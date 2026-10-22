package z5;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.channel.IWsChannelClient;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class a implements IWsChannelClient, WeakHandler.IHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f14215a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f14216b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Handler f14217m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public b f14218n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f14219o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final HashMap f14220p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public List<String> f14221q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final C0202a f14222r;

    /* JADX INFO: renamed from: z5.a$a, reason: collision with other inner class name */
    public class C0202a extends ContentObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f14223a;

        public C0202a(a r8, Handler r10) {
            this.f14223a = r8;
            super(r10);
        }

        @Override // android.database.ContentObserver
        public final void onChange(boolean r8) {
            super.onChange(r8);
            a r10 = this.f14223a;
            if (a.a(r10.f14216b) == false) goto L5;
            r10.openConnection(r10.f14220p, r10.f14221q);
            return;
        L5:
            r10.stopConnection();
        }
    }

    public a(Handler r8, int r10) {
        this.f14220p = new HashMap();
        this.f14222r = new C0202a(this, this.f14217m);
        this.f14215a = r10;
        this.f14217m = r8;
    }

    public static boolean a(Context r8) {
        return com.bytedance.common.wschannel.a.a(r8).f3869a.a(WsConstants.KEY_OK_IMPL_ENABLE, true);
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public final void destroy() {
        Log.d("WsChannelSdk_ok", "destroy() , channelId = " + this.f14215a);
        b r8 = this.f14218n;
        WeakHandler r10 = r8.f14232s;
        r10.removeMessages(2);
        r10.removeMessages(1);
        r10.removeMessages(3);
        r10.removeMessages(5);
        r8.s(new e(r8));
        Context r11 = this.f14216b;     // Catch: Throwable -> L7
        if (r11 == null) goto L12;
        r11.getContentResolver().unregisterContentObserver(this.f14222r);     // Catch: Throwable -> L7
        return;
    L12:
        return;
    L7:
        th = move-exception;
        th.printStackTrace();
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public final void handleMsg(Message r8) {
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public final void init(Context r8, IWsChannelClient r10) {
        if (this.f14219o == false) goto L5;
        return;
    L5:
        this.f14219o = true;
        StringBuilder r11 = new StringBuilder("init() , channelId = ");
        int r12 = this.f14215a;
        r11.append(r12);
        Log.d("WsChannelSdk_ok", r11.toString());
        this.f14216b = r8.getApplicationContext();
        b.c r13 = new b.c(r8);
        r13.f14241a = new a6.b(r8);
        f6.a r14 = (f6.a) w5.c.f12988d.get(Integer.valueOf(r12));
        if (r14 == null) goto L8;
        r13.f14242b = r14;
    L8:
        b r15 = new b(new b.d(r8, r13.f14241a, r13.f14242b));
        this.f14218n = r15;
        r15.f14234u = new n(this.f14216b, r10);
        r8.getContentResolver().registerContentObserver(WsChannelMultiProcessSharedProvider.a(r8, WsConstants.KEY_OK_IMPL_ENABLE, "boolean"), true, this.f14222r);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        th.printStackTrace();
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public final boolean isConnected() {
        b r8 = this.f14218n;
        monitor-enter(r8);
        int r10 = r8.f14228o;     // Catch: Throwable -> L11
        monitor-exit(r8);
        if (r10 != 4) goto L9;
        return true;
    L9:
        return false;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public final void onAppStateChanged(int r8) {
        if (a(this.f14216b) == true) goto L5;
        return;
    L5:
        Log.d("WsChannelSdk_ok", "onAppStateChanged(), channelId = " + this.f14215a);
        b r10 = this.f14218n;
        boolean r11 = true;
        if (r8 == 1) goto L9;
        r11 = false;
    L9:
        r10.f14232s.obtainMessage(5, Boolean.valueOf(r11)).sendToTarget();
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public final void onConnection(JSONObject r8) {
        Log.d("WsChannelSdk_ok", "onConnection()");
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public final void onMessage(byte[] r8) {
        Log.d("WsChannelSdk_ok", "onMessage(),channel = " + this.f14215a);
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public final void onNetworkStateChanged(int r8) {
        if (a(this.f14216b) == true) goto L5;
        return;
    L5:
        Log.d("WsChannelSdk_ok", "onNetworkStateChanged(), channelId = " + this.f14215a);
        this.f14218n.f14232s.obtainMessage(3, Integer.valueOf(r8)).sendToTarget();
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public final void onParameterChange(Map<String, Object> r8, List<String> r10) {
        if (r8 == null) goto L4;
        this.f14220p.putAll(r8);
    L4:
        this.f14221q = r10;
        if (a(this.f14216b) == true) goto L7;
        return;
    L7:
        Log.d("WsChannelSdk_ok", "onParameterChange(),channelId = " + this.f14215a);
        b r11 = this.f14218n;
        r11.getClass();
        if (r10.isEmpty() == false) goto L10;
        Logger.e("WsChannelSdk_ok", "error : no target ws url ,return");
        return;
    L10:
        r11.s(new g(r11, r8, r10));
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public final void openConnection(Map<String, Object> r8, List<String> r10) {
        if (r8 == null) goto L4;
        this.f14220p.putAll(r8);
    L4:
        this.f14221q = r10;
        if (a(this.f14216b) == true) goto L7;
        return;
    L7:
        b r11 = this.f14218n;
        r11.getClass();
        if (r10.isEmpty() == false) goto L10;
        Logger.e("WsChannelSdk_ok", "error : no target ws url ,return");
        return;
    L10:
        r11.s(new d(r11, r8, r10));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public final boolean sendMessage(byte[] r8) {
        if (a(this.f14216b) == true) goto L5;
        return false;
    L5:
        Log.d("WsChannelSdk_ok", "sendMessage(),channelId = " + this.f14215a);
        b r10 = this.f14218n;
        r10.getClass();
        jf.g r11 = jf.g.g(r8);
        Logger.d("WsChannelSdk_ok", "send msg : " + r11);
        if (r10.f14235v == null) goto L22;
        monitor-enter(r10);
        int r12 = r10.f14228o;     // Catch: Throwable -> L19
        monitor-exit(r10);
        if (r12 != 4) goto L13;
        boolean r13 = true;
    L14:
        if (r13 == false) goto L25;
        boolean r14 = r11 instanceof String;
        b6.c r15 = r10.f14235v;
        if (r14 == false) goto L27;
        r15.getClass();
        return r15.i(1, jf.g.d((String) r11));
    L27:
        return r15.i(2, r11);
    L25:
        return false;
    L13:
        r13 = false;
    L19:
        th = move-exception;
        throw th;
    L22:
        return false;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public final void stopConnection() {
        Log.d("WsChannelSdk_ok", "stopConnection(),channelId = " + this.f14215a);
        b r8 = this.f14218n;
        r8.getClass();
        r8.s(new c(r8));
    }
}
