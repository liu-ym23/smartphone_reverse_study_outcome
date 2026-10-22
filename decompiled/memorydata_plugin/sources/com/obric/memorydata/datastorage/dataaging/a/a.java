package com.obric.memorydata.datastorage.dataaging.a;

import android.database.Cursor;
import android.database.sqlite.SQLiteQueryBuilder;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u0006\b\u0016\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0017\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J(\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0018\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000eH\u0016J&\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000eH\u0016J=\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000e2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u001a\u001a\u00020\u0013H\u0016¢\u0006\u0002\u0010\u001bR\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\b8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\b8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\n¨\u0006\u001d"}, d2 = {"Lcom/obric/memorydata/datastorage/dataaging/wrapper/RoomDatabaseWrapper;", "Lcom/obric/memorydata/datastorage/dataaging/wrapper/intf/IDatabaseWrapper;", "openHelperProvider", "Lkotlin/Function0;", "Landroidx/sqlite/db/SupportSQLiteOpenHelper;", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "readableDatabase", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "getReadableDatabase", "()Landroidx/sqlite/db/SupportSQLiteDatabase;", "writableDatabase", "getWritableDatabase", "getNthElementPrimaryKeySortedByAutoIncrementPrimaryKey", "", "tableName", "autoIncrementPrimaryKeyName", "whereClause", "n", "", "deleteRowsByCondition", "queryPrimaryKeyValuesByCondition", "", "", "primaryKey", "afterPrimaryKey", "limit", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;I)Ljava/util/List;", "Companion", "app_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public class a implements com.obric.memorydata.datastorage.dataaging.a.a.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0463a f9698a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function0<SupportSQLiteOpenHelper> f9699b;

    /* JADX INFO: renamed from: com.obric.memorydata.datastorage.dataaging.a.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/datastorage/dataaging/wrapper/RoomDatabaseWrapper$Companion;", "", "<init>", "()V", "TAG", "", "app_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class C0463a {
        private C0463a() {
        }

        public /* synthetic */ C0463a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f9698a = new C0463a(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public a(Function0<? extends SupportSQLiteOpenHelper> r3) {
        Function0<SupportSQLiteOpenHelper> r4 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "openHelperProvider");
        this.f9699b = r4;
    }

    public /* synthetic */ a(Function0 r2, int r3, DefaultConstructorMarker r4) {
        Function0 r5 = (Function0) ZeusTransformUtils.wrapperContextForParams(r2, Function0.class, "com.obric.memorydata.plugin");
        if ((r3 & 1) == 0) goto L5;
        r5 = $$Lambda$a$qG8U4Kk8Ol8BgEUZx_S4930v74w.INSTANCE;
    L5:
        this(r5);
    }

    private static final SupportSQLiteOpenHelper c() {
        return MemoryDbEngine.INSTANCE.getGlobalDbEngine().getOpenHelper();
    }

    public static /* synthetic */ SupportSQLiteOpenHelper lambda$qG8U4Kk8Ol8BgEUZx_S4930v74w() {
        return c();
    }

    @Override // com.obric.memorydata.datastorage.dataaging.a.a.a
    public int a(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "tableName");
        Intrinsics.checkNotNullParameter(r3, "whereClause");
        return b().delete(r2, r3, new Object[0]);
    }

    public final SupportSQLiteDatabase a() {
        return ((SupportSQLiteOpenHelper) ZeusTransformUtils.preCheckCast(this.f9699b.invoke(), SupportSQLiteOpenHelper.class, "com.obric.memorydata.plugin")).getReadableDatabase();
    }

    @Override // com.obric.memorydata.datastorage.dataaging.a.a.a
    public String a(String r13, String r14, String r15, int r16) {
        Intrinsics.checkNotNullParameter(r13, "tableName");
        Intrinsics.checkNotNullParameter(r14, "autoIncrementPrimaryKeyName");
        Intrinsics.checkNotNullParameter(r15, "whereClause");
        String r10 = "";
        if (r16 > 0) goto L6;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "RoomDatabaseWrapper", "getNthElementPrimaryKeySortedByAutoIncrementPrimaryKey n <= 0", null, 4, null);
        return "";
    L6:
        String r0 = SQLiteQueryBuilder.buildQueryString(false, r13, new String[]{r14}, r15, "", "", r14 + " DESC", "1 OFFSET " + (r16 - 1));
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L22
        SupportSQLiteDatabase r3 = a();     // Catch: Throwable -> L22
        Intrinsics.checkNotNull(r0);     // Catch: Throwable -> L22
        Closeable r4 = (Closeable) ZeusTransformUtils.preCheckCast(r3.query(r0), Closeable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L22
        Cursor r1 = (Cursor) ZeusTransformUtils.preCheckCast(r4, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L15
        if (r1.moveToFirst() == false) goto L12;
        r10 = String.valueOf(r1.getLong(0));     // Catch: Throwable -> L15
    L12:
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L15
        CloseableKt.closeFinally(r4, null);     // Catch: Throwable -> L22
        Object r6 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L22
    L24:
        Throwable r7 = Result.m1424exceptionOrNullimpl(r6);
        if (r7 == null) goto L27;
        RunLog.INSTANCE.error("RoomDatabaseWrapper", "getNthElementPrimaryKeySortedByAutoIncrementPrimaryKey executeSqlQuery error.", r7);
    L27:
        return r10;
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        CloseableKt.closeFinally(r4, th);     // Catch: Throwable -> L22
        throw th;     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r6 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L24
    }

    @Override // com.obric.memorydata.datastorage.dataaging.a.a.a
    public List<Long> a(String r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "tableName");
        Intrinsics.checkNotNullParameter(r11, "primaryKey");
        Intrinsics.checkNotNullParameter(r12, "whereClause");
        String r13 = SQLiteQueryBuilder.buildQueryString(false, r10, new String[]{r11}, r12, "", "", r11 + " ASC", null);
        Set r14 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L17
        SupportSQLiteDatabase r9 = a();     // Catch: Throwable -> L17
        Intrinsics.checkNotNull(r13);     // Catch: Throwable -> L17
        Closeable r15 = (Closeable) ZeusTransformUtils.preCheckCast(r9.query(r13), Closeable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L17
        Cursor r1 = (Cursor) ZeusTransformUtils.preCheckCast(r15, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L12
    L7:
        if (r1.moveToNext() == false) goto L9;
        r14.add(Long.valueOf(r1.getLong(r1.getColumnIndexOrThrow(r11))));     // Catch: Throwable -> L12
        goto L7
    L9:
        Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L12
        CloseableKt.closeFinally(r15, null);     // Catch: Throwable -> L17
        Object r17 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L17
    L19:
        Throwable r18 = Result.m1424exceptionOrNullimpl(r17);
        if (r18 == null) goto L23;
        RunLog.INSTANCE.error("RoomDatabaseWrapper", "deleteRowsByCondition executeSqlQuery error.", r18);
    L23:
        return CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.memorydata.plugin"));
    L12:
        th = move-exception;
        throw th;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        CloseableKt.closeFinally(r15, th);     // Catch: Throwable -> L17
        throw th;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r17 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L19
    }

    @Override // com.obric.memorydata.datastorage.dataaging.a.a.a
    public List<Long> a(String r14, String r15, String r16, Long r17, int r18) {
        String r1 = r16;
        Intrinsics.checkNotNullParameter(r14, "tableName");
        Intrinsics.checkNotNullParameter(r15, "primaryKey");
        Intrinsics.checkNotNullParameter(r1, "whereClause");
        if (r18 > 0) goto L7;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "RoomDatabaseWrapper", "queryPrimaryKeyValuesByCondition limit <= 0", null, 4, null);
        return CollectionsKt.emptyList();
    L7:
        if (r17 != null) goto L10;
    L18:
        String r0 = SQLiteQueryBuilder.buildQueryString(false, r14, new String[]{r15}, r1, "", "", r15 + " ASC", String.valueOf(r18));
        List<Long> r2 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        SupportSQLiteDatabase r3 = a();
        Intrinsics.checkNotNull(r0);
        Closeable r4 = (Closeable) ZeusTransformUtils.preCheckCast(r3.query(r0), Closeable.class, "com.obric.memorydata.plugin");
        Cursor r5 = (Cursor) ZeusTransformUtils.preCheckCast(r4, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L26
    L21:
        if (r5.moveToNext() == false) goto L23;
        r2.add(Long.valueOf(r5.getLong(0)));     // Catch: Throwable -> L26
        goto L21
    L23:
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L26
        CloseableKt.closeFinally(r4, null);
        return r2;
    L26:
        th = move-exception;
        throw th;     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        CloseableKt.closeFinally(r4, th);
        throw th;
    L10:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L12;
        boolean r7 = true;
    L14:
        if (r7 == false) goto L16;
        StringBuilder r8 = new StringBuilder().append(r15).append(" > ").append(r17);
    L17:
        r1 = r8.toString();
        goto L18
    L16:
        r8 = new StringBuilder().append('(').append(r1).append(") AND (").append(r15).append(" > ").append(r17).append(')');
        goto L17
    L12:
        r7 = false;
        goto L14
    }

    public final SupportSQLiteDatabase b() {
        return ((SupportSQLiteOpenHelper) ZeusTransformUtils.preCheckCast(this.f9699b.invoke(), SupportSQLiteOpenHelper.class, "com.obric.memorydata.plugin")).getWritableDatabase();
    }
}
