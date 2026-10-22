package com.larus.common.app_ops;

import android.app.AsyncNotedAppOp;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.common.app_ops.AppOpsUtil$init$callback$1$onAsyncNoted$1", f = "AppOpsUtil.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class AppOpsUtil$init$callback$1$onAsyncNoted$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AsyncNotedAppOp $asyncOp;
    int label;

    public AppOpsUtil$init$callback$1$onAsyncNoted$1(AsyncNotedAppOp r1, Continuation<? super AppOpsUtil$init$callback$1$onAsyncNoted$1> r2) {
        this.$asyncOp = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new AppOpsUtil$init$callback$1$onAsyncNoted$1(this.$asyncOp, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L28;
        ResultKt.throwOnFailure(r9);
        Ref.ObjectRef r10 = new Ref.ObjectRef();     // Catch: Exception -> L23
        r10.element = "";     // Catch: Exception -> L23
        Ref.ObjectRef r3 = new Ref.ObjectRef();     // Catch: Exception -> L23
        r3.element = "";     // Catch: Exception -> L23
        Ref.ObjectRef r4 = new Ref.ObjectRef();     // Catch: Exception -> L23
        r4.element = "";     // Catch: Exception -> L23
        String r5 = this.$asyncOp.getAttributionTag();     // Catch: Exception -> L23
        if (r5 == null) goto L18;
        AsyncNotedAppOp r6 = this.$asyncOp;     // Catch: Exception -> L23
        if (Intrinsics.areEqual(r5, "busyTag") == false) goto L10;
        r10.element = "busyTag";     // Catch: Exception -> L23
        r3.element = "busyTag";     // Catch: Exception -> L23
        goto L18
    L10:
        c r1 = a.a.c(r6.getOp(), r5);     // Catch: Exception -> L23
        if (r1 != null) goto L13;
        r10.element = "nullTag";     // Catch: Exception -> L23
        r3.element = "nullTag";     // Catch: Exception -> L23
        goto L18
    L13:
        r10.element = r1.b;     // Catch: Exception -> L23
        List<? extends Throwable> r0 = r1.a;     // Catch: Exception -> L23
        if (r0 == null) goto L16;
        String r2 = "" + e.b(r0);     // Catch: Exception -> L23
    L17:
        r3.element = r2;     // Catch: Exception -> L23
        r4.element = r1.c;     // Catch: Exception -> L23
        goto L18
    L16:
        r2 = "";
    L18:
        JSONObject r7 = new JSONObject();     // Catch: Exception -> L23
        r7.put("opCode", this.$asyncOp.getOp());     // Catch: Exception -> L23
        r7.put("attributionTag", r10.element);     // Catch: Exception -> L23
        r7.put("message", this.$asyncOp.getMessage());     // Catch: Exception -> L23
        r7.put("type", "onAsyncNoted");     // Catch: Exception -> L23
        r7.put("asyncTime", this.$asyncOp.getTime());     // Catch: Exception -> L23
        r7.put("asyncuid", this.$asyncOp.getNotingUid());     // Catch: Exception -> L23
        a r8 = a.a;     // Catch: Exception -> L23
        r7.put("check_op", a.a(this.$asyncOp.getOp()));     // Catch: Exception -> L23
        if (Intrinsics.areEqual(r3.element, "") == true) goto L21;
        r7.put("asyncStack", r3.element);     // Catch: Exception -> L23
    L21:
        r7.put("serviceName", r4.element);     // Catch: Exception -> L23
        a.j(r7);     // Catch: Exception -> L23
    L26:
        return Unit.INSTANCE;
    L23:
        e = move-exception;
        FLogger.a.e("AppOpsUtil", "err occur:" + e.getMessage());
        goto L26
    L28:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
