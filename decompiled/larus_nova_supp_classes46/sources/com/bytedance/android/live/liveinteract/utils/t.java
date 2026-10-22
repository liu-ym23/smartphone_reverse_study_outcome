package com.bytedance.android.live.liveinteract.utils;

import android.app.Activity;
import android.content.DialogInterface;
import com.bytedance.android.livehostapi.foundation.IMiddlewareHostApp;
import com.bytedance.android.livehostapi.foundation.depend.OnBindPhoneListener;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class t implements DialogInterface.OnClickListener {
    public final /* synthetic */ Activity a;
    public final /* synthetic */ String b;
    public final /* synthetic */ int c;
    public final /* synthetic */ OnBindPhoneListener d;

    public t(Activity r1, int r2, qh0.h.b r3) {
        this.a = r1;
        this.b = "guest_connection";
        this.c = r2;
        this.d = r3;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r12, int r13) {
        r12.dismiss();
        HashMap r14 = new HashMap();
        r14.put("verify_type", "phone");
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_guest_connection_verify_popup_click", r14, new Object[]{IRoom.class, new am2.x()});
        int r15 = u.a;
        Activity r6 = this.a;
        String r16 = this.b;
        int r17 = this.c;
        OnBindPhoneListener r10 = this.d;
        if (r17 != 20089) goto L8;
        IMiddlewareHostApp r18 = jc1.k.f(IMiddlewareHostApp.class);
        if (r18 == null) goto L15;
        r18.startBindMobileFullFragment(r6, "live_detail", "live_detail", r10);
    L15:
        HashMap r19 = new HashMap();
        r19.put("bind_page_source", r16);
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_phone_bind_page_show", r19, new Object[]{new am2.x(), IRoom.class});
        return;
    L8:
        if (r17 != 4002168) goto L12;
        IMiddlewareHostApp r5 = jc1.k.f(IMiddlewareHostApp.class);
        if (r5 == null) goto L15;
        r5.startBindSafeMobileFullFragment(r6, "live_detail", "live_detail", null, r10);
        goto L15
    L12:
        IMiddlewareHostApp r110 = jc1.k.f(IMiddlewareHostApp.class);
        if (r110 == null) goto L15;
        r110.startBindMobileFullFragment(r6, "live_detail", "live_detail", r10);
        goto L15
    }
}
