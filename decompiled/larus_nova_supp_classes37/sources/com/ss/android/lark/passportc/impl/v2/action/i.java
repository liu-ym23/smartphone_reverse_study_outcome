package com.ss.android.lark.passportc.impl.v2.action;

import com.ss.android.lark.log.Log;
import com.ss.android.lark.passport.signinsdk_api.account.User;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.entity.UserState;
import com.ss.android.lark.passportc.impl.v2.entity.UpdateUserContext;
import com.ss.android.lark.passportc.internal.t;
import com.ss.android.lark.passportc.task.ComponentTaskScheduler;
import com.ss.android.lark.passportc.task.TaskType;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public abstract class i<Component> implements c {
    public final m<Component> a;
    public final Set<com.ss.android.lark.passportc.task.d> b;
    public final l0c.d c;
    public final t d;
    public final l0c.c e;

    @Override // i0c.b
    public /* bridge */ /* synthetic */ h0c.b a(UpdateUserContext r1, Object r2, Object r3) {
        return b(r1, (UserState) r2, (UserState) r3);
    }

    public h0c.b<j0c.a> b(UpdateUserContext r10, UserState r11, UserState r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "from");
        Intrinsics.checkNotNullParameter(r12, "to");
        com.ss.android.lark.passportc.api.d r13 = r10.e;
        User r14 = r10.c;
        UserSession r15 = r10.j;
        if (r15 == null) goto L18;
        Set r3 = SetsKt.plus(this.b, this.a.c(r15));
        j0c.e r0 = new j0c.e(new f0c.g(r14, r15), r13.d, null);
        if (r3.isEmpty() == false) goto L19;
        int r16 = h0c.b.b;
        return new h0c.b.C0143b(new j0c.a(false, "online task is empty, userId:" + r14.userId, null, null, 28));
    L19:
        Object r17 = new ComponentTaskScheduler(r3, TaskType.ONLINE, this.a.g(), this.d, this.c, this.e).b(r0, r13.b, r13.c).blockingFirst();     // Catch: NoSuchElementException -> L10
        Intrinsics.checkNotNull(r17, "null cannot be cast to non-null type com.ss.android.lark.passportc.task.entity.ExecuteTaskResult");     // Catch: NoSuchElementException -> L10
        j0c.a r18 = (j0c.a) r17;     // Catch: NoSuchElementException -> L10
    L13:
        if (r18.a == false) goto L15;
        int r19 = h0c.b.b;
        return new h0c.b.c(r18);
    L15:
        int r110 = h0c.b.b;
        return new h0c.b.C0143b(r18);
    L10:
        e = move-exception;
        Log.e("ComponentTask", "get execute task error :" + e.getMessage());
        r18 = new j0c.a(false, "online transfer error :" + e.getMessage(), null, null, 28);
        goto L13
    L18:
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public i(m<Component> r2, Set<com.ss.android.lark.passportc.task.d> r3, l0c.d r4, t r5, l0c.c r6) {
        Intrinsics.checkNotNullParameter(r2, "userComponentDelegate");
        Intrinsics.checkNotNullParameter(r3, "globalOnlineTasks");
        Intrinsics.checkNotNullParameter(r4, "taskMonitor");
        Intrinsics.checkNotNullParameter(r5, "executors");
        Intrinsics.checkNotNullParameter(r6, "userFlowMonitor");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
