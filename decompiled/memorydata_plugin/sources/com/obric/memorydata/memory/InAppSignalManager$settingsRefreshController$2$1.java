package com.obric.memorydata.memory;

import android.os.SystemClock;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* synthetic */ class InAppSignalManager$settingsRefreshController$2$1 extends FunctionReferenceImpl implements Function0<Long> {
    public static final InAppSignalManager$settingsRefreshController$2$1 INSTANCE = null;

    static {
        INSTANCE = new InAppSignalManager$settingsRefreshController$2$1();
    }

    InAppSignalManager$settingsRefreshController$2$1() {
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
