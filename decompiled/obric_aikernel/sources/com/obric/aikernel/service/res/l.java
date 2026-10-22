package com.obric.aikernel.service.res;

import androidx.work.WorkRequest;
import com.bytedance.crash.resource.vmmonitor.VmMonitorConfig;
import com.obric.aikernel.res.update.MetadataRequestFailureKind;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class l {
    public static final String a(String r10, long r11, long r12, long r13) {
        Intrinsics.checkNotNullParameter(r10, "sourceName");
        return "startup " + r10 + " start from " + r11 + ", interval: " + r12 + "ms, triggerToken: " + r13;
    }

    public static final boolean b(MetadataRequestFailureKind r10) {
        return CollectionsKt.contains(SetsKt.setOf(new MetadataRequestFailureKind[]{MetadataRequestFailureKind.NO_NETWORK, MetadataRequestFailureKind.UNKNOWN_TRANSPORT, MetadataRequestFailureKind.TLS_BOOTSTRAP_PENDING}), r10);
    }

    public static final long c(Long r10) {
        if (r10 != null) goto L6;
        return 5000;
    L6:
        if (r10.longValue() != 5000) goto L9;
        return 15000;
    L9:
        if (r10.longValue() != 15000) goto L11;
        return WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS;
    L11:
        return VmMonitorConfig.SLEEP_TIME_BEFORE_RECOVER;
    }

    public static final m d(n r10, boolean r11, MetadataRequestFailureKind r12) {
        Intrinsics.checkNotNullParameter(r10, "state");
        if (r10.d() == true) goto L7;
        return new m(n.b(r10, false, false, null, 1, null), false, null);
    L7:
        if (r11 == false) goto L11;
        return new m(new n(false, false, null, 6, null), true, null);
    L11:
        if (b(r12) == false) goto L15;
        long r13 = c(r10.e());
        return new m(new n(true, false, Long.valueOf(r13)), false, Long.valueOf(r13));
    L15:
        return new m(new n(false, false, null, 6, null), true, null);
    }
}
