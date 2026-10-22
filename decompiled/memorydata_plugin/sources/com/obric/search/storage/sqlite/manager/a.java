package com.obric.search.storage.sqlite.manager;

import android.content.Context;
import com.obric.search.api.c.c;
import com.obric.search.api.c.e;
import com.obric.search.api.c.f;
import com.obric.search.api.schema.impl.FullTextSearchSchema;
import com.obric.search.common.log.RuntimeLogger;
import com.obric.search.extension.OFts5Extension;
import com.obric.search.storage.sqlite.fts5.SQLiteFts5Extension;
import com.tencent.wcdb.database.SQLiteCipherSpec;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.h;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB[\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0011R\u001b\u0010\u0012\u001a\u00020\u00138FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/obric/search/storage/sqlite/manager/SQLiteDatabaseManager;", "", "context", "Landroid/content/Context;", "databaseName", "", "version", "", "schemaList", "", "Lcom/obric/search/storage/sqlite/schema/intf/ISQLiteTableSchema;", "passPhrase", "sqlCipherConfig", "Lcom/obric/search/api/config/SQLCipherConfig;", "migrationContainer", "Lcom/obric/search/api/migration/MigrationContainer;", "databasePath", "(Landroid/content/Context;Ljava/lang/String;ILjava/util/List;Ljava/lang/String;Lcom/obric/search/api/config/SQLCipherConfig;Lcom/obric/search/api/migration/MigrationContainer;Ljava/lang/String;)V", "database", "Lcom/tencent/wcdb/database/SQLiteDatabase;", "getDatabase", "()Lcom/tencent/wcdb/database/SQLiteDatabase;", "database$delegate", "Lkotlin/Lazy;", "sqliteOpenHelper", "Lcom/tencent/wcdb/database/SQLiteOpenHelper;", "Companion", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0800a f14969a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final h f14970b;
    private final Lazy c;

    /* JADX INFO: renamed from: com.obric.search.storage.sqlite.manager.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/search/storage/sqlite/manager/SQLiteDatabaseManager$Companion;", "", "()V", "TAG", "", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class C0800a {
        private C0800a() {
        }

        public /* synthetic */ C0800a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\"\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016¨\u0006\u000b"}, d2 = {"com/obric/search/storage/sqlite/manager/SQLiteDatabaseManager$sqliteOpenHelper$1", "Lcom/tencent/wcdb/database/SQLiteOpenHelper;", "onConfigure", "", "db", "Lcom/tencent/wcdb/database/SQLiteDatabase;", "onCreate", "onUpgrade", "oldVersion", "", "newVersion", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class b extends h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f14971a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ List<com.obric.search.storage.sqlite.a.b.a> f14972b;
        final /* synthetic */ e c;

        b(Context r9, int r10, String r11, List<? extends com.obric.search.storage.sqlite.a.b.a> r12, e r13, String r14, byte[] r15, SQLiteCipherSpec r16) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
            List<com.obric.search.storage.sqlite.a.b.a> r2 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.memorydata.plugin");
            this.f14971a = r11;
            this.f14972b = r2;
            this.c = r13;
            super(r1, r14, r15, r16, null, r10, null);
        }

        @Override // com.tencent.wcdb.database.h
        public void a(SQLiteDatabase r3) {
            super.a(r3);
            if (r3 != null) goto L6;
            RuntimeLogger.f14958a.d("SQLiteDatabaseManager", "SQLite database[" + this.f14971a + "] onConfigure db is null.");
            return;
        L6:
            r3.a((com.tencent.wcdb.extension.a) ZeusTransformUtils.preCheckCast(OFts5Extension.f14960a, com.tencent.wcdb.extension.a.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.tencent.wcdb.database.h
        public void a(SQLiteDatabase r12, int r13, int r14) {
            RuntimeLogger.f14958a.b("SQLiteDatabaseManager", "SQLite database[" + this.f14971a + "] onUpgrade! From " + r13 + " to " + r14 + '!');
            if (r12 != null) goto L6;
            RuntimeLogger.f14958a.d("SQLiteDatabaseManager", "SQLite database[" + this.f14971a + "] onUpgrade db is null.");
            return;
        L6:
            e r0 = this.c;
            if (r0 == null) goto L9;
            List<com.obric.search.api.c.a> r15 = r0.a(r13, r14);
        L10:
            if (r15 != null) goto L13;
            RuntimeLogger.f14958a.d("SQLiteDatabaseManager", "SQLite database[" + this.f14971a + "] onUpgrade migrationPath is null!");
            return;
        L13:
            Iterator<com.obric.search.api.c.a> r16 = r15.iterator();
        L15:
            if (r16.hasNext() == false) goto L39;
            com.obric.search.api.c.a r17 = (com.obric.search.api.c.a) ZeusTransformUtils.preCheckCast(r16.next(), com.obric.search.api.c.a.class, "com.obric.memorydata.plugin");
            RuntimeLogger.f14958a.c("SQLiteDatabaseManager", "SQLite database[" + this.f14971a + "] onUpgrade exec migration[" + r17.a() + "->" + r17.b() + ']');
            Iterator<c> r18 = r17.c().iterator();
        L18:
            if (r18.hasNext() == false) goto L15;
            c r1 = (c) ZeusTransformUtils.preCheckCast(r18.next(), c.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r1, com.obric.search.api.c.b.class) == true) goto L21;
            if (ZeusTransformUtils.instanceOf(r1, f.class) == false) goto L18;
            RuntimeLogger.f14958a.b("SQLiteDatabaseManager", "SQLite database[" + this.f14971a + "] onUpgrade exec remove schema action. size is " + ((f) ZeusTransformUtils.preCheckCast(r1, f.class, "com.obric.memorydata.plugin")).a().size());
            Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(((f) ZeusTransformUtils.preCheckCast(r1, f.class, "com.obric.memorydata.plugin")).a(), Iterable.class, "com.obric.memorydata.plugin");
            Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10)), Collection.class, "com.obric.memorydata.plugin");
            Iterator r3 = r2.iterator();
        L33:
            if (r3.hasNext() == false) goto L35;
            FullTextSearchSchema r6 = (FullTextSearchSchema) ZeusTransformUtils.preCheckCast(r3.next(), FullTextSearchSchema.class, "com.obric.memorydata.plugin");
            r4.add(new com.obric.search.storage.sqlite.a.a.a(r6.a(), r6.b(), r6.c(), r6.d()));
            goto L33
        L35:
            Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        L37:
            if (r5.hasNext() == false) goto L18;
            com.obric.search.storage.sqlite.a.a.a r7 = (com.obric.search.storage.sqlite.a.a.a) ZeusTransformUtils.preCheckCast(r5.next(), com.obric.search.storage.sqlite.a.a.a.class, "com.obric.memorydata.plugin");
            r12.c(r7.c());
            RuntimeLogger.f14958a.a("SQLiteDatabaseManager", "execSQL " + r7.b());
            goto L37
        L21:
            RuntimeLogger.f14958a.b("SQLiteDatabaseManager", "SQLite database[" + this.f14971a + "] onUpgrade exec add schema action. size is " + ((com.obric.search.api.c.b) ZeusTransformUtils.preCheckCast(r1, com.obric.search.api.c.b.class, "com.obric.memorydata.plugin")).a().size());
            Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(((com.obric.search.api.c.b) ZeusTransformUtils.preCheckCast(r1, com.obric.search.api.c.b.class, "com.obric.memorydata.plugin")).a(), Iterable.class, "com.obric.memorydata.plugin");
            Collection r9 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10)), Collection.class, "com.obric.memorydata.plugin");
            Iterator r10 = r8.iterator();
        L23:
            if (r10.hasNext() == false) goto L25;
            FullTextSearchSchema r11 = (FullTextSearchSchema) ZeusTransformUtils.preCheckCast(r10.next(), FullTextSearchSchema.class, "com.obric.memorydata.plugin");
            r9.add(new com.obric.search.storage.sqlite.a.a.a(r11.a(), r11.b(), r11.c(), r11.d()));
            goto L23
        L25:
            Iterator r19 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r9, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        L27:
            if (r19.hasNext() == false) goto L18;
            com.obric.search.storage.sqlite.a.a.a r20 = (com.obric.search.storage.sqlite.a.a.a) ZeusTransformUtils.preCheckCast(r19.next(), com.obric.search.storage.sqlite.a.a.a.class, "com.obric.memorydata.plugin");
            r12.c(r20.b());
            RuntimeLogger.f14958a.a("SQLiteDatabaseManager", "execSQL " + r20.b());
            goto L27
        L39:
            RuntimeLogger.f14958a.b("SQLiteDatabaseManager", "SQLite database[" + this.f14971a + "] onUpgrade done!");
            return;
        L9:
            r15 = null;
            goto L10
        }

        @Override // com.tencent.wcdb.database.h
        public void b(SQLiteDatabase r8) {
            RuntimeLogger.f14958a.b("SQLiteDatabaseManager", "SQLite database[" + this.f14971a + "] onCreate!");
            if (r8 != null) goto L6;
            RuntimeLogger.f14958a.d("SQLiteDatabaseManager", "SQLite database[" + this.f14971a + "] onCreate db is null.");
            return;
        L6:
            Iterator<com.obric.search.storage.sqlite.a.b.a> r0 = this.f14972b.iterator();
        L8:
            if (r0.hasNext() == false) goto L10;
            com.obric.search.storage.sqlite.a.b.a r1 = (com.obric.search.storage.sqlite.a.b.a) ZeusTransformUtils.preCheckCast(r0.next(), com.obric.search.storage.sqlite.a.b.a.class, "com.obric.memorydata.plugin");
            r8.c(r1.b());
            RuntimeLogger.f14958a.a("SQLiteDatabaseManager", "execSQL " + r1.b());
            goto L8
        L10:
            RuntimeLogger.f14958a.b("SQLiteDatabaseManager", "SQLite database[" + this.f14971a + "] create " + this.f14972b.size() + " tables!");
        }
    }

    static {
        f14969a = new C0800a(null);
        SQLiteFts5Extension.f14967a.a();
    }

    public a(Context r13, String r14, int r15, List<? extends com.obric.search.storage.sqlite.a.b.a> r16, String r17, com.obric.search.api.a.b r18, e r19, String r20) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r13, Context.class, "com.obric.memorydata.plugin");
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r16, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r14, "databaseName");
        Intrinsics.checkNotNullParameter(r5, "schemaList");
        if (r20 == null) goto L5;
        String r7 = r20 + File.separator + r14;
    L7:
        if (r17 == null) goto L9;
        byte[] r1 = r17.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(r1, "this as java.lang.String).getBytes(charset)");
        byte[] r8 = r1;
    L10:
        if (r18 == null) goto L12;
        SQLiteCipherSpec r9 = r18.a();
    L13:
        this.f14970b = (h) ZeusTransformUtils.preCheckCast(new b(r3, r15, r14, r5, r19, r7, r8, r9), h.class, "com.obric.memorydata.plugin");
        this.c = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(new SQLiteDatabaseManager$database$2(this), Function0.class, "com.obric.memorydata.plugin"));
        return;
    L12:
        r9 = null;
        goto L13
    L9:
        r8 = null;
        goto L10
    L5:
        r7 = r14;
        goto L7
    }

    public /* synthetic */ a(Context r13, String r14, int r15, List r16, String r17, com.obric.search.api.a.b r18, e r19, String r20, int r21, DefaultConstructorMarker r22) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r13, Context.class, "com.obric.memorydata.plugin");
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r16, List.class, "com.obric.memorydata.plugin");
        if ((r21 & 16) == 0) goto L5;
        String r8 = null;
    L7:
        if ((r21 & 32) == 0) goto L9;
        com.obric.search.api.a.b r9 = null;
    L11:
        if ((r21 & 64) == 0) goto L13;
        e r10 = null;
    L15:
        if ((r21 & 128) == 0) goto L17;
        String r11 = null;
    L18:
        this(r4, r14, r15, r7, r8, r9, r10, r11);
        return;
    L17:
        r11 = r20;
        goto L18
    L13:
        r10 = r19;
        goto L15
    L9:
        r9 = r18;
        goto L11
    L5:
        r8 = r17;
        goto L7
    }

    public static final /* synthetic */ h a(a r0) {
        return r0.f14970b;
    }

    public final SQLiteDatabase a() {
        Object r2 = this.c.getValue();
        Intrinsics.checkNotNullExpressionValue(r2, "<get-database>(...)");
        return (SQLiteDatabase) ZeusTransformUtils.preCheckCast(r2, SQLiteDatabase.class, "com.obric.memorydata.plugin");
    }
}
