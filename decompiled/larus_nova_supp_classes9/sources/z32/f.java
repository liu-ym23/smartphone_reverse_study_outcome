package z32;

import com.bytedance.android.livesdk.interactivity.api.monitorV2.business.PSRoomIndicatorNode;
import com.bytedance.android.livesdk.interactivity.api.monitorV2.business.PSRoomStatDescNode;
import com.bytedance.android.livesdk.interactivity.api.monitorV2.business.PSRoomStatValueNode;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f extends a {
    public static final f b = null;

    static {
        b = new f();
    }

    public f() {
    }

    @JvmStatic
    public static final void c(PSRoomStatValueNode r3) {
        Intrinsics.checkNotNullParameter(r3, "node");
        com.bytedance.android.livesdk.interactivity.api.monitorV2.a.f(b.a, r3.getValueNodeName(), 1);
    }

    @JvmStatic
    public static final void a(PSRoomStatDescNode r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "node");
        Intrinsics.checkNotNullParameter(r2, "field");
        com.bytedance.android.livesdk.interactivity.api.monitorV2.a.c(b.a, r1.getDescName(), r2);
    }

    @JvmStatic
    public static final void b(PSRoomIndicatorNode r1, long r2) {
        Intrinsics.checkNotNullParameter(r1, "indicator");
        com.bytedance.android.livesdk.interactivity.api.monitorV2.a.e(b.a, r1.getIndicatorName(), r2);
    }

    @JvmStatic
    public static final void d(PSRoomStatValueNode r1, long r2) {
        Intrinsics.checkNotNullParameter(r1, "node");
        com.bytedance.android.livesdk.interactivity.api.monitorV2.a.f(b.a, r1.getValueNodeName(), r2);
    }
}
