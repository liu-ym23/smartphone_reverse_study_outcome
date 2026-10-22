package com.obric.memorydata.memory.ui.settings.contextawareness;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\u001a\u000e\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0002¨\u0006\u0003"}, d2 = {"allSourceKeys", "", "", "memory_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class l {
    public static final /* synthetic */ List a() {
        return b();
    }

    private static final List<String> b() {
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(ContextAwarenessSystemApp.getEntries(), Iterable.class, "com.obric.memorydata.plugin");
        h r1 = h.f11453a;
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        r3.add(r1.a((ContextAwarenessSystemApp) ZeusTransformUtils.preCheckCast(r2.next(), ContextAwarenessSystemApp.class, "com.obric.memorydata.plugin")));
        goto L4
    L6:
        Collection r4 = (Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin");
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(ContextAwarenessGlobalSource.getEntries(), Iterable.class, "com.obric.memorydata.plugin");
        h r6 = h.f11453a;
        Collection r7 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r8 = r5.iterator();
    L8:
        if (r8.hasNext() == false) goto L11;
        r7.add(r6.a((ContextAwarenessGlobalSource) ZeusTransformUtils.preCheckCast(r8.next(), ContextAwarenessGlobalSource.class, "com.obric.memorydata.plugin")));
        goto L8
    L11:
        return CollectionsKt.plus(r4, (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));
    }
}
