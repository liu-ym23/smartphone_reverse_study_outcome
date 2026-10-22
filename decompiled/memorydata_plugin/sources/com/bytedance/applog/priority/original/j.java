package com.bytedance.applog.priority.original;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.crash.constants.Constants;
import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\"\u001a\u00020#H\u0016J\u0010\u0010$\u001a\u00020!2\u0006\u0010%\u001a\u00020!H\u0016J\u0016\u0010&\u001a\u00020#2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020)0(H\u0016J\b\u0010*\u001a\u00020#H\u0016J\u000e\u0010+\u001a\b\u0012\u0004\u0012\u00020!0,H\u0016Jd\u0010-\u001a*\u0012 \u0012\u001e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u0002000/j\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u000200`1\u0012\u0004\u0012\u0002020.2\u0006\u0010%\u001a\u00020!2\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u00020!2\u0006\u00106\u001a\u0002042\u0012\u00107\u001a\u000e\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020208H\u0016J\u001a\u00109\u001a\u0004\u0018\u00010)2\u0006\u0010:\u001a\u00020)2\u0006\u0010;\u001a\u00020\u0007H\u0016J\u0010\u0010<\u001a\u0002022\u0006\u0010%\u001a\u00020!H\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u0011\u0010\u0018\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u000e\u0010 \u001a\u00020!X\u0082D¢\u0006\u0002\n\u0000¨\u0006="}, d2 = {"Lcom/bytedance/applog/priority/original/EventDatabase;", "Lcom/bytedance/applog/priority/original/DatabaseInterface;", "logger", "Lcom/bytedance/applog/log/AbsLogger;", "context", "Landroid/content/Context;", "appId", "", "priorityName", "Lcom/bytedance/applog/priority/original/Model$PriorityName;", "(Lcom/bytedance/applog/log/AbsLogger;Landroid/content/Context;Ljava/lang/String;Lcom/bytedance/applog/priority/original/Model$PriorityName;)V", "getAppId", "()Ljava/lang/String;", "colEventJson", "colEventName", "colEventStained", "colEventType", "colGroupId", "colMonitorId", "colTimestamp", "getContext", "()Landroid/content/Context;", "createTableSql", "eventTableName", "helper", "Lcom/bytedance/applog/priority/original/SqliteDbHelper;", "getHelper", "()Lcom/bytedance/applog/priority/original/SqliteDbHelper;", "getLogger", "()Lcom/bytedance/applog/log/AbsLogger;", "getPriorityName", "()Lcom/bytedance/applog/priority/original/Model$PriorityName;", "sqliteDbVersion", "", "clear", "", CommonConsts.COUNT_TYPE, "groupId", "deleteAll", "keys", "", "Lcom/bytedance/applog/priority/original/Model$EventKey;", "destroy", "getAllGroupIds", "", "getBySizeAndCount", "Lkotlin/Pair;", "Ljava/util/HashMap;", "Lorg/json/JSONObject;", "Lkotlin/collections/HashMap;", "", "maxSize", "", "maxCount", "eventTtl", "filter", "Lkotlin/Function1;", "insert", "key", EventBody.KEY_VALUE, "isEmpty", "priority_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class j implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.bytedance.applog.log.a f1838a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f1839b;
    private final String c;
    private final Model.PriorityName d;
    private final int e;
    private final String f;
    private final String g;
    private final String h;
    private final String i;
    private final String j;
    private final String k;
    private final String l;
    private final String m;
    private final String n;
    private final s o;

    public j(com.bytedance.applog.log.a r12, Context r13, String r14, Model.PriorityName r15) {
        com.bytedance.applog.log.a r3 = (com.bytedance.applog.log.a) ZeusTransformUtils.wrapperContextForParams(r12, com.bytedance.applog.log.a.class, "com.obric.memorydata.plugin");
        Context r16 = (Context) ZeusTransformUtils.wrapperContextForParams(r13, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "logger");
        Intrinsics.checkNotNullParameter(r16, "context");
        Intrinsics.checkNotNullParameter(r14, "appId");
        Intrinsics.checkNotNullParameter(r15, "priorityName");
        this.f1838a = r3;
        Context r4 = ZeusTransformUtils.wrapperContext(r16, "com.obric.memorydata.plugin");
        this.f1839b = r4;
        this.c = r14;
        this.d = r15;
        this.e = 1;
        this.f = "event";
        this.g = "group_id";
        this.h = "monitor_id";
        this.i = Constants.EVENT_TYPE;
        this.j = "event_stained";
        this.k = "timestamp";
        this.l = "event_name";
        this.m = "event_json";
        String r17 = "CREATE TABLE IF NOT EXISTS event (\n        id integer primary key autoincrement, \n        group_id integer NOT NULL, \n        monitor_id varchar(32) NOT NULL, \n        " + Constants.EVENT_TYPE + " integer NOT NULL, \n        event_stained integer default 0, \n        timestamp integer NOT NULL, \n        event_name varchar(255) NOT NULL, \n        event_json TEXT NOT NULL \n        )";
        this.n = r17;
        this.o = new s(r3, r4, "applog_priority_db_" + r15.name() + '@' + r14, null, 1, CollectionsKt.listOf(r17));
    }

    public static final /* synthetic */ String a(j r0) {
        return r0.f;
    }

    @Override // com.bytedance.applog.priority.original.g
    public int a(final int r7) {
        Closeable r2 = (Closeable) ZeusTransformUtils.preCheckCast(this.o.getWritableDatabase().rawQuery("select count(1) from " + this.f + " where " + this.g + " = ?", new String[]{String.valueOf(r7)}), Closeable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L18
        Cursor r4 = (Cursor) ZeusTransformUtils.preCheckCast(r2, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L13
        if (r4.moveToFirst() == false) goto L10;
        int r5 = r4.getInt(0);     // Catch: Throwable -> L13
        CloseableKt.closeFinally(r2, null);     // Catch: Throwable -> L18
        return r5;
    L10:
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L13
        CloseableKt.closeFinally(r2, null);     // Catch: Throwable -> L18
    L20:
        return 0;
    L13:
        th = move-exception;
        throw th;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        CloseableKt.closeFinally(r2, th);     // Catch: Throwable -> L18
        throw th;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        this.f1838a.a("SqliteDatabase:count", th, (Function0) ZeusTransformUtils.preCheckCast(new EventDatabase$count$2(r7), Function0.class, "com.obric.memorydata.plugin"));
        goto L20
    }

    @Override // com.bytedance.applog.priority.original.g
    public Set<Integer> a() {
        Set<Integer> r0 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
        Closeable r1 = (Closeable) ZeusTransformUtils.preCheckCast(this.o.getWritableDatabase().rawQuery("select distinct(" + this.g + ") from " + this.f, null), Closeable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
        Cursor r3 = (Cursor) ZeusTransformUtils.preCheckCast(r1, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
    L6:
        if (r3.moveToNext() == false) goto L8;
        r0.add(Integer.valueOf(r3.getInt(0)));     // Catch: Throwable -> L11
        goto L6
    L8:
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L11
        CloseableKt.closeFinally(r1, null);     // Catch: Throwable -> L16
    L18:
        return r0;
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        CloseableKt.closeFinally(r1, th);     // Catch: Throwable -> L16
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        this.f1838a.a("SqliteDatabase:getAllGroupIds", th, (Function0) ZeusTransformUtils.preCheckCast(EventDatabase$getAllGroupIds$2.INSTANCE, Function0.class, "com.obric.memorydata.plugin"));
        goto L18
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v10, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r26v0 */
    /* JADX WARN: Type inference failed for: r26v1 */
    /* JADX WARN: Type inference failed for: r26v2 */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v12 */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v14 */
    /* JADX WARN: Type inference failed for: r8v15 */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v22 */
    /* JADX WARN: Type inference failed for: r8v23 */
    /* JADX WARN: Type inference failed for: r8v24 */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v6, types: [boolean] */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9, types: [int] */
    @Override // com.bytedance.applog.priority.original.g
    public Pair<HashMap<Model.a, JSONObject>, Boolean> a(final int r31, final long r32, final int r34, final long r35, Function1<? super JSONObject, Boolean> r37) {
        Function1 r2 = (Function1) ZeusTransformUtils.wrapperContextForParams(r37, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "filter");
        HashMap r4 = new HashMap();
        HashSet r5 = new HashSet();
        long r6 = (System.currentTimeMillis() - r35) / ((long) 1000);
        ?? r8 = 0;
        ?? r9 = 0;
        boolean r10 = true;
        Closeable r11 = (Closeable) ZeusTransformUtils.preCheckCast(this.o.getWritableDatabase().rawQuery("select id, " + this.k + ", " + this.g + ", " + this.i + ", " + this.j + ", " + this.h + ", " + this.l + ", " + this.m + " from " + this.f + " where " + this.g + " = ?", new String[]{String.valueOf(r31)}), Closeable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L51
        ?? r12 = (Cursor) ZeusTransformUtils.preCheckCast(r11, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L41
        long r13 = 0;
        int r14 = 0;
    L5:
        if (r12.moveToNext() == false) goto L34;
        if (r13 >= r32) goto L9;
        int r15 = r14 + 1;
        if (r14 >= r34) goto L12;
        long r17 = r12.getLong(r9);     // Catch: Throwable -> L32
        long r20 = r12.getLong(1);     // Catch: Throwable -> L32
        if (r20 >= r6) goto L19;
        r5.add(Long.valueOf(r17));     // Catch: Throwable -> L39
        HashSet r27 = r5;
        long r28 = r6;
    L29:
        r14 = r15;
        r5 = r27;
        r6 = r28;
        r9 = 0;
        r10 = true;
    L39:
        th = move-exception;
        Throwable r3 = th;
        r8 = r9;
    L56:
        throw r3;     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        CloseableKt.closeFinally(r11, r3);     // Catch: Throwable -> L49
        throw th;     // Catch: Throwable -> L49
    L19:
        int r19 = r12.getInt(2);     // Catch: Throwable -> L32
        Model.EventType r22 = Model.EventType.Companion.a(r12.getInt(3));     // Catch: Throwable -> L32
        if (r12.getInt(4) != 1) goto L22;
        boolean r23 = true;
    L23:
        String r16 = r12.getString(5);     // Catch: Throwable -> L32
        String r18 = r12.getString(6);     // Catch: Throwable -> L32
        String r0 = r12.getString(7);     // Catch: Throwable -> L32
        r27 = r5;
        r28 = r6;
        Intrinsics.checkNotNullExpressionValue(r16, "monitorId");     // Catch: Throwable -> L32
        Intrinsics.checkNotNullExpressionValue(r18, "eventName");     // Catch: Throwable -> L32
        Model.a r7 = new Model.a(r17, r19, r20, r22, r23, r16, r18);     // Catch: Throwable -> L32
        JSONObject r21 = new JSONObject(r0);     // Catch: Throwable -> L26
    L28:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r2.invoke(r21), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L29;
        r4.put(r7, r21);     // Catch: Throwable -> L32
        Intrinsics.checkNotNullExpressionValue(r0, "eventJson");     // Catch: Throwable -> L32
        r13 = r13 + ((long) e.a(r0));
    L26:
        r21 = new JSONObject();     // Catch: Throwable -> L32
        goto L28
    L22:
        r23 = false;
    L32:
        th = th;
    L43:
        r3 = th;
        r8 = 0;
        goto L56
    L12:
        r9 = 1;
    L35:
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L39
        CloseableKt.closeFinally(r11, null);     // Catch: Throwable -> L49
        ?? r24 = r9;
    L55:
        return new Pair(r4, Boolean.valueOf(r24));
    L9:
        r9 = r10;
        goto L35
    L34:
        r9 = 0;
    L41:
        th = th;
    L49:
        th = th;
        ?? r26 = r8;
    L53:
        this.f1838a.a("SqliteDatabase:getBySizeAndCount", th, (Function0) ZeusTransformUtils.preCheckCast(new EventDatabase$getBySizeAndCount$2(r31, r32, r34, r35), Function0.class, "com.obric.memorydata.plugin"));
        r24 = r26;
    L51:
        th = th;
        r26 = 0;
        goto L53
    }

    @Override // com.bytedance.applog.priority.original.g
    public void a(Iterable<Model.a> r10) {
        final Iterable r11 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r10, Iterable.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r11, "keys");
        SQLiteDatabase r0 = this.o.getWritableDatabase();
        r0.beginTransaction();     // Catch: Throwable -> L15
        SQLiteStatement r2 = r0.compileStatement("delete from " + this.f + " where id = ?");     // Catch: Throwable -> L15
        Iterator r3 = r11.iterator();     // Catch: Throwable -> L12
    L6:
        if (r3.hasNext() == false) goto L10;
        Model.a r4 = (Model.a) ZeusTransformUtils.preCheckCast(r3.next(), Model.a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L12
        if (r4.a() < 0) goto L6;
        r2.clearBindings();     // Catch: Throwable -> L12
        r2.bindLong(1, r4.a());     // Catch: Throwable -> L12
        r2.executeUpdateDelete();     // Catch: Throwable -> L12
        goto L6
    L10:
        r0.setTransactionSuccessful();     // Catch: Throwable -> L12
        r2.close();     // Catch: Throwable -> L15
    L17:
        e.a(r0);
        return;
    L12:
        th = move-exception;
        r2.close();     // Catch: Throwable -> L15
        throw th;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        this.f1838a.a("SqliteDatabase:deleteAll", th, (Function0) ZeusTransformUtils.preCheckCast(new EventDatabase$deleteAll$2(r11), Function0.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        e.a(r0);
        throw th;
    }

    @Override // com.bytedance.applog.priority.original.g
    public void b() {
    }

    @Override // com.bytedance.applog.priority.original.g
    public boolean b(int r1) {
        if (a(r1) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final Context getContext() {
        return this.f1839b;
    }

    @Override // com.bytedance.applog.priority.original.g
    public Model.a insert(final Model.a r6, String r7) {
        Intrinsics.checkNotNullParameter(r6, "key");
        Intrinsics.checkNotNullParameter(r7, EventBody.KEY_VALUE);
        ContentValues r0 = new ContentValues();
        r0.put(this.g, Integer.valueOf(r6.b()));
        r0.put(this.i, Integer.valueOf(r6.d().getType()));
        r0.put(this.j, Integer.valueOf(r6.e() ? 1 : 0));
        r0.put(this.h, r6.f());
        r0.put(this.k, Long.valueOf(r6.c()));
        r0.put(this.l, r6.g());
        r0.put(this.m, r7);
        final long r1 = this.o.getWritableDatabase().insert(this.f, null, r0);
        if (r1 >= 0) goto L6;
        this.f1838a.a("SqliteDatabase:insert", null, (Function0) ZeusTransformUtils.preCheckCast(new EventDatabase$insert$1(r6, r1), Function0.class, "com.obric.memorydata.plugin"));
        return null;
    L6:
        r6.a(r1);
        return r6;
    }
}
