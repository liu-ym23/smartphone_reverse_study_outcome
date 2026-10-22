package com.bytedance.ai.bridge.protocol;

import androidx.annotation.Keep;
import c1.b;
import com.bytedance.ai.applet.render.core.relax.RelaxBridgeModule;
import com.bytedance.ai.applet.render.core.relax.monitor.RelaxViewMonitorModule;
import com.relax.BackendWorker;
import i2.h;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\t\u0010\bR#\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0\n8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"com/bytedance/ai/bridge/protocol/RelaxWorkerAIBridgePort$RTSInterface", "", "<init>", "()V", "Lcom/relax/BackendWorker;", "relaxWorker", "", "initialize", "(Lcom/relax/BackendWorker;)V", "release", "Ljava/util/WeakHashMap;", "Lcom/bytedance/ai/applet/render/core/relax/RelaxBridgeModule;", "relaxWorkerToRelaxBridgeModule", "Ljava/util/WeakHashMap;", "getRelaxWorkerToRelaxBridgeModule", "()Ljava/util/WeakHashMap;", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class RelaxWorkerAIBridgePort$RTSInterface {
    public static final RelaxWorkerAIBridgePort$RTSInterface INSTANCE = null;
    private static final WeakHashMap<BackendWorker, RelaxBridgeModule> relaxWorkerToRelaxBridgeModule = null;

    static {
        INSTANCE = new RelaxWorkerAIBridgePort$RTSInterface();
        relaxWorkerToRelaxBridgeModule = new WeakHashMap();
    }

    private RelaxWorkerAIBridgePort$RTSInterface() {
    }

    public static /* synthetic */ void a(BackendWorker r5) {
        release$lambda$1(r5);
    }

    @JvmStatic
    public static final void initialize(BackendWorker r5) {
        Intrinsics.checkNotNullParameter(r5, "relaxWorker");
        WeakHashMap<BackendWorker, RelaxBridgeModule> r10 = relaxWorkerToRelaxBridgeModule;
        if (r10.get(r5) == null) goto L5;
        return;
    L5:
        RelaxBridgeModule r11 = new RelaxBridgeModule();
        r5.registerBridgeModule("AppletBridgeModule", r11);
        r5.registerBridgeModule("hybridMonitor", new RelaxViewMonitorModule(null));
        r10.put(r5, r11);
    }

    @JvmStatic
    public static final void release(final BackendWorker r5) {
        Intrinsics.checkNotNullParameter(r5, "relaxWorker");
        b.b(new h(r5));
    }

    private static final void release$lambda$1(BackendWorker r5) {
        relaxWorkerToRelaxBridgeModule.remove(r5);
    }

    public final WeakHashMap<BackendWorker, RelaxBridgeModule> getRelaxWorkerToRelaxBridgeModule() {
        return relaxWorkerToRelaxBridgeModule;
    }
}
