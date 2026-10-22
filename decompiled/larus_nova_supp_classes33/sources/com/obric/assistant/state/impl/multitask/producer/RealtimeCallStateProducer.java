package com.obric.assistant.state.impl.multitask.producer;

import aha.a0;
import aha.u;
import aha.x;
import aha.y;
import aha.z;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.state.api.multitask.IObricRealtimeCallStateProducerService;
import com.obric.assistant.state.multitask.ext.TaskFlowDslKt;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import jha.f;
import jha.g;
import jha.j;
import jha.j$a;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0018\n\u0002\u0010\"\n\u0002\b\u0004\b\u0007\u0018\u0000 02\u00020\u00012\u00020\u0002:\u0003012B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\tH\u0016J\u0018\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\tH\u0016J\u0018\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\tH\u0016J(\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u0011H\u0016J \u0010\u001f\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u0011H\u0016J\u0018\u0010!\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\tH\u0016J\u001e\u0010\"\u001a\u00020\u00162\u0006\u0010#\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\tH\u0082@¢\u0006\u0002\u0010$J\u001a\u0010%\u001a\u0004\u0018\u00010\n2\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\tH\u0002J \u0010&\u001a\u0004\u0018\u00010\n2\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\tH\u0082@¢\u0006\u0002\u0010'J \u0010(\u001a\u00020\u00162\u0006\u0010#\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u0011H\u0002J\u0018\u0010)\u001a\u00020\u00162\u0006\u0010#\u001a\u00020\n2\u0006\u0010*\u001a\u00020\u0011H\u0002J \u0010+\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u0011H\u0002J\u0010\u0010,\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\tH\u0002J\u0010\u0010-\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\tH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00110\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\t0\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00110/X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/obric/assistant/state/impl/multitask/producer/RealtimeCallStateProducer;", "Lcom/obric/assistant/state/multitask/core/TaskFlowStateProducer;", "Lcom/obric/assistant/state/api/multitask/IObricRealtimeCallStateProducerService;", "<init>", "()V", "scope", "Lkotlinx/coroutines/CoroutineScope;", "activeCallsByConversationId", "", "", "Lcom/obric/assistant/state/impl/multitask/producer/RealtimeCallStateProducer$ActiveRealtimeCall;", "conversationIdByCallId", "pendingCallIdByConversationId", "pendingMajorStatesByCallId", "Ljava/util/ArrayDeque;", "Lcom/obric/assistant/state/impl/multitask/producer/RealtimeCallStateProducer$PendingMajorState;", "pendingMuteStateByCallId", "", "closedCallIds", "", "closedCallIdOrder", "onCallEntered", "", "botId", "conversationId", "onCallExited", "onPluginStarted", "callId", "onMajorStateChanged", "prevState", "currentState", "onMuteStateChanged", "state", "onPluginStopped", "bindCall", "activeCall", "(Lcom/obric/assistant/state/impl/multitask/producer/RealtimeCallStateProducer$ActiveRealtimeCall;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "findActiveCall", "findOrBindActiveCall", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "applyMajorState", "endTasks", "finalState", "bufferMajorState", "clearCallId", "markCallClosed", "projectedCallStates", "", "Companion", "PendingMajorState", "ActiveRealtimeCall", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RealtimeCallStateProducer implements j, IObricRealtimeCallStateProducerService {
    public static final /* synthetic */ int j = 0;
    public final CoroutineScope a;
    public final Map<String, a> b;
    public final Map<String, String> c;
    public final Map<String, String> d;
    public final Map<String, ArrayDeque<c>> e;
    public final Map<String, Integer> f;
    public final Set<String> g;
    public final ArrayDeque<String> h;
    public final Set<Integer> i;

    public static final class a {
        public final String a;
        public final String b;
        public final String c;
        public final u d;
        public String e;
        public jha.l<a0> f;
        public jha.l<y> g;
        public c h;

        public a() {
            throw null;
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.h, r6.h) == true) goto L32;
            return false;
        L32:
            return true;
        }

        public final int hashCode() {
            int r0 = ((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31;
            String r1 = this.e;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            jha.l<a0> r5 = this.f;
            if (r5 != null) goto L9;
            int r6 = 0;
        L10:
            int r7 = (r4 + r6) * 31;
            jha.l<y> r8 = this.g;
            if (r8 != null) goto L13;
            int r9 = 0;
        L14:
            int r10 = (r7 + r9) * 31;
            c r11 = this.h;
            if (r11 == null) goto L19;
            r2 = r11.hashCode();
        L19:
            return r10 + r2;
        L13:
            r9 = r8.hashCode();
            goto L14
        L9:
            r6 = r5.hashCode();
            goto L10
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public final String toString() {
            return "ActiveRealtimeCall(botId=" + this.a + ", conversationId=" + this.b + ", modeSessionId=" + this.c + ", metadata=" + this.d + ", callId=" + this.e + ", callHandle=" + this.f + ", muteHandle=" + this.g + ", lastTransition=" + this.h + ')';
        }

        public a(String r2, String r3, String r4, u r5) {
            Intrinsics.checkNotNullParameter(r2, "botId");
            Intrinsics.checkNotNullParameter(r3, "conversationId");
            Intrinsics.checkNotNullParameter(r4, "modeSessionId");
            Intrinsics.checkNotNullParameter(r5, "metadata");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = null;
            this.f = null;
            this.g = null;
            this.h = null;
        }
    }

    public static final class b {
    }

    public static final class c {
        public final int a;
        public final int b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof c) == true) goto L8;
            return false;
        L8:
            c r6 = (c) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a * 31) + this.b;
        }

        public final String toString() {
            return "PendingMajorState(prevState=" + this.a + ", currentState=" + this.b + ')';
        }

        public c(int r1, int r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    static {
    }

    public RealtimeCallStateProducer() {
        ExecutorCoroutineDispatcher r0 = f.a;
        this.a = f.b;
        this.b = new LinkedHashMap();
        this.c = new LinkedHashMap();
        this.d = new LinkedHashMap();
        this.e = new LinkedHashMap();
        this.f = new LinkedHashMap();
        this.g = new LinkedHashSet();
        this.h = new ArrayDeque();
        this.i = SetsKt.setOf(new Integer[]{-1, 0, 1, 2, 9, 3, 4, 5, 6});
    }

    public static void k(a r5) {
        String r0 = r5.e;
        if (r0 != null) goto L5;
        return;
    L5:
        jha.l<a0> r1 = r5.f;
        if (r1 == null) goto L8;
        TaskFlowDslKt.c(r1, new a0.c(r0, r5.b, r5.d));
    L8:
        jha.l<y> r2 = r5.g;
        if (r2 == null) goto L11;
        TaskFlowDslKt.c(r2, new y.c(r0, r5.b, r5.d));
    L11:
        r5.f = null;
        r5.g = null;
        r5.h = null;
    }

    @Override // com.obric.assistant.state.api.multitask.IObricRealtimeCallStateProducerService
    public final void c(String r7, String r8) {
        Intrinsics.checkNotNullParameter(r7, "botId");
        Intrinsics.checkNotNullParameter(r8, "conversationId");
        BuildersKt.launch$default(this.a, null, null, new RealtimeCallStateProducer$onCallExited$1(this, r8, null), 3, null);
    }

    @Override // com.obric.assistant.state.api.multitask.IObricRealtimeCallStateProducerService
    public final void d(String r8, String r9) {
        Intrinsics.checkNotNullParameter(r8, "botId");
        Intrinsics.checkNotNullParameter(r9, "conversationId");
        if (StringsKt.isBlank(r8) == false) goto L5;
    L9:
        FLogger.a.w("RealtimeCallStateProducer", "ignore call enter with empty identity");
        return;
    L5:
        if (StringsKt.isBlank(r9) == true) goto L9;
        BuildersKt.launch$default(this.a, null, null, new RealtimeCallStateProducer$onCallEntered$1(this, r9, r8, null), 3, null);
    }

    @Override // com.obric.assistant.state.api.multitask.IObricRealtimeCallStateProducerService
    public final void e(String r8, String r9) {
        Intrinsics.checkNotNullParameter(r8, "callId");
        Intrinsics.checkNotNullParameter(r9, "conversationId");
        BuildersKt.launch$default(this.a, null, null, new RealtimeCallStateProducer$onPluginStopped$1(this, r9, r8, null), 3, null);
    }

    @Override // com.obric.assistant.state.api.multitask.IObricRealtimeCallStateProducerService
    public final void g(String r8, String r9) {
        Intrinsics.checkNotNullParameter(r8, "callId");
        Intrinsics.checkNotNullParameter(r9, "conversationId");
        if (StringsKt.isBlank(r8) == false) goto L5;
    L9:
        FLogger.a.w("RealtimeCallStateProducer", "ignore plugin start with empty identity");
        return;
    L5:
        if (StringsKt.isBlank(r9) == true) goto L9;
        BuildersKt.launch$default(this.a, null, null, new RealtimeCallStateProducer$onPluginStarted$1(this, r8, r9, null), 3, null);
    }

    public final a l(String r3, String r4) {
        String r0 = (String) ((LinkedHashMap) this.c).get(r3);
        if (r0 != null) goto L6;
        return null;
    L6:
        if (Intrinsics.areEqual(r0, r4) == true) goto L8;
        return null;
    L8:
        a r5 = (a) ((LinkedHashMap) this.b).get(r4);
        if (r5 != null) goto L11;
        return null;
    L11:
        if (Intrinsics.areEqual(r5.e, r3) == true) goto L13;
        return null;
    L13:
        return r5;
    }

    @Override // com.obric.assistant.state.api.multitask.IObricRealtimeCallStateProducerService
    public final void a(String r11, String r12, int r13) {
        Intrinsics.checkNotNullParameter(r11, "callId");
        Intrinsics.checkNotNullParameter(r12, "conversationId");
        if (StringsKt.isBlank(r11) == false) goto L5;
        return;
    L5:
        if (StringsKt.isBlank(r12) == true) goto L10;
        BuildersKt.launch$default(this.a, null, null, new RealtimeCallStateProducer$onMuteStateChanged$1(this, r11, r12, r13, null), 3, null);
        return;
    }

    public final void i(a r9, int r10, int r11) {
        c r0 = new c(r10, r11);
        boolean r1 = Intrinsics.areEqual(r9.h, r0);
        r9.h = r0;
        if (r1 == false) goto L5;
    L9:
        boolean r12 = false;
    L11:
        if (this.i.contains(Integer.valueOf(r11)) == true) goto L13;
        return;
    L13:
        String r2 = r9.e;
        if (r2 != null) goto L16;
        return;
    L16:
        if (r12 == false) goto L21;
        jha.l<a0> r13 = r9.f;
        if (r13 == null) goto L25;
        TaskFlowDslKt.f(r13, new a0.a(r2, r9.b, r11, MapsKt.mapOf(TuplesKt.to("round_completed", Boolean.TRUE)), r9.d, 8));
        return;
    L25:
        return;
    L21:
        jha.l<a0> r14 = r9.f;
        if (r14 == null) goto L26;
        TaskFlowDslKt.f(r14, new a0.a(r2, r9.b, r11, null, r9.d, 24));
        return;
    L26:
        return;
    L5:
        if (r10 != 5) goto L9;
        if (r11 != 3) goto L9;
        r12 = true;
        goto L11
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object j(a r10, String r11, Continuation<? super Unit> r12) {
        if ((r12 instanceof RealtimeCallStateProducer$bindCall$1) == false) goto L7;
        RealtimeCallStateProducer$bindCall$1 r0 = (RealtimeCallStateProducer$bindCall$1) r12;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r13 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        jha.l r4 = null;
        r4 = null;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        a r14 = (a) r0.L$2;
        r11 = (String) r0.L$1;
        a r5 = (a) r0.L$0;
        ResultKt.throwOnFailure(r13);
    L40:
        jha.m r15 = (jha.m) r13;
        if (r15 != null) goto L43;
    L48:
        r14.g = r4;
        ArrayDeque<c> r16 = this.e.remove(r11);
        if (r16 == null) goto L54;
        Iterator<T> r17 = r16.iterator();
    L52:
        if (r17.hasNext() == false) goto L54;
        c r18 = (c) r17.next();
        i(r5, r18.a, r18.b);
    L54:
        Integer r19 = this.f.remove(r11);
        if (r19 == null) goto L60;
        int r110 = r19.intValue();
        jha.l<y> r111 = r5.g;
        if (r111 == null) goto L60;
        TaskFlowDslKt.f(r111, new y.a(r11, r5.b, r110, r5.d));
    L60:
        return Unit.INSTANCE;
    L43:
        if (r15.b == true) goto L46;
        r15 = null;
    L46:
        if (r15 == null) goto L48;
        r4 = r15.a;
        goto L48
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r10 = (a) r0.L$2;
        r11 = (String) r0.L$1;
        a r6 = (a) r0.L$0;
        ResultKt.throwOnFailure(r13);
    L27:
        jha.m r112 = (jha.m) r13;
        if (r112 != null) goto L30;
    L35:
        jha.l<a0> r113 = 0;
    L36:
        r10.f = r113;
        Intrinsics.checkNotNullParameter(r11, "callId");
        g r114 = TaskFlowDslKt.b(x.a, r11);
        y.b r115 = new y.b(r11, r6.b, r6.d);
        jha.c r7 = j$a.a(this);
        r0.L$0 = r6;
        r0.L$1 = r11;
        r0.L$2 = r6;
        r0.label = 2;
        r13 = TaskFlowDslKt.e(r114, r115, r7, r0);
        if (r13 != r2) goto L39;
        return r2;
    L39:
        r14 = r6;
        r5 = r14;
        goto L40
    L30:
        if (r112.b == true) goto L33;
        r112 = null;
    L33:
        if (r112 == null) goto L35;
        r113 = r112.a;
        goto L36
    L16:
        ResultKt.throwOnFailure(r13);
        if (Intrinsics.areEqual(r10.e, r11) == true) goto L19;
        String r116 = r10.e;
        if (r116 == null) goto L23;
        k(r10);
        this.c.remove(r116);
        this.e.remove(r116);
        this.f.remove(r116);
    L23:
        r10.e = r11;
        this.c.put(r11, r10.b);
        Intrinsics.checkNotNullParameter(r11, "callId");
        g r117 = TaskFlowDslKt.b(z.a, r11);
        a0.b r8 = new a0.b(r11, r10.b, r10.d);
        jha.c r9 = j$a.a(this);
        r0.L$0 = r10;
        r0.L$1 = r11;
        r0.L$2 = r10;
        r0.label = 1;
        r13 = TaskFlowDslKt.e(r117, r8, r9, r0);
        if (r13 != r2) goto L26;
        return r2;
    L26:
        r6 = r10;
        goto L27
    L19:
        return Unit.INSTANCE;
    L7:
        r0 = new RealtimeCallStateProducer$bindCall$1(this, r12);
        goto L8
    }

    public static final Object h(RealtimeCallStateProducer r4, String r5, String r6, Continuation r7) {
        r4.getClass();
        if ((r7 instanceof RealtimeCallStateProducer$findOrBindActiveCall$1) == false) goto L7;
        RealtimeCallStateProducer$findOrBindActiveCall$1 r0 = (RealtimeCallStateProducer$findOrBindActiveCall$1) r7;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        a r9 = (a) r0.L$0;
        ResultKt.throwOnFailure(r8);
        return r9;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r8);
        a r10 = r4.l(r5, r6);
        if (r10 != null) goto L33;
        a r11 = (a) ((LinkedHashMap) r4.b).get(r6);
        r10 = null;
        if (r11 == null) goto L33;
        if (r11.e != null) goto L22;
        boolean r12 = true;
    L23:
        if (r12 == true) goto L26;
        r11 = null;
    L26:
        if (r11 == null) goto L33;
        r0.L$0 = r11;
        r0.label = 1;
        if (r4.j(r11, r5, r0) != r2) goto L31;
        return r2;
    L31:
        return r11;
    L22:
        r12 = false;
    L33:
        return r10;
    L7:
        r0 = new RealtimeCallStateProducer$findOrBindActiveCall$1(r4, r7);
        goto L8
    }

    @Override // com.obric.assistant.state.api.multitask.IObricRealtimeCallStateProducerService
    public final void b(String r12, String r13, int r14, int r15) {
        Intrinsics.checkNotNullParameter(r12, "callId");
        Intrinsics.checkNotNullParameter(r13, "conversationId");
        if (StringsKt.isBlank(r12) == false) goto L5;
        return;
    L5:
        if (StringsKt.isBlank(r13) == true) goto L10;
        BuildersKt.launch$default(this.a, null, null, new RealtimeCallStateProducer$onMajorStateChanged$1(this, r12, r13, r14, r15, null), 3, null);
        return;
    }
}
