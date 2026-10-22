package a8b;

import java.util.BitSet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {
    public final BitSet a;

    /* JADX INFO: renamed from: a8b.a$a, reason: collision with other inner class name */
    public static class C0003a {
        public final BitSet a;

        public C0003a(BitSet r1) {
            this.a = r1;
        }

        public final void a(char r2) {
            if (r2 > 127) goto L7;
            this.a.set(r2);
            return;
        L7:
            throw new IllegalArgumentException("Can only match ASCII characters");
        }

        public final void b(char r1, char r2) {
        L2:
            if (r1 > r2) goto L4;
            a(r1);
            r1 = (char) (r1 + 1);
            goto L2
        }
    }

    public static C0003a a() {
        return new C0003a(new BitSet());
    }

    public final C0003a b() {
        return new C0003a((BitSet) this.a.clone());
    }

    public a(C0003a r1) {
        this.a = r1.a;
    }
}
