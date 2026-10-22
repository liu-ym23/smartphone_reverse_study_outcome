package com.bytedance.applog.priority.original;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\r¢\u0006\u0002\u0010\u000eJ\u0012\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\"\u0010\u001f\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010 \u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u000bH\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\r¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006\""}, d2 = {"Lcom/bytedance/applog/priority/original/SqliteDbHelper;", "Landroid/database/sqlite/SQLiteOpenHelper;", "logger", "Lcom/bytedance/applog/log/AbsLogger;", "context", "Landroid/content/Context;", ActivityLifecycle.NAME, "", "factory", "Landroid/database/sqlite/SQLiteDatabase$CursorFactory;", "version", "", "createTableSql", "", "(Lcom/bytedance/applog/log/AbsLogger;Landroid/content/Context;Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase$CursorFactory;ILjava/util/List;)V", "getContext", "()Landroid/content/Context;", "getCreateTableSql", "()Ljava/util/List;", "getFactory", "()Landroid/database/sqlite/SQLiteDatabase$CursorFactory;", "getLogger", "()Lcom/bytedance/applog/log/AbsLogger;", "getName", "()Ljava/lang/String;", "getVersion", "()I", "onCreate", "", "db", "Landroid/database/sqlite/SQLiteDatabase;", "onUpgrade", "oldVersion", "newVersion", "priority_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class s extends SQLiteOpenHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.bytedance.applog.log.a f1853a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f1854b;
    private final String c;
    private final SQLiteDatabase.CursorFactory d;
    private final int e;
    private final List<String> f;

    public s(com.bytedance.applog.log.a r3, Context r4, String r5, SQLiteDatabase.CursorFactory r6, int r7, List<String> r8) {
        com.bytedance.applog.log.a r9 = (com.bytedance.applog.log.a) ZeusTransformUtils.wrapperContextForParams(r3, com.bytedance.applog.log.a.class, "com.obric.memorydata.plugin");
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        SQLiteDatabase.CursorFactory r11 = (SQLiteDatabase.CursorFactory) ZeusTransformUtils.wrapperContextForParams(r6, SQLiteDatabase.CursorFactory.class, "com.obric.memorydata.plugin");
        List<String> r12 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "logger");
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r5, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r12, "createTableSql");
        super(r10, r5, r11, r7);
        this.f1853a = r9;
        this.f1854b = ZeusTransformUtils.wrapperContext(r10, "com.obric.memorydata.plugin");
        this.c = r5;
        this.d = r11;
        this.e = r7;
        this.f = r12;
    }

    public final String a() {
        return this.c;
    }

    public final Context getContext() {
        return this.f1854b;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase r5) {
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(this.f, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L10
    L5:
        if (r1.hasNext() == false) goto L20;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r5 == null) goto L5;
        r5.execSQL(r2);     // Catch: Throwable -> L10
        goto L5
    L20:
        return;
    L10:
        th = move-exception;
        this.f1853a.a("SqliteDbHelper:onCreate", th, (Function0) ZeusTransformUtils.preCheckCast(new SqliteDbHelper$onCreate$2(this), Function0.class, "com.obric.memorydata.plugin"));
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase r1, int r2, int r3) {
    }
}
