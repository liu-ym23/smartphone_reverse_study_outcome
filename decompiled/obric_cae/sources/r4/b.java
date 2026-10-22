package r4;

import android.app.Application;
import android.content.ContentValues;
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
import androidx.lifecycle.s;
import c4.l;
import c4.m;
import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import x4.j0;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final y3.c f11465a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C0145b f11466b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap<String, r4.a> f11467c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final r4.a[] f11468d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public a f11469e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile boolean f11470f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile boolean f11471g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final HashSet f11472h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f11473i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f11474j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f11475k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f11476l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ArrayList<r4.a> f11477m;

    public class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f11478a;

        public a(b r8, Looper r10) {
            this.f11478a = r8;
            super(r10);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message r8) {
            if (r8.what != 0) goto L7;
            this.f11478a.x(null);
            return;
        }
    }

    /* JADX INFO: renamed from: r4.b$b, reason: collision with other inner class name */
    public class C0145b extends SQLiteOpenHelper {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f11479a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f11480b;

        public C0145b(b r8, Application r10, String r11) {
            this.f11480b = r8;
            super(r10, r11, null, 58);
            long r12 = 0;
            this.f11479a = 0;
            File r13 = r10.getDatabasePath(r11);
            if (r13 == null) goto L5;
            r12 = r13.length();
        L5:
            this.f11479a = r12;
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onConfigure(SQLiteDatabase r8) {
            super.onConfigure(r8);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onCreate(SQLiteDatabase r8) {
            b r10 = this.f11480b;
            r8.beginTransaction();     // Catch: Throwable -> L11
            Iterator<r4.a> r11 = r10.f11467c.values().iterator();     // Catch: Throwable -> L11
        L5:
            if (r11.hasNext() == false) goto L9;
            String r12 = r11.next().b();     // Catch: Throwable -> L11
            if (r12 == null) goto L5;
            r8.execSQL(r12);     // Catch: Throwable -> L11
            goto L5
        L9:
            r8.setTransactionSuccessful();     // Catch: Throwable -> L11
        L13:
            v4.i.f(r8);
            return;
        L11:
            th = move-exception;
            m r13 = (m) r10.g();     // Catch: Throwable -> L15
            r13.k(th, 5, "create db failed", new Object[0]);     // Catch: Throwable -> L15
            r10.f11465a.f13937m.f11417y.g("DBHelper onCreate failed", th);     // Catch: Throwable -> L15
        L15:
            th = move-exception;
            v4.i.f(r8);
            throw th;
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onDowngrade(SQLiteDatabase r8, int r10, int r11) {
            onUpgrade(r8, r10, r11);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onUpgrade(SQLiteDatabase r8, int r10, int r11) {
            b r12 = this.f11480b;
            ((m) r12.g()).l(5, null, "onUpgrade: v{} -> v{}", new Object[]{Integer.valueOf(r10), Integer.valueOf(r11)});
            r8.beginTransaction();     // Catch: Throwable -> L9
            Iterator<r4.a> r13 = r12.f11467c.values().iterator();     // Catch: Throwable -> L9
        L5:
            if (r13.hasNext() == false) goto L7;
            r8.execSQL("DROP TABLE IF EXISTS " + r13.next().i());     // Catch: Throwable -> L9
            goto L5
        L7:
            r8.setTransactionSuccessful();     // Catch: Throwable -> L9
        L11:
            v4.i.f(r8);
            onCreate(r8);
            return;
        L9:
            th = move-exception;
            ((m) r12.g()).k(th, 5, "upgrade db failed", new Object[0]);     // Catch: Throwable -> L13
            r12.f11465a.f13937m.f11417y.g("DBHelper onUpgrade failed", th);     // Catch: Throwable -> L13
        L13:
            th = move-exception;
            v4.i.f(r8);
            throw th;
        }
    }

    public b(y3.c r10, String r11) {
        this.f11467c = new HashMap();
        r4.a[] r8 = r4.a.d();
        this.f11468d = r8;
        Cursor r12 = null;
        this.f11469e = null;
        this.f11470f = false;
        this.f11471g = false;
        this.f11472h = new HashSet();
        this.f11473i = 0;
        this.f11474j = 0;
        this.f11475k = 0;
        this.f11476l = 0;
        this.f11477m = new ArrayList();
        this.f11466b = new C0145b(this, r10.f13937m.f11402j, r11);
        this.f11465a = r10;
        w(new j());
        w(new g());
        w(new k());
        w(new i());
        w(new f());
        int r13 = 0;
    L4:
        if (r13 >= 3) goto L6;
        w(r8[r13]);
        r13 = r13 + 1;
        goto L4
    L6:
        this.f11473i = 0;
        this.f11474j = 0;
        this.f11475k = 0;
        this.f11476l = 0;
        SQLiteDatabase r14 = this.f11466b.getReadableDatabase();     // Catch: Throwable -> L29
        Iterator r15 = Arrays.asList(new String[]{"event", "eventv3", "event_misc"}).iterator();     // Catch: Throwable -> L29
        Cursor r16 = null;
    L37:
    L27:
        th = th;
    L39:
        ((m) g()).k(th, 5, "count all events failed", new Object[0]);     // Catch: Throwable -> L34
        this.f11465a.f13937m.f11417y.g("readPiledUpEventCount failed", th);     // Catch: Throwable -> L34
        v4.i.b(r16);
        return;
    L34:
        th = move-exception;
        v4.i.b(r16);
        throw th;
    L10:
        if (r15.hasNext() == false) goto L19;
        r16 = r14.rawQuery("select count(1) from " + ((String) r15.next()), null);     // Catch: Throwable -> L18
        if (r16 == null) goto L37;
        if (r16.moveToFirst() == false) goto L37;
        this.f11473i += r16.getInt(0);     // Catch: Throwable -> L18
    L18:
        v4.i.b(r16);     // Catch: Throwable -> L27
        goto L37
    L19:
        r12 = r14.rawQuery("select _launch_count, _terminate_count, _event_v1_count, _event_v3_count, _event_misc_count, _impression_count from pack", null);     // Catch: Throwable -> L27
        if (r12 == null) goto L26;
        this.f11476l = r12.getCount();     // Catch: Throwable -> L29
    L23:
        if (r12.moveToNext() == false) goto L26;
        this.f11474j += r12.getInt(0);     // Catch: Throwable -> L29
        this.f11475k += r12.getInt(1);     // Catch: Throwable -> L29
        int r17 = this.f11473i + r12.getInt(2);     // Catch: Throwable -> L29
        this.f11473i = r17;     // Catch: Throwable -> L29
        int r18 = r17 + r12.getInt(3);     // Catch: Throwable -> L29
        this.f11473i = r18;     // Catch: Throwable -> L29
        this.f11473i = r18 + r12.getInt(4);     // Catch: Throwable -> L29
    L26:
        v4.i.b(r12);
        return;
    L29:
        th = th;
        r16 = r12;
        goto L39
    }

    public static String B(r4.a r8, String r10, boolean r11, int r12, m4.b r13) {
        StringBuilder r14 = new StringBuilder("SELECT * FROM " + r8.i() + " WHERE session_id");
        if (r11 == false) goto L5;
        String r15 = "='";
    L6:
        r14.append(r15);
        r14.append(r10);
        if (r13 == null) goto L9;
        r13.getClass();
        String r16 = "' AND priority=0";
    L10:
        r14.append(r16);
        r14.append(" ORDER BY _id LIMIT " + r12);
        return r14.toString();
    L9:
        r16 = "'";
        goto L10
    L5:
        r15 = "!='";
        goto L6
    }

    public static String C(int r8, m4.b r10) {
        StringBuilder r11 = new StringBuilder("SELECT * FROM pack");
        if (r10 == null) goto L5;
        r10.getClass();
        r11.append(defpackage.a.d(" WHERE priority=", 0));
    L5:
        r11.append(" ORDER BY _id DESC LIMIT " + r8);
        return r11.toString();
    }

    public static String D(String r8, boolean r10) {
        StringBuilder r11 = new StringBuilder("SELECT * FROM page WHERE session_id");
        if (r10 == false) goto L5;
        String r12 = "='";
    L6:
        r11.append(r12);
        r11.append(r8);
        r11.append("' ORDER BY ");
        if (r10 == false) goto L9;
        String r13 = "session_id,";
    L11:
        return android.aimedia.a.i(r11, r13, "duration DESC LIMIT 1000");
    L9:
        r13 = "";
        goto L11
    L5:
        r12 = "!='";
        goto L6
    }

    public static String c(String r8, String r10, boolean r11, long r12, m4.b r13) {
        StringBuilder r14 = new StringBuilder(defpackage.b.d("DELETE FROM ", r8, " WHERE session_id"));
        if (r11 == false) goto L5;
        String r15 = "='";
    L6:
        r14.append(r15);
        r14.append(r10 + "' AND _id<=" + r12);
        if (r13 == null) goto L10;
        r13.getClass();
        r14.append(" AND priority=0");
    L10:
        return r14.toString();
    L5:
        r15 = "!='";
        goto L6
    }

    public static boolean i(long[] r8) {
        if (r8[0] > 0) goto L9;
        if (r8[1] > 0) goto L9;
        if (r8[2] > 0) goto L9;
        return false;
    L9:
        return true;
    }

    public final void A(ArrayList<r4.a> r17) {
        if (r17 != null) goto L5;
        return;
    L5:
        ArrayList<g> r8 = new ArrayList(4);
        ArrayList<r4.a> r10 = new ArrayList(4);
        ArrayList<k> r11 = new ArrayList(4);
        boolean r12 = this.f11471g;
        SQLiteDatabase r15 = this.f11466b.getWritableDatabase();     // Catch: Throwable -> L27
        if (r12 == true) goto L57;
    L9:
        j(r17, r8, r10, r11, r15);     // Catch: Throwable -> L25
        if (r12 == false) goto L13;
        r15.setTransactionSuccessful();     // Catch: Throwable -> L25
        boolean r13 = true;
    L55:
    L23:
        th = th;
    L30:
        if (r12 == false) goto L33;
        if (r13 == true) goto L33;
        v4.i.f(r15);     // Catch: Throwable -> L49
        e(r17, r8, r10, r11, r15);     // Catch: Throwable -> L49
    L49:
        th = move-exception;
        if (r12 == false) goto L52;
        v4.i.f(r15);
    L52:
        throw th;
    L33:
        ((m) g()).k(th, 5, "save db failed", new Object[0]);     // Catch: Throwable -> L49
        this.f11465a.f13937m.f11417y.b(i4.k.O, 1);     // Catch: Throwable -> L49
        this.f11465a.f13937m.f11417y.g("save base data list failed", th);     // Catch: Throwable -> L49
        if (r12 == false) goto L36;
    L35:
        v4.i.f(r15);
    L36:
        m(r10);
        Iterator<g> r14 = r8.iterator();     // Catch: Throwable -> L46
    L39:
        if (r14.hasNext() == false) goto L41;
        g r16 = r14.next();     // Catch: Throwable -> L46
        this.f11465a.f13937m.f11393a.b(r16.f11449a, r16.f11452n);     // Catch: Throwable -> L46
        goto L39
    L41:
        Iterator<k> r18 = r11.iterator();     // Catch: Throwable -> L46
    L42:
        if (r18.hasNext() == false) goto L67;
        k r19 = r18.next();     // Catch: Throwable -> L46
        this.f11465a.f13937m.f11393a.c(r19.f11449a, r19.f11452n, r19.m());     // Catch: Throwable -> L46
        goto L42
    L67:
        return;
    L46:
        th = move-exception;
        ((m) g()).k(th, 5, "onSessionStart failed", new Object[0]);
        this.f11465a.f13937m.f11417y.g("notify onSessionStart or onSessionTerminate failed", th);
        return;
    L15:
        if (l.b() == true) goto L21;
        Iterator<r4.a> r20 = r17.iterator();     // Catch: Throwable -> L23
    L18:
        if (r20.hasNext() == false) goto L21;
        l.d(r20.next(), "event_save_db");     // Catch: Throwable -> L23
    L21:
        if (r12 == false) goto L36;
    L25:
        th = th;
    L29:
        r13 = false;
        goto L30
    L13:
        r13 = false;
        goto L55
    L57:
        r15.beginTransaction();     // Catch: Throwable -> L25
    L27:
        th = th;
        r15 = null;
        goto L29
    }

    public final ArrayList E(i r34) {
        ArrayList r8 = new ArrayList();
        y3.c r10 = this.f11465a;
        r10.f13937m.getClass();
        r8.add(r34);
        d4.c r11 = r10.f13938n;
        String r12 = "max_pack_size";
        long r13 = 0;
        if (r11.f6761e.getLong("max_pack_size", 0) <= 0) goto L5;
        boolean r14 = true;
    L6:
        if (r14 == false) goto L97;
        ArrayList r15 = new ArrayList();
        Iterator r16 = r8.iterator();
    L9:
        if (r16.hasNext() == false) goto L78;
        i r17 = (i) r16.next();
        long r18 = r11.f6761e.getLong(r12, r13);
        r17.getClass();
        ArrayList r19 = new ArrayList();
        if (r17.m().toString().length() >= r18) goto L13;
        r19.add(r17);
        ArrayList r20 = r15;
        long r21 = r13;
    L76:
        r20.addAll(r19);
        r15 = r20;
        r13 = r21;
        r16 = r16;
        r11 = r11;
        r12 = r12;
        goto L9
    L13:
        JSONObject r110 = r17.Q;
        if (r110 == null) goto L16;
        long r111 = r110.toString().length();
    L17:
        i r112 = new i();
        ArrayList r29 = r15;
        r112.u(r17.f11461w, r17.Q, r17.N, r17.P, r17.O, new JSONArray[]{null, null, null}, new long[]{r17.K, r17.M, r17.S}, r17.T, r17.Z, r17.f11493l0);
        r112.f11452n = r17.f11452n;
        r112.f11485c0 = r17.f11485c0;
        r112.d0 = r17.d0;
        r19.add(r112);
        long r22 = r18 - r111;
        g r23 = r17.N;
        if (r23 == null) goto L20;
        long r24 = r22 - ((long) r23.m().toString().length());
    L21:
        k r25 = r17.P;
        if (r25 == null) goto L24;
        r24 = r24 - ((long) r25.m().toString().length());
    L24:
        JSONArray r26 = r17.T;
        if (r26 == null) goto L27;
        r24 = r24 - ((long) r26.toString().length());
    L27:
        i r113 = r112;
        int r27 = 0;
    L29:
        if (v4.e.a(r17.J) == true) goto L43;
        if (r27 >= r17.J.length()) goto L43;
        JSONObject r28 = r17.J.optJSONObject(r27);
        if (r28 == null) goto L42;
        long r30 = r28.toString().length();
        r24 = r24 - r30;
        if (r24 > 0) goto L38;
        i r31 = r17.q();
        r19.add(r31);
        JSONArray r32 = new JSONArray();
        r31.J = r32;
        r32.put(r28);
        r113 = r31;
        r24 = r22 - r30;
        goto L42
    L38:
        if (r113.J != null) goto L40;
        r113.J = new JSONArray();
    L40:
        r113.J.put(r28);
    L42:
        r27 = r27 + 1;
    L43:
        int r33 = 0;
    L45:
        if (v4.e.a(r17.L) == true) goto L59;
        if (r33 >= r17.L.length()) goto L59;
        JSONObject r35 = r17.L.optJSONObject(r33);
        if (r35 == null) goto L58;
        long r36 = r35.toString().length();
        r24 = r24 - r36;
        if (r24 > 0) goto L54;
        i r37 = r17.q();
        r19.add(r37);
        JSONArray r38 = new JSONArray();
        r37.L = r38;
        r38.put(r35);
        r113 = r37;
        r24 = r22 - r36;
        goto L58
    L54:
        if (r113.L != null) goto L56;
        r113.L = new JSONArray();
    L56:
        r113.L.put(r35);
    L58:
        r33 = r33 + 1;
    L59:
        int r39 = 0;
    L61:
        if (v4.e.a(r17.R) == true) goto L75;
        if (r39 >= r17.R.length()) goto L75;
        JSONObject r40 = r17.R.optJSONObject(r39);
        if (r40 == null) goto L74;
        long r41 = r40.toString().length();
        r24 = r24 - r41;
        if (r24 > 0) goto L70;
        i r42 = r17.q();
        r19.add(r42);
        JSONArray r43 = new JSONArray();
        r42.R = r43;
        r43.put(r40);
        r113 = r42;
        r24 = r22 - r41;
        goto L74
    L70:
        if (r113.R != null) goto L72;
        r113.R = new JSONArray();
    L72:
        r113.R.put(r40);
    L74:
        r39 = r39 + 1;
    L75:
        r21 = 0;
        r20 = r29;
        goto L76
    L20:
        r24 = r22;
        goto L21
    L16:
        r111 = r13;
        goto L17
    L78:
        return r15;
    L97:
        return r8;
    L5:
        r14 = false;
        goto L6
    }

    public final void F() {
        Field r8 = CursorWindow.class.getDeclaredField("sCursorWindowSize");     // Catch: Throwable -> L8
        r8.setAccessible(true);     // Catch: Throwable -> L8
        int r10 = r8.getInt(null);     // Catch: Throwable -> L8
        if (r10 > 0) goto L5;
        return;
    L5:
        if (r10 > 8388608) goto L14;
        r8.setInt(null, r10 * 2);     // Catch: Throwable -> L8
        return;
    L14:
        return;
    L8:
        th = move-exception;
        g().k(th, 5, "tryIncreaseCursorWindowSize", new Object[0]);
    }

    public final JSONObject a(g r8, JSONObject r10) {
        String r11 = r8.I;
        y3.c r12 = this.f11465a;
        j0 r13 = ((u3.e) r12.f13942r.f6774a).f12437b;
        if (r13 == null) goto L5;
        String r14 = r13.c();
    L7:
        if (TextUtils.equals(r11, r14) == false) goto L19;
        long r15 = r8.H;
        j0 r16 = ((u3.e) r12.f13942r.f6774a).f12437b;
        if (r16 == null) goto L11;
        long r17 = r16.d();
    L13:
        if (r15 != r17) goto L19;
        return r10;
    L11:
        r17 = 0;
    L19:
        JSONObject r18 = new JSONObject();     // Catch: JSONException -> L16
        v4.i.d(r18, r10);     // Catch: JSONException -> L16
        r18.put("app_version", r8.I);     // Catch: JSONException -> L16
        r18.put("version_code", r8.H);     // Catch: JSONException -> L16
        return r18;
    L16:
        e = move-exception;
        m r19 = (m) g();
        r19.k(e, 5, "check version failed", new Object[0]);
        return r10;
    L5:
        r14 = "";
        goto L7
    }

    public final void b(SQLiteDatabase r11, HashMap<String, JSONObject> r12) {
        y3.c r8 = this.f11465a;
        g r10 = (g) this.f11467c.get("launch");
        if (r10 != null) goto L43;
        return;
    L43:
        Cursor r13 = r11.rawQuery("SELECT * FROM launch ORDER BY _id DESC LIMIT 3", null);     // Catch: Throwable -> L23
        boolean r14 = r13.moveToLast();     // Catch: Throwable -> L17
    L9:
        if (r14 == false) goto L57;
        r10.j(r13);     // Catch: Throwable -> L17
        JSONObject r15 = new JSONObject();     // Catch: Throwable -> L17
        r8.f13937m.f11393a.a(r10.f11449a, r10.f11452n, r15);     // Catch: Throwable -> L13
    L15:
        r12.put(r10.f11452n, r15);     // Catch: Throwable -> L17
        r14 = r13.moveToPrevious();     // Catch: Throwable -> L17
    L13:
        th = move-exception;
        ((m) g()).l(5, null, "onSessionBatchEvent failed", new Object[]{th});     // Catch: Throwable -> L17
        r8.f13937m.f11417y.g("collectImpression onSessionBatchEvent failed", th);     // Catch: Throwable -> L17
        goto L15
    L57:
        r13.close();     // Catch: Throwable -> L21
        return;
    L21:
        th = move-exception;
        ((m) g()).l(5, null, "close cursor failed", new Object[]{th});
        return;
    L17:
        Throwable th = th;
    L51:
        ((m) g()).l(5, null, "collect impression failed", new Object[]{th});     // Catch: Throwable -> L36
        r8.f13937m.f11417y.b(i4.k.f8259l0, 1);     // Catch: Throwable -> L36
        r8.f13937m.f11417y.g("collectImpression failed", th);     // Catch: Throwable -> L36
        if (r13 == null) goto L62;
        r13.close();     // Catch: Throwable -> L33
        return;
    L33:
        th = move-exception;
        ((m) g()).l(5, null, "close cursor failed", new Object[]{th});
        return;
    L62:
        return;
    L36:
        th = move-exception;
        if (r13 != null) goto L45;
    L42:
        throw th;
    L45:
        r13.close();     // Catch: Throwable -> L40
    L40:
        th = move-exception;
        ((m) g()).l(5, null, "close cursor failed", new Object[]{th});
    L23:
        th = th;
    L28:
        r13 = null;
    L26:
        th = move-exception;
        th = th;
        goto L28
    }

    public final void d(ArrayList r8) {
        Iterator r10 = r8.iterator();
        long r11 = 0;
    L4:
        if (r10.hasNext() == false) goto L14;
        long r12 = ((f) r10.next()).f11449a;
        if (r12 <= r11) goto L4;
        r11 = r12;
        goto L4
    L14:
        this.f11466b.getWritableDatabase().delete("forward_eventv3", "_id <= ?", new String[]{String.valueOf(r11)});     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        ((m) g()).k(th, 5, "delete forward events failed", new Object[0]);
        this.f11465a.f13937m.f11417y.g("deleteForwardEvents failed", th);
    }

    public final void e(ArrayList<r4.a> r8, ArrayList<g> r10, ArrayList<r4.a> r11, ArrayList<k> r12, SQLiteDatabase r13) {
        r10.clear();
        r11.clear();
        r12.clear();
        j(r8, r10, r11, r12, r13);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        m r14 = (m) g();
        r14.k(th, 5, "save db failed", new Object[0]);
        y3.c r15 = this.f11465a;
        r15.f13937m.f11417y.b(i4.k.O, 1);
        r15.f13937m.f11417y.g("save base data list failed", th);
    }

    public final JSONArray f(String r8, HashMap<String, JSONObject> r10) {
        JSONObject r11 = r10.remove(r8);
        if (r11 == null) goto L8;
        JSONArray r12 = r11.optJSONArray("item_impression");
        if (r12 != null) goto L7;
    L9:
        y3.c r13 = this.f11465a;
        if (v4.c.b(r13.f13937m.f11401i) == false) goto L15;
        if (r12 == null) goto L15;
        v4.d r14 = v4.c.a(r13.f13937m.f11401i);
        if (r14 == null) goto L15;
        r14.a();
    L15:
        return r12;
    L7:
        if (r12.length() != 0) goto L9;
    L8:
        r12 = null;
        goto L9
    }

    public final c4.g g() {
        return this.f11465a.f13937m.H;
    }

    public final Handler h() {
        if (this.f11469e != null) goto L8;
        if (Looper.myLooper() == null) goto L8;
        this.f11469e = new a(this, Looper.myLooper());
    L8:
        return this.f11469e;
    }

    public final void j(ArrayList<r4.a> r10, ArrayList<g> r11, ArrayList<r4.a> r12, ArrayList<k> r13, SQLiteDatabase r14) {
        Iterator<r4.a> r15 = r10.iterator();
        ContentValues r8 = null;
    L4:
        if (r15.hasNext() == false) goto L59;
        r4.a r16 = r15.next();
        boolean r17 = TextUtils.isEmpty(r16.f11461w);
        y3.c r18 = this.f11465a;
        if (r17 == false) goto L9;
        r16.f11461w = r18.f13937m.f11401i;
    L9:
        if (r16.C <= 0) goto L11;
        l6.a.P0(r18.f13937m.f11417y, i4.a.C, r16);
    L11:
        String r19 = r16.i();
        if (r8 != null) goto L14;
        r8 = new ContentValues();
    L15:
        r16.n(r8);
        long r20 = r14.insert(r19, null, r8);
        r16.f11449a = r20;
        if (r20 < 0) goto L18;
        boolean r21 = true;
    L20:
        if (r16.C <= 0) goto L26;
        i4.f r22 = r18.f13937m.f11417y;
        if (r21 == false) goto L24;
        i4.a r23 = i4.a.E;
    L25:
        l6.a.P0(r22, r23, r16);
        goto L26
    L24:
        r23 = i4.a.D;
    L26:
        if (r21 == true) goto L29;
        r18.f13937m.f11417y.b(i4.k.O, 1);
    L29:
        if ((r16 instanceof c) == true) goto L30;
        if ((r16 instanceof e) == true) goto L35;
        if ((r16 instanceof d) == true) goto L40;
        if ((r16 instanceof g) == true) goto L45;
        if ((r16 instanceof k) == true) goto L50;
        if ((r16 instanceof j) == false) goto L4;
        if (r21 == true) goto L4;
        i4.f r24 = r18.f13937m.f11417y;
        i4.k r25 = i4.k.f8253f0;
    L58:
        r24.b(r25, 1);
        goto L4
    L50:
        r13.add((k) r16);
        if (r21 == true) goto L4;
    L47:
        r24 = r18.f13937m.f11417y;
        r25 = i4.k.f8252e0;
        goto L58
    L45:
        r11.add((g) r16);
        if (r21 == true) goto L4;
    L40:
        r12.add(r16);
        if (r21 == true) goto L4;
        r24 = r18.f13937m.f11417y;
        r25 = i4.k.d0;
        goto L58
    L35:
        r12.add(r16);
        if (r21 == true) goto L4;
        r24 = r18.f13937m.f11417y;
        r25 = i4.k.f8250b0;
        goto L58
    L30:
        r12.add(r16);
        if (r21 == true) goto L4;
        r24 = r18.f13937m.f11417y;
        r25 = i4.k.f8251c0;
        goto L58
    L18:
        r21 = false;
        goto L20
    L14:
        r8.clear();
        goto L15
    }

    public final void k(SQLiteDatabase r10, i r11, boolean r12) {
        g r8 = r11.N;
        if (r8 == null) goto L7;
        if (r8.M == false) goto L7;
    L31:
        boolean r13 = false;
    L33:
        if (r13 == false) goto L36;
        ((m) g()).f(5, null, "no need insert to db for empty pack: {}, matchSid: {}", new Object[]{r11, Boolean.valueOf(r12)});
        return;
    L36:
        y3.c r14 = this.f11465a;
        boolean r15 = r14.f13937m.f11417y.f();
        r3.c r16 = r14.f13937m;
        if (r15 == false) goto L42;
        Iterator r17 = r11.s().iterator();
    L40:
        if (r17.hasNext() == false) goto L42;
        l6.a.O0(r16.f11417y, i4.a.F, (i4.i) r17.next());
    L42:
        ContentValues r18 = new ContentValues();
        r11.n(r18);
        long r19 = r10.insert("pack", null, r18);
        if (r19 >= 0) goto L50;
        g r110 = r11.N;
        if (r110 == null) goto L47;
        this.f11472h.remove(r110.f11452n);
    L47:
        r11.t();
        ((m) g()).t("insert to db failed, pack: {}, result: {}", new Object[]{r11, Long.valueOf(r19)});
        r16.f11417y.b(i4.k.f8254g0, 1);
        r16.f11417y.g("pack insert failed for db id < 0", null);
        throw new SQLiteException("insert pack to db failed for result id < 0.");
    L50:
        if (r16.f11417y.f() == false) goto L55;
        Iterator r20 = r11.s().iterator();
    L53:
        if (r20.hasNext() == false) goto L55;
        l6.a.O0(r16.f11417y, i4.a.G, (i4.i) r20.next());
    L55:
        r11.f11449a = r19;
        ((m) g()).g(5, null, "pack: {} insert to db success!", new Object[]{r11, Long.valueOf(r19)});
        if (r11.P == null) goto L69;
        JSONArray r21 = r11.O;
        if (r21 != null) goto L60;
        return;
    L60:
        if (r21.length() <= 0) goto L71;
        String r22 = r11.f11452n;
        StringBuilder r111 = new StringBuilder("DELETE FROM page WHERE session_id");
        if (r12 == false) goto L64;
        String r112 = "='";
    L65:
        r111.append(r112);
        r111.append(r22);
        r111.append("'");
        r10.execSQL(r111.toString());
        return;
    L64:
        r112 = "!='";
        goto L65
    L71:
        return;
    L69:
        return;
    L7:
        if (r11.P != null) goto L31;
        JSONArray r23 = r11.T;
        if (r23 != null) goto L11;
    L12:
        JSONArray r24 = r11.J;
        if (r24 != null) goto L15;
    L16:
        JSONArray r25 = r11.L;
        if (r25 != null) goto L19;
    L20:
        JSONArray r26 = r11.R;
        if (r26 != null) goto L23;
    L24:
        JSONObject r27 = r11.f11486e0;
        if (r27 == null) goto L29;
        if (r27.length() != 0) goto L31;
    L29:
        if (TextUtils.isEmpty(r11.f11484b0) == false) goto L31;
        r13 = true;
        goto L33
    L23:
        if (r26.length() != 0) goto L31;
    L19:
        if (r25.length() != 0) goto L31;
    L15:
        if (r24.length() != 0) goto L31;
    L11:
        if (r23.length() != 0) goto L31;
        goto L12
    }

    public final boolean l(String r8) {
        HashSet r10 = this.f11472h;
        if (r10.contains(r8) == true) goto L5;
        r10.add(r8);
        boolean r11 = true;
    L6:
        c4.g r12 = g();
        m r13 = (m) r12;
        r13.l(5, null, "session id:{} needLaunch:{}", new Object[]{r8, Boolean.valueOf(r11)});
        return r11;
    L5:
        r11 = false;
        goto L6
    }

    public final void m(List<r4.a> r14) {
        y3.c r8 = this.f11465a;
        r3.c r10 = r8.f13937m;
        r3.c r11 = r8.f13937m;
        if (r10.f11394b.a(0) == false) goto L5;
        return;
    L5:
        Iterator<r4.a> r15 = r14.iterator();
    L7:
        if (r15.hasNext() == false) goto L21;
        r4.a r12 = r15.next();
        if ("event".equals(r12.i()) == true) goto L11;
        if ("eventv3".equals(r12.i()) == true) goto L14;
        if ("event_misc".equals(r12.i()) == false) goto L7;
        d r13 = (d) r12;     // Catch: Throwable -> L19
        r11.f11394b.d(0, r13.I, r13.H);     // Catch: Throwable -> L19
        goto L7
    L14:
        e r16 = (e) r12;     // Catch: Throwable -> L19
        r11.f11394b.c(0, r16.J, r16.H);     // Catch: Throwable -> L19
        goto L7
    L11:
        c r17 = (c) r12;     // Catch: Throwable -> L19
        b4.a r18 = r11.f11394b;     // Catch: Throwable -> L19
        String r19 = r17.H;     // Catch: Throwable -> L19
        String r110 = r17.I;     // Catch: Throwable -> L19
        String r111 = r17.J;     // Catch: Throwable -> L19
        r18.b(0, r17.L, r17.M, r19, r110, r111, r17.K);     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        m r20 = (m) g();
        r20.k(th, 5, "notify event observer before store failed", new Object[0]);
        r11.f11417y.g("notify event observer failed", th);
        goto L7
    }

    public final synchronized void n(JSONObject r29, m4.b r30, int r31) {
        monitor-enter(this);
        SQLiteDatabase r8 = null;
        Cursor r10 = null;
        if (this.f11470f == false) goto L7;
        x(null);     // Catch: Throwable -> L121
    L7:
        g r11 = (g) this.f11467c.get("launch");     // Catch: Throwable -> L121
        k r14 = (k) this.f11467c.get("terminate");     // Catch: Throwable -> L121
        j r15 = (j) this.f11467c.get("page");     // Catch: Throwable -> L121
        i r12 = (i) this.f11467c.get("pack");     // Catch: Throwable -> L121
        JSONArray[] r13 = new JSONArray[3];     // Catch: Throwable -> L99
        long[] r16 = new long[3];     // Catch: Throwable -> L99
        HashMap<String, JSONObject> r17 = new HashMap();     // Catch: Throwable -> L99
        ((m) g()).l(5, null, "DbStore pack before collect impression.", new Object[0]);     // Catch: Throwable -> L99
        SQLiteDatabase r18 = this.f11466b.getWritableDatabase();     // Catch: Throwable -> L99
        b(r18, r17);     // Catch: Throwable -> L96
        ((m) g()).l(5, null, "DbStore pack after collect impression.", new Object[0]);     // Catch: Throwable -> L96
        r18.beginTransaction();     // Catch: Throwable -> L96
        Cursor r19 = r18.rawQuery("SELECT * FROM launch ORDER BY _id DESC LIMIT 5", null);     // Catch: Throwable -> L96
        y3.j r20 = this.f11465a.f13945u;     // Catch: Throwable -> L93
        String r21 = r20.f13979e;     // Catch: Throwable -> L93
        boolean r22 = r20.f13982h;     // Catch: Throwable -> L93
        ArrayList r23 = new ArrayList();     // Catch: Throwable -> L93
        boolean r110 = r19.moveToLast();     // Catch: Throwable -> L93
        JSONObject r111 = r29;
    L13:
        if (r110 == false) goto L38;
        r11.j(r19);     // Catch: Throwable -> L36
        r12.f11452n = r11.f11452n;     // Catch: Throwable -> L33
        r111 = a(r11, r29);     // Catch: Throwable -> L33
    L31:
        th = th;
        Cursor r24 = r19;
        SQLiteDatabase r25 = r18;
    L35:
        SQLiteDatabase r112 = r25;
        int r113 = 0;
    L54:
        r8 = r112;
        int r114 = r113;
        int r115 = 5;
    L139:
        this.f11465a.f13937m.f11417y.b(i4.k.R, 1);     // Catch: Throwable -> L111
        this.f11465a.f13937m.f11417y.g("pack failed", th);     // Catch: Throwable -> L111
        ((m) g()).k(th, r115, "pack failed", new Object[r114]);     // Catch: Throwable -> L111
        if (r24 != null) goto L151;
    L108:
        v4.i.f(r8);     // Catch: Throwable -> L121
    L109:
        monitor-exit(this);
        return;
    L151:
        r24.close();     // Catch: Throwable -> L105
    L105:
        th = move-exception;
        ((m) g()).k(th, r115, "close cursor failed", new Object[r114]);     // Catch: Throwable -> L121
        goto L108
    L111:
        th = move-exception;
        if (r24 != null) goto L145;
    L119:
        v4.i.f(r8);     // Catch: Throwable -> L121
        throw th;     // Catch: Throwable -> L121
    L145:
        r24.close();     // Catch: Throwable -> L116
    L116:
        th = move-exception;
        ((m) g()).k(th, r115, "close cursor failed", new Object[r114]);     // Catch: Throwable -> L121
        goto L119
    L17:
        if (TextUtils.equals(r11.f11452n, r21) == false) goto L24;
        if (r22 == true) goto L20;
        boolean r116 = true;
    L21:
        r11.J = r116;     // Catch: Throwable -> L31
        ArrayList r117 = r23;
        r24 = r19;
        r25 = r18;
        HashMap<String, JSONObject> r26 = r17;
        long[] r27 = r16;
        JSONArray[] r28 = r13;
        p(r111, r11, r12, r18, r13, r16, r26, r30, r31);     // Catch: Throwable -> L29
        ArrayList r118 = r117;
    L126:
    L55:
        th = th;
        goto L35
    L28:
        r15 = r15;
        r22 = r22;
        r21 = r21;
        r19 = r24;
        r18 = r25;
        r17 = r26;
        r16 = r27;
        r13 = r28;
        r12 = r12;
        ArrayList r210 = r118;
        r110 = r24.moveToPrevious();     // Catch: Throwable -> L55
        r23 = r210;
    L29:
        th = th;
        goto L35
    L20:
        r116 = false;
        goto L21
    L24:
        ArrayList r119 = r23;
        r24 = r19;
        r25 = r18;
        r26 = r17;
        r27 = r16;
        r28 = r13;
        r119.add(Long.valueOf(r11.f11449a));     // Catch: Throwable -> L29
        r118 = r119;
        q(r111, r11, r12, r15, r14, r25, r28, r27, r26, r30, r31);     // Catch: Throwable -> L55
    L33:
        th = th;
        r24 = r19;
        r25 = r18;
    L36:
        th = th;
        r24 = r19;
        r8 = r18;
        r115 = 5;
        r114 = 0;
        goto L139
    L38:
        ArrayList r120 = r23;
        String r211 = r21;
        r24 = r19;
        r25 = r18;
        long[] r212 = r16;
        JSONArray[] r213 = r13;
        i r214 = r12;
        j r121 = r15;
        if (r120.isEmpty() == true) goto L57;
        Iterator r32 = r120.iterator();     // Catch: Throwable -> L55
    L42:
        if (r32.hasNext() == false) goto L57;
        String[] r33 = new String[1];     // Catch: Throwable -> L55
        r113 = 0;
        r33[0] = String.valueOf((Long) r32.next());     // Catch: Throwable -> L52
        r112 = r25;
        r112.execSQL("DELETE FROM launch WHERE _id=?", r33);     // Catch: Throwable -> L50
        r25 = r112;
    L50:
        th = th;
    L52:
        th = th;
        r112 = r25;
    L57:
        SQLiteDatabase r122 = r25;
        if (r24.getCount() < 5) goto L153;
    L68:
        r115 = 5;
        SQLiteDatabase r123 = r122;
        r114 = 0;
    L69:
        r123.setTransactionSuccessful();     // Catch: Throwable -> L87
        r3.c r34 = this.f11465a.f13937m;     // Catch: Throwable -> L87
        if (r34 == null) goto L143;
        s r35 = r34.M;     // Catch: Throwable -> L87
        if (r35 == null) goto L143;
        Iterator r36 = ((List) r35.f2194b).iterator();     // Catch: Throwable -> L87
    L74:
        if (r36.hasNext() == false) goto L143;
        l4.b r37 = (l4.b) r36.next();     // Catch: Throwable -> L87
        if ((r37 instanceof l4.a) == false) goto L74;
        ((l4.a) r37).a();     // Catch: Throwable -> L87
    L87:
        th = th;
    L95:
        r10 = r24;
    L98:
        r24 = r10;
        r8 = r123;
    L143:
        r24.close();     // Catch: Throwable -> L82
    L85:
        v4.i.f(r123);     // Catch: Throwable -> L121
        goto L109
    L82:
        th = move-exception;
        ((m) g()).k(th, r115, "close cursor failed", new Object[r114]);     // Catch: Throwable -> L121
        goto L85
    L153:
    L66:
        th = th;
        r115 = 5;
        r123 = r122;
        r114 = 0;
        goto L95
    L62:
        if (TextUtils.isEmpty(r211) == true) goto L68;
        JSONObject r38 = r111;
        r115 = 5;
        r123 = r122;
        r114 = 0;
        r(r38, (g) r11.a(), r14, r121, r214, r122, r211, r213, r212, r30, r31);     // Catch: Throwable -> L87
    L89:
        th = th;
        r123 = r122;
        r114 = 0;
        r115 = 5;
    L91:
        th = th;
        r123 = r25;
        r115 = 5;
        r114 = 0;
    L93:
        th = th;
        r24 = r19;
        r123 = r18;
        r114 = 0;
        r115 = 5;
    L96:
        th = th;
        r123 = r18;
        r114 = 0;
        r115 = 5;
    L99:
        th = th;
        r114 = 0;
        r115 = 5;
        r24 = null;
    L121:
        th = move-exception;
        throw th;
    }

    public final synchronized void o(JSONObject r20, m4.b r21, int r22) {
        monitor-enter(this);
        SQLiteDatabase r8 = null;
        if (this.f11470f == false) goto L7;
        x(null);     // Catch: Throwable -> L25
    L7:
        char r10 = 1;
        JSONArray[] r15 = new JSONArray[3];     // Catch: Throwable -> L17
        long[] r11 = new long[3];     // Catch: Throwable -> L17
        r8 = this.f11466b.getWritableDatabase();     // Catch: Throwable -> L17
        r8.beginTransaction();     // Catch: Throwable -> L17
        int r14 = 200;
        int r12 = 200;
    L9:
        if (r12 < r14) goto L14;
        r21.getClass();     // Catch: Throwable -> L17
        s(r8, r15, r11, 0);     // Catch: Throwable -> L17
        int r13 = r15[r10].length();     // Catch: Throwable -> L17
        if (r13 == 0) goto L14;
        i r16 = new i();     // Catch: Throwable -> L17
        r16.u(this.f11465a.f13937m.f11401i, r20, null, null, null, r15, r11, null, r21, r22);     // Catch: Throwable -> L17
        r21.getClass();     // Catch: Throwable -> L17
        z(r16, r8, 0);     // Catch: Throwable -> L17
        r14 = r14;
        r12 = r13;
        r10 = 1;
    L14:
        r8.setTransactionSuccessful();     // Catch: Throwable -> L17
    L15:
        v4.i.f(r8);     // Catch: Throwable -> L25
        monitor-exit(this);
        return;
    L17:
        th = move-exception;
        this.f11465a.f13937m.f11417y.b(i4.k.R, 1);     // Catch: Throwable -> L22
        this.f11465a.f13937m.f11417y.g("packByPriority failed", th);     // Catch: Throwable -> L22
        ((m) g()).k(th, 5, "pack by priority failed", new Object[0]);     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        v4.i.f(r8);     // Catch: Throwable -> L25
        throw th;     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        throw th;
    }

    public final void p(JSONObject r24, g r25, i r26, SQLiteDatabase r27, JSONArray[] r28, long[] r29, HashMap<String, JSONObject> r30, m4.b r31, int r32) {
        ((m) g()).l(5, null, "packCurrentData sid:{}", new Object[]{r25.f11452n});
        l6.a r22 = new l6.a();
        int r8 = t(0, r27, r25.f11452n, true, r28, r29, r31, r22);
        boolean r10 = l(r25.f11452n);
        JSONArray r19 = f(r25.f11452n, r30);
        y3.c r11 = this.f11465a;
        if (r10 == false) goto L5;
    L9:
        String r12 = r11.f13937m.f11401i;
        if (r10 == false) goto L12;
        g r13 = r25;
    L13:
        m4.b r14 = r31;
        SQLiteDatabase r15 = r27;
        i r16 = r26;
        r26.u(r12, r24, r13, null, null, r28, r29, r19, r31, r32);
        y(r16, true, r15, r14);
    L15:
        if (r32 == 13) goto L17;
        boolean r17 = true;
    L18:
        ((m) g()).t("packCurrentData isPackAllData = " + r17, new Object[0]);
        int r18 = r8;
    L20:
        if (r18 >= this.f11468d.length) goto L27;
        if (r17 == false) goto L32;
        i r110 = r16;
        SQLiteDatabase r111 = r15;
        m4.b r112 = r14;
        y3.c r113 = r11;
        r18 = t(r18, r27, r25.f11452n, true, r28, r29, r31, r22);
        if (i(r29) == false) goto L25;
        m4.b r20 = r112;
        r15 = r111;
        i r21 = r110;
        r26.u(r113.f13937m.f11401i, r24, null, null, null, r28, r29, null, r31, r32);
        boolean r23 = true;
        y(r21, true, r15, r20);
    L26:
        r11 = r113;
        r14 = r20;
        r17 = r17;
        r16 = r21;
        goto L20
    L25:
        r20 = r112;
        r15 = r111;
        r21 = r110;
        r23 = true;
        goto L26
    L32:
        return;
    L27:
        return;
    L17:
        r17 = false;
        goto L18
    L12:
        r13 = null;
        goto L13
    L5:
        if (i(r29) == true) goto L9;
        if (r19 != null) goto L9;
        r14 = r31;
        r15 = r27;
        r16 = r26;
        goto L15
    }

    public final void q(JSONObject r24, g r25, i r26, j r27, k r28, SQLiteDatabase r29, JSONArray[] r30, long[] r31, HashMap<String, JSONObject> r32, m4.b r33, int r34) {
        ((m) g()).l(5, null, "packHistoryData sid:{}", new Object[]{r25.f11452n});
        l6.a r21 = new l6.a();
        int r8 = t(0, r29, r25.f11452n, true, r30, r31, r33, r21);
        JSONArray r10 = v(r25, true, r28, r27, r29, r33, i(r31));
        boolean r11 = true;
        if (r10.length() <= 0) goto L5;
        boolean r12 = true;
    L6:
        r25.J = !r12;
        JSONArray r18 = f(r25.f11452n, r32);
        boolean r13 = r25.J;
        y3.c r14 = this.f11465a;
        if (r13 == true) goto L9;
        m4.b r15 = r33;
        SQLiteDatabase r16 = r29;
        i r17 = r26;
        g r19 = r25;
        r26.u(r14.f13937m.f11401i, r24, null, r28, r10, r30, r31, r18, r33, r34);
    L21:
        boolean r20 = true;
    L22:
        if (r20 == false) goto L24;
        y(r17, true, r16, r15);
    L24:
        int r22 = r8;
    L26:
        if (r22 >= this.f11468d.length) goto L32;
        i r110 = r17;
        SQLiteDatabase r111 = r16;
        m4.b r112 = r15;
        y3.c r113 = r14;
        boolean r114 = r11;
        r22 = t(r22, r29, r19.f11452n, true, r30, r31, r33, r21);
        if (i(r31) == false) goto L30;
        boolean r23 = r114;
        m4.b r35 = r112;
        SQLiteDatabase r36 = r111;
        r17 = r110;
        r26.u(r113.f13937m.f11401i, r24, null, null, null, r30, r31, null, r33, r34);
        y(r17, r23, r36, r35);
    L31:
        r16 = r36;
        r11 = r23;
        r15 = r35;
        r19 = r25;
        r14 = r113;
        goto L26
    L30:
        r23 = r114;
        r35 = r112;
        r36 = r111;
        r17 = r110;
        goto L31
    L32:
        return;
    L9:
        if (l(r25.f11452n) == false) goto L11;
        r15 = r33;
        r16 = r29;
        r17 = r26;
        g r37 = r25;
        r26.u(r14.f13937m.f11401i, r24, r25, null, null, r30, r31, r18, r33, r34);
    L19:
        r19 = r37;
        goto L21
    L11:
        r15 = r33;
        r16 = r29;
        r17 = r26;
        r37 = r25;
        if (i(r31) == true) goto L18;
        if (r18 != null) goto L15;
    L17:
        r19 = r37;
        r20 = false;
        goto L22
    L15:
        if (r18.length() <= 0) goto L17;
    L18:
        r26.u(r14.f13937m.f11401i, r24, null, null, null, r30, r31, r18, r33, r34);
        goto L19
    L5:
        r12 = false;
        goto L6
    }

    public final void r(JSONObject r23, g r24, k r25, j r26, i r27, SQLiteDatabase r28, String r29, JSONArray[] r30, long[] r31, m4.b r32, int r33) {
        ((m) g()).l(5, null, "packLostData exclude sid:{}", new Object[]{r29});
        r24.f11452n = r29;
        r27.f11452n = r29;
        l6.a r21 = new l6.a();
        int r8 = t(0, r28, r29, false, r30, r31, r32, r21);
        JSONArray r10 = v(r24, false, r25, r26, r28, r32, i(r31));
        boolean r11 = false;
        if (r10.length() <= 0) goto L5;
        boolean r12 = true;
    L6:
        r24.J = !r12;
        boolean r13 = i(r31);
        y3.c r14 = this.f11465a;
        if (r13 == false) goto L9;
    L12:
        String r15 = r14.f13937m.f11401i;
        boolean r16 = r24.J;
        if (r16 == true) goto L15;
        k r17 = r25;
    L16:
        if (r16 == false) goto L19;
        r10 = null;
    L19:
        m4.b r18 = r32;
        SQLiteDatabase r19 = r28;
        k r110 = r17;
        i r20 = r27;
        r27.u(r15, r23, null, r110, r10, r30, r31, null, r32, r33);
        y(r20, false, r19, r18);
    L20:
        int r22 = r8;
    L22:
        if (r22 >= this.f11468d.length) goto L28;
        SQLiteDatabase r111 = r19;
        i r112 = r20;
        m4.b r113 = r18;
        y3.c r114 = r14;
        boolean r115 = r11;
        r22 = t(r22, r28, r29, false, r30, r31, r32, r21);
        if (i(r31) == false) goto L26;
        boolean r34 = r115;
        m4.b r35 = r113;
        i r36 = r112;
        r19 = r111;
        r27.u(r114.f13937m.f11401i, r23, null, null, null, r30, r31, null, r32, r33);
        y(r36, r34, r19, r35);
    L27:
        r20 = r36;
        r11 = r34;
        r18 = r35;
        r14 = r114;
        goto L22
    L26:
        r34 = r115;
        r35 = r113;
        r36 = r112;
        r19 = r111;
        goto L27
    L28:
        return;
    L15:
        r17 = null;
        goto L16
    L9:
        if (r24.J == false) goto L12;
        r18 = r32;
        r19 = r28;
        r20 = r27;
        goto L20
    L5:
        r12 = false;
        goto L6
    }

    public final void s(SQLiteDatabase r11, JSONArray[] r12, long[] r13, int r14) {
        r4.a r8 = this.f11468d[1];
        JSONArray r10 = new JSONArray();
        Cursor r15 = null;
        long r16 = 0;
        r15 = r11.rawQuery("SELECT * FROM " + r8.i() + " WHERE priority=" + r14 + " ORDER BY _id LIMIT 200", null);     // Catch: Throwable -> L13
        int r17 = 0;
    L5:
        if (r15.moveToNext() == false) goto L30;
        if (r17 > 200) goto L30;
        r8.j(r15);     // Catch: Throwable -> L13
        r10.put(r8.m());     // Catch: Throwable -> L13
        long r18 = r8.f11449a;     // Catch: Throwable -> L13
        if (r18 <= r16) goto L12;
        r16 = r18;
    L12:
        r17 = r17 + 1;
    L30:
        r15.close();
    L31:
        r12[1] = r10;
        r13[1] = r16;
        return;
    L13:
        th = move-exception;
        boolean r19 = r8 instanceof e;     // Catch: Throwable -> L33
        y3.c r20 = this.f11465a;
        if (r19 == false) goto L19;
        i4.f r110 = r20.f13937m.f11417y;     // Catch: Throwable -> L33
        i4.k r21 = i4.k.f8255h0;     // Catch: Throwable -> L33
    L24:
        r110.b(r21, 1);     // Catch: Throwable -> L33
    L25:
        r20.f13937m.f11417y.g("queryEventByPriority failed", th);     // Catch: Throwable -> L33
        if ((th instanceof SQLiteBlobTooBigException) == false) goto L28;
        F();     // Catch: Throwable -> L33
    L28:
        ((m) g()).k(th, 5, "query event failed", new Object[0]);     // Catch: Throwable -> L33
        if (r15 == null) goto L31;
    L19:
        if ((r8 instanceof c) == false) goto L22;
        r110 = r20.f13937m.f11417y;     // Catch: Throwable -> L33
        r21 = i4.k.f8256i0;     // Catch: Throwable -> L33
        goto L24
    L22:
        if ((r8 instanceof d) == false) goto L25;
        r110 = r20.f13937m.f11417y;     // Catch: Throwable -> L33
        r21 = i4.k.f8257j0;     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        if (r15 == null) goto L36;
        r15.close();
    L36:
        throw th;
    }

    public final int t(int r19, SQLiteDatabase r20, String r21, boolean r22, JSONArray[] r23, long[] r24, m4.b r25, l6.a r26) {
        int r8 = 0;
    L3:
        String[] r10 = null;
        if (r8 >= r19) goto L6;
        r23[r8] = null;
        r24[r8] = 0;
        r8 = r8 + 1;
        goto L3
    L6:
        int r11 = 200;
        int r12 = r8;
        int r13 = 200;
    L7:
        if (r13 <= 0) goto L55;
        r4.a[] r14 = this.f11468d;
        if (r12 >= r14.length) goto L55;
        r4.a r15 = r14[r12];
        JSONArray r16 = new JSONArray();
        Cursor r17 = r20.rawQuery(B(r15, r21, r22, r13, r25), r10);     // Catch: Throwable -> L25
        int r18 = 0;
        long r110 = 0;
    L62:
    L23:
        th = th;
    L60:
        boolean r27 = r15 instanceof e;     // Catch: Throwable -> L51
        y3.c r28 = this.f11465a;
        if (r27 == false) goto L35;
        i4.f r29 = r28.f13937m.f11417y;     // Catch: Throwable -> L51
        i4.k r30 = i4.k.f8255h0;     // Catch: Throwable -> L51
    L40:
        r29.b(r30, 1);     // Catch: Throwable -> L51
    L41:
        r28.f13937m.f11417y.g("queryEvent failed", th);     // Catch: Throwable -> L51
        if ((th instanceof SQLiteBlobTooBigException) == false) goto L44;
        F();     // Catch: Throwable -> L51
    L44:
        ((m) g()).k(th, 5, "query event failed", new Object[0]);     // Catch: Throwable -> L51
        if (r17 == null) goto L47;
    L46:
        r17.close();
    L47:
        r23[r12] = r16;
        r24[r12] = r110;
        r13 = r13 - r16.length();
        if (r13 <= 0) goto L50;
        r12 = r12 + 1;
    L50:
        r10 = null;
        r11 = 200;
        goto L7
    L35:
        if ((r15 instanceof c) == false) goto L38;
        r29 = r28.f13937m.f11417y;     // Catch: Throwable -> L51
        r30 = i4.k.f8256i0;     // Catch: Throwable -> L51
        goto L40
    L38:
        if ((r15 instanceof d) == false) goto L41;
        r29 = r28.f13937m.f11417y;     // Catch: Throwable -> L51
        r30 = i4.k.f8257j0;     // Catch: Throwable -> L51
    L51:
        th = move-exception;
        if (r17 == null) goto L54;
        r17.close();
    L54:
        throw th;
    L16:
        if (r17.moveToNext() == false) goto L46;
        if (r18 > r11) goto L46;
        r15.j(r17);     // Catch: Throwable -> L23
        r16.put(r15.m());     // Catch: Throwable -> L23
        long r31 = r15.f11449a;     // Catch: Throwable -> L23
        if (r31 <= r110) goto L22;
        r110 = r31;
    L22:
        r18 = r18 + 1;
        r11 = 200;
    L25:
        th = th;
    L29:
        r17 = null;
        r110 = 0;
    L27:
        th = th;
    L55:
        int r32 = r12 + 1;
    L57:
        if (r32 >= r23.length) goto L59;
        r23[r32] = null;
        r24[r32] = 0;
        r32 = r32 + 1;
        goto L57
    L59:
        return r12;
    }

    public final synchronized ArrayList u() {
        monitor-enter(this);
        Cursor r8 = null;
        if (this.f11470f == false) goto L6;
        x(null);     // Catch: Throwable -> L20
    L6:
        ArrayList r10 = new ArrayList();     // Catch: Throwable -> L20
        r8 = this.f11466b.getWritableDatabase().rawQuery("SELECT * FROM forward_eventv3 ORDER BY _id ASC LIMIT 1000", null);     // Catch: Throwable -> L12
    L9:
        if (r8.moveToNext() == false) goto L14;
        f r11 = new f();     // Catch: Throwable -> L12
        r11.j(r8);     // Catch: Throwable -> L12
        r10.add(r11);     // Catch: Throwable -> L12
    L14:
        v4.i.b(r8);     // Catch: Throwable -> L20
        monitor-exit(this);
        return r10;
    L12:
        th = move-exception;
        m r12 = (m) g();     // Catch: Throwable -> L17
        r12.k(th, 5, "pack forward events failed", new Object[0]);     // Catch: Throwable -> L17
        this.f11465a.f13937m.f11417y.g("queryForwardEvents failed", th);     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        v4.i.b(r8);     // Catch: Throwable -> L20
        throw th;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        throw th;
    }

    public final JSONArray v(g r21, boolean r22, k r23, j r24, SQLiteDatabase r25, m4.b r26, boolean r27) {
        y3.c r8 = this.f11465a;
        JSONArray r10 = new JSONArray();
        if (r26 == null) goto L99;
        r26.getClass();
        return r10;
    L99:
        Cursor r11 = r25.rawQuery(D(r21.f11452n, r22), null);     // Catch: Throwable -> L54
        HashMap r12 = new HashMap(8);     // Catch: Throwable -> L52
        long r13 = 0;
        String r14 = null;
        String r15 = null;
        String r16 = null;
    L103:
    L49:
        th = th;
        r11 = r11;
    L51:
        r11 = r11;
    L91:
        ((m) g()).k(th, 5, "query page failed", new Object[0]);     // Catch: Throwable -> L85
        r8.f13937m.f11417y.b(i4.k.f8258k0, 1);     // Catch: Throwable -> L85
        r8.f13937m.f11417y.g("query page failed", th);     // Catch: Throwable -> L85
        if (r11 == null) goto L60;
    L59:
        r11.close();
    L60:
        String r17 = r16;
        if (r10.length() > 0) goto L63;
    L84:
        return r10;
    L63:
        if (r13 > 1000) goto L66;
        r13 = 1000;
    L66:
        r23.getClass();
        long r18 = i4.h.f8231a.incrementAndGet();
        r23.A = r18;
        r23.B = r18;
        r23.f11461w = r8.f13937m.f11401i;
        r23.H = r13;
        if (r22 == false) goto L69;
        r23.f11452n = r21.f11452n;
        long r19 = r21.f11450b;
    L70:
        r23.l(r19);
        long r20 = r21.f11453o;
        y3.j r28 = r8.f13945u;
        r28.b(r23, r20);
        r23.f11455q = r21.f11455q;
        r23.I = r23.f11450b + r13;
        r23.f11451m = r28.f13980f.incrementAndGet();
        r23.J = null;
        if (TextUtils.isEmpty(r21.K) == true) goto L74;
        r23.J = r21.K;
    L76:
        r3.c r29 = r8.f13937m;
        r23.C = l6.a.S(r29.f11417y, r23);
        r23.K = r15;
        r29.f11417y.b(i4.k.f8262n, 1);
        if (r23.C <= 0) goto L93;
        l6.a.P0(r29.f11417y, i4.a.f8137m, r23);
    L93:
        r29.f11393a.c(-1, r23.f11452n, r23.m());     // Catch: Throwable -> L81
    L83:
        l.d(r23, "event_receive");
    L81:
        th = move-exception;
        ((m) g()).k(th, 5, "notify session terminate failed", new Object[0]);
        r29.f11417y.g("notify onSessionTerminate failed", th);
        goto L83
    L74:
        if (TextUtils.isEmpty(r17) == true) goto L76;
        r23.J = r17;
        r23.f11455q = r14;
        goto L76
    L69:
        r23.f11452n = UUID.randomUUID().toString();
        r19 = 0;
    L85:
        th = move-exception;
        if (r11 == null) goto L88;
        r11.close();
    L88:
        throw th;
    L11:
        if (r11.moveToNext() == false) goto L59;
        r24.j(r11);     // Catch: Throwable -> L49
        r11 = r11;
        String r110 = r14;
        ((m) g()).l(5, null, "queryPage: {}", new Object[]{r24});     // Catch: Throwable -> L46
        Integer r30 = (Integer) r12.get(r24.J);     // Catch: Throwable -> L46
        if (r24.H != (-1)) goto L17;
        boolean r31 = true;
    L18:
        if (r31 == false) goto L19;
        if (r30 == null) goto L44;
        Integer r32 = Integer.valueOf(r30.intValue() - 1);     // Catch: Throwable -> L46
        if (r32.intValue() <= 0) goto L43;
        r12.put(r24.J, r32);     // Catch: Throwable -> L46
    L45:
        r14 = r110;
        goto L103
    L43:
        r12.remove(r24.J);     // Catch: Throwable -> L46
        goto L45
    L44:
        r24.H = 1000;     // Catch: Throwable -> L46
        r13 = r13 + 1000;     // Catch: Throwable -> L46
        r10.put(r24.m());     // Catch: Throwable -> L46
        goto L45
    L19:
        String r33 = r24.J;     // Catch: Throwable -> L46
        if (r30 == null) goto L22;
        int r34 = r30.intValue() + 1;     // Catch: Throwable -> L46
    L23:
        r12.put(r33, Integer.valueOf(r34));     // Catch: Throwable -> L46
        long r35 = r24.H;     // Catch: Throwable -> L46
        if (r35 < 1000) goto L26;
        r13 = r13 + r35;     // Catch: Throwable -> L46
    L27:
        r10.put(r24.m());     // Catch: Throwable -> L46
        if (TextUtils.isEmpty(r24.L) == true) goto L34;
        String r36 = r24.L;     // Catch: Throwable -> L46
        r16 = r36;
        r14 = r24.f11455q;     // Catch: Throwable -> L32
    L89:
        r15 = r24.M;     // Catch: Throwable -> L37
    L37:
        th = th;
    L32:
        th = th;
        r11 = r11;
        r16 = r36;
        r14 = r110;
        goto L91
    L34:
        r14 = r110;
        goto L89
    L26:
        r13 = r13 + 1000;     // Catch: Throwable -> L46
        goto L27
    L22:
        r34 = 1;
        goto L23
    L17:
        r31 = false;
    L46:
        th = th;
        r14 = r110;
    L52:
        th = th;
        r11 = r11;
    L56:
        r13 = 0;
        r14 = null;
        r15 = null;
        r16 = null;
    L54:
        th = th;
        r11 = null;
        goto L56
    }

    public final void w(r4.a r8) {
        String r10 = r8.i();
        this.f11467c.put(r10, r8);
    }

    public final synchronized void x(ArrayList r8) {
        monitor-enter(this);
    L25:
        th = move-exception;
        throw th;
    L4:
        if (this.f11470f == true) goto L8;
        A(r8);     // Catch: Throwable -> L25
        monitor-exit(this);
        return;
    L8:
        if (r8 != null) goto L10;
        int r10 = 0;
    L13:
        if ((this.f11477m.size() + r10) != 0) goto L16;
        monitor-exit(this);
        return;
    L16:
        ArrayList<r4.a> r11 = new ArrayList(this.f11477m);     // Catch: Throwable -> L25
        this.f11477m.clear();     // Catch: Throwable -> L25
        if (r10 <= 0) goto L20;
        r11.addAll(r8);     // Catch: Throwable -> L25
    L20:
        if (h() == null) goto L22;
        h().removeCallbacksAndMessages(null);     // Catch: Throwable -> L25
    L22:
        A(r11);     // Catch: Throwable -> L25
        monitor-exit(this);
        return;
    L10:
        r10 = r8.size();     // Catch: Throwable -> L25
        goto L13
    }

    public final void y(i r12, boolean r13, SQLiteDatabase r14, m4.b r15) {
        y3.c r8 = this.f11465a;
        boolean r10 = false;
        if (r14 == null) goto L36;
    L7:
        if (r10 == false) goto L9;
        r14.beginTransaction();     // Catch: Throwable -> L5
    L9:
        Iterator r11 = E(r12).iterator();     // Catch: Throwable -> L5
    L11:
        if (r11.hasNext() == false) goto L13;
        k(r14, (i) r11.next(), r13);     // Catch: Throwable -> L5
        goto L11
    L13:
        long r16 = r12.K;     // Catch: Throwable -> L5
        if (r16 <= 0) goto L16;
        r14.execSQL(c("event", r12.f11452n, r13, r16, r15));     // Catch: Throwable -> L5
    L16:
        long r17 = r12.M;     // Catch: Throwable -> L5
        if (r17 <= 0) goto L19;
        r14.execSQL(c("eventv3", r12.f11452n, r13, r17, r15));     // Catch: Throwable -> L5
    L19:
        long r18 = r12.S;     // Catch: Throwable -> L5
        if (r18 <= 0) goto L22;
        r14.execSQL(c("event_misc", r12.f11452n, r13, r18, r15));     // Catch: Throwable -> L5
    L22:
        if (r10 == false) goto L24;
        r14.setTransactionSuccessful();     // Catch: Throwable -> L5
    L5:
        th = move-exception;
        ((m) g()).l(5, null, "delete pack data failed", new Object[]{th});     // Catch: Throwable -> L30
        r8.f13937m.f11417y.b(i4.k.O, 1);     // Catch: Throwable -> L30
        r8.f13937m.f11417y.g("saveAndDeleteDataFromPack failed", th);     // Catch: Throwable -> L30
        if (r10 == false) goto L40;
    L28:
        v4.i.f(r14);
        return;
    L40:
        return;
    L30:
        th = move-exception;
        if (r10 == false) goto L33;
        v4.i.f(r14);
    L33:
        throw th;
    L24:
        if (r10 == true) goto L28;
        return;
    L36:
        r14 = this.f11466b.getWritableDatabase();     // Catch: Throwable -> L5
        r10 = true;
        goto L7
    }

    public final void z(i r8, SQLiteDatabase r10, int r11) {
        y3.c r12 = this.f11465a;
        Iterator r13 = E(r8).iterator();     // Catch: Throwable -> L11
    L5:
        if (r13.hasNext() == false) goto L7;
        k(r10, (i) r13.next(), false);     // Catch: Throwable -> L11
        goto L5
    L7:
        long r14 = r8.M;     // Catch: Throwable -> L11
        if (r14 <= 0) goto L17;
        r10.execSQL("DELETE FROM eventv3 WHERE _id<=" + r14 + " AND priority=" + r11);     // Catch: Throwable -> L11
        return;
    L17:
        return;
    L11:
        th = move-exception;
        ((m) g()).l(5, null, "delete pack data failed", new Object[]{th});
        r12.f13937m.f11417y.b(i4.k.O, 1);
        r12.f13937m.f11417y.g("saveAndDeleteDataFromPriorityPack " + r11 + " failed", th);
    }
}
