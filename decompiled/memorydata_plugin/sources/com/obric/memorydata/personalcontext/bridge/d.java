package com.obric.memorydata.personalcontext.bridge;

import android.content.Context;
import android.net.Uri;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.database.e;
import com.obric.memorydata.middleware.database.g;
import com.obric.memorydata.middleware.database.h;
import com.obric.memorydata.middleware.database.l;
import com.obric.search.api.schema.impl.FullTextSearchSchema;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u001bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0005J\u000e\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0005J\u001a\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016H\u0002J\f\u0010\u0018\u001a\u00020\u0019*\u00020\u001aH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/obric/memorydata/personalcontext/bridge/InvertedIndexDbManager;", "", "<init>", "()V", "TAG", "", "dbInstanceMap", "", "Lcom/obric/memorydata/personalcontext/bridge/InvertedIndexDbManager$DbEntry;", "dbLockMap", "initDatabase", "", "dbSchema", "Lcom/obric/memorydata/middleware/database/InvertedIndexDatabaseSchema;", "getEngine", "Lcom/obric/search/api/OSearchEngine;", "dbName", "getAdaptedEngine", "logicName", "buildMigrationConfig", "Lcom/obric/search/api/config/MigrationConfig;", "upgradeSchemas", "", "Lcom/obric/memorydata/middleware/database/UpgradeSchema;", "toOSchema", "Lcom/obric/search/api/schema/impl/FullTextSearchSchema;", "Lcom/obric/memorydata/middleware/database/InvertedIndexSchema;", "DbEntry", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f12043a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map<String, a> f12044b = null;
    private static final Map<String, Object> c = null;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/obric/memorydata/personalcontext/bridge/InvertedIndexDbManager$DbEntry;", "", "db", "Lcom/obric/search/api/OSearchEngine;", "version", "", "<init>", "(Lcom/obric/search/api/OSearchEngine;I)V", "getDb", "()Lcom/obric/search/api/OSearchEngine;", "getVersion", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.obric.search.api.a f12045a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f12046b;

        public a(com.obric.search.api.a r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "db");
            this.f12045a = r2;
            this.f12046b = r3;
        }

        public final com.obric.search.api.a a() {
            return this.f12045a;
        }

        public final int b() {
            return this.f12046b;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f12045a, r6.f12045a) == true) goto L12;
            return false;
        L12:
            if (this.f12046b == r6.f12046b) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f12045a.hashCode() * 31) + Integer.hashCode(this.f12046b);
        }

        public String toString() {
            return "DbEntry(db=" + this.f12045a + ", version=" + this.f12046b + ')';
        }
    }

    static {
        f12043a = new d();
        f12044b = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        c = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
    }

    private d() {
    }

    private final com.obric.search.api.a.a a(List<l> r9) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        if (r8 != null) goto L6;
        return null;
    L6:
        com.obric.search.api.a.a r10 = new com.obric.search.api.a.a();
        Iterator r11 = r8.iterator();
    L8:
        if (r11.hasNext() == false) goto L16;
        l r1 = (l) ZeusTransformUtils.preCheckCast(r11.next(), l.class, "com.obric.memorydata.plugin");
        int r2 = r1.a();
        int r3 = r1.b();
        Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast(r1.c(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r5 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r6 = r4.iterator();
    L11:
        if (r6.hasNext() == false) goto L13;
        r5.add(f12043a.a((g) ZeusTransformUtils.preCheckCast(r6.next(), g.class, "com.obric.memorydata.plugin")));
        goto L11
    L13:
        List r7 = (List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.memorydata.plugin");
        if (r7.isEmpty() == true) goto L8;
        r10.a(new com.obric.search.api.c.d(r2, r3).a(new com.obric.search.api.c.c[]{new com.obric.search.api.c.b(r7)}).a());
        RunLog.INSTANCE.debug("InvertedIndexDbManager", "addMigration for [" + r2 + " -> " + r3 + "], changes: " + r7);
        goto L8
    L16:
        return r10;
    }

    private final FullTextSearchSchema a(g r7) {
        FullTextSearchSchema.TOKENIZER[] r6 = FullTextSearchSchema.TOKENIZER.values();
        int r0 = r6.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L8;
        FullTextSearchSchema.TOKENIZER r3 = r6[r2];
        if (Intrinsics.areEqual(r3.getSqlName(), r7.c()) == true) goto L9;
        r2 = r2 + 1;
    L9:
        if (r3 == null) goto L13;
        return new FullTextSearchSchema(r7.a(), r7.b(), r3, false);
    L13:
        throw new IllegalArgumentException("Invalid tokenizer: " + r7.c());
    L8:
        r3 = null;
        goto L9
    }

    public final com.obric.search.api.a a(String r3) {
        Intrinsics.checkNotNullParameter(r3, "dbName");
        a r2 = (a) ZeusTransformUtils.preCheckCast(f12044b.get(r3), a.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L8;
        com.obric.search.api.a r4 = r2.a();
        if (r4 == null) goto L8;
        return r4;
    L8:
        throw new IllegalStateException('[' + r3 + "] has not been initialized");
    }

    public final void a(e r23) {
        Intrinsics.checkNotNullParameter(r23, "dbSchema");
        String r1 = r23.e();
        Map<String, Object> r2 = c;
        Object r3 = r2.get(r1);
        if (r3 != null) goto L5;
        r3 = new Object();
        r2.put(r1, r3);
    L5:
        Object r14 = r3;
        monitor-enter(r14);
        a r12 = (a) ZeusTransformUtils.preCheckCast(f12044b.get(r1), a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L33
        boolean r4 = false;
        if (r12 == null) goto L10;
        int r5 = r12.b();     // Catch: Throwable -> L33
    L11:
        int r15 = r23.a();     // Catch: Throwable -> L33
        if (r12 == null) goto L16;
        if (r5 < r15) goto L16;
        monitor-exit(r14);
        return;
    L16:
        com.obric.search.api.a.a r10 = f12043a.a(r23.d());     // Catch: Throwable -> L33
        String r8 = com.obric.memorydata.middleware.database.d.f11652a.c(r1);     // Catch: Throwable -> L33
        Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(r23.b(), Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L33
        Collection r7 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10)), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L33
        Iterator r9 = r6.iterator();     // Catch: Throwable -> L33
    L18:
        if (r9.hasNext() == false) goto L20;
        r7.add(f12043a.a((g) ZeusTransformUtils.preCheckCast(r9.next(), g.class, "com.obric.memorydata.plugin")));     // Catch: Throwable -> L33
        goto L18
    L20:
        List r11 = (List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L33
        String r13 = r23.c();     // Catch: Throwable -> L33
        if (r13 == null) goto L23;
        Uri r16 = Uri.parse(r13);     // Catch: Throwable -> L33
    L24:
        Uri r17 = r16;
        if (r12 == null) goto L27;
        r4 = true;
    L27:
        if (r4 == false) goto L29;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "InvertedIndexDbManager", "upgrade db " + r23, false, 4, null);     // Catch: Throwable -> L33
        Intrinsics.checkNotNull(r12);     // Catch: Throwable -> L33
        com.obric.search.api.a.a(r12.a(), (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r1, r15, r11, r8, null, r10, 32, null);     // Catch: Throwable -> L33
        f12044b.put(r1, new a(r12.a(), r15));     // Catch: Throwable -> L33
    L30:
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L33
        monitor-exit(r14);
        return;
    L29:
        com.obric.search.api.a r18 = new com.obric.search.api.a();     // Catch: Throwable -> L33
        com.obric.search.api.a.a(r18, (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r1, r15, r11, r17, r8, null, r10, null, 320, null);     // Catch: Throwable -> L33
        r18.a(com.obric.memorydata.database.util.c.f9626a.d());     // Catch: Throwable -> L33
        f12044b.put(r1, new a(r18, r15));     // Catch: Throwable -> L33
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "InvertedIndexDbManager", "init db " + r23 + " done", false, 4, null);     // Catch: Throwable -> L33
        goto L30
    L23:
        r16 = null;
        goto L24
    L10:
        r5 = 0;
    L33:
        th = move-exception;
        throw th;
    }

    public final com.obric.search.api.a b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "logicName");
        return a(h.f11660a.b(r2));
    }
}
