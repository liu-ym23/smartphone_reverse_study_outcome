package m5;

import android.util.Log;
import java.io.BufferedReader;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class f extends a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f11049d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private List<List<File>> f11050e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f11051f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private List<Integer> f11052g;

    public f() {
        super("");
        this.f11049d = false;
        this.f11050e = new ArrayList();
        this.f11051f = -1;
    }

    private b c(List<List<File>> r10) {
        if (r10 != null) goto L4;
        return null;
    L4:
        if (r10.isEmpty() == true) goto L20;
        k5.a r11 = new k5.a();
        Iterator<List<File>> r12 = r10.iterator();
    L8:
        if (r12.hasNext() == false) goto L12;
        List<Long> r13 = d(r12.next());
        if (r13 == null) goto L8;
        r11.f(r13);
        goto L8
    L12:
        return r11;
    L20:
        return null;
    }

    private List<Long> d(List<File> r10) {
        ArrayList r11 = new ArrayList();
        Iterator<File> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L24;
        BufferedReader r13 = n5.c.b(r12.next());
        if (r13 == null) goto L7;
    L25:
        String r14 = r13.readLine();     // Catch: Throwable -> L17 Exception -> L19
        if (r14 == null) goto L16;
        if (r14.isEmpty() == true) goto L16;
        r11.add(Long.valueOf(Long.parseLong(r14) / 1000));     // Catch: Throwable -> L17 Exception -> L19
    L16:
        n5.c.a(r13);
    L19:
        e = move-exception;
        n5.b.c(Log.getStackTraceString(e));     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        n5.c.a(r13);
        throw th;
    L7:
        return null;
    L24:
        return r11;
    }

    @Override // m5.a
    public b b() {
        if (this.f11049d == true) goto L6;
        this.f11051f = n5.a.c();
        this.f11052g = n5.a.e();
        this.f11049d = true;
    L6:
        if (this.f11052g != null) goto L10;
        return null;
    L10:
        if (this.f11050e.isEmpty() == false) goto L18;
        int r10 = 0;
    L13:
        if (r10 >= this.f11051f) goto L18;
        int r11 = this.f11052g.get(r10).intValue();
        ArrayList r12 = new ArrayList();
        int r13 = 0;
    L15:
        if (r13 >= r11) goto L17;
        r12.add(new File("/sys/devices/system/cpu/cpu" + r10 + "/cpuidle/state" + r13 + "/time"));
        r13 = r13 + 1;
        goto L15
    L17:
        this.f11050e.add(r12);
        r10 = r10 + 1;
    L18:
        b r14 = c(this.f11050e);
        this.f11045a = r14;
        return r14;
    }
}
