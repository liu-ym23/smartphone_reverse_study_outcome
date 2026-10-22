package kt1;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.service.IDiagnoseDataManager;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import java.util.LinkedList;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c implements IDiagnoseDataManager {
    public static volatile c i;
    public boolean a;
    public boolean b;
    public long c;
    public final LinkedList<JSONObject> d;
    public final LinkedList<JSONObject> e;
    public final LinkedList<JSONObject> f;
    public final LinkedList<JSONObject> g;
    public final LinkedList<JSONObject> h;

    public static c b() {
        if (i != null) goto L15;
        monitor-enter(c.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (i != null) goto L9;
        i = new c();     // Catch: Throwable -> L11
    L9:
        monitor-exit(c.class);     // Catch: Throwable -> L11
    L15:
        return i;
    }

    public c() {
        this.a = false;
        this.b = false;
        this.c = 300000;
        this.d = new LinkedList();
        this.e = new LinkedList();
        this.f = new LinkedList();
        this.g = new LinkedList();
        this.h = new LinkedList();
    }

    public final boolean isInit() {
        return this.a;
    }

    public final void addDiagnoseData(JSONObject r3) {
        int r0 = JSONObjectProtectorUtils.getInt(r3, "diagnoseDataType");     // Catch: Exception -> L43
        if (r0 != 0) goto L5;
        LinkedList<JSONObject> r1 = this.d;     // Catch: Exception -> L43
        monitor-enter(r1);     // Catch: Exception -> L43
        c(this.d, r3);     // Catch: Throwable -> L40
        monitor-exit(r1);     // Catch: Throwable -> L40
    L59:
        return;
    L40:
        th = move-exception;
        throw th;     // Catch: Exception -> L43
    L5:
        if (r0 != 1) goto L7;
        LinkedList<JSONObject> r2 = this.f;     // Catch: Exception -> L43
        monitor-enter(r2);     // Catch: Exception -> L43
        c(this.f, r3);     // Catch: Throwable -> L32
        monitor-exit(r2);     // Catch: Throwable -> L32
    L58:
        return;
    L32:
        th = move-exception;
        throw th;     // Catch: Exception -> L43
    L7:
        if (r0 != 2) goto L9;
        LinkedList<JSONObject> r4 = this.g;     // Catch: Exception -> L43
        monitor-enter(r4);     // Catch: Exception -> L43
        c(this.g, r3);     // Catch: Throwable -> L24
        monitor-exit(r4);     // Catch: Throwable -> L24
    L57:
        return;
    L24:
        th = move-exception;
        throw th;     // Catch: Exception -> L43
    L9:
        if (r0 != 3) goto L55;
        LinkedList<JSONObject> r5 = this.h;     // Catch: Exception -> L43
        monitor-enter(r5);     // Catch: Exception -> L43
        c(this.h, r3);     // Catch: Throwable -> L16
        monitor-exit(r5);     // Catch: Throwable -> L16
    L56:
        return;
    L16:
        th = move-exception;
        throw th;     // Catch: Exception -> L43
    L55:
        return;
    L43:
        e = move-exception;
        ALogger.e("DiagnoseIDiagnoseDataManager", e);
    }

    public final void c(LinkedList<JSONObject> r10, JSONObject r11) {
        long r1 = System.currentTimeMillis();     // Catch: Exception -> L15
        r11.put("addTime", r1);     // Catch: Exception -> L15
        boolean r3 = false;
    L5:
        if (r10.isEmpty() == true) goto L13;
        if (r3 == true) goto L13;
        JSONObject r4 = r10.peek();     // Catch: Exception -> L15
        if (r4 == null) goto L12;
        if ((r1 - r4.optLong("addTime")) <= this.c) goto L12;
        r10.poll();     // Catch: Exception -> L15
    L12:
        r3 = true;
    L13:
        r10.add(r11);     // Catch: Exception -> L15
        return;
    L15:
        e = move-exception;
        ALogger.e("DiagnoseIDiagnoseDataManager", e);
    }
}
