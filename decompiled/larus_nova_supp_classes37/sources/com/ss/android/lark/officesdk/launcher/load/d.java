package com.ss.android.lark.officesdk.launcher.load;

import android.content.Context;
import com.larksuite.framework.launch.task.ILaunchTask;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class d {
    public final j28.a a;

    public static final class a {
    }

    public static final class b {
        public b() {
        }

        public final void a(Set<? extends Class<? extends ILaunchTask<?>>> r3) {
            Intrinsics.checkNotNullParameter(r3, "remainingTasks");
            Log.e("OfficeLoadTaskRunner", "load task dependency cycle or unresolved dependency in " + r3);
        }

        public final void c(ILaunchTask<?> r3) {
            Intrinsics.checkNotNullParameter(r3, "task");
            Log.i("OfficeLoadTaskRunner", "execute load task start, taskName=" + r3.f());
        }

        public final void d(ILaunchTask<?> r3) {
            Intrinsics.checkNotNullParameter(r3, "task");
            Log.i("OfficeLoadTaskRunner", "execute load task success, taskName=" + r3.f());
        }

        public final void b(ILaunchTask<?> r3, Throwable r4) {
            Intrinsics.checkNotNullParameter(r3, "task");
            Intrinsics.checkNotNullParameter(r4, "throwable");
            Log.e("OfficeLoadTaskRunner", "[" + r3.f() + "] load task failed", r4);
        }
    }

    static {
    }

    public d() {
        this.a = new j28.a();
    }

    public final boolean a(Context r11, List<? extends ILaunchTask<?>> r12) {
        Intrinsics.checkNotNullParameter(r11, "context");
        Intrinsics.checkNotNullParameter(r12, "tasks");
        j28.a r1 = this.a;
        b r2 = new b();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r12, "tasks");
        Intrinsics.checkNotNullParameter(r12, "tasks");
        LinkedHashMap r0 = new LinkedHashMap();
        Iterator<T> r3 = r12.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ILaunchTask r4 = (ILaunchTask) r3.next();
        r0.put(r4.getClass(), r4);
        goto L4
    L6:
        ArrayList r5 = new ArrayList();
    L8:
        if ((!r0.isEmpty()) == false) goto L36;
        Collection r6 = r0.values();
        ArrayList r7 = new ArrayList();
        Iterator r8 = r6.iterator();
    L11:
        if (r8.hasNext() == false) goto L30;
        Object r9 = r8.next();
        List r10 = ((ILaunchTask) r9).e();
        if (r10 != null) goto L15;
        r10 = CollectionsKt.emptyList();
    L15:
        List r13 = r10;
        if ((r13 instanceof Collection) == true) goto L18;
    L20:
        Iterator r14 = r13.iterator();
    L22:
        if (r14.hasNext() == false) goto L26;
        if (r0.containsKey((Class) r14.next()) == false) goto L22;
        boolean r15 = false;
    L27:
        if (r15 == false) goto L11;
        r7.add(r9);
    L26:
        r15 = true;
        goto L27
    L18:
        if (r13.isEmpty() == false) goto L20;
    L30:
        if (r7.isEmpty() == true) goto L31;
        Iterator r16 = r7.iterator();
    L34:
        if (r16.hasNext() == false) goto L8;
        ILaunchTask r17 = (ILaunchTask) r16.next();
        Intrinsics.checkNotNull(r17);
        r5.add(r17);
        r0.remove(r17.getClass());
        goto L34
    L31:
        r5 = null;
    L36:
        if (r5 != null) goto L42;
        LinkedHashSet r18 = new LinkedHashSet();
        Iterator<T> r19 = r12.iterator();
    L39:
        if (r19.hasNext() == false) goto L41;
        r18.add(((ILaunchTask) r19.next()).getClass());
        goto L39
    L41:
        r2.a(r18);
    L50:
        return false;
    L42:
        Iterator r110 = r5.iterator();
    L44:
        if (r110.hasNext() == false) goto L69;
        ILaunchTask<?> r20 = (ILaunchTask) r110.next();
        r2.c(r20);     // Catch: Throwable -> L48
        r20.a(r11);     // Catch: Throwable -> L48
        r2.d(r20);     // Catch: Throwable -> L48
        Unit r21 = Unit.INSTANCE;     // Catch: Throwable -> L48
    L48:
        th = move-exception;
        r2.b(r20, th);
        goto L50
    L69:
        return true;
    }
}
