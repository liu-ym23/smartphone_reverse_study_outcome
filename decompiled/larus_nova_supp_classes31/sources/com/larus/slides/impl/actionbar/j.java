package com.larus.slides.impl.actionbar;

import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class j {
    public static a a;

    public static final class a {
        public final List<com.larus.slides.impl.actionbar.model.c> a;
        public final int b;
        public final boolean c;
        public final String d;

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
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r0 = ((this.a.hashCode() * 31) + this.b) * 31;
            if (this.c == false) goto L5;
            int r1 = 1231;
        L6:
            int r2 = (r0 + r1) * 31;
            String r3 = this.d;
            if (r3 != null) goto L9;
            int r4 = 0;
        L11:
            return r2 + r4;
        L9:
            r4 = r3.hashCode();
            goto L11
        L5:
            r1 = 1237;
            goto L6
        }

        public final String toString() {
            return "PPTTemplateCache(templateList=" + this.a + ", nextCursor=" + this.b + ", hasMoreData=" + this.c + ", currentSelectedId=" + this.d + ')';
        }

        public a(List<com.larus.slides.impl.actionbar.model.c> r2, int r3, boolean r4, String r5) {
            Intrinsics.checkNotNullParameter(r2, "templateList");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    static {
    }

    public static void a(List r1, int r2, boolean r3, String r4) {
        Intrinsics.checkNotNullParameter(r1, "templates");
        a = new a(r1, r2, r3, r4);
        FLogger.a.d("PPTGenerationTemplateManager", "Template data saved to cache, count: " + ((ArrayList) r1).size() + ", selectedId: " + r4);
    }
}
