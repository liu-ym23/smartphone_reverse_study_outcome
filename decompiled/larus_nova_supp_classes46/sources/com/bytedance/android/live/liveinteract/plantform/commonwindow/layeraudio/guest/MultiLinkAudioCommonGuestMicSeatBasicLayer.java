package com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.guest;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.interact.utils.AvatarType;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.base.MicSeatScene;
import com.bytedance.android.live.liveinteract.interactivesong.impl.InteractiveSongContext;
import com.bytedance.android.live.liveinteract.linkbase.api.SeatItemId;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.base.LayerBackgroundStatus;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.dynamicelement.MultiLinkMicSeatGiftIconElement;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkGuestViewBinder;
import com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.playmode.SceneType;
import com.bytedance.android.live.liveinteract.pre.VerticalNitaInflate;
import com.bytedance.android.live.liveinteract.videotalk.emoji.model.TalkRoomBaseDynamicEmoji;
import com.bytedance.android.live.liveinteract.videotalk.quickinteract.interactView.LinkMicQuickInteractView;
import com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.SelfDisciplineContext;
import com.bytedance.android.live.liveinteract.videotalk.themecompetition.ThemedCompetitionContext;
import com.bytedance.android.live.liveinteract.voicechat.IVoiceChatAdminService;
import com.bytedance.android.livesdk.chatroom.ui.d6;
import com.bytedance.android.livesdk.common.AnchorPauseTipsView;
import com.bytedance.android.livesdk.link.model.bridge.Linkmic2DAvatar;
import com.bytedance.android.livesdk.link.model.bridge.g2;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.interact.data.LinkFeedTypeConstant;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdkapi.model.MultiLinkFrequencyOptConfig;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.imagepipeline.image.ImageInfo;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import py.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public class MultiLinkAudioCommonGuestMicSeatBasicLayer extends com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g {
    public static final /* synthetic */ int y = 0;
    public final String s;
    public View t;
    public final HashSet<String> u;
    public com.bytedance.android.live.liveinteract.revenue.common.vieweffect.d v;
    public com.bytedance.android.live.liveinteract.revenue.common.vieweffect.b w;
    public final com.bytedance.android.live.liveinteract.plantform.commonwindow.m x;

    public static final class a extends BaseControllerListener<ImageInfo> {
        public a() {
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

    public void M() {
        O(0);
        TextView r0 = this.k;
        if (r0 == null) goto L5;
        r0.setText(s1.B(2131918663));
    L5:
        MultiLinkMicSeatGiftIconElement r1 = this.m;
        if (r1 == null) goto L9;
        r1.e(8);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g
    public View x() {
        return null;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g
    public Integer y() {
        return null;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g
    public boolean z() {
        return true;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g
    public final void C() {
        MultiLinkFrequencyOptConfig r0 = com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.f.a;
        MultiLinkGuestViewBinder.a r1 = this.e;
        ch0.e r2 = null;
        if (r1 == null) goto L5;
        ch0.e r3 = r1.k;
    L6:
        boolean r4 = false;
        if (com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.f.a(r3, null) == false) goto L20;
        HSImageView r5 = this.f;
        if (r5 == null) goto L11;
        r5.setVisibility(8);
    L11:
        ConstraintLayout r6 = this.g;
        if (r6 == null) goto L14;
        r6.setVisibility(8);
    L14:
        MultiLinkGuestViewBinder.a r7 = this.e;
        if (r7 == null) goto L19;
        xg0.a r8 = this.c;
        if (r8 == null) goto L19;
        r8.m3(r7, true);
    L19:
        F();
    L31:
        MultiLinkGuestViewBinder.a r9 = this.e;
        if (r9 == null) goto L38;
        ch0.e r10 = r9.k;
        if (r10 == null) goto L38;
        if (ch0.f.b(r10) != true) goto L38;
        r4 = true;
    L38:
        com.bytedance.android.live.liveinteract.revenue.common.vieweffect.b r11 = this.w;
        if (r11 == null) goto L45;
        MultiLinkGuestViewBinder.a r12 = this.e;
        if (r12 == null) goto L43;
        r2 = r12.k;
    L43:
        r11.d(r4, r2);
        return;
    L45:
        return;
    L20:
        HSImageView r13 = this.f;
        if (r13 == null) goto L23;
        r13.setVisibility(0);
    L23:
        ConstraintLayout r14 = this.g;
        if (r14 == null) goto L26;
        r14.setVisibility(0);
    L26:
        MultiLinkGuestViewBinder.a r15 = this.e;
        if (r15 == null) goto L31;
        xg0.a r16 = this.c;
        if (r16 == null) goto L31;
        r16.m3(r15, false);
        goto L31
    L5:
        r3 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g
    public final void F() {
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

    public final ILinkPlayerInfoBridge J() {
        MultiLinkGuestViewBinder.a r0 = this.e;
        if (r0 == null) goto L7;
        ch0.e r1 = r0.k;
        if (r1 == null) goto L7;
        return r1.a;
    L7:
        return null;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g, jg0.e
    public bd0.c f() {
        HSImageView r1 = this.h;
        String r2 = null;
        if (r1 == null) goto L16;
        ViewParent r3 = q().getParent();
        if (r3 == null) goto L7;
        ViewParent r4 = r3.getParent();
    L9:
        if ((r4 instanceof FrameLayout) == true) goto L11;
        r4 = null;
    L11:
        FrameLayout r5 = (FrameLayout) r4;
        if (r5 == null) goto L14;
        Float r6 = Float.valueOf(r5.getScaleX());
    L15:
        r1.setTag(2131374076, r6);
        goto L16
    L14:
        r6 = null;
        goto L15
    L7:
        r4 = null;
    L16:
        boolean r7 = I();
        com.bytedance.android.live.liveinteract.plantform.commonwindow.m r8 = this.x;
        if (r8.c == false) goto L19;
        int r9 = 0;
    L20:
        InteractiveSongContext.a r10 = InteractiveSongContext.Companion;
        MultiLinkGuestViewBinder.a r11 = this.e;
        if (r11 == null) goto L23;
        ch0.e r12 = r11.k;
    L24:
        boolean r13 = InteractiveSongContext.a.d(r10, r12, r9, false, 4);
        HSImageView r14 = this.h;
        HSImageView r15 = this.f;
        ILinkPlayerInfoBridge r16 = J();
        if (r16 == null) goto L29;
        IBaseUser r17 = r16.getUser();
        if (r17 == null) goto L29;
        String r18 = r17.getIdString();
    L30:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.m r19 = this.x;
        if (r19.c == false) goto L33;
        int r20 = 0;
    L34:
        MultiLinkGuestViewBinder.a r110 = this.e;
        if (r110 == null) goto L37;
        ch0.e r111 = r110.k;
    L39:
        if (InteractiveSongContext.a.d(r10, r111, r20, false, 4) == false) goto L43;
        r2 = "";
    L41:
        String r112 = r2;
        if (r7 == true) goto L66;
        if (r13 == true) goto L66;
        boolean r113 = false;
    L67:
        if (r7 == true) goto L71;
        if (r13 == true) goto L71;
        String r21 = "circle";
    L73:
        return new bd0.c(r14, r15, r18, false, 0.0f, 0.0f, r112, r113, r21, Integer.valueOf(s1.f(8.0f)), null, null, 3128);
    L71:
        r21 = "rectangle";
    L66:
        r113 = true;
        goto L67
    L43:
        if (I() == false) goto L53;
        ILinkPlayerInfoBridge r22 = J();
        if (r22 == null) goto L41;
        Linkmic2DAvatar r23 = r22.getLinkmic2DAvatar();
        if (r23 == null) goto L41;
        py.k r24 = r23.getImage();
        if (r24 == null) goto L41;
        List r25 = r24.getUrls();
        if (r25 == null) goto L41;
        r2 = (String) ListProtector.get(r25, 0);
        goto L41
    L53:
        ILinkPlayerInfoBridge r26 = J();
        if (r26 == null) goto L41;
        IBaseUser r27 = r26.getUser();
        if (r27 == null) goto L41;
        py.k r28 = je0.d.n(r27, AvatarType.AVATAR_THUMB.getValue());
        if (r28 == null) goto L41;
        List r29 = r28.getUrls();
        if (r29 == null) goto L41;
        r2 = (String) ListProtector.get(r29, 0);
        goto L41
    L37:
        r111 = null;
        goto L39
    L33:
        r20 = r19.getUiLayout();
    L29:
        r18 = null;
        goto L30
    L23:
        r12 = null;
        goto L24
    L19:
        r9 = r8.getUiLayout();
        goto L20
    }

    @Override // jg0.c
    public int o() {
        MicSeatScene r0 = this.b;
        int r1 = com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.guest.a.b[r0.ordinal()];
        if (r1 != 1) goto L5;
        return 2131566583;
    L5:
        if (r1 != 2) goto L7;
        return 2131566584;
    L7:
        if (r1 != 3) goto L9;
        return 2131566591;
    L9:
        if (r1 == 4) goto L11;
        return 2131566582;
    L11:
        return 2131566574;
    }

    @Override // jg0.c, jg0.f
    public void onDetach() {
        com.bytedance.android.live.liveinteract.revenue.common.vieweffect.b r0 = this.w;
        if (r0 == null) goto L12;
        ILinkPlayerInfoBridge r1 = J();
        if (r1 == null) goto L9;
        IBaseUser r2 = r1.getUser();
        if (r2 == null) goto L9;
        String r3 = r2.getIdString();
    L10:
        r0.b(r3);
        return;
    L9:
        r3 = null;
        goto L10
    }

    @Override // jg0.c
    public String p() {
        MicSeatScene r0 = this.b;
        int r1 = com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.guest.a.c[r0.ordinal()];
        if (r1 == 1) goto L15;
        if (r1 == 2) goto L19;
        if (r1 == 3) goto L18;
        if (r1 == 4) goto L17;
        return VerticalNitaInflate.Tag.MultiLinkAudioCommonGuestMicSeatBasicLayer.name();
    L17:
        return VerticalNitaInflate.Tag.MultiLinkAudioCommonEnlargeStageGuestMicSeatBasicLayer.name();
    L18:
        return VerticalNitaInflate.Tag.MultiLinkAudioCommonHamletAvatarGuestMicSeatBasicLayer.name();
    L19:
        return VerticalNitaInflate.Tag.MultiLinkAudioCommonCPositionGuestMicSeatBasicLayer.name();
    L15:
        return VerticalNitaInflate.Tag.MultiLinkAudioCommonLargeGuestMicSeatBasicLayer.name();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g
    public void r() {
        O(8);
        ILinkPlayerInfoBridge r1 = J();
        if (r1 == null) goto L5;
        IBaseUser r2 = r1.getUser();
    L6:
        int r3 = 0;
        if (r2 == null) goto L25;
        K(r2);
        MicSeatScene r4 = MicSeatScene.AUDIO_LINK;
        ILinkPlayerInfoBridge r5 = J();
        if (r5 != null) goto L11;
    L22:
        TextView r6 = this.k;
        if (r6 == null) goto L25;
        r6.setText(r2.getRealNickName());
        goto L25
    L11:
        if (r5.isBackground() != true) goto L22;
        ILinkPlayerInfoBridge r7 = J();
        if (r7 != null) goto L15;
    L16:
        TextView r8 = this.k;
        if (r8 == null) goto L19;
        r8.setText(2131918663);
    L19:
        O(0);
        MultiLinkMicSeatGiftIconElement r9 = this.m;
        if (r9 == null) goto L25;
        r9.e(8);
        goto L25
    L15:
        if (r7.getSilenceStatus() == 0) goto L22;
    L25:
        L(r2);
        ILinkPlayerInfoBridge r10 = J();
        if (r10 == null) goto L28;
        H(r10.getSilenceStatus());
    L28:
        MultiLinkMicSeatGiftIconElement r11 = this.m;
        if (r11 == null) goto L37;
        ILinkPlayerInfoBridge r12 = J();
        if (r12 != null) goto L33;
    L35:
        r3 = 8;
    L36:
        r11.e(r3);
        goto L37
    L33:
        if (r12.isOpenSendGift() != true) goto L35;
    L37:
        ILinkPlayerInfoBridge r13 = J();
        if (r13 == null) goto L41;
        String r14 = r13.getFanTicketDisplayStr();
        if (r14 == null) goto L41;
    L42:
        ILinkPlayerInfoBridge r15 = J();
        if (r15 == null) goto L48;
        IBaseUser r16 = r15.getUser();
        if (r16 == null) goto L48;
        String r17 = r16.getIdString();
        if (r17 == null) goto L48;
    L49:
        s(r14, r17);
        AnchorPauseTipsView r18 = this.j;
        if (r18 == null) goto L54;
        if (r18.getVisibility() != 0) goto L54;
    L55:
        MultiLinkMicSeatGiftIconElement r19 = this.m;
        if (r19 == null) goto L59;
        r19.e(8);
    L59:
        if (this.b != MicSeatScene.AUDIO_LINK_HAMLET_AVATAR) goto L71;
        ILinkPlayerInfoBridge r0 = J();
        if (r0 != null) goto L63;
    L67:
        View r20 = this.o;
        if (r20 == null) goto L74;
        UtilityKotlinExtentionsKt.t(r20);
        return;
    L74:
        return;
    L63:
        if (r0.isEnlarged() != true) goto L67;
        View r21 = this.o;
        if (r21 == null) goto L72;
        UtilityKotlinExtentionsKt.w(r21);
        return;
    L72:
        return;
    L71:
        return;
    L54:
        if (ThemedCompetitionContext.Companion.g() == false) goto L59;
    L48:
        r17 = "";
    L41:
        r14 = "0";
        goto L42
    L5:
        r2 = null;
        goto L6
    }

    public final boolean I() {
        ILinkPlayerInfoBridge r0 = J();
        py.k r1 = null;
        if (r0 == null) goto L7;
        Linkmic2DAvatar r2 = r0.getLinkmic2DAvatar();
        if (r2 == null) goto L7;
        Boolean r3 = r2.getEnableAvatar();
    L9:
        if (Intrinsics.areEqual(r3, Boolean.TRUE) == false) goto L17;
        ILinkPlayerInfoBridge r4 = J();
        if (r4 == null) goto L15;
        Linkmic2DAvatar r5 = r4.getLinkmic2DAvatar();
        if (r5 == null) goto L15;
        r1 = r5.getImage();
    L15:
        if (r1 == null) goto L17;
        return true;
    L17:
        return false;
    L7:
        r3 = null;
        goto L9
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g
    public final void v() {
        if (J() == null) goto L58;
        ILinkPlayerInfoBridge r0 = J();
        Intrinsics.checkNotNull(r0);
        if (com.bytedance.android.live.liveinteract.plantform.model.n.f(r0) == false) goto L66;
        HSImageView r1 = this.i;
        DraweeController r2 = null;
        if (r1 == null) goto L10;
        DraweeController r3 = r1.getController();
    L11:
        if (r3 == null) goto L59;
        HSImageView r4 = this.i;
        if (r4 == null) goto L40;
        DraweeController r5 = r4.getController();
        if (r5 == null) goto L40;
        Animatable r6 = r5.getAnimatable();
    L41:
        if (r6 == null) goto L63;
        HSImageView r7 = this.i;
        if (r7 == null) goto L47;
        DraweeController r8 = r7.getController();
        if (r8 == null) goto L47;
        Animatable r9 = r8.getAnimatable();
    L49:
        if ((r9 instanceof AnimatedDrawable2) == false) goto L64;
        HSImageView r10 = this.i;
        if (r10 == null) goto L53;
        r2 = r10.getController();
    L53:
        Intrinsics.checkNotNull(r2);
        AnimatedDrawable2 r11 = r2.getAnimatable();
        if (r11 == null) goto L57;
        AnimatedDrawable2 r12 = r11;
        r12.stop();
        r12.jumpToFrame(1);
        return;
    L57:
        throw new NullPointerException("null cannot be cast to non-null type com.facebook.fresco.animation.drawable.AnimatedDrawable2");
    L64:
        return;
    L47:
        r9 = null;
        goto L49
    L63:
        return;
    L40:
        r6 = null;
        goto L41
    L59:
        ILinkPlayerInfoBridge r13 = J();     // Catch: Exception -> L32
        Intrinsics.checkNotNull(r13);     // Catch: Exception -> L32
        kd1.b r14 = r13.getMicDress();     // Catch: Exception -> L32
        if (r14 == null) goto L22;
        kd1.c r15 = r14.getVoiceWave();     // Catch: Exception -> L32
        if (r15 == null) goto L22;
        py.k r16 = r15.getMediumImg();     // Catch: Exception -> L32
        if (r16 == null) goto L22;
        List r17 = r16.getUrls();     // Catch: Exception -> L32
        if (r17 == null) goto L22;
        String r18 = (String) ListProtector.get(r17, 0);     // Catch: Exception -> L32
    L23:
        a r19 = new a();
        PipelineDraweeControllerBuilder r20 = Fresco.newDraweeControllerBuilder().setUri(r18);
        HSImageView r21 = this.i;
        if (r21 == null) goto L26;
        r2 = r21.getController();
    L26:
        AbstractDraweeController r22 = r20.setOldController(r2).setControllerListener(r19).setAutoPlayAnimations(false).build();
        HSImageView r23 = this.i;
        if (r23 == null) goto L29;
        r23.setController(r22);
    L29:
        HSImageView r24 = this.i;
        if (r24 == null) goto L61;
        r24.setVisibility(0);
        return;
    L61:
        return;
    L22:
        r18 = null;
    L32:
        e = move-exception;
        ALogger.e(this.s, "get url fail. Exception type:".concat(e.getClass().getSimpleName()));
        return;
    L10:
        r3 = null;
        goto L11
    L66:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g
    public final com.bytedance.android.live.liveinteract.revenue.common.vieweffect.b w() {
        return this.w;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g
    public final void E(boolean r8) {
        boolean r0 = gh0.b.a;
        StringBuilder r1 = new StringBuilder("updateBackgroundStatus, isBackground = ");
        r1.append(r8);
        r1.append(", user = ");
        ILinkPlayerInfoBridge r2 = J();
        ch0.e r3 = null;
        if (r2 == null) goto L5;
        IBaseUser r4 = r2.getUser();
    L6:
        r1.append(r4);
        r1.append(", silenceStatus = ");
        ILinkPlayerInfoBridge r5 = J();
        if (r5 == null) goto L9;
        Integer r6 = Integer.valueOf(r5.getSilenceStatus());
    L10:
        r1.append(r6);
        int r7 = 0;
        gh0.b.a("AudioGuestLayer", r1.toString(), false);
        MultiLinkGuestViewBinder.a r9 = this.e;
        if (r9 == null) goto L99;
        ch0.e r10 = r9.k;
        if (r10 == null) goto L100;
        ILinkPlayerInfoBridge r11 = r10.a;
        if (r11 != null) goto L18;
        return;
    L18:
        if (r11.getSilenceStatus() == 0) goto L20;
        boolean r12 = true;
    L21:
        IBaseUser r13 = r11.getUser();
        if (r13 == null) goto L24;
        String r14 = r13.getIdString();
    L25:
        com.bytedance.live.datacontext.m r15 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r15 == null) goto L30;
        IRoom r16 = (IRoom) r15.getValue();
        if (r16 == null) goto L30;
        String r17 = r16.getOwnerUserIdString();
    L31:
        boolean r18 = Intrinsics.areEqual(r14, r17);
        if (je0.d.D() == true) goto L56;
        IVoiceChatAdminService.Companion.getClass();
        IVoiceChatAdminService r19 = IVoiceChatAdminService.a.a();
        if (r19 != null) goto L36;
    L38:
        if (r8 == true) goto L40;
        LayerBackgroundStatus r20 = LayerBackgroundStatus.Audio;
    L63:
        int r21 = com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.guest.a.a[r20.ordinal()];
        if (r21 != 1) goto L66;
        O(8);
        TextView r22 = this.k;
        if (r22 == null) goto L78;
        ILinkPlayerInfoBridge r23 = J();
        if (r23 == null) goto L76;
        IBaseUser r24 = r23.getUser();
        if (r24 == null) goto L76;
        String r25 = r24.getRealNickName();
    L77:
        r22.setText(r25);
    L76:
        r25 = null;
    L78:
        MultiLinkMicSeatGiftIconElement r26 = this.m;
        if (r26 == null) goto L88;
        ILinkPlayerInfoBridge r27 = J();
        if (r27 != null) goto L83;
    L85:
        r7 = 8;
    L86:
        r26.e(r7);
        goto L88
    L83:
        if (r27.isOpenSendGift() != true) goto L85;
    L88:
        if (ThemedCompetitionContext.Companion.g() == false) goto L92;
        MultiLinkMicSeatGiftIconElement r28 = this.m;
        if (r28 == null) goto L92;
        r28.e(8);
    L92:
        com.bytedance.android.live.liveinteract.revenue.common.vieweffect.b r29 = this.w;
        if (r29 == null) goto L101;
        MultiLinkGuestViewBinder.a r30 = this.e;
        if (r30 == null) goto L97;
        r3 = r30.k;
    L97:
        r29.g(r8, r3);
        return;
    L101:
        return;
    L66:
        if (r21 != 2) goto L92;
        M();
        goto L92
    L40:
        if (r11.getSilenceStatus() == 0) goto L48;
        IBaseUser r31 = r11.getUser();
        if (r31 == null) goto L44;
        String r32 = r31.getIdString();
    L46:
        if ((!Intrinsics.areEqual(r32, je0.d.b0())) == false) goto L48;
        boolean r33 = true;
    L49:
        if (r33 == true) goto L53;
        if (r18 == true) goto L53;
        r20 = LayerBackgroundStatus.Audio;
    L53:
        r20 = LayerBackgroundStatus.Leave;
        goto L63
    L44:
        r32 = null;
    L48:
        r33 = false;
        goto L49
    L36:
        if (r19.isEngineOn() != true) goto L38;
    L56:
        if (r11.isSelfBackground() == true) goto L58;
        r20 = LayerBackgroundStatus.Audio;
        goto L63
    L58:
        if (r12 == true) goto L62;
        if (r18 == true) goto L62;
        r20 = LayerBackgroundStatus.Audio;
    L62:
        r20 = LayerBackgroundStatus.Leave;
    L30:
        r17 = null;
        goto L31
    L24:
        r14 = null;
        goto L25
    L20:
        r12 = false;
        goto L21
    L100:
        return;
    L99:
        return;
    L9:
        r6 = null;
        goto L10
    L5:
        r4 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g
    public void H(int r8) {
        int r0 = com.bytedance.android.live.liveinteract.revenue.linkroomfight.ui.a.a;
        MultiLinkGuestViewBinder.a r1 = this.e;
        if (r1 == null) goto L5;
        int r2 = r1.a;
    L7:
        if (com.bytedance.android.live.liveinteract.revenue.linkroomfight.ui.a.C0094a.d(Integer.valueOf(r2)) == true) goto L15;
        Map.Entry r3 = tc0.c.h().p;
        if (r3 == null) goto L15;
        g2 r4 = (g2) r3.getValue();
        if (r4 == null) goto L15;
        boolean r5 = true;
        if (r4.getRoomLinkSilenceStatus() != 1) goto L15;
    L17:
        if (r5 == false) goto L26;
        Drawable r9 = s1.m(2131251753);
        Context r6 = q().getContext();
        Context r7 = q().getContext();
        TextView r10 = this.k;
        if (r10 == null) goto L21;
        float r11 = r10.getTextSize();
    L22:
        int r12 = (int) UIUtils.dip2Px(r6, UIUtils.px2dip(r7, r11) + 2.0f);
        r9.setBounds(0, 0, r12, r12);
        TextView r13 = this.k;
        if (r13 == null) goto L25;
        r13.setCompoundDrawables(r9, null, null, null);
    L25:
        D();
        return;
    L21:
        r11 = UtilityKotlinExtentionsKt.m(12);
        goto L22
    L26:
        if (r8 == 0) goto L35;
        Drawable r14 = s1.m(2131251871);
        Context r15 = q().getContext();
        Context r16 = q().getContext();
        TextView r17 = this.k;
        if (r17 == null) goto L30;
        float r18 = r17.getTextSize();
    L31:
        int r19 = (int) UIUtils.dip2Px(r15, UIUtils.px2dip(r16, r18) + 2.0f);
        r14.setBounds(0, 0, r19, r19);
        TextView r20 = this.k;
        if (r20 == null) goto L34;
        r20.setCompoundDrawables(r14, null, null, null);
    L34:
        D();
        return;
    L30:
        r18 = UtilityKotlinExtentionsKt.m(12);
        goto L31
    L35:
        TextView r21 = this.k;
        if (r21 == null) goto L41;
        r21.setCompoundDrawables(null, null, null, null);
        return;
    L41:
        return;
    L15:
        r5 = false;
        goto L17
    L5:
        r2 = -1;
        goto L7
    }

    public void K(IBaseUser r5) {
        Intrinsics.checkNotNullParameter(r5, "curUser");
        xg0.a r0 = this.c;
        if (r0 == null) goto L15;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.m r1 = r0.getLinkWindowLayoutConfig();
        if (r1 == null) goto L15;
        if (r1.getUiLayout() != 27) goto L15;
        xg0.a r2 = this.c;
        if (r2 == null) goto L15;
        if (r2.getFeedType() != 5) goto L15;
        if (I() == false) goto L15;
        boolean r3 = false;
    L16:
        if (r3 == false) goto L18;
        return;
    L18:
        if (this.x.getUiLayout() != 24) goto L20;
        ImageUtil.loadRoundImageAntiFlink(this.h, je0.d.n(r5, AvatarType.AVATAR_MEDIUM.getValue()), 0);
        return;
    L20:
        ImageUtil.loadRoundImageAntiFlink(this.h, je0.d.n(r5, AvatarType.AVATAR_THUMB.getValue()), 0);
        return;
    L15:
        r3 = I();
        goto L16
    }

    public final void L(IBaseUser r8) {
        boolean r2 = true;
        if (this.x.getUiLayout() != 28) goto L5;
        boolean r0 = true;
    L6:
        if (r8 != null) goto L8;
    L14:
        boolean r1 = false;
    L15:
        String r4 = null;
        if (r8 == null) goto L18;
        String r5 = r8.getIdString();
    L19:
        IRoom r6 = je0.d.e(null);
        if (r6 == null) goto L22;
        String r7 = r6.getOwnerUserIdString();
    L24:
        if (Intrinsics.areEqual(r5, r7) == false) goto L29;
        if (r8 == null) goto L27;
        r4 = r8.getIdString();
    L27:
        if (r4 == null) goto L29;
    L31:
        if (r0 == true) goto L53;
        if (n() <= 0) goto L38;
        if (r1 == false) goto L38;
        View r3 = this.l;
        if (r3 == null) goto L49;
        r3.setVisibility(8);
    L49:
        View r9 = this.l;
        if (r9 == null) goto L72;
        r9.setBackgroundResource(2131250855);
        return;
    L72:
        return;
    L38:
        if (r1 == false) goto L46;
        ILinkPlayerInfoBridge r10 = J();
        if (r10 == null) goto L46;
        if (r10.isEnlarged() == true) goto L46;
        View r11 = this.l;
        if (r11 == null) goto L49;
        r11.setVisibility(0);
    L46:
        View r12 = this.l;
        if (r12 == null) goto L49;
        r12.setVisibility(8);
        goto L49
    L53:
        if (n() != 0) goto L74;
        if (r1 == false) goto L61;
        View r13 = this.l;
        if (r13 == null) goto L58;
        r13.setVisibility(0);
    L58:
        View r14 = this.l;
        if (r14 == null) goto L75;
        r14.setBackgroundResource(2131250855);
        return;
    L75:
        return;
    L61:
        if (r2 == false) goto L68;
        View r15 = this.l;
        if (r15 == null) goto L65;
        r15.setBackgroundResource(2131250856);
    L65:
        View r16 = this.l;
        if (r16 == null) goto L77;
        r16.setVisibility(0);
        return;
    L77:
        return;
    L68:
        View r17 = this.l;
        if (r17 == null) goto L79;
        r17.setVisibility(8);
        return;
    L79:
        return;
    L74:
        return;
    L29:
        r2 = false;
        goto L31
    L22:
        r7 = null;
        goto L24
    L18:
        r5 = null;
        goto L19
    L8:
        if (r8.getUserAttr() == null) goto L14;
        t r18 = r8.getUserAttr();
        if (r18 == null) goto L14;
        if (r18.isAdmin() != true) goto L14;
        r1 = true;
        goto L15
    L5:
        r0 = false;
        goto L6
    }

    public final void N(boolean r5) {
        MultiLinkGuestViewBinder.a r0 = this.e;
        tf0.d r1 = null;
        if (r0 == null) goto L7;
        HashMap<String, tf0.d> r2 = r0.i;
        if (r2 == null) goto L7;
        tf0.d r3 = r2.get(SeatItemId.SEAT_WIDGET.name());
    L9:
        if ((r3 instanceof nh0.m) == false) goto L12;
        r1 = r3;
    L12:
        nh0.m r4 = (nh0.m) r1;
        MultiLinkGuestViewBinder.a r6 = this.e;
        if (r6 == null) goto L19;
        ch0.e r7 = r6.k;
        if (r7 == null) goto L19;
        if (ch0.f.b(r7) != true) goto L19;
        boolean r8 = true;
    L20:
        if (r5 == false) goto L24;
        com.bytedance.android.live.liveinteract.revenue.common.vieweffect.b r9 = this.w;
        if (r9 == null) goto L28;
        r9.c(r4, r8, true);
        return;
    L28:
        return;
    L24:
        com.bytedance.android.live.liveinteract.revenue.common.vieweffect.b r10 = this.w;
        if (r10 == null) goto L30;
        r10.c(r4, r8, false);
        return;
    L30:
        return;
    L19:
        r8 = false;
    L7:
        r3 = null;
        goto L9
    }

    public void O(int r2) {
        AnchorPauseTipsView r0 = this.j;
        if (r0 == null) goto L6;
        r0.setVisibility(r2);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g, jg0.c, jg0.f
    public void a(Context r9) {
        Intrinsics.checkNotNullParameter(r9, "context");
        super.a(r9);
        this.t = q().findViewById(2131389566);
        new j22.c(this.i);
        com.bytedance.android.live.liveinteract.revenue.common.vieweffect.b r10 = new com.bytedance.android.live.liveinteract.revenue.common.vieweffect.b(q(), null, je0.d.r(), this.c);
        this.w = r10;
        MultiLinkMicSeatGiftIconElement r0 = this.m;
        if (r0 == null) goto L5;
        LinkMicQuickInteractView r1 = r0.c;
    L6:
        r10.e = r1;
        r10.f = null;
        boolean r11 = r.a;
        if (r.l() == false) goto L9;
        this.v = new com.bytedance.android.live.liveinteract.revenue.common.vieweffect.d(this.b, q(), null, je0.d.r(), true, this.c, 16);
    L9:
        this.o = q().findViewById(2131389545);
        this.p = q().findViewById(2131389567);
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g
    public final void c(d6 r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        if ((r3 instanceof d6.a) == false) goto L14;
        wj0.b r4 = ((d6.a) r3).a;
        if (r4 == null) goto L15;
        TalkRoomBaseDynamicEmoji r0 = r4.b;
        if (r0 != null) goto L9;
        return;
    L9:
        if (r0.isRandomEmoji != true) goto L17;
        xg0.a r1 = this.c;
        if (r1 == null) goto L18;
        r1.N0(ag1.b.b(r4));
        return;
    L18:
        return;
    L17:
        return;
    L15:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g, jg0.c, jg0.f
    public void j(Context r6) {
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r6, "context");
        gh0.b.a("audio_layer_update", "MultiLinkAudioCommonGuestMicSeatBasicLayer#onViewCreated", false);
        if (n() != 1) goto L5;
    L20:
        TextView r7 = this.k;
        if (r7 == null) goto L23;
        r7.setTextSize(2, 6.0f);
    L23:
        View r8 = this.l;
        if (r8 == null) goto L26;
        r8.setScaleX(0.6f);
    L26:
        View r9 = this.l;
        if (r9 == null) goto L29;
        r9.setScaleY(0.6f);
    L29:
        UIUtils.setViewVisibility(this.i, 0);
        AnchorPauseTipsView r10 = this.j;
        if (r10 == null) goto L37;
        r10.R5();
        if (this.b != MicSeatScene.AUDIO_LINK) goto L34;
        float r0 = 10.0f;
    L35:
        AnchorPauseTipsView.U5(r10, r0);
        r10.c = true;
        r10.d = 0;
        r10.requestLayout();
        return;
    L34:
        r0 = 14.0f;
        goto L35
    L37:
        return;
    L5:
        if (n() == 9) goto L20;
        if (LinkFeedTypeConstant.Companion.isHotsoonFollowAndCity(n()) == true) goto L20;
        if (n() != 5) goto L29;
        TextView r11 = this.k;
        if (r11 == null) goto L14;
        r11.setTextSize(2, 7.0f);
    L14:
        View r12 = this.l;
        if (r12 == null) goto L17;
        r12.setScaleX(0.6f);
    L17:
        View r13 = this.l;
        if (r13 == null) goto L29;
        r13.setScaleY(0.6f);
        goto L29
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g
    public void A(MultiLinkGuestViewBinder.a r7, int r8) {
        Intrinsics.checkNotNullParameter(r7, "itemData");
        super.A(r7, r8);
        AnchorPauseTipsView r9 = this.j;
        if (r9 == null) goto L10;
        if (r9.getVisibility() != 0) goto L10;
        MultiLinkMicSeatGiftIconElement r10 = this.m;
        if (r10 == null) goto L10;
        r10.e(8);
    L10:
        if (J() == null) goto L61;
        ILinkPlayerInfoBridge r11 = J();
        String r1 = null;
        if (r11 == null) goto L17;
        IBaseUser r12 = r11.getUser();
        if (r12 == null) goto L17;
        String r13 = r12.getIdString();
    L18:
        ILinkPlayerInfoBridge r2 = J();
        if (r2 == null) goto L25;
        kd1.b r3 = r2.getMicDress();
        if (r3 == null) goto L25;
        kd1.c r4 = r3.getVoiceWave();
        if (r4 == null) goto L25;
        String r5 = r4.getDressId();
    L26:
        com.bytedance.live.datacontext.m r6 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r6 == null) goto L29;
        IRoom r14 = (IRoom) r6.getValue();
    L30:
        HashSet<String> r15 = this.u;
        if (r15 != null) goto L33;
    L34:
        ILinkPlayerInfoBridge r16 = J();
        Intrinsics.checkNotNull(r16);
        if (com.bytedance.android.live.liveinteract.plantform.model.n.f(r16) == false) goto L61;
        if (this.x.getUiLayout() != 21) goto L56;
        ILinkPlayerInfoBridge r17 = J();
        if (r17 == null) goto L43;
        IBaseUser r18 = r17.getUser();
        if (r18 == null) goto L43;
        String r19 = r18.getIdString();
    L44:
        if (r19 == null) goto L56;
        ILinkPlayerInfoBridge r20 = J();
        if (r20 == null) goto L50;
        IBaseUser r21 = r20.getUser();
        if (r21 == null) goto L50;
        String r22 = r21.getIdString();
    L51:
        if (r14 == null) goto L54;
        r1 = r14.getOwnerUserIdString();
    L54:
        if (Intrinsics.areEqual(r22, r1) == false) goto L56;
    L50:
        r22 = null;
    L43:
        r19 = null;
    L56:
        if (r13 == null) goto L61;
        if (r5 == null) goto L61;
        dk0.b.a(r13, r5);
        HashSet<String> r23 = this.u;
        if (r23 == null) goto L61;
        r23.add(r13);
        goto L61
    L33:
        if (CollectionsKt.contains(r15, r13) == true) goto L61;
    L29:
        r14 = null;
    L25:
        r5 = null;
    L17:
        r13 = null;
    L61:
        com.bytedance.android.live.liveinteract.revenue.common.vieweffect.b r24 = this.w;
        if (r24 == null) goto L65;
        r24.d = Integer.valueOf(r8);
    L65:
        if (n() != 0) goto L74;
        View r25 = this.t;
        if (r25 == null) goto L69;
        r25.setOnClickListener(x0.a(new MultiLinkAudioCommonGuestMicSeatBasicLayer$onBind$1(this)));
    L69:
        MultiLinkMicSeatGiftIconElement r26 = this.m;
        if (r26 == null) goto L74;
        View.OnClickListener r27 = x0.a(new MultiLinkAudioCommonGuestMicSeatBasicLayer$onBind$2(this));
        Intrinsics.checkNotNullParameter(r27, "clickListener");
        LinkMicQuickInteractView r28 = r26.c;
        if (r28 == null) goto L74;
        r28.setOnClickListener(r27);
    L74:
        View r29 = this.t;
        if (r29 == null) goto L77;
        r29.setImportantForAccessibility(2);
    L77:
        MultiLinkGuestViewBinder.a r30 = this.e;
        if (r30 == null) goto L86;
        ch0.e r31 = r30.k;
        if (r31 == null) goto L86;
        ILinkPlayerInfoBridge r32 = r31.a;
        if (r32 == null) goto L86;
        if (r32.isBackground() != true) goto L86;
        boolean r33 = true;
    L87:
        E(r33);
        N(true);
        P(r8, true);
        com.bytedance.android.live.liveinteract.revenue.fight.b r34 = ((IInteractService) jc1.k.n(IInteractService.class)).teamFightService();
        if (r34 == null) goto L91;
        r34.F1(this, SceneType.SCENE_AUDIO_TALKROOM);
    L91:
        if (aj0.a.d() == false) goto L94;
        int r35 = com.bytedance.android.live.liveinteract.revenue.linkroomfight.ui.a.a;
        com.bytedance.android.live.liveinteract.revenue.linkroomfight.ui.a.C0094a.g(this, r8);
        return;
    L94:
        return;
    L86:
        r33 = false;
        goto L87
    }

    public final void P(int r3, boolean r4) {
        if (r4 == false) goto L6;
        com.bytedance.android.live.liveinteract.revenue.common.vieweffect.d r5 = this.v;
        if (r5 == null) goto L6;
        ALogger.w("RandomEmojiManager", "reset隐藏");
        r5.k.setVisibility(8);
    L6:
        com.bytedance.android.live.liveinteract.revenue.common.vieweffect.d r6 = this.v;
        if (r6 == null) goto L21;
        MultiLinkGuestViewBinder.a r0 = this.e;
        if (r0 == null) goto L17;
        ch0.e r1 = r0.k;
        if (r1 == null) goto L17;
        ILinkPlayerInfoBridge r2 = r1.a;
        if (r2 == null) goto L17;
        boolean r7 = true;
        if (r2.isEnlarged() != true) goto L17;
    L18:
        r6.g = r7;
        String r8 = r6.f;
        if (r8 == null) goto L21;
        r6.b(Intrinsics.areEqual(r6.c(), r8));
    L17:
        r7 = false;
    L21:
        MultiLinkGuestViewBinder.a r9 = this.e;
        tf0.d r10 = null;
        if (r9 == null) goto L26;
        HashMap<String, tf0.d> r11 = r9.i;
        if (r11 == null) goto L26;
        tf0.d r12 = r11.get(SeatItemId.RANDOM_EMOJI.name());
    L28:
        if ((r12 instanceof nh0.i) == false) goto L31;
        r10 = r12;
    L31:
        nh0.i r13 = (nh0.i) r10;
        com.bytedance.android.live.liveinteract.revenue.common.vieweffect.d r14 = this.v;
        if (r14 == null) goto L35;
        r14.d(r3, r13);
        return;
    L35:
        return;
    L26:
        r12 = null;
        goto L28
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g, jg0.f
    public /* bridge */ /* synthetic */ void d(MultiLinkGuestViewBinder.a r1, int r2) {
        A(r1, r2);
    }

    public MultiLinkAudioCommonGuestMicSeatBasicLayer(MicSeatScene r2, com.bytedance.android.live.liveinteract.plantform.commonwindow.m r3, xg0.a r4) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        Intrinsics.checkNotNullParameter(r3, "layoutConfig");
        super(r2, r4);
        this.x = r3;
        this.s = "MultiLinkAudioCommonGuestMicSeatBasicLayer";
        this.u = new HashSet();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g
    public void B(MultiLinkGuestViewBinder.a r3, int r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "itemData");
        Intrinsics.checkNotNullParameter(r5, "payload");
        super.B(r3, r4, r5);
        Iterator<String> r6 = r5.keySet().iterator();
    L4:
        if (r6.hasNext() == false) goto L31;
        String r7 = r6.next();
        if (r7 == null) goto L4;
        switch(r7.hashCode()) {
            case -201720105: goto L29;
            case 1713471578: goto L27;
            case 1785634268: goto L15;
            case 2069147793: goto L12;
            default: goto L4;
        };
    L12:
        if (r7.equals("payload_key_dynamic_data_update_for_seat_random_emoji_info") == false) goto L4;
        P(r4, false);
        goto L4
    L15:
        if (r7.equals("payload_key_user_admin_update") == false) goto L4;
        if (J() == null) goto L4;
        ILinkPlayerInfoBridge r8 = J();
        IBaseUser r0 = null;
        if (r8 == null) goto L21;
        IBaseUser r9 = r8.getUser();
    L22:
        if (r9 == null) goto L4;
        ILinkPlayerInfoBridge r10 = J();
        if (r10 == null) goto L26;
        r0 = r10.getUser();
    L26:
        L(r0);
        goto L4
    L21:
        r9 = null;
        goto L22
    L27:
        r7.equals("payload_key_is_seat_anim_action_update");
        goto L4
    L29:
        if (r7.equals("payload_key_dynamic_data_update_for_seat_widget_info") == false) goto L4;
        N(false);
        goto L4
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g, jg0.f
    public /* bridge */ /* synthetic */ void k(MultiLinkGuestViewBinder.a r1, int r2, Bundle r3) {
        B(r1, r2, r3);
    }
}
