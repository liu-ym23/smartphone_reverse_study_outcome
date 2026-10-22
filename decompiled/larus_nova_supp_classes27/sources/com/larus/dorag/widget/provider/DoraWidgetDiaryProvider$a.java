package com.larus.dorag.widget.provider;

import android.graphics.Bitmap;
import com.larus.settings.value.e10;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class DoraWidgetDiaryProvider$a {

    public static final class a {
        public final String a;
        public final Pair<Integer, Integer> b;
        public final Bitmap c;

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
            return "BetaCoverCache(url=" + this.a + ", sizeDp=" + this.b + ", bitmap=" + this.c + ')';
        }

        public a(String r2, Pair<Integer, Integer> r3, Bitmap r4) {
            Intrinsics.checkNotNullParameter(r2, "url");
            Intrinsics.checkNotNullParameter(r3, "sizeDp");
            Intrinsics.checkNotNullParameter(r4, "bitmap");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public static boolean a() {
        e10 r0 = e10.a;
        if (e10.K0().length() <= 0) goto L5;
        return true;
    L5:
        return false;
    }
}
