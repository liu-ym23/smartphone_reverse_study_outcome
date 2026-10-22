package com.bytedance.ai.applet.app.foundation.performance;

import java.util.Map;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public abstract class e {
    public final String a;
    public final String b;
    public final long c;
    public final long d;
    public final long e;
    public final AppletPerformanceErrorCode f;
    public final String g;
    public final Long h;
    public final Long i;
    public final Long j;
    public final Long k;
    public final Long l;
    public final Long m;
    public final boolean n;
    public final Long o;

    public abstract void a(Map<String, Object> r1);

    public abstract String b();

    public final Map<String, Object> c() {
        Map<String, Object> r0 = MapsKt.createMapBuilder();
        r0.put(com.bytedance.android.ec.core.event.a.KEY_APP_ID, this.a);
        r0.put("app_name", this.b);
        r0.put("trace_id", Long.valueOf(this.c));
        r0.put("start_time", Long.valueOf(this.d));
        r0.put("total_duration", Long.valueOf(this.e));
        r0.put(com.bytedance.android.ec.core.event.a.KEY_ERROR_CODE, Integer.valueOf(this.f.getCode()));
        String r1 = this.g;
        if (r1 == null) goto L5;
        r0.put("error_message", r1);
    L5:
        Long r10 = this.h;
        if (r10 == null) goto L8;
        r0.put("manifest_resource_load_duration", Long.valueOf(r10.longValue()));
    L8:
        Long r11 = this.i;
        if (r11 == null) goto L11;
        r0.put("package_resource_load_duration", Long.valueOf(r11.longValue()));
    L11:
        Long r12 = this.j;
        if (r12 == null) goto L14;
        r0.put("render_view_create_duration", Long.valueOf(r12.longValue()));
    L14:
        Long r13 = this.k;
        if (r13 == null) goto L17;
        r0.put("render_resource_load_duration", Long.valueOf(r13.longValue()));
    L17:
        Long r14 = this.l;
        if (r14 == null) goto L20;
        r0.put("render_view_load_data_duration", Long.valueOf(r14.longValue()));
    L20:
        Long r15 = this.m;
        if (r15 == null) goto L23;
        r0.put("render_view_draw_duration", Long.valueOf(r15.longValue()));
    L23:
        r0.put("is_reused", Integer.valueOf(this.n ? 1 : 0));
        Long r16 = this.o;
        if (r16 == null) goto L26;
        r0.put("script_evaluation_duration", Long.valueOf(r16.longValue()));
    L26:
        a(r0);
        return MapsKt.build(r0);
    }

    public e(String r10, String r11, long r12, long r13, long r14, AppletPerformanceErrorCode r15, String r16, Long r17, Long r18, Long r19, Long r110, Long r111, Long r112, boolean r20, Long r21) {
        this.a = r10;
        this.b = r11;
        this.c = r12;
        this.d = r13;
        this.e = r14;
        this.f = r15;
        this.g = r16;
        this.h = r17;
        this.i = r18;
        this.j = r19;
        this.k = r110;
        this.l = r111;
        this.m = r112;
        this.n = r20;
        this.o = r21;
    }
}
