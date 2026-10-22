package g0c;

import com.ss.android.lark.passportc.entity.UserState;
import com.ss.android.lark.passportc.impl.v2.action.g;
import com.ss.android.lark.passportc.impl.v2.action.h;
import com.ss.android.lark.passportc.impl.v2.d;
import com.ss.android.lark.passportc.impl.v2.entity.UpdateUserContext;
import com.ss.android.lark.passportc.internal.t;
import e0c.l;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class b extends h<l> {
    @Override // i0c.b
    public final h0c.b a(UpdateUserContext r4, Object r5, Object r6) {
        UserState r7 = (UserState) r5;
        UserState r8 = (UserState) r6;
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r7, "from");
        Intrinsics.checkNotNullParameter(r8, "to");
        d r0 = r4.g;
        if (r0 == null) goto L5;
        r0.m(r4, r7, r8);
    L5:
        h0c.b<j0c.a> r1 = super.b(r4, r7, r8);
        d r2 = r4.g;
        if (r2 == null) goto L8;
        r2.k(r4, r7, r8, (h0c.b.c) r1);
    L8:
        return r1;
    }

    public b(g r8, l0c.d r9, t r10, l0c.c r11) {
        Intrinsics.checkNotNullParameter(r8, "foregroundComponentDelegate");
        Intrinsics.checkNotNullParameter(r9, "taskMonitor");
        Intrinsics.checkNotNullParameter(r10, "executors");
        Intrinsics.checkNotNullParameter(r11, "userFlowMonitor");
        super(r8, r9, r10, r11, true);
    }
}
