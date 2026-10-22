package com.suite.lark.platform.component.widget.floatingpanel.impl.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u00010B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00132\u0006\u0010'\u001a\u00020(J\u0012\u0010)\u001a\u00020\u00152\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\u0012\u0010,\u001a\u00020\u00152\b\u0010*\u001a\u0004\u0018\u00010+H\u0017J\n\u0010-\u001a\u0004\u0018\u00010\u0013H\u0002J\b\u0010.\u001a\u00020%H\u0002J\b\u0010/\u001a\u00020%H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u00061"}, d2 = {"Lcom/suite/lark/platform/component/widget/floatingpanel/impl/view/FloatingBannerContainer;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "downY", "", "startScrollY", "touchSlop", "getTouchSlop", "()I", "touchSlop$delegate", "Lkotlin/Lazy;", "draggingView", "Landroid/view/View;", "ignoreTouchEvent", "", "draggingAnimator", "Landroid/view/ViewPropertyAnimator;", "onBannerMovedOutListener", "Lcom/suite/lark/platform/component/widget/floatingpanel/impl/view/FloatingBannerContainer$OnBannerMovedOutListener;", "getOnBannerMovedOutListener", "()Lcom/suite/lark/platform/component/widget/floatingpanel/impl/view/FloatingBannerContainer$OnBannerMovedOutListener;", "setOnBannerMovedOutListener", "(Lcom/suite/lark/platform/component/widget/floatingpanel/impl/view/FloatingBannerContainer$OnBannerMovedOutListener;)V", "onBannerClickListener", "Lcom/suite/lark/platform/component/widget/floatingpanel/impl/view/OnFloatingCardClickListener;", "getOnBannerClickListener", "()Lcom/suite/lark/platform/component/widget/floatingpanel/impl/view/OnFloatingCardClickListener;", "setOnBannerClickListener", "(Lcom/suite/lark/platform/component/widget/floatingpanel/impl/view/OnFloatingCardClickListener;)V", "addBanner", "", "view", "id", "", "onInterceptTouchEvent", "event", "Landroid/view/MotionEvent;", "onTouchEvent", "captureView", "removeDraggingView", "settleDraggingView", "OnBannerMovedOutListener", "widget-biz-dinghelper_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class FloatingBannerContainer extends FrameLayout {
    public float a;
    public float b;
    public final Lazy c;
    public View d;
    public boolean e;
    public ViewPropertyAnimator f;
    public a g;
    public e h;

    public interface a {
        void a();
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ FloatingBannerContainer a;
        public final /* synthetic */ String b;

        public b(FloatingBannerContainer r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            e r0 = this.a.getOnBannerClickListener();
            if (r0 == null) goto L6;
            Intrinsics.checkNotNull(r3);
            r0.a(r3, this.b);
            return;
        }
    }

    public FloatingBannerContainer(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public FloatingBannerContainer(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    private final int getTouchSlop() {
        return ((Number) this.c.getValue()).intValue();
    }

    public final e getOnBannerClickListener() {
        return this.h;
    }

    public final a getOnBannerMovedOutListener() {
        return this.g;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r5) {
        if (r5 == null) goto L23;
        int r1 = r5.getActionMasked();
        if (getChildCount() != 0) goto L8;
        return false;
    L8:
        if (r1 != 0) goto L10;
        getParent().requestDisallowInterceptTouchEvent(true);
        this.a = r5.getY();
        this.e = false;
        return false;
    L10:
        if (r1 != 2) goto L27;
        float r6 = r5.getY();
        if ((this.a - r6) <= getTouchSlop()) goto L24;
        this.b = r6;
        if (getChildCount() != 0) goto L17;
        View r7 = null;
    L18:
        this.d = r7;
        if (r7 == null) goto L25;
        return true;
    L25:
        return false;
    L17:
        r7 = getChildAt(getChildCount() - 1);
        goto L18
    L24:
        return false;
    L27:
        return false;
    L23:
        return false;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r6) {
        if (r6 == null) goto L28;
        int r1 = r6.getActionMasked();
        View r2 = this.d;
        if (r2 != null) goto L8;
        return false;
    L8:
        if (this.e == false) goto L11;
        return false;
    L11:
        if (r1 == 1) goto L18;
        if (r1 != 2) goto L14;
        r2.setTranslationY(Math.min(r6.getY() - this.b, 0.0f));
    L27:
        return true;
    L14:
        if (r1 != 3) goto L27;
    L18:
        if (Math.abs(r2.getTranslationY()) < (r2.getHeight() / 2)) goto L23;
        View r7 = this.d;
        if (r7 == null) goto L27;
        ViewPropertyAnimator r8 = r7.animate().translationY(r7.getHeight() * (-1.0f)).setDuration(300).setListener(new com.suite.lark.platform.component.widget.floatingpanel.impl.view.a(this));
        this.f = r8;
        r8.start();
        goto L27
    L23:
        View r9 = this.d;
        if (r9 == null) goto L27;
        ViewPropertyAnimator r10 = r9.animate().translationY(0.0f).setDuration(300);
        this.f = r10;
        r10.start();
        goto L27
    L28:
        return false;
    }

    public final void setOnBannerClickListener(e r1) {
        this.h = r1;
    }

    public final void setOnBannerMovedOutListener(a r1) {
        this.g = r1;
    }

    public final void a(View r5, String r6) {
        Intrinsics.checkNotNullParameter(r5, "view");
        Intrinsics.checkNotNullParameter(r6, "id");
        addView(r5);
        r5.setOnClickListener(new b(this, r6));
        View r7 = this.d;
        if (r7 == null) goto L8;
        r7.setTranslationY(0.0f);
        this.e = true;
        this.d = null;
        ViewPropertyAnimator r8 = this.f;
        if (r8 == null) goto L7;
        r8.cancel();
    L7:
        this.f = null;
    L8:
        int r9 = getChildCount();
        int r1 = 0;
    L9:
        if (r1 >= r9) goto L14;
        View r2 = getChildAt(r1);
        if (Intrinsics.areEqual(r2, r5) == true) goto L13;
        r2.setOnClickListener(null);
    L13:
        r1 = r1 + 1;
        goto L9
    }

    public FloatingBannerContainer(final Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.c = LazyKt.lazy(new FloatingBannerContainer$touchSlop$2(r2));
    }

    public /* synthetic */ FloatingBannerContainer(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
