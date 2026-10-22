package com.suite.lark.component.storage.ext.content;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.content.res.XmlResourceParser;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import androidx.core.content.ContextCompat;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.socialbase.downloader.file.DownloadFileUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class FileProvider extends ContentProvider {
    private static final String ATTR_NAME = "name";
    private static final String ATTR_PATH = "path";
    private static final String[] COLUMNS = null;
    private static final File DEVICE_ROOT = null;
    private static final String DISPLAYNAME_FIELD = "displayName";
    private static final String META_DATA_FILE_PROVIDER_PATHS = "android.support.FILE_PROVIDER_PATHS";
    private static final String TAG = "FileProvider";
    private static final String TAG_CACHE_PATH = "cache-path";
    private static final String TAG_EXTERNAL = "external-path";
    private static final String TAG_EXTERNAL_CACHE = "external-cache-path";
    private static final String TAG_EXTERNAL_FILES = "external-files-path";
    private static final String TAG_EXTERNAL_MEDIA = "external-media-path";
    private static final String TAG_FILES_PATH = "files-path";
    private static final String TAG_ROOT_PATH = "root-path";
    private static final HashMap<String, a> sCache = null;
    private static final String specialMatchPath = "/uz_";
    private a mStrategy;

    public interface a {
        File getFileForUri(Uri r1);

        Uri getUriForFile(File r1);
    }

    public static class b implements a {
        public final String a;
        public final HashMap<String, File> b;

        public b(String r2) {
            this.b = new HashMap();
            this.a = r2;
        }

        @Override // com.suite.lark.component.storage.ext.content.FileProvider.a
        public final File getFileForUri(Uri r5) {
            String r0 = r5.getEncodedPath();
            int r1 = r0.indexOf(47, 1);
            String r3 = Uri.decode(r0.substring(1, r1));
            String r2 = Uri.decode(r0.substring(r1 + 1));
            File r4 = this.b.get(r3);
            if (r4 == null) goto L18;
            PolarisFileWrapper r6 = new PolarisFileWrapper(r4, r2);
            if (r6.exists() == false) goto L7;
        L19:
            File r7 = r6.getCanonicalFile();     // Catch: IOException -> L15
            if (r7.getPath().startsWith(r4.getPath()) == false) goto L14;
            return r7;
        L14:
            throw new SecurityException("Resolved path jumped beyond configured root");
        L16:
            throw new IllegalArgumentException("Failed to resolve canonical path for " + r6);
        L7:
            if (r4.getPath().endsWith(FileProvider.specialMatchPath) == false) goto L19;
            r6 = new PolarisFileWrapper(r4 + r2);
            goto L19
        L18:
            throw new IllegalArgumentException("Unable to find configured root for " + r5);
        }

        @Override // com.suite.lark.component.storage.ext.content.FileProvider.a
        public final Uri getUriForFile(File r6) {
            String r7 = r6.getCanonicalPath();     // Catch: IOException -> L24
            Iterator<Map.Entry<String, File>> r0 = this.b.entrySet().iterator();
            Map.Entry<String, File> r1 = null;
        L5:
            if (r0.hasNext() == false) goto L12;
            Map.Entry<String, File> r2 = r0.next();
            String r3 = r2.getValue().getPath();
            if (r7.startsWith(r3) == false) goto L5;
            if (r1 == null) goto L11;
            if (r3.length() <= r1.getValue().getPath().length()) goto L5;
        L11:
            r1 = r2;
            goto L5
        L12:
            if (r1 == null) goto L23;
            String r4 = r1.getValue().getPath();
            if (r4.endsWith("/") == false) goto L16;
        L19:
            String r8 = r7.substring(r4.length());
        L21:
            return new Uri.Builder().scheme("content").authority(this.a).encodedPath(Uri.encode(r1.getKey()) + '/' + Uri.encode(r8, "/")).build();
        L16:
            if (r7.startsWith(r4.concat("/")) == false) goto L19;
            r8 = r7.substring(r4.length() + 1);
            goto L21
        L23:
            throw new IllegalArgumentException("Failed to find configured root that contains " + r7);
        L25:
            throw new IllegalArgumentException("Failed to resolve canonical path for " + r6);
        }

        public final void a(String r4, File r5) {
            if (TextUtils.isEmpty(r4) == true) goto L11;
            this.b.put(r4, r5.getCanonicalFile());
            return;
        L7:
            e = move-exception;
            throw new IllegalArgumentException("Failed to resolve canonical path for " + r5, e);
        L11:
            throw new IllegalArgumentException("Name must not be empty");
        }
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    static {
        COLUMNS = new String[]{"_display_name", "_size"};
        DEVICE_ROOT = new PolarisFileWrapper("/");
        sCache = new HashMap();
    }

    public FileProvider() {
    }

    private static boolean isExternalPathTag(String r1) {
        if (TAG_EXTERNAL.equals(r1) == false) goto L5;
    L12:
        return true;
    L5:
        if (TAG_EXTERNAL_FILES.equals(r1) == true) goto L12;
        if (TAG_EXTERNAL_CACHE.equals(r1) == true) goto L12;
        if (TAG_EXTERNAL_MEDIA.equals(r1) == true) goto L12;
        return false;
    }

    private static int modeToMode(String r3) {
        if (DownloadFileUtils.MODE_READ.equals(r3) == false) goto L6;
        return 268435456;
    L6:
        if (DownloadFileUtils.MODE_WRITE.equals(r3) == false) goto L8;
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

    public String getDefaultAuthority(Context r2) {
        return r2.getPackageName() + ".suite.provider";
    }

    @Override // android.content.ContentProvider
    public String getType(Uri r3) {
        File r4 = this.mStrategy.getFileForUri(r3);
        int r0 = r4.getName().lastIndexOf(46);
        if (r0 < 0) goto L7;
        String r5 = r4.getName().substring(r0 + 1);
        String r6 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(r5);
        if (r6 == null) goto L9;
        return r6;
    L9:
        return "application/octet-stream";
    L7:
        return "application/octet-stream";
    }

    private static File buildPath(File r4, String... r5) {
        int r0 = r5.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        String r2 = r5[r1];
        if (r2 == null) goto L7;
        r4 = new PolarisFileWrapper(r4, r2);
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

    private static a getPathStrategy(Context r2, String r3) {
        HashMap<String, a> r0 = sCache;
        monitor-enter(r0);
        a r1 = r0.get(r3);     // Catch: Throwable -> L16
        if (r1 == null) goto L20;
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L16
        return r1;
    L20:
        r1 = parsePathStrategy(r2, r3);     // Catch: XmlPullParserException -> L8 IOException -> L11 Throwable -> L16
        r0.put(r3, r1);     // Catch: Throwable -> L16
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

    private static a parsePathStrategy(Context r9, String r10) throws IOException, XmlPullParserException {
        b r0 = new b(r10);
        ProviderInfo r1 = r9.getPackageManager().resolveContentProvider(r10, 128);
        if (r1 == null) goto L51;
        XmlResourceParser r11 = r1.loadXmlMetaData(r9.getPackageManager(), META_DATA_FILE_PROVIDER_PATHS);
        if (r11 == null) goto L49;
    L6:
        int r2 = r11.next();
        if (r2 == 1) goto L47;
        if (r2 != 2) goto L6;
        String r3 = r11.getName();
        File r4 = null;
        String r5 = r11.getAttributeValue(null, "name");
        String r6 = r11.getAttributeValue(null, "path");
        if (TAG_ROOT_PATH.equals(r3) == false) goto L14;
        r4 = DEVICE_ROOT;
    L37:
        if (r4 == null) goto L6;
        r0.a(r5, buildPath(r4, new String[]{r6}));     // Catch: IllegalArgumentException -> L40
    L40:
        e = move-exception;
        if (isExternalPathTag(r3) == false) goto L46;
        if ((e.getCause() instanceof IOException) == true) goto L6;
    L46:
        throw e;
    L14:
        if (TAG_FILES_PATH.equals(r3) == false) goto L17;
        r4 = r9.getFilesDir();
        goto L37
    L17:
        if (TAG_CACHE_PATH.equals(r3) == false) goto L20;
        r4 = r9.getCacheDir();
        goto L37
    L20:
        if (TAG_EXTERNAL.equals(r3) == false) goto L23;
        r4 = Environment.getExternalStorageDirectory();
        goto L37
    L23:
        if (TAG_EXTERNAL_FILES.equals(r3) == false) goto L28;
        File[] r7 = ContextCompat.getExternalFilesDirs(r9, null);
        if (r7.length <= 0) goto L37;
        r4 = r7[0];
        goto L37
    L28:
        if (TAG_EXTERNAL_CACHE.equals(r3) == false) goto L33;
        File[] r8 = ContextCompat.getExternalCacheDirs(r9);
        if (r8.length <= 0) goto L37;
        r4 = r8[0];
        goto L37
    L33:
        if (TAG_EXTERNAL_MEDIA.equals(r3) == false) goto L37;
        File[] r12 = r9.getExternalMediaDirs();
        if (r12.length <= 0) goto L37;
        r4 = r12[0];
        goto L37
    L47:
        return r0;
    L49:
        throw new IllegalArgumentException("Missing android.support.FILE_PROVIDER_PATHS meta-data");
    L51:
        throw new IllegalArgumentException("Couldn't find meta-data for provider with authority " + r10);
    }

    @Override // android.content.ContentProvider
    public void attachInfo(Context r2, ProviderInfo r3) {
        super.attachInfo(r2, r3);
        if (r3.exported == true) goto L14;
        if (r3.grantUriPermissions == false) goto L12;
        if (r3.authority != null) goto L9;
        r3.authority = getDefaultAuthority(r2);
    L9:
        this.mStrategy = getPathStrategy(r2, r3.authority.split(";")[0]);
        return;
    L12:
        throw new SecurityException("Provider must grant uri permissions");
    L14:
        throw new SecurityException("Provider must not be exported");
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri r1, ContentValues r2) {
        throw new UnsupportedOperationException("No external inserts");
    }

    @Override // android.content.ContentProvider
    public ParcelFileDescriptor openFile(Uri r2, String r3) throws FileNotFoundException {
        return ParcelFileDescriptor.open(this.mStrategy.getFileForUri(r2), modeToMode(r3));
    }

    private static String[] copyOf(String[] r2, int r3) {
        String[] r0 = new String[r3];
        System.arraycopy(r2, 0, r0, 0, r3);
        return r0;
    }

    public static Uri getUriForFile(Context r0, String r1, File r2) {
        return getPathStrategy(r0, r1).getUriForFile(r2);
    }

    @Override // android.content.ContentProvider
    public int delete(Uri r1, String r2, String[] r3) {
        return this.mStrategy.getFileForUri(r1).delete() ? 1 : 0;
    }

    public static Uri getUriForFile(Context r0, String r1, File r2, String r3) {
        return getUriForFile(r0, r1, r2).buildUpon().appendQueryParameter(DISPLAYNAME_FIELD, r3).build();
    }

    @Override // android.content.ContentProvider
    public int update(Uri r1, ContentValues r2, String r3, String[] r4) {
        throw new UnsupportedOperationException("No external updates");
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri r7, String[] r8, String r9, String[] r10, String r11) {
        File r12 = this.mStrategy.getFileForUri(r7);
        String r13 = UriProtector.getQueryParameter(r7, DISPLAYNAME_FIELD);
        if (r8 != null) goto L5;
        r8 = COLUMNS;
    L5:
        String[] r14 = new String[r8.length];
        Object[] r15 = new Object[r8.length];
        int r0 = r8.length;
        int r1 = 0;
        int r2 = 0;
    L6:
        if (r1 >= r0) goto L19;
        String r3 = r8[r1];
        if ("_display_name".equals(r3) == false) goto L15;
        r14[r2] = "_display_name";
        int r4 = r2 + 1;
        if (r13 != null) goto L12;
        String r5 = r12.getName();
    L13:
        r15[r2] = r5;
    L17:
        r2 = r4;
    L18:
        r1 = r1 + 1;
        goto L6
    L12:
        r5 = r13;
        goto L13
    L15:
        if ("_size".equals(r3) == false) goto L18;
        r14[r2] = "_size";
        r4 = r2 + 1;
        r15[r2] = Long.valueOf(r12.length());
        goto L17
    L19:
        String[] r16 = copyOf(r14, r2);
        Object[] r17 = copyOf(r15, r2);
        MatrixCursor r18 = new MatrixCursor(r16, 1);
        r18.addRow(r17);
        return r18;
    }
}
