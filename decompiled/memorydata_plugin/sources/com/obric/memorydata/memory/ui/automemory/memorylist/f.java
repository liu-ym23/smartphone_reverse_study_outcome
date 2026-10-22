package com.obric.memorydata.memory.ui.automemory.memorylist;

import com.obric.memorydata.database.entity.y;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0001H\u0000¨\u0006\u0004"}, d2 = {"flattenAutoMemoryCollectionItems", "", "Lcom/obric/memorydata/memory/ui/automemory/memorylist/AutoMemoryCollectionDetailListItem;", "Lcom/obric/memorydata/memory/ui/automemory/memorylist/AutoMemoryCollectionDetailListGroup;", "memory_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class f {
    public static final List<c> a(List<b> r14) {
        List r15 = (List) ZeusTransformUtils.wrapperContextForParams(r14, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r15, "<this>");
        if (r15.isEmpty() == true) goto L5;
        int r0 = r15.size();
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(r15, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        int r4 = 0;
    L8:
        if (r2.hasNext() == false) goto L10;
        r4 = r4 + ((b) ZeusTransformUtils.preCheckCast(r2.next(), b.class, "com.obric.memorydata.plugin")).b().size();
        goto L8
    L10:
        ArrayList r3 = new ArrayList(r0 + r4);
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(r15, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        int r5 = 0;
    L12:
        if (r1.hasNext() == false) goto L31;
        Object r6 = r1.next();
        int r7 = r5 + 1;
        if (r5 >= 0) goto L16;
        CollectionsKt.throwIndexOverflow();
    L16:
        b r8 = (b) ZeusTransformUtils.preCheckCast(r6, b.class, "com.obric.memorydata.plugin");
        r3.add(new c.a(r8.a()));
        Iterator r9 = ((Iterable) ZeusTransformUtils.preCheckCast(r8.b(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        int r10 = 0;
    L18:
        if (r9.hasNext() == false) goto L29;
        Object r11 = r9.next();
        int r12 = r10 + 1;
        if (r10 >= 0) goto L22;
        CollectionsKt.throwIndexOverflow();
    L22:
        y r13 = (y) ZeusTransformUtils.preCheckCast(r11, y.class, "com.obric.memorydata.plugin");
        int r16 = r8.b().size();
        if (r10 == CollectionsKt.getLastIndex(r8.b())) goto L25;
    L27:
        boolean r17 = false;
    L28:
        r3.add(new c.b(r13, r10, r16, r17));
        r10 = r12;
        goto L18
    L25:
        if (r5 >= CollectionsKt.getLastIndex(r15)) goto L27;
        r17 = true;
        goto L28
    L29:
        r5 = r7;
        goto L12
    L31:
        return (List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin");
    L5:
        return CollectionsKt.emptyList();
    }
}
