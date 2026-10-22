package com.bytedance.ies.xelement.viewpager.foldview;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.ies.xelement.viewpager.BaseCustomAppBarLayout;
import com.bytedance.ies.xelement.viewpager.FoldToolbarLayout;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.lynx.base.log.LynxLog;
import com.lynx.tasm.b0;
import com.lynx.tasm.behavior.c0;
import com.lynx.tasm.behavior.ui.view.UISimpleView;
import com.lynx.tasm.behavior.ui.z;
import com.obric.launcher.widget.R$id;
import java.lang.reflect.Method;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\u000e\b\u0001\u0010\u0004*\b\u0012\u0004\u0012\u00028\u00000\u00032\b\u0012\u0004\u0012\u00028\u00010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u000f\u0010\n¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ies/xelement/viewpager/foldview/BaseLynxFoldView;", "Lcom/bytedance/ies/xelement/viewpager/BaseCustomAppBarLayout;", "K", "Lcom/bytedance/ies/xelement/viewpager/FoldToolbarLayout;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/lynx/tasm/behavior/ui/view/UISimpleView;", "", "enable", "", "setScrollEnable", "(Z)V", "", "granularity", "setGranularity", "(F)V", "setCompatContainerPopup", "x-element-fold-view_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class BaseLynxFoldView<K extends BaseCustomAppBarLayout, T extends FoldToolbarLayout<K>> extends UISimpleView<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public FoldToolbarLayout f6551a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f6552b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f6553c;

    public BaseLynxFoldView(b0 r5, z r10) {
        super(r5, r10);
        this.f6552b = LazyKt.lazy(BaseLynxFoldView$offsetWithoutAnimToMethod$2.f6555a);
        this.f6553c = LazyKt.lazy(BaseLynxFoldView$animateOffsetToMethod$2.f6554a);
    }

    public static void i(BaseLynxFoldView r5, double r10, int r11, int r12) {
        if ((r12 & 1) == 0) goto L6;
        r10 = -1.0d;
    L6:
        if ((r12 & 2) == 0) goto L8;
        r11 = -1;
    L8:
        BaseCustomAppBarLayout r13 = (BaseCustomAppBarLayout) r5.j().f6510b;
        ViewGroup.LayoutParams r14 = r13.getLayoutParams();
        if (r14 == null) goto L23;
        CoordinatorLayout.Behavior r15 = ((CoordinatorLayout.LayoutParams) r14).getBehavior();
        if ((r15 instanceof AppBarLayout.Behavior) == false) goto L26;
        if (r11 < 0) goto L24;
        int r16 = -r11;
    L15:
        int r17 = RangesKt.coerceAtLeast(r16, -r13.getTotalScrollRange());     // Catch: Exception -> L19
        Method r18 = (Method) r5.f6552b.getValue();     // Catch: Exception -> L19
        if (r18 == null) goto L27;
        r18.invoke(r15, new Object[]{r5.j(), r13, Integer.valueOf(r17), Integer.MIN_VALUE, Integer.MAX_VALUE});     // Catch: Exception -> L19
        return;
    L19:
        e = move-exception;
        LynxLog.b(4, "LynxFoldView", "invoke doOffsetToMethodWithoutAnim error " + e.getMessage());
        return;
    L27:
        return;
    L24:
        r16 = -((int) ((((double) 1) - r10) * ((double) r13.getTotalScrollRange())));
        goto L15
    L26:
        return;
    L23:
        throw new NullPointerException("null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams");
    }

    public final void b(double r10, int r11) {
        BaseCustomAppBarLayout r5 = (BaseCustomAppBarLayout) j().f6510b;
        ViewGroup.LayoutParams r12 = r5.getLayoutParams();
        if (r12 == null) goto L17;
        CoordinatorLayout.Behavior r13 = ((CoordinatorLayout.LayoutParams) r12).getBehavior();
        if ((r13 instanceof AppBarLayout.Behavior) == false) goto L20;
        if (r11 < 0) goto L18;
        int r14 = -r11;
    L9:
        int r15 = RangesKt.coerceAtLeast(r14, -r5.getTotalScrollRange());     // Catch: Exception -> L13
        Method r16 = (Method) this.f6553c.getValue();     // Catch: Exception -> L13
        if (r16 == null) goto L21;
        r16.invoke(r13, new Object[]{j(), r5, Integer.valueOf(r15), 0});     // Catch: Exception -> L13
        return;
    L13:
        e = move-exception;
        LynxLog.b(4, "LynxFoldView", "invoke animateOffsetToMethod error " + e.getMessage());
        return;
    L21:
        return;
    L18:
        r14 = -((int) ((((double) 1) - r10) * ((double) r5.getTotalScrollRange())));
        goto L9
    L20:
        return;
    L17:
        throw new NullPointerException("null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams");
    }

    public final void c(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        j().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        ((BaseCustomAppBarLayout) j().f6510b).addOnOffsetChangedListener(new a());
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r5) {
        if (r5 != null) goto L5;
    L21:
        CoordinatorLayout.LayoutParams r10 = new CoordinatorLayout.LayoutParams(-1, -2);
        r10.setBehavior(new AppBarLayout.ScrollingViewBehavior());
        return r10;
    L5:
        if (r5.width == (-1)) goto L7;
    L9:
        r5.width = -1;
        r5.height = -2;
        if ((r5 instanceof CollapsingToolbarLayout.LayoutParams) == false) goto L14;
        return new CollapsingToolbarLayout.LayoutParams((FrameLayout.LayoutParams) r5);
    L14:
        if ((r5 instanceof CoordinatorLayout.LayoutParams) == false) goto L18;
        CoordinatorLayout.LayoutParams r11 = new CoordinatorLayout.LayoutParams((CoordinatorLayout.LayoutParams) r5);
        r11.setBehavior(new AppBarLayout.ScrollingViewBehavior());
        return r11;
    L18:
        if ((r5 instanceof Toolbar.LayoutParams) == false) goto L21;
        return new Toolbar.LayoutParams((Toolbar.LayoutParams) r5);
    L7:
        if (r5.height != (-2)) goto L9;
        return r5;
    }

    public final FoldToolbarLayout j() {
        FoldToolbarLayout r5 = this.f6551a;
        if (r5 == null) goto L5;
        return r5;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mFoldViewLayout");
        return null;
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final boolean needCustomLayout() {
        return true;
    }

    @c0(defaultBoolean = false, name = "compat-container-popup")
    public final void setCompatContainerPopup(boolean r5) {
        j().getClass();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void setEvents(Map r5) {
        super.setEvents(r5);
        LynxLog.b(1, "LynxFoldView", "events: " + r5);
        if (r5 == null) goto L6;
        r5.containsKey("offset");
        return;
    }

    @c0(defaultFloat = 0.01f, name = "granularity")
    public final void setGranularity(float r5) {
    }

    @c0(defaultBoolean = true, name = "scroll-enable")
    public final void setScrollEnable(boolean r5) {
        j().b(r5);
        ((BaseCustomAppBarLayout) j().findViewById(R$id.app_bar_layout)).getClass();
    }
}
