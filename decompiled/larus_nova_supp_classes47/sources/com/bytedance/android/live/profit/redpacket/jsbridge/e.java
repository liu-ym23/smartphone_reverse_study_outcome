package com.bytedance.android.live.profit.redpacket.jsbridge;

import com.bytedance.android.scope.o;
import com.bytedance.ies.web.jsbridge2.g;
import io.reactivex.disposables.Disposable;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import wy0.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e implements wy0.f, o {
    public Disposable a;
    public final vy0.c b;

    public final void onStart() {
        this.a = this.b.O3(this);
    }

    public final void onStop() {
        Disposable r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("disposable");
    L5:
        r0.dispose();
    }

    public e(vy0.c r2) {
        Intrinsics.checkNotNullParameter(r2, "hybridService");
        this.b = r2;
    }

    @Override // wy0.f
    public final Map<String, com.bytedance.ies.web.jsbridge2.f.b> a(y6.c r2) {
        Intrinsics.checkNotNullParameter(r2, "manager");
        Intrinsics.checkNotNullParameter(r2, "manager");
        return MapsKt.emptyMap();
    }

    @Override // wy0.d
    public final Map<String, h<Object, ?>> c(y6.c r2) {
        Intrinsics.checkNotNullParameter(r2, "manager");
        return wy0.f.a.a(r2);
    }

    @Override // wy0.f
    public final Map<String, g<?, ?>> d(y6.c r2) {
        Intrinsics.checkNotNullParameter(r2, "manager");
        return MapsKt.mapOf(TuplesKt.to("sendRedEnvelopSuccess", new SendRedEnvelopSuccessMethod()));
    }

    @Override // wy0.d
    public final Map<String, g<Object, ?>> f(y6.c r2) {
        Intrinsics.checkNotNullParameter(r2, "manager");
        return wy0.f.a.b(r2);
    }
}
