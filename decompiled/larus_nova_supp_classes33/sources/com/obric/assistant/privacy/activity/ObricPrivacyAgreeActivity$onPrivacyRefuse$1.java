package com.obric.assistant.privacy.activity;

import android.os.Process;
import com.larus.common.mssdk.api.ISecPrivacyService;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.privacy.activity.ObricPrivacyAgreeActivity$onPrivacyRefuse$1", f = "ObricPrivacyAgreeActivity.kt", i = {}, l = {207}, m = "invokeSuspend", n = {}, s = {})
final class ObricPrivacyAgreeActivity$onPrivacyRefuse$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ObricPrivacyAgreeActivity this$0;

    public ObricPrivacyAgreeActivity$onPrivacyRefuse$1(ObricPrivacyAgreeActivity r1, Continuation<? super ObricPrivacyAgreeActivity$onPrivacyRefuse$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        ObricPrivacyAgreeActivity$onPrivacyRefuse$1 r0 = new ObricPrivacyAgreeActivity$onPrivacyRefuse$1(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3, types: [android.content.Context, com.obric.assistant.privacy.activity.ObricPrivacyAgreeActivity, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v7 */
    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 != 1) goto L9;
        ObricPrivacyAgreeActivity r2 = (ObricPrivacyAgreeActivity) this.L$0;
        ResultKt.throwOnFailure(r4);     // Catch: Throwable -> L23
        ?? r3 = r2;
    L15:
        int r5 = ObricPrivacyAgreeActivity.n;     // Catch: Throwable -> L23
        r3.getClass();     // Catch: Throwable -> L23
        ISecPrivacyService.a.getClass();     // Catch: Throwable -> L23
        ISecPrivacyService r6 = ISecPrivacyService.a.a();     // Catch: Throwable -> L23
        if (r6 == null) goto L19;
        r6.b(r3);     // Catch: Throwable -> L23
    L19:
        if (r3.l == false) goto L21;
        Process.killProcess(Process.myPid());     // Catch: Throwable -> L23
    L21:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L23
    L26:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r4);
        CoroutineScope r7 = (CoroutineScope) this.L$0;
        ObricPrivacyAgreeActivity r8 = this.this$0;
        Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L23
        this.L$0 = r8;     // Catch: Throwable -> L23
        this.label = 1;     // Catch: Throwable -> L23
        if (DelayKt.delay(300, this) != r0) goto L14;
        return r0;
    L14:
        r3 = r8;
    L23:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L26
    }
}
