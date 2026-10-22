package com.obric.assistant.state.impl.multitask.producer;

import android.os.SystemClock;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.state.impl.v2.utils.CoroutineExtKt;
import com.obric.assistant.state.multitask.ext.TaskFlowDslKt;
import com.obric.assistant.state.multitask.ext.f;
import java.util.Map;
import jha.c;
import jha.g;
import jha.j$a;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.state.impl.multitask.producer.ObricAlarmTtsStateProducer$dispatchAlarmTtsStart$1", f = "ObricAlarmTtsStateProducer.kt", i = {0, 0}, l = {50}, m = "invokeSuspend", n = {"effectiveMessageId", "startState"}, s = {"L$0", "L$1"})
final class ObricAlarmTtsStateProducer$dispatchAlarmTtsStart$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Map<String, Object> $extra;
    final /* synthetic */ String $messageId;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ ObricAlarmTtsStateProducer this$0;

    /* JADX INFO: renamed from: com.obric.assistant.state.impl.multitask.producer.ObricAlarmTtsStateProducer$dispatchAlarmTtsStart$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.state.impl.multitask.producer.ObricAlarmTtsStateProducer$dispatchAlarmTtsStart$1$1", f = "ObricAlarmTtsStateProducer.kt", i = {}, l = {66}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $effectiveMessageId;
        final /* synthetic */ jha.l<aha.h> $handle;
        int label;
        final /* synthetic */ ObricAlarmTtsStateProducer this$0;

        public AnonymousClass1(ObricAlarmTtsStateProducer r1, String r2, jha.l<aha.h> r3, Continuation<? super AnonymousClass1> r4) {
            this.this$0 = r1;
            this.$effectiveMessageId = r2;
            this.$handle = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new AnonymousClass1(this.this$0, this.$effectiveMessageId, this.$handle, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r10) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r10);
        L11:
            ObricAlarmTtsStateProducer r11 = this.this$0;
            String r2 = this.$effectiveMessageId;
            jha.l<aha.h> r3 = this.$handle;
            if (r11.b.remove(r2, r3) == false) goto L18;
            FLogger.a.i("ObricAlarmTtsStateProducer", "dispatchAlarmTtsEnd, messageId=" + r2);
            TaskFlowDslKt.c(r3, new aha.h.a(r2, MapsKt.mapOf(new Pair[]{TuplesKt.to("end_reason", "timeout"), TuplesKt.to("timeout_ms", 15000L)})));
            Job r12 = r11.c.remove(r2);
            if (r12 == null) goto L18;
            Job.DefaultImpls.cancel$default(r12, null, 1, null);
        L18:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r10);
            this.label = 1;
            if (CoroutineExtKt.a(15000, this) != r0) goto L11;
            return r0;
        }
    }

    public ObricAlarmTtsStateProducer$dispatchAlarmTtsStart$1(ObricAlarmTtsStateProducer r1, String r2, Map<String, ? extends Object> r3, Continuation<? super ObricAlarmTtsStateProducer$dispatchAlarmTtsStart$1> r4) {
        this.this$0 = r1;
        this.$messageId = r2;
        this.$extra = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new ObricAlarmTtsStateProducer$dispatchAlarmTtsStart$1(this.this$0, this.$messageId, this.$extra, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        aha.h.b r2 = (aha.h.b) this.L$1;
        String r3 = (String) this.L$0;
        ResultKt.throwOnFailure(r12);
    L28:
        jha.m r13 = (jha.m) r12;
        if (r13 != null) goto L32;
        FLogger.a.e("ObricAlarmTtsStateProducer", "dispatchAlarmTtsStart failed to enter mailbox, messageId=" + r3);
        return Unit.INSTANCE;
    L32:
        jha.l<S> r4 = r13.a;
        if (r13.b == true) goto L35;
        FLogger.a.i("ObricAlarmTtsStateProducer", "dispatchAlarmTtsStart, task already active, update and refresh timeout, messageId=" + r3);
        TaskFlowDslKt.f(r4, r2);
    L35:
        this.this$0.b.put(r3, (jha.l<aha.h>) r4);
        ObricAlarmTtsStateProducer r14 = this.this$0;
        r14.c.put(r3, BuildersKt.launch$default(r14.a, null, null, new AnonymousClass1(r14, r3, r4, null), 3, null));
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r12);
        ObricAlarmTtsStateProducer r15 = this.this$0;
        r3 = this.$messageId;
        int r5 = ObricAlarmTtsStateProducer.d;
        r15.getClass();
        if (r3 != null) goto L11;
    L20:
        r3 = "alarm-tts-" + SystemClock.elapsedRealtime();
    L21:
        FLogger.a.i("ObricAlarmTtsStateProducer", "dispatchAlarmTtsStart, messageId=" + r3);
        Intrinsics.checkNotNullParameter(r3, "messageId");
        aha.i r16 = aha.i.a;
        int r6 = f.a;
        g r17 = TaskFlowDslKt.b(r16, r3);
        Job r7 = this.this$0.c.remove(r3);
        if (r7 == null) goto L24;
        Job.DefaultImpls.cancel$default(r7, null, 1, null);
    L24:
        aha.h.b r8 = new aha.h.b(r3, this.$extra);
        ObricAlarmTtsStateProducer r9 = this.this$0;
        r9.getClass();
        c r10 = j$a.a(r9);
        this.L$0 = r3;
        this.L$1 = r8;
        this.label = 1;
        r12 = TaskFlowDslKt.e(r17, r8, r10, this);
        if (r12 != r0) goto L27;
        return r0;
    L27:
        r2 = r8;
        goto L28
    L11:
        if ((!StringsKt.isBlank(r3)) == true) goto L13;
    L15:
        boolean r18 = false;
    L16:
        if (r18 == true) goto L19;
        r3 = null;
    L19:
        if (r3 != null) goto L21;
    L13:
        if (Intrinsics.areEqual(r3, "-1") == true) goto L15;
        r18 = true;
        goto L16
    }
}
