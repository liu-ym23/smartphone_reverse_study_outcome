package com.larus.dora.impl.alive;

import com.larus.dora.api.IDoraService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.j1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class h {
    public static final CoroutineScope a = null;
    public static final StateFlowImpl b = null;
    public static final int c = 0;
    public static final Lazy d = null;

    public h() {
    }

    static {
        a = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());
        b = j1.a(Boolean.FALSE);
        IDoraService r0 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r0 == null) goto L5;
        int r1 = r0.F();
    L6:
        c = r1;
        d = LazyKt.lazy(new d());
        return;
    L5:
        r1 = 3;
        goto L6
    }

    public static StateFlowImpl a() {
        BuildersKt.launch$default(a, null, null, new DoraKeepAliveBalloon$checkShowState$1(null), 3, null);
        return b;
    }
}
