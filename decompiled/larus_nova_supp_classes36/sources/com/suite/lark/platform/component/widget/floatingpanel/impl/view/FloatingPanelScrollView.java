package com.suite.lark.platform.component.widget.floatingpanel.impl.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001:\u0001#B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\u0012\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J(\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0007H\u0014J\u0010\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u0007H\u0016J(\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u00112\u0006\u0010!\u001a\u00020\u0011H\u0014J\u0006\u0010\"\u001a\u00020\u0016R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/suite/lark/platform/component/widget/floatingpanel/impl/view/FloatingPanelScrollView;", "Landroid/widget/ScrollView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "onScrollChangedListener", "Lcom/suite/lark/platform/component/widget/floatingpanel/impl/view/FloatingPanelScrollView$OnScrollChangedListener;", "getOnScrollChangedListener", "()Lcom/suite/lark/platform/component/widget/floatingpanel/impl/view/FloatingPanelScrollView$OnScrollChangedListener;", "setOnScrollChangedListener", "(Lcom/suite/lark/platform/component/widget/floatingpanel/impl/view/FloatingPanelScrollView$OnScrollChangedListener;)V", "isFlingingToBottom", "", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "onScrollChanged", "", "l", "t", "oldl", "oldt", "fling", "velocityY", "onOverScrolled", "scrollX", "scrollY", "clampedX", "clampedY", "stopFlingAndScrollToTop", "OnScrollChangedListener", "widget-biz-dinghelper_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class FloatingPanelScrollView extends ScrollView {
    public a a;
    public boolean b;

    public interface a {
        void a(FloatingPanelScrollView r1, int r2, int r3);
    }

    public FloatingPanelScrollView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public FloatingPanelScrollView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final a getOnScrollChangedListener() {
        return this.a;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r2) {
        if (r2 == null) goto L4;
        Integer r0 = Integer.valueOf(r2.getActionMasked());
    L5:
        if (r0 == null) goto L11;
        if (r0.intValue() != 0) goto L11;
        this.b = false;
    L11:
        return super.dispatchTouchEvent(r2);
    L4:
        r0 = null;
        goto L5
    }

    @Override // android.widget.ScrollView
    public final void fling(int r1) {
        super.fling(r1);
        if (r1 <= 0) goto L5;
        boolean r2 = true;
    L6:
        this.b = r2;
        return;
    L5:
        r2 = false;
        goto L6
    }

    public final void setOnScrollChangedListener(a r1) {
        this.a = r1;
    }

    public FloatingPanelScrollView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }

    public /* synthetic */ FloatingPanelScrollView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    @Override // android.widget.ScrollView, android.view.View
    public final void onOverScrolled(int r2, int r3, boolean r4, boolean r5) {
        if (this.b == true) goto L5;
    L7:
        super.onOverScrolled(r2, r3, r4, r5);
        return;
    L5:
        if (r3 >= getScrollY()) goto L7;
        super.onOverScrolled(r2, getScrollY(), r4, false);
    }

    @Override // android.view.View
    public final void onScrollChanged(int r1, int r2, int r3, int r4) {
        super.onScrollChanged(r1, r2, r3, r4);
        a r5 = this.a;
        if (r5 == null) goto L6;
        r5.a(this, r2, r4);
        return;
    }
}
