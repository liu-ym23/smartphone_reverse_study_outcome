package com.larus.profile.impl;

import android.os.Bundle;
import android.view.View;
import com.larus.applog.api.IApplog;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a1 {
    public static final AtomicBoolean l = null;
    public final String a;
    public final long b;
    public final boolean c;
    public final boolean d;
    public long e;
    public long f;
    public long g;
    public double h;
    public double i;
    public boolean j;
    public volatile boolean k;

    public static final class a {
        public static a1 a(Bundle r8, String r9) {
            Intrinsics.checkNotNullParameter(r9, "defaultVariant");
            if (r8 == null) goto L5;
            String r0 = r8.getString("profile_edit_perf_variant");
        L6:
            if (r0 != null) goto L9;
            r0 = "";
        L9:
            if (StringsKt.isBlank(r0) == false) goto L11;
            String r3 = r9;
        L12:
            long r1 = 0;
            if (r8 == null) goto L15;
            r1 = r8.getLong("profile_edit_perf_open_start_ms", 0);
        L15:
            long r4 = r1;
            if (r8 == null) goto L18;
            boolean r6 = r8.getBoolean("profile_edit_perf_is_cold_start", false);
        L20:
            if (r8 == null) goto L22;
            boolean r7 = r8.getBoolean("profile_edit_perf_report_enabled", true);
        L24:
            return new a1(r3, r4, r6, r7);
        L22:
            r7 = true;
            goto L24
        L18:
            r6 = false;
            goto L20
        L11:
            r3 = r0;
            goto L12
        L5:
            r0 = null;
            goto L6
        }
    }

    static {
        l = new AtomicBoolean(false);
    }

    public final void b(long r6) {
        long r0 = System.currentTimeMillis();
        if (r6 > 0) goto L5;
    L7:
        long r1 = -1;
    L8:
        this.g = r1;
        return;
    L5:
        if (r0 < r6) goto L7;
        r1 = r0 - r6;
        goto L8
    }

    public final void c(long r10) {
        if (r10 >= 0) goto L5;
        return;
    L5:
        IApplog.Companion r2 = IApplog.a;
        JSONObject r3 = new JSONObject();
        r3.put("fcp", r10);
        r3.put("type", this.a);
        r3.put("current_page", "profile_setting");
        r3.put("is_cold_start", this.c ? 1 : 0);
        if (Intrinsics.areEqual(this.a, "relax") == true) goto L8;
    L10:
        int r11 = 0;
    L11:
        r3.put("is_lynx_prewarm", r11);
        long r4 = this.f;
        if (r4 < 0) goto L15;
        r3.put("load_template", r4);
    L15:
        if (Intrinsics.areEqual(this.a, "native") == false) goto L23;
        double r7 = this.h;
        if (r7 < 0.0d) goto L19;
        r3.put("native_measure", r7);
    L19:
        double r8 = this.i;
        if (r8 < 0.0d) goto L23;
        r3.put("native_layout", r8);
    L23:
        if (Intrinsics.areEqual(this.a, "relax") == false) goto L33;
        double r12 = this.h;
        if (r12 < 0.0d) goto L27;
        r3.put("native_measure", r12);
    L27:
        long r13 = this.g;
        if (r13 < 0) goto L30;
        r3.put("on_view_created", r13);
    L30:
        long r14 = this.e;
        if (r14 < 0) goto L33;
        r3.put("create_lynx_view", r14);
    L33:
        Unit r15 = Unit.INSTANCE;
        r2.reportEvent("relax_profile_performance", r3);
        return;
    L8:
        if (this.j == false) goto L10;
        r11 = 1;
        goto L11
    }

    public final void a(View r5, final com.larus.profile.impl.view.i r6) {
        Intrinsics.checkNotNullParameter(r5, "view");
        Intrinsics.checkNotNullParameter(r6, "firstFrameTiming");
        if (this.k == false) goto L5;
        return;
    L5:
        if (this.d == false) goto L10;
        this.h = r6.b / 1000000.0d;
        this.i = r6.c / 1000000.0d;
        r5.post(new z0(this, r6));
        return;
    }

    public a1(String r1, long r2, boolean r4, boolean r5) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
        this.d = r5;
        this.e = -1;
        this.f = -1;
        this.g = -1;
        this.h = -1.0d;
        this.i = -1.0d;
    }
}
