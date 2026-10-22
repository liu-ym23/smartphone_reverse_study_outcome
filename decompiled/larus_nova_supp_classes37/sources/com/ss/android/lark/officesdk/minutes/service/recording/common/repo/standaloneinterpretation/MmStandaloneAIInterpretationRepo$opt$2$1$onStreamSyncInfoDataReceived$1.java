package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation;

import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.m;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.n;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.MmStandaloneAIInterpretationRepo$opt$2$1$onStreamSyncInfoDataReceived$1", f = "MmStandaloneAIInterpretationRepo.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class MmStandaloneAIInterpretationRepo$opt$2$1$onStreamSyncInfoDataReceived$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ byte[] $data;
    int label;
    final /* synthetic */ MmStandaloneAIInterpretationRepo this$0;
    final /* synthetic */ MmStandaloneAIInterpretationRepo$opt$2.AnonymousClass1 this$1;

    public MmStandaloneAIInterpretationRepo$opt$2$1$onStreamSyncInfoDataReceived$1(byte[] r1, MmStandaloneAIInterpretationRepo r2, MmStandaloneAIInterpretationRepo$opt$2.AnonymousClass1 r3, Continuation<? super MmStandaloneAIInterpretationRepo$opt$2$1$onStreamSyncInfoDataReceived$1> r4) {
        this.$data = r1;
        this.this$0 = r2;
        this.this$1 = r3;
        super(1, r4);
    }

    public final Continuation<Unit> create(Continuation<?> r5) {
        return new MmStandaloneAIInterpretationRepo$opt$2$1$onStreamSyncInfoDataReceived$1(this.$data, this.this$0, this.this$1, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Continuation) r1);
    }

    public final Object invoke(Continuation<? super Unit> r2) {
        return create(r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L32;
        ResultKt.throwOnFailure(r8);
        n r9 = n.a;
        byte[] r0 = this.$data;
        r9.getClass();
        m r10 = n.a(r0);
        if (r10 != null) goto L8;
        lvb.a.e(this.this$0.l, "[onStreamSyncInfoDataReceived] skip, parse failed");
        return Unit.INSTANCE;
    L8:
        MmStandaloneAIInterpretationRepo r1 = this.this$0;
        Long r2 = r10.a;
        MmStandaloneAIInterpretationRepo.Companion r3 = MmStandaloneAIInterpretationRepo.t;
        r1.getClass();
        if (r2 == null) goto L17;
        long r4 = r2.longValue();
        Long r5 = r1.q;
        if (r5 != null) goto L14;
    L16:
        r1.q = Long.valueOf(r4);
        goto L17
    L14:
        if (r5.longValue() != r4) goto L16;
        boolean r6 = true;
    L18:
        if (r6 == true) goto L20;
        b r7 = (b) this.this$1.m();
        boolean r11 = this.this$0.u().i;
        e r12 = this.this$0.u();
        boolean r13 = r10.b;
        boolean r14 = r7.a;
        r12.k = ((Boolean) r12.a.invoke()).booleanValue();
        r12.i = r13;
        boolean r15 = r12.b(r14);
        boolean r16 = r12.k;
        if (r11 == r13) goto L24;
        String r17 = this.this$0.l;
        StringBuilder r18 = new StringBuilder("[onStreamSyncInfoDataReceived] seqId=");
        r18.append(r10.a);
        r18.append(", changeToOrigin=");
        r18.append(r10.b);
        r18.append(", activeTarget=");
        c r19 = r7.i;
        if (r19 == null) goto L28;
        String r20 = r19.a;
    L29:
        r18.append(r20);
        r18.append(", actualMuted=");
        r18.append(r16);
        r18.append(", resultChangeToOrigin=");
        r18.append(r13);
        r18.append(", enabled=");
        r18.append(r7.a);
        r18.append(", rtcInitialized=");
        r18.append(this.this$0.u().f);
        r18.append(", appliedToRtc=");
        r18.append(r15);
        lvb.a.e(r17, r18.toString());
        return Unit.INSTANCE;
    L28:
        r20 = null;
        goto L29
    L24:
        return Unit.INSTANCE;
    L20:
        return Unit.INSTANCE;
    L17:
        r6 = false;
        goto L18
    L32:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
