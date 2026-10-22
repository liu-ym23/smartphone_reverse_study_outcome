package com.loc;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.bytedance.rpc.internal.RpcUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class ei {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Hashtable<String, ArrayList<a>> f5489a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    boolean f5490b;
    long c;
    String d;
    dt e;
    boolean f;
    boolean g;
    String h;
    private long i;
    private boolean j;
    private String k;
    private String l;
    private String m;
    private long n;

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private es f5491a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f5492b;

        public a() {
            this.f5491a = null;
            this.f5492b = null;
        }

        public final es a() {
            return this.f5491a;
        }

        public final void a(es r1) {
            this.f5491a = r1;
        }

        public final void a(String r3) {
            if (TextUtils.isEmpty(r3) == false) goto L7;
            String r4 = null;
        L5:
            this.f5492b = r4;
            return;
        L7:
            r4 = r3.replace("##", "#");
            goto L5
        }

        public final String b() {
            return this.f5492b;
        }
    }

    public ei() {
        this.f5489a = new Hashtable();
        this.i = 0;
        this.j = false;
        this.k = "2.0.201501131131".replace(".", "");
        this.l = null;
        this.f5490b = true;
        this.c = 0;
        this.d = null;
        this.e = null;
        this.m = null;
        this.n = 0;
        this.f = true;
        this.g = true;
        this.h = String.valueOf(AMapLocationClientOption.GeoLanguage.DEFAULT);
    }

    private a a(StringBuilder r25, String r26) {
        if (this.f5489a.isEmpty() == true) goto L58;
        if (TextUtils.isEmpty(r25) == true) goto L58;
        if (this.f5489a.containsKey(r26) == true) goto L10;
        return null;
    L10:
        Hashtable r2 = new Hashtable();
        Hashtable r4 = new Hashtable();
        Hashtable r5 = new Hashtable();
        ArrayList r0 = (ArrayList) ZeusTransformUtils.preCheckCast(this.f5489a.get(r26), ArrayList.class, "com.obric.memorydata.plugin");
        boolean r7 = true;
        int r1 = r0.size() - 1;
    L11:
        if (r1 < 0) goto L54;
        a r8 = (a) ZeusTransformUtils.preCheckCast(r0.get(r1), a.class, "com.obric.memorydata.plugin");
        if (TextUtils.isEmpty(r8.b()) == true) goto L53;
        if (a(r8.b(), r25) == true) goto L17;
        boolean r9 = false;
    L21:
        a(r8.b(), r2);
        a(r25.toString(), r4);
        r5.clear();
        Iterator r12 = r2.keySet().iterator();
    L23:
        if (r12.hasNext() == false) goto L25;
        r5.put((String) ZeusTransformUtils.preCheckCast(r12.next(), String.class, "com.obric.memorydata.plugin"), "");
        goto L23
    L25:
        Iterator r13 = r4.keySet().iterator();
    L27:
        if (r13.hasNext() == false) goto L29;
        r5.put((String) ZeusTransformUtils.preCheckCast(r13.next(), String.class, "com.obric.memorydata.plugin"), "");
        goto L27
    L29:
        Set r14 = r5.keySet();
        double[] r15 = new double[r14.size()];
        double[] r16 = new double[r14.size()];
        Iterator r17 = r14.iterator();
        int r18 = 0;
    L30:
        if (r17 == null) goto L42;
        if (r17.hasNext() == false) goto L42;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r17.next(), String.class, "com.obric.memorydata.plugin");
        double r19 = 1.0d;
        if (r2.containsKey(r3) == false) goto L36;
        double r22 = 1.0d;
    L37:
        r15[r18] = r22;
        if (r4.containsKey(r3) == true) goto L41;
        r19 = 0.0d;
    L41:
        r16[r18] = r19;
        r18 = r18 + 1;
        goto L30
    L36:
        r22 = 0.0d;
    L42:
        r14.clear();
        double[] r6 = a(r15, r16);
        if (r6[0] >= 0.800000011920929d) goto L18;
        a r24 = r8;
        if (r6[1] >= Math.min(eu.g(), 0.618d)) goto L51;
        if (r9 == false) goto L53;
        if (r6[0] < Math.min(eu.g(), 0.618d)) goto L53;
    L51:
        a r10 = r24;
    L55:
        r2.clear();
        r4.clear();
        r5.clear();
        return r10;
    L18:
        r24 = r8;
        goto L51
    L17:
        if (fd.a(r8.b(), r25.toString()) == true) goto L18;
        r9 = r7;
    L53:
        r1 = r1 - 1;
        r7 = true;
        goto L11
    L54:
        r10 = null;
    L58:
        return null;
    }

    private es a(String r6, StringBuilder r7, boolean r8) {
    L36:
        th = move-exception;
        ev.a(th, "Cache", "get1");
    L38:
        return null;
    L5:
        if (r6.contains("cgiwifi") == false) goto L7;
    L17:
        a r9 = a(r7, r6);     // Catch: Throwable -> L36
    L18:
        if (r9 == null) goto L38;
        if (fd.a(r9.a()) == false) goto L38;
        es r1 = r9.a();     // Catch: Throwable -> L36
        r1.e("mem");     // Catch: Throwable -> L36
        r1.h(r9.b());     // Catch: Throwable -> L36
        if (r8 == true) goto L32;
        if (eu.a(r1.getTime()) == true) goto L32;
        Hashtable<String, ArrayList<a>> r10 = this.f5489a;     // Catch: Throwable -> L36
        if (r10 == null) goto L38;
        if (r10.containsKey(r6) == false) goto L38;
        ((ArrayList) ZeusTransformUtils.preCheckCast(this.f5489a.get(r6), ArrayList.class, "com.obric.memorydata.plugin")).remove(r9);     // Catch: Throwable -> L36
    L32:
        if (fd.a(r1) == false) goto L34;
        this.c = 0;     // Catch: Throwable -> L36
    L34:
        r1.setLocationType(4);     // Catch: Throwable -> L36
        return r1;
    L7:
        if (r6.contains(LocationAnnotation.LightLocationType.LIGHT_LOCATION_WIFI) == true) goto L17;
        if (r6.contains("cgi") == true) goto L12;
    L16:
        r9 = null;
        goto L18
    L12:
        if (this.f5489a.containsKey(r6) == false) goto L16;
        if (((ArrayList) ZeusTransformUtils.preCheckCast(this.f5489a.get(r6), ArrayList.class, "com.obric.memorydata.plugin")).size() <= 0) goto L16;
        r9 = (a) ZeusTransformUtils.preCheckCast(((ArrayList) ZeusTransformUtils.preCheckCast(this.f5489a.get(r6), ArrayList.class, "com.obric.memorydata.plugin")).get(0), a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L36
        goto L18
    }

    private String a(String r9, StringBuilder r10, Context r11) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.memorydata.plugin");
        if (r12 != null) goto L5;
        return null;
    L5:
        JSONObject r5 = new JSONObject();
        this.l = fd.l(r12);     // Catch: Throwable -> L24
        if (r9.contains("&") == false) goto L9;
        r9 = r9.substring(0, r9.indexOf("&"));     // Catch: Throwable -> L24
    L9:
        String r13 = r9.substring(r9.lastIndexOf("#") + 1);     // Catch: Throwable -> L24
        if (r13.equals("cgi") == false) goto L13;
        r5.put("cgi", r9.substring(0, r9.length() - 12));     // Catch: Throwable -> L24
    L22:
        return fq.b(eh.a(r5.toString().getBytes(RpcUtils.CHARSET_UTF8), this.l));
    L13:
        if (TextUtils.isEmpty(r10) == true) goto L22;
        if (r10.indexOf(",access") == (-1)) goto L22;
        r5.put("cgi", r9.substring(0, r9.length() - (r13.length() + 9)));     // Catch: Throwable -> L24
        String[] r14 = r10.toString().split(",access");     // Catch: Throwable -> L24
        if (r14[0].contains("#") == false) goto L19;
        String r15 = r14[0].substring(r14[0].lastIndexOf("#") + 1);     // Catch: Throwable -> L24
    L20:
        r5.put("mmac", r15);     // Catch: Throwable -> L24
        goto L22
    L19:
        r15 = r14[0];     // Catch: Throwable -> L24
    L24:
        return null;
    }

    private void a(Context r20, String r21, boolean r22) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r20, Context.class, "com.obric.memorydata.plugin");
        if (eu.e() == true) goto L5;
        return;
    L5:
        if (r8 != null) goto L7;
        return;
    L7:
        SQLiteDatabase r3 = null;
        int r9 = 0;
        SQLiteDatabase r6 = r8.openOrCreateDatabase("hmdb", 0, null);     // Catch: Throwable -> L109
    L106:
        th = th;
        SQLiteDatabase r13 = r6;
        Cursor r10 = null;
    L108:
        r3 = r13;
    L127:
        ev.a(th, "DB", "fetchHist p2");     // Catch: Throwable -> L119
        if (r10 == null) goto L114;
        r10.close();
    L114:
        if (r3 != null) goto L116;
        return;
    L116:
        if (r3.isOpen() == false) goto L146;
        r3.close();
        return;
    L146:
        return;
    L119:
        th = move-exception;
        if (r10 == null) goto L122;
        r10.close();
    L122:
        if (r3 != null) goto L124;
    L126:
        throw th;
    L124:
        if (r3.isOpen() == false) goto L126;
        r3.close();
        goto L126
    L135:
        if (fd.a(r6, "hist") == true) goto L20;
        if (r6 != null) goto L13;
        return;
    L13:
        if (r6.isOpen() == false) goto L141;
        r6.close();     // Catch: Throwable -> L16
        return;
    L141:
        return;
    L20:
        StringBuilder r5 = new StringBuilder();     // Catch: Throwable -> L106
        if (r22 == true) goto L28;
        r5.append("time >").append(fd.a() - eu.d());     // Catch: Throwable -> L16
        if (r21 == null) goto L32;
        StringBuilder r11 = r5.append(" and feature = '");     // Catch: Throwable -> L16
        String r1 = r21 + "'";     // Catch: Throwable -> L16
    L26:
        r11.append(r1);     // Catch: Throwable -> L16
    L32:
        r10 = r6.query("hist" + this.k, new String[]{"feature", " nb", "loc"}, r5.toString(), null, null, null, "time ASC", null);     // Catch: Throwable -> L106
        StringBuilder r12 = new StringBuilder();     // Catch: Throwable -> L104
        if (this.l == null) goto L133;
    L39:
        if (r10 != null) goto L41;
    L96:
        r13 = r6;
    L97:
        if (r10 == null) goto L99;
        r10.close();
    L99:
        if (r13 != null) goto L101;
        return;
    L101:
        if (r13.isOpen() == false) goto L144;
        r13.close();
        return;
    L144:
        return;
    L41:
        if (r10.moveToFirst() == false) goto L96;
    L42:
        String r4 = ",access";
        if (r10.getString(r9).startsWith("{") == false) goto L56;
        JSONObject r2 = new JSONObject(r10.getString(r9));     // Catch: Throwable -> L37
        r12.delete(r9, r12.length());     // Catch: Throwable -> L37
        if (TextUtils.isEmpty(r10.getString(1)) == true) goto L50;
        r4 = r10.getString(1);     // Catch: Throwable -> L37
    L48:
        r12.append(r4);     // Catch: Throwable -> L37
    L52:
        JSONObject r7 = new JSONObject(r10.getString(2));     // Catch: Throwable -> L37
        if (fd.a(r7, "type") == false) goto L70;
        r7.put("type", "new");     // Catch: Throwable -> L37
    L70:
        es r14 = new es("");     // Catch: Throwable -> L104
        r14.b(r7);     // Catch: Throwable -> L104
        if (fd.a(r2, "mmac") == false) goto L82;
        if (fd.a(r2, "cgi") == false) goto L82;
        String r15 = (r2.getString("cgi") + "#") + "network#";     // Catch: Throwable -> L37
        if (r2.getString("cgi").contains("#") == false) goto L79;
        StringBuilder r16 = new StringBuilder().append(r15).append("cgiwifi");     // Catch: Throwable -> L37
    L78:
        String r17 = r16.toString();     // Catch: Throwable -> L37
    L86:
        r13 = r6;
        a(r17, r12, r14, r8, false);     // Catch: Throwable -> L94
    L90:
        if (r10.moveToNext() == false) goto L91;
        r5 = r5;
        r6 = r13;
        r9 = 0;
        goto L42
    L91:
        r12.delete(0, r12.length());     // Catch: Throwable -> L94
        r5.delete(0, r5.length());     // Catch: Throwable -> L94
    L94:
        th = th;
        goto L108
    L79:
        r16 = new StringBuilder().append(r15).append(LocationAnnotation.LightLocationType.LIGHT_LOCATION_WIFI);     // Catch: Throwable -> L37
    L82:
        if (fd.a(r2, "cgi") == false) goto L88;
        String r18 = (r2.getString("cgi") + "#") + "network#";     // Catch: Throwable -> L104
        if (r2.getString("cgi").contains("#") == false) goto L88;
        r17 = r18 + "cgi";     // Catch: Throwable -> L104
    L88:
        r13 = r6;
        goto L90
    L50:
        if (fd.a(r2, "mmac") == false) goto L52;
        r12.append("#").append(r2.getString("mmac"));     // Catch: Throwable -> L37
    L37:
        th = th;
    L18:
        r3 = r6;
        goto L127
    L56:
        JSONObject r19 = new JSONObject(new String(eh.b(fq.b(r10.getString(r9)), this.l), RpcUtils.CHARSET_UTF8));     // Catch: Throwable -> L104
        r12.delete(0, r12.length());     // Catch: Throwable -> L104
        if (TextUtils.isEmpty(r10.getString(1)) == true) goto L62;
        r4 = new String(eh.b(fq.b(r10.getString(1)), this.l), RpcUtils.CHARSET_UTF8);     // Catch: Throwable -> L37
    L59:
        r12.append(r4);     // Catch: Throwable -> L37
    L66:
        r7 = new JSONObject(new String(eh.b(fq.b(r10.getString(2)), this.l), RpcUtils.CHARSET_UTF8));     // Catch: Throwable -> L104
        if (fd.a(r7, "type") == false) goto L69;
        r7.put("type", "new");     // Catch: Throwable -> L37
    L69:
        r2 = r19;
        goto L70
    L62:
        if (fd.a(r19, "mmac") == false) goto L66;
        r12.append("#").append(r19.getString("mmac"));     // Catch: Throwable -> L37
        goto L59
    L133:
        this.l = fd.l(r8);     // Catch: Throwable -> L37
    L104:
        th = th;
        r13 = r6;
        goto L108
    L28:
        r5.append("time >").append(fd.a() - 172800000);     // Catch: Throwable -> L106
        if (r21 == null) goto L32;
        r11 = r5.append(" and feature = '");     // Catch: Throwable -> L16
        r1 = r21 + "'";     // Catch: Throwable -> L16
    L16:
        th = th;
        r10 = null;
    L109:
        th = th;
        r10 = null;
        goto L127
    }

    private void a(String r8, AMapLocation r9, StringBuilder r10, Context r11) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.memorydata.plugin");
        if (r12 != null) goto L6;
        return;
    L6:
        if (this.l != null) goto L8;
        this.l = fd.l(r12);
    L8:
        String r13 = a(r8, r10, r12);
        StringBuilder r2 = new StringBuilder();
        SQLiteDatabase r4 = null;
        r4 = r12.openOrCreateDatabase("hmdb", 0, null);     // Catch: Throwable -> L19
        r2.append("CREATE TABLE IF NOT EXISTS hist");     // Catch: Throwable -> L19
        r2.append(this.k);     // Catch: Throwable -> L19
        r2.append(" (feature VARCHAR PRIMARY KEY, nb VARCHAR, loc VARCHAR, time VARCHAR);");     // Catch: Throwable -> L19
        r4.execSQL(r2.toString());     // Catch: Throwable -> L19
        r2.delete(0, r2.length());     // Catch: Throwable -> L19
        r2.append("REPLACE INTO ");     // Catch: Throwable -> L19
        r2.append("hist").append(this.k);     // Catch: Throwable -> L19
        r2.append(" VALUES (?, ?, ?, ?)");     // Catch: Throwable -> L19
        Object[] r14 = new Object[4];     // Catch: Throwable -> L19
        r14[0] = r13;     // Catch: Throwable -> L19
        byte[] r15 = eh.a(r10.toString().getBytes(RpcUtils.CHARSET_UTF8), this.l);     // Catch: Throwable -> L19
        int r16 = 1;
        r14[1] = r15;     // Catch: Throwable -> L19
        r14[2] = eh.a(r9.toStr().getBytes(RpcUtils.CHARSET_UTF8), this.l);     // Catch: Throwable -> L19
        r14[3] = Long.valueOf(r9.getTime());     // Catch: Throwable -> L19
    L10:
        if (r16 >= 3) goto L12;
        r14[r16] = fq.b((byte[]) ZeusTransformUtils.preCheckCast((byte[]) ZeusTransformUtils.preCheckCast(r14[r16], byte[].class, "com.obric.memorydata.plugin"), byte[].class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L19
        r16 = r16 + 1;     // Catch: Throwable -> L19
        goto L10
    L12:
        r4.execSQL(r2.toString(), r14);     // Catch: Throwable -> L19
        r2.delete(0, r2.length());     // Catch: Throwable -> L19
        r2.delete(0, r2.length());
        if (r4 != null) goto L16;
        return;
    L16:
        if (r4.isOpen() == false) goto L40;
        r4.close();
        return;
    L40:
        return;
    L19:
        th = move-exception;
        ev.a(th, "DB", "updateHist");     // Catch: Throwable -> L27
        r2.delete(0, r2.length());
        if (r4 != null) goto L24;
        return;
    L24:
        if (r4.isOpen() == false) goto L42;
        r4.close();
        return;
    L42:
        return;
    L27:
        th = move-exception;
        r2.delete(0, r2.length());
        if (r4 != null) goto L31;
    L33:
        throw th;
    L31:
        if (r4.isOpen() == false) goto L33;
        r4.close();
        goto L33
    }

    private static void a(String r4, Hashtable<String, String> r5) {
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
        r5.put(r2, "");
    L12:
        r1 = r1 + 1;
        goto L6
    }

    private boolean a(es r2, boolean r3) {
        if (a(r3) == true) goto L5;
        return false;
    L5:
        if (r2 != null) goto L7;
        return true;
    L7:
        if (eu.a(r2.getTime()) == true) goto L12;
        if (r3 == true) goto L13;
        return false;
    L13:
        return true;
    L12:
        return true;
    }

    private static boolean a(String r2, es r3) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
    L12:
        return false;
    L5:
        if (fd.a(r3) == false) goto L12;
        if (r2.startsWith("#") == false) goto L11;
        return false;
    L11:
        return r2.contains("network");
    }

    private static boolean a(String r4, StringBuilder r5) {
        if (TextUtils.isEmpty(r4) == false) goto L5;
    L21:
        return false;
    L5:
        if (TextUtils.isEmpty(r5) == true) goto L21;
        if (r4.contains(",access") == false) goto L21;
        if (r5.indexOf(",access") == (-1)) goto L21;
        String[] r6 = r4.split(",access");
        if (r6[0].contains("#") == false) goto L15;
        String r7 = r6[0].substring(r6[0].lastIndexOf("#") + 1);
    L17:
        if (TextUtils.isEmpty(r7) == false) goto L20;
        return false;
    L20:
        return r5.toString().contains(r7 + ",access");
    L15:
        r7 = r6[0];
        goto L17
    }

    private boolean a(boolean r3) {
        if (eu.e() == true) goto L7;
        if (r3 == true) goto L7;
        return false;
    L7:
        if (this.f5490b == false) goto L9;
        return true;
    L9:
        if (eu.f() == true) goto L15;
        if (r3 == true) goto L16;
        return false;
    L16:
        return true;
    L15:
        return true;
    }

    private static double[] a(double[] r19, double[] r20) {
        double[] r1 = new double[3];
        double r2 = 0.0d;
        int r4 = 0;
        double r5 = 0.0d;
        double r7 = 0.0d;
        int r9 = 0;
        int r10 = 0;
        int r11 = 0;
    L4:
        if (r9 >= r19.length) goto L11;
        r5 = r5 + (r19[r9] * r19[r9]);
        r7 = r7 + (r20[r9] * r20[r9]);
        r2 = r2 + (r19[r9] * r20[r9]);
        if (r20[r9] != 1.0d) goto L10;
        r11 = r11 + 1;
        if (r19[r9] != 1.0d) goto L10;
        r10 = r10 + 1;
    L10:
        r9 = r9 + 1;
        goto L4
    L11:
        r1[0] = r2 / (Math.sqrt(r5) * Math.sqrt(r7));
        double r3 = r10;
        r1[1] = (r3 * 1.0d) / ((double) r11);
        r1[2] = r3;
    L12:
        if (r4 >= 2) goto L17;
        if (r1[r4] <= 1.0d) goto L16;
        r1[r4] = 1.0d;
    L16:
        r4 = r4 + 1;
        goto L12
    L17:
        return r1;
    }

    private boolean b() {
        long r0 = fd.b();
        long r2 = this.i;
        long r1 = r0 - r2;
        if (r2 != 0) goto L6;
        return false;
    L6:
        if (this.f5489a.size() <= 360) goto L8;
    L9:
        return true;
    L8:
        if (r1 > 172800000) goto L9;
        return false;
    }

    private void c() {
        this.i = 0;
        if (this.f5489a.isEmpty() == true) goto L5;
        this.f5489a.clear();
    L5:
        this.j = false;
    }

    private void c(Context r10) {
        Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
        if (r11 != null) goto L5;
        return;
    L5:
        SQLiteDatabase r2 = null;
        r2 = r11.openOrCreateDatabase("hmdb", 0, null);     // Catch: Throwable -> L25
        if (fd.a(r2, "hist") == true) goto L38;
        if (r2 != null) goto L10;
        return;
    L10:
        if (r2.isOpen() == false) goto L44;
        r2.close();     // Catch: Throwable -> L25
        return;
    L44:
        return;
    L38:
        r2.delete("hist" + this.k, "time<?", new String[]{String.valueOf(fd.a() - 172800000)});     // Catch: Throwable -> L16
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
        ev.a(th, "DB", "clearHist");     // Catch: Throwable -> L25
        String r9 = th.getMessage();     // Catch: Throwable -> L25
        if (TextUtils.isEmpty(r9) == true) goto L20;
        r9.contains("no such table");     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        ev.a(th, "DB", "clearHist p2");     // Catch: Throwable -> L32
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

    public final es a(Context r4, String r5, StringBuilder r6, boolean r7, boolean r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        if (TextUtils.isEmpty(r5) == false) goto L6;
        return null;
    L6:
        if (eu.e() == true) goto L8;
        return null;
    L8:
        String r10 = r5 + "&" + this.f + "&" + this.g + "&" + this.h;
        if (r10.contains("gps") == false) goto L11;
    L27:
        return null;
    L11:
        if (eu.e() == false) goto L27;
        if (r6 == null) goto L27;
        if (b() == false) goto L18;
        c();
        return null;
    L18:
        if (r7 == false) goto L23;
        if (this.j == true) goto L23;
        String r11 = a(r10, r6, r9);     // Catch: Throwable -> L28
        c();     // Catch: Throwable -> L28
        a(r9, r11, r8);     // Catch: Throwable -> L28
    L23:
        if (this.f5489a.isEmpty() == false) goto L26;
        return null;
    L26:
        return a(r10, r6, r8);
    }

    public final es a(du r16, boolean r17, es r18, eg r19, StringBuilder r20, String r21, Context r22, boolean r23) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r22, Context.class, "com.obric.memorydata.plugin");
        if (a(r18, r23) == true) goto L79;
        return null;
    L79:
        dt r3 = r16.e();     // Catch: Throwable -> L78
        if (r3 == null) goto L8;
    L9:
        dt r4 = this.e;     // Catch: Throwable -> L78
        if (r4 != null) goto L12;
    L15:
        boolean r5 = true;
    L16:
        if (r18 == null) goto L24;
        int r6 = r19.e().size();     // Catch: Throwable -> L78
        if (r18.getAccuracy() > 299.0f) goto L20;
    L22:
        boolean r7 = false;
    L23:
        boolean r10 = r7;
    L26:
        if (r18 == null) goto L43;
        String r13 = this.d;     // Catch: Throwable -> L78
        if (r13 == null) goto L43;
        if (r10 == true) goto L43;
        if (r5 == true) goto L43;
        boolean r8 = fd.a(r13, r20.toString());     // Catch: Throwable -> L78
        if (this.c != 0) goto L34;
    L36:
        boolean r9 = false;
    L37:
        if (r8 == true) goto L40;
        if (r9 == true) goto L40;
    L44:
        if (r8 == true) goto L46;
        this.c = fd.b();     // Catch: Throwable -> L78
    L47:
        String r0 = this.m;     // Catch: Throwable -> L78
        if (r0 == null) goto L57;
        if (r21.equals(r0) == true) goto L57;
        if ((fd.a() - this.n) >= 3000) goto L54;
        String r11 = this.m;     // Catch: Throwable -> L78
    L61:
        if (r10 == true) goto L64;
        if (r17 == true) goto L64;
        es r1 = a(r2, r11, r20, false, false);     // Catch: Throwable -> L78
    L65:
        if (r17 == false) goto L67;
    L69:
        boolean r12 = false;
    L70:
        if (r12 == true) goto L77;
        if (r10 == true) goto L77;
        if (r17 == false) goto L75;
        return null;
    L75:
        this.c = 0;     // Catch: Throwable -> L78
        r1.setLocationType(4);     // Catch: Throwable -> L78
        return r1;
    L67:
        if (fd.a(r1) == true) goto L69;
        r12 = true;
    L64:
        r1 = null;
        goto L65
    L54:
        long r14 = fd.a();     // Catch: Throwable -> L78
    L55:
        this.n = r14;     // Catch: Throwable -> L78
        this.m = r21;     // Catch: Throwable -> L78
    L60:
        r11 = r21;
    L57:
        if (this.m != null) goto L59;
        r14 = fd.a();     // Catch: Throwable -> L78
        goto L55
    L59:
        this.n = fd.a();     // Catch: Throwable -> L78
        goto L60
    L46:
        this.c = 0;     // Catch: Throwable -> L78
    L40:
        if (fd.a(r18) == false) goto L44;
        r18.e("mem");     // Catch: Throwable -> L78
        r18.setLocationType(2);     // Catch: Throwable -> L78
        return r18;
    L34:
        if ((fd.b() - this.c) >= 3000) goto L36;
        r9 = true;
    L43:
        r8 = false;
        goto L44
    L20:
        if (r6 <= 5) goto L22;
        r7 = true;
        goto L23
    L24:
        r10 = false;
        goto L26
    L12:
        if (r4.equals(r3) == false) goto L15;
    L14:
        r5 = false;
        goto L16
    L8:
        if (this.e == null) goto L14;
    L77:
        return null;
    }

    public final void a() {
        this.c = 0;
        this.d = null;
    }

    public final void a(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (this.j == false) goto L11;
        return;
    L11:
        c();     // Catch: Throwable -> L7
        a(r4, null, false);     // Catch: Throwable -> L7
    L9:
        this.j = true;
        return;
    L7:
        th = move-exception;
        ev.a(th, "Cache", "loadDB");
        goto L9
    }

    public final void a(AMapLocationClientOption r2) {
        this.g = r2.isNeedAddress();
        this.f = r2.isOffset();
        this.f5490b = r2.isLocationCacheEnable();
        this.h = String.valueOf(r2.getGeoLanguage());
    }

    public final void a(dt r1) {
        this.e = r1;
    }

    public final void a(String r1) {
        this.d = r1;
    }

    public final void a(String r17, StringBuilder r18, es r19, Context r20, boolean r21) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r20, Context.class, "com.obric.memorydata.plugin");
    L81:
        th = move-exception;
        ev.a(th, "Cache", "add");
        return;
    L4:
        if (fd.a(r19) == true) goto L6;
        return;
    L6:
        String r13 = r17 + "&" + r19.isOffset() + "&" + r19.i() + "&" + r19.j();     // Catch: Throwable -> L81
        if (a(r13, r19) == true) goto L10;
        return;
    L10:
        if (r19.e().equals("mem") == false) goto L12;
        return;
    L12:
        if (r19.e().equals("file") == false) goto L14;
        return;
    L14:
        if (r19.e().equals("wifioff") == false) goto L17;
        return;
    L17:
        if ("-3".equals(r19.d()) == false) goto L20;
        return;
    L20:
        if (b() == false) goto L22;
        c();     // Catch: Throwable -> L81
    L22:
        JSONObject r3 = r19.f();     // Catch: Throwable -> L81
        if (fd.a(r3, "offpct") == false) goto L27;
        r3.remove("offpct");     // Catch: Throwable -> L81
        r19.a(r3);     // Catch: Throwable -> L81
    L27:
        if (r13.contains(LocationAnnotation.LightLocationType.LIGHT_LOCATION_WIFI) == false) goto L53;
        if (TextUtils.isEmpty(r18) == false) goto L32;
        return;
    L32:
        if (r19.getAccuracy() < 300.0f) goto L43;
        String[] r2 = r18.toString().split("#");     // Catch: Throwable -> L81
        int r5 = r2.length;     // Catch: Throwable -> L81
        int r6 = 0;
        int r15 = 0;
    L34:
        if (r6 >= r5) goto L40;
        if (r2[r6].contains(",") == false) goto L38;
        r15 = r15 + 1;     // Catch: Throwable -> L81
    L38:
        r6 = r6 + 1;     // Catch: Throwable -> L81
        goto L34
    L40:
        if (r15 < 8) goto L46;
        return;
    L46:
        if (r13.contains("cgiwifi") == true) goto L48;
    L61:
        es r1 = a(r13, r18, false);     // Catch: Throwable -> L81
        if (fd.a(r1) == true) goto L64;
    L66:
        this.i = fd.b();     // Catch: Throwable -> L81
        a r4 = new a();     // Catch: Throwable -> L81
        r4.a(r19);     // Catch: Throwable -> L81
        if (TextUtils.isEmpty(r18) == false) goto L69;
        String r7 = null;
    L70:
        r4.a(r7);     // Catch: Throwable -> L81
        if (this.f5489a.containsKey(r13) == false) goto L73;
        ((ArrayList) ZeusTransformUtils.preCheckCast(this.f5489a.get(r13), ArrayList.class, "com.obric.memorydata.plugin")).add(r4);     // Catch: Throwable -> L81
    L74:
        if (r21 == false) goto L94;
        a(r13, r19, r18, r12);     // Catch: Throwable -> L77
        return;
    L77:
        th = move-exception;
        ev.a(th, "Cache", "add");     // Catch: Throwable -> L81
        return;
    L94:
        return;
    L73:
        ArrayList<a> r8 = new ArrayList();     // Catch: Throwable -> L81
        r8.add(r4);     // Catch: Throwable -> L81
        this.f5489a.put(r13, r8);     // Catch: Throwable -> L81
        goto L74
    L69:
        r7 = r18.toString();     // Catch: Throwable -> L81
        goto L70
    L64:
        if (r1.toStr().equals(r19.toStr(3)) == false) goto L66;
        return;
    L48:
        if (TextUtils.isEmpty(r19.g()) == true) goto L61;
        String r9 = r13.replace("cgiwifi", "cgi");     // Catch: Throwable -> L81
        es r10 = r19.h();     // Catch: Throwable -> L81
        if (fd.a(r10) == false) goto L61;
        a(r9, new StringBuilder(), r10, r12, true);     // Catch: Throwable -> L81
        goto L61
    L43:
        if (r19.getAccuracy() > 3.0f) goto L46;
        return;
    L53:
        if (r13.contains("cgi") == false) goto L61;
        if (r18 == null) goto L59;
        if (r18.indexOf(",") == (-1)) goto L59;
        return;
    L59:
        if ("4".equals(r19.d()) == false) goto L61;
    }

    public final void b(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        c();     // Catch: Throwable -> L5
        c(r4);     // Catch: Throwable -> L5
        this.j = false;     // Catch: Throwable -> L5
        this.d = null;     // Catch: Throwable -> L5
        this.n = 0;     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        ev.a(th, "Cache", "destroy part");
    }
}
