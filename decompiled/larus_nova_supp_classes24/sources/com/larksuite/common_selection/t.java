package com.larksuite.common_selection;

import android.view.View;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class t {
    public static final t a = null;
    public static final List<s> b = null;
    public static final x c = null;

    public t() {
    }

    static {
        a = new t();
        ArrayList r0 = new ArrayList();
        b = r0;
        c = new x();
        x r1 = new x();
        Intrinsics.checkNotNullParameter(r1, "strategy");
        ListProtector.add(r0, 0, r1);
        u r2 = new u();
        Intrinsics.checkNotNullParameter(r2, "strategy");
        ListProtector.add(r0, 0, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static s a(View r4) {
        Object r0 = null;
        if (r4 != 0) goto L6;
        return null;
    L6:
        if ((r4 instanceof f) == true) goto L8;
        Iterator r1 = ((ArrayList) b).iterator();
    L11:
        if (r1.hasNext() == false) goto L16;
        Object r2 = r1.next();
        if (((s) r2).h(r4) == false) goto L11;
        r0 = r2;
    L16:
        return (s) r0;
    L8:
        return ((f) r4).getSelectionStrategy();
    }
}
