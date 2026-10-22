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
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/bean/BizResponse;", "", "Lcom/larus/avlink/env/diary/style/api/DoraEnvObserveDiaryStyleApi;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.env.diary.style.DiaryStyleViewModel$deleteStyle$1$result$1", f = "DiaryStyleViewModel.kt", i = {}, l = {308}, m = "invokeSuspend", n = {}, s = {})
public final class DiaryStyleViewModel$deleteStyle$1$result$1 extends SuspendLambda implements Function2<DoraEnvObserveDiaryStyleApi, Continuation<? super BizResponse<Object>>, Object> {
    final /* synthetic */ e0 $styleInfo;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DiaryStyleViewModel this$0;

    public DiaryStyleViewModel$deleteStyle$1$result$1(DiaryStyleViewModel r1, e0 r2, Continuation<? super DiaryStyleViewModel$deleteStyle$1$result$1> r3) {
        this.this$0 = r1;
        this.$styleInfo = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        DiaryStyleViewModel$deleteStyle$1$result$1 r0 = new DiaryStyleViewModel$deleteStyle$1$result$1(this.this$0, this.$styleInfo, r5);
        r0.L$0 = r4;
        return r0;
    }

    public final Object invoke(DoraEnvObserveDiaryStyleApi r1, Continuation<? super BizResponse<Object>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((DoraEnvObserveDiaryStyleApi) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L11:
        return r6;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        DoraEnvObserveDiaryStyleApi r7 = (DoraEnvObserveDiaryStyleApi) this.L$0;
        m98.a r2 = new m98.a(Boxing.boxInt(DiaryStyleViewModel.access$getDoraSubBiz(this.this$0)), this.$styleInfo.a);
        this.label = 1;
        r6 = r7.deleteDiaryStyle(r2, this);
        if (r6 != r0) goto L11;
        return r0;
    }
}
