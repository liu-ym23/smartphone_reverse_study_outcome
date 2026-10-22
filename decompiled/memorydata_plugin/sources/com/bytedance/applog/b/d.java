package com.bytedance.applog.b;

import com.bytedance.applog.monitor.v3.StageEventType;
import com.bytedance.applog.monitor.v3.StatsCountKeys;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f1529a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f1530b;
    private int c;
    private int d;
    private int e;
    private final boolean f;
    private boolean g;

    public d() {
        this.f = e.f1531a;
    }

    private static int a(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, JSONObject.class) == false) goto L7;
        return e((JSONObject) ZeusTransformUtils.preCheckCast(r2, JSONObject.class, "com.obric.memorydata.plugin"));
    L7:
        if (ZeusTransformUtils.instanceOf(r2, JSONArray.class) == false) goto L11;
        return a((JSONArray) ZeusTransformUtils.preCheckCast(r2, JSONArray.class, "com.obric.memorydata.plugin"));
    L11:
        if (ZeusTransformUtils.instanceOf(r2, String.class) == false) goto L15;
        return c((String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.memorydata.plugin")) + 2;
    L15:
        return String.valueOf(r2).length();
    }

    public static int a(String r4) {
        int r0 = 0;
        if (r4 != null) goto L5;
        return 0;
    L5:
        int r1 = 0;
    L7:
        if (r0 >= r4.length()) goto L19;
        char r2 = r4.charAt(r0);
        if (r2 > 127) goto L12;
        r1 = r1 + 1;
    L18:
        r0 = r0 + 1;
        goto L7
    L12:
        if (r2 > 2047) goto L15;
        r1 = r1 + 2;
        goto L18
    L15:
        if (Character.isHighSurrogate(r2) == false) goto L17;
        r1 = r1 + 4;
        r0 = r0 + 1;
        goto L18
    L17:
        r1 = r1 + 3;
        goto L18
    L19:
        return r1;
    }

    public static int a(JSONArray r5) {
        if (r5 != null) goto L5;
        return 0;
    L5:
        int r1 = 2;
        boolean r2 = true;
        int r3 = 0;
    L7:
        if (r3 >= r5.length()) goto L11;
        if (r2 == true) goto L10;
        r1 = r1 + 1;
    L10:
        r1 = r1 + a(r5.opt(r3));
        r3 = r3 + 1;
        r2 = false;
        goto L7
    L11:
        return r1;
    }

    public static String a(String r7, StageEventType r8, String r9, String r10) {
        int r0 = b(r10);
        if (r0 <= 0) goto L9;
        com.bytedance.applog.monitor.exception.b.a().a(r8, r9, r10, e.c);
        com.bytedance.applog.b r11 = com.bytedance.applog.a.b(r7);
        if (r11 == null) goto L8;
        r11.ab().a(StatsCountKeys.PARAMS_CLEARED_BY_EVENT_SIZE_LIMIT);
    L8:
        return b(r0);
    L9:
        return r10;
    }

    public static int b(String r5) {
        if (r5 != null) goto L5;
        return -1;
    L5:
        if ((((long) r5.length()) * 4) <= e.c) goto L13;
        int r6 = a(r5);
        if (r6 > e.c) goto L10;
        return -1;
    L10:
        return r6;
    L13:
        return -1;
    }

    public static String b(int r2) {
        return "{\"params_cleared_by_event_size_limit\":\"" + r2 + "\",\"max_event_size\":\"" + e.c + "\"}";
    }

    private static int c(String r4) {
        int r0 = 0;
        if (r4 != null) goto L5;
        return 0;
    L5:
        int r1 = 0;
    L7:
        if (r0 >= r4.length()) goto L31;
        char r2 = r4.charAt(r0);
        if (r2 != '\f') goto L11;
    L29:
        r1 = r1 + 2;
    L30:
        r0 = r0 + 1;
        goto L7
    L11:
        if (r2 == '\r') goto L29;
        if (r2 == '\"') goto L29;
        if (r2 == '/') goto L29;
        if (r2 == '\\') goto L29;
        switch(r2) {
            case 8: goto L29;
            case 9: goto L29;
            case 10: goto L29;
            default: goto L20;
        };
    L20:
        if (r2 > 127) goto L23;
        r1 = r1 + 1;
        goto L30
    L23:
        if (r2 <= 2047) goto L29;
        if (Character.isHighSurrogate(r2) == false) goto L28;
        r1 = r1 + 4;
        r0 = r0 + 1;
        goto L30
    L28:
        r1 = r1 + 3;
        goto L30
    L31:
        return r1;
    }

    public static int e(JSONObject r6) {
        if (r6 != null) goto L5;
        return 0;
    L5:
        int r1 = 2;
        Iterator<String> r2 = r6.keys();
        boolean r3 = true;
    L7:
        if (r2.hasNext() == false) goto L11;
        if (r3 == true) goto L10;
        r1 = r1 + 1;
    L10:
        String r4 = (String) ZeusTransformUtils.preCheckCast(r2.next(), String.class, "com.obric.memorydata.plugin");
        r1 = (r1 + (a(r4) + 3)) + a(r6.opt(r4));
        r3 = false;
        goto L7
    L11:
        return r1;
    }

    public void a(JSONObject r2) {
        if (this.f == true) goto L5;
        return;
    L5:
        this.c = 0;
        this.d = 0;
        int r3 = e(r2);
        this.f1530b = r3;
        int r4 = r3 + 5120;
        this.f1530b = r4;
        this.f1529a = r4;
        this.g = false;
    }

    public void a(boolean r1) {
        this.g = r1;
    }

    public boolean a() {
        return this.f;
    }

    public boolean a(int r3) {
        if ((this.f1529a + r3) >= e.d) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean b() {
        return this.g;
    }

    public boolean b(JSONObject r3) {
        if (this.c != 0) goto L5;
        int r0 = 14;
    L6:
        int r1 = r0 + e(r3);
        if (a(r1) == false) goto L10;
        this.f1529a += r1;
        this.c++;
        return true;
    L10:
        return false;
    L5:
        r0 = 1;
        goto L6
    }

    public boolean c(JSONObject r3) {
        if (this.d != 0) goto L5;
        int r0 = 11;
    L6:
        int r1 = r0 + e(r3);
        if (a(r1) == false) goto L10;
        this.f1529a += r1;
        this.d++;
        return true;
    L10:
        return false;
    L5:
        r0 = 1;
        goto L6
    }

    public boolean d(JSONObject r3) {
        if (this.e != 0) goto L5;
        int r0 = 14;
    L6:
        int r1 = r0 + e(r3);
        if (a(r1) == false) goto L10;
        this.f1529a += r1;
        this.e++;
        return true;
    L10:
        return false;
    L5:
        r0 = 1;
        goto L6
    }
}
