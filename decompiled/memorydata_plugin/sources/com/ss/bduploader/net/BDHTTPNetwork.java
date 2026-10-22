package com.ss.bduploader.net;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class BDHTTPNetwork extends BDVNetClient {
    private static final int HTTP_TIME_OUT = 10;
    public static final MediaType JSON = null;
    private static OkHttpClient mClient;
    private Call mCall;

    static {
        JSON = MediaType.parse("application/json");
    }

    public BDHTTPNetwork() {
    }

    @Override // com.ss.bduploader.net.BDVNetClient
    public void cancel() {
        Call r0 = this.mCall;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isCanceled() == true) goto L9;
        this.mCall.cancel();
        return;
    }

    @Override // com.ss.bduploader.net.BDVNetClient
    public void startTask(String r6, Map<String, String> r7, BDVNetClient.CompletionListener r8) {
        Map r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.memorydata.plugin");
        final BDVNetClient.CompletionListener r10 = (BDVNetClient.CompletionListener) ZeusTransformUtils.wrapperContextForParams(r8, BDVNetClient.CompletionListener.class, "com.obric.memorydata.plugin");
        monitor-enter(BDHTTPNetwork.class);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (mClient != null) goto L7;
        mClient = new OkHttpClient().newBuilder().connectTimeout(10, TimeUnit.SECONDS).writeTimeout(10, TimeUnit.SECONDS).readTimeout(10, TimeUnit.SECONDS).build();     // Catch: Throwable -> L16
    L7:
        monitor-exit(BDHTTPNetwork.class);     // Catch: Throwable -> L16
        Request.Builder r11 = new Request.Builder().url(r6);
        if (r9 == null) goto L14;
        Iterator r0 = r9.keySet().iterator();
    L12:
        if (r0.hasNext() == false) goto L14;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.memorydata.plugin");
        r11.header(r1, (String) ZeusTransformUtils.preCheckCast(r9.get(r1), String.class, "com.obric.memorydata.plugin"));
    L14:
        Request r12 = r11.build();
        Call r13 = mClient.newCall(r12);
        this.mCall = r13;
        r13.enqueue(new AnonymousClass1(this, r10));
    }

    @Override // com.ss.bduploader.net.BDVNetClient
    public void startTask(String r6, Map<String, String> r7, JSONObject r8, int r9, BDVNetClient.CompletionListener r10) {
        Map r11 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.memorydata.plugin");
        final BDVNetClient.CompletionListener r12 = (BDVNetClient.CompletionListener) ZeusTransformUtils.wrapperContextForParams(r10, BDVNetClient.CompletionListener.class, "com.obric.memorydata.plugin");
        monitor-enter(BDHTTPNetwork.class);
    L21:
        th = move-exception;
        throw th;
    L5:
        if (mClient != null) goto L7;
        mClient = new OkHttpClient().newBuilder().connectTimeout(10, TimeUnit.SECONDS).writeTimeout(10, TimeUnit.SECONDS).readTimeout(10, TimeUnit.SECONDS).build();     // Catch: Throwable -> L21
    L7:
        monitor-exit(BDHTTPNetwork.class);     // Catch: Throwable -> L21
        Request.Builder r13 = new Request.Builder().url(r6);
        if (r11 == null) goto L17;
        if (r11.size() <= 0) goto L17;
        Iterator r0 = r11.keySet().iterator();
    L14:
        if (r0.hasNext() == false) goto L17;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.memorydata.plugin");
        r13.addHeader(r1, (String) ZeusTransformUtils.preCheckCast(r11.get(r1), String.class, "com.obric.memorydata.plugin"));
    L17:
        if (r9 != 1) goto L19;
        r13.post(RequestBody.create(JSON, String.valueOf(r8)));
    L19:
        Call r14 = mClient.newCall(r13.build());
        this.mCall = r14;
        r14.enqueue(new AnonymousClass2(this, r12));
    }
}
