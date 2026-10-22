package com.obric.assistant.chat.menu;

import android.app.Application;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.Message;
import com.larus.im.internal.legacy.NativeMessageServiceImpl;
import com.larus.utils.logger.FLogger;
import com.mammon.audiosdk.structures.SAMICoreProperty;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.chat.menu.UserAsrFeedbackUtils$asrUserFeedback$1", f = "UserAsrFeedbackUtils.kt", i = {}, l = {129}, m = "invokeSuspend", n = {}, s = {})
final class UserAsrFeedbackUtils$asrUserFeedback$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $feedback;
    final /* synthetic */ Message $message;
    final /* synthetic */ int $reset;
    final /* synthetic */ SAMICoreProperty $samiCoreProperty;
    int label;

    public UserAsrFeedbackUtils$asrUserFeedback$1(Message r1, int r2, SAMICoreProperty r3, String r4, Continuation<? super UserAsrFeedbackUtils$asrUserFeedback$1> r5) {
        this.$message = r1;
        this.$reset = r2;
        this.$samiCoreProperty = r3;
        this.$feedback = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new UserAsrFeedbackUtils$asrUserFeedback$1(this.$message, this.$reset, this.$samiCoreProperty, this.$feedback, r8);
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
        boolean r3 = true;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L11:
        int r7 = ((Number) r6).intValue();
        if (r7 != 0) goto L27;
        String r2 = this.$message.getMessageId();
        if (r2 != null) goto L16;
    L18:
        r3 = false;
    L19:
        if (r3 == false) goto L27;
        if (this.$reset != 0) goto L23;
        s r4 = s.a;
        Application r5 = AppHost.a.getApplication();
        r4.getClass();
        s.o(r5, 2131912266, false);
    L23:
        NativeMessageServiceImpl r8 = com.larus.im.d.e();
        String r9 = this.$message.getMessageId();
        if (r9 != null) goto L26;
        r9 = NameKeys.UnloadStrategy_No_Strategy;
    L26:
        final String r10 = this.$feedback;
        r8.x(r9, new f(r10), null);
        goto L27
    L16:
        if ((!StringsKt.isBlank(r2)) != true) goto L18;
    L27:
        FLogger r11 = FLogger.a;
        Lazy r12 = e.a;
        r11.i("UserAsrFeedbackUtils", "SAMICoreSetProperty, ret " + r7);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        CoroutineDispatcher r13 = Dispatchers.getIO();
        UserAsrFeedbackUtils$asrUserFeedback$1$ret$1 r14 = new UserAsrFeedbackUtils$asrUserFeedback$1$ret$1(this.$samiCoreProperty, null);
        this.label = 1;
        r6 = BuildersKt.withContext(r13, r14, this);
        if (r6 != r0) goto L11;
        return r0;
    }
}
