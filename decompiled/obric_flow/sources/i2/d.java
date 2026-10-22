package i2;

import com.bytedance.ai.bridge.protocol.model.ProtocolMessage;
import com.bytedance.ai.bridge.utils.ConvertUtils;
import com.bytedance.ai.jsb.lynx.LynxWorkerModule;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.lynx.react.bridge.JavaOnlyMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LynxWorkerModule f17491c;

    public d(LynxWorkerModule r5) {
        Intrinsics.checkNotNullParameter(r5, "workerModule");
        this.f17491c = r5;
    }

    @Override // i2.c
    public final void b(a r5) {
        Intrinsics.checkNotNullParameter(r5, "consumer");
        a r10 = new a(this, r5, 1);
        this.f17491c.setMessageHandle(r10);
    }

    @Override // i2.c
    public final void d(j2.a r10) {
        Intrinsics.checkNotNullParameter(r10, "messageWrapper");
        Object r5 = null;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L6
        JsonObject r12 = com.lynx.tasm.utils.b.c((ProtocolMessage) r10.f22372b);     // Catch: Throwable -> L6
        if (r12 == null) goto L8;
        JavaOnlyMap r13 = ConvertUtils.toReactLynxJavaOnlyMap(r12);     // Catch: Throwable -> L6
    L9:
        Object r14 = Result.m124constructorimpl(r13);     // Catch: Throwable -> L6
    L12:
        Throwable r15 = Result.m127exceptionOrNullimpl(r14);
        if (r15 == null) goto L18;
        String r16 = "[WorkerAIBridgePort] post msg error with msg:" + r15.getMessage();
        Intrinsics.checkNotNullParameter("ai_bridge", "tag");
        t0.d r17 = com.bytedance.ai.utils.c.f2846a;
        if (r17 == null) goto L18;
        r17.e("ai_bridge", r16);
    L18:
        if (Result.m130isFailureimpl(r14) == false) goto L20;
        r14 = null;
    L20:
        JavaOnlyMap r18 = (JavaOnlyMap) r14;
        if (r18 != null) goto L42;
        r18 = new JavaOnlyMap();
    L42:
        JsonObject r19 = ((ProtocolMessage) r10.f22372b).f();     // Catch: Throwable -> L28
        if (r19 == null) goto L30;
        JsonElement r20 = r19.get("msgId");     // Catch: Throwable -> L28
        if (r20 == null) goto L30;
        Long r21 = Long.valueOf(r20.getAsLong());     // Catch: Throwable -> L28
    L31:
        Object r22 = Result.m124constructorimpl(r21);     // Catch: Throwable -> L28
    L35:
        if (Result.m130isFailureimpl(r22) == true) goto L38;
        r5 = r22;
    L38:
        this.f17491c.sendMessage(r18, (Long) r5);
        return;
    L30:
        r21 = null;
    L28:
        th = move-exception;
        Result.Companion r23 = Result.Companion;
        r22 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L35
    L8:
        r13 = null;
    L6:
        th = move-exception;
        Result.Companion r24 = Result.Companion;
        r14 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L12
    }
}
