package com.obric.memorydata.database.entity;

import androidx.room.RoomDatabase;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.database.manager.PersonalMemoryFrameDb;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\u001a%\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\u0004¢\u0006\u0002\u0010\t\u001a\u0006\u0010\n\u001a\u00020\u0007\u001a\b\u0010\u000b\u001a\u00020\u0007H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"CHANGE_SEQ_KEY", "", "RESTORE_PHASE_KEY", "indexWithChangeSequence", "", "Lcom/obric/memorydata/database/entity/UnionSemanticMemoryEntity;", "assignedChangeSeq", "", "isForceLazy", "(Lcom/obric/memorydata/database/entity/UnionSemanticMemoryEntity;Ljava/lang/Long;Z)Z", "nextSemanticChangeSequence", "allocateSemanticChangeSequence", "database_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ij {
    public static final long a() {
        return ((Number) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getPersonalDbEngine().runInTransaction($$Lambda$ij$BuIJGf88fp_X0heMGZKaCwR05I.INSTANCE), Number.class, "com.obric.memorydata.plugin")).longValue();
    }

    public static final boolean a(final ip r3, final Long r4, final boolean r5) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        return ((Boolean) ZeusTransformUtils.preCheckCast(ie.a((RoomDatabase) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getPersonalDbEngine(), RoomDatabase.class, "com.obric.memorydata.plugin"), new $$Lambda$ij$GcU8QuAzX3iR6GVMvyFiZY_uJqg(r3, r4, r5)), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    }

    public static /* synthetic */ boolean a(ip r0, Long r1, boolean r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = null;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = false;
    L9:
        return a(r0, r1, r2);
    }

    private static final long b() {
        PersonalMemoryFrameDb r0 = MemoryDbEngine.INSTANCE.getPersonalDbEngine();
        boolean r2 = true;
        if ((!Intrinsics.areEqual(r0.getSemanticStateDao().queryText("restore_phase"), "running")) == false) goto L18;
        r0.getSemanticStateDao().insertIfAbsent(new ik("change_seq", 0, null, 6, null));
        if (r0.getSemanticStateDao().increment("change_seq") == 1) goto L8;
        r2 = false;
    L8:
        if (r2 == false) goto L16;
        Long r1 = r0.getSemanticStateDao().queryNum("change_seq");
        if (r1 == null) goto L14;
        return ((Number) ZeusTransformUtils.preCheckCast(r1, Number.class, "com.obric.memorydata.plugin")).longValue();
    L14:
        throw new IllegalStateException("change_seq value is unavailable".toString());
    L16:
        throw new IllegalStateException("change_seq state row is unavailable".toString());
    L18:
        throw new IllegalStateException("semantic restore is running".toString());
    }

    private static final boolean b(ip r2, Long r3, boolean r4) {
        if (r3 == null) goto L4;
        long r0 = r3.longValue();
    L5:
        r2.b(r0);
        return r2.index(r4);
    L4:
        r0 = b();
        goto L5
    }

    private static final Long c() {
        return Long.valueOf(b());
    }

    /* JADX INFO: renamed from: lambda$BuIJGf88fp_-X0heMGZKaCwR05I, reason: not valid java name */
    public static /* synthetic */ Long m554lambda$BuIJGf88fp_X0heMGZKaCwR05I() {
        return c();
    }

    public static /* synthetic */ boolean lambda$GcU8QuAzX3iR6GVMvyFiZY_uJqg(ip r0, Long r1, boolean r2) {
        return b(r0, r1, r2);
    }
}
