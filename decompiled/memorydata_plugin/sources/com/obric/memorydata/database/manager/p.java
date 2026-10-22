package com.obric.memorydata.database.manager;

import android.database.Cursor;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.apm6.hub.config.internal.SlardarSettingsConstants;
import com.bytedance.bdlocation.monitor.LBSLightLocationTraceLogger;
import com.google.gson.reflect.TypeToken;
import com.obric.memorydata.utils.GsonUtil;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\u0010B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u001e\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u001e\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002¨\u0006\u0011"}, d2 = {"Lcom/obric/memorydata/database/manager/SemanticMigrationPrepareCleanup;", "", "<init>", "()V", SlardarSettingsConstants.SETTING_GENERAL_CLEANUP, "Lcom/obric/memorydata/database/manager/SemanticMigrationPrepareCleanup$CleanupCounts;", "database", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "deleteRows", "", "ids", "", "", "convertRetainedRows", "clearSurvivingConflicts", "deletedIds", "CleanupCounts", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p f9587a = null;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\n\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/obric/memorydata/database/manager/SemanticMigrationPrepareCleanup$CleanupCounts;", "", "pruned", "", "deduplicated", "<init>", "(II)V", "getPruned", "()I", "getDeduplicated", LBSLightLocationTraceLogger.TOTAL, "getTotal", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f9588a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f9589b;

        public a() {
            int r0 = 0;
            this(r0, r0, 3, null);
        }

        public a(int r1, int r2) {
            this.f9588a = r1;
            this.f9589b = r2;
        }

        public /* synthetic */ a(int r2, int r3, int r4, DefaultConstructorMarker r5) {
            if ((r4 & 1) == 0) goto L6;
            r2 = 0;
        L6:
            if ((r4 & 2) == 0) goto L8;
            r3 = 0;
        L8:
            this(r2, r3);
        }

        public final int a() {
            return this.f9588a;
        }

        public final int b() {
            return this.f9589b;
        }

        public final int c() {
            return this.f9588a + this.f9589b;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
            if (this.f9588a == r6.f9588a) goto L12;
            return false;
        L12:
            if (this.f9589b == r6.f9589b) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (Integer.hashCode(this.f9588a) * 31) + Integer.hashCode(this.f9589b);
        }

        public String toString() {
            return "CleanupCounts(pruned=" + this.f9588a + ", deduplicated=" + this.f9589b + ')';
        }
    }

    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001¨\u0006\u0003¸\u0006\u0000"}, d2 = {"com/obric/memorydata/utils/GsonUtil$fromJsonArray$2$1", "Lcom/google/gson/reflect/TypeToken;", "", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b extends TypeToken<List<? extends String>> {
        public b() {
        }
    }

    static {
        f9587a = new p();
    }

    private p() {
    }

    private static final CharSequence a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        return (CharSequence) ZeusTransformUtils.preCheckCast("?", CharSequence.class, "com.obric.memorydata.plugin");
    }

    private final void a(SupportSQLiteDatabase r12, Set<String> r13) {
        SupportSQLiteDatabase r11 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r12, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        Iterator r14 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.chunked((Iterable) ZeusTransformUtils.preCheckCast((Set) ZeusTransformUtils.wrapperContextForParams(r13, Set.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"), 200), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r14.hasNext() == false) goto L23;
        List r15 = (List) ZeusTransformUtils.preCheckCast(r14.next(), List.class, "com.obric.memorydata.plugin");
        String r1 = CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r15, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, $$Lambda$p$U0QLV9kyzB8U6WyDX847y96zizw.INSTANCE, 30, null);
        boolean r3 = false;
        String[] r2 = (String[]) ZeusTransformUtils.preCheckCast(((Collection) ZeusTransformUtils.preCheckCast(r15, Collection.class, "com.obric.memorydata.plugin")).toArray(new String[0]), String[].class, "com.obric.memorydata.plugin");
        r11.execSQL("DELETE FROM UnionSemanticMemorySnapShot WHERE entity_id IN (" + r1 + ')', r2);
        r11.execSQL("DELETE FROM UnionSemanticMemory WHERE entityId IN (" + r1 + ')', r2);
        Closeable r4 = (Closeable) ZeusTransformUtils.preCheckCast(r11.query("SELECT changes()"), Closeable.class, "com.obric.memorydata.plugin");
        Cursor r5 = (Cursor) ZeusTransformUtils.preCheckCast(r4, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L18
        if (r5.moveToNext() == false) goto L17;
        int r6 = r5.getInt(0);     // Catch: Throwable -> L18
        CloseableKt.closeFinally(r4, null);
        if (r6 != r15.size()) goto L12;
        r3 = true;
    L12:
        if (r3 == true) goto L4;
        throw new IllegalStateException("migration cleanup delete count mismatch".toString());
    L17:
        throw new IllegalStateException("migration cleanup count unavailable".toString());     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        CloseableKt.closeFinally(r4, th);
        throw th;
    }

    private final void b(SupportSQLiteDatabase r3) {
        SupportSQLiteDatabase r2 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r3, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        Closeable r4 = (Closeable) ZeusTransformUtils.preCheckCast(r2.query("SELECT 1 FROM UnionSemanticMemory WHERE product_type = 1004 AND user_edit = 0 LIMIT 1"), Closeable.class, "com.obric.memorydata.plugin");
        boolean r0 = ((Cursor) ZeusTransformUtils.preCheckCast(r4, Cursor.class, "com.obric.memorydata.plugin")).moveToNext();     // Catch: Throwable -> L9
        CloseableKt.closeFinally(r4, null);
        if (r0 == true) goto L7;
        return;
    L7:
        r2.execSQL("INSERT OR IGNORE INTO SemanticState(`key`, num) VALUES ('change_seq', 0)");
        r2.execSQL("UPDATE SemanticState SET num = num + 1 WHERE `key` = 'change_seq'");
        r2.execSQL("UPDATE UnionSemanticMemory SET product_type = 1001, change_seq = (SELECT num FROM SemanticState WHERE `key` = 'change_seq') WHERE product_type = 1004 AND user_edit = 0");
        return;
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        CloseableKt.closeFinally(r4, th);
        throw th;
    }

    private final void b(SupportSQLiteDatabase r10, Set<String> r11) {
        SupportSQLiteDatabase r9 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r10, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        Set r12 = (Set) ZeusTransformUtils.wrapperContextForParams(r11, Set.class, "com.obric.memorydata.plugin");
        Closeable r13 = (Closeable) ZeusTransformUtils.preCheckCast(r9.query("SELECT entityId, conflict_entity_ids FROM UnionSemanticMemory WHERE conflict_entity_ids != '[]' AND conflict_entity_ids != ''"), Closeable.class, "com.obric.memorydata.plugin");
        Cursor r1 = (Cursor) ZeusTransformUtils.preCheckCast(r13, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L37
        List r2 = CollectionsKt.createListBuilder();     // Catch: Throwable -> L37
    L4:
        boolean r5 = true;
        List r6 = null;
        if (r1.moveToNext() == false) goto L28;
        GsonUtil r3 = GsonUtil.INSTANCE;     // Catch: Throwable -> L37
        String r4 = r1.getString(1);     // Catch: Throwable -> L37
        if (r4 != null) goto L9;
    L17:
        if (r6 != null) goto L19;
        r6 = CollectionsKt.emptyList();     // Catch: Throwable -> L37
    L19:
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L37
        Collection r8 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L37
        Iterator r14 = r7.iterator();     // Catch: Throwable -> L37
    L21:
        if (r14.hasNext() == false) goto L25;
        Object r15 = r14.next();     // Catch: Throwable -> L37
        if (r12.contains((String) ZeusTransformUtils.preCheckCast(r15, String.class, "com.obric.memorydata.plugin")) == true) goto L21;
        r8.add(r15);     // Catch: Throwable -> L37
        goto L21
    L25:
        List r16 = (List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L37
        if (r16.size() == r6.size()) goto L4;
        r2.add(TuplesKt.to(r1.getString(0), GsonUtil.INSTANCE.toJson(r16)));     // Catch: Throwable -> L37
        goto L4
    L9:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin")).length() > 0) goto L12;
        r5 = false;
    L12:
        if (r5 == true) goto L15;
        r4 = null;
    L15:
        if (r4 == null) goto L17;
        r6 = (List) ZeusTransformUtils.preCheckCast(GsonUtil.INSTANCE.getGSON().fromJson(r4, new b().getType()), List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L37
        goto L17
    L28:
        List r17 = CollectionsKt.build(r2);     // Catch: Throwable -> L37
        CloseableKt.closeFinally(r13, null);
        if (r17.isEmpty() == false) goto L32;
        return;
    L32:
        r9.execSQL("INSERT OR IGNORE INTO SemanticState(`key`, num) VALUES ('change_seq', 0)");
        r9.execSQL("UPDATE SemanticState SET num = num + 1 WHERE `key` = 'change_seq'");
        Iterator r18 = ((Iterable) ZeusTransformUtils.preCheckCast(r17, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L34:
        if (r18.hasNext() == false) goto L36;
        Pair r19 = (Pair) ZeusTransformUtils.preCheckCast(r18.next(), Pair.class, "com.obric.memorydata.plugin");
        r9.execSQL("UPDATE UnionSemanticMemory SET conflict_entity_ids = ?, change_seq = (SELECT num FROM SemanticState WHERE `key` = 'change_seq') WHERE entityId = ?", new String[]{(String) ZeusTransformUtils.preCheckCast(r19.component2(), String.class, "com.obric.memorydata.plugin"), (String) ZeusTransformUtils.preCheckCast(r19.component1(), String.class, "com.obric.memorydata.plugin")});
        goto L34
    L36:
        return;
    L37:
        th = move-exception;
        throw th;     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        CloseableKt.closeFinally(r13, th);
        throw th;
    }

    public static /* synthetic */ CharSequence lambda$U0QLV9kyzB8U6WyDX847y96zizw(String r0) {
        return a(r0);
    }

    public final a a(SupportSQLiteDatabase r6) {
        SupportSQLiteDatabase r7 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r6, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "database");
        Closeable r0 = (Closeable) ZeusTransformUtils.preCheckCast(r7.query("SELECT entityId FROM UnionSemanticMemory WHERE product_type = 1004 AND user_edit = 0 ORDER BY modifyTime DESC, id DESC LIMIT -1 OFFSET 1000"), Closeable.class, "com.obric.memorydata.plugin");
        Cursor r2 = (Cursor) ZeusTransformUtils.preCheckCast(r0, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L13
        Set r3 = SetsKt.createSetBuilder();     // Catch: Throwable -> L13
    L5:
        if (r2.moveToNext() == false) goto L7;
        r3.add(r2.getString(0));     // Catch: Throwable -> L13
        goto L5
    L7:
        Set<String> r4 = SetsKt.build(r3);     // Catch: Throwable -> L13
        CloseableKt.closeFinally(r0, null);
        a(r7, r4);
        b(r7);
        Set<String> r1 = o.f9586a.a(r7);
        a(r7, r1);
        Set<String> r5 = SetsKt.plus(r4, (Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin"));
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L12;
        b(r7, r5);
    L12:
        return new a(r4.size(), r1.size());
    L13:
        th = move-exception;
        throw th;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        CloseableKt.closeFinally(r0, th);
        throw th;
    }
}
