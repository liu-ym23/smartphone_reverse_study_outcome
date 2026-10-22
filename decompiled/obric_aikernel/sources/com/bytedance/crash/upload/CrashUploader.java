package com.bytedance.crash.upload;

import android.os.Process;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.Global;
import com.bytedance.crash.IEncrypt;
import com.bytedance.crash.NpthCore;
import com.bytedance.crash.NpthNetworkApi;
import com.bytedance.crash.config.NetConfig;
import com.bytedance.crash.config.RuntimeConfig;
import com.bytedance.crash.constants.Constants;
import com.bytedance.crash.entity.Header;
import com.bytedance.crash.monitor.AppMonitor;
import com.bytedance.crash.monitor.MonitorManager;
import com.bytedance.crash.service.IHttpService;
import com.bytedance.crash.service.IHttpUrlConnectionInterceptor;
import com.bytedance.crash.service.IMultipartService;
import com.bytedance.crash.service.INetworkCallback;
import com.bytedance.crash.util.FileSystemUtils;
import com.bytedance.crash.util.IoUtil;
import com.bytedance.crash.util.JSONUtils;
import com.bytedance.crash.util.NpthLog;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.zip.Deflater;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import javax.net.ssl.SSLContext;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class CrashUploader {
    private static final String ALOG_LOG_TYPE = "alog";
    private static final String ALOG_SCENE_FOR_CRASH = "npth";
    static final int BUFFER_SIZE = 8192;
    private static final String CONTENT_ENCODING_DEFLATE = "deflate";
    private static final String CONTENT_ENCODING_GZIP = "gzip";
    private static final String METHOD_POST = "POST";
    private static final int MIN_COMPRESS_LENGTH = 128;
    private static final String TAG = "NPTH-CrashUpload";
    private static final String URL_PARAM_ENCRYPT = "tt_data=a";
    private static IRequestIntercept sRequestIntercept;
    private static IRequestPermission sRequestPermission;
    private static IHttpUrlConnectionInterceptor sUrlConnectionInterceptor;

    public static final enum CompressType extends Enum<CompressType> {
        private static final /* synthetic */ CompressType[] $VALUES = null;
        public static final CompressType DEFLATER = null;
        public static final CompressType GZIP = null;
        public static final CompressType NONE = null;
        final int nativeInt;

        static {
            CompressType r10 = new CompressType("NONE", 0, 0);
            NONE = r10;
            CompressType r11 = new CompressType("GZIP", 1, 1);
            GZIP = r11;
            CompressType r12 = new CompressType("DEFLATER", 2, 2);
            DEFLATER = r12;
            $VALUES = new CompressType[]{r10, r11, r12};
        }

        private CompressType(String r10, int r11, int r12) {
            super(r10, r11);
            this.nativeInt = r12;
        }

        public static CompressType valueOf(String r10) {
            return (CompressType) Enum.valueOf(CompressType.class, r10);
        }

        public static CompressType[] values() {
            return (CompressType[]) $VALUES.clone();
        }
    }

    public CrashUploader() {
    }

    private static boolean checkPermission(String r10, String r11, String r12, String r13, String r14, byte[] r15, File r16, List<String> r17) {
        if (sRequestPermission != null) goto L5;
        return true;
    L5:
        if ("POST".equals(r10) == false) goto L30;
        URL r18 = new URL(r13);     // Catch: Throwable -> L22
        String r19 = r18.getHost();     // Catch: Throwable -> L22
        String r20 = r18.getPath();     // Catch: Throwable -> L22
        ArrayList r21 = new ArrayList();     // Catch: Throwable -> L22
        if (r16 == null) goto L9;
        r21.add(r16.getAbsolutePath());     // Catch: Throwable -> L22
    L9:
        if (r17 == null) goto L14;
        Iterator<String> r22 = r17.iterator();     // Catch: Throwable -> L22
    L12:
        if (r22.hasNext() == false) goto L14;
        r21.add(r22.next());     // Catch: Throwable -> L22
    L14:
        HashMap r23 = new HashMap();     // Catch: Throwable -> L22
        r23.put("Host", r19);     // Catch: Throwable -> L22
        r23.put("POST", r20);     // Catch: Throwable -> L22
        r23.put(NetConst.KEY_CONTENT_TYPE, r11);     // Catch: Throwable -> L22
        if (r12 == null) goto L17;
        r23.put(NetConst.KEY_CONTENT_ENCODING, r12);     // Catch: Throwable -> L22
    L17:
        r23.put(NetConst.KEY_ACCEPT_ENCODING, "gzip");     // Catch: Throwable -> L22
        if (sRequestPermission.getRequestPermission(r13, r23, r15, r21) == true) goto L31;
        NpthLog.w("network request is not permitted:" + r13);     // Catch: Throwable -> L22
        return false;
    L31:
        return true;
    L22:
        th = move-exception;
        NpthLog.e(th);
        return true;
    L30:
        return true;
    }

    public static byte[] doGet(String r10) {
        return executeRequest(r10, null, "gzip", "GET", false, false).getData();
    }

    public static Response doPost(String r10, byte[] r11, CompressType r12, boolean r13) {
        if (r10 == null) goto L37;
        if (r11 == null) goto L37;
        if (NpthCore.isStopUpload() == true) goto L37;
        int r14 = r11.length;
        byte[] r15 = null;
        if (CompressType.GZIP != r12) goto L13;
        if (r14 <= 128) goto L13;
        r11 = wrapGzipData(r11);
        String r16 = "gzip";
    L11:
        String r17 = r16;
    L17:
        if (r11 == null) goto L19;
        if (r13 == false) goto L22;
        r15 = RuntimeConfig.getEncryptImpl().encrypt(r11);
    L22:
        if (r15 != null) goto L24;
        String r18 = r10;
        byte[] r19 = r11;
    L35:
        return executeRequest(r18, r19, r17, "POST", true, r13);
    L24:
        if (TextUtils.isEmpty(new URL(r10).getQuery()) == false) goto L28;
        String r110 = "?";
        if (r10.endsWith("?") == true) goto L32;
        StringBuilder r111 = new StringBuilder();
    L31:
        r111.append(r10);
        r111.append(r110);
        r10 = r111.toString();
    L32:
        r18 = r10 + URL_PARAM_ENCRYPT;
        r19 = r15;
        goto L35
    L28:
        r110 = "&";
        if (r10.endsWith("&") == true) goto L32;
        r111 = new StringBuilder();
        goto L31
    L19:
        return new Response(202);
    L13:
        if (CompressType.DEFLATER != r12) goto L16;
        if (r14 <= 128) goto L16;
        r11 = wrapDeflateData(r11);
        r16 = CONTENT_ENCODING_DEFLATE;
    L16:
        r17 = null;
    L37:
        return new Response(201);
    }

    private static Response executeRequest(String r16, byte[] r17, String r18, String r19, boolean r20, boolean r21) {
        String r10 = r16;
        NpthLog.i("CustomException", "executeRequest:upload:" + r10);
        HttpURLConnection r11 = null;
        DataOutputStream r12 = null;
        IRequestIntercept r13 = getRequestIntercept();     // Catch: Throwable -> L67
        if (r13 != null) goto L99;
    L86:
        SSLContext.getInstance("TLS").init(null, null, null);     // Catch: Throwable -> L77
    L7:
        URL r14 = new URL(r10);     // Catch: Throwable -> L67
        long r15 = NetworkDisasterManager.checkPermission(null, r14);     // Catch: Throwable -> L67
        if (r15 < 0) goto L10;
        if (r15 > 0) goto L13;
        IHttpService r22 = NpthNetworkApi.getHttpService();     // Catch: Throwable -> L67
        if (r22 == null) goto L88;
        HashMap r23 = new HashMap();     // Catch: Throwable -> L32
        if (r21 == false) goto L20;
        r23.put(NetConst.KEY_CONTENT_TYPE, "application/octet-stream;tt-data=a");     // Catch: Throwable -> L32
    L21:
        if (r18 == null) goto L23;
        r23.put(NetConst.KEY_CONTENT_ENCODING, r18);     // Catch: Throwable -> L32
    L23:
        r23.put(NetConst.KEY_ACCEPT_ENCODING, "gzip");     // Catch: Throwable -> L32
        if (r20 == false) goto L26;
        Pair<Integer, byte[]> r24 = r22.doPost(r10, r17, r23);     // Catch: Throwable -> L32
    L27:
        if (r24 != null) goto L31;
        return new Response(Constants.UPLOAD_HTTP_ERROR, "http response code ");
    L31:
        return new Response(((Integer) r24.first).intValue(), (byte[]) r24.second);
    L26:
        r24 = r22.doGet(r10, r23);     // Catch: Throwable -> L32
        goto L27
    L20:
        r23.put(NetConst.KEY_CONTENT_TYPE, NetConst.CONTENT_TYPE);     // Catch: Throwable -> L32
        goto L21
    L33:
        return new Response(Constants.UPLOAD_HTTP_ERROR, "http response code ");
    L88:
        INetworkCallback r25 = NpthNetworkApi.getNetworkCallback();     // Catch: Throwable -> L78
        if (r25 == null) goto L37;
        r25.onCallback(INetworkCallback.TYPE_URL_CONNECTION);     // Catch: Throwable -> L78
    L37:
        HttpURLConnection r26 = getUrlConnection(r14);     // Catch: Throwable -> L67
        r26.setDoOutput(r20);     // Catch: Throwable -> L65
        if (r21 == false) goto L41;
        r26.setRequestProperty(NetConst.KEY_CONTENT_TYPE, "application/octet-stream;tt-data=a");     // Catch: Throwable -> L65
    L42:
        if (r18 == null) goto L44;
        r26.setRequestProperty(NetConst.KEY_CONTENT_ENCODING, r18);     // Catch: Throwable -> L65
    L44:
        r26.setRequestProperty(NetConst.KEY_ACCEPT_ENCODING, "gzip");     // Catch: Throwable -> L65
        r26.setRequestMethod(r19);     // Catch: Throwable -> L65
        if (r17 != null) goto L47;
    L56:
        int r27 = r26.getResponseCode();     // Catch: Throwable -> L65
        Response r28 = new Response(0);     // Catch: Throwable -> L65
        r28.setServerErrorCode(r27);     // Catch: Throwable -> L65
        r28.setHeaders(r26.getHeaderFields());     // Catch: Throwable -> L65
        if (r27 != 200) goto L62;
        byte[] r29 = getResponse(r26);     // Catch: Throwable -> L65
        JSONObject r30 = new JSONObject();     // Catch: Throwable -> L65
        r30 = new JSONObject(new String(r29));     // Catch: Throwable -> L79
    L61:
        NpthLog.i("CustomException", "uploadEvent:upload:" + r30);     // Catch: Throwable -> L65
        r28.setServerJson(r30);     // Catch: Throwable -> L65
        r28.setData(r29);     // Catch: Throwable -> L65
        NetworkDisasterManager.updateNetworkState(r14, r28);     // Catch: Throwable -> L65
    L93:
        r26.disconnect();     // Catch: Exception -> L80
    L64:
        return r28;
    L62:
        NetworkDisasterManager.updateNetworkState(r14, r28);     // Catch: Throwable -> L65
        r28.setErrCode(Constants.UPLOAD_HTTP_ERROR);     // Catch: Throwable -> L65
        r28.setErrorInfo("http response code " + r27);     // Catch: Throwable -> L65
        goto L93
    L47:
        if (r17.length <= 0) goto L56;
        DataOutputStream r31 = new DataOutputStream(r26.getOutputStream());     // Catch: Throwable -> L53
        r31.write(r17);     // Catch: Throwable -> L51
        r31.flush();     // Catch: Throwable -> L51
        FileSystemUtils.close(r31);     // Catch: Throwable -> L65
    L51:
        th = th;
        r12 = r31;
    L54:
        FileSystemUtils.close(r12);     // Catch: Throwable -> L65
        throw th;     // Catch: Throwable -> L65
    L53:
        th = th;
        goto L54
    L41:
        r26.setRequestProperty(NetConst.KEY_CONTENT_TYPE, NetConst.CONTENT_TYPE);     // Catch: Throwable -> L65
    L65:
        th = th;
        r11 = r26;
    L95:
        NpthLog.e(th);     // Catch: Throwable -> L72
        Response r32 = new Response(Constants.UPLOAD_HTTP_ERROR);     // Catch: Throwable -> L72
        if (r11 != null) goto L90;
    L71:
        return r32;
    L90:
        r11.disconnect();     // Catch: Exception -> L81
    L72:
        th = move-exception;
        if (r11 != null) goto L83;
    L75:
        throw th;
    L83:
        r11.disconnect();     // Catch: Exception -> L82
        goto L75
    L13:
        return new Response(Constants.UPLOAD_DISASTER_ESCAPE);
    L10:
        return new Response(Constants.UPLOAD_DISASTER_DROP);
    L99:
        r10 = r13.requestUrlVerify(r10, r17);     // Catch: Throwable -> L76
    L67:
        th = th;
        goto L95
    }

    @Deprecated
    public static String getJavaUploadUrl() {
        return NetConfig.getJavaCrashUploadUrl();
    }

    public static Response getQuotaState(String r10, String r11) {
        return uploadCrashLog(r10, r11, false);
    }

    public static IRequestIntercept getRequestIntercept() {
        return sRequestIntercept;
    }

    private static Response getResponse(int r10, String r11) {
        Response r12 = new Response(r10);
        if (r10 == 200) goto L10;
        r12.setErrCode(Constants.UPLOAD_HTTP_ERROR);
    L10:
        JSONObject r13 = new JSONObject(r11);     // Catch: JSONException -> L7
    L8:
        r12.setServerJson(r13);
        r12.setData(r11.getBytes());
        return r12;
    L7:
        r13 = new JSONObject();
        r12.setErrCode(Constants.UPLOAD_HTTP_ERROR);
        goto L8
    }

    private static byte[] getResponse(HttpURLConnection r10) {
        InputStream r11 = null;
        InputStream r12 = r10.getInputStream();     // Catch: Throwable -> L20 Exception -> L23
    L33:
    L18:
        th = th;
        r11 = r12;
    L21:
        FileSystemUtils.close(r11);
        throw th;
    L5:
        if ("gzip".equalsIgnoreCase(r10.getContentEncoding()) == true) goto L27;
        byte[] r13 = HttpOutputStream.toByteArray(r12);     // Catch: Throwable -> L18 Exception -> L26
    L16:
        FileSystemUtils.close(r12);
        return r13;
    L27:
        GZIPInputStream r14 = new GZIPInputStream(r12);     // Catch: Throwable -> L11
        r13 = HttpOutputStream.toByteArray(r14);     // Catch: Throwable -> L9
        IoUtil.close(r14);     // Catch: Throwable -> L18 Exception -> L26
    L9:
        th = th;
    L13:
        IoUtil.close(r14);     // Catch: Throwable -> L18 Exception -> L26
        throw th;     // Catch: Throwable -> L18 Exception -> L26
    L11:
        th = th;
        r14 = null;
    L24:
        FileSystemUtils.close(r12);
        return null;
    L23:
        r12 = null;
    L20:
        th = th;
        goto L21
    }

    public static HttpURLConnection getUrlConnection(URL r10) {
        IHttpUrlConnectionInterceptor r11 = sUrlConnectionInterceptor;
        if (r11 != null) goto L6;
        return (HttpURLConnection) r10.openConnection();
    L6:
        return r11.getUrlConnection(r10);
    }

    public static void setRequestIntercept(IRequestIntercept r10) {
        sRequestIntercept = r10;
    }

    public static void setRequestPermission(IRequestPermission r10) {
        sRequestPermission = r10;
    }

    public static void setUrlConnectionInterceptor(IHttpUrlConnectionInterceptor r10) {
        sUrlConnectionInterceptor = r10;
    }

    public static boolean uploadAlogFiles(String r16, int r17, String r18, String r19, List<String> r20) {
        if (NpthCore.isStopUpload() == false) goto L5;
        return false;
    L5:
        IHttpService r10 = NpthNetworkApi.getHttpService();
        if (r10 != null) goto L52;
    L50:
        INetworkCallback r11 = NpthNetworkApi.getNetworkCallback();     // Catch: Throwable -> L45
        if (r11 == null) goto L48;
        r11.onCallback(INetworkCallback.TYPE_URL_CONNECTION);     // Catch: Throwable -> L45
    L48:
        HttpMultipart r12 = new HttpMultipart(r16, false);     // Catch: IOException -> L42
        r12.addFormField("aid", String.valueOf(r17));     // Catch: IOException -> L42
        r12.addFormField("device_id", r18);     // Catch: IOException -> L42
        r12.addFormField("os", "Android");     // Catch: IOException -> L42
        r12.addFormField("process_name", r19);     // Catch: IOException -> L42
        Iterator<String> r13 = r20.iterator();     // Catch: IOException -> L42
    L28:
        if (r13.hasNext() == false) goto L32;
        File r14 = new File(r13.next());     // Catch: IOException -> L42
        if (r14.exists() == false) goto L28;
        HashMap r15 = new HashMap();     // Catch: IOException -> L42
        r15.put("logtype", ALOG_LOG_TYPE);     // Catch: IOException -> L42
        r15.put("scene", "npth");     // Catch: IOException -> L42
        r12.addFilePart(r14, r15);     // Catch: IOException -> L42
        goto L28
    L32:
        r12.finish(ALOG_LOG_TYPE);     // Catch: IOException -> L42
        JSONObject r21 = r12.getResponse().getServerJson();     // Catch: Exception -> L46
        if (r21 != null) goto L36;
        return false;
    L36:
        if (r21.optInt("errno", -1) != 200) goto L41;
        return true;
    L41:
        return false;
    L42:
        e = move-exception;
        e.printStackTrace();
        return false;
    L52:
        IMultipartService r22 = r10.buildMultipartService(r16, "UTF-8", false);     // Catch: Throwable -> L47
        if (r22 == null) goto L50;
        r22.addFormField("aid", String.valueOf(r17));     // Catch: Throwable -> L47
        r22.addFormField("device_id", r18);     // Catch: Throwable -> L47
        r22.addFormField("os", "Android");     // Catch: Throwable -> L47
        r22.addFormField("process_name", r19);     // Catch: Throwable -> L47
        Iterator<String> r23 = r20.iterator();     // Catch: Throwable -> L47
    L11:
        if (r23.hasNext() == false) goto L15;
        File r24 = new File(r23.next());     // Catch: Throwable -> L47
        if (r24.exists() == false) goto L11;
        HashMap r25 = new HashMap();     // Catch: Throwable -> L47
        r25.put("logtype", ALOG_LOG_TYPE);     // Catch: Throwable -> L47
        r25.put("scene", "npth");     // Catch: Throwable -> L47
        r22.addFilePart(r24, r25);     // Catch: Throwable -> L47
        goto L11
    L15:
        Pair<Integer, String> r26 = r22.finish();     // Catch: Throwable -> L47
        if (r26 == null) goto L22;
        if (new JSONObject((String) r26.second).optInt("errno", -1) != 200) goto L22;
        return true;
    L22:
        return false;
    }

    public static boolean uploadCommonFile(File r16) {
        if (r16 != null) goto L5;
        return false;
    L5:
        if (r16.exists() == false) goto L52;
        AppMonitor r10 = MonitorManager.getAppMonitor();
        if (r10 != null) goto L10;
        return false;
    L10:
        String r11 = NetConfig.getAlogUploadUrl();
        String r12 = r10.getAppId();
        String r13 = r10.getDeviceId(NetConst.NOT_ENCRYPT_VERISON_CODE);
        String r14 = Global.getApplication().getPackageName();
        IHttpService r15 = NpthNetworkApi.getHttpService();
        if (r15 != null) goto L48;
    L39:
        INetworkCallback r17 = NpthNetworkApi.getNetworkCallback();     // Catch: Throwable -> L36
        if (r17 == null) goto L43;
        r17.onCallback(INetworkCallback.TYPE_URL_CONNECTION);     // Catch: Throwable -> L36
    L43:
        HttpMultipart r18 = new HttpMultipart(r11, false);     // Catch: Throwable -> L32
        r18.addFormField("aid", r12);     // Catch: Throwable -> L32
        r18.addFormField("device_id", r13);     // Catch: Throwable -> L32
        r18.addFormField("os", "Android");     // Catch: Throwable -> L32
        r18.addFormField("process_name", r14);     // Catch: Throwable -> L32
        HashMap r19 = new HashMap();     // Catch: Throwable -> L32
        r19.put("logtype", "common");     // Catch: Throwable -> L32
        r19.put("scene", "common");     // Catch: Throwable -> L32
        r18.addFilePart(r16, r19);     // Catch: Throwable -> L32
        r18.finish("custom_common_file");     // Catch: Throwable -> L32
        if (r18.getResponse().isSuccess() == false) goto L30;
        return true;
    L30:
        return false;
    L53:
        return false;
    L32:
        th = move-exception;
        th.printStackTrace();
        return false;
    L48:
        IMultipartService r20 = r15.buildMultipartService(r11, "UTF-8", false);     // Catch: Throwable -> L38
        r20.addFormField("aid", r12);     // Catch: Throwable -> L38
        r20.addFormField("device_id", r13);     // Catch: Throwable -> L38
        r20.addFormField("os", "Android");     // Catch: Throwable -> L38
        r20.addFormField("process_name", r14);     // Catch: Throwable -> L38
        HashMap r21 = new HashMap();     // Catch: Throwable -> L38
        r21.put("logtype", "common");     // Catch: Throwable -> L38
        r21.put("scene", "common");     // Catch: Throwable -> L38
        r20.addFilePart(r16, r21);     // Catch: Throwable -> L38
        goto L39
    L17:
        if (new JSONObject((String) r20.finish().second).optInt("errno", -1) != 200) goto L39;
        return true;
    L20:
        return false;
    L50:
        return false;
    L52:
        return false;
    }

    public static boolean uploadCommonFilesZip(File r10) {
        AppMonitor r11 = MonitorManager.getAppMonitor();
        if (r11 != null) goto L7;
        return false;
    L7:
        return uploadCommonFilesZip(NetConfig.getAlogUploadUrl(), r11.getAppId(), r11.getDeviceId(NetConst.NOT_ENCRYPT_VERISON_CODE), Global.getApplication().getPackageName(), r10);
    }

    public static boolean uploadCommonFilesZip(String r22, String r23, String r24, String r25, File r26) {
        if (NpthCore.isStopUpload() == false) goto L68;
        return false;
    L68:
        JSONObject r10 = new JSONObject();     // Catch: Throwable -> L18
        r10.put("aid", r23);     // Catch: Throwable -> L18
        r10.put("device_id", r24);     // Catch: Throwable -> L18
        r10.put("os", "Android");     // Catch: Throwable -> L18
        r10.put("process_name", r25);     // Catch: Throwable -> L18
        String r20 = "aid";
        String r21 = "device_id";
        String r17 = " ";
        String r13 = "os";
        if (checkPermission("POST", "multipart/form-data", null, r22, r10.toString(), null, r26, null) == true) goto L12;
        return false;
    L12:
        boolean r11 = false;
        if (NetworkDisasterManager.checkPermission(r23, new URL(r22)) == 0) goto L19;
        return true;
    L19:
        IHttpService r12 = NpthNetworkApi.getHttpService();
        if (r12 != null) goto L54;
        String r14 = r20;
        String r15 = r21;
        INetworkCallback r16 = NpthNetworkApi.getNetworkCallback();     // Catch: Throwable -> L52
        if (r16 == null) goto L35;
        String r27 = "errno";
        r16.onCallback(INetworkCallback.TYPE_URL_CONNECTION);     // Catch: Throwable -> L50
    L64:
        HttpMultipart r18 = new HttpMultipart(r22, false);     // Catch: Throwable -> L46
        r18.addFormField(r14, r23);     // Catch: Throwable -> L46
        r18.addFormField(r15, r24);     // Catch: Throwable -> L46
        r18.addFormField(r13, "Android");     // Catch: Throwable -> L46
        r18.addFormField("process_name", r25);     // Catch: Throwable -> L46
        StringBuilder r19 = new StringBuilder();     // Catch: Throwable -> L46
        r19.append("upload common file ");     // Catch: Throwable -> L46
        r19.append(r23);     // Catch: Throwable -> L46
        String r28 = r17;
        r19.append(r28);     // Catch: Throwable -> L46
        r19.append(r24);     // Catch: Throwable -> L46
        r19.append(r28);     // Catch: Throwable -> L46
        r19.append(r25);     // Catch: Throwable -> L46
        NpthLog.i(r19.toString());     // Catch: Throwable -> L46
        if (r26.exists() == false) goto L39;
        HashMap r29 = new HashMap();     // Catch: Throwable -> L46
        r29.put("logtype", "common");     // Catch: Throwable -> L46
        r29.put("scene", "common");     // Catch: Throwable -> L46
        r18.addFilePart(r26, "customFile.zip", r29);     // Catch: Throwable -> L46
    L39:
        r18.finish("custom_common_zip");     // Catch: Throwable -> L46
        if (r18.getResponse().getServerJson().optInt(r27, -1) != 200) goto L44;
        return true;
    L44:
        return false;
    L70:
        return false;
    L46:
        th = move-exception;
        th.printStackTrace();
        return false;
    L35:
        r27 = "errno";
        goto L64
    L54:
        IMultipartService r30 = r12.buildMultipartService(r22, "UTF-8", r11);     // Catch: Throwable -> L53
        r30.addFormField(r20, r23);     // Catch: Throwable -> L53
        r30.addFormField(r21, r24);     // Catch: Throwable -> L53
        r30.addFormField(r13, "Android");     // Catch: Throwable -> L53
        r30.addFormField("process_name", r25);     // Catch: Throwable -> L53
        if (r26.exists() == false) goto L24;
        HashMap r31 = new HashMap();     // Catch: Throwable -> L53
        r31.put("logtype", "common");     // Catch: Throwable -> L53
        r31.put("scene", "common");     // Catch: Throwable -> L53
        r30.addFilePart(r26, "customFile.zip", r31);     // Catch: Throwable -> L53
    L24:
        Pair<Integer, String> r32 = r30.finish();     // Catch: Throwable -> L53
        if (getResponse(((Integer) r32.first).intValue(), (String) r32.second).getServerJson().optInt("errno", -1) != 200) goto L28;
        return true;
    L28:
        return r11;
    L17:
        r11 = false;
    L18:
        r11 = false;
        r20 = "aid";
        r21 = "device_id";
        r17 = " ";
        r13 = "os";
        goto L19
    }

    public static boolean uploadCoreFile(String r10, String r11, String r12, String r13, File r14) {
        IHttpService r15 = NpthNetworkApi.getHttpService();
        if (r15 == null) goto L33;
        IMultipartService r16 = r15.buildMultipartService(r11, "UTF-8", false);     // Catch: Throwable -> L8
        if (r16 == null) goto L33;
        r16.addFormField("data", r13);     // Catch: Throwable -> L8
        r16.addFormField("header", r12);     // Catch: Throwable -> L8
        r16.addFilePart("file", r14);     // Catch: Throwable -> L8
        r16.finish();     // Catch: Throwable -> L8
        return true;
    L8:
        return false;
    L33:
        INetworkCallback r17 = NpthNetworkApi.getNetworkCallback();     // Catch: Throwable -> L26
        if (r17 == null) goto L29;
        r17.onCallback(INetworkCallback.TYPE_URL_CONNECTION);     // Catch: Throwable -> L26
    L29:
        HttpMultipart r18 = new HttpMultipart(r11, false);     // Catch: IOException -> L23
        r18.addFormField("data", r13);     // Catch: IOException -> L23
        r18.addFormField("header", r12);     // Catch: IOException -> L23
        r18.addFilePart("file", r14);     // Catch: IOException -> L23
        r18.finish(r10);     // Catch: IOException -> L23
        Response r19 = r18.getResponse();     // Catch: Exception -> L20
        JSONObject r20 = r19.getServerJson();     // Catch: Exception -> L20
        if (r20 != null) goto L17;
        return false;
    L17:
        if ("success".equals(r20.getString("message")) == true) goto L22;
        NpthLog.w("corefile upload err msg=" + r19);     // Catch: Exception -> L20
        return false;
    L22:
        return true;
    L20:
        e = move-exception;
        e.printStackTrace();
        NpthLog.w("corefile responses err" + e);
    L23:
        e = move-exception;
        e.printStackTrace();
        NpthLog.w("corefile upload err" + e);
        return false;
    }

    public static Response uploadCrashLog(String r10, String r11, boolean r12) {
    L11:
        th = move-exception;
        NpthLog.w(th);
        return new Response(Constants.UPLOAD_HTTP_ERROR, th);
    L3:
        if (TextUtils.isEmpty(r11) == true) goto L10;
        if (TextUtils.isEmpty(r10) == true) goto L10;
        return doPost(r10, r11.getBytes(), CompressType.GZIP, r12);
    L10:
        return new Response(201);
    }

    public static Response uploadCrashLogWithAttachment(String r10, String r11, String r12, @NonNull List<File> r13) {
        NpthLog.i("upload crashType " + r10);
        NpthLog.i("upload url " + r11);
        Iterator<File> r14 = r13.iterator();
    L4:
        if (r14.hasNext() == false) goto L7;
        NpthLog.i("upload attachments " + r14.next().getAbsolutePath());
        goto L4
    L7:
        if (NpthCore.isStopUpload() == false) goto L44;
        return new Response(201);
    L44:
        long r15 = NetworkDisasterManager.checkPermission(null, new URL(r11));     // Catch: IOException -> L35
        if (r15 < 0) goto L14;
        if (r15 > 0) goto L17;
        IHttpService r16 = NpthNetworkApi.getHttpService();     // Catch: IOException -> L35
        if (r16 != null) goto L45;
        INetworkCallback r17 = NpthNetworkApi.getNetworkCallback();     // Catch: Throwable -> L39
        if (r17 == null) goto L33;
        r17.onCallback(INetworkCallback.TYPE_URL_CONNECTION);     // Catch: Throwable -> L39
    L33:
        HttpMultipart r18 = new HttpMultipart(UploaderUrl.urlAppendParam(r11, "have_dump=true&encrypt=true"), true);     // Catch: IOException -> L35
        r18.addFormField("json", r12, true);     // Catch: IOException -> L35
        r18.addFilePartAsZip("file", r13);     // Catch: IOException -> L35
        r18.finish(r10);     // Catch: IOException -> L35
        Response r19 = r18.getResponse();     // Catch: IOException -> L35
        NpthLog.i(TAG, "uploadCrashLogWithAttachment:" + r10 + " success");     // Catch: IOException -> L35
        return r19;
    L45:
        byte[] r20 = r12.getBytes();     // Catch: Exception -> L28
        IEncrypt r21 = RuntimeConfig.getEncryptImpl();     // Catch: Exception -> L28
        if (r21 == null) goto L24;
        r20 = r21.encrypt(r20);     // Catch: Exception -> L28
        String r22 = UploaderUrl.urlAppendParam(r11, "have_dump=true&encrypt=true");     // Catch: Exception -> L28
    L25:
        IMultipartService r23 = r16.buildMultipartService(r22, "UTF-8", true);     // Catch: Exception -> L28
        r23.addFormField("json", r20);     // Catch: Exception -> L28
        r23.addGZIPFilePart("file", r13);     // Catch: Exception -> L28
        Pair<Integer, String> r24 = r23.finish();     // Catch: Exception -> L28
        Response r25 = getResponse(((Integer) r24.first).intValue(), (String) r24.second);     // Catch: Exception -> L28
        NetworkDisasterManager.updateNetworkState(new URL(r22), r25);     // Catch: Throwable -> L38
    L27:
        return r25;
        goto L29
    L24:
        r22 = UploaderUrl.urlAppendParam(r11, "have_dump=true");     // Catch: Exception -> L28
    L29:
        return new Response(Constants.UPLOAD_HTTP_ERROR);
    L17:
        return new Response(Constants.UPLOAD_DISASTER_ESCAPE);
    L14:
        return new Response(Constants.UPLOAD_DISASTER_DROP);
    L35:
        e = move-exception;
        e.printStackTrace();
        NpthLog.w("err upload crash log " + e);
        return new Response(Constants.UPLOAD_HTTP_ERROR);
    }

    public static boolean uploadEvent(String r10, JSONArray r11) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
    L11:
        return false;
    L5:
        if (JSONUtils.isEmpty(r11) == true) goto L11;
        return doPost(r10, r11.toString().getBytes(), CompressType.GZIP, true).isSuccess();
    L9:
        th = move-exception;
        NpthLog.w(th);
        goto L11
    }

    public static boolean uploadEvent(String r10, JSONObject r11) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
    L11:
        return false;
    L5:
        if (JSONUtils.isEmpty(r11) == true) goto L11;
        return doPost(r10, r11.toString().getBytes(), CompressType.GZIP, true).isSuccess();
    L9:
        th = move-exception;
        NpthLog.w(th);
        goto L11
    }

    @Deprecated
    public static Response uploadJavaCrashLog(String r10, String r11) {
        if (doPost(r10, r11.toString().getBytes(), CompressType.GZIP, true).isSuccess() == false) goto L8;
        return new Response(0);
    L8:
        return new Response(Constants.UPLOAD_HTTP_ERROR);
    L10:
        return new Response(Constants.UPLOAD_HTTP_ERROR);
    }

    @Deprecated
    public static Response uploadNativeCrashLog(String r10, String r11, File... r12) {
        ArrayList r13 = new ArrayList();
        int r14 = r12.length;
        int r15 = 0;
    L3:
        if (r15 >= r14) goto L6;
        r13.add(r12[r15]);
        r15 = r15 + 1;
        goto L3
    L6:
        if (uploadCrashLogWithAttachment("unknown_old", r10, r11, r13).isSuccess() == false) goto L10;
        return new Response(0);
    L10:
        return new Response(Constants.UPLOAD_HTTP_ERROR);
    }

    public static boolean uploadNativeExceptionLog(String r10, String r11, File... r12) {
        ArrayList r13 = new ArrayList();
        int r14 = r12.length;
        int r15 = 0;
    L3:
        if (r15 >= r14) goto L6;
        r13.add(r12[r15]);
        r15 = r15 + 1;
        goto L3
    L6:
        return uploadCrashLogWithAttachment("ensure_zip", r10, r11, r13).isSuccess();
    }

    public static boolean uploadRaphealFile(File r10) {
        AppMonitor r11 = MonitorManager.getAppMonitor();     // Catch: JSONException -> L4
        long r12 = new Date(r10.lastModified()).getTime();     // Catch: JSONException -> L4
        int r13 = Process.myPid();     // Catch: JSONException -> L4
        return uploadRawFile("raphael", NetConfig.getNativeMemUrl(), Header.createEventHeader(r11, r12, CrashType.ENSURE, r13).getJson().toString(), new JSONObject().put(Constants.EVENT_TYPE, "raphael_file").put("timestamp", System.currentTimeMillis()).toString(), r10);
    L4:
        return false;
    }

    public static boolean uploadRawFile(String r10, String r11, String r12, String r13, File r14) {
        IHttpService r15 = NpthNetworkApi.getHttpService();
        if (r15 == null) goto L33;
        IMultipartService r16 = r15.buildMultipartService(r11, "UTF-8", false);     // Catch: Throwable -> L8
        if (r16 == null) goto L33;
        r16.addFormField("data", r13);     // Catch: Throwable -> L8
        r16.addFormField("header", r12);     // Catch: Throwable -> L8
        r16.addFilePart("file", r14);     // Catch: Throwable -> L8
        r16.finish();     // Catch: Throwable -> L8
        return true;
    L8:
        return false;
    L33:
        INetworkCallback r17 = NpthNetworkApi.getNetworkCallback();     // Catch: Throwable -> L26
        if (r17 == null) goto L31;
        r17.onCallback(INetworkCallback.TYPE_URL_CONNECTION);     // Catch: Throwable -> L26
    L31:
        HttpMultipart r18 = new HttpMultipart(r11, false);     // Catch: IOException -> L23
        r18.addFormField("data", r13);     // Catch: IOException -> L23
        r18.addFormField("header", r12);     // Catch: IOException -> L23
        r18.addFilePart("file", r14);     // Catch: IOException -> L23
        r18.finish(r10);     // Catch: IOException -> L23
        Response r19 = r18.getResponse();     // Catch: Exception -> L20
        JSONObject r20 = r19.getServerJson();     // Catch: Exception -> L20
        if (r20 != null) goto L17;
        return false;
    L17:
        if ("success".equals(r20.getString("message")) == true) goto L22;
        NpthLog.w("corefile upload err msg=" + r19);     // Catch: Exception -> L20
        return false;
    L22:
        return true;
    L20:
        e = move-exception;
        NpthLog.w("corefile responses err" + e);
    L23:
        e = move-exception;
        NpthLog.w("corefile upload err" + e);
        return false;
    }

    private static byte[] wrapDeflateData(byte[] r10) {
        ByteArrayOutputStream r11 = new ByteArrayOutputStream(8192);
        Deflater r12 = new Deflater();
        r12.setInput(r10);
        r12.finish();
        byte[] r13 = new byte[8192];
    L4:
        if (r12.finished() == true) goto L6;
        r11.write(r13, 0, r12.deflate(r13));
        goto L4
    L6:
        r12.end();
        return r11.toByteArray();
    }

    private static byte[] wrapGzipData(byte[] r10) {
        ByteArrayOutputStream r11 = new ByteArrayOutputStream(8192);
        GZIPOutputStream r12 = new GZIPOutputStream(r11);
        r12.write(r10);     // Catch: Throwable -> L6
        r12.close();
        return r11.toByteArray();
    L6:
        th = move-exception;
        NpthLog.w(th);     // Catch: Throwable -> L10
        r12.close();
        return null;
    L10:
        th = move-exception;
        r12.close();
        throw th;
    }
}
