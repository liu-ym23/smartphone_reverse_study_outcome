package com.bytedance.ai.jsb.lynx;

import android.content.Context;
import androidx.core.util.Consumer;
import com.lynx.base.log.LynxLog;
import com.lynx.jsbridge.LynxModule;
import com.lynx.jsbridge.n;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.LynxBackgroundRuntime;
import com.lynx.tasm.core.JSProxy;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import l2.a;
import v2.b;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001fB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\r\u001a\u00020\f2\u0010\u0010\u000b\u001a\f\u0012\b\u0012\u00060\tj\u0002`\n0\b¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0010\u001a\u00020\f2\u000e\u0010\u000f\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\nH\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0015\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0018\u001a\f\u0012\b\u0012\u00060\tj\u0002`\n0\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001d\u001a\u00020\u001a8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c¨\u0006 "}, d2 = {"Lcom/bytedance/ai/jsb/lynx/LynxWorkerModule;", "Lcom/lynx/jsbridge/LynxModule;", "Landroid/content/Context;", "context", "", "param", "<init>", "(Landroid/content/Context;Ljava/lang/Object;)V", "Landroidx/core/util/Consumer;", "Lcom/lynx/react/bridge/ReadableMap;", "Lcom/bytedance/ai/applet/render/core/lynx/LynxReadableMap;", "handle", "", "setMessageHandle", "(Landroidx/core/util/Consumer;)V", "message", "postMessage", "(Lcom/lynx/react/bridge/ReadableMap;)V", "Lcom/lynx/react/bridge/JavaOnlyMap;", "", "msgId", "sendMessage", "(Lcom/lynx/react/bridge/JavaOnlyMap;Ljava/lang/Long;)V", "Ll2/a;", "remoteBridgeMessages", "Ll2/a;", "Lcom/lynx/tasm/LynxBackgroundRuntime;", "getWorker", "()Lcom/lynx/tasm/LynxBackgroundRuntime;", "worker", "Companion", "v2/b", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LynxWorkerModule extends LynxModule {
    public static final b Companion = null;
    public static final String NAME = "AppletBridgeModule";
    private final a remoteBridgeMessages;

    static {
        Companion = new b();
    }

    public LynxWorkerModule(Context r5, Object r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r10, "param");
        super(r5, r10);
        this.remoteBridgeMessages = new a();
    }

    private final LynxBackgroundRuntime getWorker() {
        Object r5 = this.mParam;
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type com.lynx.tasm.LynxBackgroundRuntime");
        return (LynxBackgroundRuntime) r5;
    }

    @n
    public final void postMessage(ReadableMap r5) {
        if (r5 == null) goto L5;
        this.remoteBridgeMessages.c(r5);
        return;
    }

    public final void sendMessage(JavaOnlyMap r5, Long r10) {
        Intrinsics.checkNotNullParameter(r5, "message");
        LynxBackgroundRuntime r11 = getWorker();
        JavaOnlyArray r12 = new JavaOnlyArray(Arrays.asList(new Object[]{r5}));
        r11.getClass();
        LynxLog.b(2, "LynxBackgroundRuntime", "LynxContext sendGlobalEvent __APPLET_BRIDGE__ with this: " + r11.toString());
        JSProxy r13 = r11.f9960b;
        r13.getClass();
        JavaOnlyArray r14 = new JavaOnlyArray();
        r14.pushString("__APPLET_BRIDGE__");
        r14.pushArray(r12);
        r13.f("GlobalEventEmitter", r14);
    }

    public final void setMessageHandle(Consumer<ReadableMap> r5) {
        Intrinsics.checkNotNullParameter(r5, "handle");
        this.remoteBridgeMessages.b(r5);
    }
}
