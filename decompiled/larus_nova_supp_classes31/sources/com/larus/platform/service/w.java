package com.larus.platform.service;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.applet.impl.f0;
import com.larus.camera.impl.utils.n;
import com.larus.camera.impl.utils.o;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class w implements com.larus.platform.api.u1 {
    public static final w a = null;
    public static final Lazy b = null;

    public w() {
    }

    static {
        a = new w();
        b = LazyKt.lazy(new v());
    }

    public static com.larus.platform.api.u1 e() {
        return (com.larus.platform.api.u1) b.getValue();
    }

    @Override // com.larus.platform.api.u1
    public final void b(Context r2, Map r3, n r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "sdkInfo");
        com.larus.platform.api.u1 r0 = e();
        if (r0 == null) goto L6;
        r0.b(r2, r3, r4);
        return;
    }

    @Override // com.larus.platform.api.u1
    public final void a(FragmentActivity r2, String r3, int r4, com.bytedance.applet.impl.e0 r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        com.larus.platform.api.u1 r0 = e();
        if (r0 == null) goto L6;
        r0.a(r2, r3, r4, r5);
        return;
    }

    @Override // com.larus.platform.api.u1
    public final void c(FragmentActivity r2, String r3, Map r4, f0 r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "sdkInfo");
        Intrinsics.checkNotNullParameter(r4, "extraInfo");
        com.larus.platform.api.u1 r0 = e();
        if (r0 == null) goto L6;
        r0.c(r2, r3, r4, r5);
        return;
    }

    @Override // com.larus.platform.api.u1
    public final void d(Context r2, String r3, String r4, o r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        com.larus.platform.api.u1 r0 = e();
        if (r0 == null) goto L6;
        r0.d(r2, r3, r4, r5);
        return;
    }
}
