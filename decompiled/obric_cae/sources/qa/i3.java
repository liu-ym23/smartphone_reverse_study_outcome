package qa;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.SystemClock;
import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.loc.es;
import com.obric.cae.BWDL.BwdlDrop.BwdlDropConstant;
import com.obric.cae.cloud.CloudServiceConstants;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class i3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Hashtable<String, ArrayList<a>> f10525a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f10526b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f10527c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f10528d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f10529e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f10530f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f10531g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f10532h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public b3 f10533i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f10534j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f10535k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f10536l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f10537m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f10538n;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public es f10539a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f10540b;

        public a() {
            this.f10539a = null;
            this.f10540b = null;
        }
    }

    public i3() {
        this.f10525a = new Hashtable();
        this.f10526b = 0;
        this.f10527c = false;
        this.f10528d = "2.0.201501131131".replace(".", "");
        this.f10529e = null;
        this.f10530f = true;
        this.f10531g = 0;
        this.f10532h = null;
        this.f10533i = null;
        this.f10534j = null;
        this.f10535k = 0;
        this.f10536l = true;
        this.f10537m = true;
        this.f10538n = String.valueOf(AMapLocationClientOption.e.f3674a);
    }

    public static void i(String r8, Hashtable<String, String> r10) {
        if (TextUtils.isEmpty(r8) == false) goto L5;
        return;
    L5:
        r10.clear();
        String[] r11 = r8.split("#");
        int r12 = r11.length;
        int r13 = 0;
    L6:
        if (r13 >= r12) goto L13;
        String r14 = r11[r13];
        if (TextUtils.isEmpty(r14) == true) goto L12;
        if (r14.contains("|") == true) goto L12;
        r10.put(r14, "");
    L12:
        r13 = r13 + 1;
        goto L6
    }

    public final es a(Context r8, String r10, StringBuilder r11, boolean r12, boolean r13) {
        if (TextUtils.isEmpty(r10) == false) goto L6;
        return null;
    L6:
        if (s3.f11073j == true) goto L8;
        return null;
    L8:
        StringBuilder r14 = android.aimedia.a.k(r10, "&");
        r14.append(this.f10536l);
        r14.append("&");
        r14.append(this.f10537m);
        r14.append("&");
        r14.append(this.f10538n);
        String r15 = r14.toString();
        if (r15.contains(CloudServiceConstants.OSettings.CAE_CONFIG_MODULE_TYPE_GPS) == false) goto L11;
    L27:
        return null;
    L11:
        if (s3.f11073j == false) goto L27;
        if (r11 == null) goto L27;
        if (j() == false) goto L18;
        k();
        return null;
    L18:
        if (r12 == false) goto L23;
        if (this.f10527c == true) goto L23;
        String r16 = d(r15, r11, r8);     // Catch: Throwable -> L28
        k();     // Catch: Throwable -> L28
        f(r8, r16, r13);     // Catch: Throwable -> L28
    L23:
        if (this.f10525a.isEmpty() == false) goto L26;
        return null;
    L26:
        return b(r15, r11, r13);
    }

    public final es b(String r8, StringBuilder r10, boolean r11) {
        boolean r12 = r8.contains("cgiwifi");     // Catch: Throwable -> L35
        Hashtable<String, ArrayList<a>> r13 = this.f10525a;
        if (r12 == false) goto L7;
    L17:
        a r14 = e(r8, r10);     // Catch: Throwable -> L35
    L18:
        if (r14 != null) goto L20;
    L37:
        return null;
    L20:
        if (y3.l(r14.f10539a) == false) goto L37;
        es r15 = r14.f10539a;     // Catch: Throwable -> L35
        r15.Z = "mem";     // Catch: Throwable -> L35
        r15.f5211f0 = r14.f10540b;     // Catch: Throwable -> L35
        if (r11 == true) goto L31;
        if (s3.e(r15.getTime()) == true) goto L31;
        if (r13 == null) goto L37;
        if (r13.containsKey(r8) == false) goto L37;
        r13.get(r8).remove(r14);     // Catch: Throwable -> L35
    L31:
        if (y3.l(r15) == false) goto L33;
        this.f10531g = 0;     // Catch: Throwable -> L35
    L33:
        r15.x(4);     // Catch: Throwable -> L35
        return r15;
    L7:
        if (r8.contains("wifi") == true) goto L17;
        if (r8.contains("cgi") == true) goto L12;
    L16:
        r14 = null;
        goto L18
    L12:
        if (r13.containsKey(r8) == false) goto L16;
        if (r13.get(r8).size() <= 0) goto L16;
        r14 = r13.get(r8).get(0);     // Catch: Throwable -> L35
    L35:
        th = move-exception;
        t3.g("Cache", "get1", th);
        goto L37
    }

    public final es c(c3 r16, boolean r17, es r18, g3 r19, StringBuilder r20, String r21, Context r22, boolean r23) {
        if (s3.f11073j == true) goto L7;
        if (r23 == true) goto L7;
    L12:
        boolean r8 = false;
    L14:
        if (r8 == false) goto L20;
        if (r18 != null) goto L18;
    L21:
        boolean r10 = true;
    L23:
        if (r10 == true) goto L99;
        return null;
    L99:
        b3 r11 = r16.l();     // Catch: Throwable -> L98
        if (r11 == null) goto L28;
    L29:
        b3 r12 = this.f10533i;     // Catch: Throwable -> L98
        if (r12 != null) goto L32;
    L35:
        boolean r13 = true;
    L36:
        if (r18 == null) goto L44;
        int r14 = r19.g().size();     // Catch: Throwable -> L98
        if (r18.getAccuracy() > 299.0f) goto L40;
    L42:
        boolean r15 = false;
    L43:
        boolean r110 = r15;
    L46:
        if (r18 == null) goto L63;
        String r24 = this.f10532h;     // Catch: Throwable -> L98
        if (r24 == null) goto L63;
        if (r110 == true) goto L63;
        if (r13 == true) goto L63;
        boolean r25 = y3.n(r24, r20.toString());     // Catch: Throwable -> L98
        if (this.f10531g != 0) goto L54;
    L56:
        boolean r26 = false;
    L57:
        if (r25 == true) goto L60;
        if (r26 == true) goto L60;
    L64:
        if (r25 == true) goto L66;
        this.f10531g = SystemClock.elapsedRealtime();     // Catch: Throwable -> L98
    L67:
        String r27 = this.f10534j;     // Catch: Throwable -> L98
        if (r27 == null) goto L76;
        if (r21.equals(r27) == true) goto L76;
        if ((System.currentTimeMillis() - this.f10535k) >= 3000) goto L78;
        String r28 = this.f10534j;     // Catch: Throwable -> L98
    L81:
        if (r110 == true) goto L84;
        if (r17 == true) goto L84;
        es r29 = a(r22, r28, r20, false, false);     // Catch: Throwable -> L98
    L85:
        if (r17 == false) goto L87;
    L89:
        boolean r30 = false;
    L90:
        if (r30 == true) goto L97;
        if (r110 == true) goto L97;
        if (r17 == false) goto L95;
        return null;
    L95:
        this.f10531g = 0;     // Catch: Throwable -> L98
        r29.x(4);     // Catch: Throwable -> L98
        return r29;
    L87:
        if (y3.l(r29) == true) goto L89;
        r30 = true;
    L84:
        r29 = null;
    L78:
        this.f10535k = System.currentTimeMillis();     // Catch: Throwable -> L98
        this.f10534j = r21;     // Catch: Throwable -> L98
    L80:
        r28 = r21;
    L76:
        if (this.f10534j == null) goto L78;
        this.f10535k = System.currentTimeMillis();     // Catch: Throwable -> L98
        goto L80
    L66:
        this.f10531g = 0;     // Catch: Throwable -> L98
    L60:
        if (y3.l(r18) == false) goto L64;
        r18.Z = "mem";     // Catch: Throwable -> L98
        r18.x(2);     // Catch: Throwable -> L98
        return r18;
    L54:
        if ((SystemClock.elapsedRealtime() - this.f10531g) >= 3000) goto L56;
        r26 = true;
    L63:
        r25 = false;
        goto L64
    L40:
        if (r14 <= 5) goto L42;
        r15 = true;
        goto L43
    L44:
        r110 = false;
        goto L46
    L32:
        if (r12.equals(r11) == false) goto L35;
    L34:
        r13 = false;
        goto L36
    L28:
        if (this.f10533i == null) goto L34;
    L97:
        return null;
    L18:
        if (s3.e(r18.getTime()) == true) goto L21;
        if (r23 == true) goto L21;
    L20:
        r10 = false;
    L7:
        if (this.f10530f == false) goto L9;
    L13:
        r8 = true;
        goto L14
    L9:
        if (s3.f11075l == true) goto L13;
        if (r23 == false) goto L12;
        goto L12
    }

    public final String d(String r10, StringBuilder r11, Context r12) {
        if (r12 != null) goto L5;
        return null;
    L5:
        JSONObject r8 = new JSONObject();
        this.f10529e = y3.E(r12);     // Catch: Throwable -> L24
        if (r10.contains("&") == false) goto L9;
        r10 = r10.substring(0, r10.indexOf("&"));     // Catch: Throwable -> L24
    L9:
        String r13 = r10.substring(r10.lastIndexOf("#") + 1);     // Catch: Throwable -> L24
        if (r13.equals("cgi") == false) goto L13;
        r8.put("cgi", r10.substring(0, r10.length() - 12));     // Catch: Throwable -> L24
    L22:
        return l4.d(h3.b(this.f10529e, r8.toString().getBytes("UTF-8")));
    L13:
        if (TextUtils.isEmpty(r11) == true) goto L22;
        if (r11.indexOf(",access") == (-1)) goto L22;
        r8.put("cgi", r10.substring(0, r10.length() - (r13.length() + 9)));     // Catch: Throwable -> L24
        String[] r14 = r11.toString().split(",access");     // Catch: Throwable -> L24
        if (r14[0].contains("#") == false) goto L19;
        String r15 = r14[0];     // Catch: Throwable -> L24
        String r16 = r15.substring(r15.lastIndexOf("#") + 1);     // Catch: Throwable -> L24
    L20:
        r8.put("mmac", r16);     // Catch: Throwable -> L24
        goto L22
    L19:
        r16 = r14[0];     // Catch: Throwable -> L24
    L24:
        return null;
    }

    public final a e(String r30, StringBuilder r31) {
        Hashtable<String, ArrayList<a>> r8 = this.f10525a;
        if (r8.isEmpty() == true) goto L92;
        if (TextUtils.isEmpty(r31) == true) goto L92;
        if (r8.containsKey(r30) == true) goto L10;
        return null;
    L10:
        Hashtable r10 = new Hashtable();
        Hashtable r11 = new Hashtable();
        Hashtable r12 = new Hashtable();
        ArrayList<a> r13 = r8.get(r30);
        int r14 = 1;
        int r15 = r13.size() - 1;
    L11:
        if (r15 < 0) goto L88;
        a r16 = r13.get(r15);
        if (TextUtils.isEmpty(r16.f10540b) == true) goto L87;
        String r17 = r16.f10540b;
        int r18 = 0;
        if (TextUtils.isEmpty(r17) == true) goto L33;
        if (TextUtils.isEmpty(r31) == true) goto L33;
        if (r17.contains(",access") == false) goto L33;
        if (r31.indexOf(",access") == (-1)) goto L33;
        String[] r19 = r17.split(",access");
        if (r19[0].contains("#") == false) goto L27;
        String r20 = r19[0];
        String r21 = r20.substring(r20.lastIndexOf("#") + r14);
    L29:
        if (TextUtils.isEmpty(r21) == true) goto L33;
        boolean r22 = r31.toString().contains(r21 + ",access");
    L34:
        if (r22 == true) goto L36;
        int r23 = 0;
    L40:
        i(r16.f10540b, r10);
        i(r31.toString(), r11);
        r12.clear();
        Iterator r24 = r10.keySet().iterator();
    L42:
        if (r24.hasNext() == false) goto L44;
        r12.put((String) r24.next(), "");
        goto L42
    L44:
        Iterator r25 = r11.keySet().iterator();
    L46:
        if (r25.hasNext() == false) goto L48;
        r12.put((String) r25.next(), "");
        goto L46
    L48:
        Set r26 = r12.keySet();
        int r110 = r26.size();
        double[] r111 = new double[r110];
        double[] r112 = new double[r26.size()];
        Iterator r113 = r26.iterator();
        int r114 = 0;
    L49:
        double r115 = 1.0d;
        double r116 = 0.0d;
        if (r113 == null) goto L62;
        if (r113.hasNext() == false) goto L62;
        String r27 = (String) r113.next();
        if (r10.containsKey(r27) == false) goto L56;
        double r28 = 1.0d;
    L57:
        r111[r114] = r28;
        if (r11.containsKey(r27) == true) goto L61;
        r115 = 0.0d;
    L61:
        r112[r114] = r115;
        r114 = r114 + 1;
        goto L49
    L56:
        r28 = 0.0d;
    L62:
        r26.clear();
        double[] r29 = new double[3];
        int r32 = 0;
        int r33 = 0;
        double r117 = 0.0d;
        double r210 = 0.0d;
    L63:
        if (r33 >= r110) goto L70;
        double r211 = r111[r33];
        r116 = (r211 * r211) + r116;
        double r212 = r112[r33];
        r117 = (r212 * r212) + r117;
        r210 = (r211 * r212) + r210;
        if (r212 != 1.0d) goto L69;
        r18 = r18 + 1;
        if (r211 != 1.0d) goto L69;
        r32 = r32 + 1;
    L69:
        r33 = r33 + 1;
        goto L63
    L70:
        r29[0] = r210 / (Math.sqrt(r117) * Math.sqrt(r116));
        double r118 = r32;
        r29[1] = (r118 * 1.0d) / ((double) r18);
        r29[2] = r118;
        int r34 = 0;
    L71:
        if (r34 >= 2) goto L77;
        if (r29[r34] <= 1.0d) goto L75;
        r29[r34] = 1.0d;
    L75:
        r34 = r34 + 1;
        goto L71
    L77:
        if (r29[0] >= 0.800000011920929d) goto L85;
        r14 = 1;
        if (r29[1] >= Math.min(s3.f11076m, 0.618d)) goto L85;
        if (r23 == 0) goto L87;
        if (r29[0] < Math.min(s3.f11076m, 0.618d)) goto L87;
    L85:
        a r35 = r16;
    L89:
        r10.clear();
        r11.clear();
        r12.clear();
        return r35;
    L36:
        if (y3.n(r16.f10540b, r31.toString()) == true) goto L85;
        r23 = r14;
        goto L40
    L27:
        r21 = r19[0];
    L33:
        r22 = false;
    L87:
        r15 = r15 - 1;
        goto L11
    L88:
        r35 = null;
    L92:
        return null;
    }

    public final void f(Context r21, String r22, boolean r23) {
        if (s3.f11073j == true) goto L5;
        return;
    L5:
        if (r21 != null) goto L7;
        return;
    L7:
        SQLiteDatabase r8 = null;
        Cursor r10 = null;
        SQLiteDatabase r19 = r21.openOrCreateDatabase("hmdb", 0, null);     // Catch: Throwable -> L99
    L97:
        th = th;
    L98:
        Cursor r11 = r10;
        r8 = r19;
    L119:
        t3.g("DB", "fetchHist p2", th);     // Catch: Throwable -> L109
        if (r11 == null) goto L104;
        r11.close();
    L104:
        if (r8 != null) goto L106;
        return;
    L106:
        if (r8.isOpen() == false) goto L131;
        r8.close();
        return;
    L131:
        return;
    L109:
        th = move-exception;
        if (r11 == null) goto L112;
        r11.close();
    L112:
        if (r8 != null) goto L114;
    L116:
        throw th;
    L114:
        if (r8.isOpen() == false) goto L116;
        r8.close();
        goto L116
    L10:
        if (y3.i(r19) == true) goto L16;
        if (r19 != null) goto L13;
        return;
    L13:
        if (r19.isOpen() == false) goto L128;
        r19.close();     // Catch: Throwable -> L97
        return;
    L128:
        return;
    L16:
        StringBuilder r12 = new StringBuilder();     // Catch: Throwable -> L97
        if (r23 == true) goto L23;
        long r13 = System.currentTimeMillis() - s3.f11074k;     // Catch: Throwable -> L97
        r12.append("time >");     // Catch: Throwable -> L97
        r12.append(r13);     // Catch: Throwable -> L97
        if (r22 == null) goto L27;
        r12.append(" and feature = '");     // Catch: Throwable -> L97
    L26:
        r12.append(r22.concat("'"));     // Catch: Throwable -> L97
    L27:
        int r14 = 1;
        int r15 = 2;
        Cursor r16 = r19.query("hist" + this.f10528d, new String[]{"feature", " nb", "loc"}, r12.toString(), null, null, null, "time ASC", null);     // Catch: Throwable -> L97
        StringBuilder r17 = new StringBuilder();     // Catch: Throwable -> L95
        if (this.f10529e == null) goto L122;
    L34:
        if (r16 != null) goto L36;
    L89:
        if (r16 == null) goto L92;
        r16.close();
    L92:
        if (r19.isOpen() == false) goto L129;
        r19.close();
        return;
    L129:
        return;
    L36:
        if (r16.moveToFirst() == false) goto L89;
    L38:
        String r18 = ",access";
        if (r16.getString(0).startsWith("{") == false) goto L51;
        JSONObject r20 = new JSONObject(r16.getString(0));     // Catch: Throwable -> L32
        r17.delete(0, r17.length());     // Catch: Throwable -> L32
        if (TextUtils.isEmpty(r16.getString(r14)) == true) goto L45;
        r18 = r16.getString(r14);     // Catch: Throwable -> L32
    L43:
        r17.append(r18);     // Catch: Throwable -> L32
    L47:
        JSONObject r24 = new JSONObject(r16.getString(r15));     // Catch: Throwable -> L32
        if (t4.g("type", r24) == false) goto L65;
        r24.put("type", "new");     // Catch: Throwable -> L32
    L65:
        es r25 = new es();     // Catch: Throwable -> L95
        r25.B(r24);     // Catch: Throwable -> L95
        if (t4.g("mmac", r20) == false) goto L78;
        if (t4.g("cgi", r20) == false) goto L78;
        String r26 = (r20.getString("cgi") + "#") + "network#";     // Catch: Throwable -> L32
        if (r20.getString("cgi").contains("#") == false) goto L74;
        StringBuilder r27 = new StringBuilder();     // Catch: Throwable -> L32
        r27.append(r26);     // Catch: Throwable -> L32
        String r28 = "cgiwifi";
    L73:
        r27.append(r28);     // Catch: Throwable -> L32
        String r29 = r27.toString();     // Catch: Throwable -> L32
    L82:
        int r110 = 2;
        int r111 = 1;
        h(r29, r17, r25, r21, false);     // Catch: Throwable -> L95
    L85:
        if (r16.moveToNext() == false) goto L86;
        r15 = r110;
        r14 = r111;
        r12 = r12;
        goto L38
    L86:
        r17.delete(0, r17.length());     // Catch: Throwable -> L95
        r12.delete(0, r12.length());     // Catch: Throwable -> L95
        goto L89
    L74:
        r27 = new StringBuilder();     // Catch: Throwable -> L32
        r27.append(r26);     // Catch: Throwable -> L32
        r28 = "wifi";
    L78:
        if (t4.g("cgi", r20) == false) goto L83;
        String r30 = (r20.getString("cgi") + "#") + "network#";     // Catch: Throwable -> L95
        if (r20.getString("cgi").contains("#") == false) goto L83;
        r29 = r30 + "cgi";     // Catch: Throwable -> L95
    L83:
        r110 = 2;
        r111 = 1;
        goto L85
    L45:
        if (t4.g("mmac", r20) == false) goto L47;
        r17.append("#");     // Catch: Throwable -> L32
        r17.append(r20.getString("mmac"));     // Catch: Throwable -> L32
    L32:
        th = th;
    L96:
        r10 = r16;
        goto L98
    L51:
        JSONObject r112 = new JSONObject(new String(h3.e(this.f10529e, l4.e(r16.getString(0))), "UTF-8"));     // Catch: Throwable -> L95
        r17.delete(0, r17.length());     // Catch: Throwable -> L95
        if (TextUtils.isEmpty(r16.getString(1)) == true) goto L57;
        r18 = new String(h3.e(this.f10529e, l4.e(r16.getString(1))), "UTF-8");     // Catch: Throwable -> L32
    L54:
        r17.append(r18);     // Catch: Throwable -> L32
    L61:
        r24 = new JSONObject(new String(h3.e(this.f10529e, l4.e(r16.getString(2))), "UTF-8"));     // Catch: Throwable -> L95
        if (t4.g("type", r24) == false) goto L64;
        r24.put("type", "new");     // Catch: Throwable -> L32
    L64:
        r20 = r112;
        goto L65
    L57:
        if (t4.g("mmac", r112) == false) goto L61;
        r17.append("#");     // Catch: Throwable -> L32
        r17.append(r112.getString("mmac"));     // Catch: Throwable -> L32
        goto L54
    L122:
        this.f10529e = y3.E(r21);     // Catch: Throwable -> L32
    L95:
        th = th;
        goto L96
    L23:
        long r113 = System.currentTimeMillis() - 172800000;     // Catch: Throwable -> L97
        r12.append("time >");     // Catch: Throwable -> L97
        r12.append(r113);     // Catch: Throwable -> L97
        if (r22 == null) goto L27;
        r12.append(" and feature = '");     // Catch: Throwable -> L97
    L99:
        th = th;
        r11 = null;
        goto L119
    }

    public final void g(String r8, AMapLocation r10, StringBuilder r11, Context r12) {
        String r13 = this.f10528d;
        if (r12 != null) goto L6;
        return;
    L6:
        if (this.f10529e != null) goto L8;
        this.f10529e = y3.E(r12);
    L8:
        String r14 = d(r8, r11, r12);
        StringBuilder r15 = new StringBuilder();
        SQLiteDatabase r16 = null;
        r16 = r12.openOrCreateDatabase("hmdb", 0, null);     // Catch: Throwable -> L17
        r15.append("CREATE TABLE IF NOT EXISTS hist");     // Catch: Throwable -> L17
        r15.append(r13);     // Catch: Throwable -> L17
        r15.append(" (feature VARCHAR PRIMARY KEY, nb VARCHAR, loc VARCHAR, time VARCHAR);");     // Catch: Throwable -> L17
        r16.execSQL(r15.toString());     // Catch: Throwable -> L17
        r15.delete(0, r15.length());     // Catch: Throwable -> L17
        r15.append("REPLACE INTO ");     // Catch: Throwable -> L17
        r15.append("hist");     // Catch: Throwable -> L17
        r15.append(r13);     // Catch: Throwable -> L17
        r15.append(" VALUES (?, ?, ?, ?)");     // Catch: Throwable -> L17
        Object[] r17 = new Object[4];     // Catch: Throwable -> L17
        r17[0] = r14;     // Catch: Throwable -> L17
        byte[] r18 = r11.toString().getBytes("UTF-8");     // Catch: Throwable -> L17
        byte[] r19 = h3.b(this.f10529e, r18);     // Catch: Throwable -> L17
        int r20 = 1;
        r17[1] = r19;     // Catch: Throwable -> L17
        byte[] r21 = r10.z().getBytes("UTF-8");     // Catch: Throwable -> L17
        r17[2] = h3.b(this.f10529e, r21);     // Catch: Throwable -> L17
        r17[3] = Long.valueOf(r10.getTime());     // Catch: Throwable -> L17
    L10:
        if (r20 >= 3) goto L12;
        r17[r20] = l4.d((byte[]) r17[r20]);     // Catch: Throwable -> L17
        r20 = r20 + 1;     // Catch: Throwable -> L17
        goto L10
    L12:
        r16.execSQL(r15.toString(), r17);     // Catch: Throwable -> L17
        r15.delete(0, r15.length());     // Catch: Throwable -> L17
        r15.delete(0, r15.length());
        if (r16.isOpen() == false) goto L37;
        r16.close();
        return;
    L37:
        return;
    L17:
        th = move-exception;
        t3.g("DB", "updateHist", th);     // Catch: Throwable -> L25
        r15.delete(0, r15.length());
        if (r16 != null) goto L22;
        return;
    L22:
        if (r16.isOpen() == false) goto L39;
        r16.close();
        return;
    L39:
        return;
    L25:
        th = move-exception;
        r15.delete(0, r15.length());
        if (r16 != null) goto L29;
    L31:
        throw th;
    L29:
        if (r16.isOpen() == false) goto L31;
        r16.close();
        goto L31
    }

    public final void h(String r17, StringBuilder r18, es r19, Context r20, boolean r21) {
    L98:
        th = move-exception;
        t3.g("Cache", "add", th);
        return;
    L4:
        if (y3.l(r19) == true) goto L6;
        return;
    L6:
        String r11 = r17 + "&" + r19.f3645v + "&" + r19.f5209c0 + "&" + r19.d0;     // Catch: Throwable -> L98
        if (TextUtils.isEmpty(r11) == false) goto L10;
    L16:
        boolean r8 = false;
    L17:
        if (r8 == true) goto L20;
        return;
    L20:
        if (r19.Z.equals("mem") == false) goto L22;
        return;
    L22:
        if (r19.Z.equals(BwdlDropConstant.FILE) == false) goto L24;
        return;
    L24:
        if (r19.Z.equals("wifioff") == false) goto L27;
        return;
    L27:
        if ("-3".equals(r19.X) == false) goto L30;
        return;
    L30:
        if (j() == false) goto L32;
        k();     // Catch: Throwable -> L98
    L32:
        JSONObject r10 = r19.f5207a0;     // Catch: Throwable -> L98
        if (t4.g("offpct", r10) == false) goto L37;
        r10.remove("offpct");     // Catch: Throwable -> L98
        r19.f5207a0 = r10;     // Catch: Throwable -> L98
    L37:
        if (r11.contains("wifi") == false) goto L63;
        if (TextUtils.isEmpty(r18) == false) goto L42;
        return;
    L42:
        if (r19.getAccuracy() < 300.0f) goto L53;
        String[] r12 = r18.toString().split("#");     // Catch: Throwable -> L98
        int r13 = r12.length;     // Catch: Throwable -> L98
        int r14 = 0;
        int r15 = 0;
    L44:
        if (r14 >= r13) goto L50;
        if (r12[r14].contains(",") == false) goto L48;
        r15 = r15 + 1;     // Catch: Throwable -> L98
    L48:
        r14 = r14 + 1;     // Catch: Throwable -> L98
        goto L44
    L50:
        if (r15 < 8) goto L56;
        return;
    L56:
        if (r11.contains("cgiwifi") == true) goto L58;
    L71:
        es r16 = b(r11, r18, false);     // Catch: Throwable -> L98
        if (y3.l(r16) == true) goto L74;
    L76:
        this.f10526b = SystemClock.elapsedRealtime();     // Catch: Throwable -> L98
        a r22 = new a();     // Catch: Throwable -> L98
        r22.f10539a = r19;     // Catch: Throwable -> L98
        String r23 = null;
        if (TextUtils.isEmpty(r18) == false) goto L79;
        String r24 = null;
    L81:
        if (TextUtils.isEmpty(r24) == true) goto L84;
        r23 = r24.replace("##", "#");     // Catch: Throwable -> L98
    L84:
        r22.f10540b = r23;     // Catch: Throwable -> L98
        Hashtable<String, ArrayList<a>> r25 = this.f10525a;
        if (r25.containsKey(r11) == false) goto L89;
        r25.get(r11).add(r22);     // Catch: Throwable -> L98
    L90:
        if (r21 == true) goto L101;
        return;
    L101:
        g(r11, r19, r18, r20);     // Catch: Throwable -> L94
        return;
    L94:
        th = move-exception;
        t3.g("Cache", "add", th);     // Catch: Throwable -> L98
        return;
    L89:
        ArrayList<a> r26 = new ArrayList();     // Catch: Throwable -> L98
        r26.add(r22);     // Catch: Throwable -> L98
        r25.put(r11, r26);     // Catch: Throwable -> L98
        goto L90
    L79:
        r24 = r18.toString();     // Catch: Throwable -> L98
        goto L81
    L74:
        if (r16.A(1).equals(r19.A(3)) == false) goto L76;
        return;
    L58:
        if (TextUtils.isEmpty(r19.f5208b0) == true) goto L71;
        String r27 = r11.replace("cgiwifi", "cgi");     // Catch: Throwable -> L98
        es r28 = r19.D();     // Catch: Throwable -> L98
        if (y3.l(r28) == false) goto L71;
        h(r27, new StringBuilder(), r28, r20, true);     // Catch: Throwable -> L98
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
        if ("4".equals(r19.X) == false) goto L71;
        return;
    L10:
        if (y3.l(r19) == false) goto L16;
        if (r11.startsWith("#") == true) goto L16;
        r8 = r11.contains("network");     // Catch: Throwable -> L98
        goto L17
    }

    public final boolean j() {
        long r8 = SystemClock.elapsedRealtime();
        long r10 = this.f10526b;
        long r11 = r8 - r10;
        if (r10 != 0) goto L6;
        return false;
    L6:
        if (this.f10525a.size() <= 360) goto L8;
    L9:
        return true;
    L8:
        if (r11 > 172800000) goto L9;
        return false;
    }

    public final void k() {
        this.f10526b = 0;
        Hashtable<String, ArrayList<a>> r8 = this.f10525a;
        if (r8.isEmpty() == true) goto L5;
        r8.clear();
    L5:
        this.f10527c = false;
    }

    public final void l(Context r10) {
        if (r10 != null) goto L5;
        return;
    L5:
        SQLiteDatabase r8 = null;
        r8 = r10.openOrCreateDatabase("hmdb", 0, null);     // Catch: Throwable -> L25
        if (y3.i(r8) == true) goto L38;
        if (r8 != null) goto L10;
        return;
    L10:
        if (r8.isOpen() == false) goto L44;
        r8.close();     // Catch: Throwable -> L25
        return;
    L44:
        return;
    L38:
        r8.delete("hist" + this.f10528d, "time<?", new String[]{String.valueOf(System.currentTimeMillis() - 172800000)});     // Catch: Throwable -> L16
    L20:
        if (r8 != null) goto L22;
        return;
    L22:
        if (r8.isOpen() == false) goto L46;
        r8.close();
        return;
    L46:
        return;
    L16:
        th = move-exception;
        t3.g("DB", "clearHist", th);     // Catch: Throwable -> L25
        String r11 = th.getMessage();     // Catch: Throwable -> L25
        if (TextUtils.isEmpty(r11) == true) goto L20;
        r11.contains("no such table");     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        t3.g("DB", "clearHist p2", th);     // Catch: Throwable -> L32
        if (r8 != null) goto L29;
        return;
    L29:
        if (r8.isOpen() == false) goto L48;
        r8.close();
        return;
    L48:
        return;
    L32:
        th = move-exception;
        if (r8 != null) goto L35;
    L37:
        throw th;
    L35:
        if (r8.isOpen() == false) goto L37;
        r8.close();
        goto L37
    }
}
