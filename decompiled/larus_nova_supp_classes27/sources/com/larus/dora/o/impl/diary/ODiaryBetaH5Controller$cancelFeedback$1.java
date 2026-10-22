package com.larus.dora.o.impl.diary;

import android.content.Context;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.o.impl.diary.ODiaryBetaH5Controller$cancelFeedback$1", f = "ODiaryBetaH5Controller.kt", i = {}, l = {307}, m = "invokeSuspend", n = {}, s = {})
final class ODiaryBetaH5Controller$cancelFeedback$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $bizId;
    final /* synthetic */ Context $context;
    final /* synthetic */ String $diaryId;
    final /* synthetic */ l0 $target;
    int label;
    final /* synthetic */ f this$0;

    public ODiaryBetaH5Controller$cancelFeedback$1(String r1, int r2, l0 r3, f r4, Context r5, Continuation<? super ODiaryBetaH5Controller$cancelFeedback$1> r6) {
        this.$diaryId = r1;
        this.$bizId = r2;
        this.$target = r3;
        this.this$0 = r4;
        this.$context = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new ODiaryBetaH5Controller$cancelFeedback$1(this.$diaryId, this.$bizId, this.$target, this.this$0, this.$context, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L11:
        boolean r11 = ((Boolean) r10).booleanValue();
        FLogger.a.i("ODiaryBetaH5", "cancel feedback diary=" + this.$diaryId + " ok=" + r11);
        if (r11 == false) goto L14;
        f r12 = this.this$0;
        String r2 = this.$diaryId;
        l0 r3 = this.$target;
        int r4 = f.j;
        r12.a(r2, 0, r3);
    L16:
        return Unit.INSTANCE;
    L14:
        t19.s r5 = t19.s.a;
        Context r6 = this.$context;
        t19.s.j(r5, r6, r6.getString(2131903889), null, false, 28);
        goto L16
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        DoraODiaryRepo r7 = DoraODiaryRepo.a;
        String r13 = this.$diaryId;
        List<String> r8 = CollectionsKt.emptyList();
        Integer r9 = Boxing.boxInt(this.$bizId);
        l0 r14 = this.$target;
        this.label = 1;
        r10 = r7.i(r13, 0, r8, "", r9, r14, this);
        if (r10 != r0) goto L11;
        return r0;
    }
}
