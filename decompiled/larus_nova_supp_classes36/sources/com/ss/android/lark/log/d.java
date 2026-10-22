package com.ss.android.lark.log;

import com.suite.component.logger.Log;
import com.suite.component.logger.api.h;
import com.suite.component.logger.c;
import java.util.Map;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d implements c {
    public final h a;
    public final String b;

    public d(h r2) {
        Intrinsics.checkNotNullParameter(r2, "newLogger");
        this.a = r2;
        this.b = "lark";
    }

    public final void d(String r3, String r4) {
        h r0 = this.a;
        if (r3 != null) goto L5;
        r3 = this.b;
    L5:
        if (r4 != null) goto L7;
        r4 = "";
    L7:
        r0.d(r3, r4, null);
    }

    public final void e(String r4, String r5) {
        h r0 = this.a;
        if (r5 != null) goto L5;
        r5 = "";
    L5:
        r0.g(r4, r5, null, false);
    }

    public final void i(String r3, String r4) {
        h r0 = this.a;
        if (r3 != null) goto L5;
        r3 = this.b;
    L5:
        if (r4 != null) goto L7;
        r4 = "";
    L7:
        r0.i(r3, r4, null);
    }

    public final void v(String r3, String r4) {
        h r0 = this.a;
        if (r3 != null) goto L5;
        r3 = this.b;
    L5:
        if (r4 != null) goto L7;
        r4 = "";
    L7:
        r0.v(r3, r4, null);
    }

    public final void w(String r3, String r4) {
        h r0 = this.a;
        if (r3 != null) goto L5;
        r3 = this.b;
    L5:
        if (r4 != null) goto L7;
        r4 = "";
    L7:
        r0.w(r3, r4, null);
    }

    public final void wtf(String r3, String r4) {
        h r0 = this.a;
        if (r3 != null) goto L5;
        r3 = this.b;
    L5:
        if (r4 != null) goto L7;
        r4 = "";
    L7:
        r0.w(r3, r4, null);
    }

    public final void a(String r3, String r4, String r5) {
        h r0 = this.a;
        if (r3 != null) goto L5;
        r3 = this.b;
    L5:
        StringBuilder r1 = new StringBuilder();
        if (r4 != null) goto L8;
        r4 = "";
    L8:
        r1.append(r4);
        r1.append(", jsonContent:");
        r1.append(r5);
        r0.i(r3, r1.toString(), null);
    }

    public final void c(String r3, String r4, String r5) {
        h r0 = this.a;
        if (r3 != null) goto L5;
        r3 = this.b;
    L5:
        StringBuilder r1 = new StringBuilder();
        if (r4 != null) goto L8;
        r4 = "";
    L8:
        r1.append(r4);
        r1.append(", xmlContent:");
        r1.append(r5);
        r0.i(r3, r1.toString(), null);
    }

    public final void d(String r2, String r3, Throwable r4) {
        h r0 = this.a;
        if (r2 != null) goto L5;
        r2 = this.b;
    L5:
        if (r3 != null) goto L7;
        r3 = "";
    L7:
        r0.d(r2, r3, r4);
    }

    public final void e(String r3, String r4, Throwable r5) {
        h r0 = this.a;
        if (r3 != null) goto L5;
        r3 = this.b;
    L5:
        if (r4 != null) goto L7;
        r4 = "";
    L7:
        r0.g(r3, r4, r5, false);
    }

    public final void i(String r2, String r3, Throwable r4) {
        h r0 = this.a;
        if (r2 != null) goto L5;
        r2 = this.b;
    L5:
        if (r3 != null) goto L7;
        r3 = "";
    L7:
        r0.i(r2, r3, r4);
    }

    public final void v(String r2, String r3, Throwable r4) {
        h r0 = this.a;
        if (r2 != null) goto L5;
        r2 = this.b;
    L5:
        if (r3 != null) goto L7;
        r3 = "";
    L7:
        r0.v(r2, r3, r4);
    }

    public final void w(String r2, String r3, Throwable r4) {
        h r0 = this.a;
        if (r2 != null) goto L5;
        r2 = this.b;
    L5:
        if (r3 != null) goto L7;
        r3 = "";
    L7:
        r0.w(r2, r3, r4);
    }

    public final void wtf(String r2, String r3, Throwable r4) {
        h r0 = this.a;
        if (r2 != null) goto L5;
        r2 = this.b;
    L5:
        if (r3 != null) goto L7;
        r3 = "";
    L7:
        r0.w(r2, r3, r4);
    }

    public final void b(int r14, String r15, String[] r16, String r17, Map<String, String> r18) {
        c r1 = Log.b.obtain();
        com.suite.component.logger.api.LogLevel.Companion.getClass();
        com.suite.component.logger.api.LogLevel r2 = com.suite.component.logger.api.LogLevel.a.a(r14);
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        r1.a = r2;
        r1.f = r15;
        String r3 = "";
        if (r16 == null) goto L6;
        String r4 = ArraysKt.joinToString$default(r16, "-", null, null, 0, null, null, 62, null);
        if (r4 == null) goto L6;
    L7:
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        r1.b = r4;
        if (r17 == null) goto L11;
        r3 = r17;
    L11:
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        r1.c = r3;
        if (r18 != null) goto L14;
    L17:
        boolean r5 = true;
    L18:
        if (r5 == true) goto L20;
        r1.c(r18);
    L20:
        Intrinsics.checkNotNullParameter(r1, "<this>");
        h r0 = r1.r;
        if (r0 == null) goto L24;
        r0.h(r1);
        return;
    L24:
        return;
    L14:
        if (r18.isEmpty() == true) goto L17;
        r5 = false;
    L6:
        r4 = "";
        goto L7
    }
}
