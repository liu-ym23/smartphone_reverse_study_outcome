package androidx.core.content;

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
import com.obric.aikernel.sdk.ext.Params;
import com.volcengine.zeus.provider.PluginContentProvider;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import net.zetetic.database.sqlcipher.SQLiteDatabase;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class FileProvider extends PluginContentProvider {
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
    private static final HashMap<String, PathStrategy> sCache = null;
    private String mAuthority;
    private PathStrategy mLocalPathStrategy;
    private int mResourceId;

    static class Api21Impl {
        private Api21Impl() {
        }

        static File[] getExternalMediaDirs(Context r2) {
            return ((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).getExternalMediaDirs();
        }
    }

    interface PathStrategy {
        File getFileForUri(Uri r1);

        Uri getUriForFile(File r1);
    }

    static class SimplePathStrategy implements PathStrategy {
        private final String mAuthority;
        private final HashMap<String, File> mRoots;

        SimplePathStrategy(String r2) {
            this.mRoots = new HashMap();
            this.mAuthority = r2;
        }

        void addRoot(String r3, File r4) {
            if (TextUtils.isEmpty(r3) == true) goto L11;
            this.mRoots.put(r3, r4.getCanonicalFile());
            return;
        L7:
            e = move-exception;
            throw new IllegalArgumentException("Failed to resolve canonical path for " + r4, e);
        L11:
            throw new IllegalArgumentException("Name must not be empty");
        }

        @Override // androidx.core.content.FileProvider.PathStrategy
        public File getFileForUri(Uri r5) {
            String r0 = r5.getEncodedPath();
            int r1 = r0.indexOf(47, 1);
            String r3 = Uri.decode(r0.substring(1, r1));
            String r2 = Uri.decode(r0.substring(r1 + 1));
            File r4 = (File) ZeusTransformUtils.preCheckCast(this.mRoots.get(r3), File.class, "com.obric.memorydata.plugin");
            if (r4 == null) goto L14;
            File r6 = new File(r4, r2);
            File r7 = r6.getCanonicalFile();     // Catch: IOException -> L11
            if (r7.getPath().startsWith(r4.getPath()) == false) goto L10;
            return r7;
        L10:
            throw new SecurityException("Resolved path jumped beyond configured root");
        L12:
            throw new IllegalArgumentException("Failed to resolve canonical path for " + r6);
        L14:
            throw new IllegalArgumentException("Unable to find configured root for " + r5);
        }

        @Override // androidx.core.content.FileProvider.PathStrategy
        public Uri getUriForFile(File r8) {
            String r9 = r8.getCanonicalPath();     // Catch: IOException -> L21
            Map.Entry r0 = null;
            Iterator<Map.Entry<String, File>> r1 = this.mRoots.entrySet().iterator();
        L5:
            if (r1.hasNext() == false) goto L12;
            Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r1.next(), Map.Entry.class, "com.obric.memorydata.plugin");
            String r4 = ((File) ZeusTransformUtils.preCheckCast(r2.getValue(), File.class, "com.obric.memorydata.plugin")).getPath();
            if (r9.startsWith(r4) == false) goto L5;
            if (r0 == null) goto L11;
            if (r4.length() <= ((File) ZeusTransformUtils.preCheckCast(r0.getValue(), File.class, "com.obric.memorydata.plugin")).getPath().length()) goto L5;
        L11:
            r0 = r2;
            goto L5
        L12:
            if (r0 == null) goto L20;
            String r3 = ((File) ZeusTransformUtils.preCheckCast(r0.getValue(), File.class, "com.obric.memorydata.plugin")).getPath();
            boolean r5 = r3.endsWith("/");
            int r6 = r3.length();
            if (r5 == true) goto L18;
            r6 = r6 + 1;
        L18:
            return new Uri.Builder().scheme(Params.CONTENT).authority(this.mAuthority).encodedPath(Uri.encode((String) ZeusTransformUtils.preCheckCast(r0.getKey(), String.class, "com.obric.memorydata.plugin")) + '/' + Uri.encode(r9.substring(r6), "/")).build();
        L20:
            throw new IllegalArgumentException("Failed to find configured root that contains " + r9);
        L22:
            throw new IllegalArgumentException("Failed to resolve canonical path for " + r8);
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

    public FileProvider(int r1) {
        this.mResourceId = r1;
    }

    private static File buildPath(File r4, String... r5) {
        int r0 = r5.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        String r2 = r5[r1];
        if (r2 == null) goto L7;
        r4 = new File(r4, r2);
    L7:
        r1 = r1 + 1;
        goto L3
    L8:
        return r4;
    }

    private static Object[] copyOf(Object[] r2, int r3) {
        Object[] r0 = new Object[r3];
        System.arraycopy(r2, 0, r0, 0, r3);
        return r0;
    }

    private static String[] copyOf(String[] r2, int r3) {
        String[] r0 = new String[r3];
        System.arraycopy(r2, 0, r0, 0, r3);
        return r0;
    }

    static XmlResourceParser getFileProviderPathsMetaData(Context r2, String r3, ProviderInfo r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L14;
        if (r4.metaData != null) goto L8;
        if (r5 == 0) goto L8;
        r4.metaData = new Bundle(1);
        r4.metaData.putInt(META_DATA_FILE_PROVIDER_PATHS, r5);
    L8:
        XmlResourceParser r7 = r4.loadXmlMetaData(r6.getPackageManager(), META_DATA_FILE_PROVIDER_PATHS);
        if (r7 == null) goto L12;
        return r7;
    L12:
        throw new IllegalArgumentException("Missing android.support.FILE_PROVIDER_PATHS meta-data");
    L14:
        throw new IllegalArgumentException("Couldn't find meta-data for provider with authority " + r3);
    }

    private PathStrategy getLocalPathStrategy() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.mLocalPathStrategy != null) goto L6;
        this.mLocalPathStrategy = getPathStrategy((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), this.mAuthority, this.mResourceId);     // Catch: Throwable -> L9
    L6:
        PathStrategy r0 = this.mLocalPathStrategy;     // Catch: Throwable -> L9
        monitor-exit(this);     // Catch: Throwable -> L9
        return r0;
    }

    private static PathStrategy getPathStrategy(Context r4, String r5, int r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        HashMap<String, PathStrategy> r0 = sCache;
        monitor-enter(r0);
        PathStrategy r1 = (PathStrategy) ZeusTransformUtils.preCheckCast(r0.get(r5), PathStrategy.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
        if (r1 == null) goto L20;
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L16
        return r1;
    L20:
        r1 = parsePathStrategy(r7, r5, r6);     // Catch: XmlPullParserException -> L8 IOException -> L11 Throwable -> L16
        r0.put(r5, r1);     // Catch: Throwable -> L16
        goto L14
    L11:
        e = move-exception;
        throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", e);     // Catch: Throwable -> L16
    L8:
        e = move-exception;
        throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", e);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;
    }

    public static Uri getUriForFile(Context r2, String r3, File r4) {
        return getPathStrategy((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), r3, 0).getUriForFile(r4);
    }

    public static Uri getUriForFile(Context r2, String r3, File r4, String r5) {
        return ZeusTransformUtils.getUriForFile((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), r3, r4, "com.obric.memorydata.plugin").buildUpon().appendQueryParameter(DISPLAYNAME_FIELD, r5).build();
    }

    private static int modeToMode(String r3) {
        if ("r".equals(r3) == false) goto L6;
        return SQLiteDatabase.CREATE_IF_NECESSARY;
    L6:
        if ("w".equals(r3) == false) goto L8;
    L21:
        return 738197504;
    L8:
        if ("wt".equals(r3) == true) goto L21;
        if ("wa".equals(r3) == false) goto L14;
        return 704643072;
    L14:
        if ("rw".equals(r3) == false) goto L17;
        return 939524096;
    L17:
        if ("rwt".equals(r3) == false) goto L20;
        return 1006632960;
    L20:
        throw new IllegalArgumentException("Invalid mode: " + r3);
    }

    private static PathStrategy parsePathStrategy(Context r8, String r9, int r10) {
        Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
        SimplePathStrategy r0 = new SimplePathStrategy(r9);
        XmlResourceParser r12 = getFileProviderPathsMetaData(r11, r9, r11.getPackageManager().resolveContentProvider(r9, 128), r10);
    L3:
        int r13 = r12.next();
        if (r13 == 1) goto L38;
        if (r13 != 2) goto L3;
        String r14 = r12.getName();
        File r2 = null;
        String r3 = r12.getAttributeValue(null, "name");
        String r4 = r12.getAttributeValue(null, ATTR_PATH);
        if (TAG_ROOT_PATH.equals(r14) == false) goto L11;
        r2 = DEVICE_ROOT;
    L36:
        if (r2 == null) goto L3;
        r0.addRoot(r3, buildPath(r2, new String[]{r4}));
        goto L3
    L11:
        if (TAG_FILES_PATH.equals(r14) == false) goto L14;
        r2 = r11.getFilesDir();
        goto L36
    L14:
        if (TAG_CACHE_PATH.equals(r14) == false) goto L17;
        r2 = r11.getCacheDir();
        goto L36
    L17:
        if (TAG_EXTERNAL.equals(r14) == false) goto L20;
        r2 = Environment.getExternalStorageDirectory();
        goto L36
    L20:
        if (TAG_EXTERNAL_FILES.equals(r14) == false) goto L25;
        File[] r15 = ContextCompat.getExternalFilesDirs(r11, null);
        if (r15.length <= 0) goto L36;
        r2 = r15[0];
        goto L36
    L25:
        if (TAG_EXTERNAL_CACHE.equals(r14) == false) goto L30;
        File[] r16 = ContextCompat.getExternalCacheDirs(r11);
        if (r16.length <= 0) goto L36;
        r2 = r16[0];
        goto L36
    L30:
        if (Build.VERSION.SDK_INT < 21) goto L36;
        if (TAG_EXTERNAL_MEDIA.equals(r14) == false) goto L36;
        File[] r17 = Api21Impl.getExternalMediaDirs(r11);
        if (r17.length <= 0) goto L36;
        r2 = r17[0];
        goto L36
    L38:
        return r0;
    }

    public void attachInfo(Context r3, ProviderInfo r4) {
        super.attachInfo((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), r4);
        if (r4.exported == true) goto L17;
        if (r4.grantUriPermissions == false) goto L15;
        this.mAuthority = r4.authority.split(";")[0];
        HashMap<String, PathStrategy> r5 = sCache;
        monitor-enter(r5);
        r5.remove(this.mAuthority);     // Catch: Throwable -> L11
        monitor-exit(r5);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    L15:
        throw new SecurityException("Provider must grant uri permissions");
    L17:
        throw new SecurityException("Provider must not be exported");
    }

    public int delete(Uri r1, String r2, String[] r3) {
        return getLocalPathStrategy().getFileForUri(r1).delete() ? 1 : 0;
    }

    public String getType(Uri r2) {
        File r1 = getLocalPathStrategy().getFileForUri(r2);
        int r3 = r1.getName().lastIndexOf(46);
        if (r3 < 0) goto L7;
        String r4 = r1.getName().substring(r3 + 1);
        String r5 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(r4);
        if (r5 == null) goto L9;
        return r5;
    L9:
        return "application/octet-stream";
    L7:
        return "application/octet-stream";
    }

    public String getTypeAnonymous(Uri r1) {
        return "application/octet-stream";
    }

    public Uri insert(Uri r1, ContentValues r2) {
        throw new UnsupportedOperationException("No external inserts");
    }

    public boolean onCreate() {
        return true;
    }

    public ParcelFileDescriptor openFile(Uri r1, String r2) {
        return ParcelFileDescriptor.open(getLocalPathStrategy().getFileForUri(r1), modeToMode(r2));
    }

    public Cursor query(Uri r6, String[] r7, String r8, String[] r9, String r10) {
        File r5 = getLocalPathStrategy().getFileForUri(r6);
        String r11 = r6.getQueryParameter(DISPLAYNAME_FIELD);
        if (r7 != null) goto L5;
        r7 = COLUMNS;
    L5:
        String[] r12 = new String[r7.length];
        Object[] r13 = new Object[r7.length];
        int r14 = r7.length;
        int r0 = 0;
        int r1 = 0;
    L6:
        if (r0 >= r14) goto L19;
        String r2 = r7[r0];
        if ("_display_name".equals(r2) == false) goto L15;
        r12[r1] = "_display_name";
        int r3 = r1 + 1;
        if (r11 != null) goto L12;
        String r4 = r5.getName();
    L13:
        r13[r1] = r4;
    L17:
        r1 = r3;
    L18:
        r0 = r0 + 1;
        goto L6
    L12:
        r4 = r11;
        goto L13
    L15:
        if ("_size".equals(r2) == false) goto L18;
        r12[r1] = "_size";
        r3 = r1 + 1;
        r13[r1] = Long.valueOf(r5.length());
        goto L17
    L19:
        String[] r15 = copyOf(r12, r1);
        Object[] r16 = copyOf(r13, r1);
        MatrixCursor r17 = new MatrixCursor(r15, 1);
        r17.addRow(r16);
        return r17;
    }

    public int update(Uri r1, ContentValues r2, String r3, String[] r4) {
        throw new UnsupportedOperationException("No external updates");
    }
}
