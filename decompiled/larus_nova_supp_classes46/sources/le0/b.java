package le0;

import com.bytedance.android.live.pushstream.d;
import com.bytedance.android.live.pushstream.model.LiveRequestSourceRole;
import fr2.m0;
import kotlin.jvm.internal.Intrinsics;
import uf2.d0;
import uf2.x;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b implements pf6.a {
    public d a;
    public d0 b;

    public b() {
    }

    public static boolean d() {
        return ((Boolean) vm2.d.G.getValue(null, vm2.d.a[30])).booleanValue();
    }

    public final void M() {
        if (d() == false) goto L7;
        d r0 = this.a;
        if (r0 == null) goto L11;
        r0.M();
        return;
    L11:
        return;
    L7:
        d0 r1 = this.b;
        if (r1 == null) goto L13;
        r1.I();
        return;
    }

    public final boolean a() {
        if (d() == false) goto L7;
        d r0 = this.a;
        if (r0 == null) goto L10;
        Boolean r1 = Boolean.valueOf(r0.a());
    L11:
        if (r1 != null) goto L15;
        return false;
    L15:
        return r1.booleanValue();
    L10:
        r1 = null;
        goto L11
    L7:
        d0 r2 = this.b;
        if (r2 == null) goto L10;
        r1 = Boolean.valueOf(r2.a());
        goto L11
    }

    public final x b() {
        if (d() == false) goto L9;
        d r0 = this.a;
        if (r0 == null) goto L12;
        d0 r1 = r0.A();
        if (r1 == null) goto L12;
        return r1.b();
    L12:
        return null;
    L9:
        d0 r2 = this.b;
        if (r2 == null) goto L12;
        return r2.b();
    }

    public final void s() {
        if (d() == false) goto L7;
        d r0 = this.a;
        if (r0 == null) goto L11;
        r0.s();
        return;
    L11:
        return;
    L7:
        d0 r1 = this.b;
        if (r1 == null) goto L13;
        r1.s();
        return;
    }

    public final m0 y0() {
        Integer r1 = null;
        if (d() == false) goto L7;
        d r0 = this.a;
        if (r0 == null) goto L10;
        d0.a r2 = r0.y0();
    L12:
        if (r2 == null) goto L14;
        r1 = Integer.valueOf(r2.f0());
    L14:
        int r3 = 0;
        if (r2 == null) goto L17;
        int r4 = r2.getVideoWidth();
    L18:
        if (r2 == null) goto L20;
        int r5 = r2.getVideoHeight();
    L21:
        if (r2 == null) goto L24;
        r3 = r2.g();
    L24:
        return new m0(r1, r4, r5, r3);
    L20:
        r5 = 0;
        goto L21
    L17:
        r4 = 0;
    L10:
        r2 = null;
        goto L12
    L7:
        d0 r6 = this.b;
        if (r6 == null) goto L10;
        r2 = r6.getBuilder();
        goto L12
    }

    public final void B(String r1) {
        if (d() == false) goto L9;
        d r2 = this.a;
        if (r2 == null) goto L13;
        d0 r3 = r2.A();
        if (r3 == null) goto L14;
        r3.v();
        return;
    L14:
        return;
    L13:
        return;
    L9:
        d0 r4 = this.b;
        if (r4 == null) goto L16;
        r4.v();
        return;
    }

    public final void O(boolean r2) {
        if (d() == false) goto L7;
        d r0 = this.a;
        if (r0 == null) goto L11;
        r0.O(r2);
        return;
    L11:
        return;
    L7:
        d0 r3 = this.b;
        if (r3 == null) goto L13;
        r3.o0();
        return;
    }

    public final void t(boolean r2) {
        if (d() == false) goto L7;
        d r0 = this.a;
        if (r0 == null) goto L11;
        r0.t(r2);
        return;
    L11:
        return;
    L7:
        d0 r3 = this.b;
        if (r3 == null) goto L13;
        r3.N();
        return;
    }

    public final void c(boolean r6, String r7) {
        Intrinsics.checkNotNullParameter(r7, "reason");
        if (d() == false) goto L7;
        d r0 = this.a;
        if (r0 == null) goto L11;
        r0.R0(r6, r7, new uv0.a(LiveRequestSourceRole.Business, "LiveStreamWrapper.setAudioMuteRaw", null));
        return;
    L11:
        return;
    L7:
        d0 r8 = this.b;
        if (r8 == null) goto L13;
        r8.k();
        return;
    }
}
