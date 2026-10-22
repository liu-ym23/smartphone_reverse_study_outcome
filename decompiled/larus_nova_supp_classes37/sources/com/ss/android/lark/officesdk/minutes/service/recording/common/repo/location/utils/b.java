package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.location.utils;

import com.ss.android.lark.location.dto.POIInfo;
import com.ss.android.lark.location.service.h;
import com.ss.android.lark.location.service.k;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class b implements h.b {
    public final /* synthetic */ MmRecordingLocationHelper a;
    public final /* synthetic */ Function1<POIInfo, Unit> b;

    public final void a(k r4) {
        this.b.invoke(null);
        lvb.a.e(this.a.b, "[getPOIInfo] onSearResultError, errorCode=" + r4.b);
    }

    public final void b(List<POIInfo> r5) {
        String r0 = this.a.b;
        StringBuilder r1 = new StringBuilder("[getPOIInfo] success list size=");
        POIInfo r2 = null;
        if (r5 == null) goto L5;
        Integer r3 = Integer.valueOf(r5.size());
    L6:
        r1.append(r3);
        r1.append(' ');
        lvb.a.e(r0, r1.toString());
        Function1<POIInfo, Unit> r4 = this.b;
        if (r5 == null) goto L9;
        r2 = (POIInfo) CollectionsKt.firstOrNull(r5);
    L9:
        r4.invoke(r2);
        return;
    L5:
        r3 = null;
        goto L6
    }

    public b(MmRecordingLocationHelper r1, Function1<? super POIInfo, Unit> r2) {
        this.a = r1;
        this.b = r2;
    }
}
