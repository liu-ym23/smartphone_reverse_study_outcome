package l0;

import android.os.Process;
import android.text.TextUtils;
import com.bytedance.apm.util.j;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public class e implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private File f10791a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<String> f10792b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f10793c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile long f10794d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile long f10795e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile long f10796f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private volatile long f10797g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private volatile long f10798h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private volatile long f10799i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private volatile long f10800j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private volatile long f10801k;

    public e() {
        this.f10792b = new CopyOnWriteArrayList();
        this.f10793c = -1;
        this.f10794d = 0;
        this.f10795e = 0;
        this.f10796f = 0;
        this.f10797g = 0;
        this.f10798h = 0;
        this.f10799i = 0;
        this.f10800j = 0;
        this.f10801k = 0;
    }

    private void m() {
        if (this.f10791a != null) goto L5;
        return;
    L5:
        BufferedReader r10 = null;
        ArrayList r11 = new ArrayList();     // Catch: Throwable -> L17
        BufferedReader r12 = new BufferedReader(new InputStreamReader(new FileInputStream(this.f10791a), "utf-8"));     // Catch: Throwable -> L17
        int r13 = 1;
    L26:
        String r14 = r12.readLine();     // Catch: Throwable -> L15
        if (r14 == null) goto L13;
        if (r13 < 0) goto L12;
        r11.add(r14);     // Catch: Throwable -> L15
    L12:
        r13 = r13 + 1;     // Catch: Throwable -> L15
        goto L26
    L13:
        this.f10792b.clear();     // Catch: Throwable -> L15
        this.f10792b.addAll(r11);     // Catch: Throwable -> L15
        x3.d.b(r12);
        return;
    L15:
        th = th;
        r10 = r12;
    L24:
        th.printStackTrace();     // Catch: Throwable -> L21
        x3.d.b(r10);
        return;
    L21:
        th = move-exception;
        x3.d.b(r10);
        throw th;
    L17:
        th = th;
        goto L24
    }

    private void n() {
        e this = this;
        if ((System.currentTimeMillis() - this.f10793c) >= 1000) goto L5;
        return;
    L5:
        this.f10793c = System.currentTimeMillis();
        int r10 = Process.myUid();
        m();
        if (j.b(this.f10792b) == false) goto L8;
        return;
    L8:
        Iterator<String> r11 = this.f10792b.iterator();
        long r12 = 0;
        long r13 = 0;
        long r14 = 0;
        long r15 = 0;
        long r16 = 0;
        long r17 = 0;
        long r18 = 0;
        long r19 = 0;
    L10:
        if (r11.hasNext() == false) goto L45;
        r11 = r11;
        long r23 = r18;
        String[] r20 = r11.next().split(" ");
    L41:
        int r32 = r10;
        long r34 = r13;
    L40:
        long r21 = r23;
    L42:
        r18 = r21;
    L43:
        r13 = r34;
    L44:
        r10 = r32;
        goto L10
    L13:
        if (TextUtils.equals(r20[3], "uid_tag_int") == true) goto L14;
        if (r10 != Integer.parseInt(r20[3])) goto L39;
        long r110 = Long.parseLong(r20[5]);     // Catch: Exception -> L41
        long r25 = Long.parseLong(r20[6]);     // Catch: Exception -> L41
        long r27 = Long.parseLong(r20[7]);     // Catch: Exception -> L41
        long r29 = Long.parseLong(r20[8]);     // Catch: Exception -> L41
        r32 = r10;
        if (Long.valueOf(r20[4]).longValue() != 1) goto L27;
        r34 = r13;
        if (r20[1].startsWith("rmnet_data") == false) goto L25;
        r16 = r16 + (r27 + r110);     // Catch: Exception -> L49
        r17 = r17 + (r29 + r25);     // Catch: Exception -> L49
    L30:
        if (Long.valueOf(r20[4]).longValue() == 0) goto L56;
    L38:
        r21 = r23;
        goto L42
    L56:
        if (r20[1].startsWith("rmnet_data") == false) goto L34;
        r14 = r14 + (r27 + r110);
        r18 = r23 + (r29 + r25);
        goto L43
    L34:
        r21 = r23;
        if (r20[1].startsWith("wlan") == false) goto L42;
        long r22 = r34 + (r27 + r110);
        r19 = r19 + (r29 + r25);
        r18 = r21;
        r13 = r22;
        goto L44
    L25:
        if (r20[1].startsWith("wlan") == false) goto L30;
        r15 = r15 + (r27 + r110);     // Catch: Exception -> L49
        r12 = r12 + (r29 + r25);     // Catch: Exception -> L49
        goto L30
    L27:
        r34 = r13;
        goto L30
    L39:
        r32 = r10;
        r34 = r13;
        goto L40
    L14:
        r18 = r23;
        goto L10
    L45:
        long r24 = r13;
        this.f10794d = r24;
        this.f10795e = r14;
        this.f10796f = r15;
        this.f10797g = r16;
        this.f10798h = r19;
        this.f10799i = r18;
        this.f10800j = r12;
        this.f10801k = r17;
    }

    @Override // l0.b
    public long a() {
        return b() + i();
    }

    @Override // l0.b
    public long b() {
        n();
        return this.f10795e;
    }

    @Override // l0.b
    public long c() {
        return k() + l();
    }

    @Override // l0.b
    public void d(boolean r10) {
    }

    @Override // l0.b
    public long e() {
        n();
        return this.f10799i + this.f10798h;
    }

    @Override // l0.b
    public long f() {
        n();
        return this.f10796f;
    }

    @Override // l0.b
    public long g() {
        n();
        return this.f10797g;
    }

    @Override // l0.b
    public long h() {
        return g() + f();
    }

    @Override // l0.b
    public long i() {
        n();
        return this.f10794d;
    }

    @Override // l0.b
    public void init() {
        this.f10791a = new File("/proc/net/xt_qtaguid/stats");
    }

    @Override // l0.b
    public long j() {
        n();
        return this.f10801k + this.f10800j;
    }

    public long k() {
        return b() + g();
    }

    public long l() {
        return i() + f();
    }
}
