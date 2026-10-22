package com.bytedance.android.live.liveinteract.voicechat.view;

import am2.x;
import android.content.Context;
import android.graphics.drawable.Animatable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.r2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.interact.utils.AvatarType;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.base.MicSeatScene;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.interactivesong.RequestSongMicSeatView;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.ui.SeatAnimationView;
import com.bytedance.android.live.liveinteract.interactivesong.impl.k;
import com.bytedance.android.live.liveinteract.interactivesong.impl.l;
import com.bytedance.android.live.liveinteract.plantform.base.i;
import com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.model.g0;
import com.bytedance.android.live.liveinteract.plantform.model.n;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.plantform.utils.i0;
import com.bytedance.android.live.liveinteract.revenue.fight.TeamFightContext;
import com.bytedance.android.live.liveinteract.revenue.linkroomfight.core.LinkRoomFightContext;
import com.bytedance.android.live.liveinteract.utils.j0;
import com.bytedance.android.live.liveinteract.utils.o1;
import com.bytedance.android.live.liveinteract.videotalk.emoji.model.TalkRoomBaseDynamicEmoji;
import com.bytedance.android.live.liveinteract.videotalk.quickinteract.QuickInteractTask;
import com.bytedance.android.live.liveinteract.videotalk.quickinteract.interactView.LinkMicQuickInteractView;
import com.bytedance.android.live.liveinteract.videotalk.quickinteract.interactView.ThemedCompetitionQuickInteractView;
import com.bytedance.android.live.liveinteract.videotalk.themecompetition.ThemedCompetitionContext;
import com.bytedance.android.live.liveinteract.view.PositionNameTv;
import com.bytedance.android.live.liveinteract.view.SeatPosTagLabelTextView;
import com.bytedance.android.live.liveinteract.voicechat.IVoiceChatGuestService;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.interact.model.d0;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.chatroom.ui.d6;
import com.bytedance.android.livesdk.chatroom.ui.e6;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.common.AnchorPauseTipsView;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveThemeKt;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.disposables.CompositeDisposable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import nh0.m;
import vm2.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002:\u0001$B'\b\u0007\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001f\u0012\b\b\u0002\u0010!\u001a\u00020\u0003¢\u0006\u0004\b\"\u0010#J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0003J\u0006\u0010\f\u001a\u00020\u000bJ\u0006\u0010\u000e\u001a\u00020\rJ\u0006\u0010\u0010\u001a\u00020\u000fJ\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0003H\u0016R(\u0010\u0018\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u00128B@\u0002X\u0082\u000e¢\u0006\f\n\u0004\b\u0019\u0010\u0015\u001a\u0004\b\u001a\u0010\u001b¨\u0006%"}, d2 = {"Lcom/bytedance/android/live/liveinteract/voicechat/view/VoiceChatRoomAnchorView;", "Landroid/widget/FrameLayout;", "Landroid/view/View$OnClickListener;", "", "getResourceLayout", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "", "setDataCenter", "visibility", "setUserNameVisibility", "Lcom/bytedance/android/live/liveinteract/chatroom/chatroom/ui/SeatAnimationView;", "getSeatAnimView", "", "getUserId", "Lbd0/c;", "getTakeOverInfo", "setVisibility", "Lcom/bytedance/android/live/liveinteract/plantform/model/ILinkPlayerInfoBridge;", "value", "t", "Lcom/bytedance/android/live/liveinteract/plantform/model/ILinkPlayerInfoBridge;", "set_anchorInfo", "(Lcom/bytedance/android/live/liveinteract/plantform/model/ILinkPlayerInfoBridge;)V", "_anchorInfo", "u", "getAnchorInfo", "()Lcom/bytedance/android/live/liveinteract/plantform/model/ILinkPlayerInfoBridge;", "anchorInfo", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class VoiceChatRoomAnchorView extends FrameLayout implements View.OnClickListener {
    public boolean A;
    public Map<Integer, View> a;
    public final String b;
    public final View c;
    public final HSImageView d;
    public final HSImageView e;
    public final SeatAnimationView f;
    public final TextView g;
    public final LinkMicQuickInteractView h;
    public final PositionNameTv i;
    public final SeatPosTagLabelTextView j;
    public DataCenter k;
    public IRoom l;
    public final ThemedCompetitionQuickInteractView m;
    public final k n;
    public final View o;
    public int p;
    public boolean q;
    public IVoiceLiveTheme r;
    public final j22.c s;
    public ILinkPlayerInfoBridge t;
    public ILinkPlayerInfoBridge u;
    public final c v;
    public String w;
    public final CompositeDisposable x;
    public com.bytedance.android.live.liveinteract.revenue.common.vieweffect.b y;
    public com.bytedance.android.live.liveinteract.revenue.common.vieweffect.d z;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ VoiceChatRoomAnchorView a;

        public b(VoiceChatRoomAnchorView r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            double r0 = ((double) this.a.e.getHeight()) / 0.75d;     // Catch: Throwable -> L4
            int r1 = (int) r0;     // Catch: Throwable -> L4
            UIUtils.updateLayout(this.a.d, r1, r1);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c extends i.a<ILinkPlayerInfoBridge> {
        public final /* synthetic */ VoiceChatRoomAnchorView a;

        public c(VoiceChatRoomAnchorView r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.liveinteract.plantform.base.i.b
        public final void onOnlineListChanged(List<ILinkPlayerInfoBridge> r5) {
            Object r2 = null;
            if (((Boolean) vm2.d.V4.getValue(null, vm2.d.a[305(0x131, float:4.27E-43)])).booleanValue() == true) goto L26;
            if (r5 == null) goto L27;
            Iterator<T> r6 = r5.iterator();
        L7:
            if (r6.hasNext() == false) goto L19;
            Object r0 = r6.next();
            IBaseUser r1 = ((ILinkPlayerInfoBridge) r0).getUser();
            if (r1 == null) goto L11;
            String r3 = r1.getIdString();
        L12:
            IRoom r4 = this.a.l;
            if (r4 == null) goto L15;
            String r7 = r4.getOwnerUserIdString();
        L17:
            if (Intrinsics.areEqual(r3, r7) == false) goto L7;
            r2 = r0;
            goto L19
        L15:
            r7 = null;
            goto L17
        L11:
            r3 = null;
        L19:
            ILinkPlayerInfoBridge r8 = (ILinkPlayerInfoBridge) r2;
            if (r8 == null) goto L28;
            this.a.e(r8);
            return;
        L28:
            return;
        L27:
            return;
        }
    }

    public static final class d implements e6 {
        public final /* synthetic */ VoiceChatRoomAnchorView a;

        public d(VoiceChatRoomAnchorView r1) {
            this.a = r1;
        }

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
            DataCenter r1 = this.a.k;
            if (r1 == null) goto L18;
            r1.put("cmd_show_dynamic_emoji_in_comment", ag1.b.b(r4));
            return;
        L18:
            return;
        L17:
            return;
        L15:
            return;
        }
    }

    static {
    }

    public VoiceChatRoomAnchorView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public VoiceChatRoomAnchorView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final int getResourceLayout() {
        return 2131567616;
    }

    private final ILinkPlayerInfoBridge getAnchorInfo() {
        ILinkPlayerInfoBridge r0 = this.t;
        if (r0 == null) goto L5;
        return r0;
    L5:
        i<ILinkPlayerInfoBridge> r1 = ((IInteractService) jc1.k.n(IInteractService.class)).getLinkUserInfoCenter();
        if (r1 == null) goto L13;
        IRoom r2 = this.l;
        if (r2 == null) goto L11;
        String r3 = r2.getOwnerUserIdString();
        if (r3 == null) goto L11;
    L12:
        ILinkPlayerInfoBridge r4 = (ILinkPlayerInfoBridge) r1.getGuestInfo(r3, "");
    L14:
        this.u = r4;
        return r4;
    L11:
        r3 = "";
        goto L12
    L13:
        r4 = null;
        goto L14
    }

    public final void c() {
        IVoiceLiveTheme r0 = this.r;
        if (r0 != null) goto L5;
    L6:
        ILinkPlayerInfoBridge r1 = getAnchorInfo();
        if (r1 != null) goto L9;
    L35:
        this.d.setController(null);
        this.d.setVisibility(4);
        return;
    L9:
        if (n.f(r1) != true) goto L35;
    L11:
        if (this.A == true) goto L32;
        ILinkPlayerInfoBridge r2 = getAnchorInfo();
        if (r2 == null) goto L32;
        if (n.f(r2) != true) goto L32;
        int r3 = dk0.b.a;
        IRoom r4 = this.l;
        String r5 = "";
        if (r4 == null) goto L20;
        String r6 = r4.getOwnerUserIdString();
        if (r6 == null) goto L20;
    L21:
        ILinkPlayerInfoBridge r7 = getAnchorInfo();
        if (r7 == null) goto L31;
        kd1.b r8 = r7.getMicDress();
        if (r8 == null) goto L31;
        kd1.c r9 = r8.getVoiceWave();
        if (r9 == null) goto L31;
        String r10 = r9.getDressId();
        if (r10 == null) goto L31;
        r5 = r10;
    L31:
        dk0.b.a(r6, r5);
        this.A = true;
    L20:
        r6 = "";
    L32:
        j22.c r11 = this.s;
        if (r11 == null) goto L37;
        r11.d = true;
        return;
    L37:
        return;
    L5:
        if (IVoiceLiveThemeKt.isVoiceAnimInvalid(r0) == true) goto L11;
        goto L6
    }

    public final bd0.c getTakeOverInfo() {
        HSImageView r1 = this.e;
        String r3 = this.w;
        ILinkPlayerInfoBridge r0 = getAnchorInfo();
        if (r0 == null) goto L11;
        IBaseUser r2 = r0.getUser();
        if (r2 == null) goto L11;
        py.k r4 = je0.d.n(r2, AvatarType.AVATAR_THUMB.getValue());
        if (r4 == null) goto L11;
        List r5 = r4.getUrls();
        if (r5 == null) goto L11;
        String r6 = (String) ListProtector.get(r5, 0);
    L13:
        return new bd0.c(r1, null, r3, false, 0.0f, 0.0f, r6, false, null, null, null, null, 4024);
    L11:
        r6 = null;
        goto L13
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.i.D();
        com.bytedance.android.live.liveinteract.revenue.common.vieweffect.b r0 = new com.bytedance.android.live.liveinteract.revenue.common.vieweffect.b(this, this.f, je0.d.r(), null);
        this.y = r0;
        r0.e = this.h;
        r0.f = null;
        r0.g = this.m;
        boolean r1 = r.a;
        if (r.l() == false) goto L6;
        this.z = new com.bytedance.android.live.liveinteract.revenue.common.vieweffect.d(MicSeatScene.AUDIO_LINK_ANCHOR, this, this.f, je0.d.r(), false, null, 48);
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.x.clear();
        i<ILinkPlayerInfoBridge> r0 = ((IInteractService) jc1.k.n(IInteractService.class)).getLinkUserInfoCenter();
        if (r0 == null) goto L5;
        r0.T4(this.v);
    L5:
        this.i.E();
        k r1 = this.n;
        if (r1 == null) goto L10;
        RequestSongMicSeatView r2 = r1.a;
        if (r2 == null) goto L10;
        r2.n();
    L10:
        com.bytedance.android.live.liveinteract.revenue.common.vieweffect.b r3 = this.y;
        if (r3 == null) goto L20;
        ILinkPlayerInfoBridge r4 = getAnchorInfo();
        if (r4 == null) goto L17;
        IBaseUser r5 = r4.getUser();
        if (r5 == null) goto L17;
        String r6 = r5.getIdString();
    L18:
        r3.b(r6);
        return;
    L17:
        r6 = null;
        goto L18
    }

    public final SeatAnimationView getSeatAnimView() {
        return this.f;
    }

    public final String getUserId() {
        return this.w;
    }

    private final void set_anchorInfo(ILinkPlayerInfoBridge r2) {
        k r0 = this.n;
        if (r0 == null) goto L5;
        r0.c = r2;
    L5:
        this.t = r2;
    }

    public final View a(int r3) {
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

    public final void b(ILinkPlayerInfoBridge r6) {
        if (r6 != null) goto L4;
        r6 = getAnchorInfo();
    L4:
        Animatable r0 = null;
        if (r6 != null) goto L7;
    L60:
        this.d.setController(null);
        return;
    L7:
        if (n.f(r6) != true) goto L60;
        if (n.f(r6) == true) goto L12;
    L31:
        HSImageView r1 = this.e;
        if (r1 == null) goto L34;
        r1.post(new b(this));
    L34:
        this.d.setVisibility(0);
        if (this.d.getController() != null) goto L48;
        kd1.b r7 = r6.getMicDress();
        if (r7 == null) goto L45;
        kd1.c r8 = r7.getVoiceWave();
        if (r8 == null) goto L45;
        py.k r9 = r8.getMediumImg();
        if (r9 == null) goto L45;
        List r10 = r9.getUrls();
        if (r10 == null) goto L45;
        String r11 = (String) CollectionsKt.getOrNull(r10, 0);
    L46:
        if (r11 == null) goto L48;
        this.d.setController(Fresco.newDraweeControllerBuilder().setUri(UriProtector.parse(r11)).setOldController(this.d.getController()).setAutoPlayAnimations(false).build());
    L45:
        r11 = null;
    L48:
        DraweeController r12 = this.d.getController();
        if (r12 == null) goto L51;
        Animatable r13 = r12.getAnimatable();
    L53:
        if ((r13 instanceof AnimatedDrawable2) == false) goto L56;
        r0 = r13;
    L56:
        AnimatedDrawable2 r2 = (AnimatedDrawable2) r0;
        if (r2 == null) goto L62;
        r2.stop();
        r2.jumpToFrame(1);
        return;
    L62:
        return;
    L51:
        r13 = null;
        goto L53
    L12:
        if (this.A == true) goto L31;
        if (je0.d.u() == false) goto L31;
        if (d0.h(this.l) == true) goto L31;
        int r3 = dk0.b.a;
        IRoom r4 = this.l;
        String r5 = "";
        if (r4 == null) goto L21;
        String r14 = r4.getOwnerUserIdString();
        if (r14 == null) goto L21;
    L22:
        kd1.b r15 = r6.getMicDress();
        if (r15 == null) goto L30;
        kd1.c r16 = r15.getVoiceWave();
        if (r16 == null) goto L30;
        String r17 = r16.getDressId();
        if (r17 == null) goto L30;
        r5 = r17;
    L30:
        dk0.b.a(r14, r5);
        this.A = true;
    L21:
        r14 = "";
        goto L22
    }

    public final void d(int r13) {
        if (this.p == r13) goto L67;
        this.p = r13;
        if (r13 > 0) goto L7;
        c();
        return;
    L7:
        if (this.q == true) goto L61;
        IVoiceLiveTheme r0 = this.r;
        if (r0 != null) goto L11;
    L12:
        ILinkPlayerInfoBridge r1 = getAnchorInfo();
        if (r1 == null) goto L61;
        if (n.f(r1) != true) goto L61;
    L16:
        IVoiceLiveTheme r2 = this.r;
        py.k r11 = null;
        if (r2 != null) goto L19;
    L20:
        ILinkPlayerInfoBridge r3 = getAnchorInfo();
        if (r3 != null) goto L23;
    L56:
        HSImageView r14 = this.d;
        PipelineDraweeControllerBuilder r4 = Fresco.newDraweeControllerBuilder();
        IVoiceLiveTheme r5 = this.r;
        if (r5 == null) goto L59;
        r11 = r5.getEffectAvatarTalk();
    L59:
        r14.setController(r4.setFirstAvailableImageRequests(a1.b(r11, -1)).setOldController(this.d.getController()).setAutoPlayAnimations(true).build());
    L60:
        this.d.setVisibility(0);
        return;
    L23:
        if (n.f(r3) != true) goto L56;
    L24:
        IRoom r6 = this.l;
        if (r6 == null) goto L29;
        IBaseUser r7 = r6.getBaseOwner();
        if (r7 == null) goto L29;
        Integer r8 = Integer.valueOf(r7.getGender());
    L30:
        IVoiceLiveTheme r9 = this.r;
        if (r9 == null) goto L36;
        if (r8 == null) goto L34;
        int r10 = r8.intValue();
    L35:
        py.k r12 = IVoiceLiveThemeKt.getVolumeAnim$default(r9, 3, r13, r10, o1.a(), false, 16, null);
    L37:
        ILinkPlayerInfoBridge r15 = getAnchorInfo();
        if (r15 != null) goto L40;
    L51:
        UIUtils.updateLayout(this.d, UtilityKotlinExtentionsKt.i(80), UtilityKotlinExtentionsKt.i(80));
        if (r12 == null) goto L60;
        j22.c r16 = this.s;
        if (r16 == null) goto L60;
        r16.e(r12);
        goto L60
    L40:
        if (n.f(r15) != true) goto L51;
        int r17 = (int) (((double) this.e.getHeight()) / 0.75d);
        UIUtils.updateLayout(this.d, r17, r17);
        ILinkPlayerInfoBridge r18 = getAnchorInfo();
        if (r18 == null) goto L48;
        kd1.b r19 = r18.getMicDress();
        if (r19 == null) goto L48;
        kd1.c r20 = r19.getVoiceWave();
        if (r20 == null) goto L48;
        r11 = kd1.d.a(r20, r13);
    L48:
        this.d.setVisibility(0);
        j22.c r110 = this.s;
        if (r110 == null) goto L68;
        r110.f(r11);
        return;
    L68:
        return;
    L34:
        r10 = 0;
        goto L35
    L36:
        r12 = null;
    L29:
        r8 = null;
        goto L30
    L19:
        if (IVoiceLiveThemeKt.isVoiceAnimInvalid(r2) == true) goto L24;
    L11:
        if (IVoiceLiveThemeKt.isVoiceAnimInvalid(r0) == true) goto L16;
    L61:
        String r111 = vm2.d.t();
        if (TextUtils.isEmpty(r111) == false) goto L64;
        ALogger.e(this.b, "radio effect is null");
        return;
    L64:
        this.d.setController(Fresco.newDraweeControllerBuilder().setUri(UriProtector.parse(r111)).setOldController(this.d.getController()).setAutoPlayAnimations(true).build());
        this.d.setVisibility(0);
        return;
    }

    public final void e(ILinkPlayerInfoBridge r14) {
        Intrinsics.checkNotNullParameter(r14, "info");
        ILinkPlayerInfoBridge r1 = this.t;
        if (r1 != null) goto L5;
    L18:
        set_anchorInfo(r14);
        Object r4 = null;
        if (r14.getUserPosition() != 0) goto L38;
        set_anchorInfo(r14);
        if (n.h(r14) == true) goto L29;
        if (n.f(r14) == false) goto L29;
        HSImageView r2 = this.d;
        if (r2 == null) goto L27;
        r2.setController(null);
    L27:
        b(r14);
    L29:
        if (n.h(r14) == true) goto L38;
        if (n.f(r14) == true) goto L38;
        HSImageView r3 = this.d;
        if (r3 == null) goto L35;
        r3.setController(null);
    L35:
        HSImageView r5 = this.d;
        if (r5 == null) goto L38;
        r5.setVisibility(4);
    L38:
        g0 r6 = r14.getMicPosTagInfo();
        if (r6 != null) goto L41;
    L63:
        SeatPosTagLabelTextView r7 = this.j;
        if (r7 == null) goto L66;
        SeatPosTagLabelTextView.z(r7, 8, getAnchorInfo(), null, null, 12);
        Unit r8 = Unit.INSTANCE;
    L66:
        k r9 = this.n;
        if (r9 == null) goto L71;
        Intrinsics.checkNotNullParameter(r14, "info");
        if (TeamFightContext.Companion.h() == true) goto L71;
        postDelayed(new l(r9, r14), 1000);
    L71:
        com.bytedance.android.live.liveinteract.revenue.common.vieweffect.b r0 = this.y;
        if (r0 == null) goto L74;
        r0.d = 0;
    L74:
        ih0.b r10 = ((IInteractService) jc1.k.n(IInteractService.class)).dynamicService(this.k);
        if (r10 == null) goto L124;
        Object r11 = r10.Xg();
        if (r11 != null) goto L79;
    L111:
        IBaseUser r15 = r14.getUser();
        if (r15 == null) goto L124;
        String r16 = r15.getIdString();
        if (r16 == null) goto L124;
        Object r17 = r10.ql(r16);
        if ((r17 instanceof nh0.i) == false) goto L119;
        r4 = r17;
    L119:
        nh0.i r12 = (nh0.i) r4;
        if (r12 == null) goto L124;
        com.bytedance.android.live.liveinteract.revenue.common.vieweffect.d r18 = this.z;
        if (r18 == null) goto L124;
        r18.d(0, r12);
        goto L124
    L79:
        if ((r11 instanceof nh0.l) == true) goto L81;
        r11 = null;
    L81:
        nh0.l r13 = (nh0.l) r11;
        if (r13 == null) goto L104;
        List<tf0.d> r19 = r13.c;
        if (r19 == null) goto L104;
        Iterator<T> r20 = r19.iterator();
    L87:
        if (r20.hasNext() == false) goto L102;
        Object r21 = r20.next();
        tf0.d r22 = (tf0.d) r21;
        String r23 = r22.c().toString();
        ILinkPlayerInfoBridge r24 = getAnchorInfo();
        if (r24 == null) goto L93;
        IBaseUser r25 = r24.getUser();
        if (r25 == null) goto L93;
        String r26 = r25.getIdString();
    L95:
        if (Intrinsics.areEqual(r23, r26) == true) goto L97;
    L99:
        boolean r27 = false;
    L100:
        if (r27 == false) goto L87;
    L103:
        tf0.d r28 = (tf0.d) r21;
    L106:
        if ((r28 instanceof m) == true) goto L108;
        r28 = null;
    L108:
        m r29 = (m) r28;
        com.bytedance.android.live.liveinteract.revenue.common.vieweffect.b r30 = this.y;
        if (r30 == null) goto L111;
        r30.c(r29, false, true);
        goto L111
    L97:
        if ((r22 instanceof m) == false) goto L99;
        r27 = true;
    L93:
        r26 = null;
        goto L95
    L102:
        r21 = null;
    L104:
        r28 = null;
    L124:
        com.bytedance.android.live.liveinteract.revenue.common.vieweffect.b r110 = this.y;
        if (r110 == null) goto L135;
        ViewGroup r111 = r110.b;
        if (r111 == null) goto L136;
        r111.setVisibility(0);
        return;
    L136:
        return;
    L135:
        return;
    L41:
        if (r6.getTagType() <= 0) goto L58;
        String r31 = r6.getPositionTagName();
        if (r31 == null) goto L58;
        if (r31.length() <= 0) goto L47;
        boolean r32 = true;
    L48:
        if (r32 != true) goto L58;
        AppCompatTextView r33 = this.j;
        if (r33 != null) goto L52;
    L53:
        SeatPosTagLabelTextView r34 = this.j;
        if (r34 == null) goto L56;
        SeatPosTagLabelTextView.z(r34, 0, getAnchorInfo(), null, null, 12);
    L56:
        int r35 = j0.a;
        j0.d(r6);
    L57:
        int r36 = j0.a;
        j0.c(this.j, r6, getAnchorInfo(), false, getContext(), null, 40);
        j0.a(this.j, r6, getAnchorInfo(), getContext(), false);
        Unit r37 = Unit.INSTANCE;
    L62:
        if (r37 != null) goto L66;
    L52:
        if (r33.getVisibility() == 0) goto L57;
    L47:
        r32 = false;
    L58:
        SeatPosTagLabelTextView r38 = this.j;
        if (r38 == null) goto L61;
        SeatPosTagLabelTextView.z(r38, 8, getAnchorInfo(), null, null, 12);
        r37 = Unit.INSTANCE;
        goto L62
    L61:
        r37 = null;
        goto L62
    L5:
        if (r1.getVerifyStatus() != 0) goto L15;
        ILinkPlayerInfoBridge r39 = this.t;
        if (r39 == null) goto L18;
        String r40 = r39.getActiveName();
        if (r40 == null) goto L18;
        if (r40.length() <= 0) goto L13;
        boolean r41 = true;
    L14:
        if (r41 != true) goto L18;
    L13:
        r41 = false;
    L15:
        ILinkPlayerInfoBridge r42 = this.t;
        if (r42 == null) goto L18;
        r14.setStats(r42.getStats());
        r14.setActiveName(r42.getActiveName());
        r14.setVerifyStatus(r42.getVerifyStatus());
        r14.setPositionType(r42.getPositionType());
        goto L18
    }

    public final void f(IRoom r6) {
        Intrinsics.checkNotNullParameter(r6, PbRequest.SwitchType.ROOM);
        this.l = r6;
        k r0 = this.n;
        if (r0 == null) goto L5;
        r0.b = r6;
    L5:
        IBaseUser r1 = r6.getBaseOwner();
        if (r1 == null) goto L8;
        int r2 = s1.f(60.0f);
        a1.w(this.e, r1.getAvatarMedium(), r2, r2);
        r3.c(this.e, r1.getNickName(), true);
    L8:
        TextView r3 = this.g;
        IBaseUser r4 = r6.getBaseOwner();
        if (r4 == null) goto L11;
        String r5 = r4.getNickName();
    L12:
        r3.setText(r5);
        this.w = r6.getOwnerUserIdString();
        ILinkPlayerInfoBridge r7 = getAnchorInfo();
        if (r7 == null) goto L15;
        r7.getInteractId();
    L15:
        UtilityKotlinExtentionsKt.t(this.h);
        this.f.setEmojiCallback(new d(this));
        SeatAnimationView r8 = this.f;
        int r9 = s1.f(60.0f);
        int r10 = s1.f(60.0f);
        r8.o = r9;
        r8.p = r10;
        SeatAnimationView.f(r8.e, r9, r10);
        UIUtils.updateLayout(this.d, UtilityKotlinExtentionsKt.i(80), UtilityKotlinExtentionsKt.i(80));
        b(null);
        return;
    L11:
        r5 = null;
        goto L12
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r6) {
        IVoiceChatGuestService.Companion.getClass();
        IVoiceChatGuestService r0 = IVoiceChatGuestService.a.a();
        if (r0 == null) goto L17;
        if (r0.isEngineOn() == true) goto L17;
        o r1 = com.bytedance.android.live.liveinteract.api.utils.m.l(this.k, 0L);
        if (r1 == null) goto L17;
        com.bytedance.live.datacontext.m r2 = r1.getCleanMode();
        if (r2 == null) goto L17;
        if (((Number) r2.getValue()).intValue() != 2) goto L17;
        if (e.h() == false) goto L17;
        ALogger.w(this.b, "rejected anchor view click for pure clean mode");
        return;
    L17:
        if (r6 == null) goto L19;
        int r7 = r6.getId();
    L21:
        if (r7 != 2131389468) goto L52;
        DataCenter r8 = this.k;
        if (r8 == null) goto L26;
        r8.put("cmd_open_interact_manage_dialog_by_anchor", Boolean.TRUE);
    L26:
        if (this.k == null) goto L28;
    L37:
        IRoom r9 = this.l;
        Intrinsics.checkNotNull(r9);
        IBaseUser r10 = r9.getOwner();
        if (r10 != null) goto L40;
        return;
    L40:
        if (Intrinsics.areEqual(jc1.k.n(IMiddlewareUserService.class).user().n(), r10.getIdString()) == false) goto L42;
        String r3 = "oneself";
    L43:
        HashMap r4 = new HashMap();
        r4.put("user_id", r10.getIdString().toString());
        r4.put("user_type", r3);
        r4.put("user_cnt", String.valueOf(je0.d.S()));
        TalkRoomLogUtils.Q0(r4);
        Integer r11 = (Integer) ((ge1.a) hd0.c.f()).b;
        if (r11 != null) goto L47;
    L49:
        String r12 = "0";
    L50:
        r4.put("is_user_guest", r12);
        r4.put("is_audience_enlarged_currently", "0");
        i0 r13 = TalkRoomLogUtils.a;
        r4.put("enlarge_open_from", String.valueOf(TalkRoomLogUtils.f()));
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_seat_head_click", r4, new Object[]{x.class, IRoom.class});
        return;
    L47:
        if (r11.intValue() != 2) goto L49;
        r12 = "1";
        goto L50
    L42:
        r3 = "anchor";
        goto L43
    L28:
        if (je0.d.r() == false) goto L33;
        com.bytedance.android.live.liveinteract.voicechat.d.s0.getClass();
        com.bytedance.android.live.liveinteract.voicechat.d r14 = com.bytedance.android.live.liveinteract.voicechat.d.a.a();
        if (r14 == null) goto L37;
        r14.onVoiceAnchorAvatarClicked();
        goto L37
    L33:
        if (hd0.c.f().h() == false) goto L37;
        IVoiceChatGuestService r15 = IVoiceChatGuestService.a.a();
        if (r15 == null) goto L37;
        r15.onVoiceAnchorAvatarClicked();
        goto L37
    L52:
        if (r7 != 2131374075) goto L54;
    L55:
        IRoom r16 = this.l;
        if (r16 == null) goto L62;
        r16.getOwner();
        return;
    L62:
        return;
    L54:
        if (r7 == 2131388292) goto L55;
        return;
    L19:
        r7 = 0;
        goto L21
    }

    public final void setDataCenter(DataCenter r3) {
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        this.k = r3;
        ((Boolean) r3.get("data_is_anchor", Boolean.FALSE)).booleanValue();
        PositionNameTv r0 = this.i;
        if (r0 == null) goto L6;
        r0.setDataCenter(r3);
        return;
    }

    public final void setUserNameVisibility(int r2) {
        this.g.setVisibility(r2);
    }

    @Override // android.view.View
    public void setVisibility(int r4) {
        super.setVisibility(r4);
        if (r4 != 0) goto L5;
        StringBuilder r1 = new StringBuilder("VISIBLE(");
        r1.append(r4);
        r1.append(')');
    L12:
        Log.getStackTraceString(new Throwable());
        return;
    L5:
        if (r4 != 4) goto L7;
        StringBuilder r2 = new StringBuilder("INVISIBLE(");
        r2.append(r4);
        r2.append(')');
        goto L12
    L7:
        if (r4 == 8) goto L9;
        StringBuilder r3 = new StringBuilder("UNKNOWN(");
        r3.append(r4);
        r3.append(')');
        goto L12
    L9:
        StringBuilder r5 = new StringBuilder("GONE(");
        r5.append(r4);
        r5.append(')');
        goto L12
    }

    public VoiceChatRoomAnchorView(Context r23, AttributeSet r24, int r25) {
        Intrinsics.checkNotNullParameter(r23, "context");
        super(r23, r24, r25);
        this.a = new LinkedHashMap();
        this.b = "VoiceChatRoomAnchorView";
        c r13 = new c(this);
        this.v = r13;
        String r14 = "";
        this.w = "";
        this.x = new CompositeDisposable();
        LayoutInflater.from(r23).inflate(getResourceLayout(), this, true);
        this.o = findViewById(2131389453);
        this.c = findViewById(2131362578);
        HSImageView r3 = findViewById(2131383601);
        this.d = r3;
        HSImageView r12 = findViewById(2131389468);
        this.e = r12;
        this.f = (SeatAnimationView) findViewById(2131385655);
        this.g = (TextView) findViewById(2131392049);
        LinkMicQuickInteractView r11 = (LinkMicQuickInteractView) findViewById(2131374075);
        this.h = r11;
        LinkMicQuickInteractView r4 = (LinkMicQuickInteractView) findViewById(2131388292);
        AnchorPauseTipsView r10 = findViewById(2131381984);
        PositionNameTv r5 = (PositionNameTv) findViewById(2131391136);
        this.i = r5;
        r5.setDataCenter(this.k);
        this.j = (SeatPosTagLabelTextView) findViewById(2131391134);
        LinearLayout r7 = (LinearLayout) findViewById(2131374095);
        HSImageView r8 = findViewById(2131374094);
        TextView r9 = (TextView) findViewById(2131374096);
        LinearLayout r15 = (LinearLayout) findViewById(2131374098);
        HSImageView r16 = findViewById(2131374097);
        TextView r17 = (TextView) findViewById(2131374099);
        TextView r18 = (TextView) findViewById(2131374093);
        LottieAnimationView r19 = findViewById(2131374103);
        r12.setOnClickListener(this);
        r11.setOnClickListener(this);
        if (r4 == null) goto L5;
        r4.setOnClickListener(this);
    L5:
        this.s = new j22.c(r3);
        k r20 = new k();
        this.n = r20;
        SeatPosTagLabelTextView r6 = (SeatPosTagLabelTextView) findViewById(2131391134);
        RequestSongMicSeatView r21 = (RequestSongMicSeatView) findViewById(2131384399);
        Intrinsics.checkNotNullParameter(r23, "context");
        r20.a = r21;
        if (r21 == null) goto L9;
        RequestSongMicSeatView.m(r21, r23, MicSeatScene.AUDIO_LINK_ANCHOR, r5, null, true, false, false, false, false, null, 1000);
    L9:
        ILinkPlayerInfoBridge r1 = r20.c;
        String r2 = null;
        if (r1 != null) goto L21;
        i<ILinkPlayerInfoBridge> r22 = ((IInteractService) jc1.k.n(IInteractService.class)).getLinkUserInfoCenter();
        if (r22 == null) goto L20;
        IRoom r26 = r20.b;
        if (r26 == null) goto L18;
        String r27 = r26.getOwnerUserIdString();
        if (r27 == null) goto L18;
    L19:
        r1 = (ILinkPlayerInfoBridge) r22.getGuestInfo(r27, "");
    L18:
        r27 = "";
        goto L19
    L20:
        r1 = null;
    L21:
        if (r1 == null) goto L25;
        RequestSongMicSeatView r28 = r20.a;
        if (r28 == null) goto L25;
        r28.l(r1, 0);
    L25:
        this.m = (ThemedCompetitionQuickInteractView) findViewById(2131389836);
        if (((Boolean) vm2.d.i5.getValue(null, vm2.d.a[318(0x13e, float:4.46E-43)])).booleanValue() == false) goto L30;
        i<ILinkPlayerInfoBridge> r29 = ((IInteractService) jc1.k.n(IInteractService.class)).getLinkUserInfoCenter();
        if (r29 == null) goto L30;
        r29.Q4(r13);
    L30:
        r10.R5();
        AnchorPauseTipsView.U5(r10, 14.0f);
        r2.a(r10, r12.getLayoutParams().width / 2);
        ILinkPlayerInfoBridge r30 = getAnchorInfo();
        if (r30 == null) goto L33;
        r2 = r30.getFanTicketDisplayStr();
    L33:
        com.bytedance.android.live.liveinteract.videotalk.quickinteract.b.C0101b r31 = com.bytedance.android.live.liveinteract.videotalk.quickinteract.b.r0;
        ILinkPlayerInfoBridge r32 = getAnchorInfo();
        r31.getClass();
        if (com.bytedance.android.live.liveinteract.videotalk.quickinteract.b.C0101b.c(r32) == false) goto L50;
        com.bytedance.android.live.liveinteract.videotalk.quickinteract.b r33 = com.bytedance.android.live.liveinteract.videotalk.quickinteract.b.C0101b.a();
        if (r33 == null) goto L50;
        if (r33.isEmpty() == true) goto L50;
        if (LinkRoomFightContext.Companion.c() == true) goto L50;
        if (ThemedCompetitionContext.Companion.g() == true) goto L50;
        com.bytedance.android.live.liveinteract.videotalk.quickinteract.b r34 = com.bytedance.android.live.liveinteract.videotalk.quickinteract.b.C0101b.a();
        if (r34 == null) goto L66;
        String r35 = je0.d.b0();
        if (r2 != null) goto L48;
        String r36 = "0";
    L49:
        r34.Si(new QuickInteractTask(r35, r36, 0, null, null, null, 0, null, false, null, null, null, null, 8188), true);
        return;
    L48:
        r36 = r2;
        goto L49
    L66:
        return;
    L50:
        if (r2 != null) goto L56;
        ILinkPlayerInfoBridge r37 = getAnchorInfo();
        if (r37 == null) goto L55;
        r2 = r37.getFanTicketDisplayStr();
        if (r2 != null) goto L56;
    L55:
        r2 = "0";
    L56:
        ILinkPlayerInfoBridge r38 = getAnchorInfo();
        if (r38 == null) goto L64;
        IBaseUser r39 = r38.getUser();
        if (r39 == null) goto L64;
        String r40 = r39.getIdString();
        if (r40 == null) goto L64;
        r14 = r40;
    L64:
        r11.b(r2, r14);
    }

    public /* synthetic */ VoiceChatRoomAnchorView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
