package y82;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.livesdkapi.model.SeiRegion;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c {
    public static final void b(View r4, d r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        Intrinsics.checkNotNullParameter(r5, "layoutData");
        ViewGroup.LayoutParams r1 = r4.getLayoutParams();
        if ((r1 instanceof FrameLayout.LayoutParams) == true) goto L5;
        r1 = null;
    L5:
        FrameLayout.LayoutParams r2 = (FrameLayout.LayoutParams) r1;
        if (r2 != null) goto L8;
        return;
    L8:
        Intrinsics.checkNotNullParameter(r2, "params");
        Intrinsics.checkNotNullParameter(r5, "layoutData");
        int r0 = r2.width;
        int r3 = r5.a;
        if (r0 == r3) goto L11;
    L21:
        boolean r6 = false;
    L22:
        if (r6 == false) goto L24;
        return;
    L24:
        r2.width = r3;
        r2.height = r5.b;
        r2.leftMargin = r5.d;
        r2.rightMargin = r5.e;
        r2.topMargin = r5.c;
        r2.gravity = r5.f;
        r4.setLayoutParams(r2);
        return;
    L11:
        if (r2.height != r5.b) goto L21;
        if (r2.leftMargin != r5.d) goto L21;
        if (r2.rightMargin != r5.e) goto L21;
        if (r2.topMargin != r5.c) goto L21;
        if (r2.gravity != r5.f) goto L21;
        r6 = true;
        goto L22
    }

    public static final Integer a(int r8, int r9, List r10) {
        Intrinsics.checkNotNullParameter(r10, "windows");
        ArrayList r0 = new ArrayList();
        Iterator r11 = r10.iterator();
    L3:
        Double r2 = null;
        if (r11.hasNext() == false) goto L16;
        SeiRegion r1 = ((com.bytedance.android.livesdk.interactivity.medialink.ui.a) r11.next()).getMSeiRegion();
        if (r1 != null) goto L9;
    L14:
        if (r2 == null) goto L3;
        r0.add(r2);
        goto L3
    L9:
        if (r1.getWidth() == 0.0d) goto L14;
        if (r1.getHeight() == 0.0d) goto L14;
        r2 = Double.valueOf(r1.getY());
        goto L14
    L16:
        Double r13 = (Double) CollectionsKt.firstOrNull(CollectionsKt.sorted(r0));
        if (r13 != null) goto L19;
        return null;
    L19:
        return Integer.valueOf((int) ((r13.doubleValue() * ((double) r9)) + ((double) r8)));
    }
}
