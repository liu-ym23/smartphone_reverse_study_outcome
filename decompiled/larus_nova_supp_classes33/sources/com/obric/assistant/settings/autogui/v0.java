package com.obric.assistant.settings.autogui;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public interface v0 {

    public static final class a implements v0 {
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
            return "BottomHint(text=" + this.a + ')';
        }

        public a(String r2) {
            Intrinsics.checkNotNullParameter(r2, "text");
            this.a = r2;
        }
    }

    public static final class b implements v0 {
        public final u0 a;

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
            return "Option(item=" + this.a + ')';
        }

        public b(u0 r2) {
            Intrinsics.checkNotNullParameter(r2, "item");
            this.a = r2;
        }
    }
}
