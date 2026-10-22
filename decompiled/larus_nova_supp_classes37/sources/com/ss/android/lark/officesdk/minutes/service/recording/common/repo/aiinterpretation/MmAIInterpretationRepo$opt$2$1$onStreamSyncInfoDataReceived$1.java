package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation;

import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.audiosave.MmAudioSaveType;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.MmAIInterpretationRepo$opt$2$1$onStreamSyncInfoDataReceived$1", f = "MmAIInterpretationRepo.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class MmAIInterpretationRepo$opt$2$1$onStreamSyncInfoDataReceived$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ byte[] $data;
    int label;
    final /* synthetic */ MmAIInterpretationRepo this$0;
    final /* synthetic */ MmAIInterpretationRepo$opt$2.AnonymousClass1 this$1;

    public MmAIInterpretationRepo$opt$2$1$onStreamSyncInfoDataReceived$1(byte[] r1, MmAIInterpretationRepo r2, MmAIInterpretationRepo$opt$2.AnonymousClass1 r3, Continuation<? super MmAIInterpretationRepo$opt$2$1$onStreamSyncInfoDataReceived$1> r4) {
        this.$data = r1;
        this.this$0 = r2;
        this.this$1 = r3;
        super(1, r4);
    }

    public final Continuation<Unit> create(Continuation<?> r5) {
        return new MmAIInterpretationRepo$opt$2$1$onStreamSyncInfoDataReceived$1(this.$data, this.this$0, this.this$1, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Continuation) r1);
    }

    public final Object invoke(Continuation<? super Unit> r2) {
        return create(r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L47;
        ResultKt.throwOnFailure(r10);
        n r11 = n.a;
        byte[] r0 = this.$data;
        r11.getClass();
        m r12 = n.a(r0);
        if (r12 != null) goto L8;
        lvb.a.e(this.this$0.n, "[onStreamSyncInfoDataReceived] skip, parse failed");
        return Unit.INSTANCE;
    L8:
        MmAIInterpretationRepo r1 = this.this$0;
        Long r2 = r12.a;
        int r3 = MmAIInterpretationRepo.r;
        r1.getClass();
        boolean r4 = true;
        int r5 = 0;
        if (r2 == null) goto L17;
        long r6 = r2.longValue();
        Long r7 = r1.p;
        if (r7 != null) goto L14;
    L16:
        r1.p = Long.valueOf(r6);
        goto L17
    L14:
        if (r7.longValue() != r6) goto L16;
        boolean r8 = true;
    L18:
        if (r8 == false) goto L21;
        lvb.a.e(this.this$0.n, "[onStreamSyncInfoDataReceived] skip duplicate seqId=" + r12.a);
        return Unit.INSTANCE;
    L21:
        d r9 = (d) this.this$1.m();
        if (r9.a == true) goto L25;
        lvb.a.e(this.this$0.n, "[onStreamSyncInfoDataReceived] skip, ai interpretation disabled, seqId=" + r12.a);
        return Unit.INSTANCE;
    L25:
        b r13 = this.this$0.k;
        boolean r14 = r12.b;
        r13.h = r14;
        lvb.a.e("MmAIInterpretationAudioController", "[onStreamSyncInfoUpdated] aiEnabled=" + r13.e + ", changeToOrigin=" + r14);
        if (r13.e == false) goto L40;
        int r15 = c.a;
        boolean r16 = r13.c();
        MmAudioSaveType r17 = r13.f;
        boolean r18 = r13.b.a();
        Intrinsics.checkNotNullParameter(r17, "audioSaveType");
        if (r16 == true) goto L30;
    L33:
        r4 = false;
    L34:
        int r19 = h.a;
        boolean r20 = r13.h;
        if (r4 == true) goto L39;
        if (r20 == true) goto L39;
        r5 = 100;
    L39:
        r13.a(r5);
        goto L40
    L30:
        if (r17 != MmAudioSaveType.SAVE) goto L33;
        if (r18 == true) goto L33;
    L40:
        String r21 = this.this$0.n;
        StringBuilder r22 = new StringBuilder("[onStreamSyncInfoDataReceived] seqId=");
        r22.append(r12.a);
        r22.append(", changeToOrigin=");
        r22.append(r12.b);
        r22.append(", activeLanguage=");
        g r110 = r9.d;
        if (r110 == null) goto L43;
        String r111 = r110.a;
    L44:
        r22.append(r111);
        lvb.a.e(r21, r22.toString());
        return Unit.INSTANCE;
    L43:
        r111 = null;
    L17:
        r8 = false;
        goto L18
    L47:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
