package com.obric.assistant.cocreationreview.modules.proactive;

import android.content.Context;
import com.obric.assistant.cocreationreview.g5;
import com.obric.assistant.cocreationreview.h5;
import com.obric.assistant.cocreationreview.s3;
import com.obric.memorydata.sdk.proactive.ProactiveAllPageSnapshot;
import com.obric.memorydata.sdk.proactive.ProactiveLabelingFeedbackConfigDto;
import com.obric.memorydata.sdk.proactive.ProactiveRecommendationDto;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/obric/assistant/cocreationreview/modules/proactive/ProactiveAgentRemoteSnapshot;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.cocreationreview.modules.proactive.ProactiveAgentRepository$loadSnapshot$1", f = "ProactiveAgentProvider.kt", i = {1, 1, 1, 2, 3, 3, 3, 4, 4, 4, 4}, l = {387, 396, 413, 419, 432}, m = "invokeSuspend", n = {"feedbackConfig", "window", "loadedByWindowApi", "feedbackConfig", "feedbackConfig", "loadedByWindowApi", "snapshot", "feedbackConfig", "loadedByWindowApi", "snapshot", "records"}, s = {"L$0", "L$1", "L$2", "L$0", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3"})
public final class ProactiveAgentRepository$loadSnapshot$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super n>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ ProactiveLabelingFeedbackConfigDto $fallbackConfig;
    final /* synthetic */ g5 $request;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ ProactiveAgentRepository this$0;

    public static final class a<T> implements Comparator {
        public a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r3, T r4) {
            return ComparisonsKt.compareValues(Long.valueOf(((q) r4).f), Long.valueOf(((q) r3).f));
        }
    }

    public static final class b<T> implements Comparator {
        public final /* synthetic */ Comparator a;

        public b(a r1) {
            this.a = r1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r3, T r4) {
            int r0 = this.a.compare(r3, r4);
            if (r0 == 0) goto L6;
            return r0;
        L6:
            return ComparisonsKt.compareValues(Double.valueOf(((q) r4).x), Double.valueOf(((q) r3).x));
        }
    }

    public ProactiveAgentRepository$loadSnapshot$1(Context r1, ProactiveLabelingFeedbackConfigDto r2, g5 r3, ProactiveAgentRepository r4, Continuation<? super ProactiveAgentRepository$loadSnapshot$1> r5) {
        this.$context = r1;
        this.$fallbackConfig = r2;
        this.$request = r3;
        this.this$0 = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        ProactiveAgentRepository$loadSnapshot$1 r6 = new ProactiveAgentRepository$loadSnapshot$1(this.$context, this.$fallbackConfig, this.$request, this.this$0, r9);
        r6.L$0 = r8;
        return r6;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super n> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r17) {
        Object r8 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 == 0) goto L17;
        if (r0 == 1) goto L15;
        if (r0 == 2) goto L14;
        if (r0 == 3) goto L13;
        if (r0 == 4) goto L12;
        if (r0 != 5) goto L11;
        List r1 = (List) this.L$3;
        ProactiveAllPageSnapshot r2 = (ProactiveAllPageSnapshot) this.L$2;
        Ref.BooleanRef r3 = (Ref.BooleanRef) this.L$1;
        ProactiveLabelingFeedbackConfigDto r4 = (ProactiveLabelingFeedbackConfigDto) this.L$0;
        ResultKt.throwOnFailure(r17);
        ProactiveAllPageSnapshot r14 = r2;
        Object r5 = r17;
    L64:
        List r6 = (List) r5;
        if ((!r6.isEmpty()) == false) goto L68;
        int r7 = s3.a;
        s3.b("proactive_agent.repository", "loadSnapshot fallbackByDay request=" + this.$request.b + ", records=" + r6.size());
        return new n(r6, r4);
    L68:
        int r9 = s3.a;
        s3.b("proactive_agent.repository", "loadSnapshot request=" + this.$request.b + ", windowApi=" + r3.element + ", batchId=" + r14.a + ", headers=" + r14.b.size() + ", records=" + r1.size());
        return new n(r1, r4);
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        ProactiveAllPageSnapshot r10 = (ProactiveAllPageSnapshot) this.L$2;
        Ref.BooleanRef r11 = (Ref.BooleanRef) this.L$1;
        ProactiveLabelingFeedbackConfigDto r12 = (ProactiveLabelingFeedbackConfigDto) this.L$0;
        ResultKt.throwOnFailure(r17);
        r14 = r10;
        r4 = r12;
        r3 = r11;
        Object r13 = r17;
    L43:
        Iterable r15 = (Iterable) r13;
        ArrayList r16 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r15, 10));
        Iterator r18 = r15.iterator();
    L45:
        if (r18.hasNext() == false) goto L47;
        r16.add(m.f((ProactiveRecommendationDto) r18.next()));
        goto L45
    L47:
        g5 r19 = this.$request;
        ArrayList r20 = new ArrayList();
        Iterator r21 = r16.iterator();
    L49:
        if (r21.hasNext() == false) goto L54;
        Object r22 = r21.next();
        if (m.a(r19, ((q) r22).f) == false) goto L49;
        r20.add(r22);
        goto L49
    L54:
        r1 = CollectionsKt.sortedWith(r20, new b(new a()));
        boolean r23 = r3.element;
        Intrinsics.checkNotNullParameter(r1, "records");
        if (r23 == false) goto L57;
    L59:
        boolean r24 = false;
    L60:
        if (r24 == false) goto L68;
        ProactiveAgentRepository r25 = this.this$0;
        g5 r26 = this.$request;
        this.L$0 = r4;
        this.L$1 = r3;
        this.L$2 = r14;
        this.L$3 = r1;
        this.label = 5;
        r5 = ProactiveAgentRepository.b(r25, r26, this);
        if (r5 != r8) goto L64;
        return r8;
    L57:
        if (r1.isEmpty() == false) goto L59;
        r24 = true;
        goto L60
    L13:
        ProactiveLabelingFeedbackConfigDto r27 = (ProactiveLabelingFeedbackConfigDto) this.L$0;
        ResultKt.throwOnFailure(r17);
        ProactiveLabelingFeedbackConfigDto r110 = r27;
        Object r28 = r17;
    L38:
        return new n((List) r28, r110);
    L14:
        Ref.BooleanRef r29 = (Ref.BooleanRef) this.L$2;
        h5 r30 = (h5) this.L$1;
        ProactiveLabelingFeedbackConfigDto r31 = (ProactiveLabelingFeedbackConfigDto) this.L$0;
        ResultKt.throwOnFailure(r17);
        r110 = r31;
        h5 r32 = r30;
        Object r33 = r17;
    L32:
        r14 = (ProactiveAllPageSnapshot) r33;
        if (r14 != null) goto L39;
        int r34 = s3.a;
        s3.c("proactive_agent.repository", "loadSnapshot empty reason=observe_timeout, request=" + this.$request.b);
        ProactiveAgentRepository r35 = this.this$0;
        g5 r36 = this.$request;
        this.L$0 = r110;
        this.L$1 = null;
        this.L$2 = null;
        this.label = 3;
        r28 = ProactiveAgentRepository.b(r35, r36, this);
        if (r28 != r8) goto L38;
        return r8;
    L39:
        ProactiveAgentRepository r37 = this.this$0;
        g5 r38 = this.$request;
        boolean r39 = r29.element;
        this.L$0 = r110;
        this.L$1 = r29;
        this.L$2 = r14;
        this.label = 4;
        r13 = ProactiveAgentRepository.a(r37, r14, r38, r32, r39, this);
        if (r13 != r8) goto L42;
        return r8;
    L42:
        r3 = r29;
        r4 = r110;
        goto L43
    L15:
        ResultKt.throwOnFailure(r17);     // Catch: Throwable -> L23
        Object r40 = r17;
    L21:
        Object r41 = Result.constructor-impl((ProactiveLabelingFeedbackConfigDto) r40);     // Catch: Throwable -> L23
    L25:
        ProactiveLabelingFeedbackConfigDto r42 = this.$fallbackConfig;
        if (Result.isFailure-impl(r41) == false) goto L28;
        r41 = r42;
    L28:
        ProactiveLabelingFeedbackConfigDto r43 = (ProactiveLabelingFeedbackConfigDto) r41;
        int r44 = s3.a;
        s3.b("proactive_agent.feedback_config", "positiveCount=" + r43.a.size() + ", positive=" + r43.a + ", negativeCount=" + r43.b.size() + ", negative=" + r43.b);
        r32 = g5.a(this.$request);
        Ref.BooleanRef r45 = new Ref.BooleanRef();
        ProactiveAgentRepository$loadSnapshot$1$snapshot$1 r111 = new ProactiveAgentRepository$loadSnapshot$1$snapshot$1(r32, r45, null);
        this.L$0 = r43;
        this.L$1 = r32;
        this.L$2 = r45;
        this.label = 2;
        r33 = TimeoutKt.c(5000, r111, this);
        if (r33 != r8) goto L31;
        return r8;
    L31:
        r110 = r43;
        r29 = r45;
        goto L32
    L17:
        ResultKt.throwOnFailure(r17);
        CoroutineScope r46 = (CoroutineScope) this.L$0;
        ska.b r47 = ska.b.a;
        r47.bindService(this.$context, "com.larus.nova");
        Result.Companion r48 = Result.Companion;     // Catch: Throwable -> L23
        this.label = 1;     // Catch: Throwable -> L23
        r40 = ska.b.b(r47);     // Catch: Throwable -> L23
        if (r40 != r8) goto L21;
        return r8;
    L23:
        th = move-exception;
        Result.Companion r49 = Result.Companion;
        r41 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L25
    }
}
