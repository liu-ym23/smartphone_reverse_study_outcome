package com.larus.avlink.env.diary.detail;

import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.env.diary.detail.DoraEnvObserveDiaryDetailFragment$showMoreMenu$commonMenu$2$1$confirm$1$1", f = "DoraEnvObserveDiaryDetailFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class DoraEnvObserveDiaryDetailFragment$showMoreMenu$commonMenu$2$1$confirm$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $diaryId;
    int label;
    final /* synthetic */ DoraEnvObserveDiaryDetailFragment this$0;

    public DoraEnvObserveDiaryDetailFragment$showMoreMenu$commonMenu$2$1$confirm$1$1(String r1, DoraEnvObserveDiaryDetailFragment r2, Continuation<? super DoraEnvObserveDiaryDetailFragment$showMoreMenu$commonMenu$2$1$confirm$1$1> r3) {
        this.$diaryId = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new DoraEnvObserveDiaryDetailFragment$showMoreMenu$commonMenu$2$1$confirm$1$1(this.$diaryId, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L13;
        ResultKt.throwOnFailure(r3);
        Intent r4 = new Intent();
        r4.putExtra("deleted_diary_id", this.$diaryId);
        FragmentActivity r0 = this.this$0.getActivity();
        if (r0 == null) goto L7;
        r0.setResult(-1, r4);
    L7:
        FragmentActivity r5 = this.this$0.getActivity();
        if (r5 == null) goto L11;
        r5.finish();
    L11:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
