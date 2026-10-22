package com.bytedance.android.live.liveinteract.revenue.guestlink.ui;

import android.animation.Animator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.android.livesdk.gift.model.o0;
import com.bytedance.android.livesdk.message.model.n5;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u000fB'\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/live/liveinteract/revenue/guestlink/ui/GiftMarqueeContainer;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/live/liveinteract/revenue/guestlink/ui/d;", "Lcom/bytedance/android/live/liveinteract/revenue/guestlink/ui/GiftMarqueeView;", "getIdleMarqueeView", "Lcom/bytedance/android/livesdk/message/model/n5;", "getCurrentGiftMessage", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class GiftMarqueeContainer extends FrameLayout implements d {
    public Map<Integer, View> a;
    public boolean b;
    public n5 c;
    public GiftMarqueeView d;
    public d.a e;
    public final c f;

    public static final class a {
    }

    public static final class b implements Animator.AnimatorListener {
        public final /* synthetic */ GiftMarqueeContainer a;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
        }

        public b(GiftMarqueeContainer r1) {
            this.a = r1;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            ALogger.d("GiftMarqueeContainer", "createMarqueeView onAnimationCancel");
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r4) {
            Intrinsics.checkNotNullParameter(r4, "animation");
            ALogger.d("GiftMarqueeContainer", "createMarqueeView onAnimationEnd, delay MarqueeRemoveTask " + this.a.g());
            MainThreadPostUtils.d(this.a.f);
            GiftMarqueeContainer r5 = this.a;
            MainThreadPostUtils.c(r5.f, r5.g());
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            ALogger.d("GiftMarqueeContainer", "createMarqueeView onAnimationStart");
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ GiftMarqueeContainer a;

        public c(GiftMarqueeContainer r1) {
            this.a = r1;
        }

        public final void a() {
            GiftMarqueeContainer r0 = this.a;
            if (r0.d == null) goto L21;
            ALogger.d("GiftMarqueeContainer", "removeCurrentMarqueeView");
            GiftMarqueeView r1 = r0.d;
            r0.d = null;
            r0.c = null;
            int r3 = r0.getWidth();
            if (r1 == null) goto L16;
            ViewPropertyAnimator r4 = r1.animate();
            if (r4 == null) goto L16;
            ViewPropertyAnimator r5 = r4.translationX(-r3);
            if (r5 == null) goto L16;
            ViewPropertyAnimator r6 = r5.setDuration(2000);
            if (r6 == null) goto L16;
            ViewPropertyAnimator r2 = r6.setListener(new com.bytedance.android.live.liveinteract.revenue.guestlink.ui.a(r1));
            if (r2 == null) goto L16;
            r2.start();
        L16:
            ALogger.d("GiftMarqueeContainer", "onMarqueeComplete");
            r0.b = false;
            d.a r7 = r0.e;
            if (r7 == null) goto L20;
            r7.a();
            return;
        L20:
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public GiftMarqueeContainer(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public GiftMarqueeContainer(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    @Override // com.bytedance.android.live.liveinteract.revenue.guestlink.ui.d
    public final void b() {
        this.e = null;
    }

    @Override // com.bytedance.android.live.liveinteract.revenue.guestlink.ui.d
    public final void clear() {
        GiftMarqueeView r0 = this.d;
        if (r0 == null) goto L7;
        ViewPropertyAnimator r1 = r0.animate();
        if (r1 == null) goto L7;
        r1.cancel();
    L7:
        GiftMarqueeView r2 = this.d;
        if (r2 == null) goto L10;
        r2.setVisibility(4);
    L10:
        this.c = null;
        MainThreadPostUtils.d(this.f);
    }

    public final long g() {
        n5 r0 = this.c;
        if (r0 == null) goto L7;
        o0 r1 = r0.getTrayInfo();
        if (r1 == null) goto L7;
        return r1.getDuration();
    L7:
        return 3000;
    }

    private final GiftMarqueeView getIdleMarqueeView() {
        if (((GiftMarqueeView) e(2131379655)).getVisibility() == 0) goto L7;
        return (GiftMarqueeView) e(2131379655);
    L7:
        if (((GiftMarqueeView) e(2131379656)).getVisibility() != 0) goto L9;
        return null;
    L9:
        return (GiftMarqueeView) e(2131379656);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MainThreadPostUtils.d(this.f);
    }

    @Override // com.bytedance.android.live.liveinteract.revenue.guestlink.ui.d
    public final boolean d() {
        return this.b;
    }

    @Override // com.bytedance.android.live.liveinteract.revenue.guestlink.ui.d
    public n5 getCurrentGiftMessage() {
        return this.c;
    }

    @Override // com.bytedance.android.live.liveinteract.revenue.guestlink.ui.d
    public final void a(n5 r5) {
        Intrinsics.checkNotNullParameter(r5, "giftMessage");
        GiftMarqueeView r0 = this.d;
        if (r0 == null) goto L13;
        this.c = r5;
        r0.b(r5, true);
        GiftMarqueeView r6 = this.d;
        if (r6 == null) goto L7;
        float r7 = r6.getTranslationX();
    L9:
        if (r7 >= 1.0f) goto L11;
        ALogger.d("GiftMarqueeContainer", "updateMarqueeView, delay MarqueeRemoveTask " + g());
        MainThreadPostUtils.d(this.f);
        MainThreadPostUtils.c(this.f, g());
        return;
    L11:
        ALogger.d("GiftMarqueeContainer", "updateMarqueeView");
        return;
    L7:
        r7 = 0.0f;
        goto L9
    }

    @Override // com.bytedance.android.live.liveinteract.revenue.guestlink.ui.d
    public final void c(n5 r3) {
        Intrinsics.checkNotNullParameter(r3, "giftMessage");
        ALogger.d("GiftMarqueeContainer", "createMarqueeView");
        this.b = true;
        GiftMarqueeView r0 = getIdleMarqueeView();
        this.d = r0;
        if (r0 == null) goto L6;
        r0.setVisibility(0);
        this.c = r3;
        r0.b(r3, false);
        r0.setTranslationX(getWidth());
        r0.animate().translationX(0.0f).setDuration(2000).setListener(new b(this)).start();
        return;
    }

    public final View e(int r3) {
        if (this.a != null) goto L5;
        this.a = new LinkedHashMap();
    L5:
        View r0 = this.a.get(Integer.valueOf(r3));
        if (r0 != null) goto L12;
        View r1 = findViewById(r3);
        if (r1 == null) goto L10;
        this.a.put(Integer.valueOf(r3), r1);
        return r1;
    L10:
        return null;
    L12:
        return r0;
    }

    public final void f(com.bytedance.android.live.liveinteract.revenue.guestlink.ui.b r2) {
        Intrinsics.checkNotNullParameter(r2, "callBack");
        this.e = r2;
    }

    public GiftMarqueeContainer(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = new LinkedHashMap();
        LayoutInflater.from(r2).inflate(2131566146, this, true);
        this.f = new c(this);
    }

    public /* synthetic */ GiftMarqueeContainer(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
