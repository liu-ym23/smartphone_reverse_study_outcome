package i2;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Looper;
import android.view.Window;
import com.bytedance.apm.core.ActivityLifeObserver;
import java.util.HashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class b implements l2.a {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final b f8089k = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f8090a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i2.a f8091b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long[] f8092c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CopyOnWriteArrayList f8093d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f8094e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f8095f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final b3.f f8096g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final b3.g f8097h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final HashMap<String, Window.OnFrameMetricsAvailableListener> f8098i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f8099j;

    public class a extends a8.a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ b f8100d;

        public a(b r8) {
            this.f8100d = r8;
        }

        @Override // a8.a
        public final void a() {
            this.f120a = false;
            b r8 = this.f8100d;
            boolean r12 = r8.f8094e;
            long r10 = a8.a.f118b;
            long[] r13 = r8.f8092c;
            r13[1] = r10;
            r13[3] = a8.a.f119c;
            CopyOnWriteArrayList r11 = r8.f8093d;
            int r14 = r11.size();
            int r15 = 0;
        L4:
            if (r15 >= r14) goto L10;
            com.bytedance.apm.block.a r16 = (com.bytedance.apm.block.a) r11.get(r15);
            if (r16.f3752a == false) goto L9;
            r16.b(r13[0], r13[2], r13[1], r13[3], r12);
        L9:
            r15 = r15 + 1;
            r14 = r14;
            r11 = r11;
            goto L4
        L10:
            long[] r17 = r8.f8091b.f8088a;
            r17[0] = 0;
            r17[1] = 0;
            r17[2] = Long.MAX_VALUE;
            r17[3] = 0;
            r8.f8095f = false;
        }

        @Override // a8.a
        public final void b(String r8) {
            this.f120a = true;
            b r10 = this.f8100d;
            r10.f8095f = true;
            long r11 = a8.a.f118b;
            long[] r12 = r10.f8092c;
            int r13 = 0;
            r12[0] = r11;
            r12[2] = a8.a.f119c;
            CopyOnWriteArrayList r14 = r10.f8093d;
            int r15 = r14.size();
        L3:
            if (r13 >= r15) goto L8;
            com.bytedance.apm.block.a r16 = (com.bytedance.apm.block.a) r14.get(r13);
            if (r16.f3752a == true) goto L7;
            r16.a(r8);
        L7:
            r13 = r13 + 1;
            goto L3
        }

        @Override // a8.a
        public final boolean c() {
            return this.f8100d.f8090a;
        }
    }

    static {
        f8089k = new b();
    }

    public b() {
        this.f8091b = new i2.a();
        this.f8092c = new long[4];
        this.f8093d = new CopyOnWriteArrayList();
        this.f8094e = false;
        this.f8095f = false;
        this.f8096g = new b3.f();
        this.f8097h = new b3.g("looper_monitor");
        this.f8098i = new HashMap();
    }

    @Override // l2.a
    public final void a() {
    }

    @Override // l2.a
    public final void b() {
    }

    @Override // l2.a
    public final void c(Activity r8) {
        Window r10 = r8.getWindow();     // Catch: Exception -> L12
        r10.setCallback(new c(this, r10.getCallback()));     // Catch: Exception -> L12
        String r11 = r8.getClass().getName();     // Catch: Exception -> L12
        String r12 = r8.toString();     // Catch: Exception -> L12
        if (a8.e.f121a == false) goto L6;
        boolean r13 = a8.e.f121a;     // Catch: Exception -> L12
        f8089k.getClass();     // Catch: Exception -> L12
    L6:
        if (this.f8097h.f3045c == null) goto L8;
        boolean r14 = true;
    L9:
        if (r14 == false) goto L15;
        d r15 = new d(this, r11);     // Catch: Exception -> L12
        this.f8098i.put(r12, r15);     // Catch: Exception -> L12
        r10.addOnFrameMetricsAvailableListener(r15, this.f8097h.f3045c);     // Catch: Exception -> L12
        return;
    L15:
        return;
    L8:
        r14 = false;
    }

    @TargetApi(16)
    public final void d() {
        if (this.f8099j == false) goto L6;
        return;
    L6:
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) goto L14;
        ActivityLifeObserver.getInstance().register(this);
        if (a8.e.f121a == true) goto L11;
        a8.e.f121a = true;
        a8.e.f122b = new a8.c();
        new a8.d();
        boolean r8 = a8.e.f121a;
        a8.e.b();
    L11:
        a8.e.f124d = new a(this);
        this.f8099j = true;
        return;
    L14:
        throw new AssertionError("must be init in main thread!");
    }

    @Override // l2.a
    public final void onActivityDestroyed(Activity r8) {
        Window.OnFrameMetricsAvailableListener r10 = this.f8098i.remove(r8.toString());     // Catch: Exception -> L6
        if (r10 == null) goto L9;
        r8.getWindow().removeOnFrameMetricsAvailableListener(r10);     // Catch: Exception -> L6
        return;
    L9:
        return;
    }
}
