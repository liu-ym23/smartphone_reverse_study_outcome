package z5;

import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.channel.IWsChannelClient;

/* JADX INFO: loaded from: classes.dex */
public final class i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ jf.g f14266a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b.e f14267b;

    public i(b.e r8, jf.g r10) {
        this.f14267b = r8;
        this.f14266a = r10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Logger.d("WsChannelSdk_ok", "----------onMessage--------");
        b.f r8 = this.f14267b.f14247c.f14234u;
        if (r8 == null) goto L8;
        n r10 = (n) r8;
        r10.getClass();
        StringBuilder r11 = new StringBuilder("onMessage() : ");
        jf.g r12 = this.f14266a;
        r11.append(r12.toString());
        Logger.d("WsChannelSdk_ok", r11.toString());
        IWsChannelClient r13 = r10.f14277a;
        if (r13 == null) goto L9;
        r13.onMessage(r12.o());
        return;
    L9:
        return;
    }
}
