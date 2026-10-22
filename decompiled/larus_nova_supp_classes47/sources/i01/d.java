package i01;

import android.view.View;
import com.bytedance.android.live.revenue.core.util.e;
import com.bytedance.android.live.revenue.core.util.j;
import com.bytedance.android.livesdk.revenue.service.toolbar.f;
import com.bytedance.android.livesdk.revenue.toolbar.RevResKeyEnum;
import com.bytedance.android.livesdk.revenue.toolbar.RevToolbarConstants;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.scope.o;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import zr2.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d implements h01.a, o, b11.a {
    public final com.bytedance.android.livesdk.revenue.service.toolbar.a a;
    public final com.bytedance.android.livesdk.revenue.service.toolbar.b b;
    public final f c;
    public final com.bytedance.android.live.revenue.core.a d;

    public final void onStop() {
    }

    @Override // b11.a
    public final List<Object> V() {
        return this.c.V();
    }

    public final void onStart() {
        com.bytedance.android.live.revenue.core.a r0 = this.d;
        r0.b(b11.a.class, r0.getScope());
    }

    @Override // h01.a
    public final void Za(RevToolbarConstants r2) {
        Intrinsics.checkNotNullParameter(r2, "constants");
        this.b.ro(r2);
    }

    @Override // h01.a
    public final void s0(RevToolbarConstants r2) {
        Intrinsics.checkNotNullParameter(r2, "constants");
        this.b.s0(r2);
    }

    @Override // h01.a
    public final void f5(RevToolbarConstants r2, k r3) {
        Intrinsics.checkNotNullParameter(r2, "constants");
        Intrinsics.checkNotNullParameter(r3, "behavior");
        Za(r2);
    }

    @Override // h01.a
    public final void k1(boolean r2, View r3) {
        this.a.k1(r2, r3);
    }

    @Override // h01.a
    public final void y9(DataCenter r3, boolean r4) {
        vh6.c.b(com.bytedance.android.livesdk.revenue.service.toolbar.a.class).Zb(r3);
        if (r3 == null) goto L7;
        Boolean r0 = (Boolean) r3.get("data_is_portrait", Boolean.TRUE);
        if (r0 == null) goto L7;
        boolean r1 = r0.booleanValue();
    L8:
        if (r4 == false) goto L14;
        if (r1 == true) goto L15;
        com.bytedance.android.livesdk.revenue.service.vs.b r5 = (dy0.b) e.c(j.C0.a(), com.bytedance.android.livesdk.revenue.service.vs.b.class);
        if (r5 == null) goto L16;
        r5.j2(r3);
        return;
    L16:
        return;
    L15:
        return;
    L14:
        return;
    L7:
        r1 = true;
        goto L8
    }

    @Override // h01.a
    public final void Ye(RevToolbarConstants r4, k r5, Function1<? super h01.d, Unit> r6) {
        Intrinsics.checkNotNullParameter(r4, "constants");
        Intrinsics.checkNotNullParameter(r5, "behavior");
        Intrinsics.checkNotNullParameter(r6, "builder");
        c r0 = new c();
        r6.invoke(r0);
        b r7 = r0.a;
        a r1 = r0.b;
        this.c.u7(r4, r5, new as2.a(r7.a));
        Function1<? super Long, Boolean> r8 = r1.a;
        if (r8 == null) goto L6;
        this.b.g4(r4, r8);
        return;
    }

    public d(com.bytedance.android.livesdk.revenue.service.toolbar.a r2, com.bytedance.android.livesdk.revenue.service.toolbar.b r3, f r4, com.bytedance.android.live.revenue.core.a r5) {
        Intrinsics.checkNotNullParameter(r2, "service");
        Intrinsics.checkNotNullParameter(r3, "animService");
        Intrinsics.checkNotNullParameter(r4, "roomService");
        Intrinsics.checkNotNullParameter(r5, "instance");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }

    @Override // h01.a
    public final String W6(RevToolbarConstants r2, IRoom r3, boolean r4, RevResKeyEnum r5) {
        Intrinsics.checkNotNullParameter(r2, "constants");
        Intrinsics.checkNotNullParameter(r3, "room");
        Intrinsics.checkNotNullParameter(r5, "resKeyEnum");
        if (this.a.Z3() == true) goto L5;
        return null;
    L5:
        return this.a.Ke(r2, r3, r4).a(r5);
    }

    @Override // h01.a
    public final boolean wk(RevToolbarConstants r2, IRoom r3, boolean r4, RevResKeyEnum r5) {
        Intrinsics.checkNotNullParameter(r2, "constants");
        Intrinsics.checkNotNullParameter(r3, "room");
        Intrinsics.checkNotNullParameter(r5, "resKeyEnum");
        if (this.a.Z3() == false) goto L13;
        if (W6(r2, r3, r4, r5) == null) goto L7;
    L10:
        return true;
    L7:
        if (this.a.lf(r2, r3, r4) == true) goto L10;
        return false;
    L13:
        return this.a.lf(r2, r3, r4);
    }
}
