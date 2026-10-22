package com.ss.android.lark.flow.feed.component.loading;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bJ\u001e\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007J\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\fR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/ss/android/lark/flow/feed/component/loading/FlowLoadingView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "loadingView", "Landroid/view/View;", "setLoadingView", "", "child", "lp", "Landroid/widget/FrameLayout$LayoutParams;", "hasLoadingContent", "", "clearLoadingView", "flow-feed_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class FlowLoadingView extends FrameLayout {
    public View a;

    public final void setLoadingView(View r1) {
        a(this, r1);
    }

    public FlowLoadingView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public FlowLoadingView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, 0);
    }

    public static void a(FlowLoadingView r4, View r5) {
        View r0 = r4.a;
        int r1 = 8;
        if (r0 != r5) goto L8;
        if (r5 == null) goto L7;
        r1 = 0;
    L7:
        r4.setVisibility(r1);
        return;
    L8:
        if (r0 != null) goto L10;
    L12:
        r4.a = r5;
        if (r5 != null) goto L15;
        r4.setVisibility(8);
        return;
    L15:
        ViewParent r2 = r5.getParent();
        if ((r2 instanceof ViewGroup) == false) goto L18;
        ViewGroup r3 = (ViewGroup) r2;
    L19:
        if (r3 == null) goto L21;
        r3.removeView(r5);
    L21:
        FrameLayout.LayoutParams r6 = new FrameLayout.LayoutParams(-2, -2);
        r6.gravity = 17;
        r4.addView(r5, r6);
        r4.setVisibility(0);
        return;
    L18:
        r3 = null;
        goto L19
    L10:
        if (r0.getParent() != r4) goto L12;
        r4.removeView(r0);
        goto L12
    }
}
