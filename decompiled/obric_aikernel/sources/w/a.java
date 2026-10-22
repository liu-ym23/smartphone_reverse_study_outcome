package w;

import android.text.TextUtils;
import c4.d;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.apm.k;
import com.bytedance.apm.util.i;
import com.bytedance.apm6.commonevent.CommonEventDeliverer;
import com.bytedance.apm6.commonevent.model.GeneralLegacyEvent;
import com.bytedance.apm6.commonevent.model.TracingData;
import com.bytedance.apm6.perf.base.model.LogTypeName;
import com.bytedance.services.slardar.config.IConfigManager;
import e0.e;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONObject;
import v4.c;
import w.b;

/* JADX INFO: loaded from: classes.dex */
public abstract class a<T extends w.b> implements u4.a {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static int f13204j = 1000;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static boolean f13205k;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final LinkedList<T> f13206c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private volatile boolean f13207g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private volatile boolean f13208h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f13209i;

    /* JADX INFO: renamed from: w.a$a, reason: collision with other inner class name */
    class RunnableC0306a implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ w.b f13210c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ a f13211g;

        RunnableC0306a(a r10, w.b r11) {
            this.f13211g = r10;
            this.f13210c = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.a(this.f13211g, this.f13210c);
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ a f13212c;

        b(a r10) {
            this.f13212c = r10;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            LinkedList r10 = a.b(this.f13212c);
            monitor-enter(r10);
            LinkedList r11 = new LinkedList(a.b(this.f13212c));     // Catch: Throwable -> L11
            a.b(this.f13212c).clear();     // Catch: Throwable -> L11
            monitor-exit(r10);     // Catch: Throwable -> L11
            Iterator r12 = r11.iterator();
        L8:
            if (r12.hasNext() == false) goto L10;
            w.b r13 = (w.b) r12.next();
            this.f13212c.f(r13);
            goto L8
        L10:
            return;
        L11:
            th = move-exception;
            throw th;
        }
    }

    static {
    }

    protected a() {
        this.f13208h = false;
        this.f13209i = false;
        this.f13206c = new LinkedList();
    }

    static /* synthetic */ void a(a r10, w.b r11) {
        r10.h(r11);
    }

    static /* synthetic */ LinkedList b(a r10) {
        return r10.f13206c;
    }

    private void c(T r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        LinkedList<T> r11 = this.f13206c;
        monitor-enter(r11);
    L17:
        th = move-exception;
        throw th;
    L7:
        if (this.f13206c.size() <= f13204j) goto L14;
        T r12 = this.f13206c.poll();     // Catch: Throwable -> L17
        if (f13205k == true) goto L11;
    L23:
        e0.a.d("apm_debug", "apm_cache_buffer_full:" + r12.c().toString());     // Catch: Exception -> L20 Throwable -> L17
        goto L14
    L11:
        if (this.f13208h == true) goto L23;
        k.e().c("apm_cache_buffer_full");     // Catch: Throwable -> L17
        this.f13208h = true;     // Catch: Throwable -> L17
    L14:
        this.f13206c.add(r10);     // Catch: Throwable -> L17
        monitor-exit(r11);     // Catch: Throwable -> L17
    }

    private void g() {
        q0.b.f().i(new b(this));
    }

    private void h(T r10) {
        if (d(r10) == true) goto L5;
        return;
    L5:
        i(r10);
        if (this.f13207g == false) goto L8;
        f(r10);
        return;
    L8:
        c(r10);
    }

    protected static boolean k() {
        if (ActivityLifeObserver.getInstance() != null) goto L6;
        return true;
    L6:
        return !ActivityLifeObserver.getInstance().isForeground();
    }

    private void m(c r10) {
        if (LogTypeName.MONITOR_TYPE_BATCH_TRACING.equals(r10.a()) == false) goto L5;
        CommonEventDeliverer.monitorTrace(new TracingData(v4.a.a(r10.c())));
        return;
    L5:
        CommonEventDeliverer.monitorTrace(new TracingData(r10.c()));
    }

    public static void n(int r10) {
        f13204j = r10;
    }

    public static void o(boolean r10) {
        f13205k = r10;
    }

    protected boolean d(T r10) {
        return true;
    }

    public final void e(T r10) {
        if (q0.b.f().g() == true) goto L5;
        q0.b.f().i(new RunnableC0306a(this, r10));
        return;
    L5:
        h(r10);
    }

    protected abstract void f(T r10);

    protected void i(T r10) {
    }

    public void j() {
        ((IConfigManager) d.a(IConfigManager.class)).registerConfigListener(this);
    }

    protected void l(String r10, String r11, JSONObject r12, boolean r13, boolean r14) {
        if (com.bytedance.apm.d.D() == false) goto L5;
        e.b("BaseDataPipeline", new String[]{"type:" + r10 + " isSaveUnSampleLog:" + r14 + "isSampled:" + r13 + " log:" + r12});
    L5:
        if (r13 == false) goto L19;
        if (this.f13209i == false) goto L9;
        JSONObject r15 = i.j(r12);
    L11:
        if (TextUtils.equals(r10, "tracing") == false) goto L14;
        m(new c(r15, null, false, r11));
    L28:
        h0.a.b().c(r10, r11, r12);
        if (TextUtils.equals(r10, LogTypeName.MONITOR_LOG_TYPE_UI_ACTION) == false) goto L34;
        z.a.b().a(r12);
        return;
    L34:
        return;
    L14:
        if (TextUtils.equals(r10, LogTypeName.MONITOR_LOG_TYPE_COMMON_LOG) == false) goto L16;
        GeneralLegacyEvent r16 = new GeneralLegacyEvent(r11, r15);
    L17:
        CommonEventDeliverer.monitorLegacyEvent(r16);
        goto L28
    L16:
        r16 = new GeneralLegacyEvent(r10, r15);
        goto L17
    L9:
        r15 = i.c(r12);
        goto L11
    L19:
        if (com.bytedance.apm.d.D() == false) goto L21;
        a0.a.b(r10, r12, false);
    L21:
        if (r14 == false) goto L28;
        if (e0.a.f() == false) goto L28;
        e0.a.g(r10, r12.toString());     // Catch: Exception -> L26
    L26:
        e = move-exception;
        t4.a.d(e, "apm_unsampled_log_error");
        goto L28
    }

    @Override // u4.a
    public void onReady() {
        this.f13207g = true;
        g();
    }

    @Override // u4.a
    public void onRefresh(JSONObject r10, boolean r11) {
    }
}
