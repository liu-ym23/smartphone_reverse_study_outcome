package z5;

import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.channel.IWsChannelClient;
import java.io.UnsupportedEncodingException;

/* JADX INFO: loaded from: classes.dex */
public final class j implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f14268a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b.e f14269b;

    public j(b.e r8, String r10) {
        this.f14269b = r8;
        this.f14268a = r10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Logger.d("WsChannelSdk_ok", "----------onMessage--------");
        b.f r8 = this.f14269b.f14247c.f14234u;
        if (r8 == null) goto L13;
        n r10 = (n) r8;
        r10.getClass();
        StringBuilder r11 = new StringBuilder("onMessage():");
        String r12 = this.f14268a;
        r11.append(r12);
        Logger.d("WsChannelSdk_ok", r11.toString());
        IWsChannelClient r13 = r10.f14277a;
        if (r13 == null) goto L14;
        r13.onMessage(r12.getBytes("UTF-8"));     // Catch: UnsupportedEncodingException -> L8
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        return;
    L14:
        return;
    }
}
