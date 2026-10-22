package m4;

import androidx.core.util.Consumer;
import com.bytedance.ai.bridge.protocol.model.ProtocolMessage;
import com.google.gson.JsonObject;
import d3.b0;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public abstract class c {
    private static final String BRIDGE_READY_MESSAGE = "__bridge_ready__";
    public static final a Companion = null;
    private b0 bridge;
    private final AtomicBoolean isClosed;
    private final s4.c<n4.c> localMessageCache;
    private volatile Function0<Unit> remoteReadyListener;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ void a(c r0, Consumer r1, n4.d r10) {
        setOnMessageCallback$lambda$0(r0, r1, r10);
    }

    public static /* synthetic */ void b(c r0, n4.c r1) {
        onRemoteReady$lambda$3(r0, r1);
    }

    public abstract void realPostMessage(n4.c r1);

    public abstract void realSetOnMessageCallback(Consumer<n4.d> r1);

    public void close() {
        this.localMessageCache.a();
        this.isClosed.compareAndSet(false, true);
    }

    public void onRemoteReady() {
        com.bytedance.ai.applet.base.log.b r0 = com.bytedance.ai.applet.base.log.a.a;
        com.bytedance.ai.applet.base.log.a.a("ai_bridge", "[" + getClass().getSimpleName() + "] remoteReady");
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L9
        Function0<Unit> r11 = this.remoteReadyListener;     // Catch: Throwable -> L9
        if (r11 == null) goto L6;
        r11.invoke();     // Catch: Throwable -> L9
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L9
    L7:
        Object r13 = Result.constructor-impl(r12);     // Catch: Throwable -> L9
    L11:
        Throwable r14 = Result.exceptionOrNull-impl(r13);
        if (r14 == null) goto L14;
        com.bytedance.ai.applet.base.log.b r15 = com.bytedance.ai.applet.base.log.a.a;
        com.bytedance.ai.applet.base.log.a.b("ai_bridge", "[" + getClass().getSimpleName() + "] remote ready listener failed: " + r14.getMessage(), null);
    L14:
        this.localMessageCache.d(new m4.a(this));
        return;
    L6:
        r12 = null;
    L9:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    }

    public c() {
        this.isClosed = new AtomicBoolean(false);
        this.localMessageCache = new s4.c();
    }

    public final b0 getBridge$applet_bridge_release() {
        return this.bridge;
    }

    public final AtomicBoolean isClosed() {
        return this.isClosed;
    }

    public final com.bytedance.ai.bridge.core.a<JsonObject> handleSyncMessage(JsonObject r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_MSG);
        if (this.isClosed.get() == false) goto L6;
        int r11 = com.bytedance.ai.bridge.core.a.a;
        return com.bytedance.ai.bridge.core.a.C0020a.a(0, "port is already closed");
    L6:
        b0 r0 = this.bridge;
        if (r0 != null) goto L11;
        int r12 = com.bytedance.ai.bridge.core.a.a;
        return com.bytedance.ai.bridge.core.a.C0020a.a(0, "bridge is not initialized");
    L11:
        return r0.b(r10);
    }

    public final void postMessage$applet_bridge_release(n4.c r10) {
        Intrinsics.checkNotNullParameter(r10, "messageWrapper");
        n4.b r0 = r10.b;
        if (r0 == null) goto L5;
        r0.a();
    L5:
        this.localMessageCache.b(r10);
    }

    public final void setBridge$applet_bridge_release(b0 r1) {
        this.bridge = r1;
    }

    public final void setOnMessageCallback$applet_bridge_release(final Consumer<n4.d> r10) {
        Intrinsics.checkNotNullParameter(r10, "consumer");
        realSetOnMessageCallback(new b(this, r10));
    }

    public final void setRemoteReadyListener(Function0<Unit> r1) {
        this.remoteReadyListener = r1;
    }

    private static final void onRemoteReady$lambda$3(c r10, n4.c r11) {
        if (r10.isClosed.get() == false) goto L5;
        return;
    L5:
        com.bytedance.ai.applet.base.log.b r0 = com.bytedance.ai.applet.base.log.a.a;
        com.bytedance.ai.applet.base.log.a.a("ai_bridge", "[" + r10.getClass().getSimpleName() + "] post msg to view " + r11.a);
        n4.b r1 = r11.b;
        if (r1 == null) goto L8;
        r1.b();
    L8:
        Intrinsics.checkNotNull(r11);
        r10.realPostMessage(r11);
    }

    private static final void setOnMessageCallback$lambda$0(c r10, Consumer r11, n4.d r12) {
        ProtocolMessage r0 = r12.a;
        if (r0.getType() == ProtocolMessage.Type.Event) goto L5;
    L8:
        r11.accept(r12);
        return;
    L5:
        if (Intrinsics.areEqual(r0.e(), BRIDGE_READY_MESSAGE) == false) goto L8;
        r10.onRemoteReady();
    }
}
