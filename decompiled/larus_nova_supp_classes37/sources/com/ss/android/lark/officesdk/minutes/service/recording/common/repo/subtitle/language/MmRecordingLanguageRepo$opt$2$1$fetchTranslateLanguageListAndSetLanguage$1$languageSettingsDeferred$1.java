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
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlin/Result;", "Lcom/ss/android/lark/pb/videochat/GetLiveRecordingSettingResponse;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.MmRecordingLanguageRepo$opt$2$1$fetchTranslateLanguageListAndSetLanguage$1$languageSettingsDeferred$1", f = "MmRecordingLanguageRepo.kt", i = {}, l = {251}, m = "invokeSuspend", n = {}, s = {})
public final class MmRecordingLanguageRepo$opt$2$1$fetchTranslateLanguageListAndSetLanguage$1$languageSettingsDeferred$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends GetLiveRecordingSettingResponse>>, Object> {
    final /* synthetic */ String $meetingId;
    int label;
    final /* synthetic */ MmRecordingLanguageRepo$opt$2.AnonymousClass1 this$0;

    public MmRecordingLanguageRepo$opt$2$1$fetchTranslateLanguageListAndSetLanguage$1$languageSettingsDeferred$1(MmRecordingLanguageRepo$opt$2.AnonymousClass1 r1, String r2, Continuation<? super MmRecordingLanguageRepo$opt$2$1$fetchTranslateLanguageListAndSetLanguage$1$languageSettingsDeferred$1> r3) {
        this.this$0 = r1;
        this.$meetingId = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new MmRecordingLanguageRepo$opt$2$1$fetchTranslateLanguageListAndSetLanguage$1$languageSettingsDeferred$1(this.this$0, this.$meetingId, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Result<GetLiveRecordingSettingResponse>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
        Object r5 = ((Result) r4).unbox-impl();
    L12:
        return Result.box-impl(r5);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        com.ss.android.lark.officesdk.minutes.service.foundation.utils.net.a r6 = this.this$0.b;
        String r2 = this.$meetingId;
        this.label = 1;
        r5 = r6.f(r2, this);
        if (r5 != r0) goto L12;
        return r0;
    }
}
