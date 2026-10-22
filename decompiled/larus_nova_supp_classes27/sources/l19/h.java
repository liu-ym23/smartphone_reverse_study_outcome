package l19;

import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.GenericDraweeView;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class h {
    static {
    }

    @JvmStatic
    public static final Rect a(View r13) {
        Intrinsics.checkNotNullParameter(r13, "view");
        if ((r13 instanceof GenericDraweeView) == false) goto L5;
        GenericDraweeView r1 = (GenericDraweeView) r13;
    L7:
        if (r1 == null) goto L11;
        GenericDraweeHierarchy r2 = r1.getHierarchy();
        if (r2 == null) goto L11;
        RectF r3 = new RectF();
        r2.getActualImageBounds(r3);
        int r4 = (int) r3.width();
        int r5 = (int) r3.height();
    L12:
        if (r5 == 0) goto L14;
        if (r4 == 0) goto L14;
    L15:
        int[] r6 = {r4, r5};
        Intrinsics.checkNotNullParameter(r13, "view");
        Intrinsics.checkNotNullParameter(r6, "photoWidthHeight");
        int r7 = r6[0];
        int r8 = r6[1];
        Intrinsics.checkNotNullParameter(r13, "view");
        int[] r0 = new int[2];
        int r9 = r13.getWidth();
        int r10 = r13.getHeight();
        r13.getLocationOnScreen(r0);
        int[] r11 = {r0[0] + (r9 / 2), r0[1] + (r10 / 2)};
        Rect r14 = new Rect();
        float r12 = r7;
        float r15 = r8;
        float r16 = r12 / r15;
        float r17 = r9;
        float r18 = r10;
        if ((r17 / r18) >= r16) goto L18;
        int r20 = r11[0];
        int r21 = ((int) (r18 * r16)) / 2;
        int r22 = r0[1];
        r14.set(r20 - r21, r22, r20 + r21, r10 + r22);
    L19:
        return r14;
    L18:
        int r23 = r0[0];
        int r24 = r11[1];
        int r25 = ((int) (r17 * (r15 / r12))) / 2;
        r14.set(r23, r24 - r25, r9 + r23, r24 + r25);
    L14:
        r4 = r13.getWidth();
        r5 = r13.getHeight();
    L11:
        r4 = 0;
        r5 = 0;
        goto L12
    L5:
        r1 = null;
        goto L7
    }
}
