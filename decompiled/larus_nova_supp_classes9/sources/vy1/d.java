package vy1;

import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.livesdk.gift.grouplive.component.dragger.DraggableContainerView;
import io.reactivex.functions.Consumer;
import kotlin.TuplesKt;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d<T> implements Consumer {
    public final /* synthetic */ a a;

    public d(a r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        Unit r5 = (Unit) r4;
        DraggableContainerView.b r6 = this.a.j.getDragCallback();
        if ((r6 instanceof ry1.a) == true) goto L5;
        r6 = null;
    L5:
        ry1.a r7 = (ry1.a) r6;
        if (r7 == null) goto L12;
        PropertyOwner r8 = r7.e;
        if (r8 == null) goto L12;
        if (((Boolean) r8.a).booleanValue() != true) goto L12;
        return;
    L12:
        a r9 = this.a;
        if (r9.j.getWidth() == ((Number) r9.s.getFirst()).intValue()) goto L15;
    L16:
        r9.s = TuplesKt.to(Integer.valueOf(r9.j.getWidth()), Integer.valueOf(r9.j.getHeight()));
        jy0.b.a("GroupComponentView", "onExpandViewSizeChange: " + r9.s + ", lastLayout: " + r9.q);
        ty1.c r0 = r9.q;
        if (r0 == null) goto L21;
        r0.b = System.currentTimeMillis();
        r9.o(new com.bytedance.android.livesdk.gift.grouplive.component.b(ty1.c.a(r0), false));
        return;
    L21:
        return;
    L15:
        if (r9.j.getHeight() != ((Number) r9.s.getSecond()).intValue()) goto L16;
    }
}
