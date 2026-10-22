package com.bytedance.android.anniex.base.service;

import android.content.Context;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class d extends s26.a {

    public static class a {
        public a() {
        }
    }

    public static class b {
        public b() {
        }

        public View a(Context r10, ia.c r11) {
            Intrinsics.checkNotNullParameter(r10, "context");
            Intrinsics.checkNotNullParameter(r11, "container");
            return null;
        }

        public void b(int r1) {
        }

        public void c(String r10) {
            Intrinsics.checkNotNullParameter(r10, "title");
        }

        public void d(int r1) {
        }

        public void e(boolean r1) {
        }

        public void f(boolean r1) {
        }
    }

    public d() {
    }

    public static a G0(b16.a r10) {
        Intrinsics.checkNotNullParameter(r10, "container");
        s26.d r0 = s26.d.c;
        if (s26.d.c.c(d.class) != null) goto L7;
        return null;
    L7:
        return G0(r10);
    }

    public static void H0(ia.c r10) {
        Intrinsics.checkNotNullParameter(r10, "container");
        s26.d r0 = s26.d.c;
        if (s26.d.c.c(d.class) == null) goto L6;
        H0(r10);
        return;
    }

    public b I0(m16.b r10, ia.c r11) {
        Intrinsics.checkNotNullParameter(r11, "container");
        s26.d r0 = s26.d.c;
        d r1 = s26.d.c.c(d.class);
        if (r1 != null) goto L7;
        return null;
    L7:
        return r1.I0(r10, r11);
    }
}
