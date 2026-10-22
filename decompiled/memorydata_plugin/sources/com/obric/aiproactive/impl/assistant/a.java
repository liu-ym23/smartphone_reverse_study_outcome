package com.obric.aiproactive.impl.assistant;

import android.app.Application;
import com.obric.eventkit.EventsTaskSdk;
import com.obric.eventkit.eventstaskmanager.ActiveAgentEvent;
import com.obric.memorydata.database.entity.ChatMessage;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.da;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001,B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012J(\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00052\u0016\b\u0002\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0018J\u0018\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u0005J\u001c\u0010\u001b\u001a\u00020\u000f2\u0014\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0018J\u0018\u0010\u001c\u001a\u00020\u000f2\b\b\u0002\u0010\u001d\u001a\u00020\tH\u0086@¢\u0006\u0002\u0010\u001eJ \u0010\u001f\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u00052\b\b\u0002\u0010\u001d\u001a\u00020\tH\u0086@¢\u0006\u0002\u0010 J6\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u00152\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u000fH\u0082@¢\u0006\u0002\u0010'J\u0010\u0010(\u001a\u0004\u0018\u00010)H\u0082@¢\u0006\u0002\u0010*J\u0010\u0010+\u001a\u0004\u0018\u00010)H\u0082@¢\u0006\u0002\u0010*R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/obric/aiproactive/impl/assistant/AiProactiveAssistantLauncher;", "", "<init>", "()V", "TAG", "", "EXTRA_EXT_CONTEXT", "EMPTY_EXT_CONTEXT_JSON", "ACTIVE_AGENT_TIMEOUT_MS", "", "ACTIVE_AGENT_STATE_TIMEOUT_MS", "VOICE_ENTRY_EXPAND_STATE", "VOICE_ENTRY_INSTRUCTION_TYPE", "VOICE_ENTRY_INSTRUCTION_ENTRY", "initialized", "", "initSdk", "application", "Landroid/app/Application;", "ensureSdkInitialized", "buildVoiceEntryEvent", "Lcom/obric/eventkit/eventstaskmanager/ActiveAgentEvent;", "eventId", "reservedParams", "", "buildQueryEntryEvent", ChatMessage.TYPE_QUERY, "shouldAttachReservedParams", "tryOpenVoiceEntry", "timeoutMs", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tryOpenQueryEntry", "(Ljava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "logActiveAgentDebugState", "", "stage", "event", "rawResult", "timedOut", "(Ljava/lang/String;Lcom/obric/eventkit/eventstaskmanager/ActiveAgentEvent;Ljava/lang/Boolean;Ljava/lang/Boolean;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "queryAssistantSessionState", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "queryAssistantTtsState", "ActiveAgentResult", "ai_proactive_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f6389a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile boolean f6390b;

    /* JADX INFO: renamed from: com.obric.aiproactive.impl.assistant.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J$\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/obric/aiproactive/impl/assistant/AiProactiveAssistantLauncher$ActiveAgentResult;", "", "accepted", "", "timedOut", "<init>", "(Ljava/lang/Boolean;Z)V", "getAccepted", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getTimedOut", "()Z", "component1", "component2", "copy", "(Ljava/lang/Boolean;Z)Lcom/obric/aiproactive/impl/assistant/AiProactiveAssistantLauncher$ActiveAgentResult;", "equals", "other", "hashCode", "", "toString", "", "ai_proactive_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class C0283a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Boolean f6391a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f6392b;

        public C0283a(Boolean r1, boolean r2) {
            this.f6391a = r1;
            this.f6392b = r2;
        }

        public final Boolean a() {
            return this.f6391a;
        }

        public final boolean b() {
            return this.f6392b;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, C0283a.class) == true) goto L8;
            return false;
        L8:
            C0283a r6 = (C0283a) ZeusTransformUtils.preCheckCast(r5, C0283a.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f6391a, r6.f6391a) == true) goto L12;
            return false;
        L12:
            if (this.f6392b == r6.f6392b) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            Boolean r0 = this.f6391a;
            if (r0 != null) goto L5;
            int r1 = 0;
        L7:
            return (r1 * 31) + Boolean.hashCode(this.f6392b);
        L5:
            r1 = r0.hashCode();
            goto L7
        }

        public String toString() {
            return "ActiveAgentResult(accepted=" + this.f6391a + ", timedOut=" + this.f6392b + ')';
        }
    }

    static {
        f6389a = new a();
    }

    private a() {
    }

    public static /* synthetic */ ActiveAgentEvent a(a r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = "ai-proactive-query-" + UUID.randomUUID();
    L6:
        return r0.a(r1, r2);
    }

    public static /* synthetic */ ActiveAgentEvent a(a r1, String r2, Map r3, int r4, Object r5) {
        Map<String, ? extends Object> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        if ((r4 & 1) == 0) goto L6;
        r2 = "ai-proactive-voice-" + UUID.randomUUID();
    L6:
        if ((r4 & 2) == 0) goto L9;
        r6 = null;
    L9:
        return r1.a(r2, r6);
    }

    public static /* synthetic */ Object a(a r1, long r2, Continuation r4, int r5, Object r6) {
        Continuation<? super Boolean> r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        if ((r5 & 1) == 0) goto L6;
        r2 = 8000;
    L6:
        return r1.a(r2, r7);
    }

    public static /* synthetic */ Object a(a r1, String r2, long r3, Continuation r5, int r6, Object r7) {
        Continuation<? super Boolean> r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        if ((r6 & 2) == 0) goto L6;
        r3 = 8000;
    L6:
        return r1.a(r2, r3, r8);
    }

    public static final /* synthetic */ Object a(a r6, String r7, ActiveAgentEvent r8, Boolean r9, Boolean r10, Continuation r11) {
        return r6.a(r7, r8, r9, r10, (Continuation) ZeusTransformUtils.wrapperContextForParams(r11, Continuation.class, "com.obric.memorydata.plugin"));
    }

    static /* synthetic */ Object a(a r6, String r7, ActiveAgentEvent r8, Boolean r9, Boolean r10, Continuation r11, int r12, Object r13) {
        Continuation<? super Unit> r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r11, Continuation.class, "com.obric.memorydata.plugin");
        if ((r12 & 4) == 0) goto L5;
        Boolean r3 = null;
    L7:
        if ((r12 & 8) == 0) goto L9;
        Boolean r4 = null;
    L11:
        return r6.a(r7, r8, r3, r4, r5);
    L9:
        r4 = r10;
        goto L11
    L5:
        r3 = r9;
        goto L7
    }

    public static final /* synthetic */ Object a(a r2, Continuation r3) {
        return r2.a((Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    private final Object a(String r16, ActiveAgentEvent r17, Boolean r18, Boolean r19, Continuation<? super Unit> r20) {
        Continuation r1 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r20, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r1, AiProactiveAssistantLauncher$logActiveAgentDebugState$1.class) == false) goto L7;
        AiProactiveAssistantLauncher$logActiveAgentDebugState$1 r3 = (AiProactiveAssistantLauncher$logActiveAgentDebugState$1) ZeusTransformUtils.preCheckCast(r1, AiProactiveAssistantLauncher$logActiveAgentDebugState$1.class, "com.obric.memorydata.plugin");
        if ((r3.label & Integer.MIN_VALUE) == 0) goto L7;
        r3.label -= Integer.MIN_VALUE;
    L8:
        Object r2 = r3.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r3.label;
        boolean r7 = true;
        if (r5 == 0) goto L16;
        if (r5 == 1) goto L15;
        if (r5 != 2) goto L14;
        Integer r0 = (Integer) ZeusTransformUtils.preCheckCast(r3.L$4, Integer.class, "com.obric.memorydata.plugin");
        Boolean r6 = (Boolean) ZeusTransformUtils.preCheckCast(r3.L$3, Boolean.class, "com.obric.memorydata.plugin");
        Boolean r8 = (Boolean) ZeusTransformUtils.preCheckCast(r3.L$2, Boolean.class, "com.obric.memorydata.plugin");
        ActiveAgentEvent r9 = (ActiveAgentEvent) ZeusTransformUtils.preCheckCast(r3.L$1, ActiveAgentEvent.class, "com.obric.memorydata.plugin");
        String r10 = (String) ZeusTransformUtils.preCheckCast(r3.L$0, String.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r2);
    L24:
        Integer r11 = (Integer) ZeusTransformUtils.preCheckCast(r2, Integer.class, "com.obric.memorydata.plugin");
        IRunLog r12 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r13 = new StringBuilder();
        StringBuilder r14 = r13.append("debugActiveAgent stage=").append(r10).append(" packageName=").append(AppContext.INSTANCE.getPackageName()).append(" pid=").append(AppContext.INSTANCE.getPid()).append(" eventSource=").append(r9.getSource()).append(" eventType=").append(r9.getEventType()).append(" eventId=").append(r9.getId()).append(" queryEmpty=");
        CharSequence r15 = (CharSequence) ZeusTransformUtils.preCheckCast(r9.getQuery(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r15 != null) goto L27;
    L30:
        boolean r110 = true;
    L31:
        StringBuilder r21 = r14.append(r110).append(" contentEmpty=");
        CharSequence r22 = (CharSequence) ZeusTransformUtils.preCheckCast(r9.getContent(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r22 != null) goto L34;
    L37:
        StringBuilder r23 = r21.append(r7).append(" instructionType=manual_normal instructionEntry=app_query extraKeys=");
        ConcurrentHashMap<String, Object> r24 = r9.getExtra();
        if (r24 == null) goto L40;
        Set<String> r25 = r24.keySet();
    L41:
        r23.append(r25).append(" sessionState=").append(r0).append(" ttsState=").append(r11).append(" rawResult=");
        r13.append(r8).append(" timedOut=").append(r6);
        IRunLog.a.a(r12, "AiProactiveVoiceEntry", r13.toString(), false, 4, null);
        return Unit.INSTANCE;
    L40:
        r25 = null;
        goto L41
    L34:
        if (StringsKt.isBlank(r22) == true) goto L37;
        r7 = false;
        goto L37
    L27:
        if (StringsKt.isBlank(r15) == true) goto L30;
        r110 = false;
        goto L31
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        Boolean r26 = (Boolean) ZeusTransformUtils.preCheckCast(r3.L$4, Boolean.class, "com.obric.memorydata.plugin");
        Boolean r27 = (Boolean) ZeusTransformUtils.preCheckCast(r3.L$3, Boolean.class, "com.obric.memorydata.plugin");
        ActiveAgentEvent r28 = (ActiveAgentEvent) ZeusTransformUtils.preCheckCast(r3.L$2, ActiveAgentEvent.class, "com.obric.memorydata.plugin");
        String r29 = (String) ZeusTransformUtils.preCheckCast(r3.L$1, String.class, "com.obric.memorydata.plugin");
        a r111 = (a) ZeusTransformUtils.preCheckCast(r3.L$0, a.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r2);
        Object r30 = r2;
        String r31 = r29;
        Boolean r32 = r27;
        ActiveAgentEvent r33 = r28;
    L20:
        Integer r34 = (Integer) ZeusTransformUtils.preCheckCast(r30, Integer.class, "com.obric.memorydata.plugin");
        r3.L$0 = r31;
        r3.L$1 = r33;
        r3.L$2 = r32;
        r3.L$3 = r26;
        r3.L$4 = r34;
        r3.label = 2;
        Object r35 = r111.b(r3);
        if (r35 != r4) goto L23;
        return r4;
    L23:
        r6 = r26;
        r9 = r33;
        r8 = r32;
        r0 = r34;
        r10 = r31;
        r2 = r35;
        goto L24
    L16:
        ResultKt.throwOnFailure(r2);
        r3.L$0 = this;
        r31 = r16;
        r3.L$1 = r31;
        r33 = r17;
        r3.L$2 = r33;
        r32 = r18;
        r3.L$3 = r32;
        r3.L$4 = r19;
        r3.label = 1;
        Object r112 = a(r3);
        if (r112 != r4) goto L19;
        return r4;
    L19:
        r111 = this;
        r26 = r19;
        r30 = r112;
    L7:
        r3 = new AiProactiveAssistantLauncher$logActiveAgentDebugState$1(this, r1);
        goto L8
    }

    private final Object a(Continuation<? super Integer> r11) {
        Continuation r12 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r11, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r12, AiProactiveAssistantLauncher$queryAssistantSessionState$1.class) == false) goto L7;
        AiProactiveAssistantLauncher$queryAssistantSessionState$1 r0 = (AiProactiveAssistantLauncher$queryAssistantSessionState$1) ZeusTransformUtils.preCheckCast(r12, AiProactiveAssistantLauncher$queryAssistantSessionState$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r10 = r0.result;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L17;
        if (r2 != 1) goto L16;
        ResultKt.throwOnFailure(r10);     // Catch: Throwable -> L13
    L21:
        return (Integer) ZeusTransformUtils.preCheckCast(r10, Integer.class, "com.obric.memorydata.plugin");
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        ResultKt.throwOnFailure(r10);
        Function2 r14 = (Function2) ZeusTransformUtils.preCheckCast(new AiProactiveAssistantLauncher$queryAssistantSessionState$2(null), Function2.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L13
        r0.label = 1;     // Catch: Throwable -> L13
        r10 = da.b(500, r14, r0);     // Catch: Throwable -> L13
        if (r10 != r13) goto L21;
        return r13;
    L13:
        th = move-exception;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AiProactiveVoiceEntry", "query assistant session state failed " + th.getMessage(), false, 4, null);
        return null;
    L7:
        r0 = new AiProactiveAssistantLauncher$queryAssistantSessionState$1(this, r12);
        goto L8
    }

    public static final /* synthetic */ Object b(a r2, Continuation r3) {
        return r2.b((Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    private final Object b(Continuation<? super Integer> r11) {
        Continuation r12 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r11, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r12, AiProactiveAssistantLauncher$queryAssistantTtsState$1.class) == false) goto L7;
        AiProactiveAssistantLauncher$queryAssistantTtsState$1 r0 = (AiProactiveAssistantLauncher$queryAssistantTtsState$1) ZeusTransformUtils.preCheckCast(r12, AiProactiveAssistantLauncher$queryAssistantTtsState$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r10 = r0.result;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L17;
        if (r2 != 1) goto L16;
        ResultKt.throwOnFailure(r10);     // Catch: Throwable -> L13
    L21:
        return (Integer) ZeusTransformUtils.preCheckCast(r10, Integer.class, "com.obric.memorydata.plugin");
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        ResultKt.throwOnFailure(r10);
        Function2 r14 = (Function2) ZeusTransformUtils.preCheckCast(new AiProactiveAssistantLauncher$queryAssistantTtsState$2(null), Function2.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L13
        r0.label = 1;     // Catch: Throwable -> L13
        r10 = da.b(500, r14, r0);     // Catch: Throwable -> L13
        if (r10 != r13) goto L21;
        return r13;
    L13:
        th = move-exception;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AiProactiveVoiceEntry", "query assistant tts state failed " + th.getMessage(), false, 4, null);
        return null;
    L7:
        r0 = new AiProactiveAssistantLauncher$queryAssistantTtsState$1(this, r12);
        goto L8
    }

    public final ActiveAgentEvent a(String r12, String r13) {
        Intrinsics.checkNotNullParameter(r12, ChatMessage.TYPE_QUERY);
        Intrinsics.checkNotNullParameter(r13, "eventId");
        return new ActiveAgentEvent(r13, null, r12, false, false, "half", "manual_normal", "app_query", 2, null);
    }

    public final ActiveAgentEvent a(String r12, Map<String, ? extends Object> r13) {
        Map<String, ? extends Object> r11 = (Map) ZeusTransformUtils.wrapperContextForParams(r13, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r12, "eventId");
        ActiveAgentEvent r14 = new ActiveAgentEvent(r12, null, null, true, false, "half", "manual_normal", "app_query", 2, null);
        if (f6389a.a(r11) == false) goto L8;
        if (r11 == null) goto L8;
        Object r15 = r11.get("o_ext_context");
        if (r15 == null) goto L8;
        Intrinsics.areEqual(r15, "{}");
    L8:
        return r14;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v4 */
    public final Object a(long r24, Continuation<? super Boolean> r26) {
        a r0 = this;
        Continuation r1 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r26, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r1, AiProactiveAssistantLauncher$tryOpenVoiceEntry$1.class) == false) goto L7;
        AiProactiveAssistantLauncher$tryOpenVoiceEntry$1 r2 = (AiProactiveAssistantLauncher$tryOpenVoiceEntry$1) ZeusTransformUtils.preCheckCast(r1, AiProactiveAssistantLauncher$tryOpenVoiceEntry$1.class, "com.obric.memorydata.plugin");
        if ((r2.label & Integer.MIN_VALUE) == 0) goto L7;
        r2.label -= Integer.MIN_VALUE;
    L8:
        AiProactiveAssistantLauncher$tryOpenVoiceEntry$1 r11 = r2;
        Object r3 = r11.result;
        Object r12 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r11.label;
        boolean r8 = true;
        Boolean r13 = null;
        boolean r7 = false;
        boolean r9 = false;
        boolean r10 = false;
        boolean r14 = false;
        if (r4 == 0) goto L24;
        if (r4 == 1) goto L23;
        if (r4 == 2) goto L18;
        if (r4 != 3) goto L17;
        C0283a r5 = (C0283a) ZeusTransformUtils.preCheckCast(r11.L$0, C0283a.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r3);     // Catch: Throwable -> L21
        r8 = true;
    L49:
        Object r6 = Result.m1421constructorimpl(Boxing.boxBoolean(Intrinsics.areEqual(r5.a(), Boxing.boxBoolean(r8))));     // Catch: Throwable -> L21
    L52:
        Throwable r15 = Result.m1424exceptionOrNullimpl(r6);
        if (r15 == null) goto L55;
        RunLog.INSTANCE.warn("AiProactiveVoiceEntry", "tryOpenVoiceEntry failed", r15);
    L55:
        Boolean r16 = Boxing.boxBoolean(false);
        if (Result.m1427isFailureimpl(r6) == false) goto L58;
        r6 = r16;
    L58:
        Boolean r17 = Boxing.boxBoolean(((Boolean) ZeusTransformUtils.preCheckCast(r6, Boolean.class, "com.obric.memorydata.plugin")).booleanValue());
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AiProactiveVoiceEntry", "tryOpenVoiceEntry accepted=" + r17.booleanValue(), false, 4, null);
        return r17;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        a r18 = (a) ZeusTransformUtils.preCheckCast(r11.L$1, a.class, "com.obric.memorydata.plugin");
        ActiveAgentEvent r19 = (ActiveAgentEvent) ZeusTransformUtils.preCheckCast(r11.L$0, ActiveAgentEvent.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r3);     // Catch: Throwable -> L21
        a r20 = r18;
        ActiveAgentEvent r21 = r19;
        r13 = r9 ? 1 : 0;
        r8 = true;
    L32:
        r5 = (C0283a) ZeusTransformUtils.preCheckCast(r3, C0283a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L21
        if (r5 != null) goto L35;
        r5 = new C0283a(r13, r8);     // Catch: Throwable -> L21
    L35:
        IRunLog r110 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L21
        StringBuilder r22 = new StringBuilder().append("tryOpenVoiceEntry rawResult=").append(r5.a()).append(" timedOut=").append(r5.b()).append(" eventId=").append(r21.getId()).append(" queryEmpty=");     // Catch: Throwable -> L21
        CharSequence r23 = (CharSequence) ZeusTransformUtils.preCheckCast(r21.getQuery(), CharSequence.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L21
        if (r23 != null) goto L38;
    L41:
        boolean r25 = r8;
    L42:
        StringBuilder r27 = r22.append(r25).append(" instructionType=manual_normal instructionEntry=app_query extraKeys=");     // Catch: Throwable -> L21
        ConcurrentHashMap<String, Object> r28 = r21.getExtra();     // Catch: Throwable -> L21
        if (r28 == null) goto L45;
        Object r29 = r28.keySet();     // Catch: Throwable -> L21
    L46:
        IRunLog.a.a(r110, "AiProactiveVoiceEntry", r27.append(r29).toString(), false, 4, null);     // Catch: Throwable -> L21
        Boolean r30 = r5.a();     // Catch: Throwable -> L21
        Boolean r31 = Boxing.boxBoolean(r5.b());     // Catch: Throwable -> L21
        r11.L$0 = r5;     // Catch: Throwable -> L21
        r11.L$1 = r13;     // Catch: Throwable -> L21
        r11.label = 3;     // Catch: Throwable -> L21
        if (r20.a("after_tryActiveAgent", r21, r30, r31, r11) != r12) goto L49;
        return r12;
    L45:
        r29 = r13;
        goto L46
    L38:
        if (StringsKt.isBlank(r23) == true) goto L41;
        r25 = false;
        goto L42
    L23:
        long r32 = r11.J$0;
        ActiveAgentEvent r33 = (ActiveAgentEvent) ZeusTransformUtils.preCheckCast(r11.L$1, ActiveAgentEvent.class, "com.obric.memorydata.plugin");
        a r34 = (a) ZeusTransformUtils.preCheckCast(r11.L$0, a.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r3);
        ActiveAgentEvent r35 = r33;
        r0 = r34;
    L28:
        Result.Companion r36 = Result.Companion;     // Catch: Throwable -> L21
        a r37 = (a) ZeusTransformUtils.preCheckCast(r0, a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L21
        Function2 r38 = (Function2) ZeusTransformUtils.preCheckCast(new AiProactiveAssistantLauncher$tryOpenVoiceEntry$result$1$timedResult$1(r35, r7 ? 1 : 0), Function2.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L21
        r11.L$0 = r35;     // Catch: Throwable -> L21
        r11.L$1 = r37;     // Catch: Throwable -> L21
        r11.label = 2;     // Catch: Throwable -> L21
        Object r39 = da.b(r32, r38, r11);     // Catch: Throwable -> L21
        if (r39 != r12) goto L31;
        return r12;
    L31:
        r20 = r37;
        r21 = r35;
        r3 = r39;
        goto L32
    L24:
        ResultKt.throwOnFailure(r3);
        ActiveAgentEvent r40 = a(r0, r13, r14 ? 1 : 0, 3, r10 ? 1 : 0);
        r11.L$0 = r0;
        r11.L$1 = r40;
        r11.J$0 = r24;
        r11.label = 1;
        if (a(this, "before_tryActiveAgent", r40, null, null, r11, 12, null) != r12) goto L27;
        return r12;
    L27:
        r32 = r24;
        r35 = r40;
    L21:
        th = move-exception;
        Result.Companion r41 = Result.Companion;
        r6 = Result.m1421constructorimpl(ResultKt.createFailure(th));
    L7:
        r2 = new AiProactiveAssistantLauncher$tryOpenVoiceEntry$1(r0, r1);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v5 */
    public final Object a(String r25, long r26, Continuation<? super Boolean> r28) {
        a r0 = this;
        Continuation r1 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r28, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r1, AiProactiveAssistantLauncher$tryOpenQueryEntry$1.class) == false) goto L7;
        AiProactiveAssistantLauncher$tryOpenQueryEntry$1 r2 = (AiProactiveAssistantLauncher$tryOpenQueryEntry$1) ZeusTransformUtils.preCheckCast(r1, AiProactiveAssistantLauncher$tryOpenQueryEntry$1.class, "com.obric.memorydata.plugin");
        if ((r2.label & Integer.MIN_VALUE) == 0) goto L7;
        r2.label -= Integer.MIN_VALUE;
    L8:
        AiProactiveAssistantLauncher$tryOpenQueryEntry$1 r11 = r2;
        Object r3 = r11.result;
        Object r12 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r11.label;
        boolean r8 = true;
        Boolean r13 = null;
        if (r4 == 0) goto L24;
        if (r4 == 1) goto L23;
        if (r4 == 2) goto L18;
        if (r4 != 3) goto L17;
        C0283a r5 = (C0283a) ZeusTransformUtils.preCheckCast(r11.L$0, C0283a.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r3);     // Catch: Throwable -> L21
        r8 = true;
    L47:
        Object r6 = Result.m1421constructorimpl(Boxing.boxBoolean(Intrinsics.areEqual(r5.a(), Boxing.boxBoolean(r8))));     // Catch: Throwable -> L21
    L50:
        Throwable r7 = Result.m1424exceptionOrNullimpl(r6);
        if (r7 == null) goto L53;
        RunLog.INSTANCE.warn("AiProactiveVoiceEntry", "tryOpenQueryEntry failed", r7);
    L53:
        Boolean r9 = Boxing.boxBoolean(false);
        if (Result.m1427isFailureimpl(r6) == false) goto L56;
        r6 = r9;
    L56:
        Boolean r10 = Boxing.boxBoolean(((Boolean) ZeusTransformUtils.preCheckCast(r6, Boolean.class, "com.obric.memorydata.plugin")).booleanValue());
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AiProactiveVoiceEntry", "tryOpenQueryEntry accepted=" + r10.booleanValue(), false, 4, null);
        return r10;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        a r14 = (a) ZeusTransformUtils.preCheckCast(r11.L$2, a.class, "com.obric.memorydata.plugin");
        ActiveAgentEvent r15 = (ActiveAgentEvent) ZeusTransformUtils.preCheckCast(r11.L$1, ActiveAgentEvent.class, "com.obric.memorydata.plugin");
        String r16 = (String) ZeusTransformUtils.preCheckCast(r11.L$0, String.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r3);     // Catch: Throwable -> L21
        ActiveAgentEvent r17 = r15;
        r13 = r13;
        r8 = true;
    L36:
        C0283a r18 = (C0283a) ZeusTransformUtils.preCheckCast(r3, C0283a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L21
        if (r18 != null) goto L39;
        r18 = new C0283a(r13, r8);     // Catch: Throwable -> L21
    L39:
        IRunLog r19 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L21
        StringBuilder r20 = new StringBuilder().append("tryOpenQueryEntry rawResult=").append(r18.a()).append(" timedOut=").append(r18.b()).append(" eventId=").append(r17.getId()).append(" queryLen=").append(r16.length()).append(" instructionType=manual_normal instructionEntry=app_query extraKeys=");     // Catch: Throwable -> L21
        ConcurrentHashMap<String, Object> r21 = r17.getExtra();     // Catch: Throwable -> L21
        if (r21 == null) goto L42;
        Object r22 = r21.keySet();     // Catch: Throwable -> L21
    L43:
        IRunLog.a.a(r19, "AiProactiveVoiceEntry", r20.append(r22).toString(), false, 4, null);     // Catch: Throwable -> L21
        Boolean r23 = r18.a();     // Catch: Throwable -> L21
        Boolean r24 = Boxing.boxBoolean(r18.b());     // Catch: Throwable -> L21
        r11.L$0 = r18;     // Catch: Throwable -> L21
        r11.L$1 = r13;     // Catch: Throwable -> L21
        r11.L$2 = r13;     // Catch: Throwable -> L21
        r11.label = 3;     // Catch: Throwable -> L21
        if (r14.a("after_tryActiveAgent_query", r17, r23, r24, r11) != r12) goto L46;
        return r12;
    L46:
        r5 = r18;
        goto L47
    L42:
        r22 = r13;
        goto L43
    L23:
        long r27 = r11.J$0;
        ActiveAgentEvent r29 = (ActiveAgentEvent) ZeusTransformUtils.preCheckCast(r11.L$2, ActiveAgentEvent.class, "com.obric.memorydata.plugin");
        String r30 = (String) ZeusTransformUtils.preCheckCast(r11.L$1, String.class, "com.obric.memorydata.plugin");
        a r31 = (a) ZeusTransformUtils.preCheckCast(r11.L$0, a.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r3);
        ActiveAgentEvent r32 = r29;
        r0 = r31;
    L32:
        Result.Companion r33 = Result.Companion;     // Catch: Throwable -> L21
        r14 = (a) ZeusTransformUtils.preCheckCast(r0, a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L21
        Function2 r34 = (Function2) ZeusTransformUtils.preCheckCast(new AiProactiveAssistantLauncher$tryOpenQueryEntry$result$1$timedResult$1(r32, r13), Function2.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L21
        r11.L$0 = r30;     // Catch: Throwable -> L21
        r11.L$1 = r32;     // Catch: Throwable -> L21
        r11.L$2 = r14;     // Catch: Throwable -> L21
        r11.label = 2;     // Catch: Throwable -> L21
        Object r35 = da.b(r27, r34, r11);     // Catch: Throwable -> L21
        if (r35 != r12) goto L35;
        return r12;
    L35:
        r17 = r32;
        r3 = r35;
        r16 = r30;
        goto L36
    L24:
        ResultKt.throwOnFailure(r3);
        String r36 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r25, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r36, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L28;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AiProactiveVoiceEntry", "tryOpenQueryEntry ignored blank query", null, 4, null);
        return Boxing.boxBoolean(false);
    L28:
        ActiveAgentEvent r37 = a(r0, r36, r13, 2, r13);
        r11.L$0 = r0;
        r11.L$1 = r36;
        r11.L$2 = r37;
        r11.J$0 = r26;
        r11.label = 1;
        if (a(this, "before_tryActiveAgent_query", r37, null, null, r11, 12, null) != r12) goto L31;
        return r12;
    L31:
        r27 = r26;
        r30 = r36;
        r32 = r37;
    L21:
        th = move-exception;
        Result.Companion r38 = Result.Companion;
        r6 = Result.m1421constructorimpl(ResultKt.createFailure(th));
    L7:
        r2 = new AiProactiveAssistantLauncher$tryOpenQueryEntry$1(r0, r1);
        goto L8
    }

    public final boolean a(Application r5) {
        Application r6 = (Application) ZeusTransformUtils.wrapperContextForParams(r5, Application.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "application");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        a r4 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L5
        EventsTaskSdk.init(new EventsTaskSdk.InitConfig(r6));     // Catch: Throwable -> L5
        f6390b = true;     // Catch: Throwable -> L5
        Object r7 = Result.m1421constructorimpl(true);     // Catch: Throwable -> L5
    L7:
        Throwable r8 = Result.m1424exceptionOrNullimpl(r7);
        if (r8 == null) goto L11;
        RunLog.INSTANCE.warn("AiProactiveVoiceEntry", "initSdk failed", r8);
    L11:
        if (Result.m1427isFailureimpl(r7) == false) goto L14;
        r7 = false;
    L14:
        return ((Boolean) ZeusTransformUtils.preCheckCast(r7, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    L5:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r7 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public final boolean a(Map<String, ? extends Object> r2) {
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin");
        return false;
    }

    public final boolean b(Application r3) {
        Application r4 = (Application) ZeusTransformUtils.wrapperContextForParams(r3, Application.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "application");
        if (f6390b == false) goto L7;
        return true;
    L7:
        return a(r4);
    }
}
