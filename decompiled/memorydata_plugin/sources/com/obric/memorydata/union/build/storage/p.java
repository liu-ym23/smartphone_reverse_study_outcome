package com.obric.memorydata.union.build.storage;

import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\tH\u0002J \u0010\r\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\tH\u0002¨\u0006\u0011"}, d2 = {"Lcom/obric/memorydata/union/build/storage/SemanticOperationGraph;", "", "<init>", "()V", "connectedComponents", "", "Lcom/obric/memorydata/union/build/storage/ResolvedSemanticOperation;", "operations", "find", "", "parents", "", EventBody.KEY_VALUE, "union", "", "left", "right", "memory_build_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p f13134a = null;

    static {
        f13134a = new p();
    }

    private p() {
    }

    private final int a(int[] r2, int r3) {
        int r1 = r3;
    L4:
        if (r2[r1] == r1) goto L7;
        r1 = r2[r1];
    L7:
        if (r2[r3] == r3) goto L9;
        int r0 = r2[r3];
        r2[r3] = r1;
        r3 = r0;
        goto L7
    L9:
        return r1;
    }

    private final void a(int[] r1, int r2, int r3) {
        int r4 = a(r1, r2);
        int r0 = a(r1, r3);
        if (r4 == r0) goto L6;
        r1[r0] = r4;
        return;
    }

    public final List<List<g>> a(List<g> r9) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "operations");
        int r10 = r8.size();
        int[] r1 = new int[r10];
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r3 >= r10) goto L5;
        r1[r3] = r3;
        r3 = r3 + 1;
        goto L3
    L5:
        Map r11 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        Iterator r4 = ((Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L7:
        if (r4.hasNext() == false) goto L18;
        Object r5 = r4.next();
        int r6 = r2 + 1;
        if (r2 >= 0) goto L11;
        CollectionsKt.throwIndexOverflow();
    L11:
        Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast(((g) ZeusTransformUtils.preCheckCast(r5, g.class, "com.obric.memorydata.plugin")).d(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L13:
        if (r7.hasNext() == false) goto L17;
        Integer r12 = (Integer) ZeusTransformUtils.preCheckCast(r11.putIfAbsent((String) ZeusTransformUtils.preCheckCast(r7.next(), String.class, "com.obric.memorydata.plugin"), Integer.valueOf(r2)), Integer.class, "com.obric.memorydata.plugin");
        if (r12 == null) goto L13;
        f13134a.a(r1, r2, r12.intValue());
        goto L13
    L17:
        r2 = r6;
        goto L7
    L18:
        Iterable r13 = (Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin");
        Map r14 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        Iterator r15 = r13.iterator();
    L20:
        if (r15.hasNext() == false) goto L26;
        Object r16 = r15.next();
        Integer r17 = Integer.valueOf(f13134a.a(r1, ((g) ZeusTransformUtils.preCheckCast(r16, g.class, "com.obric.memorydata.plugin")).a()));
        Object r18 = r14.get(r17);
        if (r18 != null) goto L24;
        r18 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        r14.put(r17, r18);
    L24:
        ((List) ZeusTransformUtils.preCheckCast(r18, List.class, "com.obric.memorydata.plugin")).add(r16);
        goto L20
    L26:
        return CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r14.values(), Iterable.class, "com.obric.memorydata.plugin"));
    }
}
