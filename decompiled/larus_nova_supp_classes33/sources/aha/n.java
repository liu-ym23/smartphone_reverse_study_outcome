package aha;

import com.obric.assistant.state.api.multitask.state.ObricInteractionStateType;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public abstract class n implements jha.o {
    public final String a;
    public final jha.h b;
    public final Map<String, Object> c;

    public static final class a extends n {
        public final String d;
        public final ObricInteractionStateType e;
        public final Map<String, Object> f;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L12;
            return false;
        L12:
            if (this.e == r6.e) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f, r6.f) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.d.hashCode() * 31) + this.e.hashCode()) * 31) + this.f.hashCode();
        }

        public final String toString() {
            return "Active(ownerId=" + this.d + ", interactionType=" + this.e + ", ext=" + this.f + ')';
        }

        @Override // aha.n
        public final String b() {
            return this.d;
        }

        public a(String r2, ObricInteractionStateType r3, Map<String, ? extends Object> r4) {
            Intrinsics.checkNotNullParameter(r2, "ownerId");
            Intrinsics.checkNotNullParameter(r3, "interactionType");
            Intrinsics.checkNotNullParameter(r4, "ext");
            super(r2, jha.h.a.a, r4);
            this.d = r2;
            this.e = r3;
            this.f = r4;
        }
    }

    public static final class b extends n {
        public final String d;
        public final ObricInteractionStateType e;
        public final Map<String, Object> f;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L12;
            return false;
        L12:
            if (this.e == r6.e) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f, r6.f) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.d.hashCode() * 31) + this.e.hashCode()) * 31) + this.f.hashCode();
        }

        public final String toString() {
            return "Inactive(ownerId=" + this.d + ", interactionType=" + this.e + ", ext=" + this.f + ')';
        }

        @Override // aha.n
        public final String b() {
            return this.d;
        }

        public b(String r2, ObricInteractionStateType r3, Map<String, ? extends Object> r4) {
            Intrinsics.checkNotNullParameter(r2, "ownerId");
            Intrinsics.checkNotNullParameter(r3, "interactionType");
            Intrinsics.checkNotNullParameter(r4, "ext");
            super(r2, jha.h.c.a, r4);
            this.d = r2;
            this.e = r3;
            this.f = r4;
        }
    }

    public n() {
        throw null;
    }

    @Override // jha.a
    public final jha.h a() {
        return this.b;
    }

    public String b() {
        return this.a;
    }

    public n(String r1, jha.h r2, Map r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
