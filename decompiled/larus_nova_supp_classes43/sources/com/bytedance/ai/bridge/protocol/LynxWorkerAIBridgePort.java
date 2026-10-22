package com.bytedance.ai.bridge.protocol;

import androidx.core.util.Consumer;
import com.bytedance.ai.applet.render.core.lynx.a;
import com.bytedance.ai.bridge.protocol.model.ProtocolMessage;
import com.bytedance.ai.bridge.utils.ConvertUtils;
import com.bytedance.ai.utils.g;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import m4.c;
import m4.f;
import n4.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0016\u0010\n\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ai/bridge/protocol/LynxWorkerAIBridgePort;", "Lcom/bytedance/ai/bridge/protocol/AbsAIBridgePort;", "delegate", "Lcom/bytedance/ai/applet/render/core/lynx/BridgeMessageDelegate;", "<init>", "(Lcom/bytedance/ai/applet/render/core/lynx/BridgeMessageDelegate;)V", "realPostMessage", "", "messageWrapper", "Lcom/bytedance/ai/bridge/protocol/model/PostMessageWrapper;", "realSetOnMessageCallback", "consumer", "Landroidx/core/util/Consumer;", "Lcom/bytedance/ai/bridge/protocol/model/ReceiveMessageWrapper;", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LynxWorkerAIBridgePort extends c {
    private final a delegate;

    public static /* synthetic */ void c(LynxWorkerAIBridgePort r0, Consumer r1, ReadableMap r10) {
        realSetOnMessageCallback$lambda$6(r0, r1, r10);
    }

    public LynxWorkerAIBridgePort(a r10) {
        Intrinsics.checkNotNullParameter(r10, "delegate");
        this.delegate = r10;
    }

    @Override // m4.c
    public void realPostMessage(n4.c r10) {
        Intrinsics.checkNotNullParameter(r10, "messageWrapper");
        Object r0 = null;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L9
        int r11 = ProtocolMessage.a;     // Catch: Throwable -> L9
        JsonObject r12 = ProtocolMessage.b.c(r10.a);     // Catch: Throwable -> L9
        if (r12 == null) goto L6;
        JavaOnlyMap r13 = ConvertUtils.toReactLynxJavaOnlyMap(r12);     // Catch: Throwable -> L9
    L7:
        Object r14 = Result.constructor-impl(r13);     // Catch: Throwable -> L9
    L11:
        Throwable r15 = Result.exceptionOrNull-impl(r14);
        if (r15 == null) goto L15;
        g.a.e("ai_bridge", "[WorkerAIBridgePort] post msg error with msg:" + r15.getMessage());
    L15:
        if (Result.isFailure-impl(r14) == false) goto L17;
        r14 = null;
    L17:
        JavaOnlyMap r16 = (JavaOnlyMap) r14;
        if (r16 != null) goto L20;
        r16 = new JavaOnlyMap();
    L20:
        a r17 = this.delegate;
        JsonObject r18 = r10.a.f();     // Catch: Throwable -> L29
        if (r18 == null) goto L26;
        JsonElement r19 = r18.get("msgId");     // Catch: Throwable -> L29
        if (r19 == null) goto L26;
        Long r20 = Long.valueOf(r19.getAsLong());     // Catch: Throwable -> L29
    L27:
        Object r21 = Result.constructor-impl(r20);     // Catch: Throwable -> L29
    L32:
        if (Result.isFailure-impl(r21) == true) goto L35;
        r0 = r21;
    L35:
        r17.sendMessage(r16, (Long) r0);
        return;
    L26:
        r20 = null;
    L29:
        th = move-exception;
        Result.Companion r22 = Result.Companion;
        r21 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L32
    L6:
        r13 = null;
    L9:
        th = move-exception;
        Result.Companion r23 = Result.Companion;
        r14 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    }

    @Override // m4.c
    public void realSetOnMessageCallback(final Consumer<d> r10) {
        Intrinsics.checkNotNullParameter(r10, "consumer");
        this.delegate.setMessageHandle(new m4.d(this, r10));
    }

    private static final void realSetOnMessageCallback$lambda$6(LynxWorkerAIBridgePort r10, Consumer r11, ReadableMap r12) {
        if (r10.isClosed().get() == false) goto L5;
        return;
    L5:
        long r13 = System.currentTimeMillis();
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L11
        int r15 = ProtocolMessage.a;     // Catch: Throwable -> L11
        Intrinsics.checkNotNull(r12);     // Catch: Throwable -> L11
        ProtocolMessage r16 = ProtocolMessage.b.a(f.b(r12));     // Catch: Throwable -> L11
        if (r16 != null) goto L9;
        return;
    L9:
        g.a.d("ai_bridge", "[WorkerAIBridgePort] receive msg from worker " + r16);     // Catch: Throwable -> L11
        d r17 = new d(r16);     // Catch: Throwable -> L11
        r17.b = r13;     // Catch: Throwable -> L11
        r11.accept(r17);     // Catch: Throwable -> L11
        Object r18 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L11
    L13:
        Throwable r19 = Result.exceptionOrNull-impl(r18);
        if (r19 == null) goto L19;
        g.a.e("ai_bridge", "[WorkerAIBridgePort] receive msg form worker error with msg:" + r19.getMessage());
        return;
    L19:
        return;
    L11:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        r18 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L13
    }
}
