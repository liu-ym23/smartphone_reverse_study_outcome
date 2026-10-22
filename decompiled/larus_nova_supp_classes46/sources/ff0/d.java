package ff0;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.api.trace.MultiTraceData$TraceBusiness;
import com.bytedance.android.live.liveinteract.api.trace.MultiTraceData$TraceEvent;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d {
    public static final d a = null;

    public d() {
    }

    static {
        a = new d();
    }

    public final void a(int r11, String r12, int r13, String r14, Map<String, String> r15) {
        Intrinsics.checkNotNullParameter(r12, "step");
        Intrinsics.checkNotNullParameter(r14, "statusMsg");
        ALogger.i("HamletAvatarTraceMonitor", "trace, step: " + r12 + ",statusCode: " + r13 + ", statusMsg: " + r14);
        MultiTraceData$TraceEvent r2 = null;
        if (((Boolean) vm2.d.L6.getValue(null, vm2.d.a[399(0x18f, float:5.59E-43)])).booleanValue() == true) goto L5;
        return;
    L5:
        JSONObject r8 = new JSONObject();
        if (r15 == null) goto L16;
        Set<String> r0 = r15.keySet();     // Catch: Exception -> L14
        if (r0 == null) goto L16;
        Iterator<T> r1 = r0.iterator();     // Catch: Exception -> L14
    L11:
        if (r1.hasNext() == false) goto L16;
        String r3 = (String) r1.next();     // Catch: Exception -> L14
        r8.put(r3, r15.get(r3));     // Catch: Exception -> L14
    L16:
        if (r11 != 1) goto L18;
        MultiTraceData$TraceEvent r16 = MultiTraceData$TraceEvent.GameAvatarStart;
    L22:
        r2 = r16;
    L23:
        MultiTraceData$TraceEvent r4 = r2;
        if (r4 == null) goto L31;
        int r17 = rd0.a.a;
        rd0.a.b(MultiTraceData$TraceBusiness.GameAvatar, r4, r12, r13, r14, r8, 64);
        return;
    L31:
        return;
    L18:
        if (r11 != 2) goto L23;
        r16 = MultiTraceData$TraceEvent.GameAvatarEnd;
        goto L22
    }
}
