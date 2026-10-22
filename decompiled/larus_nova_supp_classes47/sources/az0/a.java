package az0;

import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.ies.web.jsbridge2.f;
import com.bytedance.ies.web.jsbridge2.g;
import kotlin.jvm.internal.Intrinsics;
import wy0.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a implements e {
    public final y6.c a;

    public a(y6.c r2) {
        Intrinsics.checkNotNullParameter(r2, "originalManager");
        this.a = r2;
    }

    @Override // wy0.e
    public final void registerMethod(String r2, f.b r3) {
        Intrinsics.checkNotNullParameter(r2, "name");
        Intrinsics.checkNotNullParameter(r3, "methodProvider");
        this.a.registerMethod(r2, r3);
    }

    @Override // wy0.e
    public final void sendJsEvent(String r2, Object r3) {
        Intrinsics.checkNotNullParameter("rpcChannelMessage", "name");
        Intrinsics.checkNotNullParameter(r3, Constants.Keys.DATA);
        this.a.sendJSEvent("rpcChannelMessage", r3);
    }

    @Override // wy0.e
    public final void registerMethod(String r2, g<?, ?> r3) {
        Intrinsics.checkNotNullParameter(r2, "name");
        Intrinsics.checkNotNullParameter(r3, "method");
        this.a.registerMethod(r2, r3);
    }
}
