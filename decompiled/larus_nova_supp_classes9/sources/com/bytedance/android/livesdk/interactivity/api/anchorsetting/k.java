package com.bytedance.android.livesdk.interactivity.api.anchorsetting;

import com.bytedance.android.live.broadcast.api.LivePrivilegeSettingApi;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.ui.LiveSwitchButton;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class k implements LiveSwitchButton.e {
    public final /* synthetic */ CommentSettingDialog a;

    public k(CommentSettingDialog r1) {
        this.a = r1;
    }

    public final void d0(LiveSwitchButton r5, boolean r6) {
        if (r6 == false) goto L5;
        this.a.S90(2131373872).setVisibility(0);
    L6:
        HashMap r0 = new HashMap();
        r0.put("user_id", jc1.k.n(IUserService.class).user().n());
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_anchor_danmu_open_button_click", r0, new Object[0]);
        com.bytedance.android.livesdk.sharedpref.e r7 = com.bytedance.android.livesdk.sharedpref.b.e1;
        Boolean r1 = Boolean.valueOf(r6);
        r7.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r7, r1);
        CommentSettingDialog r8 = this.a;
        int r2 = CommentSettingDialog.t;
        r8.getClass();
        Integer r9 = (Integer) com.bytedance.android.livesdk.sharedpref.b.f1.getValue();
        Integer r3 = (Integer) com.bytedance.android.livesdk.sharedpref.b.h1.getValue();
        Integer r4 = (Integer) com.bytedance.android.livesdk.sharedpref.b.g1.getValue();
        ((LivePrivilegeSettingApi) com.bytedance.android.live.network.c.b().e(LivePrivilegeSettingApi.class)).setPrivilegeBarrageSetting(r6, r9.intValue(), r3.intValue(), r4.intValue()).compose(RxUtil.rxSchedulerHelper()).subscribe(n.a, o.a);
        return;
    L5:
        this.a.S90(2131373872).setVisibility(8);
        goto L6
    }
}
