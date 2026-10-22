package com.bytedance.android.live.liveinteract.feed;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.bgComponent.theme.VideoThemeView;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.model.w0;
import com.bytedance.android.live.liveinteract.radio.RadioDarkMaskView;
import com.bytedance.android.live.liveinteract.view.RadioTextBoardView;
import com.bytedance.android.live.liveinteract.voicechat.view.VoiceChatRoomAnchorView;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBasisData;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import com.bytedance.android.livesdkapi.feed.IKtvInteractFeedView;
import com.bytedance.android.livesdkapi.interact.data.LinkFeedTypeConstant;
import com.bytedance.android.livesdkapi.ktv.IKtvComponentFeedView;
import com.bytedance.android.livesdkapi.model.SeiAppData;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.service.MessageHub;
import com.bytedance.android.livesdkapi.view.IRenderView;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c0 extends b implements IKtvInteractFeedView {
    public Map<Integer, View> g;
    public final String h;
    public MessageHub i;
    public final CompositeDisposable j;
    public final HSImageView k;
    public final HSImageView l;
    public final VideoThemeView m;
    public com.bytedance.android.live.liveinteract.feed.a n;
    public com.bytedance.android.live.ui.q o;
    public final IKtvComponentFeedView p;
    public final boolean q;
    public boolean r;
    public final b0 s;

    public static final class a implements Runnable {
        public final /* synthetic */ c0 a;
        public final /* synthetic */ View b;
        public final /* synthetic */ IRoom c;

        public a(c0 r1, View r2, IRoom r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void a() {
            int r0 = (int) (UtilityKotlinExtentionsKt.h(136) * (this.b.getWidth() / s1.y()));
            a1.p(this.a.d(2131389468), r0);
            a1.k(this.a.d(2131389468), r0);
            int r1 = (int) (r0 * 1.5f);
            a1.p(this.a.d(2131383601), r1);
            a1.k(this.a.d(2131383601), r1);
            a1.p(this.a.d(2131387480), r1);
            a1.k(this.a.d(2131387480), r1);
            a1.k(this.a.d(2131362578), r1);
            IVoiceLiveTheme r4 = null;
            if (((FrameLayout) this.a.d(2131363500)).indexOfChild(this.a.k) >= 0) goto L9;
            HSImageView r2 = this.a.k;
            Context r6 = this.a.getContext();
            if ((r6 instanceof Activity) == true) goto L7;
            r6 = null;
        L7:
            r2.setLayoutParams(new FrameLayout.LayoutParams(-1, com.bytedance.android.live.liveinteract.utils.h.d((Activity) r6)));
            ((FrameLayout) this.a.d(2131363500)).addView(this.a.k, 0);
        L9:
            if (((FrameLayout) this.a.d(2131363500)).indexOfChild(this.a.l) >= 0) goto L14;
            HSImageView r3 = this.a.l;
            Context r7 = this.a.getContext();
            if ((r7 instanceof Activity) == true) goto L13;
            r7 = null;
        L13:
            r3.setLayoutParams(new FrameLayout.LayoutParams(-1, com.bytedance.android.live.liveinteract.utils.h.d((Activity) r7)));
            ((FrameLayout) this.a.d(2131363500)).addView(this.a.l, 1);
        L14:
            IVoiceLiveTheme r5 = this.c.getVoiceLiveTheme();
            if (r5 == null) goto L17;
            VoiceChatRoomAnchorView r8 = (VoiceChatRoomAnchorView) this.a.d(2131363504);
            r8.getClass();
            Intrinsics.checkNotNullParameter(r5, "theme");
            r8.r = r5;
            r8.c();
        L17:
            c0 r9 = this.a;
            IRoom r10 = r9.getMRoom$liveinteract_impl_saasRelease();
            if (r10 == null) goto L20;
            r4 = r10.getVoiceLiveTheme();
        L20:
            if (r4 != null) goto L22;
        L23:
            if (r4 != null) goto L25;
        L35:
            com.bytedance.android.live.ui.q r11 = r9.o;
            if (r11 == null) goto L38;
            r11.a(com.bytedance.android.livesdk.model.k.a());
        L38:
            IKtvComponentFeedView r12 = this.a.p;
            if (r12 == null) goto L42;
            r12.updateRoom(this.c);
            return;
        L42:
            return;
        L25:
            if (5 != r4.getBgType()) goto L35;
        L26:
            com.bytedance.android.live.ui.q r13 = r9.o;
            if (r13 == null) goto L30;
            r13.a(r4);
        L30:
            if (vm2.d.s0() == true) goto L32;
        L34:
            ((RadioDarkMaskView) r9.d(2131383596)).setVisibility(8);
            goto L38
        L32:
            if (r4.isUgcImage() != true) goto L34;
            ((RadioDarkMaskView) r9.d(2131383596)).setVisibility(0);
            goto L38
        L22:
            if (2 == r4.getBgType()) goto L26;
            goto L23
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

    @Override // com.bytedance.android.live.liveinteract.feed.b
    public final void a() {
    }

    @Override // com.bytedance.android.live.liveinteract.feed.b
    public final void b(com.bytedance.android.live.network.response.e<w0> r2) {
        Intrinsics.checkNotNullParameter(r2, "response");
    }

    @Override // com.bytedance.android.live.liveinteract.feed.b
    public final void c() {
    }

    public String getFeedViewName() {
        return "RadioRoomFeedView";
    }

    @Override // com.bytedance.android.live.liveinteract.feed.b
    public String getTagName() {
        return "AudioRoomFeedView";
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r1) {
        return true;
    }

    @Override // com.bytedance.android.live.liveinteract.feed.b
    public final void onSeiUpdated(SeiAppData r1) {
    }

    @Override // com.bytedance.android.live.liveinteract.feed.b
    public final void onSeiUpdated(JSONObject r1) {
    }

    @Override // com.bytedance.android.live.liveinteract.feed.b
    public final void onViewHolderSelected() {
    }

    @Override // com.bytedance.android.live.liveinteract.feed.b
    public final void onViewHolderUnSelected() {
        this.r = false;
    }

    public void setLivePlayerClient(ILivePlayerClient r1) {
    }

    public void setLivePlayerView(IRenderView r1) {
    }

    @Override // com.bytedance.android.live.liveinteract.feed.b
    public final void updateEnterFrom(String r1, String r2) {
    }

    @Override // com.bytedance.android.live.liveinteract.feed.b
    public final void updateTalkState(HashMap<String, Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "talkStateMap");
    }

    public String getCurrentSingUserId() {
        IKtvComponentFeedView r0 = this.p;
        if (r0 == null) goto L6;
        String r1 = r0.getCurrentSingUserIdString();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "";
    }

    public String getCurrentSingUserIdString() {
        IKtvComponentFeedView r0 = this.p;
        if (r0 == null) goto L6;
        String r1 = r0.getCurrentSingUserIdString();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "";
    }

    public Object getKtvSeiModelObject() {
        IKtvComponentFeedView r0 = this.p;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getKtvSeiModelObject();
    }

    @Override // com.bytedance.android.live.liveinteract.feed.b
    public List<ILinkPlayerInfoBridge> getOnlineList() {
        return new ArrayList();
    }

    public final void reset() {
        this.j.clear();
        IKtvComponentFeedView r0 = this.p;
        if (r0 == null) goto L5;
        r0.reset();
    L5:
        IRoom r1 = getMRoom$liveinteract_impl_saasRelease();
        if (r1 == null) goto L10;
        IRoomBasisData r2 = r1.getBasisRoomData();
        if (r2 == null) goto L10;
        Boolean r3 = r2.isCustomizeAudioRoom();
    L12:
        if (Intrinsics.areEqual(r3, Boolean.TRUE) == false) goto L14;
        ((VoiceChatRoomAnchorView) d(2131363504)).setVisibility(0);
    L14:
        MessageHub r4 = this.i;
        if (r4 == null) goto L18;
        r4.removeMessageListener(MessageType.ROOM_TEXT_BG_MESSAGE.getIntType(), this.s);
        return;
    L18:
        return;
    L10:
        r3 = null;
        goto L12
    }

    public final void resetKtvSeiModelObject() {
        IKtvComponentFeedView r0 = this.p;
        if (r0 == null) goto L6;
        r0.resetKtvSeiModelObject();
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.feed.b
    public IKtvComponentFeedView getKtvComponentFeedView() {
        return this.p;
    }

    public final View d(int r3) {
        if (this.g != null) goto L5;
        this.g = new LinkedHashMap();
    L5:
        View r0 = this.g.get(Integer.valueOf(r3));
        if (r0 != null) goto L12;
        View r1 = findViewById(r3);
        if (r1 == null) goto L10;
        this.g.put(Integer.valueOf(r3), r1);
        return r1;
    L10:
        return null;
    L12:
        return r0;
    }

    public final void onKtvRoomSeiModel(String r2) {
        Intrinsics.checkNotNullParameter(r2, "sei");
        IKtvComponentFeedView r0 = this.p;
        if (r0 == null) goto L6;
        r0.onSeiUpdatedRaw(r2);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.feed.b
    public final void updateMessageHub(MessageHub r3) {
        Intrinsics.checkNotNullParameter(r3, "hub");
        this.i = r3;
        if (this.q == false) goto L15;
        if (r3 == null) goto L7;
        r3.removeMessageListener(MessageType.ROOM_TEXT_BG_MESSAGE.getIntType(), this.s);
    L7:
        MessageHub r4 = this.i;
        if ((r4 instanceof xlc.a) == true) goto L10;
        r4 = null;
    L10:
        xlc.a r5 = (xlc.a) r4;
        if (r5 == null) goto L14;
        r5.y(MessageType.ROOM_TEXT_BG_MESSAGE.getIntType(), this.s);
        return;
    L14:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.feed.b
    public final void updateRadioTextSei(JSONObject r3) {
        Intrinsics.checkNotNullParameter(r3, "seiObj");
        ConstraintLayout r1 = (RadioTextBoardView) d(2131383612);
        if (r1 == null) goto L5;
        Integer r2 = Integer.valueOf(r1.getVisibility());
    L7:
        if (r2.intValue() == 0) goto L9;
        return;
    L9:
        if (this.q == false) goto L15;
        RadioTextBoardView r0 = (RadioTextBoardView) d(2131383612);
        if (r0 == null) goto L16;
        r0.R5(r3);
        return;
    L16:
        return;
    L15:
        return;
    L5:
        r2 = null;
        goto L7
    }

    @Override // com.bytedance.android.live.liveinteract.feed.b
    public final void updateRoom(IRoom r6) {
        Intrinsics.checkNotNullParameter(r6, PbRequest.SwitchType.ROOM);
        Intrinsics.checkNotNullParameter(r6, PbRequest.SwitchType.ROOM);
        this.b = r6;
        IRoomBasisData r0 = r6.getBasisRoomData();
        Boolean r1 = null;
        if (r0 == null) goto L5;
        Boolean r2 = r0.isCustomizeAudioRoom();
    L6:
        Boolean r3 = Boolean.TRUE;
        if (Intrinsics.areEqual(r2, r3) == false) goto L24;
        IRoom r4 = getMRoom$liveinteract_impl_saasRelease();
        if (r4 == null) goto L11;
        IVoiceLiveTheme r5 = r4.getVoiceLiveTheme();
    L12:
        if (r5 != null) goto L14;
    L15:
        if (r5 != null) goto L17;
    L19:
        r5 = com.bytedance.android.livesdk.model.k.a();
    L20:
        com.bytedance.android.live.ui.q r7 = this.o;
        if (r7 == null) goto L23;
        r7.d(r5);
    L23:
        this.n = null;
        this.o = null;
        goto L24
    L17:
        if (5 != r5.getBgType()) goto L19;
    L14:
        if (2 == r5.getBgType()) goto L20;
    L11:
        r5 = null;
    L24:
        com.bytedance.android.live.liveinteract.pre.a.c.a.c(getMRoom$liveinteract_impl_saasRelease(), true);
        ((VoiceChatRoomAnchorView) d(2131363504)).f(r6);
        ((VoiceChatRoomAnchorView) d(2131363504)).d(1);
        Object r8 = getParent();
        if ((r8 instanceof View) == true) goto L27;
        r8 = null;
    L27:
        View r9 = (View) r8;
        if (r9 == null) goto L30;
        r9.post(new a(this, r9, r6));
    L30:
        IRoom r10 = getMRoom$liveinteract_impl_saasRelease();
        if (r10 == null) goto L36;
        IRoomBasisData r11 = r10.getBasisRoomData();
        if (r11 == null) goto L36;
        r1 = r11.isCustomizeAudioRoom();
    L36:
        if (Intrinsics.areEqual(r1, r3) == false) goto L39;
        ((VoiceChatRoomAnchorView) d(2131363504)).setVisibility(8);
        return;
    L39:
        return;
    L5:
        r2 = null;
        goto L6
    }

    public c0(Context r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        IVoiceLiveTheme r0 = null;
        super(r10, r11, null, 0);
        this.g = new LinkedHashMap();
        this.h = "AudioRoomFeedView";
        this.j = new CompositeDisposable();
        HSImageView r5 = new HSImageView(r10);
        this.k = r5;
        HSImageView r6 = new HSImageView(r10);
        this.l = r6;
        this.q = vm2.h.f();
        this.s = new b0(this);
        LayoutInflater.from(r10).inflate(2131567756, this);
        View r2 = d(2131383617);
        if (r2 == null) goto L50;
        VideoThemeView r3 = (VideoThemeView) r2;
        this.m = r3;
        ConstraintLayout.LayoutParams r4 = new ConstraintLayout.LayoutParams(-1, -1);
        r4.topToTop = 0;
        r4.bottomToBottom = 0;
        r4.leftToLeft = 0;
        r4.rightToRight = 0;
        r3.setLayoutParams(r4);
        if (LinkFeedTypeConstant.Companion.isDouyinFullScreen(r11) == false) goto L16;
        VoiceChatRoomAnchorView r12 = (VoiceChatRoomAnchorView) d(2131363504);
        if (r12 == null) goto L9;
        ViewGroup.LayoutParams r13 = r12.getLayoutParams();
    L11:
        if ((r13 instanceof ConstraintLayout.LayoutParams) == true) goto L13;
        r13 = null;
    L13:
        ConstraintLayout.LayoutParams r14 = (ConstraintLayout.LayoutParams) r13;
        if (r14 == null) goto L27;
        ((ViewGroup.MarginLayoutParams) r14).topMargin = UtilityKotlinExtentionsKt.i(108);
    L27:
        VoiceChatRoomAnchorView r15 = (VoiceChatRoomAnchorView) d(2131363504);
        if (r15 == null) goto L30;
        r15.setUserNameVisibility(8);
    L30:
        setClickable(false);
        this.n = new com.bytedance.android.live.liveinteract.feed.a(false, r5, r6, r3, new a0(this));
        ALogger.e("MultiLinkThemeBgUIWidget", "RADIO feedView 0, initTheme");
        com.bytedance.android.live.liveinteract.videotalk.ui.theme.b.a r16 = new com.bytedance.android.live.liveinteract.videotalk.ui.theme.b.a();
        com.bytedance.android.live.liveinteract.feed.a r7 = this.n;
        Intrinsics.checkNotNull(r7);
        com.bytedance.android.live.ui.q.a.c(r16, r7);
        this.o = r16.a();
        IRoom r17 = getMRoom$liveinteract_impl_saasRelease();
        if (r17 == null) goto L33;
        r0 = r17.getVoiceLiveTheme();
    L33:
        if (r0 != null) goto L35;
    L36:
        if (r0 != null) goto L38;
    L42:
        r3.setVisibility(4);
        com.bytedance.android.live.ui.q r18 = this.o;
        if (r18 == null) goto L45;
        r18.c(com.bytedance.android.livesdk.model.k.a());
    L45:
        IKtvComponentFeedView r19 = jc1.k.n(IKtvService.class).getKtvComponentFeedView(r10, false);
        this.p = r19;
        ConstraintLayout.LayoutParams r110 = com.bytedance.android.live.liveinteract.utils.h.c(11, 2131384921);
        if (r19 == null) goto L51;
        r19.setAttachParent((ViewGroup) findViewById(2131384822), r110);
        return;
    L51:
        return;
    L38:
        if (5 != r0.getBgType()) goto L42;
    L39:
        com.bytedance.android.live.ui.q r111 = this.o;
        if (r111 == null) goto L45;
        r111.c(r0);
        goto L45
    L35:
        if (2 == r0.getBgType()) goto L39;
    L9:
        r13 = null;
        goto L11
    L16:
        VoiceChatRoomAnchorView r112 = (VoiceChatRoomAnchorView) d(2131363504);
        if (r112 == null) goto L19;
        ViewGroup.LayoutParams r113 = r112.getLayoutParams();
    L21:
        if ((r113 instanceof ConstraintLayout.LayoutParams) == true) goto L23;
        r113 = null;
    L23:
        ConstraintLayout.LayoutParams r114 = (ConstraintLayout.LayoutParams) r113;
        if (r114 == null) goto L26;
        r114.topToTop = 0;
        r114.bottomToBottom = 0;
        r114.leftToLeft = 0;
        r114.rightToRight = 0;
        r114.setMargins(0, 0, 0, 0);
    L26:
        ((RadioTextBoardView) d(2131383612)).setVisibility(8);
        goto L27
    L19:
        r113 = null;
        goto L21
    L50:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.bgComponent.theme.VideoThemeView");
    }
}
