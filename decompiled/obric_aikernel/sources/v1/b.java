package v1;

import android.content.Context;
import android.os.Handler;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.g;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.channel.IWsChannelClient;
import com.bytedance.common.wschannel.model.ServiceConnectEvent;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b implements IWsChannelClient {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static String f13165l = "";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f13166c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Handler f13167g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private List<String> f13168h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f13169i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private IWsChannelClient f13170j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private a f13171k;

    static {
    }

    private b(int r10, a r11, Handler r12) {
        this.f13169i = true;
        this.f13166c = r10;
        this.f13171k = r11;
        this.f13167g = r12;
        e();     // Catch: Throwable -> L9 ClassNotFoundException -> L11
        if (this.f13169i == false) goto L7;
        String r13 = "use cronet to connect";
    L6:
        Logger.d("WsChannelClient", r13);     // Catch: Throwable -> L9 ClassNotFoundException -> L11
    L14:
        if (this.f13170j != null) goto L19;
        Logger.d("WsChannelClient", "use okhttp to connect");
        this.f13170j = new w1.a(r10, r12);
        return;
    L19:
        return;
    L7:
        r13 = "use PushManager to connect";
    L11:
        String r14 = "don't find plugin or plugin download failed";
    L12:
        Logger.d("WsChannelClient", r14);
    L9:
        th = move-exception;
        th.printStackTrace();
        r14 = "don't find plugin";
        goto L12
    }

    private Class<?> a(String r10) {
        return Class.forName(r10);
    L4:
        return null;
    }

    public static b c(int r10, a r11, Handler r12) {
        return new b(r10, r11, r12);
    }

    private void d(JSONObject r10) {
        a r11 = this.f13171k;
        if (r11 == null) goto L6;
        r11.d(this, this.f13166c, r10);
        return;
    }

    private void e() {
        if (this.f13170j != null) goto L17;
        Class<?> r10 = null;
        if (g.b(f13165l) == true) goto L7;
        r10 = a(f13165l);
    L7:
        if (r10 != null) goto L9;
        r10 = a("org.chromium.wschannel.MySelfChannelImpl");
        this.f13169i = true;
    L9:
        if (r10 != null) goto L11;
        r10 = a("com.b.c.ws.MySelfChannelImpl");
        this.f13169i = false;
    L11:
        if (r10 == null) goto L16;
        Object r11 = r10.newInstance();
        if ((r11 instanceof IWsChannelClient) == false) goto L18;
        this.f13170j = (IWsChannelClient) r11;
        return;
    L18:
        return;
    L16:
        throw new ClassNotFoundException("plugin class not found");
    }

    public boolean b() {
        return this.f13170j instanceof w1.a;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void destroy() {
        monitor-enter(this);
        IWsChannelClient r10 = this.f13170j;     // Catch: Throwable -> L19
        if (r10 == null) goto L17;
        r10.destroy();     // Catch: Throwable -> L19
        if ((this.f13170j instanceof w1.a) == true) goto L17;
        JSONObject r11 = new JSONObject();     // Catch: Throwable -> L19
        List<String> r12 = this.f13168h;     // Catch: Throwable -> L19
        if (r12 != null) goto L10;
    L12:
        String r13 = "";
    L24:
        r11.put(WsConstants.KEY_CONNECTION_TYPE, 0);     // Catch: Exception -> L15 Throwable -> L19
        r11.put("state", 3);     // Catch: Exception -> L15 Throwable -> L19
        r11.put("url", r13);     // Catch: Exception -> L15 Throwable -> L19
        r11.put(WsConstants.KEY_CHANNEL_TYPE, 1);     // Catch: Exception -> L15 Throwable -> L19
        d(r11);     // Catch: Exception -> L15 Throwable -> L19
    L15:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L19
        goto L17
    L10:
        if (r12.size() < 1) goto L12;
        r13 = this.f13168h.get(0);     // Catch: Throwable -> L19
    L17:
        monitor-exit(this);     // Catch: Throwable -> L19
        return;
    L19:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void init(Context r10, IWsChannelClient r11) {
        IWsChannelClient r12 = this.f13170j;
        if (r12 != null) goto L12;
        return;
    L12:
        r12.init(r10, r11);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        if ((this.f13170j instanceof w1.a) == true) goto L10;
        th.printStackTrace();
        Logger.d("WsChannelClient", "cronet socket init failed，use okhttp to connect");
        w1.a r13 = new w1.a(this.f13166c, this.f13167g);
        this.f13170j = r13;
        r13.init(r10, r11);
        return;
    L10:
        throw th;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public boolean isConnected() {
        IWsChannelClient r10 = this.f13170j;
        if (r10 != null) goto L5;
        return false;
    L5:
        return r10.isConnected();
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void onAppStateChanged(int r10) {
        IWsChannelClient r11 = this.f13170j;
        if (r11 == null) goto L6;
        r11.onAppStateChanged(r10);
        return;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void onConnection(JSONObject r10) {
        monitor-enter(this);
        d(r10);     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void onMessage(WsChannelMsg r10) {
        a r11 = this.f13171k;
        if (r11 == null) goto L6;
        r11.g(this.f13166c, r10);
        return;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void onMessage(byte[] r10) {
        a r11 = this.f13171k;
        if (r11 == null) goto L6;
        r11.f(this.f13166c, r10);
        return;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void onNetworkStateChanged(int r10) {
        IWsChannelClient r11 = this.f13170j;
        if (r11 == null) goto L6;
        r11.onNetworkStateChanged(r10);
        return;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void onParameterChange(Map<String, Object> r10, List<String> r11) {
        IWsChannelClient r12 = this.f13170j;
        if (r12 == null) goto L5;
        r12.onParameterChange(r10, r11);
    L5:
        this.f13168h = r11;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void onServiceConnectEvent(int r10, boolean r11, String r12) {
        a r13 = this.f13171k;
        if (r13 == null) goto L6;
        r13.b(new ServiceConnectEvent(this.f13166c, r10, r11, r12));
        return;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void openConnection(Map<String, Object> r10, List<String> r11) {
        IWsChannelClient r12 = this.f13170j;
        if (r12 == null) goto L5;
        r12.openConnection(r10, r11);
    L5:
        this.f13168h = r11;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public boolean privateProtocolEnabled() {
        IWsChannelClient r10 = this.f13170j;
        if (r10 != null) goto L5;
        return false;
    L5:
        return r10.privateProtocolEnabled();
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public boolean privateProtocolProxyEnabled() {
        IWsChannelClient r10 = this.f13170j;
        if (r10 != null) goto L5;
        return false;
    L5:
        return r10.privateProtocolProxyEnabled();
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void registerService(int r10) {
        IWsChannelClient r11 = this.f13170j;
        if (r11 == null) goto L6;
        r11.registerService(r10);
        return;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public boolean sendMessage(WsChannelMsg r10) {
        IWsChannelClient r11 = this.f13170j;
        if (r11 != null) goto L5;
        return false;
    L5:
        return r11.sendMessage(r10);
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public boolean sendMessage(byte[] r10) {
        IWsChannelClient r11 = this.f13170j;
        if (r11 != null) goto L5;
        return false;
    L5:
        return r11.sendMessage(r10);
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void stopConnection() {
        IWsChannelClient r10 = this.f13170j;
        if (r10 == null) goto L6;
        r10.stopConnection();
        return;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void unregisterService(int r10) {
        IWsChannelClient r11 = this.f13170j;
        if (r11 == null) goto L6;
        r11.unregisterService(r10);
        return;
    }
}
