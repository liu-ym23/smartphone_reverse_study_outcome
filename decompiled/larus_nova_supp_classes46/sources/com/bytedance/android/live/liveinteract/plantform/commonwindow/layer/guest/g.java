package com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.interact.utils.AvatarType;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.base.MicSeatScene;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.ui.LinkSucAnimationView;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.dynamicelement.MultiLinkMicSeatGiftIconElement;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.guest.k;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkGuestViewBinder;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.model.n;
import com.bytedance.android.live.liveinteract.revenue.fight.TeamFightContext;
import com.bytedance.android.live.liveinteract.revenuebase.MultiRevenueDataContext;
import com.bytedance.android.live.liveinteract.utils.o1;
import com.bytedance.android.live.liveinteract.videotalk.quickinteract.QuickInteractTask;
import com.bytedance.android.live.liveinteract.videotalk.quickinteract.interactView.LinkMicQuickInteractView;
import com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.SelfDisciplineContext;
import com.bytedance.android.live.liveinteract.videotalk.themecompetition.ThemedCompetitionContext;
import com.bytedance.android.livesdk.chatroom.ui.d6;
import com.bytedance.android.livesdk.chatroom.ui.e6;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.common.AnchorPauseTipsView;
import com.bytedance.android.livesdk.config.vz;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.utils.l3;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveThemeKt;
import com.bytedance.common.utility.collection.CollectionUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.fresco.animation.frame.DropFramesFrameScheduler;
import com.facebook.imagepipeline.image.ImageInfo;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import tf0.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public class g extends jg0.a<MultiLinkGuestViewBinder.a> implements jg0.e, LinkSucAnimationView.a, e6, jg0.d<MultiLinkGuestViewBinder.a> {
    public MultiLinkGuestViewBinder.a e;
    public HSImageView f;
    public ConstraintLayout g;
    public HSImageView h;
    public HSImageView i;
    public AnchorPauseTipsView j;
    public TextView k;
    public View l;
    public MultiLinkMicSeatGiftIconElement m;
    public FrameLayout n;
    public View o;
    public HSImageView p;
    public j22.c q;
    public AnimatorSet r;

    public static final class a {
    }

    public static final class b extends AnimatorListenerAdapter {
        public final /* synthetic */ g a;
        public final /* synthetic */ Ref.IntRef b;

        public static final class a extends BaseControllerListener<ImageInfo> {
            public final /* synthetic */ b a;

            public a(b r1) {
                this.a = r1;
            }

            public final void onFinalImageSet(String r3, Object r4, Animatable r5) {
                super.onFinalImageSet(r3, (ImageInfo) r4, r5);
                if ((r5 instanceof AnimatedDrawable2) == true) goto L5;
                Animatable r6 = null;
            L6:
                AnimatedDrawable2 r7 = (AnimatedDrawable2) r6;
                if (r7 == null) goto L9;
                r7.setPrivateFrameScheduler(new DropFramesFrameScheduler(((AnimatedDrawable2) r5).getAnimationBackend()));
            L9:
                HSImageView r8 = this.a.a.p;
                if (r8 == null) goto L13;
                r8.postDelayed(new h(this), 500);
                return;
            L13:
                return;
            L5:
                r6 = r5;
                goto L6
            }
        }

        public b(g r1, Ref.IntRef r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r3, boolean r4) {
            Intrinsics.checkNotNullParameter(r3, "animation");
            super.onAnimationEnd(r3, r4);
            HSImageView r5 = this.a.p;
            if (r5 == null) goto L5;
            r5.setVisibility(0);
        L5:
            String r6 = (String) vz.a.getValue();
            HSImageView r7 = this.a.p;
            if (r7 == null) goto L9;
            r7.setController(Fresco.newDraweeControllerBuilder().setAutoPlayAnimations(true).setUri(r6).setControllerListener(new a(this)).build());
            return;
        }
    }

    public static final class c extends BaseControllerListener<ImageInfo> {
        public c() {
        }

        public final void onFinalImageSet(String r1, Object r2, Animatable r3) {
            ImageInfo r4 = (ImageInfo) r2;
            if ((r3 instanceof AnimatedDrawable2) == true) goto L5;
            r3 = null;
        L5:
            AnimatedDrawable2 r5 = (AnimatedDrawable2) r3;
            if (r5 == null) goto L9;
            r5.stop();
            r5.jumpToFrame(1);
            return;
        }
    }

    static {
    }

    public void C() {
    }

    public void E(boolean r1) {
    }

    public void c(d6 r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
    }

    @Override // jg0.e
    public void i() {
    }

    @Override // jg0.c, jg0.f
    public void j(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
    }

    public boolean u() {
        return this instanceof k;
    }

    public com.bytedance.android.live.liveinteract.revenue.common.vieweffect.b w() {
        return null;
    }

    public View x() {
        return null;
    }

    public Integer y() {
        return null;
    }

    public boolean z() {
        return true;
    }

    public final void D() {
        MultiLinkGuestViewBinder.a r0 = this.e;
        if (r0 == null) goto L11;
        ch0.e r1 = r0.k;
        if (r1 == null) goto L11;
        ILinkPlayerInfoBridge r2 = r1.a;
        if (r2 == null) goto L11;
        if (n.f(r2) != true) goto L11;
        v();
        return;
    L11:
        HSImageView r3 = this.i;
        if (r3 == null) goto L14;
        r3.setController(null);
    L14:
        HSImageView r4 = this.i;
        if (r4 == null) goto L19;
        r4.setVisibility(4);
        return;
    }

    public void F() {
        if (SelfDisciplineContext.Companion.e() == false) goto L5;
    L25:
        MultiLinkMicSeatGiftIconElement r0 = this.m;
        if (r0 == null) goto L33;
        r0.e(8);
        return;
    L33:
        return;
    L5:
        if (ThemedCompetitionContext.Companion.g() == true) goto L25;
        AnchorPauseTipsView r1 = this.j;
        if (r1 != null) goto L9;
    L11:
        MultiLinkGuestViewBinder.a r2 = this.e;
        if (r2 == null) goto L22;
        ch0.e r3 = r2.k;
        if (r3 == null) goto L22;
        ILinkPlayerInfoBridge r4 = r3.a;
        if (r4 == null) goto L22;
        if (r4.isOpenSendGift() != true) goto L22;
        MultiLinkMicSeatGiftIconElement r5 = this.m;
        if (r5 == null) goto L29;
        r5.e(0);
        return;
    L29:
        return;
    L22:
        MultiLinkMicSeatGiftIconElement r6 = this.m;
        if (r6 == null) goto L31;
        r6.e(8);
        return;
    L31:
        return;
    L9:
        if (r1.getVisibility() != 0) goto L11;
        goto L11
    }

    public final void G() {
        MultiLinkGuestViewBinder.a r0 = this.e;
        if (r0 == null) goto L27;
        ch0.e r1 = r0.k;
        if (r1 == null) goto L28;
        ILinkPlayerInfoBridge r2 = r1.a;
        if (r2 == null) goto L29;
        n.f(r2);
        if (n.h(r2) == true) goto L17;
        if (n.f(r2) == false) goto L17;
        HSImageView r3 = this.i;
        if (r3 == null) goto L15;
        r3.setController(null);
    L15:
        v();
        return;
    L17:
        if (n.h(r2) == false) goto L19;
        return;
    L19:
        if (n.f(r2) == true) goto L32;
        HSImageView r4 = this.i;
        if (r4 == null) goto L23;
        r4.setController(null);
    L23:
        HSImageView r5 = this.i;
        if (r5 == null) goto L33;
        r5.setVisibility(4);
        return;
    L33:
        return;
    L32:
        return;
    L29:
        return;
    L28:
        return;
    }

    @Override // jg0.e
    public bd0.c f() {
        HSImageView r1 = this.h;
        if (r1 == null) goto L5;
        int r2 = r1.getWidth();
    L6:
        HSImageView r3 = this.h;
        if (r3 == null) goto L9;
        int r4 = r3.getHeight();
    L11:
        if (r2 <= 0) goto L19;
        if (r4 <= 0) goto L19;
        ConstraintLayout r5 = this.g;
        if (r5 == null) goto L19;
        if (r5.getVisibility() != 0) goto L19;
        boolean r6 = false;
    L20:
        String r7 = null;
        if (r6 == false) goto L46;
        int[] r8 = new int[2];
        q().getLocationOnScreen(r8);
        float r13 = r8[0] + (q().getWidth() / 2.0f);
        float r14 = r8[1] + (q().getHeight() / 2.0f);
        HSImageView r9 = this.h;
        HSImageView r10 = this.f;
        MultiLinkGuestViewBinder.a r11 = this.e;
        if (r11 == null) goto L31;
        ch0.e r12 = r11.k;
        if (r12 == null) goto L31;
        ILinkPlayerInfoBridge r15 = r12.a;
        if (r15 == null) goto L31;
        IBaseUser r16 = r15.getUser();
        if (r16 == null) goto L31;
        String r17 = r16.getIdString();
    L32:
        MultiLinkGuestViewBinder.a r18 = this.e;
        if (r18 == null) goto L45;
        ch0.e r19 = r18.k;
        if (r19 == null) goto L45;
        ILinkPlayerInfoBridge r20 = r19.a;
        if (r20 == null) goto L45;
        IBaseUser r21 = r20.getUser();
        if (r21 == null) goto L45;
        py.k r22 = je0.d.n(r21, AvatarType.AVATAR_THUMB.getValue());
        if (r22 == null) goto L45;
        List r23 = r22.getUrls();
        if (r23 == null) goto L45;
        r7 = (String) ListProtector.get(r23, 0);
    L45:
        bd0.c r24 = new bd0.c(r9, r10, r17, true, r13, r14, r7, false, null, null, null, null, 3968);
    L70:
        return r24;
    L31:
        r17 = null;
        goto L32
    L46:
        HSImageView r25 = this.h;
        HSImageView r26 = this.f;
        MultiLinkGuestViewBinder.a r27 = this.e;
        if (r27 == null) goto L55;
        ch0.e r28 = r27.k;
        if (r28 == null) goto L55;
        ILinkPlayerInfoBridge r29 = r28.a;
        if (r29 == null) goto L55;
        IBaseUser r30 = r29.getUser();
        if (r30 == null) goto L55;
        String r210 = r30.getIdString();
    L56:
        MultiLinkGuestViewBinder.a r31 = this.e;
        if (r31 == null) goto L69;
        ch0.e r32 = r31.k;
        if (r32 == null) goto L69;
        ILinkPlayerInfoBridge r33 = r32.a;
        if (r33 == null) goto L69;
        IBaseUser r34 = r33.getUser();
        if (r34 == null) goto L69;
        py.k r35 = je0.d.n(r34, AvatarType.AVATAR_THUMB.getValue());
        if (r35 == null) goto L69;
        List r36 = r35.getUrls();
        if (r36 == null) goto L69;
        r7 = (String) ListProtector.get(r36, 0);
    L69:
        r24 = new bd0.c(r25, r26, r210, false, 0.0f, 0.0f, r7, false, null, null, null, null, 4024);
    L55:
        r210 = null;
    L19:
        r6 = true;
        goto L20
    L9:
        r4 = 0;
        goto L11
    L5:
        r2 = 0;
        goto L6
    }

    @Override // com.bytedance.android.live.liveinteract.chatroom.chatroom.ui.LinkSucAnimationView.a
    public final void g() {
        MultiLinkMicSeatGiftIconElement r0 = this.m;
        if (r0 == null) goto L6;
        r0.e(8);
        return;
    }

    public void r() {
        MultiLinkGuestViewBinder.a r0 = this.e;
        py.k r2 = null;
        if (r0 == null) goto L27;
        ch0.e r1 = r0.k;
        if (r1 == null) goto L27;
        ILinkPlayerInfoBridge r3 = r1.a;
        if (r3 == null) goto L27;
        if (r3.isAnonymous() != true) goto L27;
        PipelineDraweeControllerBuilder r4 = Fresco.newDraweeControllerBuilder();
        MultiLinkGuestViewBinder.a r5 = this.e;
        if (r5 == null) goto L23;
        ch0.e r6 = r5.k;
        if (r6 == null) goto L23;
        ILinkPlayerInfoBridge r7 = r6.a;
        if (r7 == null) goto L23;
        IBaseUser r8 = r7.getUser();
        if (r8 == null) goto L23;
        py.k r9 = r8.getAvatarMedium();
        if (r9 == null) goto L23;
        List r10 = r9.getUrls();
        if (r10 == null) goto L23;
        String r11 = (String) CollectionsKt.firstOrNull(r10);
    L24:
        AbstractDraweeController r12 = r4.setUri(r11).setControllerListener(new i(this)).build();
        HSImageView r13 = this.h;
        if (r13 == null) goto L43;
        r13.setController(r12);
    L43:
        MultiLinkGuestViewBinder.a r14 = this.e;
        if (r14 == null) goto L72;
        ch0.e r15 = r14.k;
        if (r15 == null) goto L72;
        ILinkPlayerInfoBridge r16 = r15.a;
        if (r16 == null) goto L72;
        IBaseUser r17 = r16.getUser();
        if (r17 == null) goto L72;
        if (r17.isMysteryMan() != true) goto L72;
        TextView r18 = this.k;
        if (r18 == null) goto L66;
        MultiLinkGuestViewBinder.a r19 = this.e;
        if (r19 == null) goto L64;
        ch0.e r20 = r19.k;
        if (r20 == null) goto L64;
        ILinkPlayerInfoBridge r21 = r20.a;
        if (r21 == null) goto L64;
        IBaseUser r22 = r21.getUser();
        if (r22 == null) goto L64;
        String r23 = r22.getNickName();
    L65:
        r18.setText(r23);
    L64:
        r23 = null;
    L66:
        HSImageView r24 = this.f;
        if (r24 == null) goto L69;
        r24.setController(null);
    L69:
        HSImageView r25 = this.f;
        if (r25 == null) goto L106;
        r25.setBackgroundColor(ColorProtector.parseColor("#ffa393c8"));
        return;
    L106:
        return;
    L72:
        TextView r26 = this.k;
        if (r26 == null) goto L85;
        MultiLinkGuestViewBinder.a r27 = this.e;
        if (r27 == null) goto L83;
        ch0.e r28 = r27.k;
        if (r28 == null) goto L83;
        ILinkPlayerInfoBridge r29 = r28.a;
        if (r29 == null) goto L83;
        IBaseUser r30 = r29.getUser();
        if (r30 == null) goto L83;
        String r31 = r30.getRealNickName();
    L84:
        r26.setText(r31);
    L83:
        r31 = null;
    L85:
        MultiLinkGuestViewBinder.a r32 = this.e;
        if (r32 == null) goto L94;
        ch0.e r33 = r32.k;
        if (r33 == null) goto L94;
        ILinkPlayerInfoBridge r34 = r33.a;
        if (r34 == null) goto L94;
        if (r34.isAnonymous() != true) goto L94;
        int r35 = 50;
    L95:
        HSImageView r36 = this.f;
        MultiLinkGuestViewBinder.a r37 = this.e;
        if (r37 == null) goto L104;
        ch0.e r38 = r37.k;
        if (r38 == null) goto L104;
        ILinkPlayerInfoBridge r39 = r38.a;
        if (r39 == null) goto L104;
        IBaseUser r40 = r39.getUser();
        if (r40 == null) goto L104;
        r2 = r40.getAvatarMedium();
    L104:
        ImageLoader.bindImage(r36, r2, new l3(r35));
        return;
    L94:
        r35 = 15;
    L23:
        r11 = null;
    L27:
        HSImageView r41 = this.h;
        if (r41 == null) goto L32;
        Drawable r42 = r41.getBackground();
        if (r42 == null) goto L32;
        r42.setAlpha(1);
    L32:
        HSImageView r43 = this.h;
        MultiLinkGuestViewBinder.a r44 = this.e;
        if (r44 == null) goto L41;
        ch0.e r45 = r44.k;
        if (r45 == null) goto L41;
        ILinkPlayerInfoBridge r46 = r45.a;
        if (r46 == null) goto L41;
        IBaseUser r47 = r46.getUser();
        if (r47 == null) goto L41;
        py.k r48 = r47.getAvatarMedium();
    L42:
        ImageUtil.loadRoundImageAntiFlink(r43, r48, 0);
    L41:
        r48 = null;
        goto L42
    }

    public final void t() {
        AnimatorSet r0 = this.r;
        if (r0 == null) goto L7;
        if (r0.isRunning() != true) goto L7;
        return;
    L7:
        if (this.h == null) goto L31;
        this.r = new AnimatorSet();
        PropertyValuesHolder r1 = PropertyValuesHolder.ofFloat(View.SCALE_X, new float[]{1.0f, 1.2f});
        PropertyValuesHolder r3 = PropertyValuesHolder.ofFloat(View.SCALE_Y, new float[]{1.0f, 1.2f});
        PropertyValuesHolder r4 = PropertyValuesHolder.ofFloat(View.SCALE_X, new float[]{1.2f, 1.0f});
        PropertyValuesHolder r5 = PropertyValuesHolder.ofFloat(View.SCALE_Y, new float[]{1.2f, 1.0f});
        ObjectAnimator r6 = ObjectAnimator.ofPropertyValuesHolder(this.h, new PropertyValuesHolder[]{r1, r3});
        r6.setDuration(160);
        ObjectAnimator r7 = ObjectAnimator.ofPropertyValuesHolder(this.o, new PropertyValuesHolder[]{r1, r3});
        r7.setDuration(160);
        ObjectAnimator r2 = ObjectAnimator.ofPropertyValuesHolder(this.p, new PropertyValuesHolder[]{r1, r3});
        r2.setDuration(160);
        ObjectAnimator r8 = ObjectAnimator.ofPropertyValuesHolder(this.h, new PropertyValuesHolder[]{r4, r5});
        r8.setDuration(300);
        ObjectAnimator r11 = ObjectAnimator.ofPropertyValuesHolder(this.o, new PropertyValuesHolder[]{r4, r5});
        r11.setDuration(300);
        ObjectAnimator r9 = ObjectAnimator.ofPropertyValuesHolder(this.p, new PropertyValuesHolder[]{r4, r5});
        r9.setDuration(300);
        AnimatorSet r10 = new AnimatorSet();
        AnimatorSet.Builder r12 = r10.play(r6);
        if (r12 == null) goto L14;
        AnimatorSet.Builder r13 = r12.with(r7);
        if (r13 == null) goto L14;
        r13.with(r2);
    L14:
        AnimatorSet r14 = new AnimatorSet();
        AnimatorSet.Builder r15 = r14.play(r8);
        if (r15 == null) goto L19;
        AnimatorSet.Builder r16 = r15.with(r11);
        if (r16 == null) goto L19;
        r16.with(r9);
    L19:
        AnimatorSet r17 = this.r;
        if (r17 == null) goto L24;
        AnimatorSet.Builder r18 = r17.play(r10);
        if (r18 == null) goto L24;
        r18.before(r14);
    L24:
        Ref.IntRef r19 = new Ref.IntRef();
        r19.element = 1;
        AnimatorSet r20 = this.r;
        if (r20 == null) goto L27;
        r20.addListener(new b(this, r19));
    L27:
        AnimatorSet r21 = this.r;
        if (r21 == null) goto L32;
        r21.start();
        return;
    L32:
        return;
    }

    public void v() {
        MultiLinkGuestViewBinder.a r0 = this.e;
        DraweeController r1 = null;
        if (r0 == null) goto L7;
        ch0.e r2 = r0.k;
        if (r2 == null) goto L7;
        ILinkPlayerInfoBridge r3 = r2.a;
    L8:
        if (r3 != null) goto L10;
        return;
    L10:
        if (n.f(r3) == false) goto L71;
        HSImageView r4 = this.i;
        if (r4 == null) goto L15;
        DraweeController r5 = r4.getController();
    L16:
        if (r5 == null) goto L64;
        HSImageView r6 = this.i;
        if (r6 == null) goto L45;
        DraweeController r7 = r6.getController();
        if (r7 == null) goto L45;
        Animatable r8 = r7.getAnimatable();
    L46:
        if (r8 == null) goto L68;
        HSImageView r9 = this.i;
        if (r9 == null) goto L52;
        DraweeController r10 = r9.getController();
        if (r10 == null) goto L52;
        Animatable r11 = r10.getAnimatable();
    L54:
        if ((r11 instanceof AnimatedDrawable2) == false) goto L69;
        HSImageView r12 = this.i;
        if (r12 == null) goto L58;
        r1 = r12.getController();
    L58:
        Intrinsics.checkNotNull(r1);
        AnimatedDrawable2 r13 = r1.getAnimatable();
        if (r13 == null) goto L62;
        AnimatedDrawable2 r14 = r13;
        r14.stop();
        r14.jumpToFrame(1);
        return;
    L62:
        throw new NullPointerException("null cannot be cast to non-null type com.facebook.fresco.animation.drawable.AnimatedDrawable2");
    L69:
        return;
    L52:
        r11 = null;
        goto L54
    L68:
        return;
    L45:
        r8 = null;
        goto L46
    L64:
        kd1.b r15 = r3.getMicDress();     // Catch: Exception -> L37
        if (r15 == null) goto L27;
        kd1.c r16 = r15.getVoiceWave();     // Catch: Exception -> L37
        if (r16 == null) goto L27;
        py.k r17 = r16.getMediumImg();     // Catch: Exception -> L37
        if (r17 == null) goto L27;
        List r18 = r17.getUrls();     // Catch: Exception -> L37
        if (r18 == null) goto L27;
        String r19 = (String) ListProtector.get(r18, 0);     // Catch: Exception -> L37
    L28:
        c r20 = new c();
        PipelineDraweeControllerBuilder r21 = Fresco.newDraweeControllerBuilder().setUri(r19);
        HSImageView r22 = this.i;
        if (r22 == null) goto L31;
        r1 = r22.getController();
    L31:
        AbstractDraweeController r23 = r21.setOldController(r1).setControllerListener(r20).setAutoPlayAnimations(false).build();
        HSImageView r24 = this.i;
        if (r24 == null) goto L34;
        r24.setController(r23);
    L34:
        HSImageView r25 = this.i;
        if (r25 == null) goto L66;
        r25.setVisibility(0);
        return;
    L66:
        return;
    L27:
        r19 = null;
    L37:
        e = move-exception;
        ALogger.e("MultiLinkGuestMicSeatBasicLayer", "get url fail. Exception type:".concat(e.getClass().getSimpleName()));
        return;
    L15:
        r5 = null;
        goto L16
    L71:
        return;
    L7:
        r3 = null;
        goto L8
    }

    @Override // com.bytedance.android.live.liveinteract.chatroom.chatroom.ui.LinkSucAnimationView.a
    public final void h() {
        r();
        F();
    }

    public void H(int r4) {
        MultiLinkGuestViewBinder.a r0 = this.e;
        if (r0 == null) goto L11;
        ch0.e r1 = r0.k;
        if (r1 == null) goto L11;
        ILinkPlayerInfoBridge r2 = r1.a;
        if (r2 == null) goto L11;
        boolean r3 = true;
        if (r2.getRoomLinkSilenceStatus() != 1) goto L11;
    L12:
        View r5 = null;
        if (r3 == false) goto L25;
        View r6 = this.l;
        if (r6 == null) goto L17;
        r6.setVisibility(0);
    L17:
        View r7 = this.l;
        if ((r7 instanceof ImageView) == false) goto L21;
        r5 = r7;
    L21:
        ImageView r8 = (ImageView) r5;
        if (r8 == null) goto L24;
        r8.setImageResource(2131251753);
    L24:
        D();
        return;
    L25:
        if (r4 == 0) goto L37;
        View r9 = this.l;
        if (r9 == null) goto L29;
        r9.setVisibility(0);
    L29:
        View r10 = this.l;
        if ((r10 instanceof ImageView) == false) goto L33;
        r5 = r10;
    L33:
        ImageView r11 = (ImageView) r5;
        if (r11 == null) goto L36;
        r11.setImageResource(2131251871);
    L36:
        D();
        return;
    L37:
        View r12 = this.l;
        if (r12 == null) goto L43;
        r12.setVisibility(8);
        return;
    L43:
        return;
    L11:
        r3 = false;
        goto L12
    }

    @Override // jg0.c, jg0.f
    public void a(Context r6) {
        Intrinsics.checkNotNullParameter(r6, "context");
        super.a(r6);
        this.f = q().findViewById(2131389574);
        this.g = q().findViewById(2131389575);
        this.h = q().findViewById(2131389564);
        this.j = q().findViewById(2131389641);
        LinearLayout r0 = (LinearLayout) q().findViewById(2131389587);
        this.k = (TextView) q().findViewById(2131389585);
        this.l = q().findViewById(2131389580);
        this.i = q().findViewById(2131389896);
        if ((this instanceof f) == false) goto L5;
    L8:
        View r1 = q().findViewById(2131382442);
        if ((r1 instanceof FrameLayout) == true) goto L11;
        r1 = null;
    L11:
        FrameLayout r2 = (FrameLayout) r1;
        LinkMicQuickInteractView r3 = new LinkMicQuickInteractView(r6, null, 6, 0);
        FrameLayout.LayoutParams r7 = new FrameLayout.LayoutParams(-2, -2);
        r7.gravity = 19;
        r3.setLayoutParams(r7);
        r3.setId(2131389578);
        if (r2 == null) goto L14;
        r2.addView(r3);
    L14:
        LinkMicQuickInteractView.a(r3, true, false, 2);
        r3.x = "0";
        r3.n.f();
        MultiLinkMicSeatGiftIconElement r8 = new MultiLinkMicSeatGiftIconElement(r3, true);
        this.m = r8;
        r8.e(8);
    L15:
        this.n = (FrameLayout) q().findViewById(2131389943);
        this.q = new j22.c(this.i);
        return;
    L5:
        if ((this instanceof d) == true) goto L8;
        this.m = new MultiLinkMicSeatGiftIconElement((LinkMicQuickInteractView) q().findViewById(2131389576), false);
        goto L15
    }

    public g(MicSeatScene r2, xg0.a r3) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        super(r2, r3);
    }

    public void A(MultiLinkGuestViewBinder.a r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "itemData");
        this.e = r3;
        MultiLinkMicSeatGiftIconElement r0 = this.m;
        if (r0 == null) goto L5;
        r0.a = r3;
        r0.d();
    L5:
        r();
        AnchorPauseTipsView r5 = this.j;
        if (r5 == null) goto L8;
        UtilityKotlinExtentionsKt.t(r5);
    L8:
        F();
        MultiLinkGuestViewBinder.a r6 = this.e;
        if (r6 == null) goto L15;
        ch0.e r7 = r6.k;
        if (r7 == null) goto L15;
        ILinkPlayerInfoBridge r8 = r7.a;
        if (r8 == null) goto L15;
        int r9 = r8.getSilenceStatus();
    L16:
        H(r9);
        MultiLinkGuestViewBinder.a r10 = this.e;
        if (r10 == null) goto L24;
        ch0.e r11 = r10.k;
        if (r11 == null) goto L24;
        ILinkPlayerInfoBridge r12 = r11.a;
        if (r12 == null) goto L24;
        String r13 = r12.getFanTicketDisplayStr();
        if (r13 == null) goto L24;
    L25:
        MultiLinkGuestViewBinder.a r1 = this.e;
        if (r1 == null) goto L35;
        ch0.e r2 = r1.k;
        if (r2 == null) goto L35;
        ILinkPlayerInfoBridge r14 = r2.a;
        if (r14 == null) goto L35;
        IBaseUser r15 = r14.getUser();
        if (r15 == null) goto L35;
        String r16 = r15.getIdString();
        if (r16 == null) goto L35;
    L36:
        s(r13, r16);
        G();
        Object r17 = q().getParent();
        CharSequence r18 = null;
        if ((r17 instanceof View) == true) goto L39;
        r17 = null;
    L39:
        View r19 = (View) r17;
        StringBuilder r20 = new StringBuilder();
        r20.append(r4);
        r20.append(s1.B(2131920341));
        r20.append(' ');
        TextView r21 = this.k;
        if (r21 == null) goto L42;
        r18 = r21.getText();
    L42:
        r20.append(r18);
        r3.c(r19, r20.toString(), true);
        return;
    L35:
        r16 = "";
    L24:
        r13 = "0";
    L15:
        r9 = -1;
        goto L16
    }

    @Override // jg0.f
    public /* bridge */ /* synthetic */ void d(MultiLinkGuestViewBinder.a r1, int r2) {
        A(r1, r2);
    }

    public final void s(String r23, String r24) {
        Intrinsics.checkNotNullParameter(r23, "score");
        Intrinsics.checkNotNullParameter(r24, "playerUid");
        MultiLinkGuestViewBinder.a r5 = this.e;
        if (r5 == null) goto L7;
        ch0.e r6 = r5.k;
        if (r6 == null) goto L7;
        ILinkPlayerInfoBridge r7 = r6.a;
    L8:
        com.bytedance.android.live.liveinteract.videotalk.quickinteract.b.r0.getClass();
        boolean r8 = false;
        if (com.bytedance.android.live.liveinteract.videotalk.quickinteract.b.C0101b.c(r7) == true) goto L11;
    L46:
        MultiLinkMicSeatGiftIconElement r9 = this.m;
        if (r9 == null) goto L64;
        Intrinsics.checkNotNullParameter(r23, "score");
        Intrinsics.checkNotNullParameter(r24, "playerUid");
        if (r9.b() != null) goto L51;
        r8 = true;
    L51:
        if (r8 == false) goto L65;
        LinkMicQuickInteractView r2 = r9.c;
        if (r2 == null) goto L66;
        r2.b(r23, r24);
        return;
    L66:
        return;
    L65:
        return;
    L64:
        return;
    L11:
        if (com.bytedance.android.live.liveinteract.videotalk.quickinteract.b.C0101b.a() == null) goto L46;
        TeamFightContext.a r10 = TeamFightContext.Companion;
        if (r10.f() == true) goto L17;
        if (r10.e() == true) goto L17;
    L21:
        com.bytedance.android.live.liveinteract.videotalk.quickinteract.b r11 = com.bytedance.android.live.liveinteract.videotalk.quickinteract.b.C0101b.a();
        Intrinsics.checkNotNull(r11);
        if (r11.isEmpty() == false) goto L24;
    L37:
        MultiLinkMicSeatGiftIconElement r12 = this.m;
        if (r12 == null) goto L60;
        Intrinsics.checkNotNullParameter(r23, "score");
        Intrinsics.checkNotNullParameter(r24, "playerUid");
        if (r12.b() != null) goto L42;
        r8 = true;
    L42:
        if (r8 == false) goto L61;
        LinkMicQuickInteractView r3 = r12.c;
        if (r3 == null) goto L62;
        r3.b(r23, r24);
        return;
    L62:
        return;
    L61:
        return;
    L60:
        return;
    L24:
        if (r10.f() == true) goto L37;
        if (r10.e() == true) goto L37;
        if (ThemedCompetitionContext.Companion.g() == true) goto L37;
        MultiRevenueDataContext.Companion.getClass();
        com.bytedance.android.live.liveinteract.revenuebase.b r13 = MultiRevenueDataContext.a.b();
        if (r13 != null) goto L32;
    L34:
        MultiLinkMicSeatGiftIconElement r15 = this.m;
        if (r15 == null) goto L58;
        r15.c(new QuickInteractTask(je0.d.b0(), r23, 0, null, null, null, 0, null, false, null, null, null, null, 8188));
        return;
    L58:
        return;
    L32:
        if (r13.isFightShowing() != true) goto L34;
    L17:
        if (je0.d.r() == false) goto L21;
        MultiLinkMicSeatGiftIconElement r16 = this.m;
        if (r16 == null) goto L56;
        r16.c(new QuickInteractTask(je0.d.b0(), r23, 0, null, null, null, 0, null, false, null, null, null, null, 8188));
        return;
    L56:
        return;
    L7:
        r7 = null;
        goto L8
    }

    /* JADX WARN: Type inference failed for: r14v1, types: [boolean] */
    public void B(MultiLinkGuestViewBinder.a r19, int r20, Bundle r21) {
        Intrinsics.checkNotNullParameter(r19, "itemData");
        Intrinsics.checkNotNullParameter(r21, "payload");
        this.e = r19;
        Iterator<String> r3 = r21.keySet().iterator();
    L4:
        if (r3.hasNext() == false) goto L317;
        String r4 = r3.next();
        if (r4 == null) goto L4;
        ILinkPlayerInfoBridge r8 = null;
        py.k r9 = null;
        r9 = null;
        r9 = null;
        r9 = null;
        r9 = null;
        DraweeController r10 = null;
        Integer r11 = null;
        DraweeController r12 = null;
        DraweeController r13 = null;
        Object r14 = null;
        r8 = null;
        boolean r15 = false;
        int r16 = -1;
        switch(r4.hashCode()) {
            case -2108878291: goto L252;
            case -1998665887: goto L249;
            case -1919610850: goto L246;
            case -1902415957: goto L233;
            case -1227871264: goto L199;
            case -1010189482: goto L187;
            case -715388833: goto L184;
            case -703589172: goto L181;
            case -643953561: goto L56;
            case 268668786: goto L53;
            case 316138020: goto L50;
            case 826672197: goto L47;
            case 1640944494: goto L44;
            case 1793196717: goto L39;
            case 2021952839: goto L12;
            default: goto L4;
        };
    L12:
        if (r4.equals("payload_key_silence_status_update") == false) goto L4;
        MultiLinkGuestViewBinder.a r5 = this.e;
        if (r5 == null) goto L20;
        ch0.e r6 = r5.k;
        if (r6 == null) goto L20;
        ILinkPlayerInfoBridge r7 = r6.a;
        if (r7 == null) goto L20;
        r16 = r7.getSilenceStatus();
    L20:
        H(r16);
        MultiLinkGuestViewBinder.a r17 = this.e;
        if (r17 == null) goto L4;
        ch0.e r18 = r17.k;
        if (r18 == null) goto L4;
        ILinkPlayerInfoBridge r22 = r18.a;
        if (r22 == null) goto L4;
        if (r22.isBackground() != true) goto L4;
        MultiLinkGuestViewBinder.a r23 = this.e;
        if (r23 == null) goto L37;
        ch0.e r24 = r23.k;
        if (r24 == null) goto L37;
        ILinkPlayerInfoBridge r25 = r24.a;
        if (r25 == null) goto L37;
        if (r25.isBackground() != true) goto L37;
        r15 = true;
    L37:
        E(r15);
        goto L4
    L39:
        if (r4.equals("payload_key_dynamic_data_update_for_gift_icon_info") == false) goto L4;
        MultiLinkMicSeatGiftIconElement r26 = this.m;
        if (r26 == null) goto L4;
        r26.a = this.e;
        r26.d();
        goto L4
    L44:
        if (r4.equals("payload_key_mic_dress") == false) goto L4;
        G();
        goto L4
    L47:
        if (r4.equals("payload_key_linkmic_2d_avatar_update") == false) goto L4;
    L247:
        r();
        goto L4
    L50:
        if (r4.equals("payload_key_linkmic_3d_avatar_update") == false) goto L4;
    L53:
        if (r4.equals("payload_key_is_open_send_gift_update") == false) goto L4;
        F();
        goto L4
    L56:
        if (r4.equals("payload_key_mic_talk_state") == false) goto L4;
        ?? r110 = ch0.f.a(r19.k);
        if (r19.k.a.getSilenceStatus() != 0) goto L59;
        if (r110 > 0) goto L61;
        MultiLinkGuestViewBinder.a r27 = this.e;
        if (r27 == null) goto L156;
        IVoiceLiveTheme r28 = r27.c;
    L157:
        if (r28 == null) goto L163;
        if (IVoiceLiveThemeKt.isVoiceAnimInvalid(r28) != true) goto L163;
        j22.c r29 = this.q;
        if (r29 == null) goto L4;
        r29.d = true;
    L163:
        MultiLinkGuestViewBinder.a r30 = this.e;
        if (r30 == null) goto L174;
        ch0.e r31 = r30.k;
        if (r31 == null) goto L174;
        ILinkPlayerInfoBridge r32 = r31.a;
        if (r32 == null) goto L174;
        if (n.f(r32) != true) goto L174;
        j22.c r33 = this.q;
        if (r33 == null) goto L4;
        r33.d = true;
    L174:
        HSImageView r34 = this.i;
        if (r34 == null) goto L177;
        r34.setController(null);
    L177:
        HSImageView r35 = this.i;
        if (r35 == null) goto L4;
        r35.setVisibility(4);
        goto L4
    L156:
        r28 = null;
        goto L157
    L61:
        HSImageView r36 = this.i;
        if (r36 == null) goto L64;
        r36.setVisibility(0);
    L64:
        MultiLinkGuestViewBinder.a r37 = this.e;
        if (r37 == null) goto L89;
        ch0.e r38 = r37.k;
        if (r38 == null) goto L89;
        ILinkPlayerInfoBridge r39 = r38.a;
        if (r39 == null) goto L89;
        if (n.f(r39) != true) goto L89;
        MultiLinkGuestViewBinder.a r40 = this.e;
        if (r40 == null) goto L83;
        ch0.e r41 = r40.k;
        if (r41 == null) goto L83;
        ILinkPlayerInfoBridge r42 = r41.a;
        if (r42 == null) goto L83;
        kd1.b r43 = r42.getMicDress();
        if (r43 == null) goto L83;
        kd1.c r44 = r43.getVoiceWave();
        if (r44 == null) goto L83;
        r9 = kd1.d.a(r44, r110 == true ? 1 : 0);
    L83:
        j22.c r45 = this.q;
        if (r45 == null) goto L86;
        r45.f(r9);
    L86:
        HSImageView r46 = this.i;
        if (r46 == null) goto L4;
        r46.setVisibility(0);
    L89:
        MultiLinkGuestViewBinder.a r47 = this.e;
        if (r47 == null) goto L92;
        IVoiceLiveTheme r48 = r47.c;
    L93:
        if (r48 != null) goto L94;
        PipelineDraweeControllerBuilder r49 = Fresco.newDraweeControllerBuilder().setUri(UriProtector.parse(vm2.d.t()));
        HSImageView r50 = this.i;
        if (r50 == null) goto L147;
        r10 = r50.getController();
    L147:
        AbstractDraweeController r51 = r49.setOldController(r10).setAutoPlayAnimations(true).build();
        HSImageView r52 = this.i;
        if (r52 == null) goto L150;
        r52.setController(r51);
    L150:
        HSImageView r53 = this.i;
        if (r53 == null) goto L4;
        r53.setVisibility(0);
        goto L4
    L94:
        if (r47 == null) goto L98;
        ch0.e r54 = r47.k;
        if (r54 == null) goto L98;
        ILinkPlayerInfoBridge r55 = r54.a;
    L99:
        if (r47 == null) goto L101;
        IVoiceLiveTheme r111 = r47.c;
    L102:
        if (r111 != null) goto L104;
    L116:
        if (r111 == null) goto L118;
        py.k r56 = r111.getEffectAvatarTalk();
    L119:
        if (r56 == null) goto L135;
        if (r111 == null) goto L122;
        py.k r57 = r111.getEffectAvatarTalk();
    L123:
        Intrinsics.checkNotNull(r57);
        if (CollectionUtils.isEmpty(r57.getUrls()) == true) goto L135;
        PipelineDraweeControllerBuilder r58 = Fresco.newDraweeControllerBuilder();
        if (r111 == null) goto L128;
        py.k r59 = r111.getEffectAvatarTalk();
    L129:
        PipelineDraweeControllerBuilder r60 = r58.setFirstAvailableImageRequests(a1.b(r59, -1));
        HSImageView r61 = this.i;
        if (r61 == null) goto L132;
        r12 = r61.getController();
    L132:
        AbstractDraweeController r62 = r60.setOldController(r12).setAutoPlayAnimations(true).build();
        HSImageView r63 = this.i;
        if (r63 == null) goto L141;
        r63.setController(r62);
    L141:
        HSImageView r65 = this.i;
        if (r65 == null) goto L4;
        r65.setVisibility(0);
        goto L4
    L128:
        r59 = null;
        goto L129
    L122:
        r57 = null;
    L135:
        PipelineDraweeControllerBuilder r66 = Fresco.newDraweeControllerBuilder().setUri(vm2.d.t());
        HSImageView r67 = this.i;
        if (r67 == null) goto L138;
        r13 = r67.getController();
    L138:
        AbstractDraweeController r68 = r66.setOldController(r13).setAutoPlayAnimations(true).build();
        HSImageView r69 = this.i;
        if (r69 == null) goto L141;
        r69.setController(r68);
        goto L141
    L118:
        r56 = null;
        goto L119
    L104:
        if (IVoiceLiveThemeKt.isVoiceAnimInvalid(r111) != true) goto L116;
        if (r55 != null) goto L107;
    L112:
        int r112 = 0;
    L113:
        py.k r70 = IVoiceLiveThemeKt.getVolumeAnim(r111, 3, r110 == true ? 1 : 0, r112, o1.a(), u());
        j22.c r71 = this.q;
        if (r71 == null) goto L141;
        r71.e(r70);
        goto L141
    L107:
        if (r55.getUser() == null) goto L112;
        IBaseUser r72 = r55.getUser();
        if (r72 == null) goto L111;
        r11 = Integer.valueOf(r72.getGender());
    L111:
        Intrinsics.checkNotNull(r11);
        r112 = r11.intValue();
        goto L113
    L101:
        r111 = null;
    L98:
        r55 = null;
        goto L99
    L92:
        r48 = null;
        goto L93
    L59:
        D();
        goto L4
    L181:
        if (r4.equals("payload_key_user_position") == false) goto L4;
        A(r19, r20);
        goto L4
    L184:
        if (r4.equals("payload_key_is_c_position_update") == false) goto L4;
        A(r19, r20);
        goto L4
    L187:
        if (r4.equals("payload_key_background_status_update") == false) goto L4;
        MultiLinkGuestViewBinder.a r73 = this.e;
        if (r73 == null) goto L197;
        ch0.e r74 = r73.k;
        if (r74 == null) goto L197;
        ILinkPlayerInfoBridge r75 = r74.a;
        if (r75 == null) goto L197;
        if (r75.isBackground() != true) goto L197;
        r15 = true;
    L197:
        E(r15);
        goto L4
    L199:
        if (r4.equals("payload_key_gift_icon_flash_update") == false) goto L4;
        Intrinsics.checkNotNullParameter(r19, "itemData");
        ALogger.d("MultiLinkGuestMicSeatBasicLayer", "onGiftIconFlash");
        MultiLinkMicSeatGiftIconElement r76 = this.m;
        if (r76 == null) goto L205;
        LinkMicQuickInteractView r77 = r76.c;
        if (r77 == null) goto L205;
        Integer r78 = Integer.valueOf(r77.getVisibility());
    L206:
        if (r78 == null) goto L4;
        if (r78.intValue() != 0) goto L4;
        r19.k.d.remove("EXT_KEY_GIFT_ICON_FLASH");
        MultiLinkMicSeatGiftIconElement r79 = this.m;
        if (r79 == null) goto L4;
        LinkMicQuickInteractView r80 = r79.c;
        if (r80 == null) goto L4;
        com.bytedance.android.live.liveinteract.videotalk.quickinteract.interactView.a r81 = r80.n;
        AnimatorSet r82 = r81.i;
        if (r82 == null) goto L220;
        if (r82.isRunning() == true) goto L4;
    L220:
        if (((Boolean) vm2.d.l4.getValue(null, vm2.d.a[269(0x10d, float:3.77E-43)])).booleanValue() == false) goto L224;
        if (r81.h != null) goto L4;
    L224:
        r81.j = 3;
        r81.c();
        r81.b();
        ObjectAnimator r83 = ObjectAnimator.ofFloat(r81.a, "scaleX", new float[]{1.0f, 1.1f});
        ObjectAnimator r113 = ObjectAnimator.ofFloat(r81.a, "scaleY", new float[]{1.0f, 1.1f});
        Animator r114 = r81.d(0, 200);
        ObjectAnimator r115 = ObjectAnimator.ofFloat(r81.b, "scaleX", new float[]{1.0f, 1.2f});
        ObjectAnimator r84 = ObjectAnimator.ofFloat(r81.b, "scaleY", new float[]{1.0f, 1.3f});
        ObjectAnimator r85 = ObjectAnimator.ofFloat(r81.b, "alpha", new float[]{0.0f, 0.8f});
        AnimatorSet r116 = new AnimatorSet();
        r116.setDuration(200);
        r116.playTogether(new Animator[]{r83, r113, r114, r115, r84, r85});
        ObjectAnimator r86 = ObjectAnimator.ofFloat(r81.b, "scaleX", new float[]{1.2f, 1.4f});
        ObjectAnimator r87 = ObjectAnimator.ofFloat(r81.b, "scaleY", new float[]{1.3f, 1.5f});
        ObjectAnimator r88 = ObjectAnimator.ofFloat(r81.b, "alpha", new float[]{0.8f, 0.0f});
        AnimatorSet r89 = new AnimatorSet();
        r89.setDuration(300);
        r89.playTogether(new Animator[]{r86, r87, r88});
        ObjectAnimator r90 = ObjectAnimator.ofFloat(r81.a, "scaleX", new float[]{1.1f, 1.0f, 1.0f});
        ObjectAnimator r91 = ObjectAnimator.ofFloat(r81.a, "scaleY", new float[]{1.1f, 1.0f, 1.0f});
        Animator r92 = r81.e(700, 400);
        AnimatorSet r117 = new AnimatorSet();
        r117.setStartDelay(700);
        r117.setDuration(400);
        r117.playTogether(new Animator[]{r90, r91, r92});
        AnimatorSet r93 = new AnimatorSet();
        r81.i = r93;
        r93.addListener(new com.bytedance.android.live.liveinteract.videotalk.quickinteract.interactView.b(r81));
        AnimatorSet r94 = r81.i;
        if (r94 == null) goto L227;
        boolean r95 = true;
        r94.playSequentially(new Animator[]{r116, r89, r117});
    L228:
        AnimatorSet r96 = r81.i;
        if (r96 == null) goto L231;
        r96.start();
    L231:
        r81.l = r95;
        goto L4
    L227:
        r95 = true;
    L205:
        r78 = null;
        goto L206
    L233:
        if (r4.equals("payload_key_interact_task_update") == false) goto L4;
        Object r97 = r19.k.d.get("EXT_KEY_QUICK_INTERACT_TASK");
        if ((r97 instanceof QuickInteractTask) == false) goto L238;
        r14 = r97;
    L238:
        QuickInteractTask r98 = (QuickInteractTask) r14;
        if (r98 == null) goto L4;
        if (r98.getType() != 0) goto L4;
        r19.k.d.remove("EXT_KEY_QUICK_INTERACT_TASK");
        Intrinsics.checkNotNullParameter(r98, "task");
        ALogger.d("MultiLinkGuestMicSeatBasicLayer", "onReceiveInteractTask");
        MultiLinkMicSeatGiftIconElement r99 = this.m;
        if (r99 == null) goto L4;
        r99.a(r98);
        goto L4
    L246:
        if (r4.equals("payload_key_avatar_update") == false) goto L4;
    L249:
        if (r4.equals("payload_key_video_status_update") == false) goto L4;
        C();
        goto L4
    L252:
        if (r4.equals("payload_key_fan_ticket_str_update") == false) goto L4;
        Object r100 = r19.k.d.remove("EXT_KEY_QUICK_INTERACT_MESSAGE");
        if ((r100 instanceof QuickInteractTask) == true) goto L256;
        r100 = null;
    L256:
        QuickInteractTask r101 = (QuickInteractTask) r100;
        if (r101 == null) goto L4;
        ALogger.d("MultiLinkGuestMicSeatBasicLayer", "updateFanTicketStr, task: " + r101);
        String r102 = r101.b;
        if (r102 == null) goto L4;
        MultiLinkGuestViewBinder.a r103 = this.e;
        if (r103 == null) goto L265;
        ch0.e r104 = r103.k;
        if (r104 == null) goto L265;
        r8 = r104.a;
    L265:
        if (r8 == null) goto L267;
        r8.setFanTicketDisplayStr(r102);
    L267:
        F();
        com.bytedance.android.live.liveinteract.videotalk.quickinteract.b.r0.getClass();
        if (com.bytedance.android.live.liveinteract.videotalk.quickinteract.b.C0101b.c(r8) == true) goto L269;
        MultiLinkMicSeatGiftIconElement r105 = this.m;
        if (r105 == null) goto L4;
        Intrinsics.checkNotNullParameter(r102, "score");
        if (r105.b() != null) goto L312;
        boolean r106 = true;
    L313:
        if (r106 == false) goto L4;
        LinkMicQuickInteractView r107 = r105.c;
        if (r107 == null) goto L4;
        r107.j(r102);
        goto L4
    L312:
        r106 = false;
        goto L313
    L269:
        TeamFightContext.a r108 = TeamFightContext.Companion;
        if (r108.f() == true) goto L274;
        if (r108.e() == true) goto L274;
    L279:
        if (r108.f() == true) goto L297;
        if (r108.e() == true) goto L297;
        if (ThemedCompetitionContext.Companion.g() == true) goto L297;
        MultiRevenueDataContext.Companion.getClass();
        com.bytedance.android.live.liveinteract.revenuebase.b r109 = MultiRevenueDataContext.a.b();
        if (r109 == null) goto L293;
        if (r109.isFightShowing() != true) goto L293;
        com.bytedance.android.live.liveinteract.revenuebase.b r118 = MultiRevenueDataContext.a.b();
        if (r118 == null) goto L297;
        if (r118.A4() != true) goto L297;
    L293:
        MultiLinkMicSeatGiftIconElement r119 = this.m;
        if (r119 == null) goto L4;
        r119.c(r101);
    L297:
        MultiLinkMicSeatGiftIconElement r120 = this.m;
        if (r120 == null) goto L4;
        Intrinsics.checkNotNullParameter(r102, "score");
        if (r120.b() != null) goto L302;
        boolean r121 = true;
    L303:
        if (r121 == false) goto L4;
        LinkMicQuickInteractView r122 = r120.c;
        if (r122 == null) goto L4;
        r122.j(r102);
        goto L4
    L302:
        r121 = false;
    L274:
        if (je0.d.r() == false) goto L279;
        MultiLinkMicSeatGiftIconElement r123 = this.m;
        if (r123 == null) goto L4;
        r123.c(r101);
        goto L4
    L317:
        C();
    }

    public void e(int r1, p r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, "action");
        if (Intrinsics.areEqual(r2, bj0.e.b) == false) goto L14;
        MultiLinkGuestViewBinder.a r4 = this.e;
        if (r4 == null) goto L11;
        ch0.e r5 = r4.k;
        if (r5 == null) goto L11;
        ILinkPlayerInfoBridge r6 = r5.a;
        if (r6 == null) goto L11;
        int r7 = r6.getSilenceStatus();
    L12:
        H(r7);
        return;
    L11:
        r7 = -1;
        goto L12
    }

    @Override // jg0.f
    public /* bridge */ /* synthetic */ void k(MultiLinkGuestViewBinder.a r1, int r2, Bundle r3) {
        B(r1, r2, r3);
    }
}
