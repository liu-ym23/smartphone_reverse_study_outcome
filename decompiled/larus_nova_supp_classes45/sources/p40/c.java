package p40;

import com.bytedance.android.live.componentsmarket.api.draggable.DraggableComponentState;
import com.bytedance.android.live.componentsmarket.impl.components.draggablecomponent.dragger.RegionId;
import k40.g;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c implements q40.a.b {
    public Pair<? extends RegionId, g> a;
    public Pair<? extends RegionId, g> b;
    public final /* synthetic */ a c;
    public final /* synthetic */ DraggableComponentState.Style d;
    public final /* synthetic */ int e;

    @Override // q40.a.b
    public final void a(Pair<? extends RegionId, g> r4) {
        this.b = r4;
        Pair<? extends RegionId, g> r5 = this.a;
        g r0 = null;
        if (r5 == null) goto L5;
        RegionId r6 = (RegionId) r5.getFirst();
    L6:
        Pair<? extends RegionId, g> r1 = this.b;
        if (r1 == null) goto L9;
        RegionId r2 = (RegionId) r1.getFirst();
    L10:
        boolean r3 = true;
        if (r6 != r2) goto L23;
        Pair<? extends RegionId, g> r7 = this.a;
        if (r7 == null) goto L15;
        g r8 = (g) r7.getSecond();
    L16:
        Pair<? extends RegionId, g> r9 = this.b;
        if (r9 == null) goto L20;
        r0 = (g) r9.getSecond();
    L20:
        if ((!Intrinsics.areEqual(r8, r0)) == true) goto L23;
        r3 = false;
        goto L23
    L15:
        r8 = null;
    L23:
        if (r3 == false) goto L29;
        l40.a r11 = this.c.q(this.d, this.e);
        if (r11 != null) goto L27;
        return;
    L27:
        this.c.o(new k40.b(r11));
        return;
    L29:
        return;
    L9:
        r2 = null;
        goto L10
    L5:
        r6 = null;
        goto L6
    }

    @Override // q40.a.b
    public final void b(Pair<? extends RegionId, g> r2) {
        this.a = r2;
        a r3 = this.c;
        r3.t(r3.j.getWidth());
    }

    @Override // q40.a.b
    public final void c(RegionId r3) {
        Intrinsics.checkNotNullParameter(r3, "currentRegion");
        a r0 = this.c;
        r0.s(r3, r0.j.getWidth());
    }

    public c(a r1, DraggableComponentState.Style r2, int r3) {
        this.c = r1;
        this.d = r2;
        this.e = r3;
    }
}
