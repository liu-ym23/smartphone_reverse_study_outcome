package com.ss.android.lark.passportc.impl.v2.state;

import com.ss.android.lark.passportc.api.f;
import com.ss.android.lark.passportc.impl.v2.action.g;
import com.ss.android.lark.passportc.internal.p;
import com.ss.android.lark.passportc.internal.t;
import com.ss.android.lark.passportc.task.d;
import java.util.Set;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;
import l0c.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a {
    public final g a;
    public final com.ss.android.lark.passportc.impl.v2.action.a b;
    public final f c;
    public final Set<d> d;
    public final p e;
    public final l0c.d f;
    public final t g;
    public final c h;

    @Inject
    public a(g r2, com.ss.android.lark.passportc.impl.v2.action.a r3, f r4, Set<d> r5, p r6, l0c.d r7, t r8, c r9) {
        Intrinsics.checkNotNullParameter(r2, "foregroundComponentDelegate");
        Intrinsics.checkNotNullParameter(r3, "backgroundComponentDelegate");
        Intrinsics.checkNotNullParameter(r4, "backgroundUserService");
        Intrinsics.checkNotNullParameter(r5, "globalOnlineTasks");
        Intrinsics.checkNotNullParameter(r6, "userDataSource");
        Intrinsics.checkNotNullParameter(r7, "taskMonitor");
        Intrinsics.checkNotNullParameter(r8, "executors");
        Intrinsics.checkNotNullParameter(r9, "userFlowMonitor");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
    }
}
