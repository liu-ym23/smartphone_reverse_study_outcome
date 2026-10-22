package com.obric.assistant.state.impl.multitask.consumer;

import java.util.List;
import jha.g;
import jha.o;
import jha.p;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public interface TaskFlowActiveStateStore$a {

    public static final class a implements TaskFlowActiveStateStore$a {
        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof a) == true) goto L8;
            return false;
        L8:
            ((a) r4).getClass();
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
            return "Register(registration=null, activeStates=null, sticky=false, replaced=false)";
        }
    }

    public static final class b implements TaskFlowActiveStateStore$a {
        public final List<TaskFlowActiveStateStore.c> a;
        public final g<?> b;
        public final p<? extends o> c;
        public final p<? extends o> d;
        public final p<? extends o> e;

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
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
            p<? extends o> r1 = this.c;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            p<? extends o> r5 = this.d;
            if (r5 == null) goto L11;
            r2 = r5.hashCode();
        L11:
            return ((r4 + r2) * 31) + this.e.hashCode();
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public final String toString() {
            return "StateChanged(registrations=" + this.a + ", taskFlowId=" + this.b + ", previousActiveState=" + this.c + ", currentActiveState=" + this.d + ", changedState=" + this.e + ')';
        }

        public b(List<TaskFlowActiveStateStore.c> r2, g<?> r3, p<? extends o> r4, p<? extends o> r5, p<? extends o> r6) {
            Intrinsics.checkNotNullParameter(r2, "registrations");
            Intrinsics.checkNotNullParameter(r3, "taskFlowId");
            Intrinsics.checkNotNullParameter(r6, "changedState");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
        }
    }
}
