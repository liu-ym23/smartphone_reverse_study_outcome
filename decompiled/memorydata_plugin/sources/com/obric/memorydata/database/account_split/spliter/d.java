package com.obric.memorydata.database.account_split.spliter;

import android.database.Cursor;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.obric.memorydata.database.entity.MemoryKeyInfoEntity;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.database.manager.PersonalMemoryFrameDb;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.utils.q;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005J\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005J!\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\b¢\u0006\u0002\u0010\u0010J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0005J\u000e\u0010\u0014\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\n¨\u0006\u0015"}, d2 = {"Lcom/obric/memorydata/database/account_split/spliter/PersonalDbSplitSqlHelper;", "", "<init>", "()V", "quoteIdentifier", "", MemoryKeyInfoEntity.KEY_IDENTIFIER, "loadPrimaryKeyColumns", "", "db", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "tableName", "rowIdArgs", "", "rowIds", "", "(Ljava/util/List;)[Ljava/lang/Object;", "isPersonalDbReadyForCurrentProfile", "", "logTag", "hasSqliteSequenceTable", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f8821a = null;

    static {
        f8821a = new d();
    }

    private d() {
    }

    public final String a(String r8) {
        Intrinsics.checkNotNullParameter(r8, MemoryKeyInfoEntity.KEY_IDENTIFIER);
        return '`' + StringsKt.replace$default(r8, "`", "``", false, 4, null) + '`';
    }

    public final boolean a(SupportSQLiteDatabase r2) {
        SupportSQLiteDatabase r1 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r2, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "db");
        Closeable r3 = (Closeable) ZeusTransformUtils.preCheckCast(r1.query("SELECT 1 FROM sqlite_master WHERE type = 'table' AND name = 'sqlite_sequence' LIMIT 1"), Closeable.class, "com.obric.memorydata.plugin");
        boolean r4 = ((Cursor) ZeusTransformUtils.preCheckCast(r3, Cursor.class, "com.obric.memorydata.plugin")).moveToFirst();     // Catch: Throwable -> L6
        CloseableKt.closeFinally(r3, null);
        return r4;
    L6:
        th = move-exception;
        throw th;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        CloseableKt.closeFinally(r3, th);
        throw th;
    }

    public final Object[] a(List<Long> r4) {
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "rowIds");
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.memorydata.plugin");
        Collection r6 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r7 = r5.iterator();
    L4:
        if (r7.hasNext() == false) goto L7;
        r6.add(ZeusTransformUtils.preCheckCast(Long.valueOf(((Number) ZeusTransformUtils.preCheckCast(r7.next(), Number.class, "com.obric.memorydata.plugin")).longValue()), Object.class, "com.obric.memorydata.plugin"));
        goto L4
    L7:
        return ((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r6, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin")).toArray(new Object[0]);
    }

    public final boolean b(String r10) {
        Intrinsics.checkNotNullParameter(r10, "logTag");
        PersonalMemoryFrameDb r9 = MemoryDbEngine.INSTANCE.getPersonalDbEngine();
        String r0 = com.obric.memorydata.middleware.database.b.f11646a.c(MemoryDbEngine.USER_LOGIC_DB_NAME);
        String r11 = r9.getOpenHelper().getDatabaseName();
        if (r11 != null) goto L5;
        r11 = "";
    L5:
        boolean r1 = Intrinsics.areEqual(r11, r0);
        if (r1 == true) goto L8;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), r10, "personal db mismatch, expected=" + q.f13259a.b(r0) + ", actual=" + q.f13259a.b(r11), null, 4, null);
    L8:
        return r1;
    }
}
