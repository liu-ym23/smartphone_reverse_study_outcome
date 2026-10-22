package aha;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public abstract class b implements jha.o {
    public final Map<String, Object> a;

    public static final class a extends b {
        public final String b;
        public final jha.h c;
        public final Map<String, Object> d;

        public a() {
            throw null;
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            String r0 = this.b;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = ((r2 * 31) + this.c.hashCode()) * 31;
            Map<String, Object> r4 = this.d;
            if (r4 == null) goto L11;
            r1 = r4.hashCode();
        L11:
            return r3 + r1;
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "End(meetingId=" + this.b + ", lifecycleStage=" + this.c + ", ext=" + this.d + ')';
        }

        @Override // jha.a
        public final jha.h a() {
            return this.c;
        }

        public a(String r3, Map r4) {
            jha.h.c r0 = jha.h.c.a;
            Intrinsics.checkNotNullParameter(r0, "lifecycleStage");
            super(r0, r4);
            this.b = r3;
            this.c = r0;
            this.d = r4;
        }
    }

    /* JADX INFO: renamed from: aha.b$b, reason: collision with other inner class name */
    public static final class C0000b extends b {
        public final String b;
        public final jha.h c;
        public final Map<String, Object> d;

        public C0000b() {
            throw null;
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof C0000b) == true) goto L8;
            return false;
        L8:
            C0000b r6 = (C0000b) r5;
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            String r0 = this.b;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = ((r2 * 31) + this.c.hashCode()) * 31;
            Map<String, Object> r4 = this.d;
            if (r4 == null) goto L11;
            r1 = r4.hashCode();
        L11:
            return r3 + r1;
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "Recording(meetingId=" + this.b + ", lifecycleStage=" + this.c + ", ext=" + this.d + ')';
        }

        @Override // jha.a
        public final jha.h a() {
            return this.c;
        }

        public C0000b(String r3) {
            jha.h.a r0 = jha.h.a.a;
            Intrinsics.checkNotNullParameter(r0, "lifecycleStage");
            super(r0, null);
            this.b = r3;
            this.c = r0;
            this.d = null;
        }
    }

    public b(jha.h r1, Map r2) {
        this.a = r2;
    }
}
