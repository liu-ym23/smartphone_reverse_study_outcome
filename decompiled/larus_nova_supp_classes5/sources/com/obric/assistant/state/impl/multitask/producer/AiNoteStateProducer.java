package com.obric.assistant.state.impl.multitask.producer;

import aha.b;
import com.larus.audio.AudioServiceDelegate;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.state.multitask.core.TaskFlowAutoInitProducer;
import com.obric.assistant.state.multitask.ext.TaskFlowDslKt;
import java.util.Map;
import jha.g;
import jha.l;
import jha.m;
import jha.o;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000;\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0004*\u0001\t\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0002\u0016\u0017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0016\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0082@¢\u0006\u0002\u0010\u0010J\"\u0010\u0011\u001a\u00020\f2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00140\u0013H\u0082@¢\u0006\u0002\u0010\u0015R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\n¨\u0006\u0018"}, d2 = {"Lcom/obric/assistant/state/impl/multitask/producer/AiNoteStateProducer;", "Lcom/obric/assistant/state/multitask/core/TaskFlowAutoInitProducer;", "<init>", "()V", "scope", "Lkotlinx/coroutines/CoroutineScope;", "activeRecording", "Lcom/obric/assistant/state/impl/multitask/producer/AiNoteStateProducer$ActiveRecording;", "recordingListener", "com/obric/assistant/state/impl/multitask/producer/AiNoteStateProducer$recordingListener$1", "Lcom/obric/assistant/state/impl/multitask/producer/AiNoteStateProducer$recordingListener$1;", "initProducer", "", "startRecording", "meetingId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "endRecording", "reasonExt", "", "", "(Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "ActiveRecording", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AiNoteStateProducer implements TaskFlowAutoInitProducer {
    public final CoroutineScope a;
    public a b;
    public final AiNoteStateProducer$recordingListener$1 c;

    static {
    }

    @Override // com.obric.assistant.state.multitask.core.TaskFlowAutoInitProducer
    public final void f() {
        FLogger.a.i("AiNoteStateProducer", "initProducer");
        AudioServiceDelegate.a.P().j(this.c);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        FLogger.a.e("AiNoteStateProducer", "failed to add recording status listener", th);
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.obric.assistant.state.impl.multitask.producer.AiNoteStateProducer$recordingListener$1] */
    public AiNoteStateProducer() {
        ExecutorCoroutineDispatcher r0 = jha.f.a;
        this.a = jha.f.b;
        this.c = new AiNoteStateProducer$recordingListener$1(this);
    }

    public static final Unit a(AiNoteStateProducer r2, Map r3) {
        a r0 = r2.b;
        if (r0 != null) goto L5;
        FLogger.a.i("AiNoteStateProducer", "endRecording ignored, no active recording");
        return Unit.INSTANCE;
    L5:
        r2.b = null;
        TaskFlowDslKt.c(r0.b, new b.a(r0.a, r3));
        return Unit.INSTANCE;
    }

    public static final Object b(AiNoteStateProducer r6, String r7, Continuation r8) {
        r6.getClass();
        if ((r8 instanceof startRecording.1) == false) goto L7;
        startRecording.1 r0 = (startRecording.1) r8;
        int r1 = r0.label;
        if ((r1 & IntCompanionObject.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - IntCompanionObject.MIN_VALUE;
    L8:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        o r10 = (b.b) r0.L$1;
        String r4 = (String) r0.L$0;
        ResultKt.throwOnFailure(r9);
        o r5 = r10;
        r7 = r4;
    L19:
        m r11 = (m) r9;
        if (r11 != null) goto L22;
        FLogger.a.e("AiNoteStateProducer", "startRecording failed to acquire task handle");
        return Unit.INSTANCE;
    L22:
        r6.b = new a(r7, r11.a);
        if (r11.b == true) goto L27;
        TaskFlowDslKt.f(r11.a, r5);
    L27:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r9);
        aha.a r12 = aha.a.a;
        int r13 = com.obric.assistant.state.multitask.ext.f.a;
        g r14 = TaskFlowDslKt.b(r12, "ai_note_singleton");
        r5 = new b.b(r7);
        a r15 = r6.b;
        if (r15 != null) goto L25;
        jha.c r16 = jha.j.a.a(r6);
        r0.L$0 = r7;
        r0.L$1 = r5;
        r0.label = 1;
        r9 = TaskFlowDslKt.e(r14, r5, r16, r0);
        if (r9 != r2) goto L19;
        return r2;
    L25:
        FLogger.a.w("AiNoteStateProducer", "startRecording while another recording is active, previous=" + r15.a + ", new=" + r7 + ", fallback to update");
        l r17 = r15.b;
        Intrinsics.checkNotNullParameter(r7, "meetingId");
        Intrinsics.checkNotNullParameter(r17, "handle");
        r6.b = new a(r7, r17);
        TaskFlowDslKt.f(r15.b, r5);
    L7:
        r0 = new startRecording.1(r6, r8);
        goto L8
    }
}
