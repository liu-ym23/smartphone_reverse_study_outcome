package ssb;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public abstract class b {
    public final int a;

    public static final class a extends b {
        public final List<c> b;
        public final int c;

        /* JADX INFO: renamed from: ssb.b$a$a, reason: collision with other inner class name */
        public static final class C0326a {
        }

        static {
        }

        public a() {
            throw null;
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L12;
            return false;
        L12:
            if (this.c == r6.c) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.b.hashCode() * 31) + this.c;
        }

        public final String toString() {
            return "CustomArea(data=" + this.b + ", lines=" + this.c + ')';
        }

        public /* synthetic */ a(List r2) {
            this(r2, usb.a.a());
        }

        public a(List<c> r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "data");
            super(2);
            this.b = r2;
            this.c = r3;
        }
    }

    /* JADX INFO: renamed from: ssb.b$b, reason: collision with other inner class name */
    public static final class C0327b extends b {
        public final int b;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof C0327b) == true) goto L9;
            return false;
        L9:
            if (this.b == ((C0327b) r4).b) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.b;
        }

        public final String toString() {
            return "CustomSpace(height=" + this.b + ')';
        }

        public C0327b(int r2) {
            super(3);
            this.b = r2;
        }
    }

    public static final class c extends b {
        public final com.ss.android.lark.newemoji.larkemoji.a b;
        public final boolean c;
        public final s5c.d d;
        public final Integer e;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof c) == true) goto L8;
            return false;
        L8:
            c r6 = (c) r5;
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L12;
            return false;
        L12:
            if (this.c == r6.c) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r0 = this.b.hashCode() * 31;
            if (this.c == false) goto L5;
            int r1 = 1231;
        L6:
            int r2 = (r0 + r1) * 31;
            s5c.d r3 = this.d;
            int r4 = 0;
            if (r3 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (r2 + r5) * 31;
            Integer r7 = this.e;
            if (r7 == null) goto L15;
            r4 = r7.hashCode();
        L15:
            return r6 + r4;
        L9:
            r5 = r3.hashCode();
            goto L10
        L5:
            r1 = 1237;
            goto L6
        }

        public final String toString() {
            return "Emoji(data=" + this.b + ", enableEmojiSkin=" + this.c + ", tab=" + this.d + ", position=" + this.e + ')';
        }

        public c(com.ss.android.lark.newemoji.larkemoji.a r2, boolean r3, s5c.a r4, Integer r5) {
            Intrinsics.checkNotNullParameter(r2, "data");
            super(1);
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }
    }

    public static final class d extends b {
        public final String b;
        public final String c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof d) == true) goto L8;
            return false;
        L8:
            d r6 = (d) r5;
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r0 = this.b.hashCode() * 31;
            String r1 = this.c;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return r0 + r2;
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public final String toString() {
            return "Title(title=" + this.b + ", iconKey=" + this.c + ')';
        }

        public d(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "title");
            super(0);
            this.b = r2;
            this.c = r3;
        }
    }

    public final int getType() {
        return this.a;
    }

    public b(int r1) {
        this.a = r1;
    }
}
