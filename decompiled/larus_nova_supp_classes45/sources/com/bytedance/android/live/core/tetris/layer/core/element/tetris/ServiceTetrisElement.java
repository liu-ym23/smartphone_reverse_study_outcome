package com.bytedance.android.live.core.tetris.layer.core.element.tetris;

import com.bytedance.android.live.core.tetris.layer.core.element.Element;
import com.bytedance.android.live.core.tetris.layer.core.element.service.ServiceElement;
import com.bytedance.android.live.core.tetris.layer.core.tetris.ServiceTetris;
import com.bytedance.android.live.core.tetris.layer.core.tetris.Tetris;
import com.bytedance.android.livesdk.utils.LifecycleOwnerCompat;
import h70.b;
import j70.k;
import java.util.ArrayList;
import java.util.List;
import k70.c;
import k70.d;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u00020\u00012\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/core/tetris/layer/core/element/tetris/ServiceTetrisElement;", "Lcom/bytedance/android/live/core/tetris/layer/core/element/service/ServiceElement;", "Lcom/bytedance/android/live/core/tetris/layer/core/tetris/Tetris;", "Lh70/b;", "Lk70/d;", "tetris_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ServiceTetrisElement extends ServiceElement<Tetris<? extends b>> implements d {
    public final Lazy l;
    public final List<Element<?>> m;
    public final k n;
    public final c o;
    public final p70.b p;
    public final com.bytedance.android.live.core.tetris.layer.core.data.b q;

    public final ServiceTetris<b> m() {
        return (ServiceTetris) this.l.getValue();
    }

    @Override // com.bytedance.android.live.core.tetris.layer.core.element.service.ServiceElement
    public final void l() {
        com.bytedance.android.live.core.tetris.componentx.component.b r0 = this.c;
        if (r0 == null) goto L5;
        r0.c(this, m());
    L5:
        LifecycleOwnerCompat.-CC.$default$getLifecycle(this).addObserver(m());
    }

    @Override // com.bytedance.android.live.core.tetris.layer.core.element.Element
    public final Object i() {
        return m();
    }

    @Override // com.bytedance.android.live.core.tetris.layer.core.element.Element
    public final o70.a j() {
        if ((m() instanceof o70.a) == false) goto L9;
        LifecycleOwnerCompat r0 = m();
        if (r0 == null) goto L8;
        return (o70.a) r0;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.core.tetris.layer.core.event.ElementEventResolver");
    L9:
        return null;
    }

    @Override // com.bytedance.android.live.core.tetris.layer.core.element.Element
    public final void k() {
        m().J();
        ((ArrayList) this.m).clear();
        LifecycleOwnerCompat.-CC.$default$getLifecycle(this).removeObserver(m());
        com.bytedance.android.live.core.tetris.componentx.component.b r0 = this.c;
        if (r0 == null) goto L6;
        r0.e(this, m());
        return;
    }

    @Override // k70.d
    public final void a(Element<?> r2) {
        Intrinsics.checkNotNullParameter(r2, "element");
        ((ArrayList) this.m).remove(r2);
    }

    @Override // k70.d
    public final void b(Element<?> r2) {
        Intrinsics.checkNotNullParameter(r2, "element");
        if (((ArrayList) this.m).contains(r2) == true) goto L6;
        ((ArrayList) this.m).add(r2);
        return;
    }

    public ServiceTetrisElement(k r2, c r3, b r4, p70.b r5, com.bytedance.android.live.core.tetris.layer.core.data.b r6) {
        Intrinsics.checkNotNullParameter(r2, "tetrisAttribute");
        Intrinsics.checkNotNullParameter(r3, "elementFactory");
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "processChains");
        Intrinsics.checkNotNullParameter(r6, "vmProvider");
        super(r4);
        this.n = r2;
        this.o = r3;
        this.p = r5;
        this.q = r6;
        this.l = LazyKt.lazy(new ServiceTetrisElement$tetris$2(this));
        this.m = new ArrayList();
    }
}
