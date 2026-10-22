package com.larus.doc.impl.operation;

import android.content.Context;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.doc.impl.operation.DocOpManager$deleteDoc$1$1", f = "DocOpManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class DocOpManager$deleteDoc$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ boolean $hasPermission;
    final /* synthetic */ Function0<Unit> $showDialog;
    int label;

    public DocOpManager$deleteDoc$1$1(boolean r1, Function0<Unit> r2, Context r3, Continuation<? super DocOpManager$deleteDoc$1$1> r4) {
        this.$hasPermission = r1;
        this.$showDialog = r2;
        this.$context = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new DocOpManager$deleteDoc$1$1(this.$hasPermission, this.$showDialog, this.$context, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L15;
        ResultKt.throwOnFailure(r5);
        if (this.$hasPermission == false) goto L11;
        FLogger.a.i("DocOpManager", "delete document has permission");
        this.$showDialog.invoke();     // Catch: Exception -> L9
    L13:
        return Unit.INSTANCE;
    L9:
        e = move-exception;
        FLogger.a.e("DocOpManager", "delete document error: " + e);
        goto L13
    L11:
        s r6 = s.a;
        Context r0 = this.$context;
        r6.getClass();
        s.s(r0, 2131901792);
        goto L13
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
