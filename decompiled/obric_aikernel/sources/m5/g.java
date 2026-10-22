package m5;

import android.util.Log;
import java.io.BufferedReader;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class g extends a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private List<File> f11053d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private List<Integer> f11054e;

    public g() {
        super("");
        this.f11053d = new ArrayList();
        this.f11054e = new ArrayList();
    }

    private b c(List<File> r10, List<Integer> r11) {
        if (r10 != null) goto L4;
        return null;
    L4:
        if (r10.isEmpty() == true) goto L23;
        if (r11 != null) goto L7;
        return null;
    L7:
        if (r11.isEmpty() == false) goto L9;
        return null;
    L9:
        if (r10.size() != r11.size()) goto L26;
        k5.c r12 = new k5.c();
        int r13 = r10.size();
        int r14 = 0;
    L12:
        if (r14 >= r13) goto L17;
        LinkedHashMap<Long, Long> r15 = d(r10.get(r14), r11.get(r14).intValue());
        if (r15 == null) goto L16;
        r12.f(r15);
    L16:
        r14 = r14 + 1;
        goto L12
    L17:
        return r12;
    L26:
        return null;
    L23:
        return null;
    }

    private LinkedHashMap<Long, Long> d(File r10, int r11) {
        BufferedReader r12 = n5.c.b(r10);
        LinkedHashMap<Long, Long> r13 = null;
        if (r12 != null) goto L25;
        return null;
    L25:
        String r14 = r12.readLine();     // Catch: Exception -> L19 Throwable -> L23
        if (r14 == null) goto L17;
        if (r14.isEmpty() == true) goto L17;
        String[] r15 = r14.split(" ");     // Catch: Exception -> L19 Throwable -> L23
        if (r15.length <= 1) goto L17;
        if (r13 != null) goto L15;
        r13 = new LinkedHashMap();     // Catch: Exception -> L19 Throwable -> L23
    L15:
        r13.put(Long.valueOf(Long.parseLong(r15[0])), Long.valueOf(((long) (r11 * 10)) * Long.parseLong(r15[1])));     // Catch: Exception -> L19 Throwable -> L23
    L17:
        n5.c.a(r12);
        return r13;
    L23:
        n5.c.a(r12);
        return r13;
    L19:
        e = move-exception;
        n5.b.c(Log.getStackTraceString(e));     // Catch: Throwable -> L23
        n5.c.a(r12);
        return r13;
    }

    @Override // m5.a
    public b b() {
        if (this.f11053d.isEmpty() == false) goto L12;
        List<n5.a.g> r10 = n5.a.b();
        if (r10 != null) goto L8;
        return null;
    L8:
        Iterator<n5.a.g> r11 = r10.iterator();
    L10:
        if (r11.hasNext() == false) goto L12;
        n5.a.g r12 = r11.next();
        this.f11053d.add(new File("/sys/devices/system/cpu/cpufreq/" + r12.b() + "/stats/time_in_state"));
        this.f11054e.add(Integer.valueOf(r12.a().size()));
    L12:
        b r13 = c(this.f11053d, this.f11054e);
        this.f11045a = r13;
        return r13;
    }
}
