package z5;

import android.util.Pair;
import com.bytedance.common.utility.Logger;

/* JADX INFO: loaded from: classes.dex */
public final class l implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b6.d f14271a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f14272b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ String f14273m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final /* synthetic */ b.e f14274n;

    public l(b.e r8, b6.c r10, String r11, int r12, String r13) {
        this.f14274n = r8;
        this.f14271a = r10;
        this.f14272b = r11;
        this.f14273m = r13;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Logger.d("WsChannelSdk_ok", "----------onClosed--------");
        b.e r8 = this.f14274n;
        if (b.a(r8.f14247c) != this.f14271a) goto L15;
        b r10 = r8.f14247c;
        b.d(r10, 3);
        b.b(r10);
        ((h6.b) b.c(r10)).c();
        if (b.f(r10) == null) goto L8;
        ((n) b.f(r10)).a(this.f14272b, this.f14273m);
    L8:
        if (b.g(r10) == false) goto L12;
        b.h(r10);
        b.j(r10, b.i(r10).b());
        return;
    L12:
        if (b.o(r10) == true) goto L16;
        Pair r11 = b.i(r10).a(null);
        b.k(r10, ((Long) r11.second).longValue(), (String) r11.first, true);
        return;
    L16:
        return;
    }
}
