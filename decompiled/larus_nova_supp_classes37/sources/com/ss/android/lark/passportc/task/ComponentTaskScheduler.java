package com.ss.android.lark.passportc.task;

import android.os.SystemClock;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.api.ExecuteStrategy;
import com.ss.android.lark.passportc.internal.t;
import io.reactivex.Observable;
import io.reactivex.functions.Action;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class ComponentTaskScheduler {
    public final Set<f> a;
    public final TaskType b;
    public final List<j0c.b> c;
    public final t d;
    public final l0c.d e;
    public final l0c.c f;

    public static final class a implements Action {
        public final /* synthetic */ long a;

        public a(long r1) {
            this.a = r1;
        }

        public final void run() {
            Log.i("ComponentTask", "component task list execute end, cost=" + (SystemClock.elapsedRealtime() - this.a));
        }
    }

    public static void a(List r3, List r4, Map r5) {
        Iterator r6 = r4.iterator();
    L4:
        if (r6.hasNext() == false) goto L12;
        j0c.b r0 = (j0c.b) r6.next();
        if ((!r3.contains(r0)) == false) goto L11;
        f r1 = (f) ((LinkedHashMap) r5).get(r0.a);
        if (r1 == null) goto L4;
        a(CollectionsKt.plus(r3, r0), r1.dependencies(), r5);
        goto L4
    L11:
        throw new IllegalStateException(("find circular dependency : " + r3 + " -> " + r0).toString());
    }

    public final Observable<j0c.a> b(final j0c.e r4, final ExecuteStrategy r5, final j0c.a r6) {
        Intrinsics.checkNotNullParameter(r4, "userContext");
        Intrinsics.checkNotNullParameter(r5, "executeStrategy");
        long r0 = SystemClock.elapsedRealtime();
        return Observable.create(new ComponentTaskScheduler$start$1(this, r5, r4, r6)).doOnTerminate(new a(r0));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ComponentTaskScheduler(Set<? extends f> r2, TaskType r3, List<j0c.b> r4, t r5, l0c.d r6, l0c.c r7) {
        Intrinsics.checkNotNullParameter(r2, "taskSet");
        Intrinsics.checkNotNullParameter(r3, "taskType");
        Intrinsics.checkNotNullParameter(r4, "orderList");
        Intrinsics.checkNotNullParameter(r5, "passportExecutors");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }
}
