package j8;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.channel.IWsChannelClient;
import com.bytedance.ies.web.jsbridge2.p;
import g8.f;
import g8.g;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import okio.ByteString;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements IWsChannelClient, WeakHandler.IHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f18271a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f18272b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public e f18273c;
    public boolean d;
    public final HashMap e;
    public List f;
    public final a g;

    public b(int r5, Handler r10) {
        this.e = new HashMap();
        this.f18271a = r5;
        this.g = new a(this, r10, 0);
    }

    public static boolean a(Context r5) {
        return ((c5.a) g.d(r5).f17073b).b(WsConstants.KEY_OK_IMPL_ENABLE, true);
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public final void destroy() {
        Log.d("WsChannelSdk_ok", "destroy() , channelId = " + this.f18271a);
        e r5 = this.f18273c;
        r5.f18283i.removeMessages(2);
        WeakHandler r10 = r5.f18283i;
        r10.removeMessages(1);
        r10.removeMessages(3);
        r10.removeMessages(5);
        r10.post(new c(r5, 1));
        Context r11 = this.f18272b;     // Catch: Throwable -> L7
        if (r11 == null) goto L12;
        r11.getContentResolver().unregisterContentObserver(this.g);     // Catch: Throwable -> L7
        return;
    L12:
        return;
    L7:
        th = move-exception;
        th.printStackTrace();
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public final void init(Context r10, IWsChannelClient r11) {
        if (this.d == true) goto L17;
        this.d = true;
        StringBuilder r5 = new StringBuilder("init() , channelId = ");
        int r12 = this.f18271a;
        r5.append(r12);
        Log.d("WsChannelSdk_ok", r5.toString());
        this.f18272b = r10.getApplicationContext();
        k8.a r13 = new k8.a(r10);
        q8.b r14 = (q8.b) f.e.get(Integer.valueOf(r12));
        if (r14 != null) goto L9;
        r14 = null;
    L9:
        e r15 = new e(new p(r10, r13, r14));
        this.f18273c = r15;
        int r16 = 11;
        r15.f18284j = new com.lynx.animax.player.b(r16, this.f18272b, false, r11);
        r10.getContentResolver().registerContentObserver(WsChannelMultiProcessSharedProvider.b(r10, WsConstants.KEY_OK_IMPL_ENABLE, "boolean"), true, this.g);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        th.printStackTrace();
        return;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public final boolean isConnected() {
        return this.f18273c.h();
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public final void onAppStateChanged(int r5) {
        if (a(this.f18272b) == true) goto L5;
        return;
    L5:
        Log.d("WsChannelSdk_ok", "onAppStateChanged(), channelId = " + this.f18271a);
        e r10 = this.f18273c;
        boolean r11 = true;
        if (r5 == 1) goto L9;
        r11 = false;
    L9:
        r10.f18283i.obtainMessage(5, Boolean.valueOf(r11)).sendToTarget();
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public final void onConnection(JSONObject r5) {
        Log.d("WsChannelSdk_ok", "onConnection()");
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public final void onMessage(byte[] r5) {
        Log.d("WsChannelSdk_ok", "onMessage(),channel = " + this.f18271a);
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public final void onNetworkStateChanged(int r5) {
        if (a(this.f18272b) == true) goto L5;
        return;
    L5:
        Log.d("WsChannelSdk_ok", "onNetworkStateChanged(), channelId = " + this.f18271a);
        this.f18273c.f18283i.obtainMessage(3, Integer.valueOf(r5)).sendToTarget();
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public final void onParameterChange(Map r5, List r10) {
        if (r5 == null) goto L4;
        this.e.putAll(r5);
    L4:
        this.f = r10;
        if (a(this.f18272b) == true) goto L7;
        return;
    L7:
        Log.d("WsChannelSdk_ok", "onParameterChange(),channelId = " + this.f18271a);
        e r11 = this.f18273c;
        r11.getClass();
        if (r10.isEmpty() == false) goto L10;
        Logger.e("WsChannelSdk_ok", "error : no target ws url ,return");
        return;
    L10:
        r11.f18283i.post(new d(r11, r5, r10, 1));
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public final void openConnection(Map r5, List r10) {
        if (r5 == null) goto L4;
        this.e.putAll(r5);
    L4:
        this.f = r10;
        if (a(this.f18272b) == true) goto L7;
        return;
    L7:
        e r11 = this.f18273c;
        r11.getClass();
        if (r10.isEmpty() == false) goto L10;
        Logger.e("WsChannelSdk_ok", "error : no target ws url ,return");
        return;
    L10:
        d r12 = new d(r11, r5, r10, 0);
        r11.f18283i.post(r12);
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public final boolean sendMessage(byte[] r5) {
        if (a(this.f18272b) == true) goto L5;
        return false;
    L5:
        Log.d("WsChannelSdk_ok", "sendMessage(),channelId = " + this.f18271a);
        e r10 = this.f18273c;
        r10.getClass();
        ByteString r11 = ByteString.of(r5);
        Logger.d("WsChannelSdk_ok", "send msg : " + r11);
        if (r10.f18285k != null) goto L8;
        return false;
    L8:
        if (r10.h() == false) goto L13;
        if (r11 != null) goto L11;
        return false;
    L11:
        return r10.f18285k.c(r11);
    L13:
        return false;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public final void stopConnection() {
        Log.d("WsChannelSdk_ok", "stopConnection(),channelId = " + this.f18271a);
        e r5 = this.f18273c;
        r5.getClass();
        r5.f18283i.post(new c(r5, 0));
    }
}
