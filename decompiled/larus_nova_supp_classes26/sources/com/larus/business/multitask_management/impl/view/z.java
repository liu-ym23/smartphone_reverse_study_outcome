package com.larus.business.multitask_management.impl.view;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.utils.e1;
import com.larus.utils.o0;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class z implements jl9.a {
    public static final z a = null;

    static {
        a = new z();
    }

    public z() {
    }

    public final View a(jl9.b r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        return new OngoingTaskItemSingleIconView(r5.getContext(), null, 6, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v2, types: [android.view.ViewGroup, com.larus.business.multitask_management.impl.view.OngoingTaskItemSingleIconView] */
    /* JADX WARN: Type inference failed for: r7v4 */
    public final void b(View r7, jl9.b r8, final kl9.u r9) {
        Intrinsics.checkNotNullParameter(r7, "view");
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r9, "taskBasicInfo");
        if ((r7 instanceof OngoingTaskItemSingleIconView) == false) goto L5;
        final ?? r10 = (OngoingTaskItemSingleIconView) r7;
    L6:
        if (r10 == 0) goto L55;
        final Function2 r11 = r8.b;
        Intrinsics.checkNotNullParameter(r9, "item");
        TextView r0 = r10.a.e;
        kl9.x r2 = r9.i;
        String r3 = "";
        if (r2 == null) goto L12;
        String r4 = r2.a;
        if (r4 == null) goto L12;
    L13:
        r0.setText(r4);
        kl9.x r1 = r9.i;
        if (r1 == null) goto L19;
        String r5 = r1.b;
        if (r5 == null) goto L19;
        r3 = r5;
    L19:
        r10.a.c.setText(r3);
        TextView r6 = r10.a.c;
        if (o0.d(r3) == false) goto L22;
        int r12 = 0;
    L23:
        r6.setVisibility(r12);
        List r13 = r9.j;
        if (r13 == null) goto L36;
        Iterator r14 = r13.iterator();
    L27:
        if (r14.hasNext() == false) goto L34;
        Object r15 = r14.next();
        if (((kl9.p) r15) == null) goto L31;
        boolean r16 = true;
    L32:
        if (r16 == false) goto L27;
    L35:
        final kl9.p r17 = (kl9.p) r15;
    L37:
        r10.a.d.setVisibility(0);
        SimpleDraweeView r18 = r10.a.d;
        if (r17 == null) goto L40;
        String r19 = r17.a;
    L41:
        r18.setContentDescription(r19);
        Context r20 = r10.getContext();
        SimpleDraweeView r21 = r10.a.d;
        if (r17 == null) goto L44;
        String r22 = r17.b;
    L45:
        if (r17 == null) goto L47;
        String r23 = r17.c;
    L48:
        f.c(r20, r21, r22, r23, null);
        e1.d(r10.a.d, new y(r10, r11, r17, r9));
        return;
    L47:
        r23 = null;
        goto L48
    L44:
        r22 = null;
        goto L45
    L40:
        r19 = null;
        goto L41
    L31:
        r16 = false;
        goto L32
    L34:
        r15 = null;
        goto L35
    L36:
        r17 = null;
        goto L37
    L22:
        r12 = 8;
    L12:
        r4 = "";
        goto L13
    L55:
        return;
    L5:
        r10 = 0;
        goto L6
    }
}
