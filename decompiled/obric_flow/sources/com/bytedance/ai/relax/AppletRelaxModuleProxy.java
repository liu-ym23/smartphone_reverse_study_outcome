package com.bytedance.ai.relax;

import androidx.annotation.Keep;
import c3.d;
import com.relax.embedding.InvokeMethod;
import com.relax.embedding.module.NativeModuleCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J)\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0007¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ai/relax/AppletRelaxModuleProxy;", "", "Lc3/d;", "proxy", "<init>", "(Lc3/d;)V", "", "method", "message", "Lcom/relax/embedding/module/NativeModuleCallback;", "callback", "", "postMessage", "(Ljava/lang/String;Ljava/lang/String;Lcom/relax/embedding/module/NativeModuleCallback;)V", "proxyInterface", "Lc3/d;", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AppletRelaxModuleProxy {
    private final d proxyInterface;

    public AppletRelaxModuleProxy(d r5) {
        Intrinsics.checkNotNullParameter(r5, "proxy");
    }

    @InvokeMethod
    @Keep
    public final void postMessage(String r5, String r10, NativeModuleCallback r11) {
        Intrinsics.checkNotNullParameter(r5, "method");
        Intrinsics.checkNotNullParameter(r10, "message");
        throw null;
    }
}
