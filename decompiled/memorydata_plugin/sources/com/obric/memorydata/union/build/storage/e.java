package com.obric.memorydata.union.build.storage;

import com.obric.capabilitykit.common.Ext;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0000\u001a&\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00060\u0005H\u0000\u001a*\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\b2\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00060\u0005H\u0000¨\u0006\t"}, d2 = {"pendingReviewConflictFailure", "", Ext.KEY_REQUEST, "Lcom/obric/memorydata/union/build/storage/PendingSemanticReviewRequest;", "currentConflicts", "", "", "pendingReviewDeletableConflicts", "", "memory_build_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class e {
    public static final String a(f r2, Map<String, Long> r3) {
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, Ext.KEY_REQUEST);
        Intrinsics.checkNotNullParameter(r4, "currentConflicts");
        if (r2.d() == false) goto L5;
        return null;
    L5:
        if (Intrinsics.areEqual(r4, r2.c()) == true) goto L10;
        return "CONFLICT_VERSION_CHANGED";
    L10:
        return null;
    }

    public static final List<String> b(f r7, Map<String, Long> r8) {
        Map r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r8, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, Ext.KEY_REQUEST);
        Intrinsics.checkNotNullParameter(r9, "currentConflicts");
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(r7.c().keySet(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L14;
        Object r3 = r1.next();
        String r4 = (String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin");
        Long r5 = (Long) ZeusTransformUtils.preCheckCast(r7.c().get(r4), Long.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L8;
    L10:
        boolean r6 = false;
    L11:
        if (r6 == false) goto L4;
        r2.add(r3);
        goto L4
    L8:
        if (Intrinsics.areEqual(r9.get(r4), r5) == false) goto L10;
        r6 = true;
        goto L11
    L14:
        return (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin");
    }
}
