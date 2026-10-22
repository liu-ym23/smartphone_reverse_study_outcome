package com.lynx.canvas.loader;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Base64;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.lynx.canvas.Krypton;
import com.lynx.canvas.KryptonLLog;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.Executor;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class KryptonResourceUtils {
    private static final String ASSET_SCHEME_PREFIX = "asset:///";
    private static final String BASE64_PREFIX = "base64,";
    private static final int BUFFER_MAX_SIZE = 65536;
    private static final int BUFFER_MIN_SIZE = 1024;
    private static final String CONTENT_SCHEMA_PREFIX = "content://";
    private static final String DATA_SCHEMA_PREFIX = "data:";
    private static final String FILE_SCHEME_PREFIX = "file://";
    private static final String HTTPS_SCHEME_PREFIX = "https://";
    private static final String HTTP_SCHEME_PREFIX = "http://";
    private static final String RESOURCE_SCHEME_PREFIX = "res:///";
    private static final String TAG = "KryptonResourceUtils";
    private static volatile Executor sBriefIOExecutor;

    public static final enum KryptonSchemaType extends Enum<KryptonSchemaType> {
        private static final /* synthetic */ KryptonSchemaType[] $VALUES = null;
        public static final KryptonSchemaType CONTENT = null;
        public static final KryptonSchemaType DATAURI = null;
        public static final KryptonSchemaType EMPTY = null;
        public static final KryptonSchemaType INVALID = null;
        public static final KryptonSchemaType LOCAL = null;
        public static final KryptonSchemaType REMOTE = null;

        static {
            KryptonSchemaType r0 = new KryptonSchemaType("EMPTY", 0);
            EMPTY = r0;
            KryptonSchemaType r1 = new KryptonSchemaType("INVALID", 1);
            INVALID = r1;
            KryptonSchemaType r3 = new KryptonSchemaType("REMOTE", 2);
            REMOTE = r3;
            KryptonSchemaType r5 = new KryptonSchemaType("LOCAL", 3);
            LOCAL = r5;
            KryptonSchemaType r7 = new KryptonSchemaType("CONTENT", 4);
            CONTENT = r7;
            KryptonSchemaType r9 = new KryptonSchemaType("DATAURI", 5);
            DATAURI = r9;
            $VALUES = new KryptonSchemaType[]{r0, r1, r3, r5, r7, r9};
        }

        public static KryptonSchemaType[] values() {
            return (KryptonSchemaType[]) $VALUES.clone();
        }

        public static KryptonSchemaType valueOf(String r1) {
            return (KryptonSchemaType) a.a(KryptonSchemaType.class, r1);
        }

        private KryptonSchemaType(String r1, int r2) {
            super(r1, r2);
        }
    }

    public KryptonResourceUtils() {
    }

    private static int clamp(int r0, int r1, int r2) {
        if (r0 >= r1) goto L4;
        return r1;
    L4:
        if (r0 <= r2) goto L6;
        return r2;
    L6:
        return r0;
    }

    public static Executor getKryptonIOExecutor() {
        if (sBriefIOExecutor != null) goto L15;
        monitor-enter(KryptonResourceUtils.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sBriefIOExecutor != null) goto L9;
        sBriefIOExecutor = getExecutor("krypton-brief-resource-thread", 5, 3);     // Catch: Throwable -> L11
    L9:
        monitor-exit(KryptonResourceUtils.class);     // Catch: Throwable -> L11
    L15:
        return sBriefIOExecutor;
    }

    private static void closeQuietly(Closeable r2) {
        if (r2 == null) goto L10;
        r2.close();     // Catch: IOException -> L5
        return;
    L5:
        e = move-exception;
        KryptonLLog.e(TAG, "Failed to close resource: " + e.getMessage());
        return;
    }

    public static Bitmap decodeBase64Image(String r3) throws IllegalArgumentException {
        if (schemaType(r3) != KryptonSchemaType.DATAURI) goto L7;
        byte[] r4 = Base64.decode(getDataUrlBase64Content(r3), 0);
        return BitmapFactory.decodeByteArray(r4, 0, r4.length);
    L7:
        throw new IllegalArgumentException("Call decodeBase64Image with invalid path" + r3);
    }

    public static byte[] decodeDataURI(String r3) throws IllegalArgumentException {
        KryptonSchemaType r0 = schemaType(r3);
        if (r0 != KryptonSchemaType.DATAURI) goto L7;
        return Base64.decode(getDataUrlBase64Content(r3), 0);
    L7:
        if (r0 != KryptonSchemaType.EMPTY) goto L11;
        throw new IllegalArgumentException("Call decodeBase64DataUrl with empty path!");
    L11:
        throw new IllegalArgumentException("Call decodeBase64DataUrl with invalid path: " + getTruncatePath(r3));
    }

    private static String getDataUrlBase64Content(String r1) {
        return r1.substring(r1.indexOf(BASE64_PREFIX) + 7);
    }

    public static int getPreferredBufferSize(int r2) {
        return clamp(r2, BUFFER_MIN_SIZE, BUFFER_MAX_SIZE);
    }

    public static String getTruncatePath(String r2) {
        int r0 = r2.length();
        if (r0 <= 500) goto L6;
        r0 = 500;
    L6:
        return r2.substring(0, r0);
    }

    public static boolean isContentURI(String r1) {
        if (schemaType(r1) != KryptonSchemaType.CONTENT) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isDataURI(String r1) {
        if (schemaType(r1) != KryptonSchemaType.DATAURI) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isHeif(byte[] r4) {
        if (r4 != null) goto L5;
        return false;
    L5:
        if (r4.length >= 12) goto L8;
        return false;
    L8:
        if (r4[4] == 102) goto L10;
        return false;
    L10:
        if (r4[5] == 116) goto L12;
        return false;
    L12:
        if (r4[6] == 121) goto L14;
        return false;
    L14:
        if (r4[7] != 112) goto L36;
        String r2 = new String(r4, 8, 4);
        if (r2.equals("heic") == false) goto L19;
    L28:
        return true;
    L19:
        if (r2.equals("heix") == true) goto L28;
        if (r2.equals("heim") == true) goto L28;
        if (r2.equals("heis") == true) goto L28;
        if (r2.equals("mif1") == true) goto L28;
        if (r2.equals("msf1") == true) goto L28;
        return false;
    L36:
        return false;
    }

    public static boolean isLocalPath(String r1) {
        if (schemaType(r1) != KryptonSchemaType.LOCAL) goto L5;
        return true;
    L5:
        return false;
    }

    public static InputStream loadResourceFromLocalPath(String r11) {
        KryptonSchemaType r7 = schemaType(r11);
        if (r7 != KryptonSchemaType.LOCAL) goto L5;
    L45:
        Context r8 = Krypton.inst().getContext();     // Catch: Exception -> L42
        if (r8 != null) goto L13;
        KryptonLLog.e(TAG, "Load stream from resource failed with null context: " + r11);     // Catch: Exception -> L42
        return null;
    L13:
        if (r11.startsWith(ASSET_SCHEME_PREFIX) == false) goto L19;
        if (r11.length() <= 9) goto L19;
        KryptonLLog.i(TAG, "Load resource from asset: ".concat(r11));     // Catch: Exception -> L42
        return r8.getAssets().open(r11.substring(9));
    L19:
        if (r11.startsWith(RESOURCE_SCHEME_PREFIX) == false) goto L25;
        if (r11.length() <= 7) goto L25;
        KryptonLLog.i(TAG, "Load resource from res: ".concat(r11));     // Catch: Exception -> L42
        return r8.getResources().openRawResource(r8.getResources().getIdentifier(r11.substring(7), "drawable", r8.getPackageCodePath()));
    L25:
        if (r11.startsWith(FILE_SCHEME_PREFIX) == false) goto L35;
        if (r11.length() <= 7) goto L35;
        KryptonLLog.i(TAG, "Load resource from file: ".concat(r11));     // Catch: Exception -> L42
        String r1 = r11.substring(7);     // Catch: Exception -> L42
        if (r1.startsWith("/") == true) goto L33;
        r1 = "/".concat(r1);     // Catch: Exception -> L42
    L33:
        return new PolarisFileInputStreamWrapper(new PolarisFileWrapper(r1));
    L35:
        if (r11.startsWith(CONTENT_SCHEMA_PREFIX) == true) goto L37;
    L40:
        KryptonLLog.e(TAG, "the url is not available local or content path: ".concat(r11));     // Catch: Exception -> L42
        return null;
    L37:
        if (r11.length() <= 10) goto L40;
        KryptonLLog.i(TAG, "Load resource from content uri: ".concat(r11));     // Catch: Exception -> L42
        return ContentResolverWrapper.openInputStream(r8.getContentResolver(), UriProtector.parse(r11));
    L42:
        e = move-exception;
        KryptonLLog.e(TAG, "Load stream from resource failed, the resource path is: " + r11 + " with error: " + e.getMessage());
        return null;
    L5:
        if (r7 == KryptonSchemaType.CONTENT) goto L45;
        KryptonLLog.e(TAG, "The url is not a local or content path: " + r11);
        return null;
    }

    public static byte[] mergeArray(byte[]... r6) {
        int r1 = 0;
        int r2 = 0;
    L4:
        if (r1 >= r6.length) goto L6;
        r2 = r2 + r6[r1].length;
        r1 = r1 + 1;
        goto L4
    L6:
        byte[] r3 = new byte[r2];
        int r4 = 0;
        int r5 = 0;
    L8:
        if (r4 >= r6.length) goto L14;
        byte[] r7 = r6[r4];
        int r8 = r7.length;
        if (r8 == 0) goto L13;
        System.arraycopy(r7, 0, r3, r5, r8);
        r5 = r5 + r8;
    L13:
        r4 = r4 + 1;
        goto L8
    L14:
        return r3;
    }

    public static KryptonSchemaType schemaType(String r1) {
        if (TextUtils.isEmpty(r1) == false) goto L7;
        return KryptonSchemaType.EMPTY;
    L7:
        if (r1.startsWith(HTTP_SCHEME_PREFIX) == true) goto L33;
        if (r1.startsWith(HTTPS_SCHEME_PREFIX) == true) goto L33;
        if (r1.startsWith(ASSET_SCHEME_PREFIX) == true) goto L31;
        if (r1.startsWith(RESOURCE_SCHEME_PREFIX) == true) goto L31;
        if (r1.startsWith(FILE_SCHEME_PREFIX) == true) goto L31;
        if (r1.startsWith(CONTENT_SCHEMA_PREFIX) == false) goto L23;
        return KryptonSchemaType.CONTENT;
    L23:
        if (r1.startsWith(DATA_SCHEMA_PREFIX) == false) goto L29;
        if (r1.contains(BASE64_PREFIX) == false) goto L29;
        return KryptonSchemaType.DATAURI;
    L29:
        return KryptonSchemaType.INVALID;
    L31:
        return KryptonSchemaType.LOCAL;
    L33:
        return KryptonSchemaType.REMOTE;
    }

    public static byte[] getByteArrayFromInputStream(InputStream r1, int r2) {
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();
        if (copyStream(r1, r0, r2) == true) goto L5;
        return null;
    L5:
        return r0.toByteArray();
    }

    private static boolean copyStream(InputStream r6, OutputStream r7, int r8) {
        if (r6 == null) goto L22;
        if (r7 == null) goto L22;
        int r2 = clamp(r8, BUFFER_MIN_SIZE, BUFFER_MAX_SIZE);     // Catch: Throwable -> L14 IOException -> L16
        byte[] r3 = new byte[r2];     // Catch: Throwable -> L14 IOException -> L16
        KryptonLLog.i(TAG, "Start read from stream...");     // Catch: Throwable -> L14 IOException -> L16
    L8:
        int r4 = r6.read(r3, 0, r2);     // Catch: Throwable -> L14 IOException -> L16
        if (r4 == (-1)) goto L11;
        r7.write(r3, 0, r4);     // Catch: Throwable -> L14 IOException -> L16
        goto L8
    L11:
        KryptonLLog.i(TAG, "End read from stream, the total stream content is: " + r8);     // Catch: Throwable -> L14 IOException -> L16
        closeQuietly(r6);
        closeQuietly(r7);
        return true;
    L16:
        e = move-exception;
        KryptonLLog.e(TAG, "Failed to convert to byte array from LynxResResponse: " + e.getMessage());     // Catch: Throwable -> L14
        closeQuietly(r6);
        closeQuietly(r7);
        return false;
    L14:
        th = move-exception;
        closeQuietly(r6);
        closeQuietly(r7);
        throw th;
    L22:
        KryptonLLog.e(TAG, "Invalid input stream or output stream");
        return false;
    }

    private static Executor getExecutor(final String r1, final int r2, int r3) {
        return PThreadExecutorsUtils.newFixedThreadPool(r3, new AnonymousClass1(r1, r2));
    L4:
        th = move-exception;
        KryptonLLog.e(TAG, th.toString());
        return new AnonymousClass2();
    }
}
