package com.larus.common.app_ops;

import android.app.SyncNotedAppOp;
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
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.common.app_ops.AppOpsUtil$init$callback$1$onSelfNoted$1", f = "AppOpsUtil.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class AppOpsUtil$init$callback$1$onSelfNoted$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<Throwable> $fullStackTrace;
    final /* synthetic */ SyncNotedAppOp $op;
    final /* synthetic */ Ref.ObjectRef<String> $serviceName;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public AppOpsUtil$init$callback$1$onSelfNoted$1(List<? extends Throwable> r1, SyncNotedAppOp r2, Ref.ObjectRef<String> r3, Continuation<? super AppOpsUtil$init$callback$1$onSelfNoted$1> r4) {
        this.$fullStackTrace = r1;
        this.$op = r2;
        this.$serviceName = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new AppOpsUtil$init$callback$1$onSelfNoted$1(this.$fullStackTrace, this.$op, this.$serviceName, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        String r0 = "";
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L24;
        ResultKt.throwOnFailure(r6);
        Ref.ObjectRef r7 = new Ref.ObjectRef();     // Catch: Exception -> L19
        r7.element = "";     // Catch: Exception -> L19
        List<Throwable> r1 = this.$fullStackTrace;     // Catch: Exception -> L19
        if (r1 == null) goto L8;
        r7.element = e.b(r1);     // Catch: Exception -> L19
    L8:
        String r2 = this.$op.getAttributionTag();     // Catch: Exception -> L19
        if (r2 == null) goto L17;
        Ref.ObjectRef<String> r3 = this.$serviceName;     // Catch: Exception -> L19
        c r4 = a.a.c(this.$op.getOp(), r2);     // Catch: Exception -> L19
        if (r4 == null) goto L16;
        String r5 = r4.c;     // Catch: Exception -> L19
        if (r5 == null) goto L16;
        r0 = r5;
    L16:
        r3.element = r0;     // Catch: Exception -> L19
    L17:
        JSONObject r8 = new JSONObject();     // Catch: Exception -> L19
        r8.put("opCode", this.$op.getOp());     // Catch: Exception -> L19
        r8.put("type", "onSelfNoted");     // Catch: Exception -> L19
        r8.put("message", r7.element);     // Catch: Exception -> L19
        r8.put("serviceName", this.$serviceName.element);     // Catch: Exception -> L19
        r8.put("dealType", 3);     // Catch: Exception -> L19
        a r9 = a.a;     // Catch: Exception -> L19
        r8.put("check_op", a.a(this.$op.getOp()));     // Catch: Exception -> L19
        a.j(r8);     // Catch: Exception -> L19
    L22:
        return Unit.INSTANCE;
    L19:
        e = move-exception;
        FLogger.a.e("AppOpsUtil", "err occur:" + e.getMessage());
        goto L22
    L24:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
