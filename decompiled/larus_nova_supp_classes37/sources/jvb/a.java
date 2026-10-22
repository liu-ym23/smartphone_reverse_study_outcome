package jvb;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public abstract class a {

    /* JADX INFO: renamed from: jvb.a$a, reason: collision with other inner class name */
    public static final class C0156a extends a {
        public final String a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof C0156a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((C0156a) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "ObjectToken(value=" + this.a + ')';
        }

        @Override // jvb.a
        public final String a() {
            return this.a;
        }

        public C0156a(String r2) {
            Intrinsics.checkNotNullParameter(r2, "value");
            this.a = r2;
        }
    }

    public static final class b extends a {
        public final String a;

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
            return "RecordingId(value=" + this.a + ')';
        }

        @Override // jvb.a
        public final String a() {
            return this.a;
        }

        public b(String r2) {
            Intrinsics.checkNotNullParameter(r2, "value");
            this.a = r2;
        }
    }

    public a() {
    }

    public abstract String a();
}
