package q;

import com.bytedance.apm.core.ActivityLifeObserver;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import r.b;

/* JADX INFO: loaded from: classes.dex */
public abstract class c<T extends r.b> implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f12397a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    volatile long f12398b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    volatile boolean f12399c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    volatile boolean f12400d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    ConcurrentHashMap<Integer, T> f12401e;

    c(String r10) {
        this.f12401e = new ConcurrentHashMap();
        this.f12397a = r10;
        this.f12399c = ActivityLifeObserver.getInstance().isForeground();
        this.f12398b = System.currentTimeMillis();
        this.f12400d = s.a.e(com.bytedance.apm.d.g());
    }

    @Override // q.l
    public void a(boolean r10) {
        long r11 = System.currentTimeMillis();
        if (this.f12401e.size() == 0) goto L5;
        i(this.f12398b, r11, r10);
    L5:
        this.f12398b = r11;
    }

    @Override // q.l
    public void b(boolean r10) {
        this.f12399c = false;
    }

    @Override // q.l
    public void f(boolean r10) {
        this.f12399c = true;
    }

    protected abstract void g(T r10, long r11, long r12);

    public String h() {
        return this.f12397a;
    }

    protected void i(long r10, long r11, boolean r12) {
        Iterator<Map.Entry<Integer, T>> r13 = this.f12401e.entrySet().iterator();
    L4:
        if (r13.hasNext() == false) goto L19;
        T r14 = r13.next().getValue();
        long r15 = r14.f12511b;
        if (0 >= r15) goto L11;
        if (r15 >= r14.f12510a) goto L11;
    L9:
        r13.remove();
    L11:
        if (0 >= r15) goto L16;
        if (r15 < r10) goto L9;
    L16:
        if (r11 < r14.f12510a) goto L4;
        g(r14, r10, r11);
        goto L4
    }
}
