package com.bytedance.android.anniex.base.service;

import android.content.Context;
import android.view.Menu;
import android.view.View;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a extends s26.a {

    /* JADX INFO: renamed from: com.bytedance.android.anniex.base.service.a$a, reason: collision with other inner class name */
    public static final class C0091a {
        public final String a;
        public final boolean b;
        public final String c;
        public final String d;

        public final boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof C0091a) == true) goto L8;
            return false;
        L8:
            C0091a r11 = (C0091a) r10;
            if (Intrinsics.areEqual(this.a, r11.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r11.b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r11.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r11.d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            String r0 = this.a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r10 = 0;
        L6:
            int r11 = r10 * 31;
            if (this.b == false) goto L9;
            int r12 = 1231;
        L10:
            int r13 = (r11 + r12) * 31;
            String r14 = this.c;
            if (r14 != null) goto L13;
            int r15 = 0;
        L14:
            int r16 = (r13 + r15) * 31;
            String r17 = this.d;
            if (r17 == null) goto L19;
            r1 = r17.hashCode();
        L19:
            return r16 + r1;
        L13:
            r15 = r14.hashCode();
            goto L14
        L9:
            r12 = 1237;
            goto L10
        L5:
            r10 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "LongClickConfig(sessionId=" + this.a + ", disableSaveImage=" + this.b + ", enterFrom=" + this.c + ", enterMethod=" + this.d + ')';
        }

        public C0091a(String r1, boolean r10, String r11) {
            this.a = r1;
            this.b = r10;
            this.c = r11;
            this.d = null;
        }
    }

    public static final class b {
        public final String a;
        public final boolean b;
        public final String c;
        public final String d;

        public final boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof b) == true) goto L8;
            return false;
        L8:
            b r11 = (b) r10;
            if (Intrinsics.areEqual(this.a, r11.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r11.b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r11.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r11.d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            String r0 = this.a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r10 = 0;
        L6:
            int r11 = r10 * 31;
            if (this.b == false) goto L9;
            int r12 = 1231;
        L10:
            int r13 = (r11 + r12) * 31;
            String r14 = this.c;
            if (r14 != null) goto L13;
            int r15 = 0;
        L14:
            int r16 = (r13 + r15) * 31;
            String r17 = this.d;
            if (r17 == null) goto L19;
            r1 = r17.hashCode();
        L19:
            return r16 + r1;
        L13:
            r15 = r14.hashCode();
            goto L14
        L9:
            r12 = 1237;
            goto L10
        L5:
            r10 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "SelectMenuConfig(sessionId=" + this.a + ", enableSearch=" + this.b + ", enterFrom=" + this.c + ", enterMethod=" + this.d + ')';
        }

        public b(String r1, boolean r10, String r11) {
            this.a = r1;
            this.b = r10;
            this.c = r11;
            this.d = null;
        }
    }

    public a() {
    }

    public static void G0(Context r10, la.a r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "copyData");
        s26.d r0 = s26.d.c;
        if (s26.d.c.c(a.class) == null) goto L6;
        G0(r10, r11);
        return;
    }

    public static void H0(Context r10, la.b r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "moreData");
        s26.d r0 = s26.d.c;
        if (s26.d.c.c(a.class) == null) goto L6;
        H0(r10, r11);
        return;
    }

    public static View.OnLongClickListener I0(Context r10, C0091a r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "config");
        s26.d r0 = s26.d.c;
        if (s26.d.c.c(a.class) != null) goto L7;
        return null;
    L7:
        return I0(r10, r11);
    }

    public static void K0(Context r10, la.c r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "reportData");
        s26.d r0 = s26.d.c;
        if (s26.d.c.c(a.class) == null) goto L6;
        K0(r10, r11);
        return;
    }

    public static void L0(Context r10, la.d r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "searchData");
        s26.d r0 = s26.d.c;
        if (s26.d.c.c(a.class) == null) goto L6;
        L0(r10, r11);
        return;
    }

    public static List J0(Context r10, Menu r11, b r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "menu");
        Intrinsics.checkNotNullParameter(r12, "config");
        s26.d r0 = s26.d.c;
        if (s26.d.c.c(a.class) != null) goto L7;
        return null;
    L7:
        return J0(r10, r11, r12);
    }
}
