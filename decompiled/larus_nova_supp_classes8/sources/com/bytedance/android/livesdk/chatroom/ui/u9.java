package com.bytedance.android.livesdk.chatroom.ui;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class u9 {
    public final String a;
    public final a b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;

    public static final class a {
        public final int a;
        public final String b;
        public final String c;
        public final String d;

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.ui.u9$a$a, reason: collision with other inner class name */
        public static final class C0029a {
        }

        static {
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof a) == false) goto L14;
            a r4 = (a) r3;
            if (this.a == r4.a) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.c, r4.c) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.d, r4.d) == true) goto L22;
            return false;
        L22:
            return true;
        L14:
            return false;
        }

        public final int hashCode() {
            int r0 = this.a * 31;
            String r1 = this.b;
            int r2 = 0;
            if (r1 == null) goto L5;
            int r3 = r1.hashCode();
        L6:
            int r4 = (r0 + r3) * 31;
            String r5 = this.c;
            if (r5 == null) goto L9;
            int r6 = r5.hashCode();
        L10:
            int r7 = (r4 + r6) * 31;
            String r8 = this.d;
            if (r8 == null) goto L14;
            r2 = r8.hashCode();
        L14:
            return r7 + r2;
        L9:
            r6 = 0;
            goto L10
        L5:
            r3 = 0;
            goto L6
        }

        public final String toString() {
            return "TitleConfig(titleType=" + this.a + ", titleString=" + this.b + ", titleImg=" + this.c + ", titleColor=" + this.d + ")";
        }

        public a(int r1, String r2, String r3, String r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    public u9(String r1, a r2, String r3, String r4, String r5, String r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}
