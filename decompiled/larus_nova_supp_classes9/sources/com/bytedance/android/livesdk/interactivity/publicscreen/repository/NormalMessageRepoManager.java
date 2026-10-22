package com.bytedance.android.livesdk.interactivity.publicscreen.repository;

import com.bytedance.android.live.base.model.message.c4;
import com.bytedance.android.live.base.model.message.t;
import com.bytedance.android.live.base.model.message.v3;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.chatroom.o0;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.TextMessageTracer;
import com.bytedance.android.livesdk.interactivity.api.settings.config.u;
import com.bytedance.android.livesdk.interactivity.api.settings.config.u0;
import com.bytedance.android.livesdk.interactivity.publicscreen.repository.first.c;
import com.bytedance.android.livesdk.interactivity.publicscreen.utils.TextMessagePresenterUtil;
import com.bytedance.android.livesdk.message.model.va;
import com.bytedance.android.livesdkapi.depend.room.EnterRoomRedirect;
import com.bytedance.android.livesdkapi.message.IPublicAreaCommon;
import com.bytedance.android.livesdkapi.message.IRoomMessageExtra;
import com.bytedance.android.livesdkapi.message.IRoomMessageGiftExtra;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import r42.g;
import r42.p;
import r52.a4;
import r52.b4;
import vlc.d;
import vlc.e;
import vlc.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u00108\u001a\u000207\u0012\u0006\u0010=\u001a\u00020<¢\u0006\u0004\b>\u0010?J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0002J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0016J \u0010\u0010\u001a\u00020\u00072\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\r2\u0006\u0010\u000f\u001a\u00020\u0005H\u0016J\u0016\u0010\u0012\u001a\u00020\u00052\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u0011H\u0016J\b\u0010\u0013\u001a\u00020\u0007H\u0014J\u0010\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0003H\u0016J\u0010\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0003H\u0016J\u0010\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0019H\u0016R\u0016\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010 \u001a\u00020\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00190\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010%\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010'\u001a\u00020\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010!R\u001a\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00190\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010#R\u001a\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00190\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010#R\u0018\u0010+\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0018\u0010.\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00101\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u001a\u00105\u001a\u000603j\u0002`48\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00106R\u0017\u00108\u001a\u0002078\u0006¢\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010;¨\u0006@"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/publicscreen/repository/NormalMessageRepoManager;", "Lcom/bytedance/android/livesdk/interactivity/publicscreen/repository/BaseMessageRepoManager;", BuildConfig.FLAVOR, "Ltlc/d;", "message", BuildConfig.FLAVOR, "messageManagerIntercept", BuildConfig.FLAVOR, "addMessageListeners", "removeMessageListeners", "Lcom/bytedance/android/livesdk/interactivity/publicscreen/repository/IPSMessageRepoManager$Listener;", "listener", "bind", BuildConfig.FLAVOR, "messages", "historyFlag", "onFirstMessage", BuildConfig.FLAVOR, "insertBackendTopMessage", "onCleared", "Lcom/bytedance/android/live/base/model/message/t;", "msg", "onInsertLocalMessage", "canReceiveServerMessage", "canReceiveMessage", BuildConfig.FLAVOR, "msgMethod", "onDynamicAddMessageType", "Lvlc/d;", "messageManager", "Lvlc/d;", "Lvlc/l;", "messageManagerListener", "Lvlc/l;", "messageManagerMsgMethods", "Ljava/util/List;", "Lio/reactivex/disposables/Disposable;", "rtcMessageManagerDisposable", "Lio/reactivex/disposables/Disposable;", "rtcMessageManagerListener", "rtcMessageManagerMsgMethods", "localMessageMsgMethods", "Lr42/p;", "tempHistoryMessageResp", "Lr42/p;", "Lcom/bytedance/android/livesdk/interactivity/publicscreen/repository/first/c;", "publicScreenFirstMessageProcessor", "Lcom/bytedance/android/livesdk/interactivity/publicscreen/repository/first/c;", "Lcom/bytedance/android/livesdk/interactivity/publicscreen/repository/first/a;", "historyStat", "Lcom/bytedance/android/livesdk/interactivity/publicscreen/repository/first/a;", "Lio/reactivex/disposables/CompositeDisposable;", "Lcom/bytedance/revenue/platform/api/core/rx/CompositeDisposable;", "disposable", "Lio/reactivex/disposables/CompositeDisposable;", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "getDataCenter", "()Lcom/bytedance/ies/sdk/widgets/DataCenter;", "Lq92/a;", "config", "<init>", "(Lcom/bytedance/ies/sdk/widgets/DataCenter;Lq92/a;)V", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class NormalMessageRepoManager extends BaseMessageRepoManager {
    private final DataCenter dataCenter;
    private CompositeDisposable disposable;
    private com.bytedance.android.livesdk.interactivity.publicscreen.repository.first.a historyStat;
    private final List<String> localMessageMsgMethods;
    private final d messageManager;
    private final l messageManagerListener;
    private final List<String> messageManagerMsgMethods;
    private c publicScreenFirstMessageProcessor;
    private Disposable rtcMessageManagerDisposable;
    private final l rtcMessageManagerListener;
    private final List<String> rtcMessageManagerMsgMethods;
    private p tempHistoryMessageResp;

    public static final class a implements l {
        public final /* synthetic */ NormalMessageRepoManager a;

        public a(NormalMessageRepoManager r1) {
            this.a = r1;
        }

        public final void onMessage(tlc.d r2) {
            this.a.notifyMessage(r2);
        }
    }

    public static final class b implements l {
        public final /* synthetic */ NormalMessageRepoManager a;

        public b(NormalMessageRepoManager r1) {
            this.a = r1;
        }

        public final void onMessage(tlc.d r6) {
            IPublicAreaCommon r0 = v3.a(r6);
            if (r0 == null) goto L50;
            r0.setFromRtcRoom(true);
            if ((r6 instanceof va) == false) goto L10;
            if (((va) r6).j0() != EnterRoomRedirect.REDIRECT_FROM_COLLABORATE_ENTER_ROOM.getValue()) goto L39;
            return;
        L39:
            this.a.notifyMessage(r6);
            return;
        L10:
            if ((r6 instanceof c4) == false) goto L39;
            c4 r1 = (c4) r6;
            if (r1.isGiftTypeMessage() == false) goto L39;
            IRoomMessageExtra r2 = r1.getRoomMessageExtra();
            if (r2 == null) goto L38;
            IRoomMessageGiftExtra r3 = r2.getGiftExtra();
            if (r3 == null) goto L41;
            String r4 = r3.getToUserIdString();
            if (r4 == null) goto L48;
            com.bytedance.android.live.user.api.a r5 = com.bytedance.android.live.user.api.b.a(this.a.getDataCenter());
            if (r5 == null) goto L42;
            com.bytedance.android.live.core.arch.mvvm.d r7 = r5.getUser();
            if (r7 == null) goto L43;
            User r8 = (User) r7.getValue();
            if (r8 == null) goto L44;
            String r9 = r8.getIdString();
            if (r9 != null) goto L30;
            return;
        L30:
            if (r4.length() != 0) goto L32;
            boolean r10 = true;
        L33:
            if (r10 == false) goto L35;
            return;
        L35:
            if ("0" != r4) goto L37;
            return;
        L37:
            if ((!Intrinsics.areEqual(r9, r4)) == false) goto L39;
            return;
        L32:
            r10 = false;
            goto L33
        L44:
            return;
        L43:
            return;
        L42:
            return;
        L48:
            return;
        L41:
            return;
        L38:
            return;
        }
    }

    private final void addMessageListeners() {
        d r0 = this.messageManager;
        if (r0 == null) goto L5;
        r0.n(this);
    L5:
        d r1 = this.messageManager;
        if (r1 == null) goto L9;
        com.bytedance.android.livesdk.interactivity.publicscreen.repository.a.b(r1, this.messageManagerMsgMethods, this.messageManagerListener);
    L9:
        if (this.messageManager == null) goto L11;
        return;
    L11:
        if (v.a() == true) goto L14;
        boolean r2 = TextMessageTracer.a;
        TextMessageTracer.A("message manger is null");
        SafetyGuard.a(null, null, "NormalMessageRepoManagerInitWithMessageManagerNull");
        return;
    L14:
        throw new RuntimeException("Why !");
    }

    private final void removeMessageListeners() {
        d r0 = this.messageManager;
        if (r0 == null) goto L5;
        r0.removeMessageListener(this.messageManagerListener);
    L5:
        d r1 = this.messageManager;
        if (r1 == null) goto L9;
        r1.F(this);
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.repository.BaseMessageRepoManager
    public void onCleared() {
        super.onCleared();
        removeMessageListeners();
        this.disposable.dispose();
        Disposable r0 = this.rtcMessageManagerDisposable;
        if (r0 != null) goto L5;
    L9:
        this.rtcMessageManagerDisposable = null;
        c r1 = this.publicScreenFirstMessageProcessor;
        if (r1 == null) goto L21;
        d r2 = r1.n;
        if (r2 == null) goto L14;
        r2.F(r1);
    L14:
        d r3 = r1.n;
        if (r3 == null) goto L17;
        r3.removeMessageListener(r1);
    L17:
        Disposable r4 = r1.i;
        if (r4 == null) goto L22;
        r4.dispose();
        return;
    L22:
        return;
    L21:
        return;
    L5:
        if (r0.isDisposed() == true) goto L9;
        Disposable r5 = this.rtcMessageManagerDisposable;
        if (r5 == null) goto L9;
        r5.dispose();
        goto L9
    }

    public final DataCenter getDataCenter() {
        return this.dataCenter;
    }

    public static final /* synthetic */ void access$addMessageListeners(NormalMessageRepoManager r0) {
        r0.addMessageListeners();
    }

    private final boolean messageManagerIntercept(tlc.d r3) {
        e r0 = this.messageManager;
        if (r0 == null) goto L20;
        amc.e r1 = r0.q();
        if (r1 == null) goto L17;
        amc.b r2 = r1.b();
        if (r2 == null) goto L24;
        List r4 = r2.getInterceptors();
        if (r4 == null) goto L25;
        Iterator r5 = r4.iterator();
    L12:
        if (r5.hasNext() == false) goto L26;
        if (((vlc.b) r5.next()).onMessage(r3) == false) goto L12;
        return true;
    L26:
        return false;
    L25:
        return false;
    L24:
        return false;
    L17:
        return false;
    L20:
        throw new NullPointerException("null cannot be cast to non-null type com.ss.ugc.live.sdk.message.interfaces.IMessageManagerV2");
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.repository.BaseMessageRepoManager, com.bytedance.android.livesdk.interactivity.publicscreen.repository.IPSMessageRepoManager
    public void bind(IPSMessageRepoManager.Listener r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        super.bind(r3);
        p r0 = this.tempHistoryMessageResp;
        if (r0 == null) goto L6;
        r3.f(r0.a, r0.b);
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.repository.BaseMessageRepoManager
    public boolean canReceiveMessage(tlc.d r3) {
        Intrinsics.checkNotNullParameter(r3, "msg");
        if ((r3 instanceof t) == false) goto L11;
        t r4 = (t) r3;
        if (this.messageManagerMsgMethods.contains(r4.getMessageMethod()) == false) goto L7;
    L10:
        return true;
    L7:
        if (getDynamicMessageTypes().contains(r4.getMessageMethod()) == true) goto L10;
        if (this.localMessageMsgMethods.contains(r4.getMessageMethod()) == true) goto L10;
    L11:
        return false;
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.repository.BaseMessageRepoManager
    public boolean canReceiveServerMessage(tlc.d r3) {
        Intrinsics.checkNotNullParameter(r3, "messages");
        if ((r3 instanceof t) == false) goto L9;
        t r4 = (t) r3;
        if (this.messageManagerMsgMethods.contains(r4.getMessageMethod()) == false) goto L7;
    L8:
        return true;
    L7:
        if (getDynamicMessageTypes().contains(r4.getMessageMethod()) == true) goto L8;
    L9:
        return false;
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.repository.BaseMessageRepoManager, com.bytedance.android.livesdk.interactivity.publicscreen.repository.IPSMessageRepoManager
    public boolean insertBackendTopMessage(List<? extends tlc.d> r7) {
        Intrinsics.checkNotNullParameter(r7, "messages");
        List<? extends tlc.d> r8 = r7;
        ArrayList r0 = new ArrayList();
        Iterator<T> r1 = r8.iterator();
    L3:
        boolean r3 = true;
        if (r1.hasNext() == false) goto L13;
        Object r2 = r1.next();
        tlc.d r4 = (tlc.d) r2;
        if (messageManagerIntercept(r4) == false) goto L8;
    L10:
        r3 = false;
    L11:
        if (r3 == false) goto L3;
        r0.add(r2);
        goto L3
    L8:
        if (canReceiveServerMessageWithSetting(r4) == false) goto L10;
    L13:
        Iterator<T> r9 = r8.iterator();
    L15:
        if (r9.hasNext() == false) goto L19;
        Object r5 = r9.next();
        if (Intrinsics.areEqual("WebcastRoomIntroMessage", ((tlc.d) r5).getMessageMethod()) == false) goto L15;
    L20:
        tlc.d r6 = (tlc.d) r5;
        if (r6 == null) goto L26;
        if (((u0) a4.a.getValue()).b() == false) goto L26;
        TextMessagePresenterUtil.b(this.dataCenter, this.disposable, r6);
    L26:
        if (r0.isEmpty() == false) goto L28;
        return true;
    L28:
        Iterator<IPSMessageRepoManager.Listener> r10 = getListeners().iterator();
    L30:
        if (r10.hasNext() == false) goto L32;
        r10.next().c(r0);
        goto L30
    L32:
        return true;
    L19:
        r5 = null;
        goto L20
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.repository.BaseMessageRepoManager
    public void onDynamicAddMessageType(String r3) {
        Intrinsics.checkNotNullParameter(r3, "msgMethod");
        d r0 = this.messageManager;
        if (r0 == null) goto L6;
        r0.addMessageListener(r3, this.messageManagerListener);
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.repository.BaseMessageRepoManager
    public void onInsertLocalMessage(t r2) {
        Intrinsics.checkNotNullParameter(r2, "msg");
        tlc.d r3 = (tlc.d) r2;
        if (canReceiveMessage(r3) == false) goto L9;
        c r0 = this.publicScreenFirstMessageProcessor;
        if (r0 == null) goto L7;
        r0.a(r3);
        return;
    L7:
        notifyMessage(r3);
        return;
    }

    public NormalMessageRepoManager(DataCenter r19, final q92.a r20) {
        Intrinsics.checkNotNullParameter(r19, "dataCenter");
        Intrinsics.checkNotNullParameter(r20, "config");
        this.dataCenter = r19;
        d r4 = (d) r19.get("data_message_manager");
        this.messageManager = r4;
        a r6 = new a(this);
        this.messageManagerListener = r6;
        b r10 = new b(this);
        this.rtcMessageManagerListener = r10;
        this.disposable = new CompositeDisposable();
        ArrayList r1 = new ArrayList();
        r1.add("GiftGroupMessage");
        r1.add("WebcastLinkMicSendEmojiMessage");
        com.bytedance.android.livesdk.interactivity.publicscreen.repository.a.a(r1, "WebcastRoomIntroMessage", NormalMessageRepoManager$1$1.INSTANCE);
        Unit r2 = Unit.INSTANCE;
        this.localMessageMsgMethods = r1;
        ArrayList r11 = new ArrayList();
        r11.add("WebcastChatMessage");
        r11.add("WebcastMemberMessage");
        r11.add("WebcastRoomMessage");
        r11.add("WebcastSocialMessage");
        r11.add("WebcastScreenChatMessage");
        r11.add("WebcastFansclubMessage");
        r11.add("WebcastImDeleteMessage");
        r11.add("WebcastLikeMessage");
        r11.add("WebcastPrivilegeScreenChatMessage");
        this.rtcMessageManagerMsgMethods = r11;
        ArrayList r13 = new ArrayList();
        r13.add("WebcastChatMessage");
        r13.add("WebcastAudioChatMessage");
        r13.add("WebcastAudioChatMessage");
        r13.add("WebcastGiftMessage");
        r13.add("WebcastMemberMessage");
        r13.add("WebcastRoomMessage");
        r13.add("WebcastSocialMessage");
        r13.add("WebcastControlMessage");
        r13.add("WebcastScreenChatMessage");
        r13.add("WebcastDoodleGiftMessage");
        r13.add("WebcastLotteryEventNewMessage");
        r13.add("WebcastFansclubMessage");
        r13.add("WebcastImDeleteMessage");
        r13.add("WebcastNobleUpgradeMessage");
        r13.add("WebcastExhibitionChatMessage");
        r13.add("WebcastLikeMessage");
        com.bytedance.android.livesdk.interactivity.publicscreen.repository.a.a(r13, "WebcastRoomIntroMessage", NormalMessageRepoManager$3$1.INSTANCE);
        r13.add("WebcastMediaRoomNoticeMessage");
        r13.add("WebcastLinkMessage");
        r13.add("WebcastCommonTextMessage");
        r13.add("WebcastInteractOpenAppStatusMessage");
        r13.add("WebcastPrivilegeScreenChatMessage");
        r13.add("--default--");
        r13.add("WebcastKtvMessage");
        com.bytedance.android.livesdk.interactivity.publicscreen.repository.a.a(r13, "WebcastAnchorBoostMessage", new NormalMessageRepoManager$$special$$inlined$apply$lambda$1(this, r20));
        com.bytedance.android.livesdk.interactivity.publicscreen.repository.a.a(r13, "WebcastLuckyBoxMessage", new NormalMessageRepoManager$$special$$inlined$apply$lambda$2(this, r20));
        com.bytedance.android.livesdk.interactivity.publicscreen.repository.a.a(r13, "WebcastTopAggregateChatMessage", new NormalMessageRepoManager$$special$$inlined$apply$lambda$3(this, r20));
        this.messageManagerMsgMethods = r13;
        Disposable r14 = null;
        if (g.a(null, null) == false) goto L5;
        c r15 = new c(r19, a0.n(r19), r13, r4, this, r6, new AnonymousClass4(this));
        this.publicScreenFirstMessageProcessor = r15;
        com.bytedance.android.livesdk.interactivity.publicscreen.repository.first.a r0 = r15.h;
        r0.getClass();
        r0.c = System.currentTimeMillis();
        int r3 = r42.a.a;
        r15.i = r42.a.b(r15.n, new com.bytedance.android.livesdk.interactivity.publicscreen.repository.first.b(r15));
    L7:
        if (z.e(r19, false) == true) goto L9;
        return;
    L9:
        if (((u) b4.a.getValue()).f() == false) goto L16;
        MiddlewareRoomContext r5 = MiddlewareRoomContext.a.c(MiddlewareRoomContext.Companion, r19, 0, 2);
        if (r5 == null) goto L13;
        r14 = o0.c(r5, r11, r10);
    L13:
        this.rtcMessageManagerDisposable = r14;
        return;
    L16:
        return;
    L5:
        this.historyStat = new com.bytedance.android.livesdk.interactivity.publicscreen.repository.first.a(a0.n(r19).getId());
        addMessageListeners();
        goto L7
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.repository.BaseMessageRepoManager
    public void onFirstMessage(List<tlc.d> r2, boolean r3) {
        com.bytedance.android.livesdk.interactivity.publicscreen.repository.first.a r0 = this.historyStat;
        if (r0 == null) goto L5;
        r0.a();
    L5:
        super.onFirstMessage(r2, r3);
    }
}
