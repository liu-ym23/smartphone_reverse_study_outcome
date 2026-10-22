package androidx.core.content;

import ai.j0;
import android.annotation.SuppressLint;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.content.res.XmlResourceParser;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import androidx.annotation.CallSuper;
import androidx.annotation.DoNotInline;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.XmlRes;
import androidx.core.util.ObjectsCompat;
import java.io.File;
import java.io.FileNotFoundException;
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

    @GuardedBy("mLock")
    private String mAuthority;

    @Nullable
    @GuardedBy("mLock")
    private PathStrategy mLocalPathStrategy;

    @NonNull
    private final Object mLock;
    private final int mResourceId;

    @RequiresApi(21)
    public static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        public static File[] getExternalMediaDirs(Context r5) {
            return r5.getExternalMediaDirs();
        }
    }

    public interface PathStrategy {
        File getFileForUri(Uri r5);

        Uri getUriForFile(File r5);
    }

    public static class SimplePathStrategy implements PathStrategy {
        private final String mAuthority;
        private final HashMap<String, File> mRoots;

        public SimplePathStrategy(String r5) {
            this.mRoots = new HashMap();
            this.mAuthority = r5;
        }

        private boolean belongsToRoot(@NonNull String r5, @NonNull String r10) {
            String r11 = FileProvider.access$000(r5);
            String r12 = FileProvider.access$000(r10);
            if (r11.equals(r12) == false) goto L5;
        L8:
            return true;
        L5:
            if (r11.startsWith(r12 + '/') == true) goto L8;
            return false;
        }

        public void addRoot(String r5, File r10) {
            if (TextUtils.isEmpty(r5) == true) goto L11;
            this.mRoots.put(r5, r10.getCanonicalFile());
            return;
        L7:
            e = move-exception;
            throw new IllegalArgumentException("Failed to resolve canonical path for " + r10, e);
        L11:
            throw new IllegalArgumentException("Name must not be empty");
        }

        @Override // androidx.core.content.FileProvider.PathStrategy
        public File getFileForUri(Uri r5) {
            String r10 = r5.getEncodedPath();
            int r11 = r10.indexOf(47, 1);
            String r12 = Uri.decode(r10.substring(1, r11));
            String r13 = Uri.decode(r10.substring(r11 + 1));
            File r14 = this.mRoots.get(r12);
            if (r14 == null) goto L14;
            File r15 = new File(r14, r13);
            File r16 = r15.getCanonicalFile();     // Catch: IOException -> L11
            if (belongsToRoot(r16.getPath(), r14.getPath()) == false) goto L10;
            return r16;
        L10:
            throw new SecurityException("Resolved path jumped beyond configured root");
        L12:
            throw new IllegalArgumentException("Failed to resolve canonical path for " + r15);
        L14:
            throw new IllegalArgumentException(j0.i(r5, "Unable to find configured root for "));
        }

        @Override // androidx.core.content.FileProvider.PathStrategy
        public Uri getUriForFile(File r10) {
            String r11 = r10.getCanonicalPath();     // Catch: IOException -> L21
            Iterator<Map.Entry<String, File>> r5 = this.mRoots.entrySet().iterator();
            Map.Entry<String, File> r12 = null;
        L5:
            if (r5.hasNext() == false) goto L12;
            Map.Entry<String, File> r13 = r5.next();
            String r14 = r13.getValue().getPath();
            if (belongsToRoot(r11, r14) == false) goto L5;
            if (r12 == null) goto L11;
            if (r14.length() <= r12.getValue().getPath().length()) goto L5;
        L11:
            r12 = r13;
            goto L5
        L12:
            if (r12 == null) goto L20;
            String r15 = r12.getValue().getPath();
            if (r15.endsWith("/") == false) goto L16;
            String r16 = r11.substring(r15.length());
        L18:
            return new Uri.Builder().scheme("content").authority(this.mAuthority).encodedPath(Uri.encode(r12.getKey()) + '/' + Uri.encode(r16, "/")).build();
        L16:
            r16 = r11.substring(r15.length() + 1);
            goto L18
        L20:
            throw new IllegalArgumentException(j0.C("Failed to find configured root that contains ", r11));
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
        this(0);
    }

    public static /* synthetic */ String access$000(String r5) {
        return removeTrailingSlash(r5);
    }

    private static File buildPath(File r5, String... r10) {
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L8;
        String r13 = r10[r12];
        if (r13 == null) goto L7;
        r5 = new File(r5, r13);
    L7:
        r12 = r12 + 1;
        goto L3
    L8:
        return r5;
    }

    private static String[] copyOf(String[] r5, int r10) {
        String[] r11 = new String[r10];
        System.arraycopy(r5, 0, r11, 0, r10);
        return r11;
    }

    @VisibleForTesting
    public static XmlResourceParser getFileProviderPathsMetaData(Context r5, String r10, @Nullable ProviderInfo r11, int r12) {
        if (r11 == null) goto L13;
        if (r11.metaData != null) goto L7;
        if (r12 == 0) goto L7;
        Bundle r13 = new Bundle(1);
        r11.metaData = r13;
        r13.putInt(META_DATA_FILE_PROVIDER_PATHS, r12);
    L7:
        XmlResourceParser r14 = r11.loadXmlMetaData(r5.getPackageManager(), META_DATA_FILE_PROVIDER_PATHS);
        if (r14 == null) goto L11;
        return r14;
    L11:
        throw new IllegalArgumentException("Missing android.support.FILE_PROVIDER_PATHS meta-data");
    L13:
        throw new IllegalArgumentException(j0.C("Couldn't find meta-data for provider with authority ", r10));
    }

    @NonNull
    private PathStrategy getLocalPathStrategy() {
        Object r5 = this.mLock;
        monitor-enter(r5);
        ObjectsCompat.requireNonNull(this.mAuthority, "mAuthority is null. Did you override attachInfo and did not call super.attachInfo()?");     // Catch: Throwable -> L7
        if (this.mLocalPathStrategy != null) goto L9;
        this.mLocalPathStrategy = getPathStrategy(getContext(), this.mAuthority, this.mResourceId);     // Catch: Throwable -> L7
    L9:
        PathStrategy r10 = this.mLocalPathStrategy;     // Catch: Throwable -> L7
        monitor-exit(r5);     // Catch: Throwable -> L7
        return r10;
    L7:
        th = move-exception;
        throw th;
    }

    private static PathStrategy getPathStrategy(Context r5, String r10, int r11) {
        HashMap<String, PathStrategy> r12 = sCache;
        monitor-enter(r12);
        PathStrategy r13 = r12.get(r10);     // Catch: Throwable -> L8
        if (r13 == null) goto L21;
    L16:
        monitor-exit(r12);     // Catch: Throwable -> L8
        return r13;
    L21:
        r13 = parsePathStrategy(r5, r10, r11);     // Catch: Throwable -> L8 XmlPullParserException -> L10 IOException -> L13
        r12.put(r10, r13);     // Catch: Throwable -> L8
        goto L16
    L13:
        e = move-exception;
        throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", e);     // Catch: Throwable -> L8
    L10:
        e = move-exception;
        throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", e);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    }

    public static Uri getUriForFile(@NonNull Context r5, @NonNull String r10, @NonNull File r11) {
        return getPathStrategy(r5, r10, 0).getUriForFile(r11);
    }

    private static int modeToMode(String r5) {
        if ("r".equals(r5) == false) goto L6;
        return 268435456;
    L6:
        if ("w".equals(r5) == false) goto L8;
    L21:
        return 738197504;
    L8:
        if ("wt".equals(r5) == true) goto L21;
        if ("wa".equals(r5) == false) goto L14;
        return 704643072;
    L14:
        if ("rw".equals(r5) == false) goto L17;
        return 939524096;
    L17:
        if ("rwt".equals(r5) == false) goto L20;
        return 1006632960;
    L20:
        throw new IllegalArgumentException(j0.C("Invalid mode: ", r5));
    }

    private static PathStrategy parsePathStrategy(Context r10, String r11, int r12) throws IOException, XmlPullParserException {
        SimplePathStrategy r5 = new SimplePathStrategy(r11);
        XmlResourceParser r13 = getFileProviderPathsMetaData(r10, r11, r10.getPackageManager().resolveContentProvider(r11, 128), r12);
    L3:
        int r14 = r13.next();
        if (r14 == 1) goto L36;
        if (r14 != 2) goto L3;
        String r15 = r13.getName();
        File r16 = null;
        String r17 = r13.getAttributeValue(null, ATTR_NAME);
        String r18 = r13.getAttributeValue(null, "path");
        if (TAG_ROOT_PATH.equals(r15) == false) goto L11;
        r16 = DEVICE_ROOT;
    L34:
        if (r16 == null) goto L3;
        r5.addRoot(r17, buildPath(r16, new String[]{r18}));
        goto L3
    L11:
        if (TAG_FILES_PATH.equals(r15) == false) goto L14;
        r16 = r10.getFilesDir();
        goto L34
    L14:
        if (TAG_CACHE_PATH.equals(r15) == false) goto L17;
        r16 = r10.getCacheDir();
        goto L34
    L17:
        if (TAG_EXTERNAL.equals(r15) == false) goto L20;
        r16 = Environment.getExternalStorageDirectory();
        goto L34
    L20:
        if (TAG_EXTERNAL_FILES.equals(r15) == false) goto L25;
        File[] r19 = ContextCompat.getExternalFilesDirs(r10, null);
        if (r19.length <= 0) goto L34;
        r16 = r19[0];
        goto L34
    L25:
        if (TAG_EXTERNAL_CACHE.equals(r15) == false) goto L30;
        File[] r20 = ContextCompat.getExternalCacheDirs(r10);
        if (r20.length <= 0) goto L34;
        r16 = r20[0];
        goto L34
    L30:
        if (TAG_EXTERNAL_MEDIA.equals(r15) == false) goto L34;
        File[] r21 = Api21Impl.getExternalMediaDirs(r10);
        if (r21.length <= 0) goto L34;
        r16 = r21[0];
        goto L34
    L36:
        return r5;
    }

    @NonNull
    private static String removeTrailingSlash(@NonNull String r5) {
        if (r5.length() > 0) goto L5;
        return r5;
    L5:
        if (r5.charAt(r5.length() - 1) == '/') goto L7;
        return r5;
    L7:
        return androidx.constraintlayout.motion.widget.a.n(r5, 1, 0);
    }

    @Override // android.content.ContentProvider
    @CallSuper
    public void attachInfo(@NonNull Context r5, @NonNull ProviderInfo r10) {
        super.attachInfo(r5, r10);
        if (r10.exported == true) goto L24;
        if (r10.grantUriPermissions == false) goto L22;
        String r11 = r10.authority.split(";")[0];
        Object r12 = this.mLock;
        monitor-enter(r12);
        this.mAuthority = r11;     // Catch: Throwable -> L18
        monitor-exit(r12);     // Catch: Throwable -> L18
        HashMap<String, PathStrategy> r13 = sCache;
        monitor-enter(r13);
        r13.remove(r11);     // Catch: Throwable -> L15
        monitor-exit(r13);     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        throw th;
    L18:
        th = move-exception;
        throw th;
    L22:
        throw new SecurityException("Provider must grant uri permissions");
    L24:
        throw new SecurityException("Provider must not be exported");
    }

    @Override // android.content.ContentProvider
    public int delete(@NonNull Uri r5, @Nullable String r10, @Nullable String[] r11) {
        return getLocalPathStrategy().getFileForUri(r5).delete() ? 1 : 0;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public String getType(@NonNull Uri r5) {
        File r10 = getLocalPathStrategy().getFileForUri(r5);
        int r11 = r10.getName().lastIndexOf(46);
        if (r11 < 0) goto L7;
        String r12 = r10.getName().substring(r11 + 1);
        String r13 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(r12);
        if (r13 == null) goto L9;
        return r13;
    L9:
        return "application/octet-stream";
    L7:
        return "application/octet-stream";
    }

    @Override // android.content.ContentProvider
    @Nullable
    public String getTypeAnonymous(@NonNull Uri r5) {
        return "application/octet-stream";
    }

    @Override // android.content.ContentProvider
    public Uri insert(@NonNull Uri r5, @NonNull ContentValues r10) {
        throw new UnsupportedOperationException("No external inserts");
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    @SuppressLint({"UnknownNullness"})
    public ParcelFileDescriptor openFile(@NonNull Uri r5, @NonNull String r10) throws FileNotFoundException {
        return ParcelFileDescriptor.open(getLocalPathStrategy().getFileForUri(r5), modeToMode(r10));
    }

    @Override // android.content.ContentProvider
    @NonNull
    public Cursor query(@NonNull Uri r10, @Nullable String[] r11, @Nullable String r12, @Nullable String[] r13, @Nullable String r14) {
        File r5 = getLocalPathStrategy().getFileForUri(r10);
        String r15 = r10.getQueryParameter(DISPLAYNAME_FIELD);
        if (r11 != null) goto L5;
        r11 = COLUMNS;
    L5:
        String[] r16 = new String[r11.length];
        Object[] r17 = new Object[r11.length];
        int r18 = r11.length;
        int r19 = 0;
        int r20 = 0;
    L6:
        if (r19 >= r18) goto L19;
        String r21 = r11[r19];
        if ("_display_name".equals(r21) == false) goto L16;
        r16[r20] = "_display_name";
        int r22 = r20 + 1;
        if (r15 != null) goto L12;
        String r23 = r5.getName();
    L13:
        r17[r20] = r23;
    L14:
        r20 = r22;
    L18:
        r19 = r19 + 1;
        goto L6
    L12:
        r23 = r15;
        goto L13
    L16:
        if ("_size".equals(r21) == false) goto L18;
        r16[r20] = "_size";
        r22 = r20 + 1;
        r17[r20] = Long.valueOf(r5.length());
        goto L14
    L19:
        String[] r24 = copyOf(r16, r20);
        Object[] r25 = copyOf(r17, r20);
        MatrixCursor r26 = new MatrixCursor(r24, 1);
        r26.addRow(r25);
        return r26;
    }

    @Override // android.content.ContentProvider
    public int update(@NonNull Uri r5, @NonNull ContentValues r10, @Nullable String r11, @Nullable String[] r12) {
        throw new UnsupportedOperationException("No external updates");
    }

    public FileProvider(@XmlRes int r5) {
        this.mLock = new Object();
        this.mResourceId = r5;
    }

    private static Object[] copyOf(Object[] r5, int r10) {
        Object[] r11 = new Object[r10];
        System.arraycopy(r5, 0, r11, 0, r10);
        return r11;
    }

    @NonNull
    @SuppressLint({"StreamFiles"})
    public static Uri getUriForFile(@NonNull Context r5, @NonNull String r10, @NonNull File r11, @NonNull String r12) {
        return getUriForFile(r5, r10, r11).buildUpon().appendQueryParameter(DISPLAYNAME_FIELD, r12).build();
    }
}
