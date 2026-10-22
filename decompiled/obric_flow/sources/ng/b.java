package ng;

import android.util.Pair;
import com.bytedance.ies.bullet.prefetchv2.d;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends ScheduledThreadPoolExecutor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap f20229a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap f20230b;

    public b(d r5) {
        super(1, r5);
        this.f20229a = new ConcurrentHashMap();
        this.f20230b = new ConcurrentHashMap();
    }

    public final void a(mg.d r5) {
        super.submit(r5);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public final void afterExecute(Runnable r5, Throwable r10) {
        super.afterExecute(r5, r10);
        if ((r5 instanceof ScheduledFuture) == false) goto L15;
        ScheduledFuture r11 = (ScheduledFuture) r5;
        Pair r12 = (Pair) this.f20230b.get(r11);
        if (r12 == null) goto L16;
        Object r13 = r12.first;
        if (r13 == null) goto L17;
        Integer r14 = (Integer) r13;
        Boolean r15 = (Boolean) r12.second;
        if (r15 != null) goto L11;
        return;
    L11:
        if (r15.booleanValue() == true) goto L19;
        c(r14, r11);
        return;
    L19:
        return;
    L17:
        return;
    L16:
        return;
    }

    public final void b(mg.d r5, long r10) {
        if (r5 != null) goto L4;
        return;
    L4:
        ScheduledFuture<?> r11 = schedule(r5, r10, TimeUnit.MILLISECONDS);
        int r12 = r5.hashCode();
        ConcurrentHashMap r13 = this.f20229a;
        List r14 = (List) r13.get(Integer.valueOf(r12));
        if (r14 != null) goto L7;
        r14 = new CopyOnWriteArrayList();
        r13.put(Integer.valueOf(r12), r14);
    L7:
        r14.add(r11);
        this.f20230b.put(r11, new Pair(Integer.valueOf(r12), Boolean.FALSE));
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public final void beforeExecute(Thread r5, Runnable r10) {
        super.beforeExecute(r5, r10);
    }

    public final void c(Integer r5, ScheduledFuture r10) {
        ConcurrentHashMap r11 = this.f20229a;
        List r12 = (List) r11.get(r5);
        if (r12 == null) goto L7;
        r12.remove(r10);
        if (r12.isEmpty() == false) goto L7;
        r11.remove(r5);
    L7:
        this.f20230b.remove(r10);
    }

    public final void d(w5.b r5) {
        int r10 = r5.hashCode();
        List r11 = (List) this.f20229a.get(Integer.valueOf(r10));
        if (r11 != null) goto L5;
        return;
    L5:
        if (r11.isEmpty() == true) goto L18;
        Iterator r12 = r11.iterator();
    L8:
        if (r12.hasNext() == false) goto L19;
        ScheduledFuture r13 = (ScheduledFuture) r12.next();
        if (r13.isCancelled() == true) goto L8;
        r13.cancel(true);
        c(Integer.valueOf(r10), r13);
        goto L8
    L19:
        return;
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public final void terminated() {
        super.terminated();
    }
}
