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
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public abstract class h<Component> implements c {
    public final m<Component> a;
    public final l0c.d b;
    public final t c;
    public final l0c.c d;
    public final boolean e;

    public h0c.b<j0c.a> b(UpdateUserContext r13, UserState r14, UserState r15) {
        Intrinsics.checkNotNullParameter(r13, "context");
        Intrinsics.checkNotNullParameter(r14, "from");
        Intrinsics.checkNotNullParameter(r15, "to");
        com.ss.android.lark.passportc.api.d r16 = r13.e;
        User r17 = r13.c;
        UserSession r0 = r13.j;
        if (r0 == null) goto L23;
        Set<com.ss.android.lark.passportc.task.c> r3 = this.a.b(r0);
        String r10 = "foreground";
        if (r3.isEmpty() == false) goto L11;
        StringBuilder r18 = new StringBuilder();
        if (this.e == true) goto L10;
        r10 = "background";
    L10:
        r18.append(r10);
        r18.append(" offline task is empty :");
        r18.append(r16.b);
        String r2 = r18.toString();
        Log.i("ComponentTask", r2);
        j0c.a r19 = new j0c.a(false, r2, null, null, 28);
    L20:
        int r110 = h0c.b.b;
        return new h0c.b.c(r19);
    L11:
        j0c.e r1 = new j0c.e(new f0c.g(r17, r0), r16.d, r13.f);
        r19 = (j0c.a) new ComponentTaskScheduler(r3, TaskType.OFFLINE, this.a.f(), this.c, this.b, this.d).b(r1, r16.b, r16.c).blockingFirst();     // Catch: NoSuchElementException -> L14
    L14:
        e = move-exception;
        StringBuilder r111 = new StringBuilder();
        if (this.e == true) goto L19;
        r10 = "background";
    L19:
        r111.append(r10);
        r111.append(" offline execute task  result error :");
        r111.append(e.getMessage());
        String r4 = r111.toString();
        Log.e("ComponentTask", r4);
        r19 = new j0c.a(false, r4, null, null, 28);
        goto L20
    L23:
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public h(m<Component> r2, l0c.d r3, t r4, l0c.c r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r2, "userComponentDelegate");
        Intrinsics.checkNotNullParameter(r3, "taskMonitor");
        Intrinsics.checkNotNullParameter(r4, "executors");
        Intrinsics.checkNotNullParameter(r5, "userFlowMonitor");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
