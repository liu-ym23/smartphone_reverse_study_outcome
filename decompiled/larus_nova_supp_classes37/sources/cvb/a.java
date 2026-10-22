package cvb;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public abstract class a<T> {

    /* JADX INFO: renamed from: cvb.a$a, reason: collision with other inner class name */
    public static final class C0133a extends a {
        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof C0133a) == true) goto L8;
            return false;
        L8:
            ((C0133a) r4).getClass();
            if (Intrinsics.areEqual(null, null) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(null, null) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            throw null;
        }

        public final String toString() {
            return "Failed(code=0, message=null, debugMessage=null)";
        }
    }

    public a() {
    }
}
