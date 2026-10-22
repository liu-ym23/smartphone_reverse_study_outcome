package com.bytedance.ai.bridge.protocol;

import android.content.Context;
import androidx.core.util.Consumer;
import androidx.room.f;
import com.bytedance.ai.utils.e;
import com.bytedance.vmsdk.jsbridge.JSModule;
import com.bytedance.vmsdk.jsbridge.b;
import com.bytedance.vmsdk.jsbridge.utils.JavaOnlyMap;
import com.bytedance.vmsdk.jsbridge.utils.ReadableMap;
import com.bytedance.vmsdk.worker.JsWorker;
import i2.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import l2.a;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000  2\u00020\u0001:\u0002!\"B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001b\u0010\f\u001a\u00020\u000b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u000f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\tH\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0019R\u0016\u0010\u001b\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\t0\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006#"}, d2 = {"Lcom/bytedance/ai/bridge/protocol/WorkerModule;", "Lcom/bytedance/vmsdk/jsbridge/JSModule;", "Landroid/content/Context;", "context", "", "param", "<init>", "(Landroid/content/Context;Ljava/lang/Object;)V", "Landroidx/core/util/Consumer;", "Lcom/bytedance/vmsdk/jsbridge/utils/ReadableMap;", "handle", "", "setMessageHandle", "(Landroidx/core/util/Consumer;)V", "message", "postMessage", "(Lcom/bytedance/vmsdk/jsbridge/utils/ReadableMap;)V", "Lcom/bytedance/vmsdk/jsbridge/utils/JavaOnlyMap;", "", "msgId", "sendMessage", "(Lcom/bytedance/vmsdk/jsbridge/utils/JavaOnlyMap;Ljava/lang/Long;)V", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "Ljava/lang/Object;", "Lcom/bytedance/vmsdk/worker/JsWorker;", "jsWorker", "Lcom/bytedance/vmsdk/worker/JsWorker;", "Ll2/a;", "remoteBridgeMessages", "Ll2/a;", "Companion", "i2/k", "WorkerReceiveMsgFunc", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class WorkerModule extends JSModule {
    public static final k Companion = null;
    public static final String NAME = "AppletBridgeModule";
    private final Context context;
    private JsWorker jsWorker;
    private final Object param;
    private final a remoteBridgeMessages;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ai/bridge/protocol/WorkerModule$WorkerReceiveMsgFunc;", "Lcom/bytedance/vmsdk/registry/a;", "Lcom/bytedance/vmsdk/jsbridge/utils/JavaOnlyMap;", "message", "", "onWorkerMessage", "(Lcom/bytedance/vmsdk/jsbridge/utils/JavaOnlyMap;)V", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface WorkerReceiveMsgFunc extends com.bytedance.vmsdk.registry.a {
        void onWorkerMessage(JavaOnlyMap r5);
    }

    static {
        Companion = new k();
    }

    public WorkerModule(Context r5, Object r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r10, "param");
        super(r5, r10);
        this.context = r5;
        this.param = r10;
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type com.bytedance.vmsdk.worker.JsWorker");
        this.jsWorker = (JsWorker) r10;
        this.remoteBridgeMessages = new a();
    }

    public static /* synthetic */ void a(Long r5, WorkerModule r10, JavaOnlyMap r11) {
        sendMessage$lambda$2(r5, r10, r11);
    }

    private static final void sendMessage$lambda$2(Long r5, WorkerModule r10, JavaOnlyMap r11) {
        if (r5 != null) goto L4;
    L8:
        ((WorkerReceiveMsgFunc) r10.jsWorker.getJavaScriptFunction(WorkerReceiveMsgFunc.class)).onWorkerMessage(r11);
        if (r5 != null) goto L11;
        return;
    L11:
        if (e.f2847a.get(r5) != null) goto L14;
        return;
    L14:
        throw new ClassCastException();
    L4:
        if (e.f2847a.get(r5) == null) goto L8;
        throw new ClassCastException();
    }

    public final Context getContext() {
        return this.context;
    }

    @b
    public final void postMessage(ReadableMap r5) {
        if (r5 == null) goto L5;
        this.remoteBridgeMessages.c(r5);
        return;
    }

    public final void sendMessage(JavaOnlyMap r5, Long r10) {
        Intrinsics.checkNotNullParameter(r5, "message");
        this.jsWorker.postOnJSRunner(new f(r10, 8, this, r5));
    }

    public final void setMessageHandle(Consumer<ReadableMap> r5) {
        Intrinsics.checkNotNullParameter(r5, "handle");
        this.remoteBridgeMessages.b(r5);
    }
}
