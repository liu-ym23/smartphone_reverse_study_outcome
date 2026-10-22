package rqb;

import com.ss.android.lark.lynxkit.bridge.LarkLynxBridgeCallContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c implements LarkLynxBridgeCallContext {
    public final String a;
    public final Function1<Class<?>, Object> b;

    @Override // com.ss.android.lark.lynxkit.bridge.LarkLynxBridgeCallContext
    public final String getCallId() {
        return this.a;
    }

    @Override // com.ss.android.lark.lynxkit.bridge.LarkLynxBridgeCallContext
    public final <T> T getService(Class<T> r2) {
        Intrinsics.checkNotNullParameter(r2, "clazz");
        T r3 = (T) this.b.invoke(r2);
        if (r3 != null) goto L6;
        return null;
    L6:
        return r3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(String r2, Function1<? super Class<?>, ? extends Object> r3) {
        Intrinsics.checkNotNullParameter(r2, "callId");
        Intrinsics.checkNotNullParameter(r3, "serviceProvider");
        this.a = r2;
        this.b = r3;
    }
}
