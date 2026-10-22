package q;

import android.text.TextUtils;
import com.bytedance.apm.battery.BatteryExceptionListener;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class g extends a<r.c> implements o.b {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private List<String> f12412k;

    public g() {
        super("location");
        this.f12412k = new ArrayList();
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    private void q(Object[] r10) {
        if (r10[0] == null) goto L13;
        int r11 = r10[0].hashCode();
        String r12 = String.valueOf(r11);
        if (this.f12412k.contains(r12) == false) goto L8;
        n();
        this.f12412k.remove(r12);
    L8:
        if (k.a.G().J() == false) goto L14;
        r.c r13 = (r.c) this.f12401e.get(Integer.valueOf(r11));
        if (r13 == null) goto L15;
        r13.f12511b = System.currentTimeMillis();
        this.f12401e.put(Integer.valueOf(r11), r13);
        return;
    L15:
        return;
    L14:
        return;
    }

    private void r(Object[] r10) {
        if (r10[0] != null) goto L5;
        return;
    L5:
        if (r10[1] == null) goto L9;
        t(r10[1].hashCode(), r10[0].toString());
        return;
    }

    private void s(Object[] r10) {
        if (r10[1] != null) goto L5;
        return;
    L5:
        if (r10[2] == null) goto L9;
        t(r10[2].hashCode(), r10[1].toString());
        return;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    private void t(int r10, String r11) {
        String r12 = String.valueOf(r10);
        if (this.f12412k.contains(r12) == true) goto L6;
        k();
        this.f12412k.add(r12);
    L6:
        if (k.a.G().J() == false) goto L12;
        r.c r13 = (r.c) this.f12401e.get(Integer.valueOf(r10));
        if (r13 != null) goto L10;
        r13 = new r.c();
        r13.f12514e = r11;
    L10:
        r13.f12510a = System.currentTimeMillis();
        r13.f12511b = -1;
        r13.f12513d = Thread.currentThread().getStackTrace();
        r13.f12512c = Thread.currentThread().getName();
        this.f12401e.put(Integer.valueOf(r10), r13);
        return;
    }

    @Override // o.b
    public String c() {
        return "android.location.ILocationManager";
    }

    @Override // q.l
    public void e(p.b r10, b0.a r11) {
        if (h().equals(r11.f494d) == false) goto L9;
        boolean r12 = r11.k();
        long r13 = r11.a();
        if (r12 == false) goto L7;
        r10.n(r13);
        return;
    L7:
        r10.d(r13);
        return;
    }

    @Override // o.b
    public void invoke(Object r10, Method r11, Object[] r12) {
        String r13 = r11.getName();     // Catch: Exception -> L14
        if (TextUtils.equals(r13, "requestLocationUpdates") == false) goto L6;
        r(r12);     // Catch: Exception -> L14
    L15:
        return;
    L6:
        if (TextUtils.equals(r13, "registerLocationListener") == false) goto L9;
        s(r12);     // Catch: Exception -> L14
        goto L15
    L9:
        if (TextUtils.equals(r13, "removeUpdates") == false) goto L11;
    L12:
        q(r12);     // Catch: Exception -> L14
        goto L15
    L11:
        if (TextUtils.equals(r13, "unregisterLocationListener") == false) goto L15;
    }

    @Override // q.a
    void o(double r10, double r11) {
        if (r10 < l.a.e()) goto L5;
        int r12 = 33;
    L7:
        if (r11 < l.a.d()) goto L9;
        r12 = r12 | 34;
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
        r15.a(BatteryExceptionListener.IssueType.LOCATION, r13);     // Catch: Throwable -> L25
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
        r16.put(((r.c) r17.next()).b());     // Catch: Throwable -> L26
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
        u((r.c) r10, r11);
    }

    protected void u(r.c r10, long r11) {
        if (r11 >= l.a.b()) goto L13;
        return;
    L13:
        JSONObject r12 = new JSONObject();     // Catch: Throwable -> L12
        r12.put("issue_type", 32).put("single_hold_time", r11);     // Catch: Throwable -> L12
        JSONArray r13 = new JSONArray();     // Catch: Throwable -> L12
        r13.put(r10.b());     // Catch: Throwable -> L12
        r12.put("detail", r13);     // Catch: Throwable -> L12
        BatteryExceptionListener r14 = k.a.G().F();     // Catch: Throwable -> L11
        if (r14 == null) goto L9;
        r14.a(BatteryExceptionListener.IssueType.LOCATION, r12);     // Catch: Throwable -> L11
    L9:
        i0.b.b(r12, "battery_trace");     // Catch: Throwable -> L12
        x.a.p().e(new y.d("battery_trace", r12));     // Catch: Throwable -> L12
        return;
    }
}
