package com.bytedance.android.livesdk.interactivity.publicscreen.repository;

import com.bytedance.android.live.base.model.message.t;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.chatroom.progress.context.PlayerProgressServiceContext;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.n;
import ec2.u1;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import jc1.h;
import jc1.k;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import vlc.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000i\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001 \u0018\u0000 -2\u00020\u0001:\u0001.B\u0017\u0012\u0006\u0010$\u001a\u00020#\u0012\u0006\u0010*\u001a\u00020)¢\u0006\u0004\b+\u0010,J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0014J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u001a\u0010\u0010\u001a\u00020\u00022\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0086\bø\u0001\u0000R\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u0019R\u0014\u0010\u001c\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001dR\u0016\u0010\u001f\u001a\u0004\u0018\u00010\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010\u0016R\u0014\u0010!\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010$\u001a\u00020#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010(\u001a\u0004\u0018\u00010\u00148BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006/"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/publicscreen/repository/VSFirstShowMessageRepoManager;", "Lcom/bytedance/android/livesdk/interactivity/publicscreen/repository/BaseMessageRepoManager;", BuildConfig.FLAVOR, "changeChatToRealTimeChannel", "changeChatToBackTraceChannel", BuildConfig.FLAVOR, "isBackTrace", "onCleared", "Lcom/bytedance/android/live/base/model/message/t;", "msg", "onInsertLocalMessage", "Ltlc/d;", "message", "canReceiveMessage", "Lkotlin/Function0;", BuildConfig.FLAVOR, "aLog", BuildConfig.FLAVOR, "mode", "I", "Lvlc/d;", "realTimeRepo", "Lvlc/d;", BuildConfig.FLAVOR, "realTimeMessageMethods", "Ljava/util/Set;", "backtraceMessageMethods", "Lvlc/l;", "realTimeMessageListener", "Lvlc/l;", "backtraceMessageListener", "messageManager", "com/bytedance/android/livesdk/interactivity/publicscreen/repository/VSFirstShowMessageRepoManager$c", "onFirstShowPlayListener", "Lcom/bytedance/android/livesdk/interactivity/publicscreen/repository/VSFirstShowMessageRepoManager$c;", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "getBackTraceRepo", "()Lvlc/d;", "backTraceRepo", "Lq92/a;", "config", "<init>", "(Lcom/bytedance/ies/sdk/widgets/DataCenter;Lq92/a;)V", "Companion", "a", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VSFirstShowMessageRepoManager extends BaseMessageRepoManager {
    private static final List<String> BACKTRACE_DYNAMIC_MSG_TYPES = null;
    public static final a Companion = null;
    public static final int MODE_BACKTRACE = 2;
    public static final int MODE_INIT = 0;
    public static final int MODE_REALTIME = 1;
    private static final List<String> REALTIME_DYNAMIC_MSG_TYPES = null;
    public static final String VS_TAG = "VS_Public_Screen";
    private final l backtraceMessageListener;
    private final Set<String> backtraceMessageMethods;
    private final DataCenter dataCenter;
    private final vlc.d messageManager;
    private int mode;
    private final c onFirstShowPlayListener;
    private final l realTimeMessageListener;
    private final Set<String> realTimeMessageMethods;
    private final vlc.d realTimeRepo;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements l {
        public final /* synthetic */ VSFirstShowMessageRepoManager a;

        public b(VSFirstShowMessageRepoManager r1) {
            this.a = r1;
        }

        public final void onMessage(tlc.d r2) {
            this.a.notifyMessage(r2);
        }
    }

    public static final class c implements h {
        public final /* synthetic */ VSFirstShowMessageRepoManager a;

        public final /* synthetic */ void d(long r1) {
        }

        public c(VSFirstShowMessageRepoManager r1) {
            this.a = r1;
        }

        public final void a(long r1) {
            ALogger.i(VSFirstShowMessageRepoManager.VS_TAG, "onPlayResume");
            this.a.notifyEvent(IPSMessageRepoManager.Listener.Event.RESUME);
        }

        public final void b(long r1) {
            ALogger.i(VSFirstShowMessageRepoManager.VS_TAG, "onPlayPause");
            this.a.notifyEvent(IPSMessageRepoManager.Listener.Event.PAUSE);
        }

        public final void c(long r1) {
            ALogger.i(VSFirstShowMessageRepoManager.VS_TAG, "onSeekStart");
        }

        public final void e(long r1) {
            ALogger.i(VSFirstShowMessageRepoManager.VS_TAG, "onSeekSuccess");
            this.a.notifyEvent(IPSMessageRepoManager.Listener.Event.UPDATE);
        }

        public final void f(long r1) {
            ALogger.i(VSFirstShowMessageRepoManager.VS_TAG, "onBackToLatestStart");
            this.a.notifyEvent(IPSMessageRepoManager.Listener.Event.UPDATE);
        }

        public final void g(boolean r3) {
            ALogger.i(VSFirstShowMessageRepoManager.VS_TAG, "onMessageFetchModeSwitch(" + r3 + ')');
            if (r3 == false) goto L5;
            VSFirstShowMessageRepoManager.access$changeChatToBackTraceChannel(this.a);
        L6:
            this.a.notifyEvent(IPSMessageRepoManager.Listener.Event.UPDATE);
            return;
        L5:
            VSFirstShowMessageRepoManager.access$changeChatToRealTimeChannel(this.a);
            goto L6
        }

        public final void h(long r1) {
            ALogger.i(VSFirstShowMessageRepoManager.VS_TAG, "onBackToLatestSuccess");
        }
    }

    public static final class d implements l {
        public final /* synthetic */ VSFirstShowMessageRepoManager a;

        public d(VSFirstShowMessageRepoManager r1) {
            this.a = r1;
        }

        public final void onMessage(tlc.d r2) {
            this.a.notifyMessage(r2);
        }
    }

    static {
        Companion = new a();
        REALTIME_DYNAMIC_MSG_TYPES = CollectionsKt.listOf(new String[]{"WebcastChatMessage", "WebcastScreenChatMessage", "WebcastAudioChatMessage", "WebcastAudioChatMessage", "WebcastLikeMessage", "WebcastSocialMessage", "WebcastMemberMessage"});
        BACKTRACE_DYNAMIC_MSG_TYPES = CollectionsKt.listOf(new String[]{"WebcastChatMessage", "WebcastScreenChatMessage", "WebcastAudioChatMessage", "WebcastAudioChatMessage"});
    }

    private final void changeChatToBackTraceChannel() {
        if (this.mode == 2) goto L16;
        this.realTimeMessageMethods.removeAll(REALTIME_DYNAMIC_MSG_TYPES);
        this.backtraceMessageMethods.addAll(BACKTRACE_DYNAMIC_MSG_TYPES);
        vlc.d r0 = this.realTimeRepo;
        if (r0 == null) goto L7;
        r0.removeMessageListener(this.realTimeMessageListener);
    L7:
        vlc.d r1 = this.realTimeRepo;
        if (r1 == null) goto L10;
        com.bytedance.android.livesdk.interactivity.publicscreen.repository.a.b(r1, this.realTimeMessageMethods, this.realTimeMessageListener);
    L10:
        vlc.d r2 = getBackTraceRepo();
        if (r2 == null) goto L13;
        r2.removeMessageListener(this.backtraceMessageListener);
    L13:
        vlc.d r3 = getBackTraceRepo();
        if (r3 == null) goto L16;
        com.bytedance.android.livesdk.interactivity.publicscreen.repository.a.b(r3, this.backtraceMessageMethods, this.backtraceMessageListener);
    L16:
        this.mode = 2;
    }

    private final void changeChatToRealTimeChannel() {
        if (this.mode == 1) goto L16;
        this.realTimeMessageMethods.addAll(REALTIME_DYNAMIC_MSG_TYPES);
        this.backtraceMessageMethods.removeAll(BACKTRACE_DYNAMIC_MSG_TYPES);
        vlc.d r0 = this.realTimeRepo;
        if (r0 == null) goto L7;
        r0.removeMessageListener(this.realTimeMessageListener);
    L7:
        vlc.d r1 = this.realTimeRepo;
        if (r1 == null) goto L10;
        com.bytedance.android.livesdk.interactivity.publicscreen.repository.a.b(r1, this.realTimeMessageMethods, this.realTimeMessageListener);
    L10:
        vlc.d r2 = getBackTraceRepo();
        if (r2 == null) goto L13;
        r2.removeMessageListener(this.backtraceMessageListener);
    L13:
        vlc.d r3 = getBackTraceRepo();
        if (r3 == null) goto L16;
        com.bytedance.android.livesdk.interactivity.publicscreen.repository.a.b(r3, this.backtraceMessageMethods, this.backtraceMessageListener);
    L16:
        this.mode = 1;
    }

    private final vlc.d getBackTraceRepo() {
        IRoomContextService r0 = k.f(IRoomContextService.class);
        if (r0 == null) goto L9;
        o r1 = IRoomContextService.a.a(r0, this.dataCenter, 0, 2);
        if (r1 == null) goto L9;
        j r2 = r1.K1();
        if (r2 == null) goto L9;
        return (vlc.d) r2.getValue();
    L9:
        return null;
    }

    private final boolean isBackTrace() {
        PlayerProgressServiceContext.a r0 = PlayerProgressServiceContext.Companion;
        DataCenter r1 = this.dataCenter;
        r0.getClass();
        PlayerProgressServiceContext r2 = PlayerProgressServiceContext.a.a(r1);
        if (r2 == null) goto L11;
        n r3 = r2.getPlayTimeInfo();
        if (r3 == null) goto L11;
        com.bytedance.android.livesdk.chatroom.vsplayer.model.b r4 = (com.bytedance.android.livesdk.chatroom.vsplayer.model.b) r3.getValue();
        if (r4 == null) goto L11;
        if ((r4.b - r4.a) <= (((Number) u1.a.getValue()).intValue() * IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW)) goto L11;
        return true;
    L11:
        return false;
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.repository.BaseMessageRepoManager
    public void onCleared() {
        super.onCleared();
        vlc.d r0 = this.realTimeRepo;
        if (r0 == null) goto L5;
        r0.removeMessageListener(this.realTimeMessageListener);
    L5:
        vlc.d r1 = getBackTraceRepo();
        if (r1 == null) goto L8;
        r1.removeMessageListener(this.backtraceMessageListener);
    L8:
        jc1.b.b(this.onFirstShowPlayListener);
        vlc.d r2 = this.messageManager;
        if (r2 == null) goto L12;
        r2.F(this);
        return;
    }

    public static final /* synthetic */ List access$getBACKTRACE_DYNAMIC_MSG_TYPES$cp() {
        return BACKTRACE_DYNAMIC_MSG_TYPES;
    }

    public static final /* synthetic */ List access$getREALTIME_DYNAMIC_MSG_TYPES$cp() {
        return REALTIME_DYNAMIC_MSG_TYPES;
    }

    public static final /* synthetic */ void access$changeChatToBackTraceChannel(VSFirstShowMessageRepoManager r0) {
        r0.changeChatToBackTraceChannel();
    }

    public static final /* synthetic */ void access$changeChatToRealTimeChannel(VSFirstShowMessageRepoManager r0) {
        r0.changeChatToRealTimeChannel();
    }

    public static final /* synthetic */ DataCenter access$getDataCenter$p(VSFirstShowMessageRepoManager r0) {
        return r0.dataCenter;
    }

    public final void aLog(Function0<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "msg");
        ALogger.i(VS_TAG, (String) r2.invoke());
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.repository.BaseMessageRepoManager
    public boolean canReceiveMessage(tlc.d r3) {
        Intrinsics.checkNotNullParameter(r3, "message");
        if ((r3 instanceof t) == false) goto L9;
        t r4 = (t) r3;
        if (this.realTimeMessageMethods.contains(r4.getMessageMethod()) == false) goto L7;
    L8:
        return true;
    L7:
        if (this.backtraceMessageMethods.contains(r4.getMessageMethod()) == true) goto L8;
    L9:
        return false;
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.repository.BaseMessageRepoManager
    public void onInsertLocalMessage(t r2) {
        Intrinsics.checkNotNullParameter(r2, "msg");
        tlc.d r3 = (tlc.d) r2;
        if (canReceiveMessage(r3) == false) goto L6;
        notifyMessage(r3);
        return;
    }

    public VSFirstShowMessageRepoManager(DataCenter r5, final q92.a r6) {
        Intrinsics.checkNotNullParameter(r5, "dataCenter");
        Intrinsics.checkNotNullParameter(r6, "config");
        this.dataCenter = r5;
        this.realTimeRepo = (vlc.d) r5.get("data_message_manager");
        this.realTimeMessageListener = new d(this);
        this.backtraceMessageListener = new b(this);
        vlc.d r7 = (vlc.d) r5.get("data_message_manager");
        this.messageManager = r7;
        c r0 = new c(this);
        this.onFirstShowPlayListener = r0;
        this.backtraceMessageMethods = new LinkedHashSet();
        LinkedHashSet r1 = new LinkedHashSet();
        r1.add("WebcastChatMessage");
        r1.add("WebcastScreenChatMessage");
        r1.add("WebcastAudioChatMessage");
        r1.add("WebcastAudioChatMessage");
        r1.add("WebcastRoomMessage");
        r1.add("WebcastMediaRoomNoticeMessage");
        com.bytedance.android.livesdk.interactivity.publicscreen.repository.a.a(r1, "WebcastAnchorBoostMessage", new VSFirstShowMessageRepoManager$$special$$inlined$apply$lambda$1(this, r6));
        com.bytedance.android.livesdk.interactivity.publicscreen.repository.a.a(r1, "WebcastSocialMessage", new VSFirstShowMessageRepoManager$$special$$inlined$apply$lambda$2(this, r6));
        r1.add("WebcastCommonTextMessage");
        r1.add("--default--");
        r1.add("WebcastImDeleteMessage");
        Unit r8 = Unit.INSTANCE;
        this.realTimeMessageMethods = r1;
        jc1.b.a(r0);
        if (r7 == null) goto L6;
        r7.n(this);
    L6:
        if (isBackTrace() == false) goto L8;
        changeChatToBackTraceChannel();
        return;
    L8:
        changeChatToRealTimeChannel();
    }
}
