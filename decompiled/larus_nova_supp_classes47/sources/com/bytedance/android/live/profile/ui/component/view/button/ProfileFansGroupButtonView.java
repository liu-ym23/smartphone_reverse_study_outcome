package com.bytedance.android.live.profile.ui.component.view.button;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.base.model.user.ProfileSkin;
import com.bytedance.android.live.base.model.user.c0;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.profile.ui.component.view.ProfileButtonView;
import com.bytedance.android.live.service.preinflate.ProfilePreInflateUtil;
import com.bytedance.android.live.service.preinflate.ProfilePreInflateViewInfo;
import com.bytedance.badger.collect.impl.constants.Constants;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u0012\b\b\u0002\u0010 \u001a\u00020\u0006¢\u0006\u0004\b!\u0010\"J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rJ\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000e0\rJ\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\rR\"\u0010\u0015\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u001a\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0014\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018¨\u0006#"}, d2 = {"Lcom/bytedance/android/live/profile/ui/component/view/button/ProfileFansGroupButtonView;", "Lcom/bytedance/android/live/profile/ui/component/view/ProfileButtonView;", "", "str", "", "setTalkback", "", "getButtonWidth", "Lst0/b;", Constants.Keys.DATA, "Lcom/bytedance/android/live/base/model/user/NewProfileUser;", "user", "update", "", "Landroid/animation/Animator;", "getSecondFollowAnimatotsWithFansGroup", "getFollowAnimatorSet", "getCancelFollowAnimatorSet", "", "i", "Z", "isFansGroupEnhance", "()Z", "setFansGroupEnhance", "(Z)V", "j", "isFansGroupTextOpt", "setFansGroupTextOpt", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class ProfileFansGroupButtonView extends ProfileButtonView {
    public ImageView f;
    public TextView g;
    public TextView h;
    public boolean i;
    public boolean j;

    public static final class a implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ ProfileFansGroupButtonView a;

        public a(ProfileFansGroupButtonView r1) {
            this.a = r1;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r4) {
            Intrinsics.checkNotNullParameter(r4, "it");
            Object r5 = r4.getAnimatedValue();
            ViewGroup.LayoutParams r1 = null;
            if ((r5 instanceof Integer) == true) goto L5;
            r5 = null;
        L5:
            Integer r6 = (Integer) r5;
            if (r6 == null) goto L15;
            int r7 = r6.intValue();
            ViewGroup.LayoutParams r0 = this.a.getLayoutParams();
            if ((r0 instanceof ViewGroup.MarginLayoutParams) == false) goto L11;
            r1 = r0;
        L11:
            ViewGroup.MarginLayoutParams r2 = (ViewGroup.MarginLayoutParams) r1;
            if (r2 == null) goto L16;
            r2.leftMargin = r7;
            this.a.setLayoutParams(r2);
            return;
        L16:
            return;
        }
    }

    public static final class b extends AnimatorListenerAdapter {
        public final /* synthetic */ ProfileFansGroupButtonView a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ int c;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r3) {
            Intrinsics.checkNotNullParameter(r3, "animation");
            super.onAnimationEnd(r3);
            this.a.l(this.b, this.c);
            ViewGroup.LayoutParams r4 = this.a.getLayoutParams();
            if ((r4 instanceof ViewGroup.MarginLayoutParams) == true) goto L5;
            r4 = null;
        L5:
            ViewGroup.MarginLayoutParams r5 = (ViewGroup.MarginLayoutParams) r4;
            if (r5 == null) goto L9;
            r5.leftMargin = -UtilityKotlinExtentionsKt.i(36);
            this.a.setLayoutParams(r5);
            return;
        }

        public b(ProfileFansGroupButtonView r1, boolean r2, int r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class c implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ ProfileFansGroupButtonView a;

        public c(ProfileFansGroupButtonView r1) {
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
            if (r4 == null) goto L9;
            float r5 = r4.floatValue();
            this.a.setAlpha(r5);
            return;
        }
    }

    public static final class d implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ ProfileFansGroupButtonView a;

        public d(ProfileFansGroupButtonView r1) {
            this.a = r1;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r4) {
            Intrinsics.checkNotNullParameter(r4, "it");
            Object r5 = r4.getAnimatedValue();
            ViewGroup.LayoutParams r1 = null;
            if ((r5 instanceof Integer) == true) goto L5;
            r5 = null;
        L5:
            Integer r6 = (Integer) r5;
            if (r6 == null) goto L15;
            int r7 = r6.intValue();
            ViewGroup.LayoutParams r0 = this.a.getLayoutParams();
            if ((r0 instanceof ViewGroup.MarginLayoutParams) == false) goto L11;
            r1 = r0;
        L11:
            ViewGroup.MarginLayoutParams r2 = (ViewGroup.MarginLayoutParams) r1;
            if (r2 == null) goto L16;
            r2.leftMargin = r7;
            this.a.setLayoutParams(r2);
            return;
        L16:
            return;
        }
    }

    public static final class e implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ ProfileFansGroupButtonView a;

        public e(ProfileFansGroupButtonView r1) {
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
            if (r4 == null) goto L9;
            float r5 = r4.floatValue();
            this.a.setAlpha(r5);
            return;
        }
    }

    public ProfileFansGroupButtonView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ProfileFansGroupButtonView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final List<Animator> getSecondFollowAnimatotsWithFansGroup() {
        ValueAnimator r1 = ValueAnimator.ofInt(new int[]{UtilityKotlinExtentionsKt.i(-36), UtilityKotlinExtentionsKt.i(6)});
        r1.addUpdateListener(new d(this));
        r1.setDuration(500);
        ValueAnimator r2 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r2.addUpdateListener(new e(this));
        r2.setDuration(500);
        return CollectionsKt.listOf(new ValueAnimator[]{r1, r2});
    }

    @Override // com.bytedance.android.live.profile.ui.component.view.ProfileButtonView
    public final void i(st0.b r2) {
        Intrinsics.checkNotNullParameter(r2, Constants.Keys.DATA);
    }

    public final List<Animator> getCancelFollowAnimatorSet() {
        TextView r0 = this.g;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("fansText");
    L6:
        return CollectionsKt.listOf(ObjectAnimator.ofFloat(r0, "alpha", new float[]{1.0f, 0.0f}).setDuration(150));
    }

    public final List<Animator> getFollowAnimatorSet() {
        TextView r0 = this.g;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("fansText");
    L6:
        return CollectionsKt.listOf(ObjectAnimator.ofFloat(r0, "alpha", new float[]{0.0f, 1.0f}).setDuration(150));
    }

    private final int getButtonWidth() {
        ViewGroup.LayoutParams r0 = getLayoutParams();
        if ((r0 instanceof LinearLayout.LayoutParams) == true) goto L5;
        r0 = null;
    L5:
        LinearLayout.LayoutParams r1 = (LinearLayout.LayoutParams) r0;
        if (r1 == null) goto L8;
        int r2 = (int) UtilityKotlinExtentionsKt.j(r1.width);
    L9:
        if (r2 > 0) goto L12;
        return 36;
    L12:
        return r2;
    L8:
        r2 = 36;
        goto L9
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
        ProfilePreInflateUtil.c(ProfilePreInflateViewInfo.TTLIVE_PROFILE_FANS_GROUP_BUTTON, r4, LayoutInflater.from(r4), this, true);
    L6:
        setContentView((ViewGroup) findViewById(2131380808));
        this.f = (ImageView) findViewById(2131380809);
        this.g = (TextView) findViewById(2131380810);
        this.h = (TextView) findViewById(2131380811);
        return;
    L5:
        LayoutInflater.from(r4).inflate(2131567201, this, true);
        goto L6
    }

    public final List<Animator> k(int r9) {
        if (r9 == 2) goto L7;
        if (r9 == 1) goto L7;
        boolean r3 = false;
    L8:
        ValueAnimator r4 = ValueAnimator.ofInt(new int[]{UtilityKotlinExtentionsKt.i(6), -UtilityKotlinExtentionsKt.i(getButtonWidth())});
        r4.addUpdateListener(new a(this));
        r4.setDuration(500);
        r4.addListener(new b(this, r3, r9));
        ValueAnimator r10 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        r10.addUpdateListener(new c(this));
        r10.setDuration(500);
        return CollectionsKt.listOf(new ValueAnimator[]{r4, r10});
    L7:
        r3 = true;
        goto L8
    }

    public final void setFansGroupEnhance(boolean r1) {
        this.i = r1;
    }

    public final void setFansGroupTextOpt(boolean r1) {
        this.j = r1;
    }

    @Override // com.bytedance.android.live.profile.ui.component.view.ProfileButtonView
    public final void b(st0.b r3, NewProfileUser r4) {
        Intrinsics.checkNotNullParameter(r3, Constants.Keys.DATA);
        Intrinsics.checkNotNullParameter(r4, "user");
        boolean r5 = r4.isFollowing();
        c0 r6 = r4.followInfo;
        if (r6 == null) goto L5;
        int r7 = (int) r6.getFollowStatus();
    L6:
        l(r5, r7);
        return;
    L5:
        r7 = 0;
        goto L6
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
    public final void g(st0.b r2, ProfileSkin r3) {
        Intrinsics.checkNotNullParameter(r2, Constants.Keys.DATA);
        Intrinsics.checkNotNullParameter(r3, "skin");
        super.g(r2, r3);
    }

    public final void l(boolean r9, int r10) {
        ViewGroup.LayoutParams r5 = null;
        if (this.i == false) goto L37;
        if (r9 == false) goto L37;
        ViewGroup.LayoutParams r12 = getLayoutParams();
        if ((r12 instanceof LinearLayout.LayoutParams) == false) goto L9;
        r5 = r12;
    L9:
        LinearLayout.LayoutParams r6 = (LinearLayout.LayoutParams) r5;
        if (r6 == null) goto L12;
        r6.weight = 0.0f;
        r6.width = UtilityKotlinExtentionsKt.i(36);
        setLayoutParams(r6);
    L12:
        TextView r13 = this.g;
        if (r13 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("fansText");
    L15:
        UtilityKotlinExtentionsKt.t(r13);
        TextView r14 = this.g;
        if (r14 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("fansText");
    L18:
        r14.setAlpha(0.0f);
        TextView r15 = this.h;
        if (r15 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("fansTextV2");
    L21:
        UtilityKotlinExtentionsKt.t(r15);
        TextView r16 = this.h;
        if (r16 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("fansTextV2");
    L24:
        r16.setAlpha(0.0f);
        ImageView r17 = this.f;
        if (r17 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("fansIcon");
    L27:
        UtilityKotlinExtentionsKt.w(r17);
        ImageView r18 = this.f;
        if (r18 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("fansIcon");
    L31:
        if (r10 != 2) goto L33;
        int r19 = 2131252665;
    L34:
        r18.setImageResource(r19);
        setTalkback(s1.B(2131919557));
        return;
    L33:
        r19 = 2131252666;
    L37:
        if (this.j == false) goto L88;
        if (r9 == false) goto L62;
        ViewGroup.LayoutParams r20 = getLayoutParams();
        if ((r20 instanceof LinearLayout.LayoutParams) == false) goto L43;
        r5 = r20;
    L43:
        LinearLayout.LayoutParams r7 = (LinearLayout.LayoutParams) r5;
        if (r7 == null) goto L46;
        r7.weight = 1.0f;
        r7.width = 0;
        setLayoutParams(r7);
    L46:
        TextView r22 = this.h;
        if (r22 != null) goto L49;
        Intrinsics.throwUninitializedPropertyAccessException("fansTextV2");
    L49:
        UtilityKotlinExtentionsKt.w(r22);
        TextView r23 = this.h;
        if (r23 != null) goto L52;
        Intrinsics.throwUninitializedPropertyAccessException("fansTextV2");
    L52:
        r23.setAlpha(1.0f);
        TextView r24 = this.g;
        if (r24 != null) goto L55;
        Intrinsics.throwUninitializedPropertyAccessException("fansText");
    L55:
        UtilityKotlinExtentionsKt.t(r24);
        TextView r25 = this.g;
        if (r25 != null) goto L58;
        Intrinsics.throwUninitializedPropertyAccessException("fansText");
    L58:
        r25.setAlpha(0.0f);
        ImageView r26 = this.f;
        if (r26 != null) goto L61;
        Intrinsics.throwUninitializedPropertyAccessException("fansIcon");
    L61:
        UtilityKotlinExtentionsKt.t(r26);
    L85:
        setTalkback(s1.B(2131919552));
        return;
    L62:
        ViewGroup.LayoutParams r27 = getLayoutParams();
        if ((r27 instanceof LinearLayout.LayoutParams) == false) goto L66;
        r5 = r27;
    L66:
        LinearLayout.LayoutParams r8 = (LinearLayout.LayoutParams) r5;
        if (r8 == null) goto L69;
        r8.weight = 0.0f;
        r8.width = UtilityKotlinExtentionsKt.i(54);
        setLayoutParams(r8);
    L69:
        TextView r28 = this.h;
        if (r28 != null) goto L72;
        Intrinsics.throwUninitializedPropertyAccessException("fansTextV2");
    L72:
        UtilityKotlinExtentionsKt.w(r28);
        TextView r29 = this.h;
        if (r29 != null) goto L75;
        Intrinsics.throwUninitializedPropertyAccessException("fansTextV2");
    L75:
        r29.setAlpha(1.0f);
        TextView r30 = this.g;
        if (r30 != null) goto L78;
        Intrinsics.throwUninitializedPropertyAccessException("fansText");
    L78:
        UtilityKotlinExtentionsKt.t(r30);
        TextView r32 = this.g;
        if (r32 != null) goto L81;
        Intrinsics.throwUninitializedPropertyAccessException("fansText");
    L81:
        r32.setAlpha(0.0f);
        ImageView r33 = this.f;
        if (r33 != null) goto L84;
        Intrinsics.throwUninitializedPropertyAccessException("fansIcon");
    L84:
        UtilityKotlinExtentionsKt.t(r33);
        goto L85
    L88:
        if (r9 == false) goto L115;
        ViewGroup.LayoutParams r34 = getLayoutParams();
        if ((r34 instanceof LinearLayout.LayoutParams) == false) goto L93;
        r5 = r34;
    L93:
        LinearLayout.LayoutParams r35 = (LinearLayout.LayoutParams) r5;
        if (r35 == null) goto L96;
        r35.weight = 1.0f;
        r35.width = 0;
        setLayoutParams(r35);
    L96:
        TextView r36 = this.g;
        if (r36 != null) goto L99;
        Intrinsics.throwUninitializedPropertyAccessException("fansText");
    L99:
        UtilityKotlinExtentionsKt.w(r36);
        TextView r37 = this.g;
        if (r37 != null) goto L102;
        Intrinsics.throwUninitializedPropertyAccessException("fansText");
    L102:
        r37.setAlpha(1.0f);
        TextView r38 = this.h;
        if (r38 != null) goto L105;
        Intrinsics.throwUninitializedPropertyAccessException("fansTextV2");
    L105:
        UtilityKotlinExtentionsKt.t(r38);
        TextView r39 = this.h;
        if (r39 != null) goto L108;
        Intrinsics.throwUninitializedPropertyAccessException("fansTextV2");
    L108:
        r39.setAlpha(0.0f);
        ImageView r40 = this.f;
        if (r40 != null) goto L111;
        Intrinsics.throwUninitializedPropertyAccessException("fansIcon");
    L111:
        UtilityKotlinExtentionsKt.w(r40);
        ImageView r42 = this.f;
        if (r42 != null) goto L114;
        Intrinsics.throwUninitializedPropertyAccessException("fansIcon");
    L114:
        r42.setImageResource(2131252664);
        return;
    L115:
        ViewGroup.LayoutParams r43 = getLayoutParams();
        if ((r43 instanceof LinearLayout.LayoutParams) == false) goto L119;
        r5 = r43;
    L119:
        LinearLayout.LayoutParams r44 = (LinearLayout.LayoutParams) r5;
        if (r44 == null) goto L122;
        r44.weight = 0.0f;
        r44.width = UtilityKotlinExtentionsKt.i(36);
        setLayoutParams(r44);
    L122:
        TextView r45 = this.g;
        if (r45 != null) goto L125;
        Intrinsics.throwUninitializedPropertyAccessException("fansText");
    L125:
        UtilityKotlinExtentionsKt.t(r45);
        TextView r46 = this.g;
        if (r46 != null) goto L128;
        Intrinsics.throwUninitializedPropertyAccessException("fansText");
    L128:
        r46.setAlpha(0.0f);
        TextView r47 = this.h;
        if (r47 != null) goto L131;
        Intrinsics.throwUninitializedPropertyAccessException("fansTextV2");
    L131:
        UtilityKotlinExtentionsKt.t(r47);
        TextView r48 = this.h;
        if (r48 != null) goto L134;
        Intrinsics.throwUninitializedPropertyAccessException("fansTextV2");
    L134:
        r48.setAlpha(0.0f);
        ImageView r49 = this.f;
        if (r49 != null) goto L137;
        Intrinsics.throwUninitializedPropertyAccessException("fansIcon");
    L137:
        UtilityKotlinExtentionsKt.w(r49);
        ImageView r50 = this.f;
        if (r50 != null) goto L140;
        Intrinsics.throwUninitializedPropertyAccessException("fansIcon");
    L140:
        r50.setImageResource(2131252664);
    }

    @Override // com.bytedance.android.live.profile.ui.component.view.ProfileButtonView
    /* JADX INFO: renamed from: update, reason: avoid collision after fix types in other method */
    public void update2(st0.b r4, NewProfileUser r5) {
        Intrinsics.checkNotNullParameter(r4, Constants.Keys.DATA);
        Intrinsics.checkNotNullParameter(r5, "user");
        getContentView().setBackgroundResource(2131249762);
        ImageView r0 = this.f;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("fansIcon");
    L5:
        r0.clearColorFilter();
        ImageView r1 = this.f;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("fansIcon");
    L8:
        r1.setImageResource(2131251274);
        TextView r2 = this.g;
        if (r2 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("fansText");
    L11:
        r2.setTextColor(s1.h(2131107936));
        TextView r3 = this.h;
        if (r3 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("fansTextV2");
    L14:
        r3.setTextColor(s1.h(2131107936));
        b(r4, r5);
        ProfileSkin r6 = r5.mProfileSkin;
        if (r6 == null) goto L18;
        g(r4, r6);
        return;
    }

    @Override // com.bytedance.android.live.profile.ui.component.view.ProfileButtonView, com.bytedance.android.live.profile.ui.component.base.e
    public /* bridge */ /* synthetic */ void update(st0.b r1, NewProfileUser r2) {
        update2(r1, r2);
    }

    public ProfileFansGroupButtonView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }

    public /* synthetic */ ProfileFansGroupButtonView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
