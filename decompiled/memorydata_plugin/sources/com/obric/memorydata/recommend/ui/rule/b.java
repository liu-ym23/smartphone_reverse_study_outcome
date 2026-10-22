package com.obric.memorydata.recommend.ui.rule;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\u0018\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0000\u001a\u000e\u0010\u0003\u001a\u00020\u0004*\u0004\u0018\u00010\u0002H\u0002¨\u0006\u0005"}, d2 = {"withRuleCardBoundaries", "", "Lcom/obric/memorydata/recommend/ui/rule/BlockContentItem;", "isRuleItem", "", "recommend_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class b {
    public static final List<a> a(List<? extends a> r12) {
        List r13 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r13, "<this>");
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.memorydata.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r1 = r0.iterator();
        int r3 = 0;
    L4:
        if (r1.hasNext() == false) goto L21;
        Object r4 = r1.next();
        int r5 = r3 + 1;
        if (r3 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        a r6 = (a) ZeusTransformUtils.preCheckCast(r4, a.class, "com.obric.memorydata.plugin");
        boolean r8 = !a((a) ZeusTransformUtils.preCheckCast(CollectionsKt.getOrNull(r13, r3 - 1), a.class, "com.obric.memorydata.plugin"));
        boolean r9 = !a((a) ZeusTransformUtils.preCheckCast(CollectionsKt.getOrNull(r13, r5), a.class, "com.obric.memorydata.plugin"));
        if (ZeusTransformUtils.instanceOf(r6, a.b.class) == false) goto L13;
        Object r7 = a.b.a((a.b) ZeusTransformUtils.preCheckCast(r6, a.b.class, "com.obric.memorydata.plugin"), null, r8, r9, 1, null);
    L11:
        r6 = (a) ZeusTransformUtils.preCheckCast(r7, a.class, "com.obric.memorydata.plugin");
    L17:
        r2.add(r6);
        r3 = r5;
        goto L4
    L13:
        if (ZeusTransformUtils.instanceOf(r6, a.C0686a.class) == false) goto L16;
        r7 = a.C0686a.a((a.C0686a) ZeusTransformUtils.preCheckCast(r6, a.C0686a.class, "com.obric.memorydata.plugin"), null, r8, r9, 1, null);
        goto L11
    L16:
        if (ZeusTransformUtils.instanceOf(r6, a.c.class) == true) goto L17;
        throw new NoWhenBranchMatchedException();
    L21:
        return (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin");
    }

    private static final boolean a(a r1) {
        if (ZeusTransformUtils.instanceOf(r1, a.b.class) == false) goto L5;
    L8:
        return true;
    L5:
        if (ZeusTransformUtils.instanceOf(r1, a.C0686a.class) == true) goto L8;
        return false;
    }
}
