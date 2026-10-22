package jha;

import jha.o;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public interface q<S extends o> {

    public static final class a<S extends o> implements q<S> {
        public final p<S> a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((a) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "End(envelope=" + this.a + ')';
        }

        @Override // jha.q
        public final p<S> a() {
            return this.a;
        }

        public a(p<S> r2) {
            Intrinsics.checkNotNullParameter(r2, "envelope");
            this.a = r2;
        }
    }

    public static final class b<S extends o> implements q<S> {
        public final p<S> a;

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
            return "Start(envelope=" + this.a + ')';
        }

        @Override // jha.q
        public final p<S> a() {
            return this.a;
        }

        public b(p<S> r2) {
            Intrinsics.checkNotNullParameter(r2, "envelope");
            this.a = r2;
        }
    }

    public static final class c<S extends o> implements q<S> {
        public final p<S> a;

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
            return "Update(envelope=" + this.a + ')';
        }

        @Override // jha.q
        public final p<S> a() {
            return this.a;
        }

        public c(p<S> r2) {
            Intrinsics.checkNotNullParameter(r2, "envelope");
            this.a = r2;
        }
    }

    p<S> a();
}
