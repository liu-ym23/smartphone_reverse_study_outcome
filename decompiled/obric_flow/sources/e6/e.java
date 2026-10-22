package e6;

import android.os.Process;
import android.util.Log;
import com.bytedance.android.anniex.base.service.f;
import com.bytedance.apm.doctor.DoctorManager;
import com.bytedance.apm.j;
import com.bytedance.apm.util.g;
import com.bytedance.services.apm.api.IEnsure;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements z6.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f16764a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f16765b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile JSONObject f16766c;
    public volatile JSONObject d;
    public volatile JSONObject e;
    public List f;
    public volatile long g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public JSONObject f16767h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f16768i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f16769j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f16770k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f16771l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public volatile boolean f16772m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f16773n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f16774o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public volatile long f16775p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public volatile long f16776q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public CopyOnWriteArrayList f16777r;

    @Override // z6.c
    public final void a(long r5) {
        f(false);
    }

    public final void b() {
        monitor-enter(this);
        boolean r5 = j.f3887a;     // Catch: Throwable -> L15
        if (g6.c.f17060a != (-1)) goto L10;
        throw null;     // Catch: Exception -> L8 Throwable -> L15
    L8:
        g6.c.f17060a = -1;     // Catch: Throwable -> L15
    L10:
        if (g6.c.f17060a == Process.myPid()) goto L12;
        throw null;     // Catch: Throwable -> L15
    L12:
        throw null;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }

    public final boolean c(long r10) {
        long r5 = this.f16770k;
        if (r5 <= 60000) goto L9;
        if ((r10 - this.f16771l) > r5) goto L7;
        return false;
    L7:
        return true;
    L9:
        if ((r10 - this.f16769j) > (this.g * 1000)) goto L11;
        return false;
    L11:
        return true;
    }

    public final void d() {
        if (this.f16764a == true) goto L20;
        this.f16764a = true;
        CopyOnWriteArrayList r5 = this.f16777r;
        if (r5 == null) goto L29;
        Iterator r10 = r5.iterator();
    L8:
        if (r10.hasNext() == false) goto L30;
        ((pj.a) r10.next()).e();     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        if (j.f3887a == false) goto L16;
        th.printStackTrace();
    L16:
        IEnsure r11 = oo.j.f20816a;
        if (r11 == null) goto L8;
        r11.ensureNotReachHere(th);
        goto L8
    L30:
        return;
    L29:
        return;
    }

    public final void e(JSONObject r5, boolean r10) {
        CopyOnWriteArrayList r11 = this.f16777r;
        if (r11 == null) goto L18;
        Iterator r12 = r11.iterator();
    L6:
        if (r12.hasNext() == false) goto L27;
        ((pj.a) r12.next()).d(r5, r10);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        if (j.f3887a == false) goto L14;
        th.printStackTrace();
    L14:
        IEnsure r13 = oo.j.f20816a;
        if (r13 == null) goto L6;
        r13.ensureNotReachHere(th);
        goto L6
    L27:
        return;
    }

    public final void f(boolean r5) {
        if (j.f3887a == false) goto L13;
        StringBuilder r10 = new StringBuilder("SlardarConfigFetcher.queryFromNet.");
        if (this.f16774o == false) goto L7;
    L10:
        boolean r11 = true;
    L11:
        r10.append(r11);
        r10.append(" ");
        r10.append(c(System.currentTimeMillis()));
        Log.i("apm_initializing", f.o(new String[]{r10.toString()}));
        DoctorManager.getInstance().a("APM_SETTING_UPDATE_FROM_NET", "queryFromNet:" + r5);
        goto L13
    L7:
        if (this.f16773n == true) goto L10;
        r11 = false;
    L13:
        if (this.f16774o == false) goto L15;
    L16:
        if (r5 == true) goto L22;
        if (c(System.currentTimeMillis()) == true) goto L22;
        return;
    L22:
        if (g.b(null) == true) goto L28;
        if (j.f3887a == false) goto L32;
        Log.i("apm_initializing", f.o(new String[]{"SlardarConfigFetcher.queryFromNet.NetworkUnavailable"}));
        DoctorManager.getInstance().a("APM_SETTING_UPDATE_FROM_NET_ERROR", "network not available");
        return;
    L32:
        return;
    L28:
        if (j.f3887a == false) goto L33;
        Log.i("apm_initializing", f.o(new String[]{"SlardarConfigFetcher.queryFromNet.ParamsEmpty"}));
        DoctorManager.getInstance().a("APM_SETTING_UPDATE_FROM_NET_ERROR", "mQueryParams not available");
        return;
    L33:
        return;
    L15:
        if (this.f16773n == true) goto L16;
    }

    public final boolean g() {
        b();
        throw null;
    }
}
