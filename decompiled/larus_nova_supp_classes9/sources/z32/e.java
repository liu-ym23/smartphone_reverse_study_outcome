package z32;

import com.bytedance.android.livesdk.interactivity.api.monitorV2.business.PSRealtimeIndicatorNode;
import com.bytedance.android.livesdk.interactivity.api.monitorV2.business.PSRealtimeValueNode;
import com.bytedance.android.livesdk.interactivity.service.monitor.EventName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e extends a {
    public static final e b = null;

    static {
        b = new e();
    }

    public e() {
    }

    @JvmStatic
    public static final void c(PSRealtimeValueNode r3) {
        Intrinsics.checkNotNullParameter(r3, "node");
        com.bytedance.android.livesdk.interactivity.api.monitorV2.a.f(b.a, r3.getValueNodeName(), 1);
    }

    @JvmStatic
    public static final void a(PSRealtimeIndicatorNode r1, long r2) {
        Intrinsics.checkNotNullParameter(r1, "indicator");
        com.bytedance.android.livesdk.interactivity.api.monitorV2.a.e(b.a, r1.getIndicatorNodeName(), r2);
    }

    @JvmStatic
    public static final void b(PSRealtimeIndicatorNode r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "indicator");
        EventName r0 = b.a;
        String r5 = r3.getIndicatorNodeName();
        if (r4 == false) goto L5;
        long r1 = 1;
    L6:
        com.bytedance.android.livesdk.interactivity.api.monitorV2.a.e(r0, r5, r1);
        return;
    L5:
        r1 = 0;
        goto L6
    }
}
