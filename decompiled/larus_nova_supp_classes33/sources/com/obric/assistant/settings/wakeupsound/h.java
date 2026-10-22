package com.obric.assistant.settings.wakeupsound;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public interface h {

    public static final class a implements h {
        public final g a;

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
            return "Option(item=" + this.a + ')';
        }

        public a(g r2) {
            Intrinsics.checkNotNullParameter(r2, "item");
            this.a = r2;
        }
    }
}
