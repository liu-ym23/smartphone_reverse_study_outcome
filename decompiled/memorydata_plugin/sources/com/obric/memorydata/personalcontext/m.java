package com.obric.memorydata.personalcontext;

import com.obric.memorydata.database.dao.IAppEntityRawDbDao;
import com.obric.memorydata.database.dao.MetaFullContentKeywordCopilotDao;
import com.obric.memorydata.database.entity.dl;
import com.obric.memorydata.database.index.t;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.database.model.CommonTextSearchDocument;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.store.IStore;
import com.obric.memorydata.middleware.api.store.IStoreManager;
import com.obric.memorydata.middleware.api.store.StoreManager;
import com.obric.memorydata.middleware.database.DatabaseIsolationTracker;
import com.obric.search.api.schema.impl.FullTextSearchSchema;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0007\u001a\u00020\bJ\u001a\u0010\t\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u000e\u0010\u000e\u001a\u0004\u0018\u00010\u0005*\u00020\u000fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/obric/memorydata/personalcontext/MetaFullContentUidMigrationManager;", "", "<init>", "()V", "TAG", "", "KEY_MIGRATION_DONE", "migrate", "", "queryFullContent", "entityType", "", "rawDbId", "", "readFullContent", "Lcom/obric/memorydata/database/entity/AbstractRawDbEntity;", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f12231a = null;

    static {
        f12231a = new m();
    }

    private m() {
    }

    private final String a(int r2, long r3) {
        IAppEntityRawDbDao<com.obric.memorydata.database.entity.d> r4 = com.obric.memorydata.database.index.s.a().getRawDaoByEntityType(r2);
        if (r4 == null) goto L8;
        com.obric.memorydata.database.entity.d r5 = (com.obric.memorydata.database.entity.d) ZeusTransformUtils.preCheckCast(r4.queryById(r3), com.obric.memorydata.database.entity.d.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L7;
        return null;
    L7:
        return a(r5);
    L8:
        return null;
    }

    private final String a(com.obric.memorydata.database.entity.d r5) {
        Object r0 = null;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L14
        Class<?> r2 = r5.getClass();     // Catch: Throwable -> L14
    L4:
        if (r2 == null) goto L12;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L10
        Field r4 = r2.getDeclaredField("fullContent");     // Catch: Throwable -> L10
        r4.setAccessible(true);     // Catch: Throwable -> L10
        Object r6 = r4.get(r5);     // Catch: Throwable -> L10
        if (ZeusTransformUtils.instanceOf(r6, String.class) == false) goto L28;
    L9:
        return (String) ZeusTransformUtils.preCheckCast(r6, String.class, "com.obric.memorydata.plugin");
    L28:
        return null;
    L10:
        th = move-exception;
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L14
        Result.m1421constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L14
        r2 = ((Class) ZeusTransformUtils.preCheckCast(r2, Class.class, "com.obric.memorydata.plugin")).getSuperclass();     // Catch: Throwable -> L14
        goto L4
    L12:
        Object r8 = Result.m1421constructorimpl(null);     // Catch: Throwable -> L14
    L17:
        if (Result.m1427isFailureimpl(r8) == true) goto L21;
        r0 = r8;
    L21:
        return (String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.memorydata.plugin");
    L14:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r8 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L17
    }

    public final void a() {
        com.obric.memorydata.middleware.database.i r0 = com.obric.memorydata.middleware.database.b.f11646a.a();
        if (r0.c() == false) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "db_iso_MetaFullContentUidMigrationManager", "migrate skip, user is not login", false, 4, null);
        DatabaseIsolationTracker.a(DatabaseIsolationTracker.f11642a, "skipped_invalid_uid", 0, 0, 0, 0, "invalid_uid", 30, null);
        return;
    L6:
        String r1 = r0.a();
        IStore r2 = IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null);
        String r3 = "meta_full_content_uid_migration_v2_done";
        if (r2.getBoolean("meta_full_content_uid_migration_v2_done", false) == false) goto L10;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "db_iso_MetaFullContentUidMigrationManager", "migrate skip, already done, uid=" + com.obric.memorydata.utils.q.f13259a.b(r1), false, 4, null);
        return;
    L10:
        long r7 = System.currentTimeMillis();
        MetaFullContentKeywordCopilotDao r9 = MemoryDbEngine.INSTANCE.getGlobalDbEngine().getMetaFullContentKeywordCopilotDao();
        FullTextSearchSchema r10 = com.obric.memorydata.database.util.c.f9626a.c();
        Iterable r11 = (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.plus((Collection) ZeusTransformUtils.preCheckCast(r9.queryLegacyRows(), Collection.class, "com.obric.memorydata.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(r9.queryRowsByUid(r1), Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin");
        HashSet r12 = new HashSet();
        ArrayList r13 = new ArrayList();
        Iterator r14 = r11.iterator();
    L12:
        if (r14.hasNext() == false) goto L16;
        Object r15 = r14.next();
        if (r12.add(Long.valueOf(((dl) ZeusTransformUtils.preCheckCast(r15, dl.class, "com.obric.memorydata.plugin")).a())) == false) goto L12;
        r13.add(r15);
        goto L12
    L16:
        List r16 = (List) ZeusTransformUtils.preCheckCast(r13, List.class, "com.obric.memorydata.plugin");
        Iterator r17 = ((Iterable) ZeusTransformUtils.preCheckCast(r16, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        int r6 = 0;
        int r18 = 0;
        boolean r19 = true;
    L18:
        if (r17.hasNext() == false) goto L46;
        dl r5 = (dl) ZeusTransformUtils.preCheckCast(r17.next(), dl.class, "com.obric.memorydata.plugin");
        boolean r4 = Intrinsics.areEqual(com.obric.memorydata.database.manager.c.f9561a.a(r5.getType()), "USER");
        if (r4 == false) goto L22;
        String r110 = r1;
    L23:
        Iterator r111 = r17;
        long r20 = r7;
        String r22 = r1;
        IStore r8 = r2;
        String r21 = f12231a.a(r5.getType(), r5.b());
        CharSequence r23 = (CharSequence) ZeusTransformUtils.preCheckCast(r21, CharSequence.class, "com.obric.memorydata.plugin");
        if (r23 != null) goto L26;
    L29:
        boolean r24 = true;
    L31:
        if (r24 == false) goto L33;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "db_iso_MetaFullContentUidMigrationManager", "migrate skip empty fullContent, type=" + r5.getType() + ", rawDbId=" + r5.b() + ", id=" + r5.a(), null, 4, null);
        r18 = r18 + 1;
        String r26 = r3;
        int r25 = r6;
        IStore r27 = r8;
        MetaFullContentKeywordCopilotDao r28 = r9;
        List r29 = r16;
        String r30 = r22;
        char r31 = 2;
        boolean r32 = false;
    L45:
        r9 = r28;
        r17 = r111;
        r7 = r20;
        r16 = r29;
        r3 = r26;
        r6 = r25;
        r1 = r30;
        r2 = r27;
        goto L18
    L33:
        boolean r210 = r19;
        int r211 = r18;
        r29 = r16;
        r26 = r3;
        r27 = r8;
        MetaFullContentKeywordCopilotDao r212 = r9;
        int r33 = r6;
        r32 = false;
        r31 = 2;
        if (com.obric.memorydata.database.util.d.insert(r10, CollectionsKt.listOf(new CommonTextSearchDocument(r5.a(), r10.a(), t.f9438a.a(MapsKt.mapOf(new Pair[]{TuplesKt.to("common1", new StringBuilder().append('|').append(r5.getType()).append('|').toString()), TuplesKt.to("common2", r21), TuplesKt.to("common3", com.obric.memorydata.database.util.d.a(r110))}))))) == true) goto L36;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "db_iso_MetaFullContentUidMigrationManager", "migrate insert new document failed, type=" + r5.getType() + ", rawDbId=" + r5.b() + ", id=" + r5.a(), null, 4, null);
        r25 = r33 + 1;
        r19 = false;
        r30 = r22;
        r18 = r211;
        r28 = r212;
        goto L45
    L36:
        if (r4 == true) goto L38;
    L43:
        r30 = r22;
        r28 = r212;
    L44:
        r19 = r210;
        r18 = r211;
        r25 = r33;
        goto L45
    L38:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r5.c(), CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L40;
        boolean r34 = true;
    L41:
        if (r34 == false) goto L43;
        r30 = r22;
        r28 = r212;
        r28.updateUidByIds(CollectionsKt.listOf(Long.valueOf(r5.a())), r30);
        goto L44
    L40:
        r34 = false;
        goto L41
    L26:
        if (StringsKt.isBlank(r23) == true) goto L29;
        r24 = false;
        goto L31
    L22:
        r110 = "";
        goto L23
    L46:
        IStore r213 = r2;
        String r214 = r3;
        int r35 = r6;
        long r215 = r7;
        List r216 = r16;
        boolean r217 = r19;
        int r218 = r18;
        String r36 = r1;
        if (r217 == false) goto L49;
        r213.save(r214, true);
    L49:
        int r37 = (r216.size() - r218) - r35;
        long r38 = System.currentTimeMillis() - r215;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "db_iso_MetaFullContentUidMigrationManager", "migrate finish, uid=" + com.obric.memorydata.utils.q.f13259a.b(r36) + ", total=" + r216.size() + ", migrated=" + r37 + ", skipped=" + r218 + ", failed=" + r35 + ", success=" + r217 + ", cost=" + r38, false, 4, null);
        DatabaseIsolationTracker r39 = DatabaseIsolationTracker.f11642a;
        if (r217 == false) goto L52;
        String r40 = "success";
    L53:
        String r112 = r40;
        if (r217 == false) goto L56;
        String r219 = null;
    L57:
        r39.a(r112, r37, r218, r35, r38, r219);
        return;
    L56:
        r219 = "insert_failed";
        goto L57
    L52:
        r40 = "partial_failure";
        goto L53
    }
}
