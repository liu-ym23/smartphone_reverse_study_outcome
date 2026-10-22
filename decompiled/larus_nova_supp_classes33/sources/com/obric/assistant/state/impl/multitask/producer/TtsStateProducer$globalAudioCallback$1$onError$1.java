package com.obric.assistant.state.impl.multitask.producer;

import aha.e0;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.state.multitask.ext.TaskFlowDslKt;
import com.obric.capabilitykit.common.ErrorCode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.state.impl.multitask.producer.TtsStateProducer$globalAudioCallback$1$onError$1", f = "TtsStateProducer.kt", i = {}, l = {ErrorCode.PERMISSION_ERROR}, m = "invokeSuspend", n = {}, s = {})
public final class TtsStateProducer$globalAudioCallback$1$onError$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $scene;
    int label;
    final /* synthetic */ TtsStateProducer this$0;

    public TtsStateProducer$globalAudioCallback$1$onError$1(TtsStateProducer r1, String r2, Continuation<? super TtsStateProducer$globalAudioCallback$1$onError$1> r3) {
        this.this$0 = r1;
        this.$scene = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new TtsStateProducer$globalAudioCallback$1$onError$1(this.this$0, this.$scene, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r14) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r14);
    L35:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r14);
        TtsStateProducer r15 = this.this$0;
        String r2 = this.$scene;
        this.label = 1;
        Set r3 = r15.b.entrySet();
        ArrayList r4 = new ArrayList();
        Iterator r5 = r3.iterator();
    L10:
        if (r5.hasNext() == false) goto L14;
        Object r6 = r5.next();
        if (Intrinsics.areEqual(((TtsStateProducer$a) ((Map.Entry) r6).getValue()).b.d(), r2) == false) goto L10;
        r4.add(r6);
        goto L10
    L14:
        ArrayList r7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10));
        Iterator r8 = r4.iterator();
    L16:
        if (r8.hasNext() == false) goto L19;
        Map.Entry r9 = (Map.Entry) r8.next();
        r7.add(TuplesKt.to(r9.getKey(), r9.getValue()));
        goto L16
    L19:
        if (r7.isEmpty() == false) goto L21;
        FLogger.a.i("TtsStateProducer", "onError: no active tts tasks for scene=" + r2);
        Unit r16 = Unit.INSTANCE;
    L32:
        if (r16 != r0) goto L35;
        return r0;
    L21:
        FLogger.a.i("TtsStateProducer", "onError: ending " + r7.size() + " tts tasks for scene=" + r2);
        Iterator r10 = r7.iterator();
    L23:
        if (r10.hasNext() == false) goto L31;
        Pair r11 = (Pair) r10.next();
        String r12 = (String) r11.component1();
        TtsStateProducer$a r13 = (TtsStateProducer$a) r11.component2();
        if (r15.b.get(r12) != r13) goto L23;
        Job r17 = (Job) r15.c.remove(r12);
        if (r17 == null) goto L30;
        Job.DefaultImpls.cancel$default(r17, null, 1, null);
    L30:
        r15.b.remove(r12);
        e0 r18 = r13.b;
        TaskFlowDslKt.c(r13.a, new e0.a(r18.d(), r18.e(), r18.f(), MapsKt.mapOf(new Pair[]{TuplesKt.to("error_code", "tts_play_error"), TuplesKt.to("scene", r2)}), r18.b()));
        goto L23
    L31:
        r16 = Unit.INSTANCE;
        goto L32
    }
}
