package com.obric.memorydata.database.manager;

import android.database.Cursor;
import androidx.exifinterface.media.ExifInterface;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001&B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0018\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u001e\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0016\u0010\u001b\u001a\u00020\u001c2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0019H\u0002J\u0016\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00050\u00192\u0006\u0010\u001f\u001a\u00020\u001cH\u0002J\u0010\u0010 \u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010!\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\"\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010#\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0018\u0010$\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010%\u001a\u00020\u001cH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006'"}, d2 = {"Lcom/obric/memorydata/database/manager/PersonalSemanticSchemaV11;", "", "<init>", "()V", "VERSION", "", "migration10To11", "Landroidx/room/migration/Migration;", "getMigration10To11", "()Landroidx/room/migration/Migration;", "callback", "Landroidx/room/RoomDatabase$Callback;", "getCallback", "()Landroidx/room/RoomDatabase$Callback;", "addSemanticColumns", "", "database", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "createSemanticTables", "createKeywordRefTable", "deduplicateUserKeywords", "mergeKeywordGroup", "keeperId", "", "loadKeywordGroup", "", "Lcom/obric/memorydata/database/manager/PersonalSemanticSchemaV11$KeywordRow;", "mergeSources", "", "encodedSources", "parseSources", "encoded", "createKeywordNameIndex", "createKeywordCleanupTrigger", "migrateProactiveSemantics", "clearSemanticDerivedOutputs", "ensureStateRows", "migrationPhase", "KeywordRow", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f9572a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Migration f9573b = null;
    private static final RoomDatabase.Callback c = null;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\bHÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003JE\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000e¨\u0006\""}, d2 = {"Lcom/obric/memorydata/database/manager/PersonalSemanticSchemaV11$KeywordRow;", "", OaidModel.KEY_ID, "", "summary", "", "sources", "userEdit", "", "createTime", "updateTime", "<init>", "(JLjava/lang/String;Ljava/lang/String;ZJJ)V", "getId", "()J", "getSummary", "()Ljava/lang/String;", "getSources", "getUserEdit", "()Z", "getCreateTime", "getUpdateTime", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f9574a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f9575b;
        private final String c;
        private final boolean d;
        private final long e;
        private final long f;

        public a(long r2, String r4, String r5, boolean r6, long r7, long r9) {
            Intrinsics.checkNotNullParameter(r4, "summary");
            Intrinsics.checkNotNullParameter(r5, "sources");
            this.f9574a = r2;
            this.f9575b = r4;
            this.c = r5;
            this.d = r6;
            this.e = r7;
            this.f = r9;
        }

        public final long a() {
            return this.f9574a;
        }

        public final String b() {
            return this.f9575b;
        }

        public final String c() {
            return this.c;
        }

        public final boolean d() {
            return this.d;
        }

        public final long e() {
            return this.e;
        }

        public boolean equals(Object r9) {
            if (this != r9) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r9, a.class) == true) goto L8;
            return false;
        L8:
            a r10 = (a) ZeusTransformUtils.preCheckCast(r9, a.class, "com.obric.memorydata.plugin");
            if (this.f9574a == r10.f9574a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f9575b, r10.f9575b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r10.c) == true) goto L18;
            return false;
        L18:
            if (this.d == r10.d) goto L21;
            return false;
        L21:
            if (this.e == r10.e) goto L24;
            return false;
        L24:
            if (this.f == r10.f) goto L26;
            return false;
        L26:
            return true;
        }

        public final long f() {
            return this.f;
        }

        public int hashCode() {
            return (((((((((Long.hashCode(this.f9574a) * 31) + this.f9575b.hashCode()) * 31) + this.c.hashCode()) * 31) + Boolean.hashCode(this.d)) * 31) + Long.hashCode(this.e)) * 31) + Long.hashCode(this.f);
        }

        public String toString() {
            return "KeywordRow(id=" + this.f9574a + ", summary=" + this.f9575b + ", sources=" + this.c + ", userEdit=" + this.d + ", createTime=" + this.e + ", updateTime=" + this.f + ')';
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class b<T> implements Comparator {
        public b() {
        }

        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            return ComparisonsKt.compareValues((Comparable) ZeusTransformUtils.preCheckCast(Boolean.valueOf(((a) ZeusTransformUtils.preCheckCast(r3, a.class, "com.obric.memorydata.plugin")).d()), Comparable.class, "com.obric.memorydata.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(Boolean.valueOf(((a) ZeusTransformUtils.preCheckCast(r2, a.class, "com.obric.memorydata.plugin")).d()), Comparable.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$thenBy$1"}, k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class c<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Comparator f9576a;

        public c(Comparator r3) {
            this.f9576a = (Comparator) ZeusTransformUtils.wrapperContextForParams(r3, Comparator.class, "com.obric.memorydata.plugin");
        }

        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            int r1 = this.f9576a.compare(r2, r3);
            if (r1 == 0) goto L6;
            return r1;
        L6:
            return ComparisonsKt.compareValues((Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(((a) ZeusTransformUtils.preCheckCast(r2, a.class, "com.obric.memorydata.plugin")).a()), Comparable.class, "com.obric.memorydata.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(((a) ZeusTransformUtils.preCheckCast(r3, a.class, "com.obric.memorydata.plugin")).a()), Comparable.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$thenByDescending$1"}, k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class d<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Comparator f9577a;

        public d(Comparator r3) {
            this.f9577a = (Comparator) ZeusTransformUtils.wrapperContextForParams(r3, Comparator.class, "com.obric.memorydata.plugin");
        }

        @Override // java.util.Comparator
        public final int compare(T r4, T r5) {
            int r3 = this.f9577a.compare(r4, r5);
            if (r3 == 0) goto L6;
            return r3;
        L6:
            return ComparisonsKt.compareValues((Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(((a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin")).f()), Comparable.class, "com.obric.memorydata.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(((a) ZeusTransformUtils.preCheckCast(r4, a.class, "com.obric.memorydata.plugin")).f()), Comparable.class, "com.obric.memorydata.plugin"));
        }
    }

    static {
        f9572a = new j();
        f9573b = (Migration) ZeusTransformUtils.preCheckCast(new PersonalSemanticSchemaV11$migration10To11$1(), Migration.class, "com.obric.memorydata.plugin");
        c = (RoomDatabase.Callback) ZeusTransformUtils.preCheckCast(new PersonalSemanticSchemaV11$callback$1(), RoomDatabase.Callback.class, "com.obric.memorydata.plugin");
    }

    private j() {
    }

    private final String a(List<String> r4) {
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        LinkedHashSet r5 = new LinkedHashSet();
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r6.next(), String.class, "com.obric.memorydata.plugin");
        r5.addAll((Collection) ZeusTransformUtils.preCheckCast(f9572a.a(r1), Collection.class, "com.obric.memorydata.plugin"));
        goto L4
    L6:
        String r7 = new JSONArray((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.memorydata.plugin")).toString();
        Intrinsics.checkNotNullExpressionValue(r7, "toString(...)");
        return r7;
    }

    private final List<Integer> a(String r13) {
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L5;
        JSONArray r12 = new JSONArray(r13);     // Catch: JSONException -> L37
        List r14 = CollectionsKt.createListBuilder();     // Catch: JSONException -> L37
        int r1 = r12.length();     // Catch: JSONException -> L37
        int r3 = 0;
    L7:
        if (r3 >= r1) goto L35;
        Object r4 = r12.opt(r3);     // Catch: JSONException -> L37
        Integer r6 = null;
        if (ZeusTransformUtils.instanceOf(r4, Number.class) == false) goto L30;
        Double r5 = Double.valueOf(((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.memorydata.plugin")).doubleValue());     // Catch: JSONException -> L37
        double r7 = ((Number) ZeusTransformUtils.preCheckCast(r5, Number.class, "com.obric.memorydata.plugin")).doubleValue();     // Catch: JSONException -> L37
        boolean r9 = true;
        if (Double.isInfinite(r7) == false) goto L13;
    L15:
        boolean r8 = false;
    L16:
        if (r8 == true) goto L18;
    L23:
        r9 = false;
    L24:
        if (r9 == true) goto L27;
        r5 = null;
    L27:
        if (r5 == null) goto L32;
        r6 = Integer.valueOf((int) r5.doubleValue());     // Catch: JSONException -> L37
    L32:
        if (r6 == null) goto L34;
        r14.add(r6);     // Catch: JSONException -> L37
    L34:
        r3 = r3 + 1;     // Catch: JSONException -> L37
        goto L7
    L18:
        if (r7 != ((int) r7)) goto L20;
        boolean r10 = true;
    L21:
        if (r10 == false) goto L23;
    L20:
        r10 = false;
        goto L21
    L13:
        if (Double.isNaN(r7) == true) goto L15;
        r8 = true;
        goto L16
    L30:
        if (ZeusTransformUtils.instanceOf(r4, String.class) == false) goto L32;
        r6 = StringsKt.toIntOrNull((String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.memorydata.plugin"));     // Catch: JSONException -> L37
        goto L32
    L35:
        return CollectionsKt.build(r14);
    L38:
        return CollectionsKt.emptyList();
    L5:
        return CollectionsKt.emptyList();
    }

    private final void a(SupportSQLiteDatabase r8) {
        SupportSQLiteDatabase r7 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r8, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        List r9 = CollectionsKt.listOf(new String[]{"change_seq INTEGER NOT NULL DEFAULT 0", "confirmation_state TEXT NOT NULL DEFAULT 'none'", "migration_version INTEGER NOT NULL DEFAULT 0", "evidence_ids TEXT NOT NULL DEFAULT '[]'", "conflict_entity_ids TEXT NOT NULL DEFAULT '[]'", "last_user_assert_at INTEGER NOT NULL DEFAULT 0"});
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r7.execSQL("ALTER TABLE UnionSemanticMemory ADD COLUMN " + ((String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.memorydata.plugin")));
        goto L4
    L6:
        Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L8:
        if (r10.hasNext() == false) goto L10;
        r7.execSQL("ALTER TABLE UnionSemanticMemoryHistoryEntity ADD COLUMN semantic_" + ((String) ZeusTransformUtils.preCheckCast(r10.next(), String.class, "com.obric.memorydata.plugin")));
        goto L8
    }

    private final void a(SupportSQLiteDatabase r11, final long r12) {
        SupportSQLiteDatabase r13 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r11, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        List<a> r0 = b(r13, r12);
        if (r0.size() >= 2) goto L5;
        return;
    L5:
        Object r2 = ((a) ZeusTransformUtils.preCheckCast(CollectionsKt.first(CollectionsKt.sortedWith((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin"), (Comparator) ZeusTransformUtils.preCheckCast(new c((Comparator) ZeusTransformUtils.preCheckCast(new d((Comparator) ZeusTransformUtils.preCheckCast(new b(), Comparator.class, "com.obric.memorydata.plugin")), Comparator.class, "com.obric.memorydata.plugin")), Comparator.class, "com.obric.memorydata.plugin"))), a.class, "com.obric.memorydata.plugin")).b();
        Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin");
        Collection r5 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r6 = r4.iterator();
    L7:
        if (r6.hasNext() == false) goto L9;
        r5.add(((a) ZeusTransformUtils.preCheckCast(r6.next(), a.class, "com.obric.memorydata.plugin")).c());
        goto L7
    L9:
        Object r10 = a((List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.memorydata.plugin"));
        Object[] r7 = new Object[6];
        r7[0] = r2;
        r7[1] = r10;
        Iterable r14 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r14, Collection.class) == true) goto L12;
    L14:
        Iterator r15 = r14.iterator();
    L16:
        if (r15.hasNext() == false) goto L13;
        if (((a) ZeusTransformUtils.preCheckCast(r15.next(), a.class, "com.obric.memorydata.plugin")).d() == false) goto L16;
        int r16 = 1;
    L20:
        r7[2] = Integer.valueOf(r16);
        Iterator r8 = ((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        if (r8.hasNext() == false) goto L44;
        Comparable r9 = (Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(((a) ZeusTransformUtils.preCheckCast(r8.next(), a.class, "com.obric.memorydata.plugin")).e()), Comparable.class, "com.obric.memorydata.plugin");
    L24:
        if (r8.hasNext() == false) goto L28;
        Comparable r17 = (Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(((a) ZeusTransformUtils.preCheckCast(r8.next(), a.class, "com.obric.memorydata.plugin")).e()), Comparable.class, "com.obric.memorydata.plugin");
        if (r9.compareTo(r17) <= 0) goto L24;
        r9 = r17;
        goto L24
    L28:
        r7[3] = r9;
        Iterator r18 = ((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        if (r18.hasNext() == false) goto L42;
        Comparable r19 = (Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(((a) ZeusTransformUtils.preCheckCast(r18.next(), a.class, "com.obric.memorydata.plugin")).f()), Comparable.class, "com.obric.memorydata.plugin");
    L32:
        if (r18.hasNext() == false) goto L36;
        Comparable r20 = (Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(((a) ZeusTransformUtils.preCheckCast(r18.next(), a.class, "com.obric.memorydata.plugin")).f()), Comparable.class, "com.obric.memorydata.plugin");
        if (r19.compareTo(r20) >= 0) goto L32;
        r19 = r20;
        goto L32
    L36:
        r7[4] = r19;
        r7[5] = Long.valueOf(r12);
        r13.execSQL("UPDATE UserKeyword SET summary = ?, sources = ?, user_edit = ?, create_time = ?, update_time = ? WHERE id = ?", r7);
        Iterator r110 = SequencesKt.filter(CollectionsKt.asSequence((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin")), new $$Lambda$j$E8rMSboCTNHBWg4t9TocvA9TFNw(r12)).iterator();
    L38:
        if (r110.hasNext() == false) goto L40;
        a r1 = (a) ZeusTransformUtils.preCheckCast(r110.next(), a.class, "com.obric.memorydata.plugin");
        r13.execSQL("UPDATE OR IGNORE UserKeywordRef SET keyword_id = ? WHERE keyword_id = ?", new Long[]{Long.valueOf(r12), Long.valueOf(r1.a())});
        r13.execSQL("DELETE FROM UserKeyword WHERE id = ?", new Long[]{Long.valueOf(r1.a())});
        goto L38
    L40:
        return;
    L42:
        throw new NoSuchElementException();
    L44:
        throw new NoSuchElementException();
    L13:
        r16 = 0;
        goto L20
    L12:
        if (((Collection) ZeusTransformUtils.preCheckCast(r14, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L14;
        goto L13
    }

    private final void a(SupportSQLiteDatabase r11, String r12) {
        SupportSQLiteDatabase r10 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r11, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        Iterator r13 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.listOf(new Triple[]{new Triple("change_seq", 0L, null), new Triple("restore_phase", 0L, "completed"), new Triple("migration_phase", 0L, r12), new Triple("cursor:user_insight", 0L, null), new Triple("cursor:interest_summary", 0L, null), new Triple("cursor:dreaming", 0L, null)}), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r13.hasNext() == false) goto L7;
        Triple r1 = (Triple) ZeusTransformUtils.preCheckCast(r13.next(), Triple.class, "com.obric.memorydata.plugin");
        String r2 = (String) ZeusTransformUtils.preCheckCast(r1.component1(), String.class, "com.obric.memorydata.plugin");
        long r8 = ((Number) ZeusTransformUtils.preCheckCast(r1.component2(), Number.class, "com.obric.memorydata.plugin")).longValue();
        r10.execSQL("INSERT OR IGNORE INTO SemanticState(`key`, num, txt) VALUES (?, ?, ?)", new Object[]{r2, Long.valueOf(r8), (String) ZeusTransformUtils.preCheckCast(r1.component3(), String.class, "com.obric.memorydata.plugin")});
        goto L4
    L7:
        if (Intrinsics.areEqual(r12, "schema") == false) goto L11;
        r10.execSQL("INSERT OR IGNORE INTO SemanticState(`key`, num) SELECT ?, ? WHERE EXISTS (SELECT 1 FROM SemanticState WHERE `key` = 'migration_phase' AND txt = 'schema')", new Object[]{"migration_started_at_ms", Long.valueOf(System.currentTimeMillis())});
        return;
    }

    public static final /* synthetic */ void a(j r2, SupportSQLiteDatabase r3) {
        r2.a((SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r3, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ void a(j r2, SupportSQLiteDatabase r3, String r4) {
        r2.a((SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r3, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin"), r4);
    }

    private static final boolean a(long r2, a r4) {
        Intrinsics.checkNotNullParameter(r4, "it");
        if (r4.a() == r2) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final List<a> b(SupportSQLiteDatabase r20, long r21) {
        SupportSQLiteDatabase r1 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r20, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        List<a> r3 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        int r4 = 1;
        Closeable r2 = (Closeable) ZeusTransformUtils.preCheckCast(r1.query("SELECT id, summary, sources, user_edit, create_time, update_time FROM UserKeyword WHERE name = (SELECT name FROM UserKeyword WHERE id = ?) COLLATE NOCASE ORDER BY id", new Long[]{Long.valueOf(r21)}), Closeable.class, "com.obric.memorydata.plugin");
        Cursor r5 = (Cursor) ZeusTransformUtils.preCheckCast(r2, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
    L5:
        if (r5.moveToNext() == false) goto L11;
        Collection r6 = (Collection) ZeusTransformUtils.preCheckCast(r3, Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        long r9 = r5.getLong(0);     // Catch: Throwable -> L14
        String r11 = r5.getString(r4);     // Catch: Throwable -> L14
        Intrinsics.checkNotNullExpressionValue(r11, "getString(...)");     // Catch: Throwable -> L14
        String r12 = r5.getString(2);     // Catch: Throwable -> L14
        Intrinsics.checkNotNullExpressionValue(r12, "getString(...)");     // Catch: Throwable -> L14
        if (r5.getInt(3) == 0) goto L9;
        boolean r13 = r4;
    L10:
        r6.add(new a(r9, r11, r12, r13, r5.getLong(4), r5.getLong(5)));     // Catch: Throwable -> L14
        r4 = 1;
        goto L5
    L9:
        r13 = 0;
        goto L10
    L11:
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L14
        CloseableKt.closeFinally(r2, null);
        return r3;
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        CloseableKt.closeFinally(r2, th);
        throw th;
    }

    private final void b(SupportSQLiteDatabase r3) {
        SupportSQLiteDatabase r4 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r3, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        r4.execSQL("CREATE TABLE IF NOT EXISTS SemanticRetraction (\n                id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,\n                entity_id TEXT NOT NULL,\n                content TEXT NOT NULL,\n                content_type TEXT NOT NULL,\n                content_subtype TEXT NOT NULL,\n                reason TEXT NOT NULL,\n                retracted_at INTEGER NOT NULL,\n                change_seq INTEGER NOT NULL)");
        r4.execSQL("CREATE INDEX IF NOT EXISTS idx_retraction_reason_seq ON SemanticRetraction(reason, change_seq)");
        r4.execSQL("CREATE INDEX IF NOT EXISTS idx_retraction_time ON SemanticRetraction(retracted_at)");
        c(r4);
        r4.execSQL("CREATE TABLE IF NOT EXISTS SemanticState (\n                `key` TEXT NOT NULL,\n                num INTEGER NOT NULL DEFAULT 0,\n                txt TEXT,\n                PRIMARY KEY(`key`))");
    }

    public static final /* synthetic */ void b(j r2, SupportSQLiteDatabase r3) {
        r2.b((SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r3, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin"));
    }

    private final void c(SupportSQLiteDatabase r2) {
        SupportSQLiteDatabase r1 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r2, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        r1.execSQL("CREATE TABLE IF NOT EXISTS UserKeywordRef (\n                id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,\n                keyword_id INTEGER NOT NULL,\n                semantic_entity_id TEXT NOT NULL,\n                FOREIGN KEY(keyword_id) REFERENCES UserKeyword(id) ON UPDATE NO ACTION ON DELETE CASCADE,\n                FOREIGN KEY(semantic_entity_id) REFERENCES UnionSemanticMemory(entityId) ON UPDATE NO ACTION ON DELETE CASCADE)");
        r1.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS idx_kwref ON UserKeywordRef(keyword_id, semantic_entity_id)");
        r1.execSQL("CREATE INDEX IF NOT EXISTS idx_kwref_sem ON UserKeywordRef(semantic_entity_id)");
    }

    public static final /* synthetic */ void c(j r2, SupportSQLiteDatabase r3) {
        r2.d((SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r3, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin"));
    }

    private final void d(SupportSQLiteDatabase r7) {
        SupportSQLiteDatabase r6 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r7, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        List r8 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Closeable r1 = (Closeable) ZeusTransformUtils.preCheckCast(r6.query("SELECT MIN(id) FROM UserKeyword GROUP BY name COLLATE NOCASE HAVING COUNT(*) > 1"), Closeable.class, "com.obric.memorydata.plugin");
        Cursor r2 = (Cursor) ZeusTransformUtils.preCheckCast(r1, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L13
    L5:
        if (r2.moveToNext() == false) goto L7;
        ((Collection) ZeusTransformUtils.preCheckCast(r8, Collection.class, "com.obric.memorydata.plugin")).add(Long.valueOf(r2.getLong(0)));     // Catch: Throwable -> L13
        goto L5
    L7:
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L13
        CloseableKt.closeFinally(r1, null);
        Iterator r9 = ((Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L10:
        if (r9.hasNext() == false) goto L12;
        long r4 = ((Number) ZeusTransformUtils.preCheckCast(r9.next(), Number.class, "com.obric.memorydata.plugin")).longValue();
        f9572a.a(r6, r4);
        goto L10
    L12:
        return;
    L13:
        th = move-exception;
        throw th;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        CloseableKt.closeFinally(r1, th);
        throw th;
    }

    public static final /* synthetic */ void d(j r2, SupportSQLiteDatabase r3) {
        r2.e((SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r3, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin"));
    }

    private final void e(SupportSQLiteDatabase r2) {
        ((SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r2, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin")).execSQL("CREATE UNIQUE INDEX IF NOT EXISTS idx_user_keyword_name_nocase ON UserKeyword(name COLLATE NOCASE)");
    }

    public static final /* synthetic */ void e(j r2, SupportSQLiteDatabase r3) {
        r2.f((SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r3, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin"));
    }

    private final void f(SupportSQLiteDatabase r2) {
        ((SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r2, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin")).execSQL("CREATE TRIGGER IF NOT EXISTS cleanup_user_keyword_after_ref_delete\n                AFTER DELETE ON UserKeywordRef\n                BEGIN\n                  DELETE FROM UserKeyword\n                   WHERE id = OLD.keyword_id\n                     AND NOT EXISTS (\n                       SELECT 1 FROM UserKeywordRef WHERE keyword_id = OLD.keyword_id\n                     );\n                END");
    }

    public static final /* synthetic */ void f(j r2, SupportSQLiteDatabase r3) {
        r2.h((SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r3, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin"));
    }

    private final void g(SupportSQLiteDatabase r2) {
        SupportSQLiteDatabase r1 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r2, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        r1.execSQL(StringsKt.trimIndent("UPDATE UnionSemanticMemory\n                SET confidence = 4.0,\n                    confirmation_state = 'none',\n                    description = '用户主动记忆',\n                    migration_version = 1,\n                    tag_path = " + s.f9596a.b() + ",\n                    change_seq = 1\n                WHERE product_type = 1003"));
        r1.execSQL("UPDATE SemanticState SET num = 1 WHERE `key` = 'change_seq' AND EXISTS (SELECT 1 FROM UnionSemanticMemory WHERE product_type = 1003)");
    }

    public static final /* synthetic */ void g(j r2, SupportSQLiteDatabase r3) {
        r2.g((SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r3, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin"));
    }

    private final void h(SupportSQLiteDatabase r2) {
        SupportSQLiteDatabase r1 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r2, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        r1.execSQL("DELETE FROM MemoryProcessUserInsight");
        r1.execSQL("DELETE FROM UnionUserInsight");
        r1.execSQL("DELETE FROM UnionUserPersona");
        r1.execSQL("DELETE FROM UnionSemanticTypeSummary");
    }

    public static /* synthetic */ boolean lambda$E8rMSboCTNHBWg4t9TocvA9TFNw(long r0, a r2) {
        return a(r0, r2);
    }

    public final Migration a() {
        return f9573b;
    }

    public final RoomDatabase.Callback b() {
        return c;
    }
}
