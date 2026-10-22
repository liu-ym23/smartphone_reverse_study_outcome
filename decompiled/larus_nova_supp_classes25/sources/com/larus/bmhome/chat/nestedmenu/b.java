package com.larus.bmhome.chat.nestedmenu;

import com.larus.bmhome.actionbar.model.ModelItemIdentity;
import com.larus.bmhome.actionbar.model.b2;
import com.larus.bmhome.actionbar.model.t0;
import com.larus.bmhome.actionbar.model.v1;
import di8.f0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class b implements f0 {
    public final C0068b a;
    public final c b;
    public final a c;
    public final boolean d;

    public static final class a {
        public final t0 a;

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
            return "ModePayload(sourceItem=" + this.a + ')';
        }

        public a(t0 r2) {
            Intrinsics.checkNotNullParameter(r2, "sourceItem");
            this.a = r2;
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.chat.nestedmenu.b$b, reason: collision with other inner class name */
    public static final class C0068b {
        public final b2 a;
        public final ModelItemIdentity b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof C0068b) == true) goto L8;
            return false;
        L8:
            C0068b r6 = (C0068b) r5;
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
            return "ModelPayload(sourceItem=" + this.a + ", identity=" + this.b + ')';
        }

        public C0068b(b2 r2, ModelItemIdentity r3) {
            Intrinsics.checkNotNullParameter(r2, "sourceItem");
            Intrinsics.checkNotNullParameter(r3, "identity");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class c {
        public final b2 a;
        public final ModelItemIdentity b;
        public final v1 c;
        public final int d;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof c) == true) goto L8;
            return false;
        L8:
            c r6 = (c) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            return (((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d;
        }

        public final String toString() {
            return "ReasoningEffortPayload(sourceModelItem=" + this.a + ", modelIdentity=" + this.b + ", option=" + this.c + ", level=" + this.d + ')';
        }

        public c(b2 r2, ModelItemIdentity r3, v1 r4, int r5) {
            Intrinsics.checkNotNullParameter(r2, "sourceModelItem");
            Intrinsics.checkNotNullParameter(r3, "modelIdentity");
            Intrinsics.checkNotNullParameter(r4, "option");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b() {
        Object[] r0 = 0 == true ? 1 : 0;
        Object[] r1 = 0 == true ? 1 : 0;
        this(null, r0, r1, 15);
    }

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
        if (this.d == r6.d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        C0068b r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        c r4 = this.b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        a r7 = this.c;
        if (r7 == null) goto L14;
        r1 = r7.hashCode();
    L14:
        int r8 = (r6 + r1) * 31;
        if (this.d == false) goto L17;
        int r9 = 1231;
    L19:
        return r8 + r9;
    L17:
        r9 = 1237;
        goto L19
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "NestedMenuActionBarPayload(modelPayload=" + this.a + ", reasoningEffortPayload=" + this.b + ", modePayload=" + this.c + ", isFolded=" + this.d + ')';
    }

    public /* synthetic */ b(C0068b r3, c r4, a r5, int r6) {
        if ((r6 & 1) == 0) goto L6;
        r3 = null;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r4 = null;
    L9:
        if ((r6 & 4) == 0) goto L11;
        r5 = null;
    L11:
        this(r3, r4, r5, false);
    }

    public b(C0068b r1, c r2, a r3, boolean r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
