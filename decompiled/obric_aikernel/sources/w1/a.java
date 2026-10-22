package w1;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.channel.IWsChannelClient;
import com.bytedance.common.wschannel.j;
import com.bytedance.common.wschannel.l;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a implements IWsChannelClient, WeakHandler.IHandler {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f13240c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Context f13241g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Handler f13242h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private c f13243i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f13244j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Map<String, Object> f13245k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private List<String> f13246l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private ContentObserver f13247m;

    /* JADX INFO: renamed from: w1.a$a, reason: collision with other inner class name */
    class C0309a extends ContentObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f13248a;

        C0309a(a r10, Handler r11) {
            this.f13248a = r10;
            super(r11);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean r10) {
            super.onChange(r10);
            a r11 = this.f13248a;
            if (a.b(r11, a.a(r11)) == false) goto L5;
            a r12 = this.f13248a;
            r12.openConnection(a.c(r12), a.d(this.f13248a));
            return;
        L5:
            this.f13248a.stopConnection();
        }
    }

    static {
    }

    public a(int r10, Handler r11) {
        this.f13245k = new HashMap();
        this.f13240c = r10;
        this.f13242h = r11;
        this.f13247m = new C0309a(this, this.f13242h);
    }

    static /* synthetic */ Context a(a r10) {
        return r10.f13241g;
    }

    static /* synthetic */ boolean b(a r10, Context r11) {
        return r10.g(r11);
    }

    static /* synthetic */ Map c(a r10) {
        return r10.f13245k;
    }

    static /* synthetic */ List d(a r10) {
        return r10.f13246l;
    }

    private void e(Context r10) {
        System.currentTimeMillis();
        Class<?> r11 = Class.forName("com.bytedance.mobsec.metasec.ov.MSB");     // Catch: ClassNotFoundException -> L5
    L6:
        if (r11 != null) goto L16;
        return;
    L16:
        r11.getMethod("a", new Class[]{Context.class, Integer.TYPE, Map.class}).invoke(r11, new Object[]{r10, 2, null});     // Catch: Throwable -> L10
    L12:
        System.currentTimeMillis();
        return;
    L10:
        th = move-exception;
        th.printStackTrace();
    L5:
        Log.d("WsChannelSdk_ok", "MSSdk Class -com.bytedance.mobsec.metasec.ov.MSB- not found, init fail.");
        r11 = null;
        goto L6
    }

    private void f(Context r10) {
        r10.getContentResolver().registerContentObserver(WsChannelMultiProcessSharedProvider.h(r10, WsConstants.KEY_OK_IMPL_ENABLE, TypedValues.Custom.S_BOOLEAN), true, this.f13247m);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    private boolean g(Context r10) {
        return l.f(r10).i();
    }

    private void h() {
        Context r10 = this.f13241g;     // Catch: Throwable -> L6
        if (r10 == null) goto L11;
        r10.getContentResolver().unregisterContentObserver(this.f13247m);     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        th.printStackTrace();
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void destroy() {
        Log.d("WsChannelSdk_ok", "destroy() , channelId = " + this.f13240c);
        this.f13243i.x();
        h();
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public void handleMsg(Message r10) {
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void init(Context r10, IWsChannelClient r11) {
        if (this.f13244j == false) goto L5;
        return;
    L5:
        this.f13244j = true;
        Log.d("WsChannelSdk_ok", "init() , channelId = " + this.f13240c);
        this.f13241g = r10.getApplicationContext();
        e(r10);
        c r12 = new c.h(r10).c(new x1.c(r10)).b(j.g(this.f13240c)).a();
        this.f13243i = r12;
        r12.Z(new e(this.f13241g, r12, r11));
        f(r10);
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public boolean isConnected() {
        return this.f13243i.H();
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void onAppStateChanged(int r10) {
        if (g(this.f13241g) == true) goto L5;
        return;
    L5:
        Log.d("WsChannelSdk_ok", "onAppStateChanged(), channelId = " + this.f13240c);
        c r11 = this.f13243i;
        boolean r12 = true;
        if (r10 == 1) goto L9;
        r12 = false;
    L9:
        r11.L(r12);
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void onConnection(JSONObject r10) {
        Log.d("WsChannelSdk_ok", "onConnection()");
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void onMessage(WsChannelMsg r10) {
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void onMessage(byte[] r10) {
        Log.d("WsChannelSdk_ok", "onMessage(),channel = " + this.f13240c);
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void onNetworkStateChanged(int r10) {
        if (g(this.f13241g) == true) goto L5;
        return;
    L5:
        Log.d("WsChannelSdk_ok", "onNetworkStateChanged(), channelId = " + this.f13240c);
        this.f13243i.M(r10);
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void onParameterChange(Map<String, Object> r10, List<String> r11) {
        if (r10 == null) goto L4;
        this.f13245k.putAll(r10);
    L4:
        this.f13246l = r11;
        if (g(this.f13241g) == true) goto L7;
        return;
    L7:
        Log.d("WsChannelSdk_ok", "onParameterChange(),channelId = " + this.f13240c);
        this.f13243i.N(r10, r11);
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void onServiceConnectEvent(int r10, boolean r11, String r12) {
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void openConnection(Map<String, Object> r10, List<String> r11) {
        if (r10 == null) goto L4;
        this.f13245k.putAll(r10);
    L4:
        this.f13246l = r11;
        if (g(this.f13241g) == true) goto L7;
        return;
    L7:
        this.f13243i.v(r10, r11);
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public boolean privateProtocolEnabled() {
        return false;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public boolean privateProtocolProxyEnabled() {
        return false;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void registerService(int r10) {
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public boolean sendMessage(WsChannelMsg r10) {
        return false;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public boolean sendMessage(byte[] r10) {
        if (g(this.f13241g) == true) goto L6;
        return false;
    L6:
        Log.d("WsChannelSdk_ok", "sendMessage(),channelId = " + this.f13240c);
        return this.f13243i.W(r10);
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void stopConnection() {
        Log.d("WsChannelSdk_ok", "stopConnection(),channelId = " + this.f13240c);
        this.f13243i.a0();
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void unregisterService(int r10) {
    }
}
