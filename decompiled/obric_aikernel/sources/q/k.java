package q;

import android.os.IBinder;
import com.bytedance.apm.battery.BatteryExceptionListener;
import com.bytedance.crash.constants.Constants;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class k extends a<r.d> implements o.b {
    public k() {
        super("power");
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    private void q(Object[] r10) {
        k();
        if (k.a.G().J() == true) goto L5;
        return;
    L5:
        if (r10.length <= 7) goto L7;
        return;
    L7:
        if (r10.length >= 4) goto L10;
        return;
    L10:
        if (r10[0] != null) goto L12;
        return;
    L12:
        if ((r10[0] instanceof IBinder) == false) goto L36;
        int r11 = r10[0].hashCode();
        if (this.f12401e.containsKey(Integer.valueOf(r11)) == true) goto L25;
        r.d r12 = new r.d();
        if (r10[1] != null) goto L18;
        return;
    L18:
        if ((r10[1] instanceof Integer) == false) goto L30;
        r12.f12515e = ((Integer) r10[1]).intValue();
        if (r10[2] != null) goto L22;
        return;
    L22:
        if ((r10[2] instanceof String) == false) goto L32;
        r12.f12516f = (String) r10[2];
        r12.f12511b = -1;
    L28:
        r12.f12513d = Thread.currentThread().getStackTrace();
        r12.f12512c = Thread.currentThread().getName();
        r12.f12510a = System.currentTimeMillis();
        this.f12401e.put(Integer.valueOf(r11), r12);
        return;
    L32:
        return;
    L30:
        return;
    L25:
        r12 = (r.d) this.f12401e.get(Integer.valueOf(r11));
        if (r12 != null) goto L28;
        return;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    private void r(Object[] r10) {
        n();
        if (k.a.G().J() == true) goto L5;
        return;
    L5:
        if (r10.length == 2) goto L8;
        return;
    L8:
        if (r10[0] != null) goto L10;
        return;
    L10:
        if ((r10[0] instanceof IBinder) == false) goto L17;
        int r11 = r10[0].hashCode();
        r.d r12 = (r.d) this.f12401e.get(Integer.valueOf(r11));
        if (r12 == null) goto L18;
        r12.f12511b = System.currentTimeMillis();
        this.f12401e.put(Integer.valueOf(r11), r12);
        return;
    L18:
        return;
    }

    @Override // o.b
    public String c() {
        return "android.os.IPowerManager";
    }

    @Override // q.l
    public void e(p.b r10, b0.a r11) {
        if (h().equals(r11.f494d) == false) goto L9;
        boolean r12 = r11.k();
        long r13 = r11.a();
        if (r12 == false) goto L7;
        r10.r(r13);
        return;
    L7:
        r10.h(r13);
        return;
    }

    @Override // o.b
    public synchronized void invoke(Object r10, Method r11, Object[] r12) {
        monitor-enter(this);
        String r13 = r11.getName();     // Catch: Throwable -> L10 Exception -> L15
        if ("acquireWakeLock".equals(r13) == false) goto L7;
        q(r12);     // Catch: Throwable -> L10 Exception -> L15
    L16:
        goto L13
    L7:
        if ("releaseWakeLock".equals(r13) == false) goto L16;
        r(r12);     // Catch: Throwable -> L10 Exception -> L15
    L10:
        th = move-exception;
        throw th;
    L13:
        monitor-exit(this);
    }

    @Override // q.a
    protected void o(double r10, double r11) {
        if (r10 < l.a.g()) goto L5;
        int r12 = 17;
    L7:
        if (r11 < l.a.f()) goto L9;
        r12 = r12 | 18;
    L9:
        if (r12 != 0) goto L27;
        return;
    L27:
        JSONObject r13 = new JSONObject();     // Catch: Throwable -> L26
        r13.put("issue_type", r12).put("total_hold_time", r10).put("total_acquire_count", r11);     // Catch: Throwable -> L26
        ConcurrentHashMap<Integer, T> r14 = this.f12401e;     // Catch: Throwable -> L26
        if (r14 != 0) goto L14;
    L29:
        BatteryExceptionListener r15 = k.a.G().F();     // Catch: Throwable -> L25
        if (r15 == null) goto L23;
        r15.a(BatteryExceptionListener.IssueType.WAKELOCK, r13);     // Catch: Throwable -> L25
    L23:
        i0.b.b(r13, "battery_trace");     // Catch: Throwable -> L26
        x.a.p().e(new y.d("battery_trace", r13));     // Catch: Throwable -> L26
        return;
    L14:
        if (r14.size() <= 0) goto L29;
        JSONArray r16 = new JSONArray();     // Catch: Throwable -> L26
        Iterator r17 = this.f12401e.values().iterator();     // Catch: Throwable -> L26
    L17:
        if (r17.hasNext() == false) goto L19;
        r16.put(((r.d) r17.next()).b());     // Catch: Throwable -> L26
        goto L17
    L19:
        r13.put("detail", r16);     // Catch: Throwable -> L26
    L32:
        return;
    L5:
        r12 = 0;
        goto L7
    }

    @Override // q.a
    protected /* bridge */ /* synthetic */ void p(r.b r10, long r11) {
        s((r.d) r10, r11);
    }

    protected void s(r.d r10, long r11) {
        if (r11 >= l.a.c()) goto L13;
        return;
    L13:
        JSONObject r12 = new JSONObject();     // Catch: JSONException -> L12
        r12.put(Constants.EVENT_TYPE, "battery_trace");     // Catch: JSONException -> L12
        r12.put("issue_type", 16).put("single_hold_time", r11).put("wake_lock_info", r10.toString());     // Catch: JSONException -> L12
        BatteryExceptionListener r13 = k.a.G().F();     // Catch: Throwable -> L11
        if (r13 == null) goto L9;
        r13.a(BatteryExceptionListener.IssueType.WAKELOCK, r12);     // Catch: Throwable -> L11
    L9:
        i0.b.b(r12, "battery_trace");     // Catch: JSONException -> L12
        x.a.p().e(new y.d("battery_trace", r12));     // Catch: JSONException -> L12
        return;
    }
}
