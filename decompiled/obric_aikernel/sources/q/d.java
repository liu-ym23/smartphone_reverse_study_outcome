package q;

import android.app.PendingIntent;
import androidx.core.app.NotificationCompat;
import com.bytedance.apm.battery.BatteryExceptionListener;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class d extends c<r.a> implements o.b {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int[] f12402f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f12403g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private List<Long> f12404h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f12405i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Object f12406j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final List<Long> f12407k;

    public d() {
        super(NotificationCompat.CATEGORY_ALARM);
        this.f12404h = new ArrayList();
        this.f12406j = new Object();
        this.f12407k = new ArrayList();
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    private void k(Object[] r10) {
        if (r10[0] != null) goto L5;
    L7:
        int r11 = -1;
    L8:
        r.a r12 = (r.a) this.f12401e.get(Integer.valueOf(r11));
        if (r12 != null) goto L11;
        return;
    L11:
        if (r12.f12508f <= 0) goto L15;
        r12.f12511b = System.currentTimeMillis();
        this.f12401e.put(Integer.valueOf(r11), r12);
        return;
    L15:
        return;
    L5:
        if ((r10[0] instanceof PendingIntent) == false) goto L7;
        r11 = r10[0].hashCode();
        goto L8
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    private void l(Object[] r10) {
        r.a r11 = new r.a();
        int r12 = r10.length;
        int r13 = 0;
        int r14 = -1;
        boolean r15 = false;
        int r16 = 0;
    L3:
        if (r13 >= r12) goto L20;
        Object r17 = r10[r13];
        if ((r17 instanceof Integer) == false) goto L9;
        if (r15 == true) goto L9;
        r11.f12507e = ((Integer) r17).intValue();
        r15 = true;
    L19:
        r13 = r13 + 1;
    L9:
        if ((r17 instanceof Long) == false) goto L17;
        if (r16 != 0) goto L13;
        r11.f12510a = ((Long) r17).longValue();
        r11.f12510a = r11.b();
    L15:
        r16 = r16 + 1;
        goto L19
    L13:
        if (r16 != 2) goto L15;
        r11.f12508f = ((Long) r17).longValue();
        goto L15
    L17:
        if ((r17 instanceof PendingIntent) == false) goto L19;
        PendingIntent r18 = (PendingIntent) r17;
        r11.f12509g = com.bytedance.apm.util.h.a(r18);
        r14 = r18.hashCode();
        goto L19
    L20:
        if (r14 != (-1)) goto L22;
        return;
    L22:
        if (r11.f12508f != 0) goto L24;
        long r19 = r11.f12510a;
    L25:
        r11.f12511b = r19;
        if (k.a.G().J() == false) goto L28;
        r11.f12512c = Thread.currentThread().getName();
        r11.f12513d = Thread.currentThread().getStackTrace();
    L28:
        this.f12401e.put(Integer.valueOf(r14), r11);
        return;
    L24:
        r19 = -1;
        goto L25
    }

    private void m(int[] r14, int r15) {
        long r10 = System.currentTimeMillis();
        if (this.f12399c == false) goto L7;
        if ((r15 % 2) != 0) goto L7;
    L10:
        p.a.h().l(new b0.a(false, r10, h(), this.f12400d, r14[0], null));
        p.a r16 = p.a.h();
        b0.a r12 = new b0.a(true, r10, h(), this.f12400d, r14[1], null);
    L12:
        r16.l(r12);
        return;
    L7:
        if (this.f12399c == false) goto L9;
    L11:
        p.a.h().l(new b0.a(true, r10, h(), this.f12400d, r14[0], null));
        r16 = p.a.h();
        r12 = new b0.a(false, r10, h(), this.f12400d, r14[1], null);
        goto L12
    L9:
        if ((r15 % 2) != 1) goto L11;
        goto L10
    }

    private void n() {
        long r10 = System.currentTimeMillis();
        int[] r11 = this.f12402f;
        int r12 = 0;
        double r13 = (((((double) r11[0]) + ((double) r11[1])) / (r10 - this.f12398b)) * 60000.0d) * 10.0d;
        double r14 = ((((double) this.f12403g) / (r10 - this.f12398b)) * 60000.0d) * 10.0d;
        if (r13 < l.a.h()) goto L6;
        r12 = 49;
    L6:
        if (r14 < l.a.a()) goto L8;
        r12 = r12 | 50;
    L8:
        if (r12 != 0) goto L26;
        return;
    L26:
        JSONObject r15 = new JSONObject();     // Catch: Throwable -> L25
        r15.put("issue_type", r12).put("wake_up_count", r13).put("normal_count", r14);     // Catch: Throwable -> L25
        ConcurrentHashMap<Integer, T> r16 = this.f12401e;     // Catch: Throwable -> L25
        if (r16 != 0) goto L13;
    L28:
        BatteryExceptionListener r17 = k.a.G().F();     // Catch: Throwable -> L24
        if (r17 == null) goto L22;
        r17.a(BatteryExceptionListener.IssueType.ALARM, r15);     // Catch: Throwable -> L24
    L22:
        i0.b.b(r15, "battery_trace");     // Catch: Throwable -> L25
        x.a.p().e(new y.d("battery_trace", r15));     // Catch: Throwable -> L25
        return;
    L13:
        if (r16.size() <= 0) goto L28;
        JSONArray r18 = new JSONArray();     // Catch: Throwable -> L25
        Iterator r19 = this.f12401e.values().iterator();     // Catch: Throwable -> L25
    L16:
        if (r19.hasNext() == false) goto L18;
        r18.put(((r.a) r19.next()).d());     // Catch: Throwable -> L25
        goto L16
    L18:
        r15.put("detail", r18);     // Catch: Throwable -> L25
    }

    @Override // q.c, q.l
    public void b(boolean r10) {
        super.b(r10);
        long r11 = System.currentTimeMillis();
        Object r12 = this.f12406j;
        monitor-enter(r12);
        this.f12404h.add(Long.valueOf(r11));     // Catch: Throwable -> L7
        monitor-exit(r12);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // o.b
    public String c() {
        return "android.app.IAlarmManager";
    }

    @Override // q.l
    public void d(boolean r10, boolean r11) {
        this.f12400d = r10;
    }

    @Override // q.l
    public void e(p.b r10, b0.a r11) {
        if (h().equals(r11.f494d) == true) goto L5;
        return;
    L5:
        boolean r12 = r11.j();
        long r13 = r11.a();
        if (r12 == false) goto L8;
        r10.i(r13);
        return;
    L8:
        r10.s(r13);
    }

    @Override // q.c, q.l
    public void f(boolean r10) {
        super.f(r10);
        long r11 = System.currentTimeMillis();
        Object r12 = this.f12406j;
        monitor-enter(r12);
        this.f12404h.add(Long.valueOf(r11));     // Catch: Throwable -> L7
        monitor-exit(r12);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // q.c
    protected /* bridge */ /* synthetic */ void g(r.b r10, long r11, long r12) {
        j((r.a) r10, r11, r12);
    }

    @Override // q.c
    protected void i(long r10, long r11, boolean r12) {
        this.f12403g = 0;
        this.f12402f = new int[2];
        this.f12407k.add(Long.valueOf(r10));
        Object r13 = this.f12406j;
        monitor-enter(r13);
        this.f12407k.addAll(this.f12404h);     // Catch: Throwable -> L15
        this.f12404h.clear();     // Catch: Throwable -> L15
        monitor-exit(r13);     // Catch: Throwable -> L15
        this.f12407k.add(Long.valueOf(r11));
        this.f12405i = 1;
    L8:
        if (this.f12405i >= this.f12407k.size()) goto L10;
        super.i(this.f12407k.get(this.f12405i - 1).longValue(), this.f12407k.get(this.f12405i).longValue(), r12);
        this.f12405i++;
        goto L8
    L10:
        int[] r14 = this.f12402f;
        if ((r14[0] + r14[1]) == 0) goto L13;
        m(r14, this.f12407k.size());
    L13:
        this.f12407k.clear();
        n();
        return;
    L15:
        th = move-exception;
        throw th;
    }

    @Override // o.b
    public void invoke(Object r10, Method r11, Object[] r12) {
        String r13 = r11.getName();     // Catch: Exception -> L9
        if ("set".equals(r13) == false) goto L6;
        l(r12);     // Catch: Exception -> L9
    L10:
        return;
    L6:
        if ("remove".equals(r13) == false) goto L10;
        k(r12);     // Catch: Exception -> L9
    }

    protected void j(r.a r11, long r12, long r14) {
        long r10 = r11.f12508f;
        int r13 = 1;
        if (r10 > 0) goto L10;
        long r15 = r11.f12510a;
        if (r12 <= r15) goto L7;
        return;
    L7:
        if (r15 <= r14) goto L23;
        return;
    L23:
        if (r11.c() == false) goto L25;
        int[] r16 = this.f12402f;
        int r17 = this.f12405i % 2;
        r16[r17] = r16[r17] + r13;
        return;
    L25:
        this.f12403g += r13;
        return;
    L10:
        long r18 = r11.f12510a;
        if (r18 >= r12) goto L13;
        r18 = (r12 + r10) - ((r12 - r18) % r10);
    L13:
        long r19 = r11.f12511b;
        if (r19 <= r14) goto L16;
    L19:
        long r110 = r14 - r18;
        if (r110 <= 0) goto L28;
        r13 = 1 + ((int) (r110 / r10));
        goto L23
    L28:
        return;
    L16:
        if (r19 <= 0) goto L19;
        r14 = r19;
        goto L19
    }
}
