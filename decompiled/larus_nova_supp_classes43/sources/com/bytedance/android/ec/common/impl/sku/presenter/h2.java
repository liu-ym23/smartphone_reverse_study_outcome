package com.bytedance.android.ec.common.impl.sku.presenter;

import android.view.View;
import com.bytedance.android.ec.core.widget.StatusView;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class h2<T> implements Observer {
    public final /* synthetic */ m2 a;
    public final /* synthetic */ Ref.ObjectRef b;

    public h2(m2 r1, Ref.ObjectRef r10) {
        this.a = r1;
        this.b = r10;
    }

    public final void onChanged(Object r10) {
        rg.b r11 = (rg.b) r10;
        StatusView r0 = (StatusView) this.a.Z().b(2131387797).f();
        int r1 = g2.a[r11.a.ordinal()];
        if (r1 != 1) goto L5;
        this.a.Z().b(2131378873).f().setVisibility(4);
        r0.showLoading();
        return;
    L5:
        if (r1 != 2) goto L7;
        this.a.Z().b(2131378873).f().setVisibility(0);
        r0.reset();
        return;
    L7:
        if (r1 != 3) goto L39;
        this.a.Z().b(2131378873).f().setVisibility(4);
        if (r11.b != 0) goto L12;
    L23:
        View r12 = (View) this.b.element;
        if (r12 == null) goto L28;
        View r13 = r12.findViewById(2131390547);
        if (r13 == null) goto L28;
        r13.setVisibility(0);
    L28:
        View r14 = (View) this.b.element;
        if (r14 == null) goto L33;
        View r15 = r14.findViewById(2131390548);
        if (r15 == null) goto L33;
        r15.setVisibility(0);
    L33:
        r0.setVisibility(0);
        r0.setECStatus(2);
        return;
    L12:
        if (com.bytedance.android.ec.core.abtest.d.v().contains(Double.valueOf(r11.b)) == false) goto L23;
        View r16 = (View) this.b.element;
        if (r16 == null) goto L18;
        View r17 = r16.findViewById(2131390547);
        if (r17 == null) goto L18;
        r17.setVisibility(8);
    L18:
        View r18 = (View) this.b.element;
        if (r18 == null) goto L33;
        View r19 = r18.findViewById(2131390548);
        if (r19 == null) goto L33;
        r19.setVisibility(8);
        goto L33
    }
}
