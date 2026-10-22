package com.bytedance.ai.applet.render.core.relax;

import androidx.annotation.Keep;
import androidx.annotation.MainThread;
import com.relax.embedding.InvokeMethod;
import com.relax.embedding.module.NativeModuleCallback;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J)\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0007¢\u0006\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f0\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ai/applet/render/core/relax/RelaxBridgeModule;", "", "<init>", "()V", "", "method", "message", "Lcom/relax/embedding/module/NativeModuleCallback;", "callback", "", "postMessage", "(Ljava/lang/String;Ljava/lang/String;Lcom/relax/embedding/module/NativeModuleCallback;)V", "Ll2/a;", "Lcom/bytedance/ai/applet/render/core/relax/a;", "getNext", "()Ll2/a;", "Ljava/util/concurrent/atomic/AtomicReference;", "next", "Ljava/util/concurrent/atomic/AtomicReference;", "current", "Ll2/a;", "applet-render-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class RelaxBridgeModule {
    private l2.a current;
    private final AtomicReference<l2.a> next;

    public RelaxBridgeModule() {
        this.next = new AtomicReference(null);
    }

    @MainThread
    public final l2.a getNext() {
        AtomicReference<l2.a> r5 = this.next;
        l2.a r10 = new l2.a();
    L4:
        if (r5.compareAndSet(null, r10) == true) goto L5;
        if (r5.get() == null) goto L4;
        this.current = this.next.get();
        return this.next.getAndSet(null);
    L5:
        this.current = this.next.get();
        return this.next.get();
    }

    @InvokeMethod
    @Keep
    public final void postMessage(String r5, String r10, NativeModuleCallback r11) {
        Intrinsics.checkNotNullParameter(r5, "method");
        Intrinsics.checkNotNullParameter(r10, "message");
        a r12 = new a(r10, r11);
        l2.a r13 = this.current;
        if (r13 == null) goto L6;
        r13.c(r12);
        return;
    }
}
