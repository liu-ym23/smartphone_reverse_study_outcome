package com.tencent.open.utils;

import android.app.Activity;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import androidx.core.content.FileProvider;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.android.lark.chameleon.util.EncriptUtils;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.tab.v1.space.DocTabPayload;
import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import com.tencent.connect.common.Constants;
import com.tencent.open.log.SLog;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class m {
    private static String a = "";
    private static String b = "";
    private static String c = "";
    private static String d = "";
    private static int e = -1;
    private static String f = "0123456789ABCDEF";

    private static char a(int r1) {
        int r2 = r1 & 15;
        if (r2 >= 10) goto L5;
        int r3 = r2 + 48;
    L7:
        return (char) r3;
    L5:
        r3 = (r2 - 10) + 97;
        goto L7
    }

    public static boolean a() {
        if (Environment.getExternalStorageState().equals("mounted") == false) goto L5;
        File r0 = Environment.getExternalStorageDirectory();
    L6:
        if (r0 == null) goto L9;
        return true;
    L9:
        return false;
    L5:
        r0 = null;
        goto L6
    }

    public static String b() {
        File r0 = g.e();
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r0.exists() == true) goto L10;
        r0.mkdirs();
    L10:
        return r0.toString();
    }

    public static boolean c() {
        Context r0 = g.a();
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.getPackageManager().checkPermission("android.permission.WRITE_EXTERNAL_STORAGE", r0.getPackageName()) != 0) goto L9;
        return true;
    L9:
        return false;
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_tencent_open_utils_m_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r1) {
        return WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics());
    }

    public static String a(byte[] r5) {
        if (r5 != null) goto L5;
        return null;
    L5:
        StringBuilder r1 = new StringBuilder(r5.length * 2);
        int r0 = 0;
    L7:
        if (r0 >= r5.length) goto L13;
        String r2 = Integer.toString(r5[r0] & 255, 16);
        if (r2.length() != 1) goto L11;
        r2 = DocTabPayload.DocType.UNKNOWN.concat(r2);
    L11:
        r1.append(r2);
        r0 = r0 + 1;
        goto L7
    L13:
        return r1.toString();
    }

    public static boolean b(Context r5) {
        if (r5 != null) goto L6;
        return true;
    L6:
        if (i(r5, "android.permission.ACCESS_NETWORK_STATE") == false) goto L8;
        return true;
    L8:
        ConnectivityManager r6 = (ConnectivityManager) r5.getSystemService("connectivity");
        if (r6 != null) goto L27;
        return true;
    L27:
        NetworkInfo[] r7 = r6.getAllNetworkInfo();     // Catch: Exception -> L13
    L16:
        if (r7 != null) goto L18;
    L26:
        return false;
    L18:
        if (r7.length == 0) goto L26;
        int r2 = r7.length;
        int r3 = 0;
    L21:
        if (r3 >= r2) goto L26;
        if (r7[r3].isConnectedOrConnecting() == true) goto L24;
        r3 = r3 + 1;
        goto L21
    L24:
        return true;
    L13:
        e = move-exception;
        SLog.e("openSDK_LOG.Util", "Util.isNetWorkAvailable has exception: ", e);
        r7 = null;
        goto L16
    }

    public static boolean c(Context r6) {
        DisplayMetrics r7 = INVOKEVIRTUAL_com_tencent_open_utils_m_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r6.getResources());     // Catch: Throwable -> L4
        double r0 = Math.sqrt(Math.pow(r7.widthPixels / r7.xdpi, 2.0d) + Math.pow(r7.heightPixels / r7.ydpi, 2.0d));     // Catch: Throwable -> L4
    L6:
        if (r0 <= 6.5d) goto L9;
        return true;
    L9:
        return false;
    L4:
        r0 = 0.0d;
        goto L6
    }

    public static JSONObject d(String r2) throws JSONException {
        if (r2.equals("false") == false) goto L6;
        r2 = "{value : false}";
    L6:
        if (r2.equals("true") == false) goto L9;
        r2 = "{value : true}";
    L9:
        if (r2.contains("allback(") == false) goto L12;
        r2 = r2.replaceFirst("[\\s\\S]*allback\\(([\\s\\S]*)\\);[^\\)]*\\z", "$1").trim();
    L12:
        if (r2.contains("online[0]=") == false) goto L15;
        r2 = "{online:" + r2.charAt(r2.length() - 2) + "}";
    L15:
        return new JSONObject(r2);
    }

    public static boolean e(String r0) {
        if (r0 != null) goto L4;
    L7:
        return true;
    L4:
        if (r0.length() == 0) goto L7;
        return false;
    }

    public static String f(String r2) {
        return URLEncoder.encode(r2, "UTF-8");
    L4:
        e = move-exception;
        SLog.e("openSDK_LOG.Util", "urlEncode: UnsupportedEncodingException", e);
        return BuildConfig.FLAVOR;
    }

    private static boolean g(Context r4) {
        PackageInfo r5 = r4.getPackageManager().getPackageInfo("com.tencent.mtt", 64);     // Catch: Exception -> L16
        String r2 = r5.versionName;     // Catch: Exception -> L16
        if (k.a(r2, "4.3") >= 0) goto L6;
    L17:
        goto L15
    L6:
        if (r2.startsWith("4.4") == true) goto L17;
        Signature[] r6 = r5.signatures;     // Catch: Exception -> L16
        if (r6 == null) goto L17;
        MessageDigest r3 = MessageDigest.getInstance(EncriptUtils.KEY_MD5);     // Catch: NoSuchAlgorithmException -> L13 Exception -> L16
        r3.update(r6[0].toByteArray());     // Catch: NoSuchAlgorithmException -> L13 Exception -> L16
        String r7 = a(r3.digest());     // Catch: NoSuchAlgorithmException -> L13 Exception -> L16
        r3.reset();     // Catch: NoSuchAlgorithmException -> L13 Exception -> L16
        if (r7.equals("d8391a394d4a179e6fe7bdb8a301258b") == false) goto L17;
        return true;
    L13:
        e = move-exception;
        SLog.e("openSDK_LOG.Util", "isQQBrowerAvailable has exception: " + e.getMessage());     // Catch: Exception -> L16
    L15:
        return false;
    }

    public static final boolean h(String r2) {
        if (r2 != null) goto L6;
        return false;
    L6:
        if (r2.startsWith("http://") == false) goto L8;
    L9:
        return true;
    L8:
        if (r2.startsWith("https://") == true) goto L9;
        return false;
    }

    public static boolean i(String r2) {
        if (r2 != null) goto L6;
        return false;
    L6:
        if (new PolarisFileWrapper(r2).exists() == false) goto L9;
        return true;
    L9:
        return false;
    }

    public static byte[] j(String r2) {
        return r2.getBytes("UTF-8");
    L4:
        e = move-exception;
        SLog.e("openSDK_LOG.Util", "getBytesUTF8: UnsupportedEncodingException", e);
        return new byte[0];
    }

    public static String k(String r1) {
        return a(r1, 2);
    }

    public static File l(String r3) throws IOException {
        PolarisFileWrapper r0 = new PolarisFileWrapper(r3);
        if (r0.exists() == false) goto L5;
    L13:
        return r0;
    L5:
        if (r0.getParentFile() != null) goto L7;
    L12:
        r0.createNewFile();
        goto L13
    L7:
        if (r0.getParentFile().exists() == true) goto L12;
        if (r0.getParentFile().mkdirs() == false) goto L11;
        r0.createNewFile();
        goto L13
    L11:
        SLog.d("openSDK_LOG.Util", "createFile failed" + r3);
        goto L13
    }

    public static boolean m(String r2) {
        String r0 = b();
        if (TextUtils.isEmpty(r2) == false) goto L5;
    L9:
        return false;
    L5:
        if (TextUtils.isEmpty(r0) == true) goto L9;
        if (r2.contains(r0) == false) goto L9;
        return true;
    }

    public static Bundle a(String r7) {
        Bundle r0 = new Bundle();
        if (r7 == null) goto L17;
        String[] r8 = r7.split("&");     // Catch: Exception -> L10
        int r1 = r8.length;     // Catch: Exception -> L10
        int r3 = 0;
    L5:
        if (r3 >= r1) goto L18;
        String[] r4 = a(r8[r3], "=");     // Catch: Exception -> L10
        if (r4.length != 2) goto L9;
        r0.putString(URLDecoder.decode(r4[0]), URLDecoder.decode(r4[1]));     // Catch: Exception -> L10
    L9:
        r3 = r3 + 1;
        goto L5
    L18:
        return r0;
    L10:
        return null;
    L17:
        return r0;
    }

    public static Bundle b(String r2) {
        URL r0 = new URL(r2.replace("auth://", "http://"));     // Catch: MalformedURLException -> L5
        Bundle r3 = a(r0.getQuery());     // Catch: MalformedURLException -> L5
        r3.putAll(a(r0.getRef()));     // Catch: MalformedURLException -> L5
        return r3;
    L6:
        return new Bundle();
    }

    public static JSONObject c(String r2) {
        URL r0 = new URL(r2.replace("auth://", "http://"));     // Catch: MalformedURLException -> L5
        JSONObject r3 = a(null, r0.getQuery());     // Catch: MalformedURLException -> L5
        a(r3, r0.getRef());     // Catch: MalformedURLException -> L5
        return r3;
    L6:
        return new JSONObject();
    }

    public static boolean d(Context r1) {
        if (k.c(r1, "8.1.5") < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean e(Context r1) {
        if (k.c(r1, "8.1.8") < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean f(Context r1) {
        if (k.c(r1, "5.9.5") >= 0) goto L5;
        return false;
    L5:
        return true;
    }

    public static String g(String r6) {
        MessageDigest r0 = MessageDigest.getInstance(EncriptUtils.KEY_MD5);     // Catch: NoSuchAlgorithmException -> L9
        r0.update(j(r6));     // Catch: NoSuchAlgorithmException -> L9
        byte[] r1 = r0.digest();     // Catch: NoSuchAlgorithmException -> L9
        if (r1 == null) goto L15;
        StringBuilder r2 = new StringBuilder();     // Catch: NoSuchAlgorithmException -> L9
        int r3 = r1.length;     // Catch: NoSuchAlgorithmException -> L9
        int r4 = 0;
    L5:
        if (r4 >= r3) goto L7;
        byte r5 = r1[r4];     // Catch: NoSuchAlgorithmException -> L9
        r2.append(a(r5 >>> 4));     // Catch: NoSuchAlgorithmException -> L9
        r2.append(a(r5));     // Catch: NoSuchAlgorithmException -> L9
        r4 = r4 + 1;     // Catch: NoSuchAlgorithmException -> L9
        goto L5
    L7:
        return r2.toString();
    L15:
        return r6;
    L9:
        e = move-exception;
        SLog.e("openSDK_LOG.Util", "encrypt has exception: " + e.getMessage());
        return r6;
    }

    public static final String a(Context r1) {
        if (r1 == null) goto L7;
        CharSequence r2 = r1.getPackageManager().getApplicationLabel(r1.getApplicationInfo());
        if (r2 != null) goto L6;
        return null;
    L6:
        return r2.toString();
    L7:
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11, types: [java.io.BufferedInputStream] */
    /* JADX WARN: Type inference failed for: r7v16 */
    /* JADX WARN: Type inference failed for: r7v17 */
    /* JADX WARN: Type inference failed for: r7v19 */
    /* JADX WARN: Type inference failed for: r7v20 */
    /* JADX WARN: Type inference failed for: r7v21 */
    /* JADX WARN: Type inference failed for: r7v9 */
    public static boolean a(File r6, BufferedInputStream r7) {
        FileOutputStream r2 = null;
    L67:
        e = move-exception;
        SLog.e("openSDK_LOG.Util", "copyFile error, ", e);
    L97:
        return false;
    L56:
        e = e;
        r7 = 0;
    L58:
        SLog.e("openSDK_LOG.Util", "copyFile error, ", e);     // Catch: Throwable -> L70
        if (r2 != null) goto L89;
    L64:
        if (r7 == 0) goto L97;
        r7.close();     // Catch: IOException -> L67
        r7 = r7;
    L82:
        goto L97
    L89:
        r2.close();     // Catch: IOException -> L62
    L62:
        e = move-exception;
        SLog.e("openSDK_LOG.Util", "copyFile error, ", e);
    L45:
        e = e;
        r7 = 0;
    L47:
        SLog.e("openSDK_LOG.Util", "copyFile error, ", e);     // Catch: Throwable -> L70
        if (r2 != null) goto L85;
    L53:
        if (r7 == 0) goto L97;
        r7.close();     // Catch: IOException -> L67
        r7 = r7;
        goto L82
    L85:
        r2.close();     // Catch: IOException -> L51
    L51:
        e = move-exception;
        SLog.e("openSDK_LOG.Util", "copyFile error, ", e);
    L43:
        th = th;
        r7 = 0;
    L71:
        if (r2 != null) goto L95;
    L76:
        if (r7 == 0) goto L107;
        r7.close();     // Catch: IOException -> L79
        throw th;
    L79:
        e = move-exception;
        SLog.e("openSDK_LOG.Util", "copyFile error, ", e);
        throw th;
    L107:
        throw th;
    L95:
        r2.close();     // Catch: IOException -> L74
    L74:
        e = move-exception;
        SLog.e("openSDK_LOG.Util", "copyFile error, ", e);
        goto L76
    L4:
        if (r7.exists() == false) goto L7;
        r7.delete();     // Catch: Throwable -> L43 OutOfMemoryError -> L45 IOException -> L56
    L7:
        if (r7.getParentFile() != null) goto L9;
    L11:
        FileOutputStream r4 = new PolarisFileOutputStreamWrapper(r7);     // Catch: Throwable -> L43 OutOfMemoryError -> L45 IOException -> L56
        r7 = new BufferedInputStream(new PolarisFileInputStreamWrapper(r6));     // Catch: Throwable -> L34 OutOfMemoryError -> L37 IOException -> L40
    L103:
        byte[] r8 = new byte[102400];     // Catch: Throwable -> L28 OutOfMemoryError -> L30 IOException -> L32
    L15:
        int r3 = r7.read(r8);     // Catch: Throwable -> L28 OutOfMemoryError -> L30 IOException -> L32
        if (r3 == (-1)) goto L93;
        r4.write(r8, 0, r3);     // Catch: Throwable -> L28 OutOfMemoryError -> L30 IOException -> L32
        r4.flush();     // Catch: Throwable -> L28 OutOfMemoryError -> L30 IOException -> L32
    L93:
        r4.close();     // Catch: IOException -> L21
    L87:
        r7.close();     // Catch: IOException -> L25
    L27:
        return true;
    L25:
        e = move-exception;
        SLog.e("openSDK_LOG.Util", "copyFile error, ", e);
    L21:
        e = move-exception;
        SLog.e("openSDK_LOG.Util", "copyFile error, ", e);
    L32:
        e = e;
    L42:
        r2 = r4;
        r7 = r7;
    L30:
        e = e;
    L39:
        r2 = r4;
        r7 = r7;
    L28:
        th = th;
    L36:
        r2 = r4;
    L40:
        e = e;
        r7 = 0;
    L37:
        e = e;
        r7 = 0;
    L34:
        th = th;
        r7 = 0;
        goto L36
    L9:
        if (r7.getParentFile().exists() == true) goto L11;
        r7.getParentFile().mkdirs();     // Catch: Throwable -> L43 OutOfMemoryError -> L45 IOException -> L56
    L70:
        th = th;
        goto L71
    }

    public static String b(Context r6, Uri r7) {
        if (r7 != null) goto L6;
        return null;
    L6:
        if (DocumentsContract.isDocumentUri(r6, r7) == false) goto L37;
        String r1 = r7.getAuthority();
        if ("com.android.externalstorage.documents".equals(r1) == false) goto L16;
        String[] r8 = DocumentsContract.getDocumentId(r7).split(":");
        String r9 = r8[0];
        if ("primary".equals(r9) == false) goto L14;
        return Environment.getExternalStorageDirectory().getAbsolutePath().concat("/").concat(r8[1]);
    L14:
        return "/storage/".concat(r9).concat("/").concat(r8[1]);
    L16:
        if ("com.android.providers.downloads.documents".equals(r1) == false) goto L24;
        String r10 = DocumentsContract.getDocumentId(r7);
        if (r10.startsWith("raw:") == false) goto L22;
        return r10.replaceFirst("raw:", BuildConfig.FLAVOR);
    L22:
        return c(r6, ContentUris.withAppendedId(UriProtector.parse("content://downloads/public_downloads"), CastLongProtector.parseLong(r10)));
    L24:
        if ("com.android.providers.media.documents".equals(r1) == false) goto L36;
        String[] r11 = DocumentsContract.getDocumentId(r7).split(":");
        String r2 = r11[0];
        if ("image".equals(r2) == false) goto L29;
        Uri r0 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
    L35:
        return c(r6, ContentUris.withAppendedId(r0, CastLongProtector.parseLong(r11[1])));
    L29:
        if ("video".equals(r2) == false) goto L32;
        r0 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        goto L35
    L32:
        if ("audio".equals(r2) == false) goto L36;
        r0 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
    L36:
        return null;
    L37:
        String r3 = r7.getScheme();
        if ("content".equals(r3) == false) goto L41;
        return c(r6, r7);
    L41:
        if ("file".equals(r3) == true) goto L43;
        return null;
    L43:
        return r7.getPath();
    }

    public static String c(Context r12, Uri r13) {
        FileInputStream r10 = null;
        Cursor r4 = com_tencent_open_utils_m_android_content_ContentResolver_query(r12.getContentResolver(), r13, new String[]{"_data"}, null, null, null);     // Catch: Exception -> L11
        if (r4 != null) goto L115;
    L88:
        return null;
    L115:
    L9:
        e = e;
    L13:
        SLog.e("openSDK_LOG.Util", "queryAbsolutePath error : " + e.getMessage());
        if (r4 == null) goto L138;
        r4.close();
    L138:
        ParcelFileDescriptor r3 = com_tencent_open_utils_m_android_content_ContentResolver_openFileDescriptor(r12.getContentResolver(), r13, "r");     // Catch: Throwable -> L68 Exception -> L70
        FileInputStream r5 = new PolarisFileInputStreamWrapper(r3.getFileDescriptor());     // Catch: Throwable -> L64 Exception -> L66
        File r14 = h(r12, "Images");     // Catch: Throwable -> L60 Exception -> L62
        if (r14 != null) goto L31;
        SLog.e("openSDK_LOG.Util", "getExternalFilesDir return null");     // Catch: Throwable -> L60 Exception -> L62
        r5.close();     // Catch: IOException -> L23
    L129:
        r3.close();     // Catch: IOException -> L27
    L29:
        return null;
    L27:
        e = move-exception;
        SLog.e("openSDK_LOG.Util", "close ParcelFileDescriptor error" + e.getMessage());
    L23:
        e = move-exception;
        SLog.e("openSDK_LOG.Util", "close fileIuputStream error" + e.getMessage());
        goto L129
    L31:
        if (r14.exists() == true) goto L33;
        r14.mkdirs();     // Catch: Throwable -> L60 Exception -> L62
    L33:
        PolarisFileWrapper r6 = new PolarisFileWrapper(r14, r13.getLastPathSegment());     // Catch: Throwable -> L60 Exception -> L62
        if (r6.exists() == true) goto L36;
        r6.createNewFile();     // Catch: Throwable -> L60 Exception -> L62
    L36:
        FileOutputStream r15 = new PolarisFileOutputStreamWrapper(r6);     // Catch: Throwable -> L60 Exception -> L62
        byte[] r16 = new byte[2048];     // Catch: Throwable -> L56 Exception -> L58
    L39:
        int r7 = r5.read(r16);     // Catch: Throwable -> L56 Exception -> L58
        if (r7 == (-1)) goto L42;
        r15.write(r16, 0, r7);     // Catch: Throwable -> L56 Exception -> L58
        goto L39
    L42:
        r15.flush();     // Catch: Throwable -> L56 Exception -> L58
        String r17 = r6.getAbsolutePath();     // Catch: Throwable -> L56 Exception -> L58
        r5.close();     // Catch: IOException -> L45
    L121:
        r15.close();     // Catch: IOException -> L49
    L127:
        r3.close();     // Catch: IOException -> L53
    L55:
        return r17;
    L53:
        e = move-exception;
        SLog.e("openSDK_LOG.Util", "close ParcelFileDescriptor error" + e.getMessage());
    L49:
        e = move-exception;
        SLog.e("openSDK_LOG.Util", "close fileOutputStream error" + e.getMessage());
    L45:
        e = move-exception;
        SLog.e("openSDK_LOG.Util", "close fileIuputStream error" + e.getMessage());
        goto L121
    L58:
        e = move-exception;
        FileOutputStream r18 = r15;
        e = e;
    L113:
        SLog.e("openSDK_LOG.Util", "copy file from uri error : " + e.getMessage());     // Catch: Throwable -> L89
        if (r5 != null) goto L133;
    L78:
        if (r18 != null) goto L107;
    L83:
        if (r3 == null) goto L88;
        r3.close();     // Catch: IOException -> L86
    L86:
        e = move-exception;
        SLog.e("openSDK_LOG.Util", "close ParcelFileDescriptor error" + e.getMessage());
        goto L88
    L107:
        r18.close();     // Catch: IOException -> L81
    L81:
        e = move-exception;
        SLog.e("openSDK_LOG.Util", "close fileOutputStream error" + e.getMessage());
        goto L83
    L133:
        r5.close();     // Catch: IOException -> L76
    L76:
        e = move-exception;
        SLog.e("openSDK_LOG.Util", "close fileIuputStream error" + e.getMessage());
    L89:
        th = th;
    L90:
        r10 = r5;
    L91:
        if (r10 != null) goto L119;
    L96:
        if (r18 != null) goto L125;
    L101:
        if (r3 == null) goto L143;
        r3.close();     // Catch: IOException -> L104
        throw th;
    L104:
        e = move-exception;
        SLog.e("openSDK_LOG.Util", "close ParcelFileDescriptor error" + e.getMessage());
        throw th;
    L143:
        throw th;
    L125:
        r18.close();     // Catch: IOException -> L99
    L99:
        e = move-exception;
        SLog.e("openSDK_LOG.Util", "close fileOutputStream error" + e.getMessage());
        goto L101
    L119:
        r10.close();     // Catch: IOException -> L94
    L94:
        e = move-exception;
        SLog.e("openSDK_LOG.Util", "close fileIuputStream error" + e.getMessage());
    L56:
        th = move-exception;
        r10 = r5;
        r18 = r15;
        th = th;
    L62:
        e = e;
        r18 = null;
    L60:
        th = th;
        r18 = null;
        goto L90
    L66:
        e = e;
        r18 = null;
        r5 = null;
    L64:
        th = th;
        r18 = null;
        goto L91
    L70:
        e = e;
        r18 = null;
        r3 = null;
        r5 = null;
    L68:
        th = th;
        r18 = null;
        r3 = null;
        goto L91
    L6:
        if (r4.moveToFirst() == false) goto L88;
        return r4.getString(r4.getColumnIndexOrThrow("_data"));
    L11:
        e = e;
        r4 = null;
        goto L13
    }

    private static int com_tencent_open_utils_m_android_content_Context_checkSelfPermission(Context r18, String r19) {
        ArrayList r0 = new ArrayList();
        Object[] r1 = {r19};
        f06.b r11 = new f06.b("auto_cert_com_tencent_open_utils_m_android_content_Context_checkSelfPermission");
        g06.a r2 = (g06.a) ApiHookConfig.b.get(102608);
        if (r2 == null) goto L5;
        f06.a[] r3 = r2.i;
    L6:
        f06.a[] r15 = r3;
        int r9 = r15.length;
        int r8 = 0;
    L8:
        if (r8 >= r9) goto L15;
        f06.a r7 = r15[r8];
        int r16 = r8;
        int r17 = r9;
        f06.d r4 = r7.preInvoke(102608, "android/content/Context", "checkSelfPermission", r18, r1, "int", r11);     // Catch: Exception -> L22
        if (r4.a == true) goto L17;
        r0.add(r7);     // Catch: Exception -> L22
    L17:
        if (r4.a == false) goto L21;
        return ((Integer) r4.b).intValue();
    L21:
        return r18.checkSelfPermission(r19);
    L14:
        r8 = r16 + 1;
        r9 = r17;
        goto L8
    L15:
        r4 = new f06.d(false, null);
        goto L17
    L5:
        r3 = ApiHookConfig.d;
        goto L6
    }

    public static String d(Context r0, String r1) {
        if (r0 != null) goto L5;
        return BuildConfig.FLAVOR;
    L5:
        b(r0, r1);
        return a;
    }

    public static String e(Context r0, String r1) {
        if (r0 != null) goto L5;
        return BuildConfig.FLAVOR;
    L5:
        String r2 = d(r0, r1);
        c = r2;
        return r2;
    }

    public static boolean f(Context r4, String r5) {
        boolean r1 = false;
        if (c(r4) == true) goto L5;
    L7:
        boolean r0 = true;
    L8:
        if (r0 == true) goto L10;
    L12:
        if (r0 == true) goto L14;
        return r0;
    L14:
        if (k.c(r4, r5) >= 0) goto L17;
        r1 = true;
    L17:
        return r1;
    L10:
        if (k.a(r4, "com.tencent.tim") == null) goto L12;
        r0 = false;
        goto L12
    L5:
        if (k.a(r4, "com.tencent.minihd.qq") == null) goto L7;
        r0 = false;
        goto L8
    }

    public static boolean g(Context r3, String r4) {
        boolean r1 = false;
        if (c(r3) == true) goto L5;
    L7:
        boolean r0 = true;
    L8:
        if (r0 == true) goto L10;
        return r0;
    L10:
        if (k.c(r3, r4) >= 0) goto L13;
        r1 = true;
    L13:
        return r1;
    L5:
        if (k.a(r3, "com.tencent.minihd.qq") == null) goto L7;
        r0 = false;
        goto L8
    }

    public static File h(Context r1, String r2) {
        if (r1 != null) goto L5;
        return null;
    L5:
        File[] r3 = r1.getExternalFilesDirs(r2);
        if (r3 != null) goto L8;
        return null;
    L8:
        if (r3.length > 0) goto L10;
        return null;
    L10:
        return r3[0];
    }

    private static boolean i(Context r2, String r3) {
        if (Build.VERSION.SDK_INT < 23) goto L14;
        if (com_tencent_open_utils_m_android_content_Context_checkSelfPermission(r2, r3) == 0) goto L15;
        return true;
    L15:
        return false;
    L8:
        e = move-exception;
        SLog.e("openSDK_LOG.Util", "checkSelfPermission exception", e);
        return false;
    L14:
        return false;
    }

    public static Drawable a(String r5, Context r6) {
        InputStream r2 = null;
        Drawable r3 = null;
        r3 = null;
        if (r6 != null) goto L42;
        SLog.e("openSDK_LOG.Util", "context null!");
        return null;
    L42:
        InputStream r7 = r6.getAssets().open(r5);     // Catch: Throwable -> L18 IOException -> L20
        r3 = Drawable.createFromStream(r7, r5);     // Catch: Throwable -> L14 IOException -> L16
        r7.close();     // Catch: Exception -> L11
    L27:
        return r3;
    L11:
        e = e;
        StringBuilder r8 = new StringBuilder("inputStream close exception: ");
    L13:
        r8.append(e.getMessage());
        SLog.e("openSDK_LOG.Util", r8.toString());
    L16:
        e = e;
    L22:
        SLog.e("openSDK_LOG.Util", "getDrawable exception: " + e.getMessage());     // Catch: Throwable -> L14
        r7.close();     // Catch: Exception -> L25
    L25:
        e = e;
        r8 = new StringBuilder("inputStream close exception: ");
    L14:
        th = th;
        r2 = r7;
    L33:
        r2.close();     // Catch: Exception -> L30
    L32:
        throw th;
    L30:
        e = move-exception;
        SLog.e("openSDK_LOG.Util", "inputStream close exception: " + e.getMessage());
        goto L32
    L20:
        e = e;
        r7 = null;
    L18:
        th = th;
        goto L33
    }

    public static void b(Context r5, String r6) {
        if (r5 != null) goto L12;
        return;
    L12:
        PackageInfo r7 = r5.getPackageManager().getPackageInfo(r6, 0);     // Catch: Exception -> L7 PackageManager.NameNotFoundException -> L9
        String r8 = r7.versionName;     // Catch: Exception -> L7 PackageManager.NameNotFoundException -> L9
        b = r8;     // Catch: Exception -> L7 PackageManager.NameNotFoundException -> L9
        a = r8.substring(0, r8.lastIndexOf(46));     // Catch: Exception -> L7 PackageManager.NameNotFoundException -> L9
        String r9 = b;     // Catch: Exception -> L7 PackageManager.NameNotFoundException -> L9
        d = r9.substring(r9.lastIndexOf(46) + 1, b.length());     // Catch: Exception -> L7 PackageManager.NameNotFoundException -> L9
        e = r7.versionCode;     // Catch: Exception -> L7 PackageManager.NameNotFoundException -> L9
    L15:
        return;
    L9:
        e = move-exception;
        SLog.e("openSDK_LOG.Util", "getPackageInfo has exception: " + e.getMessage());
        return;
    L7:
        e = move-exception;
        SLog.e("openSDK_LOG.Util", "getPackageInfo has exception: " + e.getMessage());
    }

    public static String c(Context r0, String r1) {
        if (r0 != null) goto L5;
        return BuildConfig.FLAVOR;
    L5:
        b(r0, r1);
        return b;
    }

    public static JSONObject a(JSONObject r6, String r7) {
        if (r6 != null) goto L4;
        r6 = new JSONObject();
    L4:
        if (r7 == null) goto L16;
        String[] r8 = r7.split("&");
        int r0 = r8.length;
        int r2 = 0;
    L6:
        if (r2 >= r0) goto L16;
        String[] r3 = r8[r2].split("=");
        if (r3.length != 2) goto L15;
        r3[0] = URLDecoder.decode(r3[0]);     // Catch: Exception -> L17
        r3[1] = URLDecoder.decode(r3[1]);     // Catch: Exception -> L17
    L18:
        r6.put(r3[0], r3[1]);     // Catch: JSONException -> L13
    L13:
        e = move-exception;
        SLog.e("openSDK_LOG.Util", "decodeUrlToJson has exception: " + e.getMessage());
    L15:
        r2 = r2 + 1;
    L16:
        return r6;
    }

    public static boolean b(String r3, String r4) {
        PolarisFileWrapper r0 = new PolarisFileWrapper(r3);
        if (r0.exists() == true) goto L10;
    L8:
        return false;
    L10:
        return a(r0, l(r4));
    L6:
        e = move-exception;
        SLog.d("openSDK_LOG.Util", "copy fail from " + r3 + " to " + r4 + " ", e);
        goto L8
    }

    public static long a(Context r8, Uri r9) {
        Cursor r10 = com_tencent_open_utils_m_android_content_ContentResolver_query(r8.getContentResolver(), r9, new String[]{"_size"}, null, null, null);
        long r2 = 0;
        if (r10 != null) goto L32;
    L25:
        return 0;
    L32:
        if (r10.getCount() == 0) goto L25;
        int r11 = r10.getColumnIndexOrThrow("_size");     // Catch: Throwable -> L14 Exception -> L16
        if (r10.moveToFirst() == false) goto L10;
        r2 = r10.getLong(r11);     // Catch: Throwable -> L14 Exception -> L16
    L10:
        r10.close();     // Catch: Exception -> L12
    L31:
    L19:
        return r2;
    L16:
        e = move-exception;
        SLog.e("openSDK_LOG.Util", "cursor exception", e);     // Catch: Throwable -> L14
        r10.close();     // Catch: Exception -> L12
    L14:
        th = move-exception;
        r10.close();     // Catch: Exception -> L22
    L24:
        throw th;
    L22:
        e = move-exception;
        SLog.e("openSDK_LOG.Util", "cursor exception", e);
    L12:
        e = move-exception;
        SLog.e("openSDK_LOG.Util", "cursor exception", e);
        goto L19
    }

    public static boolean a(Context r7, String r8) {
        boolean r3 = g(r7);     // Catch: Exception -> L9
        if (r3 == false) goto L7;
        a(r7, "com.tencent.mtt", "com.tencent.mtt.MainActivity", r8);     // Catch: Exception -> L6
    L31:
        return true;
    L7:
        a(r7, "com.android.browser", "com.android.browser.BrowserActivity", r8);     // Catch: Exception -> L6
    L11:
        if (r3 == false) goto L29;
        a(r7, "com.android.browser", "com.android.browser.BrowserActivity", r8);     // Catch: Exception -> L14
        return true;
    L14:
        a(r7, "com.google.android.browser", "com.android.browser.BrowserActivity", r8);     // Catch: Exception -> L16
        return true;
    L16:
        a(r7, "com.android.chrome", "com.google.android.apps.chrome.Main", r8);     // Catch: Exception -> L18
        return true;
    L18:
        return false;
    L29:
        a(r7, "com.google.android.browser", "com.android.browser.BrowserActivity", r8);     // Catch: Exception -> L21
        return true;
    L21:
        a(r7, "com.android.chrome", "com.google.android.apps.chrome.Main", r8);     // Catch: Exception -> L24
        return true;
    L24:
        return false;
    L9:
        r3 = false;
        goto L11
    }

    public static String a(String r1, int r2) {
        if (TextUtils.isEmpty(r1) == false) goto L10;
    L8:
        return BuildConfig.FLAVOR;
    L10:
        return Base64.encodeToString(r1.getBytes("UTF-8"), r2);
    L6:
        e = move-exception;
        SLog.e("openSDK_LOG.Util", "convert2Base64String exception: " + e.getMessage());
        goto L8
    }

    public static String[] a(String r5, String r6) {
        int r0 = r5.indexOf(r6);
        if (r0 != (-1)) goto L7;
        return new String[]{r5};
    L7:
        return new String[]{r5.substring(0, r0), r5.substring(r0 + r6.length())};
    }

    public static boolean a(Context r1, boolean r2) {
        if (c(r1) == false) goto L8;
        if (k.a(r1, "com.tencent.minihd.qq") == null) goto L8;
        return true;
    L8:
        if (k.c(r1, "4.1") < 0) goto L10;
        return true;
    L10:
        if (k.a(r1, "com.tencent.tim") != null) goto L14;
        return false;
    L14:
        return true;
    }

    public static Uri a(Activity r3, String r4, String r5) {
        if (TextUtils.isEmpty(r5) == false) goto L14;
        SLog.e("openSDK_LOG.Util", "grantUriPermissionToAllQQVersion -- stringForFileUri is empty");
        return null;
    L14:
        String r6 = Tencent.getAuthorities(r4);     // Catch: Exception -> L11
        if (TextUtils.isEmpty(r6) == false) goto L9;
        return null;
    L9:
        Uri r7 = FileProvider.getUriForFile(r3, r6, new PolarisFileWrapper(r5));     // Catch: Exception -> L11
        r3.grantUriPermission("com.tencent.mobileqq", r7, 3);     // Catch: Exception -> L11
        r3.grantUriPermission("com.tencent.tim", r7, 3);     // Catch: Exception -> L11
        r3.grantUriPermission("com.tencent.minihd.qq", r7, 3);     // Catch: Exception -> L11
        r3.grantUriPermission("com.tencent.qqlite", r7, 3);     // Catch: Exception -> L11
        return r7;
    L11:
        e = move-exception;
        SLog.e("openSDK_LOG.Util", "grantUriPermissionToAllQQVersion exception:", e);
        return null;
    }

    private static ParcelFileDescriptor com_tencent_open_utils_m_android_content_ContentResolver_openFileDescriptor(ContentResolver r18, Uri r19, String r20) {
        ArrayList r0 = new ArrayList();
        Object[] r1 = {r19, r20};
        f06.b r11 = new f06.b();
        g06.a r2 = (g06.a) ApiHookConfig.b.get(240020);
        if (r2 == null) goto L5;
        f06.a[] r3 = r2.i;
    L6:
        f06.a[] r15 = r3;
        int r9 = r15.length;
        int r8 = 0;
    L8:
        if (r8 >= r9) goto L15;
        f06.a r7 = r15[r8];
        int r16 = r8;
        int r17 = r9;
        f06.d r4 = r7.preInvoke(240020, "android/content/ContentResolver", "openFileDescriptor", r18, r1, "android.os.ParcelFileDescriptor", r11);     // Catch: Exception -> L22
        if (r4.a == true) goto L17;
        r0.add(r7);     // Catch: Exception -> L22
    L17:
        if (r4.a == false) goto L21;
        return (ParcelFileDescriptor) r4.b;
    L21:
        return ContentResolverWrapper.openFileDescriptor(r18, r19, r20);
    L14:
        r8 = r16 + 1;
        r9 = r17;
        goto L8
    L15:
        r4 = new f06.d(false, null);
        goto L17
    L5:
        r3 = ApiHookConfig.d;
        goto L6
    }

    public static boolean a(Map<String, Object> r2, String r3, boolean r4) {
        if (r2 != null) goto L7;
        SLog.e("openSDK_LOG.Util", "getBoolean error, params==null");
        return r4;
    L7:
        if (r2.containsKey(r3) == true) goto L10;
        SLog.e("openSDK_LOG.Util", "getBoolean error, not comtain : " + r3);
        return r4;
    L10:
        Object r5 = r2.get(r3);
        if ((r5 instanceof Boolean) == true) goto L13;
        return r4;
    L13:
        return ((Boolean) r5).booleanValue();
    }

    public static String a(Map<String, Object> r2, String r3, String r4) {
        if (r2 != null) goto L7;
        SLog.e("openSDK_LOG.Util", "getString error, params==null");
        return r4;
    L7:
        if (r2.containsKey(r3) == true) goto L10;
        SLog.e("openSDK_LOG.Util", "getString error, not comtain : " + r3);
        return r4;
    L10:
        Object r5 = r2.get(r3);
        if ((r5 instanceof String) == true) goto L13;
        return r4;
    L13:
        return (String) r5;
    }

    public static boolean a(Context r0, String r1, String r2) {
        boolean r3 = b(r1, r2);
        SLog.i("openSDK_LOG.Util", "copyFileByCheckPermission() copy success:" + r3);
        return r3;
    }

    public static String a(String r5, Activity r6, String r7, IUiListener r8) {
        boolean r2 = m(r7);     // Catch: Exception -> L23
        SLog.i("openSDK_LOG.Util", "doPublishMood() check file: isAppSpecificDir=" + r2 + ",hasSDPermission=" + c());     // Catch: Exception -> L23
        if (r2 == true) goto L18;
        File r0 = g.a("Images");     // Catch: Exception -> L23
        if (r0 == null) goto L9;
        String r1 = r0.getAbsolutePath() + File.separator + Constants.QQ_SHARE_TEMP_DIR;     // Catch: Exception -> L23
    L14:
        PolarisFileWrapper r3 = new PolarisFileWrapper(r7);     // Catch: Exception -> L23
        String r9 = r3.getAbsolutePath();     // Catch: Exception -> L23
        String r4 = r1 + File.separator + r3.getName();     // Catch: Exception -> L23
        if (b(r9, r4) == false) goto L17;
        r7 = r4;
        goto L18
    L17:
        r7 = null;
        goto L18
    L9:
        File r10 = g.a().getCacheDir();     // Catch: Exception -> L23
        if (r10 != null) goto L13;
        SLog.e("openSDK_LOG.Util", "getMediaFileUri error, cacheDir is null");     // Catch: Exception -> L23
        return null;
    L13:
        r1 = r10.getAbsolutePath() + File.separator + Constants.QQ_SHARE_TEMP_DIR;     // Catch: Exception -> L23
    L18:
        Uri r11 = a(r6, r5, r7);     // Catch: Exception -> L23
        if (r11 != null) goto L22;
        return null;
    L22:
        return r11.toString();
    L23:
        e = move-exception;
        SLog.e("openSDK_LOG.Util", "getMediaFileUri error", e);
        return null;
    }

    public static final String a(String r5, int r6, String r7, String r8) {
        if (TextUtils.isEmpty(r5) == false) goto L7;
        return BuildConfig.FLAVOR;
    L7:
        if (TextUtils.isEmpty(r7) == false) goto L27;
        r7 = "UTF-8";
    L27:
    L24:
        e = move-exception;
        SLog.e("openSDK_LOG.Util", "Util.subString has exception: " + e.getMessage());
        return r5;
    L11:
        if (r5.getBytes(r7).length > r6) goto L13;
        return r5;
    L13:
        int r1 = 0;
        int r2 = 0;
    L15:
        if (r1 >= r5.length()) goto L23;
        int r3 = r1 + 1;     // Catch: Exception -> L24
        r2 = r2 + r5.substring(r1, r3).getBytes(r7).length;     // Catch: Exception -> L24
        if (r2 > r6) goto L18;
        r1 = r3;
        goto L15
    L18:
        String r9 = r5.substring(0, r1);     // Catch: Exception -> L24
        if (TextUtils.isEmpty(r8) == true) goto L31;
        return r9 + r8;
    L31:
        return r9;
    L23:
        return r5;
    }

    private static void a(Context r2, String r3, String r4, String r5) {
        Intent r0 = new Intent();
        r0.setComponent(new ComponentName(r3, r4));
        r0.setAction("android.intent.action.VIEW");
        r0.addFlags(1073741824);
        r0.addFlags(268435456);
        r0.setData(UriProtector.parse(r5));
        r2.startActivity(r0);
    }

    public static Bundle a(String r12, String r13, String r14, String r15, String r16, String r17) {
        return a(r12, r14, r15, r13, r16, r17, BuildConfig.FLAVOR, BuildConfig.FLAVOR, BuildConfig.FLAVOR, BuildConfig.FLAVOR, BuildConfig.FLAVOR, BuildConfig.FLAVOR);
    }

    private static Cursor com_tencent_open_utils_m_android_content_ContentResolver_query(ContentResolver r13, Uri r14, String[] r15, String r16, String[] r17, String r18) {
        f06.c r8 = new f06.c();
        Object[] r9 = {r14, r15, r16, r17, r18};
        f06.b r10 = new f06.b();
        f06.d r11 = r8.b(240004, "android/content/ContentResolver", "query", r13, r9, "android.database.Cursor", r10);
        if (r11.a == false) goto L6;
        r8.a(240004, "android/content/ContentResolver", "query", r13, r9, null, r10, false);
        return (Cursor) r11.b;
    L6:
        Cursor r12 = r13.query(r14, r15, r16, r17, r18);
        r8.a(240004, "android/content/ContentResolver", "query", r13, r9, r12, r10, true);
        return r12;
    }

    public static Bundle a(String r2, String r3, String r4, String r5, String r6, String r7, String r8, String r9, String r10, String r11, String r12, String r13) {
        Bundle r0 = new Bundle();
        r0.putString("openid", r2);
        r0.putString("report_type", r3);
        r0.putString("act_type", r4);
        r0.putString("via", r5);
        r0.putString(ChameleonOpenTracker.ParamKey.APP_ID, r6);
        r0.putString(ChameleonOpenTracker.ParamKey.RESULT, r7);
        r0.putString(IPortraitService.TYPE, r8);
        r0.putString("login_status", r9);
        r0.putString("need_user_auth", r10);
        r0.putString("to_uin", r11);
        r0.putString("call_source", r12);
        r0.putString("to_type", r13);
        r0.putString("platform", "1");
        return r0;
    }
}
