package eib;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import cib.f;
import com.ss.android.lark.forseti.widget.bean.ArrowDirection;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    @JvmStatic
    public static final dib.a a(Context r14, vua.a r15, int r16, int r17, int r18, int r19) {
        Intrinsics.checkNotNullParameter(r14, "context");
        if (r15 == null) goto L5;
        View r3 = r15.a;
    L6:
        if (r3 == null) goto L10;
        Rect r4 = new Rect();
        View r1 = r15.a;
        if (r1 == null) goto L14;
        r1.getGlobalVisibleRect(r4);
    L14:
        int r2 = f.a(r14, 12.0f);
        int r5 = f.a(r14, 24.0f);
        int r6 = f.a(r14, 18.0f);
        int r7 = r4.top;
        int r8 = r19 - r4.bottom;
        int r9 = r4.left;
        int r10 = r18 - r4.right;
        int r11 = r4.centerX();
        int r12 = r4.centerY();
        int r13 = r17 + r6;
        if (r7 < r13) goto L18;
        int r0 = RangesKt.coerceIn(r11 - (r16 / 2), 0, RangesKt.coerceAtLeast((r18 - r16) - r2, 0));
        return new dib.a(r0, (r4.top - r17) - r6, ArrowDirection.BOTTOM, r11 - r0, r12);
    L18:
        if (r8 < r13) goto L21;
        int r20 = RangesKt.coerceIn(r11 - (r16 / 2), 0, RangesKt.coerceAtLeast((r18 - r16) - r2, 0));
        return new dib.a(r20, r4.bottom + r6, ArrowDirection.TOP, r11 - r20, r12);
    L21:
        int r21 = r16 + r6;
        if (r9 < r21) goto L25;
        int r22 = RangesKt.coerceIn(r12 - (r17 / 2), 0, RangesKt.coerceAtLeast((r19 - r17) - r5, 0));
        return new dib.a((r4.left - r16) - r6, r22, ArrowDirection.RIGHT, r11, r12 - r22);
    L25:
        if (r10 < r21) goto L28;
        int r23 = RangesKt.coerceIn(r12 - (r17 / 2), 0, RangesKt.coerceAtLeast((r19 - r17) - r5, 0));
        return new dib.a(r4.right + r6, r23, ArrowDirection.LEFT, r11, r12 - r23);
    L28:
        Intrinsics.checkNotNullParameter(r14, "context");
        int r24 = (r18 - r16) / 2;
        int r25 = (r19 - r17) / 2;
        return new dib.a(r24, r25, ArrowDirection.NONE, (r16 / 2) + r24, (r17 / 2) + r25);
    L10:
        if (r15 == null) goto L13;
        r4 = r15.b;
        if (r4 != null) goto L14;
    L13:
        r4 = new Rect();
        goto L14
    L5:
        r3 = null;
        goto L6
    }
}
