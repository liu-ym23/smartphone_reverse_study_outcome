package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language;

import com.ss.android.lark.pb.videochat.GetLiveRecordingSettingResponse;
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
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.MmRecordingLanguageRepo$opt$2$1$fetchLanguageSettings$1$1$1", f = "MmRecordingLanguageRepo.kt", i = {}, l = {160}, m = "invokeSuspend", n = {}, s = {})
public final class MmRecordingLanguageRepo$opt$2$1$fetchLanguageSettings$1$1$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ GetLiveRecordingSettingResponse $response;
    int label;
    final /* synthetic */ MmRecordingLanguageRepo$opt$2.AnonymousClass1 this$0;
    final /* synthetic */ MmRecordingLanguageRepo this$1;

    public MmRecordingLanguageRepo$opt$2$1$fetchLanguageSettings$1$1$1(MmRecordingLanguageRepo$opt$2.AnonymousClass1 r1, GetLiveRecordingSettingResponse r2, MmRecordingLanguageRepo r3, Continuation<? super MmRecordingLanguageRepo$opt$2$1$fetchLanguageSettings$1$1$1> r4) {
        this.this$0 = r1;
        this.$response = r2;
        this.this$1 = r3;
        super(1, r4);
    }

    public final Continuation<Unit> create(Continuation<?> r5) {
        return new MmRecordingLanguageRepo$opt$2$1$fetchLanguageSettings$1$1$1(this.this$0, this.$response, this.this$1, r5);
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
    L20:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r13);
        f r3 = (f) this.this$0.m();
        GetLiveRecordingSettingResponse.SubtitleLanguage r14 = this.$response.mspoken_language;
        if (r14 == null) goto L11;
        h r6 = new h(r14.mlanguage, r14.mdescription_i18n);
    L12:
        GetLiveRecordingSettingResponse.SubtitleLanguage r15 = this.$response.mtranslation_language;
        if (r15 == null) goto L15;
        h r7 = new h(r15.mlanguage, r15.mdescription_i18n);
    L16:
        f r16 = f.a(r3, null, null, r6, r7, false, true, false, 83);
        lvb.a.e(this.this$1.m, "[fetchLanguageSettings] success: " + r16);
        MmRecordingLanguageRepo r2 = this.this$1;
        this.label = 1;
        if (r2.b(r16, this) != r0) goto L20;
        return r0;
    L15:
        r7 = new h("source", "");
        goto L16
    L11:
        r6 = new h(0);
        goto L12
    }
}
