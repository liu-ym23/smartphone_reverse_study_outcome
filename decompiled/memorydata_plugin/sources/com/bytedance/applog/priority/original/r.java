package com.bytedance.applog.priority.original;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\f\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"J(\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00072\u0006\u0010'\u001a\u00020%2\b\u0010(\u001a\u0004\u0018\u00010\u00072\u0006\u0010)\u001a\u00020*J(\u0010+\u001a\u00020,2\u0006\u0010&\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\u00072\u0006\u0010.\u001a\u00020*2\b\u0010(\u001a\u0004\u0018\u00010\u0007J\u0016\u0010/\u001a\b\u0012\u0004\u0012\u0002000\"2\b\u00101\u001a\u0004\u0018\u00010\u0007J\u000e\u00102\u001a\u00020,2\u0006\u0010&\u001a\u00020\u0007J\u000e\u00103\u001a\u00020,2\u0006\u0010&\u001a\u00020\u0007R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u001b\u0010\u0015\u001a\u00020\u00168FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082D¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/bytedance/applog/priority/original/SessionDatabase;", "", "logger", "Lcom/bytedance/applog/log/AbsLogger;", "context", "Landroid/content/Context;", "appId", "", "(Lcom/bytedance/applog/log/AbsLogger;Landroid/content/Context;Ljava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "colDuration", "colExtraParams", "colIsForeground", "colPageName", "colSessionId", "colTime", "getContext", "()Landroid/content/Context;", "createLaunchTableSql", "createPageTableSql", "helper", "Lcom/bytedance/applog/priority/original/SqliteDbHelper;", "getHelper", "()Lcom/bytedance/applog/priority/original/SqliteDbHelper;", "helper$delegate", "Lkotlin/Lazy;", "getLogger", "()Lcom/bytedance/applog/log/AbsLogger;", "sessionLaunchTableName", "sessionPageTableName", "sqliteDbVersion", "", "getAllLaunch", "", "Lcom/bytedance/applog/priority/original/AppSessionLaunch;", "insertLaunch", "", ObricMemoryConstants.KEY_SESSION_ID, "isForeground", "extraParams", "timestamp", "", "insertPage", "", "pageName", "duration", "queryTerminates", "Lcom/bytedance/applog/priority/original/AppSessionTerminate;", "excludeSessionId", "removeLaunch", "removePages", "priority_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.bytedance.applog.log.a f1851a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f1852b;
    private final String c;
    private final int d;
    private final String e;
    private final String f;
    private final String g;
    private final String h;
    private final String i;
    private final String j;
    private final String k;
    private final String l;
    private final String m;
    private final String n;
    private final Lazy o;

    public r(com.bytedance.applog.log.a r10, Context r11, String r12) {
        com.bytedance.applog.log.a r13 = (com.bytedance.applog.log.a) ZeusTransformUtils.wrapperContextForParams(r10, com.bytedance.applog.log.a.class, "com.obric.memorydata.plugin");
        Context r14 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r13, "logger");
        Intrinsics.checkNotNullParameter(r14, "context");
        Intrinsics.checkNotNullParameter(r12, "appId");
        this.f1851a = r13;
        this.f1852b = ZeusTransformUtils.wrapperContext(r14, "com.obric.memorydata.plugin");
        this.c = r12;
        this.d = 1;
        this.e = "session_launch";
        this.f = "session_page";
        this.g = "session_id";
        this.h = "duration";
        this.i = "page_name";
        this.j = "extra_params";
        this.k = "timestamp";
        this.l = "foreground";
        this.m = "CREATE TABLE IF NOT EXISTS session_launch (\n        id integer primary key autoincrement, \n        session_id varchar(64) NOT NULL, \n        foreground tinyint default 0,\n        timestamp integer default 0,\n        extra_params TEXT\n        )";
        this.n = "CREATE TABLE IF NOT EXISTS session_page (\n        id integer primary key autoincrement, \n        session_id varchar(64) NOT NULL, \n        duration integer default 0, \n        page_name varchar(255) NOT NULL ,\n        extra_params TEXT\n        )";
        this.o = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(new SessionDatabase$helper$2(this), Function0.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ String a(r r0) {
        return r0.m;
    }

    public static final /* synthetic */ String b(r r0) {
        return r0.n;
    }

    public final com.bytedance.applog.log.a a() {
        return this.f1851a;
    }

    public final void a(final String r6) {
        Intrinsics.checkNotNullParameter(r6, ObricMemoryConstants.KEY_SESSION_ID);
        SQLiteDatabase r0 = c().getWritableDatabase();
        r0.beginTransaction();     // Catch: Throwable -> L9
        SQLiteStatement r1 = r0.compileStatement("delete from " + this.e + " where " + this.g + " = ?");     // Catch: Throwable -> L9
        r1.clearBindings();     // Catch: Throwable -> L6
        r1.bindString(1, r6);     // Catch: Throwable -> L6
        r1.executeUpdateDelete();     // Catch: Throwable -> L6
        r0.setTransactionSuccessful();     // Catch: Throwable -> L6
        r1.close();     // Catch: Throwable -> L9
    L11:
        e.a(r0);
        return;
    L6:
        th = move-exception;
        r1.close();     // Catch: Throwable -> L9
        throw th;     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        this.f1851a.a("SessionDatabase:removeLaunch", th, (Function0) ZeusTransformUtils.preCheckCast(new SessionDatabase$removeLaunch$1(r6), Function0.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        e.a(r0);
        throw th;
    }

    public final void a(final String r16, final String r17, final long r18, String r20) {
        Intrinsics.checkNotNullParameter(r16, ObricMemoryConstants.KEY_SESSION_ID);
        Intrinsics.checkNotNullParameter(r17, "pageName");
        ContentValues r2 = new ContentValues();     // Catch: Throwable -> L10
        r2.put(this.g, r16);     // Catch: Throwable -> L10
        r2.put(this.i, r17);     // Catch: Throwable -> L10
        r2.put(this.h, Long.valueOf(r18));     // Catch: Throwable -> L10
        if (r20 == null) goto L6;
        r2.put(this.j, r20);     // Catch: Throwable -> L10
    L6:
        final long r3 = c().getWritableDatabase().insert(this.f, null, r2);     // Catch: Throwable -> L10
        if (r3 >= 0) goto L19;
        this.f1851a.a("SessionDatabase:insertPage", null, (Function0) ZeusTransformUtils.preCheckCast(new SessionDatabase$insertPage$2(r3, r16, r17, r18), Function0.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L10
        return;
    L19:
        return;
    L10:
        th = move-exception;
        this.f1851a.a("SessionDatabase:insertPage", th, (Function0) ZeusTransformUtils.preCheckCast(new SessionDatabase$insertPage$3(r16, r17, r18), Function0.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    }

    public final boolean a(final String r8, final boolean r9, String r10, long r11) {
        Intrinsics.checkNotNullParameter(r8, ObricMemoryConstants.KEY_SESSION_ID);
        ContentValues r3 = new ContentValues();     // Catch: Throwable -> L16
        r3.put(this.g, r8);     // Catch: Throwable -> L16
        String r4 = this.l;     // Catch: Throwable -> L16
        if (r9 == false) goto L6;
        int r6 = 1;
    L7:
        r3.put(r4, Integer.valueOf(r6));     // Catch: Throwable -> L16
        r3.put(this.k, Long.valueOf(r11));     // Catch: Throwable -> L16
        if (r10 == null) goto L10;
        r3.put(this.j, r10);     // Catch: Throwable -> L16
    L10:
        final long r12 = c().getWritableDatabase().insert(this.e, null, r3);     // Catch: Throwable -> L16
        if (r12 >= 0) goto L13;
        this.f1851a.a("SessionDatabase:insertLaunch", null, (Function0) ZeusTransformUtils.preCheckCast(new SessionDatabase$insertLaunch$2(r12, r8, r9), Function0.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L16
    L13:
        if (r12 >= 0) goto L15;
        return false;
    L15:
        return true;
    L6:
        r6 = 0;
    L16:
        th = move-exception;
        this.f1851a.a("SessionDatabase:insertLaunch", th, (Function0) ZeusTransformUtils.preCheckCast(new SessionDatabase$insertLaunch$3(r8, r9), Function0.class, "com.obric.memorydata.plugin"));
        return false;
    }

    public final String b() {
        return this.c;
    }

    public final void b(final String r6) {
        Intrinsics.checkNotNullParameter(r6, ObricMemoryConstants.KEY_SESSION_ID);
        SQLiteDatabase r0 = c().getWritableDatabase();
        r0.beginTransaction();     // Catch: Throwable -> L9
        SQLiteStatement r1 = r0.compileStatement("delete from " + this.f + " where " + this.g + " = ?");     // Catch: Throwable -> L9
        r1.clearBindings();     // Catch: Throwable -> L6
        r1.bindString(1, r6);     // Catch: Throwable -> L6
        r1.executeUpdateDelete();     // Catch: Throwable -> L6
        r0.setTransactionSuccessful();     // Catch: Throwable -> L6
        r1.close();     // Catch: Throwable -> L9
    L11:
        e.a(r0);
        return;
    L6:
        th = move-exception;
        r1.close();     // Catch: Throwable -> L9
        throw th;     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        this.f1851a.a("SessionDatabase:remove", th, (Function0) ZeusTransformUtils.preCheckCast(new SessionDatabase$removePages$1(r6), Function0.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        e.a(r0);
        throw th;
    }

    public final s c() {
        return (s) ZeusTransformUtils.preCheckCast(this.o.getValue(), s.class, "com.obric.memorydata.plugin");
    }

    public final List<d> c(final String r23) {
        SQLiteDatabase r4 = c().getReadableDatabase();
        Map r5 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        String r0 = "select " + this.g + ", " + this.i + ", " + this.h + ", " + this.j + " from " + this.f + " where " + this.g + " <> ? order by id asc";     // Catch: Throwable -> L51
        int r6 = 1;
        String[] r8 = new String[1];     // Catch: Throwable -> L51
        if (r23 != null) goto L6;
        String r9 = "";
    L60:
        int r10 = 0;
        r8[0] = r9;     // Catch: Throwable -> L51
        Closeable r7 = (Closeable) ZeusTransformUtils.preCheckCast(r4.rawQuery(r0, r8), Closeable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L51
        Cursor r11 = (Cursor) ZeusTransformUtils.preCheckCast(r7, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L41
    L9:
        if (r11.moveToNext() == false) goto L34;
        String r15 = r11.getString(r10);     // Catch: Throwable -> L41
        final String r13 = r11.getString(r6);     // Catch: Throwable -> L41
        final long r12 = r11.getLong(2);     // Catch: Throwable -> L41
        String r1 = r11.getString(3);     // Catch: Throwable -> L41
        Intrinsics.checkNotNullExpressionValue(r15, ObricMemoryConstants.KEY_SESSION_ID);     // Catch: Throwable -> L41
        Object r14 = r5.get(r15);     // Catch: Throwable -> L41
        if (r14 != null) goto L14;
        d r16 = new d(r15, 0, new JSONArray(), new JSONObject());     // Catch: Throwable -> L41
        final String r17 = r15;
        r5.put(r17, r16);     // Catch: Throwable -> L41
        r14 = r16;
    L15:
        d r18 = (d) ZeusTransformUtils.preCheckCast(r14, d.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L41
        JSONArray r19 = r18.c();     // Catch: Throwable -> L41
        JSONArray r110 = new JSONArray();     // Catch: Throwable -> L41
        r110.put(r13);     // Catch: Throwable -> L41
        Closeable r111 = r7;
        Map r112 = r5;
        r110.put(Math.max(r12 / ((long) 1000), 1));     // Catch: Throwable -> L32
        r19.put(r110);     // Catch: Throwable -> L32
        r18.a(r18.b() + r12);     // Catch: Throwable -> L32
        CharSequence r20 = (CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L32
        if (r20 != null) goto L20;
    L23:
        boolean r21 = true;
    L24:
        if (r21 == true) goto L31;
        JSONObject r22 = new JSONObject(r1);     // Catch: Throwable -> L29
        if (r22.length() <= 0) goto L31;
        e.a(r18.d(), r22);     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        this.f1851a.a("SessionDatabase:queryTerminates", th, (Function0) ZeusTransformUtils.preCheckCast(new SessionDatabase$queryTerminates$1$2(r17, r13, r12), Function0.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L32
    L31:
        r5 = r112;
        r7 = r111;
        r11 = r11;
        r6 = 1;
        r10 = 0;
        goto L9
    L20:
        if (r20.length() == 0) goto L23;
        r21 = false;
    L32:
        th = move-exception;
        Throwable r24 = th;
        r7 = r111;
    L56:
        throw r24;     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        CloseableKt.closeFinally(r7, r24);     // Catch: Throwable -> L49
        throw th;     // Catch: Throwable -> L49
    L14:
        r17 = r15;
        goto L15
    L34:
        Closeable r113 = r7;
        r112 = r5;
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L39
        CloseableKt.closeFinally(r113, null);     // Catch: Throwable -> L49
    L55:
        return CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r112.values(), Iterable.class, "com.obric.memorydata.plugin"));
    L39:
        th = th;
        r7 = r113;
    L43:
        r24 = th;
    L41:
        th = th;
        r112 = r5;
    L49:
        th = th;
    L53:
        this.f1851a.a("SessionDatabase:queryTerminates", th, (Function0) ZeusTransformUtils.preCheckCast(new SessionDatabase$queryTerminates$2(r23), Function0.class, "com.obric.memorydata.plugin"));
        goto L55
    L6:
        r9 = r23;
    L51:
        th = th;
        r112 = r5;
        goto L53
    }

    public final List<b> d() {
        List<b> r1 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Closeable r0 = (Closeable) ZeusTransformUtils.preCheckCast(c().getReadableDatabase().rawQuery("select " + this.g + ", " + this.l + ", " + this.k + ", " + this.j + " from " + this.e + " order by id asc", new String[0]), Closeable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L21
        Cursor r5 = (Cursor) ZeusTransformUtils.preCheckCast(r0, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
    L7:
        if (r5.moveToNext() == false) goto L13;
        String r8 = r5.getString(0);     // Catch: Throwable -> L16
        if (r5.getInt(1) != 1) goto L11;
        boolean r9 = true;
    L12:
        long r11 = r5.getLong(2);     // Catch: Throwable -> L16
        String r6 = r5.getString(3);     // Catch: Throwable -> L16
        Intrinsics.checkNotNullExpressionValue(r8, ObricMemoryConstants.KEY_SESSION_ID);     // Catch: Throwable -> L16
        r1.add(new b(r8, r9, e.b(r6), r11));     // Catch: Throwable -> L16
        goto L7
    L11:
        r9 = false;
        goto L12
    L13:
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L16
        CloseableKt.closeFinally(r0, null);     // Catch: Throwable -> L21
    L23:
        return r1;
    L16:
        th = move-exception;
        throw th;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        CloseableKt.closeFinally(r0, th);     // Catch: Throwable -> L21
        throw th;     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        this.f1851a.a("SessionDatabase:getAllLaunch", th, (Function0) ZeusTransformUtils.preCheckCast(SessionDatabase$getAllLaunch$2.INSTANCE, Function0.class, "com.obric.memorydata.plugin"));
        goto L23
    }

    public final Context getContext() {
        return this.f1852b;
    }
}
