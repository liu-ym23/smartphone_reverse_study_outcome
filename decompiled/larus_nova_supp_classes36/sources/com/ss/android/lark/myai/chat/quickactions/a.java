package com.ss.android.lark.myai.chat.quickactions;

import android.text.Editable;
import com.ss.android.lark.keyboard.edittext2.span.f;
import com.ss.android.lark.keyboard.edittext2.span.k;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public interface a extends f {

    /* JADX INFO: renamed from: com.ss.android.lark.myai.chat.quickactions.a$a, reason: collision with other inner class name */
    public static final class C0194a {
        public static k.a a(a r7, int r8, int r9, Editable r10) {
            Intrinsics.checkNotNullParameter(r10, "text");
            int r0 = r10.getSpanStart(r7);
            int r1 = r10.getSpanEnd(r7);
            boolean r2 = false;
            if (r0 < 0) goto L6;
            if (r0 > r1) goto L6;
            boolean r4 = true;
        L8:
            if (r4 == true) goto L10;
            return null;
        L10:
            QuickActionNameSpan r5 = (QuickActionNameSpan) ArraysKt.getOrNull(r10.getSpans(0, r10.length(), QuickActionNameSpan.class), 0);
            if (r8 != r9) goto L13;
            boolean r6 = true;
        L15:
            if (r10.getSpanEnd(r5) != r0) goto L17;
            r2 = true;
        L17:
            if (r6 == false) goto L28;
            if (r2 == false) goto L20;
        L23:
            IntRange r11 = new IntRange(r0, r1);
        L25:
            if (r11.contains(r8) == true) goto L27;
        L39:
            return null;
        L27:
            return r7.a(r1, r1, r10);
        L20:
            if ((r7 instanceof QuickActionNameSpan) == true) goto L23;
            r11 = new IntRange(r0 + 1, r1);
            goto L25
        L28:
            IntRange r3 = new IntRange(r0 + 1, r1 - 1);
            if (r3.contains(r8) == false) goto L31;
            int r12 = r3.getFirst() - 1;
        L33:
            if (r3.contains(r9) == false) goto L35;
            int r13 = r3.getLast() + 1;
        L36:
            if (r12 != r8) goto L41;
            if (r13 == r9) goto L39;
        L41:
            return r7.a(r12, r13, r10);
        L35:
            r13 = r9;
            goto L36
        L31:
            r12 = r8;
            goto L33
        L13:
            r6 = false;
        L6:
            r4 = false;
            goto L8
        }
    }
}
