package ph;

import android.view.View;
import com.bytedance.android.ec.core.opt.ab.j;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void b(View r10) {
        if (r10 != null) goto L5;
    L6:
        if (r10 == null) goto L10;
        r10.setLayerType(2, null);
        return;
    L10:
        return;
    L5:
        if (r10.getLayerType() != 2) goto L6;
    }

    public static void a(View r1, boolean r10) {
        Intrinsics.checkNotNullParameter(r1, "view");
        if (j.a().g() == false) goto L15;
        if (r10 == false) goto L7;
        b(r1);
        return;
    L7:
        if (r1 == null) goto L9;
        Integer r0 = Integer.valueOf(r1.getLayerType());
    L11:
        if (r0.intValue() == 0) goto L17;
        if (r1 == null) goto L18;
        r1.setLayerType(0, null);
        return;
    L18:
        return;
    L17:
        return;
    L9:
        r0 = null;
        goto L11
    }

    public static void c(View r1, boolean r10) {
        Intrinsics.checkNotNullParameter(r1, "view");
        if (j.a().i() == false) goto L10;
        if (r10 == false) goto L7;
        b(r1);
        return;
    L7:
        if (Integer.valueOf(r1.getLayerType()).intValue() == 0) goto L12;
        r1.setLayerType(0, null);
        return;
    L12:
        return;
    }
}
