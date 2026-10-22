package z32;

import com.bytedance.android.livesdk.interactivity.api.monitorV2.business.HighlevelNoMessageMonitorEnum;
import com.bytedance.android.livesdk.interactivity.api.settings.config.l;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import r52.r0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b extends a {
    public static final l b = null;
    public static final b c = null;

    static {
        c = new b();
        b = (l) r0.a.getValue();
    }

    public b() {
    }

    @JvmStatic
    public static final void a(HighlevelNoMessageMonitorEnum r3) {
        Intrinsics.checkNotNullParameter(r3, "node");
        if (b.c() == true) goto L5;
        return;
    L5:
        com.bytedance.android.livesdk.interactivity.api.monitorV2.a.f(c.a, r3.getValueNodeName(), 1);
    }
}
