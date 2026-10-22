package com.obric.assistant.cocreationreview;

import com.lynx.tasm.event.LynxTouchEvent;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public abstract class z4 {

    public static final class a extends z4 {
        public final String a;
        public final String b;
        public final e c;
        public final a5 d;
        public final List<y4> e;
        public final List<x4> f;
        public final String g;
        public final String h;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
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
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.h, r6.h) == true) goto L32;
            return false;
        L32:
            return true;
        }

        public final int hashCode() {
            int r0 = ((((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31;
            String r1 = this.g;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            String r5 = this.h;
            if (r5 == null) goto L11;
            r2 = r5.hashCode();
        L11:
            return r4 + r2;
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public final String toString() {
            return "Content(recordId=" + this.a + ", pageTitle=" + this.b + ", title=" + this.c + ", feedback=" + this.d + ", sections=" + this.e + ", pages=" + this.f + ", initialAnchor=" + this.g + ", leadingTitleLabel=" + this.h + ')';
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(String r2, String r3, e r4, a5 r5, List<? extends y4> r6, List<x4> r7, String r8, String r9) {
            Intrinsics.checkNotNullParameter(r2, "recordId");
            Intrinsics.checkNotNullParameter(r3, "pageTitle");
            Intrinsics.checkNotNullParameter(r4, "title");
            Intrinsics.checkNotNullParameter(r5, "feedback");
            Intrinsics.checkNotNullParameter(r6, "sections");
            Intrinsics.checkNotNullParameter(r7, "pages");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
            this.g = r8;
            this.h = r9;
        }

        public /* synthetic */ a(String r12, String r13, e r14, a5 r15, List r16, List r17, String r18, int r19) {
            if ((r19 & 32) == 0) goto L5;
            List r8 = CollectionsKt.emptyList();
        L7:
            if ((r19 & LynxTouchEvent.kPseudoStateFocusTransition) == 0) goto L9;
            String r10 = null;
        L10:
            this(r12, r13, r14, r15, r16, r8, null, r10);
            return;
        L9:
            r10 = r18;
            goto L10
        L5:
            r8 = r17;
            goto L7
        }
    }

    public z4() {
    }
}
