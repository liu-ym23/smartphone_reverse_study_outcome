package com.obric.assistant.state.impl.multitask.producer;

import aha.a0;
import aha.d;
import aha.e0;
import aha.h0;
import aha.l;
import aha.t;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.state.api.multitask.IObricInteractionModeService;
import com.obric.assistant.state.api.multitask.ObricInteractionProjectionDelegate;
import com.obric.assistant.state.api.multitask.state.ModeEndReason;
import com.obric.assistant.state.api.multitask.state.ModeRefreshSource;
import com.obric.assistant.state.api.multitask.state.ObricInteractionType;
import com.obric.assistant.state.multitask.TaskFlowManager;
import com.obric.assistant.state.multitask.core.TaskFlowDispatchStrategy;
import com.obric.assistant.state.multitask.ext.TaskFlowDslKt;
import com.obric.assistant.t1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import jha.g;
import jha.m;
import jha.o;
import jha.q;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.a1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 72\u00020\u0001:\u000278B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JG\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0014\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0019H\u0016¢\u0006\u0002\u0010\u001bJ \u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0017H\u0082@¢\u0006\u0002\u0010!J=\u0010\"\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020\b2\u0006\u0010$\u001a\u00020%2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0014\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0019H\u0016¢\u0006\u0002\u0010&J=\u0010'\u001a\u00020\u001d2\u0006\u0010(\u001a\u00020\r2\u0006\u0010$\u001a\u00020%2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0014\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0019H\u0002¢\u0006\u0002\u0010)J.\u0010*\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020\b2\u0006\u0010+\u001a\u00020,2\u0014\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0019H\u0016J\u0012\u0010-\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0012\u001a\u00020\bH\u0016J.\u0010.\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020\b2\u0006\u0010+\u001a\u00020,2\u0014\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0019H\u0002J\u001f\u0010/\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0002¢\u0006\u0002\u00100J\u001c\u00101\u001a\u00020\u001d2\u0006\u00102\u001a\u00020\b2\n\u00103\u001a\u0006\u0012\u0002\b\u000304H\u0002J\"\u00105\u001a\u00020\n*\u00020\u001f2\u0014\u00106\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0019H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\n0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00100\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/obric/assistant/state/impl/multitask/producer/InteractionModeStateProducer;", "Lcom/obric/assistant/state/api/multitask/IObricInteractionModeService;", "<init>", "()V", "scope", "Lkotlinx/coroutines/CoroutineScope;", "latestSessionIdByBotId", "Ljava/util/concurrent/ConcurrentHashMap;", "", "modeSnapshotsByBotId", "Lcom/obric/assistant/state/api/multitask/ActiveModeSnapshot;", "activeModesBySessionId", "", "Lcom/obric/assistant/state/impl/multitask/producer/InteractionModeStateProducer$ActiveMode;", "activeSessionIdByBotId", "timeoutJobs", "Lkotlinx/coroutines/Job;", "startMode", "botId", "conversationId", "interactionType", "Lcom/obric/assistant/state/api/multitask/state/ObricInteractionType;", "timeoutMillis", "", "ext", "", "", "(Ljava/lang/String;Ljava/lang/String;Lcom/obric/assistant/state/api/multitask/state/ObricInteractionType;Ljava/lang/Long;Ljava/util/Map;)Ljava/lang/String;", "startModeInternal", "", "state", "Lcom/obric/assistant/state/api/multitask/state/ObricInteractionModeState$Start;", "effectiveTimeout", "(Lcom/obric/assistant/state/api/multitask/state/ObricInteractionModeState$Start;Ljava/lang/Long;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "refreshMode", "sessionId", "source", "Lcom/obric/assistant/state/api/multitask/state/ModeRefreshSource;", "(Ljava/lang/String;Lcom/obric/assistant/state/api/multitask/state/ModeRefreshSource;Ljava/lang/Long;Ljava/util/Map;)V", "refreshModeInternal", "activeMode", "(Lcom/obric/assistant/state/impl/multitask/producer/InteractionModeStateProducer$ActiveMode;Lcom/obric/assistant/state/api/multitask/state/ModeRefreshSource;Ljava/lang/Long;Ljava/util/Map;)V", "endMode", "reason", "Lcom/obric/assistant/state/api/multitask/state/ModeEndReason;", "getActiveMode", "endModeInternal", "scheduleTimeout", "(Ljava/lang/String;Ljava/lang/Long;)V", "handleTaskFlowEvent", "taskFlowId", "event", "Lcom/obric/assistant/state/multitask/core/TaskStateEvent;", "toSnapshot", "snapshotExt", "Companion", "ActiveMode", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InteractionModeStateProducer implements IObricInteractionModeService {
    public static final /* synthetic */ int g = 0;
    public final CoroutineScope a;
    public final ConcurrentHashMap<String, String> b;
    public final ConcurrentHashMap<String, zga.a> c;
    public final Map<String, a> d;
    public final Map<String, String> e;
    public final Map<String, Job> f;

    /* JADX INFO: renamed from: com.obric.assistant.state.impl.multitask.producer.InteractionModeStateProducer$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.state.impl.multitask.producer.InteractionModeStateProducer$1", f = "InteractionModeStateProducer.kt", i = {}, l = {60}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ InteractionModeStateProducer this$0;

        /* JADX INFO: renamed from: com.obric.assistant.state.impl.multitask.producer.InteractionModeStateProducer$1$a */
        public static final class a<T> implements FlowCollector {
            public final /* synthetic */ InteractionModeStateProducer a;

            public a(InteractionModeStateProducer r1) {
                this.a = r1;
            }

            public final Object emit(Object r17, Continuation r18) {
                Pair r0 = (Pair) r17;
                g r1 = (g) r0.component1();
                q r2 = (q) r0.component2();
                InteractionModeStateProducer r3 = this.a;
                String r4 = r1.toString();
                int r5 = InteractionModeStateProducer.g;
                r3.getClass();
                t r6 = r2.a().b;
                if ((r6 instanceof l) == true) goto L129;
                Long r7 = null;
                if ((r6 instanceof t) == false) goto L8;
                t r8 = r6;
            L9:
                if (r8 == null) goto L129;
                String r9 = r8.c();
                if (r9 == null) goto L129;
                String r10 = r8.getBotId();
                if (r10 == null) goto L129;
                a r11 = (a) ((LinkedHashMap) r3.d).get(r9);
                if (r11 == null) goto L129;
                if (Intrinsics.areEqual(r11.a.h, r10) == true) goto L23;
                r11 = null;
            L23:
                if (r11 == null) goto L129;
                if ((r6 instanceof aha.q) == false) goto L28;
                ModeRefreshSource r12 = ModeRefreshSource.MESSAGE;
            L42:
                TaskFlowManager r13 = TaskFlowManager.a;
                List r14 = TaskFlowManager.c();
                ArrayList r15 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r14, 10));
                Iterator r16 = ((ArrayList) r14).iterator();
            L44:
                if (r16.hasNext() == false) goto L46;
                r15.add(((q) ((Pair) r16.next()).component2()).a().b);
                goto L44
            L46:
                ArrayList r19 = new ArrayList();
                Iterator r20 = r15.iterator();
            L48:
                if (r20.hasNext() == false) goto L60;
                Object r21 = r20.next();
                t r110 = (o) r21;
                if ((r110 instanceof t) == false) goto L52;
                t r111 = r110;
            L53:
                if (r111 == null) goto L55;
                String r112 = r111.c();
            L57:
                if (Intrinsics.areEqual(r112, r9) == false) goto L48;
                r19.add(r21);
                goto L48
            L55:
                r112 = null;
                goto L57
            L52:
                r111 = null;
                goto L53
            L60:
                if (r19.isEmpty() == true) goto L78;
                Iterator r22 = r19.iterator();
            L64:
                if (r22.hasNext() == false) goto L78;
                aha.q.a r113 = (o) r22.next();
                if ((r113 instanceof aha.j.b) == false) goto L68;
            L75:
                boolean r114 = true;
            L76:
                if (r114 == false) goto L64;
                boolean r23 = true;
            L80:
                if (r19.isEmpty() == true) goto L95;
                Iterator r115 = r19.iterator();
            L84:
                if (r115.hasNext() == false) goto L95;
                aha.q.a r116 = (o) r115.next();
                if ((r116 instanceof aha.q.a) == false) goto L90;
                if (r116.f != 20) goto L90;
            L91:
                boolean r117 = true;
            L93:
                if (r117 == false) goto L84;
                boolean r118 = true;
            L97:
                if (r23 == false) goto L115;
                int r119 = i.a;
                boolean r120 = t1.a.r0();
                if (r19.isEmpty() == true) goto L107;
                Iterator r24 = r19.iterator();
            L103:
                if (r24.hasNext() == false) goto L107;
                if ((((o) r24.next()) instanceof aha.j.b) == false) goto L103;
                boolean r25 = true;
            L108:
                boolean r121 = Intrinsics.areEqual(r11.d.get("has_attachment"), Boolean.TRUE);
                if (r120 == false) goto L111;
                int r26 = 30;
            L116:
                Long r122 = r11.c;
                if (r122 != null) goto L126;
                if (r23 == true) goto L120;
                if (r118 == true) goto L120;
            L127:
                r3.g(r11, r12, r7, MapsKt.mapOf(new Pair[]{TuplesKt.to("task_flow_id", r4), TuplesKt.to("timeout_times", Integer.valueOf(r26)), TuplesKt.to("thinking", Boolean.valueOf(r23)), TuplesKt.to("generating", Boolean.valueOf(r118))}));
            L120:
                int r123 = i.a;
                ObricInteractionType r124 = r11.a.k;
                Intrinsics.checkNotNullParameter(r124, "interactionType");
                switch(i.a.a[r124.ordinal()]) {
                    case 1: goto L125;
                    case 2: goto L125;
                    case 3: goto L125;
                    case 4: goto L127;
                    case 5: goto L127;
                    case 6: goto L127;
                    default: goto L123;
                };
            L125:
                r7 = Long.valueOf(((long) r26) * 140000);
                goto L127
            L123:
                throw new NoWhenBranchMatchedException();
            L126:
                r7 = r122;
                goto L127
            L111:
                if (r25 == false) goto L113;
                r26 = 13;
                goto L116
            L113:
                if (r121 == false) goto L115;
                r26 = 3;
            L107:
                r25 = false;
            L115:
                r26 = 1;
            L90:
                if ((r116 instanceof e0.b) == true) goto L91;
                r117 = false;
            L95:
                r118 = false;
                goto L97
            L68:
                if ((r113 instanceof d.a) == true) goto L75;
                if ((r113 instanceof aha.q.a) == true) goto L72;
            L74:
                r114 = false;
                goto L76
            L72:
                if (SetsKt.setOf(new Integer[]{11, 24}).contains(Integer.valueOf(r113.f)) == false) goto L74;
            L78:
                r23 = false;
                goto L80
            L28:
                if ((r6 instanceof aha.j) == false) goto L31;
                r12 = ModeRefreshSource.DEEP_THINK;
                goto L42
            L31:
                if ((r6 instanceof d) == false) goto L34;
                r12 = ModeRefreshSource.COMPLEX_TASK;
                goto L42
            L34:
                if ((r6 instanceof e0) == false) goto L37;
                r12 = ModeRefreshSource.TTS;
                goto L42
            L37:
                if ((r6 instanceof h0) == false) goto L40;
                r12 = ModeRefreshSource.CLICK_TALK;
                goto L42
            L40:
                if ((r6 instanceof a0) == false) goto L129;
                r12 = ModeRefreshSource.REALTIME_CALL;
                goto L42
            L8:
                r8 = null;
            L129:
                return Unit.INSTANCE;
            }
        }

        public AnonymousClass1(InteractionModeStateProducer r1, Continuation<? super AnonymousClass1> r2) {
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

        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            a1 r6 = TaskFlowManager.h;
            a r2 = new a(this.this$0);
            this.label = 1;
            if (r6.collect(r2, this) != r0) goto L12;
            return r0;
        }
    }

    static {
    }

    public InteractionModeStateProducer() {
        CoroutineScope r0 = jha.f.b;
        this.a = r0;
        this.b = new ConcurrentHashMap();
        this.c = new ConcurrentHashMap();
        this.d = new LinkedHashMap();
        this.e = new LinkedHashMap();
        this.f = new LinkedHashMap();
        BuildersKt.launch$default(r0, null, CoroutineStart.UNDISPATCHED, new AnonymousClass1(this, null), 1, null);
        ObricInteractionProjectionDelegate.b.b(null, new c(this));
    }

    public final zga.a c(String r2) {
        Intrinsics.checkNotNullParameter(r2, "botId");
        return this.c.get(r2);
    }

    public final void h(String r9, Long r10) {
        Job r0 = this.f.remove(r9);
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        if (r10 != null) goto L7;
        return;
    L7:
        if (r10.longValue() <= 0) goto L12;
        this.f.put(r9, BuildersKt.launch$default(this.a, null, null, new scheduleTimeout.1(r10, this, r9, null), 3, null));
        return;
    }

    public final void b(String r11, ModeEndReason r12, Map<String, ? extends Object> r13) {
        Intrinsics.checkNotNullParameter(r11, "sessionId");
        Intrinsics.checkNotNullParameter(r12, "reason");
        Intrinsics.checkNotNullParameter(r13, "ext");
        BuildersKt.launch$default(this.a, null, null, new endMode.1(this, r11, r12, r13, null), 3, null);
    }

    public final void f(String r11, ModeEndReason r12, Map<String, ? extends Object> r13) {
        a r0 = this.d.remove(r11);
        if (r0 != null) goto L5;
        return;
    L5:
        Job r1 = this.f.remove(r11);
        if (r1 == null) goto L8;
        Job.DefaultImpls.cancel$default(r1, null, 1, null);
    L8:
        this.e.remove(r0.a.h, r11);
        this.b.remove(r0.a.h, r11);
        this.c.computeIfPresent(r0.a.h, new e(new d(r11)));
        jha.l r2 = r0.b;
        l.c r3 = r0.a;
        TaskFlowDslKt.c(r2, new l.b(r3.h, r3.i, r11, r3.k, r12, r13));
        FLogger.a.i("InteractionModeStateProducer", "mode ended botId=" + r0.a.h + ", mode=" + r0.a.k + ", sessionId=" + r11 + ", reason=" + r12);
    }

    public static final Object e(InteractionModeStateProducer r11, l.c r12, Long r13, Continuation r14) {
        r11.getClass();
        if ((r14 instanceof startModeInternal.1) == false) goto L7;
        startModeInternal.1 r0 = (startModeInternal.1) r14;
        int r1 = r0.label;
        if ((r1 & IntCompanionObject.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - IntCompanionObject.MIN_VALUE;
    L8:
        Object r15 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        String r16 = (String) r0.L$2;
        r13 = (Long) r0.L$1;
        l.c r4 = (l.c) r0.L$0;
        ResultKt.throwOnFailure(r15);
        String r17 = r16;
        r12 = r4;
        Object r5 = r15;
    L23:
        m r6 = (m) r5;
        if (r6 != null) goto L26;
    L32:
        FLogger.a.w("InteractionModeStateProducer", "startMode ignored, task already exists, sessionId=" + r17);
        r11.b.remove(r12.h, r17);
        ConcurrentHashMap<String, zga.a> r18 = r11.c;
        String r19 = r12.h;
        r18.remove(r19, new zga.a(r19, r12.i, r12.j, r12.k, r12.m));
        return Unit.INSTANCE;
    L26:
        if (r6.b == false) goto L32;
        r11.d.put(r17, new a(r12, r6.a, r13, r12.m));
        r11.e.put(r12.h, r17);
        FLogger.a.i("InteractionModeStateProducer", "mode started botId=" + r12.h + ", mode=" + r12.k + ", sessionId=" + r17 + ", timeoutMillis=" + r13);
        if (r13 == null) goto L35;
        r11.h(r17, r13);
    L35:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r15);
        r17 = r12.j;
        if (Intrinsics.areEqual(r11.b.get(r12.h), r17) == false) goto L34;
        String r7 = (String) ((LinkedHashMap) r11.e).get(r12.h);
        if (r7 == null) goto L20;
        r11.f(r7, ModeEndReason.REPLACED, MapsKt.emptyMap());
    L20:
        String r8 = r12.h;
        String r9 = r12.i;
        Intrinsics.checkNotNullParameter(r8, "botId");
        Intrinsics.checkNotNullParameter(r17, "sessionId");
        aha.m r10 = aha.m.a;
        int r20 = com.obric.assistant.state.multitask.ext.f.a;
        g r21 = TaskFlowDslKt.b(r10, com.obric.assistant.state.multitask.ext.g.a(new com.obric.assistant.state.multitask.ext.g(), new String[]{r8, r9, r17}));
        ExecutorCoroutineDispatcher r22 = jha.f.a;
        Intrinsics.checkNotNullParameter("InteractionModeStateProducer", "orderingDomain");
        jha.c r23 = new jha.c(TaskFlowDispatchStrategy.SHARED_SERIALIZED, "InteractionModeStateProducer");
        r0.L$0 = r12;
        r0.L$1 = r13;
        r0.L$2 = r17;
        r0.label = 1;
        r5 = TaskFlowDslKt.e(r21, r12, r23, r0);
        if (r5 != r2) goto L23;
        return r2;
    L34:
        return Unit.INSTANCE;
    L7:
        r0 = new startModeInternal.1(r11, r14);
        goto L8
    }

    public final void a(String r12, ModeRefreshSource r13, Long r14, Map<String, ? extends Object> r15) {
        Intrinsics.checkNotNullParameter(r12, "sessionId");
        Intrinsics.checkNotNullParameter(r13, "source");
        Intrinsics.checkNotNullParameter(r15, "ext");
        BuildersKt.launch$default(this.a, null, null, new refreshMode.1(this, r12, r14, r13, r15, null), 3, null);
    }

    public final void g(a r10, ModeRefreshSource r11, Long r12, Map<String, ? extends Object> r13) {
        String r0 = r10.a.j;
        if ((!r13.isEmpty()) == false) goto L5;
        Map r14 = MapsKt.plus(r10.d, r13);
        Intrinsics.checkNotNullParameter(r14, "<set-?>");
        r10.d = r14;
    L5:
        jha.l r15 = r10.b;
        l.c r1 = r10.a;
        TaskFlowDslKt.f(r15, new l.a(r1.h, r1.i, r0, r1.k, r11, r10.d));
        FLogger.a.i("InteractionModeStateProducer", "mode refreshed botId=" + r10.a.h + ", mode=" + r10.a.k + ", sessionId=" + r0 + ", source=" + r11 + ", timeoutMillis=" + r12);
        if (((LinkedHashMap) this.d).get(r0) == r10) goto L8;
        return;
    L8:
        if (Intrinsics.areEqual(this.b.get(r10.a.h), r0) == false) goto L10;
        ConcurrentHashMap<String, zga.a> r16 = this.c;
        l.c r17 = r10.a;
        String r7 = r17.h;
        r16.put(r7, new zga.a(r7, r17.i, r17.j, r17.k, r10.d));
    L10:
        h(r0, r12);
    }

    public final String d(String r21, String r22, ObricInteractionType r23, Long r24, Map<String, ? extends Object> r25) {
        Intrinsics.checkNotNullParameter(r21, "botId");
        Intrinsics.checkNotNullParameter(r23, "interactionType");
        Intrinsics.checkNotNullParameter(r25, "ext");
        String r10 = UUID.randomUUID().toString();
        Map r11 = MapsKt.toMap(r25);
        l.c r12 = new l.c(r21, r22, r10, r23, r11);
        FLogger.a.i("InteractionModeStateProducer", "startMode requested botId=" + r21 + ", mode=" + r23 + ", sessionId=" + r10 + ", timeoutMillis=" + r24);
        this.b.put(r21, r10);
        this.c.put(r21, new zga.a(r12.h, r12.i, r12.j, r12.k, r11));
        BuildersKt.launch$default(this.a, null, null, new startMode.1(this, r12, r24, null), 3, null);
        return r10;
    }
}
