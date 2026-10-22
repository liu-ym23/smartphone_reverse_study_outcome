package com.ss.ttvideoengine.utils;

import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.os.Looper;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.Base64;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.lark.chameleon.container.webcontainer.util.ChameleonContainerUtils;
import com.ss.android.lark.chameleon.util.EncriptUtils;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.tab.v1.space.DocTabPayload;
import com.ss.ttvideoengine.JniUtils;
import com.ss.ttvideoengine.Resolution;
import com.ss.ttvideoengine.TTVideoEngineConfig;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class TTHelper {
    private static final String TAG = "TTHelper";
    private static String mAppPath = null;
    private static final String queryStrAllowCharset = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_.~#[]!\\()*%";
    private static String sBoeSuffix = "";
    private static volatile String sLastExternalStorageState = null;
    private static volatile long sLastGetExternalStorageStateTime = -1;

    public TTHelper() {
    }

    public static /* synthetic */ Class access$000(String r0) throws ClassNotFoundException {
        return Class.forName(r0);
    }

    public static /* synthetic */ Class access$001(String r0, boolean r1, ClassLoader r2) throws ClassNotFoundException {
        return Class.forName(r0, r1, r2);
    }

    public static boolean isAndroidJB2() {
        return true;
    }

    public static <T> T nonNullElse(T r0, T r1) {
        if (r0 != null) goto L4;
        return r1;
    L4:
        return r0;
    }

    public static HashMap<String, Resolution> defaultAudioResolutionMap() {
        return new AnonymousClass2();
    }

    public static HashMap<String, Resolution> defaultVideoResolutionMap() {
        return new AnonymousClass1();
    }

    public static boolean isExternalStorageWritable() {
        return "mounted".equals(safeGetExternalStorageState());
    }

    public static String safeGetExternalStorageState() {
        if (TextUtils.isEmpty(sLastExternalStorageState) == false) goto L5;
    L12:
        sLastGetExternalStorageStateTime = System.currentTimeMillis();     // Catch: Throwable -> L10
        sLastExternalStorageState = Environment.getExternalStorageState();     // Catch: Throwable -> L10
        return sLastExternalStorageState;
    L10:
        return BuildConfig.FLAVOR;
    L5:
        if ((System.currentTimeMillis() - sLastGetExternalStorageStateTime) >= 5000) goto L12;
        return sLastExternalStorageState;
    }

    public static Looper getLooper() {
        if (Looper.myLooper() == null) goto L7;
        return Looper.myLooper();
    L7:
        return Looper.getMainLooper();
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_ss_ttvideoengine_utils_TTHelper_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r3) throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class r2 = access$000(r3);     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r3);
    L12:
        throw th;
    L34:
        Class r4 = access$000(r3);     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L17
    L16:
        return r4;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r3);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r3);
    }

    public static String base64Decode(String r1) {
        return base64Decode(r1, null);
    }

    public static byte[] base64DecodeToBytes(String r3) {
        TTVideoEngineLog.d(TAG, "base64DecodeToBytes " + r3);
        if (TextUtils.isEmpty(r3) == false) goto L11;
    L9:
        return null;
    L11:
        return Base64.decode(r3, 0);
    L7:
        th = move-exception;
        TTVideoEngineLog.e(TAG, "base64DecodeToBytes " + th);
        goto L9
    }

    public static String buildBoeUrl(String r6) {
        if (r6 != null) goto L6;
        return null;
    L6:
        if (TextUtils.isEmpty(sBoeSuffix) == false) goto L8;
        return r6;
    L8:
        boolean r0 = r6.contains(sBoeSuffix);
        boolean r1 = isIP(r6);
        if (r6.startsWith("https") == false) goto L11;
        r6 = r6.replace("https", "http");
    L11:
        if (r1 == false) goto L13;
        return r6;
    L13:
        if (r6.indexOf("http") != 0) goto L23;
        if (r0 == true) goto L24;
        String r2 = new URL(r6).getHost();     // Catch: Exception -> L17
        StringBuilder r3 = new StringBuilder();     // Catch: Exception -> L17
        r3.append(r2);     // Catch: Exception -> L17
        r3.append(String.format(".%s", new Object[]{sBoeSuffix}));     // Catch: Exception -> L17
        return r6.replace(r2, r3);
    L17:
        e = move-exception;
        TTVideoEngineLog.d(e);
        return r6;
    L24:
        return r6;
    L23:
        return r6;
    }

    public static String buildHttpUrl(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
        return r2;
    L5:
        if (r2.startsWith("https") == true) goto L7;
        return r2;
    L7:
        return r2.replace("https", "http");
    }

    public static String buildHttpsUrl(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
        return r2;
    L5:
        if (r2.contains("http://127.0.0.1") == false) goto L7;
        return r2;
    L7:
        return r2.replaceAll("http:", "https:");
    }

    public static StringBuilder buildUrlEncodedQuery(Map<String, Object> r4) {
        StringBuilder r1 = new StringBuilder();
        Iterator<Map.Entry<String, Object>> r5 = r4.entrySet().iterator();
    L4:
        if (r5.hasNext() == false) goto L13;
        Map.Entry<String, Object> r2 = r5.next();
        if (TextUtils.isEmpty(r2.getKey()) == true) goto L4;
        if (r2.getValue() == null) goto L4;
        r1.append(URLEncoder.encode(r2.getKey(), "UTF-8"));     // Catch: UnsupportedEncodingException -> L11
        r1.append("=");     // Catch: UnsupportedEncodingException -> L11
        r1.append(URLEncoder.encode(String.valueOf(r2.getValue()), "UTF-8"));     // Catch: UnsupportedEncodingException -> L11
        r1.append("&");     // Catch: UnsupportedEncodingException -> L11
        goto L4
    L13:
        if (r1.length() <= 0) goto L15;
        r1.deleteCharAt(r1.length() - 1);
    L15:
        return r1;
    }

    private static String bytesToHexString(byte[] r7) {
        StringBuilder r0 = new StringBuilder();
        if (r7 != null) goto L5;
        return null;
    L5:
        if (r7.length <= 0) goto L20;
        int r1 = r7.length;
        int r3 = 0;
    L8:
        if (r3 >= r1) goto L14;
        String r4 = Integer.toHexString(r7[r3] & 255);
        if (r4.length() >= 2) goto L12;
        r0.append(0);
    L12:
        r0.append(r4);
        r3 = r3 + 1;
        goto L8
    L14:
        return r0.toString();
    L20:
        return null;
    }

    public static String computeMD5(String r3) {
        MessageDigest r0 = MessageDigest.getInstance(EncriptUtils.KEY_MD5);     // Catch: Exception -> L4
        r0.update(r3.getBytes());     // Catch: Exception -> L4
        return new BigInteger(1, r0.digest()).toString(16);
    L7:
        return r3;
    }

    public static void configBoeSuffix(String r0) {
        sBoeSuffix = r0;
    }

    public static String customBase64Decode(String r2) {
        if (r2 != null) goto L4;
        return r2;
    L4:
        if (r2.length() != 0) goto L7;
        return r2;
    L7:
        return r2.replace("$", "_").replace("@", "/").replace("#", ".");
    }

    public static String customBase64Encode(String r2) {
        if (r2 != null) goto L4;
        return r2;
    L4:
        if (r2.length() != 0) goto L7;
        return r2;
    L7:
        return r2.replace("_", "$").replace("/", "@").replace(".", "#");
    }

    public static String decodeUrl(String r2) {
        String r0 = BuildConfig.FLAVOR;
    L10:
    L8:
        return null;
    L4:
        if (r0.equals(r2) == true) goto L7;
        r0 = r2;
        r2 = URLDecoder.decode(r2, "UTF-8");     // Catch: UnsupportedEncodingException -> L8
        goto L10
    L7:
        return r2;
    }

    public static void deleteBeforeDirFiles(Context r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        String r6 = getAppFilesPath(r5);
        if (r6 != null) goto L7;
        return;
    L7:
        PolarisFileWrapper r0 = new PolarisFileWrapper(r6);
        if (r0.exists() == true) goto L10;
        return;
    L10:
        if (r0.isDirectory() == false) goto L31;
        File[] r7 = r0.listFiles();
        if (r7 != null) goto L15;
        return;
    L15:
        if (r7.length == 0) goto L32;
        int r1 = r7.length;
        int r2 = 0;
    L18:
        if (r2 >= r1) goto L33;
        File r3 = r7[r2];
        if (r3.isFile() == false) goto L24;
        if (r3.getName().matches("^[0-9]{1,15}\\.cach$") == false) goto L24;
        r3.delete();
    L24:
        r2 = r2 + 1;
        goto L18
    L33:
        return;
    L32:
        return;
    }

    public static String encodeQuery(String r1) {
        if (TextUtils.isEmpty(r1) == false) goto L9;
        return r1;
    L9:
        return Uri.encode(r1, queryStrAllowCharset);
    L7:
        return null;
    }

    public static String encodeUrl(String r1) {
        if (TextUtils.isEmpty(r1) == false) goto L9;
        return r1;
    L9:
        return URLEncoder.encode(r1, "UTF-8");
    L7:
        return null;
    }

    public static Error errorWithJson(JSONObject r6) {
        if (r6 != null) goto L10;
        return null;
    L10:
        return new Error(r6.optString("domain"), r6.optInt("code"), r6.optInt("innerCode"), r6.optString("des"));
    L7:
        th = move-exception;
        TTVideoEngineLog.e("TTVideoEngineTTHelper", "generate error fail. " + th + " " + r6);
        return null;
    }

    public static String getAppFilesPath(Context r1) {
        String r0 = mAppPath;
        if (r0 == null) goto L6;
        return r0;
    L6:
        if (r1 != null) goto L11;
        return null;
    L11:
        String r2 = r1.getApplicationContext().getFilesDir().getAbsolutePath();     // Catch: Exception -> L10
        mAppPath = r2;     // Catch: Exception -> L10
        return r2;
    L10:
        return null;
    }

    public static long getAvailableStorageSize(Context r3) {
        if (r3 != null) goto L6;
        return -1;
    L6:
        if (Environment.getDataDirectory() != null) goto L8;
        return -1;
    L8:
        return getDirectoryAvailableSize(r3.getFilesDir().getParent());
    }

    public static long getDirectoryAvailableSize(String r5) {
        StatFs r0 = new StatFs(r5);     // Catch: IllegalArgumentException -> L9
        if (isAndroidJB2() == false) goto L5;
        long r1 = r0.getBlockSizeLong();     // Catch: IllegalArgumentException -> L9
        long r3 = r0.getAvailableBlocksLong();     // Catch: IllegalArgumentException -> L9
    L8:
        return r1 * r3;
    L5:
        r1 = r0.getBlockSize();     // Catch: IllegalArgumentException -> L9
        r3 = r0.getAvailableBlocks();     // Catch: IllegalArgumentException -> L9
    L9:
        return -1;
    }

    /* JADX WARN: Not initialized variable reg: 4, insn: 0x0049: MOVE (r1 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]) (LINE:16777289), block:B:32:0x0049 */
    public static String getFileMd5(File r7) {
        FileInputStream r1 = null;
        if (r7.isFile() == true) goto L5;
        return null;
    L5:
        byte[] r2 = new byte[ChameleonContainerUtils.MAX_URL_LENGTH];
        MessageDigest r3 = MessageDigest.getInstance(EncriptUtils.KEY_MD5);     // Catch: Throwable -> L20 Exception -> L22
        PolarisFileInputStreamWrapper r4 = new PolarisFileInputStreamWrapper(r7);     // Catch: Throwable -> L20 Exception -> L22
    L46:
        int r5 = r4.read(r2, 0, ChameleonContainerUtils.MAX_URL_LENGTH);     // Catch: Exception -> L18 Throwable -> L31
        if (r5 == (-1)) goto L39;
        r3.update(r2, 0, r5);     // Catch: Exception -> L18 Throwable -> L31
        goto L46
    L39:
        r4.close();     // Catch: IOException -> L14
    L17:
        return bytesToHexString(r3.digest());
    L14:
        e = move-exception;
        e.printStackTrace();
    L18:
        e = e;
    L24:
        e.printStackTrace();     // Catch: Throwable -> L31
        if (r4 != null) goto L41;
    L30:
        return null;
    L41:
        r4.close();     // Catch: IOException -> L28
    L28:
        e = move-exception;
        e.printStackTrace();
    L31:
        th = th;
        r1 = r4;
    L33:
        if (r1 != null) goto L44;
    L38:
        throw th;
    L44:
        r1.close();     // Catch: IOException -> L36
    L36:
        e = move-exception;
        e.printStackTrace();
    L22:
        e = e;
        r4 = null;
    L20:
        th = th;
        goto L33
    }

    public static long getFreeSize(Context r3) {
        if (r3 != null) goto L6;
        return -1;
    L6:
        if (isExternalStorageWritable() == true) goto L8;
        return -1;
    L8:
        return getAvailableStorageSize(r3);
    }

    public static String getHexString(byte[] r7) {
        StringBuilder r0 = new StringBuilder();
        int r1 = r7.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L9;
        String r4 = Integer.toHexString(r7[r3] & 255);
        if (r4.length() >= 2) goto L7;
        r0.append(0);
    L7:
        r0.append(r4);
        r3 = r3 + 1;
        goto L3
    L9:
        return r0.toString();
    }

    public static float getVolume(Context r0) {
        return TTVideoEngineInternalHelper.getVolume(r0);
    }

    public static String hmacSha1(String r1) {
        byte[] r2 = JniUtils.getSettingSignature(r1);
        if (r2 != null) goto L7;
        TTVideoEngineLog.d(TAG, "hmacSha1 signature is null");
        return null;
    L7:
        return getHexString(r2);
    }

    public static boolean isBase64(String r1) {
        return Pattern.matches("^([A-Za-z0-9+/]{4})*([A-Za-z0-9+/]{4}|[A-Za-z0-9+/]{3}=|[A-Za-z0-9+/]{2}==)$", r1);
    }

    public static boolean isEmpty(List r0) {
        if (r0 != null) goto L4;
    L7:
        return true;
    L4:
        if (r0.isEmpty() == true) goto L7;
        return false;
    }

    public static boolean isIP(String r4) {
        if (r4 == null) goto L20;
        String r1 = BuildConfig.FLAVOR;
        if (r4.equals(BuildConfig.FLAVOR) == true) goto L20;
        r1 = new URL(r4).getHost();     // Catch: Exception -> L9
    L12:
        if (PatternProtector.compile("([1-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}").matcher(r1).find() == false) goto L14;
        return true;
    L14:
        int r2 = r4.indexOf("[");
        int r3 = r4.indexOf("]");
        if (r2 <= 0) goto L20;
        if (r3 <= r2) goto L20;
        if (r4.substring(r2, r3).indexOf(":") <= 0) goto L20;
        return true;
    L9:
        e = move-exception;
        TTVideoEngineLog.d(e);
    L20:
        return false;
    }

    public static boolean isStringHex(String r1) {
        if (TextUtils.isEmpty(r1) == false) goto L7;
        return false;
    L7:
        return r1.matches("^[A-Fa-f0-9]+$");
    }

    public static boolean isTranscodeUrl(String r5) {
        if (TextUtils.isEmpty(r5) == false) goto L5;
        return false;
    L5:
        TTVideoEngineLog.d("isTranscodeUrl", "----start check url:" + r5);
        String r6 = UriProtector.getQueryParameter(UriProtector.parse(r5), "btag");
        if (TextUtils.isEmpty(r6) == false) goto L9;
        TTVideoEngineLog.d("isTranscodeUrl", "get query value is null");
        return false;
    L9:
        TTVideoEngineLog.d("isTranscodeUrl", "get query value is:" + r6);
        if (isStringHex(r6) == true) goto L13;
        TTVideoEngineLog.d("isTranscodeUrl", "not hex string");
        return false;
    L13:
        BigInteger r0 = new BigInteger(r6, 16);
        BigInteger r7 = new BigInteger("80000", 16);
        if (r0.and(r7).compareTo(r7) != 0) goto L17;
        TTVideoEngineLog.d("isTranscodeUrl", "end url is transcoded");
        return true;
    L17:
        TTVideoEngineLog.d("isTranscodeUrl", "****end url is not transcoded");
        return false;
    }

    public static boolean isTranscodeUrlList(String[] r4) {
        if (r4 != null) goto L5;
    L14:
        return false;
    L5:
        if (r4.length <= 0) goto L14;
        int r1 = r4.length;
        int r2 = 0;
    L8:
        if (r2 >= r1) goto L14;
        if (isTranscodeUrl(r4[r2]) == true) goto L11;
        r2 = r2 + 1;
        goto L8
    L11:
        return true;
    }

    public static JSONObject jsonWithError(Error r3) {
        JSONObject r0 = null;
        if (r3 != null) goto L15;
        return null;
    L15:
        JSONObject r1 = new JSONObject();     // Catch: Throwable -> L10
        r1.put("domain", r3.domain);     // Catch: Throwable -> L8
        r1.put("code", r3.code);     // Catch: Throwable -> L8
        r1.put("innerCode", r3.internalCode);     // Catch: Throwable -> L8
        r1.put("des", r3.description);     // Catch: Throwable -> L8
        return r1;
    L8:
        th = th;
        r0 = r1;
    L11:
        TTVideoEngineLog.e("TTVideoEngineTTHelper", "error to json fail. " + th + " " + r0.toString());
        return r0;
    L10:
        th = th;
        goto L11
    }

    public static String md5(String r7) {
        if (TextUtils.isEmpty(r7) == false) goto L16;
        return BuildConfig.FLAVOR;
    L16:
        byte[] r8 = MessageDigest.getInstance(EncriptUtils.KEY_MD5).digest(r7.getBytes());     // Catch: NoSuchAlgorithmException -> L13
        StringBuilder r0 = new StringBuilder();     // Catch: NoSuchAlgorithmException -> L13
        int r2 = r8.length;     // Catch: NoSuchAlgorithmException -> L13
        int r3 = 0;
    L6:
        if (r3 >= r2) goto L11;
        String r4 = Integer.toHexString(r8[r3] & 255);     // Catch: NoSuchAlgorithmException -> L13
        if (r4.length() != 1) goto L10;
        r4 = DocTabPayload.DocType.UNKNOWN + r4;     // Catch: NoSuchAlgorithmException -> L13
    L10:
        r0.append(r4);     // Catch: NoSuchAlgorithmException -> L13
        r3 = r3 + 1;     // Catch: NoSuchAlgorithmException -> L13
        goto L6
    L11:
        return r0.toString();
    L13:
        e = move-exception;
        TTVideoEngineLog.d(e);
        return BuildConfig.FLAVOR;
    }

    public static int parseInt(Object r3) {
        if (r3 == null) goto L14;
        if ((r3 instanceof Integer) == false) goto L8;
        return ((Integer) r3).intValue();
    L8:
        if ((r3 instanceof String) == false) goto L12;
        return CastIntegerProtector.parseInt((String) r3);
    L12:
        throw new NumberFormatException("Can't format " + r3.getClass() + " to int");
    L14:
        throw null;
    }

    public static void recursionDeleteFile(File r4) {
        if (r4 != null) goto L5;
        return;
    L5:
        if (r4.isFile() == false) goto L9;
        r4.delete();
        return;
    L9:
        if (r4.isDirectory() == false) goto L22;
        File[] r0 = r4.listFiles();
        if (r0 != null) goto L13;
    L19:
        r4.delete();
        return;
    L13:
        if (r0.length == 0) goto L19;
        int r1 = r0.length;
        int r2 = 0;
    L16:
        if (r2 >= r1) goto L18;
        recursionDeleteFile(r0[r2]);
        r2 = r2 + 1;
        goto L16
    L18:
        r4.delete();
        return;
    }

    public static long safelyUnbox(Long r2) {
        return ((Long) nonNullElse(r2, 0L)).longValue();
    }

    public static int versionStringToInt(String r3) {
        int r0 = 0;
        if (r3 != null) goto L5;
    L19:
        return 0;
    L5:
        if (r3.isEmpty() == true) goto L19;
        String[] r4 = r3.split("\\.");
        if (r4.length > 0) goto L10;
        return 0;
    L10:
        int r1 = 0;
    L12:
        if (r0 >= r4.length) goto L18;
        if (r0 != 0) goto L16;
        r1 = CastIntegerProtector.parseInt(r4[r0]);     // Catch: Exception -> L20
    L17:
        r0 = r0 + 1;
        goto L12
    L16:
        r1 = (r1 * 100) + CastIntegerProtector.parseInt(r4[r0]);
        goto L17
    L18:
        return r1;
    }

    public static boolean isEmpty(Map r0) {
        if (r0 != null) goto L4;
    L7:
        return true;
    L4:
        if (r0.size() == 0) goto L7;
        return false;
    }

    public static boolean isEmpty(JSONArray r0) {
        if (r0 != null) goto L4;
    L7:
        return true;
    L4:
        if (r0.length() == 0) goto L7;
        return false;
    }

    public static boolean isEmpty(String[] r0) {
        if (r0 != null) goto L4;
    L7:
        return true;
    L4:
        if (r0.length == 0) goto L7;
        return false;
    }

    public static String appendQueryString(String r2, String r3) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
        return r2;
    L5:
        if (TextUtils.isEmpty(r3) == false) goto L8;
        return r2;
    L8:
        if (r2.contains(r3) == false) goto L11;
        return r2;
    L11:
        if (r2.contains("?") == true) goto L14;
        return r2 + "?" + r3;
    L14:
        return r2 + "&" + r3;
    }

    public static String base64Decode(String r2, String r3) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
        return r2;
    L5:
        if (isBase64(r2) == true) goto L16;
        return r2;
    L16:
        byte[] r4 = Base64.decode(r2, 0);     // Catch: Throwable -> L13
        if (TextUtils.isEmpty(r3) == false) goto L12;
        return new String(r4, "utf-8");
    L12:
        return JniUtils.getDecodedStrWithKey(r4, Base64.decode(r3, 0));
    L13:
        th = move-exception;
        TTVideoEngineLog.d(TAG, th.toString());
        return BuildConfig.FLAVOR;
    }

    public static String genTrackID(String r3, long r4) {
        StringBuilder r0 = new StringBuilder();
        if (TextUtils.isEmpty(r3) == true) goto L5;
        r0.append(r3);
        r0.append("T");
    L5:
        r0.append(r4);
        r0.append("T");
        r0.append(Integer.toString((int) (Math.random() * 65535.0d)));
        return r0.toString();
    }

    public static Class<?> getClzUsingPluginLoader(int r1, String r2) throws Exception {
        if (r1 < 0) goto L12;
        if (TextUtils.isEmpty(r2) == true) goto L12;
        ClassLoader r3 = TTVideoEngineConfig.getClassLoader(r1);
        if (r3 != null) goto L10;
        return INVOKESTATIC_com_ss_ttvideoengine_utils_TTHelper_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r2);
    L10:
        return INVOKESTATIC_com_ss_ttvideoengine_utils_TTHelper_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r2, true, r3);
    L12:
        throw new Exception("pluginName or/and className is empty");
    }

    public static String getParam(String r4, String r5) {
        List<String> r6 = getUrlSlices(r4, r5);
        if (r6 != null) goto L5;
    L14:
        return null;
    L5:
        if (r6.size() == 0) goto L14;
        Iterator<String> r7 = r6.iterator();
    L9:
        if (r7.hasNext() == false) goto L14;
        String r1 = r7.next();
        if (r1.startsWith(r5 + "=") == false) goto L9;
        return r1.substring(r5.length() + 1);
    }

    private static List<String> getUrlSlices(String r5, String r6) {
        ArrayList r0 = new ArrayList();
        if (TextUtils.isEmpty(r5) == false) goto L5;
        return null;
    L5:
        String[] r7 = r5.split("[?]");
        if (r7.length >= 2) goto L8;
        return null;
    L8:
        String r3 = r7[0];
        String r8 = r7[1];
        int r9 = r8.indexOf(r6 + "=");
        if (r9 != (-1)) goto L11;
        return null;
    L11:
        r0.add(r3);
        r0.add("?");
        r0.add(r8.substring(0, r9));
        int r1 = r8.indexOf("&", r9);
        if (r1 != (-1)) goto L15;
        r0.add(r8.substring(r9));
        return r0;
    L15:
        r0.add(r8.substring(r9, r1));
        r0.add(r8.substring(r1));
        return r0;
    }

    public static String keyFromFilePath(Context r1, String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L6;
        return null;
    L6:
        if (r1 == null) goto L11;
        String r3 = getAppFilesPath(r1);
        if (TextUtils.isEmpty(r3) == true) goto L11;
        r2.replace(r3, BuildConfig.FLAVOR);
    L11:
        return md5(r2);
    }

    public static String replaceHostInURL(String r2, String r3) {
        if (TextUtils.isEmpty(r2) == false) goto L7;
        return BuildConfig.FLAVOR;
    L7:
        if (TextUtils.isEmpty(r3) == false) goto L17;
        return r2;
    L17:
        String r0 = new URI(r2).getHost();     // Catch: URISyntaxException -> L14
        if (TextUtils.isEmpty(r0) == false) goto L12;
        return r2;
    L12:
        return r2.replaceFirst(r0, r3);
    L14:
        e = move-exception;
        e.printStackTrace();
        return r2;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_ss_ttvideoengine_utils_TTHelper_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r2, boolean r3, ClassLoader r4) throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class r5 = access$001(r2, r3, r4);     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r2);     // Catch: Throwable -> L8
    L7:
        return r5;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r2);
    L12:
        throw th;
    L34:
        Class r6 = access$001(r2, r3, r4);     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r2);     // Catch: Throwable -> L17
    L16:
        return r6;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r2);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r2);
    }

    public static String overrideUrlParam(String r4, String r5, String r6) {
        List<String> r0 = getUrlSlices(r4, r5);
        if (r0 != null) goto L5;
        return r4;
    L5:
        if (r0.size() == 0) goto L23;
        StringBuilder r7 = new StringBuilder();
        Iterator<String> r1 = r0.iterator();
    L9:
        if (r1.hasNext() == false) goto L15;
        String r2 = r1.next();
        if (r2.startsWith(r5 + "=") == true) goto L12;
        r7.append(r2);
        goto L9
    L12:
        r7.append(r5);
        r7.append("=");
        r7.append(r6);
        goto L9
    L15:
        return r7.toString();
    L23:
        return r4;
    }

    public static float safeGetFloat(Map<String, Object> r0, String r1, float r2) {
        if (r0 != null) goto L4;
        Object r3 = null;
    L6:
        if ((r3 instanceof Float) == true) goto L8;
        return r2;
    L8:
        return ((Float) r3).floatValue();
    L4:
        r3 = r0.get(r1);
        goto L6
    }

    public static int safeGetInt(Map<String, Object> r0, String r1, int r2) {
        if (r0 != null) goto L4;
        Object r3 = null;
    L6:
        if ((r3 instanceof Integer) == true) goto L8;
        return r2;
    L8:
        return ((Integer) r3).intValue();
    L4:
        r3 = r0.get(r1);
        goto L6
    }

    public static long safeGetLong(Map<String, Object> r0, String r1, long r2) {
        if (r0 != null) goto L4;
        Object r3 = null;
    L6:
        if ((r3 instanceof Long) == true) goto L8;
        return r2;
    L8:
        return ((Long) r3).longValue();
    L4:
        r3 = r0.get(r1);
        goto L6
    }

    public static String safeGetString(Map<String, Object> r0, String r1, String r2) {
        if (r0 != null) goto L4;
        Object r3 = null;
    L6:
        if ((r3 instanceof String) == true) goto L8;
        return r2;
    L8:
        return (String) r3;
    L4:
        r3 = r0.get(r1);
        goto L6
    }

    public static double safeParseDouble(JSONObject r0, String r1, double r2) {
        String r3 = r0.optString(r1);
        if (TextUtils.isEmpty(r3) == false) goto L10;
        return r2;
    L10:
        return CastDoubleProtector.parseDouble(r3);
    L7:
        e = move-exception;
        e.printStackTrace();
        return r2;
    }

    public static float safeParseFloat(JSONObject r0, String r1, float r2) {
        String r3 = r0.optString(r1);
        if (TextUtils.isEmpty(r3) == false) goto L10;
        return r2;
    L10:
        return CastFloatProtector.parseFloat(r3);
    L7:
        e = move-exception;
        e.printStackTrace();
        return r2;
    }
}
