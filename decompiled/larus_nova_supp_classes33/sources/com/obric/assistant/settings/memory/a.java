package com.obric.assistant.settings.memory;

import com.obric.assistant.settings.ToggleName;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public abstract class a {

    /* JADX INFO: renamed from: com.obric.assistant.settings.memory.a$a, reason: collision with other inner class name */
    public static final class C0023a extends a {
        public static final C0023a a = null;

        static {
            a = new C0023a();
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if ((r3 instanceof C0023a) == true) goto L9;
            return false;
        L9:
            C0023a r4 = (C0023a) r3;
            return true;
        }

        public final int hashCode() {
            return 936644714;
        }

        public final String toString() {
            return "Banner";
        }

        public C0023a() {
        }
    }

    public static final class b extends a {
        public final ToggleName a;
        public final String b;
        public final String c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
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
            return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
        }

        public final String toString() {
            return "DataSourceItem(toggleName=" + this.a + ", title=" + this.b + ", endText=" + this.c + ')';
        }

        public b(ToggleName r2, String r3, String r4) {
            Intrinsics.checkNotNullParameter(r2, "toggleName");
            Intrinsics.checkNotNullParameter(r3, "title");
            Intrinsics.checkNotNullParameter(r4, "endText");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public static final class c extends a {
        public final String a;
        public final boolean b;

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
            int r0 = this.a.hashCode() * 31;
            if (this.b == false) goto L5;
            int r1 = 1231;
        L7:
            return r0 + r1;
        L5:
            r1 = 1237;
            goto L7
        }

        public final String toString() {
            return "LocalDataSearchSwitch(title=" + this.a + ", enabled=" + this.b + ')';
        }

        public c(String r2, boolean r3) {
            Intrinsics.checkNotNullParameter(r2, "title");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class d extends a {
        public final String a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof d) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((d) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "SectionHeader(title=" + this.a + ')';
        }

        public d(String r2) {
            Intrinsics.checkNotNullParameter(r2, "title");
            this.a = r2;
        }
    }

    public a() {
    }
}
