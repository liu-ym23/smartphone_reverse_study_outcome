package com.ss.android.lark.integrator.security.compliance.psda;

import android.app.Application;
import com.bytedance.supervisor.runtime.common.Logger;
import com.ss.android.lark.utils.LarkContext;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import lf7.d;
import mf7.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b {

    public static final class a {
    }

    static {
    }

    public static void a() {
        lf7.b r0 = d.a;
        Application r1 = LarkContext.getApplication();
        lf7.b r2 = new lf7.b(SensitiveApiManageModule$init$1.INSTANCE);
        Intrinsics.checkNotNullParameter(r1, "application");
        Intrinsics.checkNotNullParameter(r2, "config");
        d.a = r2;
        if (nf7.a.a() == true) goto L5;
        Logger.c("SensitiveApiSupervisor", "SensitiveApiSupervisor disable");
        nf7.d.a("SensitiveApiSupervisor", "SensitiveApiSupervisor disable");
        return;
    L5:
        ConcurrentHashMap r3 = com.bytedance.supervisor.runtime.config.b.b;
        com.bytedance.supervisor.runtime.config.b.d(r1);
        List r4 = mf7.b.a;
        ArrayList r5 = (ArrayList) r4;
        r5.add(new mf7.d());
        r5.add(new e());
        r5.add(new mf7.a());
    }
}
