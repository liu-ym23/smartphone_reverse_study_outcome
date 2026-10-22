package com.larus.canvas.feature.component.resultdisplay.image;

import android.view.View;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.larus.canvas.feature.component.base.AbsUIComponent;
import com.larus.canvas.feature.component.resultdisplay.image.widget.ImagePagerAdapter;
import com.larus.canvas.feature.component.resultdisplay.image.widget.ImagePagerLayoutController$autoAdjustItemLayout$1;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.b1;
import kotlinx.coroutines.flow.j1;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 L2\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00012\u00020\u0005:\u0001LB\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010;\u001a\u00020<2\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010=\u001a\u00020\u0002H\u0016J\u0010\u0010>\u001a\u00020<2\u0006\u0010?\u001a\u00020\u0003H\u0016J\b\u0010@\u001a\u00020<H\u0016J\u0010\u0010A\u001a\u00020<2\u0006\u0010B\u001a\u00020CH\u0016J\b\u0010D\u001a\u00020<H\u0016J\n\u0010E\u001a\u0004\u0018\u00010CH\u0016J\b\u0010F\u001a\u00020<H\u0002J\u0010\u0010G\u001a\u00020<2\u0006\u0010?\u001a\u00020\u0003H\u0002J\b\u0010H\u001a\u00020<H\u0002J\b\u0010I\u001a\u00020<H\u0002J\u0010\u0010J\u001a\u00020<2\u0006\u0010K\u001a\u00020\u0017H\u0002J\b\u0010K\u001a\u00020\u0017H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R#\u0010\n\u001a\n \f*\u0004\u0018\u00010\u000b0\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0018\u001a\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0010\u001a\u0004\b\u001a\u0010\u001bR\u001b\u0010\u001d\u001a\u00020\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u0010\u001a\u0004\b\u001f\u0010 R\u0016\u0010\"\u001a\u0004\u0018\u00010#8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R\u001b\u0010&\u001a\u00020'8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010\u0010\u001a\u0004\b(\u0010)R\u0014\u0010+\u001a\b\u0012\u0004\u0012\u00020,0\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010-\u001a\b\u0012\u0004\u0012\u00020,0.X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u001b\u00101\u001a\u0002028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b5\u0010\u0010\u001a\u0004\b3\u00104R\u001b\u00106\u001a\u0002078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b:\u0010\u0010\u001a\u0004\b8\u00109¨\u0006M"}, d2 = {"Lcom/larus/canvas/feature/component/resultdisplay/image/CreationImagePagerComponent;", "Lcom/larus/canvas/feature/component/base/AbsUIComponent;", "Lcom/larus/canvas/feature/component/resultdisplay/image/ImagePagerUIState;", "Lcom/larus/canvas/feature/component/resultdisplay/image/ImagePagerUIEvent;", "Lcom/larus/canvas/feature/component/resultdisplay/image/ImagePagerUIAction;", "Lcom/larus/canvas/feature/component/resultdisplay/image/IImagePagerAbility;", "<init>", "()V", "dependency", "Lcom/larus/canvas/feature/component/resultdisplay/image/CreationImagePagerDepend;", "pagerContainer", "Landroid/widget/FrameLayout;", "kotlin.jvm.PlatformType", "getPagerContainer", "()Landroid/widget/FrameLayout;", "pagerContainer$delegate", "Lkotlin/Lazy;", "bindFragment", "Landroidx/fragment/app/Fragment;", "getBindFragment", "()Landroidx/fragment/app/Fragment;", "imeStatusFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "exceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "getExceptionHandler", "()Lkotlinx/coroutines/CoroutineExceptionHandler;", "exceptionHandler$delegate", "viewPager", "Landroidx/viewpager2/widget/ViewPager2;", "getViewPager", "()Landroidx/viewpager2/widget/ViewPager2;", "viewPager$delegate", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "layoutController", "Lcom/larus/canvas/feature/component/resultdisplay/image/widget/ImagePagerLayoutController;", "getLayoutController", "()Lcom/larus/canvas/feature/component/resultdisplay/image/widget/ImagePagerLayoutController;", "layoutController$delegate", "_curPositionFlow", "", "curPositionFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getCurPositionFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "adapter", "Lcom/larus/canvas/feature/component/resultdisplay/image/widget/ImagePagerAdapter;", "getAdapter", "()Lcom/larus/canvas/feature/component/resultdisplay/image/widget/ImagePagerAdapter;", "adapter$delegate", "sizePublisher", "Lcom/larus/canvas/feature/component/resultdisplay/image/widget/SizePublisher;", "getSizePublisher", "()Lcom/larus/canvas/feature/component/resultdisplay/image/widget/SizePublisher;", "sizePublisher$delegate", "initDependency", "", "initialState", "sendUIEvent", "event", "onAttach", "onViewCreated", "view", "Landroid/view/View;", "afterViewBind", "getCurImageContainer", "initViewPager", "handleUIEvents", "reloadCurFailedImage", "bindObservers", "adjustTopPaddingWhenImeChanged", "isImeShown", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationImagePagerComponent extends AbsUIComponent<u, t, s> implements r {
    public static final int B = 0;
    public static final int C = 0;
    public static int D;
    public final Lazy A;
    public q r;
    public final Lazy s;
    public final StateFlowImpl t;
    public final Lazy u;
    public final Lazy v;
    public final Lazy w;
    public final StateFlowImpl x;
    public final b1 y;
    public final Lazy z;

    public static final class a {
    }

    public static final class b extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
        public b(CoroutineExceptionHandler.Key r1) {
            super(r1);
        }

        public final void handleException(CoroutineContext r3, Throwable r4) {
            FLogger.a.e("CreationImagePagerComponent", "err! msg=" + r4);
        }
    }

    static {
        B = i5.E();
        C = i5.j0();
        x.a.getClass();
        D = x.b.getInt("ime_max_height", 770);
    }

    public final void P2() {
        m3(e1.s(F2()));
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new CreationImagePagerComponent$bindObservers$1(this, null), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new CreationImagePagerComponent$bindObservers$2(this, null), 3, null);
        Ref.IntRef r2 = new Ref.IntRef();
        this.r.c.invoke(new n(this, r2));
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new CreationImagePagerComponent$bindObservers$4(this, null), 3, null);
    }

    @Override // com.larus.canvas.feature.component.base.AbsUIComponent
    public final com.larus.canvas.feature.component.base.d h3() {
        return new u(0);
    }

    public final ViewPager2 p3() {
        return (ViewPager2) this.v.getValue();
    }

    public final void y2() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, r.class);
    }

    public CreationImagePagerComponent() {
        this.r = new q(0, i5.h(), new o(), p.a);
        LazyThreadSafetyMode r0 = LazyThreadSafetyMode.NONE;
        this.s = LazyKt.lazy(r0, new com.larus.canvas.feature.component.resultdisplay.image.a(this));
        this.t = j1.a(Boolean.FALSE);
        this.u = LazyKt.lazy(r0, new e());
        this.v = LazyKt.lazy(r0, new f(this));
        this.w = LazyKt.lazy(r0, new g(this));
        StateFlowImpl r1 = j1.a(0);
        this.x = r1;
        this.y = kotlinx.coroutines.flow.e.b(r1);
        this.z = LazyKt.lazy(r0, new h(this));
        this.A = LazyKt.lazy(new i(this));
    }

    public final RecyclerView getRecyclerView() {
        RecyclerView r0 = p3().getChildAt(0);
        if ((r0 instanceof RecyclerView) == true) goto L7;
        return null;
    L7:
        return r0;
    }

    @Override // com.larus.canvas.feature.component.resultdisplay.image.r
    public final b1 OP() {
        return this.y;
    }

    public final void m3(boolean r8) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        Intrinsics.checkNotNullParameter(this, "<this>");     // Catch: Throwable -> L4
        Object r1 = Result.constructor-impl(com.larus.ui.arch.component.internal.attach.a.b(this, this));     // Catch: Throwable -> L4
    L7:
        if (Result.isFailure-impl(r1) == false) goto L9;
        r1 = null;
    L9:
        Fragment r2 = (Fragment) r1;
        if (r2 == null) goto L16;
        FragmentActivity r3 = r2.getActivity();
        if (r3 == null) goto L16;
        if (r3.isFinishing() == true) goto L16;
        boolean r4 = true;
    L17:
        if (r4 == true) goto L19;
        return;
    L19:
        if (r8 == false) goto L21;
        int r5 = this.r.b;
    L22:
        if (r8 == false) goto L24;
        int r9 = C;
    L25:
        FrameLayout r6 = (FrameLayout) this.s.getValue();
        int r7 = r6.getPaddingStart();
        int r10 = r6.getPaddingEnd();
        FLogger.a.i("updatePaddingRelative", "view:" + r6.getClass().getSimpleName() + ",source:,start:" + r7 + ",top:" + r5 + ",end:" + r10 + ",bottom:" + r9);
        r6.setPaddingRelative(r7, r5, r10, r9);
        return;
    L24:
        r9 = B;
        goto L25
    L21:
        r5 = this.r.a + B;
    L16:
        r4 = false;
    L4:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    public final void onViewCreated(View r3) {
        Intrinsics.checkNotNullParameter(r3, "view");
        Intrinsics.checkNotNullParameter(r3, "view");
        ((FrameLayout) this.s.getValue()).removeAllViews();
        ((FrameLayout) this.s.getValue()).addView(p3());
        p3().setAdapter((ImagePagerAdapter) this.z.getValue());
        RecyclerView r4 = getRecyclerView();
        if (r4 == null) goto L5;
        r4.addItemDecoration(new CreationImagePagerComponent$initViewPager$1());
    L5:
        RecyclerView r5 = getRecyclerView();
        if (r5 == null) goto L8;
        r5.setItemAnimator(null);
    L8:
        RecyclerView r6 = getRecyclerView();
        if (r6 == null) goto L11;
        r6.setOverScrollMode(2);
    L11:
        RecyclerView r7 = getRecyclerView();
        if (r7 == null) goto L14;
        r7.setClipToPadding(false);
    L14:
        RecyclerView r8 = getRecyclerView();
        if (r8 == null) goto L17;
        r8.setClipChildren(false);
    L17:
        final com.larus.canvas.feature.component.resultdisplay.image.widget.q r9 = (com.larus.canvas.feature.component.resultdisplay.image.widget.q) this.w.getValue();
        r9.a.registerOnPageChangeCallback(new ImagePagerLayoutController$autoAdjustItemLayout$1(r9));
        p3().registerOnPageChangeCallback(new CreationImagePagerComponent$initViewPager$2(this));
    }

    @Override // com.larus.canvas.feature.component.resultdisplay.image.r
    public final void uX(q r2) {
        Intrinsics.checkNotNullParameter(r2, "dependency");
        this.r = r2;
    }

    @Override // com.larus.canvas.feature.component.base.AbsUIComponent, com.larus.canvas.feature.component.base.a
    public final void yS(com.larus.canvas.feature.component.base.c r2) {
        t r3 = (t) r2;
        Intrinsics.checkNotNullParameter(r3, "event");
        super.yS(r3);
    }
}
