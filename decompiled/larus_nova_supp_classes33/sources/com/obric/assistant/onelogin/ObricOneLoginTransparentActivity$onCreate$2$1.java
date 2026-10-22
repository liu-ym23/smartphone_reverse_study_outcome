package com.obric.assistant.onelogin;

import android.content.Intent;
import androidx.activity.result.ActivityResultLauncher;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.onelogin.ObricOneLoginTransparentActivity$onCreate$2$1", f = "ObricOneLoginTransparentActivity.kt", i = {}, l = {99}, m = "invokeSuspend", n = {}, s = {})
public final class ObricOneLoginTransparentActivity$onCreate$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ObricOneLoginTransparentActivity this$0;

    public ObricOneLoginTransparentActivity$onCreate$2$1(ObricOneLoginTransparentActivity r1, Continuation<? super ObricOneLoginTransparentActivity$onCreate$2$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ObricOneLoginTransparentActivity$onCreate$2$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v9, types: [android.app.Activity, com.obric.assistant.onelogin.ObricOneLoginTransparentActivity, java.lang.Object] */
    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
    L12:
        if (((Boolean) r4).booleanValue() == true) goto L14;
        ?? r5 = this.this$0;
        int r2 = ObricOneLoginTransparentActivity.d;
        r5.getClass();
        FLogger.a.i("ObricOneLoginTransparentActivity", "startOAccountLoginActivity taskId:" + r5.getTaskId() + ", " + r5 + ' ');
        ActivityResultLauncher<Intent> r3 = r5.b;
        Intent r6 = new Intent("com.obric.account.action.OBRIC_ACCOUNT_LOGIN");
        r6.setPackage("com.obric.account");
        r6.putExtra("enter_from", r5.getPackageName());
        r3.launch(r6);
    L16:
        return Unit.INSTANCE;
    L14:
        ObricOneLoginTransparentActivity r7 = this.this$0;
        int r8 = ObricOneLoginTransparentActivity.d;
        r7.y1();
        goto L16
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        this.label = 1;
        StateFlowImpl r9 = c0.a;
        r4 = CoroutineScopeKt.coroutineScope(new ObricOneLoginUtilsKt.getOAccountLogin.2(null), this);
        if (r4 != r0) goto L12;
        return r0;
    }
}
