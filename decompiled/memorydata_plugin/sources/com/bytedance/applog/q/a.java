package com.bytedance.applog.q;

import java.util.Collections;
import java.util.Random;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f1860a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f1861b;
    private long c;
    private int d;
    private int e;
    private int f;
    private final com.bytedance.applog.b g;
    private final com.bytedance.applog.k.b h;
    private long i;

    public a(com.bytedance.applog.b r4, com.bytedance.applog.k.b r5, long r6) {
        this.f1860a = 0;
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.f = 0;
        this.g = r4;
        this.h = r5;
        this.i = r6;
    }

    private int a(com.bytedance.applog.priority.b r2) {
        if (r2 != null) goto L4;
        return 12;
    L4:
        if ((-1) != r2.a()) goto L7;
        return 12;
    L7:
        if (r2.a() != 0) goto L10;
        return Integer.MAX_VALUE;
    L10:
        return 60;
    }

    public void a(JSONObject r5, long r6, com.bytedance.applog.priority.b r8) {
        this.i = r6;
        int r7 = r5.optInt("backoff_ratio", 0);
        this.f1860a = r7;
        if (r7 >= 0) goto L5;
    L6:
        this.f1860a = 0;
    L7:
        int r9 = r5.optInt("max_request_frequency", a(r8));
        this.f1861b = r9;
        if (r9 > 0) goto L10;
        this.f1861b = 12;
    L10:
        int r10 = this.f1860a;
        if (r10 > 0) goto L13;
    L15:
        if (r10 != 0) goto L17;
        this.c = 0;
        this.d = 0;
    L17:
        this.e = r5.optInt("disable_session_start_request", 0);
        this.f = r5.optInt("disable_session_end_request", 0);
        if (this.f1860a != 0) goto L22;
        int r11 = this.f1861b;
        if (r11 <= 0) goto L22;
        this.h.a(r8, r11);
    L22:
        this.g.aA().b(Collections.singletonList("BackoffController"), "parseBackoffControllerFromResp mEventInterval: " + this.i + ", mBackoffRatio: " + this.f1860a + ", mMaxRequestFrequency: " + this.f1861b + ", mBackoffWindowStartTime: " + this.c + ", mBackoffWindowSendCount: " + this.d + ", mDisableSessionStartRequest: " + this.e + ", mDisableSessionEndRequest: " + this.f, new Object[0]);
        return;
    L13:
        if (this.c != 0) goto L15;
        this.c = System.currentTimeMillis();
        this.d = 1;
        goto L17
    L5:
        if (r7 <= 10000) goto L7;
        goto L6
    }

    public boolean a(int r11) {
        if (this.f1860a <= 0) goto L11;
        long r2 = System.currentTimeMillis();
        long r4 = this.c;
        long r6 = this.i;
        if (r2 >= (r4 + r6)) goto L10;
        int r0 = this.d;
        if (r0 < this.f1861b) goto L9;
        return true;
    L9:
        this.d = r0 + 1;
        goto L11
    L10:
        this.c = r4 + (((r2 - r4) / r6) * r6);
        this.d = 1;
    L11:
        int r1 = this.f1860a;
        if (r1 < 10000) goto L14;
        return true;
    L14:
        if (r1 <= 0) goto L20;
        if (r1 >= 10000) goto L20;
        if (new Random().nextInt(10000) >= this.f1860a) goto L20;
        return true;
    L20:
        if (this.e <= 0) goto L23;
        if (1 != r11) goto L23;
    L26:
        return true;
    L23:
        if (this.f > 0) goto L25;
        return false;
    L25:
        if (3 == r11) goto L26;
        return false;
    }
}
