package com.lynx.devtool.recorder;

import android.util.Base64;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.larus.utils.logger.FLogger;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.eventreport.LynxEventReporter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class LynxRecorderFetcher implements k7a.a {
    private static String ASSETS_SCHEMA = "assets://";
    private static final int HTTP_TIME_OUT = 5000;
    private static int count;
    private boolean disableSyncRequest;
    private HashMap<String, JSONObject> mDynamicMap;

    public static /* synthetic */ void a(k7a.a.InterfaceC0095a r0, byte[] r1) {
        lambda$loadDynamicComponent$0(r0, r1);
    }

    private boolean shouldSendAsyncRequest() {
        if (this.disableSyncRequest == false) goto L5;
        return true;
    L5:
        int r0 = count;
        count = r0 + 1;
        if ((r0 % 2) == 0) goto L10;
        return false;
    L10:
        return true;
    }

    public LynxRecorderFetcher() {
        this.disableSyncRequest = false;
        disableSyncRequest(true);
        this.mDynamicMap = new HashMap();
    }

    @Skip({"com.obric.assistant.network.okhttp"})
    public static URLConnection INVOKEVIRTUAL_com_lynx_devtool_recorder_LynxRecorderFetcher_com_obric_assistant_network_okhttp_UrlConnLancet_openConnection(URL r7) throws IOException {
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

    public static /* synthetic */ byte[] access$000(String r0) throws Exception {
        return loadDynamicComponentTemplate(r0);
    }

    private static byte[] loadDynamicComponentFromAssets(String r4) throws IOException {
        InputStream r5 = LynxEnv.inst().getAppContext().getAssets().open(r4);
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();     // Catch: Throwable -> L21
        byte[] r1 = new byte[4096];     // Catch: Throwable -> L13
    L6:
        int r2 = r5.read(r1);     // Catch: Throwable -> L13
        if (r2 == (-1)) goto L9;
        r0.write(r1, 0, r2);     // Catch: Throwable -> L13
        goto L6
    L9:
        byte[] r3 = r0.toByteArray();     // Catch: Throwable -> L13
        r0.close();     // Catch: Throwable -> L21
        r5.close();
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
        if (r5 != null) goto L34;
    L29:
        throw th;
    L34:
        r5.close();     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        th.addSuppressed(th);
        goto L29
    }

    private static byte[] loadDynamicComponentTemplate(String r2) throws Exception {
        if (r2.startsWith(ASSETS_SCHEMA) == true) goto L5;
        HttpURLConnection r3 = (HttpURLConnection) INVOKEVIRTUAL_com_lynx_devtool_recorder_LynxRecorderFetcher_com_obric_assistant_network_okhttp_UrlConnLancet_openConnection(new URL(r2));
        r3.setRequestMethod("GET");
        r3.setReadTimeout(5000);
        if (r3.getResponseCode() == 200) goto L9;
        return null;
    L9:
        return Utils.inputStreamToByteArray(r3.getInputStream());
    L5:
        return loadDynamicComponentFromAssets(r2.substring(ASSETS_SCHEMA.length()));
    }

    public void disableSyncRequest(boolean r1) {
        this.disableSyncRequest = r1;
    }

    public void parse(JSONArray r5) {
        int r0 = 0;
    L4:
        if (r0 >= r5.length()) goto L12;
        JSONObject r1 = JSONArrayProtectorUtils.getJSONObject(r5, r0);     // Catch: JSONException -> L9
        JSONObject r2 = JSONObjectProtectorUtils.getJSONObject(r1, "Params");     // Catch: JSONException -> L9
        if (JSONObjectProtectorUtils.getString(r1, "Function Name").equals("LoadComponentWithCallback") == false) goto L11;
        this.mDynamicMap.put(JSONObjectProtectorUtils.getString(r2, LynxEventReporter.PROP_NAME_URL), r2);     // Catch: JSONException -> L9
    L11:
        r0 = r0 + 1;
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L11
    }

    private static /* synthetic */ void lambda$loadDynamicComponent$0(k7a.a.InterfaceC0095a r1, byte[] r2) {
        r1.a(r2, null);
    }

    @Override // k7a.a
    public void loadDynamicComponent(final String r5, final k7a.a.InterfaceC0095a r6) {
    L22:
        e = move-exception;
        e.printStackTrace();
        r6.a(null, e);
        return;
    L4:
        if (this.mDynamicMap.containsKey(r5) == false) goto L10;
        JSONObject r7 = this.mDynamicMap.get(r5);     // Catch: JSONException -> L22
        final byte[] r1 = Base64.decode(JSONObjectProtectorUtils.getString(r7, "source"), 0);     // Catch: JSONException -> L22
        if (JSONObjectProtectorUtils.getBoolean(r7, "sync_tag") == false) goto L8;
        r6.a(r1, null);     // Catch: JSONException -> L22
    L25:
        return;
    L8:
        ThreadUtils.getThreadPool().execute(new h(r6, r1));     // Catch: JSONException -> L22
        goto L25
    L10:
        if (shouldSendAsyncRequest() == false) goto L12;
        ThreadUtils.getThreadPool().execute(new AnonymousClass1(this, r6, r5));     // Catch: JSONException -> L22
        goto L25
    L12:
        Future r8 = ThreadUtils.getThreadPool().submit(new AnonymousClass2(this, r5));     // Catch: JSONException -> L22
        r6.a((byte[]) r8.get(5000, TimeUnit.MILLISECONDS), null);     // Catch: TimeoutException -> L15 ExecutionException -> L17 Throwable -> L19 JSONException -> L22
    L19:
        e = move-exception;
        e.printStackTrace();     // Catch: JSONException -> L22
        r6.a(null, e);     // Catch: JSONException -> L22
        goto L25
    }
}
