package com.larus.avlink.env.diary.style;

import com.larus.avlink.env.diary.style.api.DoraEnvObserveDiaryStyleApi;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.network.bean.BizResponse;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/bean/BizResponse;", "Lcom/larus/avlink/env/diary/style/api/UpdateDiaryStyleData;", "Lcom/larus/avlink/env/diary/style/api/DoraEnvObserveDiaryStyleApi;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.env.diary.style.DiaryStyleViewModel$updateCustomStyle$1$result$1", f = "DiaryStyleViewModel.kt", i = {}, l = {378}, m = "invokeSuspend", n = {}, s = {})
public final class DiaryStyleViewModel$updateCustomStyle$1$result$1 extends SuspendLambda implements Function2<DoraEnvObserveDiaryStyleApi, Continuation<? super BizResponse<m98.g>>, Object> {
    final /* synthetic */ e0 $existingStyle;
    final /* synthetic */ String $prompt;
    final /* synthetic */ String $resolvedName;
    final /* synthetic */ String $styleId;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DiaryStyleViewModel this$0;

    public DiaryStyleViewModel$updateCustomStyle$1$result$1(DiaryStyleViewModel r1, String r2, String r3, String r4, e0 r5, Continuation<? super DiaryStyleViewModel$updateCustomStyle$1$result$1> r6) {
        this.this$0 = r1;
        this.$prompt = r2;
        this.$resolvedName = r3;
        this.$styleId = r4;
        this.$existingStyle = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        DiaryStyleViewModel$updateCustomStyle$1$result$1 r7 = new DiaryStyleViewModel$updateCustomStyle$1$result$1(this.this$0, this.$prompt, this.$resolvedName, this.$styleId, this.$existingStyle, r10);
        r7.L$0 = r9;
        return r7;
    }

    public final Object invoke(DoraEnvObserveDiaryStyleApi r1, Continuation<? super BizResponse<m98.g>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((DoraEnvObserveDiaryStyleApi) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r13) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r13);
    L11:
        return r13;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r13);
        DoraEnvObserveDiaryStyleApi r14 = (DoraEnvObserveDiaryStyleApi) this.L$0;
        m98.h r2 = new m98.h(Boxing.boxInt(DiaryStyleViewModel.access$getDoraSubBiz(this.this$0)), new m98.b(Boxing.boxInt(1), this.$prompt, this.$resolvedName, this.$styleId, this.$existingStyle.d, Boxing.boxBoolean(true)));
        this.label = 1;
        r13 = r14.updateDiaryStyle(r2, this);
        if (r13 != r0) goto L11;
        return r0;
    }
}
