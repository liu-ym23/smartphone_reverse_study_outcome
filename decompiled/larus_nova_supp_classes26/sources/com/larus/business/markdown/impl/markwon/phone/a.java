package com.larus.business.markdown.impl.markwon.phone;

import java.util.regex.Pattern;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a {
    public static final a a = null;
    public static Pattern b;
    public static Pattern c;

    /* JADX INFO: renamed from: com.larus.business.markdown.impl.markwon.phone.a$a, reason: collision with other inner class name */
    public static final class C0073a {
        public final int a;
        public final int b;
        public final String c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof C0073a) == true) goto L8;
            return false;
        L8:
            C0073a r6 = (C0073a) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.a * 31) + this.b) * 31) + this.c.hashCode();
        }

        public final String toString() {
            return "PhoneInfo(start=" + this.a + ", end=" + this.b + ", phoneNumber=" + this.c + ')';
        }

        public C0073a(int r2, int r3, String r4) {
            Intrinsics.checkNotNullParameter(r4, "phoneNumber");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    static {
        a = new a();
    }

    public a() {
    }
}
