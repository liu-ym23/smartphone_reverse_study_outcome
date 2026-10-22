package com.bytedance.applog.n;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.applog.isolate.DataIsolateKey;
import com.bytedance.applog.log.p;
import com.bytedance.applog.monitor.v3.StageEventType;
import com.bytedance.applog.monitor.v3.StatsCountKeys;
import com.bytedance.applog.util.o;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.crash.constants.Constants;
import com.bytedance.crash.entity.EventBody;
import com.bytedance.rpc.internal.RpcUtils;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.ss.android.common.lib.AppLogNewUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class h extends a {
    private static final SimpleDateFormat ac = null;
    JSONArray A;
    long B;
    g C;
    JSONArray D;
    j E;
    JSONArray F;
    long G;
    public int H;
    public String I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private JSONArray f1731J;
    private JSONObject K;
    private JSONArray L;
    private String M;
    private String N;
    private String O;
    private com.bytedance.applog.priority.b P;
    private String Q;
    private String R;
    private String S;
    private String T;
    private JSONObject U;
    private int V;
    private int W;
    private int X;
    private int Y;
    private int Z;
    private int aa;
    private int ab;
    public byte[] v;
    int w;
    public int x;
    JSONArray y;
    long z;

    static {
        ac = com.bytedance.applog.util.c.a();
    }

    public h() {
        this.ab = 0;
    }

    private h E() {
        h r11 = new h();
        r11.a(this.m, this.K, null, null, null, new JSONArray[]{new JSONArray(), null, null}, new long[]{this.z, this.B, this.G}, null, this.P, this.ab);
        r11.d = this.d;
        r11.S = this.S;
        r11.T = this.T;
        return r11;
    }

    public static h a(com.bytedance.applog.b r15, List<a> r16, JSONObject r17, com.bytedance.applog.priority.b r18) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r16, List.class, "com.obric.memorydata.plugin");
        h r13 = new h();
        JSONArray[] r8 = {null, new JSONArray(), null};     // Catch: Throwable -> L9
        long[] r9 = new long[3];     // Catch: Throwable -> L9
        Iterator r2 = r0.iterator();     // Catch: Throwable -> L9
    L5:
        if (r2.hasNext() == false) goto L7;
        r8[1].put(((a) ZeusTransformUtils.preCheckCast(r2.next(), a.class, "com.obric.memorydata.plugin")).m());     // Catch: Throwable -> L9
        goto L5
    L7:
        r13.a(r15.b(), r17, null, null, null, r8, r9, null, r18, 8);     // Catch: Throwable -> L9
        r13.t();     // Catch: Throwable -> L9
        a(r15.b(), r0);     // Catch: Throwable -> L9
    L11:
        return r13;
    L9:
        th = move-exception;
        r15.aA().a(4, "pack real time failed", th, new Object[0]);
        goto L11
    }

    private h a(DataIsolateKey r16, String r17) {
        h r12 = new h();
        String r2 = this.m;
        JSONObject r3 = this.K;
        JSONArray r4 = null;
        if (com.bytedance.applog.util.i.a(this.D) == false) goto L5;
        JSONArray r6 = null;
    L6:
        JSONArray[] r7 = new JSONArray[3];
        if (com.bytedance.applog.util.i.a(this.y) == false) goto L9;
        JSONArray r5 = null;
    L10:
        r7[0] = r5;
        if (com.bytedance.applog.util.i.a(this.A) == false) goto L13;
        JSONArray r8 = null;
    L14:
        r7[1] = r8;
        if (com.bytedance.applog.util.i.a(this.F) == true) goto L18;
        r4 = new JSONArray();
    L18:
        r7[2] = r4;
        r12.a(r2, r3, null, null, r6, r7, new long[]{this.z, this.B, this.G}, this.L, this.P, this.ab);
        r12.d = this.d;
        r12.S = r16.getKey();
        r12.T = r17;
        return r12;
    L13:
        r8 = new JSONArray();
        goto L14
    L9:
        r5 = new JSONArray();
        goto L10
    L5:
        r6 = new JSONArray();
        goto L6
    }

    public static h a(String r1, JSONObject r2, long r3, JSONObject r5) {
        h r0 = new h();
        r0.a(r3);
        r0.a(r1);
        r0.e(r2);
        r0.d(r5);
        return r0;
    }

    public static h a(String r3, JSONObject r4, JSONArray r5, int r6) {
        h r0 = new h();
        r0.a(0);
        r0.a(r3);
        r0.e(r4);
        r0.b(r6);
        r0.a(r5);
        return r0;
    }

    private String a(List<com.bytedance.applog.monitor.v3.h> r4) {
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        JSONArray r5 = new JSONArray();
        if (r3.isEmpty() == true) goto L9;
        Iterator r6 = r3.iterator();
    L6:
        if (r6.hasNext() == false) goto L9;
        r5.put(((com.bytedance.applog.monitor.v3.h) ZeusTransformUtils.preCheckCast(r6.next(), com.bytedance.applog.monitor.v3.h.class, "com.obric.memorydata.plugin")).a());
    L9:
        return r5.toString();
    }

    private String a(Set<Long> r7) {
        Set r6 = (Set) ZeusTransformUtils.wrapperContextForParams(r7, Set.class, "com.obric.memorydata.plugin");
        if (r6.isEmpty() == true) goto L15;
        Long[] r8 = (Long[]) ZeusTransformUtils.preCheckCast(r6.toArray(new Long[0]), Long[].class, "com.obric.memorydata.plugin");
        Arrays.sort(r8);
        StringBuilder r0 = new StringBuilder();
        r0.append(r8[0]);
        if (r8.length <= 1) goto L14;
        r0.append(ParameterizedMessage.ERROR_MSG_SEPARATOR);
        int r9 = 1;
    L8:
        if (r9 >= r8.length) goto L14;
        r0.append(r8[r9].longValue() - r8[r9 - 1].longValue());
        if (r9 == (r8.length - 1)) goto L12;
        r0.append(",");
    L12:
        r9 = r9 + 1;
    L14:
        return r0.toString();
    L15:
        return "";
    }

    private static void a(final String r7, List<a> r8) {
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        if (p.a() == false) goto L5;
        return;
    L5:
        if (r9 != null) goto L7;
        return;
    L7:
        if (r9.isEmpty() == true) goto L27;
        final JSONArray r0 = new JSONArray();
        Iterator r10 = r9.iterator();
    L11:
        if (r10.hasNext() == false) goto L17;
        a r2 = (a) ZeusTransformUtils.preCheckCast(r10.next(), a.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L11;
        if (r2.q <= 0) goto L11;
        r0.put(r2.q);
        goto L11
    L17:
        p.a("event_realtime_eid", new AnonymousClass1(r7, r0));
        return;
    }

    private void a(JSONArray r1) {
        this.f1731J = r1;
    }

    private void b(int r1) {
        this.ab = r1;
    }

    private Set<Long> d(String r11) {
        HashSet r0 = new HashSet();
        if (TextUtils.isEmpty(r11) == false) goto L16;
        return r0;
    L16:
        int r3 = r11.indexOf(ParameterizedMessage.ERROR_MSG_SEPARATOR);     // Catch: Throwable -> L13
        if (r3 >= 0) goto L9;
        r0.add(Long.valueOf(Long.parseLong(r11)));     // Catch: Throwable -> L13
    L15:
        return r0;
    L9:
        long r4 = Long.parseLong(r11.substring(0, r3));     // Catch: Throwable -> L13
        r0.add(Long.valueOf(r4));     // Catch: Throwable -> L13
        String[] r5 = r11.substring(r3 + 1).split(",");     // Catch: Throwable -> L13
        int r6 = r5.length;     // Catch: Throwable -> L13
        int r7 = 0;
    L10:
        if (r7 >= r6) goto L15;
        r4 = r4 + Long.parseLong(r5[r7]);     // Catch: Throwable -> L13
        r0.add(Long.valueOf(r4));     // Catch: Throwable -> L13
        r7 = r7 + 1;
    L13:
        th = move-exception;
        s().e("Cannot parse set ids:{}!", new Object[]{r11, th});
        goto L15
    }

    private void d(JSONObject r1) {
        this.U = r1;
    }

    private List<com.bytedance.applog.monitor.v3.h> e(String r7) {
        ArrayList r0 = new ArrayList();
        if (TextUtils.isEmpty(r7) == false) goto L14;
        return r0;
    L14:
        JSONArray r2 = new JSONArray(r7);     // Catch: Throwable -> L11
        int r3 = 0;
    L8:
        if (r3 >= r2.length()) goto L13;
        r0.add(new com.bytedance.applog.monitor.v3.h(r2.optJSONObject(r3)));     // Catch: Throwable -> L11
        r3 = r3 + 1;
    L13:
        return r0;
    L11:
        th = move-exception;
        s().e("Cannot parse stage events:{}!", new Object[]{r7, th});
        goto L13
    }

    private void e(JSONObject r1) {
        this.K = r1;
    }

    public DataIsolateKey A() {
        if (o.a(this.S) == false) goto L12;
        return DataIsolateKey.fromKey(this.S);
    L6:
        th = move-exception;
        s().e("Cannot parse isolate key:{}!", new Object[]{this.S, th});
        return null;
    L12:
        return null;
    }

    public String B() {
        return this.T;
    }

    public boolean C() {
        g r0 = this.C;
        if (r0 == null) goto L7;
        if (r0.A == false) goto L7;
    L35:
        return false;
    L7:
        if (this.E != null) goto L35;
        JSONArray r1 = this.L;
        if (r1 != null) goto L11;
    L12:
        JSONArray r2 = this.y;
        if (r2 != null) goto L15;
    L16:
        JSONArray r3 = this.A;
        if (r3 != null) goto L19;
    L20:
        JSONArray r4 = this.F;
        if (r4 != null) goto L23;
    L24:
        JSONArray r5 = this.f1731J;
        if (r5 != null) goto L27;
    L28:
        JSONObject r6 = this.U;
        if (r6 == null) goto L33;
        if (r6.length() != 0) goto L35;
    L33:
        if (TextUtils.isEmpty(this.R) == false) goto L35;
        return true;
    L27:
        if (r5.length() != 0) goto L35;
    L23:
        if (r4.length() != 0) goto L35;
    L19:
        if (r3.length() != 0) goto L35;
    L15:
        if (r2.length() != 0) goto L35;
    L11:
        if (r1.length() != 0) goto L35;
        goto L12
    }

    public int D() {
        return (this.X + this.Y) + this.Z;
    }

    @Override // com.bytedance.applog.n.a
    public int a(Cursor r3) {
        Cursor r4 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r3, Cursor.class, "com.obric.memorydata.plugin");
        this.f1724a = r4.getLong(0);
        this.f1725b = r4.getLong(1);
        this.v = r4.getBlob(2);
        this.d = r4.getString(3);
        this.w = r4.getInt(4);
        r4.getString(5);
        this.M = r4.getString(6);
        this.N = r4.getString(7);
        this.O = r4.getString(8);
        this.m = r4.getString(9);
        this.H = r4.getInt(10);
        this.I = r4.getString(11);
        this.o = r4.getInt(12);
        this.p = r4.getInt(13);
        this.Q = r4.getString(14);
        this.S = r4.getString(15);
        this.T = r4.getString(16);
        this.V = r4.getInt(17);
        this.W = r4.getInt(18);
        this.X = r4.getInt(19);
        this.Y = r4.getInt(20);
        this.Z = r4.getInt(21);
        this.aa = r4.getInt(22);
        this.R = r4.getString(23);
        this.K = null;
        this.C = null;
        this.E = null;
        this.D = null;
        this.y = null;
        this.A = null;
        this.F = null;
        this.L = null;
        return 24;
    }

    public Collection<h> a(DataIsolateKey r10) {
        HashMap r1 = new HashMap();
        int r3 = 0;
    L4:
        if (com.bytedance.applog.util.i.a(this.y) == true) goto L11;
        if (r3 >= this.y.length()) goto L11;
        JSONObject r4 = this.y.optJSONObject(r3);
        String r5 = com.bytedance.applog.isolate.a.a(r10, r4, "");
        if (r1.containsKey(r5) == true) goto L10;
        r1.put(r5, a(r10, r5));
    L10:
        ((h) ZeusTransformUtils.preCheckCast(r1.get(r5), h.class, "com.obric.memorydata.plugin")).y.put(r4);
        r3 = r3 + 1;
    L11:
        int r6 = 0;
    L13:
        if (com.bytedance.applog.util.i.a(this.A) == true) goto L20;
        if (r6 >= this.A.length()) goto L20;
        JSONObject r7 = this.A.optJSONObject(r6);
        String r8 = com.bytedance.applog.isolate.a.a(r10, r7, "");
        if (r1.containsKey(r8) == true) goto L19;
        r1.put(r8, a(r10, r8));
    L19:
        ((h) ZeusTransformUtils.preCheckCast(r1.get(r8), h.class, "com.obric.memorydata.plugin")).A.put(r7);
        r6 = r6 + 1;
    L20:
        int r9 = 0;
    L22:
        if (com.bytedance.applog.util.i.a(this.F) == true) goto L29;
        if (r9 >= this.F.length()) goto L29;
        JSONObject r11 = this.F.optJSONObject(r9);
        String r12 = com.bytedance.applog.isolate.a.a(r10, r11, "");
        if (r1.containsKey(r12) == true) goto L28;
        r1.put(r12, a(r10, r12));
    L28:
        ((h) ZeusTransformUtils.preCheckCast(r1.get(r12), h.class, "com.obric.memorydata.plugin")).F.put(r11);
        r9 = r9 + 1;
    L29:
        g r13 = this.C;
        if (r13 == null) goto L36;
        String r14 = com.bytedance.applog.isolate.a.a(r10, r13, "");
        if (r1.containsKey(r14) == true) goto L34;
        r1.put(r14, a(r10, r14));
    L34:
        ((h) ZeusTransformUtils.preCheckCast(r1.get(r14), h.class, "com.obric.memorydata.plugin")).C = this.C;
    L36:
        if (this.E == null) goto L46;
        if (r1.isEmpty() == false) goto L40;
        String r15 = com.bytedance.applog.isolate.a.a(r10, this.E, "");
        r1.put(r15, a(r10, r15));
    L40:
        Iterator r16 = r1.keySet().iterator();
        if (r16.hasNext() == false) goto L46;
        String r17 = (String) ZeusTransformUtils.preCheckCast(r16.next(), String.class, "com.obric.memorydata.plugin");
        ((h) ZeusTransformUtils.preCheckCast(r1.get(r17), h.class, "com.obric.memorydata.plugin")).E = this.E;
        if (com.bytedance.applog.util.i.a(this.D) == true) goto L46;
        ((h) ZeusTransformUtils.preCheckCast(r1.get(r17), h.class, "com.obric.memorydata.plugin")).D = this.D;
    L46:
        if (r1.isEmpty() == false) goto L49;
        return null;
    L49:
        if (r1.size() != 1) goto L53;
        this.S = r10.getKey();
        this.T = ((String[]) ZeusTransformUtils.preCheckCast(r1.keySet().toArray(new String[0]), String[].class, "com.obric.memorydata.plugin"))[0];
        return null;
    L53:
        return r1.values();
    }

    @Override // com.bytedance.applog.n.a
    public void a(ContentValues r4) {
        r4.put("local_time_ms", Long.valueOf(this.f1725b));     // Catch: Throwable -> L4
        r4.put("_data", t());     // Catch: Throwable -> L4
        r4.put("session_id", this.d);     // Catch: Throwable -> L4
        r4.put("key", this.M);     // Catch: Throwable -> L4
        r4.put("iv", this.N);     // Catch: Throwable -> L4
        r4.put("encode_type", Integer.valueOf(this.H));     // Catch: Throwable -> L4
        r4.put("encode_headers", this.I);     // Catch: Throwable -> L4
        r4.put("data_json", this.O);     // Catch: Throwable -> L4
        r4.put("_app_id", this.m);     // Catch: Throwable -> L4
        r4.put("priority", Integer.valueOf(this.o));     // Catch: Throwable -> L4
        r4.put("forward", Integer.valueOf(this.p));     // Catch: Throwable -> L4
        r4.put("e_ids", this.Q);     // Catch: Throwable -> L4
        r4.put("isolate_key", this.S);     // Catch: Throwable -> L4
        r4.put("isolate_key_value", this.T);     // Catch: Throwable -> L4
        r4.put("_launch_count", Integer.valueOf(this.V));     // Catch: Throwable -> L4
        r4.put("_terminate_count", Integer.valueOf(this.W));     // Catch: Throwable -> L4
        r4.put("_event_v1_count", Integer.valueOf(this.X));     // Catch: Throwable -> L4
        r4.put("_event_v3_count", Integer.valueOf(this.Y));     // Catch: Throwable -> L4
        r4.put("_event_misc_count", Integer.valueOf(this.Z));     // Catch: Throwable -> L4
        r4.put("_impression_count", Integer.valueOf(this.aa));     // Catch: Throwable -> L4
        r4.put("sentry_stained_ids", this.R);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        s().a(5, "write pack to db failed", th, new Object[0]);
    }

    public void a(com.bytedance.applog.monitor.v3.e r3, boolean r4) {
        if (this.V <= 0) goto L9;
        if (r4 == false) goto L6;
        StatsCountKeys r0 = StatsCountKeys.REPORT_SUCCESS_LAUNCH_COUNT;
    L7:
        r3.a(r0, this.V);
        goto L9
    L6:
        r0 = StatsCountKeys.REPORT_FAILED_LAUNCH_COUNT;
    L9:
        if (this.W <= 0) goto L14;
        if (r4 == false) goto L12;
        StatsCountKeys r1 = StatsCountKeys.REPORT_SUCCESS_TERMINATE_COUNT;
    L13:
        r3.a(r1, this.W);
        goto L14
    L12:
        r1 = StatsCountKeys.REPORT_FAILED_TERMINATE_COUNT;
    L14:
        int r2 = (this.X + this.Y) + this.Z;
        if (r2 <= 0) goto L21;
        if (r4 == false) goto L18;
        StatsCountKeys r5 = StatsCountKeys.REPORT_SUCCESS_EVENT_COUNT;
    L19:
        r3.a(r5, r2);
        return;
    L18:
        r5 = StatsCountKeys.REPORT_FAILED_EVENT_COUNT;
        goto L19
    }

    public void a(String r3, JSONObject r4, g r5, j r6, JSONArray r7, JSONArray[] r8, long[] r9, JSONArray r10, com.bytedance.applog.priority.b r11, int r12) {
        a(0);
        this.K = r4;
        this.C = r5;
        this.E = r6;
        this.D = r7;
        int r13 = 0;
        this.y = r8[0];
        this.z = r9[0];
        int r14 = 1;
        this.A = r8[1];
        this.B = r9[1];
        this.F = r8[2];
        this.G = r9[2];
        this.L = r10;
        this.P = r11;
        if (r11 == null) goto L5;
        int r15 = r11.a();
    L6:
        this.o = r15;
        this.ab = r12;
        this.m = r3;
        this.O = null;
        this.H = 0;
        this.I = null;
        this.M = null;
        this.N = null;
        this.Q = null;
        this.R = null;
        this.S = null;
        this.T = null;
        this.U = null;
        this.w = 0;
        this.v = null;
        if (this.C == null) goto L9;
        int r16 = 1;
    L10:
        this.V = r16;
        if (this.E != null) goto L14;
        r14 = 0;
    L14:
        this.W = r14;
        JSONArray r17 = this.y;
        if (r17 == null) goto L17;
        int r18 = r17.length();
    L18:
        this.X = r18;
        JSONArray r19 = this.A;
        if (r19 == null) goto L21;
        int r20 = r19.length();
    L22:
        this.Y = r20;
        JSONArray r21 = this.F;
        if (r21 == null) goto L25;
        int r22 = r21.length();
    L26:
        this.Z = r22;
        JSONArray r23 = this.L;
        if (r23 == null) goto L29;
        r13 = r23.length();
    L29:
        this.aa = r13;
        return;
    L25:
        r22 = 0;
        goto L26
    L21:
        r20 = 0;
        goto L22
    L17:
        r18 = 0;
        goto L18
    L9:
        r16 = 0;
        goto L10
    L5:
        r15 = -1;
        goto L6
    }

    @Override // com.bytedance.applog.n.a
    public void a(JSONObject r4) {
        s().d(4, this.t, "write ipc not implemented", new Object[0]);
    }

    public boolean a(com.bytedance.applog.e.f r8) {
        if (TextUtils.isEmpty(this.O) == false) goto L5;
        return false;
    L5:
        JSONObject r0 = null;
        r0 = new JSONObject(this.O);     // Catch: JSONException -> L29
    L8:
        if (r0 != null) goto L10;
    L28:
        return false;
    L10:
        if (r0.isNull("terminate") == true) goto L28;
        JSONObject r7 = r0.optJSONObject("terminate");
        if (r7 != null) goto L15;
        return false;
    L15:
        SimpleDateFormat r1 = ac;
        String r2 = r1.format(new Date(System.currentTimeMillis()));
        if (r2.equals(r1.format(Long.valueOf(r8.i()))) == false) goto L18;
        return false;
    L18:
        long r3 = r7.optLong("local_time_ms", -1);
        if (r3 < 0) goto L28;
        if (r1.format(new Date(r3)).startsWith(r2) == true) goto L28;
        if (r2.equals(r1.format(new Date(r7.optLong("stop_timestamp") * 1000))) == false) goto L26;
        return false;
    L26:
        return true;
    }

    @Override // com.bytedance.applog.n.a
    public a b(JSONObject r4) {
        s().d(4, this.t, "read ipc not implemented", new Object[0]);
        return null;
    }

    public List<h> c(long r20) {
        ArrayList r1 = new ArrayList();
        if (m().toString().length() >= r20) goto L6;
        r1.add(this);
        return r1;
    L6:
        JSONObject r2 = this.K;
        if (r2 == null) goto L9;
        long r5 = r2.toString().length();
    L10:
        h r3 = new h();
        r3.a(this.m, this.K, this.C, this.E, this.D, new JSONArray[]{null, null, null}, new long[]{this.z, this.B, this.G}, this.L, this.P, this.ab);
        r3.d = this.d;
        r3.S = this.S;
        r3.T = this.T;
        r1.add(r3);
        long r4 = r20 - r5;
        g r6 = this.C;
        if (r6 == null) goto L13;
        long r7 = r4 - ((long) r6.m().toString().length());
    L14:
        j r8 = this.E;
        if (r8 == null) goto L17;
        r7 = r7 - ((long) r8.m().toString().length());
    L17:
        JSONArray r9 = this.L;
        if (r9 == null) goto L20;
        r7 = r7 - ((long) r9.toString().length());
    L20:
        int r10 = 0;
    L22:
        if (com.bytedance.applog.util.i.a(this.y) == true) goto L36;
        if (r10 >= this.y.length()) goto L36;
        JSONObject r11 = this.y.optJSONObject(r10);
        if (r11 == null) goto L35;
        long r12 = r11.toString().length();
        r7 = r7 - r12;
        if (r7 > 0) goto L31;
        r3 = E();
        r1.add(r3);
        JSONArray r13 = new JSONArray();
        r3.y = r13;
        r13.put(r11);
        r7 = r4 - r12;
        goto L35
    L31:
        if (r3.y != null) goto L33;
        r3.y = new JSONArray();
    L33:
        r3.y.put(r11);
    L35:
        r10 = r10 + 1;
    L36:
        int r14 = 0;
    L38:
        if (com.bytedance.applog.util.i.a(this.A) == true) goto L52;
        if (r14 >= this.A.length()) goto L52;
        JSONObject r15 = this.A.optJSONObject(r14);
        if (r15 == null) goto L51;
        long r16 = r15.toString().length();
        r7 = r7 - r16;
        if (r7 > 0) goto L47;
        r3 = E();
        r1.add(r3);
        JSONArray r17 = new JSONArray();
        r3.A = r17;
        r17.put(r15);
        r7 = r4 - r16;
        goto L51
    L47:
        if (r3.A != null) goto L49;
        r3.A = new JSONArray();
    L49:
        r3.A.put(r15);
    L51:
        r14 = r14 + 1;
    L52:
        int r18 = 0;
    L54:
        if (com.bytedance.applog.util.i.a(this.F) == true) goto L68;
        if (r18 >= this.F.length()) goto L68;
        JSONObject r19 = this.F.optJSONObject(r18);
        if (r19 == null) goto L67;
        long r21 = r19.toString().length();
        r7 = r7 - r21;
        if (r7 > 0) goto L63;
        r3 = E();
        r1.add(r3);
        JSONArray r22 = new JSONArray();
        r3.F = r22;
        r22.put(r19);
        r7 = r4 - r21;
        goto L67
    L63:
        if (r3.F != null) goto L65;
        r3.F = new JSONArray();
    L65:
        r3.F.put(r19);
    L67:
        r18 = r18 + 1;
    L68:
        return r1;
    L13:
        r7 = r4;
        goto L14
    L9:
        r5 = 0;
        goto L10
    }

    public byte[] c(String r10) {
        this.v = null;
        HashMap r0 = new HashMap();
        if (TextUtils.isEmpty(r10) == false) goto L5;
    L26:
        this.I = o.a(r0);
        return this.v;
    L5:
        if (com.bytedance.applog.a.a(this.m) == false) goto L26;
        com.bytedance.applog.b r1 = com.bytedance.applog.a.b(this.m);
        if (r1 == null) goto L26;
        byte[] r11 = r10.getBytes(RpcUtils.CHARSET_UTF8);     // Catch: Throwable -> L24
        this.v = r11;     // Catch: Throwable -> L24
        if (r11 == null) goto L26;
        if (r11.length <= 0) goto L26;
        if (r1.Z() == null) goto L21;
        com.bytedance.applog.d r12 = r1.Z().a(this.v);     // Catch: Throwable -> L17
        this.v = r12.a();     // Catch: Throwable -> L17
        this.H = r12.b();     // Catch: Throwable -> L17
        r0.putAll(r12.c());     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        s().a(4, this.t, "log compress toBytes failed", th, new Object[0]);     // Catch: Throwable -> L24
        r1.ab().a(StatsCountKeys.COMPRESS_ERROR_COUNT);     // Catch: Throwable -> L24
    L21:
        if (r1.k() == false) goto L26;
        this.v = r1.aw().a().b(this.v);     // Catch: Throwable -> L24
        r0.remove(NetConst.KEY_CONTENT_ENCODING);     // Catch: Throwable -> L24
        r0.put(NetConst.KEY_CONTENT_TYPE, "application/octet-stream;tt-data=a");     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        s().a(4, this.t, "toBytes failed", th, new Object[0]);
        r1.ab().a(StatsCountKeys.PACK_ERROR_COUNT);
        r1.ab().a("pack_to_bytes_failed", th);
        goto L26
    }

    @Override // com.bytedance.applog.n.a
    public List<String> e() {
        return Arrays.asList(new String[]{"_id", "integer primary key autoincrement", "local_time_ms", TypedValues.Custom.S_INT, "_data", "blob", "session_id", "varchar", "_fail", TypedValues.Custom.S_INT, "event_count", "varchar", "key", "varchar", "iv", "varchar", "data_json", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "_app_id", "varchar", "encode_type", TypedValues.Custom.S_INT, "encode_headers", "varchar", "priority", TypedValues.Custom.S_INT, "forward", TypedValues.Custom.S_INT, "e_ids", "varchar", "isolate_key", "varchar", "isolate_key_value", "varchar", "_launch_count", TypedValues.Custom.S_INT, "_terminate_count", TypedValues.Custom.S_INT, "_event_v1_count", TypedValues.Custom.S_INT, "_event_v3_count", TypedValues.Custom.S_INT, "_event_misc_count", TypedValues.Custom.S_INT, "_impression_count", TypedValues.Custom.S_INT, "sentry_stained_ids", "varchar"});
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v7, types: [com.bytedance.applog.m.a] */
    /* JADX WARN: Type inference failed for: r14v12, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r21v4 */
    /* JADX WARN: Type inference failed for: r2v32, types: [java.lang.Object, org.json.JSONArray] */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r5v5, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r6v0, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r6v29 */
    /* JADX WARN: Type inference failed for: r6v34 */
    /* JADX WARN: Type inference failed for: r6v35 */
    /* JADX WARN: Type inference failed for: r7v39, types: [java.lang.Object, org.json.JSONObject] */
    @Override // com.bytedance.applog.n.a
    public JSONObject f() {
        JSONObject r0 = this.U;
        String r2 = "iv";
        if (r0 == null) goto L6;
        this.M = r0.optString("key");
        this.N = this.U.optString("iv");
        return this.U;
    L6:
        HashSet r1 = new HashSet();
        ArrayList r4 = new ArrayList();
        com.bytedance.applog.b r5 = com.bytedance.applog.a.b(this.m);
        ?? r6 = new JSONObject();
        r6.put(Api.KEY_MAGIC, Api.MSG_MAGIC);
        r6.put("header", this.K);
        if (r5 != null) goto L9;
    L11:
        r6.put("_gen_time", System.currentTimeMillis());
        g r7 = this.C;
        if (r7 == null) goto L14;
        int r10 = 1;
    L15:
        this.V = r10;
        if (r7 != null) goto L18;
    L26:
        j r8 = this.E;
        if (r8 == null) goto L29;
        int r12 = 1;
    L30:
        this.W = r12;
        if (r8 != null) goto L33;
        String r20 = "iv";
    L54:
        JSONArray r3 = this.f1731J;
        if (r3 != null) goto L57;
    L66:
        JSONArray r9 = this.y;
        if (r9 == null) goto L69;
        int r11 = r9.length();
    L70:
        this.X = r11;
        String r13 = "event";
        String r14 = "event_stained";
        String r15 = "event_id";
        if (r11 <= 0) goto L84;
        JSONArray r16 = new JSONArray();
        int r17 = 0;
        ?? r18 = r6;
    L74:
        if (r17 >= this.y.length()) goto L83;
        JSONObject r19 = this.y.getJSONObject(r17);
        com.bytedance.applog.b r110 = r5;
        ?? r21 = r18;
        long r111 = r19.optLong(r15, 0);
        if (r111 <= 0) goto L79;
        r1.add(Long.valueOf(r111));
    L79:
        if (r19.optInt(r14, 0) <= 0) goto L82;
        r4.add(new com.bytedance.applog.monitor.v3.h(r19.optString(LocationMonitorConst.TAG, ""), String.valueOf(r19.optLong("monitor_id", 0)), r19.optLong("local_time_ms", 0), StageEventType.V1_EVENT));
    L82:
        r16.put(r19);
        r17 = r17 + 1;
        r14 = r14;
        r5 = r110;
        r18 = r21;
        r15 = r15;
        goto L74
    L83:
        com.bytedance.applog.b r112 = r5;
        ?? r22 = r18;
        String r23 = r14;
        String r30 = r15;
        r22.put("event", r16);
        ?? r24 = r22;
    L85:
        JSONArray r25 = this.A;
        if (r25 == null) goto L88;
        int r26 = r25.length();
    L89:
        this.Y = r26;
        if (r26 <= 0) goto L103;
        JSONArray r27 = new JSONArray();
        int r113 = 0;
    L93:
        if (r113 >= this.A.length()) goto L102;
        JSONObject r114 = this.A.getJSONObject(r113);
        com.bytedance.applog.b r28 = r112;
        String r115 = r30;
        long r116 = r114.optLong(r115, 0);
        if (r116 <= 0) goto L98;
        r1.add(Long.valueOf(r116));
    L98:
        if (r114.optInt(r23, 0) <= 0) goto L101;
        r4.add(new com.bytedance.applog.monitor.v3.h(r114.optString(r13, ""), String.valueOf(r114.optLong("monitor_id", 0)), r114.optLong("local_time_ms", 0), StageEventType.V3_EVENT));
    L101:
        r27.put(r114);
        r113 = r113 + 1;
        r13 = r13;
        r112 = r28;
        r23 = r23;
        r30 = r115;
        goto L93
    L102:
        com.bytedance.applog.b r29 = r112;
        String r117 = r30;
        String r31 = r23;
        r24.put(AppLogNewUtils.EVENT_V3_CATEGORY, r27);
    L104:
        JSONArray r32 = this.F;
        if (r32 == null) goto L107;
        int r33 = r32.length();
    L108:
        this.Z = r33;
        if (r33 <= 0) goto L122;
        JSONArray r34 = new JSONArray();
        int r35 = 0;
    L112:
        if (r35 >= this.F.length()) goto L121;
        JSONObject r36 = this.F.getJSONObject(r35);
        long r118 = r36.optLong(r117, 0);
        if (r118 <= 0) goto L116;
        r1.add(Long.valueOf(r118));
    L116:
        String r119 = r31;
        if (r36.optInt(r119, 0) <= 0) goto L120;
        r4.add(new com.bytedance.applog.monitor.v3.h(r36.optString("log_type", ""), String.valueOf(r36.optLong("monitor_id", 0)), r36.optLong("local_time_ms", 0), StageEventType.LOG_DATA));
    L120:
        r34.put(r36);
        r35 = r35 + 1;
        r117 = r117;
        r31 = r119;
        goto L112
    L121:
        r24.put("log_data", r34);
    L122:
        JSONArray r37 = this.L;
        if (r37 == null) goto L125;
        int r38 = r37.length();
    L126:
        this.aa = r38;
        if (r38 <= 0) goto L129;
        r24.put("item_impression", this.L);
    L129:
        this.Q = a(r1);
        this.R = a(r4);
        if (r29 == null) goto L182;
        r29.aw().a(r24, true);
        JSONObject r39 = new JSONObject();
        r39.put("request_from", this.ab);
        if (r29.aK() <= 0) goto L188;
        JSONObject r40 = new JSONObject();
        r40.put("capability", r29.aK());
        com.bytedance.applog.filter.h r41 = r29.O();
        if (r41 != null) goto L136;
    L141:
        r39.put("event_sampling", r40);
        goto L188
    L136:
        if (r41.b() == null) goto L141;
        if (r29.aK() != r41.b().b()) goto L140;
        r40.put("version", r41.b().a());
    L140:
        r40.put("config_ids", r41.b().c());
    L188:
        JSONObject r42 = r29.V();     // Catch: Throwable -> L146
        if (r42 == null) goto L184;
        r39.put("expected_batch_interval", r42);     // Catch: Throwable -> L146
    L184:
        JSONObject r43 = r29.W();     // Catch: Throwable -> L152
        if (r43 == null) goto L155;
        r39.put("log_back", r43);     // Catch: Throwable -> L152
    L155:
        if (r29.K() == false) goto L161;
        JSONObject r44 = new JSONObject();
        r44.put("enable", 1);
        if (r29.aJ() == null) goto L159;
        r44.put("version", r29.aJ().b());
    L159:
        r44.put(EventBody.KEY_VALUE, this.o);
        r39.put("applog_priority", r44);
    L161:
        if (r29.aH() == false) goto L170;
        JSONObject r45 = new JSONObject();     // Catch: Throwable -> L167
        r45.put("enable", 1);     // Catch: Throwable -> L167
        if (r29.aI() == null) goto L165;
        r45.put("version", r29.aI().a());     // Catch: Throwable -> L167
    L165:
        r39.put("applog_forward", r45);     // Catch: Throwable -> L167
    L167:
        th = move-exception;
        r29.aA().a("build forward to pack failed", th, new Object[0]);
    L170:
        if (r29.ab().f() == false) goto L172;
        int r46 = 1;
    L174:
        if (r29.ab().e() == false) goto L176;
        r46 = r46 | 2;
    L176:
        if (r46 <= 0) goto L179;
        r39.put("sentry_stained", r46);
    L179:
        if (r29.aS() == null) goto L181;
        r29.aS().a(r39);
    L181:
        r24.put("options", r39);
        goto L182
    L172:
        r46 = 0;
    L152:
        th = move-exception;
        r29.aA().a("build logback to pack failed", th, new Object[0]);
    L146:
        th = move-exception;
        r29.aA().a("build expected batch interval to pack failed", th, new Object[0]);
    L182:
        this.M = r24.optString("key");
        this.N = r24.optString(r20);
        s().c(4, "pack -> ts:{}, launch:{}, terminate:{}, v1:{}, v3:{}, misc:{}, impression:{}", new Object[]{Long.valueOf(this.f1725b), this.C, this.E, Integer.valueOf(this.X), Integer.valueOf(this.Y), Integer.valueOf(this.Z), Integer.valueOf(this.aa)});
        return r24;
    L125:
        r38 = 0;
        goto L126
    L107:
        r33 = 0;
        goto L108
    L103:
        r29 = r112;
        r117 = r30;
        r31 = r23;
        goto L104
    L88:
        r26 = 0;
        goto L89
    L84:
        r112 = r5;
        r24 = r6;
        r23 = "event_stained";
        r30 = "event_id";
        goto L85
    L69:
        r11 = 0;
        goto L70
    L57:
        if (r3.length() <= 0) goto L66;
        JSONArray r47 = r6.optJSONArray("terminate");
        if (r47 != null) goto L61;
        r47 = new JSONArray();
    L61:
        int r48 = 0;
    L63:
        if (r48 >= this.f1731J.length()) goto L65;
        r47.put(this.f1731J.get(r48));
        r48 = r48 + 1;
        goto L63
    L65:
        this.W += this.f1731J.length();
        r6.put("terminate", r47);
        goto L66
    L33:
        if (r8.q <= 0) goto L36;
        r1.add(Long.valueOf(this.E.q));
    L36:
        if (this.E.s <= 0) goto L38;
        r4.add(new com.bytedance.applog.monitor.v3.h("terminate", String.valueOf(this.E.r), this.E.f1725b, StageEventType.TERMINATE));
    L38:
        ?? r49 = this.E.m();
        ?? r120 = new JSONObject();
        r120.put("terminate", r49);
        this.O = r120.toString();
        JSONArray r121 = this.D;
        if (r121 == null) goto L41;
        int r122 = r121.length();
    L42:
        JSONArray r123 = new JSONArray();
        int r124 = 0;
    L43:
        if (r124 >= r122) goto L45;
        JSONArray r125 = new JSONArray();
        JSONObject r50 = new JSONObject(new JSONObject(this.D.optString(r124)).optString(TrackerImpl.PARAMS));
        r125.put(0, r50.optString("page_key", ""));
        r125.put(1, (r50.optInt("duration", 0) + 999) / 1000);
        r123.put(r125);
        r124 = r124 + 1;
        r2 = r2;
        goto L43
    L45:
        r20 = r2;
        if (r122 <= 0) goto L48;
        r49.put("activites", r123);
    L48:
        if (r5 != null) goto L50;
    L52:
        ?? r51 = new JSONArray();
        r51.put(r49);
        r6.put("terminate", r51);
        goto L54
    L50:
        if (r5.N() <= 0) goto L52;
        r49.put("launch_from", r5.N());
        r5.b(0);
        goto L52
    L41:
        r122 = 0;
        goto L42
    L29:
        r12 = 0;
        goto L30
    L18:
        if (r7.A == false) goto L26;
        if (this.C.q <= 0) goto L23;
        r1.add(Long.valueOf(this.C.q));
    L23:
        if (this.C.s <= 0) goto L25;
        r4.add(new com.bytedance.applog.monitor.v3.h(Constants.LAUNCH_TAG, String.valueOf(this.C.r), this.C.f1725b, StageEventType.LAUNCH));
    L25:
        JSONArray r52 = new JSONArray();
        r52.put(this.C.m());
        r6.put(Constants.LAUNCH_TAG, r52);
        goto L26
    L14:
        r10 = 0;
        goto L15
    L9:
        if (r5.aw().f1646a == null) goto L11;
        r6.put("time_sync", r5.aw().f1646a);
        goto L11
    }

    @Override // com.bytedance.applog.n.a
    String h() {
        return "pack";
    }

    @Override // com.bytedance.applog.n.a
    public String i() {
        return "";
    }

    @Override // com.bytedance.applog.n.a
    public String o() {
        return String.valueOf(this.f1724a);
    }

    public byte[] t() {
        return c(m().toString());
    L4:
        com.bytedance.applog.b r0 = com.bytedance.applog.a.b(this.m);
        if (r0 == null) goto L7;
        r0.ab().a(StatsCountKeys.MEM_ERROR_COUNT);
    L7:
        z();
        return null;
    }

    @Override // com.bytedance.applog.n.a
    public String toString() {
        return "pack:{id=" + this.f1724a + ", ts=" + this.f1725b + ", sid:" + this.d + ", e3_cnt:" + this.Y + ", e1_cnt:" + this.X + ", l_cnt:" + this.V + ", t_cnt:" + this.W + ", ipr_cnt:" + this.aa + ", isolate:" + this.S + "->" + this.T + "}";
    }

    public String[] u() {
        return new String[]{this.M, this.N};
    }

    public Set<Long> v() {
        return d(this.Q);
    }

    public List<com.bytedance.applog.monitor.v3.h> w() {
        return e(this.R);
    }

    public boolean x() {
        if (this.V <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean y() {
        if (this.W <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public void z() {
        com.bytedance.applog.b r0 = com.bytedance.applog.a.b(this.m);
        if (r0 != null) goto L6;
        return;
    L6:
        if (this.V <= 0) goto L9;
        r0.ab().a(StatsCountKeys.CLEAN_UP_LAUNCH_COUNT, this.V);
    L9:
        if (this.W <= 0) goto L11;
        r0.ab().a(StatsCountKeys.CLEAN_UP_TERMINATE_COUNT, this.W);
    L11:
        int r1 = (this.X + this.Y) + this.Z;
        if (r1 <= 0) goto L15;
        r0.ab().a(StatsCountKeys.CLEAN_UP_EVENT_COUNT, r1);
        return;
    }
}
