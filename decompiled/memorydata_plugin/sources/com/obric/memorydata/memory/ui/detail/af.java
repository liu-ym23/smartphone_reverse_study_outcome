package com.obric.memorydata.memory.ui.detail;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0000\u001a \u0010\u0000\u001a\u0004\u0018\u00010\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000¨\u0006\u0006"}, d2 = {"selectPreferredSourceActivity", "Lcom/obric/memorydata/memory/ui/detail/SourceActivityTarget;", "candidates", "", "sourcePackageName", "", "memory_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class af {
    public static final ad a(List<ad> r4, String r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "candidates");
        Intrinsics.checkNotNullParameter(r5, "sourcePackageName");
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r8 = r7.iterator();
    L4:
        if (r8.hasNext() == false) goto L8;
        Object r2 = r8.next();
        if (Intrinsics.areEqual(((ad) ZeusTransformUtils.preCheckCast(r2, ad.class, "com.obric.memorydata.plugin")).a(), r5) == false) goto L4;
        r0.add(r2);
        goto L4
    L8:
        List r9 = (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin");
        ad r10 = (ad) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull(r9), ad.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L17;
        boolean r1 = true;
        if (r9.size() > 1) goto L14;
        r1 = false;
    L14:
        if (r1 == false) goto L17;
        return r10;
    L17:
        return null;
    }
}
