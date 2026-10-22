package n4a;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.SystemClock;
import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.loc.es;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.obric.aivoice.core.data.NameKeys;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class u3 {
    public final Hashtable<String, ArrayList<a>> a;
    public long b;
    public boolean c;
    public final String d;
    public String e;
    public boolean f;
    public long g;
    public String h;
    public k3 i;
    public String j;
    public long k;
    public boolean l;
    public boolean m;
    public String n;

    public static class a {
        public es a;
        public String b;

        public a() {
            this.a = null;
            this.b = null;
        }
    }

    public u3() {
        this.a = new Hashtable();
        this.b = 0;
        this.c = false;
        this.d = "2.0.201501131131".replace(".", NameKeys.UnloadStrategy_No_Strategy);
        this.e = null;
        this.f = true;
        this.g = 0;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = 0;
        this.l = true;
        this.m = true;
        this.n = String.valueOf(AMapLocationClientOption.GeoLanguage.DEFAULT);
    }

    public static void i(String r4, Hashtable<String, String> r5) {
        if (TextUtils.isEmpty(r4) == false) goto L5;
        return;
    L5:
        r5.clear();
        String[] r6 = r4.split("#");
        int r0 = r6.length;
        int r1 = 0;
    L6:
        if (r1 >= r0) goto L13;
        String r2 = r6[r1];
        if (TextUtils.isEmpty(r2) == true) goto L12;
        if (r2.contains("|") == true) goto L12;
        r5.put(r2, NameKeys.UnloadStrategy_No_Strategy);
    L12:
        r1 = r1 + 1;
        goto L6
    }

    public final String d(String r9, StringBuilder r10, Context r11) {
        if (r11 != null) goto L5;
        return null;
    L5:
        JSONObject r5 = new JSONObject();
        this.e = j4.I(r11);     // Catch: Throwable -> L24
        if (r9.contains("&") == false) goto L9;
        r9 = r9.substring(0, r9.indexOf("&"));     // Catch: Throwable -> L24
    L9:
        String r12 = r9.substring(r9.lastIndexOf("#") + 1);     // Catch: Throwable -> L24
        if (r12.equals("cgi") == false) goto L13;
        r5.put("cgi", r9.substring(0, r9.length() - 12));     // Catch: Throwable -> L24
    L22:
        return y4.d(t3.c(r5.toString().getBytes("UTF-8"), this.e));
    L13:
        if (TextUtils.isEmpty(r10) == true) goto L22;
        if (r10.indexOf(",access") == (-1)) goto L22;
        r5.put("cgi", r9.substring(0, r9.length() - (r12.length() + 9)));     // Catch: Throwable -> L24
        String[] r13 = r10.toString().split(",access");     // Catch: Throwable -> L24
        if (r13[0].contains("#") == false) goto L19;
        String r14 = r13[0];     // Catch: Throwable -> L24
        String r15 = r14.substring(r14.lastIndexOf("#") + 1);     // Catch: Throwable -> L24
    L20:
        r5.put("mmac", r15);     // Catch: Throwable -> L24
        goto L22
    L19:
        r15 = r13[0];     // Catch: Throwable -> L24
    L24:
        return null;
    }

    public final void g(String r6, AMapLocation r7, StringBuilder r8, Context r9) throws Exception {
        if (r9 != null) goto L6;
        return;
    L6:
        if (this.e != null) goto L8;
        this.e = j4.I(r9);
    L8:
        String r10 = d(r6, r8, r9);
        StringBuilder r1 = new StringBuilder();
        SQLiteDatabase r2 = null;
        r2 = r9.openOrCreateDatabase("hmdb", 0, null);     // Catch: Throwable -> L17
        r1.append("CREATE TABLE IF NOT EXISTS hist");     // Catch: Throwable -> L17
        r1.append(this.d);     // Catch: Throwable -> L17
        r1.append(" (feature VARCHAR PRIMARY KEY, nb VARCHAR, loc VARCHAR, time VARCHAR);");     // Catch: Throwable -> L17
        r2.execSQL(r1.toString());     // Catch: Throwable -> L17
        r1.delete(0, r1.length());     // Catch: Throwable -> L17
        r1.append("REPLACE INTO ");     // Catch: Throwable -> L17
        r1.append("hist");     // Catch: Throwable -> L17
        r1.append(this.d);     // Catch: Throwable -> L17
        r1.append(" VALUES (?, ?, ?, ?)");     // Catch: Throwable -> L17
        Object[] r11 = new Object[4];     // Catch: Throwable -> L17
        r11[0] = r10;     // Catch: Throwable -> L17
        byte[] r12 = t3.c(r8.toString().getBytes("UTF-8"), this.e);     // Catch: Throwable -> L17
        int r13 = 1;
        r11[1] = r12;     // Catch: Throwable -> L17
        r11[2] = t3.c(r7.toStr().getBytes("UTF-8"), this.e);     // Catch: Throwable -> L17
        r11[3] = Long.valueOf(r7.getTime());     // Catch: Throwable -> L17
    L10:
        if (r13 >= 3) goto L12;
        r11[r13] = y4.d((byte[]) r11[r13]);     // Catch: Throwable -> L17
        r13 = r13 + 1;     // Catch: Throwable -> L17
        goto L10
    L12:
        r2.execSQL(r1.toString(), r11);     // Catch: Throwable -> L17
        r1.delete(0, r1.length());     // Catch: Throwable -> L17
        r1.delete(0, r1.length());
        if (r2.isOpen() == false) goto L37;
        r2.close();
        return;
    L37:
        return;
    L17:
        th = move-exception;
        c4.g(th, "DB", "updateHist");     // Catch: Throwable -> L25
        r1.delete(0, r1.length());
        if (r2 != null) goto L22;
        return;
    L22:
        if (r2.isOpen() == false) goto L39;
        r2.close();
        return;
    L39:
        return;
    L25:
        th = move-exception;
        r1.delete(0, r1.length());
        if (r2 != null) goto L29;
    L31:
        throw th;
    L29:
        if (r2.isOpen() == false) goto L31;
        r2.close();
        goto L31
    }

    public final void k() {
        this.b = 0;
        if (this.a.isEmpty() == true) goto L5;
        this.a.clear();
    L5:
        this.c = false;
    }

    public final boolean j() {
        long r0 = SystemClock.elapsedRealtime();
        long r2 = this.b;
        long r1 = r0 - r2;
        if (r2 != 0) goto L6;
        return false;
    L6:
        if (this.a.size() <= 360) goto L8;
    L9:
        return true;
    L8:
        if (r1 > 172800000) goto L9;
        return false;
    }

    public final void l(Context r10) throws Exception {
        if (r10 != null) goto L5;
        return;
    L5:
        SQLiteDatabase r2 = null;
        r2 = r10.openOrCreateDatabase("hmdb", 0, null);     // Catch: Throwable -> L25
        if (j4.j(r2) == true) goto L38;
        if (r2 != null) goto L10;
        return;
    L10:
        if (r2.isOpen() == false) goto L44;
        r2.close();     // Catch: Throwable -> L25
        return;
    L44:
        return;
    L38:
        r2.delete("hist" + this.d, "time<?", new String[]{String.valueOf(System.currentTimeMillis() - 172800000)});     // Catch: Throwable -> L16
    L20:
        if (r2 != null) goto L22;
        return;
    L22:
        if (r2.isOpen() == false) goto L46;
        r2.close();
        return;
    L46:
        return;
    L16:
        th = move-exception;
        c4.g(th, "DB", "clearHist");     // Catch: Throwable -> L25
        String r11 = th.getMessage();     // Catch: Throwable -> L25
        if (TextUtils.isEmpty(r11) == true) goto L20;
        r11.contains("no such table");     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        c4.g(th, "DB", "clearHist p2");     // Catch: Throwable -> L32
        if (r2 != null) goto L29;
        return;
    L29:
        if (r2.isOpen() == false) goto L48;
        r2.close();
        return;
    L48:
        return;
    L32:
        th = move-exception;
        if (r2 != null) goto L35;
    L37:
        throw th;
    L35:
        if (r2.isOpen() == false) goto L37;
        r2.close();
        goto L37
    }

    public final a e(StringBuilder r32, String r33) {
        if (this.a.isEmpty() == true) goto L92;
        if (TextUtils.isEmpty(r32) == true) goto L92;
        if (this.a.containsKey(r33) == true) goto L10;
        return null;
    L10:
        Hashtable r2 = new Hashtable();
        Hashtable r4 = new Hashtable();
        Hashtable r5 = new Hashtable();
        ArrayList<a> r1 = this.a.get(r33);
        int r7 = 1;
        int r6 = r1.size() - 1;
    L11:
        if (r6 < 0) goto L88;
        a r8 = (a) ListProtector.get(r1, r6);
        if (TextUtils.isEmpty(r8.b) == true) goto L87;
        String r9 = r8.b;
        int r11 = 0;
        if (TextUtils.isEmpty(r9) == true) goto L33;
        if (TextUtils.isEmpty(r32) == true) goto L33;
        if (r9.contains(",access") == false) goto L33;
        if (r32.indexOf(",access") == (-1)) goto L33;
        String[] r10 = r9.split(",access");
        if (r10[0].contains("#") == false) goto L27;
        String r12 = r10[0];
        String r13 = r12.substring(r12.lastIndexOf("#") + r7);
    L29:
        if (TextUtils.isEmpty(r13) == true) goto L33;
        boolean r14 = r32.toString().contains(r13 + ",access");
    L34:
        if (r14 == true) goto L36;
        boolean r15 = false;
    L40:
        i(r8.b, r2);
        i(r32.toString(), r4);
        r5.clear();
        Iterator r16 = r2.keySet().iterator();
    L42:
        if (r16.hasNext() == false) goto L44;
        r5.put((String) r16.next(), NameKeys.UnloadStrategy_No_Strategy);
        goto L42
    L44:
        Iterator r17 = r4.keySet().iterator();
    L46:
        if (r17.hasNext() == false) goto L48;
        r5.put((String) r17.next(), NameKeys.UnloadStrategy_No_Strategy);
        goto L46
    L48:
        Set r18 = r5.keySet();
        int r19 = r18.size();
        double[] r110 = new double[r19];
        double[] r111 = new double[r18.size()];
        Iterator r112 = r18.iterator();
        int r113 = 0;
    L49:
        double r114 = 1.0d;
        double r20 = 0.0d;
        if (r112 == null) goto L62;
        if (r112.hasNext() == false) goto L62;
        String r3 = (String) r112.next();
        if (r2.containsKey(r3) == false) goto L56;
        double r23 = 1.0d;
    L57:
        r110[r113] = r23;
        if (r4.containsKey(r3) == true) goto L61;
        r114 = 0.0d;
    L61:
        r111[r113] = r114;
        r113 = r113 + 1;
        goto L49
    L56:
        r23 = 0.0d;
    L62:
        r18.clear();
        double[] r21 = new double[3];
        double r115 = 0.0d;
        double r24 = 0.0d;
        int r22 = 0;
        int r116 = 0;
    L63:
        if (r116 >= r19) goto L70;
        double r25 = r110[r116];
        r20 = r20 + (r25 * r25);
        double r27 = r111[r116];
        r115 = r115 + (r27 * r27);
        r24 = r24 + (r25 * r27);
        if (r27 != 1.0d) goto L69;
        r11 = r11 + 1;
        if (r25 != 1.0d) goto L69;
        r22 = r22 + 1;
    L69:
        r116 = r116 + 1;
        goto L63
    L70:
        r21[0] = r24 / (Math.sqrt(r20) * Math.sqrt(r115));
        double r117 = r22;
        r21[1] = (r117 * 1.0d) / ((double) r11);
        r21[2] = r117;
        int r118 = 0;
    L71:
        if (r118 >= 2) goto L77;
        if (r21[r118] <= 1.0d) goto L75;
        r21[r118] = 1.0d;
    L75:
        r118 = r118 + 1;
        goto L71
    L77:
        if (r21[0] >= 0.800000011920929d) goto L78;
        a r34 = r8;
        if (r21[1] >= Math.min(com.loc.h.m, 0.618d)) goto L85;
        if (r15 == false) goto L87;
        if (r21[0] < Math.min(com.loc.h.m, 0.618d)) goto L87;
    L85:
        a r26 = r34;
    L89:
        r2.clear();
        r4.clear();
        r5.clear();
        return r26;
    L78:
        r34 = r8;
        goto L85
    L36:
        if (j4.o(r8.b, r32.toString()) == true) goto L78;
        r15 = true;
        goto L40
    L27:
        r13 = r10[0];
    L33:
        r14 = false;
    L87:
        r6 = r6 - 1;
        r7 = 1;
        goto L11
    L88:
        r26 = null;
    L92:
        return null;
    }

    /* JADX WARN: Type inference failed for: r1v4, types: [android.location.Location, com.loc.es] */
    public final es b(String r5, StringBuilder r6, boolean r7) {
    L35:
        th = move-exception;
        c4.g(th, "Cache", "get1");
    L37:
        return null;
    L4:
        if (r5.contains("cgiwifi") == false) goto L6;
    L16:
        a r8 = e(r6, r5);     // Catch: Throwable -> L35
    L17:
        if (r8 == null) goto L37;
        if (j4.m(r8.a) == false) goto L37;
        ?? r1 = r8.a;     // Catch: Throwable -> L35
        r1.P = "mem";     // Catch: Throwable -> L35
        r1.V = r8.b;     // Catch: Throwable -> L35
        if (r7 == true) goto L31;
        if (com.loc.h.e(r1.getTime()) == true) goto L31;
        Hashtable<String, ArrayList<a>> r9 = this.a;     // Catch: Throwable -> L35
        if (r9 == null) goto L37;
        if (r9.containsKey(r5) == false) goto L37;
        this.a.get(r5).remove(r8);     // Catch: Throwable -> L35
    L31:
        if (j4.m(r1) == false) goto L33;
        this.g = 0;     // Catch: Throwable -> L35
    L33:
        r1.setLocationType(4);     // Catch: Throwable -> L35
        return r1;
    L6:
        if (r5.contains("wifi") == true) goto L16;
        if (r5.contains("cgi") == true) goto L11;
    L15:
        r8 = null;
        goto L17
    L11:
        if (this.a.containsKey(r5) == false) goto L15;
        if (this.a.get(r5).size() <= 0) goto L15;
        r8 = (a) ListProtector.get(this.a.get(r5), 0);     // Catch: Throwable -> L35
        goto L17
    }

    public final void f(Context r21, String r22, boolean r23) throws Exception {
        if (com.loc.h.j == true) goto L5;
        return;
    L5:
        if (r21 != null) goto L7;
        return;
    L7:
        SQLiteDatabase r3 = null;
        Cursor r4 = null;
        SQLiteDatabase r19 = r21.openOrCreateDatabase("hmdb", 0, null);     // Catch: Throwable -> L98
    L96:
        th = th;
    L97:
        Cursor r1 = r4;
        r3 = r19;
    L116:
        c4.g(th, "DB", "fetchHist p2");     // Catch: Throwable -> L108
        if (r1 == null) goto L103;
        r1.close();
    L103:
        if (r3 != null) goto L105;
        return;
    L105:
        if (r3.isOpen() == false) goto L130;
        r3.close();
        return;
    L130:
        return;
    L108:
        th = move-exception;
        if (r1 == null) goto L111;
        r1.close();
    L111:
        if (r3 != null) goto L113;
    L115:
        throw th;
    L113:
        if (r3.isOpen() == false) goto L115;
        r3.close();
        goto L115
    L10:
        if (j4.j(r19) == true) goto L16;
        if (r19 != null) goto L13;
        return;
    L13:
        if (r19.isOpen() == false) goto L127;
        r19.close();     // Catch: Throwable -> L96
        return;
    L127:
        return;
    L16:
        StringBuilder r6 = new StringBuilder();     // Catch: Throwable -> L96
        if (r23 == true) goto L23;
        long r11 = System.currentTimeMillis() - com.loc.h.k;     // Catch: Throwable -> L96
        r6.append("time >");     // Catch: Throwable -> L96
        r6.append(r11);     // Catch: Throwable -> L96
        if (r22 == null) goto L27;
        r6.append(" and feature = '");     // Catch: Throwable -> L96
    L26:
        r6.append(r22.concat("'"));     // Catch: Throwable -> L96
    L27:
        Cursor r10 = r19.query("hist" + this.d, new String[]{"feature", " nb", "loc"}, r6.toString(), null, null, null, "time ASC", null);     // Catch: Throwable -> L96
        StringBuilder r12 = new StringBuilder();     // Catch: Throwable -> L94
        if (this.e == null) goto L121;
    L34:
        if (r10 != null) goto L36;
    L88:
        if (r10 == null) goto L91;
        r10.close();
    L91:
        if (r19.isOpen() == false) goto L128;
        r19.close();
        return;
    L128:
        return;
    L36:
        if (r10.moveToFirst() == false) goto L88;
    L38:
        String r5 = ",access";
        if (r10.getString(0).startsWith("{") == false) goto L51;
        JSONObject r2 = new JSONObject(r10.getString(0));     // Catch: Throwable -> L32
        r12.delete(0, r12.length());     // Catch: Throwable -> L32
        if (TextUtils.isEmpty(r10.getString(1)) == true) goto L44;
        r5 = r10.getString(1);     // Catch: Throwable -> L32
    L46:
        r12.append(r5);     // Catch: Throwable -> L32
    L47:
        JSONObject r7 = new JSONObject(r10.getString(2));     // Catch: Throwable -> L32
        if (f5.h(r7, "type") == false) goto L64;
        r7.put("type", "new");     // Catch: Throwable -> L32
    L64:
        es r8 = new es();     // Catch: Throwable -> L94
        r8.q(r7);     // Catch: Throwable -> L94
        if (f5.h(r2, "mmac") == false) goto L77;
        if (f5.h(r2, "cgi") == false) goto L77;
        String r9 = (r2.getString("cgi") + "#") + "network#";     // Catch: Throwable -> L32
        if (r2.getString("cgi").contains("#") == false) goto L73;
        StringBuilder r13 = new StringBuilder();     // Catch: Throwable -> L32
        r13.append(r9);     // Catch: Throwable -> L32
        String r14 = "cgiwifi";
    L72:
        r13.append(r14);     // Catch: Throwable -> L32
        String r15 = r13.toString();     // Catch: Throwable -> L32
    L81:
        h(r15, r12, r8, r21, false);     // Catch: Throwable -> L94
    L84:
        if (r10.moveToNext() == false) goto L85;
        r6 = r6;
        goto L38
    L85:
        r12.delete(0, r12.length());     // Catch: Throwable -> L94
        r6.delete(0, r6.length());     // Catch: Throwable -> L94
        goto L88
    L73:
        r13 = new StringBuilder();     // Catch: Throwable -> L32
        r13.append(r9);     // Catch: Throwable -> L32
        r14 = "wifi";
    L77:
        if (f5.h(r2, "cgi") == false) goto L84;
        String r16 = (r2.getString("cgi") + "#") + "network#";     // Catch: Throwable -> L94
        if (r2.getString("cgi").contains("#") == false) goto L84;
        r15 = r16 + "cgi";     // Catch: Throwable -> L94
        goto L81
    L44:
        if (f5.h(r2, "mmac") == false) goto L47;
        r12.append("#");     // Catch: Throwable -> L32
        r12.append(r2.getString("mmac"));     // Catch: Throwable -> L32
    L32:
        th = th;
    L95:
        r4 = r10;
        goto L97
    L51:
        JSONObject r17 = new JSONObject(new String(t3.e(y4.e(r10.getString(0)), this.e), "UTF-8"));     // Catch: Throwable -> L94
        r12.delete(0, r12.length());     // Catch: Throwable -> L94
        if (TextUtils.isEmpty(r10.getString(1)) == true) goto L56;
        r5 = new String(t3.e(y4.e(r10.getString(1)), this.e), "UTF-8");     // Catch: Throwable -> L32
    L58:
        r12.append(r5);     // Catch: Throwable -> L32
    L60:
        r7 = new JSONObject(new String(t3.e(y4.e(r10.getString(2)), this.e), "UTF-8"));     // Catch: Throwable -> L94
        if (f5.h(r7, "type") == false) goto L63;
        r7.put("type", "new");     // Catch: Throwable -> L32
    L63:
        r2 = r17;
        goto L64
    L56:
        if (f5.h(r17, "mmac") == false) goto L60;
        r12.append("#");     // Catch: Throwable -> L32
        r12.append(r17.getString("mmac"));     // Catch: Throwable -> L32
        goto L58
    L121:
        this.e = j4.I(r21);     // Catch: Throwable -> L32
    L94:
        th = th;
        goto L95
    L23:
        long r18 = System.currentTimeMillis() - 172800000;     // Catch: Throwable -> L96
        r6.append("time >");     // Catch: Throwable -> L96
        r6.append(r18);     // Catch: Throwable -> L96
        if (r22 == null) goto L27;
        r6.append(" and feature = '");     // Catch: Throwable -> L96
    L98:
        th = th;
        r1 = null;
        goto L116
    }

    public final es a(Context r4, String r5, StringBuilder r6, boolean r7, boolean r8) {
        if (TextUtils.isEmpty(r5) == false) goto L6;
        return null;
    L6:
        if (com.loc.h.j == true) goto L8;
        return null;
    L8:
        String r9 = r5 + "&" + this.l + "&" + this.m + "&" + this.n;
        if (r9.contains("gps") == false) goto L11;
    L29:
        return null;
    L11:
        if (com.loc.h.j == false) goto L29;
        if (r6 == null) goto L29;
        if (j() == false) goto L18;
        k();
        return null;
    L18:
        if (r7 == false) goto L25;
        if (this.c == true) goto L25;
        String r10 = d(r9, r6, r4);     // Catch: Throwable -> L23
        k();     // Catch: Throwable -> L23
        f(r4, r10, r8);     // Catch: Throwable -> L23
    L25:
        if (this.a.isEmpty() == false) goto L28;
        return null;
    L28:
        return b(r9, r6, r8);
    }

    public final void h(String r17, StringBuilder r18, es r19, Context r20, boolean r21) {
    L96:
        th = move-exception;
        c4.g(th, "Cache", "add");
        return;
    L4:
        if (j4.m(r19) == true) goto L6;
        return;
    L6:
        String r11 = r17 + "&" + r19.isOffset() + "&" + r19.S + "&" + r19.T;     // Catch: Throwable -> L96
        if (TextUtils.isEmpty(r11) == false) goto L10;
    L16:
        boolean r3 = false;
    L17:
        if (r3 == true) goto L20;
        return;
    L20:
        if (r19.P.equals("mem") == false) goto L22;
        return;
    L22:
        if (r19.P.equals("file") == false) goto L24;
        return;
    L24:
        if (r19.P.equals("wifioff") == false) goto L27;
        return;
    L27:
        if ("-3".equals(r19.N) == false) goto L30;
        return;
    L30:
        if (j() == false) goto L32;
        k();     // Catch: Throwable -> L96
    L32:
        JSONObject r4 = r19.Q;     // Catch: Throwable -> L96
        if (f5.h(r4, "offpct") == false) goto L37;
        r4.remove("offpct");     // Catch: Throwable -> L96
        r19.Q = r4;     // Catch: Throwable -> L96
    L37:
        if (r11.contains("wifi") == false) goto L63;
        if (TextUtils.isEmpty(r18) == false) goto L42;
        return;
    L42:
        if (r19.getAccuracy() < 300.0f) goto L53;
        String[] r2 = r18.toString().split("#");     // Catch: Throwable -> L96
        int r5 = r2.length;     // Catch: Throwable -> L96
        int r6 = 0;
        int r14 = 0;
    L44:
        if (r6 >= r5) goto L50;
        if (r2[r6].contains(",") == false) goto L48;
        r14 = r14 + 1;     // Catch: Throwable -> L96
    L48:
        r6 = r6 + 1;     // Catch: Throwable -> L96
        goto L44
    L50:
        if (r14 < 8) goto L56;
        return;
    L56:
        if (r11.contains("cgiwifi") == true) goto L58;
    L71:
        es r1 = b(r11, r18, false);     // Catch: Throwable -> L96
        if (j4.m(r1) == true) goto L74;
    L76:
        this.b = SystemClock.elapsedRealtime();     // Catch: Throwable -> L96
        a r7 = new a();     // Catch: Throwable -> L96
        r7.a = r19;     // Catch: Throwable -> L96
        String r8 = null;
        if (TextUtils.isEmpty(r18) == false) goto L79;
        String r9 = null;
    L81:
        if (TextUtils.isEmpty(r9) == true) goto L84;
        r8 = r9.replace("##", "#");     // Catch: Throwable -> L96
    L84:
        r7.b = r8;     // Catch: Throwable -> L96
        if (this.a.containsKey(r11) == false) goto L87;
        this.a.get(r11).add(r7);     // Catch: Throwable -> L96
    L88:
        if (r21 == true) goto L100;
        return;
    L100:
        g(r11, r19, r18, r20);     // Catch: Throwable -> L92
        return;
    L92:
        th = move-exception;
        c4.g(th, "Cache", "add");     // Catch: Throwable -> L96
        return;
    L87:
        ArrayList<a> r10 = new ArrayList();     // Catch: Throwable -> L96
        r10.add(r7);     // Catch: Throwable -> L96
        this.a.put(r11, r10);     // Catch: Throwable -> L96
        goto L88
    L79:
        r9 = r18.toString();     // Catch: Throwable -> L96
        goto L81
    L74:
        if (r1.toStr(1).equals(r19.toStr(3)) == false) goto L76;
        return;
    L58:
        if (TextUtils.isEmpty(r19.R) == true) goto L71;
        String r12 = r11.replace("cgiwifi", "cgi");     // Catch: Throwable -> L96
        es r13 = r19.s();     // Catch: Throwable -> L96
        if (j4.m(r13) == false) goto L71;
        h(r12, new StringBuilder(), r13, r20, true);     // Catch: Throwable -> L96
        goto L71
    L53:
        if (r19.getAccuracy() > 3.0f) goto L56;
        return;
    L63:
        if (r11.contains("cgi") == false) goto L71;
        if (r18 == null) goto L69;
        if (r18.indexOf(",") == (-1)) goto L69;
        return;
    L69:
        if ("4".equals(r19.N) == false) goto L71;
        return;
    L10:
        if (j4.m(r19) == false) goto L16;
        if (r11.startsWith("#") == true) goto L16;
        r3 = r11.contains(CloudControlInf.NETWORK);     // Catch: Throwable -> L96
        goto L17
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final es c(l3 r16, boolean r17, es r18, s3 r19, StringBuilder r20, String r21, Context r22, boolean r23) {
        if (com.loc.h.j == true) goto L7;
        if (r23 == true) goto L7;
    L12:
        boolean r2 = false;
    L14:
        if (r2 == false) goto L20;
        if (r18 != 0) goto L18;
    L21:
        boolean r3 = true;
    L23:
        if (r3 == true) goto L99;
        return null;
    L99:
        k3 r4 = r16.o();     // Catch: Throwable -> L98
        if (r4 == null) goto L28;
    L29:
        k3 r5 = this.i;     // Catch: Throwable -> L98
        if (r5 != null) goto L32;
    L35:
        boolean r6 = true;
    L36:
        if (r18 == 0) goto L44;
        int r7 = r19.i().size();     // Catch: Throwable -> L98
        if (r18.getAccuracy() > 299.0f) goto L40;
    L42:
        boolean r8 = false;
    L43:
        boolean r10 = r8;
    L46:
        if (r18 == 0) goto L63;
        String r9 = this.h;     // Catch: Throwable -> L98
        if (r9 == null) goto L63;
        if (r10 == true) goto L63;
        if (r6 == true) goto L63;
        boolean r11 = j4.o(r9, r20.toString());     // Catch: Throwable -> L98
        if (this.g != 0) goto L54;
    L56:
        boolean r12 = false;
    L57:
        if (r11 == true) goto L60;
        if (r12 == true) goto L60;
    L64:
        if (r11 == true) goto L66;
        this.g = SystemClock.elapsedRealtime();     // Catch: Throwable -> L98
    L67:
        String r0 = this.j;     // Catch: Throwable -> L98
        if (r0 == null) goto L76;
        if (r21.equals(r0) == true) goto L76;
        if ((System.currentTimeMillis() - this.k) >= 3000) goto L78;
        String r13 = this.j;     // Catch: Throwable -> L98
    L81:
        if (r10 == true) goto L84;
        if (r17 == true) goto L84;
        es r1 = a(r22, r13, r20, false, false);     // Catch: Throwable -> L98
    L85:
        if (r17 == false) goto L87;
    L89:
        boolean r14 = false;
    L90:
        if (r14 == true) goto L97;
        if (r10 == true) goto L97;
        if (r17 == false) goto L95;
        return null;
    L95:
        this.g = 0;     // Catch: Throwable -> L98
        r1.setLocationType(4);     // Catch: Throwable -> L98
        return r1;
    L87:
        if (j4.m(r1) == true) goto L89;
        r14 = true;
    L84:
        r1 = null;
    L78:
        this.k = System.currentTimeMillis();     // Catch: Throwable -> L98
        this.j = r21;     // Catch: Throwable -> L98
    L80:
        r13 = r21;
    L76:
        if (this.j == null) goto L78;
        this.k = System.currentTimeMillis();     // Catch: Throwable -> L98
        goto L80
    L66:
        this.g = 0;     // Catch: Throwable -> L98
    L60:
        if (j4.m(r18) == false) goto L64;
        r18.P = "mem";     // Catch: Throwable -> L98
        r18.setLocationType(2);     // Catch: Throwable -> L98
        return r18;
    L54:
        if ((SystemClock.elapsedRealtime() - this.g) >= 3000) goto L56;
        r12 = true;
    L63:
        r11 = false;
        goto L64
    L40:
        if (r7 <= 5) goto L42;
        r8 = true;
        goto L43
    L44:
        r10 = false;
        goto L46
    L32:
        if (r5.equals(r4) == false) goto L35;
    L34:
        r6 = false;
        goto L36
    L28:
        if (this.i == null) goto L34;
    L97:
        return null;
    L18:
        if (com.loc.h.e(r18.getTime()) == true) goto L21;
        if (r23 == true) goto L21;
    L20:
        r3 = false;
    L7:
        if (this.f == false) goto L9;
    L13:
        r2 = true;
        goto L14
    L9:
        if (com.loc.h.l == true) goto L13;
        if (r23 == false) goto L12;
        goto L12
    }
}
