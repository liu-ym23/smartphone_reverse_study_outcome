package com.larus.avlink.env.diary.detail;

import com.larus.avlink.env.diary.feedback.api.DoraEnvObserveDiaryFeedbackApi;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.network.bean.BizResponse;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/bean/BizResponse;", "", "Lcom/larus/avlink/env/diary/feedback/api/DoraEnvObserveDiaryFeedbackApi;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.env.diary.detail.DoraEnvObserveDiaryDetailViewModel$submitFeedback$1$result$1", f = "DoraEnvObserveDiaryDetailViewModel.kt", i = {}, l = {219}, m = "invokeSuspend", n = {}, s = {})
public final class DoraEnvObserveDiaryDetailViewModel$submitFeedback$1$result$1 extends SuspendLambda implements Function2<DoraEnvObserveDiaryFeedbackApi, Continuation<? super BizResponse<Object>>, Object> {
    final /* synthetic */ String $content;
    final /* synthetic */ String $diaryId;
    final /* synthetic */ j98.f $state;
    private /* synthetic */ Object L$0;
    int label;

    public DoraEnvObserveDiaryDetailViewModel$submitFeedback$1$result$1(String r1, j98.f r2, String r3, Continuation<? super DoraEnvObserveDiaryDetailViewModel$submitFeedback$1$result$1> r4) {
        this.$diaryId = r1;
        this.$state = r2;
        this.$content = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        DoraEnvObserveDiaryDetailViewModel$submitFeedback$1$result$1 r0 = new DoraEnvObserveDiaryDetailViewModel$submitFeedback$1$result$1(this.$diaryId, this.$state, this.$content, r6);
        r0.L$0 = r5;
        return r0;
    }

    public final Object invoke(DoraEnvObserveDiaryFeedbackApi r1, Continuation<? super BizResponse<Object>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((DoraEnvObserveDiaryFeedbackApi) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r11);
    L19:
        return r11;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r11);
        DoraEnvObserveDiaryFeedbackApi r12 = (DoraEnvObserveDiaryFeedbackApi) this.L$0;
        String r4 = this.$diaryId;
        j98.f r2 = this.$state;
        int r5 = r2.b;
        List<String> r3 = r2.d;
        List<String> r6 = j98.d.a;
        Intrinsics.checkNotNullParameter(r3, "reasons");
        if (r3.isEmpty() == false) goto L11;
        String r7 = null;
    L12:
        String r8 = this.$content;
        if (StringsKt.isBlank(r8) == false) goto L15;
        String r9 = null;
    L16:
        j98.i r10 = new j98.i(new j98.e(r4, r5, r7, r9, 2), 2);
        this.label = 1;
        r11 = r12.submitFeedback(r10, this);
        if (r11 != r0) goto L19;
        return r0;
    L15:
        r9 = r8;
        goto L16
    L11:
        r7 = new JSONArray(r3).toString();
        goto L12
    }
}
