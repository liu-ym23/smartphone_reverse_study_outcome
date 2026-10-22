package x50;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.live.core.launch.AbsTask;
import com.bytedance.android.livesdkapi.init.ILiveInitTaskController;
import com.bytedance.android.livesdkapi.init.ILiveInitTaskListener;
import com.bytedance.android.livesdkapi.init.LiveInitCostInfo;
import com.bytedance.android.livesdkapi.init.LiveInitTaskInfo;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b implements ILiveInitTaskController {
    public final ConcurrentHashMap<Integer, AbsTask> a;
    public final ConcurrentHashMap<Integer, Integer> b;
    public final ConcurrentHashMap<Integer, Integer> c;
    public int[][] d;
    public AbsTask e;
    public Thread f;
    public volatile boolean g;
    public ILiveInitTaskListener h;

    public static class a {
        public static final b a = null;

        static {
            a = new b();
        }
    }

    public final synchronized void c() {
        monitor-enter(this);
    L26:
        th = move-exception;
        throw th;
    L4:
        if (this.g == false) goto L7;
        monitor-exit(this);
        return;
    L7:
        ILiveInitTaskListener r0 = this.h;     // Catch: Throwable -> L26
        if (r0 == null) goto L11;
        r0.onTaskScheduleStart(new LiveInitCostInfo("sdk_launcher_task"));     // Catch: Throwable -> L26
    L11:
        if (this.e != null) goto L14;
        this.e = a();     // Catch: Throwable -> L26
    L14:
        if (ThreadMethodProxy.currentThread() != ThreadMethodProxy.getLooperThread(Looper.getMainLooper())) goto L17;
        d();     // Catch: Throwable -> L26
    L21:
        ILiveInitTaskListener r1 = this.h;     // Catch: Throwable -> L26
        if (r1 == null) goto L24;
        r1.onTaskScheduleEnd(new LiveInitCostInfo("sdk_launcher_task"));     // Catch: Throwable -> L26
        this.h.onAllTaskExecuteFinish();     // Catch: Throwable -> L26
    L24:
        monitor-exit(this);
        return;
    L17:
        if (this.f == null) goto L20;
        monitor-exit(this);
        return;
    L20:
        e();     // Catch: Throwable -> L26
        goto L21
    }

    public final synchronized void d() {
        monitor-enter(this);
    L37:
        th = move-exception;
        throw th;
    L4:
        if (this.e != null) goto L6;
    L35:
        monitor-exit(this);
        return;
    L6:
        if (ThreadMethodProxy.currentThread() != ThreadMethodProxy.getLooperThread(Looper.getMainLooper())) goto L35;
        AbsTask r0 = this.e;     // Catch: Throwable -> L37
    L9:
        boolean r1 = true;
        if (r0 == null) goto L11;
        Iterator<Integer> r2 = r0.preTasks().iterator();     // Catch: Throwable -> L37
    L16:
        if (r2.hasNext() == false) goto L23;
        Integer r3 = r2.next();     // Catch: Throwable -> L37
        if (r3.intValue() == r0.getTaskId()) goto L16;
        if (this.a.get(r3).isFinished() == true) goto L16;
        r1 = false;
    L23:
        String r4 = r0.getTaskBusinessInfo();     // Catch: Throwable -> L37
        if (r1 == false) goto L33;
        if (r0.isIDLE() == false) goto L33;
        LiveInitTaskInfo r5 = new LiveInitTaskInfo("sdk_launcher_task", r4);     // Catch: Throwable -> L37
        ILiveInitTaskListener r6 = this.h;     // Catch: Throwable -> L37
        if (r6 == null) goto L30;
        r6.onTaskStart(r5);     // Catch: Throwable -> L37
    L30:
        r0.start();     // Catch: Throwable -> L37
        ILiveInitTaskListener r7 = this.h;     // Catch: Throwable -> L37
        if (r7 == null) goto L33;
        r7.onTaskEnd(r5);     // Catch: Throwable -> L37
    L33:
        r0 = r0.next();     // Catch: Throwable -> L37
        goto L9
    L11:
        this.g = true;     // Catch: Throwable -> L37
        monitor-exit(this);
    }

    public final synchronized void e() {
        monitor-enter(this);
    L23:
        th = move-exception;
        throw th;
    L4:
        if (this.e != null) goto L6;
    L21:
        monitor-exit(this);
        return;
    L6:
        if (ThreadMethodProxy.currentThread() == ThreadMethodProxy.getLooperThread(Looper.getMainLooper())) goto L21;
        this.f = ThreadMethodProxy.currentThread();     // Catch: Throwable -> L23
        AbsTask r0 = this.e;     // Catch: Throwable -> L23
        long r1 = System.currentTimeMillis();     // Catch: Throwable -> L23
        ArrayList r3 = new ArrayList();     // Catch: Throwable -> L23
        HashMap r4 = new HashMap();     // Catch: Throwable -> L23
    L9:
        if (r0 == null) goto L10;
        LiveInitTaskInfo r6 = new LiveInitTaskInfo("sdk_launcher_task", r0.getTaskBusinessInfo());     // Catch: Throwable -> L23
        long r7 = System.currentTimeMillis();     // Catch: Throwable -> L23
        ILiveInitTaskListener r5 = this.h;     // Catch: Throwable -> L23
        if (r5 == null) goto L16;
        r5.onTaskStart(r6);     // Catch: Throwable -> L23
    L16:
        r0.start();     // Catch: Throwable -> L23
        ILiveInitTaskListener r8 = this.h;     // Catch: Throwable -> L23
        if (r8 == null) goto L19;
        r8.onTaskEnd(r6);     // Catch: Throwable -> L23
    L19:
        long r9 = System.currentTimeMillis() - r7;     // Catch: Throwable -> L23
        r3.add(r0.getClass().getCanonicalName());     // Catch: Throwable -> L23
        r4.put(r0.getClass().getCanonicalName(), Long.valueOf(r9));     // Catch: Throwable -> L23
        r0 = r0.next();     // Catch: Throwable -> L23
        goto L9
    L10:
        x50.a.a(System.currentTimeMillis() - r1, r3, r4);     // Catch: Throwable -> L23
        this.f = null;     // Catch: Throwable -> L23
        this.g = true;     // Catch: Throwable -> L23
        monitor-exit(this);
    }

    public final AbsTask a() {
        int r1 = 0;
        this.d = (int[][]) Array.newInstance(Integer.TYPE, new int[]{this.b.size(), this.b.size()});
        int[] r0 = new int[this.b.size()];
        Iterator<Map.Entry<Integer, Integer>> r2 = this.b.entrySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L14;
        Map.Entry<Integer, Integer> r4 = r2.next();
        List<Integer> r5 = this.a.get(r4.getKey()).getPreTasks();
        if (r5 == null) goto L4;
        Iterator<Integer> r6 = r5.iterator();
    L9:
        if (r6.hasNext() == false) goto L4;
        Integer r7 = r6.next();
        if (r7 == r4.getKey()) goto L9;
        this.d[this.b.get(r7).intValue()][this.b.get(r4.getKey()).intValue()] = 1;
        goto L9
    L14:
        Stack r3 = new Stack();
        int r8 = this.b.size();
        int r9 = 0;
    L15:
        if (r9 >= r8) goto L17;
        r0[r9] = 0;
        r9 = r9 + 1;
    L17:
        if (r1 >= r8) goto L26;
        if (r0[r1] != 0) goto L25;
        if (g(r1, r0, r3) == true) goto L25;
        throw new RuntimeException(this.a.get(Integer.valueOf(r1)).getClass().getCanonicalName() + "在环上，重新review task依赖");
    L25:
        r1 = r1 + 1;
        goto L17
    L26:
        int r11 = -1;
        AbsTask r12 = null;
    L28:
        if (r3.empty() == true) goto L34;
        int r13 = this.c.get(r3.pop()).intValue();
        if (this.a.containsKey(Integer.valueOf(r11)) == false) goto L32;
        this.a.get(Integer.valueOf(r11)).append(this.a.get(Integer.valueOf(r13)));
    L33:
        r11 = r13;
        goto L28
    L32:
        r12 = this.a.get(Integer.valueOf(r13));
        goto L33
    L34:
        return r12;
    }

    public b() {
        this.a = new ConcurrentHashMap();
        this.b = new ConcurrentHashMap();
        this.c = new ConcurrentHashMap();
        new Handler(Looper.getMainLooper());
    }

    public final AbsTask b(int r2) {
        return this.a.get(Integer.valueOf(r2));
    }

    public final void setInitTaskListener(ILiveInitTaskListener r1) {
        this.h = r1;
    }

    public final void f(int r4, AbsTask r5) {
        if (this.a.containsKey(Integer.valueOf(r4)) == true) goto L6;
        this.a.put(Integer.valueOf(r4), r5);
        int r6 = this.b.size();
        this.b.put(Integer.valueOf(r4), Integer.valueOf(r6));
        this.c.put(Integer.valueOf(r6), Integer.valueOf(r4));
        return;
    }

    public final boolean g(int r5, int[] r6, Stack r7) {
        r6[r5] = -1;
        int r1 = 0;
    L4:
        if (r1 >= r6.length) goto L15;
        if (this.d[r5][r1] != 1) goto L14;
        int r2 = r6[r1];
        if (r2 < 0) goto L9;
        if (r2 == 1) goto L14;
        if (g(r1, r6, r7) == true) goto L14;
        return false;
    L9:
        return false;
    L14:
        r1 = r1 + 1;
        goto L4
    L15:
        r6[r5] = 1;
        r7.push(Integer.valueOf(r5));
        return true;
    }
}
