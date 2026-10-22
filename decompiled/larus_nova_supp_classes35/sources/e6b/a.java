package e6b;

import com.ss.android.lark.blueprint.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface a {

    /* JADX INFO: renamed from: e6b.a$a, reason: collision with other inner class name */
    public static final class C0216a {
        public final int a;
        public final int b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof C0216a) == true) goto L8;
            return false;
        L8:
            C0216a r6 = (C0216a) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a * 31) + this.b;
        }

        public final String toString() {
            return "OrderCount(subOrder=" + this.a + ", count=" + this.b + ')';
        }

        public C0216a(int r1, int r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    C0216a e(j r1);
}
