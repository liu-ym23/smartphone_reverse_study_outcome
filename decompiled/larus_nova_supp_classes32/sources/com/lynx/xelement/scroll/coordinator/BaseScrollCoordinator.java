package com.lynx.xelement.scroll.coordinator;

import android.content.res.Resources;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.ui.view.UISimpleView;
import com.lynx.tasm.event.EventsListener;
import com.lynx.xelement.scroll.coordinator.BaseScrollCoordinatorAppBarLayout;
import com.lynx.xelement.scroll.coordinator.ScrollCoordinatorToolbarLayout;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.lang.reflect.Method;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\u000e\b\u0001\u0010\u0004*\b\u0012\u0004\u0012\u00028\u00000\u00032\b\u0012\u0004\u0012\u00028\u00010\u0005:\u0001\u000eJ\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0007J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¨\u0006\u000f"}, d2 = {"Lcom/lynx/xelement/scroll/coordinator/BaseScrollCoordinator;", "Lcom/lynx/xelement/scroll/coordinator/BaseScrollCoordinatorAppBarLayout;", "K", "Lcom/lynx/xelement/scroll/coordinator/ScrollCoordinatorToolbarLayout;", "T", "Lcom/lynx/tasm/behavior/ui/view/UISimpleView;", NameKeys.UnloadStrategy_No_Strategy, "enable", NameKeys.UnloadStrategy_No_Strategy, "setScrollEnable", NameKeys.UnloadStrategy_No_Strategy, "value", "setGranularity", "setCompatContainerPopup", "a", "ScrollCoordinator_release"}, k = 1, mv = {1, 6, 0})
public abstract class BaseScrollCoordinator<K extends BaseScrollCoordinatorAppBarLayout, T extends ScrollCoordinatorToolbarLayout<K>> extends UISimpleView<T> {
    public T a;
    public boolean b;
    public float c;
    public float d;
    public int e;
    public final Lazy f;
    public final Lazy g;

    public static final class a {
    }

    static {
    }

    public int O() {
        return 0;
    }

    public abstract void P(AppBarLayout r1, int r2);

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final boolean needCustomLayout() {
        return true;
    }

    public final T N() {
        T r0 = this.a;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("coordinatorLayout");
        return null;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final int getScrollY() {
        return Math.abs(this.e);
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r4) {
        if (r4 != null) goto L5;
    L21:
        CoordinatorLayout.LayoutParams r5 = new CoordinatorLayout.LayoutParams(-1, -2);
        r5.setBehavior(new AppBarLayout.ScrollingViewBehavior());
        return r5;
    L5:
        if (r4.width == (-1)) goto L7;
    L9:
        r4.width = -1;
        r4.height = -2;
        if ((r4 instanceof CollapsingToolbarLayout.LayoutParams) == false) goto L14;
        return new CollapsingToolbarLayout.LayoutParams((FrameLayout.LayoutParams) r4);
    L14:
        if ((r4 instanceof CoordinatorLayout.LayoutParams) == false) goto L18;
        CoordinatorLayout.LayoutParams r0 = new CoordinatorLayout.LayoutParams((CoordinatorLayout.LayoutParams) r4);
        r0.setBehavior(new AppBarLayout.ScrollingViewBehavior());
        return r0;
    L18:
        if ((r4 instanceof Toolbar.LayoutParams) == false) goto L21;
        return new Toolbar.LayoutParams((Toolbar.LayoutParams) r4);
    L7:
        if (r4.height != (-2)) goto L9;
        return r4;
    }

    @LynxProp(defaultBoolean = false, name = "compat-container-popup")
    public final void setCompatContainerPopup(boolean r2) {
        N().setCompatContainerPopupEnabled(r2);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void setEvents(Map<String, EventsListener> r3) {
        super.setEvents(r3);
        LLog.d("ScrollCoordinator", "events: " + r3);
        if (r3 == null) goto L6;
        this.b = r3.containsKey("offset");
        return;
    }

    @LynxProp(defaultFloat = 0.01f, name = "granularity")
    public final void setGranularity(float r1) {
        this.d = r1;
    }

    @LynxProp(defaultBoolean = true, name = "enable-scroll")
    public final void setScrollEnable(boolean r3) {
        N().setScrollEnabled(r3);
        ((BaseScrollCoordinatorAppBarLayout) N().findViewById(2131363087)).setScrollEnabled(r3);
    }

    public BaseScrollCoordinator(LynxContext r1, Object r2) {
        super(r1, r2);
        this.d = 0.01f;
        this.f = LazyKt.lazy(BaseScrollCoordinator$offsetWithoutAnimationMethod$2.INSTANCE);
        this.g = LazyKt.lazy(BaseScrollCoordinator$animateOffsetMethod$2.INSTANCE);
    }

    public static final int M(BaseScrollCoordinator r1, float r2) {
        Resources r3 = r1.mContext.getResources();
        return (int) ((r2 / WindowDisplayMetricsOverride.apply(r3, r3.getDisplayMetrics()).density) + 0.5f);
    }

    public static void Q(BaseScrollCoordinator r9, int r10) {
        CoordinatorLayout.AttachedBehavior r0 = (BaseScrollCoordinatorAppBarLayout) r9.N().getAppBarLayout();
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        if (r1 == null) goto L18;
        CoordinatorLayout.Behavior r2 = ((CoordinatorLayout.LayoutParams) r1).getBehavior();
        if ((r2 instanceof AppBarLayout.Behavior) == true) goto L7;
        return;
    L7:
        if (r10 >= 0) goto L10;
        r10 = (int) (((double) r0.getTotalScrollRange()) * (((double) 1) - (-1.0d)));     // Catch: Exception -> L14
    L14:
        e = move-exception;
        LLog.e("ScrollCoordinator", "invoke setOffsetWithoutAnimation error " + e.getMessage());
        return;
    L10:
        int r11 = RangesKt.coerceAtLeast(-r10, -r0.getTotalScrollRange());     // Catch: Exception -> L14
        Method r3 = (Method) r9.f.getValue();     // Catch: Exception -> L14
        if (r3 == null) goto L22;
        r3.invoke(r2, new Object[]{r9.N(), r0, Integer.valueOf(r11), Integer.MIN_VALUE, Integer.MAX_VALUE});     // Catch: Exception -> L14
        return;
    L22:
        return;
    L18:
        throw new NullPointerException("null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams");
    }
}
