package com.bytedance.android.livesdk.gift.platform.business.effect.giftview;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0003B'\b\u0007\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\b\b\u0003\u0010\u001a\u001a\u00020\n¢\u0006\u0004\b\u001b\u0010\u001cR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0015\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u000e¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/effect/giftview/GiftEffectInfoDraggableView;", "Landroid/widget/FrameLayout;", BuildConfig.FLAVOR, "a", "Z", "getDraggable", "()Z", "setDraggable", "(Z)V", "draggable", BuildConfig.FLAVOR, "b", "I", "getTopMarginPx", "()I", "setTopMarginPx", "(I)V", "topMarginPx", "e", "Lkotlin/Lazy;", "getStatusBarHeight", "statusBarHeight", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GiftEffectInfoDraggableView extends FrameLayout {
    public boolean a;
    public int b;
    public int c;
    public int d;
    public final Lazy e;
    public int f;
    public final a g;
    public j80.d h;
    public final b i;

    public final class a {
        public final int a;
        public j80.d b;
        public j80.d c;
        public final /* synthetic */ GiftEffectInfoDraggableView d;

        public a(GiftEffectInfoDraggableView r2) {
            this.d = r2;
            this.a = ViewConfiguration.get(r2.getContext()).getScaledTouchSlop();
            this.b = new j80.d(0.0f, 0.0f);
            this.c = new j80.d(0.0f, 0.0f);
        }
    }

    public static final class b {
        public final /* synthetic */ GiftEffectInfoDraggableView a;

        public b(GiftEffectInfoDraggableView r1) {
            this.a = r1;
        }

        public final void a(j80.d r6) {
            Intrinsics.checkNotNullParameter(r6, "offset");
            GiftEffectInfoDraggableView r0 = this.a;
            r0.h = j80.c.e(r0.h, r6);
            float r7 = this.a.h.a().floatValue();
            float r1 = this.a.h.b().floatValue();
            if (this.a.h.a().floatValue() >= 0.0f) goto L5;
            r7 = 0.0f;
        L9:
            if (this.a.h.b().floatValue() >= this.a.getTopMarginPx()) goto L11;
            r1 = this.a.getTopMarginPx();
        L14:
            GiftEffectInfoDraggableView r2 = this.a;
            j80.d r3 = new j80.d(r7, r1);
            r2.h = r3;
            j80.b.e(r2, r3);
            return;
        L11:
            float r4 = this.a.h.b().floatValue() + this.a.getHeight();
            GiftEffectInfoDraggableView r5 = this.a;
            if (r4 <= (r5.d + GiftEffectInfoDraggableView.a(r5))) goto L14;
            GiftEffectInfoDraggableView r8 = this.a;
            r1 = (r8.d + GiftEffectInfoDraggableView.a(r8)) - this.a.getHeight();
            goto L14
        L5:
            float r9 = this.a.h.a().floatValue() + this.a.getWidth();
            GiftEffectInfoDraggableView r10 = this.a;
            int r11 = r10.c;
            if (r9 <= r11) goto L9;
            r7 = r11 - r10.getWidth();
            goto L9
        }
    }

    public GiftEffectInfoDraggableView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public GiftEffectInfoDraggableView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final int getStatusBarHeight() {
        return ((Number) this.e.getValue()).intValue();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f = getContext().getResources().getConfiguration().orientation;
    }

    public final boolean getDraggable() {
        return this.a;
    }

    public final int getTopMarginPx() {
        return this.b;
    }

    public static final /* synthetic */ int a(GiftEffectInfoDraggableView r0) {
        return r0.getStatusBarHeight();
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration r4) {
        super.onConfigurationChanged(r4);
        if (r4 == null) goto L5;
        int r5 = r4.orientation;
    L7:
        if (this.f == r5) goto L10;
        j80.b.e(this, new j80.d(0.0f, this.b));
        this.c = s1.t();
        this.d = s1.r();
        this.f = r5;
        return;
    L10:
        return;
    L5:
        r5 = 1;
        goto L7
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r5) {
        Intrinsics.checkNotNullParameter(r5, "ev");
        if (this.a == false) goto L23;
        a r0 = this.g;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r5, "event");
        int r1 = r5.getAction();
        if (r1 != 0) goto L7;
        r0.d.getParent().requestDisallowInterceptTouchEvent(true);
        r0.b = j80.b.c(r5);
    L19:
        boolean r2 = false;
    L20:
        if (r2 == false) goto L23;
        return true;
    L7:
        if (r1 != 2) goto L19;
        if (j80.c.a(j80.b.c(r5), r0.b) < r0.a) goto L19;
        r0.c = j80.b.c(r5);
        b r3 = r0.d.i;
        if (r3 == null) goto L14;
        GiftEffectInfoDraggableView r4 = r3.a;
        r4.h = j80.b.a(r4);
    L14:
        b r6 = r0.d.i;
        if (r6 == null) goto L17;
        r6.a(j80.c.b(j80.b.c(r5), r0.b));
    L17:
        r2 = true;
    L23:
        return super.onInterceptTouchEvent(r5);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r6) {
        Intrinsics.checkNotNullParameter(r6, "event");
        if (this.a == false) goto L25;
        a r1 = this.g;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r6, "event");
        int r0 = r6.getAction();
        if (r0 == 0) goto L18;
        boolean r3 = false;
        if (r0 != 1) goto L9;
        GiftEffectInfoDraggableView r2 = r1.d;
        b r4 = r2.i;
        r2.getParent().requestDisallowInterceptTouchEvent(false);
    L21:
        r3 = true;
    L22:
        if (r3 == false) goto L25;
        return true;
    L9:
        if (r0 != 2) goto L11;
        j80.d r5 = j80.c.b(j80.b.c(r6), r1.c);
        r1.c = j80.b.c(r6);
        b r7 = r1.d.i;
        if (r7 == null) goto L21;
        r7.a(r5);
        goto L21
    L11:
        if (r0 != 3) goto L22;
        GiftEffectInfoDraggableView r8 = r1.d;
        b r9 = r8.i;
        r8.getParent().requestDisallowInterceptTouchEvent(false);
        goto L21
    L18:
        r1.c = j80.b.c(r6);
        r1.d.getParent().requestDisallowInterceptTouchEvent(true);
        b r10 = r1.d.i;
        if (r10 == null) goto L21;
        GiftEffectInfoDraggableView r11 = r10.a;
        r11.h = j80.b.a(r11);
    L25:
        return super.onTouchEvent(r6);
    }

    public final void setDraggable(boolean r1) {
        this.a = r1;
    }

    public final void setTopMarginPx(int r1) {
        this.b = r1;
    }

    public GiftEffectInfoDraggableView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.c = s1.t();
        this.d = s1.r();
        this.e = LazyKt.lazy(GiftEffectInfoDraggableView$statusBarHeight$2.INSTANCE);
        this.f = 1;
        this.g = new a(this);
        this.h = new j80.d(0.0f, 0.0f);
        this.i = new b(this);
    }

    public /* synthetic */ GiftEffectInfoDraggableView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
