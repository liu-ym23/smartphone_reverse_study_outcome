package com.bytedance.crash.upload;

import android.app.Application;
import android.os.Process;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.bdlocation.client.LocationInfoConst;
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
import com.bytedance.retrofit2.HttpMethodContrants;
import com.bytedance.rpc.internal.RpcUtils;
import com.obric.memorydata.memory.ui.automemory.settings.MemoryInfoSectionEditActivity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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

/* JADX INFO: loaded from: classes2.dex */
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
            CompressType r0 = new CompressType("NONE", 0, 0);
            NONE = r0;
            CompressType r1 = new CompressType("GZIP", 1, 1);
            GZIP = r1;
            CompressType r3 = new CompressType("DEFLATER", 2, 2);
            DEFLATER = r3;
            $VALUES = new CompressType[]{r0, r1, r3};
        }

        private CompressType(String r1, int r2, int r3) {
            super(r1, r2);
            this.nativeInt = r3;
        }

        public static CompressType valueOf(String r2) {
            return (CompressType) ZeusTransformUtils.preCheckCast(Enum.valueOf(CompressType.class, r2), CompressType.class, "com.obric.memorydata.plugin");
        }

        public static CompressType[] values() {
            return (CompressType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), CompressType[].class, "com.obric.memorydata.plugin");
        }
    }

    public CrashUploader() {
    }

    private static boolean checkPermission(String r4, String r5, String r6, String r7, String r8, byte[] r9, File r10, List<String> r11) {
        List r12 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
        if (sRequestPermission != null) goto L5;
        return true;
    L5:
        if ("POST".equals(r4) == false) goto L30;
        URL r13 = new URL(r7);     // Catch: Throwable -> L22
        String r1 = r13.getHost();     // Catch: Throwable -> L22
        String r14 = r13.getPath();     // Catch: Throwable -> L22
        ArrayList r2 = new ArrayList();     // Catch: Throwable -> L22
        if (r10 == null) goto L9;
        r2.add(r10.getAbsolutePath());     // Catch: Throwable -> L22
    L9:
        if (r12 == null) goto L14;
        Iterator r15 = r12.iterator();     // Catch: Throwable -> L22
    L12:
        if (r15.hasNext() == false) goto L14;
        r2.add((String) ZeusTransformUtils.preCheckCast(r15.next(), String.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L22
    L14:
        HashMap r16 = new HashMap();     // Catch: Throwable -> L22
        r16.put("Host", r1);     // Catch: Throwable -> L22
        r16.put("POST", r14);     // Catch: Throwable -> L22
        r16.put(NetConst.KEY_CONTENT_TYPE, r5);     // Catch: Throwable -> L22
        if (r6 == null) goto L17;
        r16.put(NetConst.KEY_CONTENT_ENCODING, r6);     // Catch: Throwable -> L22
    L17:
        r16.put(NetConst.KEY_ACCEPT_ENCODING, "gzip");     // Catch: Throwable -> L22
        if (sRequestPermission.getRequestPermission(r7, r16, r9, r2) == true) goto L31;
        NpthLog.w("network request is not permitted:" + r7);     // Catch: Throwable -> L22
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

    public static byte[] doGet(String r6) {
        return executeRequest(r6, null, "gzip", HttpMethodContrants.GET, false, false).getData();
    }

    public static Response doPost(String r10, byte[] r11, CompressType r12, boolean r13) {
        if (r10 == null) goto L37;
        if (r11 == null) goto L37;
        if (NpthCore.isStopUpload() == true) goto L37;
        int r0 = r11.length;
        byte[] r3 = null;
        if (CompressType.GZIP != r12) goto L13;
        if (r0 <= 128) goto L13;
        r11 = wrapGzipData(r11);
        String r14 = "gzip";
    L11:
        String r6 = r14;
    L17:
        if (r11 == null) goto L19;
        if (r13 == false) goto L22;
        r3 = RuntimeConfig.getEncryptImpl().encrypt(r11);
    L22:
        if (r3 != null) goto L24;
        String r4 = r10;
        byte[] r5 = r11;
    L35:
        return executeRequest(r4, r5, r6, "POST", true, r13);
    L24:
        if (TextUtils.isEmpty(new URL(r10).getQuery()) == false) goto L28;
        String r15 = "?";
        if (r10.endsWith("?") == true) goto L32;
        StringBuilder r16 = new StringBuilder();
    L31:
        r10 = r16.append(r10).append(r15).toString();
    L32:
        r4 = r10 + URL_PARAM_ENCRYPT;
        r5 = r3;
        goto L35
    L28:
        r15 = "&";
        if (r10.endsWith("&") == true) goto L32;
        r16 = new StringBuilder();
        goto L31
    L19:
        return new Response(202);
    L13:
        if (CompressType.DEFLATER != r12) goto L16;
        if (r0 <= 128) goto L16;
        r11 = wrapDeflateData(r11);
        r14 = CONTENT_ENCODING_DEFLATE;
    L16:
        r6 = null;
    L37:
        return new Response(201);
    }

    private static Response executeRequest(String r16, byte[] r17, String r18, String r19, boolean r20, boolean r21) {
        String r0 = r16;
        NpthLog.i("CustomException", "executeRequest:upload:" + r0);
        HttpURLConnection r7 = null;
        IRequestIntercept r8 = getRequestIntercept();     // Catch: Throwable -> L72
        if (r8 == null) goto L107;
        r0 = r8.requestUrlVerify(r0, r17);     // Catch: Throwable -> L82
    L107:
        SSLContext.getInstance("TLS").init(null, null, null);     // Catch: Throwable -> L83
    L7:
        URL r9 = new URL(r0);     // Catch: Throwable -> L72
        long r10 = NetworkDisasterManager.checkPermission(null, r9);     // Catch: Throwable -> L72
        if (r10 < 0) goto L11;
        if (r10 > 0) goto L16;
        IHttpService r11 = NpthNetworkApi.getHttpService();     // Catch: Throwable -> L72
        if (r11 != null) goto L105;
        INetworkCallback r1 = NpthNetworkApi.getNetworkCallback();     // Catch: Throwable -> L84
        if (r1 == null) goto L40;
        r1.onCallback(INetworkCallback.TYPE_URL_CONNECTION);     // Catch: Throwable -> L84
    L40:
        HttpURLConnection r4 = getUrlConnection(r9);     // Catch: Throwable -> L72
        r4.setDoOutput(r20);     // Catch: Throwable -> L70
        if (r21 == false) goto L44;
        r4.setRequestProperty(NetConst.KEY_CONTENT_TYPE, "application/octet-stream;tt-data=a");     // Catch: Throwable -> L70
    L45:
        if (r18 == null) goto L47;
        r4.setRequestProperty(NetConst.KEY_CONTENT_ENCODING, r18);     // Catch: Throwable -> L70
    L47:
        r4.setRequestProperty(NetConst.KEY_ACCEPT_ENCODING, "gzip");     // Catch: Throwable -> L70
        r4.setRequestMethod(r19);     // Catch: Throwable -> L70
        if (r17 != null) goto L50;
    L60:
        int r2 = r4.getResponseCode();     // Catch: Throwable -> L70
        Response r3 = new Response(0);     // Catch: Throwable -> L70
        r3.setServerErrorCode(r2);     // Catch: Throwable -> L70
        r3.setHeaders(r4.getHeaderFields());     // Catch: Throwable -> L70
        if (r2 != 200) goto L66;
        byte[] r5 = getResponse(r4);     // Catch: Throwable -> L70
        JSONObject r6 = new JSONObject();     // Catch: Throwable -> L70
        r6 = new JSONObject(new String(r5));     // Catch: Throwable -> L85
    L65:
        NpthLog.i("CustomException", "uploadEvent:upload:" + r6);     // Catch: Throwable -> L70
        r3.setServerJson(r6);     // Catch: Throwable -> L70
        r3.setData(r5);     // Catch: Throwable -> L70
        NetworkDisasterManager.updateNetworkState(r9, r3);     // Catch: Throwable -> L70
    L67:
        if (r4 != null) goto L97;
    L69:
        return r3;
    L97:
        r4.disconnect();     // Catch: Exception -> L86
        goto L69
    L66:
        NetworkDisasterManager.updateNetworkState(r9, r3);     // Catch: Throwable -> L70
        r3.setErrCode(Constants.UPLOAD_HTTP_ERROR);     // Catch: Throwable -> L70
        r3.setErrorInfo("http response code " + r2);     // Catch: Throwable -> L70
        goto L67
    L50:
        if (r17.length <= 0) goto L60;
        DataOutputStream r12 = new DataOutputStream(r4.getOutputStream());     // Catch: Throwable -> L56
        r12.write(r17);     // Catch: Throwable -> L54
        r12.flush();     // Catch: Throwable -> L54
        FileSystemUtils.close(r12);     // Catch: Throwable -> L70
    L54:
        th = th;
        DataOutputStream r13 = r12;
    L58:
        FileSystemUtils.close(r13);     // Catch: Throwable -> L70
        throw th;     // Catch: Throwable -> L70
    L56:
        th = th;
        r13 = null;
        goto L58
    L44:
        r4.setRequestProperty(NetConst.KEY_CONTENT_TYPE, "application/json; charset=utf-8");     // Catch: Throwable -> L70
    L70:
        th = th;
        r7 = r4;
    L93:
        NpthLog.e(th);     // Catch: Throwable -> L78
        Response r14 = new Response(Constants.UPLOAD_HTTP_ERROR);     // Catch: Throwable -> L78
        if (r7 != null) goto L109;
    L77:
        return r14;
    L109:
        r7.disconnect();     // Catch: Exception -> L87
    L78:
        th = move-exception;
        if (r7 != null) goto L91;
    L81:
        throw th;
    L91:
        r7.disconnect();     // Catch: Exception -> L88
        goto L81
    L105:
        HashMap r15 = new HashMap();     // Catch: Throwable -> L35
        if (r21 == false) goto L23;
        r15.put(NetConst.KEY_CONTENT_TYPE, "application/octet-stream;tt-data=a");     // Catch: Throwable -> L35
    L24:
        if (r18 == null) goto L26;
        r15.put(NetConst.KEY_CONTENT_ENCODING, r18);     // Catch: Throwable -> L35
    L26:
        r15.put(NetConst.KEY_ACCEPT_ENCODING, "gzip");     // Catch: Throwable -> L35
        if (r20 == false) goto L29;
        Pair<Integer, byte[]> r22 = r11.doPost(r0, r17, r15);     // Catch: Throwable -> L35
    L30:
        if (r22 != null) goto L34;
        return new Response(Constants.UPLOAD_HTTP_ERROR, "http response code ");
    L34:
        return new Response(((Integer) ZeusTransformUtils.preCheckCast(r22.first, Integer.class, "com.obric.memorydata.plugin")).intValue(), (byte[]) ZeusTransformUtils.preCheckCast(r22.second, byte[].class, "com.obric.memorydata.plugin"));
    L29:
        r22 = r11.doGet(r0, r15);     // Catch: Throwable -> L35
        goto L30
    L23:
        r15.put(NetConst.KEY_CONTENT_TYPE, "application/json; charset=utf-8");     // Catch: Throwable -> L35
        goto L24
    L36:
        return new Response(Constants.UPLOAD_HTTP_ERROR, "http response code ");
    L16:
        return new Response(Constants.UPLOAD_DISASTER_ESCAPE);
    L11:
        return new Response(Constants.UPLOAD_DISASTER_DROP);
    L12:
        th = th;
    L72:
        th = th;
        r7 = null;
        goto L93
    }

    @Deprecated
    public static String getJavaUploadUrl() {
        return NetConfig.getJavaCrashUploadUrl();
    }

    public static Response getQuotaState(String r1, String r2) {
        return uploadCrashLog(r1, r2, false);
    }

    public static IRequestIntercept getRequestIntercept() {
        return sRequestIntercept;
    }

    private static Response getResponse(int r3, String r4) {
        Response r0 = new Response(r3);
        if (r3 == 200) goto L10;
        r0.setErrCode(Constants.UPLOAD_HTTP_ERROR);
    L10:
        JSONObject r5 = new JSONObject(r4);     // Catch: JSONException -> L7
    L8:
        r0.setServerJson(r5);
        r0.setData(r4.getBytes());
        return r0;
    L7:
        r5 = new JSONObject();
        r0.setErrCode(Constants.UPLOAD_HTTP_ERROR);
        goto L8
    }

    private static byte[] getResponse(HttpURLConnection r3) {
        InputStream r0 = null;
        InputStream r1 = r3.getInputStream();     // Catch: Throwable -> L20 Exception -> L23
    L33:
    L18:
        th = th;
        r0 = r1;
    L21:
        FileSystemUtils.close(r0);
        throw th;
    L5:
        if ("gzip".equalsIgnoreCase(r3.getContentEncoding()) == true) goto L27;
        byte[] r2 = HttpOutputStream.toByteArray(r1);     // Catch: Throwable -> L18 Exception -> L26
    L16:
        FileSystemUtils.close(r1);
        return r2;
    L27:
        GZIPInputStream r4 = new GZIPInputStream(r1);     // Catch: Throwable -> L11
        r2 = HttpOutputStream.toByteArray(r4);     // Catch: Throwable -> L9
        IoUtil.close(r4);     // Catch: Throwable -> L18 Exception -> L26
    L9:
        th = th;
    L13:
        IoUtil.close(r4);     // Catch: Throwable -> L18 Exception -> L26
        throw th;     // Catch: Throwable -> L18 Exception -> L26
    L11:
        th = th;
        r4 = null;
    L24:
        FileSystemUtils.close(r1);
        return null;
    L23:
        r1 = null;
    L20:
        th = th;
        goto L21
    }

    public static HttpURLConnection getUrlConnection(URL r2) {
        IHttpUrlConnectionInterceptor r0 = sUrlConnectionInterceptor;
        if (r0 != null) goto L6;
        return (HttpURLConnection) ZeusTransformUtils.preCheckCast(r2.openConnection(), HttpURLConnection.class, "com.obric.memorydata.plugin");
    L6:
        return r0.getUrlConnection(r2);
    }

    public static void setRequestIntercept(IRequestIntercept r2) {
        sRequestIntercept = (IRequestIntercept) ZeusTransformUtils.wrapperContextForParams(r2, IRequestIntercept.class, "com.obric.memorydata.plugin");
    }

    public static void setRequestPermission(IRequestPermission r2) {
        sRequestPermission = (IRequestPermission) ZeusTransformUtils.wrapperContextForParams(r2, IRequestPermission.class, "com.obric.memorydata.plugin");
    }

    public static void setUrlConnectionInterceptor(IHttpUrlConnectionInterceptor r2) {
        sUrlConnectionInterceptor = (IHttpUrlConnectionInterceptor) ZeusTransformUtils.wrapperContextForParams(r2, IHttpUrlConnectionInterceptor.class, "com.obric.memorydata.plugin");
    }

    public static boolean uploadAlogFiles(String r18, int r19, String r20, String r21, List<String> r22) {
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r22, List.class, "com.obric.memorydata.plugin");
        if (NpthCore.isStopUpload() == false) goto L5;
        return false;
    L5:
        IHttpService r5 = NpthNetworkApi.getHttpService();
        String r7 = "npth";
        if (r5 != null) goto L9;
        String r6 = "errno";
    L69:
        INetworkCallback r13 = NpthNetworkApi.getNetworkCallback();     // Catch: Throwable -> L64
        if (r13 == null) goto L39;
        String r16 = r6;
        r13.onCallback(INetworkCallback.TYPE_URL_CONNECTION);     // Catch: Throwable -> L62
    L77:
        HttpMultipart r8 = new HttpMultipart(r18, false);     // Catch: IOException -> L59
        r8.addFormField("aid", String.valueOf(r19));     // Catch: IOException -> L59
        r8.addFormField("device_id", r20);     // Catch: IOException -> L59
        r8.addFormField("os", LocationInfoConst.SYSTEM);     // Catch: IOException -> L59
        r8.addFormField("process_name", r21);     // Catch: IOException -> L59
        Iterator r0 = r3.iterator();     // Catch: IOException -> L59
    L42:
        if (r0.hasNext() == false) goto L46;
        File r2 = new File((String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.memorydata.plugin"));     // Catch: IOException -> L59
        if (r2.exists() == false) goto L42;
        HashMap r1 = new HashMap();     // Catch: IOException -> L59
        r1.put("logtype", ALOG_LOG_TYPE);     // Catch: IOException -> L59
        r1.put(MemoryInfoSectionEditActivity.KIND_SCENE, r7);     // Catch: IOException -> L59
        r8.addFilePart(r2, r1);     // Catch: IOException -> L59
        goto L42
    L46:
        r8.finish(ALOG_LOG_TYPE);     // Catch: IOException -> L59
        JSONObject r4 = r8.getResponse().getServerJson();     // Catch: Exception -> L57
        if (r4 != null) goto L71;
        return false;
    L71:
        if (r4.optInt(r16, -1) != 200) goto L88;
        return true;
    L88:
        return false;
    L89:
        return false;
    L57:
        return false;
    L59:
        e = move-exception;
        e.printStackTrace();
        return false;
    L39:
        r16 = r6;
        goto L77
    L9:
        String r17 = "npth";
        IMultipartService r9 = r5.buildMultipartService(r18, RpcUtils.CHARSET_UTF8, false);     // Catch: Throwable -> L30
        if (r9 != null) goto L67;
        r6 = "errno";
        r7 = r17;
        goto L69
    L67:
        r9.addFormField("aid", String.valueOf(r19));     // Catch: Throwable -> L31
        r9.addFormField("device_id", r20);     // Catch: Throwable -> L31
        r9.addFormField("os", LocationInfoConst.SYSTEM);     // Catch: Throwable -> L31
        r9.addFormField("process_name", r21);     // Catch: Throwable -> L31
        Iterator r10 = r3.iterator();     // Catch: Throwable -> L31
    L14:
        if (r10.hasNext() == false) goto L20;
        File r11 = new File((String) ZeusTransformUtils.preCheckCast(r10.next(), String.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L31
        if (r11.exists() == false) goto L18;
        HashMap r12 = new HashMap();     // Catch: Throwable -> L31
        r12.put("logtype", ALOG_LOG_TYPE);     // Catch: Throwable -> L31
        String r14 = r17;
        r12.put(MemoryInfoSectionEditActivity.KIND_SCENE, r14);     // Catch: Throwable -> L31
        r9.addFilePart(r11, r12);     // Catch: Throwable -> L31
    L19:
        r17 = r14;
        goto L14
    L18:
        r14 = r17;
        goto L19
    L20:
        Pair<Integer, String> r15 = r9.finish();     // Catch: Throwable -> L31
        if (r15 == null) goto L27;
        if (new JSONObject((String) ZeusTransformUtils.preCheckCast(r15.second, String.class, "com.obric.memorydata.plugin")).optInt("errno", -1) != 200) goto L90;
        return true;
    L90:
        return false;
    L27:
        return false;
    L31:
        return false;
    L87:
        return false;
    }

    public static boolean uploadCommonFile(File r17) {
        if (r17 != null) goto L5;
        return false;
    L5:
        if (r17.exists() == false) goto L52;
        AppMonitor r2 = MonitorManager.getAppMonitor();
        if (r2 != null) goto L10;
        return false;
    L10:
        String r3 = NetConfig.getAlogUploadUrl();
        String r4 = r2.getAppId();
        String r5 = r2.getDeviceId("0");
        String r6 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(Global.getApplication(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin")).getPackageName();
        IHttpService r7 = NpthNetworkApi.getHttpService();
        if (r7 != null) goto L46;
    L39:
        INetworkCallback r0 = NpthNetworkApi.getNetworkCallback();     // Catch: Throwable -> L37
        if (r0 == null) goto L48;
        r0.onCallback(INetworkCallback.TYPE_URL_CONNECTION);     // Catch: Throwable -> L37
    L48:
        HttpMultipart r1 = new HttpMultipart(r3, false);     // Catch: Throwable -> L32
        r1.addFormField("aid", r4);     // Catch: Throwable -> L32
        r1.addFormField("device_id", r5);     // Catch: Throwable -> L32
        r1.addFormField("os", LocationInfoConst.SYSTEM);     // Catch: Throwable -> L32
        r1.addFormField("process_name", r6);     // Catch: Throwable -> L32
        HashMap r8 = new HashMap();     // Catch: Throwable -> L32
        r8.put("logtype", "common");     // Catch: Throwable -> L32
        r8.put(MemoryInfoSectionEditActivity.KIND_SCENE, "common");     // Catch: Throwable -> L32
        r1.addFilePart(r17, r8);     // Catch: Throwable -> L32
        r1.finish("custom_common_file");     // Catch: Throwable -> L32
        if (r1.getResponse().isSuccess() == false) goto L30;
        return true;
    L30:
        return false;
    L53:
        return false;
    L32:
        th = move-exception;
        th.printStackTrace();
        return false;
    L46:
        IMultipartService r9 = r7.buildMultipartService(r3, RpcUtils.CHARSET_UTF8, false);     // Catch: Throwable -> L35
        r9.addFormField("aid", r4);     // Catch: Throwable -> L35
        r9.addFormField("device_id", r5);     // Catch: Throwable -> L35
        r9.addFormField("os", LocationInfoConst.SYSTEM);     // Catch: Throwable -> L35
        r9.addFormField("process_name", r6);     // Catch: Throwable -> L35
        HashMap r10 = new HashMap();     // Catch: Throwable -> L35
        r10.put("logtype", "common");     // Catch: Throwable -> L35
        r10.put(MemoryInfoSectionEditActivity.KIND_SCENE, "common");     // Catch: Throwable -> L35
        r9.addFilePart(r17, r10);     // Catch: Throwable -> L35
        goto L39
    L17:
        if (new JSONObject((String) ZeusTransformUtils.preCheckCast(r9.finish().second, String.class, "com.obric.memorydata.plugin")).optInt("errno", -1) != 200) goto L39;
        return true;
    L20:
        return false;
    L50:
        return false;
    L52:
        return false;
    }

    public static boolean uploadCommonFilesZip(File r6) {
        AppMonitor r0 = MonitorManager.getAppMonitor();
        if (r0 != null) goto L7;
        return false;
    L7:
        return uploadCommonFilesZip(NetConfig.getAlogUploadUrl(), r0.getAppId(), r0.getDeviceId("0"), ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(Global.getApplication(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin")).getPackageName(), r6);
    }

    public static boolean uploadCommonFilesZip(String r24, String r25, String r26, String r27, File r28) {
        if (NpthCore.isStopUpload() == false) goto L56;
        return false;
    L56:
        JSONObject r1 = new JSONObject();     // Catch: Throwable -> L18
        r1.put("aid", r25);     // Catch: Throwable -> L18
        r1.put("device_id", r26);     // Catch: Throwable -> L18
        r1.put("os", LocationInfoConst.SYSTEM);     // Catch: Throwable -> L18
        r1.put("process_name", r27);     // Catch: Throwable -> L18
        String r18 = r1.toString();     // Catch: Throwable -> L18
        String r21 = "aid";
        String r22 = "device_id";
        String r23 = "os";
        String r17 = " ";
        String r13 = LocationInfoConst.SYSTEM;
        if (checkPermission("POST", "multipart/form-data", null, r24, r18, null, r28, null) == true) goto L12;
        return false;
    L12:
        boolean r2 = false;
        if (NetworkDisasterManager.checkPermission(r25, new URL(r24)) == 0) goto L19;
        return true;
    L19:
        IHttpService r3 = NpthNetworkApi.getHttpService();
        if (r3 != null) goto L60;
        String r4 = r21;
        String r5 = r22;
        String r14 = r23;
        INetworkCallback r6 = NpthNetworkApi.getNetworkCallback();     // Catch: Throwable -> L52
        if (r6 == null) goto L35;
        String r20 = "errno";
        r6.onCallback(INetworkCallback.TYPE_URL_CONNECTION);     // Catch: Throwable -> L50
    L62:
        HttpMultipart r7 = new HttpMultipart(r24, false);     // Catch: Throwable -> L46
        r7.addFormField(r4, r25);     // Catch: Throwable -> L46
        r7.addFormField(r5, r26);     // Catch: Throwable -> L46
        r7.addFormField(r14, r13);     // Catch: Throwable -> L46
        r7.addFormField("process_name", r27);     // Catch: Throwable -> L46
        String r8 = r17;
        NpthLog.i("upload common file " + r25 + r8 + r26 + r8 + r27);     // Catch: Throwable -> L46
        if (r28.exists() == false) goto L39;
        HashMap r0 = new HashMap();     // Catch: Throwable -> L46
        r0.put("logtype", "common");     // Catch: Throwable -> L46
        r0.put(MemoryInfoSectionEditActivity.KIND_SCENE, "common");     // Catch: Throwable -> L46
        r7.addFilePart(r28, "customFile.zip", r0);     // Catch: Throwable -> L46
    L39:
        r7.finish("custom_common_zip");     // Catch: Throwable -> L46
        if (r7.getResponse().getServerJson().optInt(r20, -1) != 200) goto L44;
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
        r20 = "errno";
        goto L62
    L60:
        IMultipartService r9 = r3.buildMultipartService(r24, RpcUtils.CHARSET_UTF8, r2);     // Catch: Throwable -> L53
        r9.addFormField(r21, r25);     // Catch: Throwable -> L53
        r9.addFormField(r22, r26);     // Catch: Throwable -> L53
        r9.addFormField(r23, r13);     // Catch: Throwable -> L53
        r9.addFormField("process_name", r27);     // Catch: Throwable -> L53
        if (r28.exists() == false) goto L24;
        HashMap r10 = new HashMap();     // Catch: Throwable -> L53
        r10.put("logtype", "common");     // Catch: Throwable -> L53
        r10.put(MemoryInfoSectionEditActivity.KIND_SCENE, "common");     // Catch: Throwable -> L53
        r9.addFilePart(r28, "customFile.zip", r10);     // Catch: Throwable -> L53
    L24:
        Pair<Integer, String> r11 = r9.finish();     // Catch: Throwable -> L53
        if (getResponse(((Integer) ZeusTransformUtils.preCheckCast(r11.first, Integer.class, "com.obric.memorydata.plugin")).intValue(), (String) ZeusTransformUtils.preCheckCast(r11.second, String.class, "com.obric.memorydata.plugin")).getServerJson().optInt("errno", -1) != 200) goto L28;
        return true;
    L28:
        return r2;
    L17:
        r2 = false;
    L18:
        r2 = false;
        r21 = "aid";
        r22 = "device_id";
        r23 = "os";
        r17 = " ";
        r13 = LocationInfoConst.SYSTEM;
        goto L19
    }

    public static boolean uploadCoreFile(String r7, String r8, String r9, String r10, File r11) {
        IHttpService r0 = NpthNetworkApi.getHttpService();
        if (r0 != null) goto L29;
    L27:
        INetworkCallback r1 = NpthNetworkApi.getNetworkCallback();     // Catch: Throwable -> L26
        if (r1 == null) goto L31;
        r1.onCallback(INetworkCallback.TYPE_URL_CONNECTION);     // Catch: Throwable -> L26
    L31:
        HttpMultipart r2 = new HttpMultipart(r8, false);     // Catch: IOException -> L23
        r2.addFormField("data", r10);     // Catch: IOException -> L23
        r2.addFormField("header", r9);     // Catch: IOException -> L23
        r2.addFilePart("file", r11);     // Catch: IOException -> L23
        r2.finish(r7);     // Catch: IOException -> L23
        Response r12 = r2.getResponse();     // Catch: Exception -> L20
        JSONObject r13 = r12.getServerJson();     // Catch: Exception -> L20
        if (r13 != null) goto L17;
        return false;
    L17:
        if ("success".equals(r13.getString("message")) == true) goto L22;
        NpthLog.w("corefile upload err msg=" + r12);     // Catch: Exception -> L20
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
    L29:
        IMultipartService r3 = r0.buildMultipartService(r8, RpcUtils.CHARSET_UTF8, false);     // Catch: Throwable -> L8
        if (r3 == null) goto L27;
        r3.addFormField("data", r10);     // Catch: Throwable -> L8
        r3.addFormField("header", r9);     // Catch: Throwable -> L8
        r3.addFilePart("file", r11);     // Catch: Throwable -> L8
        r3.finish();     // Catch: Throwable -> L8
        return true;
    L8:
        return false;
    }

    public static Response uploadCrashLog(String r1, String r2, boolean r3) {
    L11:
        th = move-exception;
        NpthLog.w(th);
        return new Response(Constants.UPLOAD_HTTP_ERROR, th);
    L3:
        if (TextUtils.isEmpty(r2) == true) goto L10;
        if (TextUtils.isEmpty(r1) == true) goto L10;
        return doPost(r1, r2.getBytes(), CompressType.GZIP, r3);
    L10:
        return new Response(201);
    }

    public static Response uploadCrashLogWithAttachment(String r7, String r8, String r9, List<File> r10) {
        List<File> r11 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
        NpthLog.i("upload crashType " + r7);
        NpthLog.i("upload url " + r8);
        Iterator<File> r0 = r11.iterator();
    L4:
        if (r0.hasNext() == false) goto L7;
        NpthLog.i("upload attachments " + ((File) ZeusTransformUtils.preCheckCast(r0.next(), File.class, "com.obric.memorydata.plugin")).getAbsolutePath());
        goto L4
    L7:
        if (NpthCore.isStopUpload() == false) goto L46;
        return new Response(201);
    L46:
        long r3 = NetworkDisasterManager.checkPermission(null, new URL(r8));     // Catch: IOException -> L35
        if (r3 < 0) goto L14;
        if (r3 > 0) goto L17;
        IHttpService r1 = NpthNetworkApi.getHttpService();     // Catch: IOException -> L35
        if (r1 != null) goto L44;
        INetworkCallback r2 = NpthNetworkApi.getNetworkCallback();     // Catch: Throwable -> L39
        if (r2 == null) goto L33;
        r2.onCallback(INetworkCallback.TYPE_URL_CONNECTION);     // Catch: Throwable -> L39
    L33:
        HttpMultipart r4 = new HttpMultipart(UploaderUrl.urlAppendParam(r8, "have_dump=true&encrypt=true"), true);     // Catch: IOException -> L35
        r4.addFormField("json", r9, true);     // Catch: IOException -> L35
        r4.addFilePartAsZip("file", r11);     // Catch: IOException -> L35
        r4.finish(r7);     // Catch: IOException -> L35
        Response r12 = r4.getResponse();     // Catch: IOException -> L35
        NpthLog.i(TAG, "uploadCrashLogWithAttachment:" + r7 + " success");     // Catch: IOException -> L35
        return r12;
    L44:
        byte[] r13 = r9.getBytes();     // Catch: Exception -> L28 IOException -> L35
        IEncrypt r14 = RuntimeConfig.getEncryptImpl();     // Catch: Exception -> L28 IOException -> L35
        if (r14 == null) goto L24;
        r13 = r14.encrypt(r13);     // Catch: Exception -> L28 IOException -> L35
        String r15 = UploaderUrl.urlAppendParam(r8, "have_dump=true&encrypt=true");     // Catch: Exception -> L28 IOException -> L35
    L25:
        IMultipartService r16 = r1.buildMultipartService(r15, RpcUtils.CHARSET_UTF8, true);     // Catch: Exception -> L28 IOException -> L35
        r16.addFormField("json", r13);     // Catch: Exception -> L28 IOException -> L35
        r16.addGZIPFilePart("file", r11);     // Catch: Exception -> L28 IOException -> L35
        Pair<Integer, String> r17 = r16.finish();     // Catch: Exception -> L28 IOException -> L35
        Response r18 = getResponse(((Integer) ZeusTransformUtils.preCheckCast(r17.first, Integer.class, "com.obric.memorydata.plugin")).intValue(), (String) ZeusTransformUtils.preCheckCast(r17.second, String.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L28 IOException -> L35
        NetworkDisasterManager.updateNetworkState(new URL(r15), r18);     // Catch: Throwable -> L38
    L27:
        return r18;
        goto L29
    L24:
        r15 = UploaderUrl.urlAppendParam(r8, "have_dump=true");     // Catch: Exception -> L28 IOException -> L35
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

    public static boolean uploadEvent(String r3, JSONArray r4) {
        if (TextUtils.isEmpty(r3) == false) goto L5;
    L11:
        return false;
    L5:
        if (JSONUtils.isEmpty(r4) == true) goto L11;
        return doPost(r3, r4.toString().getBytes(), CompressType.GZIP, true).isSuccess();
    L9:
        th = move-exception;
        NpthLog.w(th);
        goto L11
    }

    public static boolean uploadEvent(String r3, JSONObject r4) {
        if (TextUtils.isEmpty(r3) == false) goto L5;
    L11:
        return false;
    L5:
        if (JSONUtils.isEmpty(r4) == true) goto L11;
        return doPost(r3, r4.toString().getBytes(), CompressType.GZIP, true).isSuccess();
    L9:
        th = move-exception;
        NpthLog.w(th);
        goto L11
    }

    @Deprecated
    public static Response uploadJavaCrashLog(String r3, String r4) {
        if (doPost(r3, r4.toString().getBytes(), CompressType.GZIP, true).isSuccess() == false) goto L8;
        return new Response(0);
    L8:
        return new Response(Constants.UPLOAD_HTTP_ERROR);
    L10:
        return new Response(Constants.UPLOAD_HTTP_ERROR);
    }

    @Deprecated
    public static Response uploadNativeCrashLog(String r5, String r6, File... r7) {
        ArrayList r0 = new ArrayList();
        int r1 = r7.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L6;
        r0.add(r7[r3]);
        r3 = r3 + 1;
        goto L3
    L6:
        if (uploadCrashLogWithAttachment("unknown_old", r5, r6, r0).isSuccess() == false) goto L10;
        return new Response(0);
    L10:
        return new Response(Constants.UPLOAD_HTTP_ERROR);
    }

    public static boolean uploadNativeExceptionLog(String r4, String r5, File... r6) {
        ArrayList r0 = new ArrayList();
        int r1 = r6.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L6;
        r0.add(r6[r2]);
        r2 = r2 + 1;
        goto L3
    L6:
        return uploadCrashLogWithAttachment("ensure_zip", r4, r5, r0).isSuccess();
    }

    public static boolean uploadRaphealFile(File r8) {
        AppMonitor r0 = MonitorManager.getAppMonitor();     // Catch: JSONException -> L4
        long r1 = new Date(r8.lastModified()).getTime();     // Catch: JSONException -> L4
        int r3 = Process.myPid();     // Catch: JSONException -> L4
        return uploadRawFile("raphael", NetConfig.getNativeMemUrl(), Header.createEventHeader(r0, r1, CrashType.ENSURE, r3).getJson().toString(), new JSONObject().put(Constants.EVENT_TYPE, "raphael_file").put("timestamp", System.currentTimeMillis()).toString(), r8);
    L4:
        return false;
    }

    public static boolean uploadRawFile(String r7, String r8, String r9, String r10, File r11) {
        IHttpService r0 = NpthNetworkApi.getHttpService();
        if (r0 != null) goto L31;
    L27:
        INetworkCallback r1 = NpthNetworkApi.getNetworkCallback();     // Catch: Throwable -> L26
        if (r1 == null) goto L29;
        r1.onCallback(INetworkCallback.TYPE_URL_CONNECTION);     // Catch: Throwable -> L26
    L29:
        HttpMultipart r2 = new HttpMultipart(r8, false);     // Catch: IOException -> L23
        r2.addFormField("data", r10);     // Catch: IOException -> L23
        r2.addFormField("header", r9);     // Catch: IOException -> L23
        r2.addFilePart("file", r11);     // Catch: IOException -> L23
        r2.finish(r7);     // Catch: IOException -> L23
        Response r12 = r2.getResponse();     // Catch: Exception -> L20
        JSONObject r13 = r12.getServerJson();     // Catch: Exception -> L20
        if (r13 != null) goto L17;
        return false;
    L17:
        if ("success".equals(r13.getString("message")) == true) goto L22;
        NpthLog.w("corefile upload err msg=" + r12);     // Catch: Exception -> L20
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
    L31:
        IMultipartService r3 = r0.buildMultipartService(r8, RpcUtils.CHARSET_UTF8, false);     // Catch: Throwable -> L8
        if (r3 == null) goto L27;
        r3.addFormField("data", r10);     // Catch: Throwable -> L8
        r3.addFormField("header", r9);     // Catch: Throwable -> L8
        r3.addFilePart("file", r11);     // Catch: Throwable -> L8
        r3.finish();     // Catch: Throwable -> L8
        return true;
    L8:
        return false;
    }

    private static byte[] wrapDeflateData(byte[] r4) {
        ByteArrayOutputStream r0 = new ByteArrayOutputStream(8192);
        Deflater r2 = new Deflater();
        r2.setInput(r4);
        r2.finish();
        byte[] r5 = new byte[8192];
    L4:
        if (r2.finished() == true) goto L6;
        r0.write(r5, 0, r2.deflate(r5));
        goto L4
    L6:
        r2.end();
        return r0.toByteArray();
    }

    private static byte[] wrapGzipData(byte[] r2) {
        ByteArrayOutputStream r0 = new ByteArrayOutputStream(8192);
        GZIPOutputStream r1 = new GZIPOutputStream(r0);
        r1.write(r2);     // Catch: Throwable -> L6
        r1.close();
        return r0.toByteArray();
    L6:
        th = move-exception;
        NpthLog.w(th);     // Catch: Throwable -> L10
        r1.close();
        return null;
    L10:
        th = move-exception;
        r1.close();
        throw th;
    }
}
