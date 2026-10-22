package vc2;

import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.live.core.utils.v;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a implements kf6.a {
    public final boolean a;
    public final String b;

    public final void debug(String r2, String r3) {
        Intrinsics.checkNotNullParameter("TimeCost", "tag");
        Intrinsics.checkNotNullParameter(r3, "message");
    }

    public a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "alias");
        this.b = r2;
        if (v.a() == true) goto L5;
    L7:
        boolean r3 = false;
    L8:
        this.a = r3;
        return;
    L5:
        if (((Boolean) l42.a.h.getValue()).booleanValue() == false) goto L7;
        r3 = true;
        goto L8
    }

    public final void error(String r3, Throwable r4) {
        Intrinsics.checkNotNullParameter("CoreEngine", "tag");
        Intrinsics.checkNotNullParameter(r3, "message");
        if (this.a == true) goto L7;
        SafetyGuard.a(null, r4, "Danmaku: " + this.b + " Exception");
        return;
    L7:
        throw new RuntimeException(r4);
    }
}
