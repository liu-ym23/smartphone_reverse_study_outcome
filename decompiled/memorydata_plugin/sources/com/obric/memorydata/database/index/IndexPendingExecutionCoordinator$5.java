package com.obric.memorydata.database.index;

import android.os.SystemClock;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* synthetic */ class IndexPendingExecutionCoordinator$5 extends FunctionReferenceImpl implements Function0<Long> {
    public static final IndexPendingExecutionCoordinator$5 INSTANCE = null;

    static {
        INSTANCE = new IndexPendingExecutionCoordinator$5();
    }

    IndexPendingExecutionCoordinator$5() {
        super(0, SystemClock.class, "elapsedRealtime", "elapsedRealtime()J", 0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Long invoke() {
        return Long.valueOf(SystemClock.elapsedRealtime());
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Long invoke() {
        return invoke();
    }
}
