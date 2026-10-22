package com.obric.memorydata.memory.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.ttnet.org.chromium.base.BaseSwitches;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0007J&\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0007H\u0007J.\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\r2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00050\u0011H\u0007¨\u0006\u0012"}, d2 = {"Lcom/obric/memorydata/memory/ui/ViewWidthCalculator;", "", "<init>", "()V", "debugViewHierarchy", "", "view", "Landroid/view/View;", LocationMonitorConst.TAG, "", "getMaxContentWidth", "", "includePadding", "", "attachedAncestor", "getMaxContentWidthAsync", "callback", "Lkotlin/Function1;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p f11380a = null;

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/obric/memorydata/memory/ui/ViewWidthCalculator$getMaxContentWidthAsync$1", "Landroid/view/View$OnAttachStateChangeListener;", "onViewAttachedToWindow", "", BaseSwitches.V, "Landroid/view/View;", "onViewDetachedFromWindow", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f11381a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function1<Integer, Unit> f11382b;
        final /* synthetic */ boolean c;

        a(View r3, Function1<? super Integer, Unit> r4, boolean r5) {
            Function1<Integer, Unit> r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
            this.f11381a = r3;
            this.f11382b = r6;
            this.c = r5;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View r3) {
            Intrinsics.checkNotNullParameter(r3, BaseSwitches.V);
            r3.removeOnAttachStateChangeListener((View.OnAttachStateChangeListener) ZeusTransformUtils.preCheckCast(this, View.OnAttachStateChangeListener.class, "com.obric.memorydata.plugin"));
            p.a(this.f11381a, this.f11382b, this.c);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View r1) {
            Intrinsics.checkNotNullParameter(r1, BaseSwitches.V);
        }
    }

    static {
        f11380a = new p();
    }

    private p() {
    }

    @JvmStatic
    public static final int a(View r8, boolean r9, View r10) {
        Intrinsics.checkNotNullParameter(r8, "view");
        if (r8.getWidth() <= 0) goto L8;
        if (r9 == false) goto L7;
        return r8.getWidth();
    L7:
        return (r8.getWidth() - r8.getPaddingLeft()) - r8.getPaddingRight();
    L8:
        ViewGroup.LayoutParams r0 = r8.getLayoutParams();
        if (r0 != null) goto L11;
    L16:
        ViewGroup.LayoutParams r1 = r8.getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r1, ViewGroup.MarginLayoutParams.class) == false) goto L19;
        ViewGroup.MarginLayoutParams r2 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r1, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
    L21:
        if (r2 == null) goto L23;
        int r4 = (r2.leftMargin + r2.rightMargin) + 0;
    L24:
        ViewParent r3 = r8.getParent();
        View r5 = r8;
    L25:
        if (r3 == null) goto L43;
        if (ZeusTransformUtils.instanceOf(r3, View.class) == false) goto L42;
        r5 = (View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.memorydata.plugin");
        r4 = r4 + (((View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.memorydata.plugin")).getPaddingLeft() + ((View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.memorydata.plugin")).getPaddingRight());
        ViewGroup.LayoutParams r6 = ((View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.memorydata.plugin")).getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r6, ViewGroup.MarginLayoutParams.class) == false) goto L31;
        ViewGroup.MarginLayoutParams r7 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r6, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
    L32:
        if (r7 == null) goto L35;
        r4 = r4 + (r7.leftMargin + r7.rightMargin);
    L35:
        if (((View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.memorydata.plugin")).getWidth() > 0) goto L36;
        ViewGroup.LayoutParams r11 = ((View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.memorydata.plugin")).getLayoutParams();
        if (r11 == null) goto L42;
        if (r11.width <= 0) goto L42;
        int r12 = r11.width;
    L44:
        if (r12 != 0) goto L48;
        String r13 = r5.getClass().getName();
        Intrinsics.checkNotNullExpressionValue(r13, "getName(...)");
        if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("DecorView", CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null) == true) goto L48;
        boolean r14 = true;
    L49:
        if (r14 == false) goto L71;
        if (r10 == null) goto L71;
        r4 = r4 + (r10.getPaddingLeft() + r10.getPaddingRight());
        ViewGroup.LayoutParams r15 = r10.getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r15, ViewGroup.MarginLayoutParams.class) == false) goto L54;
        ViewGroup.MarginLayoutParams r16 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r15, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
    L55:
        if (r16 == null) goto L57;
        r4 = r4 + (r16.leftMargin + r16.rightMargin);
    L57:
        ViewParent r17 = r10.getParent();
    L58:
        if (r17 == null) goto L71;
        if (ZeusTransformUtils.instanceOf(r17, View.class) == false) goto L70;
        r4 = r4 + (((View) ZeusTransformUtils.preCheckCast(r17, View.class, "com.obric.memorydata.plugin")).getPaddingLeft() + ((View) ZeusTransformUtils.preCheckCast(r17, View.class, "com.obric.memorydata.plugin")).getPaddingRight());
        ViewGroup.LayoutParams r18 = ((View) ZeusTransformUtils.preCheckCast(r17, View.class, "com.obric.memorydata.plugin")).getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r18, ViewGroup.MarginLayoutParams.class) == false) goto L64;
        ViewGroup.MarginLayoutParams r19 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r18, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
    L65:
        if (r19 == null) goto L68;
        r4 = r4 + (r19.leftMargin + r19.rightMargin);
    L68:
        if (((View) ZeusTransformUtils.preCheckCast(r17, View.class, "com.obric.memorydata.plugin")).getWidth() <= 0) goto L70;
        r12 = ((View) ZeusTransformUtils.preCheckCast(r17, View.class, "com.obric.memorydata.plugin")).getWidth();
        goto L71
    L64:
        r19 = null;
    L70:
        r17 = r17.getParent();
        goto L58
    L54:
        r16 = null;
    L71:
        if (r12 != 0) goto L73;
        r12 = ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r8.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin").getDisplayMetrics().widthPixels;
    L73:
        int r110 = RangesKt.coerceAtLeast(r12 - r4, 0);
        if (r9 == false) goto L77;
        return r110;
    L77:
        return RangesKt.coerceAtLeast((r110 - r8.getPaddingLeft()) - r8.getPaddingRight(), 0);
    L48:
        r14 = false;
        goto L49
    L36:
        r12 = ((View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.memorydata.plugin")).getWidth();
        goto L44
    L31:
        r7 = null;
    L42:
        r3 = r3.getParent();
        goto L25
    L43:
        r12 = 0;
        goto L44
    L23:
        r4 = 0;
        goto L24
    L19:
        r2 = null;
        goto L21
    L11:
        if (r0.width <= 0) goto L16;
        if (r9 == false) goto L15;
        return r0.width;
    L15:
        return (r0.width - r8.getPaddingLeft()) - r8.getPaddingRight();
    }

    public static /* synthetic */ int a(View r0, boolean r1, View r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r1 = false;
    L6:
        if ((r3 & 4) == 0) goto L9;
        r2 = null;
    L9:
        return a(r0, r1, r2);
    }

    public static final /* synthetic */ void a(View r2, Function1 r3, boolean r4) {
        b(r2, (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin"), r4);
    }

    @JvmStatic
    public static final void a(View r2, boolean r3, Function1<? super Integer, Unit> r4) {
        Function1 r5 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r5, "callback");
        if (r2.isAttachedToWindow() == false) goto L5;
        b(r2, r5, r3);
        return;
    L5:
        r2.addOnAttachStateChangeListener((View.OnAttachStateChangeListener) ZeusTransformUtils.preCheckCast(new a(r2, r5, r3), View.OnAttachStateChangeListener.class, "com.obric.memorydata.plugin"));
    }

    public static /* synthetic */ void a(View r1, boolean r2, Function1 r3, int r4, Object r5) {
        Function1 r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        if ((r4 & 2) == 0) goto L5;
        r2 = false;
    L5:
        a(r1, r2, r6);
    }

    private static final void a(Function1 r2, View r3, boolean r4) {
        ((Function1) ZeusTransformUtils.wrapperContextForParams(r2, Function1.class, "com.obric.memorydata.plugin")).invoke(Integer.valueOf(a(r3, r4, null, 4, null)));
    }

    private static final void b(final View r2, Function1<? super Integer, Unit> r3, final boolean r4) {
        final Function1 r5 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        if (r2.getWidth() <= 0) goto L5;
        r5.invoke(Integer.valueOf(a(r2, r4, null, 4, null)));
        return;
    L5:
        r2.post(new $$Lambda$p$T9uOyXWt_JQSonRRQw01D76H5ls(r5, r2, r4));
    }

    public static /* synthetic */ void lambda$T9uOyXWt_JQSonRRQw01D76H5ls(Function1 r0, View r1, boolean r2) {
        a(r0, r1, r2);
    }
}
