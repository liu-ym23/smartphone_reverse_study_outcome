package dn;

import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.service.ILynxImageService;
import g8.g;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f16672a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f16673b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ f f16674c;

    public e(f r5, int r10, int r11) {
        this.f16674c = r5;
        this.f16672a = r10;
        this.f16673b = r11;
    }

    @Override // java.lang.Runnable
    public final void run() {
        f r5 = this.f16674c;
        if (r5.X == false) goto L5;
    L10:
        uj.a r10 = r5.i0;
    L11:
        String r11 = r5.d;
        xn.e r12 = r5.a(this.f16672a, this.f16673b, r11);
        if (r12 == null) goto L15;
        r5.E = r12;
        g r13 = r5.f16679c;
        r13.getClass();
        TraceEvent.c("LynxImageServiceProxy.fetchImage");
        com.lynx.animax.player.b r14 = r5.g0;
        LynxContext r15 = r5.f16677b;
        ((ILynxImageService) r13.f17073b).fetchImage(r12, r14, r10, r15);
        TraceEvent.a(0, "LynxImageServiceProxy.fetchImage");
        return;
    L15:
        return;
    L5:
        if (r5.V == true) goto L10;
        if (r5.W == true) goto L10;
        r10 = null;
        goto L11
    }
}
