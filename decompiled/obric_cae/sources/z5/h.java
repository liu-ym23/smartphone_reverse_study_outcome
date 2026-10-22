package z5;

import com.bytedance.common.utility.Logger;
import we.a0;

/* JADX INFO: loaded from: classes.dex */
public final class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b6.d f14263a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a0 f14264b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ b.e f14265m;

    public h(b.e r8, b6.c r10, a0 r11) {
        this.f14265m = r8;
        this.f14263a = r10;
        this.f14264b = r11;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Logger.d("WsChannelSdk_ok", "----------onOpen--------");
        b.e r8 = this.f14265m;
        if (b.a(r8.f14247c) != this.f14263a) goto L8;
        b.d(r8.f14247c, 4);
        b.e(r8.f14247c);
        h6.b r10 = (h6.b) b.c(r8.f14247c);
        a0 r11 = this.f14264b;
        r10.b(r11);
        if (b.f(r8.f14247c) == null) goto L9;
        ((n) b.f(r8.f14247c)).c(r11);
        return;
    L9:
        return;
    }
}
