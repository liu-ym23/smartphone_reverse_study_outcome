package y5;

import android.content.Context;
import android.os.Handler;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.channel.IWsChannelClient;
import com.bytedance.common.wschannel.model.SocketState;
import com.bytedance.common.wschannel.server.WsChannelService;
import j6.f;
import java.util.List;
import java.util.Map;
import org.chromium.wschannel.MySelfChannelImpl;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class b implements IWsChannelClient {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static boolean f13992r = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f13993a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Handler f13994b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f13995m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public List<String> f13996n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f13997o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public IWsChannelClient f13998p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final a f13999q;

    public b(int r8, com.bytedance.common.wschannel.server.b r10, WeakHandler r11) {
        this.f13995m = false;
        this.f13997o = true;
        this.f13993a = r8;
        this.f13999q = r10;
        this.f13994b = r11;
        if (f13992r == false) goto L13;
        b();     // Catch: Throwable -> L9 ClassNotFoundException -> L16
        if (this.f13997o == false) goto L7;
        Logger.d("WsChannelClient", "使用cronet建立长链接");     // Catch: Throwable -> L9 ClassNotFoundException -> L16
    L17:
        goto L11
    L7:
        Logger.d("WsChannelClient", "使用PushManager建立长链接");     // Catch: Throwable -> L9 ClassNotFoundException -> L16
        f13992r = false;     // Catch: Throwable -> L9 ClassNotFoundException -> L16
    L9:
        th = move-exception;
        th.printStackTrace();
    L11:
        Logger.d("WsChannelClient", "未检测到插件或者插件下载失败");
    L13:
        if (this.f13998p != null) goto L20;
        Logger.d("WsChannelClient", "使用okhttp建立长链接");
        this.f13998p = new z5.a(r11, r8);
        return;
    }

    public final void a(JSONObject r8) {
        a r10 = this.f13999q;
        if (r10 == null) goto L18;
        int r11 = this.f13993a;
        com.bytedance.common.wschannel.server.b r12 = (com.bytedance.common.wschannel.server.b) r10;
        if (r8 == null) goto L19;
        r8.put(WsConstants.KEY_CHANNEL_ID, r11);     // Catch: JSONException -> L9
    L11:
        SocketState r13 = new SocketState();
        r13.f3887n = r8.optInt(WsConstants.KEY_CHANNEL_ID, Integer.MIN_VALUE);
        r13.f3884a = r8.optInt("type", -1);
        r13.f3885b = r8.optInt("state", -1);
        r13.f3886m = r8.optString(WsConstants.KEY_CONNECTION_URL, "");
        r13.f3888o = r8.optInt(WsConstants.KEY_CHANNEL_TYPE);
        r13.f3889p = r8.optString(WsConstants.KEY_CONNECTION_ERROR, "");
        r13.f3890q = r8.optInt("error_code");
        r12.b(r13);
        Context r14 = r12.f3931a;
        if (com.bytedance.common.wschannel.a.a(r14).f3869a.a(WsConstants.KEY_ENABLE_REPORT_APP_STATE, false) == false) goto L20;
        j6.a r15 = j6.a.e(r14);
        f r16 = new f(r12, this);
        r15.f8689a.post(r16);
        return;
    L20:
        return;
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L11
    L19:
        return;
    }

    public final void b() {
        if (this.f13998p != null) goto L24;
        Class<?> r8 = null;
        if (r5.f.b("") == false) goto L27;
    L8:
        Class<?> r10 = null;
    L9:
        if (r10 == null) goto L31;
    L14:
        if (r10 == null) goto L29;
    L18:
        if (r10 == null) goto L23;
        Object r11 = r10.newInstance();
        if ((r11 instanceof IWsChannelClient) == false) goto L33;
        this.f13998p = (IWsChannelClient) r11;
        return;
    L33:
        return;
    L23:
        throw new ClassNotFoundException("plugin class not found");
    L29:
        r8 = Class.forName("com.b.c.ws.MySelfChannelImpl");     // Catch: Throwable -> L25
    L17:
        this.f13997o = false;
        r10 = r8;
        goto L18
    L31:
        r10 = MySelfChannelImpl.class;
        int r12 = MySelfChannelImpl.f9803a;     // Catch: Throwable -> L12
    L13:
        this.f13997o = true;
    L12:
        r10 = null;
        goto L13
    L27:
        r10 = Class.forName("");     // Catch: Throwable -> L26
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public final void destroy() {
        monitor-enter(this);
        this.f13995m = true;     // Catch: Throwable -> L20
        IWsChannelClient r8 = this.f13998p;     // Catch: Throwable -> L20
        if (r8 == null) goto L18;
        r8.destroy();     // Catch: Throwable -> L20
        if ((this.f13998p instanceof z5.a) == true) goto L18;
        JSONObject r10 = new JSONObject();     // Catch: Throwable -> L20
        List<String> r11 = this.f13996n;     // Catch: Throwable -> L20
        if (r11 != null) goto L11;
    L13:
        String r12 = "";
    L23:
        r10.put("type", 0);     // Catch: Exception -> L16 Throwable -> L20
        r10.put("state", 3);     // Catch: Exception -> L16 Throwable -> L20
        r10.put(WsConstants.KEY_CONNECTION_URL, r12);     // Catch: Exception -> L16 Throwable -> L20
        r10.put(WsConstants.KEY_CHANNEL_TYPE, 1);     // Catch: Exception -> L16 Throwable -> L20
        a(r10);     // Catch: Exception -> L16 Throwable -> L20
    L16:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L20
        goto L18
    L11:
        if (r11.size() < 1) goto L13;
        r12 = this.f13996n.get(0);     // Catch: Throwable -> L20
    L18:
        monitor-exit(this);     // Catch: Throwable -> L20
        return;
    L20:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public final void init(Context r8, IWsChannelClient r10) {
        IWsChannelClient r11 = this.f13998p;
        if (r11 != null) goto L12;
        return;
    L12:
        r11.init(r8, r10);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        if ((this.f13998p instanceof z5.a) == true) goto L10;
        th.printStackTrace();
        Logger.d("WsChannelClient", "cronet长连接初始化失败，用ok实现");
        int r12 = this.f13993a;
        z5.a r13 = new z5.a(this.f13994b, r12);
        this.f13998p = r13;
        r13.init(r8, r10);
        return;
    L10:
        throw th;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public final boolean isConnected() {
        IWsChannelClient r8 = this.f13998p;
        if (r8 != null) goto L5;
        return false;
    L5:
        return r8.isConnected();
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public final void onAppStateChanged(int r8) {
        IWsChannelClient r10 = this.f13998p;
        if (r10 == null) goto L6;
        r10.onAppStateChanged(r8);
        return;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public final void onConnection(JSONObject r8) {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.f13995m == false) goto L7;
        monitor-exit(this);     // Catch: Throwable -> L10
        return;
    L7:
        a(r8);     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public final void onMessage(byte[] r8) {
        a r10 = this.f13999q;
        if (r10 == null) goto L22;
        int r11 = this.f13993a;
        com.bytedance.common.wschannel.server.b r12 = (com.bytedance.common.wschannel.server.b) r10;
        if (r8 == null) goto L23;
        WsChannelService.a r13 = new WsChannelService.a();     // Catch: Throwable -> L15
        r13.f3927a = r11;     // Catch: Throwable -> L15
        r13.f3928b = r8;     // Catch: Throwable -> L15
        r12.f3935e.offer(r13);     // Catch: Throwable -> L15
        com.bytedance.common.wschannel.server.b.f3930h.getAndSet(true);     // Catch: Throwable -> L15
        if (r12.f3937g != null) goto L18;
        r12.f3937g = new com.bytedance.common.wschannel.server.a(r12);     // Catch: Throwable -> L15
    L18:
        r12.f3936f.submit(r12.f3937g);     // Catch: Throwable -> L12
        r12.getClass();     // Catch: Throwable -> L12
    L24:
        return;
    L12:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        th.printStackTrace();
        return;
    L23:
        return;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public final void onNetworkStateChanged(int r8) {
        IWsChannelClient r10 = this.f13998p;
        if (r10 == null) goto L6;
        r10.onNetworkStateChanged(r8);
        return;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public final void onParameterChange(Map<String, Object> r8, List<String> r10) {
        IWsChannelClient r11 = this.f13998p;
        if (r11 == null) goto L5;
        r11.onParameterChange(r8, r10);
    L5:
        this.f13996n = r10;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public final void openConnection(Map<String, Object> r8, List<String> r10) {
        IWsChannelClient r11 = this.f13998p;
        if (r11 == null) goto L5;
        r11.openConnection(r8, r10);
    L5:
        this.f13996n = r10;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public final boolean sendMessage(byte[] r8) {
        IWsChannelClient r10 = this.f13998p;
        if (r10 != null) goto L5;
        return false;
    L5:
        return r10.sendMessage(r8);
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public final void stopConnection() {
        IWsChannelClient r8 = this.f13998p;
        if (r8 == null) goto L6;
        r8.stopConnection();
        return;
    }
}
