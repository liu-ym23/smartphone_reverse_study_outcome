package com.bytedance.android.live.profile.ui.component;

import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.base.model.user.ProfileCustomSkin;
import com.bytedance.android.live.base.model.user.ProfileSkin;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.profile.NewProfileInfoViewModel;
import com.bytedance.android.live.profile.p000enum.DressClickArea;
import com.bytedance.android.live.profile.ui.base.ComponentType;
import com.bytedance.android.live.profile.ui.util.DressType;
import com.bytedance.android.live.uikit.util.RTLUtil;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import io.reactivex.Observable;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import rs0.b0;
import rs0.t0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class ProfileSkinCustomComponent implements com.bytedance.android.live.profile.ui.base.g {
    public static final /* synthetic */ int d = 0;
    public final Lazy a;
    public final b b;
    public final com.bytedance.android.live.profile.ui.base.l c;

    public static final class a {
    }

    public static final class b implements View.OnTouchListener {
        public final /* synthetic */ ProfileSkinCustomComponent a;

        public b(ProfileSkinCustomComponent r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r3, MotionEvent r4) {
            if (r4.getAction() != 1) goto L12;
            if ((r3.getX() + (r3.getMeasuredWidth() / 2)) <= r4.getX()) goto L7;
            boolean r5 = true;
        L8:
            if (r5 == false) goto L10;
            this.a.c.a().onDressClick(DressClickArea.BorderLeft);
            goto L12
        L10:
            this.a.c.a().onDressClick(DressClickArea.BorderRight);
            goto L12
        L7:
            r5 = false;
        L12:
            return !((com.bytedance.android.live.profile.ui.base.h) this.a.a.getValue()).isMyLive();
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public final void b(com.bytedance.android.live.profile.ui.base.d r1) {
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public final void f() {
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public final void g(NewProfileUser r2) {
        Intrinsics.checkNotNullParameter(r2, "user");
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public final void onComponentDestroy() {
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public final ComponentType getComponentType() {
        return ComponentType.SkinCustom.INSTANCE;
    }

    public ProfileSkinCustomComponent(com.bytedance.android.live.profile.ui.base.l r2) {
        Intrinsics.checkNotNullParameter(r2, "hostBehavior");
        this.c = r2;
        this.a = LazyKt.lazy(new ProfileSkinCustomComponent$profileContext$2(this));
        this.b = new b(this);
    }

    public static AbstractDraweeController h(py.k r2) {
        if (UtilityKotlinExtentionsKt.n(r2) == false) goto L7;
        return null;
    L7:
        return Fresco.newDraweeControllerBuilder().setFirstAvailableImageRequests(a1.b(r2, -1)).setAutoPlayAnimations(true).build();
    }

    public final <T extends View> T c(int r2) {
        View r0 = this.c.getHostFragment().getView();
        if (r0 != null) goto L7;
        return null;
    L7:
        return (T) r0.findViewById(r2);
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public final void d(NewProfileUser r2) {
        Intrinsics.checkNotNullParameter(r2, "user");
        Intrinsics.checkNotNullParameter(r2, "user");
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public final void e(ProfileSkin r2) {
        if ((r2 instanceof ProfileSkin) == false) goto L6;
        i(r2.skin);
        j(r2.skin);
        return;
    }

    public final void i(ProfileCustomSkin r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        com.bytedance.android.live.profit.dress.a r0 = (com.bytedance.android.live.profit.dress.a) yt0.c.a().getDressData(r10.avatarBorderDressId, 1, "ProfileSkinCustomComponent: parseCustomSkin");
        if (r0 == null) goto L8;
        py.k r1 = r0.a;
        if (r1 == null) goto L8;
    L9:
        py.k r2 = r1;
        if (r2 == null) goto L20;
        View r12 = this.c.getHostFragment().getView();
        if (r12 == null) goto L21;
        HSImageView r3 = r12.findViewById(2131380738);
        if (r3 != null) goto L16;
        return;
    L16:
        if (((Boolean) t0.a.getValue()).booleanValue() == false) goto L18;
        ViewGroup.LayoutParams r13 = r3.getLayoutParams();
        r13.width = s1.f(94.0f);
        r13.height = s1.f(94.0f);
        r3.requestLayout();
    L18:
        ImageLoader.bindImage(r3, r2, null, -1, -1, null, null, true);
        return;
    L21:
        return;
    L20:
        return;
    L8:
        r1 = r10.avatarBorder;
        goto L9
    }

    public final void j(ProfileCustomSkin r18) {
        if (r18 != null) goto L5;
        return;
    L5:
        com.bytedance.android.live.profile.profilecontext.a r3 = this.c.b();
        if (r3 != null) goto L8;
        return;
    L8:
        ProfileCustomSkin.BgUI r0 = r18.bgSkin;
        if (r0 == null) goto L17;
        String r1 = r0.dividerColor;
        if (r1 == null) goto L17;
        View r4 = this.c.getHostFragment().getView();
        if (r4 == null) goto L17;
        View r5 = r4.findViewById(2131380861);
        if (r5 == null) goto L17;
        com.bytedance.android.live.profile.ui.util.m.f(r5, r1);
    L17:
        py.k r2 = r3.getDressImageModelWithFallback(DressType.PanelBgPng);
        if (r2 != null) goto L20;
    L28:
        ProfileCustomSkin.BgUI r6 = r18.bgSkin;
        if (r6 == null) goto L50;
        ProfileCustomSkin.GradientColor r7 = r6.bgColor;
        if (r7 == null) goto L50;
        View r8 = this.c.getHostFragment().getView();
        if (r8 == null) goto L50;
        View r9 = r8.findViewById(2131380783);
        if (r9 == null) goto L50;
        if (this.c.isVertical() == false) goto L39;
        float r10 = 8;
        float[] r12 = {UtilityKotlinExtentionsKt.h(r10), UtilityKotlinExtentionsKt.h(r10), UtilityKotlinExtentionsKt.h(r10), UtilityKotlinExtentionsKt.h(r10), 0.0f, 0.0f, 0.0f, 0.0f};
    L40:
        int r13 = com.bytedance.android.live.profile.ui.util.m.a;
        GradientDrawable.Orientation r14 = GradientDrawable.Orientation.TOP_BOTTOM;
        Intrinsics.checkNotNullParameter(r9, "view");
        Intrinsics.checkNotNullParameter(r7, "color");
        Intrinsics.checkNotNullParameter(r12, "cornerRadii");
        Intrinsics.checkNotNullParameter(r14, "orientation");
    L48:
        e = move-exception;
        ALogger.e("PaintedSkinHelper", "paintViewDrawableGradientColor error: " + e.getMessage());
        goto L50
    L42:
        if (TextUtils.isEmpty(r7.from) == true) goto L50;
        if (TextUtils.isEmpty(r7.to) == true) goto L50;
        GradientDrawable r15 = new GradientDrawable(r14, new int[]{Color.parseColor(r7.from), Color.parseColor(r7.to)});     // Catch: Exception -> L48
        r15.mutate();     // Catch: Exception -> L48
        r15.setCornerRadii(r12);     // Catch: Exception -> L48
        r15.setGradientType(0);     // Catch: Exception -> L48
        r9.setBackgroundDrawable(r15);     // Catch: Exception -> L48
        goto L50
    L39:
        float r16 = 8;
        r12 = new float[]{UtilityKotlinExtentionsKt.h(r16), UtilityKotlinExtentionsKt.h(r16), UtilityKotlinExtentionsKt.h(r16), UtilityKotlinExtentionsKt.h(r16), UtilityKotlinExtentionsKt.h(r16), UtilityKotlinExtentionsKt.h(r16), UtilityKotlinExtentionsKt.h(r16), UtilityKotlinExtentionsKt.h(r16)};
    L50:
        py.k r17 = r3.getDressImageModelWithFallback(DressType.BorderPng);
        if (r17 != null) goto L53;
        py.k r19 = r3.getDressImageModelWithFallback(DressType.Border9Png);
        if (r19 != null) goto L67;
    L93:
        ProfileCustomSkin.BgUI r20 = r18.bgSkin;
        if (r20 == null) goto L110;
        ProfileCustomSkin.ExtendTopBorder r22 = r20.extendTopBorder;
        if (r22 == null) goto L111;
        int r23 = com.bytedance.android.live.profile.ui.util.t.a;     // Catch: Exception -> L103
        if (((ss0.a) b0.a.getValue()).d() == true) goto L100;
        return;
    L100:
        if (com.bytedance.android.live.profile.ui.util.n.b(r3) == true) goto L113;
        a(r22, r3);     // Catch: Exception -> L103
        return;
    L113:
        return;
    L103:
        e = move-exception;
        ALogger.e("ProfileSkinCustomComponent", "error: " + e.getMessage());
        return;
    L111:
        return;
    L110:
        return;
    L67:
        if (((com.bytedance.android.live.profile.ui.base.h) this.a.getValue()).isMyLive() == false) goto L69;
        int r24 = 2131380858;
    L70:
        View r25 = this.c.getHostFragment().getView();
        if (r25 == null) goto L73;
        View r26 = r25.findViewById(r24);
    L74:
        if (r26 == null) goto L92;
        r26.setOnTouchListener(this.b);
        if ((s1.u() - 3.0f) <= 0.01f) goto L78;
        float r27 = (s1.u() - 3.0f) * 22;
        r26.setTranslationY(r27);
        ALogger.i(NewProfileInfoViewModel.TAG, "density= " + s1.u() + " transY= " + r27);
    L78:
        a1.d(r19, RTLUtil.isAppRTL(s1.getContext()), new x(r26));
        int r28 = com.bytedance.android.live.profile.ui.util.t.a;
        if (r26.getVisibility() != 0) goto L92;
        ViewGroup.LayoutParams r29 = r26.getLayoutParams();
        if ((r29 instanceof ConstraintLayout.LayoutParams) == true) goto L83;
        r29 = null;
    L83:
        ConstraintLayout.LayoutParams r30 = (ConstraintLayout.LayoutParams) r29;
        if ((r19 instanceof com.bytedance.android.live.base.model.f) == true) goto L86;
        r19 = null;
    L86:
        com.bytedance.android.live.base.model.f r32 = (com.bytedance.android.live.base.model.f) r19;
        if (r32 == null) goto L92;
        int r33 = (int) r32.flexImageTopBorderHeight();
        if (r30 == null) goto L91;
        ((ViewGroup.MarginLayoutParams) r30).height = s1.f(r33);
    L91:
        r26.setLayoutParams(r30);
    L92:
        Unit r34 = Unit.INSTANCE;
        goto L93
    L73:
        r26 = null;
        goto L74
    L69:
        r24 = 2131380855;
        goto L70
    L53:
        if (((com.bytedance.android.live.profile.ui.base.h) this.a.getValue()).isMyLive() == false) goto L55;
        int r35 = 2131380860;
    L56:
        HSImageView r36 = c(r35);
        if (r36 == null) goto L93;
        int r37 = r17.getWidth();
        int r38 = r17.getHeight();
        if (PadConfigUtils.c() == false) goto L62;
        int r39 = UtilityKotlinExtentionsKt.i(375);
    L63:
        com.bytedance.android.live.core.utils.a1.k(r36, (int) ((((double) r39) / ((double) r37)) * ((double) r38)));
        r36.setOnTouchListener(this.b);
        ImageLoader.bindImage(r36, r17);
        goto L93
    L62:
        r39 = s1.y();
        goto L63
    L55:
        r35 = 2131380859;
        goto L56
    L20:
        if (((com.bytedance.android.live.profile.ui.base.h) this.a.getValue()).isMyLive() == false) goto L25;
        HSImageView r40 = c(2131380782);
        if (r40 == null) goto L28;
        com.bytedance.android.live.core.utils.a1.k(r40, (int) ((((double) ((com.bytedance.android.live.profile.ui.base.h) this.a.getValue()).getProfileWidth(null)) / ((double) r2.getWidth())) * ((double) r2.getHeight())));
        ImageLoader.bindImage(r40, r2);
        goto L28
    L25:
        PointF r42 = new PointF(0.5f, 0.0f);
        HSImageView r43 = c(2131380781);
        if (r43 == null) goto L28;
        ImageLoader.bindImageWithFocusCrop(r43, r2, UtilityKotlinExtentionsKt.i(r2.getWidth()), UtilityKotlinExtentionsKt.i(r2.getHeight()), r42);
        goto L28
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public void update(NewProfileUser r5) {
        Intrinsics.checkNotNullParameter(r5, "newUser");
        ALogger.i("NewUserProfile_ProfilePre", "ProfileSkinCustomComponent update");
        com.bytedance.android.live.profile.profilecontext.a r0 = this.c.b();
        if (r0 != null) goto L5;
        return;
    L5:
        ProfileCustomSkin r3 = null;
        if (r0.getPreTargetUser() == null) goto L31;
        NewProfileUser r1 = r0.getPreTargetUser();
        if (r1 == null) goto L14;
        ProfileSkin r2 = r1.mProfileSkin;
        if (r2 == null) goto L14;
        ProfileCustomSkin r4 = r2.skin;
        if (r4 == null) goto L14;
        String r6 = r4.avatarBorderDressId;
    L15:
        ProfileSkin r7 = r5.mProfileSkin;
        if (r7 == null) goto L20;
        ProfileCustomSkin r8 = r7.skin;
        if (r8 == null) goto L20;
        String r9 = r8.avatarBorderDressId;
    L22:
        if ((!Intrinsics.areEqual(r6, r9)) == false) goto L31;
        HSImageView r10 = c(2131380738);
        if (r10 == null) goto L26;
        r10.setImageURI(null);
    L26:
        ProfileSkin r12 = r5.mProfileSkin;
        if (r12 == null) goto L29;
        ProfileCustomSkin r13 = r12.skin;
    L30:
        i(r13);
        goto L31
    L29:
        r13 = null;
    L20:
        r9 = null;
    L14:
        r6 = null;
    L31:
        com.bytedance.android.live.profile.profilecontext.a r14 = this.c.b();
        if (r14 != null) goto L34;
        return;
    L34:
        if (com.bytedance.android.live.profile.ui.base.i.g(r14) != true) goto L73;
        View r15 = this.c.getHostFragment().getView();
        if (r15 == null) goto L40;
        View r16 = r15.findViewById(2131380861);
        if (r16 == null) goto L40;
        com.bytedance.android.live.profile.ui.util.m.f(r16, "#0C161823");
    L40:
        HSImageView r17 = c(2131380781);
        if (r17 == null) goto L43;
        com.bytedance.android.live.profile.ui.util.m.b(r17);
    L43:
        HSImageView r18 = c(2131380782);
        if (r18 == null) goto L46;
        com.bytedance.android.live.profile.ui.util.m.b(r18);
        com.bytedance.android.live.core.utils.a1.k(r18, 0);
    L46:
        View r19 = c(2131380783);
        if (r19 == null) goto L49;
        r19.setBackground(null);
    L49:
        HSImageView r20 = c(2131380859);
        if (r20 == null) goto L52;
        com.bytedance.android.live.core.utils.a1.k(r20, 0);
        r20.setOnTouchListener(null);
        com.bytedance.android.live.profile.ui.util.m.b(r20);
    L52:
        View r22 = c(2131380855);
        if (r22 == null) goto L55;
        com.bytedance.android.live.core.utils.a1.k(r22, 0);
        r22.setOnTouchListener(null);
        r22.setBackground(null);
    L55:
        HSImageView r23 = c(2131380856);
        if (r23 == null) goto L58;
        com.bytedance.android.live.core.utils.a1.k(r23, 0);
        r23.setOnTouchListener(null);
        com.bytedance.android.live.profile.ui.util.m.b(r23);
    L58:
        HSImageView r24 = c(2131380860);
        if (r24 == null) goto L61;
        com.bytedance.android.live.core.utils.a1.k(r24, 0);
        r24.setOnTouchListener(null);
        com.bytedance.android.live.profile.ui.util.m.b(r24);
    L61:
        View r25 = c(2131380858);
        if (r25 == null) goto L64;
        com.bytedance.android.live.core.utils.a1.k(r25, 0);
        r25.setOnTouchListener(null);
        r25.setBackground(null);
    L64:
        HSImageView r26 = c(2131380857);
        if (r26 == null) goto L67;
        com.bytedance.android.live.core.utils.a1.k(r26, 0);
        r26.setOnTouchListener(null);
        com.bytedance.android.live.profile.ui.util.m.b(r26);
    L67:
        ProfileSkin r27 = r5.mProfileSkin;
        if (r27 == null) goto L70;
        r3 = r27.skin;
    L70:
        j(r3);
        return;
    }

    public final void a(ProfileCustomSkin.ExtendTopBorder r8, com.bytedance.android.live.profile.ui.base.h r9) {
        if (r9.isMyLive() == false) goto L5;
        int r0 = 2131380857;
    L6:
        View r1 = this.c.getHostFragment().getView();
        if (r1 == null) goto L31;
        HSImageView r2 = r1.findViewById(r0);
        if (r2 != null) goto L12;
        return;
    L12:
        if (r8.overlayPicType == ProfileCustomSkin.IMAGE_TYPE_WEBP) goto L14;
        return;
    L14:
        DressType r10 = DressType.BorderLoopWebp;
        py.k r3 = r9.getDressImageModelWithFallback(r10);
        int r4 = 0;
        if (r3 == null) goto L17;
        int r5 = r3.getWidth();
    L18:
        py.k r6 = r9.getDressImageModelWithFallback(r10);
        if (r6 == null) goto L21;
        r4 = r6.getHeight();
    L21:
        com.bytedance.android.live.core.utils.a1.k(r2, (int) ((((double) r9.getProfileWidth(Boolean.TRUE)) / ((double) r5)) * ((double) r4)));
        r2.setOnTouchListener(this.b);
        if (r9.getDressImageModelWithFallback(DressType.BorderEnterWebp) != null) goto L24;
    L27:
        AbstractDraweeController r12 = h(r9.getDressImageModelWithFallback(r10));
        if (r12 == null) goto L33;
        r2.setController(r12);
        return;
    L33:
        return;
    L24:
        if (com.bytedance.android.live.profile.ui.base.i.h(r9) == true) goto L27;
        ALogger.i("NewUserProfile_ProfilePre", "ProfileSkinCustomComponent call enterWaitForOrRunImmediately");
        com.bytedance.android.live.profile.ui.base.i.b(r9, Observable.create(new w(this, r9, r2)));
        return;
    L17:
        r5 = 0;
        goto L18
    L31:
        return;
    L5:
        r0 = 2131380856;
        goto L6
    }
}
