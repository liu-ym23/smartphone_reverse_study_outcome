package com.bytedance.android.livesdk.interactivity.api.publicscreen.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.livesdk.f7;
import com.bytedance.android.livesdk.h7;
import com.bytedance.android.livesdk.widget.LiveVerticalViewPager;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\b¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/ui/PublicScreenTextMessageFrameLayout;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/livesdk/widget/LiveVerticalViewPager$l;", "a", "Lcom/bytedance/android/livesdk/widget/LiveVerticalViewPager$l;", "getPublicScreenTouchInterceptor", "()Lcom/bytedance/android/livesdk/widget/LiveVerticalViewPager$l;", "setPublicScreenTouchInterceptor", "(Lcom/bytedance/android/livesdk/widget/LiveVerticalViewPager$l;)V", "publicScreenTouchInterceptor", "b", "getPublicScreenTouchInterceptorCache", "setPublicScreenTouchInterceptorCache", "publicScreenTouchInterceptorCache", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attr", BuildConfig.FLAVOR, "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PublicScreenTextMessageFrameLayout extends FrameLayout implements LiveVerticalViewPager.l {
    public LiveVerticalViewPager.l a;
    public LiveVerticalViewPager.l b;

    public PublicScreenTextMessageFrameLayout(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public PublicScreenTextMessageFrameLayout(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final boolean r() {
        return ((Boolean) f7.a.getValue()).booleanValue();
    }

    public final boolean s() {
        if (((Boolean) h7.a.getValue()).booleanValue() == false) goto L13;
        LiveVerticalViewPager.l r0 = this.a;
        if (r0 == null) goto L8;
        Intrinsics.checkNotNull(r0);
        if (r0.s() == false) goto L8;
        return true;
    L8:
        LiveVerticalViewPager.l r1 = this.b;
        if (r1 == null) goto L18;
        Intrinsics.checkNotNull(r1);
        if (r1.s() == false) goto L18;
        return true;
    L18:
        return false;
    L13:
        LiveVerticalViewPager.l r2 = this.a;
        if (r2 == null) goto L18;
        Intrinsics.checkNotNull(r2);
        if (r2.s() == false) goto L18;
        return true;
    }

    public final LiveVerticalViewPager.l getPublicScreenTouchInterceptor() {
        return this.a;
    }

    public final LiveVerticalViewPager.l getPublicScreenTouchInterceptorCache() {
        return this.b;
    }

    public final boolean a(MotionEvent r4) {
        Intrinsics.checkNotNullParameter(r4, "ev");
        if (((Boolean) h7.a.getValue()).booleanValue() == false) goto L13;
        LiveVerticalViewPager.l r0 = this.a;
        if (r0 == null) goto L8;
        Intrinsics.checkNotNull(r0);
        if (r0.a(r4) == false) goto L8;
        return true;
    L8:
        LiveVerticalViewPager.l r1 = this.b;
        if (r1 == null) goto L18;
        Intrinsics.checkNotNull(r1);
        if (r1.a(r4) == false) goto L18;
        return true;
    L18:
        return false;
    L13:
        LiveVerticalViewPager.l r2 = this.a;
        if (r2 == null) goto L18;
        Intrinsics.checkNotNull(r2);
        if (r2.a(r4) == false) goto L18;
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r4) {
        Intrinsics.checkNotNullParameter(r4, "ev");
        LiveVerticalViewPager.l r0 = this.a;
        if (r0 == null) goto L12;
        Intrinsics.checkNotNull(r0);
        if (r0.a(r4) == false) goto L12;
        return false;
    L12:
        return super.dispatchTouchEvent(r4);
    L9:
        e = move-exception;
        SafetyGuard.a(null, e, "PublicScreenTextMessageFrameLayout");
        return false;
    }

    public final void setPublicScreenTouchInterceptor(LiveVerticalViewPager.l r1) {
        this.a = r1;
    }

    public final void setPublicScreenTouchInterceptorCache(LiveVerticalViewPager.l r1) {
        this.b = r1;
    }

    public PublicScreenTextMessageFrameLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }

    public /* synthetic */ PublicScreenTextMessageFrameLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
