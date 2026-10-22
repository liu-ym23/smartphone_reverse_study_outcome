package b3;

import android.util.Log;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import com.bytedance.monitor.collector.LockMonitorManager;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class g implements z2.g, jg.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ JSONObject f840a;

    public /* synthetic */ g(JSONObject r5) {
        this.f840a = r5;
    }

    public void a(List r10) {
        if (r10 != null) goto L5;
        return;
    L5:
        if (com.bytedance.apm.j.f3887a == false) goto L7;
        Log.d("LockMonitorManager", "dumpLockInfo size -> " + r10.size());
    L7:
        Iterator r11 = r10.iterator();
    L9:
        if (r11.hasNext() == false) goto L22;
        jg.e r5 = (jg.e) r11.next();
        JSONObject r12 = LockMonitorManager.access$000(r5, this.f840a);     // Catch: Throwable -> L17
        if (r12 == null) goto L9;
        if (com.bytedance.apm.j.f3887a == false) goto L19;
        Log.d("LockMonitorManager", "lock report LockInfo: " + r5);     // Catch: Throwable -> L17
    L19:
        j6.c r13 = new j6.c("block_monitor", r5.f18327a, r12);     // Catch: Throwable -> L17
        r13.f18255c = true;     // Catch: Throwable -> L17
        i6.a.i().b(r13);     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        Log.e("LockMonitorManager", "onData: parse lock info failed: " + th.getLocalizedMessage());
        goto L9
    }

    @Override // z2.g
    public void b(z2.f r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
        JSONObject r10 = this.f840a;
        JSONObject r11 = r10.optJSONObject("category");
        if (r11 == null) goto L5;
        r5.f23387i = r11;
    L5:
        JSONObject r12 = r10.optJSONObject(LynxMonitorService.KEY_METRIC);
        if (r12 == null) goto L9;
        r5.f23388j = r12;
        return;
    }
}
