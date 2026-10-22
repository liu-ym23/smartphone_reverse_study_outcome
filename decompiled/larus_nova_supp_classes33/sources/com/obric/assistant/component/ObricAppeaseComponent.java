package com.obric.assistant.component;

import com.google.gson.Gson;
import com.larus.audio.AudioServiceDelegate;
import com.larus.audio.audiov3.tts.PlayStateEnum;
import com.larus.call_plugins_doubao_common.manager.AudioSoundAppeaseManager;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.Message;
import com.larus.im.internal.legacy.NativeMessageServiceImpl;
import com.larus.im.observer.MessageListState;
import com.larus.platform.api.IVideoController;
import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.ISessionAuthenticationService;
import com.obric.assistant.audio.service.IObricTtsService;
import com.obric.assistant.audio.service.ObricAssistantBaseServiceDelegate;
import com.obric.assistant.chat.IObricChatService;
import com.obric.assistant.chat.tts.TtsSilentInterceptor;
import com.obric.assistant.interaction.api.IKeyguardStateKt;
import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import com.obric.assistant.spi.audio.ObricTtsControlDelegate;
import com.obric.assistant.spi.keyguard.IKeyguardService;
import com.obric.assistant.state.api.v2.core.IObricStateDispatcherService;
import com.obric.assistant.state.api.v2.core.bean.ObricTtsInfo;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014*\u0003 #'\u0018\u0000 H2\u00020\u0001:\u0001HB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010)\u001a\u00020*H\u0016J\b\u0010+\u001a\u00020*H\u0002J\u0010\u0010,\u001a\u00020*2\u0006\u0010-\u001a\u00020\u000bH\u0002J\u0010\u0010.\u001a\u00020*2\u0006\u0010/\u001a\u00020\u000bH\u0002J\b\u00100\u001a\u00020*H\u0016J\b\u00101\u001a\u00020*H\u0016J\u0010\u00102\u001a\u0002032\u0006\u00104\u001a\u000205H\u0002J\b\u00106\u001a\u000203H\u0002J\n\u00107\u001a\u0004\u0018\u00010\u000bH\u0002J\b\u00108\u001a\u00020*H\u0002J\u0010\u00109\u001a\u0002032\u0006\u0010:\u001a\u00020\u000bH\u0002J\b\u0010>\u001a\u00020*H\u0002J\u0010\u0010?\u001a\u00020*2\u0006\u0010@\u001a\u00020\u000bH\u0002J\b\u0010A\u001a\u00020*H\u0002J\b\u0010B\u001a\u00020*H\u0002J\u0018\u0010C\u001a\u00020*2\u0006\u0010D\u001a\u0002032\u0006\u00104\u001a\u000205H\u0002J\u0010\u0010E\u001a\u0002032\u0006\u00104\u001a\u000205H\u0002J\u0010\u0010F\u001a\u0002032\u0006\u00104\u001a\u000205H\u0002J\b\u0010G\u001a\u000203H\u0002R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\t\u001a\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\t\u001a\u0004\b\u0017\u0010\u0018R4\u0010\u001a\u001a&\u0012\f\u0012\n \u001c*\u0004\u0018\u00010\u000b0\u000b \u001c*\u0012\u0012\u000e\b\u0001\u0012\n \u001c*\u0004\u0018\u00010\u000b0\u000b0\u001b0\u001bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001dR\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0004\n\u0002\u0010!R\u0010\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0004\n\u0002\u0010$R\u0010\u0010%\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u00020'X\u0082\u0004¢\u0006\u0004\n\u0002\u0010(R\u0014\u0010;\u001a\u0002038BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b<\u0010=¨\u0006I"}, d2 = {"Lcom/obric/assistant/component/ObricAppeaseComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "<init>", "()V", "chatConversationAbility", "Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "getChatConversationAbility", "()Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "chatConversationAbility$delegate", "Lkotlin/Lazy;", "preCvsId", "", "appeasePlayer", "Lcom/larus/call_plugins_doubao_common/manager/AudioSoundAppeaseManager;", "getAppeasePlayer", "()Lcom/larus/call_plugins_doubao_common/manager/AudioSoundAppeaseManager;", "appeasePlayer$delegate", "playJob", "Lkotlinx/coroutines/Job;", "stopJob", "authObserverJob", "scope", "Lkotlinx/coroutines/CoroutineScope;", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "scope$delegate", "appeaseTextArray", "", "kotlin.jvm.PlatformType", "[Ljava/lang/String;", "currentPlayingTtsId", "appBackgroundListener", "com/obric/assistant/component/ObricAppeaseComponent$appBackgroundListener$1", "Lcom/obric/assistant/component/ObricAppeaseComponent$appBackgroundListener$1;", "audioObserver", "com/obric/assistant/component/ObricAppeaseComponent$audioObserver$1", "Lcom/obric/assistant/component/ObricAppeaseComponent$audioObserver$1;", "currentSentMsgId", "changeListener", "com/obric/assistant/component/ObricAppeaseComponent$changeListener$1", "Lcom/obric/assistant/component/ObricAppeaseComponent$changeListener$1;", "onCreate", "", "observeAuthenticationState", "cancelPlayAppeaseIfActive", WindowEvent.Params.REASON, "changeCvsObserver", "newConversationId", "onStop", "onDestroy", "needPlayAppease", "", "msg", "Lcom/larus/im/bean/message/Message;", "ttsEnable", "getConversationId", "startPlayAppease", "shouldSkipAppease", "scene", "useObricTtsClient", "getUseObricTtsClient", "()Z", "playAppeaseText", "fallbackPlayByImTts", "content", "release", "cancelPlayAppease", "updateOrReceiveMessage", "isUpdate", "isCurrentReplyMessage", "notClarifyMsg", "isActive", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricAppeaseComponent extends BaseContentWidget {
    public static final /* synthetic */ int z = 0;
    public final Lazy m;
    public String n;
    public final Lazy o;
    public Job p;
    public Job q;
    public Job r;
    public final Lazy s;
    public final String[] t;
    public String u;
    public final b v;
    public final c w;
    public String x;
    public final d y;

    public static final class a {
    }

    public static final class b implements f09.a.b {
        public final /* synthetic */ ObricAppeaseComponent a;

        public final void onAllActivityDestroyed() {
        }

        public final void onAppForeground() {
        }

        public final void onAppBackground() {
            ObricAppeaseComponent.Y2(this.a, "app background");
        }

        public b(ObricAppeaseComponent r1) {
            this.a = r1;
        }
    }

    public static final class c implements cha.a {
        public final /* synthetic */ ObricAppeaseComponent a;

        public c(ObricAppeaseComponent r1) {
            this.a = r1;
        }

        public final void b(ObricTtsInfo r3, int r4) {
            Intrinsics.checkNotNullParameter(r3, "ttsInfo");
            Intrinsics.checkNotNullParameter(r3, "ttsInfo");
            if (r4 != PlayStateEnum.PLAY_STATE_PREPARE.getState()) goto L9;
            if (Intrinsics.areEqual(r3.getMsgId(), "appease_tts_message") == true) goto L7;
            FLogger.a.i("ObricAppeaseComponent", "cancel by tts prepare");
            ObricAppeaseComponent r5 = this.a;
            int r0 = ObricAppeaseComponent.z;
            r5.p3();
        L7:
            ObricAppeaseComponent r6 = this.a;
            r6.u = r3.getMsgId();
            return;
        L9:
            if (r4 != PlayStateEnum.PLAY_STATE_STOPPED.getState()) goto L11;
        L12:
            this.a.u = null;
            return;
        L11:
            if (r4 == PlayStateEnum.PLAY_STATE_FAIL.getState()) goto L12;
        }
    }

    public static final class d implements nf9.b {
        public final /* synthetic */ ObricAppeaseComponent a;

        public final void b(String r2, MessageListState r3, List<Message> r4) {
            Intrinsics.checkNotNullParameter(r2, "cid");
            Intrinsics.checkNotNullParameter(r3, "state");
            Intrinsics.checkNotNullParameter(r4, "msgList");
        }

        public final void d(String r2, Message r3) {
            Intrinsics.checkNotNullParameter(r2, "cid");
            Intrinsics.checkNotNullParameter(r3, "msg");
        }

        public final void f(String r2, Message r3) {
            Intrinsics.checkNotNullParameter(r2, "cid");
            Intrinsics.checkNotNullParameter(r3, "msg");
        }

        public final void onMessageListReplaced(String r2, List<Message> r3, List<Message> r4) {
            Intrinsics.checkNotNullParameter(r2, "cid");
            Intrinsics.checkNotNullParameter(r3, "oldMsgList");
            Intrinsics.checkNotNullParameter(r4, "newMsgList");
        }

        public d(ObricAppeaseComponent r1) {
            this.a = r1;
        }

        public final void a(String r12, Message r13) {
            Intrinsics.checkNotNullParameter(r12, "cid");
            Intrinsics.checkNotNullParameter(r13, "msg");
            int r14 = r13.getMessageStatusLocal();
            if (r14 != 0) goto L5;
            FLogger.a.i("ObricAppeaseComponent", "cancel play by local msg");
            ObricAppeaseComponent r15 = this.a;
            int r16 = ObricAppeaseComponent.z;
            r15.p3();
            return;
        L5:
            if (r14 != 10) goto L7;
            ObricAppeaseComponent r17 = this.a;
            int r1 = ObricAppeaseComponent.z;
            r17.getClass();
            boolean r2 = false;
            if (AudioServiceDelegate.a.g() == false) goto L14;
            FLogger.a.i("ObricAppeaseComponent", "ai note recording");
        L32:
            boolean r18 = false;
        L33:
            if (r18 == false) goto L61;
            this.a.getClass();
            Map r19 = r13.getExt();
            if (r19 == null) goto L37;
            String r110 = (String) r19.get("o_task_state");
        L39:
            if ((!Intrinsics.areEqual(r110, "clarify_auto_gui")) == false) goto L62;
            ObricAppeaseComponent r111 = this.a;
            Job r112 = r111.p;
            if (r112 != null) goto L43;
        L45:
            boolean r113 = false;
        L46:
            if (r113 == false) goto L48;
        L49:
            r2 = true;
        L50:
            if (r2 == true) goto L63;
            FLogger r114 = FLogger.a;
            r114.i("ObricAppeaseComponent", "start play");
            ObricAppeaseComponent r115 = this.a;
            r115.getClass();
            r114.i("ObricAppeaseComponent", "startPlayAppease and cancel old job");
            Job r116 = r115.p;
            if (r116 == null) goto L54;
            Job.DefaultImpls.cancel$default(r116, null, 1, null);
        L54:
            Job r117 = r115.q;
            if (r117 == null) goto L57;
            Job.DefaultImpls.cancel$default(r117, null, 1, null);
        L57:
            r115.p = BuildersKt.launch$default((CoroutineScope) r115.s.getValue(), null, null, new ObricAppeaseComponent$startPlayAppease$1(r115, null), 3, null);
            r115.q = BuildersKt.launch$default((CoroutineScope) r115.s.getValue(), null, null, new ObricAppeaseComponent$startPlayAppease$2(r115, null), 3, null);
            return;
        L63:
            return;
        L48:
            if (r111.B3().f == false) goto L50;
        L43:
            if (r112.isActive() != true) goto L45;
            r113 = true;
            goto L46
        L62:
            return;
        L37:
            r110 = null;
            goto L39
        L61:
            return;
        L14:
            if (AppHost.a.a().isAppBackground() == true) goto L16;
        L18:
            boolean r118 = IKeyguardStateKt.getKeyguardState().isKeyguardLocked();
            Map r4 = r13.getExt();
            if (r4 == null) goto L21;
            String r5 = (String) r4.get("obric_launch_wakeup");
        L22:
            IObricChatService.a.getClass();
            IObricChatService r6 = IObricChatService.a.a();
            if (r6 != null) goto L25;
        L27:
            boolean r7 = false;
        L28:
            FLogger.a.i("ObricAppeaseComponent", "msg from wakeup source: " + r5 + ", keyguard locked: " + r118);
            if (r7 == false) goto L32;
            if (r118 == false) goto L32;
            r18 = true;
            goto L33
        L25:
            if (r6.q() != true) goto L27;
            r7 = true;
            goto L28
        L21:
            r5 = null;
            goto L22
        L16:
            if (com.obric.assistant.t1.a.isTtsPlayBackgroundEnabled() == true) goto L18;
            FLogger.a.i("ObricAppeaseComponent", "background");
            goto L32
        L7:
            if (r14 != 11) goto L65;
            this.a.x = r13.getMessageId();
            return;
        }

        public final void c(String r1, Message r2, Map<String, String> r3) {
            Intrinsics.checkNotNullParameter(r1, "cid");
            Intrinsics.checkNotNullParameter(r2, "msg");
            ObricAppeaseComponent.m3(this.a, true, r2);
        }

        public final void e(String r1, Message r2, Map<String, String> r3) {
            Intrinsics.checkNotNullParameter(r1, "cid");
            Intrinsics.checkNotNullParameter(r2, "msg");
            ObricAppeaseComponent.m3(this.a, false, r2);
        }
    }

    public static final class e implements com.larus.bmhome.chat.component.cvs.y.a<wc9.e> {
        public final /* synthetic */ ObricAppeaseComponent a;

        public e(ObricAppeaseComponent r1) {
            this.a = r1;
        }

        public final void c(Object r5) {
            wc9.e r6 = (wc9.e) r5;
            Intrinsics.checkNotNullParameter(r6, "new");
            ObricAppeaseComponent r0 = this.a;
            String r7 = r6.a;
            if (com.larus.utils.o0.d(r0.n) == false) goto L8;
            NativeMessageServiceImpl r1 = com.larus.im.d.e();
            String r2 = r0.n;
            if (r2 != null) goto L7;
            r2 = r7;
        L7:
            r1.unregisterOnMessageChangedObserver(r2, r0.y);
        L8:
            com.larus.im.d.e().registerOnMessageChangedObserver(r7, r0.y);
            r0.n = r7;
        }
    }

    public static final class f implements Function0<com.larus.bmhome.chat.component.cvs.y> {
        public final /* synthetic */ AttachReceiver a;

        public f(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(com.larus.bmhome.chat.component.cvs.y.class));
        }
    }

    static {
    }

    public final AudioSoundAppeaseManager B3() {
        return (AudioSoundAppeaseManager) this.o.getValue();
    }

    public final String C3() {
        com.larus.bmhome.chat.component.cvs.y r0 = (com.larus.bmhome.chat.component.cvs.y) this.m.getValue();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.Y1();
    }

    public final void onDestroy() {
        FLogger.a.i("ObricAppeaseComponent", "cancel play by destroy");
        p3();
        Job r0 = this.r;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        AppHost.a.a().c(this.v);
        NativeMessageServiceImpl r1 = com.larus.im.d.e();
        String r2 = C3();
        if (r2 != null) goto L8;
        r2 = "";
    L8:
        r1.unregisterOnMessageChangedObserver(r2, this.y);
        IObricStateDispatcherService r3 = (IObricStateDispatcherService) ServiceManager.get().getService(IObricStateDispatcherService.class);
        if (r3 == null) goto L11;
        r3.g(this.w);
    L11:
        p3();
        B3().f();
        IVideoController r4 = B3().d();
        if (r4 == null) goto L15;
        r4.t();
        return;
    }

    public final void onStop() {
        if (ObricTtsControlDelegate.b.m() == false) goto L6;
        FLogger.a.i("ObricAppeaseComponent", "cancel play by stop");
        p3();
        return;
    }

    public final void p3() {
        FLogger.a.i("ObricAppeaseComponent", "cancelPlayAppease");
        Job r0 = this.p;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        boolean r2 = false;
    L9:
        if (r2 == false) goto L13;
        Job r3 = this.p;
        if (r3 == null) goto L13;
        Job.DefaultImpls.cancel$default(r3, null, 1, null);
    L13:
        AudioSoundAppeaseManager r4 = B3();
        int r5 = AudioSoundAppeaseManager.i;
        r4.i(null);
        Job r6 = this.q;
        if (r6 != null) goto L16;
    L18:
        if (r1 == false) goto L23;
        Job r7 = this.q;
        if (r7 == null) goto L24;
        Job.DefaultImpls.cancel$default(r7, null, 1, null);
        return;
    L24:
        return;
    L23:
        return;
    L16:
        if (r6.isActive() != true) goto L18;
        r1 = true;
        goto L18
    L5:
        if (r0.isActive() != true) goto L7;
        r2 = true;
        goto L9
    }

    public ObricAppeaseComponent() {
        this.m = LazyKt.lazy(new f(this));
        this.o = LazyKt.lazy(new com.obric.assistant.component.d());
        this.s = LazyKt.lazy(new com.obric.assistant.component.e());
        this.t = AppHost.a.getApplication().getResources().getStringArray(2130903040);
        this.v = new b(this);
        this.w = new c(this);
        this.y = new d(this);
    }

    public final void onCreate() {
        super/*com.larus.ui.arch.component.external.delegate.BaseComponentWidget*/.onCreate();
        com.larus.bmhome.chat.component.cvs.y r0 = (com.larus.bmhome.chat.component.cvs.y) this.m.getValue();
        if (r0 == null) goto L5;
        r0.rh(new com.obric.assistant.component.c(), new e(this));
    L5:
        IObricStateDispatcherService r1 = (IObricStateDispatcherService) ServiceManager.get().getService(IObricStateDispatcherService.class);
        if (r1 == null) goto L8;
        r1.i(this.w);
    L8:
        AppHost.a.a().j(this.v);
        Job r2 = this.r;
        if (r2 == null) goto L11;
        Job.DefaultImpls.cancel$default(r2, null, 1, null);
    L11:
        this.r = BuildersKt.launch$default((CoroutineScope) this.s.getValue(), null, null, new ObricAppeaseComponent$observeAuthenticationState$1(this, null), 3, null);
    }

    public final void z3(String r50) {
        FLogger r0 = FLogger.a;
        r0.i("ObricAppeaseComponent", "fallbackPlayByImTts, content length=" + r50.length() + ", cvsId=" + C3());
        IObricTtsService r1 = (IObricTtsService) ServiceManager.get().getService(IObricTtsService.class);
        if (r1 != null) goto L6;
        r0.e("ObricAppeaseComponent", "fallbackPlayByImTts: IObricTtsService not available");
        return;
    L6:
        r1.e(new Message(C3(), null, null, 0, 21, null, 0, false, null, r50, null, null, null, MapsKt.mapOf(TuplesKt.to("tts_not_supported", "0")), "unknown", "appease_tts_message", 0, 0, false, null, null, null, null, null, null, 0, false, 0, null, null, false, null, null, 0, null, null, null, -57874, 31, null), 2);
        r0.i("ObricAppeaseComponent", "fallbackPlayByImTts: readContentByMessage dispatched");
    }

    public static final void Y2(ObricAppeaseComponent r4, String r5) {
        Job r0 = r4.p;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        boolean r2 = false;
    L9:
        if (r2 == true) goto L21;
        Job r3 = r4.q;
        if (r3 != null) goto L13;
    L15:
        if (r1 == true) goto L21;
        if (r4.B3().f == true) goto L21;
        if (Intrinsics.areEqual(r4.u, "appease_tts_message") == true) goto L21;
        return;
    L13:
        if (r3.isActive() != true) goto L15;
        r1 = true;
    L21:
        FLogger r6 = FLogger.a;
        r6.i("ObricAppeaseComponent", "cancel play by ".concat(r5));
        r4.p3();
        if (Intrinsics.areEqual(r4.u, "appease_tts_message") == false) goto L25;
        r6.i("ObricAppeaseComponent", "interrupt appease tts by ".concat(r5));
        ObricAssistantBaseServiceDelegate.b.a();
        return;
    L25:
        return;
    L5:
        if (r0.isActive() != true) goto L7;
        r2 = true;
        goto L9
    }

    public static final boolean h3(ObricAppeaseComponent r3, String r4) {
        r3.getClass();
        IKeyguardService r5 = (IKeyguardService) ServiceManager.get().getService(IKeyguardService.class);
        if (r5 == null) goto L7;
        kotlinx.coroutines.flow.i1 r6 = r5.isDismissingKeyguard();
        if (r6 == null) goto L7;
        ((Boolean) r6.getValue()).booleanValue();
    L7:
        ISessionAuthenticationService r7 = (ISessionAuthenticationService) ServiceManager.get().getService(ISessionAuthenticationService.class);
        if (r7 == null) goto L12;
        kotlinx.coroutines.flow.i1 r8 = r7.l();
        if (r8 == null) goto L12;
        boolean r9 = ((Boolean) r8.getValue()).booleanValue();
    L13:
        FLogger.a.e("ObricAppeaseComponent", "play appease error " + r4 + ", isBiometricAuthenticating: " + r9);
        return r9;
    L12:
        r9 = false;
        goto L13
    }

    public static final void m3(ObricAppeaseComponent r9, boolean r10, Message r11) {
        r9.getClass();
        if (Intrinsics.areEqual(r11.getReplyId(), r9.x) == false) goto L60;
        int r0 = r11.getMessageStatusLocal();
        if (r0 != 20) goto L8;
    L10:
        boolean r2 = false;
        if (com.larus.im.bean.message.a.C0(r11) == false) goto L23;
        int r1 = wf9.b.a;
        Intrinsics.checkNotNullParameter(r11, "message");
        boolean r3 = com.larus.im.bean.message.a.r0(r11);
        boolean r4 = com.larus.bmhome.chat.bean.d.f0(r11);
        if (r3 == true) goto L15;
        if (r4 == true) goto L15;
    L16:
        FLogger r5 = FLogger.a;
        r5.i("ObricAppeaseComponent", "isServerLoading = " + r3 + ", isDeepThinkingTyping = " + r4 + ", msg id = " + r11.getMessageId());
        if (r10 == false) goto L52;
        if (r2 == true) goto L53;
        r5.i("ObricAppeaseComponent", "cancel play by deep thinking message loaded completely");
        r9.p3();
        if (Intrinsics.areEqual(r9.u, "appease_tts_message") == false) goto L54;
        r5.i("ObricAppeaseComponent", "interrupt appease tts");
        ObricAssistantBaseServiceDelegate.b.a();
        return;
    L54:
        return;
    L53:
        return;
    L52:
        return;
    L15:
        r2 = true;
        goto L16
    L23:
        if (r11.getContentType() == 100) goto L48;
        if (r10 == true) goto L28;
        Gson r6 = TtsSilentInterceptor.a;
        if (TtsSilentInterceptor.a.a(r11) == true) goto L48;
    L28:
        if (Intrinsics.areEqual(com.larus.bmhome.chat.bean.d.B(r11), "type_800") == true) goto L48;
        if (r10 == false) goto L32;
    L45:
        FLogger r12 = FLogger.a;
        r12.i("ObricAppeaseComponent", "cancel play by simple text message");
        r9.p3();
        if (Intrinsics.areEqual(r9.u, "appease_tts_message") == false) goto L57;
        r12.i("ObricAppeaseComponent", "interrupt appease tts");
        ObricAssistantBaseServiceDelegate.b.a();
        return;
    L57:
        return;
    L32:
        if (r11.getMessageStatusLocal() != 20) goto L45;
        Job r13 = r9.p;
        if (r13 != null) goto L36;
    L38:
        boolean r14 = false;
    L39:
        if (r14 == false) goto L41;
    L42:
        r2 = true;
    L43:
        if (r2 == false) goto L45;
        FLogger.a.i("ObricAppeaseComponent", "skip cancel for first streaming msg, waiting for type confirmation");
        return;
    L41:
        if (r9.B3().f == false) goto L43;
    L36:
        if (r13.isActive() != true) goto L38;
        r14 = true;
    L48:
        FLogger r15 = FLogger.a;
        r15.i("ObricAppeaseComponent", "cancel play by widget|silent|other message");
        r9.p3();
        if (Intrinsics.areEqual(r9.u, "appease_tts_message") == false) goto L59;
        r15.i("ObricAppeaseComponent", "interrupt appease tts");
        ObricAssistantBaseServiceDelegate.b.a();
        return;
    L59:
        return;
    L8:
        if (r0 == 21) goto L10;
        return;
    }
}
