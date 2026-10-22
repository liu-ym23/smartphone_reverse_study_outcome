package com.obric.memorydata.datatransport.manager;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¨\u0006\u0004"}, d2 = {"visibleTo", "Lcom/obric/memorydata/datatransport/manager/DataExportTaskState;", "userId", "", "data_transport_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class g {
    public static final f a(f r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "userId");
        if (Intrinsics.areEqual(r2, f.b.f9769a) == false) goto L6;
        return r2;
    L6:
        if (ZeusTransformUtils.instanceOf(r2, f.d.class) == false) goto L12;
        if (Intrinsics.areEqual(((f.d) ZeusTransformUtils.preCheckCast(r2, f.d.class, "com.obric.memorydata.plugin")).a().b(), r3) == false) goto L25;
        return r2;
    L25:
        return (f) ZeusTransformUtils.preCheckCast(f.b.f9769a, f.class, "com.obric.memorydata.plugin");
    L12:
        if (ZeusTransformUtils.instanceOf(r2, f.e.class) == false) goto L17;
        if (Intrinsics.areEqual(((f.e) ZeusTransformUtils.preCheckCast(r2, f.e.class, "com.obric.memorydata.plugin")).a().b(), r3) == false) goto L25;
        return r2;
    L17:
        if (ZeusTransformUtils.instanceOf(r2, f.a.class) == false) goto L22;
        if (Intrinsics.areEqual(((f.a) ZeusTransformUtils.preCheckCast(r2, f.a.class, "com.obric.memorydata.plugin")).a().b(), r3) == false) goto L25;
        return r2;
    L22:
        if (ZeusTransformUtils.instanceOf(r2, f.c.class) == false) goto L27;
        if (Intrinsics.areEqual(((f.c) ZeusTransformUtils.preCheckCast(r2, f.c.class, "com.obric.memorydata.plugin")).a().b(), r3) == false) goto L25;
        return r2;
    L27:
        throw new NoWhenBranchMatchedException();
    }
}
