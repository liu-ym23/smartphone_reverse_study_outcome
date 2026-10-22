package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.speaker;

import com.ss.android.lark.picker.base.view.ItemViewType;
import java.util.LinkedHashMap;
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
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.speaker.MmRecordingSpeakerRepo$opt$2$1$onSpeakerMarked$1", f = "MmRecordingSpeakerRepo.kt", i = {0}, l = {71}, m = "invokeSuspend", n = {"mergedMap"}, s = {"L$0"})
public final class MmRecordingSpeakerRepo$opt$2$1$onSpeakerMarked$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ String $clusterId;
    final /* synthetic */ c $newSpeaker;
    final /* synthetic */ g $result;
    Object L$0;
    int label;
    final /* synthetic */ MmRecordingSpeakerRepo$opt$2.AnonymousClass1 this$0;
    final /* synthetic */ MmRecordingSpeakerRepo this$1;

    public MmRecordingSpeakerRepo$opt$2$1$onSpeakerMarked$1(MmRecordingSpeakerRepo$opt$2.AnonymousClass1 r1, g r2, c r3, MmRecordingSpeakerRepo r4, String r5, Continuation<? super MmRecordingSpeakerRepo$opt$2$1$onSpeakerMarked$1> r6) {
        this.this$0 = r1;
        this.$result = r2;
        this.$newSpeaker = r3;
        this.this$1 = r4;
        this.$clusterId = r5;
        super(1, r6);
    }

    public final Continuation<Unit> create(Continuation<?> r9) {
        return new MmRecordingSpeakerRepo$opt$2$1$onSpeakerMarked$1(this.this$0, this.$result, this.$newSpeaker, this.this$1, this.$clusterId, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Continuation) r1);
    }

    public final Object invoke(Continuation<? super Unit> r2) {
        return create(r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        LinkedHashMap r2 = (LinkedHashMap) this.L$0;
        ResultKt.throwOnFailure(r8);
    L14:
        lvb.a.e(this.this$1.l, "[onSpeakerMarked] changed, clusterId=" + this.$clusterId + ", mergedMap=" + r2);
        this.this$0.A0(MmSpeakerMappingSyncSource.MANUAL_MARK);
    L17:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        f r9 = (f) this.this$0.m();
        LinkedHashMap r3 = new LinkedHashMap(r9.b);
        if ((!Intrinsics.areEqual(r3.put(this.$result.b, this.$newSpeaker), this.$newSpeaker)) == false) goto L15;
        MmRecordingSpeakerRepo r4 = this.this$1;
        f r10 = f.a(r9, false, r3, null, 5);
        this.L$0 = r3;
        this.label = 1;
        if (r4.b(r10, this) != r0) goto L13;
        return r0;
    L13:
        r2 = r3;
        goto L14
    L15:
        lvb.a.e(this.this$1.l, "[onSpeakerMarked] skip, no change, clusterId=" + this.$clusterId);
        goto L17
    }
}
