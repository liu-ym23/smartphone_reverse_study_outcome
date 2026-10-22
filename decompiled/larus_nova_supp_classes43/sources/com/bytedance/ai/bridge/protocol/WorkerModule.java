package com.bytedance.ai.bridge.protocol;

import android.content.Context;
import androidx.core.util.Consumer;
import com.bytedance.ai.utils.j;
import com.bytedance.vmsdk.jsbridge.JSMethod;
import com.bytedance.vmsdk.jsbridge.JSModule;
import com.bytedance.vmsdk.jsbridge.utils.JavaOnlyMap;
import com.bytedance.vmsdk.jsbridge.utils.ReadableMap;
import com.bytedance.vmsdk.worker.JsWorker;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import m4.h;
import s4.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u0000 \u001a2\u00020\u0001:\u0002\u001a\u001bB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0014\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0012J\u0012\u0010\u0013\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u000eH\u0007J\u001d\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\u0002\u0010\u0019R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/bytedance/ai/bridge/protocol/WorkerModule;", "Lcom/bytedance/vmsdk/jsbridge/JSModule;", "context", "Landroid/content/Context;", "param", "", "<init>", "(Landroid/content/Context;Ljava/lang/Object;)V", "getContext", "()Landroid/content/Context;", "jsWorker", "Lcom/bytedance/vmsdk/worker/JsWorker;", "remoteBridgeMessages", "Lcom/bytedance/ai/bridge/utils/CacheHandle;", "Lcom/bytedance/vmsdk/jsbridge/utils/ReadableMap;", "setMessageHandle", "", "handle", "Landroidx/core/util/Consumer;", "postMessage", com.bytedance.android.ec.core.event.a.KEY_MSG, "sendMessage", "Lcom/bytedance/vmsdk/jsbridge/utils/JavaOnlyMap;", "msgId", "", "(Lcom/bytedance/vmsdk/jsbridge/utils/JavaOnlyMap;Ljava/lang/Long;)V", "Companion", "WorkerReceiveMsgFunc", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WorkerModule extends JSModule {
    public static final a Companion = null;
    public static final String NAME = "AppletBridgeModule";
    private final Context context;
    private JsWorker jsWorker;
    private final Object param;
    private final c<ReadableMap> remoteBridgeMessages;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ai/bridge/protocol/WorkerModule$WorkerReceiveMsgFunc;", "Lcom/bytedance/vmsdk/registry/JavaScriptFunction;", "onWorkerMessage", "", com.bytedance.android.ec.core.event.a.KEY_MSG, "Lcom/bytedance/vmsdk/jsbridge/utils/JavaOnlyMap;", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface WorkerReceiveMsgFunc extends com.bytedance.vmsdk.registry.a {
        void onWorkerMessage(JavaOnlyMap r1);
    }

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ void a(Long r0, WorkerModule r1, JavaOnlyMap r10) {
        sendMessage$lambda$2(r0, r1, r10);
    }

    public final Context getContext() {
        return this.context;
    }

    @JSMethod
    public final void postMessage(ReadableMap r10) {
        if (r10 == null) goto L5;
        this.remoteBridgeMessages.b(r10);
        return;
    }

    public final void setMessageHandle(Consumer<ReadableMap> r10) {
        Intrinsics.checkNotNullParameter(r10, "handle");
        this.remoteBridgeMessages.d(r10);
    }

    public WorkerModule(Context r10, Object r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "param");
        super(r10, r11);
        this.context = r10;
        this.param = r11;
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type com.bytedance.vmsdk.worker.JsWorker");
        this.jsWorker = (JsWorker) r11;
        this.remoteBridgeMessages = new c();
    }

    public final void sendMessage(final JavaOnlyMap r10, final Long r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_MSG);
        this.jsWorker.postOnJSRunner(new h(r11, this, r10));
    }

    private static final void sendMessage$lambda$2(Long r1, WorkerModule r10, JavaOnlyMap r11) {
        if (r1 == null) goto L8;
        r1.longValue();
        j.a r0 = j.b(r1);
        if (r0 == null) goto L8;
        j.c r12 = r0.o;
        if (r12 == null) goto L8;
        r12.a();
    L8:
        ((WorkerReceiveMsgFunc) r10.jsWorker.getJavaScriptFunction(WorkerReceiveMsgFunc.class)).onWorkerMessage(r11);
        if (r1 == null) goto L16;
        r1.longValue();
        j.a r13 = j.b(r1);
        if (r13 == null) goto L17;
        j.c r14 = r13.p;
        if (r14 == null) goto L18;
        r14.a();
        return;
    L18:
        return;
    L17:
        return;
    }
}
