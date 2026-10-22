package com.bytedance.android.live.liveinteract.floatwindow.dialog;

import am2.x;
import android.view.View;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.HashMap;
import xe0.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ BaseLinkmicFloatWindowRetainDialog a;

    public a(BaseLinkmicFloatWindowRetainDialog r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r6) {
        BaseLinkmicFloatWindowRetainDialog r7 = this.a;
        r7.findViewById(2131383716).setChecked(!r7.findViewById(2131383716).isChecked());
        boolean r1 = k.a;
        boolean r8 = r7.findViewById(2131383716).isChecked();
        HashMap r0 = new HashMap();
        if (r8 == false) goto L5;
        String r9 = "on";
    L6:
        r0.put("switch_status", r9);
        Integer r10 = (Integer) ((ge1.a) hd0.c.f()).b;
        if (r10 != null) goto L10;
    L12:
        if (r10 != null) goto L15;
    L17:
        String r11 = PbRequest.SwitchType.OTHER;
    L18:
        r0.put("link_status", r11);
        j0.l().sendLog("livesdk_audience_apply_reserve_autoopen_click", r0, new Object[]{IRoom.class, x.class});
        return;
    L15:
        if (r10.intValue() != 1) goto L17;
        r11 = "apply";
        goto L18
    L10:
        if (r10.intValue() != 2) goto L12;
        r11 = "link";
        goto L18
    L5:
        r9 = "off";
        goto L6
    }
}
