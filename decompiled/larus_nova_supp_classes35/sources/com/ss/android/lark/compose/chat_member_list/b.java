package com.ss.android.lark.compose.chat_member_list;

import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.PopupPositionProvider;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b implements PopupPositionProvider {
    public static final b a = null;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[LayoutDirection.values().length];
            r0[LayoutDirection.Ltr.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[LayoutDirection.Rtl.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    static {
        a = new b();
    }

    public b() {
    }

    /* JADX INFO: renamed from: calculatePosition-llwVHH4, reason: not valid java name */
    public final long m772calculatePositionllwVHH4(IntRect r6, long r7, LayoutDirection r9, long r10) {
        Intrinsics.checkNotNullParameter(r6, "anchorBounds");
        Intrinsics.checkNotNullParameter(r9, "layoutDirection");
        int r11 = a.a[r9.ordinal()];
        if (r11 != 1) goto L5;
        int r12 = r6.getRight() - ((int) (r10 >> 32));
    L10:
        int r13 = RangesKt.coerceIn(r12, 0, RangesKt.coerceAtLeast(((int) (r7 >> 32)) - ((int) (r10 >> 32)), 0));
        int r8 = RangesKt.coerceIn(r6.getBottom(), 0, RangesKt.coerceAtLeast(((int) (r7 & 4294967295L)) - ((int) (r10 & 4294967295L)), 0));
        return IntOffset.constructor-impl((((long) r13) << 32) | (((long) r8) & 4294967295L));
    L5:
        if (r11 != 2) goto L8;
        r12 = r6.getLeft();
        goto L10
    L8:
        throw new NoWhenBranchMatchedException();
    }
}
