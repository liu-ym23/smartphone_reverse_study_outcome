package com.bytedance.android.live.liveinteract.interactivesong.impl;

import android.text.TextUtils;
import android.widget.FrameLayout;
import com.bytedance.android.live.base.model.message.ILinkmicEnlargeGuestMessage;
import com.bytedance.android.live.base.model.message.d6;
import com.bytedance.android.live.base.model.message.f6;
import com.bytedance.android.live.base.model.message.l3;
import com.bytedance.android.live.base.model.message.s2;
import com.bytedance.android.live.base.model.message.t2;
import com.bytedance.android.live.base.model.message.v2;
import com.bytedance.android.live.base.model.message.w2;
import com.bytedance.android.live.base.model.message.x2;
import com.bytedance.android.live.base.model.message.y2;
import com.bytedance.android.live.base.model.message.z2;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.o0;
import com.bytedance.android.live.broadcast.api.model.z0;
import com.bytedance.android.live.browser.IBaseBrowserService;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.core.setting.u2;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.i0;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.live.liveinteract.api.utils.LiveSeiUtil;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.playmode.AbsPlayModeWidget;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.interactivesong.RequestSongSingState;
import com.bytedance.android.live.liveinteract.customizestream.CustomizeStreamContext;
import com.bytedance.android.live.liveinteract.interactivesong.logger.InteractiveSongLoggerKt;
import com.bytedance.android.live.liveinteract.interactivesong.logger.OpenSource;
import com.bytedance.android.live.liveinteract.interactivesong.logger.UserType;
import com.bytedance.android.live.liveinteract.interactivesong.panel.InteractiveSongMvManager;
import com.bytedance.android.live.liveinteract.interactivesong.speech.SpeechRhythm;
import com.bytedance.android.live.liveinteract.plantform.datamerge.LinkUserDataMergeContext;
import com.bytedance.android.live.liveinteract.plantform.datamerge.handler.p;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.utils.h0;
import com.bytedance.android.live.liveinteract.plantform.utils.s0;
import com.bytedance.android.live.liveinteract.plantform.utils.u0;
import com.bytedance.android.live.liveinteract.revenue.fight.TeamFightContext;
import com.bytedance.android.live.liveinteract.revenue.linkroomfight.core.LinkRoomFightContext;
import com.bytedance.android.live.liveinteract.utils.MultiLinkLoadWidgetUtils;
import com.bytedance.android.live.liveinteract.voicechat.IVoiceChatGuestService;
import com.bytedance.android.live.liveinteract.wrds.LinkWRDSHelper;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.model.interact.IMVBaseInfo;
import com.bytedance.android.livesdk.chatroom.model.interact.IOrderSingMVInfo;
import com.bytedance.android.livesdk.chatroom.model.interact.OrderSingItemAction;
import com.bytedance.android.livesdk.chatroom.model.interact.j0;
import com.bytedance.android.livesdk.chatroom.model.q2;
import com.bytedance.android.livesdk.chatroom.u;
import com.bytedance.android.livesdk.chatroom.utils.o3;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget;
import com.bytedance.android.livesdk.gift.model.h2;
import com.bytedance.android.livesdk.j1;
import com.bytedance.android.livesdk.link.model.bridge.Linkmic2DAvatar;
import com.bytedance.android.livesdk.link.model.bridge.f1;
import com.bytedance.android.livesdk.link.model.bridge.h1;
import com.bytedance.android.livesdk.link.model.bridge.k1;
import com.bytedance.android.livesdk.link.model.bridge.l1;
import com.bytedance.android.livesdk.link.model.z5;
import com.bytedance.android.livesdk.message.model.LinkmicOrderSingMessageType;
import com.bytedance.android.livesdk.message.model.MVOperation;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.utils.MultiLinkSettingHelper;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.android.livesdk.wrds.LinkMicRoomDataSyncModel;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.android.livesdkapi.depend.message.IRoomLinkMicSyncData;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerLeaveContentBridge;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.LiveMemLeakConfig;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdkapi.model.MultiLinkFirstFrameOptConfigV2;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import fd2.t;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.BehaviorSubject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import tf0.o;
import uf2.d0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\b\u0012\u0004\u0012\u00020\u00050\u0004:\u0001\bB\u0007¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/liveinteract/interactivesong/impl/InteractiveSongWidget;", "Lcom/bytedance/android/live/liveinteract/chatroom/chatroom/playmode/AbsPlayModeWidget;", "Lvlc/l;", "Lof0/b;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "<init>", "()V", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class InteractiveSongWidget extends AbsPlayModeWidget implements vlc.l, of0.b, Observer<KVData> {
    public static final /* synthetic */ int C = 0;
    public final Function1<IOrderSingMVInfo, Unit> A;
    public final Function1<Long, Unit> B;
    public boolean a;
    public InteractiveSongViewModel b;
    public vlc.d c;
    public final CompositeDisposable d;
    public boolean e;
    public boolean f;
    public boolean g;
    public Integer h;
    public final SpeechRhythm i;
    public final MultiLinkFirstFrameOptConfigV2 j;
    public boolean k;
    public List<Long> l;
    public List<Long> m;
    public boolean n;
    public boolean o;
    public com.bytedance.android.live.liveinteract.plantform.datamerge.handler.i p;
    public p q;
    public String r;
    public boolean s;
    public String t;
    public String u;
    public HSImageView v;
    public FrameLayout w;
    public InteractiveSongMvManager x;
    public boolean y;
    public com.bytedance.android.live.liveinteract.interactivesong.speech.a z;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ InteractiveSongWidget a;

        public b(InteractiveSongWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            if (((Boolean) r2).booleanValue() == false) goto L7;
            FrameLayout r3 = this.a.w;
            if (r3 == null) goto L13;
            r3.setVisibility(8);
            return;
        L13:
            return;
        L7:
            InteractiveSongWidget r4 = this.a;
            if (r4.k == false) goto L15;
            FrameLayout r5 = r4.w;
            if (r5 == null) goto L16;
            r5.setVisibility(0);
            return;
        L16:
            return;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ InteractiveSongWidget a;

        public c(InteractiveSongWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            Iterator<T> r6 = ((IRoomLinkMicSyncData) ((dc2.c.b) r5).b).getMLinkUsers().iterator();
        L3:
            String r1 = null;
            if (r6.hasNext() == false) goto L16;
            T r0 = r6.next();
            k1 r2 = ((com.bytedance.android.livesdk.link.model.bridge.k) r0).getContent();
            if (r2 == null) goto L12;
            l1 r3 = r2.getLinkMicAudienceContent();
            if (r3 == null) goto L12;
            Linkmic2DAvatar r4 = r3.getLinkmic2DAvatar();
            if (r4 == null) goto L12;
            Boolean r7 = r4.getEnableAvatar();
        L14:
            if (Intrinsics.areEqual(r7, Boolean.TRUE) == false) goto L3;
        L17:
            com.bytedance.android.livesdk.link.model.bridge.k r8 = (com.bytedance.android.livesdk.link.model.bridge.k) r0;
            if (r8 == null) goto L22;
            IBaseUser r9 = r8.getUser();
            if (r9 == null) goto L22;
            String r10 = r9.getIdString();
        L24:
            if (Intrinsics.areEqual(r10, je0.d.b0()) == false) goto L28;
            InteractiveSongWidget r11 = this.a;
            int r12 = InteractiveSongWidget.C;
            r11.getClass();
            if (InteractiveSongWidget.Iq() == false) goto L28;
            this.a.i.i("2d_avatar");
        L28:
            if (r8 == null) goto L34;
            IBaseUser r13 = r8.getUser();
            if (r13 == null) goto L33;
            r1 = r13.getIdString();
        L33:
            if ((!Intrinsics.areEqual(r1, je0.d.b0())) == true) goto L34;
            return;
        L34:
            SpeechRhythm r14 = this.a.i;
            if (r14.c == false) goto L42;
            r14.j("2d_avatar");
            return;
        L42:
            return;
        L22:
            r10 = null;
        L12:
            r7 = null;
            goto L14
        L16:
            r0 = null;
            goto L17
        }
    }

    public static final class d implements t {
        public final /* synthetic */ InteractiveSongWidget a;

        public final void a() {
        }

        public final void c() {
        }

        public d(InteractiveSongWidget r1) {
            this.a = r1;
        }

        public final void d(boolean r5) {
            InteractiveSongContext.a r0 = InteractiveSongContext.Companion;
            InteractiveSongContext r1 = r0.getContext();
            if (r1 == null) goto L9;
            m<Boolean> r2 = r1.isAIMVStage();
            if (r2 == null) goto L9;
            Boolean r3 = (Boolean) r2.getValue();
            if (r3 == null) goto L9;
            boolean r4 = r3.booleanValue();
        L11:
            if (r5 == false) goto L15;
            if (r4 == false) goto L28;
            this.a.i.i("ai_mv");
            return;
        L28:
            return;
        L15:
            if (this.a.i.c == false) goto L30;
            InteractiveSongContext r6 = r0.getContext();
            if (r6 == null) goto L21;
            m<Integer> r7 = r6.getCurrentIsInSongRefrain();
            if (r7 == null) goto L21;
            r7.setValue(0);
        L21:
            InteractiveSongContext r8 = r0.getContext();
            if (r8 == null) goto L26;
            m<String> r9 = r8.getCurrentMvEmoTag();
            if (r9 == null) goto L26;
            r9.setValue("");
        L26:
            this.a.i.j("ai_mv");
            return;
        L30:
            return;
        L9:
            r4 = false;
            goto L11
        }

        public final void b(String r3, Integer r4) {
            InteractiveSongContext.a r0 = InteractiveSongContext.Companion;
            InteractiveSongContext r1 = r0.getContext();
            if (r1 == null) goto L9;
            m<String> r2 = r1.getCurrentMvEmoTag();
            if (r2 == null) goto L9;
            if (r3 != null) goto L8;
            r3 = "";
        L8:
            r2.setValue(r3);
        L9:
            InteractiveSongContext r5 = r0.getContext();
            if (r5 == null) goto L18;
            m<Integer> r6 = r5.getCurrentIsInSongRefrain();
            if (r6 == null) goto L19;
            if (r4 == null) goto L15;
            int r7 = r4.intValue();
        L16:
            r6.setValue(Integer.valueOf(r7));
            return;
        L15:
            r7 = 0;
            goto L16
        L19:
            return;
        }
    }

    static {
    }

    @Override // xh0.b
    public final ArrayList<xh0.f> getIncompatibleSourceList() {
        return null;
    }

    @Override // xh0.b
    public final boolean isOpen() {
        return false;
    }

    @Override // xh0.b
    public final void tryStartPlayMode(HashMap<String, Object> r1) {
    }

    @Override // xh0.b
    public final void tryStopPlayMode(HashMap<String, Object> r1) {
    }

    public final void Aq() {
        CustomizeStreamContext r0 = CustomizeStreamContext.Companion.getContext();
        if (r0 == null) goto L12;
        m<Boolean> r1 = r0.getCustomizeStreamStarted();
        if (r1 == null) goto L13;
        Observable r2 = r1.a();
        if (r2 == null) goto L14;
        Disposable r3 = r2.subscribe(new b(this));
        if (r3 == null) goto L15;
        RxUtilKt.c(r3, this.d);
        return;
    L15:
        return;
    L14:
        return;
    L13:
        return;
    }

    public final void Kq() {
        com.bytedance.android.livesdk.sharedpref.e r0 = b6.F;
        q2 r1 = (q2) r0.getValue();
        if (r1 != null) goto L5;
        return;
    L5:
        r1.h(TextUtils.join(",", this.l));
        r1.i(Boolean.valueOf(this.o));
        r1.g(Boolean.valueOf(this.s));
        r1.f(TextUtils.join(",", this.m));
        r1.j(Boolean.valueOf(this.n));
        r0.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r0, r1);
    }

    @Override // xh0.b
    public final xh0.h getPlayModeInfo() {
        return new xh0.h(19, s1.B(2131918014));
    }

    public final boolean isAnchor() {
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 != null) goto L5;
        return false;
    L5:
        return a0.d(r0, false);
    }

    public final void xq() {
        if (this.w == null) goto L6;
        return;
    L6:
        if (MultiLinkLoadWidgetUtils.g() == false) goto L8;
        FrameLayout r0 = new FrameLayout(((Widget) this).context);
        zd0.c r1 = new zd0.c(r0);
        int r2 = vd0.a.g;
        vd0.a.C0284a.a(((Widget) this).dataCenter).b(3000, 3001, r1);
        Unit r3 = Unit.INSTANCE;
        this.w = r0;
    L22:
        FrameLayout r4 = this.w;
        if (r4 == null) goto L28;
        InteractiveSongMvManager r5 = this.x;
        if (r5 == null) goto L29;
        r5.h(r4);
        return;
    L29:
        return;
    L28:
        return;
    L8:
        if (isAnchor() == false) goto L14;
        com.bytedance.android.live.liveinteract.voicechat.d.s0.getClass();
        com.bytedance.android.live.liveinteract.voicechat.d r6 = com.bytedance.android.live.liveinteract.voicechat.d.a.a();
        if (r6 == null) goto L19;
        o r7 = r6.commonWindowManager();
        if (r7 == null) goto L19;
        FrameLayout r8 = r7.D();
    L20:
        this.w = r8;
    L19:
        r8 = null;
        goto L20
    L14:
        IVoiceChatGuestService.Companion.getClass();
        IVoiceChatGuestService r9 = IVoiceChatGuestService.a.a();
        if (r9 == null) goto L19;
        o r10 = r9.commonWindowManager();
        if (r10 == null) goto L19;
        r8 = r10.D();
        goto L20
    }

    public final String zq() {
        String r0 = this.u;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L13;
        String r2 = this.u;
        Intrinsics.checkNotNull(r2);
        return r2;
    L13:
        return UserType.ADMIN.getValue();
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    public InteractiveSongWidget() {
        this.d = new CompositeDisposable();
        this.e = true;
        this.i = new SpeechRhythm(this, ((Widget) this).dataCenter);
        this.j = (MultiLinkFirstFrameOptConfigV2) u2.a.getValue();
        this.l = new ArrayList();
        this.m = new ArrayList();
        this.y = true;
        this.A = new InteractiveSongWidget$setMvInfoCallBack$1(this);
        this.B = new InteractiveSongWidget$mvProgressCB$1(this);
    }

    public static boolean Iq() {
        if (je0.d.f() != 5) goto L11;
        Integer r0 = je0.d.h();
        if (r0 == null) goto L11;
        if (r0.intValue() != 27) goto L11;
        if (InteractiveSongContext.Companion.f() == false) goto L11;
    L16:
        return true;
    L11:
        Integer r1 = je0.d.h();
        if (r1 != null) goto L15;
    L17:
        return false;
    L15:
        if (r1.intValue() != 30) goto L17;
        goto L16
    }

    public final void Bq() {
        if (vm2.c.g() == true) goto L5;
        return;
    L5:
        LinkMicRoomDataSyncModel r0 = LinkWRDSHelper.b();
        if (r0 == null) goto L15;
        dc2.c r1 = r0.getTalkRoomListUserInfoPb();
        if (r1 == null) goto L16;
        Observable r2 = r1.e;
        if (r2 == null) goto L17;
        Disposable r3 = r2.subscribe(new c(this));
        if (r3 == null) goto L18;
        RxUtilKt.c(r3, this.d);
        return;
    L18:
        return;
    L17:
        return;
    L16:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.chatroom.chatroom.playmode.AbsPlayModeWidget, com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget
    public final int getScene() {
        return je0.d.f();
    }

    @Override // com.bytedance.android.live.liveinteract.chatroom.chatroom.playmode.AbsPlayModeWidget, com.bytedance.android.live.liveinteract.linkpanel.widget.PlatformMultiLinkWidget, com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget
    public final void onCreate() {
        super.onCreate();
        if (this.j.isEnableInteractiveSongHandlerOpt() == true) goto L5;
    L8:
        boolean r0 = true;
    L10:
        if (r0 == false) goto L27;
        LinkUserDataMergeContext.a r1 = LinkUserDataMergeContext.Companion;
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r4 = LinkUserDataMergeContext.a.b(r1, ((Widget) this).dataCenter);
        if (r4 == null) goto L15;
        com.bytedance.android.live.liveinteract.plantform.datamerge.handler.i r5 = new com.bytedance.android.live.liveinteract.plantform.datamerge.handler.i();
        this.p = r5;
        Intrinsics.checkNotNull(r5);
        r4.M0(r5);
    L15:
        LinkUserDataMergeContext r2 = r1.getContext(((Widget) this).dataCenter, "");
        if (r2 == null) goto L20;
        com.bytedance.live.datacontext.j<com.bytedance.android.live.liveinteract.plantform.datamerge.b> r3 = r2.getLinkRoomFightDataMergeCenter();
        if (r3 == null) goto L20;
        com.bytedance.android.live.liveinteract.plantform.datamerge.b r6 = (com.bytedance.android.live.liveinteract.plantform.datamerge.b) r3.getValue();
    L22:
        if ((r6 instanceof com.bytedance.android.live.liveinteract.plantform.datamerge.h) == true) goto L24;
        r6 = null;
    L24:
        com.bytedance.android.live.liveinteract.plantform.datamerge.h r7 = (com.bytedance.android.live.liveinteract.plantform.datamerge.h) r6;
        if (r7 == null) goto L27;
        p r8 = new p();
        this.q = r8;
        Intrinsics.checkNotNull(r8);
        Intrinsics.checkNotNullParameter(r8, "handler");
        Intrinsics.checkNotNullParameter(r7, "proxy");
        r8.a = r7;
        r7.b.add(r8);
        r8.b = true;
    L20:
        r6 = null;
    L27:
        vlc.d r9 = (vlc.d) ((Widget) this).dataCenter.get("data_message_manager");
        this.c = r9;
        if (r9 == null) goto L30;
        r9.addMessageListener(MessageType.LINK_MIC_ORDER_SING_MESSAGE.getKey(), this);
    L30:
        vlc.d r10 = this.c;
        if (r10 == null) goto L33;
        r10.addMessageListener(MessageType.LINK_MIC_ORDER_SING_SCORE_MESSAGE.getKey(), this);
    L33:
        vlc.d r11 = this.c;
        if (r11 == null) goto L36;
        r11.addMessageListener(MessageType.LINKER.getKey(), this);
    L36:
        vlc.d r12 = this.c;
        if (r12 == null) goto L39;
        r12.addMessageListener(MessageType.LINK_MIC_ENLARGE_GUEST_MESSAGE.getKey(), this);
    L39:
        Pair r13 = com.bytedance.live.datacontext.d.a(InteractiveSongWidget$initContext$pair$1.INSTANCE);
        InteractiveSongContext r14 = (InteractiveSongContext) r13.getFirst();
        r14.getInteractiveSongWidget().d(this);
        com.bytedance.live.datacontext.b.a(r14, InteractiveSongContext.TAG_FOR_LIVE);
        m<Boolean> r15 = r14.getShowOrderSingStage();
        DataCenter r16 = ((Widget) this).dataCenter;
        if (r16 == null) goto L42;
        Boolean r17 = (Boolean) r16.get("data_order_sing_stage_is_inert", Boolean.FALSE);
    L43:
        Boolean r18 = Boolean.TRUE;
        r15.setValue(Boolean.valueOf(Intrinsics.areEqual(r17, r18)));
        this.d.add((Disposable) r13.getSecond());
        Pair r19 = com.bytedance.live.datacontext.d.a(InteractiveSongWidget$initContext$interactiveSongViewModelPair$1.INSTANCE);
        this.b = (InteractiveSongViewModel) r19.getFirst();
        this.d.add((Disposable) r19.getSecond());
        DataCenter r20 = ((Widget) this).dataCenter;
        if (r20 == null) goto L46;
        r20.put("data_inner_interactive_song_context_init", r18);
    L46:
        DataCenter r21 = ((Widget) this).dataCenter;
        if (r21 == null) goto L49;
        IRoom r22 = a0.o(r21);
    L50:
        com.bytedance.android.live.liveinteract.interactivesong.speech.a r23 = new com.bytedance.android.live.liveinteract.interactivesong.speech.a(r22, isAnchor(), ((Widget) this).dataCenter, this, new d(this));
        this.z = r23;
        cg6.a r24 = r23.c();
        if (r24 == null) goto L56;
        vb6.g r25 = r24.O5();
        if (r25 == null) goto L56;
        r25.X0(new com.bytedance.android.live.liveinteract.interactivesong.speech.b(r23), false);
    L56:
        if (r23.i == false) goto L85;
        TeamFightContext r26 = TeamFightContext.Companion.getContext();
        if (r26 == null) goto L66;
        m<Integer> r27 = r26.getFightStatus();
        if (r27 == null) goto L66;
        Observable r28 = r27.a();
        if (r28 == null) goto L66;
        Disposable r29 = r28.subscribe(new com.bytedance.android.live.liveinteract.interactivesong.speech.c(r23));
        if (r29 == null) goto L66;
        RxUtilKt.c(r29, r23.d);
    L66:
        r23.d.add(xs2.b.a().b(jd0.d.class).subscribe(new com.bytedance.android.live.liveinteract.interactivesong.speech.d(r23)));
        IRoom r30 = r23.h;
        if (r30 == null) goto L75;
        Map r31 = r30.getAnchorABMap();
        if (r31 == null) goto L75;
        String r32 = (String) r31.get("linkmic_order_sing_ai_mv");
        if (r32 == null) goto L75;
        if (CastIntegerProtector.parseInt(r32) != 1) goto L75;
        boolean r33 = true;
    L76:
        u r34 = o3.d();
        if (r34 == null) goto L85;
        com.bytedance.live.datacontext.j r35 = r34.s();
        if (r35 == null) goto L85;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r36 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r35.getValue();
        if (r36 == null) goto L85;
        BehaviorSubject r37 = r36.a();
        if (r37 == null) goto L85;
        r37.subscribe(new com.bytedance.android.live.liveinteract.interactivesong.speech.e(r33));
    L75:
        r33 = false;
    L85:
        DataCenter r38 = ((Widget) this).dataCenter;
        if (r38 == null) goto L90;
        Boolean r39 = (Boolean) r38.get("key_order_song_first_load", Boolean.FALSE);
        if (r39 == null) goto L90;
        boolean r40 = r39.booleanValue();
    L92:
        if (((Boolean) MultiLinkSettingHelper.c.getValue()).booleanValue() == true) goto L95;
        r40 = true;
    L95:
        int r41 = com.bytedance.android.live.liveinteract.aimv.b.a;
        m r42 = com.bytedance.android.live.liveinteract.api.utils.m.j(this).getRoom();
        if (r42 == null) goto L98;
        IRoom r43 = (IRoom) r42.getValue();
    L99:
        boolean r44 = com.bytedance.android.live.liveinteract.aimv.b.b(r43);
        m r45 = com.bytedance.android.live.liveinteract.api.utils.m.j(this).getRoom();
        if (r45 == null) goto L109;
        IRoom r46 = (IRoom) r45.getValue();
        if (r46 == null) goto L109;
        z5 r47 = r46.getLinkerDetail();
        if (r47 == null) goto L109;
        List r48 = r47.getPlayModes();
        if (r48 == null) goto L109;
        if (r48.contains(Long.valueOf(19)) != true) goto L109;
    L119:
        boolean r49 = true;
    L122:
        if (((Boolean) vm2.d.c8.getValue(null, vm2.d.a[467(0x1d3, float:6.54E-43)])).booleanValue() == true) goto L132;
        if (r40 == false) goto L132;
        if (r49 == false) goto L132;
        DataCenter r50 = ((Widget) this).dataCenter;
        if (r50 == null) goto L128;
        r50.put("key_order_song_first_load", Boolean.FALSE);
    L128:
        InteractiveSongContext.Companion.g(true, true, r44, String.valueOf(19));
        com.bytedance.android.live.liveinteract.plantform.datamerge.handler.i r51 = this.p;
        if (r51 == null) goto L132;
        r51.d(true);
    L132:
        if (isAnchor() == true) goto L155;
        m r52 = com.bytedance.android.live.liveinteract.api.utils.m.j(this).getRoom();
        if (r52 == null) goto L143;
        IRoom r53 = (IRoom) r52.getValue();
        if (r53 == null) goto L143;
        z5 r54 = r53.getLinkerDetail();
        if (r54 == null) goto L143;
        List r55 = r54.getPlayModes();
        if (r55 == null) goto L143;
        if (r55.contains(Long.valueOf(19)) != true) goto L143;
    L153:
        ((Widget) this).dataCenter.observe("data_online_changed_list", this, true);
        ((Widget) this).dataCenter.observe("data_room_audio_chat_ui_layout_before", this);
        ((Widget) this).dataCenter.observe("data_room_audio_chat_ui_layout", this);
    L143:
        m r56 = com.bytedance.android.live.liveinteract.api.utils.m.j(this).getRoom();
        if (r56 == null) goto L155;
        IRoom r57 = (IRoom) r56.getValue();
        if (r57 == null) goto L155;
        j0 r58 = r57.getLinkInitResult();
        if (r58 == null) goto L155;
        List r59 = r58.getPlayModes();
        if (r59 == null) goto L155;
        if (r59.contains(19) == true) goto L153;
    L155:
        if (isAnchor() == false) goto L168;
        m r60 = com.bytedance.android.live.liveinteract.api.utils.m.j(this).getRoom();
        if (r60 == null) goto L168;
        IRoom r61 = (IRoom) r60.getValue();
        if (r61 == null) goto L168;
        j0 r62 = r61.getLinkInitResult();
        if (r62 == null) goto L168;
        List r63 = r62.getPlayModes();
        if (r63 == null) goto L168;
        if (r63.contains(19) != true) goto L168;
        ((Widget) this).dataCenter.observe("data_online_changed_list", this, true);
        ((Widget) this).dataCenter.observe("data_room_audio_chat_ui_layout", this);
    L168:
        if (isAnchor() == false) goto L171;
        RxUtilKt.c(((ObservableSubscribeProxy) jc1.k.n(IBaseBrowserService.class).registerJsEventSubscriber("livesdk_anchor_playmode_open_success").observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind(this))).subscribe(new i(this)), this.d);
        RxUtilKt.c(((ObservableSubscribeProxy) jc1.k.n(IBaseBrowserService.class).registerJsEventSubscriber("livesdk_anchor_playmode_over").observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind(this))).subscribe(new j(this)), this.d);
        ((Widget) this).dataCenter.observe("data_room_audio_chat_ui_layout", this);
        ((Widget) this).dataCenter.observe("data_room_audio_chat_ui_layout_before", this);
    L173:
        TeamFightContext r65 = TeamFightContext.Companion.getContext();
        if (r65 == null) goto L182;
        m<Integer> r66 = r65.getFightStatus();
        if (r66 == null) goto L182;
        Observable r67 = r66.a();
        if (r67 == null) goto L182;
        Disposable r68 = r67.subscribe(new com.bytedance.android.live.liveinteract.interactivesong.impl.b(this));
        if (r68 == null) goto L182;
        RxUtilKt.c(r68, this.d);
    L182:
        LinkRoomFightContext r69 = LinkRoomFightContext.Companion.getContext();
        if (r69 == null) goto L191;
        m<com.bytedance.android.live.liveinteract.revenue.linkroomfight.core.c.b> r70 = r69.getFightState();
        if (r70 == null) goto L191;
        Observable r71 = r70.a();
        if (r71 == null) goto L191;
        Disposable r72 = r71.subscribe(new com.bytedance.android.live.liveinteract.interactivesong.impl.c(this));
        if (r72 == null) goto L191;
        RxUtilKt.c(r72, this.d);
    L191:
        Aq();
        Disposable r73 = xs2.b.a().b(jd0.a.class).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.live.liveinteract.interactivesong.impl.d(this));
        if (r73 == null) goto L194;
        RxUtilKt.c(r73, this.d);
    L194:
        InteractiveSongViewModel r74 = this.b;
        if (r74 == null) goto L198;
        r74.observeOrderSingListUserMicrophone(this, new e(this));
    L198:
        if (isAnchor() == true) goto L201;
        this.d.add(xs2.b.a().b(pv0.c.class).observeOn(AndroidSchedulers.mainThread()).subscribe(new f(this)));
    L201:
        if (vm2.c.j() == false) goto L211;
        InteractiveSongContext r75 = InteractiveSongContext.Companion.getContext();
        if (r75 == null) goto L211;
        m<Boolean> r76 = r75.m130isOpenInteractiveSong();
        if (r76 == null) goto L211;
        Observable r77 = r76.a();
        if (r77 == null) goto L211;
        Disposable r78 = r77.subscribe(g.a);
        if (r78 == null) goto L211;
        RxUtilKt.c(r78, this.d);
    L211:
        Bq();
        com.bytedance.android.livesdk.chatroom.t r79 = jc1.k.n(IRoomContextService.class).getRoomInteractivityService(((MiddlewareRoomWidget) this).dataContext);
        if (r79 == null) goto L220;
        n r80 = r79.a();
        if (r80 == null) goto L220;
        ArrayList r81 = (ArrayList) r80.getValue();
        if (r81 == null) goto L220;
        if (r81.contains(19) != true) goto L220;
        boolean r82 = true;
    L221:
        if (r82 == false) goto L229;
        com.bytedance.android.livesdk.chatroom.t r83 = jc1.k.n(IRoomContextService.class).getRoomInteractivityService(((MiddlewareRoomWidget) this).dataContext);
        if (r83 == null) goto L229;
        n r84 = r83.a();
        if (r84 == null) goto L229;
        ArrayList r85 = (ArrayList) r84.getValue();
        if (r85 == null) goto L229;
        r85.remove(19);
    L229:
        if (r82 == false) goto L234;
        com.bytedance.live.datacontext.j r86 = com.bytedance.android.live.liveinteract.api.utils.m.j(this).s2();
        if (r86 == null) goto L233;
        z0 r87 = (z0) r86.getValue();
    L233:
        Gq(false, null);
    L234:
        m r88 = com.bytedance.android.live.liveinteract.api.utils.m.j(this).getRoom();
        if (r88 == null) goto L242;
        IRoom r89 = (IRoom) r88.getValue();
        if (r89 != null) goto L239;
        return;
    L239:
        if (r89.isLiveTypeAudio() != true) goto L244;
        this.x = new InteractiveSongMvManager(((Widget) this).context, ((Widget) this).dataCenter);
        return;
    L244:
        return;
    L242:
        return;
    L220:
        r82 = false;
        goto L221
    L171:
        if (isAnchor() == true) goto L173;
        ((Widget) this).dataCenter.observe("data_room_audio_chat_ui_layout", this);
        ((Widget) this).dataCenter.observe("data_room_audio_chat_ui_layout_before", this);
    L109:
        m r90 = com.bytedance.android.live.liveinteract.api.utils.m.j(this).getRoom();
        if (r90 == null) goto L120;
        IRoom r91 = (IRoom) r90.getValue();
        if (r91 == null) goto L120;
        j0 r92 = r91.getLinkInitResult();
        if (r92 == null) goto L120;
        List r93 = r92.getPlayModes();
        if (r93 == null) goto L120;
        if (r93.contains(19) == true) goto L119;
    L120:
        r49 = false;
        goto L122
    L98:
        r43 = null;
    L90:
        r40 = false;
        goto L92
    L49:
        r22 = null;
        goto L50
    L42:
        r17 = null;
        goto L43
    L5:
        if (PadConfigUtils.a() == true) goto L8;
        r0 = false;
        goto L10
    }

    @Override // com.bytedance.android.live.liveinteract.chatroom.chatroom.playmode.AbsPlayModeWidget, com.bytedance.android.live.liveinteract.linkpanel.widget.PlatformMultiLinkWidget, com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget
    public final void onDestroy() {
        if (KtvSettingHelper.r().booleanValue() == false) goto L8;
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L8;
        r0.removeObserver(this);
    L8:
        if (((LiveMemLeakConfig) j1.a.getValue()).getFixDataCenter() == false) goto L12;
        DataCenter r1 = ((Widget) this).dataCenter;
        if (r1 == null) goto L12;
        r1.removeObserver(this);
    L12:
        super.onDestroy();
        com.bytedance.android.live.liveinteract.interactivesong.speech.a r2 = this.z;
        boolean r3 = true;
        if (r2 == null) goto L15;
        r2.j(true);
    L15:
        SpeechRhythm r4 = this.i;
        r4.b.clear();
        ALogger.i("SpeechRhythm", "stopAllBusinessRhythmDetect");
        r4.d.clear();
        r4.c = false;
        cg6.a r5 = r4.c();
        if (r5 == null) goto L22;
        hg6.g r6 = r5.getRtcManager();
        if (r6 == null) goto L22;
        ec6.b r7 = r6.R();
        if (r7 == null) goto L22;
        com.bytedance.android.live.pushstream.d r8 = gc6.b.a(r7);
    L23:
        if (r8 == null) goto L27;
        d0 r9 = r8.getLiveCore();
        if (r9 == null) goto L27;
        r9.h();
    L27:
        if (r8 == null) goto L32;
        d0 r10 = r8.getLiveCore();
        if (r10 == null) goto L32;
        r10.h();
    L32:
        if (this.a == false) goto L38;
        this.a = false;
        if (isAnchor() == false) goto L36;
        InteractiveSongLoggerKt.j(zq(), this.g, this.h, null, Boolean.valueOf(this.s));
        this.u = null;
        goto L38
    L36:
        InteractiveSongLoggerKt.h(this.g, this.h);
    L38:
        if (isAnchor() == true) goto L48;
        InteractiveSongMvManager r11 = this.x;
        if (r11 == null) goto L42;
        r11.b();
    L42:
        InteractiveSongContext r12 = InteractiveSongContext.Companion.getContext();
        if (r12 == null) goto L45;
        long r13 = r12.getMvWatchDuration();
    L46:
        InteractiveSongLoggerKt.d(r13);
        goto L48
    L45:
        r13 = 0;
    L48:
        if (vm2.c.j() == false) goto L50;
        InteractiveSongContext.Companion.getClass();
        InteractiveSongContext.access$getMicSeatTaskExecutors$cp().clear();
    L50:
        InteractiveSongContext r14 = InteractiveSongContext.Companion.getContext();
        if (r14 == null) goto L55;
        ConcurrentHashMap<String, pf0.a> r15 = r14.getGuestListInteractiveSongInfo();
        if (r15 == null) goto L55;
        r15.clear();
    L55:
        vlc.d r16 = this.c;
        if (r16 == null) goto L58;
        r16.removeMessageListener(this);
    L58:
        com.bytedance.android.live.liveinteract.plantform.datamerge.handler.i r17 = this.p;
        if (r17 == null) goto L62;
        r17.b = true;
        r17.d = null;
        r17.e = null;
        r17.c();
    L62:
        if (this.j.isEnableInteractiveSongHandlerOpt() == true) goto L64;
    L67:
        if (r3 == false) goto L88;
        com.bytedance.android.live.liveinteract.plantform.datamerge.handler.i r18 = this.p;
        if (r18 == null) goto L74;
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r19 = LinkUserDataMergeContext.a.b(LinkUserDataMergeContext.Companion, ((Widget) this).dataCenter);
        if (r19 == null) goto L74;
        r19.d1(r18);
    L74:
        p r20 = this.q;
        if (r20 == null) goto L88;
        LinkUserDataMergeContext r21 = LinkUserDataMergeContext.a.a(LinkUserDataMergeContext.Companion, ((Widget) this).dataCenter);
        if (r21 == null) goto L81;
        com.bytedance.live.datacontext.j<com.bytedance.android.live.liveinteract.plantform.datamerge.b> r22 = r21.getLinkRoomFightDataMergeCenter();
        if (r22 == null) goto L81;
        com.bytedance.android.live.liveinteract.plantform.datamerge.b r23 = (com.bytedance.android.live.liveinteract.plantform.datamerge.b) r22.getValue();
    L83:
        if ((r23 instanceof com.bytedance.android.live.liveinteract.plantform.datamerge.h) == true) goto L85;
        r23 = null;
    L85:
        com.bytedance.android.live.liveinteract.plantform.datamerge.h r24 = (com.bytedance.android.live.liveinteract.plantform.datamerge.h) r23;
        if (r24 == null) goto L88;
        Intrinsics.checkNotNullParameter(r20, "handler");
        r24.b.remove(r20);
        r20.b = false;
    L81:
        r23 = null;
    L88:
        InteractiveSongViewModel r25 = this.b;
        if (r25 == null) goto L91;
        r25.onDestroy();
    L91:
        this.d.clear();
        InteractiveSongMvManager r26 = this.x;
        if (r26 == null) goto L94;
        r26.e();
    L94:
        this.w = null;
        return;
    L64:
        if (PadConfigUtils.a() == true) goto L67;
        r3 = false;
    L22:
        r8 = null;
        goto L23
    }

    @Override // of0.b
    public final String Bm() {
        return this.t;
    }

    public static String yq(IOrderSingMVInfo r3) {
        InteractiveSongContext.a r0 = InteractiveSongContext.Companion;
        InteractiveSongContext r1 = r0.getContext();
        String r2 = null;
        if (r1 == null) goto L11;
        com.bytedance.android.live.liveinteract.interactivesong.panel.h r4 = r1.getCurMvDialogSelectedMv();
        if (r4 == null) goto L11;
        IOrderSingMVInfo r5 = r4.b;
        if (r5 == null) goto L11;
        IMVBaseInfo r6 = r5.getMvBaseInfo();
        if (r6 == null) goto L11;
        String r7 = r6.getVid();
    L12:
        if (r3 == null) goto L17;
        IMVBaseInfo r8 = r3.getMvBaseInfo();
        if (r8 == null) goto L17;
        r2 = r8.getVid();
    L17:
        if (Intrinsics.areEqual(r7, r2) == false) goto L24;
        InteractiveSongContext r9 = r0.getContext();
        if (r9 == null) goto L24;
        com.bytedance.android.live.liveinteract.interactivesong.panel.h r10 = r9.getCurMvDialogSelectedMv();
        if (r10 == null) goto L24;
        String r11 = r10.a;
        if (r11 == null) goto L24;
        return r11;
    L24:
        return "推荐";
    L11:
        r7 = null;
        goto L12
    }

    public final void Cq(boolean r2) {
        this.o = r2;
        InteractiveSongContext r0 = InteractiveSongContext.Companion.getContext();
        if (r0 == null) goto L8;
        m<Boolean> r1 = r0.isSeatEnlarge();
        if (r1 == null) goto L9;
        r1.setValue(Boolean.valueOf(r2));
        return;
    L9:
        return;
    }

    public final void Eq(List<Long> r5) {
        this.l = r5;
        InteractiveSongContext.a r0 = InteractiveSongContext.Companion;
        InteractiveSongContext r1 = r0.getContext();
        if (r1 == null) goto L7;
        m<List<Long>> r2 = r1.getCurrentGiftIdList();
        if (r2 == null) goto L7;
        r2.setValue(r5);
    L7:
        InteractiveSongContext r3 = r0.getContext();
        if (r3 == null) goto L12;
        m<List<Long>> r4 = r3.getCurrentGiftNumList();
        if (r4 == null) goto L12;
        List r6 = (List) r4.getValue();
    L13:
        if (r6 == null) goto L15;
        r6.clear();
    L15:
        Iterator<T> r7 = r5.iterator();
    L17:
        if (r7.hasNext() == false) goto L26;
        long r8 = ((Number) r7.next()).longValue();
        g50.c r9 = jc1.k.f(g50.c.class);
        if (r9 == null) goto L23;
        h2 r10 = r9.findLiteGiftById(r8);
        if (r10 == null) goto L23;
        long r11 = r10.getDiamondCount();
    L24:
        if (r6 == null) goto L17;
        r6.add(Long.valueOf(r11));
    L23:
        r11 = 0;
        goto L24
    L26:
        return;
    L12:
        r6 = null;
        goto L13
    }

    public final void Fq(List<Long> r5) {
        this.m = r5;
        InteractiveSongContext.a r0 = InteractiveSongContext.Companion;
        InteractiveSongContext r1 = r0.getContext();
        if (r1 == null) goto L7;
        m<List<Long>> r2 = r1.getCurrentTestGiftIdList();
        if (r2 == null) goto L7;
        r2.setValue(r5);
    L7:
        InteractiveSongContext r3 = r0.getContext();
        if (r3 == null) goto L12;
        m<List<Long>> r4 = r3.getCurrentTestGiftNumList();
        if (r4 == null) goto L12;
        List r6 = (List) r4.getValue();
    L13:
        if (r6 == null) goto L15;
        r6.clear();
    L15:
        Iterator<T> r7 = r5.iterator();
    L17:
        if (r7.hasNext() == false) goto L26;
        long r8 = ((Number) r7.next()).longValue();
        g50.c r9 = jc1.k.f(g50.c.class);
        if (r9 == null) goto L23;
        h2 r10 = r9.findLiteGiftById(r8);
        if (r10 == null) goto L23;
        long r11 = r10.getDiamondCount();
    L24:
        if (r6 == null) goto L17;
        r6.add(Long.valueOf(r11));
    L23:
        r11 = 0;
        goto L24
    L26:
        return;
    L12:
        r6 = null;
        goto L13
    }

    public final void Lq(pf0.a r3) {
        com.bytedance.android.live.liveinteract.plantform.datamerge.handler.i r0 = this.p;
        if (r0 == null) goto L8;
        Intrinsics.checkNotNullParameter(r3, "micInfoItem");
        if (r0.c == false) goto L9;
        r0.b = false;
        r0.e = r3;
        r0.c();
        return;
    L9:
        return;
    }

    @Override // of0.b
    public final void e7(HSImageView r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        this.v = r2;
    }

    public final void onChanged(Object r5) {
        KVData r6 = (KVData) r5;
        String r0 = null;
        if (r6 == null) goto L5;
        String r1 = r6.getKey();
    L7:
        if (Intrinsics.areEqual(r1, "data_online_changed_list") == false) goto L56;
        List r7 = (List) r6.getData();
        if (r7 != null) goto L11;
        return;
    L11:
        if ((!r7.isEmpty()) == true) goto L13;
        return;
    L13:
        if (this.e == true) goto L15;
        return;
    L15:
        if (InteractiveSongContext.Companion.f() == false) goto L60;
        this.e = false;
        HSImageView r2 = this.v;
        if (r2 == null) goto L19;
        UtilityKotlinExtentionsKt.w(r2);
    L19:
        HSImageView r3 = this.v;
        if (r3 == null) goto L22;
        com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.interactivesong.n.c(r3, LiveCommonConstants.assembleTosObjectUrl("obj/live-android/ttlive_request_song_game_start.webp"), new InteractiveSongWidget$playGameStartEffect$1(this));
    L22:
        InteractiveSongViewModel r4 = this.b;
        if (r4 == null) goto L30;
        DataCenter r8 = ((Widget) this).dataCenter;
        if (r8 == null) goto L27;
        IRoom r9 = a0.o(r8);
    L28:
        r4.fetchPlayModeInfo(r9);
        goto L30
    L27:
        r9 = null;
    L30:
        if (isAnchor() == true) goto L32;
        return;
    L32:
        if (Iq() == false) goto L62;
        Iterator r10 = r7.iterator();
    L35:
        if (r10.hasNext() == false) goto L43;
        Object r11 = r10.next();
        Linkmic2DAvatar r12 = ((ILinkPlayerInfoBridge) r11).getLinkmic2DAvatar();
        if (r12 == null) goto L39;
        Boolean r13 = r12.getEnableAvatar();
    L41:
        if (Intrinsics.areEqual(r13, Boolean.TRUE) == false) goto L35;
    L44:
        ILinkPlayerInfoBridge r14 = (ILinkPlayerInfoBridge) r11;
        if (r14 == null) goto L50;
        IBaseUser r15 = r14.getUser();
        if (r15 == null) goto L50;
        r0 = r15.getIdString();
    L50:
        if (Intrinsics.areEqual(r0, je0.d.b0()) == false) goto L63;
        this.i.i("2d_avatar");
        return;
    L63:
        return;
    L39:
        r13 = null;
        goto L41
    L43:
        r11 = null;
        goto L44
    L62:
        return;
    L60:
        return;
    L56:
        return;
    L5:
        r1 = null;
        goto L7
    }

    public final void onMessage(tlc.d r22) {
        tlc.d r1 = r22;
        String r13 = null;
        List r14 = null;
        r14 = null;
        r14 = null;
        Integer r15 = null;
        String r16 = null;
        if ((r1 instanceof h1) == false) goto L60;
        h1 r2 = (h1) r1;
        if (r2.getMType() == 6) goto L9;
        if (r2.getMType() == 7) goto L9;
        return;
    L9:
        if (r2.getMType() != 6) goto L14;
        f1 r3 = r2.getEnter();
        if (r3 == null) goto L18;
        r14 = r3.getLinkUsers();
    L18:
        if (r14 == null) goto L25;
        ArrayList<ILinkPlayerInfoBridge> r4 = je0.d.f0(r14, false);
        ArrayList r5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10));
        Iterator<ILinkPlayerInfoBridge> r6 = r4.iterator();
    L21:
        if (r6.hasNext() == false) goto L23;
        IBaseUser r7 = r6.next().getUser();
        Intrinsics.checkNotNull(r7);
        r5.add(r7.getIdString());
        goto L21
    L23:
        List r8 = CollectionsKt.toMutableList(r5);
        if (r8 == null) goto L25;
    L26:
        ArrayList r9 = new ArrayList();
        r9.addAll(r8);
        InteractiveSongContext r10 = InteractiveSongContext.Companion.getContext();
        if (r10 == null) goto L32;
        ConcurrentHashMap<String, pf0.a> r11 = r10.getGuestListInteractiveSongInfo();
        if (r11 == null) goto L32;
        Set<String> r12 = r11.keySet();
        if (r12 == null) goto L32;
    L33:
        ArrayList r17 = new ArrayList();
        r17.addAll(r12);
        if (r8.size() <= r12.size()) goto L50;
        r9.removeAll(r17);
        Iterator r18 = r9.iterator();
    L37:
        if (r18.hasNext() == false) goto L616;
        String r19 = (String) r18.next();
        pf0.a r110 = new pf0.a(r19, 0, null, null, null, 28);
        InteractiveSongContext.a r20 = InteractiveSongContext.Companion;
        InteractiveSongContext r21 = r20.getContext();
        if (r21 == null) goto L43;
        ConcurrentHashMap<String, pf0.a> r23 = r21.getGuestListInteractiveSongInfo();
        if (r23 == null) goto L43;
        pf0.a r24 = r23.put(r19, r110);
    L43:
        InteractiveSongContext r25 = r20.getContext();
        if (r25 == null) goto L48;
        ConcurrentHashMap<String, Integer> r26 = r25.getSingingStates();
        if (r26 == null) goto L48;
        Integer r27 = r26.put(r19, Integer.valueOf(RequestSongSingState.STATE_NOSING.getValue()));
    L48:
        Lq(r110);
        goto L37
    L616:
        return;
    L50:
        if (r8.size() >= r12.size()) goto L577;
        r17.removeAll(r9);
        Iterator r28 = r17.iterator();
    L53:
        if (r28.hasNext() == false) goto L617;
        String r29 = (String) r28.next();
        InteractiveSongContext r30 = InteractiveSongContext.Companion.getContext();
        if (r30 == null) goto L53;
        ConcurrentHashMap<String, pf0.a> r31 = r30.getGuestListInteractiveSongInfo();
        if (r31 == null) goto L53;
        pf0.a r32 = r31.remove(r29);
        goto L53
    L617:
        return;
    L577:
        return;
    L32:
        r12 = new LinkedHashSet();
    L25:
        r8 = new ArrayList();
        goto L26
    L14:
        if (r2.getMType() != 7) goto L18;
        ILinkerLeaveContentBridge r33 = r2.getLeave();
        if (r33 == null) goto L18;
        r14 = r33.getLinkUsers();
        goto L18
    L60:
        if ((r1 instanceof x2) == false) goto L517;
        x2 r34 = (x2) r1;
        int r35 = r34.getMessageType();
        if (r35 != LinkmicOrderSingMessageType.TYPE_MESSAGE_CREATE.getValue()) goto L160;
        HSImageView r36 = this.v;
        if (r36 == null) goto L66;
        UtilityKotlinExtentionsKt.w(r36);
    L66:
        HSImageView r37 = this.v;
        if (r37 == null) goto L69;
        com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.interactivesong.n.c(r37, LiveCommonConstants.assembleTosObjectUrl("obj/live-android/ttlive_request_song_game_start.webp"), new InteractiveSongWidget$playGameStartEffect$1(this));
    L69:
        com.bytedance.android.live.base.model.message.u2 r38 = r34.getOrderSingCreateContent();
        if (r38 != null) goto L72;
    L74:
        boolean r39 = false;
    L75:
        Cq(r39);
        com.bytedance.android.live.base.model.message.u2 r40 = r34.getOrderSingCreateContent();
        if (r40 == null) goto L81;
        List r41 = r40.getGiftIds();
        if (r41 == null) goto L81;
        List<Long> r42 = CollectionsKt.toMutableList(r41);
        if (r42 == null) goto L81;
    L82:
        Eq(r42);
        com.bytedance.android.live.base.model.message.u2 r43 = r34.getOrderSingCreateContent();
        if (r43 == null) goto L88;
        List r44 = r43.getAuditionGiftIds();
        if (r44 == null) goto L88;
        List<Long> r45 = CollectionsKt.toMutableList(r44);
        if (r45 == null) goto L88;
    L89:
        Fq(r45);
        com.bytedance.android.live.base.model.message.u2 r46 = r34.getOrderSingCreateContent();
        if (r46 == null) goto L94;
        Boolean r47 = r46.getShowGiftInfo();
        if (r47 == null) goto L94;
        boolean r48 = r47.booleanValue();
    L95:
        this.n = r48;
        InteractiveSongContext.a r49 = InteractiveSongContext.Companion;
        InteractiveSongContext r50 = r49.getContext();
        if (r50 == null) goto L100;
        m<Boolean> r51 = r50.getShowGiftInfo();
        if (r51 == null) goto L100;
        r51.setValue(Boolean.valueOf(r48));
    L100:
        int r52 = com.bytedance.android.live.liveinteract.aimv.b.a;
        m r53 = com.bytedance.android.live.liveinteract.api.utils.m.j(this).getRoom();
        if (r53 == null) goto L103;
        IRoom r54 = (IRoom) r53.getValue();
    L104:
        final boolean r55 = com.bytedance.android.live.liveinteract.aimv.b.b(r54);
        com.bytedance.android.live.base.model.message.u2 r56 = r34.getOrderSingCreateContent();
        if (r56 == null) goto L107;
        Integer r57 = r56.getStageEffects();
    L108:
        if (r57 != null) goto L111;
    L113:
        boolean r58 = false;
    L114:
        InteractiveSongContext r59 = r49.getContext();
        if (r59 == null) goto L119;
        m<Boolean> r60 = r59.isAIMVStage();
        if (r60 == null) goto L119;
        r60.setValue(Boolean.valueOf(r58));
    L119:
        Kq();
        com.bytedance.android.live.base.model.message.u2 r61 = r34.getOrderSingCreateContent();
        if (r61 == null) goto L122;
        boolean r62 = r61.getAiLyrics();
    L123:
        this.g = r62;
        com.bytedance.android.live.base.model.message.u2 r63 = r34.getOrderSingCreateContent();
        if (r63 == null) goto L126;
        r15 = r63.getStageEffects();
    L126:
        this.h = r15;
        Jq(true, new InteractiveSongWidget$handleOpenGame$1(this, r55));
        com.bytedance.android.live.liveinteract.interactivesong.speech.a r65 = this.z;
        if (r65 == null) goto L132;
        boolean r66 = this.g;
        if ((!h0.a.booleanValue()) == false) goto L131;
        r65.a = false;
        goto L132
    L131:
        r65.a = r66;
    L132:
        InteractiveSongContext r67 = r49.getContext();
        if (r67 == null) goto L137;
        m<Boolean> r68 = r67.isAiLyricsSwitchOn();
        if (r68 == null) goto L137;
        r68.setValue(Boolean.valueOf(this.g));
    L137:
        com.bytedance.android.live.liveinteract.interactivesong.speech.a r69 = this.z;
        if (r69 == null) goto L140;
        r69.h();
    L140:
        com.bytedance.android.livesdk.sharedpref.e r70 = b6.G;
        r70.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r70, 1);
        if (this.a == true) goto L153;
        this.a = true;
        if (isAnchor() == true) goto L146;
        InteractiveSongLoggerKt.k(this.g);
        goto L153
    L146:
        if (isAnchor() == false) goto L153;
        if (this.f == true) goto L153;
        String r71 = this.r;
        if (r71 != null) goto L152;
        r71 = OpenSource.INTERACTION_BUTTON.getValue();
    L152:
        InteractiveSongLoggerKt.i(r71, zq(), this.s, this.g, this.t);
    L153:
        FrameLayout r72 = this.w;
        if (r72 == null) goto L158;
        InteractiveSongMvManager r73 = this.x;
        if (r73 == null) goto L158;
        r73.h(r72);
    L158:
        Bq();
        return;
    L122:
        r62 = false;
        goto L123
    L111:
        if (r57.intValue() != 2) goto L113;
        r58 = true;
        goto L114
    L107:
        r57 = null;
        goto L108
    L103:
        r54 = null;
    L94:
        r48 = false;
    L88:
        r45 = new ArrayList();
    L81:
        r42 = new ArrayList();
        goto L82
    L72:
        if (r38.getAutoEnlarge() != true) goto L74;
        r39 = true;
        goto L75
    L160:
        if (r35 != LinkmicOrderSingMessageType.TYPE_MESSAGE_FINISH.getValue()) goto L207;
        ALogger.i("InteractiveSongWidget", "handleCloseGame ;; FinishRequestSong");
        v2 r74 = r34.getOrderSingFinishContent();
        if (r74 == null) goto L164;
        String r75 = r74.getCloseOrderSingToast();
    L166:
        if (StringUtils.isEmpty(r75) == true) goto L171;
        if (r74 == null) goto L169;
        String r76 = r74.getCloseOrderSingToast();
    L170:
        f2.c(r76, 0);
        goto L171
    L169:
        r76 = null;
    L171:
        if (r74 != null) goto L173;
    L175:
        boolean r77 = false;
    L176:
        Cq(r77);
        Kq();
        com.bytedance.android.live.liveinteract.interactivesong.speech.a r78 = this.z;
        if (r78 == null) goto L179;
        int r79 = com.bytedance.android.live.liveinteract.interactivesong.speech.a.m;
        r78.j(false);
    L179:
        this.i.j("2d_avatar");
        this.i.j("ai_mv");
        InteractiveSongContext r80 = InteractiveSongContext.Companion.getContext();
        if (r80 == null) goto L187;
        ConcurrentHashMap<String, Integer> r81 = r80.getSingingStates();
        if (r81 == null) goto L187;
        Iterator<Map.Entry<String, Integer>> r82 = r81.entrySet().iterator();
    L185:
        if (r82.hasNext() == false) goto L187;
        r81.put(r82.next().getKey(), Integer.valueOf(RequestSongSingState.STATE_NOSING.getValue()));
    L187:
        InteractiveSongContext r83 = InteractiveSongContext.Companion.getContext();
        if (r83 == null) goto L192;
        m<Boolean> r84 = r83.isAIMVStage();
        if (r84 == null) goto L192;
        r84.setValue(Boolean.FALSE);
    L192:
        this.a = false;
        if (isAnchor() == false) goto L195;
        InteractiveSongLoggerKt.j(zq(), this.g, this.h, this.t, Boolean.valueOf(this.s));
        this.u = null;
    L196:
        int r85 = com.bytedance.android.live.liveinteract.aimv.b.a;
        m r86 = com.bytedance.android.live.liveinteract.api.utils.m.j(this).getRoom();
        if (r86 == null) goto L199;
        IRoom r87 = (IRoom) r86.getValue();
    L200:
        final boolean r88 = com.bytedance.android.live.liveinteract.aimv.b.b(r87);
        Jq(false, new InteractiveSongWidget$handleCloseGame$2(this, r88));
        InteractiveSongMvManager r89 = this.x;
        if (r89 == null) goto L203;
        r89.f();
    L203:
        qf0.b.a.setValue("true");
        this.t = null;
        com.bytedance.android.live.liveinteract.plantform.datamerge.handler.i r90 = this.p;
        if (r90 == null) goto L579;
        r90.b = true;
        r90.d = null;
        r90.e = null;
        r90.c();
        return;
    L579:
        return;
    L199:
        r87 = null;
        goto L200
    L195:
        InteractiveSongLoggerKt.h(this.g, this.h);
        goto L196
    L173:
        if (r74.getAutoEnlarge() != true) goto L175;
        r77 = true;
        goto L176
    L164:
        r75 = null;
        goto L166
    L207:
        if (r35 != LinkmicOrderSingMessageType.TYPE_MESSAGE_SING_ACTION_TOAST.getValue()) goto L233;
        t2 r91 = r34.getOrderSingActionToastContent();
        if (r91 == null) goto L211;
        String r92 = r91.getStartSingToast();
    L212:
        if (r91 == null) goto L214;
        String r93 = r91.getFinishSingToast();
    L215:
        if (r91 == null) goto L217;
        String r94 = r91.getOrderSingActionToast();
    L218:
        if (r91 == null) goto L221;
        r16 = r91.getOderSingToast();
    L221:
        if (StringUtils.isEmpty(r92) == true) goto L224;
        f2.c(r92, 0);
        return;
    L224:
        if (StringUtils.isEmpty(r93) == true) goto L227;
        f2.c(r93, 0);
        return;
    L227:
        if (StringUtils.isEmpty(r94) == true) goto L230;
        f2.c(r94, 0);
        return;
    L230:
        if (StringUtils.isEmpty(r16) == true) goto L584;
        f2.c(r16, 0);
        return;
    L584:
        return;
    L217:
        r94 = null;
        goto L218
    L214:
        r93 = null;
        goto L215
    L211:
        r92 = null;
        goto L212
    L233:
        if (r35 != LinkmicOrderSingMessageType.TYPE_MESSAGE_SING_ACTION.getValue()) goto L335;
        s2 r95 = r34.getOrderSingActionContent();
        if ((r95 instanceof s2) == false) goto L586;
        IBaseUser r96 = r95.getOrderUser();
        InteractiveSongViewModel r97 = this.b;
        if (r97 == null) goto L243;
        IBaseUser r98 = r95.getOrderUser();
        if (r98 == null) goto L241;
        String r99 = r98.getIdString();
    L242:
        r97.setCurOrderSongUser(r99);
        goto L243
    L241:
        r99 = null;
    L243:
        int r100 = r95.getOrderSingItemAction();
        OrderSingItemAction r101 = OrderSingItemAction.ORDER_SING_START_ITEM;
        if (r100 != r101.getValue()) goto L246;
    L247:
        InteractiveSongViewModel r102 = this.b;
        if (r102 == null) goto L254;
        IBaseUser r103 = r95.getOrderUser();
        if (r103 == null) goto L252;
        String r104 = r103.getIdString();
    L253:
        r102.setCurOrderSongUser(r104);
        goto L254
    L252:
        r104 = null;
    L254:
        int r105 = r95.getOrderSingItemAction();
        if (r105 != r101.getValue()) goto L281;
        if (r96 == null) goto L587;
        String r106 = r96.getIdString();
        if (r106 == null) goto L612;
        InteractiveSongContext r107 = InteractiveSongContext.Companion.getContext();
        if (r107 == null) goto L272;
        ConcurrentHashMap<String, Integer> r108 = r107.getSingingStates();
        if (r108 == null) goto L272;
        Iterator<Map.Entry<String, Integer>> r109 = r108.entrySet().iterator();
    L266:
        if (r109.hasNext() == false) goto L272;
        Map.Entry<String, Integer> r111 = r109.next();
        if ((!Intrinsics.areEqual(r111.getKey(), r106)) == false) goto L270;
        int r112 = RequestSongSingState.STATE_NOSING.getValue();
    L271:
        r108.put(r111.getKey(), Integer.valueOf(r112));
        goto L266
    L270:
        r112 = RequestSongSingState.STATE_SINGING.getValue();
    L272:
        i0.c().postDelayed(new h(this, r106), 2000);
        InteractiveSongContext.a r113 = InteractiveSongContext.Companion;
        InteractiveSongContext r114 = r113.getContext();
        if (r114 == null) goto L277;
        m<String> r115 = r114.getSingingGuestId();
        if (r115 == null) goto L277;
        r115.setValue(r106);
    L277:
        InteractiveSongContext r116 = r113.getContext();
        if (r116 == null) goto L588;
        r116.setCurOrderSongItemId(r95.getOrderSingItemId());
        return;
    L588:
        return;
    L612:
        return;
    L587:
        return;
    L281:
        if (r105 != OrderSingItemAction.ORDER_SING_END_ITEM.getValue()) goto L283;
    L305:
        if (r96 == null) goto L594;
        String r117 = r96.getIdString();
        if (r117 == null) goto L613;
        InteractiveSongContext.a r118 = InteractiveSongContext.Companion;
        InteractiveSongContext r119 = r118.getContext();
        if (r119 == null) goto L315;
        m<String> r120 = r119.getSingingGuestId();
        if (r120 == null) goto L315;
        r120.setValue("");
    L315:
        if (r2.a(r117) == false) goto L595;
        InteractiveSongContext r121 = r118.getContext();
        if (r121 == null) goto L324;
        ConcurrentHashMap<String, Integer> r122 = r121.getSingingStates();
        if (r122 == null) goto L324;
        Iterator<Map.Entry<String, Integer>> r123 = r122.entrySet().iterator();
    L322:
        if (r123.hasNext() == false) goto L324;
        r122.put(r123.next().getKey(), Integer.valueOf(RequestSongSingState.STATE_NOSING.getValue()));
    L324:
        Lq(new pf0.a(r117, 0, Integer.valueOf(OrderSingItemAction.ORDER_SING_END_ITEM.getValue()), null, null, 24));
        String r124 = r95.getOrderSingItemId();
        InteractiveSongContext r125 = InteractiveSongContext.Companion.getContext();
        if (r125 == null) goto L328;
        r13 = r125.getCurOrderSongItemId();
    L328:
        if (Intrinsics.areEqual(r124, r13) == false) goto L596;
        InteractiveSongMvManager r126 = this.x;
        if (r126 != null) goto L332;
        return;
    L332:
        if (r126.m != true) goto L598;
        r126.c();
        return;
    L598:
        return;
    L596:
        return;
    L595:
        return;
    L613:
        return;
    L594:
        return;
    L283:
        if (r105 == OrderSingItemAction.ORDER_SING_DEL_ITEM.getValue()) goto L305;
        if (r105 != OrderSingItemAction.ORDER_SING_DEL_ALL_ITEM.getValue()) goto L590;
        InteractiveSongContext.a r127 = InteractiveSongContext.Companion;
        InteractiveSongContext r128 = r127.getContext();
        if (r128 == null) goto L292;
        m<String> r129 = r128.getSingingGuestId();
        if (r129 == null) goto L292;
        r129.setValue("");
    L292:
        InteractiveSongContext r130 = r127.getContext();
        if (r130 == null) goto L300;
        ConcurrentHashMap<String, Integer> r131 = r130.getSingingStates();
        if (r131 == null) goto L300;
        Iterator<Map.Entry<String, Integer>> r132 = r131.entrySet().iterator();
    L298:
        if (r132.hasNext() == false) goto L300;
        r131.put(r132.next().getKey(), Integer.valueOf(RequestSongSingState.STATE_NOSING.getValue()));
    L300:
        Lq(new pf0.a("", 0, Integer.valueOf(OrderSingItemAction.ORDER_SING_DEL_ALL_ITEM.getValue()), null, null, 24));
        InteractiveSongMvManager r133 = this.x;
        if (r133 != null) goto L303;
        return;
    L303:
        if (r133.m != true) goto L592;
        r133.c();
        return;
    L592:
        return;
    L590:
        return;
    L246:
        if (r95.getOrderSingItemAction() != OrderSingItemAction.ORDER_SING_END_ITEM.getValue()) goto L254;
    L586:
        return;
    L335:
        if (r35 != LinkmicOrderSingMessageType.TYPE_MESSAGE_MV_ACTION_CONTENT.getValue()) goto L600;
        w2 r134 = r34.getOrderSingMVActionContent();
        if (r134 == null) goto L475;
        if (r134.getMvOperate() != MVOperation.MVOperation_Start.getValue()) goto L475;
        String r135 = jc1.k.n(IMiddlewareUserService.class).user().n();
        if (isAnchor() == true) goto L359;
        if (this.y == false) goto L359;
        IOrderSingMVInfo r136 = r134.getMvInfo();
        if (r136 == null) goto L350;
        IMVBaseInfo r137 = r136.getMvBaseInfo();
        if (r137 == null) goto L350;
        String r138 = r137.getVid();
        if (r138 == null) goto L350;
    L351:
        InteractiveSongMvManager r139 = this.x;
        if (r139 == null) goto L356;
        IOrderSingMVInfo r140 = r139.g;
        if (r140 == null) goto L356;
        boolean r141 = r140.isHighQuality();
    L357:
        InteractiveSongLoggerKt.c(r138, r141);
        this.y = false;
    L356:
        r141 = false;
    L350:
        r138 = "";
    L359:
        if (Intrinsics.areEqual(r134.getSingerId(), r135) == false) goto L378;
        String r142 = yq(r134.getMvInfo());
        IOrderSingMVInfo r143 = r134.getMvInfo();
        if (r143 == null) goto L368;
        IMVBaseInfo r144 = r143.getMvBaseInfo();
        if (r144 == null) goto L368;
        String r145 = r144.getVid();
        if (r145 == null) goto L368;
        String r146 = r145;
    L369:
        IOrderSingMVInfo r147 = r134.getMvInfo();
        if (r147 == null) goto L372;
        boolean r148 = r147.isHighQuality();
    L373:
        String r149 = r134.getItemId();
        if (r149 != null) goto L376;
        String r150 = "";
    L377:
        InteractiveSongLoggerKt.g(r142, r146, r148, r150, "official_mv", 0);
        goto L378
    L376:
        r150 = r149;
        goto L377
    L372:
        r148 = false;
    L368:
        r146 = "";
    L378:
        InteractiveSongViewModel r151 = this.b;
        if (r151 == null) goto L381;
        String r152 = r151.getCurOrderSongUser();
    L383:
        if (Intrinsics.areEqual(String.valueOf(r152), r135) == false) goto L444;
        InteractiveSongMvManager r153 = this.x;
        if (r153 == null) goto L444;
        IOrderSingMVInfo r154 = r153.g;
        if (r154 == null) goto L444;
        IMVBaseInfo r155 = r154.getMvBaseInfo();
        if (r155 == null) goto L444;
        String r156 = r155.getVid();
        if (r156 == null) goto L444;
        if (r156.length() <= 0) goto L395;
        boolean r157 = true;
    L396:
        if (r157 != true) goto L444;
        InteractiveSongContext.a r158 = InteractiveSongContext.Companion;
        InteractiveSongContext r159 = r158.getContext();
        if (r159 == null) goto L400;
        String r160 = r159.getCurOrderSongItemId();
    L401:
        if (r160 == null) goto L411;
        InteractiveSongContext r161 = r158.getContext();
        if (r161 == null) goto L405;
        String r162 = r161.getCurOrderSongItemId();
    L407:
        if ((!Intrinsics.areEqual(r162, r134.getItemId())) == false) goto L411;
        InteractiveSongMvManager r163 = this.x;
        String r164 = "cut";
        if (r163 == null) goto L417;
        IOrderSingMVInfo r165 = r163.g;
    L416:
        String r166 = r164;
    L418:
        InteractiveSongMvManager r167 = this.x;
        if (r167 == null) goto L421;
        r167.b();
    L421:
        String r168 = yq(r165);
        if (r165 == null) goto L427;
        IMVBaseInfo r169 = r165.getMvBaseInfo();
        if (r169 == null) goto L427;
        String r170 = r169.getVid();
        if (r170 == null) goto L427;
    L428:
        if (r165 == null) goto L430;
        boolean r171 = r165.isHighQuality();
    L431:
        InteractiveSongContext r172 = r158.getContext();
        if (r172 == null) goto L437;
        String r173 = r172.getCurOrderSongItemId();
        if (r173 == null) goto L437;
        String r174 = r173;
    L438:
        InteractiveSongMvManager r175 = this.x;
        if (r175 == null) goto L441;
        long r176 = r175.t;
    L442:
        InteractiveSongLoggerKt.f(r168, r170, r171, r174, r166, r176, 0, "official_mv");
        goto L444
    L441:
        r176 = 0;
    L437:
        r174 = "";
        goto L438
    L430:
        r171 = false;
    L427:
        r170 = "";
    L417:
        r166 = r164;
        r165 = null;
        goto L418
    L405:
        r162 = null;
    L411:
        InteractiveSongContext r177 = r158.getContext();
        r164 = "change";
        if (r177 == null) goto L417;
        com.bytedance.android.live.liveinteract.interactivesong.panel.h r178 = r177.getCurMvDialogSelectedMv();
        if (r178 == null) goto L417;
        r165 = r178.b;
        goto L416
    L400:
        r160 = null;
        goto L401
    L395:
        r157 = false;
    L444:
        InteractiveSongMvManager r179 = this.x;
        if (r179 == null) goto L447;
        r179.t = 0;
    L447:
        InteractiveSongViewModel r180 = this.b;
        if (r180 == null) goto L450;
        r180.setCurOrderSongUser(r134.getSingerId());
    L450:
        InteractiveSongContext r181 = InteractiveSongContext.Companion.getContext();
        if (r181 == null) goto L453;
        r181.setCurOrderSongItemId(r134.getItemId());
    L453:
        xq();
        if (isAnchor() == false) goto L458;
        IOrderSingMVInfo r182 = r134.getMvInfo();
        if (r182 == null) goto L458;
        r182.getMvType();
    L458:
        IOrderSingMVInfo r183 = r134.getMvInfo();
        InteractiveSongMvManager r184 = this.x;
        if (r184 == null) goto L461;
        r184.i(r183, isAnchor(), false, this.B, new InteractiveSongWidget$setMvInfo$1(this));
    L461:
        this.k = true;
        if (Intrinsics.areEqual(r134.getSingerId(), r135) == false) goto L470;
        InteractiveSongMvManager r185 = this.x;
        if (r185 == null) goto L470;
        Function0<Unit> r186 = new InteractiveSongWidget$handleOrderSingMVOperationMessage$1(this);
        Intrinsics.checkNotNullParameter(r186, "closeMvBg");
        Disposable r187 = r185.k;
        if (r187 == null) goto L468;
        r187.dispose();
    L468:
        r185.k = Observable.timer(((Number) vm2.d.F2.getValue(null, vm2.d.a[185(0xb9, float:2.59E-43)])).intValue(), TimeUnit.SECONDS).compose(RxUtil.rxSchedulerHelper()).subscribe(new com.bytedance.android.live.liveinteract.interactivesong.panel.a(r186));
    L470:
        if (isAnchor() == false) goto L513;
        IOrderSingMVInfo r188 = r134.getMvInfo();
        if (r188 == null) goto L513;
        r188.getMvType();
    L513:
        if (r134 == null) goto L601;
        String r189 = r134.getOpToast();
        if (r189 == null) goto L602;
        f2.c(r189, 0);
        return;
    L602:
        return;
    L601:
        return;
    L381:
        r152 = null;
    L475:
        if (r134 == null) goto L513;
        if (r134.getMvOperate() != MVOperation.MVOperation_Close.getValue()) goto L513;
        InteractiveSongMvManager r190 = this.x;
        if (r190 == null) goto L481;
        r190.c();
    L481:
        this.k = false;
        if (Intrinsics.areEqual(r134.getSingerId(), jc1.k.n(IMiddlewareUserService.class).user().n()) == false) goto L513;
        InteractiveSongMvManager r191 = this.x;
        if (r191 == null) goto L486;
        IOrderSingMVInfo r192 = r191.g;
    L487:
        if (r192 == null) goto L513;
        if (r191 == null) goto L490;
        IOrderSingMVInfo r193 = r191.g;
    L491:
        String r194 = yq(r193);
        if (r193 == null) goto L497;
        IMVBaseInfo r195 = r193.getMvBaseInfo();
        if (r195 == null) goto L497;
        String r196 = r195.getVid();
        if (r196 == null) goto L497;
    L498:
        if (r193 == null) goto L500;
        boolean r197 = r193.isHighQuality();
    L501:
        InteractiveSongContext r198 = InteractiveSongContext.Companion.getContext();
        if (r198 == null) goto L505;
        String r199 = r198.getCurOrderSongItemId();
        if (r199 == null) goto L505;
    L506:
        String r200 = r134.getOpSource();
        InteractiveSongMvManager r201 = this.x;
        if (r201 == null) goto L509;
        long r202 = r201.t;
    L510:
        InteractiveSongLoggerKt.f(r194, r196, r197, r199, r200, r202, 0, "official_mv");
        InteractiveSongMvManager r203 = this.x;
        if (r203 == null) goto L513;
        r203.g = null;
        goto L513
    L509:
        r202 = 0;
    L505:
        r199 = "";
        goto L506
    L500:
        r197 = false;
    L497:
        r196 = "";
        goto L498
    L490:
        r193 = null;
        goto L491
    L486:
        r192 = null;
        goto L487
    L600:
        return;
    L517:
        boolean r204 = r1 instanceof z2;
        if (r204 == false) goto L539;
        InteractiveSongContext r205 = InteractiveSongContext.Companion.getContext();
        if (r205 == null) goto L522;
        ConcurrentHashMap<String, pf0.a> r206 = r205.getGuestListInteractiveSongInfo();
    L523:
        if (r204 == true) goto L525;
        r1 = null;
    L525:
        z2 r207 = (z2) r1;
        if (r207 == null) goto L604;
        y2 r208 = r207.getOrderSingScoreContent();
        if (r208 == null) goto L605;
        l3 r209 = r208.getUserScore();
        if (r209 == null) goto L614;
        String r210 = r209.getUserIdString();
        if (r2.a(r210) == false) goto L606;
        int r211 = r209.getGoldenMicrophoneNum();
        ALogger.d("InteractiveSongWidget", "goldMicrophoneNum = " + r211 + ", increase = " + ((int) r209.getCurrentRoundMicCount()));
        pf0.a r212 = new pf0.a(r210, r211, null, Integer.valueOf((int) r209.getCurrentRoundMicCount()), r209.getTitleSponsor(), 4);
        if (r206 == null) goto L537;
        pf0.a r213 = r206.put(r210, r212);
    L537:
        Lq(r212);
        return;
    L606:
        return;
    L614:
        return;
    L605:
        return;
    L604:
        return;
    L522:
        r206 = null;
        goto L523
    L539:
        if ((r1 instanceof ILinkmicEnlargeGuestMessage) == false) goto L608;
        ILinkmicEnlargeGuestMessage r214 = (ILinkmicEnlargeGuestMessage) r1;
        if (vm2.c.g() == false) goto L615;
        f6 r215 = r214.getTurn_on_content();
        if (r215 == null) goto L550;
        String r216 = jc1.k.n(IMiddlewareUserService.class).user().n();
        Intrinsics.checkNotNullParameter(r215, "$this$enlarged_user_id");
        o0.a r217 = o0.a;
        Long r218 = Long.valueOf(r215.get_enlargedUserId());
        String r219 = r215.get_enlargedOpenId();
        r217.getClass();
        if (Intrinsics.areEqual(r216, o0.a.g(r218, r219)) == false) goto L550;
        if (wq(r216) == false) goto L550;
        this.i.i("2d_avatar");
    L550:
        d6 r220 = r214.getChange_user_content();
        if (r220 == null) goto L609;
        String r221 = jc1.k.n(IMiddlewareUserService.class).user().n();
        Intrinsics.checkNotNullParameter(r220, "$this$enlargedUserId");
        o0.a r222 = o0.a;
        Long r223 = Long.valueOf(r220.get_enlargedUserId());
        String r224 = r220.get_enlargedOpenId();
        r222.getClass();
        if (Intrinsics.areEqual(r221, o0.a.g(r223, r224)) == true) goto L555;
        return;
    L555:
        if (wq(r221) == false) goto L611;
        this.i.i("2d_avatar");
        return;
    L611:
        return;
    L609:
        return;
    L615:
        return;
    }

    @Override // of0.b
    public final void onSei(String r7) {
        Intrinsics.checkNotNullParameter(r7, "sei");
        if (StringsKt.contains$default(r7, "audio_mv_sei", false, 2, null) == false) goto L18;
        LiveSeiUtil.i.getClass();
        Object r0 = LiveSeiUtil.c(r7).get("audio_mv_sei");
        if ((r0 instanceof JSONObject) == true) goto L7;
        r0 = null;
    L7:
        JSONObject r1 = (JSONObject) r0;
        if (r1 != null) goto L10;
        return;
    L10:
        InteractiveSongMvManager r4 = this.x;
        if (r4 == null) goto L18;
        if (r4.g(r1, this.A) != true) goto L18;
        xq();
        InteractiveSongMvManager r2 = this.x;
        if (r2 == null) goto L18;
        r2.d(true, isAnchor());
    L18:
        if (StringsKt.contains$default(r7, "music_beat_result", false, 2, null) == false) goto L21;
        this.i.e(r7);
        return;
    }

    public final boolean wq(String r7) {
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r0 = LinkUserDataMergeContext.a.b(LinkUserDataMergeContext.Companion, ((Widget) this).dataCenter);
        py.k r1 = null;
        if (r0 == null) goto L20;
        BehaviorSubject<List<ch0.e>> r2 = r0.f();
        if (r2 == null) goto L20;
        List r3 = (List) r2.getValue();
        if (r3 == null) goto L20;
        Iterator r4 = r3.iterator();
    L10:
        if (r4.hasNext() == false) goto L18;
        Object r5 = r4.next();
        IBaseUser r6 = ((ch0.e) r5).a.getUser();
        if (r6 == null) goto L14;
        String r8 = r6.getIdString();
    L16:
        if (Intrinsics.areEqual(r8, r7) == false) goto L10;
    L19:
        ch0.e r9 = (ch0.e) r5;
    L21:
        if (r9 == null) goto L23;
        ILinkPlayerInfoBridge r10 = r9.a;
    L24:
        if (r10 == null) goto L28;
        Linkmic2DAvatar r11 = r10.getLinkmic2DAvatar();
        if (r11 == null) goto L28;
        Boolean r12 = r11.getEnableAvatar();
    L30:
        if (Intrinsics.areEqual(r12, Boolean.TRUE) == false) goto L37;
        if (r10 == null) goto L35;
        Linkmic2DAvatar r13 = r10.getLinkmic2DAvatar();
        if (r13 == null) goto L35;
        r1 = r13.getImage();
    L35:
        if (r1 == null) goto L37;
        boolean r14 = true;
    L38:
        InteractiveSongContext.a r15 = InteractiveSongContext.Companion;
        Integer r16 = je0.d.h();
        if (r16 == null) goto L41;
        int r17 = r16.intValue();
    L42:
        boolean r18 = InteractiveSongContext.a.d(r15, r9, r17, false, 4);
        ALogger.i("InteractiveSongWidget", "isSupportRhythmDetect, support3DVideoAvatar: " + r18 + ", support2DAvatar: " + r14);
        if (Iq() == false) goto L47;
        if (r18 == true) goto L52;
        if (r14 == false) goto L47;
        return true;
    L52:
        return true;
    L47:
        return false;
    L41:
        r17 = 0;
    L37:
        r14 = false;
    L28:
        r12 = null;
        goto L30
    L23:
        r10 = null;
        goto L24
    L14:
        r8 = null;
        goto L16
    L18:
        r5 = null;
    L20:
        r9 = null;
        goto L21
    }

    @Override // of0.b
    public final void y5(String r2) {
        Gq(true, r2);
    }

    public final void Gq(boolean r5, String r6) {
        if (isAnchor() == true) goto L5;
        return;
    L5:
        if (InteractiveSongContext.Companion.f() == false) goto L8;
        f2.b(2131919178, 0);
        return;
    L8:
        if (r6 != null) goto L10;
        r6 = OpenSource.CONVENIENT_PAGE.getValue();
    L10:
        if (r5 == false) goto L32;
        Integer r7 = (Integer) b6.G.getValue();
        if (r7 != null) goto L15;
    L17:
        if (r7 != null) goto L20;
        return;
    L20:
        if (r7.intValue() != 1) goto L36;
        InteractiveSongViewModel r8 = this.b;
        if (r8 == null) goto L29;
        DataCenter r3 = ((Widget) this).dataCenter;
        if (r3 == null) goto L26;
        IRoom r4 = a0.o(r3);
    L27:
        r8.turnOnOrderSing(r4);
        goto L29
    L26:
        r4 = null;
    L29:
        if (this.a == true) goto L31;
        this.a = true;
        InteractiveSongLoggerKt.i(r6, UserType.ANCHOR.getValue(), false, false, null);
    L31:
        this.f = true;
        return;
    L36:
        return;
    L15:
        if (r7.intValue() != 0) goto L17;
        qf0.b.d(((Widget) this).context, r6);
        return;
    L32:
        qf0.b.d(((Widget) this).context, r6);
    }

    public final void Jq(boolean r2, Function0<Unit> r3) {
        if (r3 == null) goto L4;
        Unit r4 = (Unit) r3.invoke();
    L4:
        com.bytedance.android.live.liveinteract.plantform.datamerge.handler.i r5 = this.p;
        if (r5 != null) goto L7;
    L9:
        p r6 = this.q;
        if (r6 != null) goto L12;
        return;
    L12:
        if (r6.b == false) goto L16;
        r6.c = Boolean.valueOf(r2);
        r6.c();
        return;
    L16:
        return;
    L7:
        if (r5.c == false) goto L9;
        r5.d = Boolean.valueOf(r2);
        r5.c();
        goto L9
    }

    @Override // of0.b
    public final void I0(String r5, long r6, boolean r8, Map<String, String> r9) {
        Intrinsics.checkNotNullParameter(r5, "toUserId");
        Intrinsics.checkNotNullParameter(r9, "logMap");
        r9.put("play_mode", u0.b());
        String r1 = "1";
        if (this.l.contains(Long.valueOf(r6)) == false) goto L5;
        String r0 = "1";
    L6:
        r9.put("is_request_song", r0);
        if (s0.g(null) == true) goto L9;
    L13:
        if (r8 == false) goto L15;
        return;
    L15:
        r9.put("request_song_guest_id", r5.toString());
        InteractiveSongContext r7 = InteractiveSongContext.Companion.getContext();
        if (r7 == null) goto L25;
        ConcurrentHashMap<String, pf0.a> r10 = r7.getGuestListInteractiveSongInfo();
        if (r10 == null) goto L25;
        pf0.a r11 = r10.get(r5);
        if (r11 == null) goto L25;
        if (r11.b <= 0) goto L25;
        String r12 = "golden_mic";
    L26:
        r9.put("request_song_guest_level", r12);
        return;
    L25:
        r12 = "";
        goto L26
    L9:
        if (this.m.contains(Long.valueOf(r6)) == true) goto L12;
        r1 = "0";
    L12:
        r9.put("is_test_song", r1);
        goto L13
    L5:
        r0 = "0";
        goto L6
    }

    @Override // of0.b
    public final void w9(final String r10, String r11, String r12, boolean r13, final Function0<Unit> r14) {
        Intrinsics.checkNotNullParameter(r10, "mvId");
        Intrinsics.checkNotNullParameter(r11, "itemId");
        Intrinsics.checkNotNullParameter(r12, "closeSource");
        String r0 = jc1.k.n(IMiddlewareUserService.class).user().n();
        InteractiveSongViewModel r1 = this.b;
        IRoom r2 = null;
        if (r1 == null) goto L5;
        String r3 = r1.getCurOrderSongUser();
    L7:
        if (Intrinsics.areEqual(r3, r0) == true) goto L9;
        if (r13 == true) goto L9;
        return;
    L9:
        InteractiveSongViewModel r4 = this.b;
        if (r4 == null) goto L17;
        DataCenter r15 = ((Widget) this).dataCenter;
        if (r15 == null) goto L14;
        r2 = a0.o(r15);
    L14:
        r4.closePlayingMv(r10, r11, r2, r12, new InteractiveSongWidget$closeMvBackground$1(this, r10, r14));
        return;
    L17:
        return;
    L5:
        r3 = null;
        goto L7
    }
}
