package com.obric.assistant.state.impl.v2.wakelock;

import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.sync.MutexImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class ObricWakelockTimeoutHandler {
    public final long a;
    public final Function0<Unit> b;
    public final String c;
    public final CoroutineScope d;
    public final MutexImpl e;
    public Job f;

    public ObricWakelockTimeoutHandler(d r3) {
        Intrinsics.checkNotNullParameter(r3, "onTimerFinish");
        this.a = 150000;
        this.b = r3;
        this.c = ObricWakelockTimeoutHandler.class.getSimpleName();
        this.d = CoroutineScopeKt.CoroutineScope(ExecutorsKt.from(PThreadExecutorsUtils.newSingleThreadExecutor(new e())).plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
        this.e = kotlinx.coroutines.sync.b.a();
    }

    public final void a(String r9) {
        FLogger.a.i(this.c, r9.concat("ObricWakelockTimeoutHandler"));
        BuildersKt.launch$default(this.d, null, null, new ObricWakelockTimeoutHandler$scheduleTimeout$1(this, null), 3, null);
    }
}
