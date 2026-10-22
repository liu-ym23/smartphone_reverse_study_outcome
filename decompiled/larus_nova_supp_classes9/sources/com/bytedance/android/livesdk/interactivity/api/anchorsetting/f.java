package com.bytedance.android.livesdk.interactivity.api.anchorsetting;

import android.widget.RadioGroup;
import com.bytedance.android.live.user.IUserService;
import java.util.HashMap;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f implements RadioGroup.OnCheckedChangeListener {
    public final /* synthetic */ CommentSettingDialog a;

    public f(CommentSettingDialog r1) {
        this.a = r1;
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public final void onCheckedChanged(RadioGroup r5, int r6) {
        CommentSettingDialog r7 = this.a;
        Integer r8 = r7.n.get(Integer.valueOf(r6));
        if (r8 == null) goto L5;
        int r9 = r8.intValue();
    L6:
        r7.q = r9;
        CommentSettingDialog r10 = this.a;
        r10.getClass();
        com.bytedance.android.livesdk.log.g r11 = com.bytedance.android.livesdk.log.u.l();
        HashMap r0 = new HashMap();
        r0.put("enter_from_merge", "direct_shoot");
        r0.put("enter_method", "live_anchor_setting_page");
        r0.put("anchor_id", jc1.k.n(IUserService.class).user().n());
        r0.put("room_id", String.valueOf(r10.h));
        Integer r1 = (Integer) com.bytedance.android.livesdk.sharedpref.b.W0.getValue();
        if (r1 != null) goto L10;
    L12:
        if (r1 != null) goto L15;
    L17:
        if (r1 != null) goto L20;
    L22:
        String r2 = "null";
    L23:
        r0.put("group", r2);
        if (r10.j == false) goto L26;
        String r3 = "1";
    L27:
        r0.put("is_paidlive", r3);
        r0.put("ticket_id", String.valueOf(r10.k));
        r0.put("ticket_name", r10.l);
        Unit r13 = Unit.INSTANCE;
        r11.sendLog("livesdk_anchor_comment_group_click", r0, new Object[0]);
        return;
    L26:
        r3 = "0";
        goto L27
    L20:
        if (r1.intValue() != 5) goto L22;
        r2 = "fans";
        goto L23
    L15:
        if (r1.intValue() != 3) goto L17;
        r2 = "follow";
        goto L23
    L10:
        if (r1.intValue() != 9) goto L12;
        r2 = "all";
        goto L23
    L5:
        r9 = this.a.q;
        goto L6
    }
}
