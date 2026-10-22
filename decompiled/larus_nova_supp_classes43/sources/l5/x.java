package l5;

import com.bytedance.ai.monitor.AppletMonitorableEvent;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class x implements k5.j {
    public final /* synthetic */ JSONObject a;

    public x(JSONObject r1) {
        this.a = r1;
    }

    @Override // k5.j
    public final void a(AppletMonitorableEvent r10) {
        Intrinsics.checkNotNullParameter(r10, "event");
        JSONObject r0 = this.a.optJSONObject(com.bytedance.android.ec.core.event.a.KEY_LUBAN_CATEGORY);
        if (r0 == null) goto L5;
        r10.i = r0;
    L5:
        JSONObject r1 = this.a.optJSONObject("metric");
        if (r1 == null) goto L9;
        r10.j = r1;
        return;
    }
}
