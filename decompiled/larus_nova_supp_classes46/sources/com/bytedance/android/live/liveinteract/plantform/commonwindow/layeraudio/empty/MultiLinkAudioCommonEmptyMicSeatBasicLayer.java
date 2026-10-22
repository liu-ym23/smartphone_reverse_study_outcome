package com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.empty;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.base.MicSeatScene;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.m;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkNormalEmptyViewBinder;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.plantform.utils.i0;
import com.bytedance.android.live.liveinteract.playmode.SceneType;
import com.bytedance.android.live.liveinteract.pre.VerticalNitaInflate;
import com.bytedance.android.live.liveinteract.revenue.fight.TeamFightContext;
import com.bytedance.android.live.liveinteract.revenuebase.MultiRevenueDataContext;
import com.bytedance.android.live.liveinteract.videotalk.themecompetition.ThemedCompetitionContext;
import com.bytedance.android.live.liveinteract.view.PositionNameTv;
import com.bytedance.android.live.liveinteract.voicechat.s;
import com.bytedance.android.live.liveinteract.voicechat.wm.RoundRectLayoutWrapContent;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import com.bytedance.android.livesdkapi.interact.data.LinkFeedTypeConstant;
import com.bytedance.common.utility.UIUtils;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class MultiLinkAudioCommonEmptyMicSeatBasicLayer extends com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.empty.b {
    public HSImageView q;
    public final boolean r;
    public boolean s;
    public final m t;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ MultiLinkAudioCommonEmptyMicSeatBasicLayer a;

        public a(MultiLinkAudioCommonEmptyMicSeatBasicLayer r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Long r3 = (Long) r2;
            this.a.C(true);
        }
    }

    public final void A() {
        re0.b r0 = this.d;
        if ((r0 instanceof se0.c) == true) goto L5;
        return;
    L5:
        if (r0 == null) goto L29;
        se0.b r1 = ((se0.c) r0).a;
        Integer r2 = null;
        if (r1 == null) goto L9;
        String r3 = r1.b;
    L11:
        if (r2.a(r3) == false) goto L15;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.dynamicelement.b r4 = this.i;
        if (r4 == null) goto L15;
        r4.g(r3);
    L15:
        re0.b r5 = this.d;
        if (r5 == null) goto L27;
        se0.b r6 = ((se0.c) r5).a;
        if (r6 == null) goto L20;
        r2 = Integer.valueOf(r6.a);
    L20:
        if (r2 != null) goto L22;
        return;
    L22:
        if (r2.intValue() <= 0) goto L32;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.dynamicelement.b r7 = this.i;
        if (r7 == null) goto L33;
        r7.d(r2.intValue());
        return;
    L33:
        return;
    L32:
        return;
    L27:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.feed.layerconfig.audio.AudioFeedLayerUIConfig");
    L9:
        r3 = null;
        goto L11
    L29:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.feed.layerconfig.audio.AudioFeedLayerUIConfig");
    }

    @Override // jg0.c
    public final int o() {
        MicSeatScene r0 = this.b;
        switch(com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.empty.a.a[r0.ordinal()]) {
            case 1: goto L9;
            case 2: goto L8;
            case 3: goto L8;
            case 4: goto L7;
            case 5: goto L6;
            case 6: goto L5;
            default: goto L4;
        };
    L4:
        return 0;
    L5:
        return 2131566571;
    L6:
        return 2131566573;
    L7:
        return 2131566588;
    L8:
        return 2131566570;
    L9:
        return 2131566579;
    }

    @Override // jg0.c
    public final String p() {
        MicSeatScene r0 = this.b;
        switch(com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.empty.a.b[r0.ordinal()]) {
            case 1: goto L10;
            case 2: goto L15;
            case 3: goto L15;
            case 4: goto L14;
            case 5: goto L13;
            case 6: goto L12;
            default: goto L4;
        };
    L4:
        return "";
    L12:
        return VerticalNitaInflate.Tag.MultiLinkAudioCommonLargeEmptyBasicLayer.name();
    L13:
        return VerticalNitaInflate.Tag.MultiLinkAudioCommonEnlargeStageEmptyBasicLayer.name();
    L14:
        return VerticalNitaInflate.Tag.MultiLinkAudioCommonHamletEmptyBasicLayer.name();
    L15:
        return VerticalNitaInflate.Tag.MultiLinkAudioCommonEmptyBasicLayer.name();
    L10:
        return VerticalNitaInflate.Tag.MultiLinkAudioCommonCPositionEmptyBasicLayer.name();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.empty.b
    public final int s() {
        if (this.b != MicSeatScene.AUDIO_LINK_LARGE) goto L5;
        return 2131251088;
    L5:
        return 2131251087;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.empty.b
    public final com.bytedance.android.live.liveinteract.a t() {
        return new s(q());
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.empty.b
    public final void v() {
        if (this.r == true) goto L5;
        return;
    L5:
        MultiLinkNormalEmptyViewBinder.a r0 = this.e;
        if (r0 == null) goto L8;
        IVoiceLiveTheme r1 = r0.c;
    L9:
        if (r1 != null) goto L11;
        return;
    L11:
        if (je0.d.r() == false) goto L13;
        return;
    L13:
        if (r1.isUgcImage() == false) goto L15;
    L26:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.dynamicelement.b r2 = this.i;
        if (r2 == null) goto L29;
        r2.d(s());
    L29:
        A();
        return;
    L15:
        if (IVoiceLiveTheme.Companion.isImageModelValid(r1.getSeatIcon()) == false) goto L26;
        UIUtils.setViewVisibility(this.h, 8);
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.dynamicelement.b r3 = this.i;
        if (r3 == null) goto L19;
        r3.e(0);
    L19:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.dynamicelement.b r4 = this.i;
        if (r4 == null) goto L33;
        k r5 = r1.getSeatIcon();
        r4.f = r5;
        if (r5 != null) goto L24;
        return;
    L24:
        if (r4.a() == false) goto L35;
        ImageUtil.loadImage(r4.j, r5, 0);
        return;
    L35:
        return;
    L33:
        return;
    L8:
        r1 = null;
        goto L9
    }

    public final void z() {
        HSImageView r0 = this.q;
        int r1 = 0;
        if (r0 != null) goto L5;
    L7:
        AbstractDraweeController r2 = Fresco.newDraweeControllerBuilder().setUri("https://lf3-webcastcdn-tos.douyinstatic.com/obj/live-android/voice_chat_guide.webp").setAutoPlayAnimations(true).build();
        HSImageView r3 = this.q;
        if (r3 == null) goto L10;
        r3.setController(r2);
    L10:
        UIUtils.setViewVisibility(this.q, 0);
        hd0.c.f().getClass();
    L12:
        if (ThemedCompetitionContext.Companion.g() == false) goto L14;
    L26:
        CompositeDisposable r4 = this.o;
        if (r4 == null) goto L30;
        r4.add(Observable.timer(((long) vm2.d.T()) * 1000, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(this)));
        return;
    L30:
        return;
    L14:
        if (je0.d.r() == true) goto L26;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.dynamicelement.b r5 = this.i;
        if (r5 == null) goto L18;
        r5.g(s1.B(2131919822));
    L18:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.dynamicelement.b r6 = this.i;
        if (r6 == null) goto L26;
        String r7 = r6.c();
        if (r7 == null) goto L26;
        Integer r8 = this.n;
        if (r8 == null) goto L25;
        r1 = r8.intValue();
    L25:
        r3.c(q(), (r1 + 1) + s1.B(2131920341) + r7, true);
        goto L26
    L5:
        if (r0.getVisibility() != 0) goto L7;
        goto L7
    }

    public final void D() {
        View r0 = q().findViewById(2131374117);
        if (r0 == null) goto L6;
        r0.post(new b(this, r0));
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.empty.b, jg0.c, jg0.f
    public final void onDetach() {
        super.onDetach();
        C(false);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.empty.b
    public final void r() {
        if (n() != 1) goto L5;
    L14:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.dynamicelement.b r0 = this.i;
        if (r0 == null) goto L17;
        r0.k.setTextSize(2, 6.0f);
    L17:
        D();
        return;
    L5:
        if (n() == 9) goto L14;
        if (LinkFeedTypeConstant.Companion.isHotsoonFollowAndCity(n()) == true) goto L14;
        if (n() != 5) goto L17;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.dynamicelement.b r1 = this.i;
        if (r1 == null) goto L17;
        r1.k.setTextSize(1, 7.0f);
        goto L17
    }

    public final void B(MultiLinkNormalEmptyViewBinder.a r6) {
        Intrinsics.checkNotNullParameter(r6, "itemData");
        if (this.b != MicSeatScene.AUDIO_LINK_LARGE) goto L44;
        if (TeamFightContext.Companion.h() == false) goto L26;
        if (li0.d.g(null) == false) goto L26;
        if (this.n == null) goto L26;
        if (r6.h() == false) goto L15;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.dynamicelement.b r7 = this.i;
        if (r7 == null) goto L65;
        r7.g(s1.B(2131922790));
    L65:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.dynamicelement.b r8 = this.i;
        if (r8 == null) goto L74;
        String r9 = r8.c();
        if (r9 == null) goto L74;
        Integer r0 = this.n;
        if (r0 == null) goto L72;
        int r1 = r0.intValue();
    L73:
        r3.c(q(), (r1 + 1) + s1.B(2131920341) + r9, true);
        goto L74
    L72:
        r1 = 0;
    L74:
        A();
        return;
    L15:
        Integer r10 = this.n;
        Intrinsics.checkNotNull(r10);
        int r11 = li0.d.b(r10.intValue());
        if (r11 != 1) goto L21;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.dynamicelement.b r12 = this.i;
        if (r12 == null) goto L65;
        r12.g(s1.B(2131920070));
        goto L65
    L21:
        if (r11 != 2) goto L65;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.dynamicelement.b r13 = this.i;
        if (r13 == null) goto L65;
        r13.g(s1.B(2131920069));
    L26:
        if (gh0.a.d() == true) goto L33;
        com.bytedance.android.live.liveinteract.api.data.a.h.getClass();
        if (com.bytedance.android.live.liveinteract.api.data.a.C0017a.a().c == false) goto L33;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.dynamicelement.b r14 = this.i;
        if (r14 == null) goto L65;
        r14.g(s1.B(2131919824));
    L33:
        if (r6.h() == false) goto L35;
    L40:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.dynamicelement.b r15 = this.i;
        if (r15 == null) goto L65;
        r15.g(s1.B(2131919821));
        goto L65
    L35:
        if (je0.d.D() == true) goto L40;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.dynamicelement.b r16 = this.i;
        if (r16 == null) goto L65;
        r16.g(s1.B(2131919833));
        goto L65
    L44:
        if (gh0.a.d() == true) goto L51;
        com.bytedance.android.live.liveinteract.api.data.a.h.getClass();
        if (com.bytedance.android.live.liveinteract.api.data.a.C0017a.a().c == false) goto L51;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.dynamicelement.b r17 = this.i;
        if (r17 == null) goto L65;
        r17.g(s1.B(2131919824));
    L51:
        if (r6.h() == false) goto L55;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.dynamicelement.b r18 = this.i;
        if (r18 == null) goto L65;
        r18.g(s1.B(2131919823));
        goto L65
    L55:
        MultiRevenueDataContext.Companion.getClass();
        com.bytedance.android.live.liveinteract.revenuebase.a r19 = MultiRevenueDataContext.a.a();
        if (r19 != null) goto L58;
    L62:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.dynamicelement.b r20 = this.i;
        if (r20 == null) goto L65;
        r20.g(s1.B(2131919833));
        goto L65
    L58:
        if (r19.isGameShowing() != true) goto L62;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.dynamicelement.b r21 = this.i;
        if (r21 == null) goto L65;
        r21.g(s1.B(2131917241));
        goto L65
    }

    public final void C(boolean r5) {
        HSImageView r0 = this.q;
        if (r0 == null) goto L5;
        r0.setController(null);
    L5:
        UIUtils.setViewVisibility(this.q, 4);
        if (ThemedCompetitionContext.Companion.g() == true) goto L31;
        if (r5 == false) goto L14;
        if (je0.d.r() == true) goto L32;
        MultiLinkNormalEmptyViewBinder.a r6 = this.e;
        if (r6 == null) goto L33;
        B(r6);
        return;
    L33:
        return;
    L32:
        return;
    L14:
        if (je0.d.r() == false) goto L27;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.dynamicelement.b r7 = this.i;
        if (r7 == null) goto L18;
        r7.g(s1.B(2131919821));
    L18:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.dynamicelement.b r8 = this.i;
        if (r8 == null) goto L35;
        String r9 = r8.c();
        if (r9 == null) goto L36;
        Integer r1 = this.n;
        if (r1 == null) goto L25;
        int r2 = r1.intValue();
    L26:
        r3.c(q(), (r2 + 1) + s1.B(2131920341) + r9, true);
        return;
    L25:
        r2 = 0;
        goto L26
    L36:
        return;
    L35:
        return;
    L27:
        MultiLinkNormalEmptyViewBinder.a r10 = this.e;
        if (r10 == null) goto L38;
        B(r10);
        return;
    L38:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.empty.b, jg0.c, jg0.f
    public final void a(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super.a(r2);
        PositionNameTv r3 = this.j;
        if (r3 == null) goto L5;
        r3.F("#80000000");
    L5:
        RoundRectLayoutWrapContent r4 = (RoundRectLayoutWrapContent) q().findViewById(2131384852);
        this.q = q().findViewById(2131389461);
        HSImageView r5 = q().findViewById(2131389607);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.empty.b, jg0.f
    public final /* bridge */ /* synthetic */ void d(Object r1, int r2) {
        w((MultiLinkNormalEmptyViewBinder.a) r1, r2);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.empty.b
    public final void w(final MultiLinkNormalEmptyViewBinder.a r7, final int r8) {
        Intrinsics.checkNotNullParameter(r7, "itemData");
        super.w(r7, r8);
        if (gh0.a.d() == true) goto L10;
        if (this.t.getUiLayout() != 26) goto L10;
        if (this.s == true) goto L10;
        this.s = true;
        i0 r0 = TalkRoomLogUtils.a;
        TalkRoomLogUtils.M(r8);
    L10:
        if (n() != 0) goto L15;
        View r1 = this.g;
        if (r1 == null) goto L15;
        r1.setOnClickListener(x0.a(new MultiLinkAudioCommonEmptyMicSeatBasicLayer$onBind$1(this, r7, r8)));
    L15:
        if (je0.d.D() == false) goto L59;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.dynamicelement.b r2 = this.i;
        if (r2 == null) goto L19;
        r2.g(s1.B(2131919821));
    L19:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.dynamicelement.b r3 = this.i;
        if (r3 == null) goto L29;
        String r4 = r3.c();
        if (r4 == null) goto L29;
        Integer r5 = this.n;
        if (r5 == null) goto L26;
        int r6 = r5.intValue();
    L27:
        r3.c(q(), (r6 + 1) + s1.B(2131920341) + r4, true);
        goto L29
    L26:
        r6 = 0;
    L29:
        if (this.b == MicSeatScene.AUDIO_LINK_LARGE) goto L38;
        com.bytedance.android.live.liveinteract.voicechat.d.s0.getClass();
        com.bytedance.android.live.liveinteract.voicechat.d r9 = com.bytedance.android.live.liveinteract.voicechat.d.a.a();
        if (r9 == null) goto L38;
        ILinkPlayerInfoBridge r10 = r9.currentCPositionUser();
        if (r10 == null) goto L38;
        if (r8 >= r10.getUserPosition()) goto L38;
        int r11 = r8;
    L39:
        IInteractService r12 = (IInteractService) jc1.k.n(IInteractService.class);
        Integer r13 = je0.d.h();
        if (r13 == null) goto L42;
        int r14 = r13.intValue();
    L44:
        if (r12.isVoiceMultiEnlargeSeat(r14, r8) == false) goto L49;
        TextView r15 = this.h;
        if (r15 == null) goto L56;
        r15.setText(s1.B(2131919275));
    L56:
        UIUtils.setViewVisibility(this.h, 0);
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.dynamicelement.b r16 = this.i;
        if (r16 == null) goto L66;
        r16.e(8);
    L66:
        UIUtils.setViewVisibility(this.k, 4);
        if (je0.d.r() == true) goto L69;
        v();
    L69:
        y();
        if (r7.i() == false) goto L83;
        if (gh0.a.d() == false) goto L74;
    L79:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.dynamicelement.b r17 = this.i;
        if (r17 == null) goto L83;
        r17.g(s1.B(2131922884));
        goto L83
    L74:
        if (r7.h() == true) goto L79;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.dynamicelement.b r18 = this.i;
        if (r18 == null) goto L83;
        r18.g(s1.B(2131922885));
    L83:
        if (r7.f() == false) goto L85;
        z();
    L85:
        View r19 = this.g;
        if (r19 == null) goto L88;
        r19.setImportantForAccessibility(2);
    L88:
        ViewGroup r20 = q();
        if (r20 == null) goto L91;
        r20.setImportantForAccessibility(1);
    L91:
        com.bytedance.android.live.liveinteract.revenue.fight.b r21 = ((IInteractService) jc1.k.n(IInteractService.class)).teamFightService();
        if (r21 == null) goto L95;
        r21.F1(this, SceneType.SCENE_AUDIO_TALKROOM);
    L95:
        if (aj0.a.d() == false) goto L97;
        int r22 = com.bytedance.android.live.liveinteract.revenue.linkroomfight.ui.a.a;
        com.bytedance.android.live.liveinteract.revenue.linkroomfight.ui.a.C0094a.f(this, r8, this.t.getUiLayout());
    L97:
        u(true);
        if (((IInteractService) jc1.k.n(IInteractService.class)).isVoiceMultiEnlargeSeat(this.t.getUiLayout(), r8) == false) goto L104;
        View r23 = this.g;
        if (r23 == null) goto L109;
        ViewTreeObserver r24 = r23.getViewTreeObserver();
        if (r24 == null) goto L109;
        r24.addOnGlobalLayoutListener(new c(this));
    L109:
        D();
        if (this.b != MicSeatScene.AUDIO_LINK_STAGE_ENLARGE) goto L117;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.dynamicelement.b r25 = this.i;
        if (r25 == null) goto L118;
        TextView r26 = r25.k;
        if (r26 == null) goto L119;
        r26.setTextSize(1, 10.0f);
        return;
    L119:
        return;
    L118:
        return;
    L117:
        return;
    L104:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.dynamicelement.b r27 = this.i;
        if (r27 == null) goto L109;
        TextView r28 = r27.k;
        if (r28 == null) goto L109;
        r28.setTranslationY(0.0f);
        goto L109
    L49:
        if (r11 >= 10) goto L53;
        TextView r29 = this.h;
        if (r29 == null) goto L56;
        r29.setText(s1.C(2131919300, new Object[]{Integer.valueOf(r11)}));
        goto L56
    L53:
        TextView r30 = this.h;
        if (r30 == null) goto L56;
        r30.setText(String.valueOf(r11));
        goto L56
    L42:
        r14 = 0;
    L38:
        r11 = r8 + 1;
        goto L39
    L59:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.dynamicelement.b r31 = this.i;
        if (r31 == null) goto L62;
        r31.e(0);
    L62:
        UIUtils.setViewVisibility(this.h, 0);
        TextView r32 = this.h;
        if (r32 == null) goto L65;
        r32.setText("");
    L65:
        B(r7);
        goto L66
    }

    public MultiLinkAudioCommonEmptyMicSeatBasicLayer(MicSeatScene r2, m r3, xg0.a r4) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        Intrinsics.checkNotNullParameter(r3, "layoutConfig");
        Intrinsics.checkNotNullParameter(r4, "linkSeatAbilityProvider");
        super(r2, r4);
        this.t = r3;
        this.r = true;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.empty.b, jg0.f
    public final /* bridge */ /* synthetic */ void k(Object r1, int r2, Bundle r3) {
        x((MultiLinkNormalEmptyViewBinder.a) r1, r2, r3);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.empty.b
    public final void x(MultiLinkNormalEmptyViewBinder.a r5, int r6, Bundle r7) {
        Intrinsics.checkNotNullParameter(r5, "itemData");
        Intrinsics.checkNotNullParameter(r7, "payload");
        super.x(r5, r6, r7);
        Iterator<String> r8 = r7.keySet().iterator();
    L4:
        if (r8.hasNext() == false) goto L44;
        String r0 = r8.next();
        if (r0 == null) goto L4;
        switch(r0.hashCode()) {
            case 223389637: goto L33;
            case 817798352: goto L30;
            case 1052690544: goto L27;
            case 1074297423: goto L22;
            case 1486084776: goto L17;
            case 1926167357: goto L12;
            default: goto L4;
        };
    L12:
        if (r0.equals("payload_key_position_invite_guide_update") == false) goto L4;
        if (r5.f() == false) goto L4;
        z();
        goto L4
    L17:
        if (r0.equals("payload_key_dynamic_data_update_for_empty_info") == false) goto L4;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.dynamicelement.b r1 = this.i;
        if (r1 == null) goto L4;
        r1.a = this.e;
        r1.h();
        goto L4
    L22:
        if (r0.equals("payload_key_interact_state_update") == false) goto L4;
        MultiLinkNormalEmptyViewBinder.a r2 = this.e;
        if (r2 == null) goto L4;
        B(r2);
        goto L4
    L27:
        if (r0.equals("payload_key_theme_update") == false) goto L4;
        v();
        goto L4
    L30:
        if (r0.equals("payload_key_position_item_update") == false) goto L4;
        y();
        goto L4
    L33:
        if (r0.equals("payload_key_friend_online_update") == false) goto L4;
        ch0.b r3 = r5.a();
        if (r3 == null) goto L4;
        if (r3.a == null) goto L4;
        ch0.b r4 = r5.a();
        Intrinsics.checkNotNull(r4);
        Intrinsics.checkNotNullParameter(r4, "friendOnlineInviteeInfo");
        IBaseUser r9 = r4.a;
        if (r9 == null) goto L4;
        ImageUtil.loadRoundImage(this.l, r9.getAvatarThumbKt());
        this.f = r4;
        com.bytedance.android.live.liveinteract.a r10 = this.m;
        if (r10 == null) goto L43;
        r10.c();
    L43:
        int r11 = com.bytedance.android.live.liveinteract.chatroom.chatroom.util.b.a;
        com.bytedance.android.live.liveinteract.chatroom.chatroom.util.b.c(r9.getIdString());
        goto L4
    L44:
        View r12 = this.g;
        if (r12 == null) goto L47;
        r12.setImportantForAccessibility(2);
    L47:
        r3.c(q(), (r6 + 1) + s1.B(2131920341) + s1.B(2131919821), true);
        u(true);
    }
}
