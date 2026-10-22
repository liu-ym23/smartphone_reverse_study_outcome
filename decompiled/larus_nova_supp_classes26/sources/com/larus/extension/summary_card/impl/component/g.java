package com.larus.extension.summary_card.impl.component;

import com.larus.im.bean.message.Message;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class g {
    public static final /* synthetic */ int h = 0;
    public final Message a;
    public final f b;
    public final boolean c;
    public final boolean d;
    public final boolean e;
    public final int f;
    public final boolean g;

    public static final class a {
        public static g a(Message r3) {
            String r1 = null;
            if (r3 == null) goto L5;
            String r2 = r3.getMessageId();
        L6:
            if (r2 != null) goto L8;
        L11:
            boolean r4 = true;
        L12:
            if (r4 == false) goto L20;
            if (r3 == null) goto L18;
            Map r5 = r3.getBusinessExt();
            if (r5 == null) goto L18;
            r1 = (String) r5.get("expand_status_non_collapsed");
        L18:
            if (Intrinsics.areEqual(r1, "1") == false) goto L20;
            f r6 = f.d.a;
        L22:
            return new g(r6, 125);
        L20:
            r6 = f.a.a;
            goto L22
        L8:
            if (r2.length() == 0) goto L11;
            r4 = false;
            goto L12
        L5:
            r2 = null;
            goto L6
        }
    }

    static {
    }

    public g() {
        this(null, 127);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof g) == true) goto L8;
        return false;
    L8:
        g r6 = (g) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L27;
        return false;
    L27:
        if (this.g == r6.g) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        Message r0 = this.a;
        if (r0 != null) goto L5;
        int r1 = 0;
    L6:
        int r2 = ((r1 * 31) + this.b.hashCode()) * 31;
        int r3 = 1231;
        if (this.c == false) goto L9;
        int r4 = 1231;
    L10:
        int r5 = (r2 + r4) * 31;
        if (this.d == false) goto L13;
        int r6 = 1231;
    L14:
        int r7 = (r5 + r6) * 31;
        if (this.e == false) goto L17;
        int r8 = 1231;
    L18:
        int r9 = (((r7 + r8) * 31) + this.f) * 31;
        if (this.g == true) goto L23;
        r3 = 1237;
    L23:
        return r9 + r3;
    L17:
        r8 = 1237;
        goto L18
    L13:
        r6 = 1237;
        goto L14
    L9:
        r4 = 1237;
        goto L10
    L5:
        r1 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "SummaryCardStatus(message=" + this.a + ", expandStatus=" + this.b + ", firstBind=" + this.c + ", realSummaryFirstExposure=" + this.d + ", placeholderFirstExposure=" + this.e + ", unExpandHeight=" + this.f + ", mLastIsPlaceholder=" + this.g + ')';
    }

    public /* synthetic */ g(f r9, int r10) {
        if ((r10 & 2) == 0) goto L5;
        r9 = f.a.a;
    L5:
        f r2 = r9;
        if ((r10 & 4) == 0) goto L8;
        boolean r11 = true;
    L10:
        if ((r10 & 8) == 0) goto L12;
        boolean r4 = true;
    L14:
        if ((r10 & 16) == 0) goto L16;
        boolean r5 = true;
    L17:
        this(null, r2, r11, r4, r5, 0, false);
        return;
    L16:
        r5 = false;
        goto L17
    L12:
        r4 = false;
        goto L14
    L8:
        r11 = false;
        goto L10
    }

    public g(Message r2, f r3, boolean r4, boolean r5, boolean r6, int r7, boolean r8) {
        Intrinsics.checkNotNullParameter(r3, "expandStatus");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
    }

    public static g a(g r8, Message r9, f r10, boolean r11, int r12, boolean r13, int r14) {
        if ((r14 & 1) == 0) goto L5;
        r9 = r8.a;
    L5:
        Message r1 = r9;
        if ((r14 & 2) == 0) goto L8;
        r10 = r8.b;
    L8:
        f r2 = r10;
        if ((r14 & 4) == 0) goto L11;
        r11 = r8.c;
    L11:
        boolean r3 = r11;
        if ((r14 & 8) == 0) goto L14;
        boolean r4 = r8.d;
    L16:
        if ((r14 & 16) == 0) goto L18;
        boolean r5 = r8.e;
    L20:
        if ((r14 & 32) == 0) goto L22;
        r12 = r8.f;
    L22:
        int r6 = r12;
        if ((r14 & 64) == 0) goto L25;
        r13 = r8.g;
    L25:
        Intrinsics.checkNotNullParameter(r2, "expandStatus");
        return new g(r1, r2, r3, r4, r5, r6, r13);
    L18:
        r5 = false;
        goto L20
    L14:
        r4 = false;
        goto L16
    }
}
