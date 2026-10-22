package com.bytedance.android.livesdk.commerce.coupon;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.uikit.util.IESUIUtils;
import com.bytedance.android.livesdk.TTLiveSDKContext;
import com.bytedance.android.livesdk.chatroom.bl.PlatformMessageHelper;
import com.bytedance.android.livesdk.utils.t6;
import com.bytedance.android.livesdkapi.depend.handler.WeakHandler;
import com.bytedance.android.livesdkapi.service.IHostCommerceServiceLive;
import com.bytedance.mt.protector.impl.UriProtector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0003\u0082\u0001\tB)\b\u0007\u0012\u0006\u0010|\u001a\u00020{\u0012\n\b\u0002\u0010~\u001a\u0004\u0018\u00010}\u0012\b\b\u0002\u0010\u007f\u001a\u00020S¢\u0006\u0006\b\u0080\u0001\u0010\u0081\u0001J\u0010\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004R$\u0010\u000f\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u0017\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u001e\u001a\u00020\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010&\u001a\u00020\u001f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010*\u001a\u00020\u001f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010!\u001a\u0004\b(\u0010#\"\u0004\b)\u0010%R\"\u00102\u001a\u00020+8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\"\u00106\u001a\u00020+8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b3\u0010-\u001a\u0004\b4\u0010/\"\u0004\b5\u00101R$\u0010>\u001a\u0004\u0018\u0001078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\"\u0010F\u001a\u00020?8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\"\u0010N\u001a\u00020G8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\"\u0010R\u001a\u00020G8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bO\u0010I\u001a\u0004\bP\u0010K\"\u0004\bQ\u0010MR\"\u0010Z\u001a\u00020S8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bT\u0010U\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR$\u0010b\u001a\u0004\u0018\u00010[8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\\\u0010]\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR$\u0010j\u001a\u0004\u0018\u00010c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bd\u0010e\u001a\u0004\bf\u0010g\"\u0004\bh\u0010iR$\u0010r\u001a\u0004\u0018\u00010k8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bl\u0010m\u001a\u0004\bn\u0010o\"\u0004\bp\u0010qR\"\u0010v\u001a\u00020G8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bs\u0010I\u001a\u0004\bt\u0010K\"\u0004\bu\u0010MR\"\u0010z\u001a\u00020G8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bw\u0010I\u001a\u0004\bx\u0010K\"\u0004\by\u0010M¨\u0006\u0083\u0001"}, d2 = {"Lcom/bytedance/android/livesdk/commerce/coupon/LiveCouponView;", "Landroid/widget/RelativeLayout;", "Landroid/view/View$OnClickListener;", "Lcom/bytedance/android/livesdkapi/depend/handler/WeakHandler$IHandler;", "Lcom/bytedance/android/livesdk/commerce/coupon/b;", "data", "", "setActivityData", "Lvl2/b;", "b", "Lvl2/b;", "getMCouponResourcePath", "()Lvl2/b;", "setMCouponResourcePath", "(Lvl2/b;)V", "mCouponResourcePath", "Lrg2/g;", "c", "Lrg2/g;", "getMLottieHelper", "()Lrg2/g;", "setMLottieHelper", "(Lrg2/g;)V", "mLottieHelper", "d", "Landroid/widget/RelativeLayout;", "getMCenterArea", "()Landroid/widget/RelativeLayout;", "setMCenterArea", "(Landroid/widget/RelativeLayout;)V", "mCenterArea", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "getMTryGetButton", "()Landroid/widget/TextView;", "setMTryGetButton", "(Landroid/widget/TextView;)V", "mTryGetButton", "f", "getMDescView", "setMDescView", "mDescView", "Lcom/airbnb/lottie/LottieAnimationView;", "g", "Lcom/airbnb/lottie/LottieAnimationView;", "getMDoubleCouponLottie", "()Lcom/airbnb/lottie/LottieAnimationView;", "setMDoubleCouponLottie", "(Lcom/airbnb/lottie/LottieAnimationView;)V", "mDoubleCouponLottie", "h", "getMHappyLottie", "setMHappyLottie", "mHappyLottie", "Lcom/bytedance/android/livesdk/commerce/coupon/LiveCouponView$b;", "i", "Lcom/bytedance/android/livesdk/commerce/coupon/LiveCouponView$b;", "getMCouponClick", "()Lcom/bytedance/android/livesdk/commerce/coupon/LiveCouponView$b;", "setMCouponClick", "(Lcom/bytedance/android/livesdk/commerce/coupon/LiveCouponView$b;)V", "mCouponClick", "Landroid/widget/FrameLayout;", "j", "Landroid/widget/FrameLayout;", "getMCouponView", "()Landroid/widget/FrameLayout;", "setMCouponView", "(Landroid/widget/FrameLayout;)V", "mCouponView", "Landroid/widget/ImageView;", "k", "Landroid/widget/ImageView;", "getMCloseView", "()Landroid/widget/ImageView;", "setMCloseView", "(Landroid/widget/ImageView;)V", "mCloseView", "l", "getMDoubleCoupon", "setMDoubleCoupon", "mDoubleCoupon", "", "m", "I", "getMButtonState", "()I", "setMButtonState", "(I)V", "mButtonState", "Lcom/bytedance/android/livesdk/commerce/coupon/d;", "n", "Lcom/bytedance/android/livesdk/commerce/coupon/d;", "getMCouponMsg", "()Lcom/bytedance/android/livesdk/commerce/coupon/d;", "setMCouponMsg", "(Lcom/bytedance/android/livesdk/commerce/coupon/d;)V", "mCouponMsg", "Lvl2/m;", "p", "Lvl2/m;", "getMHideLottieEntity", "()Lvl2/m;", "setMHideLottieEntity", "(Lvl2/m;)V", "mHideLottieEntity", "", "q", "Ljava/lang/String;", "getMMetaId", "()Ljava/lang/String;", "setMMetaId", "(Ljava/lang/String;)V", "mMetaId", "r", "getMFrontView", "setMFrontView", "mFrontView", "s", "getMBehindView", "setMBehindView", "mBehindView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveCouponView extends RelativeLayout implements View.OnClickListener, WeakHandler.IHandler {
    public final WeakHandler a;
    public vl2.b b;
    public rg2.g c;
    public RelativeLayout d;
    public TextView e;
    public TextView f;
    public LottieAnimationView g;
    public LottieAnimationView h;
    public b i;
    public FrameLayout j;
    public ImageView k;
    public ImageView l;
    public int m;
    public d n;
    public com.bytedance.android.livesdk.commerce.coupon.b o;
    public vl2.m p;
    public String q;
    public ImageView r;
    public ImageView s;
    public final c t;

    public static final class a {
    }

    public interface b {
        void a(String r1, Function0<Unit> r2);

        void b();

        void onCloseClick();
    }

    public static final class c implements Animator.AnimatorListener {
        public final /* synthetic */ LiveCouponView a;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
        }

        public c(LiveCouponView r1) {
            this.a = r1;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r8) {
            Intrinsics.checkNotNullParameter(r8, "animation");
            LiveCouponView r9 = this.a;
            com.bytedance.android.livesdk.commerce.coupon.b r0 = r9.o;
            if (r0 != null) goto L5;
        L18:
            vl2.b r1 = r9.b;
            if (r1 == null) goto L26;
            WeakHandler r10 = r9.a;
            String r2 = r1.e;
            l56.b r3 = l56.b.a();
            vl2.e r4 = new vl2.e(r2);
            if (r3.a == false) goto L24;
            r3.b.execute(new l56.a(r10, r4, 300));
            return;
        L24:
            throw new IllegalStateException("TaskManager not init");
        L26:
            return;
        L5:
            if (r0.activityType != 1) goto L7;
            boolean r5 = true;
        L9:
            if (r5 == true) goto L12;
            r0 = null;
        L12:
            if (r0 == null) goto L18;
            l56.b r6 = l56.b.a();
            WeakHandler r11 = r9.a;
            if (r6.a == false) goto L17;
            r6.b.execute(new l56.a(r11, null, 400));
            return;
        L17:
            throw new IllegalStateException("TaskManager not init");
        L7:
            r5 = false;
            goto L9
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            this.a.getMDoubleCoupon().setVisibility(4);
        }
    }

    static {
    }

    public LiveCouponView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public LiveCouponView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final ImageView getMBehindView() {
        return this.s;
    }

    public final int getMButtonState() {
        return this.m;
    }

    public final RelativeLayout getMCenterArea() {
        return this.d;
    }

    public final ImageView getMCloseView() {
        return this.k;
    }

    public final b getMCouponClick() {
        return this.i;
    }

    public final d getMCouponMsg() {
        return this.n;
    }

    public final vl2.b getMCouponResourcePath() {
        return this.b;
    }

    public final FrameLayout getMCouponView() {
        return this.j;
    }

    public final TextView getMDescView() {
        return this.f;
    }

    public final ImageView getMDoubleCoupon() {
        return this.l;
    }

    public final LottieAnimationView getMDoubleCouponLottie() {
        return this.g;
    }

    public final ImageView getMFrontView() {
        return this.r;
    }

    public final LottieAnimationView getMHappyLottie() {
        return this.h;
    }

    public final vl2.m getMHideLottieEntity() {
        return this.p;
    }

    public final rg2.g getMLottieHelper() {
        return this.c;
    }

    public final String getMMetaId() {
        return this.q;
    }

    public final TextView getMTryGetButton() {
        return this.e;
    }

    public final void a(vl2.b r3) {
        this.b = r3;
        if (r3 == null) goto L11;
        this.s.setImageURI(UriProtector.parse(r3.g));     // Catch: Exception -> L6
        this.r.setImageURI(UriProtector.parse(r3.f));     // Catch: Exception -> L6
        this.l.setImageURI(UriProtector.parse(r3.h));     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public final void handleMsg(Message r11) {
        Object r0 = null;
        if (r11 == null) goto L5;
        Integer r1 = Integer.valueOf(r11.what);
    L6:
        if (r11 == null) goto L9;
        r0 = r11.obj;
    L9:
        if (r1 == null) goto L24;
        if (r1.intValue() != 200) goto L24;
        if ((r0 instanceof vl2.m) == false) goto L44;
        vl2.m r2 = (vl2.m) r0;
        if (r2 != null) goto L18;
        return;
    L18:
        if (r2.a != 5) goto L53;
        this.p = r2;
        this.g.cancelAnimation();
        this.g.setProgress(0.0f);
        this.g.setVisibility(0);
        this.l.setVisibility(8);
        rg2.g r12 = this.c;
        if (r12 == null) goto L46;
        r12.a(r2, this.g, false);
        return;
    L46:
        return;
    L53:
        return;
    L44:
        return;
    L24:
        if (r1 != null) goto L27;
    L38:
        if (r1 != null) goto L41;
        return;
    L41:
        if (r1.intValue() != 400) goto L52;
        this.j.setVisibility(0);
        this.g.setVisibility(8);
        float r13 = this.j.getTranslationY();
        ObjectAnimator r14 = ObjectAnimator.ofFloat(this.j, View.TRANSLATION_Y, new float[]{r13, (r13 - this.j.getHeight()) + t6.a(getContext(), 25.0f)});
        r14.setDuration(600);
        LottieAnimationView r3 = this.g;
        ObjectAnimator r4 = ObjectAnimator.ofFloat(r3, View.TRANSLATION_Y, new float[]{r3.getTranslationY(), -10.0f});
        r4.setDuration(500);
        r4.start();
        r14.start();
        return;
    L52:
        return;
    L27:
        if (r1.intValue() != 300) goto L38;
        if ((r0 instanceof vl2.m) == false) goto L48;
        vl2.m r5 = (vl2.m) r0;
        if (r5 != null) goto L33;
        return;
    L33:
        if (r5.a != 5) goto L54;
        this.j.setVisibility(0);
        float r15 = this.j.getTranslationY();
        ObjectAnimator r16 = ObjectAnimator.ofFloat(this.j, View.TRANSLATION_Y, new float[]{r15, (r15 - this.j.getHeight()) + t6.a(getContext(), 2.0f)});
        r16.setDuration(600);
        r16.start();
        rg2.g r17 = this.c;
        if (r17 == null) goto L50;
        r17.a(r5, this.h, true);
        return;
    L50:
        return;
    L54:
        return;
    L48:
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        if (r5 != null) goto L4;
    L27:
        if (r5 != null) goto L29;
        return;
    L29:
        if (r5.getId() != 2131367009) goto L42;
        b r6 = this.i;
        if (r6 == null) goto L43;
        r6.onCloseClick();
        return;
    L43:
        return;
    L42:
        return;
    L4:
        if (r5.getId() != 2131389411) goto L27;
        int r7 = this.m;
        if (r7 != 0) goto L10;
        this.m = 2;
        b r8 = this.i;
        if (r8 == null) goto L34;
        r8.a(this.q, new AnonymousClass1(this));
        return;
    L34:
        return;
    L10:
        if (r7 != 2) goto L13;
        IESUIUtils.displayToast(getContext(), s1.B(2131918944));
        return;
    L13:
        if (r7 == 1) goto L15;
        return;
    L15:
        if (this.n == null) goto L38;
        IHostCommerceServiceLive r9 = TTLiveSDKContext.getHostService().c();
        if (r9 == null) goto L24;
        Context r0 = getContext();
        JSONObject r1 = new JSONObject();
        r1.put("entry_name", "coupon");
        d r2 = this.n;
        if (r2 == null) goto L22;
        String r3 = r2.couponMetaId;
        if (r3 == null) goto L22;
    L23:
        r1.put("coupon_id", r3);
        Unit r4 = Unit.INSTANCE;
        com.bytedance.android.livesdk.chatroom.bl.a r10 = new com.bytedance.android.livesdk.chatroom.bl.a(r9.showLivePromotionListFragment(r0, r1));
        PlatformMessageHelper.INSTANCE.setFollowGuideBarrier("EC_GOOD_LIST_DIALOG", r10);
    L22:
        r3 = "";
    L24:
        b r11 = this.i;
        if (r11 == null) goto L39;
        r11.b();
        return;
    L39:
        return;
    }

    public final void setActivityData(com.bytedance.android.livesdk.commerce.coupon.b r8) {
        this.o = r8;
        if (r8 == null) goto L46;
        boolean r4 = false;
        if (r8.activityType != 1) goto L7;
        boolean r0 = true;
    L9:
        if (r0 == false) goto L11;
        com.bytedance.android.livesdk.commerce.coupon.b r1 = r8;
    L12:
        if (r1 == null) goto L47;
        TextView r2 = this.f;
        String r3 = r8.beforeText;
        if (r3 != null) goto L17;
    L20:
        boolean r5 = true;
    L22:
        if ((!r5) == false) goto L24;
        com.bytedance.android.livesdk.commerce.coupon.b r6 = r8;
    L25:
        if (r6 == null) goto L29;
        String r7 = r6.beforeText;
        if (r7 == null) goto L29;
    L30:
        r2.setText(r7);
        this.f.setTextColor(s1.h(2131107250));
        this.f.setAlpha(1.0f);
        this.f.setTextSize(1, 13.0f);
        TextView r9 = this.e;
        String r10 = r8.beforeButton;
        if (r10 != null) goto L33;
    L34:
        r4 = true;
    L36:
        if ((!r4) == true) goto L39;
        r8 = null;
    L39:
        if (r8 == null) goto L43;
        String r11 = r8.beforeButton;
        if (r11 == null) goto L43;
    L44:
        r9.setText(r11);
        this.e.setTextColor(s1.h(2131107488));
        this.e.setTextSize(1, 15.0f);
        this.e.setBackgroundDrawable(s1.m(2131252225));
        return;
    L43:
        r11 = s1.B(2131920024);
        goto L44
    L33:
        if (r10.length() != 0) goto L36;
    L29:
        r7 = s1.B(2131919662);
        goto L30
    L24:
        r6 = null;
        goto L25
    L17:
        if (r3.length() == 0) goto L20;
        r5 = false;
        goto L22
    L47:
        return;
    L11:
        r1 = null;
        goto L12
    L7:
        r0 = false;
        goto L9
    }

    public final void setMBehindView(ImageView r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.s = r2;
    }

    public final void setMButtonState(int r1) {
        this.m = r1;
    }

    public final void setMCenterArea(RelativeLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.d = r2;
    }

    public final void setMCloseView(ImageView r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.k = r2;
    }

    public final void setMCouponClick(b r1) {
        this.i = r1;
    }

    public final void setMCouponMsg(d r1) {
        this.n = r1;
    }

    public final void setMCouponResourcePath(vl2.b r1) {
        this.b = r1;
    }

    public final void setMCouponView(FrameLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.j = r2;
    }

    public final void setMDescView(TextView r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.f = r2;
    }

    public final void setMDoubleCoupon(ImageView r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.l = r2;
    }

    public final void setMDoubleCouponLottie(LottieAnimationView r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.g = r2;
    }

    public final void setMFrontView(ImageView r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.r = r2;
    }

    public final void setMHappyLottie(LottieAnimationView r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.h = r2;
    }

    public final void setMHideLottieEntity(vl2.m r1) {
        this.p = r1;
    }

    public final void setMLottieHelper(rg2.g r1) {
        this.c = r1;
    }

    public final void setMMetaId(String r1) {
        this.q = r1;
    }

    public final void setMTryGetButton(TextView r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.e = r2;
    }

    public LiveCouponView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = new WeakHandler(Looper.getMainLooper(), this);
        LayoutInflater.from(r2).inflate(2131565341, this);
        this.d = (RelativeLayout) findViewById(2131365400);
        this.e = (TextView) findViewById(2131389411);
        this.f = (TextView) findViewById(2131368846);
        this.g = findViewById(2131370112);
        this.h = findViewById(2131374195);
        this.j = (FrameLayout) findViewById(2131383771);
        this.k = (ImageView) findViewById(2131367009);
        this.l = (ImageView) findViewById(2131370111);
        this.s = (ImageView) findViewById(2131364091);
        this.r = (ImageView) findViewById(2131373322);
        this.e.setTextColor(s1.h(2131108457));
        this.e.setOnClickListener(this);
        this.k.setOnClickListener(this);
        this.t = new c(this);
    }

    public /* synthetic */ LiveCouponView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
