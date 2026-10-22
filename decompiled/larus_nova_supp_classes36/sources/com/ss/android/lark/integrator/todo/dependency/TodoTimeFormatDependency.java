package com.ss.android.lark.integrator.todo.dependency;

import com.larksuite.framework.callback.UICallbackExecutor;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.usersetting.service.timeformat.TimeFormatSetting;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class TodoTimeFormatDependency implements g7c.t {
    public a a;
    public final Lazy b;

    public static final class a implements com.ss.android.lark.usersetting.service.timeformat.a {
        public final /* synthetic */ TodoTimeFormatDependency a;

        /* JADX INFO: renamed from: com.ss.android.lark.integrator.todo.dependency.TodoTimeFormatDependency$a$a, reason: collision with other inner class name */
        public static final class RunnableC0124a implements Runnable {
            public final /* synthetic */ TodoTimeFormatDependency a;

            public RunnableC0124a(TodoTimeFormatDependency r1) {
                this.a = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Iterator r0 = ((CopyOnWriteArrayList) this.a.b.getValue()).iterator();     // Catch: Throwable -> L7
            L4:
                if (r0.hasNext() == false) goto L16;
                ((g7c.t.a) r0.next()).a();     // Catch: Throwable -> L7
                goto L4
            L16:
                return;
            L7:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L11;
                return;
            L11:
                throw th;
            }
        }

        public a(TodoTimeFormatDependency r1) {
            this.a = r1;
        }

        public final void a(TimeFormatSetting r2) {
            UICallbackExecutor.post(new RunnableC0124a(this.a));
        }
    }

    public final boolean c() {
        TimeFormatSetting r0 = com.ss.android.lark.usersetting.service.e.a.a.f();
        if (r0 != null) goto L5;
        boolean r3 = true;
    L6:
        if (r3 != true) goto L8;
    L7:
        return true;
    L8:
        if (r3 == true) goto L14;
        if (r0.getTimeFormat() == TimeFormatSetting.TimeFormat.TWENTY_FOUR_HOUR) goto L7;
        return false;
    L14:
        throw new NoWhenBranchMatchedException();
    L5:
        r3 = false;
        goto L6
    }

    public TodoTimeFormatDependency() {
        this.b = LazyKt.lazy(TodoTimeFormatDependency$mChangeListeners$2.INSTANCE);
    }

    public final void a(g7c.t.a r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        ((CopyOnWriteArrayList) this.b.getValue()).remove(r2);
        if (this.a != null) goto L5;
        return;
    L5:
        if (((CopyOnWriteArrayList) this.b.getValue()).size() == 0) goto L7;
        return;
    L7:
        if (com.ss.android.lark.usersetting.service.e.a.a == null) goto L12;
        a r3 = this.a;
        Object r0 = com.ss.android.lark.usersetting.service.timeformat.b.b;
        com.ss.android.lark.usersetting.service.timeformat.b r1 = com.ss.android.lark.usersetting.service.timeformat.b.b.a;
        if (r3 != null) goto L11;
        r1.getClass();
        goto L12
    L11:
        ((ConcurrentHashMap) r1.a).remove(r3);
    L12:
        this.a = null;
    }

    public final void b(g7c.t.a r3) {
        Intrinsics.checkNotNullParameter(r3, "newListener");
        ((CopyOnWriteArrayList) this.b.getValue()).add(r3);
        if (this.a != null) goto L8;
        a r4 = new a(this);
        this.a = r4;
        if (com.ss.android.lark.usersetting.service.e.a.a == null) goto L9;
        Object r0 = com.ss.android.lark.usersetting.service.timeformat.b.b;
        Map r1 = com.ss.android.lark.usersetting.service.timeformat.b.b.a.a;
        ConcurrentHashMap r2 = (ConcurrentHashMap) r1;
        r2.put(r4, com.ss.android.lark.usersetting.service.timeformat.b.b);
        return;
    L9:
        return;
    }
}
