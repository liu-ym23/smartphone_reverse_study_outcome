package com.bytedance.android.livesdk.dispatch.handler;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.livesdk.dispatch.DispatchContext;
import com.bytedance.android.livesdk.dispatch.utils.DispatchLogUtil;
import com.bytedance.android.livesdk.dispatch.utils.g;
import com.bytedance.android.livesdk.schema.interfaces.IBaseCallbackSchemaHandler;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class GeneralPathDispatchHandler implements a {
    public final Lazy a;
    public final String b;

    @Override // com.bytedance.android.livesdk.dispatch.handler.a
    public final void a(com.bytedance.android.livesdk.dispatch.a r2) {
        Intrinsics.checkNotNullParameter(r2, "card");
    }

    public GeneralPathDispatchHandler() {
        this.a = LazyKt.lazy(GeneralPathDispatchHandler$isDebug$2.INSTANCE);
        this.b = "DispatchInvokeException";
    }

    @Override // com.bytedance.android.livesdk.dispatch.handler.a
    public final void b(com.bytedance.android.livesdk.dispatch.a r6, IBaseCallbackSchemaHandler.SchemaCallback<String> r7, DispatchContext r8) {
        Intrinsics.checkNotNullParameter(r6, "card");
        Intrinsics.checkNotNullParameter(r8, "dispatchContext");
        Lazy r2 = DispatchLogUtil.a;     // Catch: Exception -> L14
        DispatchLogUtil.f(3, r6.a, r6.b, r8);     // Catch: Exception -> L14
        String r3 = r6.a;     // Catch: Exception -> L14
        String r4 = r6.b;     // Catch: Exception -> L14
        st1.a r5 = r8.getInstances().get(r3);     // Catch: Exception -> L14
        DispatchLogUtil.a("initClassInfo？   " + r5);     // Catch: Exception -> L14
        if (r5 == null) goto L8;
        Map<String, Function3<rt1.a, IBaseCallbackSchemaHandler.SchemaCallback<String>, String, Unit>> r1 = r5.a();     // Catch: Exception -> L14
        if (r1 == null) goto L8;
        Function3<rt1.a, IBaseCallbackSchemaHandler.SchemaCallback<String>, String, Unit> r9 = r1.get(r4);     // Catch: Exception -> L14
    L9:
        int r10 = g.a;     // Catch: Exception -> L14
        rt1.a r11 = new rt1.a(g.a.a(r6.c));     // Catch: Exception -> L14
        String r12 = r6.c.toString();     // Catch: Exception -> L14
        if (r9 == null) goto L12;
        Unit r13 = (Unit) r9.invoke(r11, r7, r12);     // Catch: Exception -> L14
    L12:
        DispatchLogUtil.a("invoke success,  schema 是 " + r12);     // Catch: Exception -> L14
        return;
    L8:
        r9 = null;
    L14:
        e = move-exception;
        Lazy r0 = DispatchLogUtil.a;
        DispatchLogUtil.f(101, r6.a, r6.b, r8);
        ALogger.e("GeneralPathHandler", "exception is " + e.toString());
        String r14 = this.b;
        SafetyGuard.a(r14, e, r14);
        if (((Boolean) this.a.getValue()).booleanValue() == true) goto L18;
        return;
    L18:
        throw e;
    }
}
