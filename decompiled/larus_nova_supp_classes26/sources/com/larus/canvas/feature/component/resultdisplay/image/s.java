package com.larus.canvas.feature.component.resultdisplay.image;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public interface s extends com.larus.canvas.feature.component.base.b {

    public static final class a implements s {
        public final y a;
        public final String b;

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
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "OnClickCompare(data=" + this.a + ", clickFrom=" + this.b + ')';
        }

        public a(y r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "data");
            Intrinsics.checkNotNullParameter(r3, "clickFrom");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class b implements s {
        public final y a;

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
            return "OnClickRegenerate(data=" + this.a + ')';
        }

        public b(y r2) {
            Intrinsics.checkNotNullParameter(r2, "data");
            this.a = r2;
        }
    }

    public static final class c implements s {
        public final y a;

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
            return "OnClickSave(data=" + this.a + ')';
        }

        public c(y r2) {
            Intrinsics.checkNotNullParameter(r2, "data");
            this.a = r2;
        }
    }

    public static final class d implements s {
        public final y a;
        public final boolean b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof d) == true) goto L8;
            return false;
        L8:
            d r6 = (d) r5;
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
            return "OnImageLoaded(data=" + this.a + ", isSuccess=" + this.b + ')';
        }

        public d(y r2, boolean r3) {
            Intrinsics.checkNotNullParameter(r2, "data");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class e implements s {
        public final y a;
        public final View b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof e) == true) goto L8;
            return false;
        L8:
            e r6 = (e) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "OnItemClick(data=" + this.a + ", view=" + this.b + ')';
        }

        public e(y r2, View r3) {
            Intrinsics.checkNotNullParameter(r2, "data");
            Intrinsics.checkNotNullParameter(r3, "view");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class f implements s {
        public final y a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof f) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((f) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "OnItemLongClick(data=" + this.a + ')';
        }

        public f(y r2) {
            Intrinsics.checkNotNullParameter(r2, "data");
            this.a = r2;
        }
    }

    public static final class g implements s {
        public static final g a = null;

        static {
            a = new g();
        }

        public g() {
        }
    }
}
