package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language;

import com.ss.android.lark.pb.videochat.GetLiveRecordingSettingResponse;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.MmRecordingLanguageRepo$opt$2$1$fetchTranslateLanguageList$1$1$1", f = "MmRecordingLanguageRepo.kt", i = {}, l = {227}, m = "invokeSuspend", n = {}, s = {})
public final class MmRecordingLanguageRepo$opt$2$1$fetchTranslateLanguageList$1$1$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ GetLiveRecordingSettingResponse $response;
    int label;
    final /* synthetic */ MmRecordingLanguageRepo$opt$2.AnonymousClass1 this$0;
    final /* synthetic */ MmRecordingLanguageRepo this$1;

    public MmRecordingLanguageRepo$opt$2$1$fetchTranslateLanguageList$1$1$1(GetLiveRecordingSettingResponse r1, MmRecordingLanguageRepo$opt$2.AnonymousClass1 r2, MmRecordingLanguageRepo r3, Continuation<? super MmRecordingLanguageRepo$opt$2$1$fetchTranslateLanguageList$1$1$1> r4) {
        this.$response = r1;
        this.this$0 = r2;
        this.this$1 = r3;
        super(1, r4);
    }

    public final Continuation<Unit> create(Continuation<?> r5) {
        return new MmRecordingLanguageRepo$opt$2$1$fetchTranslateLanguageList$1$1$1(this.$response, this.this$0, this.this$1, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Continuation) r1);
    }

    public final Object invoke(Continuation<? super Unit> r2) {
        return create(r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.util.List] */
    public final Object invokeSuspend(Object r13) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r13);
    L23:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r13);
        List<GetLiveRecordingSettingResponse.SubtitleLanguage> r14 = this.$response.mtranslation_language_list;
        if (r14 == null) goto L14;
        List<GetLiveRecordingSettingResponse.SubtitleLanguage> r15 = r14;
        ?? r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r15, 10));
        Iterator r16 = r15.iterator();
    L12:
        if (r16.hasNext() == false) goto L15;
        GetLiveRecordingSettingResponse.SubtitleLanguage r3 = (GetLiveRecordingSettingResponse.SubtitleLanguage) r16.next();
        r2.add(new h(r3.mlanguage, r3.mdescription_i18n));
    L15:
        ?? r5 = r2;
        Boolean r17 = this.$response.mis_bilingual;
        if (r17 == null) goto L18;
        boolean r8 = r17.booleanValue();
    L19:
        f r18 = f.a((f) this.this$0.m(), null, r5, null, null, r8, false, true, 45);
        MmRecordingLanguageRepo r4 = this.this$1;
        this.label = 1;
        if (r4.b(r18, this) != r0) goto L23;
        return r0;
    L18:
        r8 = false;
        goto L19
    L14:
        r2 = CollectionsKt.emptyList();
        goto L15
    }
}
