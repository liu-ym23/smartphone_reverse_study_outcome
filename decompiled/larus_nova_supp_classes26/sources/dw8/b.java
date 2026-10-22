package dw8;

import com.larus.business.floatchat.api.AIChatActionBarCapability;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public abstract class b {

    public static final class a extends b {
        public final AIChatActionBarCapability a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof a) == true) goto L9;
            return false;
        L9:
            if (this.a == ((a) r4).a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "OpenCapability(capability=" + this.a + ')';
        }

        public a(AIChatActionBarCapability r2) {
            Intrinsics.checkNotNullParameter(r2, "capability");
            this.a = r2;
        }
    }

    /* JADX INFO: renamed from: dw8.b$b, reason: collision with other inner class name */
    public static final class C0106b extends b {
        public final String a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof C0106b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((C0106b) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "OpenSchema(schema=" + this.a + ')';
        }

        public C0106b(String r2) {
            Intrinsics.checkNotNullParameter(r2, "schema");
            this.a = r2;
        }
    }

    public static final class c extends b {
        public final String a;

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
            return "SendPrompt(prompt=" + this.a + ')';
        }

        public c(String r2) {
            Intrinsics.checkNotNullParameter(r2, "prompt");
            this.a = r2;
        }
    }

    public b() {
    }
}
