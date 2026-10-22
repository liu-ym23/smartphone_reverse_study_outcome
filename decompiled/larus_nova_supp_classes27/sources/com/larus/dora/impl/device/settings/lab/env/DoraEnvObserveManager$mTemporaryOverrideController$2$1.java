package com.larus.dora.impl.device.settings.lab.env;

import android.os.SystemClock;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class DoraEnvObserveManager$mTemporaryOverrideController$2$1 extends FunctionReferenceImpl implements Function0<Long> {
    public static final DoraEnvObserveManager$mTemporaryOverrideController$2$1 INSTANCE = null;

    static {
        INSTANCE = new DoraEnvObserveManager$mTemporaryOverrideController$2$1();
    }

    public DoraEnvObserveManager$mTemporaryOverrideController$2$1() {
        super(0, SystemClock.class, "elapsedRealtime", "elapsedRealtime()J", 0);
    }

    public final Long invoke() {
        return Long.valueOf(SystemClock.elapsedRealtime());
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m101invoke() {
        return invoke();
    }
}
