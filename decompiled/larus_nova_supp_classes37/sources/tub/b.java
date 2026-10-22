package tub;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public abstract class b {

    public static final class a extends b {
        public final boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if ((r3 instanceof a) == true) goto L9;
            return false;
        L9:
            ((a) r3).getClass();
            return true;
        }

        public final int hashCode() {
            return (int) 0;
        }

        public final String toString() {
            return "StartedAt(startedAtMillis=0)";
        }
    }
}
