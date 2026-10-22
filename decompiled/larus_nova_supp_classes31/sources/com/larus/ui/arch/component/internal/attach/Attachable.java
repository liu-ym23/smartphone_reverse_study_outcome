package com.larus.ui.arch.component.internal.attach;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.larus.ui.arch.component.external.LazyComponent;
import com.larus.ui.arch.component.external.LazySlotComponent;
import com.larus.ui.arch.component.external.api.Component;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.larus.ui.arch.component.external.delegate.BaseSlotWidget;
import com.larus.ui.arch.component.internal.control.ComponentStateController;
import com.larus.ui.arch.modulizer.di.ComponentDsl;
import com.tencent.open.log.TraceLevel;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import p1a.c;
import p1a.d;
import p1a.g;
import p1a.h;
import p1a.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 (2\u00020\u0001:\u0001(B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\t\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u0006H\u0000¢\u0006\u0002\b\u000bJ\u001f\u0010\f\u001a\u00020\r2\b\u0010\n\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000e\u001a\u00020\u0007H\u0000¢\u0006\u0002\b\u000fJ\u0015\u0010\u0010\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u0006H\u0000¢\u0006\u0002\b\u0011J\b\u0010\u0012\u001a\u00020\rH\u0014J%\u0010\u0013\u001a\u00020\r*\u00020\u00062\u0017\u0010\u0014\u001a\u0013\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u0015¢\u0006\u0002\b\u0018H\u0007J%\u0010\u0019\u001a\u00020\r*\u00020\u00062\u0017\u0010\u0014\u001a\u0013\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b0\u0015¢\u0006\u0002\b\u0018H\u0007J)\u0010\u001c\u001a\u00020\r*\u00020\u00062\u001b\u0010\u0014\u001a\u0017\u0012\u0004\u0012\u00020\u001d\u0012\b\u0012\u00060\u001ej\u0002`\u001f0\u0015¢\u0006\u0002\b\u0018H\u0007J\u0018\u0010\u001c\u001a\u00020\r*\u00020\u00062\n\u0010\u0013\u001a\u00060\u001ej\u0002`\u001fH\u0007J)\u0010 \u001a\u00020\r*\u00020\u00062\u001b\u0010\u0014\u001a\u0017\u0012\u0004\u0012\u00020!\u0012\b\u0012\u00060\"j\u0002`#0\u0015¢\u0006\u0002\b\u0018H\u0007J%\u0010$\u001a\u00020\r*\u00020\u00062\u0017\u0010\u0014\u001a\u0013\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020&0\u0015¢\u0006\u0002\b\u0018H\u0007J\u0014\u0010\u0013\u001a\u00020\r*\u00020\u00062\u0006\u0010\u0013\u001a\u00020'H\u0007R*\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/larus/ui/arch/component/internal/attach/Attachable;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "componentStateControllers", "Ljava/util/HashMap;", "Landroidx/lifecycle/LifecycleOwner;", "Lcom/larus/ui/arch/component/internal/control/ComponentStateController;", "Lkotlin/collections/HashMap;", "getComponentStateController", "lifecycleOwner", "getComponentStateController$component_release", "putComponentStateController", "", "c", "putComponentStateController$component_release", "clear", "clear$component_release", "onCleared", "component", "contentBuilder", "Lkotlin/Function1;", "Lcom/larus/ui/arch/component/external/core/ComponentFeatureBuilder;", "Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", "Lkotlin/ExtensionFunctionType;", "lazyComponent", "Lcom/larus/ui/arch/component/external/core/LazyComponentBuilder;", "Lcom/larus/ui/arch/component/external/LazyComponent;", "contentComponent", "Lcom/larus/ui/arch/component/external/core/ContentComponentBuilder;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/larus/ui/arch/component/external/ContentComponent;", "slotComponent", "Lcom/larus/ui/arch/component/external/core/SlotComponentBuilder;", "Lcom/larus/ui/arch/component/external/delegate/BaseSlotWidget;", "Lcom/larus/ui/arch/component/external/SlotComponent;", "lazySlotComponent", "Lcom/larus/ui/arch/component/external/core/LazySlotComponentBuilder;", "Lcom/larus/ui/arch/component/external/LazySlotComponent;", "Lcom/larus/ui/arch/component/external/api/Component;", "Companion", "component_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class Attachable extends ViewModel {
    public static final int $stable = 0;
    public static final a Companion = null;
    private final HashMap<LifecycleOwner, ComponentStateController> componentStateControllers;

    public static final class a {
        public a() {
        }

        public static Attachable a(FragmentActivity r1) {
            Intrinsics.checkNotNullParameter(r1, "activity");
            return (Attachable) new ViewModelProvider(r1).get(Attachable.class);
        }
    }

    static {
        Companion = new a();
        $stable = 8;
    }

    public void onCleared() {
        this.componentStateControllers.clear();
    }

    public Attachable() {
        this.componentStateControllers = new HashMap();
    }

    public final void clear$component_release(LifecycleOwner r2) {
        Intrinsics.checkNotNullParameter(r2, "lifecycleOwner");
        this.componentStateControllers.remove(r2);
    }

    public final ComponentStateController getComponentStateController$component_release(LifecycleOwner r2) {
        return this.componentStateControllers.get(r2);
    }

    @ComponentDsl
    public final void component(LifecycleOwner r2, Function1<? super c, ? extends ComponentFeature> r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "contentBuilder");
        ComponentStateController r4 = this.componentStateControllers.get(r2);
        if (r4 == null) goto L6;
        c r0 = new c();
        ComponentFeature r5 = (ComponentFeature) r3.invoke(r0);
        r0.c(r5);
        r4.a(r5);
        return;
    }

    @ComponentDsl
    public final void contentComponent(LifecycleOwner r2, Function1<? super d, ? extends BaseContentWidget> r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "contentBuilder");
        ComponentStateController r4 = this.componentStateControllers.get(r2);
        if (r4 == null) goto L6;
        d r0 = new d();
        BaseContentWidget r5 = (BaseContentWidget) r3.invoke(r0);
        r0.c(r5);
        r4.a(r5);
        return;
    }

    @ComponentDsl
    public final void lazyComponent(LifecycleOwner r3, Function1<? super g, ? extends LazyComponent> r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "contentBuilder");
        ComponentStateController r5 = this.componentStateControllers.get(r3);
        if (r5 == null) goto L6;
        g r0 = new g();
        LazyComponent r6 = (LazyComponent) r4.invoke(r0);
        r0.c(r6);
        Intrinsics.checkNotNullParameter(r6, "component");
        r5.a(r6);
        r5.c(r6, null, false);
        return;
    }

    @ComponentDsl
    public final void lazySlotComponent(LifecycleOwner r4, Function1<? super h, ? extends LazySlotComponent> r5) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r5, "contentBuilder");
        ComponentStateController r6 = this.componentStateControllers.get(r4);
        if (r6 == null) goto L16;
        h r0 = new h();
        LazySlotComponent r7 = (LazySlotComponent) r5.invoke(r0);
        r0.c(r7);
        if ((r7 instanceof LazySlotComponent) == false) goto L12;
        Intrinsics.checkNotNullParameter(r7, "component");
        r6.a(r7);
        if (((ArrayList) r6.d).contains(r7) == true) goto L9;
        return;
    L9:
        if (r7.getLifecycle().getCurrentState() == r6.d().getCurrentState()) goto L18;
        r6.e(r6.d().getCurrentState(), r7, null, false);
        return;
    L18:
        return;
    L12:
        if (x1a.a.a == true) goto L15;
        return;
    L15:
        throw new RuntimeException("target component[" + r7.getClass().getSimpleName() + "] is not lazyComponent, please check it!");
    }

    public final void putComponentStateController$component_release(final LifecycleOwner r2, ComponentStateController r3) {
        Intrinsics.checkNotNullParameter(r3, "c");
        if (r2 != null) goto L5;
        return;
    L5:
        this.componentStateControllers.put(r2, r3);
        r2.getLifecycle().addObserver(new Attachable$putComponentStateController$1(this, r2));
    }

    @ComponentDsl
    public final void slotComponent(LifecycleOwner r2, Function1<? super i, ? extends BaseSlotWidget> r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "contentBuilder");
        ComponentStateController r4 = this.componentStateControllers.get(r2);
        if (r4 == null) goto L6;
        i r0 = new i();
        BaseSlotWidget r5 = (BaseSlotWidget) r3.invoke(r0);
        r0.c(r5);
        r4.a(r5);
        return;
    }

    @ComponentDsl
    public final void component(LifecycleOwner r2, Component r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "component");
        ComponentStateController r4 = this.componentStateControllers.get(r2);
        if (r4 == null) goto L6;
        r4.a(r3);
        return;
    }

    @ComponentDsl
    public final void contentComponent(LifecycleOwner r2, BaseContentWidget r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "component");
        ComponentStateController r4 = this.componentStateControllers.get(r2);
        if (r4 == null) goto L6;
        r4.a(r3);
        return;
    }
}
