package androidx.core.content;

import android.annotation.SuppressLint;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.content.res.XmlResourceParser;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import androidx.annotation.DoNotInline;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.XmlRes;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class FileProvider extends ContentProvider {
    private static final String ATTR_NAME = "name";
    private static final String ATTR_PATH = "path";
    private static final String[] COLUMNS = null;
    private static final File DEVICE_ROOT = null;
    private static final String DISPLAYNAME_FIELD = "displayName";
    private static final String META_DATA_FILE_PROVIDER_PATHS = "android.support.FILE_PROVIDER_PATHS";
    private static final String TAG_CACHE_PATH = "cache-path";
    private static final String TAG_EXTERNAL = "external-path";
    private static final String TAG_EXTERNAL_CACHE = "external-cache-path";
    private static final String TAG_EXTERNAL_FILES = "external-files-path";
    private static final String TAG_EXTERNAL_MEDIA = "external-media-path";
    private static final String TAG_FILES_PATH = "files-path";
    private static final String TAG_ROOT_PATH = "root-path";

    @GuardedBy("sCache")
    private static final HashMap<String, PathStrategy> sCache = null;
    private int mResourceId;
    private PathStrategy mStrategy;

    @RequiresApi(21)
    static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        static File[] getExternalMediaDirs(Context r10) {
            return r10.getExternalMediaDirs();
        }
    }

    interface PathStrategy {
        File getFileForUri(Uri r10);

        Uri getUriForFile(File r10);
    }

    static class SimplePathStrategy implements PathStrategy {
        private final String mAuthority;
        private final HashMap<String, File> mRoots;

        SimplePathStrategy(String r10) {
            this.mRoots = new HashMap();
            this.mAuthority = r10;
        }

        void addRoot(String r10, File r11) {
            if (TextUtils.isEmpty(r10) == true) goto L11;
            this.mRoots.put(r10, r11.getCanonicalFile());
            return;
        L7:
            e = move-exception;
            throw new IllegalArgumentException("Failed to resolve canonical path for " + r11, e);
        L11:
            throw new IllegalArgumentException("Name must not be empty");
        }

        @Override // androidx.core.content.FileProvider.PathStrategy
        public File getFileForUri(Uri r10) {
            String r11 = r10.getEncodedPath();
            int r12 = r11.indexOf(47, 1);
            String r13 = Uri.decode(r11.substring(1, r12));
            String r14 = Uri.decode(r11.substring(r12 + 1));
            File r15 = this.mRoots.get(r13);
            if (r15 == null) goto L14;
            File r16 = new File(r15, r14);
            File r17 = r16.getCanonicalFile();     // Catch: IOException -> L11
            if (r17.getPath().startsWith(r15.getPath()) == false) goto L10;
            return r17;
        L10:
            throw new SecurityException("Resolved path jumped beyond configured root");
        L12:
            throw new IllegalArgumentException("Failed to resolve canonical path for " + r16);
        L14:
            throw new IllegalArgumentException("Unable to find configured root for " + r10);
        }

        @Override // androidx.core.content.FileProvider.PathStrategy
        public Uri getUriForFile(File r10) {
            String r11 = r10.getCanonicalPath();     // Catch: IOException -> L21
            Map.Entry<String, File> r12 = null;
            Iterator<Map.Entry<String, File>> r13 = this.mRoots.entrySet().iterator();
        L5:
            if (r13.hasNext() == false) goto L12;
            Map.Entry<String, File> r14 = r13.next();
            String r15 = r14.getValue().getPath();
            if (r11.startsWith(r15) == false) goto L5;
            if (r12 == null) goto L11;
            if (r15.length() <= r12.getValue().getPath().length()) goto L5;
        L11:
            r12 = r14;
            goto L5
        L12:
            if (r12 == null) goto L20;
            String r16 = r12.getValue().getPath();
            boolean r17 = r16.endsWith("/");
            int r18 = r16.length();
            if (r17 == true) goto L18;
            r18 = r18 + 1;
        L18:
            return new Uri.Builder().scheme("content").authority(this.mAuthority).encodedPath(Uri.encode(r12.getKey()) + '/' + Uri.encode(r11.substring(r18), "/")).build();
        L20:
            throw new IllegalArgumentException("Failed to find configured root that contains " + r11);
        L22:
            throw new IllegalArgumentException("Failed to resolve canonical path for " + r10);
        }
    }

    static {
        COLUMNS = new String[]{"_display_name", "_size"};
        DEVICE_ROOT = new File("/");
        sCache = new HashMap();
    }

    public FileProvider() {
        this.mResourceId = 0;
    }

    protected FileProvider(@XmlRes int r10) {
        this.mResourceId = r10;
    }

    private static File buildPath(File r10, String... r11) {
        int r12 = r11.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L8;
        String r14 = r11[r13];
        if (r14 == null) goto L7;
        r10 = new File(r10, r14);
    L7:
        r13 = r13 + 1;
        goto L3
    L8:
        return r10;
    }

    private static Object[] copyOf(Object[] r10, int r11) {
        Object[] r12 = new Object[r11];
        System.arraycopy(r10, 0, r12, 0, r11);
        return r12;
    }

    private static String[] copyOf(String[] r10, int r11) {
        String[] r12 = new String[r11];
        System.arraycopy(r10, 0, r12, 0, r11);
        return r12;
    }

    @VisibleForTesting
    static XmlResourceParser getFileProviderPathsMetaData(Context r10, String r11, @Nullable ProviderInfo r12, int r13) {
        if (r12 == null) goto L13;
        if (r12.metaData != null) goto L7;
        if (r13 == 0) goto L7;
        Bundle r14 = new Bundle(1);
        r12.metaData = r14;
        r14.putInt(META_DATA_FILE_PROVIDER_PATHS, r13);
    L7:
        XmlResourceParser r15 = r12.loadXmlMetaData(r10.getPackageManager(), META_DATA_FILE_PROVIDER_PATHS);
        if (r15 == null) goto L11;
        return r15;
    L11:
        throw new IllegalArgumentException("Missing android.support.FILE_PROVIDER_PATHS meta-data");
    L13:
        throw new IllegalArgumentException("Couldn't find meta-data for provider with authority " + r11);
    }

    private static PathStrategy getPathStrategy(Context r10, String r11, int r12) {
        HashMap<String, PathStrategy> r13 = sCache;
        monitor-enter(r13);
        PathStrategy r14 = r13.get(r11);     // Catch: Throwable -> L16
        if (r14 == null) goto L20;
    L14:
        monitor-exit(r13);     // Catch: Throwable -> L16
        return r14;
    L20:
        r14 = parsePathStrategy(r10, r11, r12);     // Catch: XmlPullParserException -> L8 IOException -> L11 Throwable -> L16
        r13.put(r11, r14);     // Catch: Throwable -> L16
        goto L14
    L8:
        e = move-exception;
        throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", e);     // Catch: Throwable -> L16
    L11:
        e = move-exception;
        throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", e);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;
    }

    public static Uri getUriForFile(@NonNull Context r10, @NonNull String r11, @NonNull File r12) {
        return getPathStrategy(r10, r11, 0).getUriForFile(r12);
    }

    @NonNull
    @SuppressLint({"StreamFiles"})
    public static Uri getUriForFile(@NonNull Context r10, @NonNull String r11, @NonNull File r12, @NonNull String r13) {
        return getUriForFile(r10, r11, r12).buildUpon().appendQueryParameter(DISPLAYNAME_FIELD, r13).build();
    }

    private static int modeToMode(String r10) {
        if ("r".equals(r10) == false) goto L6;
        return 268435456;
    L6:
        if ("w".equals(r10) == false) goto L8;
    L21:
        return 738197504;
    L8:
        if ("wt".equals(r10) == true) goto L21;
        if ("wa".equals(r10) == false) goto L14;
        return 704643072;
    L14:
        if ("rw".equals(r10) == false) goto L17;
        return 939524096;
    L17:
        if ("rwt".equals(r10) == false) goto L20;
        return 1006632960;
    L20:
        throw new IllegalArgumentException("Invalid mode: " + r10);
    }

    private static PathStrategy parsePathStrategy(Context r10, String r11, int r12) {
        SimplePathStrategy r13 = new SimplePathStrategy(r11);
        XmlResourceParser r14 = getFileProviderPathsMetaData(r10, r11, r10.getPackageManager().resolveContentProvider(r11, 128), r12);
    L3:
        int r15 = r14.next();
        if (r15 == 1) goto L38;
        if (r15 != 2) goto L3;
        String r16 = r14.getName();
        File r17 = null;
        String r18 = r14.getAttributeValue(null, "name");
        String r19 = r14.getAttributeValue(null, ATTR_PATH);
        if (TAG_ROOT_PATH.equals(r16) == false) goto L11;
        r17 = DEVICE_ROOT;
    L36:
        if (r17 == null) goto L3;
        r13.addRoot(r18, buildPath(r17, new String[]{r19}));
        goto L3
    L11:
        if (TAG_FILES_PATH.equals(r16) == false) goto L14;
        r17 = r10.getFilesDir();
        goto L36
    L14:
        if (TAG_CACHE_PATH.equals(r16) == false) goto L17;
        r17 = r10.getCacheDir();
        goto L36
    L17:
        if (TAG_EXTERNAL.equals(r16) == false) goto L20;
        r17 = Environment.getExternalStorageDirectory();
        goto L36
    L20:
        if (TAG_EXTERNAL_FILES.equals(r16) == false) goto L25;
        File[] r110 = ContextCompat.getExternalFilesDirs(r10, null);
        if (r110.length <= 0) goto L36;
        r17 = r110[0];
        goto L36
    L25:
        if (TAG_EXTERNAL_CACHE.equals(r16) == false) goto L30;
        File[] r111 = ContextCompat.getExternalCacheDirs(r10);
        if (r111.length <= 0) goto L36;
        r17 = r111[0];
        goto L36
    L30:
        if (Build.VERSION.SDK_INT < 21) goto L36;
        if (TAG_EXTERNAL_MEDIA.equals(r16) == false) goto L36;
        File[] r112 = Api21Impl.getExternalMediaDirs(r10);
        if (r112.length <= 0) goto L36;
        r17 = r112[0];
        goto L36
    L38:
        return r13;
    }

    @Override // android.content.ContentProvider
    public void attachInfo(@NonNull Context r10, @NonNull ProviderInfo r11) {
        super.attachInfo(r10, r11);
        if (r11.exported == true) goto L18;
        if (r11.grantUriPermissions == false) goto L16;
        String r12 = r11.authority.split(";")[0];
        HashMap<String, PathStrategy> r13 = sCache;
        monitor-enter(r13);
        r13.remove(r12);     // Catch: Throwable -> L12
        monitor-exit(r13);     // Catch: Throwable -> L12
        this.mStrategy = getPathStrategy(r10, r12, this.mResourceId);
        return;
    L12:
        th = move-exception;
        throw th;
    L16:
        throw new SecurityException("Provider must grant uri permissions");
    L18:
        throw new SecurityException("Provider must not be exported");
    }

    @Override // android.content.ContentProvider
    public int delete(@NonNull Uri r10, @Nullable String r11, @Nullable String[] r12) {
        return this.mStrategy.getFileForUri(r10).delete() ? 1 : 0;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public String getType(@NonNull Uri r10) {
        File r11 = this.mStrategy.getFileForUri(r10);
        int r12 = r11.getName().lastIndexOf(46);
        if (r12 < 0) goto L7;
        String r13 = r11.getName().substring(r12 + 1);
        String r14 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(r13);
        if (r14 == null) goto L9;
        return r14;
    L9:
        return "application/octet-stream";
    L7:
        return "application/octet-stream";
    }

    @Override // android.content.ContentProvider
    public Uri insert(@NonNull Uri r10, @NonNull ContentValues r11) {
        throw new UnsupportedOperationException("No external inserts");
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    @SuppressLint({"UnknownNullness"})
    public ParcelFileDescriptor openFile(@NonNull Uri r10, @NonNull String r11) {
        return ParcelFileDescriptor.open(this.mStrategy.getFileForUri(r10), modeToMode(r11));
    }

    @Override // android.content.ContentProvider
    @NonNull
    public Cursor query(@NonNull Uri r10, @Nullable String[] r11, @Nullable String r12, @Nullable String[] r13, @Nullable String r14) {
        File r15 = this.mStrategy.getFileForUri(r10);
        String r16 = r10.getQueryParameter(DISPLAYNAME_FIELD);
        if (r11 != null) goto L5;
        r11 = COLUMNS;
    L5:
        String[] r17 = new String[r11.length];
        Object[] r18 = new Object[r11.length];
        int r19 = r11.length;
        int r20 = 0;
        int r21 = 0;
    L6:
        if (r20 >= r19) goto L19;
        String r22 = r11[r20];
        if ("_display_name".equals(r22) == false) goto L15;
        r17[r21] = "_display_name";
        int r23 = r21 + 1;
        if (r16 != null) goto L12;
        String r24 = r15.getName();
    L13:
        r18[r21] = r24;
    L17:
        r21 = r23;
    L18:
        r20 = r20 + 1;
        goto L6
    L12:
        r24 = r16;
        goto L13
    L15:
        if ("_size".equals(r22) == false) goto L18;
        r17[r21] = "_size";
        r23 = r21 + 1;
        r18[r21] = Long.valueOf(r15.length());
        goto L17
    L19:
        String[] r25 = copyOf(r17, r21);
        Object[] r26 = copyOf(r18, r21);
        MatrixCursor r27 = new MatrixCursor(r25, 1);
        r27.addRow(r26);
        return r27;
    }

    @Override // android.content.ContentProvider
    public int update(@NonNull Uri r10, @NonNull ContentValues r11, @Nullable String r12, @Nullable String[] r13) {
        throw new UnsupportedOperationException("No external updates");
    }
}
