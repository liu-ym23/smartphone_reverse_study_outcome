package j0a;

import com.larus.platform.api.creation.UserCreation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public interface a {

    /* JADX INFO: renamed from: j0a.a$a, reason: collision with other inner class name */
    public static final class C0062a implements a {
        public static final C0062a a = null;

        static {
            a = new C0062a();
        }

        public C0062a() {
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if ((r3 instanceof C0062a) == true) goto L9;
            return false;
        L9:
            C0062a r4 = (C0062a) r3;
            return true;
        }

        public final int hashCode() {
            return 339691341;
        }

        public final String toString() {
            return "Deleted";
        }
    }

    public static final class b implements a {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if ((r3 instanceof b) == true) goto L9;
            return false;
        L9:
            b r4 = (b) r3;
            return true;
        }

        public final int hashCode() {
            return 1172817545;
        }

        public final String toString() {
            return "Failed";
        }
    }

    public static final class c implements a {
        public final UserCreation a;

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
            return "Hit(creation=" + this.a + ')';
        }

        public c(UserCreation r2) {
            Intrinsics.checkNotNullParameter(r2, "creation");
            this.a = r2;
        }
    }
}
