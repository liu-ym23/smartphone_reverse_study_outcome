package com.larus.bmhome.bigimg.download;

import java.util.Collection;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class e implements Function2 {
    public /* synthetic */ e() {
    }

    public final Object invoke(Object r2, Object r3) {
        ((Boolean) r2).booleanValue();
        String r4 = (String) r3;
        Intrinsics.checkNotNullParameter(r4, "url");
        StateFlowImpl r5 = ImageDownloadLoadingMgr.b;
        List r0 = CollectionsKt.toMutableList((Collection) r5.getValue());
        r0.remove(r4);
        r5.setValue(r0);
        Job r6 = ImageDownloadLoadingMgr.d.get(r4);
        if (r6 == null) goto L6;
        Job.DefaultImpls.cancel$default(r6, null, 1, null);
    L6:
        return Unit.INSTANCE;
    }
}
