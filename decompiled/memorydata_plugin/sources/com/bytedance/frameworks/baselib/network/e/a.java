package com.bytedance.frameworks.baselib.network.e;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: com.bytedance.frameworks.baselib.network.e.a$a, reason: collision with other inner class name */
    public static class C0122a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String[] f2341a;

        public C0122a(String[] r1) {
            this.f2341a = r1;
        }

        public String[] a() {
            return this.f2341a;
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L5;
            return true;
        L5:
            if (r3 != null) goto L7;
            return false;
        L7:
            if (getClass() != r3.getClass()) goto L13;
            C0122a r4 = (C0122a) ZeusTransformUtils.preCheckCast(r3, C0122a.class, "com.obric.memorydata.plugin");
            return Arrays.equals(this.f2341a, r4.f2341a);
        L13:
            return false;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f2342a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f2343b;
        private String[] c;
        private String[] d;
        private String[] e;
        private String[] f;
        private String[] g;
        private String[] h;
        private String[] i;

        public b(boolean r1, boolean r2, String[] r3, String[] r4, String[] r5, String[] r6, String[] r7, String[] r8, String[] r9) {
            this.f2342a = r1;
            this.f2343b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
            this.g = r7;
            this.h = r8;
            this.i = r9;
        }

        public boolean a() {
            return this.f2342a;
        }

        public boolean b() {
            return this.f2343b;
        }

        public String[] c() {
            return this.c;
        }

        public String[] d() {
            return this.d;
        }

        public String[] e() {
            return this.e;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (r5 != null) goto L8;
        L31:
            return false;
        L8:
            if (getClass() != r5.getClass()) goto L31;
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin");
            if (this.f2342a != r6.f2342a) goto L30;
            if (this.f2343b != r6.f2343b) goto L30;
            if (Arrays.equals(this.c, r6.c) == false) goto L30;
            if (Arrays.equals(this.d, r6.d) == false) goto L30;
            if (Arrays.equals(this.e, r6.e) == false) goto L30;
            if (Arrays.equals(this.f, r6.f) == false) goto L30;
            if (Arrays.equals(this.g, r6.g) == false) goto L30;
            if (Arrays.equals(this.h, r6.h) == false) goto L30;
            if (Arrays.equals(this.i, r6.i) == false) goto L30;
            return true;
        L30:
            return false;
        }

        public String[] f() {
            return this.f;
        }

        public String[] g() {
            return this.g;
        }

        public String[] h() {
            return this.h;
        }

        public String[] i() {
            return this.i;
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f2344a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f2345b;
        private b c;
        private C0122a d;

        public c(int r1, int r2, b r3, C0122a r4) {
            this.f2344a = r1;
            this.f2345b = r2;
            this.c = r3;
            this.d = r4;
        }

        public c(int r2, b r3, C0122a r4) {
            this(r2, 0, r3, r4);
        }

        public int a() {
            return this.f2344a;
        }

        public int b() {
            return this.f2345b;
        }

        public b c() {
            return this.c;
        }

        public C0122a d() {
            return this.d;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (r5 != null) goto L8;
        L21:
            return false;
        L8:
            if (getClass() != r5.getClass()) goto L21;
            c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.memorydata.plugin");
            if (this.f2344a != r6.f2344a) goto L20;
            if (this.f2345b != r6.f2345b) goto L20;
            if (Objects.equals(this.c, r6.c) == false) goto L20;
            if (Objects.equals(this.d, r6.d) == false) goto L20;
            return true;
        L20:
            return false;
        }
    }
}
