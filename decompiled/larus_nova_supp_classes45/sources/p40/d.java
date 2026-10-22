package p40;

import com.bytedance.android.live.componentsmarket.api.draggable.DraggableComponentState;
import com.bytedance.android.live.componentsmarket.impl.components.draggablecomponent.dragger.DraggableContainerView;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;
import kotlin.TuplesKt;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d<T> implements Consumer {
    public final /* synthetic */ a a;

    public d(a r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        Unit r5 = (Unit) r4;
        DraggableContainerView.b r6 = this.a.j.getDragCallback();
        if ((r6 instanceof q40.a) == true) goto L5;
        r6 = null;
    L5:
        q40.a r7 = (q40.a) r6;
        if (r7 == null) goto L12;
        PropertyOwner r8 = r7.e;
        if (r8 == null) goto L12;
        if (((Boolean) r8.a).booleanValue() != true) goto L12;
        return;
    L12:
        a r9 = this.a;
        if (r9.j.getWidth() == ((Number) r9.p.getFirst()).intValue()) goto L15;
    L16:
        r9.p = TuplesKt.to(Integer.valueOf(r9.j.getWidth()), Integer.valueOf(r9.j.getHeight()));
        ALogger.d("DraggableComponentView", "onExpandViewSizeChange: " + r9.p);
        if (r9.t == false) goto L23;
        l40.a r0 = r9.q(DraggableComponentState.Style.DEFAULT, 0);
        if (r0 == null) goto L24;
        r0.a = System.currentTimeMillis();
        r9.o(new k40.b(l40.a.a(r0)));
        return;
    L24:
        return;
    L23:
        return;
    L15:
        if (r9.j.getHeight() != ((Number) r9.p.getSecond()).intValue()) goto L16;
    }
}
