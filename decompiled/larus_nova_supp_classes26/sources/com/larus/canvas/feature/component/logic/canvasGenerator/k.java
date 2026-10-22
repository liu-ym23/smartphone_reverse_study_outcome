package com.larus.canvas.feature.component.logic.canvasGenerator;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public abstract class k<T> {

    public static final class a extends k {
        public final int a;
        public final String b;
        public final Throwable c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
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
            int r0 = ((this.a * 31) + this.b.hashCode()) * 31;
            Throwable r1 = this.c;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return r0 + r2;
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        @Override // com.larus.canvas.feature.component.logic.canvasGenerator.k
        public final String toString() {
            return "Error(code=" + this.a + ", msg=" + this.b + ", throwable=" + this.c + ')';
        }

        public a(int r2, String r3) {
            Intrinsics.checkNotNullParameter(r3, "msg");
            this.a = r2;
            this.b = r3;
            this.c = null;
        }
    }

    public static final class b<T> extends k<T> {
        public final T a;
        public final boolean b;

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
            if (this.b == r6.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            T r0 = this.a;
            if (r0 != null) goto L5;
            int r1 = 0;
        L6:
            int r2 = r1 * 31;
            if (this.b == false) goto L9;
            int r3 = 1231;
        L11:
            return r2 + r3;
        L9:
            r3 = 1237;
            goto L11
        L5:
            r1 = r0.hashCode();
            goto L6
        }

        @Override // com.larus.canvas.feature.component.logic.canvasGenerator.k
        public final String toString() {
            return "Success(data=" + this.a + ", isFinish=" + this.b + ')';
        }

        public b(T r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public k() {
    }

    public String toString() {
        if ((this instanceof b) == false) goto L6;
        return "Success[" + this + ']';
    L6:
        if ((this instanceof a) == false) goto L10;
        return "Error[" + this + ']';
    L10:
        throw new NoWhenBranchMatchedException();
    }
}
