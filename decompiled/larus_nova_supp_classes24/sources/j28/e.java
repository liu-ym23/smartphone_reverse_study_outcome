package j28;

import com.larksuite.framework.launch.scheduler.impl.StartAnchorTask;
import com.larksuite.framework.launch.task.ILaunchTask;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class e {
    public static final Object g = null;
    public final StartAnchorTask a;
    public final Map<Class<?>, Set<Class<?>>> b;
    public final Map<Class<?>, Set<Class<?>>> c;
    public final List<ILaunchTask> d;
    public final Map<Class<?>, Object> e;
    public final Map<Class<?>, ILaunchTask> f;

    static {
        g = new Object();
    }

    public e() {
        StartAnchorTask r0 = new StartAnchorTask();
        this.a = r0;
        this.b = new HashMap();
        this.c = new HashMap();
        this.e = new HashMap();
        HashMap r1 = new HashMap();
        this.f = r1;
        r1.put(r0.getClass(), r0);
        this.d = new ArrayList();
    }

    public final synchronized void c(ILaunchTask r5) {
        monitor-enter(this);
        Map<Class<?>, Object> r0 = this.e;     // Catch: Throwable -> L20
        HashMap r1 = (HashMap) r0;     // Catch: Throwable -> L20
        r1.put(r5.getClass(), g);     // Catch: Throwable -> L20
        Map<Class<?>, Set<Class<?>>> r2 = this.b;     // Catch: Throwable -> L20
        HashMap r3 = (HashMap) r2;     // Catch: Throwable -> L20
        Set r4 = (Set) r3.remove(r5.getClass());     // Catch: Throwable -> L20
        Map<Class<?>, ILaunchTask> r6 = this.f;     // Catch: Throwable -> L20
        HashMap r7 = (HashMap) r6;     // Catch: Throwable -> L20
        r7.remove(r5.getClass());     // Catch: Throwable -> L20
        if (f28.a.a(r4) == false) goto L7;
        monitor-exit(this);
        return;
    L7:
        Iterator r8 = r4.iterator();     // Catch: Throwable -> L20
    L8:
        if (r8.hasNext() == false) goto L18;
        Class r9 = (Class) r8.next();     // Catch: Throwable -> L20
        Set r10 = (Set) ((HashMap) this.c).get(r9);     // Catch: Throwable -> L20
        if (f28.a.a(r10) == true) goto L13;
        r10.remove(r5.getClass());     // Catch: Throwable -> L20
    L13:
        ILaunchTask r11 = (ILaunchTask) ((HashMap) this.f).get(r9);     // Catch: Throwable -> L20
        if (f28.a.a(r10) == false) goto L8;
        if (r11 == null) goto L8;
        ((ArrayList) this.d).add(r11);     // Catch: Throwable -> L20
        goto L8
    L18:
        monitor-exit(this);
        return;
    L20:
        th = move-exception;
        throw th;
    }

    public final void a(Class<?> r3, Class<?> r4) {
        Set r0 = (Set) ((HashMap) this.b).get(r3);
        if (r0 != null) goto L5;
        r0 = new HashSet();
        ((HashMap) this.b).put(r3, r0);
    L5:
        r0.add(r4);
        Set r1 = (Set) ((HashMap) this.c).get(r4);
        if (r1 != null) goto L8;
        r1 = new HashSet();
        ((HashMap) this.c).put(r4, r1);
    L8:
        r1.add(r3);
    }

    public final synchronized void b(ILaunchTask r3, List<Class<? extends ILaunchTask>> r4) {
        monitor-enter(this);
        Map<Class<?>, ILaunchTask> r0 = this.f;     // Catch: Throwable -> L15
        HashMap r1 = (HashMap) r0;     // Catch: Throwable -> L15
        r1.put(r3.getClass(), r3);     // Catch: Throwable -> L15
        a(this.a.getClass(), r3.getClass());     // Catch: Throwable -> L15
        if (f28.a.a(r4) == true) goto L13;
        Iterator<Class<? extends ILaunchTask>> r5 = r4.iterator();     // Catch: Throwable -> L15
    L7:
        if (r5.hasNext() == false) goto L13;
        Class<? extends ILaunchTask> r2 = r5.next();     // Catch: Throwable -> L15
        if (((HashMap) this.e).containsKey(r2) == true) goto L7;
        a(r2, r3.getClass());     // Catch: Throwable -> L15
    L13:
        monitor-exit(this);
        return;
    L15:
        th = move-exception;
        throw th;
    }
}
