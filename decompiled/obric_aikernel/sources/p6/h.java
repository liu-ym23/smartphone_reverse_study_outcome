package p6;

import com.bytedance.apm6.perf.base.model.LogTypeName;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class h extends o6.a implements v6.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private m6.f f12339b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private File f12340c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ConcurrentLinkedQueue<b> f12341d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private b f12342e;

    class a implements t4.f {
        a(h r10) {
        }
    }

    private class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f12343a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f12344b;

        public b(h r10, String r11, String r12) {
            this.f12343a = r11;
            this.f12344b = r12;
        }
    }

    public h() {
        this.f12340c = null;
        this.f12341d = new ConcurrentLinkedQueue();
        this.f12342e = new b(this, "error_data", "error_ids");
    }

    @Override // v6.a
    public List<String> a() {
        ArrayList r10 = new ArrayList();
        File r11 = this.f12340c;
        if (r11 == null) goto L5;
        r10.add(r11.getAbsolutePath());
    L5:
        return r10;
    }

    @Override // o6.a
    public String f() {
        return "monitor_log";
    }

    @Override // o6.a
    public boolean g(n6.a r25) {
        JSONObject r10 = new JSONObject(r25.c());
        if (this.f12339b != null) goto L6;
        return false;
    L6:
        if (e(r10, r25) == false) goto L8;
        return true;
    L8:
        long r19 = r10.optLong("fetch_start_time", (System.currentTimeMillis() / 1000) - 18000);
        long r21 = r10.optLong("fetch_end_time", System.currentTimeMillis() / 1000);
        String[] r11 = this.f12339b.b(r10);
        if (r11 != null) goto L11;
    L33:
        return true;
    L11:
        if (r11.length <= 0) goto L33;
        int r12 = r11.length;
        boolean r13 = false;
        boolean r14 = false;
        int r15 = 0;
    L13:
        if (r15 >= r12) goto L30;
        String r16 = r11[r15];
        int r17 = 0;
    L15:
        r17 = r17 + 1;
        if (r17 > 100) goto L29;
        if (this.f12341d.isEmpty() == true) goto L20;
        b r18 = this.f12341d.poll();
        if (r18 == this.f12342e) goto L24;
        File r20 = r6.c.a(k6.a.k().i(), r18.f12343a, m(r16));
        this.f12340c = r20;
        if (r20 == null) goto L28;
        String r110 = r16;
        w6.a r111 = new w6.a(n(r16), 0, false, r25.b(), this, null);
        r111.h(1);
        r111.t(true);
        u6.a.c(r111);
        this.f12339b.a(r110, r18.f12344b);
        Thread.sleep(100);
        r14 = false;
        r13 = true;
        r16 = r110;
        r15 = r15;
        r12 = r12;
        r11 = r11;
        r17 = r17;
        goto L15
    L28:
        this.f12341d.clear();
        r13 = false;
        r14 = false;
        goto L29
    L24:
        this.f12341d.clear();
        r14 = false;
        goto L29
    L20:
        if (r14 == true) goto L15;
        this.f12339b.c(r19, r21, r16, new a(this));
        r14 = true;
    L29:
        r15 = r15 + 1;
        r12 = r12;
        r11 = r11;
        goto L13
    L30:
        if (r13 == false) goto L32;
        l(r25);
        goto L33
    L32:
        k("Monitor日志查询为空", r25);
        goto L33
    }

    public String m(String r10) {
        return "cloudMessage_" + r10;
    }

    public String n(String r10) {
        if (LogTypeName.MONITOR_TYPE_BLOCK.equals(r10) == false) goto L5;
        return "log_exception";
    L5:
        return "log_performance";
    }

    public void o(m6.f r10) {
        this.f12339b = r10;
    }
}
