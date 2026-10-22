package com.ss.android.lark.location_ui.picklocation;

import android.app.Activity;
import android.text.TextUtils;
import com.larksuite.component.ui.toast.LKUIToast;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.location.dto.LarkLocation;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.statistics.Statistics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d implements com.ss.android.lark.location.service.g.a {
    public final /* synthetic */ LocationView.g a;
    public final /* synthetic */ e b;

    @Override // com.ss.android.lark.location.service.g.a
    public final void a(LarkLocation r9) {
        if (r9 != null) goto L5;
    L20:
        Log.e("LocationModel", "failed to startLocation. location is null or illegal.");
        if (r9 == null) goto L23;
        int r0 = r9.g;
        String r10 = r9.i;
    L24:
        LocationView.d r1 = (LocationView.d) this.a;
        r1.getClass();
        Log.i("LocationView", "onLocationFailed");
        if (kqb.d.a() == false) goto L28;
        Statistics.sendEvent("lark_message_location_google_poi_no_response");
    L28:
        if (r0 == 40100) goto L30;
    L32:
        Activity r11 = r1.a.b;
        LKUIToast.show(r11, UIUtils.getString(r11, 2131890390));
    L33:
        LocationView r12 = r1.a;
        String[] r2 = LocationView.y;
        r12.D(39.908823d, 116.39747d);
        return;
    L30:
        if (TextUtils.isEmpty(r10) == true) goto L32;
        UDToast.show(r1.a.b, r10);
        goto L33
    L23:
        r0 = -1;
        r10 = null;
        goto L24
    L5:
        if (r9.g != 0) goto L20;
        this.b.a.q0(r9.getLatitude(), r9.getLongitude());
        LocationView.g r3 = this.a;
        double r4 = this.b.a.t0();
        double r5 = this.b.a.r0();
        LocationView.d r6 = (LocationView.d) r3;
        r6.a.r = Double.valueOf(r4);
        r6.a.s = Double.valueOf(r5);
        r6.a.C();
        if (kqb.d.a() == false) goto L9;
    L11:
        r6.a.getClass();
        if (kqb.d.a() == true) goto L14;
    L16:
        boolean r7 = false;
    L17:
        if (r7 == false) goto L19;
        LocationView.o(r6.a);
    L19:
        Log.i("LocationModel", "onLocationChange, errorCode: " + r9.g);
        return;
    L14:
        if (com.ss.android.lark.location.service.f.a().isGmsEnabled() == true) goto L16;
        r7 = true;
        goto L17
    L9:
        if (com.ss.android.lark.location.service.f.a().isInHouse(r4, r5) == true) goto L11;
        Statistics.sendEvent("feishu_message_location_outside_mainlandchina");
        goto L11
    }

    public d(e r1, LocationView.d r2) {
        this.b = r1;
        this.a = r2;
    }
}
