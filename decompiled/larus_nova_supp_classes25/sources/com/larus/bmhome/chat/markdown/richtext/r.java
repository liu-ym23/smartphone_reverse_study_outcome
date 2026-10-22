package com.larus.bmhome.chat.markdown.richtext;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public abstract class r {

    public static final class a extends r {
        public final String a;
        public final int b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b;
        }

        public final String toString() {
            return "Attachment(uri=" + this.a + ", type=" + this.b + ')';
        }

        public final int getType() {
            return this.b;
        }

        public a(String r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "uri");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class b extends r {
        public final String a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((b) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "Conversation(conversationId=" + this.a + ')';
        }

        public b(String r2) {
            Intrinsics.checkNotNullParameter(r2, "conversationId");
            this.a = r2;
        }
    }

    public static final class c extends r {
        public final String a;
        public final MessageFileKind b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof c) == true) goto L8;
            return false;
        L8:
            c r6 = (c) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "File(path=" + this.a + ", kind=" + this.b + ')';
        }

        public c(String r2, MessageFileKind r3) {
            Intrinsics.checkNotNullParameter(r2, "path");
            Intrinsics.checkNotNullParameter(r3, "kind");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class d extends r {
        public final int a;
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
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a * 31;
            String r1 = this.b;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            String r5 = this.c;
            if (r5 == null) goto L11;
            r2 = r5.hashCode();
        L11:
            return r4 + r2;
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public final String toString() {
            return "Skill(type=" + this.a + ", id=" + this.b + ", path=" + this.c + ')';
        }

        public final int getType() {
            return this.a;
        }

        public d(int r3, String r4, String r5, int r6) {
            if ((r6 & 2) == 0) goto L6;
            r4 = null;
        L6:
            if ((r6 & 4) == 0) goto L8;
            r5 = null;
        L8:
            this.a = r3;
            this.b = r4;
            this.c = r5;
        }
    }

    public r() {
    }
}
