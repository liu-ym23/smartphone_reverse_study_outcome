package com.obric.assistant.state.multitask;

import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import jha.q;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class a {
    public final String a;
    public final C0026a b;
    public final long c;
    public final q<?> d;

    /* JADX INFO: renamed from: com.obric.assistant.state.multitask.a$a, reason: collision with other inner class name */
    public static final class C0026a {
        public final String a;
        public final String b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof C0026a) == true) goto L8;
            return false;
        L8:
            C0026a r6 = (C0026a) r5;
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
            return this.a + ':' + this.b;
        }

        public C0026a(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "action");
            Intrinsics.checkNotNullParameter(r3, WindowEvent.Params.RESULT);
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class b {
    }

    static {
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof a) == true) goto L8;
        return false;
    L8:
        a r9 = (a) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r9.c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r9.d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        long r1 = this.c;
        int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        q<?> r3 = this.d;
        if (r3 != null) goto L5;
        int r4 = 0;
    L7:
        return r2 + r4;
    L5:
        r4 = r3.hashCode();
        goto L7
    }

    public final String toString() {
        StringBuilder r0 = new StringBuilder();
        q<?> r1 = this.d;
        if (r1 == null) goto L6;
        r0.append("taskFlowId=" + r1.a().a + ", ");
        r0.append("sequenceId=" + this.c + ", ");
        r0.append("state=" + r1.a().b.getClass().getSimpleName() + ", ");
        r0.append("action=" + this.b + ", ");
        StringBuilder r2 = new StringBuilder("taskEvent=");
        r2.append(r1.a());
        r0.append(r2.toString());
    L6:
        return StringsKt.trimEnd(r0.toString(), new char[]{',', ' '});
    }

    public a(String r2, C0026a r3, long r4, q<?> r6) {
        Intrinsics.checkNotNullParameter(r2, "logTag");
        Intrinsics.checkNotNullParameter(r3, "action");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r6;
    }
}
