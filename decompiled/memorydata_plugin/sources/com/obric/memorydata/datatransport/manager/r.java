package com.obric.memorydata.datatransport.manager;

import com.obric.memorydata.datatransport.utils.RoomToExcelExporter;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0000\u001a(\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006H\u0000¨\u0006\u0007"}, d2 = {"countRows", "", "Lcom/obric/memorydata/datatransport/utils/RoomToExcelExporter$TableExportResult;", "groupValue", "", "excludedGroupValues", "", "data_transport_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class r {
    public static final long a(RoomToExcelExporter.e r8, String r9, Set<String> r10) {
        Set r11 = (Set) ZeusTransformUtils.wrapperContextForParams(r10, Set.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "<this>");
        Intrinsics.checkNotNullParameter(r11, "excludedGroupValues");
        if (r9 == null) goto L8;
        Long r12 = (Long) ZeusTransformUtils.preCheckCast(r8.c().get(r9), Long.class, "com.obric.memorydata.plugin");
        if (r12 != null) goto L7;
        return 0;
    L7:
        return r12.longValue();
    L8:
        Iterator r13 = ((Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        long r4 = 0;
    L10:
        if (r13.hasNext() == false) goto L17;
        Long r14 = (Long) ZeusTransformUtils.preCheckCast(r8.c().get((String) ZeusTransformUtils.preCheckCast(r13.next(), String.class, "com.obric.memorydata.plugin")), Long.class, "com.obric.memorydata.plugin");
        if (r14 == null) goto L14;
        long r6 = r14.longValue();
    L15:
        r4 = r4 + r6;
        goto L10
    L14:
        r6 = 0;
        goto L15
    L17:
        return RangesKt.coerceAtLeast(r8.b() - r4, 0);
    }
}
