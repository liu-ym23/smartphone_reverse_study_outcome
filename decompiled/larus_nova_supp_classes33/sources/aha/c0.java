package aha;

import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public abstract class c0 implements jha.o {

    public static final class a extends c0 {
        public final int a;
        public final jha.h b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "Active(refreshSequence=" + this.a + ", lifecycleStage=" + this.b + ')';
        }

        @Override // jha.a
        public final jha.h a() {
            return this.b;
        }

        public a(int r3) {
            jha.h.a r0 = jha.h.a.a;
            Intrinsics.checkNotNullParameter(r0, "lifecycleStage");
            super(r0);
            this.a = r3;
            this.b = r0;
        }
    }

    public static final class b extends c0 {
        public final String a;
        public final jha.h b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "Terminated(reason=" + this.a + ", lifecycleStage=" + this.b + ')';
        }

        @Override // jha.a
        public final jha.h a() {
            return this.b;
        }

        public b(String r3) {
            jha.h.c r0 = jha.h.c.a;
            Intrinsics.checkNotNullParameter(r3, WindowEvent.Params.REASON);
            Intrinsics.checkNotNullParameter(r0, "lifecycleStage");
            super(r0);
            this.a = r3;
            this.b = r0;
        }
    }

    public c0(jha.h r1) {
    }
}
