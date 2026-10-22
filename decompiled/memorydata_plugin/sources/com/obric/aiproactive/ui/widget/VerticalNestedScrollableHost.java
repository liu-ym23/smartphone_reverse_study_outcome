package com.obric.aiproactive.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/obric/aiproactive/ui/widget/VerticalNestedScrollableHost;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "touchSlop", "", "initialX", "", "initialY", "onInterceptTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "findNestedScrollableChild", "Landroid/view/View;", "view", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class VerticalNestedScrollableHost extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f6926a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f6927b;
    private float c;

    /* JADX WARN: Multi-variable type inference failed */
    public VerticalNestedScrollableHost(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "context");
        this(r4, null, 2, 0 == true ? 1 : 0);
    }

    public VerticalNestedScrollableHost(Context r3, AttributeSet r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r6 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r6);
        this.f6926a = ViewConfiguration.get(r5).getScaledTouchSlop();
    }

    public /* synthetic */ VerticalNestedScrollableHost(Context r2, AttributeSet r3, int r4, DefaultConstructorMarker r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin");
        if ((r4 & 2) == 0) goto L5;
        r7 = null;
    L5:
        this(r6, r7);
    }

    private final View a(View r6) {
        if (r6.canScrollVertically(1) == false) goto L5;
    L20:
        return r6;
    L5:
        if (r6.canScrollVertically(-1) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r6, ViewGroup.class) == false) goto L10;
        ViewGroup r7 = (ViewGroup) ZeusTransformUtils.preCheckCast(r6, ViewGroup.class, "com.obric.memorydata.plugin");
    L11:
        if (r7 != null) goto L13;
        return null;
    L13:
        int r0 = 0;
        int r2 = r7.getChildCount();
    L14:
        if (r0 >= r2) goto L19;
        View r3 = r7.getChildAt(r0);
        Intrinsics.checkNotNullExpressionValue(r3, "getChildAt(...)");
        View r4 = a(r3);
        if (r4 != null) goto L17;
        r0 = r0 + 1;
        goto L14
    L17:
        return r4;
    L19:
        return null;
    L10:
        r7 = null;
        goto L11
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r7) {
        Intrinsics.checkNotNullParameter(r7, "ev");
        if (getChildCount() == 0) goto L5;
        View r1 = getChildAt(0);
        Intrinsics.checkNotNullExpressionValue(r1, "getChildAt(...)");
        View r2 = a(r1);
        if (r2 != null) goto L9;
        r2 = getChildAt(0);
    L9:
        int r0 = r7.getActionMasked();
        int r3 = 1;
        if (r0 != 0) goto L12;
        this.f6927b = r7.getX();
        this.c = r7.getY();
        getParent().requestDisallowInterceptTouchEvent(true);
    L24:
        return super.onInterceptTouchEvent(r7);
    L12:
        if (r0 != 2) goto L24;
        float r4 = r7.getX() - this.f6927b;
        float r5 = r7.getY() - this.c;
        if (Math.abs(r5) <= this.f6926a) goto L24;
        if (Math.abs(r5) <= Math.abs(r4)) goto L24;
        if (r5 <= 0.0f) goto L21;
        r3 = -1;
    L21:
        getParent().requestDisallowInterceptTouchEvent(r2.canScrollVertically(r3));
        goto L24
    L5:
        return super.onInterceptTouchEvent(r7);
    }
}
