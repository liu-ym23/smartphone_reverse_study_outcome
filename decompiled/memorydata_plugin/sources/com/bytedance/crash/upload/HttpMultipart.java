package com.bytedance.crash.upload;

import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.crash.IEncrypt;
import com.bytedance.crash.NpthNetworkApi;
import com.bytedance.crash.config.RuntimeConfig;
import com.bytedance.crash.constants.Constants;
import com.bytedance.crash.diagnose.NpthMonitor;
import com.bytedance.crash.service.INetworkCallback;
import com.bytedance.crash.service.IRequestHeaderProvider;
import com.bytedance.crash.util.NpthLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.net.ssl.SSLContext;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class HttpMultipart {
    private static final int BUFFER_SIZE = 8192;
    private static final String LINE_FEED = "\r\n";
    private final String mBoundary;
    private final HttpURLConnection mConnection;
    public final IEncrypt mEncryptImpl;
    private final NpthMonitor.Event mMonitor;
    private final HttpOutputStream mOutput;

    public HttpMultipart(String r7, boolean r8) {
        this.mBoundary = "AAA" + System.currentTimeMillis() + "AAA";
        SSLContext.getInstance("TLS").init(null, null, null);     // Catch: Throwable -> L18
    L4:
        HttpURLConnection r9 = CrashUploader.getUrlConnection(new URL(r7));
        this.mConnection = r9;
        r9.setUseCaches(false);
        r9.setDoOutput(true);
        r9.setDoInput(true);
        r9.setRequestMethod("POST");
        r9.setRequestProperty(NetConst.KEY_CONTENT_TYPE, "multipart/form-data; boundary=" + this.mBoundary);
        if (r8 == false) goto L20;
        r9.setRequestProperty(NetConst.KEY_CONTENT_ENCODING, NetConst.GZIP);
    L20:
        IRequestHeaderProvider r10 = NpthNetworkApi.getRequestHeaderProvider();     // Catch: Throwable -> L19
        if (r10 == null) goto L16;
        Map<String, String> r11 = r10.getHeader(INetworkCallback.TYPE_URL_CONNECTION);     // Catch: Throwable -> L19
        if (r11 == null) goto L16;
        Iterator<String> r1 = r11.keySet().iterator();     // Catch: Throwable -> L19
    L13:
        if (r1.hasNext() == false) goto L16;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L19
        this.mConnection.setRequestProperty(r2, (String) ZeusTransformUtils.preCheckCast(r11.get(r2), String.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L19
    L16:
        this.mOutput = new HttpOutputStream(this.mConnection.getOutputStream(), r8);
        this.mEncryptImpl = RuntimeConfig.getEncryptImpl();
        this.mMonitor = new NpthMonitor.Event("crash_upload_size");
    }

    private void addFileContent(File r5) {
        FileInputStream r0 = new FileInputStream(r5);
        byte[] r6 = new byte[8192];
    L3:
        int r1 = r0.read(r6);
        if (r1 == (-1)) goto L6;
        this.mOutput.write(r6, 0, r1);
        goto L3
    L6:
        r0.close();
        this.mOutput.write(LINE_FEED);
    }

    private void addFilePartSplit(String r2) {
        addFilePartSplit(r2, null);
    }

    private void addFilePartSplit(String r8, Map<String, String> r9) {
        Map r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r9, Map.class, "com.obric.memorydata.plugin");
        StringBuilder r0 = new StringBuilder();
        r0.append("--").append(this.mBoundary).append(LINE_FEED).append("Content-Disposition: form-data; name=\"").append(r8).append("\"; filename=\"").append(r8).append("\"");
        if (r10 == null) goto L8;
        Iterator r11 = r10.entrySet().iterator();
    L6:
        if (r11.hasNext() == false) goto L8;
        Map.Entry r12 = (Map.Entry) ZeusTransformUtils.preCheckCast(r11.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        r0.append("; ").append((String) ZeusTransformUtils.preCheckCast(r12.getKey(), String.class, "com.obric.memorydata.plugin")).append("=\"").append((String) ZeusTransformUtils.preCheckCast(r12.getValue(), String.class, "com.obric.memorydata.plugin")).append("\"");
    L8:
        r0.append(LINE_FEED).append("Content-Transfer-Encoding: binary").append(LINE_FEED).append(LINE_FEED);
        this.mOutput.write(r0.toString().getBytes());
    }

    public void addFilePart(File r3, String r4, Map<String, String> r5) {
        addFilePartSplit(r4, (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin"));
        addFileContent(r3);
    }

    public void addFilePart(File r3, Map<String, String> r4) {
        Map<String, String> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        addFilePartSplit(r3.getName(), r5);
        addFileContent(r3);
    }

    public void addFilePart(String r5, File r6) {
        long r0 = this.mOutput.getCount();
        addFilePartSplit(r5);
        addFileContent(r6);
        this.mMonitor.addMetrics(new Object[]{r5 + "_size", Long.valueOf(this.mOutput.getCount() - r0)});
    }

    public void addFilePartAsZip(String r5, List<File> r6) {
        List<File> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        long r0 = this.mOutput.getCount();
        addFilePartSplit(r5, null);
        this.mOutput.writeZipFiles(r7);
        this.mOutput.write(LINE_FEED);
        this.mMonitor.addMetrics(new Object[]{r5 + "_size", Long.valueOf(this.mOutput.getCount() - r0)});
    }

    public void addFormField(String r2, String r3) {
        addFormField(r2, r3, false);
    }

    public void addFormField(String r7, String r8, boolean r9) {
        long r0 = this.mOutput.getCount();
        StringBuilder r2 = new StringBuilder();
        r2.append("--").append(this.mBoundary).append(LINE_FEED).append("Content-Disposition: form-data; name=\"").append(r7).append("\"").append(LINE_FEED).append("Content-Type: text/plain; charset=UTF-8").append(LINE_FEED).append(LINE_FEED);
        this.mOutput.write(r2.toString());     // Catch: IOException -> L10
    L4:
        byte[] r10 = r8.getBytes();
        if (r9 == false) goto L17;
        r10 = this.mEncryptImpl.encrypt(r10);     // Catch: Throwable -> L11
    L17:
        this.mOutput.write(r10);     // Catch: IOException -> L12
        this.mOutput.write(LINE_FEED);     // Catch: IOException -> L12
    L8:
        this.mMonitor.addMetrics(new Object[]{r7 + "_size", Long.valueOf(this.mOutput.getCount() - r0)});
    }

    public void finish(String r6) {
        this.mOutput.write("\r\n--" + this.mBoundary + "--" + LINE_FEED);
        this.mOutput.close();
        this.mMonitor.addCategories(new Object[]{"data_type", r6});
        this.mMonitor.addMetrics(new Object[]{"total_size", Long.valueOf(this.mOutput.getCount())});
        this.mMonitor.upload();
    }

    public Response getResponse() {
        ArrayList r0 = new ArrayList();
        NpthLog.d("getHeaderFields:" + this.mConnection.getHeaderFields());
        int r1 = this.mConnection.getResponseCode();
        Response r2 = new Response(r1);
        if (r1 != 200) goto L9;
        BufferedReader r3 = new BufferedReader(new InputStreamReader(this.mConnection.getInputStream()));
    L5:
        String r4 = r3.readLine();
        if (r4 == null) goto L8;
        r0.add(r4);
        goto L5
    L8:
        r3.close();
        this.mConnection.disconnect();
    L10:
        StringBuilder r5 = new StringBuilder();
        Iterator r6 = r0.iterator();
    L12:
        if (r6.hasNext() == false) goto L22;
        r5.append((String) ZeusTransformUtils.preCheckCast(r6.next(), String.class, "com.obric.memorydata.plugin"));
        goto L12
    L22:
        JSONObject r7 = new JSONObject(r5.toString());     // Catch: JSONException -> L16
    L17:
        r2.setServerJson(r7);
        NetworkDisasterManager.updateNetworkState(this.mConnection.getURL(), r2);     // Catch: Throwable -> L21
    L19:
        r2.setData(r5.toString().getBytes());
        return r2;
    L16:
        r7 = new JSONObject();
        r2.setErrCode(Constants.UPLOAD_HTTP_ERROR);
        goto L17
    L9:
        r2.setErrCode(Constants.UPLOAD_HTTP_ERROR);
        goto L10
    }
}
