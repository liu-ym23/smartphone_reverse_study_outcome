package l9;

import android.content.Context;
import android.text.TextUtils;
import cn.nubia.neopush.commons.AppUtil;
import com.bytedance.ies.xelement.RecyclerItemStatusHelper$recyclerScrollListener$1;
import com.google.common.reflect.w;
import com.google.gson.JsonObject;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes2.dex */
public final class g {
    public static g f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19560a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f19561b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f19562c;
    public Object d;
    public Object e;

    public g(int r5) {
        this.f19560a = r5;
        switch(r5) {
            case 4: goto L8;
            case 5: goto L7;
            default: goto L4;
        };
    L4:
        this.f19561b = -1;
        this.e = new RecyclerItemStatusHelper$recyclerScrollListener$1();
        return;
    L8:
        com.bytedance.iesgurd.settings.a r10 = com.bytedance.iesgurd.settings.a.f6688a;
        this.f19561b = 0;
        this.f19562c = 0;
        this.e = new AtomicBoolean(false);
        this.d = r10;
        return;
    }

    public float a() {
        int r5 = this.f19561b;
        s4.c r10 = (s4.c) this.e;
        r10.getClass();
        String r11 = (String) this.d;
        Intrinsics.checkNotNullParameter(r11, "input");
        r10.f21818a = r5;
        int r12 = this.f19562c;
        if (r5 >= r12) goto L129;
        char r13 = r11.charAt(r5);
        if (r13 != '-') goto L8;
        r10.f21818a++;
        boolean r14 = true;
    L11:
        int r15 = r10.f21818a;
        int r16 = 0;
        int r17 = 0;
        int r18 = 0;
        boolean r19 = false;
        int r110 = 0;
        long r111 = 0;
    L12:
        int r20 = r10.f21818a;
        if (r20 >= r12) goto L40;
        char r21 = r11.charAt(r20);
        if (r21 != '0') goto L20;
        if (r16 != 0) goto L18;
        r18 = r18 + 1;
    L39:
        r10.f21818a++;
        goto L12
    L18:
        r17 = r17 + 1;
        goto L39
    L20:
        if (Intrinsics.compare(r21, 49) < 0) goto L35;
        if (Intrinsics.compare(r21, 57) > 0) goto L35;
        int r112 = r16 + r17;
    L25:
        if (r17 <= 0) goto L29;
        if (r111 > 922337203685477580L) goto L129;
        r111 = r111 * ((long) 10);
        r17 = r17 - 1;
        goto L25
    L29:
        if (r111 > 922337203685477580L) goto L129;
        r111 = (r111 * ((long) 10)) + ((long) (r21 - '0'));
        r16 = r112 + 1;
        if (r111 >= 0) goto L39;
    L35:
        if (r21 != '.') goto L40;
        if (r19 == true) goto L40;
        r110 = r10.f21818a - r15;
        r19 = true;
    L40:
        if (r19 == true) goto L42;
    L44:
        if (r16 != 0) goto L48;
        if (r18 == 0) goto L129;
        r16 = 1;
    L48:
        if (r19 == false) goto L50;
        r17 = (r110 - r18) - r16;
    L50:
        int r22 = r10.f21818a;
        if (r22 >= r12) goto L112;
        char r23 = r11.charAt(r22);
        if (r23 != 'E') goto L55;
    L56:
        int r24 = r10.f21818a + 1;
        r10.f21818a = r24;
        if (r24 == r12) goto L129;
        char r25 = r11.charAt(r24);
        if (r25 != '-') goto L63;
        r10.f21818a++;
        boolean r26 = true;
        boolean r27 = false;
    L94:
        if (r27 == true) goto L112;
        int r28 = r10.f21818a;
        int r29 = 0;
    L96:
        int r113 = r10.f21818a;
        if (r113 >= r12) goto L107;
        char r114 = r11.charAt(r113);
        if (Intrinsics.compare(r114, 48) < 0) goto L107;
        if (Intrinsics.compare(r114, 57) > 0) goto L107;
        if (r29 > 922337203685477580L) goto L129;
        r29 = (r29 * 10) + (r114 - '0');
        r10.f21818a++;
    L107:
        if (r10.f21818a == r28) goto L129;
        if (r26 == false) goto L111;
        r17 = r17 - r29;
        goto L112
    L111:
        r17 = r17 + r29;
        goto L112
    L63:
        if (r25 != '+') goto L65;
        r10.f21818a++;
    L91:
        r27 = false;
    L92:
        r26 = false;
        goto L94
    L65:
        if (r25 == '0') goto L91;
        if (r25 == '1') goto L91;
        if (r25 == '2') goto L91;
        if (r25 == '3') goto L91;
        if (r25 == '4') goto L91;
        if (r25 == '5') goto L91;
        if (r25 == '6') goto L91;
        if (r25 == '7') goto L91;
        if (r25 == '8') goto L91;
        if (r25 == '9') goto L91;
        r10.f21818a--;
        r27 = true;
        goto L92
    L55:
        if (r23 == 'e') goto L56;
    L112:
        int r115 = r16 + r17;
        if (r115 > 39) goto L129;
        if (r115 < (-44)) goto L129;
        long r116 = r111;
        float r30 = r116;
        if (r116 == 0) goto L127;
        if (r17 <= 0) goto L122;
        float r31 = s4.c.f21816b[r17];
    L121:
        r30 = r30 * r31;
        goto L127
    L122:
        if (r17 >= 0) goto L127;
        if (r17 >= (-38)) goto L126;
        r30 = r30 * 1.0E-20f;
        r17 = r17 + 20;
    L126:
        r31 = s4.c.f21817c[-r17];
    L127:
        if (r14 == false) goto L131;
        r30 = -r30;
    L131:
        if (Float.isNaN(r30) == true) goto L133;
        this.f19561b = r10.f21818a;
    L133:
        return r30;
    L42:
        if (r10.f21818a != (r110 + 1)) goto L44;
    L8:
        if (r13 != '+') goto L10;
        r10.f21818a++;
    L10:
        r14 = false;
    L129:
        r30 = Float.NaN;
        goto L131
    }

    public float b(float r5) {
        if (Float.isNaN(r5) == false) goto L6;
        return Float.NaN;
    L6:
        i();
        int r10 = this.f19561b;
        if (r10 == this.f19562c) goto L14;
        if (((String) this.d).charAt(r10) != ',') goto L14;
        this.f19561b++;
        i();
    L14:
        return a();
    }

    public void c() {
        switch(this.f19560a) {
            case 0: goto L18;
            default: goto L4;
        };
    L4:
        int r5 = this.f19561b;
        this.f19561b = r5 + 1;
        long r10 = (long) Math.floor((Math.pow(2.0d, Math.min(r5 - 1, 8)) * (Math.random() + 0.5d)) * 5.0d);
        int r11 = (int) (((long) this.f19562c) + r10);
        this.f19562c = r11;
        if (r11 <= 5115) goto L13;
        AtomicBoolean r12 = (AtomicBoolean) this.e;
        if (r12.get() == false) goto L20;
        this.f19561b = 0;
        bb.b r13 = (bb.b) ((w) bb.c.f895a.f22857a).f9377c;
        if (r13 == null) goto L12;
        r13.removeMessages(2);
    L12:
        r12.set(false);
        return;
    L20:
        return;
    L13:
        com.bytedance.iesgurd.request.a r14 = new com.bytedance.iesgurd.request.a(this, 1);
        long r15 = r10 * 1000;
        w r16 = (w) bb.c.f895a.f22857a;
        if (r15 >= 0) goto L16;
        r16.getClass();
        return;
    L16:
        r16.e(r14, r15, 0);
        return;
    L18:
        this.f19561b = mh.e.c(c.e(), this.f19561b, new String[]{"custom_event_settings", "npth_simple_setting", "crash_limit_issue"});
        this.f19562c = mh.e.c(c.e(), this.f19562c, new String[]{"custom_event_settings", "npth_simple_setting", "crash_limit_all"});
    }

    public void d(File r5) {
        File r10 = new File(com.bytedance.crash.util.g.h((Context) this.d), "realIssueCrashTimes");
        if (r10.mkdirs() == true) goto L5;
        r10.mkdirs();
    L5:
        r5.renameTo(new File(r10, String.valueOf(System.currentTimeMillis())));
        String[] r11 = r10.list();
        if (r11 != null) goto L9;
        return;
    L9:
        if (r11.length <= 5) goto L12;
        Arrays.sort(r11);
        new File(r10, r11[0]).delete();
        return;
    }

    public boolean e() {
        long r5 = this.f19561b;
        monitor-enter(this);
        HashMap r10 = (HashMap) this.e;     // Catch: Throwable -> L7
        long r11 = 1L;     // Catch: Throwable -> L7
        if (r10 != null) goto L9;
        Long r12 = -1L;     // Catch: Throwable -> L7
    L13:
        if (r12.longValue() >= r5) goto L21;
        monitor-exit(this);
        if (g(this.f19561b) == false) goto L28;
        return true;
    L28:
        return false;
    L21:
        monitor-exit(this);
        return false;
    L9:
        Long r13 = (Long) r10.get("default");     // Catch: Throwable -> L7
        if (r13 == null) goto L12;
        r11 = Long.valueOf(r13.longValue() + 1);     // Catch: Throwable -> L7
    L12:
        r10.put("default", r11);     // Catch: Throwable -> L7
        r12 = r11;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean f(char r5) {
        int r10 = this.f19561b;
        if (r10 < this.f19562c) goto L5;
    L7:
        boolean r11 = false;
    L8:
        if (r11 == false) goto L10;
        this.f19561b++;
    L10:
        return r11;
    L5:
        if (((String) this.d).charAt(r10) != r5) goto L7;
        r11 = true;
        goto L8
    }

    public synchronized boolean g(long r10) {
        monitor-enter(this);
        HashMap r5 = (HashMap) this.e;     // Catch: Throwable -> L7
        long r11 = 1L;     // Catch: Throwable -> L7
        if (r5 != null) goto L9;
        Long r12 = -1L;     // Catch: Throwable -> L7
    L13:
        long r13 = r12.longValue();     // Catch: Throwable -> L7
        monitor-exit(this);
        if (r13 >= r10) goto L19;
        return true;
    L19:
        return false;
    L9:
        Long r14 = (Long) r5.get("all");     // Catch: Throwable -> L7
        if (r14 == null) goto L12;
        r11 = Long.valueOf(r14.longValue() + 1);     // Catch: Throwable -> L7
    L12:
        r5.put("all", r11);     // Catch: Throwable -> L7
        r12 = r11;
    L7:
        th = move-exception;
        throw th;
    }

    public synchronized void h(long r11, String r13, String r14) {
        monitor-enter(this);
    L6:
        th = move-exception;
        throw th;
    L4:
        if (((HashMap) this.d) != null) goto L9;
        this.d = new HashMap();     // Catch: Throwable -> L6
    L9:
        if (((HashMap) this.d).containsKey(r13) == false) goto L13;
        v6.i r12 = (v6.i) ((HashMap) this.d).get(r13);     // Catch: Throwable -> L6
        r12.d++;     // Catch: Throwable -> L6
        r12.e = System.currentTimeMillis();     // Catch: Throwable -> L6
        int r15 = r12.d;     // Catch: Throwable -> L6
        if (r15 <= this.f19562c) goto L44;
        this.f19562c = r15;     // Catch: Throwable -> L6
    L44:
        monitor-exit(this);
        return;
    L13:
        HashMap r5 = (HashMap) this.e;     // Catch: Throwable -> L6
        if (r5 == null) goto L43;
        String r10 = null;
        long r16 = Long.MAX_VALUE;
        if (r5.containsKey(r13) == false) goto L33;
        v6.i r17 = (v6.i) ((HashMap) this.e).get(r13);     // Catch: Throwable -> L6
        int r18 = r17.d;     // Catch: Throwable -> L6
        r17.d = r18 + 1;     // Catch: Throwable -> L6
        r17.e = System.currentTimeMillis();     // Catch: Throwable -> L6
        if (r18 <= this.f19561b) goto L44;
        ((HashMap) this.e).remove(r13);     // Catch: Throwable -> L6
        if (((HashMap) this.d).size() < 20) goto L31;
        long r19 = System.currentTimeMillis() / 2;     // Catch: Throwable -> L6
        Iterator r110 = ((HashMap) this.d).entrySet().iterator();     // Catch: Throwable -> L6
    L23:
        if (r110.hasNext() == false) goto L29;
        Map.Entry r111 = (Map.Entry) r110.next();     // Catch: Throwable -> L6
        if (((v6.i) r111.getValue()).e >= r19) goto L23;
        if (((v6.i) r111.getValue()).d >= r16) goto L23;
        r16 = ((v6.i) r111.getValue()).d;     // Catch: Throwable -> L6
        r10 = ((v6.i) r111.getValue()).f22547a;     // Catch: Throwable -> L6
        goto L23
    L29:
        if (r10 == null) goto L31;
        ((HashMap) this.d).remove(r10);     // Catch: Throwable -> L6
    L31:
        ((HashMap) this.d).put(r13, r17);     // Catch: Throwable -> L6
        goto L44
    L33:
        if (((HashMap) this.e).size() < 50) goto L42;
        Iterator r20 = ((HashMap) this.e).entrySet().iterator();     // Catch: Throwable -> L6
    L36:
        if (r20.hasNext() == false) goto L40;
        Map.Entry r21 = (Map.Entry) r20.next();     // Catch: Throwable -> L6
        if (((v6.i) r21.getValue()).e >= r16) goto L36;
        long r22 = ((v6.i) r21.getValue()).e;     // Catch: Throwable -> L6
        r10 = ((v6.i) r21.getValue()).f22547a;     // Catch: Throwable -> L6
        r16 = r22;
        goto L36
    L40:
        if (r10 == null) goto L42;
        ((HashMap) this.e).remove(r10);     // Catch: Throwable -> L6
    L42:
        ((HashMap) this.e).put(r13, new v6.i(r11, r13, r14));     // Catch: Throwable -> L6
        goto L44
    L43:
        HashMap r23 = new HashMap();     // Catch: Throwable -> L6
        this.e = r23;     // Catch: Throwable -> L6
        r23.put(r13, new v6.i(r11, r13, r14));     // Catch: Throwable -> L6
        goto L44
    }

    public void i() {
    L2:
        int r5 = this.f19561b;
        if (r5 >= this.f19562c) goto L15;
        char r10 = ((String) this.d).charAt(r5);
        if (r10 == ' ') goto L14;
        if (r10 == '\n') goto L14;
        if (r10 == '\r') goto L14;
        if (r10 == '\t') goto L14;
        return;
    L14:
        this.f19561b++;
        goto L2
    }

    public g(int r5, int r10, JsonObject r11, String r12) {
        this.f19560a = 1;
        this.f19561b = r5;
        this.f19562c = r10;
        this.d = r11;
        this.e = r12;
    }

    public g(Context r12) {
        this.f19560a = 0;
        this.f19561b = 50;
        this.f19562c = 100;
        this.d = r12;
        File r5 = new File(com.bytedance.crash.util.g.h(r12), "realIssueCrashTimes");
        if (r5.mkdirs() == true) goto L5;
        r5.mkdirs();
    L5:
        File r10 = new File(r5, "crash.times");
        HashMap r13 = new HashMap();
        r13.put("time", Long.valueOf(System.currentTimeMillis()));
        JSONArray r11 = cl.a.F(r10.getAbsolutePath());     // Catch: Throwable -> L27 IOException -> L33
        if (r11 == null) goto L28;
        if (mh.e.m(r11) == true) goto L28;
        String r14 = r11.optString(0, null);     // Catch: Throwable -> L27 IOException -> L33
        if (TextUtils.isEmpty(r14) == false) goto L34;
    L16:
        long r15 = 0;
    L18:
        if ((System.currentTimeMillis() - r15) <= AppUtil.MILLIS_IN_DAYS) goto L20;
        d(r10);     // Catch: Throwable -> L27 IOException -> L33
        goto L28
    L20:
        r13.put("time", Long.valueOf(r15));     // Catch: Throwable -> L27 IOException -> L33
        int r16 = 1;
    L22:
        if (r16 >= r11.length()) goto L28;
        String[] r17 = r11.optString(r16, "").split(" ");     // Catch: Throwable -> L27 IOException -> L33
        if (r17.length != 2) goto L26;
        r13.put(r17[0], Long.decode(r17[1]));     // Catch: Throwable -> L27 IOException -> L33
    L26:
        r16 = r16 + 1;
        goto L22
    L34:
        r15 = Long.decode(r14).longValue();     // Catch: Throwable -> L32
    L27:
        cl.a.C(r10);
    L28:
        this.e = r13;
        c();
        f r18 = new f(this, 0);
        c.f19554a.add(r18);
        if (c.f19555b == false) goto L40;
        r18.b();
        r18.a();
        return;
    }

    public g(String r10) {
        this.f19560a = 3;
        Intrinsics.checkNotNullParameter(r10, "input");
        this.e = new s4.c();
        int r5 = r10.length() - 1;
        int r11 = 0;
        boolean r12 = false;
    L3:
        if (r11 > r5) goto L18;
        if (r12 == true) goto L6;
        int r13 = r11;
    L8:
        if (Intrinsics.compare(r10.charAt(r13), 32) > 0) goto L10;
        boolean r14 = true;
    L11:
        if (r12 == false) goto L12;
        if (r14 == false) goto L18;
        r5 = r5 - 1;
        goto L3
    L12:
        if (r14 == false) goto L13;
        r11 = r11 + 1;
        goto L3
    L13:
        r12 = true;
        goto L3
    L10:
        r14 = false;
        goto L11
    L6:
        r13 = r5;
    L18:
        String r15 = r10.subSequence(r11, r5 + 1).toString();
        this.d = r15;
        this.f19562c = r15.length();
    }
}
