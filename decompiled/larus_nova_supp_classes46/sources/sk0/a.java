package sk0;

import com.bytedance.android.live.pushstream.d;
import com.bytedance.android.livesdk.live.extension.plugin.api.livepusher.ILiveWrappedLivePusher;
import fr2.m0;
import kotlin.jvm.internal.Intrinsics;
import uf2.b1;
import uf2.d0;
import uf2.h0;
import uf2.y0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a {
    public final d a;
    public final d0 b;

    /* JADX INFO: renamed from: sk0.a$a, reason: collision with other inner class name */
    public static final class C0273a implements h0.d {
        public C0273a(kb6.a r1) {
        }
    }

    public final String b() {
        return this.a.j1();
    }

    public final m0 c() {
        d0.a r1 = this.a.y0();
        if (r1 == null) goto L5;
        Integer r2 = Integer.valueOf(r1.f0());
    L6:
        d0.a r3 = this.a.y0();
        int r4 = 0;
        if (r3 == null) goto L9;
        int r5 = r3.getVideoWidth();
    L10:
        d0.a r6 = this.a.y0();
        if (r6 == null) goto L13;
        int r7 = r6.getVideoHeight();
    L14:
        d0.a r8 = this.a.y0();
        if (r8 == null) goto L18;
        r4 = r8.g();
    L18:
        return new m0(r2, r5, r7, r4);
    L13:
        r7 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = null;
        goto L6
    }

    public final void d() {
        this.a.I();
    }

    public final void g() {
        this.a.s();
    }

    public final void a(boolean r1) {
        this.b.R();
    }

    public final void e(kb6.b r5) {
        Intrinsics.checkNotNullParameter(r5, "tag");
        d r0 = this.a;
        y0.a r1 = y0.a;
        int r2 = r5.a;
        String r3 = String.valueOf(r5.b);
        String r6 = String.valueOf(r5.c);
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "businessType");
        Intrinsics.checkNotNullParameter(r6, "sceneType");
        ILiveWrappedLivePusher.Companion.getClass();
        ILiveWrappedLivePusher r4 = ILiveWrappedLivePusher.a.b();
        if (r4 == null) goto L5;
        r4.newLiveStreamBusinessTag(r2, r3, r6);
    L5:
        r0.L();
    }

    public final void f(boolean r2) {
        this.a.O(r2);
    }

    public final void h(String r2) {
        Intrinsics.checkNotNullParameter(r2, "params");
        this.a.y(r2);
    }

    public final void j(b1 r2) {
        this.a.l1(r2);
    }

    public a(d r2, d0 r3) {
        Intrinsics.checkNotNullParameter(r2, "liveStream");
        Intrinsics.checkNotNullParameter(r3, "liveCore");
        this.a = r2;
        this.b = r3;
    }

    public final void i(String r3, kb6.a r4) {
        Intrinsics.checkNotNullParameter(r3, "params");
        d r0 = this.a;
        if (r4 != null) goto L5;
        C0273a r5 = null;
    L6:
        r0.H0(r3, r5);
        return;
    L5:
        r5 = new C0273a(r4);
        goto L6
    }
}
