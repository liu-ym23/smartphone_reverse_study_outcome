package com.larus.bmhome.bot;

import android.view.View;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.utils.logger.FLogger;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.bot.CommonSettingFragment$setupFeedback$1$1", f = "CommonSettingFragment.kt", i = {}, l = {2766}, m = "invokeSuspend", n = {}, s = {})
final class CommonSettingFragment$setupFeedback$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ View $feedbackView;
    int label;
    final /* synthetic */ CommonSettingFragment this$0;

    public CommonSettingFragment$setupFeedback$1$1(CommonSettingFragment r1, View r2, Continuation<? super CommonSettingFragment$setupFeedback$1$1> r3) {
        this.this$0 = r1;
        this.$feedbackView = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new CommonSettingFragment$setupFeedback$1$1(this.this$0, this.$feedbackView, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        String r4 = null;
        if (r1 == 0) goto L9;
        if (r1 != 1) goto L8;
        ResultKt.throwOnFailure(r6);     // Catch: Exception -> L19 Throwable -> L33 CancellationException -> L38
    L13:
        Pair r7 = (Pair) r6;     // Catch: Exception -> L19 Throwable -> L33 CancellationException -> L38
        if (r7 != null) goto L16;
        FLogger.a.w(this.this$0.e, "feedback message collection timed out");     // Catch: Exception -> L19 Throwable -> L33 CancellationException -> L38
    L16:
        if (r7 == null) goto L22;
        r4 = (String) r7.getSecond();     // Catch: Exception -> L19 Throwable -> L33 CancellationException -> L38
        goto L22
    L22:
        if (this.this$0.isAdded() == true) goto L24;
    L35:
        FLogger.a.w(this.this$0.e, "feedback navigation aborted because page was destroyed");     // Catch: Throwable -> L33
        Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L33
        this.this$0.D = false;
        return r8;
    L24:
        if (this.this$0.getView() == null) goto L35;
        com.larus.platform.api.k3.a r9 = com.larus.platform.api.k3.a;     // Catch: Throwable -> L33
        View r2 = this.$feedbackView;     // Catch: Throwable -> L33
        Intrinsics.checkNotNull(r2);     // Catch: Throwable -> L33
        r9.getClass();     // Catch: Throwable -> L33
        Intrinsics.checkNotNullParameter(r2, "view");     // Catch: Throwable -> L33
        com.larus.platform.api.l3 r10 = (com.larus.platform.api.k3) com.larus.platform.api.k3.a.c.getValue();     // Catch: Throwable -> L33
        if ((r10 instanceof com.larus.platform.api.l3) == false) goto L29;
        r10.a(r2, r4);     // Catch: Throwable -> L33
    L31:
        this.this$0.D = false;
        return Unit.INSTANCE;
    L29:
        if (r10 == null) goto L31;
        r10.k(r2);     // Catch: Throwable -> L33
        goto L31
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r6);
        CommonSettingFragment$setupFeedback$1$1$extra$result$1 r11 = new CommonSettingFragment$setupFeedback$1$1$extra$result$1(null);     // Catch: Exception -> L19 Throwable -> L33 CancellationException -> L38
        this.label = 1;     // Catch: Exception -> L19 Throwable -> L33 CancellationException -> L38
        r6 = TimeoutKt.c(500, r11, this);     // Catch: Exception -> L19 Throwable -> L33 CancellationException -> L38
        if (r6 != r0) goto L13;
        return r0;
    L33:
        th = move-exception;
        this.this$0.D = false;
        throw th;
    L19:
        e = move-exception;
        FLogger.a.e(this.this$0.e, "feedback message collection failed", e);     // Catch: Throwable -> L33
    L38:
        e = move-exception;
        FLogger.a.d(this.this$0.e, "feedback message collection cancelled");     // Catch: Throwable -> L33
        throw e;     // Catch: Throwable -> L33
    }
}
