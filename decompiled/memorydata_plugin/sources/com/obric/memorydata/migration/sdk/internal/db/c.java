package com.obric.memorydata.migration.sdk.internal.db;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.google.gson.Gson;
import com.obric.memorydata.middleware.api.DatabaseKeyMigration;
import com.obric.memorydata.migration.sdk.ai;
import com.obric.memorydata.migration.sdk.t;
import com.obric.security.secretdata.SecretDataManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J&\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0002J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u0018H\u0002J\u001e\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00180\u001d2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u0018H\u0002J\u0016\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00180\u001d2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u001e\u0010\u001f\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/obric/memorydata/migration/sdk/internal/db/DbSnapshotExporter;", "", "fileUriMapper", "Lcom/obric/memorydata/migration/sdk/internal/file/FileUriMapper;", "gson", "Lcom/google/gson/Gson;", "<init>", "(Lcom/obric/memorydata/migration/sdk/internal/file/FileUriMapper;Lcom/google/gson/Gson;)V", "export", "", "context", "Landroid/content/Context;", "backupConfig", "Lcom/obric/memorydata/migration/sdk/BackupConfig;", "backupRootDir", "Ljava/io/File;", "checkpointDb", "dbConfig", "Lcom/obric/memorydata/migration/sdk/DbConfig;", "applyExportSqlFilters", "db", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "keepTables", "", "", "countRows", "", "table", "columns", "", "listUserTables", "clearAllTablesExcept", "migration_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.obric.memorydata.migration.sdk.internal.file.b f11921a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Gson f11922b;

    public c(com.obric.memorydata.migration.sdk.internal.file.b r3, Gson r4) {
        com.obric.memorydata.migration.sdk.internal.file.b r5 = (com.obric.memorydata.migration.sdk.internal.file.b) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.memorydata.migration.sdk.internal.file.b.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "fileUriMapper");
        Intrinsics.checkNotNullParameter(r4, "gson");
        this.f11921a = r5;
        this.f11922b = r4;
    }

    public /* synthetic */ c(com.obric.memorydata.migration.sdk.internal.file.b r2, Gson r3, int r4, DefaultConstructorMarker r5) {
        com.obric.memorydata.migration.sdk.internal.file.b r6 = (com.obric.memorydata.migration.sdk.internal.file.b) ZeusTransformUtils.wrapperContextForParams(r2, com.obric.memorydata.migration.sdk.internal.file.b.class, "com.obric.memorydata.plugin");
        if ((r4 & 2) == 0) goto L5;
        r3 = new Gson();
    L5:
        this(r6, r3);
    }

    private final long a(SupportSQLiteDatabase r7, String r8) {
        SupportSQLiteDatabase r9 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r7, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L17
        c r6 = (c) ZeusTransformUtils.preCheckCast(this, c.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L17
        Closeable r10 = (Closeable) ZeusTransformUtils.preCheckCast(r9.query("SELECT COUNT(1) FROM `" + r8 + '`'), Closeable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L17
        Cursor r11 = (Cursor) ZeusTransformUtils.preCheckCast(r10, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L12
        if (r11.moveToFirst() == false) goto L9;
        long r4 = r11.getLong(0);     // Catch: Throwable -> L12
    L10:
        CloseableKt.closeFinally(r10, null);     // Catch: Throwable -> L17
        Object r12 = Result.m1421constructorimpl(Long.valueOf(r4));     // Catch: Throwable -> L17
    L20:
        if (Result.m1427isFailureimpl(r12) == false) goto L23;
        r12 = -1L;
    L23:
        return ((Number) ZeusTransformUtils.preCheckCast(r12, Number.class, "com.obric.memorydata.plugin")).longValue();
    L9:
        r4 = -1;
    L12:
        th = move-exception;
        throw th;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        CloseableKt.closeFinally(r10, th);     // Catch: Throwable -> L17
        throw th;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r12 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L20
    }

    private static final CharSequence a(String r2) {
        return (CharSequence) ZeusTransformUtils.preCheckCast('`' + r2 + '`', CharSequence.class, "com.obric.memorydata.plugin");
    }

    private static final CharSequence a(Pair r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        return (CharSequence) ZeusTransformUtils.preCheckCast(r2.getFirst(), CharSequence.class, "com.obric.memorydata.plugin");
    }

    private final List<String> a(SupportSQLiteDatabase r8) {
        SupportSQLiteDatabase r7 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r8, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        List r9 = CollectionsKt.createListBuilder();
        Closeable r10 = (Closeable) ZeusTransformUtils.preCheckCast(r7.query("SELECT name FROM sqlite_master WHERE type='table'"), Closeable.class, "com.obric.memorydata.plugin");
        Cursor r0 = (Cursor) ZeusTransformUtils.preCheckCast(r10, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L20
        int r1 = r0.getColumnIndex(ActivityLifecycle.NAME);     // Catch: Throwable -> L20
    L5:
        if (r0.moveToNext() == false) goto L17;
        String r2 = r0.getString(r1);     // Catch: Throwable -> L20
        if (r2 == null) goto L5;
        if (StringsKt.startsWith$default(r2, "sqlite_", false, 2, null) == true) goto L5;
        if (Intrinsics.areEqual(r2, "android_metadata") == true) goto L5;
        if (Intrinsics.areEqual(r2, "room_master_table") == true) goto L5;
        r9.add(r2);     // Catch: Throwable -> L20
        goto L5
    L17:
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L20
        CloseableKt.closeFinally(r10, null);
        return CollectionsKt.build(r9);
    L20:
        th = move-exception;
        throw th;     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        CloseableKt.closeFinally(r10, th);
        throw th;
    }

    private static final Pair a(ai r7) {
        Intrinsics.checkNotNullParameter(r7, "cfg");
        String r0 = r7.b();
        if (r0 == null) goto L15;
        String r1 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (r1 == null) goto L16;
        String r2 = StringsKt.trimEnd(r1, new char[]{';'});
        if (r2 != null) goto L9;
        return null;
    L9:
        if ((true ^ StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L12;
        r2 = null;
    L12:
        if (r2 != null) goto L14;
        return null;
    L14:
        return TuplesKt.to(r7.a(), r2);
    L16:
        return null;
    L15:
        return null;
    }

    private final void a(SupportSQLiteDatabase r29, com.obric.memorydata.migration.sdk.g r30, Set<String> r31) {
        SupportSQLiteDatabase r5 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r29, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        final Set r0 = (Set) ZeusTransformUtils.wrapperContextForParams(r31, Set.class, "com.obric.memorydata.plugin");
        List r6 = SequencesKt.toList(SequencesKt.mapNotNull(SequencesKt.filter(CollectionsKt.asSequence((Iterable) ZeusTransformUtils.preCheckCast(r30.c(), Iterable.class, "com.obric.memorydata.plugin")), new $$Lambda$c$uQmPyxaX2Iu8ykzV4T7cJRXkzsc(r0)), $$Lambda$c$NJYJkzbmSgNskh62dg_5xYD1fXg.INSTANCE));
        if (r6.isEmpty() == false) goto L5;
        return;
    L5:
        Object r18 = ",";
        t.f11981a.a("backup: apply exportSQL row filter, db=" + r30.a() + ", tables=" + CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, $$Lambda$c$k6wvfmMOfyNk0MPflE60ZN_SgXM.INSTANCE, 30, null));
        boolean r7 = a.a(r5);
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L8
        r5.execSQL("PRAGMA foreign_keys=OFF");     // Catch: Throwable -> L8
        Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L11:
        if (a.a(r5) == false) goto L123;
        t.f11981a.a("sqlite pragma foreign_keys=OFF not applied (maybe inside a transaction)");
    L123:
        r5.beginTransaction();     // Catch: Throwable -> L93
        Iterator r8 = ((Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L90
    L16:
        if (r8.hasNext() == false) goto L82;
        Pair r2 = (Pair) ZeusTransformUtils.preCheckCast(r8.next(), Pair.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L90
        String r9 = (String) ZeusTransformUtils.preCheckCast(r2.component1(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L90
        String r3 = (String) ZeusTransformUtils.preCheckCast(r2.component2(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L90
        if (StringsKt.startsWith(StringsKt.trimStart((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin")).toString(), "select", true) == false) goto L79;
        long r10 = a(r5, r9);     // Catch: Throwable -> L90
        String r11 = "__migration_export_" + System.nanoTime();     // Catch: Throwable -> L90
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L22
        c r13 = (c) ZeusTransformUtils.preCheckCast(this, c.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L22
        r5.execSQL("CREATE TEMP TABLE `" + r11 + "` AS " + r3);     // Catch: Throwable -> L22
        Object r4 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L22
    L25:
        if (Result.m1427isFailureimpl(r4) == false) goto L31;
        t.f11981a.a("backup: exportSQL filter create-temp failed, table=" + r9);     // Catch: Throwable -> L90
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L29
        c r15 = (c) ZeusTransformUtils.preCheckCast(this, c.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L29
        r5.execSQL("DROP TABLE IF EXISTS `" + r11 + '`');     // Catch: Throwable -> L29
        Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L90
        Result.m1421constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L90
        goto L79
    L31:
        Iterable r17 = (Iterable) ZeusTransformUtils.preCheckCast(b(r5, r9), Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L90
        Map r19 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r17, 10)), 16)), Map.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L90
        Iterator r20 = r17.iterator();     // Catch: Throwable -> L90
    L34:
        if (r20.hasNext() == false) goto L113;
        Object r110 = r20.next();     // Catch: Throwable -> L90
        Iterator r32 = r20;
        String r21 = ((String) ZeusTransformUtils.preCheckCast(r110, String.class, "com.obric.memorydata.plugin")).toLowerCase(Locale.ROOT);     // Catch: Throwable -> L90
        Intrinsics.checkNotNullExpressionValue(r21, "toLowerCase(...)");     // Catch: Throwable -> L90
        r19.put(r21, r110);     // Catch: Throwable -> L90
        r20 = r32;
        goto L34
    L113:
        Result.Companion r22 = Result.Companion;     // Catch: Throwable -> L49
        c r23 = (c) ZeusTransformUtils.preCheckCast(this, c.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L49
        Closeable r111 = (Closeable) ZeusTransformUtils.preCheckCast(r5.query("SELECT * FROM `" + r11 + "` LIMIT 0"), Closeable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L49
        String[] r112 = ((Cursor) ZeusTransformUtils.preCheckCast(r111, Cursor.class, "com.obric.memorydata.plugin")).getColumnNames();     // Catch: Throwable -> L42
        Intrinsics.checkNotNullExpressionValue(r112, "getColumnNames(...)");     // Catch: Throwable -> L42
        List r24 = ArraysKt.toList((Object[]) ZeusTransformUtils.preCheckCast(r112, Object[].class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L42
    L40:
        CloseableKt.closeFinally(r111, null);     // Catch: Throwable -> L49
        Object r25 = Result.m1421constructorimpl(r24);     // Catch: Throwable -> L49
    L51:
        List r113 = CollectionsKt.emptyList();     // Catch: Throwable -> L90
        if (Result.m1427isFailureimpl(r25) == false) goto L54;
        r25 = r113;
    L54:
        Iterable r26 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r25, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L90
        Collection r114 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L90
        Iterator r27 = r26.iterator();     // Catch: Throwable -> L90
    L56:
        if (r27.hasNext() == false) goto L61;
        Object r115 = r27.next();     // Catch: Throwable -> L90
        Iterator r33 = r27;
        String r28 = (String) ZeusTransformUtils.preCheckCast(r115, String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L90
        Intrinsics.checkNotNull(r28);     // Catch: Throwable -> L90
        Iterator r34 = r8;
        String r35 = r28.toLowerCase(Locale.ROOT);     // Catch: Throwable -> L90
        Intrinsics.checkNotNullExpressionValue(r35, "toLowerCase(...)");     // Catch: Throwable -> L90
        if (r19.containsKey(r35) == false) goto L60;
        r114.add(r115);     // Catch: Throwable -> L90
    L60:
        r27 = r33;
        r8 = r34;
        goto L56
    L61:
        Iterator r36 = r8;
        List r37 = (List) ZeusTransformUtils.preCheckCast(r114, List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L90
        if (r37.isEmpty() == false) goto L69;
        t.f11981a.a("backup: exportSQL filter no compatible cols, skip table=" + r9);     // Catch: Throwable -> L90
        Result.Companion r38 = Result.Companion;     // Catch: Throwable -> L67
        c r39 = (c) ZeusTransformUtils.preCheckCast(this, c.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L67
        r5.execSQL("DROP TABLE `" + r11 + '`');     // Catch: Throwable -> L67
        Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L67
    L80:
        Object r40 = r18;
    L81:
        r18 = r40;
        r8 = r36;
        goto L16
    L67:
        th = move-exception;
        Result.Companion r41 = Result.Companion;     // Catch: Throwable -> L90
        Result.m1421constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L90
        goto L80
    L69:
        r40 = r18;
        String r42 = CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r37, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(r40, CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, $$Lambda$c$tLHT7F7QXgmjZo_t1ihCwKvzAN4.INSTANCE, 30, null);     // Catch: Throwable -> L90
        Result.Companion r116 = Result.Companion;     // Catch: Throwable -> L72
        c r117 = (c) ZeusTransformUtils.preCheckCast(this, c.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L72
        r5.execSQL("DELETE FROM `" + r9 + '`');     // Catch: Throwable -> L72
        r5.execSQL("INSERT INTO `" + r9 + "` (" + r42 + ") SELECT " + r42 + " FROM `" + r11 + '`');     // Catch: Throwable -> L72
        Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L72
    L117:
        Result.Companion r43 = Result.Companion;     // Catch: Throwable -> L76
        c r44 = (c) ZeusTransformUtils.preCheckCast(this, c.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L76
        r5.execSQL("DROP TABLE `" + r11 + '`');     // Catch: Throwable -> L76
        Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L76
    L78:
        t.f11981a.a("backup: exportSQL filter done, table=" + r9 + " rows " + r10 + " -> " + a(r5, r9));     // Catch: Throwable -> L90
        goto L81
    L76:
        th = move-exception;
        Result.Companion r118 = Result.Companion;     // Catch: Throwable -> L90
        Result.m1421constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L90
        goto L78
    L72:
        th = move-exception;
        Result.Companion r119 = Result.Companion;     // Catch: Throwable -> L90
        Result.m1421constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L90
    L42:
        th = move-exception;
        throw th;     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        CloseableKt.closeFinally(r111, th);     // Catch: Throwable -> L49
        throw th;     // Catch: Throwable -> L49
    L49:
        th = move-exception;
        Result.Companion r120 = Result.Companion;     // Catch: Throwable -> L90
        r25 = Result.m1421constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L90
    L22:
        th = move-exception;
        Result.Companion r121 = Result.Companion;     // Catch: Throwable -> L90
        r4 = Result.m1421constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L90
    L79:
        r36 = r8;
        goto L80
    L82:
        r5.setTransactionSuccessful();     // Catch: Throwable -> L90
        r5.endTransaction();     // Catch: Throwable -> L93
        Unit r45 = Unit.INSTANCE;     // Catch: Throwable -> L93
        if (r7 == false) goto L134;
        Result.Companion r46 = Result.Companion;     // Catch: Throwable -> L87
        r5.execSQL("PRAGMA foreign_keys=ON");     // Catch: Throwable -> L87
        Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L87
        return;
    L87:
        th = move-exception;
        Result.Companion r47 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
        return;
    L134:
        return;
    L90:
        th = move-exception;
        r5.endTransaction();     // Catch: Throwable -> L93
        throw th;     // Catch: Throwable -> L93
    L93:
        th = move-exception;
        if (r7 == false) goto L136;
        Result.Companion r48 = Result.Companion;     // Catch: Throwable -> L98
        r5.execSQL("PRAGMA foreign_keys=ON");     // Catch: Throwable -> L98
        Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L98
        throw th;
    L98:
        th = move-exception;
        Result.Companion r49 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
        throw th;
    L136:
        throw th;
    L8:
        th = move-exception;
        Result.Companion r50 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    private final void a(SupportSQLiteDatabase r11, Set<String> r12) {
        SupportSQLiteDatabase r13 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r11, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        Set r14 = (Set) ZeusTransformUtils.wrapperContextForParams(r12, Set.class, "com.obric.memorydata.plugin");
        boolean r2 = a.a(r13);
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L5
        r13.execSQL("PRAGMA foreign_keys=OFF");     // Catch: Throwable -> L5
        Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L8:
        if (a.a(r13) == false) goto L47;
        t.f11981a.a("sqlite pragma foreign_keys=OFF not applied (maybe inside a transaction)");
    L47:
        r13.beginTransaction();     // Catch: Throwable -> L36
        List<String> r5 = a(r13);     // Catch: Throwable -> L33
        List r6 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L33
        Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L33
    L13:
        if (r7.hasNext() == false) goto L25;
        String r8 = (String) ZeusTransformUtils.preCheckCast(r7.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L33
        if (r14.contains(r8) == true) goto L13;
        Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L18
        c r10 = (c) ZeusTransformUtils.preCheckCast(this, c.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L18
        r13.execSQL("DELETE FROM `" + r8 + '`');     // Catch: Throwable -> L18
        Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L18
    L48:
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L22
        c r16 = (c) ZeusTransformUtils.preCheckCast(this, c.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L22
        r13.execSQL("DELETE FROM sqlite_sequence WHERE name='" + r8 + '\'');     // Catch: Throwable -> L22
        Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L22
    L24:
        r6.add(r8);     // Catch: Throwable -> L33
        goto L13
    L22:
        th = move-exception;
        Result.Companion r17 = Result.Companion;     // Catch: Throwable -> L33
        Result.m1421constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L33
    L18:
        th = move-exception;
        Result.Companion r18 = Result.Companion;     // Catch: Throwable -> L33
        Result.m1421constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L33
        goto L48
    L25:
        r13.setTransactionSuccessful();     // Catch: Throwable -> L33
        t.f11981a.a("backup: clear non-keep tables done, totalTables=" + r5.size() + ", kept=" + r14.size() + ", clearedCount=" + r6.size());     // Catch: Throwable -> L33
        r13.endTransaction();     // Catch: Throwable -> L36
        Unit r19 = Unit.INSTANCE;     // Catch: Throwable -> L36
        if (r2 == false) goto L60;
        Result.Companion r110 = Result.Companion;     // Catch: Throwable -> L30
        r13.execSQL("PRAGMA foreign_keys=ON");     // Catch: Throwable -> L30
        Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L30
        return;
    L30:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
        return;
    L60:
        return;
    L33:
        th = move-exception;
        r13.endTransaction();     // Catch: Throwable -> L36
        throw th;     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        if (r2 == true) goto L54;
    L42:
        throw th;
    L54:
        Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L40
        r13.execSQL("PRAGMA foreign_keys=ON");     // Catch: Throwable -> L40
        Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L40
    L40:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
    L5:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    private final void a(com.obric.memorydata.migration.sdk.g r6) {
        Pair<RoomDatabase, SupportSQLiteDatabase> r7 = a.c(r6);
        RoomDatabase r1 = (RoomDatabase) ZeusTransformUtils.preCheckCast(r7.component1(), RoomDatabase.class, "com.obric.memorydata.plugin");
        SupportSQLiteDatabase r8 = (SupportSQLiteDatabase) ZeusTransformUtils.preCheckCast(r7.component2(), SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        Unit r2 = null;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L5
        c r5 = (c) ZeusTransformUtils.preCheckCast(this, c.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L5
        r8.execSQL("PRAGMA wal_checkpoint(FULL)");     // Catch: Throwable -> L5
        Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L24:
        Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L12
        c r10 = (c) ZeusTransformUtils.preCheckCast(this, c.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L12
        if (r1 == null) goto L10;
        r1.close();     // Catch: Throwable -> L12
        r2 = Unit.INSTANCE;     // Catch: Throwable -> L12
    L10:
        Result.m1421constructorimpl(r2);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
        return;
    L5:
        th = move-exception;
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L15
        Result.m1421constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L21
        if (r1 == null) goto L19;
        r1.close();     // Catch: Throwable -> L21
        r2 = Unit.INSTANCE;     // Catch: Throwable -> L21
    L19:
        Result.m1421constructorimpl(r2);     // Catch: Throwable -> L21
    L23:
        throw th;
    L21:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L23
    }

    private static final boolean a(Set r3, ai r4) {
        Set r5 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "it");
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r4.a(), CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L5;
    L7:
        return false;
    L5:
        if (r5.contains(r4.a()) == false) goto L7;
        return true;
    }

    private final List<String> b(SupportSQLiteDatabase r4, String r5) {
        SupportSQLiteDatabase r3 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        List r6 = CollectionsKt.createListBuilder();
        Closeable r7 = (Closeable) ZeusTransformUtils.preCheckCast(r3.query("PRAGMA table_info(`" + r5 + "`)"), Closeable.class, "com.obric.memorydata.plugin");
        Cursor r8 = (Cursor) ZeusTransformUtils.preCheckCast(r7, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        int r0 = r8.getColumnIndex(ActivityLifecycle.NAME);     // Catch: Throwable -> L10
    L5:
        if (r8.moveToNext() == false) goto L7;
        String r1 = r8.getString(r0);     // Catch: Throwable -> L10
        Intrinsics.checkNotNullExpressionValue(r1, "getString(...)");     // Catch: Throwable -> L10
        r6.add(r1);     // Catch: Throwable -> L10
        goto L5
    L7:
        Unit r9 = Unit.INSTANCE;     // Catch: Throwable -> L10
        CloseableKt.closeFinally(r7, null);
        return CollectionsKt.build(r6);
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        CloseableKt.closeFinally(r7, th);
        throw th;
    }

    public static /* synthetic */ Pair lambda$NJYJkzbmSgNskh62dg_5xYD1fXg(ai r0) {
        return a(r0);
    }

    public static /* synthetic */ CharSequence lambda$k6wvfmMOfyNk0MPflE60ZN_SgXM(Pair r0) {
        return a(r0);
    }

    public static /* synthetic */ CharSequence lambda$tLHT7F7QXgmjZo_t1ihCwKvzAN4(String r0) {
        return a(r0);
    }

    public static /* synthetic */ boolean lambda$uQmPyxaX2Iu8ykzV4T7cJRXkzsc(Set r0, ai r1) {
        return a(r0, r1);
    }

    public final void a(Context r33, com.obric.memorydata.migration.sdk.b r34, File r35) {
        File r9 = r35;
        String r10 = ",";
        Class<c> r11 = c.class;
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r33, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r13, "context");
        Intrinsics.checkNotNullParameter(r34, "backupConfig");
        Intrinsics.checkNotNullParameter(r9, "backupRootDir");
        LinkedHashMap r15 = new LinkedHashMap();
        LinkedHashMap r8 = new LinkedHashMap();
        LinkedHashMap r7 = new LinkedHashMap();
        t.f11981a.a("backup: export begin, dbCount=" + r34.a().size() + ", extraFiles=" + r34.b().size() + ", rootDir=" + r35.getAbsolutePath());
        Iterator r16 = ((Iterable) ZeusTransformUtils.preCheckCast(r34.a(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        int r0 = 0;
    L4:
        if (r16.hasNext() == false) goto L62;
        Object r2 = r16.next();
        int r6 = r0 + 1;
        if (r0 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        com.obric.memorydata.migration.sdk.g r4 = (com.obric.memorydata.migration.sdk.g) ZeusTransformUtils.preCheckCast(r2, com.obric.memorydata.migration.sdk.g.class, "com.obric.memorydata.plugin");
        String r5 = r4.a();
        String r3 = a.a(r4);
        String r12 = a.a(r5);
        t.f11981a.a("backup: ======== db[" + r6 + '/' + r34.a().size() + "] " + r5 + " (" + r4.b() + ") ========");
        t.f11981a.a("backup: begin, role=" + r4.b() + ", logical=" + r5 + ", physical=" + r3 + ", temp=" + r12 + ", requestedTableCount=" + r4.c().size());
        String r1 = com.obric.memorydata.middleware.database.d.f11652a.c(r3);
        ((Map) ZeusTransformUtils.preCheckCast(r15, Map.class, "com.obric.memorydata.plugin")).put(r12, r1);
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L11
        c r17 = (c) ZeusTransformUtils.preCheckCast(this, r11, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        DatabaseKeyMigration.INSTANCE.writeDatabasePhrase(r12, r1);     // Catch: Throwable -> L11
        Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L11
    L13:
        a(r4);
        a.a(r13, r3, r12);
        LinkedHashMap r18 = r7;
        t.f11981a.a(new StringBuilder().append("backup: db=").append(r5).append(" checkpoint+copy done, physical=").append(r3).append(" -> temp=").append(r12).append(", tempSize=").append(r13.getDatabasePath(r12).length()).append('B').toString());
        RoomDatabase r19 = a.a(r4, r12);
        SupportSQLiteDatabase r20 = r19.getOpenHelper().getWritableDatabase();     // Catch: Throwable -> L55
        Iterable r21 = (Iterable) ZeusTransformUtils.preCheckCast(r4.c(), Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L55
        Collection r22 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r21, 10)), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L55
        Iterator r23 = r21.iterator();     // Catch: Throwable -> L55
    L16:
        if (r23.hasNext() == false) goto L18;
        r22.add(((ai) ZeusTransformUtils.preCheckCast(r23.next(), ai.class, "com.obric.memorydata.plugin")).a());     // Catch: Throwable -> L55
        r23 = r23;
        goto L16
    L18:
        Iterable r24 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r22, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L55
        Collection r25 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L55
        Iterator r26 = r24.iterator();     // Catch: Throwable -> L55
    L20:
        if (r26.hasNext() == false) goto L25;
        Object r27 = r26.next();     // Catch: Throwable -> L55
        Iterator r110 = r26;
        String r28 = r12;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r27, String.class, "com.obric.memorydata.plugin"), CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L24;
        r25.add(r27);     // Catch: Throwable -> L55
    L24:
        r26 = r110;
        r12 = r28;
        goto L20
    L25:
        String r29 = r12;
        List r30 = (List) ZeusTransformUtils.preCheckCast(r25, List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L55
        Set<String> r31 = a.a(r20, r30);     // Catch: Throwable -> L55
        Set r32 = CollectionsKt.toSet((Iterable) ZeusTransformUtils.preCheckCast(a(r20), Iterable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L55
        LinkedHashMap r111 = r15;
        Collection r36 = (Collection) ZeusTransformUtils.preCheckCast(CollectionsKt.intersect((Iterable) ZeusTransformUtils.preCheckCast(r31, Iterable.class, "com.obric.memorydata.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(r32, Iterable.class, "com.obric.memorydata.plugin")), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L55
        if (r36.isEmpty() == true) goto L28;
    L31:
        Set<String> r37 = (Set) ZeusTransformUtils.preCheckCast(r36, Set.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L55
        Class<c> r210 = r11;
        t.f11981a.a("backup: db=" + r5 + " keepTables resolved, \nrequestedCount=" + r30.size() + " requested=" + CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.sorted((Iterable) ZeusTransformUtils.preCheckCast(r30, Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null) + ", \nkeepTablesCount=" + r31.size() + " keepTables=" + CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.sorted((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r31, Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null) + ", \nexistingInTemp=" + r32.size() + ", keepExistingCount=" + r37.size() + " keepExisting=" + CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.sorted((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r37, Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null));     // Catch: Throwable -> L55
        a(r20, r4, r37);     // Catch: Throwable -> L55
        a(r20, r37);     // Catch: Throwable -> L55
        String r211 = r10;
        LinkedHashMap r112 = r8;
        a.a(r13, r20, r4, r35, this.f11921a, (Map) ZeusTransformUtils.preCheckCast(r8, Map.class, "com.obric.memorydata.plugin"), (Map) ZeusTransformUtils.preCheckCast(r18, Map.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L55
        Result.Companion r38 = Result.Companion;     // Catch: Throwable -> L38
        Class<c> r39 = r210;
        c r40 = (c) ZeusTransformUtils.preCheckCast(this, r39, "com.obric.memorydata.plugin");     // Catch: Throwable -> L36
        r20.execSQL("PRAGMA wal_checkpoint(FULL)");     // Catch: Throwable -> L36
        Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L36
    L91:
        Result.Companion r41 = Result.Companion;     // Catch: Throwable -> L43
        c r42 = (c) ZeusTransformUtils.preCheckCast(this, r39, "com.obric.memorydata.plugin");     // Catch: Throwable -> L43
        r19.close();     // Catch: Throwable -> L43
        Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L43
    L45:
        File r43 = new File(r35, "dbs/" + r29);
        r43.mkdirs();
        a.a(r13, r29, r43);
        a.a(r13, r29);
        Result.Companion r44 = Result.Companion;     // Catch: Throwable -> L48
        c r45 = (c) ZeusTransformUtils.preCheckCast(this, r39, "com.obric.memorydata.plugin");     // Catch: Throwable -> L48
        Result.m1421constructorimpl(Integer.valueOf(SecretDataManager.getInstance().deleteData((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r13.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r29, new Bundle())));     // Catch: Throwable -> L48
    L50:
        t r46 = t.f11981a;
        StringBuilder r47 = new StringBuilder().append("backup: db=").append(r5).append(" snapshot written, dir=").append(r43.getAbsolutePath()).append(", snapshotFileCount=");
        File[] r48 = r43.listFiles();
        if (r48 == null) goto L53;
        int r49 = r48.length;
    L54:
        r46.a(r47.append(r49).toString());
        r11 = r39;
        r9 = r35;
        r8 = r112;
        r15 = r111;
        r7 = r18;
        r0 = r6;
        r10 = r211;
        goto L4
    L53:
        r49 = 0;
    L48:
        th = move-exception;
        Result.Companion r50 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
    L43:
        th = move-exception;
        Result.Companion r51 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
    L36:
        th = th;
    L40:
        Result.Companion r52 = Result.Companion;     // Catch: Throwable -> L55
        Result.m1421constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L55
    L38:
        th = th;
        r39 = r210;
        goto L40
    L28:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r30, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L30;
        t.f11981a.a("backup: none of requested tables exist, fallback keep all tables");     // Catch: Throwable -> L55
    L30:
        r36 = r32;
    L55:
        th = move-exception;
        Result.Companion r53 = Result.Companion;     // Catch: Throwable -> L59
        r19.close();     // Catch: Throwable -> L59
        Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L59
        throw th;
    L59:
        th = move-exception;
        Result.Companion r54 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
        throw th;
    L11:
        th = move-exception;
        Result.Companion r55 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L13
    L62:
        LinkedHashMap r212 = r7;
        LinkedHashMap r113 = r8;
        File r56 = r9;
        LinkedHashMap r114 = r15;
        if ((!((Map) ZeusTransformUtils.preCheckCast(r114, Map.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L66;
        File r57 = new File(r56, "db_passphrases.json");
        String r58 = this.f11922b.toJson(r114);
        Intrinsics.checkNotNullExpressionValue(r58, "toJson(...)");
        FilesKt.writeText$default(r57, r58, null, 2, null);
    L66:
        if ((!((Map) ZeusTransformUtils.preCheckCast(r113, Map.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L69;
        File r59 = new File(r56, "path_mapping.json");
        String r60 = this.f11922b.toJson(r113);
        Intrinsics.checkNotNullExpressionValue(r60, "toJson(...)");
        FilesKt.writeText$default(r59, r60, null, 2, null);
    L69:
        if ((!((Map) ZeusTransformUtils.preCheckCast(r212, Map.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L79;
        Map r61 = (Map) ZeusTransformUtils.preCheckCast(r212, Map.class, "com.obric.memorydata.plugin");
        Map r62 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(MapsKt.mapCapacity(r61.size())), Map.class, "com.obric.memorydata.plugin");
        Iterator r63 = ((Iterable) ZeusTransformUtils.preCheckCast(r61.entrySet(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L72:
        if (r63.hasNext() == false) goto L78;
        Object r64 = r63.next();
        Object r115 = ((Map.Entry) ZeusTransformUtils.preCheckCast(r64, Map.Entry.class, "com.obric.memorydata.plugin")).getKey();
        Map r65 = (Map) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r64, Map.Entry.class, "com.obric.memorydata.plugin")).getValue(), Map.class, "com.obric.memorydata.plugin");
        Map r116 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(MapsKt.mapCapacity(r65.size())), Map.class, "com.obric.memorydata.plugin");
        Iterator r66 = ((Iterable) ZeusTransformUtils.preCheckCast(r65.entrySet(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L75:
        if (r66.hasNext() == false) goto L77;
        Object r117 = r66.next();
        r116.put(((Map.Entry) ZeusTransformUtils.preCheckCast(r117, Map.Entry.class, "com.obric.memorydata.plugin")).getKey(), CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast((Set) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r117, Map.Entry.class, "com.obric.memorydata.plugin")).getValue(), Set.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")));
        goto L75
    L77:
        r62.put(r115, r116);
        goto L72
    L78:
        File r67 = new File(r56, "public_media_columns.json");
        String r68 = this.f11922b.toJson(r62);
        Intrinsics.checkNotNullExpressionValue(r68, "toJson(...)");
        FilesKt.writeText$default(r67, r68, null, 2, null);
    L79:
        t.f11981a.a("backup: export end, passphrases=" + r114.size() + ", pathMapping=" + r113.size() + ", publicMediaColumnDbs=" + r212.size());
    }
}
