package com.obric.memorydata.personalcontext.poison;

import androidx.room.RoomDatabase;
import com.obric.memorydata.BuildConfig;
import com.obric.memorydata.database.dao.IAppEntityRawDbDao;
import com.obric.memorydata.database.index.EntityIndexEngine;
import com.obric.memorydata.database.index.s;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J+\u0010\b\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\r0\fH\u0082\bJ+\u0010\u000e\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\r0\fH\u0082\b¨\u0006\u000f"}, d2 = {"Lcom/obric/memorydata/personalcontext/poison/EntityPoisonLabelUpdater;", "", "<init>", "()V", BuildConfig.CHANNEL, "Lcom/obric/memorydata/personalcontext/poison/EntityPoisonLabelUpdateResult;", "batch", "Lcom/obric/memorydata/personalcontext/poison/EntityPoisonLabelBatch;", "updateOperationsSafely", "operations", "", "Lcom/obric/memorydata/personalcontext/poison/EntityPoisonLabelOperation;", "Lkotlin/Function1;", "", "updateOperations", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f12253a = null;

    static {
        f12253a = new f();
    }

    private f() {
    }

    /* JADX WARN: Type inference failed for: r8v6, types: [T, com.obric.memorydata.personalcontext.poison.e] */
    private static final void a(Ref.ObjectRef r7, List r8, IAppEntityRawDbDao r9, b r10) {
        List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        IAppEntityRawDbDao r12 = (IAppEntityRawDbDao) ZeusTransformUtils.wrapperContextForParams(r9, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin");
        Iterator r13 = ((Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        int r0 = 0;
        int r2 = 0;
    L4:
        if (r13.hasNext() == false) goto L9;
        c r3 = (c) ZeusTransformUtils.preCheckCast(r13.next(), c.class, "com.obric.memorydata.plugin");
        int r4 = r12.updatePoisonLabelIfContentHashMatches(r3.b(), r3.c(), r3.d(), r10.a());
        if (r4 > 0) goto L7;
        r2 = r2 + 1;
        goto L4
    L7:
        r0 = r0 + r4;
        goto L4
    L9:
        r7.element = new e(r0, r2);
    }

    /* JADX INFO: renamed from: lambda$Rts-ZzDm2_YOY1uAcQct2ZSeJUs, reason: not valid java name */
    public static /* synthetic */ void m1085lambda$RtsZzDm2_YOY1uAcQct2ZSeJUs(Ref.ObjectRef r0, List r1, IAppEntityRawDbDao r2, b r3) {
        a(r0, r1, r2, r3);
    }

    /* JADX WARN: Type inference failed for: r5v10, types: [T, com.obric.memorydata.personalcontext.poison.e] */
    /* JADX WARN: Type inference failed for: r9v0, types: [T, com.obric.memorydata.personalcontext.poison.e] */
    public final e update(final b r15) {
        Intrinsics.checkNotNullParameter(r15, "batch");
        int r14 = r15.c();
        EntityIndexEngine r0 = s.a();
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(r15.b(), Iterable.class, "com.obric.memorydata.plugin");
        Map r2 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        Iterator r3 = r1.iterator();
    L4:
        if (r3.hasNext() == false) goto L9;
        Object r4 = r3.next();
        Integer r5 = Integer.valueOf(((c) ZeusTransformUtils.preCheckCast(r4, c.class, "com.obric.memorydata.plugin")).a());
        Object r6 = r2.get(r5);
        if (r6 != null) goto L8;
        r6 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        r2.put(r5, r6);
    L8:
        ((List) ZeusTransformUtils.preCheckCast(r6, List.class, "com.obric.memorydata.plugin")).add(r4);
        goto L4
    L9:
        Iterator r7 = r2.entrySet().iterator();
        int r8 = 0;
    L11:
        if (r7.hasNext() == false) goto L36;
        Map.Entry r9 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        int r10 = ((Number) ZeusTransformUtils.preCheckCast(r9.getKey(), Number.class, "com.obric.memorydata.plugin")).intValue();
        final List r11 = (List) ZeusTransformUtils.preCheckCast(r9.getValue(), List.class, "com.obric.memorydata.plugin");
        final IAppEntityRawDbDao<com.obric.memorydata.database.entity.d> r12 = r0.getRawDaoByEntityType(r10);
        if (r12 != null) goto L17;
        int r13 = r11.size();
    L15:
        r14 = r14 + r13;
        goto L11
    L17:
        if (Intrinsics.areEqual(com.obric.memorydata.database.manager.c.f9561a.a(r10), "USER") == false) goto L19;
        Object r16 = MemoryDbEngine.INSTANCE.getPersonalDbEngine();
    L20:
        RoomDatabase r17 = (RoomDatabase) ZeusTransformUtils.preCheckCast(r16, RoomDatabase.class, "com.obric.memorydata.plugin");
        final Ref.ObjectRef r18 = new Ref.ObjectRef();
        r18.element = new e(0, 0);
        r17.runInTransaction(new $$Lambda$f$RtsZzDm2_YOY1uAcQct2ZSeJUs(r18, r11, r12, r15));     // Catch: Exception -> L23
    L34:
        r8 = r8 + ((e) ZeusTransformUtils.preCheckCast(r18.element, e.class, "com.obric.memorydata.plugin")).a();
        r13 = ((e) ZeusTransformUtils.preCheckCast(r18.element, e.class, "com.obric.memorydata.plugin")).b();
    L23:
        Iterator r19 = ((Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        int r20 = 0;
        int r21 = 0;
    L25:
        if (r19.hasNext() == false) goto L33;
        c r110 = (c) ZeusTransformUtils.preCheckCast(r19.next(), c.class, "com.obric.memorydata.plugin");
        int r111 = r12.updatePoisonLabelIfContentHashMatches(r110.b(), r110.c(), r110.d(), r15.a());     // Catch: Exception -> L29
    L30:
        if (r111 > 0) goto L31;
        r21 = r21 + 1;
        goto L25
    L31:
        r20 = r20 + r111;
    L29:
        r111 = 0;
        goto L30
    L33:
        r18.element = new e(r20, r21);
        goto L34
    L19:
        r16 = MemoryDbEngine.INSTANCE.getGlobalDbEngine();
        goto L20
    L36:
        return new e(r8, r14);
    }
}
