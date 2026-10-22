package com.bytedance.android.livesdk.chatroom.vs_base.util;

import android.app.Activity;
import android.content.DialogInterface;
import com.bytedance.android.livehostapi.foundation.IMiddlewareHostApp;
import com.bytedance.android.livehostapi.foundation.depend.OnBindPhoneListener;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class e implements DialogInterface.OnClickListener {
    public final /* synthetic */ Activity a;
    public final /* synthetic */ String b;
    public final /* synthetic */ OnBindPhoneListener c;

    public e(Activity r1, OnBindPhoneListener r2) {
        this.a = r1;
        this.b = "send_message";
        this.c = r2;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r4, int r5) {
        r4.dismiss();
        Activity r6 = this.a;
        String r7 = this.b;
        OnBindPhoneListener r0 = this.c;
        jc1.k.f(IMiddlewareHostApp.class).startBindMobileFullFragment(r6, "live_detail", "live_detail", r0);
        HashMap r8 = new HashMap();
        r8.put("bind_page_source", r7);
        com.bytedance.android.livesdk.chatroom.vs_base.log.d.b.d("phone_bind_page_show", r8, new Object[0]);
    }
}
