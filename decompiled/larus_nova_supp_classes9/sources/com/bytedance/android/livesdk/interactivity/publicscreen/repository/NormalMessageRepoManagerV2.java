package com.bytedance.android.livesdk.interactivity.publicscreen.repository;

import com.bytedance.android.live.base.model.message.c4;
import com.bytedance.android.live.base.model.message.t;
import com.bytedance.android.live.base.model.message.v3;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.chatroom.o0;
import com.bytedance.android.livesdk.chatroom.utils.o3;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.TextMessageTracer;
import com.bytedance.android.livesdk.interactivity.api.settings.config.u;
import com.bytedance.android.livesdk.interactivity.publicscreen.utils.TextMessagePresenterUtil;
import com.bytedance.android.livesdk.message.model.ck;
import com.bytedance.android.livesdk.message.model.va;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.room.EnterRoomRedirect;
import com.bytedance.android.livesdkapi.message.IPublicAreaCommon;
import com.bytedance.android.livesdkapi.message.IRoomMessageExtra;
import com.bytedance.android.livesdkapi.message.IRoomMessageGiftExtra;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import jc1.k;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import r52.b4;
import vlc.d;
import vlc.e;
import vlc.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u00107\u001a\u000206\u0012\u0006\u0010<\u001a\u00020;¢\u0006\u0004\b=\u0010>J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J \u0010\f\u001a\u00020\u00062\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\u0004H\u0016J\u0016\u0010\u000e\u001a\u00020\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\rH\u0016J\b\u0010\u000f\u001a\u00020\u0006H\u0014J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0002H\u0016J\u0010\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0015H\u0016R\u0016\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001c\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00150\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010!\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010#\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010\u001dR\u001a\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00150\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010\u001fR\u001a\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00150\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010\u001fR\u0018\u0010'\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010*\u001a\u0004\u0018\u00010)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R&\u0010/\u001a\u0012\u0012\u0004\u0012\u00020-0,j\b\u0012\u0004\u0012\u00020-`.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0014\u00101\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00104\u001a\u0002038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u0017\u00107\u001a\u0002068\u0006¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:¨\u0006?"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/publicscreen/repository/NormalMessageRepoManagerV2;", "Lcom/bytedance/android/livesdk/interactivity/publicscreen/repository/BaseMessageRepoManager;", "Ltlc/d;", "message", BuildConfig.FLAVOR, "messageManagerIntercept", BuildConfig.FLAVOR, "addMessageListeners", "removeMessageListeners", BuildConfig.FLAVOR, "messages", "historyFlag", "onFirstMessage", BuildConfig.FLAVOR, "insertBackendTopMessage", "onCleared", "Lcom/bytedance/android/live/base/model/message/t;", "msg", "onInsertLocalMessage", "canReceiveServerMessage", "canReceiveMessage", BuildConfig.FLAVOR, "msgMethod", "onDynamicAddMessageType", "Lvlc/d;", "messageManager", "Lvlc/d;", "Lvlc/l;", "messageManagerListener", "Lvlc/l;", "messageManagerMsgMethods", "Ljava/util/List;", "Lio/reactivex/disposables/Disposable;", "rtcMessageManagerDisposable", "Lio/reactivex/disposables/Disposable;", "rtcMessageManagerListener", "rtcMessageManagerMsgMethods", "localMessageMsgMethods", "Lcom/bytedance/android/livesdk/interactivity/publicscreen/repository/first/d;", "publicScreenFirstMessageProcessor", "Lcom/bytedance/android/livesdk/interactivity/publicscreen/repository/first/d;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "room", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "Ljava/util/HashSet;", BuildConfig.FLAVOR, "Lkotlin/collections/HashSet;", "firstMessageIdSet", "Ljava/util/HashSet;", "needFirstProcessor", "Z", "Lio/reactivex/disposables/CompositeDisposable;", "disposable", "Lio/reactivex/disposables/CompositeDisposable;", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "getDataCenter", "()Lcom/bytedance/ies/sdk/widgets/DataCenter;", "Lq92/a;", "config", "<init>", "(Lcom/bytedance/ies/sdk/widgets/DataCenter;Lq92/a;)V", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class NormalMessageRepoManagerV2 extends BaseMessageRepoManager {
    private final DataCenter dataCenter;
    private CompositeDisposable disposable;
    private HashSet<Long> firstMessageIdSet;
    private final List<String> localMessageMsgMethods;
    private final d messageManager;
    private final l messageManagerListener;
    private final List<String> messageManagerMsgMethods;
    private final boolean needFirstProcessor;
    private com.bytedance.android.livesdk.interactivity.publicscreen.repository.first.d publicScreenFirstMessageProcessor;
    private final IRoom room;
    private Disposable rtcMessageManagerDisposable;
    private final l rtcMessageManagerListener;
    private final List<String> rtcMessageManagerMsgMethods;

    public static final class a implements l {
        public final /* synthetic */ NormalMessageRepoManagerV2 a;

        public a(NormalMessageRepoManagerV2 r1) {
            this.a = r1;
        }

        public final void onMessage(tlc.d r2) {
            this.a.notifyMessage(r2);
        }
    }

    public static final class b implements l {
        public final /* synthetic */ NormalMessageRepoManagerV2 a;

        public b(NormalMessageRepoManagerV2 r1) {
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
        this.disposable.dispose();
        Disposable r0 = this.rtcMessageManagerDisposable;
        if (r0 != null) goto L5;
    L9:
        this.rtcMessageManagerDisposable = null;
        removeMessageListeners();
        com.bytedance.android.livesdk.interactivity.publicscreen.repository.first.d r1 = this.publicScreenFirstMessageProcessor;
        if (r1 == null) goto L22;
        d r2 = r1.p;
        if (r2 == null) goto L14;
        r2.removeMessageListener(r1);
    L14:
        d r3 = r1.p;
        if (r3 == null) goto L17;
        r3.F(r1);
    L17:
        r1.f.dispose();
        Disposable r4 = r1.h;
        if (r4 == null) goto L20;
        r4.dispose();
    L20:
        r1.h = null;
        return;
    L22:
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

    public static final /* synthetic */ void access$addMessageListeners(NormalMessageRepoManagerV2 r0) {
        r0.addMessageListeners();
    }

    public static final /* synthetic */ HashSet access$getFirstMessageIdSet$p(NormalMessageRepoManagerV2 r0) {
        return r0.firstMessageIdSet;
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
    public boolean canReceiveServerMessage(tlc.d r4) {
        Intrinsics.checkNotNullParameter(r4, "message");
        if (this.needFirstProcessor == false) goto L10;
        if ((r4 instanceof ck) == false) goto L10;
        if (TextMessagePresenterUtil.a(r4, this.dataCenter) == true) goto L10;
        return true;
    L10:
        if ((r4 instanceof t) == false) goto L16;
        t r5 = (t) r4;
        if (this.messageManagerMsgMethods.contains(r5.getMessageMethod()) == false) goto L14;
        return true;
    L14:
        if (getDynamicMessageTypes().contains(r5.getMessageMethod()) == false) goto L16;
        return true;
    L16:
        return false;
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.repository.BaseMessageRepoManager, com.bytedance.android.livesdk.interactivity.publicscreen.repository.IPSMessageRepoManager
    public boolean insertBackendTopMessage(List<? extends tlc.d> r7) {
        Intrinsics.checkNotNullParameter(r7, "messages");
        ALogger.i("PublicScreenFirstMessageProcessorV2", "执行 insertBackendTopMessage");
        ArrayList r0 = new ArrayList();
        Iterator<T> r8 = r7.iterator();
    L3:
        boolean r2 = true;
        boolean r3 = false;
        if (r8.hasNext() == false) goto L13;
        Object r1 = r8.next();
        tlc.d r4 = (tlc.d) r1;
        if (messageManagerIntercept(r4) == false) goto L8;
    L10:
        r2 = false;
    L11:
        if (r2 == false) goto L3;
        r0.add(r1);
        goto L3
    L8:
        if (canReceiveServerMessage(r4) == false) goto L10;
    L13:
        Iterator<IPSMessageRepoManager.Listener> r9 = getListeners().iterator();
    L15:
        if (r9.hasNext() == false) goto L17;
        r9.next().e(r0);
        r3 = true;
        goto L15
    L17:
        return r3;
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
    public void onInsertLocalMessage(t r5) {
        Intrinsics.checkNotNullParameter(r5, "msg");
        tlc.d r6 = (tlc.d) r5;
        if (canReceiveMessage(r6) == false) goto L18;
        com.bytedance.android.livesdk.interactivity.publicscreen.repository.first.d r0 = this.publicScreenFirstMessageProcessor;
        if (r0 != null) goto L8;
        notifyMessage(r6);
        return;
    L8:
        boolean r2 = false;
        if (r6 != null) goto L12;
    L15:
        if (r2 != true) goto L19;
        notifyMessage(r6);
        return;
    L19:
        return;
    L12:
        if (r0.j == false) goto L14;
        ((ArrayList) r0.d).add(r6);
        goto L15
    L14:
        r2 = true;
        goto L15
    }

    public NormalMessageRepoManagerV2(DataCenter r19, final q92.a r20) {
        Intrinsics.checkNotNullParameter(r19, "dataCenter");
        Intrinsics.checkNotNullParameter(r20, "config");
        this.dataCenter = r19;
        d r4 = (d) r19.get("data_message_manager");
        this.messageManager = r4;
        a r6 = new a(this);
        this.messageManagerListener = r6;
        b r11 = new b(this);
        this.rtcMessageManagerListener = r11;
        IRoomContextService r1 = k.f(IRoomContextService.class);
        if (r1 == null) goto L9;
        o r2 = IRoomContextService.a.a(r1, r19, 0, 2);
        if (r2 == null) goto L9;
        m r3 = r2.getRoom();
        if (r3 == null) goto L9;
        IRoom r5 = (IRoom) r3.getValue();
    L10:
        this.room = r5;
        this.firstMessageIdSet = new HashSet();
        if (r5 != null) goto L13;
    L14:
        if (r5 == null) goto L18;
        if (r5.isVsRoom() != true) goto L18;
    L23:
        boolean r7 = false;
    L24:
        this.needFirstProcessor = r7;
        this.disposable = new CompositeDisposable();
        ArrayList r8 = new ArrayList();
        r8.add("GiftGroupMessage");
        r8.add("WebcastLinkMicSendEmojiMessage");
        com.bytedance.android.livesdk.interactivity.publicscreen.repository.a.a(r8, "WebcastRoomIntroMessage", NormalMessageRepoManagerV2$1$1.INSTANCE);
        Unit r9 = Unit.INSTANCE;
        this.localMessageMsgMethods = r8;
        ArrayList r10 = new ArrayList();
        r10.add("WebcastChatMessage");
        r10.add("WebcastMemberMessage");
        r10.add("WebcastRoomMessage");
        r10.add("WebcastSocialMessage");
        r10.add("WebcastScreenChatMessage");
        r10.add("WebcastFansclubMessage");
        r10.add("WebcastImDeleteMessage");
        r10.add("WebcastLikeMessage");
        r10.add("WebcastPrivilegeScreenChatMessage");
        this.rtcMessageManagerMsgMethods = r10;
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
        com.bytedance.android.livesdk.interactivity.publicscreen.repository.a.a(r13, "WebcastRoomIntroMessage", NormalMessageRepoManagerV2$3$1.INSTANCE);
        r13.add("WebcastMediaRoomNoticeMessage");
        r13.add("WebcastLinkMessage");
        r13.add("WebcastCommonTextMessage");
        r13.add("WebcastInteractOpenAppStatusMessage");
        r13.add("WebcastPrivilegeScreenChatMessage");
        r13.add("--default--");
        r13.add("WebcastKtvMessage");
        com.bytedance.android.livesdk.interactivity.publicscreen.repository.a.a(r13, "WebcastAnchorBoostMessage", new NormalMessageRepoManagerV2$$special$$inlined$apply$lambda$1(this, r20));
        com.bytedance.android.livesdk.interactivity.publicscreen.repository.a.a(r13, "WebcastLuckyBoxMessage", new NormalMessageRepoManagerV2$$special$$inlined$apply$lambda$2(this, r20));
        com.bytedance.android.livesdk.interactivity.publicscreen.repository.a.a(r13, "WebcastTopAggregateChatMessage", new NormalMessageRepoManagerV2$$special$$inlined$apply$lambda$3(this, r20));
        this.messageManagerMsgMethods = r13;
        if (r7 == false) goto L27;
        boolean r14 = false;
        this.publicScreenFirstMessageProcessor = new com.bytedance.android.livesdk.interactivity.publicscreen.repository.first.d(r19, a0.n(r19), r13, r4, this, r6, new AnonymousClass4(this), new AnonymousClass5(this));
    L29:
        if (z.e(r19, r14) == true) goto L31;
        return;
    L31:
        if (((u) b4.a.getValue()).f() == false) goto L39;
        MiddlewareRoomContext r0 = MiddlewareRoomContext.a.c(MiddlewareRoomContext.Companion, r19, 0, 2);
        if (r0 == null) goto L35;
        Disposable r15 = o0.c(r0, r10, r11);
    L36:
        this.rtcMessageManagerDisposable = r15;
        return;
    L35:
        r15 = null;
        goto L36
    L39:
        return;
    L27:
        r14 = false;
        addMessageListeners();
    L18:
        if ((!Intrinsics.areEqual(o3.j(r19).isAnchor(), Boolean.TRUE)) == false) goto L23;
        if (r5 != null) goto L21;
    L22:
        r7 = true;
        goto L24
    L21:
        if (((int) r5.getRoomLayout()) == 2) goto L23;
    L13:
        if (r5.isMediaRoom() == true) goto L23;
    L9:
        r5 = null;
        goto L10
    }

    public static final /* synthetic */ void access$setFirstMessageIdSet$p(NormalMessageRepoManagerV2 r0, HashSet r1) {
        r0.firstMessageIdSet = r1;
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.repository.BaseMessageRepoManager
    public void onFirstMessage(List<tlc.d> r7, boolean r8) {
        if (r7 == null) goto L10;
        ArrayList r0 = new ArrayList();
        Iterator<T> r9 = r7.iterator();
    L5:
        if (r9.hasNext() == false) goto L9;
        Object r1 = r9.next();
        if ((!this.firstMessageIdSet.contains(Long.valueOf(((tlc.d) r1).getMessageId()))) == false) goto L5;
        r0.add(r1);
        goto L5
    L9:
        List<tlc.d> r10 = CollectionsKt.toMutableList(r0);
    L11:
        super.onFirstMessage(r10, r8);
        return;
    L10:
        r10 = null;
        goto L11
    }
}
