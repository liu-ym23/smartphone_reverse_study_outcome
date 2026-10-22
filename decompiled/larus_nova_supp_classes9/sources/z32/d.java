package z32;

import com.bytedance.android.livesdk.interactivity.api.monitorV2.business.PSNoMessageValueNode;
import com.bytedance.android.livesdk.interactivity.api.settings.config.e0;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import r52.m3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d extends a {
    public static final e0 b = null;
    public static final d c = null;

    static {
        c = new d();
        b = (e0) m3.a.getValue();
    }

    public d() {
    }

    @JvmStatic
    public static final void a(PSNoMessageValueNode r3) {
        Intrinsics.checkNotNullParameter(r3, "node");
        if (b.c() == true) goto L5;
        return;
    L5:
        com.bytedance.android.livesdk.interactivity.api.monitorV2.a.f(c.a, r3.getValueNodeName(), 1);
    }
}
