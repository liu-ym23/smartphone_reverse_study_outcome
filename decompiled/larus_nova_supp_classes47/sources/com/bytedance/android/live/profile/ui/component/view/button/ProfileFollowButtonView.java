package com.bytedance.android.live.profile.ui.component.view.button;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.NinePatchDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.base.model.user.ProfileCustomSkin;
import com.bytedance.android.live.base.model.user.ProfileSkin;
import com.bytedance.android.live.base.model.user.c0;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.platform.ILiveProfilePlatformService;
import com.bytedance.android.live.profile.model.h;
import com.bytedance.android.live.profile.ui.component.view.ProfileButtonView;
import com.bytedance.android.live.profile.ui.util.DressType;
import com.bytedance.android.live.profile.ui.util.l;
import com.bytedance.android.live.profile.ui.util.m;
import com.bytedance.android.live.profile.ui.util.t;
import com.bytedance.android.live.profit.dress.config.x;
import com.bytedance.android.live.service.preinflate.ProfilePreInflateUtil;
import com.bytedance.android.live.service.preinflate.ProfilePreInflateViewInfo;
import com.bytedance.android.live.uikit.util.RTLUtil;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.paas.HostInfoPresenter;
import com.bytedance.badger.collect.impl.constants.Constants;
import java.util.List;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import rs0.b0;
import rs0.i;
import zt0.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u00100\u001a\u00020/\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u000101\u0012\b\b\u0002\u00103\u001a\u00020\u0014¢\u0006\u0004\b4\u00105J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rJ\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rJ\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\rJ\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000e0\rJ\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\u0010\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0017H\u0002R#\u0010\u001f\u001a\n \u001a*\u0004\u0018\u00010\u00170\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR#\u0010\"\u001a\n \u001a*\u0004\u0018\u00010\u00170\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u001c\u001a\u0004\b!\u0010\u001eR#\u0010%\u001a\n \u001a*\u0004\u0018\u00010\u00170\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u001c\u001a\u0004\b$\u0010\u001eR#\u0010(\u001a\n \u001a*\u0004\u0018\u00010\u00170\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\u001c\u001a\u0004\b'\u0010\u001eR#\u0010+\u001a\n \u001a*\u0004\u0018\u00010\u00170\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\u001c\u001a\u0004\b*\u0010\u001eR#\u0010.\u001a\n \u001a*\u0004\u0018\u00010\u00170\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010\u001c\u001a\u0004\b-\u0010\u001e¨\u00066"}, d2 = {"Lcom/bytedance/android/live/profile/ui/component/view/button/ProfileFollowButtonView;", "Lcom/bytedance/android/live/profile/ui/component/view/ProfileButtonView;", "", "isFansGroupEnhance", "", "setFansGroupEnhance", "isFansGroupTextOpt", "setFansGroupTextOpt", "Lst0/b;", Constants.Keys.DATA, "Lcom/bytedance/android/live/base/model/user/NewProfileUser;", "user", "update", "", "Landroid/animation/Animator;", "getFirstFollowAnimatorsWithFansGroup", "getSecondFollowAnimatotsWithFansGroup", "getFollowAnimatorSet", "getCancelFollowAnimatorSet", "setFollowBackground", "", "status", "setFollowStatus", "", "str", "setTalkback", "kotlin.jvm.PlatformType", "n", "Lkotlin/Lazy;", "getFollowString", "()Ljava/lang/String;", "followString", "o", "getFollowedString", "followedString", "p", "getFollowedWithFansGroupString", "followedWithFansGroupString", "q", "getFansGroupString", "fansGroupString", "r", "getFollowBackString", "followBackString", "s", "getFollowEachString", "followEachString", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class ProfileFollowButtonView extends ProfileButtonView {
    public ConstraintLayout f;
    public ImageView g;
    public TextView h;
    public LinearLayout i;
    public ImageView j;
    public TextView k;
    public ViewGroup l;
    public LinearLayout m;
    public final Lazy n;
    public final Lazy o;
    public final Lazy p;
    public final Lazy q;
    public final Lazy r;
    public final Lazy s;
    public final int t;
    public boolean u;

    public static final class a implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ ProfileFollowButtonView a;

        public a(ProfileFollowButtonView r1) {
            this.a = r1;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r3) {
            Intrinsics.checkNotNullParameter(r3, "it");
            Object r4 = r3.getAnimatedValue();
            if ((r4 instanceof Float) == true) goto L5;
            r4 = null;
        L5:
            Float r5 = (Float) r4;
            if (r5 == null) goto L12;
            float r6 = r5.floatValue();
            LinearLayout r0 = this.a.i;
            if (r0 != null) goto L10;
            Intrinsics.throwUninitializedPropertyAccessException("followedLayout");
        L10:
            r0.setAlpha(r6);
            return;
        }
    }

    public static final class b implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ ProfileFollowButtonView a;

        public b(ProfileFollowButtonView r1) {
            this.a = r1;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r2) {
            Intrinsics.checkNotNullParameter(r2, "it");
            Object r3 = r2.getAnimatedValue();
            if ((r3 instanceof Float) == true) goto L5;
            r3 = null;
        L5:
            Float r4 = (Float) r3;
            if (r4 == null) goto L11;
            float r5 = r4.floatValue();
            LinearLayout r0 = this.a.m;
            if (r0 == null) goto L12;
            r0.setAlpha(r5);
            return;
        L12:
            return;
        }
    }

    public static final class c implements a1.c {
        public final /* synthetic */ HSImageView a;

        public final void onFail() {
        }

        public c(HSImageView r1) {
            this.a = r1;
        }

        public final void a(NinePatchDrawable r2) {
            this.a.setBackgroundDrawable(r2);
        }
    }

    public ProfileFollowButtonView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ProfileFollowButtonView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final String getFansGroupString() {
        return (String) this.q.getValue();
    }

    private final String getFollowBackString() {
        return (String) this.r.getValue();
    }

    private final String getFollowEachString() {
        return (String) this.s.getValue();
    }

    private final String getFollowString() {
        return (String) this.n.getValue();
    }

    private final String getFollowedString() {
        return (String) this.o.getValue();
    }

    private final String getFollowedWithFansGroupString() {
        return (String) this.p.getValue();
    }

    public final List<Animator> getFirstFollowAnimatorsWithFansGroup() {
        return null;
    }

    public final List<Animator> getSecondFollowAnimatotsWithFansGroup() {
        ValueAnimator r1 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        r1.addUpdateListener(new a(this));
        r1.setDuration(500);
        ValueAnimator r4 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r4.addUpdateListener(new b(this));
        r4.setDuration(500);
        return CollectionsKt.listOf(new ValueAnimator[]{r1, r4});
    }

    @Override // com.bytedance.android.live.profile.ui.component.view.ProfileButtonView
    public final void i(st0.b r2) {
        Intrinsics.checkNotNullParameter(r2, Constants.Keys.DATA);
    }

    public final List<Animator> getCancelFollowAnimatorSet() {
        ConstraintLayout r0 = this.f;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("followLayout");
    L5:
        ObjectAnimator r1 = ObjectAnimator.ofFloat(r0, "alpha", new float[]{0.0f, 1.0f}).setDuration(150);
        LinearLayout r2 = this.i;
        if (r2 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("followedLayout");
    L9:
        return CollectionsKt.listOf(new ObjectAnimator[]{r1, ObjectAnimator.ofFloat(r2, "alpha", new float[]{1.0f, 0.0f}).setDuration(150)});
    }

    public final List<Animator> getFollowAnimatorSet() {
        ConstraintLayout r0 = this.f;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("followLayout");
    L5:
        ObjectAnimator r1 = ObjectAnimator.ofFloat(r0, "alpha", new float[]{1.0f, 0.0f}).setDuration(150);
        LinearLayout r2 = this.i;
        if (r2 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("followedLayout");
    L9:
        return CollectionsKt.listOf(new ObjectAnimator[]{r1, ObjectAnimator.ofFloat(r2, "alpha", new float[]{0.0f, 1.0f}).setDuration(150)});
    }

    public final void n() {
        ILiveProfilePlatformService r0 = k.f(ILiveProfilePlatformService.class);
        if (r0 == null) goto L19;
        h r1 = r0.getProfileBtnResource();
        if (r1 != null) goto L7;
        return;
    L7:
        if (r1.a != true) goto L21;
        ConstraintLayout r2 = this.f;
        if (r2 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("followLayout");
    L11:
        r2.setBackgroundResource(2131249766);
        TextView r3 = this.h;
        if (r3 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("followText");
    L14:
        r3.setTextColor(getResources().getColor(2131108252));
        ImageView r4 = this.g;
        if (r4 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("followIcon");
    L17:
        r4.getDrawable().setColorFilter(getResources().getColor(2131108252), PorterDuff.Mode.SRC_IN);
        return;
    L21:
        return;
    }

    private final void setFollowBackground(NewProfileUser r12) {
        d r0 = yt0.c.b();
        if (r0 == null) goto L5;
        zt0.c r1 = r0.d2();
    L6:
        if (r1 == null) goto L15;
        ProfileSkin r2 = r12.mProfileSkin;
        if (r2 == null) goto L13;
        ProfileCustomSkin r3 = r2.skin;
        if (r3 == null) goto L13;
        String r4 = r3.dressId;
        if (r4 == null) goto L13;
    L14:
        x r5 = (x) r1.a(r4, Reflection.getOrCreateKotlinClass(x.class));
    L16:
        HSImageView r6 = findViewById(2131380768);
        if (r6 != null) goto L19;
        return;
    L19:
        int r7 = t.a;
        b0 r8 = b0.a;
        if (((ss0.a) r8.getValue()).f() == false) goto L22;
        py.k r9 = l.a(r12, DressType.MainButtonWebp, r5);
    L24:
        if (((ss0.a) r8.getValue()).e() == false) goto L26;
        py.k r13 = l.a(r12, DressType.MainButton9Png, r5);
    L27:
        if (r9 != null) goto L29;
        if (r13 != null) goto L29;
    L35:
        if (r9 == null) goto L37;
        ImageLoader.bindImage(r6, r9, null, -1, -1, null, null, true);
        return;
    L37:
        if (r13 == null) goto L41;
        a1.d(r13, RTLUtil.isAppRTL(s1.getContext()), new c(r6));
        return;
    L41:
        return;
    L29:
        ConstraintLayout r10 = this.f;
        if (r10 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("followLayout");
    L32:
        r10.setBackground(null);
        ViewGroup r14 = this.l;
        if (r14 == null) goto L35;
        r14.setVisibility(0);
        goto L35
    L26:
        r13 = null;
        goto L27
    L22:
        r9 = null;
    L13:
        r4 = "";
        goto L14
    L15:
        r5 = null;
        goto L16
    L5:
        r1 = null;
        goto L6
    }

    private final void setFollowStatus(int r7) {
        if (r7 != 0) goto L5;
        TextView r8 = this.h;
        if (r8 != null) goto L100;
        Intrinsics.throwUninitializedPropertyAccessException("followText");
    L100:
        r8.setText(getFollowString());
        ConstraintLayout r9 = this.f;
        if (r9 != null) goto L103;
        Intrinsics.throwUninitializedPropertyAccessException("followLayout");
    L103:
        UtilityKotlinExtentionsKt.w(r9);
        LinearLayout r10 = this.i;
        if (r10 != null) goto L106;
        Intrinsics.throwUninitializedPropertyAccessException("followedLayout");
    L106:
        UtilityKotlinExtentionsKt.u(r10);
        LinearLayout r12 = this.m;
        if (r12 == null) goto L109;
        UtilityKotlinExtentionsKt.u(r12);
    L109:
        setTalkback(getFollowString());
        return;
    L5:
        if (r7 == 1) goto L70;
        if (r7 == 2) goto L25;
        if (r7 != 3) goto L116;
        TextView r13 = this.h;
        if (r13 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("followText");
    L14:
        r13.setText(getFollowBackString());
        ConstraintLayout r14 = this.f;
        if (r14 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("followLayout");
    L17:
        UtilityKotlinExtentionsKt.w(r14);
        LinearLayout r15 = this.i;
        if (r15 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("followedLayout");
    L20:
        UtilityKotlinExtentionsKt.u(r15);
        LinearLayout r16 = this.m;
        if (r16 == null) goto L23;
        UtilityKotlinExtentionsKt.u(r16);
    L23:
        setTalkback(getFollowBackString());
        return;
    L116:
        return;
    L25:
        if (this.u == false) goto L36;
        ConstraintLayout r17 = this.f;
        if (r17 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("followLayout");
    L29:
        UtilityKotlinExtentionsKt.u(r17);
        LinearLayout r18 = this.i;
        if (r18 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("followedLayout");
    L32:
        UtilityKotlinExtentionsKt.u(r18);
        LinearLayout r19 = this.m;
        if (r19 == null) goto L35;
        UtilityKotlinExtentionsKt.w(r19);
    L35:
        setTalkback(getFansGroupString());
        return;
    L36:
        TextView r20 = this.k;
        if (r20 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("followedText");
    L39:
        r20.setText(getFollowEachString());
        ILiveProfilePlatformService r22 = k.f(ILiveProfilePlatformService.class);
        if (r22 == null) goto L44;
        h r23 = r22.getProfileBtnResource();
        if (r23 == null) goto L44;
        boolean r24 = r23.b;
    L45:
        if (r24 == true) goto L55;
        int r25 = this.t;
        ImageView r0 = this.j;
        if (r0 != null) goto L49;
        Intrinsics.throwUninitializedPropertyAccessException("followedEachIcon");
    L49:
        if (r0 != null) goto L52;
    L59:
        ConstraintLayout r26 = this.f;
        if (r26 != null) goto L62;
        Intrinsics.throwUninitializedPropertyAccessException("followLayout");
    L62:
        UtilityKotlinExtentionsKt.u(r26);
        LinearLayout r27 = this.i;
        if (r27 != null) goto L65;
        Intrinsics.throwUninitializedPropertyAccessException("followedLayout");
    L65:
        UtilityKotlinExtentionsKt.w(r27);
        LinearLayout r28 = this.m;
        if (r28 == null) goto L68;
        UtilityKotlinExtentionsKt.u(r28);
    L68:
        setTalkback(getFollowEachString());
        return;
    L52:
        if (r25 == (-1)) goto L54;
        r0.setImageResource(r25);
        UtilityKotlinExtentionsKt.w(r0);
        goto L59
    L54:
        UtilityKotlinExtentionsKt.t(r0);
        goto L59
    L55:
        ImageView r29 = this.j;
        if (r29 != null) goto L58;
        Intrinsics.throwUninitializedPropertyAccessException("followedEachIcon");
    L58:
        UtilityKotlinExtentionsKt.t(r29);
    L44:
        r24 = false;
        goto L45
    L70:
        if (this.u == false) goto L81;
        ConstraintLayout r30 = this.f;
        if (r30 != null) goto L74;
        Intrinsics.throwUninitializedPropertyAccessException("followLayout");
    L74:
        UtilityKotlinExtentionsKt.u(r30);
        LinearLayout r32 = this.i;
        if (r32 != null) goto L77;
        Intrinsics.throwUninitializedPropertyAccessException("followedLayout");
    L77:
        UtilityKotlinExtentionsKt.u(r32);
        LinearLayout r33 = this.m;
        if (r33 == null) goto L80;
        UtilityKotlinExtentionsKt.w(r33);
    L80:
        setTalkback(getFansGroupString());
        return;
    L81:
        TextView r34 = this.k;
        if (r34 != null) goto L84;
        Intrinsics.throwUninitializedPropertyAccessException("followedText");
    L84:
        r34.setText(getFollowedString());
        ConstraintLayout r35 = this.f;
        if (r35 != null) goto L87;
        Intrinsics.throwUninitializedPropertyAccessException("followLayout");
    L87:
        UtilityKotlinExtentionsKt.u(r35);
        LinearLayout r36 = this.i;
        if (r36 != null) goto L90;
        Intrinsics.throwUninitializedPropertyAccessException("followedLayout");
    L90:
        UtilityKotlinExtentionsKt.w(r36);
        ImageView r37 = this.j;
        if (r37 != null) goto L93;
        Intrinsics.throwUninitializedPropertyAccessException("followedEachIcon");
    L93:
        UtilityKotlinExtentionsKt.t(r37);
        LinearLayout r38 = this.m;
        if (r38 == null) goto L96;
        UtilityKotlinExtentionsKt.u(r38);
    L96:
        setTalkback(getFollowedString());
    }

    private final void setTalkback(String r3) {
        setContentDescription(s1.C(2131921753, new Object[]{r3}));
    }

    @Override // com.bytedance.android.live.profile.ui.component.view.ProfileButtonView, com.bytedance.android.live.profile.ui.component.base.e
    public final /* bridge */ /* synthetic */ void e(st0.b r1) {
        i(r1);
    }

    @Override // com.bytedance.android.live.profile.ui.component.view.ProfileButtonView
    public final void f(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        if (ProfilePreInflateUtil.a() == false) goto L5;
        ProfilePreInflateUtil.c(ProfilePreInflateViewInfo.TTLIVE_PROFILE_FOLLOE_BUTTON, r4, LayoutInflater.from(r4), this, true);
    L6:
        setContentView((ViewGroup) findViewById(2131380813));
        this.f = findViewById(2131380770);
        this.g = (ImageView) findViewById(2131380769);
        this.h = (TextView) findViewById(2131380771);
        this.i = (LinearLayout) findViewById(2131380773);
        this.j = (ImageView) findViewById(2131380772);
        this.k = (TextView) findViewById(2131380774);
        this.m = (LinearLayout) findViewById(2131380765);
        ViewGroup r5 = (ViewGroup) findViewById(2131380812);
        this.l = r5;
        if (r5 == null) goto L10;
        r5.setVisibility(8);
    L10:
        if (HostInfoPresenter.e() == false) goto L15;
        ConstraintLayout r6 = this.f;
        if (r6 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("followLayout");
    L14:
        r6.setBackgroundResource(2131249761);
    L15:
        n();
        return;
    L5:
        LayoutInflater.from(r4).inflate(2131567202, this, true);
        goto L6
    }

    public final void l(int r8) {
        if (r8 != 0) goto L5;
        TextView r9 = this.h;
        if (r9 != null) goto L56;
        Intrinsics.throwUninitializedPropertyAccessException("followText");
    L56:
        r9.setText(getFollowString());
        ConstraintLayout r10 = this.f;
        if (r10 != null) goto L59;
        Intrinsics.throwUninitializedPropertyAccessException("followLayout");
    L59:
        r10.setAlpha(0.0f);
        ConstraintLayout r12 = this.f;
        if (r12 != null) goto L62;
        Intrinsics.throwUninitializedPropertyAccessException("followLayout");
    L62:
        UtilityKotlinExtentionsKt.w(r12);
        setTalkback(getFollowString());
        return;
    L5:
        if (r8 != 1) goto L7;
        TextView r13 = this.k;
        if (r13 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("followedText");
    L43:
        r13.setText(getFollowedString());
        LinearLayout r14 = this.i;
        if (r14 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("followedLayout");
    L46:
        r14.setAlpha(0.0f);
        LinearLayout r15 = this.i;
        if (r15 != null) goto L49;
        Intrinsics.throwUninitializedPropertyAccessException("followedLayout");
    L49:
        UtilityKotlinExtentionsKt.w(r15);
        ImageView r16 = this.j;
        if (r16 != null) goto L52;
        Intrinsics.throwUninitializedPropertyAccessException("followedEachIcon");
    L52:
        UtilityKotlinExtentionsKt.t(r16);
        setTalkback(getFollowedString());
        return;
    L7:
        if (r8 != 2) goto L9;
        TextView r17 = this.k;
        if (r17 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("followedText");
    L24:
        r17.setText(getFollowEachString());
        int r18 = this.t;
        ImageView r0 = this.j;
        if (r0 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("followedEachIcon");
    L27:
        if (r0 != null) goto L30;
    L33:
        LinearLayout r19 = this.i;
        if (r19 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("followedLayout");
    L36:
        r19.setAlpha(0.0f);
        LinearLayout r20 = this.i;
        if (r20 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("followedLayout");
    L39:
        UtilityKotlinExtentionsKt.w(r20);
        setTalkback(getFollowEachString());
        return;
    L30:
        if (r18 == (-1)) goto L32;
        r0.setImageResource(r18);
        UtilityKotlinExtentionsKt.w(r0);
        goto L33
    L32:
        UtilityKotlinExtentionsKt.t(r0);
        goto L33
    L9:
        if (r8 != 3) goto L67;
        TextView r22 = this.h;
        if (r22 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("followText");
    L14:
        r22.setText(getFollowBackString());
        ConstraintLayout r23 = this.f;
        if (r23 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("followLayout");
    L17:
        r23.setAlpha(0.0f);
        ConstraintLayout r24 = this.f;
        if (r24 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("followLayout");
    L20:
        UtilityKotlinExtentionsKt.w(r24);
        setTalkback(getFollowBackString());
        return;
    }

    public final void m(int r8) {
        if (r8 != 0) goto L5;
        TextView r9 = this.h;
        if (r9 != null) goto L58;
        Intrinsics.throwUninitializedPropertyAccessException("followText");
    L58:
        r9.setText(getFollowString());
        ConstraintLayout r10 = this.f;
        if (r10 != null) goto L61;
        Intrinsics.throwUninitializedPropertyAccessException("followLayout");
    L61:
        UtilityKotlinExtentionsKt.w(r10);
        ConstraintLayout r12 = this.f;
        if (r12 != null) goto L64;
        Intrinsics.throwUninitializedPropertyAccessException("followLayout");
    L64:
        r12.setAlpha(1.0f);
        LinearLayout r13 = this.i;
        if (r13 != null) goto L67;
        Intrinsics.throwUninitializedPropertyAccessException("followedLayout");
    L67:
        UtilityKotlinExtentionsKt.u(r13);
        LinearLayout r14 = this.m;
        if (r14 == null) goto L70;
        UtilityKotlinExtentionsKt.u(r14);
    L70:
        setTalkback(getFollowString());
        return;
    L5:
        if (r8 == 1) goto L26;
        if (r8 == 2) goto L26;
        if (r8 != 3) goto L74;
        TextView r15 = this.h;
        if (r15 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("followText");
    L13:
        r15.setText(getFollowBackString());
        ConstraintLayout r16 = this.f;
        if (r16 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("followLayout");
    L16:
        UtilityKotlinExtentionsKt.w(r16);
        ConstraintLayout r17 = this.f;
        if (r17 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("followLayout");
    L19:
        r17.setAlpha(1.0f);
        LinearLayout r18 = this.i;
        if (r18 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("followedLayout");
    L22:
        UtilityKotlinExtentionsKt.u(r18);
        LinearLayout r19 = this.m;
        if (r19 == null) goto L25;
        UtilityKotlinExtentionsKt.u(r19);
    L25:
        setTalkback(getFollowBackString());
        return;
    L74:
        return;
    L26:
        if (r8 != 2) goto L28;
        String r0 = getFollowEachString();
    L29:
        TextView r4 = this.k;
        if (r4 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("followedText");
    L32:
        r4.setText(r0);
        LinearLayout r5 = this.i;
        if (r5 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("followedLayout");
    L35:
        UtilityKotlinExtentionsKt.w(r5);
        LinearLayout r6 = this.i;
        if (r6 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("followedLayout");
    L38:
        r6.setAlpha(1.0f);
        ImageView r1 = this.j;
        if (r1 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("followedEachIcon");
    L41:
        UtilityKotlinExtentionsKt.w(r1);
        r1.setBackground(null);
        if (r8 != 2) goto L44;
        int r20 = 2131252665;
    L45:
        r1.setImageResource(r20);
        ConstraintLayout r22 = this.f;
        if (r22 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException("followLayout");
    L48:
        UtilityKotlinExtentionsKt.u(r22);
        LinearLayout r23 = this.m;
        if (r23 == null) goto L51;
        UtilityKotlinExtentionsKt.w(r23);
    L51:
        LinearLayout r24 = this.m;
        if (r24 == null) goto L54;
        r24.setAlpha(0.0f);
    L54:
        setTalkback(r0);
        return;
    L44:
        r20 = 2131252666;
        goto L45
    L28:
        r0 = getFollowedWithFansGroupString();
        goto L29
    }

    public final void setFansGroupEnhance(boolean r3) {
        this.u = r3;
        if (r3 == false) goto L8;
        ImageView r4 = this.j;
        if (r4 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("followedEachIcon");
    L7:
        com.bytedance.android.live.core.utils.a1.p(r4, UtilityKotlinExtentionsKt.i(24));
        com.bytedance.android.live.core.utils.a1.k(r4, UtilityKotlinExtentionsKt.i(24));
        com.bytedance.android.live.core.utils.a1.n(r4, UtilityKotlinExtentionsKt.i(4));
        return;
    L8:
        ImageView r5 = this.j;
        if (r5 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("followedEachIcon");
    L11:
        com.bytedance.android.live.core.utils.a1.p(r5, UtilityKotlinExtentionsKt.i(16));
        com.bytedance.android.live.core.utils.a1.k(r5, UtilityKotlinExtentionsKt.i(16));
        com.bytedance.android.live.core.utils.a1.n(r5, UtilityKotlinExtentionsKt.i(0));
    }

    public final void setFansGroupTextOpt(boolean r4) {
        if (r4 == false) goto L19;
        LinearLayout r5 = this.m;
        if (r5 == null) goto L9;
        ImageView r6 = (ImageView) r5.findViewById(2131380764);
        if (r6 == null) goto L9;
        UtilityKotlinExtentionsKt.t(r6);
    L9:
        LinearLayout r7 = this.m;
        if (r7 == null) goto L14;
        TextView r8 = (TextView) r7.findViewById(2131380766);
        if (r8 == null) goto L14;
        UtilityKotlinExtentionsKt.t(r8);
    L14:
        LinearLayout r9 = this.m;
        if (r9 == null) goto L35;
        TextView r10 = (TextView) r9.findViewById(2131380767);
        if (r10 == null) goto L36;
        UtilityKotlinExtentionsKt.w(r10);
        return;
    L36:
        return;
    L35:
        return;
    L19:
        LinearLayout r12 = this.m;
        if (r12 == null) goto L24;
        ImageView r13 = (ImageView) r12.findViewById(2131380764);
        if (r13 == null) goto L24;
        UtilityKotlinExtentionsKt.w(r13);
    L24:
        LinearLayout r14 = this.m;
        if (r14 == null) goto L29;
        TextView r15 = (TextView) r14.findViewById(2131380766);
        if (r15 == null) goto L29;
        UtilityKotlinExtentionsKt.w(r15);
    L29:
        LinearLayout r16 = this.m;
        if (r16 == null) goto L38;
        TextView r17 = (TextView) r16.findViewById(2131380767);
        if (r17 == null) goto L39;
        UtilityKotlinExtentionsKt.t(r17);
        return;
    L39:
        return;
    }

    public static final /* synthetic */ void k(ProfileFollowButtonView r0, int r1) {
        r0.setFollowStatus(r1);
    }

    @Override // com.bytedance.android.live.profile.ui.component.view.ProfileButtonView
    public final void b(st0.b r3, NewProfileUser r4) {
        Intrinsics.checkNotNullParameter(r3, Constants.Keys.DATA);
        Intrinsics.checkNotNullParameter(r4, "user");
        if (((Boolean) i.a.getValue()).booleanValue() == false) goto L5;
        int r5 = com.bytedance.android.live.room.api.follow.b.a;
        com.bytedance.android.live.room.api.follow.b.a(r4, new ProfileFollowButtonView$initData$1(this));
    L10:
        setFollowBackground(r4);
        return;
    L5:
        c0 r6 = r4.followInfo;
        if (r6 == null) goto L8;
        int r7 = (int) r6.getFollowStatus();
    L9:
        setFollowStatus(r7);
        goto L10
    L8:
        r7 = 0;
        goto L9
    }

    @Override // com.bytedance.android.live.profile.ui.component.view.ProfileButtonView, com.bytedance.android.live.profile.ui.component.base.e
    public final /* bridge */ /* synthetic */ void c(st0.b r1, NewProfileUser r2) {
        b(r1, r2);
    }

    @Override // com.bytedance.android.live.profile.ui.component.view.ProfileButtonView, com.bytedance.android.live.profile.ui.component.base.e
    public final /* bridge */ /* synthetic */ void d(st0.b r1, ProfileSkin r2) {
        g(r1, r2);
    }

    @Override // com.bytedance.android.live.profile.ui.component.view.ProfileButtonView
    public final void g(st0.b r4, ProfileSkin r5) {
        Intrinsics.checkNotNullParameter(r4, Constants.Keys.DATA);
        Intrinsics.checkNotNullParameter(r5, "skin");
        ProfileCustomSkin r6 = r5.skin;
        if (r6 == null) goto L19;
        ProfileCustomSkin.SecondaryButtonUI r7 = r6.secondaryButtonSkin;
        if (r7 == null) goto L20;
        String r8 = r7.iconColor;
        String r0 = r7.borderColor;
        String r9 = r7.backgroundColor;
        int r1 = m.a;
        LinearLayout r2 = this.i;
        if (r2 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("followedLayout");
    L9:
        m.f(r2, r9);
        LinearLayout r3 = this.i;
        if (r3 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("followedLayout");
    L12:
        m.c(r3, r0);
        LinearLayout r10 = this.i;
        if (r10 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("followedLayout");
    L15:
        m.e(r10, r8);
        LinearLayout r12 = this.m;
        if (r12 == null) goto L21;
        m.f(r12, r9);
        m.c(r12, r0);
        m.e(r12, r8);
        return;
    L21:
        return;
    L20:
        return;
    }

    @Override // com.bytedance.android.live.profile.ui.component.view.ProfileButtonView
    /* JADX INFO: renamed from: update, reason: avoid collision after fix types in other method */
    public void update2(st0.b r5, NewProfileUser r6) {
        Intrinsics.checkNotNullParameter(r5, Constants.Keys.DATA);
        Intrinsics.checkNotNullParameter(r6, "user");
        LinearLayout r0 = this.i;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("followedLayout");
    L5:
        r0.setBackgroundResource(2131249762);
        ImageView r1 = this.j;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("followedEachIcon");
    L8:
        r1.clearColorFilter();
        TextView r2 = this.k;
        if (r2 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("followedText");
    L11:
        r2.setTextColor(s1.h(2131107936));
        LinearLayout r3 = this.m;
        if (r3 == null) goto L14;
        r3.setBackgroundResource(2131249762);
    L14:
        LinearLayout r4 = this.m;
        if (r4 == null) goto L19;
        ImageView r7 = (ImageView) r4.findViewById(2131380764);
        if (r7 == null) goto L19;
        r7.clearColorFilter();
    L19:
        LinearLayout r8 = this.m;
        if (r8 == null) goto L24;
        TextView r9 = (TextView) r8.findViewById(2131380766);
        if (r9 == null) goto L24;
        r9.setTextColor(s1.h(2131107936));
    L24:
        LinearLayout r10 = this.m;
        if (r10 == null) goto L29;
        TextView r12 = (TextView) r10.findViewById(2131380767);
        if (r12 == null) goto L29;
        r12.setTextColor(s1.h(2131107936));
    L29:
        ConstraintLayout r13 = this.f;
        if (r13 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("followLayout");
    L32:
        r13.setBackgroundResource(2131249760);
        ViewGroup r14 = this.l;
        if (r14 == null) goto L35;
        r14.setVisibility(8);
    L35:
        HSImageView r15 = findViewById(2131380768);
        if (r15 == null) goto L38;
        m.b(r15);
        r15.setBackground(null);
    L38:
        n();
        b(r5, r6);
        ProfileSkin r16 = r6.mProfileSkin;
        if (r16 == null) goto L42;
        g(r5, r16);
        return;
    }

    @Override // com.bytedance.android.live.profile.ui.component.view.ProfileButtonView, com.bytedance.android.live.profile.ui.component.base.e
    public /* bridge */ /* synthetic */ void update(st0.b r1, NewProfileUser r2) {
        update2(r1, r2);
    }

    public ProfileFollowButtonView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.n = LazyKt.lazy(ProfileFollowButtonView$followString$2.INSTANCE);
        this.o = LazyKt.lazy(ProfileFollowButtonView$followedString$2.INSTANCE);
        this.p = LazyKt.lazy(ProfileFollowButtonView$followedWithFansGroupString$2.INSTANCE);
        this.q = LazyKt.lazy(ProfileFollowButtonView$fansGroupString$2.INSTANCE);
        this.r = LazyKt.lazy(ProfileFollowButtonView$followBackString$2.INSTANCE);
        this.s = LazyKt.lazy(ProfileFollowButtonView$followEachString$2.INSTANCE);
        this.t = 2131251363;
    }

    public /* synthetic */ ProfileFollowButtonView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
