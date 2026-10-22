package com.bytedance.applog.n;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.CursorWindow;
import android.database.sqlite.SQLiteBlobTooBigException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.applog.log.p;
import com.bytedance.applog.monitor.v3.EventStage;
import com.bytedance.applog.monitor.v3.StatsCountKeys;
import com.bytedance.applog.util.o;
import com.bytedance.crash.constants.Constants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f1726a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile boolean f1727b = false;
    public static volatile long c = 60000;
    ArrayList<com.bytedance.applog.n.a> d;
    private final com.bytedance.applog.e.c e;
    private final C0103b f;
    private final HashMap<String, com.bytedance.applog.n.a> g;
    private final com.bytedance.applog.n.a[] h;
    private Handler i;
    private volatile boolean j;
    private volatile boolean k;
    private final Set<String> l;
    private int m;
    private int n;
    private int o;
    private int p;

    class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f1728a;

        public a(b r1, Looper r2) {
            this.f1728a = r1;
            super(r2);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r2) {
            if (r2.what != 0) goto L7;
            this.f1728a.a(null, true);
            return;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.applog.n.b$b, reason: collision with other inner class name */
    private class C0103b extends SQLiteOpenHelper {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f1729a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f1730b;
        private long c;

        C0103b(b r3, Context r4, String r5, SQLiteDatabase.CursorFactory r6, int r7) {
            Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
            SQLiteDatabase.CursorFactory r9 = (SQLiteDatabase.CursorFactory) ZeusTransformUtils.wrapperContextForParams(r6, SQLiteDatabase.CursorFactory.class, "com.obric.memorydata.plugin");
            this.f1729a = r3;
            super(r8, r5, r9, r7);
            long r10 = 0;
            this.f1730b = 0;
            File r11 = r8.getDatabasePath(r5);
            if (r11 == null) goto L5;
            r10 = r11.length();
        L5:
            this.f1730b = r10;
        }

        public int a() {
            long r0 = this.f1730b;
            if (r0 > 0) goto L7;
            return 0;
        L7:
            return Math.toIntExact(r0 / 1024);
        }

        public void b() {
            if (b.f1727b == true) goto L5;
            return;
        L5:
            long r0 = System.currentTimeMillis();
            if ((r0 - this.c) > b.c) goto L8;
            return;
        L8:
            this.c = r0;
            Cursor r2 = getWritableDatabase().rawQuery("PRAGMA wal_checkpoint(2)", null);     // Catch: Throwable -> L14
            if (r2 == null) goto L12;
            r2.close();     // Catch: Throwable -> L14
        L12:
            b.b(this.f1729a).c(5, "executeWALCheckpoint success", new Object[0]);     // Catch: Throwable -> L14
            return;
        L14:
            th = move-exception;
            b.b(this.f1729a).a(5, "executeWALCheckpoint failed", th, new Object[0]);
            b.c(this.f1729a).a().ab().a("executeWALCheckpoint failed", th);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onConfigure(SQLiteDatabase r3) {
            super.onConfigure(r3);
            if (b.f1727b == false) goto L6;
            r3.enableWriteAheadLogging();
            b.b(this.f1729a).c(5, "enable sqlite WAL", new Object[0]);
            return;
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase r6) {
            r6.beginTransaction();     // Catch: Throwable -> L10
            Iterator r0 = b.a(this.f1729a).values().iterator();     // Catch: Throwable -> L10
        L4:
            if (r0.hasNext() == false) goto L8;
            String r1 = ((com.bytedance.applog.n.a) ZeusTransformUtils.preCheckCast(r0.next(), com.bytedance.applog.n.a.class, "com.obric.memorydata.plugin")).g();     // Catch: Throwable -> L10
            if (r1 == null) goto L4;
            r6.execSQL(r1);     // Catch: Throwable -> L10
            goto L4
        L8:
            r6.setTransactionSuccessful();     // Catch: Throwable -> L10
        L9:
            o.a(r6);
            return;
        L10:
            th = move-exception;
            b.b(this.f1729a).a(5, "create db failed", th, new Object[0]);     // Catch: Throwable -> L14
            b.c(this.f1729a).a().ab().a("DBHelper onCreate failed", th);     // Catch: Throwable -> L14
        L14:
            th = move-exception;
            o.a(r6);
            throw th;
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onDowngrade(SQLiteDatabase r1, int r2, int r3) {
            onUpgrade(r1, r2, r3);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase r5, int r6, int r7) {
            b.b(this.f1729a).c(5, "onUpgrade: v{} -> v{}", new Object[]{Integer.valueOf(r6), Integer.valueOf(r7)});
            r5.beginTransaction();     // Catch: Throwable -> L9
            Iterator r8 = b.a(this.f1729a).values().iterator();     // Catch: Throwable -> L9
        L5:
            if (r8.hasNext() == false) goto L7;
            r5.execSQL("DROP TABLE IF EXISTS " + ((com.bytedance.applog.n.a) ZeusTransformUtils.preCheckCast(r8.next(), com.bytedance.applog.n.a.class, "com.obric.memorydata.plugin")).h());     // Catch: Throwable -> L9
            goto L5
        L7:
            r5.setTransactionSuccessful();     // Catch: Throwable -> L9
        L8:
            o.a(r5);
            onCreate(r5);
            return;
        L9:
            th = move-exception;
            b.b(this.f1729a).a(5, "upgrade db failed", th, new Object[0]);     // Catch: Throwable -> L14
            b.c(this.f1729a).a().ab().a("DBHelper onUpgrade failed", th);     // Catch: Throwable -> L14
        L14:
            th = move-exception;
            o.a(r5);
            throw th;
        }
    }

    static {
    }

    public b(com.bytedance.applog.e.c r10, String r11) {
        this.g = new HashMap();
        com.bytedance.applog.n.a[] r0 = com.bytedance.applog.n.a.d();
        this.h = r0;
        this.i = null;
        int r1 = 0;
        this.j = false;
        this.k = false;
        this.l = new HashSet();
        this.m = 0;
        this.n = 0;
        this.o = 0;
        this.p = 0;
        this.d = new ArrayList();
        this.f = new C0103b(this, (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r10.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r11, null, 58);
        this.e = r10;
        a(new i());
        a(new g());
        a(new j());
        a(new h());
        a(new f());
        int r12 = r0.length;
    L3:
        if (r1 >= r12) goto L5;
        a(r0[r1]);
        r1 = r1 + 1;
        goto L3
    L5:
        h();
    }

    private int a(int r19, SQLiteDatabase r20, String r21, boolean r22, JSONArray[] r23, long[] r24, com.bytedance.applog.priority.b r25, com.bytedance.applog.b.d r26) {
        int r0 = 0;
    L4:
        if (r0 >= r19) goto L7;
        r23[r0] = null;
        r24[r0] = 0;
        r0 = r0 + 1;
        goto L4
    L7:
        if (r26.a() == false) goto L9;
        int r1 = com.bytedance.applog.b.e.f1532b;
    L10:
        int r15 = r1;
        int r10 = r0;
        int r16 = r15;
    L11:
        if (r16 <= 0) goto L23;
        if (r10 >= this.h.length) goto L23;
        int r17 = r10;
        a(r20, r21, r16, r10, r22, r23, r24, r25, r15, r26);
        if (r26.a() == true) goto L17;
    L19:
        r16 = r16 - r23[r17].length();
        if (r16 > 0) goto L21;
        r10 = r17;
        goto L11
    L21:
        r10 = r17 + 1;
        goto L11
    L17:
        if (r26.b() == false) goto L19;
    L24:
        int r11 = r17 + 1;
    L26:
        if (r11 >= r23.length) goto L28;
        r23[r11] = null;
        r24[r11] = 0;
        r11 = r11 + 1;
        goto L26
    L28:
        return r17;
    L23:
        r17 = r10;
        goto L24
    L9:
        r1 = 200;
        goto L10
    }

    private String a(long r2, int r4) {
        return "UPDATE pack SET _fail=" + r4 + " WHERE _id=" + r2;
    }

    private String a(com.bytedance.applog.n.a r2, int r3, int r4) {
        return "SELECT * FROM " + r2.h() + " WHERE priority=" + r4 + " ORDER BY _id LIMIT " + r3;
    }

    private String a(com.bytedance.applog.n.a r3, String r4, boolean r5, int r6, com.bytedance.applog.priority.b r7) {
        StringBuilder r2 = new StringBuilder("SELECT * FROM " + r3.h() + " WHERE session_id");
        if (r5 == false) goto L5;
        String r8 = "='";
    L6:
        r2.append(r8);
        r2.append(r4);
        if (r7 == null) goto L13;
        int r9 = r7.a();
        if ((-1) != r9) goto L11;
        StringBuilder r10 = new StringBuilder().append("' AND (priority=").append(r9).append(" OR ").append("priority").append(">").append(r7.b()).append(")");
    L12:
        String r11 = r10.toString();
    L14:
        r2.append(r11);
        r2.append(" ORDER BY _id LIMIT " + r6);
        return r2.toString();
    L11:
        r10 = new StringBuilder().append("' AND priority=").append(r9);
        goto L12
    L13:
        r11 = "'";
        goto L14
    L5:
        r8 = "!='";
        goto L6
    }

    private String a(String r2, long r3, int r5) {
        return "DELETE FROM " + r2 + " WHERE _id<=" + r3 + " AND priority=" + r5;
    }

    private String a(String r3, String r4, boolean r5, long r6, com.bytedance.applog.priority.b r8) {
        StringBuilder r2 = new StringBuilder("DELETE FROM " + r3 + " WHERE session_id");
        if (r5 == false) goto L5;
        String r7 = "='";
    L6:
        r2.append(r7);
        r2.append(r4 + "' AND _id<=" + r6);
        if (r8 == null) goto L14;
        int r9 = r8.a();
        if ((-1) != r9) goto L11;
        StringBuilder r10 = new StringBuilder().append(" AND (priority=").append(r9).append(" OR ").append("priority").append(">").append(r8.b()).append(")");
    L12:
        r2.append(r10.toString());
        goto L14
    L11:
        r10 = new StringBuilder().append(" AND priority=").append(r9);
    L14:
        return r2.toString();
    L5:
        r7 = "!='";
        goto L6
    }

    private String a(String r2, boolean r3) {
        StringBuilder r1 = new StringBuilder().append("SELECT * FROM page WHERE session_id");
        if (r3 == false) goto L5;
        String r0 = "='";
    L6:
        StringBuilder r4 = r1.append(r0).append(r2).append("' ORDER BY ");
        if (r3 == false) goto L9;
        String r5 = "session_id,";
    L11:
        return r4.append(r5).append("duration").append(" DESC LIMIT 1000").toString();
    L9:
        r5 = "";
        goto L11
    L5:
        r0 = "!='";
        goto L6
    }

    static /* synthetic */ HashMap a(b r0) {
        return r0.g;
    }

    private JSONArray a(g r22, boolean r23, j r24, i r25, SQLiteDatabase r26, com.bytedance.applog.priority.b r27, boolean r28) {
        JSONArray r6 = new JSONArray();
        if (r27 == null) goto L92;
        int r7 = r27.a();
        if (r7 != 0) goto L7;
    L9:
        return r6;
    L7:
        if ((-1) == r7) goto L92;
        if (r28 == false) goto L9;
    L92:
        Cursor r14 = r26.rawQuery(a(r22.d, r23), null);     // Catch: Throwable -> L47
        HashMap r15 = new HashMap(8);     // Catch: Throwable -> L45
        String r13 = null;
        long r16 = 0;
        String r18 = null;
        String r19 = null;
    L84:
        if (r14.moveToNext() == false) goto L40;
        r25.a(r14);     // Catch: Throwable -> L43
        int r11 = 1;
        i().c(5, "queryPage: {}", new Object[]{r25});     // Catch: Throwable -> L43
        Integer r8 = (Integer) ZeusTransformUtils.preCheckCast(r15.get(r25.x), Integer.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L43
        if (r25.t() == false) goto L18;
        if (r8 != null) goto L34;
        r25.v = 1000;     // Catch: Throwable -> L43
        r16 = r16 + r25.v;     // Catch: Throwable -> L43
        r6.put(r25.m());     // Catch: Throwable -> L43
        goto L84
    L34:
        Integer r9 = Integer.valueOf(r8.intValue() - 1);     // Catch: Throwable -> L43
        if (r9.intValue() > 0) goto L36;
        r15.remove(r25.x);     // Catch: Throwable -> L43
        goto L84
    L36:
        r15.put(r25.x, r9);     // Catch: Throwable -> L43
        goto L84
    L18:
        String r10 = r25.x;     // Catch: Throwable -> L43
        if (r8 == null) goto L21;
        r11 = 1 + r8.intValue();     // Catch: Throwable -> L43
    L21:
        r15.put(r10, Integer.valueOf(r11));     // Catch: Throwable -> L43
        if (r25.v < 1000) goto L24;
        r16 = r16 + r25.v;     // Catch: Throwable -> L43
    L25:
        r6.put(r25.m());     // Catch: Throwable -> L43
        if (TextUtils.isEmpty(r25.z) == true) goto L32;
        String r12 = r25.z;     // Catch: Throwable -> L43
        r18 = r12;
        r19 = r25.g;     // Catch: Throwable -> L30
    L30:
        th = th;
        r18 = r12;
    L90:
        i().a(5, "query page failed", th, new Object[0]);     // Catch: Throwable -> L78
        this.e.a().ab().a(StatsCountKeys.QUERY_PAGE_FAILED_COUNT);     // Catch: Throwable -> L78
        this.e.a().ab().a("query page failed", th);     // Catch: Throwable -> L78
        if (r14 != null) goto L41;
    L42:
        String r0 = r18;
        String r5 = r19;
        if (r6.length() > 0) goto L56;
    L77:
        return r6;
    L56:
        if (r16 <= 1000) goto L58;
        long r17 = r16;
    L59:
        r24.a();
        r24.a(this.e.a().b());
        r24.v = r17;
        if (r23 == false) goto L62;
        r24.d = r22.d;
        long r20 = r22.f1725b;
    L63:
        r24.a(r20);
        this.e.b().a(r24, r22.e);
        r24.g = r22.g;
        r24.w = r24.f1725b + r17;
        r24.c = this.e.b().h();
        r24.x = null;
        if (TextUtils.isEmpty(r22.y) == true) goto L67;
        r24.x = r22.y;
    L69:
        r24.s = com.bytedance.applog.monitor.b.c(this.e.a().ab(), r24);
        r24.C = r13;
        this.e.a().ab().a(StatsCountKeys.COLLECT_TERMINATE_COUNT);
        if (r24.s <= 0) goto L88;
        com.bytedance.applog.monitor.b.a(this.e.a().ab(), EventStage.COLLECTED, r24);
    L88:
        this.e.a().as().a(-1, r24.d, r24.m());     // Catch: Throwable -> L74
    L76:
        p.a("event_receive", r24);
    L74:
        th = move-exception;
        i().a(5, "notify session terminate failed", th, new Object[0]);
        this.e.a().ab().a("notify onSessionTerminate failed", th);
        goto L76
    L67:
        if (TextUtils.isEmpty(r0) == true) goto L69;
        r24.x = r0;
        r24.g = r5;
        goto L69
    L62:
        r24.d = UUID.randomUUID().toString();
        r20 = 0;
        goto L63
    L58:
        r17 = 1000;
    L41:
        r14.close();
    L78:
        th = move-exception;
        if (r14 == null) goto L81;
        r14.close();
    L81:
        throw th;
    L32:
        r13 = r25.A;     // Catch: Throwable -> L43
        goto L84
    L24:
        r16 = r16 + 1000;     // Catch: Throwable -> L43
        goto L25
    L40:
        if (r14 == null) goto L42;
    L43:
        th = th;
    L45:
        th = th;
        r13 = null;
    L49:
        r16 = 0;
        r18 = null;
        r19 = null;
    L47:
        th = th;
        r13 = null;
        r14 = null;
        goto L49
    }

    private JSONArray a(String r3, HashMap<String, JSONObject> r4) {
        JSONObject r5 = (JSONObject) ZeusTransformUtils.preCheckCast(r4.remove(r3), JSONObject.class, "com.obric.memorydata.plugin");
        JSONArray r0 = null;
        if (r5 == null) goto L11;
        JSONArray r6 = r5.optJSONArray("item_impression");
        if (r6 != null) goto L7;
    L9:
        r0 = r6;
        goto L11
    L7:
        if (r6.length() != 0) goto L9;
    L11:
        if (com.bytedance.applog.util.g.a(this.e.a().b()) == false) goto L14;
        if (r0 == null) goto L14;
        com.bytedance.applog.util.g.a(this.e.a().b(), "item_impression", r0);
    L14:
        return r0;
    }

    private JSONObject a(g r5, JSONObject r6) {
        if (TextUtils.equals(r5.w, this.e.h().c()) == true) goto L5;
    L11:
        JSONObject r0 = new JSONObject();     // Catch: JSONException -> L8
        o.b(r0, r6);     // Catch: JSONException -> L8
        r0.put("app_version", r5.w);     // Catch: JSONException -> L8
        r0.put("version_code", r5.v);     // Catch: JSONException -> L8
        return r0;
    L8:
        e = move-exception;
        i().a(5, "check version failed", e, new Object[0]);
        return r6;
    L5:
        if (r5.v != this.e.h().b()) goto L11;
        return r6;
    }

    private void a(int r5) {
        if (f1726a == true) goto L5;
        return;
    L5:
        if (r5 != 0) goto L7;
        this.h[r5] = new c();
        return;
    L7:
        if (r5 != 1) goto L9;
        this.h[r5] = new e(null, null, false, null);
        return;
    L9:
        if (r5 != 2) goto L17;
        this.h[r5] = new d(null, "", new JSONObject());
        return;
    }

    private void a(SQLiteDatabase r12, h r13, boolean r14) {
        if (r13.C() == false) goto L7;
        i().d(5, "no need insert to db for empty pack: {}, matchSid: {}", new Object[]{r13, Boolean.valueOf(r14)});
        return;
    L7:
        if (this.e.a().ab().d() == false) goto L12;
        Iterator<com.bytedance.applog.monitor.v3.h> r0 = r13.w().iterator();
    L10:
        if (r0.hasNext() == false) goto L12;
        com.bytedance.applog.monitor.b.a(this.e.a().ab(), EventStage.PACK_INSERT_START, (com.bytedance.applog.monitor.v3.h) ZeusTransformUtils.preCheckCast(r0.next(), com.bytedance.applog.monitor.v3.h.class, "com.obric.memorydata.plugin"));
    L12:
        long r6 = r12.insert("pack", null, r13.b(null));
        if (r6 >= 0) goto L20;
        if (r13.C == null) goto L17;
        this.l.remove(r13.C.d);
    L17:
        r13.z();
        i().e(5, "insert to db failed, pack: {}, result: {}", new Object[]{r13, Long.valueOf(r6)});
        this.e.a().ab().a(StatsCountKeys.INSERT_PACK_FAILED_COUNT);
        this.e.a().ab().a("pack insert failed for db id < 0", null);
        throw new SQLiteException("insert pack to db failed for result id < 0.");
    L20:
        if (this.e.a().ab().d() == false) goto L25;
        Iterator<com.bytedance.applog.monitor.v3.h> r1 = r13.w().iterator();
    L23:
        if (r1.hasNext() == false) goto L25;
        com.bytedance.applog.monitor.b.a(this.e.a().ab(), EventStage.PACK_INSERT_END, (com.bytedance.applog.monitor.v3.h) ZeusTransformUtils.preCheckCast(r1.next(), com.bytedance.applog.monitor.v3.h.class, "com.obric.memorydata.plugin"));
    L25:
        r13.f1724a = r6;
        i().b(5, "pack: {} insert to db success!", new Object[]{r13, Long.valueOf(r6)});
        if (r13.E != null) goto L28;
        return;
    L28:
        if (r13.D != null) goto L30;
        return;
    L30:
        if (r13.D.length() <= 0) goto L37;
        r12.execSQL(b(r13.d, r14));
        return;
    }

    private void a(SQLiteDatabase r16, String r17, int r18, int r19, boolean r20, JSONArray[] r21, long[] r22, com.bytedance.applog.priority.b r23, int r24, com.bytedance.applog.b.d r25) {
        com.bytedance.applog.n.a r9 = this.h[r19];
        JSONArray r10 = new JSONArray();
        Cursor r12 = null;
        long r13 = 0;
        r12 = r16.rawQuery(a(r9, r17, r20, r18, r23), null);     // Catch: Throwable -> L27
        int r1 = 0;
    L5:
        if (r12.moveToNext() == false) goto L24;
        if (r1 > r24) goto L24;
        r9.a(r12);     // Catch: Throwable -> L27
        JSONObject r3 = r9.m();     // Catch: Throwable -> L27
        if (r25.a() == true) goto L11;
    L19:
        r10.put(r3);     // Catch: Throwable -> L27
        if (r9.f1724a <= r13) goto L23;
        r13 = r9.f1724a;     // Catch: Throwable -> L27
    L23:
        r1 = r1 + 1;
        goto L5
    L11:
        if (ZeusTransformUtils.instanceOf(r9, e.class) == false) goto L14;
        boolean r4 = r25.b(r3);     // Catch: Throwable -> L27
    L17:
        if (r4 == true) goto L19;
        r25.a(true);     // Catch: Throwable -> L27
        goto L24
    L14:
        if (ZeusTransformUtils.instanceOf(r9, c.class) == false) goto L16;
        r4 = r25.c(r3);     // Catch: Throwable -> L27
        goto L17
    L16:
        r4 = r25.d(r3);     // Catch: Throwable -> L27
    L24:
        if (r12 == null) goto L26;
    L25:
        r12.close();
    L26:
        a(r19);
        r21[r19] = r10;
        r22[r19] = r13;
        return;
    L27:
        th = move-exception;
    L46:
        th = move-exception;
        if (r12 == null) goto L49;
        r12.close();
    L49:
        a(r19);
        throw th;
    L29:
        if (ZeusTransformUtils.instanceOf(r9, e.class) == false) goto L33;
        com.bytedance.applog.monitor.v3.e r2 = this.e.a().ab();     // Catch: Throwable -> L46
        StatsCountKeys r5 = StatsCountKeys.QUERY_EVENT_V3_FAILED_COUNT;     // Catch: Throwable -> L46
    L31:
        r2.a(r5);     // Catch: Throwable -> L46
    L38:
        this.e.a().ab().a("queryEvent failed", th);     // Catch: Throwable -> L46
        if (ZeusTransformUtils.instanceOf(th, SQLiteBlobTooBigException.class) == false) goto L41;
        j();     // Catch: Throwable -> L46
    L41:
        i().a(5, "query event failed", th, new Object[0]);     // Catch: Throwable -> L46
        if (r12 == null) goto L26;
    L33:
        if (ZeusTransformUtils.instanceOf(r9, c.class) == false) goto L36;
        r2 = this.e.a().ab();     // Catch: Throwable -> L46
        r5 = StatsCountKeys.QUERY_EVENT_V1_FAILED_COUNT;     // Catch: Throwable -> L46
        goto L31
    L36:
        if (ZeusTransformUtils.instanceOf(r9, d.class) == false) goto L38;
        r2 = this.e.a().ab();     // Catch: Throwable -> L46
        r5 = StatsCountKeys.QUERY_EVENT_MISC_FAILED_COUNT;     // Catch: Throwable -> L46
        goto L31
    }

    private void a(SQLiteDatabase r12, HashMap<String, JSONObject> r13) {
        g r1 = (g) ZeusTransformUtils.preCheckCast(this.g.get(Constants.LAUNCH_TAG), g.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L5;
        return;
    L5:
        Cursor r4 = null;
        r4 = r12.rawQuery(b(3), null);     // Catch: Throwable -> L21
        boolean r14 = r4.moveToLast();     // Catch: Throwable -> L21
    L7:
        if (r14 == false) goto L15;
        r1.a(r4);     // Catch: Throwable -> L21
        JSONObject r15 = new JSONObject();     // Catch: Throwable -> L21
        this.e.a().as().b(r1.f1724a, r1.d, r15);     // Catch: Throwable -> L11
    L13:
        r13.put(r1.d, r15);     // Catch: Throwable -> L21
        r14 = r4.moveToPrevious();     // Catch: Throwable -> L21
    L11:
        th = move-exception;
        i().c(5, "onSessionBatchEvent failed", new Object[]{th});     // Catch: Throwable -> L21
        this.e.a().ab().a("collectImpression onSessionBatchEvent failed", th);     // Catch: Throwable -> L21
        goto L13
    L15:
        if (r4 != null) goto L39;
    L20:
        a(Constants.LAUNCH_TAG);
        return;
    L39:
        r4.close();     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        i().c(5, "close cursor failed", new Object[]{th});
    L21:
        th = move-exception;
        i().c(5, "collect impression failed", new Object[]{th});     // Catch: Throwable -> L29
        this.e.a().ab().a(StatsCountKeys.COLLECT_IMPRESSION_ERROR_COUNT);     // Catch: Throwable -> L29
        this.e.a().ab().a("collectImpression failed", th);     // Catch: Throwable -> L29
        if (r4 == null) goto L20;
        r4.close();     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        i().c(5, "close cursor failed", new Object[]{th});
    L29:
        th = move-exception;
        if (r4 != null) goto L47;
    L35:
        a(Constants.LAUNCH_TAG);
        throw th;
    L47:
        r4.close();     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        i().c(5, "close cursor failed", new Object[]{th});
        goto L35
    }

    private void a(SQLiteDatabase r11, JSONArray[] r12, long[] r13, int r14) {
        com.bytedance.applog.n.a r0 = this.h[1];
        JSONArray r2 = new JSONArray();
        Cursor r5 = null;
        long r6 = 0;
        r5 = r11.rawQuery(a(r0, 200, r14), null);     // Catch: Throwable -> L14
        int r15 = 0;
    L5:
        if (r5.moveToNext() == false) goto L11;
        if (r15 > 200) goto L11;
        r0.a(r5);     // Catch: Throwable -> L14
        r2.put(r0.m());     // Catch: Throwable -> L14
        if (r0.f1724a <= r6) goto L10;
        r6 = r0.f1724a;     // Catch: Throwable -> L14
    L10:
        r15 = r15 + 1;
    L11:
        if (r5 == null) goto L13;
    L12:
        r5.close();
    L13:
        a(1);
        r12[1] = r2;
        r13[1] = r6;
        return;
    L14:
        th = move-exception;
    L33:
        th = move-exception;
        if (r5 == null) goto L36;
        r5.close();
    L36:
        a(1);
        throw th;
    L16:
        if (ZeusTransformUtils.instanceOf(r0, e.class) == false) goto L20;
        com.bytedance.applog.monitor.v3.e r16 = this.e.a().ab();     // Catch: Throwable -> L33
        StatsCountKeys r1 = StatsCountKeys.QUERY_EVENT_V3_FAILED_COUNT;     // Catch: Throwable -> L33
    L18:
        r16.a(r1);     // Catch: Throwable -> L33
    L25:
        this.e.a().ab().a("queryEventByPriority failed", th);     // Catch: Throwable -> L33
        if (ZeusTransformUtils.instanceOf(th, SQLiteBlobTooBigException.class) == false) goto L28;
        j();     // Catch: Throwable -> L33
    L28:
        i().a(5, "query event failed", th, new Object[0]);     // Catch: Throwable -> L33
        if (r5 == null) goto L13;
    L20:
        if (ZeusTransformUtils.instanceOf(r0, c.class) == false) goto L23;
        r16 = this.e.a().ab();     // Catch: Throwable -> L33
        r1 = StatsCountKeys.QUERY_EVENT_V1_FAILED_COUNT;     // Catch: Throwable -> L33
        goto L18
    L23:
        if (ZeusTransformUtils.instanceOf(r0, d.class) == false) goto L25;
        r16 = this.e.a().ab();     // Catch: Throwable -> L33
        r1 = StatsCountKeys.QUERY_EVENT_MISC_FAILED_COUNT;     // Catch: Throwable -> L33
        goto L18
    }

    private void a(com.bytedance.applog.n.a r2) {
        this.g.put(r2.h(), r2);
    }

    private void a(h r8, SQLiteDatabase r9, int r10) {
        if (r9 == null) goto L35;
        boolean r2 = false;
    L9:
        if (r2 == true) goto L31;
    L11:
        Iterator<h> r3 = b(r8).iterator();     // Catch: Throwable -> L22
    L13:
        if (r3.hasNext() == false) goto L16;
        a(r9, (h) ZeusTransformUtils.preCheckCast(r3.next(), h.class, "com.obric.memorydata.plugin"), false);     // Catch: Throwable -> L22
        goto L13
    L16:
        if (r8.B <= 0) goto L18;
        r9.execSQL(a("eventv3", r8.B, r10));     // Catch: Throwable -> L22
    L18:
        if (r2 == false) goto L20;
        r9.setTransactionSuccessful();     // Catch: Throwable -> L22
    L22:
        th = th;
    L33:
        i().c(5, "delete pack data failed", new Object[]{th});     // Catch: Throwable -> L27
        this.e.a().ab().a(StatsCountKeys.DB_ERROR_COUNT);     // Catch: Throwable -> L27
        this.e.a().ab().a("saveAndDeleteDataFromPriorityPack " + r10 + " failed", th);     // Catch: Throwable -> L27
        if (r2 == false) goto L39;
    L21:
        o.a(r9);
        return;
    L39:
        return;
    L27:
        th = move-exception;
        if (r2 == false) goto L30;
        o.a(r9);
    L30:
        throw th;
    L20:
        if (r2 == true) goto L21;
        return;
    L31:
        r9.beginTransaction();     // Catch: Throwable -> L22
        goto L11
    L35:
        r9 = this.f.getWritableDatabase();     // Catch: Throwable -> L6
        r2 = true;
    L6:
        th = th;
        r2 = false;
        goto L33
    }

    private void a(String r5) {
        if (f1726a == true) goto L6;
        return;
    L6:
        if (this.g.containsKey(r5) == true) goto L8;
        return;
    L8:
        r5.hashCode();
        byte r0 = -1;
        switch(r5.hashCode()) {
            case -1376501097: goto L40;
            case -1109843021: goto L36;
            case -551622883: goto L32;
            case 3432985: goto L28;
            case 3433103: goto L24;
            case 96891546: goto L20;
            case 984152945: goto L16;
            case 2035990113: goto L12;
            default: goto L44;
        };
    L12:
        if (r5.equals("terminate") == false) goto L44;
        r0 = 7;
        goto L44
    L16:
        if (r5.equals("event_misc") == false) goto L44;
        r0 = 6;
        goto L44
    L20:
        if (r5.equals("event") == false) goto L44;
        r0 = 5;
        goto L44
    L24:
        if (r5.equals("page") == false) goto L44;
        r0 = 4;
        goto L44
    L28:
        if (r5.equals("pack") == false) goto L44;
        r0 = 3;
        goto L44
    L32:
        if (r5.equals("forward_eventv3") == false) goto L44;
        r0 = 2;
        goto L44
    L36:
        if (r5.equals(Constants.LAUNCH_TAG) == false) goto L44;
        r0 = 1;
        goto L44
    L40:
        if (r5.equals("eventv3") == false) goto L44;
        r0 = 0;
    L44:
        switch(r0) {
            case 0: goto L54;
            case 1: goto L53;
            case 2: goto L52;
            case 3: goto L50;
            case 4: goto L49;
            case 5: goto L48;
            case 6: goto L47;
            case 7: goto L46;
            default: goto L56;
        };
    L46:
        HashMap<String, com.bytedance.applog.n.a> r4 = this.g;
        com.bytedance.applog.n.a r1 = new j();
    L51:
        r4.put(r5, r1);
        return;
    L47:
        r4 = this.g;
        r1 = new d(null, "", new JSONObject());
        goto L51
    L48:
        r4 = this.g;
        r1 = new c();
        goto L51
    L49:
        r4 = this.g;
        r1 = new i();
        goto L51
    L50:
        r4 = this.g;
        r1 = new h();
        goto L51
    L52:
        r4 = this.g;
        r1 = new f();
        goto L51
    L53:
        r4 = this.g;
        r1 = new g();
        goto L51
    L54:
        r4 = this.g;
        r1 = new e(null, null, false, null);
        goto L51
    }

    private void a(ArrayList<com.bytedance.applog.n.a> r1, ArrayList<g> r2, ArrayList<com.bytedance.applog.n.a> r3, ArrayList<j> r4, SQLiteDatabase r5) {
        r2.clear();
        r3.clear();
        r4.clear();
        b(r1, r2, r3, r4, r5);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        i().a(5, "save db failed", th, new Object[0]);
        this.e.a().ab().a(StatsCountKeys.DB_ERROR_COUNT);
        this.e.a().ab().a("save base data list failed", th);
    }

    private void a(JSONObject r25, g r26, h r27, SQLiteDatabase r28, JSONArray[] r29, long[] r30, HashMap<String, JSONObject> r31, com.bytedance.applog.priority.b r32, int r33) {
        JSONObject r15 = r25;
        g r14 = r26;
        long[] r11 = r30;
        i().c(5, "packCurrentData sid:{}", new Object[]{r14.d});
        com.bytedance.applog.b.d r5 = new com.bytedance.applog.b.d();
        r5.a(r15);
        com.bytedance.applog.b.d r21 = r5;
        int r0 = a(0, r28, r14.d, true, r29, r30, r32, r21);
        boolean r1 = b(r14.d);
        JSONArray r18 = a(r14.d, r31);
        if (r1 == false) goto L5;
    L9:
        String r2 = this.e.a().b();
        if (r1 == false) goto L12;
        g r3 = r14;
    L13:
        SQLiteDatabase r6 = r28;
        h r7 = r27;
        r27.a(r2, r25, r3, null, null, r29, r30, r18, r32, r33);
        boolean r16 = true;
        a(r7, true, r6, r32);
    L15:
        if (r33 == 13) goto L17;
        boolean r13 = r16;
    L18:
        i().e(5, "packCurrentData isPackAllData = " + r13, new Object[0]);
        int r4 = r0;
    L20:
        if (r4 >= this.h.length) goto L27;
        if (r13 == false) goto L32;
        com.bytedance.applog.b.d r12 = r21;
        r12.a(r15);
        h r17 = r7;
        SQLiteDatabase r10 = r6;
        r4 = a(r4, r28, r14.d, true, r29, r30, r32, r12);
        if (a(r11) == false) goto L25;
        SQLiteDatabase r8 = r10;
        h r9 = r17;
        boolean r19 = true;
        r27.a(this.e.a().b(), r25, null, null, null, r29, r30, null, r32, r33);
        com.bytedance.applog.priority.b r20 = r32;
        a(r9, true, r8, r20);
    L26:
        r11 = r30;
        r21 = r12;
        r13 = r13;
        r15 = r25;
        r14 = r26;
        h r23 = r9;
        r6 = r8;
        r7 = r23;
        goto L20
    L25:
        r20 = r32;
        r8 = r10;
        r9 = r17;
        r19 = true;
        goto L26
    L32:
        return;
    L27:
        return;
    L17:
        r13 = false;
        goto L18
    L12:
        r3 = null;
        goto L13
    L5:
        if (a(r11) == true) goto L9;
        if (r18 != null) goto L9;
        r6 = r28;
        r7 = r27;
        r16 = true;
        goto L15
    }

    private void a(JSONObject r23, g r24, h r25, i r26, j r27, SQLiteDatabase r28, JSONArray[] r29, long[] r30, HashMap<String, JSONObject> r31, com.bytedance.applog.priority.b r32, int r33) {
        boolean r16 = false;
        i().c(5, "packHistoryData sid:{}", new Object[]{r24.d});
        com.bytedance.applog.b.d r7 = new com.bytedance.applog.b.d();
        r7.a(r23);
        com.bytedance.applog.b.d r21 = r7;
        int r8 = a(0, r28, r24.d, true, r29, r30, r32, r21);
        JSONArray r0 = a(r24, true, r27, r26, r28, r32, a(r30));
        if (r0.length() <= 0) goto L5;
        boolean r1 = true;
    L6:
        r24.x = !r1;
        JSONArray r18 = a(r24.d, r31);
        if (r24.x == true) goto L9;
        JSONObject r2 = r23;
        com.bytedance.applog.priority.b r9 = r32;
        long[] r6 = r30;
        SQLiteDatabase r5 = r28;
        h r4 = r25;
        g r3 = r24;
        boolean r10 = true;
        r25.a(this.e.a().b(), r23, null, r27, r0, r29, r30, r18, r32, r33);
    L21:
        r16 = r10;
    L22:
        if (r16 == false) goto L25;
        a(r4, r10, r5, r9);
    L25:
        if (r8 >= this.h.length) goto L31;
        com.bytedance.applog.b.d r15 = r21;
        r15.a(r2);
        boolean r14 = r10;
        h r13 = r4;
        SQLiteDatabase r12 = r5;
        com.bytedance.applog.priority.b r11 = r9;
        r8 = a(r8, r28, r3.d, true, r29, r30, r32, r15);
        if (a(r6) == false) goto L29;
        com.bytedance.applog.priority.b r17 = r11;
        SQLiteDatabase r19 = r12;
        h r20 = r13;
        boolean r22 = r14;
        r25.a(this.e.a().b(), r23, null, null, null, r29, r30, null, r32, r33);
        a(r20, r22, r19, r17);
    L30:
        r3 = r24;
        r6 = r30;
        r21 = r15;
        r9 = r17;
        r4 = r20;
        r5 = r19;
        r10 = r22;
        r2 = r23;
        goto L25
    L29:
        r17 = r11;
        r19 = r12;
        r20 = r13;
        r22 = r14;
        goto L30
    L31:
        return;
    L9:
        if (b(r24.d) == false) goto L12;
        r9 = r32;
        r6 = r30;
        r5 = r28;
        r4 = r25;
        r3 = r24;
        r2 = r23;
        boolean r34 = true;
        r25.a(this.e.a().b(), r23, r24, null, null, r29, r30, r18, r32, r33);
    L11:
        r10 = r34;
        goto L21
    L12:
        r2 = r23;
        r9 = r32;
        r6 = r30;
        r5 = r28;
        r4 = r25;
        r3 = r24;
        r34 = true;
        if (a(r6) == true) goto L19;
        if (r18 != null) goto L16;
    L18:
        r10 = true;
        goto L22
    L16:
        if (r18.length() <= 0) goto L18;
    L19:
        r25.a(this.e.a().b(), r23, null, null, null, r29, r30, r18, r32, r33);
        goto L11
    L5:
        r1 = false;
        goto L6
    }

    private void a(JSONObject r23, g r24, j r25, i r26, h r27, SQLiteDatabase r28, String r29, JSONArray[] r30, long[] r31, com.bytedance.applog.priority.b r32, int r33) {
        JSONObject r15 = r23;
        long[] r11 = r31;
        i().c(5, "packLostData exclude sid:{}", new Object[]{r29});
        r24.d = r29;
        r27.d = r29;
        com.bytedance.applog.b.d r5 = new com.bytedance.applog.b.d();
        r5.a(r15);
        com.bytedance.applog.b.d r21 = r5;
        int r8 = a(0, r28, r29, false, r30, r31, r32, r21);
        JSONArray r0 = a(r24, false, r25, r26, r28, r32, a(r11));
        if (r0.length() <= 0) goto L5;
        boolean r7 = true;
    L6:
        r24.x = !r7;
        if (a(r11) == false) goto L9;
    L12:
        String r1 = this.e.a().b();
        JSONArray r4 = null;
        if (r24.x == true) goto L15;
        j r3 = r25;
    L17:
        if (r24.x == true) goto L19;
        r4 = r0;
    L19:
        SQLiteDatabase r6 = r28;
        h r9 = r27;
        r27.a(r1, r23, null, r3, r4, r30, r31, null, r32, r33);
        com.bytedance.applog.priority.b r16 = r32;
        boolean r14 = false;
        a(r9, false, r6, r16);
    L20:
        int r2 = r8;
    L22:
        if (r2 >= this.h.length) goto L28;
        com.bytedance.applog.b.d r13 = r21;
        r13.a(r15);
        h r12 = r9;
        SQLiteDatabase r17 = r6;
        r2 = a(r2, r28, r29, false, r30, r31, r32, r13);
        if (a(r11) == false) goto L26;
        SQLiteDatabase r10 = r17;
        h r18 = r12;
        boolean r19 = r14;
        com.bytedance.applog.priority.b r20 = r16;
        r27.a(this.e.a().b(), r23, null, null, null, r30, r31, null, r32, r33);
        a(r18, r19, r10, r20);
    L27:
        r11 = r31;
        r14 = r19;
        r16 = r20;
        r21 = r13;
        r15 = r23;
        r6 = r10;
        r9 = r18;
        goto L22
    L26:
        r10 = r17;
        r18 = r12;
        r19 = r14;
        r20 = r16;
        goto L27
    L28:
        return;
    L15:
        r3 = null;
        goto L17
    L9:
        if (r24.x == false) goto L12;
        r6 = r28;
        r9 = r27;
        r14 = false;
        r16 = r32;
        goto L20
    L5:
        r7 = false;
        goto L6
    }

    private boolean a(long[] r7) {
        if (r7[0] > 0) goto L9;
        if (r7[1] > 0) goto L9;
        if (r7[2] > 0) goto L9;
        return false;
    L9:
        return true;
    }

    static /* synthetic */ com.bytedance.applog.log.j b(b r0) {
        return r0.i();
    }

    private String b(int r2) {
        return "SELECT * FROM launch ORDER BY _id DESC LIMIT " + r2;
    }

    private String b(int r4, com.bytedance.applog.priority.b r5) {
        StringBuilder r3 = new StringBuilder("SELECT * FROM pack");
        if (r5 == null) goto L9;
        int r0 = r5.a();
        if ((-1) != r0) goto L7;
        StringBuilder r6 = new StringBuilder().append(" WHERE priority=").append(r0).append(" OR ").append("priority").append(">").append(r5.b());
    L8:
        r3.append(r6.toString());
        goto L9
    L7:
        r6 = new StringBuilder().append(" WHERE priority=").append(r0);
    L9:
        r3.append(" ORDER BY _id DESC LIMIT " + r4);
        return r3.toString();
    }

    private String b(String r2, boolean r3) {
        StringBuilder r1 = new StringBuilder().append("DELETE FROM page WHERE session_id");
        if (r3 == false) goto L5;
        String r4 = "='";
    L7:
        return r1.append(r4).append(r2).append("'").toString();
    L5:
        r4 = "!='";
        goto L7
    }

    private List<h> b(h r7) {
        ArrayList r0 = new ArrayList();
        if (this.e.a().S() == true) goto L5;
    L9:
        r0.add(r7);
    L11:
        if (this.e.m().C() == false) goto L17;
        ArrayList r8 = new ArrayList();
        Iterator r1 = r0.iterator();
    L14:
        if (r1.hasNext() == false) goto L16;
        r8.addAll(((h) ZeusTransformUtils.preCheckCast(r1.next(), h.class, "com.obric.memorydata.plugin")).c(this.e.m().B()));
        goto L14
    L16:
        return r8;
    L17:
        return r0;
    L5:
        if (this.e.a().T() == null) goto L9;
        Collection<h> r2 = r7.a(this.e.a().T());
        if (r2 == null) goto L9;
        i().c(5, "Pack split to {} packs for data isolate: {}", new Object[]{Integer.valueOf(r2.size()), this.e.a().T()});
        r0.addAll(r2);
        goto L11
    }

    private void b(ArrayList<com.bytedance.applog.n.a> r17) {
        if (r17 != null) goto L5;
        return;
    L5:
        ArrayList<g> r9 = new ArrayList(4);
        ArrayList<com.bytedance.applog.n.a> r10 = new ArrayList(4);
        ArrayList<j> r11 = new ArrayList(4);
        boolean r12 = this.k;
        SQLiteDatabase r15 = this.f.getWritableDatabase();     // Catch: Throwable -> L27
        if (r12 == true) goto L55;
    L9:
        b(r17, r9, r10, r11, r15);     // Catch: Throwable -> L25
        if (r12 == false) goto L13;
        r15.setTransactionSuccessful();     // Catch: Throwable -> L25
        boolean r1 = true;
    L53:
    L23:
        th = th;
    L30:
        if (r12 == false) goto L33;
        if (r1 == true) goto L33;
        o.a(r15);     // Catch: Throwable -> L49
        a(r17, r9, r10, r11, r15);     // Catch: Throwable -> L49
    L49:
        th = move-exception;
        if (r12 == false) goto L52;
        o.a(r15);
    L52:
        throw th;
    L33:
        i().a(5, "save db failed", th, new Object[0]);     // Catch: Throwable -> L49
        this.e.a().ab().a(StatsCountKeys.DB_ERROR_COUNT);     // Catch: Throwable -> L49
        this.e.a().ab().a("save base data list failed", th);     // Catch: Throwable -> L49
        if (r12 == true) goto L22;
    L36:
        a(r10);
        Iterator<g> r0 = r9.iterator();     // Catch: Throwable -> L46
    L39:
        if (r0.hasNext() == false) goto L41;
        g r2 = (g) ZeusTransformUtils.preCheckCast(r0.next(), g.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L46
        this.e.a().as().a(r2.f1724a, r2.d);     // Catch: Throwable -> L46
        goto L39
    L41:
        Iterator<j> r3 = r11.iterator();     // Catch: Throwable -> L46
    L42:
        if (r3.hasNext() == false) goto L67;
        j r4 = (j) ZeusTransformUtils.preCheckCast(r3.next(), j.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L46
        this.e.a().as().a(r4.f1724a, r4.d, r4.m());     // Catch: Throwable -> L46
        goto L42
    L67:
        return;
    L46:
        th = move-exception;
        i().a(5, "onSessionStart failed", th, new Object[0]);
        this.e.a().ab().a("notify onSessionStart or onSessionTerminate failed", th);
        return;
    L22:
        o.a(r15);
        goto L36
    L15:
        if (p.a() == true) goto L21;
        Iterator<com.bytedance.applog.n.a> r5 = r17.iterator();     // Catch: Throwable -> L23
    L18:
        if (r5.hasNext() == false) goto L21;
        p.a("event_save_db", (com.bytedance.applog.n.a) ZeusTransformUtils.preCheckCast(r5.next(), com.bytedance.applog.n.a.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L23
    L21:
        if (r12 == false) goto L36;
    L25:
        th = th;
    L29:
        r1 = false;
        goto L30
    L13:
        r1 = false;
        goto L53
    L55:
        r15.beginTransaction();     // Catch: Throwable -> L25
    L27:
        th = th;
        r15 = null;
        goto L29
    }

    private void b(ArrayList<com.bytedance.applog.n.a> r10, ArrayList<g> r11, ArrayList<com.bytedance.applog.n.a> r12, ArrayList<j> r13, SQLiteDatabase r14) {
        Iterator<com.bytedance.applog.n.a> r15 = r10.iterator();
        ContentValues r1 = null;
    L4:
        if (r15.hasNext() == false) goto L54;
        com.bytedance.applog.n.a r2 = (com.bytedance.applog.n.a) ZeusTransformUtils.preCheckCast(r15.next(), com.bytedance.applog.n.a.class, "com.obric.memorydata.plugin");
        if (TextUtils.isEmpty(r2.m) == false) goto L9;
        r2.a(this.e.a().b());
    L9:
        if (r2.s <= 0) goto L11;
        com.bytedance.applog.monitor.b.a(this.e.a().ab(), EventStage.DB_INSERT_START, r2);
    L11:
        String r3 = r2.h();
        r1 = r2.b(r1);
        r2.f1724a = r14.insert(r3, null, r1);
        if (r2.f1724a < 0) goto L14;
        boolean r4 = true;
    L16:
        if (r2.s <= 0) goto L22;
        com.bytedance.applog.monitor.v3.e r5 = this.e.a().ab();
        if (r4 == false) goto L20;
        EventStage r6 = EventStage.DB_SAVE_END;
    L21:
        com.bytedance.applog.monitor.b.a(r5, r6, r2);
        goto L22
    L20:
        r6 = EventStage.DB_SAVE_FAILED;
    L22:
        if (r4 == true) goto L25;
        this.e.a().ab().a(StatsCountKeys.DB_ERROR_COUNT);
    L25:
        if (ZeusTransformUtils.instanceOf(r2, c.class) == true) goto L26;
        if (ZeusTransformUtils.instanceOf(r2, e.class) == true) goto L32;
        if (ZeusTransformUtils.instanceOf(r2, d.class) == true) goto L37;
        if (ZeusTransformUtils.instanceOf(r2, g.class) == true) goto L42;
        if (ZeusTransformUtils.instanceOf(r2, j.class) == true) goto L47;
        if (ZeusTransformUtils.instanceOf(r2, i.class) == false) goto L4;
        if (r4 == true) goto L4;
        com.bytedance.applog.monitor.v3.e r7 = this.e.a().ab();
        StatsCountKeys r8 = StatsCountKeys.INSERT_PAGE_FAILED_COUNT;
    L29:
        r7.a(r8);
        goto L4
    L47:
        r13.add((j) ZeusTransformUtils.preCheckCast(r2, j.class, "com.obric.memorydata.plugin"));
        if (r4 == true) goto L4;
    L44:
        r7 = this.e.a().ab();
        r8 = StatsCountKeys.INSERT_SESSION_FAILED_COUNT;
        goto L29
    L42:
        r11.add((g) ZeusTransformUtils.preCheckCast(r2, g.class, "com.obric.memorydata.plugin"));
        if (r4 == true) goto L4;
    L37:
        r12.add(r2);
        if (r4 == true) goto L4;
        r7 = this.e.a().ab();
        r8 = StatsCountKeys.INSERT_EVENT_MISC_FAILED_COUNT;
        goto L29
    L32:
        r12.add(r2);
        if (r4 == true) goto L4;
        r7 = this.e.a().ab();
        r8 = StatsCountKeys.INSERT_EVENT_V3_FAILED_COUNT;
        goto L29
    L26:
        r12.add(r2);
        if (r4 == true) goto L4;
        r7 = this.e.a().ab();
        r8 = StatsCountKeys.INSERT_EVENT_V1_FAILED_COUNT;
        goto L29
    L14:
        r4 = false;
        goto L16
    }

    private boolean b(String r6) {
        if (this.l.contains(r6) == true) goto L5;
        this.l.add(r6);
        boolean r0 = true;
    L6:
        i().c(5, "session id:{} needLaunch:{}", new Object[]{r6, Boolean.valueOf(r0)});
        return r0;
    L5:
        r0 = false;
        goto L6
    }

    static /* synthetic */ com.bytedance.applog.e.c c(b r0) {
        return r0.e;
    }

    private com.bytedance.applog.log.j i() {
        return this.e.a().aA();
    }

    private void j() {
        Field r0 = CursorWindow.class.getDeclaredField("sCursorWindowSize");     // Catch: Throwable -> L8
        r0.setAccessible(true);     // Catch: Throwable -> L8
        int r2 = r0.getInt(null);     // Catch: Throwable -> L8
        if (r2 > 0) goto L5;
        return;
    L5:
        if (r2 > 8388608) goto L14;
        r0.setInt(null, r2 * 2);     // Catch: Throwable -> L8
        return;
    L14:
        return;
    L8:
        th = move-exception;
        i().a(5, "tryIncreaseCursorWindowSize", th, new Object[0]);
    }

    private Handler k() {
        if (this.i != null) goto L8;
        if (Looper.myLooper() == null) goto L8;
        this.i = new a(this, Looper.myLooper());
    L8:
        return this.i;
    }

    private void l() {
        if (this.j == false) goto L6;
        a(null);
        return;
    }

    public int a() {
        return this.m;
    }

    public long a(h r5) {
        long r0 = this.f.getWritableDatabase().insert("pack", null, r5.b(null));
        if (r0 >= 0) goto L5;
        this.e.a().ab().a(StatsCountKeys.INSERT_PACK_FAILED_COUNT);
    L5:
        return r0;
    }

    public ArrayList<h> a(int r7, com.bytedance.applog.priority.b r8) {
        h r1 = (h) ZeusTransformUtils.preCheckCast(this.g.get("pack"), h.class, "com.obric.memorydata.plugin");
        Cursor r3 = null;
        r3 = this.f.getWritableDatabase().rawQuery(b(r7, r8), null);     // Catch: Throwable -> L12
        ArrayList<h> r9 = new ArrayList();     // Catch: Throwable -> L12
    L5:
        if (r3.moveToNext() == false) goto L8;
        r1 = (h) ZeusTransformUtils.preCheckCast(r1.n(), h.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L12
        r1.a(r3);     // Catch: Throwable -> L12
        r9.add(r1);     // Catch: Throwable -> L12
        goto L5
    L8:
        if (r3 == null) goto L10;
        r3.close();
    L10:
        a("pack");
        return r9;
    L12:
        th = move-exception;
        boolean r10 = ZeusTransformUtils.instanceOf(th, SQLiteBlobTooBigException.class);     // Catch: Throwable -> L21
        i().a(5, "query pack failed", th, new Object[0]);     // Catch: Throwable -> L21
        this.e.a().ab().a(StatsCountKeys.DB_ERROR_COUNT);     // Catch: Throwable -> L21
        this.e.a().ab().a("query pack failed", th);     // Catch: Throwable -> L21
        if (r3 == null) goto L16;
        r3.close();
    L16:
        a("pack");
        if (r10 == false) goto L20;
        j();
    L20:
        return new ArrayList();
    L21:
        th = move-exception;
        if (r3 == null) goto L24;
        r3.close();
    L24:
        a("pack");
        throw th;
    }

    public void a(h r17, boolean r18, SQLiteDatabase r19, com.bytedance.applog.priority.b r20) {
        if (r19 == null) goto L37;
        SQLiteDatabase r11 = r19;
        boolean r12 = false;
    L9:
        if (r12 == true) goto L39;
    L11:
        Iterator<h> r1 = b(r17).iterator();     // Catch: Throwable -> L28
    L13:
        if (r1.hasNext() == false) goto L16;
        a(r11, (h) ZeusTransformUtils.preCheckCast(r1.next(), h.class, "com.obric.memorydata.plugin"), r18);     // Catch: Throwable -> L28
        goto L13
    L16:
        if (r17.z <= 0) goto L19;
        r11.execSQL(a("event", r17.d, r18, r17.z, r20));     // Catch: Throwable -> L28
    L19:
        if (r17.B <= 0) goto L22;
        r11.execSQL(a("eventv3", r17.d, r18, r17.B, r20));     // Catch: Throwable -> L28
    L22:
        if (r17.G <= 0) goto L24;
        r11.execSQL(a("event_misc", r17.d, r18, r17.G, r20));     // Catch: Throwable -> L28
    L24:
        if (r12 == false) goto L26;
        r11.setTransactionSuccessful();     // Catch: Throwable -> L28
    L28:
        th = th;
    L41:
        i().c(5, "delete pack data failed", new Object[]{th});     // Catch: Throwable -> L33
        this.e.a().ab().a(StatsCountKeys.DB_ERROR_COUNT);     // Catch: Throwable -> L33
        this.e.a().ab().a("saveAndDeleteDataFromPack failed", th);     // Catch: Throwable -> L33
        if (r12 == false) goto L45;
    L27:
        o.a(r11);
        return;
    L45:
        return;
    L33:
        th = move-exception;
        if (r12 == false) goto L36;
        o.a(r11);
    L36:
        throw th;
    L26:
        if (r12 == true) goto L27;
        return;
    L39:
        r11.beginTransaction();     // Catch: Throwable -> L28
        goto L11
    L37:
        r11 = this.f.getWritableDatabase();     // Catch: Throwable -> L6
        r12 = true;
    L6:
        th = th;
        r11 = r19;
        r12 = false;
        goto L41
    }

    public void a(ArrayList<com.bytedance.applog.n.a> r2) {
        a(r2, true);
    }

    public synchronized void a(ArrayList<com.bytedance.applog.n.a> r5, boolean r6) {
        monitor-enter(this);
    L37:
        th = move-exception;
        throw th;
    L4:
        if (this.j == true) goto L9;
        b(r5);     // Catch: Throwable -> L37
        monitor-exit(this);
        return;
    L9:
        if (r5 != null) goto L11;
        int r1 = 0;
    L13:
        int r2 = this.d.size() + r1;
        if (r2 != 0) goto L18;
        monitor-exit(this);
        return;
    L18:
        if (r6 == false) goto L20;
    L28:
        ArrayList<com.bytedance.applog.n.a> r7 = new ArrayList(this.d);     // Catch: Throwable -> L37
        this.d.clear();     // Catch: Throwable -> L37
        if (r1 <= 0) goto L32;
        r7.addAll(r5);     // Catch: Throwable -> L37
    L32:
        if (k() == null) goto L34;
        k().removeCallbacksAndMessages(null);     // Catch: Throwable -> L37
    L34:
        b(r7);     // Catch: Throwable -> L37
    L35:
        monitor-exit(this);
        return;
    L20:
        if (r2 >= this.e.a().ao()) goto L28;
        this.d.addAll(r5);     // Catch: Throwable -> L37
        if (k() != null) goto L26;
        a(null, true);     // Catch: Throwable -> L37
        goto L35
    L26:
        if (k().hasMessages(0) == true) goto L35;
        k().sendEmptyMessageDelayed(0, this.e.a().an());     // Catch: Throwable -> L37
        goto L35
    L11:
        r1 = r5.size();     // Catch: Throwable -> L37
        goto L13
    }

    public void a(List<com.bytedance.applog.n.a> r15) {
        List r16 = (List) ZeusTransformUtils.wrapperContextForParams(r15, List.class, "com.obric.memorydata.plugin");
        if (this.e.a().at().a(0) == false) goto L5;
        return;
    L5:
        Iterator r17 = r16.iterator();
    L7:
        if (r17.hasNext() == false) goto L21;
        com.bytedance.applog.n.a r0 = (com.bytedance.applog.n.a) ZeusTransformUtils.preCheckCast(r17.next(), com.bytedance.applog.n.a.class, "com.obric.memorydata.plugin");
        if ("event".equals(r0.h()) == true) goto L11;
        if ("eventv3".equals(r0.h()) == true) goto L14;
        if ("event_misc".equals(r0.h()) == false) goto L7;
        d r1 = (d) ZeusTransformUtils.preCheckCast(r0, d.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L19
        this.e.a().at().b(0, r1.t(), r1.p());     // Catch: Throwable -> L19
        goto L7
    L14:
        e r2 = (e) ZeusTransformUtils.preCheckCast(r0, e.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L19
        this.e.a().at().a(0, r2.u(), r2.p());     // Catch: Throwable -> L19
        goto L7
    L11:
        c r3 = (c) ZeusTransformUtils.preCheckCast(r0, c.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L19
        this.e.a().at().a(0, r3.v, r3.w, r3.x, r3.z, r3.A, r3.y);     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        i().a(5, "notify event observer before store failed", th, new Object[0]);
        this.e.a().ab().a("notify event observer failed", th);
        goto L7
    }

    public synchronized void a(JSONObject r18, com.bytedance.applog.priority.b r19, int r20) {
        monitor-enter(this);
        l();     // Catch: Throwable -> L23
        SQLiteDatabase r2 = null;
        JSONArray[] r14 = new JSONArray[3];     // Catch: Throwable -> L15
        long[] r0 = new long[3];     // Catch: Throwable -> L15
        r2 = this.f.getWritableDatabase();     // Catch: Throwable -> L15
        r2.beginTransaction();     // Catch: Throwable -> L15
        int r15 = 200;
        int r3 = 200;
    L7:
        if (r3 < r15) goto L12;
        a(r2, r14, r0, r19.a());     // Catch: Throwable -> L15
        int r16 = r14[1].length();     // Catch: Throwable -> L15
        if (r16 == 0) goto L12;
        h r13 = new h();     // Catch: Throwable -> L15
        r13.a(this.e.a().b(), r18, null, null, null, r14, r0, null, r19, r20);     // Catch: Throwable -> L15
        a(r13, r2, r19.a());     // Catch: Throwable -> L15
        r3 = r16;
        r15 = 200;
    L12:
        r2.setTransactionSuccessful();     // Catch: Throwable -> L15
    L13:
        o.a(r2);     // Catch: Throwable -> L23
        monitor-exit(this);
        return;
    L15:
        th = move-exception;
        this.e.a().ab().a(StatsCountKeys.PACK_ERROR_COUNT);     // Catch: Throwable -> L20
        this.e.a().ab().a("packByPriority failed", th);     // Catch: Throwable -> L20
        i().a(5, "pack by priority failed", th, new Object[0]);     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        o.a(r2);     // Catch: Throwable -> L23
        throw th;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public synchronized void a(JSONObject r28, com.bytedance.applog.priority.b r29, int r30, boolean r31) {
        monitor-enter(this);
        l();     // Catch: Throwable -> L117
        g r0 = (g) ZeusTransformUtils.preCheckCast(this.g.get(Constants.LAUNCH_TAG), g.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L117
        j r14 = (j) ZeusTransformUtils.preCheckCast(this.g.get("terminate"), j.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L117
        i r15 = (i) ZeusTransformUtils.preCheckCast(this.g.get("page"), i.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L117
        h r12 = (h) ZeusTransformUtils.preCheckCast(this.g.get("pack"), h.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L117
        SQLiteDatabase r2 = null;
        int r11 = 0;
        JSONArray[] r9 = new JSONArray[3];     // Catch: Throwable -> L94
        long[] r8 = new long[3];     // Catch: Throwable -> L94
        HashMap<String, JSONObject> r7 = new HashMap();     // Catch: Throwable -> L94
        i().c(5, "DbStore pack before collect impression.", new Object[0]);     // Catch: Throwable -> L94
        SQLiteDatabase r6 = this.f.getWritableDatabase();     // Catch: Throwable -> L94
        a(r6, r7);     // Catch: Throwable -> L91
        i().c(5, "DbStore pack after collect impression.", new Object[0]);     // Catch: Throwable -> L91
        r6.beginTransaction();     // Catch: Throwable -> L91
        Cursor r5 = r6.rawQuery(b(5), null);     // Catch: Throwable -> L91
        com.bytedance.applog.e.f r1 = this.e.b();     // Catch: Throwable -> L89
        String r4 = r1.c();     // Catch: Throwable -> L89
        boolean r16 = r1.f();     // Catch: Throwable -> L89
        ArrayList r3 = new ArrayList();     // Catch: Throwable -> L89
        if (r31 == true) goto L126;
        boolean r10 = r5.moveToLast();     // Catch: Throwable -> L89
    L15:
        JSONObject r13 = r28;
    L16:
        boolean r17 = 1;
        if (r10 == false) goto L45;
        r0.a(r5);     // Catch: Throwable -> L41
        r12.d = r0.d;     // Catch: Throwable -> L41
        JSONObject r18 = a(r0, r28);     // Catch: Throwable -> L41
        if (TextUtils.equals(r0.d, r4) == false) goto L29;
        if (r16 == false) goto L23;
        r17 = r11;
    L23:
        r0.x = r17;     // Catch: Throwable -> L41
        ArrayList r19 = r3;
        Cursor r20 = r5;
        SQLiteDatabase r21 = r6;
        HashMap<String, JSONObject> r22 = r7;
        long[] r23 = r8;
        JSONArray[] r24 = r9;
        a(r18, r0, r12, r6, r9, r8, r22, r29, r30);     // Catch: Throwable -> L27
        ArrayList r110 = r19;
        int r111 = 0;
    L33:
        if (r31 == true) goto L141;
        r10 = r20.moveToPrevious();     // Catch: Throwable -> L37
    L36:
        r11 = r111;
        r3 = r110;
        r13 = r18;
        r4 = r4;
        r5 = r20;
        r6 = r21;
        r7 = r22;
        r8 = r23;
        r9 = r24;
        r15 = r15;
        r12 = r12;
        goto L16
    L141:
        r10 = r20.moveToNext();     // Catch: Throwable -> L37
    L37:
        th = th;
    L43:
        r2 = r21;
    L44:
        int r112 = 5;
    L153:
        this.e.a().ab().a(StatsCountKeys.PACK_ERROR_COUNT);     // Catch: Throwable -> L107
        this.e.a().ab().a("pack failed", th);     // Catch: Throwable -> L107
        i().a(r112, "pack failed", th, new Object[r111]);     // Catch: Throwable -> L107
        if (r20 != null) goto L143;
    L103:
        o.a(r2);     // Catch: Throwable -> L117
        a(Constants.LAUNCH_TAG);     // Catch: Throwable -> L117
        a("terminate");     // Catch: Throwable -> L117
        a("page");     // Catch: Throwable -> L117
        String r25 = "pack";
    L80:
        a(r25);     // Catch: Throwable -> L117
        monitor-exit(this);
        return;
    L143:
        r20.close();     // Catch: Throwable -> L100
    L100:
        th = move-exception;
        i().a(r112, "close cursor failed", th, new Object[r111]);     // Catch: Throwable -> L117
        goto L103
    L107:
        th = move-exception;
        if (r20 != null) goto L122;
    L115:
        o.a(r2);     // Catch: Throwable -> L117
        a(Constants.LAUNCH_TAG);     // Catch: Throwable -> L117
        a("terminate");     // Catch: Throwable -> L117
        a("page");     // Catch: Throwable -> L117
        a("pack");     // Catch: Throwable -> L117
        throw th;     // Catch: Throwable -> L117
    L122:
        r20.close();     // Catch: Throwable -> L112
    L112:
        th = move-exception;
        i().a(r112, "close cursor failed", th, new Object[r111]);     // Catch: Throwable -> L117
    L27:
        th = th;
        r2 = r21;
        r112 = 5;
        r111 = 0;
        goto L153
    L29:
        ArrayList r113 = r3;
        r20 = r5;
        r21 = r6;
        r22 = r7;
        r23 = r8;
        r24 = r9;
        r113.add(Long.valueOf(r0.f1724a));     // Catch: Throwable -> L39
        i r26 = r15;
        r110 = r113;
        r111 = 0;
        a(r18, r0, r12, r26, r14, r21, r24, r23, r22, r29, r30);     // Catch: Throwable -> L37
    L39:
        th = th;
        r111 = 0;
    L41:
        th = th;
        r20 = r5;
        r21 = r6;
        r111 = r11;
        goto L43
    L45:
        ArrayList r114 = r3;
        String r115 = r4;
        r20 = r5;
        SQLiteDatabase r27 = r6;
        long[] r210 = r8;
        JSONArray[] r211 = r9;
        h r212 = r12;
        i r213 = r15;
        r111 = r11;
        if (r114.isEmpty() == false) goto L134;
    L60:
        SQLiteDatabase r116 = r27;
        if (r20.getCount() < 5) goto L124;
    L71:
        r112 = 5;
        SQLiteDatabase r117 = r116;
    L72:
        r117.setTransactionSuccessful();     // Catch: Throwable -> L82
        com.bytedance.applog.l.b.a(this.e.a());     // Catch: Throwable -> L82
        if (r20 != null) goto L155;
    L79:
        o.a(r117);     // Catch: Throwable -> L117
        a(Constants.LAUNCH_TAG);     // Catch: Throwable -> L117
        a("terminate");     // Catch: Throwable -> L117
        a("page");     // Catch: Throwable -> L117
        r25 = "pack";
        goto L80
    L155:
        r20.close();     // Catch: Throwable -> L76
    L76:
        th = move-exception;
        i().a(r112, "close cursor failed", th, new Object[r111]);     // Catch: Throwable -> L117
    L82:
        th = th;
    L93:
        r2 = r117;
        goto L153
    L124:
    L69:
        th = th;
        r112 = 5;
        r117 = r116;
        goto L93
    L65:
        if (TextUtils.isEmpty(r115) == true) goto L71;
        r112 = 5;
        r117 = r116;
        a(r13, (g) ZeusTransformUtils.preCheckCast(r0.n(), g.class, "com.obric.memorydata.plugin"), r14, r213, r212, r116, r115, r211, r210, r29, r30);     // Catch: Throwable -> L82
    L84:
        th = th;
        r117 = r116;
    L88:
        r112 = 5;
        goto L93
    L134:
        Iterator r32 = r114.iterator();     // Catch: Throwable -> L57
    L50:
        if (r32.hasNext() == false) goto L60;
        String[] r33 = new String[1];     // Catch: Throwable -> L57
        r33[r111] = String.valueOf((Long) ZeusTransformUtils.preCheckCast(r32.next(), Long.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L57
        SQLiteDatabase r118 = r27;
        r118.execSQL("DELETE FROM launch WHERE _id=?", r33);     // Catch: Throwable -> L55
        r27 = r118;
    L55:
        th = th;
    L59:
        r2 = r118;
    L57:
        th = th;
        r118 = r27;
    L86:
        th = th;
        r117 = r27;
        goto L88
    L126:
        r10 = r5.moveToFirst();     // Catch: Throwable -> L12
    L12:
        th = th;
        r20 = r5;
        r2 = r6;
        r112 = 5;
        r111 = 0;
    L89:
        th = th;
        r20 = r5;
        r117 = r6;
        r112 = 5;
        r111 = 0;
    L91:
        th = th;
        r117 = r6;
        r112 = 5;
        r111 = 0;
        r20 = null;
    L94:
        th = th;
        r112 = 5;
        r111 = 0;
        r20 = null;
    L117:
        th = move-exception;
        throw th;
    }

    public synchronized void a(boolean r3) {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.j != true) goto L7;
        if (r3 == true) goto L7;
        a(null);     // Catch: Throwable -> L10
    L7:
        this.j = r3;     // Catch: Throwable -> L10
        monitor-exit(this);
    }

    public int b() {
        return this.n;
    }

    public void b(List<f> r7) {
        Iterator r8 = ((List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin")).iterator();
        long r2 = 0;
    L4:
        if (r8.hasNext() == false) goto L14;
        f r0 = (f) ZeusTransformUtils.preCheckCast(r8.next(), f.class, "com.obric.memorydata.plugin");
        if (r0.f1724a <= r2) goto L4;
        r2 = r0.f1724a;
        goto L4
    L14:
        this.f.getWritableDatabase().delete("forward_eventv3", "_id <= ?", new String[]{String.valueOf(r2)});     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        i().a(5, "delete forward events failed", th, new Object[0]);
        this.e.a().ab().a("deleteForwardEvents failed", th);
    }

    public void b(boolean r1) {
        this.k = r1;
    }

    public int c() {
        return this.o;
    }

    public int d() {
        return this.p;
    }

    public int e() {
        return this.f.a();
    }

    public synchronized List<f> f() {
        monitor-enter(this);
        l();     // Catch: Throwable -> L20
        ArrayList r0 = new ArrayList();     // Catch: Throwable -> L20
        Cursor r1 = null;
        r1 = this.f.getWritableDatabase().rawQuery("SELECT * FROM forward_eventv3 ORDER BY _id ASC LIMIT 1000", null);     // Catch: Throwable -> L12
    L7:
        if (r1.moveToNext() == false) goto L10;
        f r2 = new f();     // Catch: Throwable -> L12
        r2.a(r1);     // Catch: Throwable -> L12
        r0.add(r2);     // Catch: Throwable -> L12
    L10:
        o.a(r1);     // Catch: Throwable -> L20
        monitor-exit(this);
        return r0;
    L12:
        th = move-exception;
        i().a(5, "pack forward events failed", th, new Object[0]);     // Catch: Throwable -> L17
        this.e.a().ab().a("queryForwardEvents failed", th);     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        o.a(r1);     // Catch: Throwable -> L20
        throw th;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        throw th;
    }

    public void g() {
        if (this.j == false) goto L31;
        monitor-enter(this);
        this.d.clear();     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    L31:
        SQLiteDatabase r1 = this.f.getWritableDatabase();     // Catch: Throwable -> L21
        r1.beginTransaction();     // Catch: Throwable -> L19
        Iterator<com.bytedance.applog.n.a> r2 = this.g.values().iterator();     // Catch: Throwable -> L19
    L15:
        if (r2.hasNext() == false) goto L17;
        r1.delete(((com.bytedance.applog.n.a) ZeusTransformUtils.preCheckCast(r2.next(), com.bytedance.applog.n.a.class, "com.obric.memorydata.plugin")).h(), null, null);     // Catch: Throwable -> L19
        goto L15
    L17:
        r1.setTransactionSuccessful();     // Catch: Throwable -> L19
    L18:
        o.a(r1);
        return;
    L19:
        Throwable th = th;
    L33:
        i().a(5, "clear tables failed", th, new Object[0]);     // Catch: Throwable -> L26
        this.e.a().ab().a(StatsCountKeys.DB_ERROR_COUNT);     // Catch: Throwable -> L26
        this.e.a().ab().a("clearAllTables failed", th);     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        o.a(r1);
        throw th;
    L21:
        th = move-exception;
        r1 = null;
        th = th;
        goto L33
    }

    public void h() {
        this.m = 0;
        this.n = 0;
        this.o = 0;
        this.p = 0;
        Cursor r1 = null;
        SQLiteDatabase r2 = this.f.getReadableDatabase();     // Catch: Throwable -> L25
        Iterator r3 = Arrays.asList(new String[]{"event", "eventv3", "event_misc"}).iterator();     // Catch: Throwable -> L25
        Cursor r4 = null;
    L35:
    L23:
        Throwable th = th;
    L39:
        i().a(5, "count all events failed", th, new Object[0]);     // Catch: Throwable -> L30
        this.e.a().ab().a("readPiledUpEventCount failed", th);     // Catch: Throwable -> L30
        o.a(r4);
        return;
    L30:
        th = move-exception;
        o.a(r4);
        throw th;
    L6:
        if (r3.hasNext() == false) goto L15;
        r4 = r2.rawQuery("select count(1) from " + ((String) ZeusTransformUtils.preCheckCast(r3.next(), String.class, "com.obric.memorydata.plugin")), null);     // Catch: Throwable -> L14
        if (r4 == null) goto L35;
        if (r4.moveToFirst() == false) goto L35;
        this.m += r4.getInt(0);     // Catch: Throwable -> L14
    L14:
        o.a(r4);     // Catch: Throwable -> L23
        goto L35
    L15:
        r1 = r2.rawQuery("select _launch_count, _terminate_count, _event_v1_count, _event_v3_count, _event_misc_count, _impression_count from pack", null);     // Catch: Throwable -> L23
        if (r1 == null) goto L22;
        this.p = r1.getCount();     // Catch: Throwable -> L25
    L19:
        if (r1.moveToNext() == false) goto L22;
        this.n += r1.getInt(0);     // Catch: Throwable -> L25
        this.o += r1.getInt(1);     // Catch: Throwable -> L25
        int r5 = this.m + r1.getInt(2);     // Catch: Throwable -> L25
        this.m = r5;     // Catch: Throwable -> L25
        int r6 = r5 + r1.getInt(3);     // Catch: Throwable -> L25
        this.m = r6;     // Catch: Throwable -> L25
        this.m = r6 + r1.getInt(4);     // Catch: Throwable -> L25
    L22:
        o.a(r1);
        return;
    L25:
        th = move-exception;
        r4 = r1;
        th = th;
        goto L39
    }

    public void setResult(List<h> r17, List<h> r18) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r17, List.class, "com.obric.memorydata.plugin");
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r18, List.class, "com.obric.memorydata.plugin");
        i().c(5, "setResult: del -> {}, fail -> {}", new Object[]{r0, r3});
        Iterator r4 = r3.iterator();
        ArrayList r6 = new ArrayList();
        com.bytedance.applog.o.b r10 = this.e.a().az();
    L4:
        if (r4.hasNext() == false) goto L39;
        h r11 = (h) ZeusTransformUtils.preCheckCast(r4.next(), h.class, "com.obric.memorydata.plugin");
        long r12 = r10.b();
        if (r12 > 0) goto L8;
    L10:
        int r7 = r10.c();
        if (r7 < 0) goto L4;
        if (r11.w < r7) goto L4;
    L9:
        r0.add(r11);
        r6.add(r11);
        r4.remove();
        goto L4
    L8:
        if (Math.abs(System.currentTimeMillis() - r11.f1725b) < r12) goto L10;
    L39:
        SQLiteDatabase r5 = this.f.getWritableDatabase();     // Catch: Throwable -> L28
        Iterator r1 = r0.iterator();     // Catch: Throwable -> L28
    L18:
        if (r1.hasNext() == false) goto L22;
        h r8 = (h) ZeusTransformUtils.preCheckCast(r1.next(), h.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L28
        int r9 = r5.delete("pack", "_id = ?", new String[]{String.valueOf(r8.f1724a)});     // Catch: Throwable -> L28
        if (r9 > 0) goto L18;
        i().e(5, "delete from db failed, pack: {}, rows: {}", new Object[]{r8, Integer.valueOf(r9)});     // Catch: Throwable -> L28
        this.e.a().ab().a(StatsCountKeys.DB_ERROR_COUNT);     // Catch: Throwable -> L28
        this.e.a().aF().b("DB_DELETE_LOG_FAILED", "fail delete pack:" + r8.f1724a);     // Catch: Throwable -> L28
        this.e.a().ab().a("delete pack failed for zero", null);     // Catch: Throwable -> L28
        goto L18
    L22:
        Iterator r2 = r3.iterator();     // Catch: Throwable -> L28
    L23:
        if (r2.hasNext() == false) goto L27;
        h r13 = (h) ZeusTransformUtils.preCheckCast(r2.next(), h.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L28
        long r14 = r13.f1724a;     // Catch: Throwable -> L28
        int r15 = r13.w + 1;     // Catch: Throwable -> L28
        r13.w = r15;     // Catch: Throwable -> L28
        r5.execSQL(a(r14, r15));     // Catch: Throwable -> L28
    L27:
        this.f.b();
        Iterator r16 = r6.iterator();
    L33:
        if (r16.hasNext() == false) goto L35;
        ((h) ZeusTransformUtils.preCheckCast(r16.next(), h.class, "com.obric.memorydata.plugin")).z();
        goto L33
    L35:
        return;
    L28:
        th = move-exception;
        i().a(5, "set result failed", th, new Object[0]);     // Catch: Throwable -> L36
        this.e.a().ab().a(StatsCountKeys.DB_ERROR_COUNT);     // Catch: Throwable -> L36
        this.e.a().aF().a("DB_DELETE_LOG_ERROR", th);     // Catch: Throwable -> L36
        this.e.a().ab().a("handle pack send result failed", th);     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        this.f.b();
        throw th;
    }
}
