package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.upload;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/core/service/upload/MmRecordingUploadResponse;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.upload.MmRecordingUploadTask$execute$1", f = "MmRecordingUploadTask.kt", i = {}, l = {ItemViewType.ITEM_VIEW_TYPE_EMAIL_CONTACT, ItemViewType.ITEM_VIEW_TYPE_EMAIL_CONTACT}, m = "invokeSuspend", n = {}, s = {})
final class MmRecordingUploadTask$execute$1 extends SuspendLambda implements Function2<FlowCollector<? super MmRecordingUploadResponse>, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a $userContext;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MmRecordingUploadTask this$0;

    public MmRecordingUploadTask$execute$1(MmRecordingUploadTask r1, com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a r2, Continuation<? super MmRecordingUploadTask$execute$1> r3) {
        this.this$0 = r1;
        this.$userContext = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        MmRecordingUploadTask$execute$1 r0 = new MmRecordingUploadTask$execute$1(this.this$0, this.$userContext, r5);
        r0.L$0 = r4;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((FlowCollector) r1, (Continuation) r2);
    }

    public final Object invoke(FlowCollector<? super MmRecordingUploadResponse> r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r6);
    L17:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        FlowCollector r2 = (FlowCollector) this.L$0;
        ResultKt.throwOnFailure(r6);
    L13:
        this.L$0 = null;
        this.label = 2;
        if (r2.emit(r6, this) != r0) goto L17;
        return r0;
    L10:
        ResultKt.throwOnFailure(r6);
        r2 = (FlowCollector) this.L$0;
        MmRecordingUploadTask r7 = this.this$0;
        com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a r4 = this.$userContext;
        this.L$0 = r2;
        this.label = 1;
        r6 = MmRecordingUploadTask.a(r7, r4, this);
        if (r6 != r0) goto L13;
        return r0;
    }
}
