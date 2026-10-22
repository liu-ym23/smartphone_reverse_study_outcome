package g0c;

import com.ss.android.lark.passportc.entity.UserState;
import com.ss.android.lark.passportc.impl.v2.action.g;
import com.ss.android.lark.passportc.impl.v2.action.i;
import com.ss.android.lark.passportc.impl.v2.d;
import com.ss.android.lark.passportc.impl.v2.entity.UpdateUserContext;
import com.ss.android.lark.passportc.internal.t;
import e0c.l;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class c extends i<l> {
    @Override // com.ss.android.lark.passportc.impl.v2.action.i, i0c.b
    public final /* bridge */ /* synthetic */ h0c.b a(UpdateUserContext r1, Object r2, Object r3) {
        return b(r1, (UserState) r2, (UserState) r3);
    }

    @Override // com.ss.android.lark.passportc.impl.v2.action.i
    public final h0c.b<j0c.a> b(UpdateUserContext r3, UserState r4, UserState r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "from");
        Intrinsics.checkNotNullParameter(r5, "to");
        d r0 = r3.g;
        if (r0 == null) goto L5;
        r0.p(r3, r4, r5);
    L5:
        h0c.b<j0c.a> r1 = super.b(r3, r4, r5);
        d r2 = r3.g;
        if (r2 == null) goto L8;
        r2.g(r3, r4, r5, r1);
    L8:
        return r1;
    }

    public c(g r2, Set<com.ss.android.lark.passportc.task.d> r3, l0c.d r4, t r5, l0c.c r6) {
        Intrinsics.checkNotNullParameter(r2, "foregroundComponentDelegate");
        Intrinsics.checkNotNullParameter(r3, "globalOnlineTasks");
        Intrinsics.checkNotNullParameter(r4, "taskMonitor");
        Intrinsics.checkNotNullParameter(r5, "executors");
        Intrinsics.checkNotNullParameter(r6, "userFlowMonitor");
        super(r2, r3, r4, r5, r6);
    }
}
