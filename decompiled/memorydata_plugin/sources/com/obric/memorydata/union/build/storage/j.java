package com.obric.memorydata.union.build.storage;

import com.obric.memorydata.database.entity.id;
import com.obric.memorydata.database.entity.ip;
import com.obric.memorydata.memory.api.MemoryBuildOuter;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J.\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\fJ\u001c\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\fJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u0007H\u0002¨\u0006\u000f"}, d2 = {"Lcom/obric/memorydata/union/build/storage/SemanticBatchTracking;", "", "<init>", "()V", "upsert", "", "businessId", "", "entity", "Lcom/obric/memorydata/database/entity/UnionSemanticMemoryEntity;", "previous", "removed", "", "delete", "deleteMethod", "memory_build_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f13127a = null;

    static {
        f13127a = new j();
    }

    private j() {
    }

    private final String a(String r1) {
        if (Intrinsics.areEqual(r1, "episodic_semantic") == false) goto L6;
        return "semantic_timeslop";
    L6:
        if (Intrinsics.areEqual(r1, "semantic_consolidation") == false) goto L8;
        return "semantic_daily";
    L8:
        return null;
    }

    private static final Unit a(com.obric.memorydata.memory.api.c r1) {
        MemoryBuildOuter.INSTANCE.trackProcessedSemanticMemory(r1);
        return Unit.INSTANCE;
    }

    private static final Unit a(String r1, String r2) {
        MemoryBuildOuter.INSTANCE.trackMemoryDelete(CollectionsKt.listOf(r1), r2);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit lambda$IhkU1O4Poqr4nCEGrpjnp9f2bAY(com.obric.memorydata.memory.api.c r0) {
        return a(r0);
    }

    public static /* synthetic */ Unit lambda$VzhMGxbokJZad4SPIODagBTolNE(String r0, String r1) {
        return a(r0, r1);
    }

    public final void a(String r17, ip r18, ip r19, List<ip> r20) {
        List<ip> r14 = (List) ZeusTransformUtils.wrapperContextForParams(r20, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r17, "businessId");
        Intrinsics.checkNotNullParameter(r18, "entity");
        Intrinsics.checkNotNullParameter(r14, "removed");
        if (a(r17) != null) goto L5;
        return;
    L5:
        String r2 = r18.getUuid();
        String r3 = r18.q();
        String r4 = r18.a();
        String r12 = r18.b();
        long r5 = r18.getCreateTime();
        long r7 = r18.getModifyTime();
        if (r19 != null) goto L8;
        boolean r0 = true;
    L9:
        boolean r9 = r0;
        float r10 = r18.l();
        if (r19 == null) goto L12;
        Float r1 = Float.valueOf(r19.l());
    L13:
        final com.obric.memorydata.memory.api.c r15 = new com.obric.memorydata.memory.api.c(r2, r17, r3, r4, r5, r7, r9, r10, r1, r12);
        id.f9213a.a(new $$Lambda$j$IhkU1O4Poqr4nCEGrpjnp9f2bAY(r15));
        delete(r17, r14);
        return;
    L12:
        r1 = null;
        goto L13
    L8:
        r0 = false;
        goto L9
    }

    public final void delete(String r5, List<ip> r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "businessId");
        Intrinsics.checkNotNullParameter(r7, "removed");
        final String r4 = a(r5);
        if (r4 != null) goto L5;
        return;
    L5:
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin");
        Collection r9 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r10 = r8.iterator();
    L7:
        if (r10.hasNext() == false) goto L16;
        String r0 = ((ip) ZeusTransformUtils.preCheckCast(r10.next(), ip.class, "com.obric.memorydata.plugin")).getUuid();
        if (r0 != null) goto L11;
    L13:
        r0 = null;
    L14:
        if (r0 == null) goto L7;
        r9.add(r0);
        goto L7
    L11:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L13;
    L16:
        Iterator r11 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.distinct((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r9, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L18:
        if (r11.hasNext() == false) goto L20;
        final String r12 = (String) ZeusTransformUtils.preCheckCast(r11.next(), String.class, "com.obric.memorydata.plugin");
        id.f9213a.a(new $$Lambda$j$VzhMGxbokJZad4SPIODagBTolNE(r12, r4));
        goto L18
    }
}
