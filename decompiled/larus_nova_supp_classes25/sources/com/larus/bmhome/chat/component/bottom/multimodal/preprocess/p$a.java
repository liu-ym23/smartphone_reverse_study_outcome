package com.larus.bmhome.chat.component.bottom.multimodal.preprocess;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class p$a {
    public static final /* synthetic */ int d = 0;
    public final String a;
    public final long b;
    public final long c;

    public static final class a {
        public static p$a a(String r13) {
            Intrinsics.checkNotNullParameter(r13, "value");
            List r14 = StringsKt.split$default(r13, new String[]{"\u0000"}, false, 0, 6, null);
            if (r14.size() == 3) goto L5;
            return null;
        L5:
            boolean r0 = false;
            Object r1 = ListProtector.get(r14, 0);
            if ((!StringsKt.isBlank((String) r1)) == true) goto L9;
            r1 = null;
        L9:
            String r6 = (String) r1;
            if (r6 != null) goto L12;
            return null;
        L12:
            Long r2 = StringsKt.toLongOrNull((String) ListProtector.get(r14, 1));
            if (r2 != null) goto L15;
        L33:
            return null;
        L15:
            if (r2.longValue() < 0) goto L17;
            boolean r3 = true;
        L18:
            if (r3 == true) goto L21;
            r2 = null;
        L21:
            if (r2 == null) goto L33;
            long r7 = r2.longValue();
            Long r15 = StringsKt.toLongOrNull((String) ListProtector.get(r14, 2));
            if (r15 == null) goto L33;
            if (r15.longValue() < 0) goto L27;
            r0 = true;
        L27:
            if (r0 == true) goto L30;
            r15 = null;
        L30:
            if (r15 == null) goto L33;
            return new p$a(r6, r7, r15.longValue());
        L17:
            r3 = false;
            goto L18
        }
    }

    static {
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof p$a) == true) goto L8;
        return false;
    L8:
        p$a r9 = (p$a) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r9.b) goto L15;
        return false;
    L15:
        if (this.c == r9.c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        long r1 = this.b;
        int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        long r3 = this.c;
        return r2 + ((int) (r3 ^ (r3 >>> 32)));
    }

    public final String toString() {
        return "CandidateProof(path=" + this.a + ", lastModified=" + this.b + ", length=" + this.c + ')';
    }

    public p$a(String r2, long r3, long r5) {
        Intrinsics.checkNotNullParameter(r2, "path");
        this.a = r2;
        this.b = r3;
        this.c = r5;
    }
}
