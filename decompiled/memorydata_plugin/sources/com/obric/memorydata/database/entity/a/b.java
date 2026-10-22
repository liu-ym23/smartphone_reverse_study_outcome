package com.obric.memorydata.database.entity.a;

import android.database.Cursor;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.crash.Ensure;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.memorydata.database.dao.IAppEntityRawDbDao;
import com.obric.memorydata.database.entity.cd;
import com.obric.memorydata.database.entity.cu;
import com.obric.memorydata.database.entity.d;
import com.obric.memorydata.database.index.ao;
import com.obric.memorydata.database.index.bc;
import com.obric.memorydata.database.index.s;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.database.manager.c;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.utils.y;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005J.\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00052\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00102\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u0011\u001a\u00020\tJ\u000e\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/obric/memorydata/database/entity/utils/MemoryUpgradeUtils;", "", "<init>", "()V", "TAG", "", "INSERT_EXISTING_DATA_PAGE_SIZE", "", "insertExistingDataPendingTask", "", "entityType", LocationMonitorConst.TAG, "pendingTaskBuilder", "Lcom/obric/memorydata/database/entity/utils/ExistingDataPendingTaskBuilder;", "deleteOldBuildType", "deleteOldBuildTypeSet", "", "refreshEpisodicMemoryTitle", "getEpisodicMemoryEntityTitle", Params.CONTENT, "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f8862a = null;

    static {
        f8862a = new b();
    }

    private b() {
    }

    private static final Unit a(String r3, int r4, Exception r5) {
        Intrinsics.checkNotNullParameter(r5, "error");
        RunLog.INSTANCE.error("MemoryUpgradeUtils", "insertExistingDataPendingTask(" + r3 + "): " + r4 + ", error", (Throwable) ZeusTransformUtils.preCheckCast(r5, Throwable.class, "com.obric.memorydata.plugin"));
        Ensure.ensureNotReachHere((Throwable) ZeusTransformUtils.preCheckCast(r5, Throwable.class, "com.obric.memorydata.plugin"));
        return Unit.INSTANCE;
    }

    private static final Unit a(String r25, int r26, Ref.LongRef r27, IAppEntityRawDbDao r28, a r29, List r30) {
        IAppEntityRawDbDao r3 = (IAppEntityRawDbDao) ZeusTransformUtils.wrapperContextForParams(r28, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin");
        a r5 = (a) ZeusTransformUtils.wrapperContextForParams(r29, a.class, "com.obric.memorydata.plugin");
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r30, List.class, "com.obric.memorydata.plugin");
    L3:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryUpgradeUtils", "insertExistingDataPendingTask(" + r25 + "): " + r26 + ", lastDbId: " + r27.element, false, 4, null);
        List<com.obric.memorydata.database.b> r7 = r3.getEntitySimpleDataPaging(1000, r27.element);
        if (r7.isEmpty() == true) goto L6;
        r27.element = ((com.obric.memorydata.database.b) ZeusTransformUtils.preCheckCast(CollectionsKt.last(r7), com.obric.memorydata.database.b.class, "com.obric.memorydata.plugin")).a();
        List<cd> r8 = r5.a(r26, r7);
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin");
        Collection r10 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r11 = r9.iterator();
    L9:
        if (r11.hasNext() == false) goto L11;
        r10.add(Long.valueOf(((com.obric.memorydata.database.b) ZeusTransformUtils.preCheckCast(r11.next(), com.obric.memorydata.database.b.class, "com.obric.memorydata.plugin")).a()));
        goto L9
    L11:
        List r12 = (List) ZeusTransformUtils.preCheckCast(r10, List.class, "com.obric.memorydata.plugin");
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r8, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L3;
        Set r13 = SetsKt.setOf(new Integer[]{Integer.valueOf(r26), Integer.valueOf(cu.f8996a.a(r26))});
        Iterator r14 = ((Iterable) ZeusTransformUtils.preCheckCast(c.f9561a.a(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L15:
        if (r14.hasNext() == false) goto L42;
        String r15 = (String) ZeusTransformUtils.preCheckCast(r14.next(), String.class, "com.obric.memorydata.plugin");
        Iterable r16 = (Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin");
        IAppEntityRawDbDao r23 = r3;
        Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r17 = r16.iterator();
    L18:
        if (r17.hasNext() == false) goto L23;
        Object r18 = r17.next();
        a r24 = r5;
        Iterator r31 = r17;
        if (Intrinsics.areEqual(c.f9561a.a(((cd) ZeusTransformUtils.preCheckCast(r18, cd.class, "com.obric.memorydata.plugin")).c()), r15) == false) goto L22;
        r4.add(r18);
    L22:
        r17 = r31;
        r5 = r24;
        goto L18
    L23:
        a r210 = r5;
        List r19 = (List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.memorydata.plugin");
        Collection r20 = (Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.memorydata.plugin");
        if (r20 != null) goto L26;
    L29:
        boolean r21 = true;
    L30:
        if (r21 == false) goto L36;
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r19, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == true) goto L36;
    L41:
        r14 = r14;
        r3 = r23;
        r5 = r210;
    L36:
        ao r110 = ao.f9372a;
        if (r6 != null) goto L39;
        List r22 = CollectionsKt.emptyList();
    L40:
        r110.a(r15, r12, r13, CollectionsKt.toSet((Iterable) ZeusTransformUtils.preCheckCast(r22, Iterable.class, "com.obric.memorydata.plugin")), r19, (bc) ZeusTransformUtils.preCheckCast(new bc.a(System.currentTimeMillis()), bc.class, "com.obric.memorydata.plugin"));
        goto L41
    L39:
        r22 = r6;
        goto L40
    L26:
        if (r20.isEmpty() == true) goto L29;
        r21 = false;
        goto L30
    L42:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryUpgradeUtils", "insertExistingDataPendingTask(" + r25 + "): " + r26 + ", insert " + r8.size() + " pending tasks, lastDbId: " + r27.element, false, 4, null);
        r3 = r3;
        r5 = r5;
        goto L3
    L6:
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit lambda$BJKO5846leUNfVoZfEwCpJQbusM(String r0, int r1, Exception r2) {
        return a(r0, r1, r2);
    }

    public static /* synthetic */ Unit lambda$Yyia0nNNw57AYBozRj7dgPS9Adg(String r0, int r1, Ref.LongRef r2, IAppEntityRawDbDao r3, a r4, List r5) {
        return a(r0, r1, r2, r3, r4, r5);
    }

    public final String a(String r9) {
        Intrinsics.checkNotNullParameter(r9, Params.CONTENT);
        int r8 = StringsKt.indexOf$default((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin"), "\n- ", 0, false, 6, null);
        if (r8 == (-1)) goto L5;
        r9 = r9.substring(0, r8);
        Intrinsics.checkNotNullExpressionValue(r9, "substring(...)");
    L5:
        int r10 = StringsKt.indexOf$default((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin"), '|', 0, false, 6, null);
        if (r10 >= 0) goto L8;
        return r9;
    L8:
        if (r10 >= (r9.length() - 1)) goto L12;
        String r11 = r9.substring(r10 + 1);
        Intrinsics.checkNotNullExpressionValue(r11, "substring(...)");
        return StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin")).toString();
    L12:
        return r9;
    }

    public final void a() {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryUpgradeUtils", "refreshEpisodicMemoryTitle start", false, 4, null);
        long r0 = System.currentTimeMillis();
        SupportSQLiteDatabase r3 = MemoryDbEngine.INSTANCE.getGlobalDbEngine().getOpenHelper().getWritableDatabase();
        if (r3.isOpen() == true) goto L50;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryUpgradeUtils", "refreshEpisodicMemoryTitle db not open", false, 4, null);
        return;
    L50:
        r3.beginTransaction();     // Catch: Exception -> L46
        int r7 = 0;
        boolean r6 = true;
    L8:
        if (r6 == false) goto L41;
        Cursor r8 = r3.query(StringsKt.trimIndent("\n                    SELECT id,title,content  FROM ShortMemory\n                    WHERE category = 0 \n                    ORDER BY modifyTime DESC \n                    LIMIT 100 OFFSET " + r7 + "\n                "));     // Catch: Throwable -> L43
        if (r8.getCount() <= 0) goto L12;
        boolean r9 = true;
    L13:
        if (r9 == false) goto L14;
        List r10 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L43
    L17:
        if (r8.moveToNext() == false) goto L34;
        int r11 = r8.getColumnIndex(OaidModel.KEY_ID);     // Catch: Throwable -> L43
        int r12 = r8.getColumnIndex("title");     // Catch: Throwable -> L43
        int r13 = r8.getColumnIndex(Params.CONTENT);     // Catch: Throwable -> L43
        if (r11 == (-1)) goto L17;
        if (r12 == (-1)) goto L17;
        if (r13 == (-1)) goto L17;
        long r14 = r8.getLong(r11);     // Catch: Throwable -> L43
        String r15 = r8.getString(r12);     // Catch: Throwable -> L43
        String r16 = r8.getString(r13);     // Catch: Throwable -> L43
        CharSequence r17 = (CharSequence) ZeusTransformUtils.preCheckCast(r15, CharSequence.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L43
        if (r17 != null) goto L26;
    L29:
        boolean r18 = true;
    L30:
        if (r18 == false) goto L17;
        if (r16 != null) goto L33;
        r16 = "";
    L33:
        r10.add(TuplesKt.to(Long.valueOf(r14), a(r16)));     // Catch: Throwable -> L43
        goto L17
    L26:
        if (r17.length() == 0) goto L29;
        r18 = false;
        goto L30
    L34:
        r8.close();     // Catch: Throwable -> L43
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r10, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L40;
        SupportSQLiteStatement r19 = r3.compileStatement("UPDATE ShortMemory \nSET title = ? \nWHERE id = ?");     // Catch: Throwable -> L43
        Iterator r20 = ((Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L43
    L38:
        if (r20.hasNext() == false) goto L40;
        Pair r110 = (Pair) ZeusTransformUtils.preCheckCast(r20.next(), Pair.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L43
        r19.bindString(1, (String) ZeusTransformUtils.preCheckCast(r110.getSecond(), String.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L43
        r19.bindLong(2, ((Number) ZeusTransformUtils.preCheckCast(r110.getFirst(), Number.class, "com.obric.memorydata.plugin")).longValue());     // Catch: Throwable -> L43
        r19.executeUpdateDelete();     // Catch: Throwable -> L43
        r19.clearBindings();     // Catch: Throwable -> L43
    L40:
        r7 = r7 + 100;     // Catch: Throwable -> L43
        r6 = r9;
        goto L8
    L14:
        r8.close();     // Catch: Throwable -> L43
        goto L41
    L12:
        r9 = false;
    L43:
        th = move-exception;
        r3.endTransaction();     // Catch: Exception -> L46
        throw th;     // Catch: Exception -> L46
    L41:
        r3.setTransactionSuccessful();     // Catch: Throwable -> L43
        r3.endTransaction();     // Catch: Exception -> L46
    L48:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryUpgradeUtils", "refreshEpisodicMemoryTitle end, cost " + (System.currentTimeMillis() - r0) + " ms", false, 4, null);
        return;
    L46:
        e = move-exception;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryUpgradeUtils", "refreshEpisodicMemoryTitle: error " + e, null, 4, null);
        goto L48
    }

    public final void a(int r3, String r4, a r5, String r6) {
        a r7 = (a) ZeusTransformUtils.wrapperContextForParams(r5, a.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, LocationMonitorConst.TAG);
        Intrinsics.checkNotNullParameter(r7, "pendingTaskBuilder");
        if (r6 != null) goto L5;
        List<String> r8 = null;
    L6:
        a(r3, r4, r8, r7);
        return;
    L5:
        r8 = CollectionsKt.listOf(r6);
        goto L6
    }

    public final void a(final int r17, final String r18, List<String> r19, a r20) {
        final List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r19, List.class, "com.obric.memorydata.plugin");
        final a r5 = (a) ZeusTransformUtils.wrapperContextForParams(r20, a.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r18, LocationMonitorConst.TAG);
        Intrinsics.checkNotNullParameter(r5, "pendingTaskBuilder");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryUpgradeUtils", "insertExistingDataPendingTask(" + r18 + "): " + r17 + " start", false, 4, null);
        long r10 = System.currentTimeMillis();
        if (MemoryDbEngine.INSTANCE.getGlobalDbEngine().getOpenHelper().getWritableDatabase().isOpen() == true) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryUpgradeUtils", "insertExistingDataPendingTask(" + r18 + "): " + r17 + ", db not open", false, 4, null);
        return;
    L6:
        final IAppEntityRawDbDao<d> r12 = s.a().getRawDaoByEntityType(r17);
        if (r12 != null) goto L10;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryUpgradeUtils", "insertExistingDataPendingTask(" + r18 + "): " + r17 + ", dao not found", null, 4, null);
        return;
    L10:
        final Ref.LongRef r13 = new Ref.LongRef();
        r13.element = -1;
        y.a(new $$Lambda$b$BJKO5846leUNfVoZfEwCpJQbusM(r18, r17), new $$Lambda$b$Yyia0nNNw57AYBozRj7dgPS9Adg(r18, r17, r13, r12, r5, r6));
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryUpgradeUtils", "insertExistingDataPendingTask(" + r18 + "): " + r17 + " end, cost " + (System.currentTimeMillis() - r10) + " ms", false, 4, null);
    }
}
