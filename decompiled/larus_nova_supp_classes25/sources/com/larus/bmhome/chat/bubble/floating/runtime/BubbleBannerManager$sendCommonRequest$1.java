package com.larus.bmhome.chat.bubble.floating.runtime;

import android.content.Context;
import com.larus.bmhome.chat.bubble.floating.BubbleBannerDismissReason;
import com.larus.bmhome.chat.bubble.floating.network.ExperienceCommonBizData;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.bubble.floating.runtime.BubbleBannerManager$sendCommonRequest$1", f = "BubbleBannerManager.kt", i = {}, l = {345}, m = "invokeSuspend", n = {}, s = {})
final class BubbleBannerManager$sendCommonRequest$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Map<String, String> $actionData;
    final /* synthetic */ Context $context;
    final /* synthetic */ pc8.e $prompt;
    int label;

    public BubbleBannerManager$sendCommonRequest$1(Context r1, pc8.e r2, Map<String, String> r3, Continuation<? super BubbleBannerManager$sendCommonRequest$1> r4) {
        this.$context = r1;
        this.$prompt = r2;
        this.$actionData = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new BubbleBannerManager$sendCommonRequest$1(this.$context, this.$prompt, this.$actionData, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        String r2 = null;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r9);
    L11:
        dm9.a.b r10 = (dm9.a) r9;
        j r3 = j.a;
        Context r4 = this.$context;
        pc8.e r5 = this.$prompt;
        r3.getClass();
        if ((r10 instanceof dm9.a.b) == false) goto L40;
        ExperienceCommonBizData r11 = (ExperienceCommonBizData) r10.a.getData();
        if (r11 != null) goto L16;
        s.a.getClass();
        s.s(r4, 2131907052);
        j.d(r5, j.l());
    L43:
        return Unit.INSTANCE;
    L16:
        Boolean r6 = r11.isSuccess();
        Boolean r7 = Boolean.TRUE;
        boolean r8 = Intrinsics.areEqual(r6, r7);
        String r12 = r11.getShowMessage();
        if (r12 != null) goto L19;
    L26:
        boolean r13 = Intrinsics.areEqual(r11.isSuccess(), r7);
        Pair[] r14 = new Pair[1];
        if (r13 == false) goto L29;
        String r15 = "success";
    L30:
        r14[0] = TuplesKt.to("banner_action_result", r15);
        Map r16 = MapsKt.mutableMapOf(r14);
        if (r13 == true) goto L38;
        String r17 = r11.getFailReason();
        if (r17 != null) goto L35;
    L37:
        r16.put("banner_action_fail_reason", r2);
        goto L38
    L35:
        if ((!StringsKt.isBlank(r17)) == false) goto L37;
        r2 = r17;
    L38:
        j.d(r5, r16);
        j.c(r5.a, BubbleBannerDismissReason.USER_CLICK);
        goto L43
    L29:
        r15 = "fail";
        goto L30
    L19:
        if ((!StringsKt.isBlank(r12)) == true) goto L22;
        r12 = null;
    L22:
        if (r12 == null) goto L26;
        if (r8 == false) goto L25;
        s.a.getClass();
        s.p(r4, r12);
        goto L26
    L25:
        s.a.getClass();
        s.t(r4, r12);
        goto L26
    L40:
        if ((r10 instanceof dm9.a.a) == false) goto L45;
        s.a.getClass();
        s.s(r4, 2131907052);
        j.d(r5, j.l());
        goto L43
    L45:
        throw new NoWhenBranchMatchedException();
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r9);
        CoroutineDispatcher r18 = Dispatchers.getIO();
        BubbleBannerManager$sendCommonRequest$1$result$1 r19 = new BubbleBannerManager$sendCommonRequest$1$result$1(this.$actionData, null);
        this.label = 1;
        r9 = BuildersKt.withContext(r18, r19, this);
        if (r9 != r0) goto L11;
        return r0;
    }
}
