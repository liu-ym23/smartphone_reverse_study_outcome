package m1;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class h extends com.lynx.tasm.utils.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f19968b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ i f19969c;
    public final /* synthetic */ String d;

    public h(String r5, i r10, String r11) {
        this.f19968b = r5;
        this.f19969c = r10;
        this.d = r11;
    }

    @Override // com.lynx.tasm.utils.a
    public final void d() {
        if (td.d.f22127b == null) goto L6;
        final j r5 = (j) this.f19969c.g.b(j.class);
        final String r10 = this.f19968b;
        Intrinsics.checkNotNullParameter(r10, "traceId");
        final String r11 = this.d;
        Intrinsics.checkNotNullParameter(r11, "eventName");
        final long r12 = System.currentTimeMillis();
        a3.i.a(new a3.h(r10, r5, r12, r11));
        return;
    }

    @Override // com.lynx.tasm.utils.a
    public final void l() {
        if (td.d.f22127b == null) goto L6;
        i2.c r5 = this.f19969c.d;
        String r10 = this.f19968b;
        Intrinsics.checkNotNullParameter(r10, "traceId");
        a3.i.a(new a3.d(r10, System.currentTimeMillis(), r5, 0));
        return;
    }
}
