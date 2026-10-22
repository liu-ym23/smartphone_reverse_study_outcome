package com.larus.bmhome.video.download;

import java.util.Collection;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import nr9.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class b implements Function1 {
    public final /* synthetic */ VideoDownloadLoadingMgr a;

    public /* synthetic */ b(VideoDownloadLoadingMgr r1) {
        this.a = r1;
    }

    public final Object invoke(Object r4) {
        VideoDownloadLoadingMgr r0 = this.a;
        g r5 = (g) r4;
        Intrinsics.checkNotNullParameter(r5, "data");
        List r1 = CollectionsKt.toMutableList((Collection) r0.k.getValue());
        r1.remove(r5);
        r0.k.setValue(r1);
        Job r6 = r0.m.get(r5);
        if (r6 == null) goto L6;
        Job.DefaultImpls.cancel$default(r6, null, 1, null);
    L6:
        return Unit.INSTANCE;
    }
}
