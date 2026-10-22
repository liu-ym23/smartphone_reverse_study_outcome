package j6;

import com.bytedance.common.wschannel.channel.IWsChannelClient;

/* JADX INFO: loaded from: classes.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IWsChannelClient f8730a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.common.wschannel.server.b f8731b;

    public f(com.bytedance.common.wschannel.server.b r8, IWsChannelClient r10) {
        this.f8731b = r8;
        this.f8730a = r10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        byte[] r8 = a.e(this.f8731b.f3931a).a();
        this.f8730a.sendMessage(r8);
    }
}
