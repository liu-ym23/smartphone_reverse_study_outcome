package com.larus.bmhome.chat.component.bottom.core.inputtext;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.JobKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class p1 {
    public static final /* synthetic */ int f = 0;
    public final String a;
    public final String b;
    public final List<n1> c;
    public final String d;
    public final List<n1> e;

    public static final class a {
        public static p1 a(String r14, Continuation r15) {
            CoroutineContext r16 = r15.getContext();
            StringBuilder r0 = new StringBuilder();
            StringBuilder r1 = new StringBuilder();
            ArrayList r5 = new ArrayList();
            ArrayList r7 = new ArrayList();
            int r3 = 0;
        L4:
            if (r3 >= r14.length()) goto L40;
            JobKt.ensureActive(r16);
            int r4 = Character.charCount(r14.codePointAt(r3)) + r3;
            n1 r6 = new n1(r3, r4);
            if ((r4 - r3) != 1) goto L19;
            char r8 = r14.charAt(r3);
            if (19968 > r8) goto L14;
            if (r8 > 40869) goto L14;
            if (ru7.c.b(r8) <= 0) goto L14;
        L15:
            boolean r9 = true;
        L17:
            if (r9 == false) goto L19;
            boolean r10 = true;
        L20:
            if (r10 == false) goto L22;
            String r11 = ru7.c.c(r14.charAt(r3));
        L23:
            Intrinsics.checkNotNull(r11);
            String r12 = r11.toLowerCase(Locale.ROOT);
            StringBuilder r13 = new StringBuilder();
            int r17 = 0;
        L25:
            if (r17 >= r12.length()) goto L30;
            char r18 = r12.charAt(r17);
            if (CharsKt.isWhitespace(r18) == true) goto L29;
            r13.append(r18);
        L29:
            r17 = r17 + 1;
            goto L25
        L30:
            String r19 = r13.toString();
            r0.append(r19);
            int r110 = r19.length();
            int r111 = 0;
        L31:
            if (r111 >= r110) goto L33;
            r5.add(r6);
            r111 = r111 + 1;
            goto L31
        L33:
            if (r10 == false) goto L35;
            r19 = StringsKt.take(r19, 1);
        L35:
            r1.append(r19);
            int r20 = r19.length();
            int r21 = 0;
        L36:
            if (r21 >= r20) goto L38;
            r7.add(r6);
            r21 = r21 + 1;
            goto L36
        L38:
            r3 = r4;
            goto L4
        L22:
            r11 = r14.substring(r3, r4);
        L14:
            if (12295 == r8) goto L15;
            r9 = false;
        L19:
            r10 = false;
            goto L20
        L40:
            return new p1(r14, r0.toString(), r5, r1.toString(), r7);
        }
    }

    static {
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof p1) == true) goto L8;
        return false;
    L8:
        p1 r6 = (p1) r5;
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
        return (((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode();
    }

    public final String toString() {
        return "SearchTextIndex(original=" + this.a + ", pinyin=" + this.b + ", pinyinRanges=" + this.c + ", initials=" + this.d + ", initialRanges=" + this.e + ')';
    }

    public p1(String r2, String r3, List<n1> r4, String r5, List<n1> r6) {
        Intrinsics.checkNotNullParameter(r2, "original");
        Intrinsics.checkNotNullParameter(r3, "pinyin");
        Intrinsics.checkNotNullParameter(r4, "pinyinRanges");
        Intrinsics.checkNotNullParameter(r5, "initials");
        Intrinsics.checkNotNullParameter(r6, "initialRanges");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
