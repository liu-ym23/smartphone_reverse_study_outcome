package com.larus.business.multitask_management.impl.component;

import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import kl9.u;
import kotlin.collections.CollectionsKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class g {
    public static final i1<List<u>> a = null;

    static {
        il9.a r0 = (il9.a) ServiceManager.get().getService(il9.a.class);
        if (r0 == null) goto L6;
        StateFlowImpl r1 = r0.I0();
        if (r1 == null) goto L6;
    L7:
        a = r1;
        return;
    L6:
        r1 = j1.a(CollectionsKt.emptyList());
        goto L7
    }
}
