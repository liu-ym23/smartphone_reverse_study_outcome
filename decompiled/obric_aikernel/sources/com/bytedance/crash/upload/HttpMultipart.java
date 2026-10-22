package com.bytedance.crash.upload;

import androidx.annotation.Nullable;
import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.crash.IEncrypt;
import com.bytedance.crash.NpthNetworkApi;
import com.bytedance.crash.config.RuntimeConfig;
import com.bytedance.crash.constants.Constants;
import com.bytedance.crash.diagnose.NpthMonitor;
import com.bytedance.crash.service.INetworkCallback;
import com.bytedance.crash.service.IRequestHeaderProvider;
import com.bytedance.crash.util.NpthLog;
import com.bytedance.crypto.cloudsync.network.CloudConfig;
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

/* JADX INFO: loaded from: classes.dex */
public class HttpMultipart {
    private static final int BUFFER_SIZE = 8192;
    private static final String LINE_FEED = "\r\n";
    private final String mBoundary;
    private final HttpURLConnection mConnection;
    public final IEncrypt mEncryptImpl;
    private final NpthMonitor.Event mMonitor;
    private final HttpOutputStream mOutput;

    public HttpMultipart(String r10, boolean r11) {
        this.mBoundary = "AAA" + System.currentTimeMillis() + "AAA";
        SSLContext.getInstance("TLS").init(null, null, null);     // Catch: Throwable -> L18
    L4:
        HttpURLConnection r12 = CrashUploader.getUrlConnection(new URL(r10));
        this.mConnection = r12;
        r12.setUseCaches(false);
        r12.setDoOutput(true);
        r12.setDoInput(true);
        r12.setRequestMethod(CloudConfig.REQUEST_TYPE_POST);
        r12.setRequestProperty(NetConst.KEY_CONTENT_TYPE, "multipart/form-data; boundary=" + this.mBoundary);
        if (r11 == false) goto L20;
        r12.setRequestProperty(NetConst.KEY_CONTENT_ENCODING, NetConst.GZIP);
    L20:
        IRequestHeaderProvider r13 = NpthNetworkApi.getRequestHeaderProvider();     // Catch: Throwable -> L19
        if (r13 == null) goto L16;
        Map<String, String> r14 = r13.getHeader(INetworkCallback.TYPE_URL_CONNECTION);     // Catch: Throwable -> L19
        if (r14 == null) goto L16;
        Iterator<String> r15 = r14.keySet().iterator();     // Catch: Throwable -> L19
    L13:
        if (r15.hasNext() == false) goto L16;
        String r16 = r15.next();     // Catch: Throwable -> L19
        this.mConnection.setRequestProperty(r16, r14.get(r16));     // Catch: Throwable -> L19
    L16:
        this.mOutput = new HttpOutputStream(this.mConnection.getOutputStream(), r11);
        this.mEncryptImpl = RuntimeConfig.getEncryptImpl();
        this.mMonitor = new NpthMonitor.Event("crash_upload_size");
    }

    private void addFileContent(File r10) {
        FileInputStream r11 = new FileInputStream(r10);
        byte[] r12 = new byte[8192];
    L3:
        int r13 = r11.read(r12);
        if (r13 == (-1)) goto L6;
        this.mOutput.write(r12, 0, r13);
        goto L3
    L6:
        r11.close();
        this.mOutput.write(LINE_FEED);
    }

    private void addFilePartSplit(String r10) {
        addFilePartSplit(r10, null);
    }

    private void addFilePartSplit(String r10, @Nullable Map<String, String> r11) {
        StringBuilder r12 = new StringBuilder();
        r12.append("--");
        r12.append(this.mBoundary);
        r12.append(LINE_FEED);
        r12.append("Content-Disposition: form-data; name=\"");
        r12.append(r10);
        r12.append("\"; filename=\"");
        r12.append(r10);
        r12.append("\"");
        if (r11 == null) goto L8;
        Iterator<Map.Entry<String, String>> r13 = r11.entrySet().iterator();
    L6:
        if (r13.hasNext() == false) goto L8;
        Map.Entry<String, String> r14 = r13.next();
        r12.append("; ");
        r12.append(r14.getKey());
        r12.append("=\"");
        r12.append(r14.getValue());
        r12.append("\"");
    L8:
        r12.append(LINE_FEED);
        r12.append("Content-Transfer-Encoding: binary");
        r12.append(LINE_FEED);
        r12.append(LINE_FEED);
        this.mOutput.write(r12.toString().getBytes());
    }

    public void addFilePart(File r10, String r11, Map<String, String> r12) {
        addFilePartSplit(r11, r12);
        addFileContent(r10);
    }

    public void addFilePart(File r10, Map<String, String> r11) {
        addFilePartSplit(r10.getName(), r11);
        addFileContent(r10);
    }

    public void addFilePart(String r10, File r11) {
        long r12 = this.mOutput.getCount();
        addFilePartSplit(r10);
        addFileContent(r11);
        this.mMonitor.addMetrics(new Object[]{r10 + "_size", Long.valueOf(this.mOutput.getCount() - r12)});
    }

    public void addFilePartAsZip(String r10, List<File> r11) {
        long r12 = this.mOutput.getCount();
        addFilePartSplit(r10, null);
        this.mOutput.writeZipFiles(r11);
        this.mOutput.write(LINE_FEED);
        this.mMonitor.addMetrics(new Object[]{r10 + "_size", Long.valueOf(this.mOutput.getCount() - r12)});
    }

    public void addFormField(String r10, String r11) {
        addFormField(r10, r11, false);
    }

    public void addFormField(String r10, String r11, boolean r12) {
        long r13 = this.mOutput.getCount();
        this.mOutput.write("--" + this.mBoundary + LINE_FEED + "Content-Disposition: form-data; name=\"" + r10 + "\"" + LINE_FEED + "Content-Type: text/plain; charset=UTF-8" + LINE_FEED + LINE_FEED);     // Catch: IOException -> L10
    L4:
        byte[] r14 = r11.getBytes();
        if (r12 == true) goto L15;
    L13:
        this.mOutput.write(r14);     // Catch: IOException -> L12
        this.mOutput.write(LINE_FEED);     // Catch: IOException -> L12
    L8:
        this.mMonitor.addMetrics(new Object[]{r10 + "_size", Long.valueOf(this.mOutput.getCount() - r13)});
        return;
    L15:
        r14 = this.mEncryptImpl.encrypt(r14);     // Catch: Throwable -> L11
        goto L13
    }

    public void finish(String r10) {
        this.mOutput.write("\r\n--" + this.mBoundary + "--" + LINE_FEED);
        this.mOutput.close();
        this.mMonitor.addCategories(new Object[]{"data_type", r10});
        this.mMonitor.addMetrics(new Object[]{"total_size", Long.valueOf(this.mOutput.getCount())});
        this.mMonitor.upload();
    }

    public Response getResponse() {
        ArrayList r10 = new ArrayList();
        NpthLog.d("getHeaderFields:" + this.mConnection.getHeaderFields());
        int r11 = this.mConnection.getResponseCode();
        Response r12 = new Response(r11);
        if (r11 != 200) goto L9;
        BufferedReader r13 = new BufferedReader(new InputStreamReader(this.mConnection.getInputStream()));
    L5:
        String r14 = r13.readLine();
        if (r14 == null) goto L8;
        r10.add(r14);
        goto L5
    L8:
        r13.close();
        this.mConnection.disconnect();
    L10:
        StringBuilder r15 = new StringBuilder();
        Iterator r16 = r10.iterator();
    L12:
        if (r16.hasNext() == false) goto L22;
        r15.append((String) r16.next());
        goto L12
    L22:
        JSONObject r17 = new JSONObject(r15.toString());     // Catch: JSONException -> L16
    L17:
        r12.setServerJson(r17);
        NetworkDisasterManager.updateNetworkState(this.mConnection.getURL(), r12);     // Catch: Throwable -> L21
    L19:
        r12.setData(r15.toString().getBytes());
        return r12;
    L16:
        r17 = new JSONObject();
        r12.setErrCode(Constants.UPLOAD_HTTP_ERROR);
        goto L17
    L9:
        r12.setErrCode(Constants.UPLOAD_HTTP_ERROR);
        goto L10
    }
}
