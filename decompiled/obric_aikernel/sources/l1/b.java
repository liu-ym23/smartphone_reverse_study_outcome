package l1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.CursorWindow;
import android.database.sqlite.SQLiteBlobTooBigException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import com.bytedance.applog.monitor.MonitorKey;
import com.bytedance.applog.monitor.MonitorState;
import com.bytedance.crash.constants.Constants;
import f1.m;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import o1.p;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a1.c f10845a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a f10846b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final HashMap<String, l1.a> f10847c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final l1.a[] f10848d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f10849e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final C0229b[] f10850f;

    private class a extends SQLiteOpenHelper {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ b f10851c;

        a(@Nullable b r10, @Nullable Context r11, @Nullable String r12, SQLiteDatabase.CursorFactory r13, int r14) {
            this.f10851c = r10;
            super(r11, r12, r13, r14);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase r10) {
            r10.beginTransaction();     // Catch: Throwable -> L10
            Iterator r11 = b.a(this.f10851c).values().iterator();     // Catch: Throwable -> L10
        L4:
            if (r11.hasNext() == false) goto L8;
            String r12 = ((l1.a) r11.next()).d();     // Catch: Throwable -> L10
            if (r12 == null) goto L4;
            r10.execSQL(r12);     // Catch: Throwable -> L10
            goto L4
        L8:
            r10.setTransactionSuccessful();     // Catch: Throwable -> L10
        L12:
            p.e(r10);
            return;
        L10:
            th = move-exception;
            b.b(this.f10851c).v(5, "create db failed", th, new Object[0]);     // Catch: Throwable -> L14
        L14:
            th = move-exception;
            p.e(r10);
            throw th;
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onDowngrade(SQLiteDatabase r10, int r11, int r12) {
            onUpgrade(r10, r11, r12);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase r10, int r11, int r12) {
            b.b(this.f10851c).h(5, "onUpgrade, " + r11 + ", " + r12, new Object[0]);
            r10.beginTransaction();     // Catch: Throwable -> L9
            Iterator r13 = b.a(this.f10851c).values().iterator();     // Catch: Throwable -> L9
        L5:
            if (r13.hasNext() == false) goto L7;
            r10.execSQL("DROP TABLE IF EXISTS " + ((l1.a) r13.next()).q());     // Catch: Throwable -> L9
            goto L5
        L7:
            r10.setTransactionSuccessful();     // Catch: Throwable -> L9
        L11:
            p.e(r10);
            onCreate(r10);
            return;
        L9:
            th = move-exception;
            b.b(this.f10851c).v(5, "upgrade db failed", th, new Object[0]);     // Catch: Throwable -> L13
        L13:
            th = move-exception;
            p.e(r10);
            throw th;
        }
    }

    /* JADX INFO: renamed from: l1.b$b, reason: collision with other inner class name */
    class C0229b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f10852a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f10853b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f10854c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f10855d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ b f10856e;

        C0229b(b r10) {
            this.f10856e = r10;
        }

        static /* synthetic */ void a(C0229b r10, l1.a r11, int r12) {
            r10.b(r11, r12);
        }

        private void b(l1.a r10, int r11) {
            String r12 = r10.l();
            if (r12 != null) goto L5;
            return;
        L5:
            if (r12.length() <= this.f10853b) goto L8;
            this.f10852a = r10.m();
            this.f10853b = r12.length();
        L8:
            if (r12.length() < 50000) goto L10;
            b.d(this.f10856e).s().R().h(b.c(r11), MonitorState.f_log_size_limit);
        L10:
            this.f10855d += r12.length();
        }

        public String toString() {
            StringBuilder r10 = new StringBuilder(this.f10854c);
            r10.append("-");
            r10.append(this.f10855d);
            r10.append("-");
            r10.append(this.f10852a);
            r10.append("-");
            r10.append(this.f10853b);
            return r10.toString();
        }
    }

    public b(a1.c r10, String r11) {
        this.f10847c = new HashMap();
        l1.a[] r12 = l1.a.i();
        this.f10848d = r12;
        this.f10846b = new a(this, r10.w(), r11, null, 51);
        this.f10845a = r10;
        C(new h());
        C(new f());
        C(new i());
        C(new g());
        int r13 = r12.length;
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L5;
        C(r12[r14]);
        r14 = r14 + 1;
        goto L3
    L5:
        this.f10850f = new C0229b[]{new C0229b(this), new C0229b(this), new C0229b(this)};
    }

    private JSONArray A(f r21, boolean r22, i r23, h r24, SQLiteDatabase r25, h1.b r26, boolean r27) {
        JSONArray r10 = new JSONArray();
        if (r26 == null) goto L10;
        int r11 = r26.f();
        if (r11 != 0) goto L7;
    L9:
        return r10;
    L7:
        if ((-1) == r11) goto L10;
        if (r27 == false) goto L9;
    L10:
        long r12 = 1000;
        Cursor r13 = r25.rawQuery(I(r21.f10830i, r22), null);     // Catch: Throwable -> L43
        HashMap r14 = new HashMap(8);     // Catch: Throwable -> L41
        String r17 = null;
        String r18 = null;
        long r15 = 0;
    L80:
        if (r13.moveToNext() == false) goto L48;
        r24.r(r13);     // Catch: Throwable -> L39
        n().h(5, "queryPage, " + r24, new Object[0]);     // Catch: Throwable -> L39
        Integer r16 = (Integer) r14.get(r24.B);     // Catch: Throwable -> L39
        int r19 = 1;
        if (r24.G() == true) goto L32;
        String r20 = r24.B;     // Catch: Throwable -> L39
        if (r16 == null) goto L21;
        r19 = 1 + r16.intValue();     // Catch: Throwable -> L39
    L21:
        r14.put(r20, Integer.valueOf(r19));     // Catch: Throwable -> L39
        long r28 = r24.f10865z;     // Catch: Throwable -> L39
        if (r28 < 1000) goto L24;
        r15 = r15 + r28;     // Catch: Throwable -> L39
    L25:
        r10.put(r24.z());     // Catch: Throwable -> L39
        if (TextUtils.isEmpty(r24.D) == true) goto L80;
        String r29 = r24.D;     // Catch: Throwable -> L39
        r17 = r29;
        r18 = r24.f10833l;     // Catch: Throwable -> L30
    L30:
        th = th;
        r17 = r29;
    L78:
        n().v(5, "query page failed", th, new Object[0]);     // Catch: Throwable -> L70
        if (r13 != null) goto L48;
    L49:
        String r30 = r17;
        String r31 = r18;
        if (r10.length() > 0) goto L52;
    L69:
        return r10;
    L52:
        if (r15 <= 1000) goto L54;
        r12 = r15;
    L54:
        r23.f10843v = p.k();
        r23.u(this.f10845a.s().getAppId());
        r23.f10866z = r12;
        if (r22 == false) goto L57;
        r23.f10830i = r21.f10830i;
        long r110 = r21.f10828g;
    L58:
        r23.x(r110);
        this.f10845a.C().b(r23, r21.f10831j);
        r23.f10833l = r21.f10833l;
        r23.A = r23.f10828g + r12;
        r23.f10829h = this.f10845a.C().m();
        r23.B = null;
        if (TextUtils.isEmpty(r21.C) == true) goto L62;
        r23.B = r21.C;
    L76:
        this.f10845a.s().V().c(-1, r23.f10830i, r23.z());     // Catch: Throwable -> L66
    L68:
        m.e("event_receive", r23);
    L66:
        th = move-exception;
        n().v(5, "notify session terminate failed", th, new Object[0]);
        goto L68
    L62:
        if (TextUtils.isEmpty(r30) == true) goto L76;
        r23.B = r30;
        r23.f10833l = r31;
        goto L76
    L57:
        r23.f10830i = UUID.randomUUID().toString();
        r110 = 0;
    L70:
        th = move-exception;
        if (r13 == null) goto L73;
        r13.close();
    L73:
        throw th;
    L24:
        r15 = r15 + 1000;     // Catch: Throwable -> L39
        goto L25
    L32:
        if (r16 == null) goto L37;
        Integer r32 = Integer.valueOf(r16.intValue() - 1);     // Catch: Throwable -> L39
        if (r32.intValue() <= 0) goto L36;
        r14.put(r24.B, r32);     // Catch: Throwable -> L39
        goto L80
    L36:
        r14.remove(r24.B);     // Catch: Throwable -> L39
        goto L80
    L37:
        r24.f10865z = 1000;     // Catch: Throwable -> L39
        r15 = r15 + 1000;     // Catch: Throwable -> L39
        r10.put(r24.z());     // Catch: Throwable -> L39
    L48:
        r13.close();
    L39:
        th = th;
    L41:
        th = th;
    L45:
        r15 = 0;
        r17 = null;
        r18 = null;
    L43:
        th = th;
        r13 = null;
        goto L45
    }

    private void B(Throwable r10) {
        if ((r10 instanceof SQLiteException) == false) goto L6;
        this.f10845a.s().R().h(MonitorKey.database, MonitorState.f_exception);
        return;
    }

    private void C(l1.a r10) {
        this.f10847c.put(r10.q(), r10);
    }

    private void D() {
        C0229b[] r10 = this.f10850f;
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        C0229b r13 = r10[r12];
        r13.f10852a = "";
        r13.f10853b = 0;
        r13.f10854c = 0;
        r13.f10855d = 0;
        r12 = r12 + 1;
        goto L3
    }

    private String F(l1.a r10, String r11, boolean r12, int r13, h1.b r14) {
        StringBuilder r15 = new StringBuilder("SELECT * FROM " + r10.q() + " WHERE session_id");
        if (r12 == false) goto L5;
        String r16 = "='";
    L6:
        r15.append(r16);
        r15.append(r11);
        if (r14 == null) goto L13;
        int r17 = r14.f();
        if ((-1) != r17) goto L11;
        StringBuilder r18 = new StringBuilder();
        r18.append("' AND (priority=");
        r18.append(r17);
        r18.append(" OR ");
        r18.append("priority");
        r18.append(">");
        r18.append(r14.e());
        r18.append(")");
    L12:
        String r19 = r18.toString();
    L14:
        r15.append(r19);
        r15.append(" ORDER BY _id LIMIT " + r13);
        return r15.toString();
    L11:
        r18 = new StringBuilder();
        r18.append("' AND priority=");
        r18.append(r17);
        goto L12
    L13:
        r19 = "'";
        goto L14
    L5:
        r16 = "!='";
        goto L6
    }

    private String G(int r10) {
        return "SELECT * FROM launch ORDER BY _id DESC LIMIT " + r10;
    }

    private String H(int r10, h1.b r11) {
        StringBuilder r12 = new StringBuilder("SELECT * FROM pack");
        if (r11 == null) goto L9;
        int r13 = r11.f();
        if ((-1) != r13) goto L7;
        String r14 = " WHERE priority=" + r13 + " OR priority>" + r11.e();
    L8:
        r12.append(r14);
        goto L9
    L7:
        r14 = " WHERE priority=" + r13;
    L9:
        r12.append(" ORDER BY _id DESC LIMIT " + r10);
        return r12.toString();
    }

    private String I(String r10, boolean r11) {
        StringBuilder r12 = new StringBuilder();
        r12.append("SELECT * FROM page WHERE session_id");
        if (r11 == false) goto L5;
        String r13 = "='";
    L6:
        r12.append(r13);
        r12.append(r10);
        r12.append("' ORDER BY ");
        if (r11 == false) goto L9;
        String r14 = "session_id,";
    L10:
        r12.append(r14);
        r12.append("duration");
        r12.append(" DESC LIMIT 1000");
        return r12.toString();
    L9:
        r14 = "";
        goto L10
    L5:
        r13 = "!='";
        goto L6
    }

    private List<g> K(g r10) {
        ArrayList r11 = new ArrayList();
        if (this.f10845a.s().a0() == true) goto L5;
    L9:
        r11.add(r10);
    L11:
        if (this.f10845a.v().E() == false) goto L17;
        ArrayList r12 = new ArrayList();
        Iterator r13 = r11.iterator();
    L14:
        if (r13.hasNext() == false) goto L16;
        r12.addAll(((g) r13.next()).a0(this.f10845a.v().v()));
        goto L14
    L16:
        return r12;
    L17:
        return r11;
    L5:
        if (this.f10845a.s().z() == null) goto L9;
        Collection<g> r14 = r10.Z(this.f10845a.s().z());
        if (r14 == null) goto L9;
        n().h(5, "Pack split to {} packs for data isolate: {}", new Object[]{Integer.valueOf(r14.size()), this.f10845a.s().z()});
        r11.addAll(r14);
        goto L11
    }

    private void L(MonitorKey r10) {
        Field r11 = CursorWindow.class.getDeclaredField("sCursorWindowSize");     // Catch: Throwable -> L10
        r11.setAccessible(true);     // Catch: Throwable -> L10
        int r12 = r11.getInt(null);     // Catch: Throwable -> L10
        if (r12 > 0) goto L5;
    L8:
        com.bytedance.applog.monitor.a r13 = this.f10845a.s().R();     // Catch: Throwable -> L10
        MonitorState r14 = MonitorState.cursor_window_size_overflow;     // Catch: Throwable -> L10
    L7:
        r13.h(r10, r14);     // Catch: Throwable -> L10
        return;
    L5:
        if (r12 > 8388608) goto L8;
        r11.setInt(null, r12 * 2);     // Catch: Throwable -> L10
        r13 = this.f10845a.s().R();     // Catch: Throwable -> L10
        r14 = MonitorState.increase_cursor_window_size;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        n().v(5, "tryIncreaseCursorWindowSize", th, new Object[0]);
    }

    static /* synthetic */ HashMap a(b r10) {
        return r10.f10847c;
    }

    static /* synthetic */ f1.g b(b r10) {
        return r10.n();
    }

    static /* synthetic */ MonitorKey c(int r10) {
        return o(r10);
    }

    static /* synthetic */ a1.c d(b r10) {
        return r10.f10845a;
    }

    private void e(HashMap<String, JSONObject> r10) {
        if (r10.isEmpty() == true) goto L16;
        Iterator<Map.Entry<String, JSONObject>> r11 = r10.entrySet().iterator();
    L6:
        if (r11.hasNext() == false) goto L20;
        Map.Entry<String, JSONObject> r12 = r11.next();
        JSONObject r13 = r12.getValue();
        if (r13 == null) goto L14;
        JSONArray r14 = r13.optJSONArray("item_impression");
        if (r14 == null) goto L14;
        if (r14.length() <= 0) goto L14;
        int r15 = r14.length();
    L15:
        n().h(5, "lost impression for launch: " + r12.getKey() + ", count: " + r15, new Object[0]);
        this.f10845a.s().R().j(MonitorKey.pack, MonitorState.f_lost_impression, r15);
    L14:
        r15 = 0;
        goto L15
    L20:
        return;
    }

    private JSONObject f(f r10, JSONObject r11) {
        if (TextUtils.equals(r10.A, this.f10845a.y().i()) == true) goto L5;
    L11:
        JSONObject r12 = new JSONObject();     // Catch: JSONException -> L8
        p.c(r12, r11);     // Catch: JSONException -> L8
        r12.put("app_version", r10.A);     // Catch: JSONException -> L8
        r12.put("version_code", r10.f10860z);     // Catch: JSONException -> L8
        return r12;
    L8:
        e = move-exception;
        n().v(5, "check version failed", e, new Object[0]);
        return r11;
    L5:
        if (r10.f10860z != this.f10845a.y().h()) goto L11;
        return r11;
    }

    private void h(SQLiteDatabase r10, HashMap<String, JSONObject> r11, h1.b r12) {
        if (r12 != null) goto L5;
    L7:
        f r13 = (f) this.f10847c.get(Constants.LAUNCH_TAG);
        if (r13 != null) goto L10;
        return;
    L10:
        Cursor r14 = null;
        r14 = r10.rawQuery(G(3), null);     // Catch: Throwable -> L24
        boolean r15 = r14.moveToLast();     // Catch: Throwable -> L24
    L12:
        if (r15 == false) goto L41;
        r13.r(r14);     // Catch: Throwable -> L24
        JSONObject r16 = new JSONObject();     // Catch: Throwable -> L24
        this.f10845a.s().V().a(r13.f10827c, r13.f10830i, r16);     // Catch: Throwable -> L16
    L18:
        r11.put(r13.f10830i, r16);     // Catch: Throwable -> L24
        r15 = r14.moveToPrevious();     // Catch: Throwable -> L24
    L16:
        th = move-exception;
        n().h(5, "onSessionBatchEvent failed", new Object[]{th});     // Catch: Throwable -> L24
        goto L18
    L41:
        r14.close();     // Catch: Throwable -> L22
        return;
    L22:
        th = move-exception;
        n().h(5, "close cursor failed", new Object[]{th});
        return;
    L24:
        th = move-exception;
        n().h(5, "collect impression failed", new Object[]{th});     // Catch: Throwable -> L32
        if (r14 == null) goto L54;
        r14.close();     // Catch: Throwable -> L29
        return;
    L29:
        th = move-exception;
        n().h(5, "close cursor failed", new Object[]{th});
        return;
    L54:
        return;
    L32:
        th = move-exception;
        if (r14 != null) goto L47;
    L38:
        throw th;
    L47:
        r14.close();     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        n().h(5, "close cursor failed", new Object[]{th});
        goto L38
    L5:
        if (r12.f() == (-1)) goto L7;
    }

    private String i(String r10, String r11, boolean r12, long r13, h1.b r14) {
        StringBuilder r15 = new StringBuilder("DELETE FROM " + r10 + " WHERE session_id");
        if (r12 == false) goto L5;
        String r16 = "='";
    L6:
        r15.append(r16);
        r15.append(r11 + "' AND _id<=" + r13);
        if (r14 == null) goto L14;
        int r17 = r14.f();
        if ((-1) != r17) goto L11;
        StringBuilder r18 = new StringBuilder();
        r18.append(" AND (priority=");
        r18.append(r17);
        r18.append(" OR ");
        r18.append("priority");
        r18.append(">");
        r18.append(r14.e());
        r18.append(")");
    L12:
        r15.append(r18.toString());
        goto L14
    L11:
        r18 = new StringBuilder();
        r18.append(" AND priority=");
        r18.append(r17);
    L14:
        return r15.toString();
    L5:
        r16 = "!='";
        goto L6
    }

    private String j(String r10, boolean r11) {
        StringBuilder r12 = new StringBuilder();
        r12.append("DELETE FROM page WHERE session_id");
        if (r11 == false) goto L5;
        String r13 = "='";
    L6:
        r12.append(r13);
        r12.append(r10);
        r12.append("'");
        return r12.toString();
    L5:
        r13 = "!='";
        goto L6
    }

    private String l(long r10, int r11) {
        return "UPDATE pack SET _fail=" + r11 + " WHERE _id=" + r10;
    }

    private JSONArray m(String r10, HashMap<String, JSONObject> r11, h1.b r12) {
        JSONArray r13 = null;
        if (r12 != null) goto L5;
    L7:
        JSONObject r14 = r11.remove(r10);
        if (r14 == null) goto L15;
        JSONArray r15 = r14.optJSONArray("item_impression");
        if (r15 != null) goto L12;
    L14:
        r13 = r15;
        goto L15
    L12:
        if (r15.length() != 0) goto L14;
    L15:
        if (r13 == null) goto L20;
        if (r13.length() == 0) goto L20;
        this.f10845a.s().R().j(MonitorKey.item_impression, MonitorState.init, r13.length());
    L20:
        if (o1.h.d(this.f10845a.s().getAppId()) == false) goto L23;
        if (r13 == null) goto L23;
        o1.h.e(this.f10845a.s().getAppId(), "item_impression", r13);
    L23:
        return r13;
    L5:
        if (r12.f() == (-1)) goto L7;
        return null;
    }

    private f1.g n() {
        return this.f10845a.s().P();
    }

    private static MonitorKey o(int r10) {
        MonitorKey r11 = MonitorKey.event_v3;
        if (r10 == 0) goto L9;
        if (r10 == 2) goto L10;
        return r11;
    L10:
        return MonitorKey.log_data;
    L9:
        return MonitorKey.event;
    }

    private boolean p(long[] r10) {
        if (r10[0] > 0) goto L9;
        if (r10[1] > 0) goto L9;
        if (r10[2] > 0) goto L9;
        return false;
    L9:
        return true;
    }

    private void q(SQLiteDatabase r10, h1.b r11, g r12, boolean r13) {
        com.bytedance.applog.monitor.a r14 = this.f10845a.s().R();
        MonitorKey r15 = MonitorKey.pack;
        r14.h(r15, MonitorState.init);
        long r16 = r10.insert("pack", null, r12.A(null));
        if (r16 >= 0) goto L19;
        if (r12.G == null) goto L10;
        r(null, r11, true);
        if (r12.G.B == true) goto L10;
        this.f10845a.s().R().h(MonitorKey.launch, MonitorState.f_db_insert);
    L10:
        if (r12.I == null) goto L16;
        JSONArray r17 = r12.H;
        if (r17 == null) goto L16;
        if (r17.length() <= 0) goto L16;
        this.f10845a.s().R().h(MonitorKey.terminate, MonitorState.f_db_insert);
    L16:
        this.f10845a.s().R().h(r15, MonitorState.f_db_insert);
        r12.U(MonitorKey.f_db_insert_event);
        n().q(5, "insert to db failed, pack: " + r12 + ", result: " + r16, new Object[0]);
        throw new SQLiteException("insert pack to db failed for result id < 0.");
    L19:
        if (r12.I == null) goto L26;
        JSONArray r18 = r12.H;
        if (r18 != null) goto L23;
        return;
    L23:
        if (r18.length() <= 0) goto L28;
        r10.execSQL(j(r12.f10830i, r13));
        return;
    L28:
        return;
    }

    private boolean r(String r10, h1.b r11, boolean r12) {
        f1.g r13 = n();
        StringBuilder r14 = new StringBuilder();
        r14.append("needLaunch, ");
        r14.append(this.f10849e);
        r14.append(", ");
        r14.append(r10);
        r14.append(", ");
        r14.append(r12);
        r14.append(", ");
        if (r11 == null) goto L5;
        Object r15 = Integer.valueOf(r11.f());
    L6:
        r14.append(r15);
        r13.h(5, r14.toString(), new Object[0]);
        if (r11 == null) goto L15;
        int r16 = r11.f();
        if (r16 != 0) goto L11;
    L13:
        return false;
    L11:
        if ((-1) == r16) goto L15;
        if (r12 == false) goto L13;
    L15:
        if (TextUtils.equals(r10, this.f10849e) == true) goto L18;
        this.f10849e = r10;
        return true;
    L18:
        return false;
    L5:
        r15 = "null";
        goto L6
    }

    private void u(JSONObject r23, f r24, g r25, SQLiteDatabase r26, JSONArray[] r27, long[] r28, HashMap<String, JSONObject> r29, h1.b r30, int r31) {
        long[] r15 = r28;
        h1.b r14 = r30;
        n().h(5, "packCurrentData, " + r24.f10830i, new Object[0]);
        int r10 = y(0, r26, r24.f10830i, true, r27, r28, r30);
        boolean r11 = r(r24.f10830i, r14, p(r15));
        JSONArray r18 = m(r24.f10830i, r29, r14);
        if (r11 == false) goto L5;
    L9:
        String r12 = this.f10845a.s().getAppId();
        if (r11 == false) goto L12;
        f r13 = r24;
    L13:
        r25.V(r12, r23, r13, null, null, r27, r28, r18, r30, r31);
        r15 = r15;
        k(r25, true, r26, true, r30);
    L14:
        int r16 = r10;
        if (r16 >= this.f10848d.length) goto L24;
        h1.b r17 = r14;
        r10 = y(r16, r26, r24.f10830i, true, r27, r28, r30);
        if (p(r15) == false) goto L23;
        boolean r19 = r(r24.f10830i, r17, true);
        String r110 = this.f10845a.s().getAppId();
        if (r19 == false) goto L21;
        f r111 = r24;
    L22:
        r25.V(r110, r23, r111, null, null, r27, r28, null, r30, r31);
        k(r25, true, r26, true, r30);
        goto L23
    L21:
        r111 = null;
    L23:
        r15 = r28;
        r14 = r30;
        goto L14
    L24:
        return;
    L12:
        r13 = null;
        goto L13
    L5:
        if (p(r15) == true) goto L9;
        if (r18 == null) goto L14;
        goto L9
    }

    private void v(JSONObject r22, f r23, g r24, h r25, i r26, SQLiteDatabase r27, JSONArray[] r28, long[] r29, HashMap<String, JSONObject> r30, h1.b r31, int r32) {
        boolean r10 = false;
        n().h(5, "packHistoryData, " + r23.f10830i, new Object[0]);
        int r20 = y(0, r27, r23.f10830i, true, r28, r29, r31);
        JSONArray r11 = A(r23, true, r26, r25, r27, r31, p(r29));
        if (r11.length() != 0) goto L5;
        boolean r12 = true;
    L6:
        r23.B = r12;
        JSONArray r17 = m(r23.f10830i, r30, r31);
        if (r23.B == true) goto L9;
        long[] r13 = r29;
        f r14 = r23;
        r24.V(this.f10845a.s().getAppId(), r22, null, r26, r11, r28, r29, r17, r31, r32);
    L18:
        r10 = true;
    L19:
        if (r10 == false) goto L21;
        k(r24, true, r27, true, r31);
    L21:
        int r15 = r20;
    L23:
        if (r15 >= this.f10848d.length) goto L28;
        int r16 = y(r15, r27, r14.f10830i, true, r28, r29, r31);
        if (p(r13) == false) goto L27;
        r24.V(this.f10845a.s().getAppId(), r22, null, null, null, r28, r29, null, r31, r32);
        k(r24, true, r27, true, r31);
    L27:
        r13 = r29;
        r15 = r16;
        r14 = r23;
        goto L23
    L28:
        return;
    L9:
        if (r(r23.f10830i, r31, p(r29)) == false) goto L11;
        r13 = r29;
        r14 = r23;
        r24.V(this.f10845a.s().getAppId(), r22, r23, null, null, r28, r29, r17, r31, r32);
        goto L18
    L11:
        r13 = r29;
        r14 = r23;
        if (p(r13) == true) goto L16;
        if (r17 == null) goto L19;
        if (r17.length() <= 0) goto L19;
    L16:
        r24.V(this.f10845a.s().getAppId(), r22, null, null, null, r28, r29, r17, r31, r32);
        goto L18
    L5:
        r12 = false;
        goto L6
    }

    private void w(JSONObject r24, f r25, i r26, h r27, g r28, SQLiteDatabase r29, String r30, JSONArray[] r31, long[] r32, h1.b r33, int r34) {
        boolean r11 = false;
        n().h(5, "packLostData, " + r30, new Object[0]);
        r25.f10830i = r30;
        r28.f10830i = r30;
        int r22 = y(0, r29, r30, false, r31, r32, r33);
        JSONArray r10 = A(r25, false, r26, r27, r29, r33, p(r32));
        if (r10.length() != 0) goto L5;
        r11 = true;
    L5:
        r25.B = r11;
        if (p(r32) == false) goto L8;
    L11:
        String r12 = this.f10845a.s().getAppId();
        boolean r13 = r25.B;
        if (r13 == true) goto L14;
        i r14 = r26;
    L15:
        if (r13 == true) goto L17;
        JSONArray r16 = r10;
    L18:
        r28.V(r12, r24, null, r14, r16, r31, r32, null, r33, r34);
        k(r28, false, r29, true, r33);
    L19:
        int r15 = r22;
    L21:
        if (r15 >= this.f10848d.length) goto L26;
        int r17 = y(r15, r29, r30, false, r31, r32, r33);
        if (p(r32) == false) goto L25;
        r28.V(this.f10845a.s().getAppId(), r24, null, null, null, r31, r32, null, r33, r34);
        k(r28, false, r29, true, r33);
    L25:
        r15 = r17;
        goto L21
    L26:
        return;
    L17:
        r16 = null;
        goto L18
    L14:
        r14 = null;
        goto L15
    L8:
        if (r25.B == true) goto L19;
        goto L11
    }

    private void x(SQLiteDatabase r15, String r16, int r17, int r18, boolean r19, JSONArray[] r20, long[] r21, h1.b r22) {
        l1.a r10 = this.f10848d[r18];
        JSONArray r11 = new JSONArray();
        Cursor r12 = null;
        long r13 = 0;
        r12 = r15.rawQuery(F(r10, r16, r19, r17, r22), null);     // Catch: Throwable -> L14
        int r14 = 0;
    L5:
        if (r12.moveToNext() == false) goto L13;
        if (r14 > 200) goto L13;
        r10.r(r12);     // Catch: Throwable -> L14
        C0229b.a(this.f10850f[r18], r10, r18);     // Catch: Throwable -> L14
        r11.put(r10.z());     // Catch: Throwable -> L14
        long r23 = r10.f10827c;     // Catch: Throwable -> L14
        if (r23 <= r13) goto L12;
        r13 = r23;
    L12:
        r14 = r14 + 1;
    L13:
        r12.close();
    L21:
        r20[r18] = r11;
        r21[r18] = r13;
        return;
    L14:
        th = move-exception;
    L23:
        th = move-exception;
        if (r12 == null) goto L26;
        r12.close();
    L26:
        throw th;
    L16:
        if ((th instanceof SQLiteBlobTooBigException) == false) goto L18;
        L(o(r18));     // Catch: Throwable -> L23
    L18:
        n().v(5, "query event failed", th, new Object[0]);     // Catch: Throwable -> L23
        if (r12 == null) goto L21;
        goto L21
    }

    private int y(int r17, SQLiteDatabase r18, String r19, boolean r20, JSONArray[] r21, long[] r22, h1.b r23) {
        D();
        int r10 = 0;
    L4:
        if (r10 >= r17) goto L6;
        r21[r10] = null;
        r22[r10] = 0;
        r10 = r10 + 1;
        goto L4
    L6:
        int r14 = r10;
        int r15 = 200;
    L7:
        if (r15 <= 0) goto L13;
        if (r14 >= this.f10848d.length) goto L13;
        x(r18, r19, r15, r14, r20, r21, r22, r23);
        int r11 = r21[r14].length();
        r15 = r15 - r11;
        this.f10850f[r14].f10854c = r11;
        if (r15 <= 0) goto L7;
        r14 = r14 + 1;
    L13:
        int r12 = r14 + 1;
    L15:
        if (r12 >= r21.length) goto L17;
        r21[r12] = null;
        r22[r12] = 0;
        r12 = r12 + 1;
        goto L15
    L17:
        return r14;
    }

    public void E(@NonNull ArrayList<l1.a> r20) {
        ArrayList r10 = new ArrayList(4);
        ArrayList r11 = new ArrayList(4);
        ArrayList r12 = new ArrayList(4);
        int r13 = r20.size();
        String r14 = null;
        SQLiteDatabase r15 = this.f10846b.getWritableDatabase();     // Catch: Throwable -> L53
        r15.beginTransaction();     // Catch: Throwable -> L50
        Iterator<l1.a> r16 = r20.iterator();     // Catch: Throwable -> L50
        ContentValues r17 = null;
        int r18 = 0;
        int r19 = 0;
        int r110 = 0;
        int r111 = 0;
    L77:
        if (r16.hasNext() == false) goto L40;
        l1.a r112 = r16.next();     // Catch: Throwable -> L48
        if (TextUtils.isEmpty(r112.f10839r) == false) goto L11;
        r112.u(this.f10845a.s().getAppId());     // Catch: Throwable -> L48
    L11:
        String r21 = r112.q();     // Catch: Throwable -> L48
        r17 = r112.A(r17);     // Catch: Throwable -> L48
        int r113 = r13;
        long r22 = r15.insert(r21, r14, r17);     // Catch: Throwable -> L46
        r112.f10827c = r22;     // Catch: Throwable -> L46
        if (r22 < 0) goto L16;
        boolean r23 = true;
    L18:
        if (NotificationCompat.CATEGORY_EVENT.equals(r112.q()) == false) goto L24;
        r11.add(r112);     // Catch: Throwable -> L46
        if (r23 == false) goto L22;
    L21:
        r18 = r18 + 1;     // Catch: Throwable -> L46
    L37:
        if (r23 == true) goto L39;
        this.f10845a.s().R().i(r112, MonitorState.f_db_insert);     // Catch: Throwable -> L46
        this.f10845a.s().R().m(MonitorKey.f_db_insert_event, com.bytedance.applog.monitor.a.c(r112));     // Catch: Throwable -> L46
    L39:
        r13 = r113;
        r14 = null;
    L22:
        r19 = r19 + 1;     // Catch: Throwable -> L46
        goto L37
    L24:
        if ("eventv3".equals(r112.q()) == false) goto L29;
        r11.add(r112);     // Catch: Throwable -> L46
        if (r23 == false) goto L22;
    L29:
        if ((r112 instanceof f) == false) goto L35;
        r10.add((f) r112);     // Catch: Throwable -> L46
        if (r23 == false) goto L33;
        r110 = r110 + 1;     // Catch: Throwable -> L46
        goto L37
    L33:
        r111 = r111 + 1;     // Catch: Throwable -> L46
        goto L37
    L35:
        if ((r112 instanceof i) == false) goto L37;
        r12.add((i) r112);     // Catch: Throwable -> L46
        goto L37
    L16:
        r23 = false;
    L46:
        th = th;
    L52:
        SQLiteDatabase r24 = r15;
    L81:
        B(th);     // Catch: Throwable -> L70
        n().v(5, "save db failed", th, new Object[0]);     // Catch: Throwable -> L70
        p.e(r24);
    L57:
        n().h(5, "save, " + r113 + ", " + r18 + ", " + r19 + ", " + r110 + ", " + r111, new Object[0]);
        s(r11);
        Iterator r25 = r10.iterator();     // Catch: Throwable -> L67
    L60:
        if (r25.hasNext() == false) goto L62;
        f r26 = (f) r25.next();     // Catch: Throwable -> L67
        this.f10845a.s().V().b(r26.f10827c, r26.f10830i);     // Catch: Throwable -> L67
        goto L60
    L62:
        Iterator r27 = r12.iterator();     // Catch: Throwable -> L67
    L63:
        if (r27.hasNext() == false) goto L91;
        i r28 = (i) r27.next();     // Catch: Throwable -> L67
        this.f10845a.s().V().c(r28.f10827c, r28.f10830i, r28.z());     // Catch: Throwable -> L67
        goto L63
    L91:
        return;
    L67:
        th = move-exception;
        n().v(5, "onSessionStart failed", th, new Object[0]);
        return;
    L70:
        th = move-exception;
        p.e(r24);
        throw th;
    L40:
        r113 = r13;
        r15.setTransactionSuccessful();     // Catch: Throwable -> L46
        Iterator<l1.a> r29 = r20.iterator();     // Catch: Throwable -> L46
    L41:
        if (r29.hasNext() == false) goto L45;
        m.e("event_save_db", r29.next());     // Catch: Throwable -> L46
        goto L41
    L45:
        p.e(r15);
    L48:
        th = th;
        r113 = r13;
    L50:
        th = th;
        r113 = r13;
        r18 = 0;
        r19 = 0;
        r110 = 0;
        r111 = 0;
    L53:
        th = th;
        r113 = r13;
        r18 = 0;
        r19 = 0;
        r110 = 0;
        r111 = 0;
        r24 = null;
        goto L81
    }

    public void J(ArrayList<g> r11, ArrayList<g> r12) {
        n().h(5, "setResult, " + r11 + ", " + r12, new Object[0]);
        Iterator<g> r10 = r12.iterator();
        ArrayList r13 = new ArrayList();
    L4:
        if (r10.hasNext() == false) goto L8;
        g r14 = r10.next();
        if (Math.abs(System.currentTimeMillis() - r14.f10828g) <= 1209600000) goto L4;
        r11.add(r14);
        r13.add(r14);
        r10.remove();
        goto L4
    L8:
        this.f10845a.s().R().k(r13, MonitorState.f_expire);
        Iterator r15 = r13.iterator();
    L10:
        if (r15.hasNext() == false) goto L12;
        ((g) r15.next()).U(MonitorKey.f_expire_event);
        goto L10
    L12:
        SQLiteDatabase r16 = null;
        r16 = this.f10846b.getWritableDatabase();     // Catch: Throwable -> L25
        r16.beginTransaction();     // Catch: Throwable -> L25
        Iterator<g> r17 = r11.iterator();     // Catch: Throwable -> L25
    L15:
        if (r17.hasNext() == false) goto L19;
        g r18 = r17.next();     // Catch: Throwable -> L25
        int r19 = r16.delete("pack", "_id = ?", new String[]{String.valueOf(r18.f10827c)});     // Catch: Throwable -> L25
        if (r19 > 0) goto L15;
        this.f10845a.s().R().l(r18, MonitorState.f_db_delete);     // Catch: Throwable -> L25
        n().q(5, "delete from db failed, pack: {}, rows: ", new Object[]{r18, Integer.valueOf(r19)});     // Catch: Throwable -> L25
        goto L15
    L19:
        Iterator<g> r110 = r12.iterator();     // Catch: Throwable -> L25
    L21:
        if (r110.hasNext() == false) goto L23;
        g r111 = r110.next();     // Catch: Throwable -> L25
        long r20 = r111.f10827c;     // Catch: Throwable -> L25
        int r21 = r111.A + 1;     // Catch: Throwable -> L25
        r111.A = r21;     // Catch: Throwable -> L25
        r16.execSQL(l(r20, r21));     // Catch: Throwable -> L25
        goto L21
    L23:
        r16.setTransactionSuccessful();     // Catch: Throwable -> L25
    L27:
        p.e(r16);
        return;
    L25:
        th = move-exception;
        B(th);     // Catch: Throwable -> L29
        n().v(5, "set result failed", th, new Object[0]);     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        p.e(r16);
        throw th;
    }

    public void M(long r10, ContentValues r11) {
        if (r10 < 0) goto L14;
        if (r11 != null) goto L12;
        return;
    L12:
        this.f10846b.getWritableDatabase().update("pack", r11, "_id = ?", new String[]{String.valueOf(r10)});     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        B(th);
        n().v(5, "update pack failed", th, new Object[0]);
        return;
    }

    public void g() {
        SQLiteDatabase r10 = this.f10846b.getWritableDatabase();     // Catch: Throwable -> L12
        r10.beginTransaction();     // Catch: Throwable -> L10
        Iterator<l1.a> r11 = this.f10847c.values().iterator();     // Catch: Throwable -> L10
    L6:
        if (r11.hasNext() == false) goto L8;
        r10.delete(r11.next().q(), null, null);     // Catch: Throwable -> L10
        goto L6
    L8:
        r10.setTransactionSuccessful();     // Catch: Throwable -> L10
    L15:
        p.e(r10);
        return;
    L10:
        Throwable th = th;
    L20:
        n().v(5, "clear tables failed", th, new Object[0]);     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        p.e(r10);
        throw th;
    L12:
        th = move-exception;
        r10 = null;
        th = th;
        goto L20
    }

    public void k(g r18, boolean r19, SQLiteDatabase r20, boolean r21, h1.b r22) {
        if (r20 == null) goto L41;
        SQLiteDatabase r11 = r20;
        boolean r12 = false;
    L9:
        if (r12 == true) goto L39;
    L13:
        if (r21 == false) goto L18;
        Iterator<g> r10 = K(r18).iterator();     // Catch: Throwable -> L11
    L16:
        if (r10.hasNext() == false) goto L18;
        q(r11, r22, r10.next(), r19);     // Catch: Throwable -> L11
    L18:
        long r13 = r18.D;     // Catch: Throwable -> L11
        if (r13 <= 0) goto L21;
        r11.execSQL(i(NotificationCompat.CATEGORY_EVENT, r18.f10830i, r19, r13, r22));     // Catch: Throwable -> L11
    L21:
        long r14 = r18.F;     // Catch: Throwable -> L11
        if (r14 <= 0) goto L24;
        r11.execSQL(i("eventv3", r18.f10830i, r19, r14, r22));     // Catch: Throwable -> L11
    L24:
        long r15 = r18.M;     // Catch: Throwable -> L11
        if (r15 <= 0) goto L27;
        r11.execSQL(i("event_misc", r18.f10830i, r19, r15, r22));     // Catch: Throwable -> L11
    L27:
        if (r12 == false) goto L29;
        r11.setTransactionSuccessful();     // Catch: Throwable -> L11
    L11:
        th = th;
    L43:
        B(th);     // Catch: Throwable -> L35
        n().h(5, "delete pack data failed", new Object[]{th});     // Catch: Throwable -> L35
        if (r12 == false) goto L47;
    L33:
        p.e(r11);
        return;
    L47:
        return;
    L35:
        th = move-exception;
        if (r12 == false) goto L38;
        p.e(r11);
    L38:
        throw th;
    L29:
        if (r12 == true) goto L33;
        return;
    L39:
        r11.beginTransaction();     // Catch: Throwable -> L11
        goto L13
    L41:
        r11 = this.f10846b.getWritableDatabase();     // Catch: Throwable -> L6
        r12 = true;
    L6:
        th = th;
        r11 = r20;
        r12 = false;
        goto L43
    }

    public void s(List<l1.a> r14) {
        if (this.f10845a.s().G().a(0) == false) goto L5;
        return;
    L5:
        Iterator<l1.a> r15 = r14.iterator();
    L7:
        if (r15.hasNext() == false) goto L27;
        l1.a r10 = r15.next();
        if (NotificationCompat.CATEGORY_EVENT.equals(r10.q()) == true) goto L11;
        JSONObject r11 = null;
        if ("eventv3".equals(r10.q()) == true) goto L14;
        if ("event_misc".equals(r10.q()) == false) goto L7;
        d r12 = (d) r10;     // Catch: Throwable -> L25
        d1.a r13 = this.f10845a.s().G();     // Catch: Throwable -> L25
        String r16 = r12.E();     // Catch: Throwable -> L25
        if (r12.l() == null) goto L23;
        r11 = new JSONObject(r12.l());     // Catch: Throwable -> L25
    L23:
        r13.d(0, r16, r11);     // Catch: Throwable -> L25
        goto L7
    L14:
        e r17 = (e) r10;     // Catch: Throwable -> L25
        d1.a r18 = this.f10845a.s().G();     // Catch: Throwable -> L25
        String r19 = r17.B;     // Catch: Throwable -> L25
        if (r17.f10859z == null) goto L17;
        r11 = new JSONObject(r17.f10859z);     // Catch: Throwable -> L25
    L17:
        r18.c(0, r19, r11);     // Catch: Throwable -> L25
        goto L7
    L11:
        c r20 = (c) r10;     // Catch: Throwable -> L25
        this.f10845a.s().G().b(0, r20.f10857z, r20.A, r20.B, r20.D, r20.E, r20.C);     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        n().v(5, "notify event observer before store failed", th, new Object[0]);
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public synchronized void t(JSONObject r36, h1.b r37, int r38) {
        monitor-enter(this);
        f r10 = (f) this.f10847c.get(Constants.LAUNCH_TAG);     // Catch: Throwable -> L112
        i r14 = (i) this.f10847c.get("terminate");     // Catch: Throwable -> L112
        h r15 = (h) this.f10847c.get("page");     // Catch: Throwable -> L112
        g r12 = (g) this.f10847c.get("pack");     // Catch: Throwable -> L112
        Cursor r11 = null;
        int r13 = 0;
        int r16 = 5;
        JSONArray[] r17 = new JSONArray[3];     // Catch: Throwable -> L90
        long[] r18 = new long[3];     // Catch: Throwable -> L90
        HashMap<String, JSONObject> r19 = new HashMap();     // Catch: Throwable -> L90
        n().h(5, "DbStore pack before collect impression.", new Object[0]);     // Catch: Throwable -> L90
        SQLiteDatabase r20 = this.f10846b.getWritableDatabase();     // Catch: Throwable -> L90
        h(r20, r19, r37);     // Catch: Throwable -> L88
        n().h(5, "DbStore pack after collect impression.", new Object[0]);     // Catch: Throwable -> L88
        r20.beginTransaction();     // Catch: Throwable -> L88
        Cursor r21 = r20.rawQuery(G(5), null);     // Catch: Throwable -> L88
        a1.e r22 = this.f10845a.C();     // Catch: Throwable -> L85
        String r23 = r22.d();     // Catch: Throwable -> L85
        boolean r110 = r22.j();     // Catch: Throwable -> L85
        boolean r24 = r21.moveToLast();     // Catch: Throwable -> L85
        JSONObject r25 = r36;
        long r26 = Long.MIN_VALUE;
        long r27 = Long.MAX_VALUE;
    L12:
        if (r24 == false) goto L42;
        r10.r(r21);     // Catch: Throwable -> L39
        r12.f10830i = r10.f10830i;     // Catch: Throwable -> L39
        JSONObject r28 = f(r10, r36);     // Catch: Throwable -> L39
        if (TextUtils.equals(r10.f10830i, r23) == false) goto L23;
        if (r110 == true) goto L17;
        boolean r29 = 1;
    L128:
        r10.B = r29;     // Catch: Throwable -> L21
        Cursor r210 = r21;
        SQLiteDatabase r211 = r20;
        HashMap<String, JSONObject> r30 = r19;
        long[] r31 = r18;
        JSONArray[] r32 = r17;
        u(r28, r10, r12, r20, r17, r18, r30, r37, r38);     // Catch: Throwable -> L36
    L117:
        r24 = r210.moveToPrevious();     // Catch: Throwable -> L34
        r13 = r13;
        r25 = r28;
        r23 = r23;
        r21 = r210;
        r20 = r211;
        r19 = r30;
        r18 = r31;
        r17 = r32;
        r15 = r15;
        r12 = r12;
        r16 = 5;
    L34:
        th = th;
    L38:
        r11 = r210;
        SQLiteDatabase r111 = r211;
    L57:
        r16 = 5;
    L130:
        B(th);     // Catch: Throwable -> L102
        n().v(r16, "pack failed", th, new Object[r13]);     // Catch: Throwable -> L102
        if (r11 != null) goto L146;
    L76:
        p.e(r111);     // Catch: Throwable -> L112
        monitor-exit(this);
        return;
    L146:
        r11.close();     // Catch: Throwable -> L96
    L96:
        th = move-exception;
        n().v(r16, "close cursor failed", th, new Object[r13]);     // Catch: Throwable -> L112
        goto L76
    L102:
        th = move-exception;
        if (r11 != null) goto L142;
    L110:
        p.e(r111);     // Catch: Throwable -> L112
        throw th;     // Catch: Throwable -> L112
    L142:
        r11.close();     // Catch: Throwable -> L107
    L107:
        th = move-exception;
        n().v(r16, "close cursor failed", th, new Object[r13]);     // Catch: Throwable -> L112
    L36:
        th = th;
        r13 = r13;
    L21:
        th = th;
    L41:
        r11 = r21;
        r111 = r20;
        goto L130
    L17:
        r29 = r13;
        goto L128
    L23:
        r210 = r21;
        r211 = r20;
        r30 = r19;
        r31 = r18;
        r32 = r17;
        long r33 = r10.f10827c;     // Catch: Throwable -> L36
        if (r33 >= r27) goto L28;
        r27 = r33;
    L28:
        if (r33 <= r26) goto L31;
        r26 = r33;
    L31:
        v(r28, r10, r12, r15, r14, r211, r32, r31, r30, r37, r38);     // Catch: Throwable -> L34
    L39:
        th = th;
        goto L41
    L42:
        String r212 = r23;
        Cursor r213 = r21;
        SQLiteDatabase r214 = r20;
        long[] r34 = r18;
        JSONArray[] r35 = r17;
        g r39 = r12;
        h r310 = r15;
        r13 = r13;
        e(r19);     // Catch: Throwable -> L82
        if (r27 != Long.MAX_VALUE) goto L47;
    L58:
        SQLiteDatabase r112 = r214;
    L126:
        if (r213.getCount() < 5) goto L124;
    L69:
        r16 = 5;
        r111 = r112;
    L70:
        r111.setTransactionSuccessful();     // Catch: Throwable -> L78
        r213.close();     // Catch: Throwable -> L73
    L73:
        th = move-exception;
        n().v(r16, "close cursor failed", th, new Object[r13]);     // Catch: Throwable -> L112
    L78:
        th = th;
    L87:
        r11 = r213;
        goto L130
    L124:
    L67:
        th = th;
        r16 = 5;
        r111 = r112;
        goto L87
    L63:
        if (TextUtils.isEmpty(r212) == true) goto L69;
        r16 = 5;
        r111 = r112;
        w(r25, (f) r10.b(), r14, r310, r39, r112, r212, r35, r34, r37, r38);     // Catch: Throwable -> L78
    L80:
        th = th;
        r111 = r112;
    L84:
        r16 = 5;
        goto L87
    L47:
        if (r26 == Long.MIN_VALUE) goto L58;
        String[] r40 = new String[2];     // Catch: Throwable -> L54
        r40[r13] = String.valueOf(r27);     // Catch: Throwable -> L54
        r40[1] = String.valueOf(r26);     // Catch: Throwable -> L54
        r112 = r214;
        r112.execSQL("DELETE FROM launch WHERE _id>=? AND _id<=?", r40);     // Catch: Throwable -> L52
    L52:
        th = th;
    L56:
        r111 = r112;
        r11 = r213;
    L54:
        th = th;
        r112 = r214;
    L82:
        th = th;
        r111 = r214;
    L85:
        th = th;
        r213 = r21;
        r111 = r20;
        r16 = 5;
        r13 = 0;
    L88:
        th = th;
        r111 = r20;
        r16 = 5;
        r13 = 0;
    L90:
        th = th;
        r16 = 5;
        r13 = 0;
        r111 = null;
    L112:
        th = move-exception;
        throw th;
    }

    @NonNull
    public ArrayList<g> z(int r10, h1.b r11) {
        ArrayList<g> r12 = new ArrayList();
        g r13 = (g) this.f10847c.get("pack");
        boolean r14 = false;
        Cursor r15 = null;
        r15 = this.f10846b.getWritableDatabase().rawQuery(H(r10, r11), null);     // Catch: Throwable -> L9
    L5:
        if (r15.moveToNext() == false) goto L8;
        r13 = (g) r13.b();     // Catch: Throwable -> L9
        r13.r(r15);     // Catch: Throwable -> L9
        r12.add(r13);     // Catch: Throwable -> L9
        goto L5
    L8:
        r15.close();
    L14:
        if (r14 == false) goto L16;
        L(MonitorKey.pack);
    L16:
        return r12;
    L9:
        th = move-exception;
        boolean r16 = th instanceof SQLiteBlobTooBigException;     // Catch: Throwable -> L17
        B(th);     // Catch: Throwable -> L17
        n().v(5, "query pack failed", th, new Object[0]);     // Catch: Throwable -> L17
        if (r15 == null) goto L13;
        r15.close();
    L13:
        r14 = r16;
    L17:
        th = move-exception;
        if (r15 == null) goto L20;
        r15.close();
    L20:
        throw th;
    }
}
