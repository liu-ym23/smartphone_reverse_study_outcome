package com.ss.android.lark.conditional.access.nopermission.manager;

import androidx.lifecycle.Observer;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class e<T> implements Observer {
    public final /* synthetic */ NoPermissionModuleManager a;

    public e(NoPermissionModuleManager r1) {
        this.a = r1;
    }

    public final void onChanged(Object r5) {
        if (((Boolean) r5).booleanValue() == true) goto L11;
        NoPermissionModuleManager r6 = this.a;
        r6.n = false;
        Iterator<NoPermissionModuleManager.b> r0 = r6.l.iterator();
    L6:
        if (r0.hasNext() == false) goto L8;
        NoPermissionModuleManager.b r1 = r0.next();
        int r2 = ScsLogger.a;
        ScsLogger.d("SecurityPolicy_NoPermissionModuleManager", "proceed navigate " + r1.c);
        r1.c.a(r1.a, r1.b);
        goto L6
    L8:
        r6.l.clear();
        return;
    }
}
