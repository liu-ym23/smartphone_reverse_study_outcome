package com.bytedance.android.live.core.tetris.layer.core.element.container;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.live.core.tetris.layer.core.element.Element;
import com.bytedance.android.live.core.tetris.template.delegate.BaseTemplateDelegate;
import com.bytedance.android.live.core.tetris.template.loader.TemplateLoader;
import com.bytedance.android.livesdk.utils.LifecycleOwnerCompat;
import h70.b;
import j70.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import k70.c;
import k70.d;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u00020\u00012\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/core/tetris/layer/core/element/container/ContainerElement;", "Lcom/bytedance/android/live/core/tetris/layer/core/element/Element;", "Lcom/bytedance/android/live/core/tetris/template/loader/TemplateLoader;", "Lh70/b;", "Lk70/d;", "tetris_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ContainerElement extends Element<TemplateLoader<? extends b>> implements d {
    public final Lazy l;
    public final List<Element<?>> m;
    public final j70.b n;
    public final c o;
    public final b80.a p;
    public final p70.b q;
    public final com.bytedance.android.live.core.tetris.layer.core.data.b r;

    public final TemplateLoader<b> l() {
        return (TemplateLoader) this.l.getValue();
    }

    @Override // com.bytedance.android.live.core.tetris.layer.core.element.Element
    public final Lifecycle g() {
        return l().getLifecycle();
    }

    @Override // com.bytedance.android.live.core.tetris.layer.core.element.Element
    public final TemplateLoader<? extends b> i() {
        return l();
    }

    @Override // com.bytedance.android.live.core.tetris.layer.core.element.Element
    public final o70.a j() {
        if ((l() instanceof o70.a) == false) goto L9;
        LifecycleOwnerCompat r0 = l();
        if (r0 == null) goto L8;
        return (o70.a) r0;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.core.tetris.layer.core.event.ElementEventResolver");
    L9:
        return null;
    }

    @Override // com.bytedance.android.live.core.tetris.layer.core.element.Element
    public final void k() {
        TemplateLoader<b> r0 = l();
        Iterator r1 = ((ArrayList) r0.a).iterator();
    L4:
        if (r1.hasNext() == false) goto L11;
        Element<?> r2 = (Element) r1.next();
        d r3 = r0.d;
        if (r3 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("elementGroup");
    L8:
        r3.a(r2);
        r0.getLifecycle().removeObserver(r2);
        r2.e();
        com.bytedance.android.live.core.tetris.componentx.component.b r4 = r0.h;
        if (r4 == null) goto L4;
        r4.b(r2);
        goto L4
    L11:
        Lifecycle.State r5 = r0.getLifecycle().getCurrentState();
        int r6 = c80.a.a[r5.ordinal()];
        if (r6 != 3) goto L14;
        r0.onDestroy();
    L21:
        ((ArrayList) r0.a).clear();
        ((ArrayList) this.m).clear();
        LifecycleOwnerCompat.-CC.$default$getLifecycle(this).removeObserver(l());
        return;
    L14:
        if (r6 != 4) goto L16;
        r0.onStop();
        r0.onDestroy();
        goto L21
    L16:
        if (r6 != 5) goto L21;
        r0.onPause();
        r0.onStop();
        r0.onDestroy();
        goto L21
    }

    @Override // k70.d
    public final void a(Element<?> r2) {
        Intrinsics.checkNotNullParameter(r2, "element");
        ((ArrayList) this.m).remove(r2);
        m(false, r2);
    }

    @Override // k70.d
    public final void b(Element<?> r2) {
        Intrinsics.checkNotNullParameter(r2, "element");
        if (((ArrayList) this.m).contains(r2) == true) goto L6;
        ((ArrayList) this.m).add(r2);
        m(true, r2);
        return;
    }

    @Override // com.bytedance.android.live.core.tetris.layer.core.element.Element
    public final void onViewCreated(View r2) {
        LifecycleOwnerCompat.-CC.$default$getLifecycle(this).addObserver(l());
    }

    @Override // com.bytedance.android.live.core.tetris.layer.core.element.Element
    public final View c(Context r3, ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this.n.n(r3);
        ConstraintLayout r5 = new ConstraintLayout(this.k.getContext());
        if (this.n.y() <= 0) goto L11;
        r5.setId(this.n.y());
    L11:
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L7
        View r7 = new View(this.k.getContext());     // Catch: Throwable -> L7
        r7.setVisibility(8);     // Catch: Throwable -> L7
        r7.setId(ViewCompat.generateViewId());     // Catch: Throwable -> L7
        r5.addView(r7, new ConstraintLayout.LayoutParams(1, 1));     // Catch: Throwable -> L7
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L7
    L9:
        TemplateLoader<b> r8 = l();
        r8.getClass();
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        r8.f = r5;
        return r5;
    L7:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L9
    }

    /* JADX WARN: Type inference failed for: r4v0, types: [C extends h70.b, T extends h70.b, java.lang.Object] */
    public final void m(boolean r7, Element<?> r8) {
        b80.a r0 = this.p;
        if (r0 == null) goto L41;
        List<BaseTemplateDelegate<? extends b>> r1 = r0.a();
        if (r1 == null) goto L57;
        Iterator<T> r2 = r1.iterator();
    L8:
        if (r2.hasNext() == false) goto L58;
        BaseTemplateDelegate r3 = (BaseTemplateDelegate) r2.next();
        if (r7 == true) goto L11;
        f r4 = r8.d;
        r3.getClass();
        Intrinsics.checkNotNullParameter(r4, "elementType");
        if (r3.c.containsKey(r4) == false) goto L37;
        Intrinsics.checkNotNullParameter(r4, "elementType");
        Element<?> r5 = (Element) ((LinkedHashMap) r3.c).get(r4);
        r3.c.remove(r4);
        if (r5 == null) goto L37;
        r3.b(r5);
    L37:
        if (r3.d.containsKey(r4) == false) goto L8;
        l70.a r6 = (l70.a) ((LinkedHashMap) r3.d).get(r4);
        if (r6 == null) goto L8;
        r6.d();
        goto L8
    L11:
        r3.getClass();
        Intrinsics.checkNotNullParameter(r8, "element");
        r3.c.put(r8.d, r8);
        r3.a(r8);
        if (r3.d.containsKey(r8.d) == false) goto L8;
        l70.a r9 = (l70.a) ((LinkedHashMap) r3.d).get(r8.d);
        if (r9 == null) goto L19;
        ?? r11 = r3.b;
        if (r11 != 0) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("layerContext");
    L18:
        Intrinsics.checkNotNullParameter(r11, "<set-?>");
        r9.a = r11;
    L19:
        if (r9 == null) goto L21;
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        r9.d = r3;
    L21:
        if (r9 == null) goto L23;
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        r9.c = r3;
    L23:
        if (r9 == null) goto L29;
        v70.c r12 = r8.h();
        if (r12 == null) goto L28;
        Intrinsics.checkNotNullParameter(r12, "<set-?>");
        r9.b = r12;
        goto L29
    L28:
        throw new RuntimeException(r8.d + " is invalid.");
    L29:
        if (r9 == null) goto L8;
        r9.c();
        goto L8
    L58:
        return;
    L57:
        return;
    }

    public ContainerElement(j70.b r2, c r3, b r4, b80.a r5, p70.b r6, com.bytedance.android.live.core.tetris.layer.core.data.b r7) {
        Intrinsics.checkNotNullParameter(r2, "containerAttribute");
        Intrinsics.checkNotNullParameter(r3, "elementFactory");
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r6, "processChains");
        Intrinsics.checkNotNullParameter(r7, "vmProvider");
        super(r4);
        this.n = r2;
        this.o = r3;
        this.p = r5;
        this.q = r6;
        this.r = r7;
        this.l = LazyKt.lazy(new ContainerElement$templateLoader$2(this));
        this.m = new ArrayList();
    }
}
