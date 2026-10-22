package fx0;

import com.bytedance.ies.web.jsbridge2.CallContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a extends com.bytedance.ies.web.jsbridge2.f<Object, Object> {
    public final void onTerminate() {
    }

    public a() {
    }

    public final void invoke(Object r2, CallContext r3) {
        Intrinsics.checkNotNullParameter(r2, "params");
        Intrinsics.checkNotNullParameter(r3, "context");
        xs2.b.a().post(new fw0.a());
    }
}
