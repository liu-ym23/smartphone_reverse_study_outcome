package com.larus.bmhome.bot.share;

import android.graphics.Bitmap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public abstract class i {

    public static final class a extends i {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }
    }

    public static final class b extends i {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }
    }

    public static final class c extends i {
        public final Bitmap a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof c) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((c) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "Success(bitmap=" + this.a + ')';
        }

        public c(Bitmap r2) {
            Intrinsics.checkNotNullParameter(r2, "bitmap");
            this.a = r2;
        }
    }

    public i() {
    }
}
