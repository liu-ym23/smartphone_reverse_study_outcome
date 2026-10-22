package com.ss.android.lark.locationmessage.ui.navigation;

import com.larksuite.component.universe_design.toast.UDToast;
import com.ss.android.lark.biz.im.api.LocationInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class s extends kqb.a {
    public final /* synthetic */ NavigateView b;

    @Override // kqb.a
    public final void a() {
        if (this.b.d.isAdminGpsEnabled() == true) goto L6;
        UDToast.show(this.b.b, 2131890566);
        return;
    L6:
        NavigateView r0 = this.b;
        Double r1 = r0.k;
        if (r1 != null) goto L9;
    L21:
        r0.h(new r(this));
        return;
    L9:
        if (r0.l == null) goto L21;
        r0.o.l(r1.doubleValue(), this.b.l.doubleValue());
        NavigateView r2 = this.b;
        LocationInfo r3 = r2.i;
        double r4 = r2.k.doubleValue();
        double r5 = this.b.l.doubleValue();
        boolean r6 = false;
        if (r3 != null) goto L14;
    L18:
        if (r6 == false) goto L20;
        this.b.mIvLocatePosition.setImageResource(2131243869);
        return;
    L20:
        this.b.mIvLocatePosition.setImageResource(2131243878);
        return;
    L14:
        if (oqb.b.a(r3.getLatitude(), r4) == false) goto L18;
        if (oqb.b.a(r3.getLongitude(), r5) == false) goto L18;
        r6 = true;
        goto L18
    }

    public s(NavigateView r1) {
        this.b = r1;
    }
}
