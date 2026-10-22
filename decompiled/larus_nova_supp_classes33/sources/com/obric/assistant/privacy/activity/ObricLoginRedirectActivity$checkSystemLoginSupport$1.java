package com.obric.assistant.privacy.activity;

import android.content.ComponentName;
import android.content.Intent;
import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.onelogin.IObricOneLogin;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.privacy.activity.ObricLoginRedirectActivity$checkSystemLoginSupport$1", f = "ObricLoginRedirectActivity.kt", i = {}, l = {189}, m = "invokeSuspend", n = {}, s = {})
final class ObricLoginRedirectActivity$checkSystemLoginSupport$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ObricLoginRedirectActivity this$0;

    public ObricLoginRedirectActivity$checkSystemLoginSupport$1(ObricLoginRedirectActivity r1, Continuation<? super ObricLoginRedirectActivity$checkSystemLoginSupport$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ObricLoginRedirectActivity$checkSystemLoginSupport$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        ActivityResultLauncher<Intent> r8 = null;
        if (r1 == 0) goto L9;
        if (r1 != 1) goto L8;
        ResultKt.throwOnFailure(r12);     // Catch: Exception -> L29
    L13:
        FLogger r13 = FLogger.a;     // Catch: Exception -> L29
        r13.i("TAG_ObricLoginRedirectActivity", this.this$0 + " initProductSdk() completed, continue with checkSystemLoginSupport()");     // Catch: Exception -> L29
        if (t9a.b.a().b() == false) goto L24;
        r13.i("TAG_ObricLoginRedirectActivity", this.this$0 + " Support system login, start ObricOneLoginActivity");     // Catch: Exception -> L29
        Intent r14 = new Intent();     // Catch: Exception -> L29
        AppCompatActivity r2 = this.this$0;     // Catch: Exception -> L29
        IObricOneLogin r7 = (IObricOneLogin) ServiceManager.get().getService(IObricOneLogin.class);     // Catch: Exception -> L29
        if (r7 == null) goto L19;
        String r9 = r7.c();     // Catch: Exception -> L29
        if (r9 == null) goto L19;
    L20:
        r14.setComponent(new ComponentName(r2, r9));     // Catch: Exception -> L29
        r14.putExtra("launch_dou_bao_main_bot", false);     // Catch: Exception -> L29
        ActivityResultLauncher<Intent> r3 = this.this$0.a;     // Catch: Exception -> L29
        if (r3 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("oneLoginLauncher");     // Catch: Exception -> L29
        r3 = null;
    L23:
        r3.launch(r14);     // Catch: Exception -> L29
    L36:
        return Unit.INSTANCE;
    L19:
        r9 = "com.obric.assistant.onelogin.ObricOneLoginActivity";
        goto L20
    L24:
        r13.i("TAG_ObricLoginRedirectActivity", this.this$0 + " Does not support system login, start doubao login");     // Catch: Exception -> L29
        Intent r15 = new Intent();     // Catch: Exception -> L29
        AppCompatActivity r4 = this.this$0;     // Catch: Exception -> L29
        r15.putExtra("key_trigger_app_id", "obric_login");     // Catch: Exception -> L29
        r15.setComponent(new ComponentName(r4, "com.larus.login.impl.activity.AccountLoginActivity"));     // Catch: Exception -> L29
        r15.addFlags(335544320);     // Catch: Exception -> L29
        ActivityResultLauncher<Intent> r5 = this.this$0.c;     // Catch: Exception -> L29
        if (r5 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("doubaoLoginLauncher");     // Catch: Exception -> L29
        r5 = null;
    L27:
        r5.launch(r15);     // Catch: Exception -> L29
        goto L36
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r12);
        FLogger.a.i("TAG_ObricLoginRedirectActivity", this.this$0 + " Waiting for initProductSdk() to complete");     // Catch: Exception -> L29
        CompletableDeferred<Unit> r16 = this.this$0.d;     // Catch: Exception -> L29
        this.label = 1;     // Catch: Exception -> L29
        if (r16.await(this) != r0) goto L13;
        return r0;
    L29:
        e = move-exception;
        FLogger.a.e("TAG_ObricLoginRedirectActivity", this.this$0 + " Error in checkSystemLoginSupport()", e);
        Intent r17 = new Intent();
        AppCompatActivity r6 = this.this$0;
        r17.putExtra("key_trigger_app_id", "obric_login");
        r17.setComponent(new ComponentName(r6, "com.larus.login.impl.activity.AccountLoginActivity"));
        r17.addFlags(335544320);
        ActivityResultLauncher<Intent> r10 = this.this$0.c;
        if (r10 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("doubaoLoginLauncher");
    L34:
        r8.launch(r17);
        goto L36
    L33:
        r8 = r10;
        goto L34
    }
}
