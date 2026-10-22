package com.obric.memorydata.migration.sdk.internal.db;

import androidx.room.RoomDatabase;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.obric.memorydata.database.dao.IAppEntityRawDbDao;
import com.obric.memorydata.migration.sdk.t;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bJ \u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\f2\u000e\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00110\u0010H\u0002J$\u0010\u0012\u001a\u0016\u0012\u0004\u0012\u00020\f\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00110\u00100\u00132\u0006\u0010\u0014\u001a\u00020\tH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/obric/memorydata/migration/sdk/internal/db/MigrationRawDbCleaner;", "", "<init>", "()V", "PAGE_SIZE", "", "cleanupByDeleteIfPossible", "", "roomDb", "Landroidx/room/RoomDatabase;", "tables", "", "", "deleteAll", "tableName", "dao", "Lcom/obric/memorydata/database/dao/IAppEntityRawDbDao;", "Lcom/obric/memorydata/database/entity/AbstractRawDbEntity;", "resolveRawDaoByTableName", "", "db", "migration_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f11923a = null;

    static {
        f11923a = new e();
    }

    private e() {
    }

    private final Map<String, IAppEntityRawDbDao<? extends com.obric.memorydata.database.entity.d>> a(RoomDatabase r7) {
        LinkedHashMap r6 = new LinkedHashMap();
        Method[] r0 = r7.getClass().getMethods();
        Intrinsics.checkNotNullExpressionValue(r0, "getMethods(...)");
        Iterator r1 = SequencesKt.filter(SequencesKt.filter(ArraysKt.asSequence((Object[]) ZeusTransformUtils.preCheckCast(r0, Object[].class, "com.obric.memorydata.plugin")), $$Lambda$e$1mVy3SYRGBKeOfQ8kNjIFN9qAHw.INSTANCE), $$Lambda$e$lXA1pijjokJm4NFqMoXAKuGoM0.INSTANCE).iterator();
    L4:
        if (r1.hasNext() == false) goto L35;
        Method r2 = (Method) ZeusTransformUtils.preCheckCast(r1.next(), Method.class, "com.obric.memorydata.plugin");
        Object r3 = null;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L12
        Object r5 = r2.invoke(r7, new Object[0]);     // Catch: Throwable -> L12
        if (ZeusTransformUtils.instanceOf(r5, IAppEntityRawDbDao.class) == false) goto L9;
        IAppEntityRawDbDao r8 = (IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r5, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L12
    L10:
        Object r9 = Result.m1421constructorimpl(r8);     // Catch: Throwable -> L12
    L15:
        if (Result.m1427isFailureimpl(r9) == false) goto L17;
        r9 = null;
    L17:
        IAppEntityRawDbDao r10 = (IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r9, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L4;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L22
        Object r12 = Result.m1421constructorimpl(r10.getTableName());     // Catch: Throwable -> L22
    L25:
        if (Result.m1427isFailureimpl(r12) == true) goto L28;
        r3 = r12;
    L28:
        String r13 = (String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin");
        if (r13 != null) goto L32;
        r13 = "";
    L32:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L4;
        ((Map) ZeusTransformUtils.preCheckCast(r6, Map.class, "com.obric.memorydata.plugin")).put(r13, r10);
    L22:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r12 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L25
    L9:
        r8 = null;
    L12:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r9 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L15
    L35:
        return (Map) ZeusTransformUtils.preCheckCast(r6, Map.class, "com.obric.memorydata.plugin");
    }

    private final void a(String r13, IAppEntityRawDbDao<? extends com.obric.memorydata.database.entity.d> r14) {
        IAppEntityRawDbDao r15 = (IAppEntityRawDbDao) ZeusTransformUtils.wrapperContextForParams(r14, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin");
        t.f11981a.a("restore: raw cleanup table start, table=" + r13);
        long r3 = 0;
        int r5 = 0;
    L26:
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L5
        e r7 = (e) ZeusTransformUtils.preCheckCast(this, e.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L5
        Object r4 = Result.m1421constructorimpl(r15.rawQuery((SupportSQLiteQuery) ZeusTransformUtils.preCheckCast(new SimpleSQLiteQuery("SELECT * FROM `" + r15.getTableName() + "` WHERE id > ? ORDER BY id ASC LIMIT ?", new Object[]{Long.valueOf(r3), 200}), SupportSQLiteQuery.class, "com.obric.memorydata.plugin")));     // Catch: Throwable -> L5
    L7:
        List r8 = CollectionsKt.emptyList();
        if (Result.m1427isFailureimpl(r4) == false) goto L10;
        r4 = r8;
    L10:
        List r9 = (List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.memorydata.plugin");
        if (r9.isEmpty() == true) goto L24;
        Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L14:
        if (r10.hasNext() == false) goto L23;
        com.obric.memorydata.database.entity.d r11 = (com.obric.memorydata.database.entity.d) ZeusTransformUtils.preCheckCast(r10.next(), com.obric.memorydata.database.entity.d.class, "com.obric.memorydata.plugin");
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L18
        r11.delete();     // Catch: Throwable -> L18
        r5 = r5 + 1;     // Catch: Throwable -> L18
        t.f11981a.a("restore: raw cleanup deleted, table=" + r13 + " cls=" + r11.getClass().getSimpleName() + " id=" + r11.getId() + " entityId=" + r11.getEntityId() + " type=" + r11.getType());     // Catch: Throwable -> L18
        Object r16 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L18
    L20:
        Throwable r17 = Result.m1424exceptionOrNullimpl(r16);
        if (r17 == null) goto L14;
        t.f11981a.a("restore: delete old entity failed table=" + r13 + " id=" + r11.getId(), r17);
    L18:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r16 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L20
    L23:
        r3 = ((com.obric.memorydata.database.entity.d) ZeusTransformUtils.preCheckCast(CollectionsKt.last(r9), com.obric.memorydata.database.entity.d.class, "com.obric.memorydata.plugin")).getId();
        goto L26
    L24:
        t.f11981a.a("restore: raw cleanup table end, table=" + r13 + " deleted=" + r5);
        return;
    L5:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r4 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    private static final boolean a(Method r2) {
        Class<?>[] r3 = r2.getParameterTypes();
        Intrinsics.checkNotNullExpressionValue(r3, "getParameterTypes(...)");
        if (((Object[]) ZeusTransformUtils.preCheckCast(r3, Object[].class, "com.obric.memorydata.plugin")).length != 0) goto L5;
        return true;
    L5:
        return false;
    }

    private static final boolean b(Method r1) {
        return IAppEntityRawDbDao.class.isAssignableFrom(r1.getReturnType());
    }

    public static /* synthetic */ boolean lambda$1mVy3SYRGBKeOfQ8kNjIFN9qAHw(Method r0) {
        return a(r0);
    }

    /* JADX INFO: renamed from: lambda$lXA1pijjokJm4NFqMoXAK-uGoM0, reason: not valid java name */
    public static /* synthetic */ boolean m1041lambda$lXA1pijjokJm4NFqMoXAKuGoM0(Method r0) {
        return b(r0);
    }

    public final void a(RoomDatabase r5, Set<String> r6) {
        Set r7 = (Set) ZeusTransformUtils.wrapperContextForParams(r6, Set.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "roomDb");
        Intrinsics.checkNotNullParameter(r7, "tables");
        if (r7.isEmpty() == false) goto L5;
        return;
    L5:
        Map<String, IAppEntityRawDbDao<? extends com.obric.memorydata.database.entity.d>> r4 = a(r5);
        if (r4.isEmpty() == false) goto L10;
        t r8 = t.f11981a;
        String r9 = "restore: raw cleanup skipped, no raw dao found";
    L8:
        r8.a(r9);
        return;
    L10:
        Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L12:
        if (r10.hasNext() == false) goto L17;
        String r11 = (String) ZeusTransformUtils.preCheckCast(r10.next(), String.class, "com.obric.memorydata.plugin");
        IAppEntityRawDbDao<? extends com.obric.memorydata.database.entity.d> r0 = (IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4.get(r11), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L15;
        f11923a.a(r11, r0);
        goto L12
    L15:
        t.f11981a.a("restore: raw cleanup skip, table=" + r11 + " (no dao)");
        goto L12
    L17:
        r8 = t.f11981a;
        r9 = "restore: raw cleanup end";
        goto L8
    }
}
