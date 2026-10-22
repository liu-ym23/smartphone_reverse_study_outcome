package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language;

import com.ss.android.lark.pb.videochat.GetLiveRecordingSettingResponse;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.MmRecordingLanguageRepo$opt$2$1$fetchLanguageSettings$1", f = "MmRecordingLanguageRepo.kt", i = {}, l = {148}, m = "invokeSuspend", n = {}, s = {})
final class MmRecordingLanguageRepo$opt$2$1$fetchLanguageSettings$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $meetingId;
    int label;
    final /* synthetic */ MmRecordingLanguageRepo$opt$2.AnonymousClass1 this$0;
    final /* synthetic */ MmRecordingLanguageRepo this$1;

    public MmRecordingLanguageRepo$opt$2$1$fetchLanguageSettings$1(MmRecordingLanguageRepo$opt$2.AnonymousClass1 r1, String r2, MmRecordingLanguageRepo r3, Continuation<? super MmRecordingLanguageRepo$opt$2$1$fetchLanguageSettings$1> r4) {
        this.this$0 = r1;
        this.$meetingId = r2;
        this.this$1 = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new MmRecordingLanguageRepo$opt$2$1$fetchLanguageSettings$1(this.this$0, this.$meetingId, this.this$1, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
        Object r8 = ((Result) r7).unbox-impl();
    L11:
        MmRecordingLanguageRepo r2 = this.this$1;
        MmRecordingLanguageRepo$opt$2.AnonymousClass1 r3 = this.this$0;
        if (Result.isSuccess-impl(r8) == false) goto L14;
        r2.j(new MmRecordingLanguageRepo$opt$2$1$fetchLanguageSettings$1$1$1(r3, (GetLiveRecordingSettingResponse) r8, r2, null));
    L14:
        MmRecordingLanguageRepo$opt$2.AnonymousClass1 r4 = this.this$0;
        MmRecordingLanguageRepo r5 = this.this$1;
        Throwable r9 = Result.exceptionOrNull-impl(r8);
        if (r9 == null) goto L18;
        r4.i = true;
        lvb.a.b(r5.m, "[fetchLanguageSettings] failed, error=" + r9);
    L18:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        com.ss.android.lark.officesdk.minutes.service.foundation.utils.net.a r10 = this.this$0.b;
        String r6 = this.$meetingId;
        this.label = 1;
        r8 = r10.f(r6, this);
        if (r8 != r0) goto L11;
        return r0;
    }
}
