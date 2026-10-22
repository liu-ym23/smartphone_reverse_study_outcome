package com.bytedance.common.wschannel.channel.a.a;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.channel.IWsChannelClient;
import com.bytedance.rpc.internal.RpcUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.UnsupportedEncodingException;
import okhttp3.Response;
import okio.ByteString;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class e implements c.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final IWsChannelClient f2079a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final c f2080b;
    private final Context c;

    e(Context r3, c r4, IWsChannelClient r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        IWsChannelClient r7 = (IWsChannelClient) ZeusTransformUtils.wrapperContextForParams(r5, IWsChannelClient.class, "com.obric.memorydata.plugin");
        this.f2080b = r4;
        this.f2079a = r7;
        this.c = ZeusTransformUtils.wrapperContext(r6, "com.obric.memorydata.plugin");
    }

    @Override // com.bytedance.common.wschannel.channel.a.a.c.d
    public void a(String r4) {
        if (this.f2079a == null) goto L12;
        JSONObject r0 = new JSONObject();
        r0.put("type", 1);     // Catch: Exception -> L7
        r0.put("state", 1);     // Catch: Exception -> L7
        r0.put("url", r4);     // Catch: Exception -> L7
        r0.put(WsConstants.KEY_CHANNEL_TYPE, 2);     // Catch: Exception -> L7
        this.f2079a.onConnection(r0);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    @Override // com.bytedance.common.wschannel.channel.a.a.c.d
    public void a(String r7, int r8, String r9) {
        Logger.d("WsChannelSdk_ok", "onFailure() : " + r9);
        Bundle r0 = new Bundle();
        r0.putString("url", r7);
        r0.putInt("error_code", r8);
        r0.putString("error_msg", r9);
        r0.putString("method", "onFailure");
        com.bytedance.common.wschannel.b.a.a(this.c, "WsChannelSdk_ok", r0);
        if (this.f2079a == null) goto L12;
        JSONObject r1 = new JSONObject();
        r1.put("type", 0);     // Catch: Exception -> L7
        r1.put("state", 2);     // Catch: Exception -> L7
        r1.put("url", r7);     // Catch: Exception -> L7
        r1.put(WsConstants.KEY_CHANNEL_TYPE, 2);     // Catch: Exception -> L7
        r1.put("error", r9);     // Catch: Exception -> L7
        r1.put("error_code", r8);     // Catch: Exception -> L7
        this.f2079a.onConnection(r1);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    @Override // com.bytedance.common.wschannel.channel.a.a.c.d
    public void a(Response r4) {
        Logger.d("WsChannelSdk_ok", "onOpen(): " + r4.toString());
        if (this.f2079a == null) goto L12;
        JSONObject r0 = new JSONObject();
        r0.put("type", 1);     // Catch: Exception -> L7
        r0.put("state", 4);     // Catch: Exception -> L7
        r0.put("url", r4.request().url().toString());     // Catch: Exception -> L7
        r0.put(WsConstants.KEY_CHANNEL_TYPE, 2);     // Catch: Exception -> L7
        this.f2079a.onConnection(r0);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    @Override // com.bytedance.common.wschannel.channel.a.a.c.d
    public void a(ByteString r3) {
        Logger.d("WsChannelSdk_ok", "onMessage() : " + r3.toString());
        IWsChannelClient r2 = this.f2079a;
        if (r2 == null) goto L6;
        r2.onMessage(r3.toByteArray());
        return;
    }

    @Override // com.bytedance.common.wschannel.channel.a.a.c.d
    public void b(String r3) {
        Logger.d("WsChannelSdk_ok", "onMessage():" + r3);
        IWsChannelClient r2 = this.f2079a;
        if (r2 == null) goto L11;
        r2.onMessage(r3.getBytes(RpcUtils.CHARSET_UTF8));     // Catch: UnsupportedEncodingException -> L6
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    @Override // com.bytedance.common.wschannel.channel.a.a.c.d
    public void b(String r2, int r3, String r4) {
        Logger.d("WsChannelSdk_ok", "onClosed() : " + r4);
        if (this.f2079a == null) goto L12;
        JSONObject r5 = new JSONObject();
        r5.put("type", 0);     // Catch: Exception -> L7
        r5.put("state", 3);     // Catch: Exception -> L7
        r5.put("url", r2);     // Catch: Exception -> L7
        r5.put(WsConstants.KEY_CHANNEL_TYPE, 2);     // Catch: Exception -> L7
        this.f2079a.onConnection(r5);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
        return;
    }
}
