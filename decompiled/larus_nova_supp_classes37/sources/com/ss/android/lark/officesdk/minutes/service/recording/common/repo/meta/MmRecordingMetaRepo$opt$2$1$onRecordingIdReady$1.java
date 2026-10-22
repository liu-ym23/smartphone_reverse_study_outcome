package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.meta;

import com.ss.android.lark.officesdk.minutes.service.foundation.network.response.http.MmAssociatedIds;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.response.http.MmCreateAudioResponse;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.meta.MmRecordingMetaRepo$opt$2$1$onRecordingIdReady$1", f = "MmRecordingMetaRepo.kt", i = {}, l = {95}, m = "invokeSuspend", n = {}, s = {})
public final class MmRecordingMetaRepo$opt$2$1$onRecordingIdReady$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ MmCreateAudioResponse $info;
    int label;
    final /* synthetic */ MmRecordingMetaRepo$opt$2.AnonymousClass1 this$0;
    final /* synthetic */ MmRecordingMetaRepo this$1;

    public MmRecordingMetaRepo$opt$2$1$onRecordingIdReady$1(MmRecordingMetaRepo$opt$2.AnonymousClass1 r1, MmCreateAudioResponse r2, MmRecordingMetaRepo r3, Continuation<? super MmRecordingMetaRepo$opt$2$1$onRecordingIdReady$1> r4) {
        this.this$0 = r1;
        this.$info = r2;
        this.this$1 = r3;
        super(1, r4);
    }

    public final Continuation<Unit> create(Continuation<?> r5) {
        return new MmRecordingMetaRepo$opt$2$1$onRecordingIdReady$1(this.this$0, this.$info, this.this$1, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Continuation) r1);
    }

    public final Object invoke(Continuation<? super Unit> r2) {
        return create(r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r13) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r13);
    L24:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r13);
        b r3 = (b) this.this$0.m();
        MmAssociatedIds r14 = this.$info.getAssociatedIds();
        if (r14 == null) goto L11;
        String r15 = r14.getObjectToken();
    L12:
        if (r15 != null) goto L15;
        r15 = "";
    L15:
        if (StringsKt.isBlank(r15) == false) goto L17;
        r15 = r3.b;
    L17:
        String r5 = r15;
        String r16 = this.$info.getTopic();
        if (StringsKt.isBlank(r16) == false) goto L20;
        r16 = r3.c;
    L20:
        b r17 = b.a(r3, null, r5, r16, 0, null, null, 57);
        MmRecordingMetaRepo r2 = this.this$1;
        this.label = 1;
        if (r2.b(r17, this) != r0) goto L24;
        return r0;
    L11:
        r15 = null;
        goto L12
    }
}
