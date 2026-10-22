package com.larus.bmhome.chat.nestedmenu.ui;

import com.larus.bmhome.view.screenmenu.l0;
import di8.d0;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public interface q {

    public static final class a implements q {
        public final String a;
        public final LinkedHashMap<String, List<d0>> b;
        public final d0 c;
        public final l0 d;

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
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            return (((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
        }

        public final String toString() {
            return "Item(sectionName=" + this.a + ", sections=" + this.b + ", model=" + this.c + ", legacyItem=" + this.d + ')';
        }

        public a(String r2, LinkedHashMap<String, List<d0>> r3, d0 r4, l0 r5) {
            Intrinsics.checkNotNullParameter(r2, "sectionName");
            Intrinsics.checkNotNullParameter(r3, "sections");
            Intrinsics.checkNotNullParameter(r4, "model");
            Intrinsics.checkNotNullParameter(r5, "legacyItem");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    public static final class b implements q {
        public final int a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof b) == true) goto L9;
            return false;
        L9:
            if (this.a == ((b) r4).a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a;
        }

        public final String toString() {
            return "SectionSpacer(heightPx=" + this.a + ')';
        }

        public b(int r1) {
            this.a = r1;
        }
    }
}
