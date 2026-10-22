package com.obric.assistant.settings.autogui;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public abstract class c {

    public static final class a extends c {
        public final String a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((a) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "SectionTitle(title=" + this.a + ')';
        }

        public a(String r2) {
            Intrinsics.checkNotNullParameter(r2, "title");
            this.a = r2;
        }
    }

    public static final class b extends c {
        public final com.obric.assistant.settings.autogui.a a;
        public final boolean b;
        public final int c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            if (this.b == false) goto L5;
            int r1 = 1231;
        L7:
            return ((r0 + r1) * 31) + this.c;
        L5:
            r1 = 1237;
            goto L7
        }

        public final String toString() {
            return "Switch(item=" + this.a + ", checked=" + this.b + ", cardPosition=" + this.c + ')';
        }

        public b(com.obric.assistant.settings.autogui.a r2, boolean r3, int r4) {
            Intrinsics.checkNotNullParameter(r2, "item");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public c() {
    }
}
