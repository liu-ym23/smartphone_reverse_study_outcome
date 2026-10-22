package com.bytedance.ai.applet.render.core.lynx;

import androidx.core.util.Consumer;
import com.bytedance.ai.bridge.protocol.model.ProtocolMessage;
import com.google.gson.JsonObject;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.LynxView;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0010\u0010\u0004\u001a\f\u0012\b\u0012\u00060\u0006j\u0002`\u00070\u0005¢\u0006\u0004\b\b\u0010\tJ\f\u0010\n\u001a\u00020\u000b*\u00020\fH\u0002J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0016\u0010\u0011\u001a\u00020\u000e2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0016J\b\u0010\u0015\u001a\u00020\u000eH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0004\u001a\f\u0012\b\u0012\u00060\u0006j\u0002`\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ai/applet/render/core/lynx/LynxAIBridgePort;", "Lcom/bytedance/ai/bridge/protocol/AbsAIBridgePort;", "lynxView", "Lcom/lynx/tasm/LynxView;", "remoteMessageCache", "Lcom/bytedance/ai/bridge/utils/CacheHandle;", "Lcom/lynx/react/bridge/ReadableMap;", "Lcom/bytedance/ai/applet/render/core/lynx/LynxReadableMap;", "<init>", "(Lcom/lynx/tasm/LynxView;Lcom/bytedance/ai/bridge/utils/CacheHandle;)V", "toMap", "Lcom/lynx/react/bridge/JavaOnlyMap;", "Lcom/bytedance/ai/bridge/protocol/model/ProtocolMessage;", "realPostMessage", "", "messageWrapper", "Lcom/bytedance/ai/bridge/protocol/model/PostMessageWrapper;", "realSetOnMessageCallback", "consumer", "Landroidx/core/util/Consumer;", "Lcom/bytedance/ai/bridge/protocol/model/ReceiveMessageWrapper;", com.bytedance.android.ec.core.event.a.VALUE_CLOSE, "applet-render-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LynxAIBridgePort extends m4.c {
    private final LynxView lynxView;
    private final s4.c<ReadableMap> remoteMessageCache;

    public static /* synthetic */ void c(Consumer r0, ReadableMap r1) {
        realSetOnMessageCallback$lambda$5(r0, r1);
    }

    @Override // m4.c
    public void close() {
        super.close();
        this.remoteMessageCache.a();
    }

    private final JavaOnlyMap toMap(ProtocolMessage r10) {
        int r0 = ProtocolMessage.a;
        JsonObject r11 = ProtocolMessage.b.c(r10);
        if (r11 == null) goto L6;
        return j.b(r11);
    L6:
        return new JavaOnlyMap();
    }

    @Override // m4.c
    public void realPostMessage(n4.c r10) {
        Intrinsics.checkNotNullParameter(r10, "messageWrapper");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        this.lynxView.sendGlobalEvent("__APPLET_BRIDGE__", JavaOnlyArray.of(new Object[]{toMap(r10.a)}));     // Catch: Throwable -> L5
        Object r11 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r12 = Result.exceptionOrNull-impl(r11);
        if (r12 == null) goto L13;
        com.bytedance.ai.applet.base.log.b r1 = com.bytedance.ai.applet.base.log.a.a;
        com.bytedance.ai.applet.base.log.a.b("ai_bridge", "[LynxAIBridgePort] post msg to lynx view error with msg:" + r12.getMessage(), null);
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    @Override // m4.c
    public void realSetOnMessageCallback(final Consumer<n4.d> r10) {
        Intrinsics.checkNotNullParameter(r10, "consumer");
        this.remoteMessageCache.d(new d(r10));
    }

    public LynxAIBridgePort(LynxView r10, s4.c<ReadableMap> r11) {
        Intrinsics.checkNotNullParameter(r10, "lynxView");
        Intrinsics.checkNotNullParameter(r11, "remoteMessageCache");
        this.lynxView = r10;
        this.remoteMessageCache = r11;
    }

    private static final void realSetOnMessageCallback$lambda$5(Consumer r10, ReadableMap r11) {
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L8
        long r13 = System.currentTimeMillis();     // Catch: Throwable -> L8
        int r14 = ProtocolMessage.a;     // Catch: Throwable -> L8
        ProtocolMessage r15 = ProtocolMessage.b.a(com.bytedance.ai.applet.base.gson.c.a().toJsonTree(r11.asHashMap()).getAsJsonObject());     // Catch: Throwable -> L8
        if (r15 != null) goto L6;
        return;
    L6:
        com.bytedance.ai.applet.base.log.b r16 = com.bytedance.ai.applet.base.log.a.a;     // Catch: Throwable -> L8
        com.bytedance.ai.applet.base.log.a.a("ai_bridge", "[LynxAIBridgePort] receive msg from lynx " + r15);     // Catch: Throwable -> L8
        n4.d r1 = new n4.d(r15);     // Catch: Throwable -> L8
        r1.b = r13;     // Catch: Throwable -> L8
        r10.accept(r1);     // Catch: Throwable -> L8
        Object r17 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r18 = Result.exceptionOrNull-impl(r17);
        if (r18 == null) goto L16;
        com.bytedance.ai.applet.base.log.b r19 = com.bytedance.ai.applet.base.log.a.a;
        com.bytedance.ai.applet.base.log.a.b("ai_bridge", "[LynxAIBridgePort] receive msg form lynx error with msg:" + r18.getMessage(), null);
        return;
    L16:
        return;
    L8:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        r17 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }
}
