package com.obric.assistant.special_input;

import android.os.SystemClock;
import android.service.voice.VoiceInteractionSession;
import com.larus.account.base.api.ILoginService;
import com.larus.im.d;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.obric.aiagent.assistant.idl.IAssistantInteractionListenerIDL;
import com.obric.aiagent.assistant.idl.bean.DMTaskState;
import com.obric.aiagent.assistant.idl.bean.StateInfo;
import com.obric.assistant.automic.IObricAutoMicService;
import com.obric.assistant.interaction.base.feedback.VibratorSmtFeedbackEffect;
import com.obric.assistant.interaction.base.util.SoundEffectHelper;
import com.obric.assistant.interaction.base.util.SystemHiddenApiHelper;
import com.obric.assistant.live.util.ObricIslandType;
import com.obric.assistant.special_input.util.AssistantInteractionListenerIDLWrapper;
import com.obric.assistant.special_input.util.l;
import com.obric.assistant.special_input.util.l$b;
import com.obric.assistant.task.ObricTaskStatusManager;
import com.obric.assistant.util.r2;
import com.obric.assistant.voice.ComplexEvent;
import com.obric.assistant.voice.ContentScene;
import com.obric.assistant.voice.IObricVoiceService;
import com.obric.assistant.voice.OAutoEvent;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.flow.b1;
import kotlinx.coroutines.sync.MutexImpl;
import kotlinx.coroutines.sync.b;
import laa.j;
import laa.v;
import maa.e;
import va8.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 C2\u00020\u0001:\u0001CB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u001a\u001a\u00020\u0014H\u0016J:\u0010\u001b\u001a\u00020\u00142\b\u0010\u001c\u001a\u0004\u0018\u00010\n2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u001e2\u000e\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013H\u0016J\b\u0010\"\u001a\u00020\u0014H\u0002J\u0012\u0010#\u001a\u00020\u00142\b\u0010$\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010%\u001a\u00020\u00142\b\u0010&\u001a\u0004\u0018\u00010\u0006H\u0016J+\u0010'\u001a\u00020\u00142\b\u0010$\u001a\u0004\u0018\u00010\u00062\b\u0010(\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001c\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0002\u0010)J\u001c\u0010*\u001a\u00020\u00142\b\u0010$\u001a\u0004\u0018\u00010\u00062\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\n\u0010-\u001a\u0004\u0018\u00010\nH\u0016J\u0014\u0010.\u001a\u0004\u0018\u00010\u00072\b\u0010$\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010/\u001a\u00020\u00142\u0006\u00100\u001a\u000201H\u0016J&\u00102\u001a\u00020\u00142\u0006\u00103\u001a\u0002042\u0014\u00105\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u000106H\u0016J\n\u00107\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u00108\u001a\u00020\u00142\b\u0010\u001c\u001a\u0004\u0018\u00010\nH\u0016J\u0010\u00109\u001a\u00020\u00142\u0006\u0010:\u001a\u00020\u000eH\u0002J\n\u0010;\u001a\u0004\u0018\u00010\nH\u0002J\u0018\u0010<\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\n2\u0006\u0010=\u001a\u00020\u0006H\u0002J\"\u0010>\u001a\u00020\u00142\u0006\u0010?\u001a\u00020@2\u0006\u0010\u001c\u001a\u00020\n2\b\u00100\u001a\u0004\u0018\u000101H\u0002J\u001a\u0010A\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\n2\b\u00100\u001a\u0004\u0018\u000101H\u0002J\b\u0010B\u001a\u00020\u0014H\u0002R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n0\tj\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n`\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006D"}, d2 = {"Lcom/obric/assistant/special_input/SpecialInputTaskImpl;", "Lcom/obric/assistant/special_input/ISpecialInputTask;", "<init>", "()V", "interactionListeners", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/obric/assistant/special_input/util/AssistantInteractionListenerIDLWrapper;", "waitingInputTasks", "Ljava/util/LinkedHashMap;", "Lcom/obric/aiagent/assistant/idl/bean/StateInfo;", "Lkotlin/collections/LinkedHashMap;", "shortLivedOnceTaskInfo", "clearShortLivedOnceTaskInfoJob", "Lkotlinx/coroutines/Job;", "specialInputMsgForwardTool", "Lcom/obric/assistant/special_input/util/SpecialInputMsgForwardTool;", "taskQueue", "Lkotlinx/coroutines/channels/Channel;", "Lkotlin/Function0;", "", "mainScope", "Lkotlinx/coroutines/CoroutineScope;", "workScope", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "init", "openAssistantInputPanel", "stateInfo", DBDefinition.FORCE, "", "isAppInnerCall", "isAutoOpen", "completeCallback", "closeSystemDialogsForInputPanel", "closeAssistantInputPanel", DBDefinition.PACKAGE_NAME, "closeAssistantInputPanelWithTaskQueryMessageId", "taskQueryMessageId", "notifyAssistantState", "enter", "(Ljava/lang/String;Ljava/lang/Boolean;Lcom/obric/aiagent/assistant/idl/bean/StateInfo;)V", "setAssistantInteractionListener", "listener", "Lcom/obric/aiagent/assistant/idl/IAssistantInteractionListenerIDL;", "getWaitingInputTaskInfo", "getAssistantInteractionListener", "requestToShowInputPanelWithMeta", "meta", "Lcom/obric/assistant/special_input/SpecialInputMeta;", "requestToShowComplexTaskPanel", "panelType", "Lcom/obric/assistant/special_input/ObricComplexTaskPanelType;", "ext", "", "fetchAndConsumeShortLivedOnceTaskInfo", "setShortLivedOnceTaskInfo", "resetClearShortLivedOnceTaskInfoJob", "completeJob", "getAssistantInputStateInfo", "updateLaunchReportParams", "topPkg", "tryTurnOnMic", "vContext", "Lcom/larus/ui/arch/context/external/VContext;", "turnOnAutoMic", "playListenEffect", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SpecialInputTaskImpl implements ISpecialInputTask {
    public static final /* synthetic */ int j = 0;
    public final ConcurrentHashMap<String, AssistantInteractionListenerIDLWrapper> a;
    public final LinkedHashMap<String, StateInfo> b;
    public StateInfo c;
    public Job d;
    public final l e;
    public final Channel<Function0<Unit>> f;
    public final CoroutineScope g;
    public final CoroutineScope h;
    public final MutexImpl i;

    /* JADX INFO: renamed from: com.obric.assistant.special_input.SpecialInputTaskImpl$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.special_input.SpecialInputTaskImpl$1", f = "SpecialInputTaskImpl.kt", i = {}, l = {83}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;
        final /* synthetic */ SpecialInputTaskImpl this$0;

        public AnonymousClass1(SpecialInputTaskImpl r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0040 -> B:13:0x0045). Please report as a decompilation issue!!! */
        public final Object invokeSuspend(Object r12) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ChannelIterator<Function0<Unit>> r2 = (ChannelIterator) this.L$0;
            ResultKt.throwOnFailure(r12);
            ChannelIterator<Function0<Unit>> r4 = r2;
            Object r3 = r0;
            AnonymousClass1 r5 = this;
        L14:
            if (((Boolean) r12).booleanValue() == false) goto L16;
            Function0<Unit> r13 = r4.next();
            FLogger r6 = FLogger.a;
            r6.i("SpecialInputTaskImpl", "handle task start");
            long r7 = SystemClock.elapsedRealtime();
            r13.invoke();
            r6.i("SpecialInputTaskImpl", "handle task finish. used time = " + (SystemClock.elapsedRealtime() - r7) + " ms");
            AnonymousClass1 r14 = r5;
            r0 = r3;
            ChannelIterator<Function0<Unit>> r8 = r4;
        L9:
            r14.L$0 = r8;
            r14.label = 1;
            Object r9 = r8.hasNext(r14);
            if (r9 != r0) goto L12;
            return r0;
        L12:
            Object r10 = r0;
            r5 = r14;
            r12 = r9;
            r4 = r8;
            r3 = r10;
            goto L14
        L16:
            FLogger.a.w("SpecialInputTaskImpl", "stop monitor task queue");
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r12);
            FLogger.a.i("SpecialInputTaskImpl", "start monitor task queue");
            r8 = this.this$0.f.iterator();
            r14 = this;
            goto L9
        }
    }

    static {
    }

    public final synchronized StateInfo g() {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (this.c != null) goto L8;
        monitor-exit(this);
        return null;
    L8:
        Job r0 = this.d;     // Catch: Throwable -> L14
        if (r0 == null) goto L11;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);     // Catch: Throwable -> L14
    L11:
        StateInfo r1 = this.c;     // Catch: Throwable -> L14
        this.c = null;     // Catch: Throwable -> L14
        monitor-exit(this);
        return r1;
    }

    public final StateInfo a() {
        LinkedHashMap<String, StateInfo> r0 = this.b;
        monitor-enter(r0);
        StateInfo r2 = null;
        if ((!this.b.isEmpty()) == false) goto L9;
        Map.Entry r1 = (Map.Entry) CollectionsKt.lastOrNull(this.b.entrySet());     // Catch: Throwable -> L11
        if (r1 == null) goto L9;
        r2 = (StateInfo) r1.getValue();     // Catch: Throwable -> L11
    L9:
        monitor-exit(r0);
        return r2;
    L11:
        th = move-exception;
        throw th;
    }

    public final void init() {
        l r0 = this.e;
        r0.getClass();
        FLogger.a.i("SpecialInputMsgForwardTool", "init");
        d.e().registerOnGlobalMessageObserver((l$b) r0.a.getValue());
    }

    public SpecialInputTaskImpl() {
        this.a = new ConcurrentHashMap();
        this.b = new LinkedHashMap();
        this.e = new l();
        this.f = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);
        this.g = CoroutineScopeKt.MainScope();
        CoroutineScope r2 = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
        this.h = r2;
        this.i = b.a();
        BuildersKt.launch$default(r2, null, null, new AnonymousClass1(this, null), 3, null);
    }

    public static final void i(SpecialInputTaskImpl r3) {
        r3.getClass();
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L12
        IObricVoiceService.a.getClass();     // Catch: Throwable -> L12
        IObricVoiceService r1 = IObricVoiceService.a.a();     // Catch: Throwable -> L12
        if (r1 == null) goto L6;
        VoiceInteractionSession r2 = r1.m();     // Catch: Throwable -> L12
    L7:
        if (r2 != null) goto L9;
        FLogger.a.w("SpecialInputTaskImpl", "closeSystemDialogs skipped: session unavailable");     // Catch: Throwable -> L12
    L10:
        Object r4 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L12
    L14:
        Throwable r5 = Result.exceptionOrNull-impl(r4);
        if (r5 == null) goto L20;
        FLogger.a.e("SpecialInputTaskImpl", "closeSystemDialogs for input panel failed", r5);
        return;
    L20:
        return;
    L9:
        FLogger.a.i("SpecialInputTaskImpl", "request closeSystemDialogs for input panel");     // Catch: Throwable -> L12
        r2.closeSystemDialogs();     // Catch: Throwable -> L12
        goto L10
    L6:
        r2 = null;
    L12:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    }

    public final void c(String r5) {
        t1a.b r0 = r2.a();
        String r1 = null;
        if (r0 == null) goto L11;
        j r2 = r0.getAbility(j.class);
        if (r2 == null) goto L11;
        b1 r3 = r2.i80();
        if (r3 == null) goto L11;
        v r4 = (v) r3.getValue();
        if (r4 == null) goto L11;
        StateInfo r6 = r4.b;
    L12:
        if (r6 == null) goto L14;
        r1 = r6.getRefMessageId();
    L14:
        if (r1 != null) goto L16;
        r1 = "";
    L16:
        FLogger r7 = FLogger.a;
        r7.i("SpecialInputTaskImpl", "closeAssistantInputPanelWithTaskQueryMessageId: taskQueryMessageId = " + r5 + ", inputRefMessageId = " + r1);
        if (r1.length() <= 0) goto L19;
        boolean r8 = true;
    L20:
        if (r8 == true) goto L22;
        return;
    L22:
        if (Intrinsics.areEqual(r1, r5) == false) goto L26;
        r7.i("SpecialInputTaskImpl", "closeAssistantInputPanelWithTaskQueryMessageId: close assistant input panel");
        closeAssistantInputPanel(ObricIslandType.COMPLEX_TASK.getValue());
        return;
    L26:
        return;
    L19:
        r8 = false;
    L11:
        r6 = null;
        goto L12
    }

    public final void closeAssistantInputPanel(String r10) {
        FLogger.a.i("SpecialInputTaskImpl", "closeAssistantInputPanel: packageName = " + r10);
        BuildersKt.launch$default(this.g, null, null, new closeAssistantInputPanel.1(r10, null), 3, null);
    }

    public final void f(w0 r4) {
        Intrinsics.checkNotNullParameter(r4, "meta");
        FLogger.a.i("SpecialInputTaskImpl", "requestToShowInputPanelWithMeta: meta = " + r4);
        AssistantInteractionListenerIDLWrapper r0 = k("com.obric.autoaction");
        if (r0 == null) goto L6;
        r0.requestToShowInputPanelWithMeta(com.larus.utils.gson.b.a(r4));
        return;
    }

    public final /* bridge */ /* synthetic */ AssistantInteractionListenerIDLWrapper h(String r1) {
        return k(r1);
    }

    public final AssistantInteractionListenerIDLWrapper k(String r5) {
        ConcurrentHashMap<String, AssistantInteractionListenerIDLWrapper> r0 = this.a;
        if (r5 != null) goto L5;
        String r1 = "";
    L6:
        AssistantInteractionListenerIDLWrapper r2 = r0.get(r1);
        if (r2 != null) goto L9;
        FLogger.a.w("SpecialInputTaskImpl", "not found listener of " + r5);
    L9:
        return r2;
    L5:
        r1 = r5;
        goto L6
    }

    public final synchronized void l(StateInfo r7) {
        monitor-enter(this);
        this.c = r7;     // Catch: Throwable -> L10
        Job r0 = this.d;     // Catch: Throwable -> L10
        if (r0 == null) goto L6;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);     // Catch: Throwable -> L10
    L6:
        if (r7 == null) goto L8;
        Job r8 = BuildersKt.launch$default(this.g, null, null, new setShortLivedOnceTaskInfo.1(this, null), 3, null);     // Catch: Throwable -> L10
        r8.invokeOnCompletion(new h1(this, r8));     // Catch: Throwable -> L10
        this.d = r8;     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public static void m(StateInfo r7, w0 r8) {
        FLogger r0 = FLogger.a;
        r0.i("SpecialInputTaskImpl", "turnOnAutoMic: turn on mic for existing input");
        ContentScene.a r2 = ContentScene.Companion;
        String r3 = null;
        if (r8 == null) goto L5;
        String r4 = r8.b();
    L6:
        String r5 = "";
        if (r4 != null) goto L9;
        r4 = "";
    L9:
        r2.getClass();
        ContentScene r6 = ContentScene.a.a(r4);
        StringBuilder r9 = new StringBuilder("turnOnAutoMic: meta?.subScene = ");
        if (r8 == null) goto L12;
        String r10 = r8.b();
    L13:
        r9.append(r10);
        r9.append(", contentScene = ");
        r9.append(r6);
        r0.i("SpecialInputTaskImpl", r9.toString());
        IObricAutoMicService.a.getClass();
        IObricAutoMicService r1 = IObricAutoMicService.a.a();
        if (r1 == null) goto L37;
        if (r8 == null) goto L18;
        r3 = r8.b();
    L18:
        if (Intrinsics.areEqual(r3, ContentScene.OAUTO_CALL_USER.getStr()) == false) goto L27;
        String r11 = r7.getRefMessageId();
        if (r11 != null) goto L22;
        r11 = "";
    L22:
        String r12 = r7.getContent();
        if (r12 == null) goto L26;
        r5 = r12;
    L26:
        OAutoEvent r13 = new OAutoEvent(r11, r5, r7);
    L35:
        IObricAutoMicService.b.a(r1, r6, r13);
        return;
    L27:
        String r14 = r7.getRefMessageId();
        if (r14 != null) goto L30;
        r14 = "";
    L30:
        String r15 = r7.getContent();
        if (r15 == null) goto L34;
        r5 = r15;
    L34:
        r13 = new ComplexEvent(r14, r5);
        goto L35
    L37:
        return;
    L12:
        r10 = null;
        goto L13
    L5:
        r4 = null;
        goto L6
    }

    public final void d(ObricComplexTaskPanelType r10, Map<String, String> r11) {
        Intrinsics.checkNotNullParameter(r10, "panelType");
        FLogger r0 = FLogger.a;
        r0.i("SpecialInputTaskImpl", "requestToShowComplexTaskPanel: panelType = " + r10 + ", ext = " + r11);
        ObricTaskStatusManager.a.getClass();
        DMTaskState r1 = ObricTaskStatusManager.c();
        if (r1 != null) goto L7;
        r0.w("SpecialInputTaskImpl", "requestToShowComplexTaskPanel: no running task, return");
        return;
    L7:
        if (com.obric.assistant.utils.l.e(r1) == true) goto L10;
        r0.i("SpecialInputTaskImpl", "requestToShowComplexTaskPanel: is not in clarify state, return");
        return;
    L10:
        BuildersKt.launch$default(this.g, null, null, new requestToShowComplexTaskPanel.1(this, r10, r11, null), 3, null);
    }

    public final void setAssistantInteractionListener(String r4, IAssistantInteractionListenerIDL r5) {
        FLogger.a.i("SpecialInputTaskImpl", "setAssistantInteractionListener: packageName = " + r4 + ", listener = " + r5);
        if (r5 == null) goto L8;
        ConcurrentHashMap<String, AssistantInteractionListenerIDLWrapper> r1 = this.a;
        if (r4 != null) goto L7;
        r4 = "";
    L7:
        r1.put(r4, new AssistantInteractionListenerIDLWrapper(r5, this.f));
        return;
    L8:
        ConcurrentHashMap<String, AssistantInteractionListenerIDLWrapper> r6 = this.a;
        if (r4 != null) goto L11;
        r4 = "";
    L11:
        r6.remove(r4);
    }

    public final void b(String r5, Boolean r6, StateInfo r7) {
        FLogger.a.i("SpecialInputTaskImpl", "notifyAssistantState: packageName = " + r5 + ", enter = " + r6 + ", stateInfo = " + r7);
        LinkedHashMap<String, StateInfo> r0 = this.b;
        monitor-enter(r0);
        LinkedHashMap<String, StateInfo> r1 = this.b;     // Catch: Throwable -> L18
        if (r5 != null) goto L7;
        String r2 = "";
    L8:
        r1.remove(r2);     // Catch: Throwable -> L18
        if (Intrinsics.areEqual(r6, Boolean.TRUE) == false) goto L15;
        if (r7 == null) goto L15;
        LinkedHashMap<String, StateInfo> r8 = this.b;     // Catch: Throwable -> L18
        if (r5 != null) goto L14;
        r5 = "";
    L14:
        r8.put(r5, r7);     // Catch: Throwable -> L18
    L15:
        Unit r9 = Unit.INSTANCE;     // Catch: Throwable -> L18
        monitor-exit(r0);
        return;
    L7:
        r2 = r5;
    L18:
        th = move-exception;
        throw th;
    }

    public static final void j(SpecialInputTaskImpl r3, t1a.b r4, StateInfo r5, w0 r6) {
        r3.getClass();
        o r7 = r4.getAbility(o.class);
        boolean r0 = false;
        if (r7 == null) goto L9;
        String r8 = r7.u7();
        if (r8 == null) goto L9;
        if (o0.d(r8) != true) goto L9;
        boolean r9 = true;
    L11:
        if (r9 == false) goto L13;
        FLogger.a.i("SpecialInputTaskImpl", "tryTurnOnMic: has input text should not turn on mic");
        return;
    L13:
        if (r6 != null) goto L15;
    L17:
        if (r0 == false) goto L19;
        FLogger.a.i("SpecialInputTaskImpl", "tryTurnOnMic: auto open mic to reply");
        m(r5, r6);
        return;
    L19:
        FLogger.a.i("SpecialInputTaskImpl", "tryTurnOnMic: open click talk");
        if (ILoginService.a.getAccountInfo().a == false) goto L22;
        SoundEffectHelper.INSTANCE.playListening();
        SystemHiddenApiHelper.INSTANCE.performVibratorSmtFeedback(VibratorSmtFeedbackEffect.EFFECT_LONG_PRESS);
    L22:
        e r10 = r4.getAbility(e.class);
        if (r10 == null) goto L28;
        e.a.b(r10, 3, null, 6);
        return;
    L28:
        return;
    L15:
        if (r6.c() != true) goto L17;
        r0 = true;
    L9:
        r9 = false;
        goto L11
    }

    public final void e(StateInfo r15, boolean r16, boolean r17, boolean r18, Function0<Unit> r19) {
        FLogger r0 = FLogger.a;
        r0.i("SpecialInputTaskImpl", "openAssistantInputPanel: stateInfo = " + r15 + ", force = " + r16 + ", isAppInnerCall = " + r17 + ", isAutoOpen = " + r18);
        if (r15 != null) goto L6;
        r0.w("SpecialInputTaskImpl", "stateInfo is null");
        BuildersKt.launch$default(this.g, null, null, new openAssistantInputPanel.1(r19, null), 3, null);
        return;
    L6:
        BuildersKt.launch$default(this.h, null, null, new openAssistantInputPanel.2(this, r15, r17, r16, r18, null), 3, null).invokeOnCompletion(new g1(this, r19));
    }
}
