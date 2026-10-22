package com.larus.avlink.gallery.business;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public abstract class b {

    public static final class a extends b {
        public final List<String> a;
        public final List<String> b;
        public final String c;

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
            return "Deleted(uniqIds=" + this.a + ", paths=" + this.b + ", source=" + this.c + ')';
        }

        public a(List<String> r2, List<String> r3, String r4) {
            Intrinsics.checkNotNullParameter(r2, "uniqIds");
            Intrinsics.checkNotNullParameter(r3, "paths");
            Intrinsics.checkNotNullParameter(r4, "source");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public b() {
    }
}
