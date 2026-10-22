package o1c;

import com.ss.android.lark.preload.v2.condition.ConditionSet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class e {
    public c<?, ?> a;
    public Object b;
    public final boolean c;

    public final c<?, ?> a() {
        c<?, ?> r0 = this.a;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("task");
        r0 = null;
    L6:
        Object r3 = this.b;
        boolean r4 = this.c;
        Intrinsics.checkNotNullParameter(r0, "task");
        ConditionSet r1 = new ConditionSet();
        r1.a(new j1c.a());
        r1.a(new j1c.c());
        r1.a(new j1c.b());
        r0.L(r1);
        r0.N0(r4);
        if (r4 == false) goto L9;
        ConditionSet r2 = new ConditionSet();
        r2.a(new h1c.b());
        r0.o0(r2);
    L10:
        r0.e1(new ConditionSet());
        r0.b0(null);
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.ss.android.lark.preload.v2.task.ITask<kotlin.Any?, kotlin.Any?>");
        r0.h1(r3);
        r0.y0(0);
        return r0;
    L9:
        r0.o0(new ConditionSet());
        goto L10
    }

    public e() {
        this.c = true;
    }
}
