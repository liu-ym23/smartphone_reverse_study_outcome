package com.bytedance.android.livesdk.chatroom.vs_impl.message;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.core.cache.LruCache;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.r;
import com.bytedance.android.livesdk.common.MarqueeTextView;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.android.livesdkapi.depend.model.live.vs.BusinessBarrageConfigure;
import com.bytedance.android.livesdkapi.depend.model.live.vs.BusinessConfigure;
import com.bytedance.android.livesdkapi.depend.model.live.vs.BusinessResourceConfigure;
import com.bytedance.live.datacontext.m;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import fq1.t;
import j40.f4;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import vr1.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016R\u001d\u0010\n\u001a\u0004\u0018\u00010\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u001d\u0010\u000f\u001a\u0004\u0018\u00010\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\u0007\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0012\u001a\u0004\u0018\u00010\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0007\u001a\u0004\b\u0011\u0010\tR\u001d\u0010\u0015\u001a\u0004\u0018\u00010\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0007\u001a\u0004\b\u0014\u0010\u000e¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/vs_impl/message/BusinessMsgView;", "Landroid/widget/FrameLayout;", "Lcq1/b;", "Landroid/view/View;", "getView", "Landroid/animation/AnimatorSet;", "m", "Lkotlin/Lazy;", "getInAnimationSet", "()Landroid/animation/AnimatorSet;", "inAnimationSet", "Landroid/view/animation/Animation;", "n", "getInAnimation", "()Landroid/view/animation/Animation;", "inAnimation", "o", "getOutAnimationSet", "outAnimationSet", "p", "getOutAnimation", "outAnimation", "a", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BusinessMsgView extends FrameLayout implements cq1.b {
    public final eq1.b a;
    public final View b;
    public final View c;
    public final View d;
    public final MarqueeTextView e;
    public final ImageView f;
    public final ImageView g;
    public final View h;
    public final ImageView i;
    public boolean j;
    public boolean k;
    public final BusinessMsgView$animationRunnable$1 l;
    public final Lazy m;
    public final Lazy n;
    public final Lazy o;
    public final Lazy p;

    public static final class a {
    }

    public static final class b implements Animator.AnimatorListener {
        public final /* synthetic */ AnimatorSet a;
        public final /* synthetic */ BusinessMsgView b;
        public final /* synthetic */ Function0 c;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            this.a.removeAllListeners();
            UtilityKotlinExtentionsKt.t(this.b.b);
            BusinessMsgView r3 = this.b;
            r3.e.removeCallbacks(r3.l);
            this.c.invoke();
        }

        public b(AnimatorSet r1, BusinessMsgView r2, Function0 r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class c implements Animator.AnimatorListener {
        public final /* synthetic */ AnimatorSet a;
        public final /* synthetic */ BusinessMsgView b;
        public final /* synthetic */ Function0 c;
        public final /* synthetic */ String d;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            this.a.removeAllListeners();
            BusinessMsgView r3 = this.b;
            r3.e.post(r3.l);
            this.c.invoke();
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r3) {
            Intrinsics.checkNotNullParameter(r3, "animation");
            UtilityKotlinExtentionsKt.w(this.b.b);
            String r4 = t.a().getCurrentUserId();
            if (this.d == null) goto L6;
            ((LruCache) f4.u.getValue()).put(r4 + "_" + this.d, 1);
            return;
        }

        public c(AnimatorSet r1, BusinessMsgView r2, Function0 r3, String r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    static {
    }

    public BusinessMsgView(Context r4) {
        this(r4, null, 0, 14);
    }

    public BusinessMsgView(Context r3, AttributeSet r4) {
        this(r3, r4, 0, 12);
    }

    public BusinessMsgView(Context r2, AttributeSet r3, int r4) {
        this(r2, r3, r4, 8);
    }

    private final Animation getInAnimation() {
        return (Animation) this.n.getValue();
    }

    private final AnimatorSet getInAnimationSet() {
        return (AnimatorSet) this.m.getValue();
    }

    private final Animation getOutAnimation() {
        return (Animation) this.p.getValue();
    }

    private final AnimatorSet getOutAnimationSet() {
        return (AnimatorSet) this.o.getValue();
    }

    @Override // cq1.b
    public View getView() {
        return this;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r5) {
        Rect r0 = new Rect();
        this.c.getGlobalVisibleRect(r0);
        if (r5 == null) goto L5;
        int r2 = (int) r5.getRawX();
    L6:
        if (r5 == null) goto L8;
        int r3 = (int) r5.getRawY();
    L10:
        if (r0.contains(r2, r3) == false) goto L13;
        this.k = true;
        return true;
    L13:
        this.k = false;
        return super.onInterceptTouchEvent(r5);
    L8:
        r3 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public static Integer d(String r2, String r3) {
        if (r2 != null) goto L4;
    L11:
        return null;
    L4:
        if (r2.length() <= 0) goto L6;
        boolean r0 = true;
    L7:
        if (r0 != true) goto L11;
        return Integer.valueOf(Color.parseColor(r2));
    L10:
        ALogger.e("BusinessMsgView", "color " + r2 + " parse fail, scene " + r3);
        goto L11
    L6:
        r0 = false;
        goto L7
    }

    @Override // cq1.b
    public final void b(final BusinessConfigure r18, String r19) {
        Intrinsics.checkNotNullParameter(r18, "businessConfigure");
        BusinessResourceConfigure r3 = r18.resourceConfig;
        if (r3 == null) goto L109;
        BusinessBarrageConfigure r4 = r3.barrageConfig;
        if (r4 == null) goto L111;
        boolean r5 = false;
        this.j = false;
        UtilityKotlinExtentionsKt.t(this.b);
        MarqueeTextView r6 = this.e;
        r6.setTextWithEllipsisImmediately("");
        r6.setTextColor(-16777216);
        UtilityKotlinExtentionsKt.t(this.f);
        UtilityKotlinExtentionsKt.t(this.g);
        Drawable r7 = this.h.getBackground();
        if ((r7 instanceof GradientDrawable) == true) goto L10;
        r7 = null;
    L10:
        GradientDrawable r8 = (GradientDrawable) r7;
        if (r8 == null) goto L13;
        r8.setColor(0);
        r8.setStroke(s1.f(1.0f), -1);
        this.h.setBackground(r8);
    L13:
        ViewGroup.LayoutParams r9 = this.e.getLayoutParams();
        if ((r9 instanceof ConstraintLayout.LayoutParams) == true) goto L16;
        r9 = null;
    L16:
        ConstraintLayout.LayoutParams r10 = (ConstraintLayout.LayoutParams) r9;
        if (r10 == null) goto L19;
        r10.constrainedWidth = Intrinsics.areEqual("business_info_portrait", r19);
    L19:
        this.e.setIncludeFontPadding(true);
        Integer r11 = d(r4.getAtomsTextColor(), "atomsTextColor");
        if (r11 == null) goto L22;
        this.e.setTextColor(r11.intValue());
    L23:
        Drawable r12 = this.h.getBackground();
        if ((r12 instanceof GradientDrawable) == true) goto L26;
        r12 = null;
    L26:
        GradientDrawable r13 = (GradientDrawable) r12;
        if (r13 == null) goto L37;
        Integer r14 = d(r4.getAtomsBgColor(), null);
        if (r14 == null) goto L31;
        r13.setColor(r14.intValue());
    L32:
        Integer r15 = d(r4.getAtomsFrameColor(), null);
        if (r15 == null) goto L35;
        r13.setStroke(s1.f(1.0f), r15.intValue());
    L36:
        this.h.setBackground(r13);
        goto L37
    L35:
        r13.setStroke(s1.f(1.0f), ColorProtector.parseColor("#7FFFE5F1"));
        goto L36
    L31:
        r13.setColor(ColorProtector.parseColor("#66FF308A"));
    L37:
        int r16 = 2131364961;
        if (r18.businessType != BusinessConfigure.BusinessType.STRONG_BARRAGE) goto L64;
        Bitmap r17 = r4.getLogoBitmap();
        if (r17 == null) goto L42;
        this.f.setImageBitmap(r17);
        UtilityKotlinExtentionsKt.w(this.f);
    L43:
        Bitmap r20 = r4.getTailBitmap();
        if (r20 == null) goto L46;
        this.g.setImageBitmap(r20);
        UtilityKotlinExtentionsKt.w(this.g);
    L47:
        ViewGroup.LayoutParams r21 = this.e.getLayoutParams();
        if ((r21 instanceof ConstraintLayout.LayoutParams) == true) goto L50;
        r21 = null;
    L50:
        ConstraintLayout.LayoutParams r22 = (ConstraintLayout.LayoutParams) r21;
        if (r22 == null) goto L57;
        r22.setMargins(0, 0, 0, 0);
        r22.leftToRight = 2131364964;
        if (r4.getJumpIconBitmap() != null) goto L56;
        r16 = 2131364969;
    L56:
        r22.rightToLeft = r16;
        r22.leftToLeft = -1;
        r22.rightToRight = -1;
    L57:
        ViewGroup.LayoutParams r23 = this.i.getLayoutParams();
        if ((r23 instanceof ConstraintLayout.LayoutParams) == true) goto L60;
        r23 = null;
    L60:
        ConstraintLayout.LayoutParams r24 = (ConstraintLayout.LayoutParams) r23;
        if (r24 == null) goto L89;
        r24.setMargins(s1.f(3.0f), s1.f(1.5f), 0, 0);
    L89:
        Bitmap r25 = r4.getJumpIconBitmap();
        if (r25 == null) goto L92;
        this.i.setImageBitmap(r25);
        UtilityKotlinExtentionsKt.w(this.i);
    L93:
        final String r26 = r4.getSchema();
        if (r26 != null) goto L96;
    L103:
        setOnClickListener(null);
    L105:
        if (Intrinsics.areEqual("business_info_portrait", r19) == false) goto L107;
        this.e.setTextWithEllipsis(r4.getText());
        return;
    L107:
        this.e.setTextWithEllipsisImmediately(r4.getText());
        return;
    L96:
        if (r26.length() <= 0) goto L98;
        r5 = true;
    L98:
        if (r5 == true) goto L101;
        r26 = null;
    L101:
        if (r26 == null) goto L103;
        setOnClickListener(x0.a(new BusinessMsgView$bindView$$inlined$also$lambda$1(r26, this, r18)));
        goto L105
    L92:
        UtilityKotlinExtentionsKt.t(this.i);
        Unit r27 = Unit.INSTANCE;
        goto L93
    L46:
        UtilityKotlinExtentionsKt.t(this.g);
        goto L47
    L42:
        UtilityKotlinExtentionsKt.t(this.f);
        goto L43
    L64:
        if (r4.getJumpIconBitmap() == null) goto L77;
        ViewGroup.LayoutParams r28 = this.e.getLayoutParams();
        if ((r28 instanceof ConstraintLayout.LayoutParams) == true) goto L68;
        r28 = null;
    L68:
        ConstraintLayout.LayoutParams r29 = (ConstraintLayout.LayoutParams) r28;
        if (r29 == null) goto L71;
        r29.setMargins(s1.f(12.0f), 0, 0, 0);
        r29.leftToLeft = 0;
        r29.rightToLeft = 2131364961;
        r29.leftToRight = -1;
        r29.rightToRight = -1;
    L71:
        ViewGroup.LayoutParams r30 = this.i.getLayoutParams();
        if ((r30 instanceof ConstraintLayout.LayoutParams) == true) goto L74;
        r30 = null;
    L74:
        ConstraintLayout.LayoutParams r31 = (ConstraintLayout.LayoutParams) r30;
        if (r31 == null) goto L89;
        r31.setMargins(s1.f(3.0f), s1.f(1.5f), s1.f(8.0f), 0);
        goto L89
    L77:
        ViewGroup.LayoutParams r32 = this.e.getLayoutParams();
        if ((r32 instanceof ConstraintLayout.LayoutParams) == true) goto L80;
        r32 = null;
    L80:
        ConstraintLayout.LayoutParams r33 = (ConstraintLayout.LayoutParams) r32;
        if (r33 == null) goto L83;
        r33.setMargins(s1.f(12.0f), 0, s1.f(12.0f), 0);
        r33.leftToLeft = 0;
        r33.rightToRight = 0;
        r33.leftToRight = -1;
        r33.rightToLeft = -1;
    L83:
        ViewGroup.LayoutParams r34 = this.i.getLayoutParams();
        if ((r34 instanceof ConstraintLayout.LayoutParams) == true) goto L86;
        r34 = null;
    L86:
        ConstraintLayout.LayoutParams r35 = (ConstraintLayout.LayoutParams) r34;
        if (r35 == null) goto L89;
        r35.setMargins(s1.f(3.0f), s1.f(1.5f), 0, 0);
        goto L89
    L22:
        this.e.setTextColor(-1);
        goto L23
    L111:
        return;
    }

    public final void c(boolean r3, Function0<Unit> r4) {
        Intrinsics.checkNotNullParameter(r4, "endAction");
        if (this.b.getVisibility() != 8) goto L5;
        return;
    L5:
        AnimatorSet r0 = getInAnimationSet();
        if (r0 == null) goto L8;
        r0.cancel();
    L8:
        if (r3 == false) goto L15;
        AnimatorSet r5 = getOutAnimationSet();
        if (r5 == null) goto L17;
        r5.addListener(new b(r5, this, r4));
        if (r5.isRunning() == false) goto L14;
        r5.cancel();
    L14:
        r5.start();
        return;
    L17:
        return;
    L15:
        UtilityKotlinExtentionsKt.t(this.b);
    }

    public final boolean e(String r4, Function0<Unit> r5) {
        Intrinsics.checkNotNullParameter(r5, "showAction");
        if (this.b.getVisibility() != 0) goto L5;
        return true;
    L5:
        AnimatorSet r0 = getOutAnimationSet();
        if (r0 == null) goto L8;
        r0.cancel();
    L8:
        AnimatorSet r1 = getInAnimationSet();
        if (r1 == null) goto L15;
        r1.addListener(new c(r1, this, r5, r4));
        if (r1.isRunning() == false) goto L13;
        r1.cancel();
    L13:
        r1.start();
        return true;
    L15:
        return false;
    }

    /* JADX WARN: Type inference failed for: r5v12, types: [com.bytedance.android.livesdk.chatroom.vs_impl.message.BusinessMsgView$animationRunnable$1] */
    public BusinessMsgView(final Context r3, AttributeSet r4, int r5, int r6) {
        if ((r6 & 2) == 0) goto L5;
        r4 = null;
    L5:
        boolean r0 = false;
        if ((r6 & 4) == 0) goto L8;
        r5 = 0;
    L8:
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, r5);
        u r7 = r.u(null, null, 2);
        if (r7 == null) goto L15;
        m<Boolean> r8 = r7.A();
        if (r8 == null) goto L15;
        if (((Boolean) r8.getValue()).booleanValue() != true) goto L15;
        r0 = true;
    L15:
        this.a = new eq1.b(true, r0);
        View r9 = LayoutInflater.from(r3).inflate(2131565282, this, true);
        this.b = r9;
        this.c = r9.findViewById(2131364966);
        this.d = r9.findViewById(2131364965);
        this.e = (MarqueeTextView) r9.findViewById(2131364970);
        this.f = (ImageView) r9.findViewById(2131364964);
        this.g = (ImageView) r9.findViewById(2131364969);
        this.h = r9.findViewById(2131364965);
        this.i = (ImageView) r9.findViewById(2131364961);
        this.l = new BusinessMsgView$animationRunnable$1(this);
        this.m = LazyKt.lazy(new BusinessMsgView$inAnimationSet$2(this));
        this.n = LazyKt.lazy(new BusinessMsgView$inAnimation$2(r3));
        this.o = LazyKt.lazy(new BusinessMsgView$outAnimationSet$2(this));
        this.p = LazyKt.lazy(new BusinessMsgView$outAnimation$2(r3));
        UtilityKotlinExtentionsKt.t(r9);
    }

    @Override // cq1.b
    public final void a(int r2, int r3, int r4, int r5, int r6, int r7) {
        ViewGroup.LayoutParams r0 = this.f.getLayoutParams();
        r0.height = r2;
        r0.width = r3;
        ViewGroup.LayoutParams r8 = this.g.getLayoutParams();
        r8.height = r4;
        r8.width = r5;
        this.e.setTextSize(1, s1.G(r6));
        this.d.getLayoutParams().height = r7;
    }
}
