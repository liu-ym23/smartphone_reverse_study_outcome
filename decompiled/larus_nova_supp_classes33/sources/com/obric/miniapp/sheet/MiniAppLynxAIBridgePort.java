package com.obric.miniapp.sheet;

import androidx.core.util.Consumer;
import com.bytedance.ai.bridge.protocol.model.ProtocolMessage;
import com.bytedance.ai.bridge.utils.ConvertUtils;
import com.google.gson.JsonObject;
import com.larus.utils.logger.FLogger;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0010\u0010\u0004\u001a\f\u0012\b\u0012\u00060\u0006j\u0002`\u00070\u0005¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u000bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0004\u001a\f\u0012\b\u0012\u00060\u0006j\u0002`\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/obric/miniapp/sheet/MiniAppLynxAIBridgePort;", "Lcom/bytedance/ai/bridge/protocol/AbsAIBridgePort;", "lynxView", "Lcom/bytedance/ai/lynx/AppletLynxView;", "remoteMessageCache", "Lcom/bytedance/ai/bridge/utils/CacheHandle;", "Lcom/lynx/react/bridge/ReadableMap;", "Lcom/bytedance/ai/utils/LynxReadableMap;", "<init>", "(Lcom/bytedance/ai/lynx/AppletLynxView;Lcom/bytedance/ai/bridge/utils/CacheHandle;)V", "realSetOnMessageCallback", "", "consumer", "Landroidx/core/util/Consumer;", "Lcom/bytedance/ai/bridge/protocol/model/ReceiveMessageWrapper;", "realPostMessage", "messageWrapper", "Lcom/bytedance/ai/bridge/protocol/model/PostMessageWrapper;", "close", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MiniAppLynxAIBridgePort extends m4.c {
    private final com.bytedance.ai.lynx.g lynxView;
    private final s4.c<ReadableMap> remoteMessageCache;

    public static /* synthetic */ void c(Consumer r0, ReadableMap r1) {
        realSetOnMessageCallback$lambda$3(r0, r1);
    }

    public void close() {
        super.close();
        this.remoteMessageCache.a();
    }

    public void realPostMessage(n4.c r7) {
        Intrinsics.checkNotNullParameter(r7, "messageWrapper");
        Object r0 = null;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L9
        int r2 = ProtocolMessage.a;     // Catch: Throwable -> L9
        JsonObject r8 = ProtocolMessage.b.c(((n4.a) r7).a);     // Catch: Throwable -> L9
        if (r8 == null) goto L6;
        JavaOnlyMap r9 = ConvertUtils.toReactLynxJavaOnlyMap(r8);     // Catch: Throwable -> L9
    L7:
        Object r10 = Result.constructor-impl(r9);     // Catch: Throwable -> L9
    L11:
        Throwable r3 = Result.exceptionOrNull-impl(r10);
        if (r3 == null) goto L15;
        FLogger.a.e("ai_bridge", "[MiniAppLynxAIBridgePort] post msg error with msg:" + r3.getMessage());
    L15:
        if (Result.isFailure-impl(r10) == true) goto L18;
        r0 = r10;
    L18:
        JavaOnlyMap r4 = (JavaOnlyMap) r0;
        if (r4 != null) goto L29;
        r4 = new JavaOnlyMap();
    L29:
        this.lynxView.sendGlobalEvent("__APPLET_BRIDGE__", JavaOnlyArray.of(new Object[]{r4}));     // Catch: Throwable -> L23
        Object r11 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L23
    L25:
        Throwable r12 = Result.exceptionOrNull-impl(r11);
        if (r12 == null) goto L33;
        FLogger.a.e("ai_bridge", "[MiniAppLynxAIBridgePort] sendGlobalEvent error with msg:" + r12.getMessage());
        return;
    L33:
        return;
    L23:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L25
    L6:
        r9 = null;
    L9:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    }

    public void realSetOnMessageCallback(final Consumer<n4.d> r3) {
        Intrinsics.checkNotNullParameter(r3, "consumer");
        this.remoteMessageCache.d(new a(r3));
    }

    public MiniAppLynxAIBridgePort(com.bytedance.ai.lynx.g r2, s4.c<ReadableMap> r3) {
        Intrinsics.checkNotNullParameter(r2, "lynxView");
        Intrinsics.checkNotNullParameter(r3, "remoteMessageCache");
        this.lynxView = r2;
        this.remoteMessageCache = r3;
    }

    private static final void realSetOnMessageCallback$lambda$3(Consumer r3, ReadableMap r4) {
        Intrinsics.checkNotNullParameter(r4, "it");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L8
        int r1 = ProtocolMessage.a;     // Catch: Throwable -> L8
        ProtocolMessage r5 = ProtocolMessage.b.a(m4.f.b(r4));     // Catch: Throwable -> L8
        if (r5 != null) goto L6;
        return;
    L6:
        n4.d r2 = new n4.d(r5);     // Catch: Throwable -> L8
        r2.b = System.currentTimeMillis();     // Catch: Throwable -> L8
        r3.accept(r2);     // Catch: Throwable -> L8
        Object r6 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r7 = Result.exceptionOrNull-impl(r6);
        if (r7 == null) goto L16;
        FLogger.a.e("ai_bridge", "[MiniAppLynxAIBridgePort] receive msg error with msg:" + r7.getMessage());
        return;
    L16:
        return;
    L8:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }
}
