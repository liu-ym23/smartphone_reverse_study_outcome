package com.bytedance.android.livesdk.interactivity.publicscreen.ui;

import am2.x;
import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.PublicScreenStyleHelper;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e implements View.OnClickListener {
    public final /* synthetic */ AnchorPublicScreenConfigDialog a;

    public e(AnchorPublicScreenConfigDialog r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r10) {
        AnchorPublicScreenConfigDialog r11 = this.a;
        int r0 = AnchorPublicScreenConfigDialog.B;
        Map<String, String> r1 = r11.S90();
        int r2 = r11.t;
        int r3 = PublicScreenStyleHelper.a;
        String r4 = "standard";
        boolean r6 = true;
        if (r2 == 1) goto L7;
        if (r2 == 2) goto L6;
        Object r5 = "standard";
    L8:
        HashMap r7 = (HashMap) r1;
        r7.put("height_setting_before", r5);
        int r8 = r11.v;
        if (r8 == 1) goto L13;
        if (r8 != 2) goto L14;
        r4 = "high";
    L14:
        r7.put("height_setting_after", r4);
        int r9 = r11.t;
        float r13 = 14.0f;
        if (r9 == 1) goto L19;
        if (r9 == 2) goto L18;
        float r14 = 14.0f;
    L20:
        r7.put("Font_size_before", String.valueOf((int) r14));
        int r15 = r11.u;
        if (r15 == 1) goto L25;
        if (r15 != 2) goto L26;
        r13 = 18.0f;
    L26:
        r7.put("Font_size_after", String.valueOf((int) r13));
        j0.l().sendLog("livesdk_anchor_screen_message_setting_finish_click", r1, new Object[]{IRoom.class, x.class});
        r11.dismiss();     // Catch: Exception -> L29
    L33:
        int r16 = r11.u;
        Integer r17 = null;
        if (r16 == r11.s) goto L44;
        int r18 = PublicScreenStyleHelper.a;
        if (r16 < 0) goto L40;
        if (2 < r16) goto L40;
    L41:
        if (r6 == false) goto L43;
        com.bytedance.android.livesdk.sharedpref.e<Integer> r19 = PublicScreenStyleHelper.o;
        Integer r20 = Integer.valueOf(r16);
        r19.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r19, r20);
        PublicScreenStyleHelper.q = r16;
    L43:
        Integer r21 = Integer.valueOf(r11.u);
    L45:
        int r23 = r11.v;
        if (r23 == r11.t) goto L48;
        PublicScreenStyleHelper.f(r23);
        r17 = Integer.valueOf(r11.v);
    L48:
        com.bytedance.android.livesdk.interactivity.api.publicscreen.a.InterfaceC0093a r110 = r11.d;
        if (r110 == null) goto L51;
        r110.a(r21, r17);
    L51:
        ALogger.i("AnchorPublicScreenConfigDialog", "onComplete. fonSizeLevel=" + r21 + " heightLevel=" + r17);
        return;
    L40:
        r6 = false;
        goto L41
    L44:
        r21 = null;
    L29:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r24 = DialogFragmentLancet.sLastShowStack;
        if (r24 == null) goto L33;
        com.bytedance.crash.d.d(r24, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L33
    L25:
        r13 = 16.0f;
        goto L26
    L18:
        r14 = 18.0f;
        goto L20
    L19:
        r14 = 16.0f;
        goto L20
    L13:
        r4 = "middle";
        goto L14
    L6:
        r5 = "high";
        goto L8
    L7:
        r5 = "middle";
        goto L8
    }
}
