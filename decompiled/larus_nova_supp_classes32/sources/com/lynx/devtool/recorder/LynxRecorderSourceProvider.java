package com.lynx.devtool.recorder;

import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.larus.utils.logger.FLogger;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.provider.LynxResourceCallback;
import com.lynx.tasm.provider.LynxResourceRequest;
import com.lynx.tasm.provider.LynxResourceResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class LynxRecorderSourceProvider extends d8a.k<Object, byte[]> {
    private static final String ASSETS_SCHEME = "assets://";
    private static final int HTTP_TIME_OUT = 5000;
    private static final String TAG = "LynxRecorderSourceProvider";
    private JSONObject mUrlRedirect;

    public LynxRecorderSourceProvider() {
        this.mUrlRedirect = null;
    }

    @Skip({"com.obric.assistant.network.okhttp"})
    public static URLConnection INVOKEVIRTUAL_com_lynx_devtool_recorder_LynxRecorderSourceProvider_com_obric_assistant_network_okhttp_UrlConnLancet_openConnection(URL r7) throws IOException {
        String r3 = r7.getHost();     // Catch: Throwable -> L8 IOException -> L12
        String r4 = r7.getPath();     // Catch: Throwable -> L8 IOException -> L12
        if (com.obric.assistant.network.okhttp.a.c(r3, r4) == false) goto L11;
        FLogger.a.i("UrlConnLancet", "openConnection drop host=" + r3 + " path=" + r4);     // Catch: Throwable -> L8 IOException -> L12
        com.obric.assistant.network.okhttp.a.b(com.obric.assistant.network.okhttp.a.a(r3, r4), r3, r4);     // Catch: Throwable -> L8 IOException -> L12
        throw new IOException("[NetGuard] dropped " + r7);     // Catch: Throwable -> L8 IOException -> L12
    L11:
        return r7.openConnection();
    L12:
        e = move-exception;
        throw e;
    L8:
        th = move-exception;
        FLogger.a.e("UrlConnLancet", "openConnection intercept failed, fallback to origin: " + th.getMessage());
        goto L11
    }

    private byte[] requestFromAssets(String r5) throws IOException {
        InputStream r6 = LynxEnv.inst().getAppContext().getAssets().open(r5);
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();     // Catch: Throwable -> L21
        byte[] r1 = new byte[4096];     // Catch: Throwable -> L13
    L6:
        int r2 = r6.read(r1);     // Catch: Throwable -> L13
        if (r2 == (-1)) goto L9;
        r0.write(r1, 0, r2);     // Catch: Throwable -> L13
        goto L6
    L9:
        byte[] r3 = r0.toByteArray();     // Catch: Throwable -> L13
        r0.close();     // Catch: Throwable -> L21
        r6.close();
        return r3;
    L13:
        th = move-exception;
        throw th;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        r0.close();     // Catch: Throwable -> L18
    L20:
        throw th;     // Catch: Throwable -> L21
    L18:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        throw th;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        if (r6 != null) goto L34;
    L29:
        throw th;
    L34:
        r6.close();     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        th.addSuppressed(th);
        goto L29
    }

    private byte[] requestFromURL(String r3) throws IOException {
        HttpURLConnection r4 = (HttpURLConnection) INVOKEVIRTUAL_com_lynx_devtool_recorder_LynxRecorderSourceProvider_com_obric_assistant_network_okhttp_UrlConnLancet_openConnection(new URL(r3));
        r4.setRequestMethod("GET");
        r4.setReadTimeout(5000);
        if (r4.getResponseCode() != 200) goto L7;
        return Utils.inputStreamToByteArray(r4.getInputStream());
    L7:
        throw new IOException(r4.getResponseMessage());
    }

    public void setUrlRedirect(JSONObject r1) {
        this.mUrlRedirect = r1;
    }

    @Override // d8a.k
    public void request(LynxResourceRequest<Object> r6, LynxResourceCallback<byte[]> r7) {
        LLog.i(TAG, "LynxRecorderSourceProvider request " + r6.a);
        Throwable r0 = null;
        String r8 = r6.a;     // Catch: Throwable -> L15
        if (r8.length() > 9) goto L6;
    L8:
        JSONObject r2 = this.mUrlRedirect;     // Catch: Throwable -> L15
        if (r2 != null) goto L11;
    L13:
        byte[] r9 = requestFromURL(r8);     // Catch: Throwable -> L15
    L17:
        if (r0 == null) goto L19;
        LLog.i(TAG, "LynxRecorderSourceProvider request failed, error:" + r0);
        r7.onResponse(LynxResourceResponse.failed(-1, r0));
        return;
    L19:
        LLog.i(TAG, "LynxRecorderSourceProvider request successfully");
        r7.onResponse(LynxResourceResponse.success(r9));
        return;
    L11:
        if (r2.has(r8) == false) goto L13;
        r8 = JSONObjectProtectorUtils.getString(this.mUrlRedirect, r8);     // Catch: Throwable -> L15
        goto L13
    L6:
        if (r8.startsWith(ASSETS_SCHEME) == false) goto L8;
        r9 = requestFromAssets(r8.substring(9));     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        r0 = th;
        r9 = null;
        goto L17
    }
}
