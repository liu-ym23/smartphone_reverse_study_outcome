package com.obric.assistant.state.impl.multitask.producer;

import aha.h0;
import aha.u;
import com.obric.assistant.state.api.multitask.IVoiceCaptureStateProducerService;
import com.obric.assistant.state.api.multitask.state.VoiceCaptureScene;
import com.obric.assistant.state.multitask.ext.TaskFlowDslKt;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import jha.f;
import jha.j;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0007\u0018\u0000 +2\u00020\u00012\u00020\u0002:\u0003+,-B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J=\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0002\u0010\u0016J3\u0010\u0017\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0002\u0010\u0018J;\u0010\u0019\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u00142\b\u0010\u0012\u001a\u0004\u0018\u00010\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0002\u0010\u001bJ3\u0010\u001c\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0002\u0010\u0018J3\u0010\u001d\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0002\u0010\u0018J;\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0012\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0002\u0010 J\u001e\u0010!\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\tH\u0082@¢\u0006\u0002\u0010#J2\u0010$\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0082@¢\u0006\u0002\u0010%J\u001a\u0010&\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J#\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020)0(2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002¢\u0006\u0002\u0010*R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\f0\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/obric/assistant/state/impl/multitask/producer/VoiceCaptureStateProducer;", "Lcom/obric/assistant/state/multitask/core/TaskFlowStateProducer;", "Lcom/obric/assistant/state/api/multitask/IVoiceCaptureStateProducerService;", "<init>", "()V", "scope", "Lkotlinx/coroutines/CoroutineScope;", "activeSessionMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/obric/assistant/state/impl/multitask/producer/VoiceCaptureStateProducer$ActiveSession;", "pendingEndMap", "Lcom/obric/assistant/state/impl/multitask/producer/VoiceCaptureStateProducer$PendingEndEvent;", "start", "", "conversationId", "scene", "Lcom/obric/assistant/state/api/multitask/state/VoiceCaptureScene;", "sessionId", "sourceType", "", "botId", "(Ljava/lang/String;Lcom/obric/assistant/state/api/multitask/state/VoiceCaptureScene;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "onAsrStart", "(Ljava/lang/String;Lcom/obric/assistant/state/api/multitask/state/VoiceCaptureScene;Ljava/lang/String;Ljava/lang/Integer;)V", "onCallStateChanged", "callState", "(Ljava/lang/String;Lcom/obric/assistant/state/api/multitask/state/VoiceCaptureScene;ILjava/lang/String;Ljava/lang/Integer;)V", "onAsrEnd", "end", "bufferPendingEnd", "key", "(Ljava/lang/String;Ljava/lang/String;Lcom/obric/assistant/state/api/multitask/state/VoiceCaptureScene;Ljava/lang/Integer;Ljava/lang/String;)V", "flushPendingEnd", "effectiveSessionId", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "endSession", "(Ljava/lang/String;Ljava/lang/String;Lcom/obric/assistant/state/api/multitask/state/VoiceCaptureScene;Ljava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sessionKey", "buildExt", "", "", "(Ljava/lang/Integer;)Ljava/util/Map;", "Companion", "PendingEndEvent", "ActiveSession", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VoiceCaptureStateProducer implements j, IVoiceCaptureStateProducerService {
    public final CoroutineScope a;
    public final ConcurrentHashMap<String, a> b;
    public final ConcurrentHashMap<String, c> c;

    public static final class a {
        public final String a;
        public final jha.l<h0> b;
        public final u c;
        public final VoiceCaptureScene d;
        public final Integer e;

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
            if (this.d == r6.d) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            int r0 = ((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31;
            Integer r1 = this.e;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return r0 + r2;
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public final String toString() {
            return "ActiveSession(sessionId=" + this.a + ", handle=" + this.b + ", taskMetadata=" + this.c + ", scene=" + this.d + ", sourceType=" + this.e + ')';
        }

        public a(String r2, jha.l<h0> r3, u r4, VoiceCaptureScene r5, Integer r6) {
            Intrinsics.checkNotNullParameter(r2, "sessionId");
            Intrinsics.checkNotNullParameter(r3, "handle");
            Intrinsics.checkNotNullParameter(r4, "taskMetadata");
            Intrinsics.checkNotNullParameter(r5, "scene");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
        }
    }

    public static final class b {
    }

    public static final class c {
        public final String a;
        public final VoiceCaptureScene b;
        public final Integer c;
        public final String d;
        public final Job e;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof c) == true) goto L8;
            return false;
        L8:
            c r6 = (c) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            String r0 = this.a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = ((r2 * 31) + this.b.hashCode()) * 31;
            Integer r4 = this.c;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (r3 + r5) * 31;
            String r7 = this.d;
            if (r7 == null) goto L15;
            r1 = r7.hashCode();
        L15:
            return ((r6 + r1) * 31) + this.e.hashCode();
        L9:
            r5 = r4.hashCode();
            goto L10
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "PendingEndEvent(conversationId=" + this.a + ", scene=" + this.b + ", sourceType=" + this.c + ", sessionId=" + this.d + ", timeoutJob=" + this.e + ')';
        }

        public c(String r2, VoiceCaptureScene r3, Integer r4, String r5, Job r6) {
            Intrinsics.checkNotNullParameter(r3, "scene");
            Intrinsics.checkNotNullParameter(r6, "timeoutJob");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
        }
    }

    static {
    }

    public VoiceCaptureStateProducer() {
        ExecutorCoroutineDispatcher r0 = f.a;
        this.a = f.b;
        this.b = new ConcurrentHashMap();
        this.c = new ConcurrentHashMap();
    }

    public static Map h(Integer r2) {
        LinkedHashMap r0 = new LinkedHashMap();
        if (r2 != null) goto L6;
    L8:
        return r0;
    L6:
        if (r2.intValue() != 4) goto L8;
        r0.put("is_from_continuous_intents", "1");
        goto L8
    }

    public static final String g(VoiceCaptureStateProducer r0, String r1, VoiceCaptureScene r2) {
        r0.getClass();
        StringBuilder r3 = new StringBuilder();
        r3.append(r2.name());
        r3.append('#');
        if (r1 != null) goto L5;
        r1 = "unknown_session";
    L5:
        r3.append(r1);
        return r3.toString();
    }

    @Override // com.obric.assistant.state.api.multitask.IVoiceCaptureStateProducerService
    public final void c(String r12, VoiceCaptureScene r13, String r14, Integer r15) {
        Intrinsics.checkNotNullParameter(r13, "scene");
        BuildersKt.launch$default(this.a, null, null, new VoiceCaptureStateProducer$onAsrStart$1(this, r12, r13, r14, r15, null), 3, null);
    }

    @Override // com.obric.assistant.state.api.multitask.IVoiceCaptureStateProducerService
    public final void d(String r12, VoiceCaptureScene r13, String r14, Integer r15) {
        Intrinsics.checkNotNullParameter(r13, "scene");
        BuildersKt.launch$default(this.a, null, null, new VoiceCaptureStateProducer$end$1(this, r12, r13, r14, r15, null), 3, null);
    }

    @Override // com.obric.assistant.state.api.multitask.IVoiceCaptureStateProducerService
    public final void e(String r12, VoiceCaptureScene r13, String r14, Integer r15) {
        Intrinsics.checkNotNullParameter(r13, "scene");
        BuildersKt.launch$default(this.a, null, null, new VoiceCaptureStateProducer$onAsrEnd$1(this, r12, r13, r14, r15, null), 3, null);
    }

    public final Unit i(String r9, String r10, VoiceCaptureScene r11, Integer r12) {
        a r13 = this.b.remove(r9);
        if (r13 == null) goto L5;
        TaskFlowDslKt.c(r13.b, new h0.c(r10, r11, r12, h(r12), r13.c));
        return Unit.INSTANCE;
    L5:
        return Unit.INSTANCE;
    }

    @Override // com.obric.assistant.state.api.multitask.IVoiceCaptureStateProducerService
    public final void a(String r14, VoiceCaptureScene r15, int r16, String r17, Integer r18) {
        Intrinsics.checkNotNullParameter(r15, "scene");
        if (r16 != 3) goto L5;
        return;
    L5:
        BuildersKt.launch$default(this.a, null, null, new VoiceCaptureStateProducer$onCallStateChanged$1(this, r14, r15, r16, r17, r18, null), 3, null);
    }

    @Override // com.obric.assistant.state.api.multitask.IVoiceCaptureStateProducerService
    public final void b(String r14, VoiceCaptureScene r15, String r16, Integer r17, String r18) {
        Intrinsics.checkNotNullParameter(r15, "scene");
        BuildersKt.launch$default(this.a, null, null, new VoiceCaptureStateProducer$start$1(r16, r14, r18, r15, r17, this, null), 3, null);
    }
}
