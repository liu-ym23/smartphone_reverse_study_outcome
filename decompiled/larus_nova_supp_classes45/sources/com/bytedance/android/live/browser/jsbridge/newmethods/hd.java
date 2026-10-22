package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.content.Context;
import android.content.DialogInterface;
import com.bytedance.android.live.browser.BrowserServiceImpl;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.annotations.SerializedName;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import javax.inject.Inject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "commercialComponentOperation")
public final class hd extends com.bytedance.ies.web.jsbridge2.f<a, Object> {

    @Inject
    public com.bytedance.android.live.browser.v a;

    public static final class a {

        @SerializedName("card_id")
        String cardId;

        @SerializedName("room_id")
        String roomId;

        @SerializedName("type")
        int type;

        public a() {
        }
    }

    public final void onTerminate() {
    }

    public hd() {
        BrowserServiceImpl.Companion.getClass();
        this.a = (com.bytedance.android.live.browser.v) ((s20.b) BrowserServiceImpl.access$getDiComponent$cp()).a().a.e.get();
    }

    public final void invoke(Object r5, CallContext r6) throws Exception {
        a r7 = (a) r5;
        xs2.b.a().post(new com.bytedance.android.livesdk.event.h0(r7.type));
        if (r7.type != 4) goto L19;
        Context r8 = r6.getContext();
        com.bytedance.android.livesdk.widget.x0.d r9 = new com.bytedance.android.livesdk.widget.x0.d();
        r9.b = r8;
        r9.a = 4;
        r9.c = r9.b.getText(2131922671);
        r9.d = r9.b.getText(2131920732);
        String r11 = com.bytedance.android.live.core.utils.s1.B(2131922059);
        DialogInterface.OnClickListener r0 = new fd(this);
        com.bytedance.android.livesdk.widget.x0.c[] r1 = r9.g;
        com.bytedance.android.livesdk.widget.x0.c r3 = r1[0];
        if (r3 != null) goto L7;
        r3 = new com.bytedance.android.livesdk.widget.x0.c();
        r1[0] = r3;
    L7:
        r3.a = r11;
        r3.b = r0;
        String r12 = com.bytedance.android.live.core.utils.s1.B(2131922826);
        DialogInterface.OnClickListener r2 = new gd(this);
        com.bytedance.android.livesdk.widget.x0.c[] r4 = r9.g;
        com.bytedance.android.livesdk.widget.x0.c r13 = r4[1];
        if (r13 != null) goto L10;
        r13 = new com.bytedance.android.livesdk.widget.x0.c();
        r4[1] = r13;
    L10:
        r13.a = r12;
        r13.b = r2;
        com.bytedance.android.livesdk.widget.x0 r14 = new com.bytedance.android.livesdk.widget.x0(r9.b, r9);
        if (DialogLancet.shouldBlockDialogShow(r14) == false) goto L17;
        DialogLancet.handleBlockedDialogShow(r14);
        return;
    L17:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L16
    L14:
        DialogLancet.beforeDialogShow(r14);
        r14.show();
        DialogLancet.afterDialogShow(r14);
        return;
    }
}
