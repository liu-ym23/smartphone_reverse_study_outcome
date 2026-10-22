package i8;

import android.content.Context;
import android.os.Handler;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.channel.IWsChannelClient;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements IWsChannelClient {
    public static boolean g = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f17516a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Handler f17517b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List f17518c;
    public boolean d;
    public IWsChannelClient e;
    public final a f;

    public b(int r5, a r10, Handler r11) {
        this.d = true;
        this.f17516a = r5;
        this.f = r10;
        this.f17517b = r11;
        if (g == false) goto L14;
        a();     // Catch: Throwable -> L7 ClassNotFoundException -> L12
        if (this.d == false) goto L9;
        Logger.d("WsChannelClient", "use cronet to connect");     // Catch: Throwable -> L7 ClassNotFoundException -> L12
    L17:
    L9:
        Logger.d("WsChannelClient", "use PushManager to connect");     // Catch: Throwable -> L7 ClassNotFoundException -> L12
        g = false;     // Catch: Throwable -> L7 ClassNotFoundException -> L12
    L12:
        Logger.d("WsChannelClient", "don't find plugin or plugin download failed");
    L7:
        th = move-exception;
        th.printStackTrace();
        Logger.d("WsChannelClient", "don't find plugin");
    L14:
        if (this.e != null) goto L20;
        Logger.d("WsChannelClient", "use okhttp to connect");
        this.e = new j8.b(r5, r11);
        return;
    }

    public final void a() {
        if (this.e != null) goto L26;
        Class<?> r5 = null;
        if (com.bytedance.common.utility.b.b("") == false) goto L29;
    L8:
        Class<?> r10 = null;
    L9:
        if (r10 == null) goto L33;
    L15:
        if (r10 == null) goto L31;
    L19:
        if (r10 == null) goto L25;
        Object r11 = r10.newInstance();
        if ((r11 instanceof IWsChannelClient) == false) goto L35;
        this.e = (IWsChannelClient) r11;
        return;
    L35:
        return;
    L25:
        throw new ClassNotFoundException("plugin class not found");
    L31:
        r5 = Class.forName("com.b.c.ws.MySelfChannelImpl");     // Catch: Throwable -> L27
    L18:
        this.d = false;
        r10 = r5;
        goto L19
    L33:
        r10 = Class.forName("org.chromium.wschannel.MySelfChannelImpl");     // Catch: Throwable -> L13
    L14:
        this.d = true;
    L13:
        r10 = null;
        goto L14
    L29:
        r10 = Class.forName("");     // Catch: Throwable -> L28
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public final void destroy() {
        monitor-enter(this);
        IWsChannelClient r5 = this.e;     // Catch: Throwable -> L12
        if (r5 == null) goto L21;
        r5.destroy();     // Catch: Throwable -> L12
        if ((this.e instanceof j8.b) == true) goto L21;
        JSONObject r10 = new JSONObject();     // Catch: Throwable -> L12
        List r11 = this.f17518c;     // Catch: Throwable -> L12
        if (r11 != null) goto L10;
    L14:
        String r12 = "";
    L25:
        r10.put("type", 0);     // Catch: Throwable -> L12 Exception -> L19
        r10.put("state", 3);     // Catch: Throwable -> L12 Exception -> L19
        r10.put("url", r12);     // Catch: Throwable -> L12 Exception -> L19
        r10.put(WsConstants.KEY_CHANNEL_TYPE, 1);     // Catch: Throwable -> L12 Exception -> L19
        a r13 = this.f;     // Catch: Throwable -> L12 Exception -> L19
        if (r13 == null) goto L21;
        r13.e(this, this.f17516a, r10);     // Catch: Throwable -> L12 Exception -> L19
    L19:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L12
        goto L21
    L10:
        if (r11.size() < 1) goto L14;
        r12 = (String) this.f17518c.get(0);     // Catch: Throwable -> L12
    L21:
        monitor-exit(this);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public final void init(Context r5, IWsChannelClient r10) {
        IWsChannelClient r11 = this.e;
        if (r11 != null) goto L12;
        return;
    L12:
        r11.init(r5, r10);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        if ((this.e instanceof j8.b) == true) goto L10;
        th.printStackTrace();
        Logger.d("WsChannelClient", "cronet socket init failed，use okhttp to connect");
        j8.b r12 = new j8.b(this.f17516a, this.f17517b);
        this.e = r12;
        r12.init(r5, r10);
        return;
    L10:
        throw th;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public final boolean isConnected() {
        IWsChannelClient r5 = this.e;
        if (r5 != null) goto L5;
        return false;
    L5:
        return r5.isConnected();
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public final void onAppStateChanged(int r5) {
        IWsChannelClient r10 = this.e;
        if (r10 == null) goto L6;
        r10.onAppStateChanged(r5);
        return;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public final void onConnection(JSONObject r5) {
        monitor-enter(this);
        a r10 = this.f;     // Catch: Throwable -> L7
        if (r10 == null) goto L25;
        r10.e(this, this.f17516a, r5);     // Catch: Throwable -> L7
    L25:
        JSONObject r11 = new JSONObject();     // Catch: Throwable -> L7 Exception -> L22
        int r12 = r5.optInt("state");     // Catch: Throwable -> L7 Exception -> L22
        if (2 != r12) goto L13;
        int r13 = 1;
    L16:
        if (99 == r13) goto L18;
        r11.put(WsConstants.KEY_LP_CONNECT_STATUS, r13);     // Catch: Throwable -> L7 Exception -> L22
        this.f.b(WsConstants.LP_WSCHANNEL_CLIENT_ON_CONNECTION, r11);     // Catch: Throwable -> L7 Exception -> L22
        goto L18
    L13:
        if (4 != r12) goto L15;
        r13 = 0;
        goto L16
    L15:
        r13 = 99;
    L18:
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public final void onMessage(byte[] r5) {
        a r10 = this.f;
        if (r10 == null) goto L6;
        r10.f(this.f17516a, r5);
        return;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public final void onNetworkStateChanged(int r5) {
        IWsChannelClient r10 = this.e;
        if (r10 == null) goto L6;
        r10.onNetworkStateChanged(r5);
        return;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public final void onParameterChange(Map r5, List r10) {
        IWsChannelClient r11 = this.e;
        if (r11 == null) goto L5;
        r11.onParameterChange(r5, r10);
    L5:
        this.f17518c = r10;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public final void openConnection(Map r5, List r10) {
        IWsChannelClient r11 = this.e;
        if (r11 == null) goto L5;
        r11.openConnection(r5, r10);
    L5:
        this.f17518c = r10;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public final boolean sendMessage(byte[] r5) {
        IWsChannelClient r10 = this.e;
        if (r10 != null) goto L5;
        return false;
    L5:
        return r10.sendMessage(r5);
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public final void stopConnection() {
        IWsChannelClient r5 = this.e;
        if (r5 == null) goto L6;
        r5.stopConnection();
        return;
    }
}
