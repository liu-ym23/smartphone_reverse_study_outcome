package com.obric.assistant.state.impl.multitask.producer;

import aha.e0;
import aha.f0;
import aha.u;
import com.larus.audio.controller.GlobalAudioStateEnum;
import com.larus.audio.observer.GlobalAudioObserver;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.state.multitask.core.TaskFlowAutoInitProducer;
import com.obric.assistant.state.multitask.ext.TaskFlowDslKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import jha.g;
import jha.l;
import jha.m;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000K\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u000f\b\u0007\u0018\u0000 #2\u00020\u0001:\u0002#$B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\f\u001a\u00020\rH\u0016JH\u0010\u0011\u001a\u00020\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\b2\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0018H\u0082@¢\u0006\u0002\u0010\u0019J\u0018\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\tH\u0002J\u0010\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\bH\u0002J2\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u001f2\u0006\u0010\u001b\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\bH\u0002J\u0016\u0010 \u001a\u00020\r2\u0006\u0010!\u001a\u00020\bH\u0082@¢\u0006\u0002\u0010\"R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010¨\u0006%"}, d2 = {"Lcom/obric/assistant/state/impl/multitask/producer/TtsStateProducer;", "Lcom/obric/assistant/state/multitask/core/TaskFlowAutoInitProducer;", "<init>", "()V", "scope", "Lkotlinx/coroutines/CoroutineScope;", "activeTtsTasks", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/obric/assistant/state/impl/multitask/producer/TtsStateProducer$ActiveTtsTask;", "playingRefreshJobs", "Lkotlinx/coroutines/Job;", "initProducer", "", "globalAudioCallback", "com/obric/assistant/state/impl/multitask/producer/TtsStateProducer$globalAudioCallback$1", "Lcom/obric/assistant/state/impl/multitask/producer/TtsStateProducer$globalAudioCallback$1;", "emitTtsTaskState", "audioScene", "state", "Lcom/larus/audio/controller/GlobalAudioStateEnum;", "conversationId", "messageId", "bizExtra", "", "(Ljava/lang/String;Lcom/larus/audio/controller/GlobalAudioStateEnum;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startPlayingRefresh", "taskKey", "activeTask", "stopPlayingRefresh", "findActiveTask", "Lkotlin/Pair;", "endTtsTasksByScene", "scene", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "ActiveTtsTask", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TtsStateProducer implements TaskFlowAutoInitProducer {
    public final CoroutineScope a;
    public final ConcurrentHashMap<String, a> b;
    public final ConcurrentHashMap<String, Job> c;
    public final TtsStateProducer$globalAudioCallback$1 d;

    static {
    }

    @Override // com.obric.assistant.state.multitask.core.TaskFlowAutoInitProducer
    public final void f() {
        FLogger.a.i("TtsStateProducer", "initProducer");
        GlobalAudioObserver.a.b(this.d);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        FLogger.a.e("TtsStateProducer", "failed to register GlobalAudioObserver", th);
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.obric.assistant.state.impl.multitask.producer.TtsStateProducer$globalAudioCallback$1] */
    public TtsStateProducer() {
        ExecutorCoroutineDispatcher r0 = jha.f.a;
        this.a = jha.f.b;
        this.b = new ConcurrentHashMap();
        this.c = new ConcurrentHashMap();
        this.d = new TtsStateProducer$globalAudioCallback$1(this);
    }

    public final Pair<String, a> b(String r4, String r5, String r6) {
        a r0 = this.b.get(r4);
        if (r0 != null) goto L5;
        Set<Map.Entry<String, a>> r7 = this.b.entrySet();
        ArrayList r1 = new ArrayList();
        Iterator<T> r8 = r7.iterator();
    L8:
        if (r8.hasNext() == false) goto L12;
        Object r2 = r8.next();
        if (Intrinsics.areEqual(((a) ((Map.Entry) r2).getValue()).b.d(), r5) == false) goto L8;
        r1.add(r2);
        goto L8
    L12:
        Iterator r9 = r1.iterator();
    L14:
        if (r9.hasNext() == false) goto L18;
        Object r10 = r9.next();
        if (Intrinsics.areEqual(((a) ((Map.Entry) r10).getValue()).b.f(), r6) == false) goto L14;
    L19:
        Map.Entry r11 = (Map.Entry) r10;
        if (r11 != null) goto L22;
        Iterator r12 = r1.iterator();
        boolean r13 = false;
        Object r14 = null;
    L25:
        if (r12.hasNext() == false) goto L31;
        Object r3 = r12.next();
        if ((((a) ((Map.Entry) r3).getValue()).b instanceof e0.c) == false) goto L25;
        if (r13 == true) goto L32;
        r13 = true;
        r14 = r3;
    L32:
        r14 = null;
    L33:
        Map.Entry r15 = (Map.Entry) r14;
        if (r15 != null) goto L36;
        return null;
    L36:
        return TuplesKt.to(r15.getKey(), r15.getValue());
    L31:
        if (r13 == true) goto L33;
    L22:
        return TuplesKt.to(r11.getKey(), r11.getValue());
    L18:
        r10 = null;
        goto L19
    L5:
        return TuplesKt.to(r4, r0);
    }

    public static final Object a(TtsStateProducer r18, String r19, GlobalAudioStateEnum r20, String r21, String r22, Map r23, Continuation r24) {
        r18.getClass();
        if ((r24 instanceof emitTtsTaskState.1) == false) goto L7;
        emitTtsTaskState.1 r5 = (emitTtsTaskState.1) r24;
        int r6 = r5.label;
        if ((r6 & IntCompanionObject.MIN_VALUE) == 0) goto L7;
        r5.label = r6 - IntCompanionObject.MIN_VALUE;
    L8:
        emitTtsTaskState.1 r7 = r5;
        Object r1 = r7.result;
        Object r8 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r9 = r7.label;
        a r10 = null;
        if (r9 == 0) goto L14;
        if (r9 != 1) goto L13;
        e0.b r2 = (e0.b) r7.L$1;
        String r3 = (String) r7.L$0;
        ResultKt.throwOnFailure(r1);
    L46:
        m r4 = (m) r1;
        if (r4 == null) goto L62;
        r18.b.put(r3, new a(r4.a, r2));
        if (r4.b == true) goto L52;
        TaskFlowDslKt.f(r4.a, r2);
    L52:
        String r13 = r3;
    L53:
        a r11 = r18.b.get(r13);
        if (r11 == null) goto L63;
        Job r12 = r18.c.remove(r13);
        if (r12 == null) goto L59;
        Job.DefaultImpls.cancel$default(r12, null, 1, null);
    L59:
        r18.c.put(r13, BuildersKt.launch$default(r18.a, null, null, new startPlayingRefresh.1(r18, r13, r11, null), 3, null));
    L61:
        return Unit.INSTANCE;
    L63:
        return Unit.INSTANCE;
    L62:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r1);
        g r14 = f0.a(r21, r22, r19);
        int r15 = m.a;
        u r16 = m.d(r21, (String) r23.get("bot_id"), null, 12);
        int r17 = c.a[r20.ordinal()];
        if (r17 != 1) goto L17;
        Pair<String, a> r110 = r18.b(r14.a, r19, r22);
        if (r110 == null) goto L35;
        String r25 = (String) r110.getFirst();
        if (r25 == null) goto L35;
    L36:
        r13 = r25;
        e0.b r111 = new e0.b(r19, r21, r22, r23, r16);
        if (r110 == null) goto L39;
        a r26 = (a) r110.getSecond();
    L40:
        if (r26 == null) goto L42;
        FLogger.a.i("TtsStateProducer", "TTS already playing, update instead of start, taskKey=" + r13);
        ConcurrentHashMap<String, a> r27 = r18.b;
        l r28 = r26.a;
        Intrinsics.checkNotNullParameter(r28, "handle");
        Intrinsics.checkNotNullParameter(r111, "state");
        r27.put(r13, new a(r28, r111));
        TaskFlowDslKt.f(r26.a, r111);
        goto L53
    L42:
        jha.c r29 = jha.j.a.a(r18);
        r7.L$0 = r13;
        r7.L$1 = r111;
        r7.label = 1;
        r1 = TaskFlowDslKt.e(r14, r111, r29, r7);
        if (r1 == r8) goto L64;
        r3 = r13;
        r2 = r111;
        goto L46
    L64:
        return r8;
    L39:
        r26 = null;
    L35:
        r25 = r14.a;
        goto L36
    L17:
        if (r17 != 2) goto L19;
    L21:
        Pair<String, a> r30 = r18.b(r14.a, r19, r22);
        if (r30 == null) goto L27;
        String r31 = (String) r30.component1();
        Job r32 = r18.c.remove(r31);
        if (r32 == null) goto L26;
        Job.DefaultImpls.cancel$default(r32, null, 1, null);
    L26:
        r10 = r18.b.remove(r31);
    L27:
        if (r10 == null) goto L61;
        l r0 = r10.a;
        if (r0 == null) goto L61;
        TaskFlowDslKt.c(r0, new e0.a(r10.b.d(), r10.b.e(), r10.b.f(), r23, r10.b.b()));
        goto L61
    L19:
        if (r17 == 3) goto L21;
    L7:
        r5 = new emitTtsTaskState.1(r18, r24);
        goto L8
    }
}
