package com.larus.canvas.feature.component.title;

import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.canvas.feature.component.base.AbsUIComponent;
import com.larus.canvas.feature.component.title.widget.CanvasTitleView;
import com.skydoves.balloon.Balloon;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000Y\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0014\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00012\u00020\u0005B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0018\u001a\u00020\u0002H\u0016J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0003H\u0016J\b\u0010\u001c\u001a\u00020\u001aH\u0016J\b\u0010\u001d\u001a\u00020\u001aH\u0016J\b\u0010\u001e\u001a\u00020\u001aH\u0016J\b\u0010\u001f\u001a\u00020\u001aH\u0016J\b\u0010 \u001a\u00020!H\u0016J\u001e\u0010\"\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020$2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020'0&H\u0002J\u0010\u0010(\u001a\u00020\u001a2\u0006\u0010)\u001a\u00020\u0002H\u0002J\b\u0010*\u001a\u00020\u001aH\u0002J\b\u0010+\u001a\u00020\u001aH\u0002R#\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u000e\u001a\u0004\b\u0015\u0010\u0016¨\u0006,"}, d2 = {"Lcom/larus/canvas/feature/component/title/CreationTitleComponent;", "Lcom/larus/canvas/feature/component/base/AbsUIComponent;", "Lcom/larus/canvas/feature/component/title/TitleUIState;", "Lcom/larus/canvas/feature/component/title/TitleUIEvent;", "Lcom/larus/canvas/feature/component/title/TitleUIAction;", "Lcom/larus/canvas/feature/component/title/ITitleAbility;", "<init>", "()V", "titleView", "Lcom/larus/canvas/feature/component/title/widget/CanvasTitleView;", "kotlin.jvm.PlatformType", "getTitleView", "()Lcom/larus/canvas/feature/component/title/widget/CanvasTitleView;", "titleView$delegate", "Lkotlin/Lazy;", "balloon", "Lcom/skydoves/balloon/Balloon;", "disMissTime", "", "widthFixItemDecoration", "com/larus/canvas/feature/component/title/CreationTitleComponent$widthFixItemDecoration$2$1", "getWidthFixItemDecoration", "()Lcom/larus/canvas/feature/component/title/CreationTitleComponent$widthFixItemDecoration$2$1;", "widthFixItemDecoration$delegate", "initialState", "sendUIEvent", "", "event", "onAttach", "onCreate", "afterViewBind", "onDestroy", "isShowingBalloon", "", "showPopUpMenu", "anchorView", "Landroid/view/View;", "items", "", "Lcom/larus/canvas/feature/component/title/widget/DropdownItemData;", "refreshView", "state", "bindObservers", "dismissBalloon", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationTitleComponent extends AbsUIComponent<n, m, l> implements k {
    public static final /* synthetic */ int v = 0;
    public final Lazy r;
    public Balloon s;
    public long t;
    public final Lazy u;

    @Override // com.larus.canvas.feature.component.title.k
    public final boolean WC() {
        Balloon r0 = this.s;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.g != true) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.larus.canvas.feature.component.base.AbsUIComponent
    public final com.larus.canvas.feature.component.base.d h3() {
        return new n(0);
    }

    public final CanvasTitleView m3() {
        return (CanvasTitleView) this.r.getValue();
    }

    public final void onDestroy() {
        Balloon r0 = this.s;
        if (r0 == null) goto L5;
        r0.h();
    L5:
        this.s = null;
    }

    public final void y2() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, k.class);
    }

    public CreationTitleComponent() {
        this.r = LazyKt.lazy(new d(this));
        this.u = LazyKt.lazy(new e(this));
    }

    public final void P2() {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new CreationTitleComponent$bindObservers$1(this, null), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new CreationTitleComponent$bindObservers$2(this, null), 3, null);
        F2().setOnClickListener(new f(this));
        CanvasTitleView r0 = m3();
        if (r0 == null) goto L5;
        r0.setOnClickLeftIcon(new g(this));
    L5:
        CanvasTitleView r1 = m3();
        if (r1 == null) goto L8;
        r1.setOnClickRightIcon(new h(this));
    L8:
        CanvasTitleView r2 = m3();
        if (r2 == null) goto L11;
        r2.setOnClickCenterText(new i(this));
    L11:
        CanvasTitleView r3 = m3();
        if (r3 == null) goto L15;
        r3.setOnLongClickCenterText(new j(this));
        return;
    }

    public final void onCreate() {
        super/*com.larus.ui.arch.component.external.delegate.BaseComponentWidget*/.onCreate();
    }

    @Override // com.larus.canvas.feature.component.base.AbsUIComponent, com.larus.canvas.feature.component.base.a
    public final void yS(com.larus.canvas.feature.component.base.c r2) {
        m r3 = (m) r2;
        Intrinsics.checkNotNullParameter(r3, "event");
        super.yS(r3);
    }
}
