package com.obric.memorydata.utils;

import android.content.Context;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.MarginLayoutParamsCompat;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\u001a(\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0006\u001a\u0014\u0010\u0007\u001a\u00020\b*\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\n\u001a\f\u0010\u000b\u001a\u00020\b*\u00020\u0002H\u0002\u001a\u0012\u0010\f\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\r\u001a\u00020\u000e\u001a\u0012\u0010\u000f\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000e\u001a\u0012\u0010\u0011\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u000e¨\u0006\u0013"}, d2 = {"setThrottledClick", "", "Landroid/view/View;", "interval", "", "onClick", "Lkotlin/Function1;", "isInUpperHalfOfRecyclerView", "", "recyclerView", "Lcom/obric/oui/orecyclerview/widget/RecyclerView;", "isInUpperHalf", "setMarginTop", "marginTop", "", "setPaddingTop", "topPadding", "setPaddingBottom", "bottomPadding", "utils_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class bb {
    public static final void a(View r8, int r9) {
        Intrinsics.checkNotNullParameter(r8, "<this>");
        ViewGroup.LayoutParams r0 = r8.getLayoutParams();
        ViewGroup.MarginLayoutParams r2 = null;
        if (ZeusTransformUtils.instanceOf(r0, ViewGroup.MarginLayoutParams.class) == false) goto L5;
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r0, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
    L6:
        if (r1 == null) goto L22;
        ViewGroup.LayoutParams r3 = r8.getLayoutParams();
        int r5 = 0;
        if (ZeusTransformUtils.instanceOf(r3, ViewGroup.MarginLayoutParams.class) == false) goto L10;
        int r4 = MarginLayoutParamsCompat.getMarginStart((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r3, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin"));
    L11:
        ViewGroup.LayoutParams r6 = r8.getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r6, ViewGroup.MarginLayoutParams.class) == false) goto L14;
        int r7 = MarginLayoutParamsCompat.getMarginEnd((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r6, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin"));
    L15:
        ViewGroup.LayoutParams r10 = r8.getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r10, ViewGroup.MarginLayoutParams.class) == false) goto L18;
        r2 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r10, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
    L18:
        if (r2 == null) goto L20;
        r5 = r2.bottomMargin;
    L20:
        r1.setMargins(r4, r9, r7, r5);
        r8.requestLayout();
        return;
    L14:
        r7 = 0;
        goto L15
    L10:
        r4 = 0;
        goto L11
    L22:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public static final void a(View r2, final long r3, Function1<? super View, Unit> r5) {
        final Function1 r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r6, "onClick");
        final Ref.LongRef r0 = new Ref.LongRef();
        r2.setOnClickListener(new $$Lambda$bb$_fRRDBYwHmC0JqDIBrusrkEhBJg(r0, r3, r6));
    }

    public static /* synthetic */ void a(View r1, long r2, Function1 r4, int r5, Object r6) {
        Function1 r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        if ((r5 & 1) == 0) goto L5;
        r2 = 1000;
    L5:
        a(r1, r2, r7);
    }

    private static final void a(Ref.LongRef r4, long r5, Function1 r7, View r8) {
        Function1 r9 = (Function1) ZeusTransformUtils.wrapperContextForParams(r7, Function1.class, "com.obric.memorydata.plugin");
        long r0 = SystemClock.elapsedRealtime();
        if ((r0 - r4.element) < r5) goto L6;
        r4.element = r0;
        Intrinsics.checkNotNull(r8);
        r9.invoke(r8);
        return;
    }

    private static final boolean a(View r5) {
        int[] r1 = new int[2];
        r5.getLocationOnScreen(r1);
        if ((r1[1] + (r5.getHeight() / 2)) < (ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin").getDisplayMetrics().heightPixels / 2)) goto L7;
        return false;
    L7:
        return true;
    }

    public static final boolean a(View r1, RecyclerView r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r2 == null) goto L10;
        if (((r1.getTop() + r1.getBottom()) / 2) >= (r2.getHeight() / 2)) goto L7;
        return true;
    L7:
        return false;
    L10:
        return a(r1);
    }

    public static final void b(View r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        r3.setPadding(r3.getPaddingLeft(), r4, r3.getPaddingRight(), r3.getPaddingBottom());
    }

    public static final void c(View r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        r3.setPadding(r3.getPaddingLeft(), r3.getPaddingTop(), r3.getPaddingRight(), r4);
    }

    public static /* synthetic */ void lambda$_fRRDBYwHmC0JqDIBrusrkEhBJg(Ref.LongRef r0, long r1, Function1 r3, View r4) {
        a(r0, r1, r3, r4);
    }
}
