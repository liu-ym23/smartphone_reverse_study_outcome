package com.ss.android.lark.locationmessage.ui.navigation;

import com.ss.android.lark.biz.im.api.LocationInfo;
import com.ss.android.lark.location.dto.LarkLocation;
import com.ss.android.lark.statistics.Statistics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class f implements com.ss.android.lark.location.service.g.a {
    public final /* synthetic */ NavigateView.a a;
    public final /* synthetic */ g b;

    @Override // com.ss.android.lark.location.service.g.a
    public final void a(LarkLocation r12) {
        if (r12 != null) goto L4;
    L24:
        ((u) this.a).getClass();
        if (lqb.b.a.isGooglePlay() == false) goto L31;
        Statistics.sendEvent("lark_message_location_google_poi_no_response");
        return;
    L31:
        return;
    L4:
        if (r12.g != 0) goto L24;
        g r0 = this.b;
        r0.a = new cqb.a(r12.getLatitude(), r12.getLongitude());
        NavigateView.a r13 = this.a;
        cqb.a r1 = this.b.a;
        double r2 = r1.a;
        double r3 = r1.b;
        u r14 = (u) r13;
        NavigateView r4 = r14.b;
        r4.k = Double.valueOf(r2);
        NavigateView r5 = r14.b;
        r5.l = Double.valueOf(r3);
        NavigateView r6 = r14.b;
        r6.o.a(r6.k.doubleValue(), r14.b.l.doubleValue());
        if (r14.a == false) goto L8;
        NavigateView r7 = r14.b;
        r7.o.l(r7.k.doubleValue(), r14.b.l.doubleValue());
    L8:
        NavigateView r8 = r14.b;
        LocationInfo r9 = r8.i;
        double r10 = r8.k.doubleValue();
        double r11 = r14.b.l.doubleValue();
        boolean r15 = false;
        if (r9 != null) goto L12;
    L16:
        if (r15 == false) goto L18;
        r14.b.mIvLocatePosition.setImageResource(2131243869);
    L20:
        if (lqb.b.a.isGooglePlay() == false) goto L22;
        return;
    L22:
        if (com.ss.android.lark.location.service.f.a().isInHouse(r2, r3) == true) goto L29;
        Statistics.sendEvent("feishu_message_location_outside_mainlandchina");
        return;
    L29:
        return;
    L18:
        r14.b.mIvLocatePosition.setImageResource(2131243878);
        goto L20
    L12:
        if (oqb.b.a(r9.getLatitude(), r10) == false) goto L16;
        if (oqb.b.a(r9.getLongitude(), r11) == false) goto L16;
        r15 = true;
        goto L16
    }

    public f(g r1, u r2) {
        this.b = r1;
        this.a = r2;
    }
}
