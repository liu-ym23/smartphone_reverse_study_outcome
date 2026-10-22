package com.obric.miniapp.alarm;

import com.larus.dora.api.IDoraService;
import com.larus.home.api.main.IPrivacyService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class AlarmTtsNotificationDispatcher {
    public static final Lazy a = null;
    public static final Lazy b = null;
    public static final MutableSharedFlow<a> c = null;
    public static final AlarmTtsNotificationDispatcher$special$$inlined$map$1 d = null;
    public static final CoroutineScope e = null;

    public AlarmTtsNotificationDispatcher() {
    }

    static {
        a = LazyKt.lazy(new n());
        b = LazyKt.lazy(new o());
        final MutableSharedFlow<a> r0 = SharedFlowKt.MutableSharedFlow$default(0, 64, BufferOverflow.DROP_OLDEST, 1, null);
        c = r0;
        Flow<e0> r1 = new AlarmTtsNotificationDispatcher$special$$inlined$mapNotNull$1(r0);
        Intrinsics.checkNotNullParameter(r1, "<this>");
        d = new AlarmTtsNotificationDispatcher$special$$inlined$map$1(kotlinx.coroutines.flow.e.g(new AlarmTtsNotificationDispatcherKt$chunked$1(r1, 200, null)));
        e = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().getImmediate().plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
    }

    public static final IDoraService a() {
        IPrivacyService r0 = (IPrivacyService) ServiceManager.get().getService(IPrivacyService.class);
        if (r0 == null) goto L7;
        boolean r1 = true;
        if (r0.a() != true) goto L7;
    L8:
        if (r1 == true) goto L12;
        return null;
    L12:
        return (IDoraService) ServiceManager.get().getService(IDoraService.class);
    L7:
        r1 = false;
        goto L8
    }
}
