package z32;

import com.bytedance.android.livesdk.interactivity.api.monitorV2.business.InputConstantNode;
import com.bytedance.android.livesdk.interactivity.api.monitorV2.business.InputDescNode;
import com.bytedance.android.livesdk.interactivity.api.monitorV2.business.InputValueNode;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c extends a {
    public static final c b = null;

    static {
        b = new c();
    }

    public c() {
    }

    @JvmStatic
    public static final void b(InputValueNode r3) {
        Intrinsics.checkNotNullParameter(r3, "node");
        com.bytedance.android.livesdk.interactivity.api.monitorV2.a.f(b.a, r3.getValueNodeName(), 1);
    }

    @JvmStatic
    public static final void a(InputDescNode r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "node");
        Intrinsics.checkNotNullParameter(r2, "field");
        com.bytedance.android.livesdk.interactivity.api.monitorV2.a.c(b.a, r1.getDescNodeName(), r2);
    }

    @JvmStatic
    public static final void c(InputConstantNode r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "node");
        Intrinsics.checkNotNullParameter(r2, "value");
        com.bytedance.android.livesdk.interactivity.api.monitorV2.a.b(b.a, r1.getNodeName(), r2);
    }
}
