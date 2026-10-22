package x4;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public class c extends Observable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile c f13558c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile boolean f13559a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private CopyOnWriteArrayList<Integer> f13560b;

    public c() {
        this.f13560b = new CopyOnWriteArrayList();
    }

    public static c a() {
        if (f13558c != null) goto L15;
        monitor-enter(c.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f13558c != null) goto L9;
        f13558c = new c();     // Catch: Throwable -> L11
    L9:
        monitor-exit(c.class);     // Catch: Throwable -> L11
    L15:
        return f13558c;
    }

    private void b(Map<String, Object> r10) {
        setChanged();
        notifyObservers(r10);
    }

    public void c(boolean r10, List<Integer> r11) {
        this.f13559a = r10;
        this.f13560b.clear();
        this.f13560b.addAll(r11);
        HashMap r12 = new HashMap();
        r12.put("user_blocked_state", Boolean.valueOf(this.f13559a));
        r12.put("drop_reason_list", this.f13560b);
        b(r12);
    }
}
