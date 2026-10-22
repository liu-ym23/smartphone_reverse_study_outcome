package com.bytedance.android.livesdk.interactivity.api.anchorsetting;

import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.ui.LiveSwitchButton;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import java.util.HashMap;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g implements LiveSwitchButton.e {
    public final /* synthetic */ CommentSettingDialog a;

    public g(CommentSettingDialog r1) {
        this.a = r1;
    }

    public final void d0(LiveSwitchButton r10, boolean r11) {
        String r0 = "0";
        if (r11 == false) goto L13;
        com.bytedance.android.livesdk.sharedpref.e r13 = com.bytedance.android.livesdk.sharedpref.b.c1;
        r13.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r13, 1);
        f2.b(2131922278, 0);
        AudioCommentApi.a.a((AudioCommentApi) com.bytedance.android.live.network.c.b().e(AudioCommentApi.class), this.a.h, 30, 0).compose(RxUtil.rxSchedulerHelper()).subscribe(new com.bytedance.android.livesdk.user.h());
        com.bytedance.android.livesdk.log.g r14 = com.bytedance.android.livesdk.log.u.l();
        HashMap r6 = new HashMap();
        IUserService r7 = jc1.k.f(IUserService.class);
        if (r7 == null) goto L12;
        com.bytedance.android.livesdk.user.f r8 = r7.user();
        if (r8 == null) goto L12;
        String r9 = r8.n();
        if (r9 == null) goto L12;
        r0 = r9;
    L12:
        r6.put("anchor_id", r0);
        r6.put("set_result", "on");
        Unit r15 = Unit.INSTANCE;
        r14.sendLog("livesdk_chat_channel_anchor_set", r6, new Object[]{new am2.x(), Room.class});
        return;
    L13:
        com.bytedance.android.livesdk.sharedpref.e r16 = com.bytedance.android.livesdk.sharedpref.b.c1;
        r16.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r16, 2);
        f2.b(2131922273, 0);
        AudioCommentApi.a.a((AudioCommentApi) com.bytedance.android.live.network.c.b().e(AudioCommentApi.class), this.a.h, 31, 0).compose(RxUtil.rxSchedulerHelper()).subscribe(new com.bytedance.android.livesdk.user.h());
        com.bytedance.android.livesdk.log.g r17 = com.bytedance.android.livesdk.log.u.l();
        HashMap r18 = new HashMap();
        IUserService r19 = jc1.k.f(IUserService.class);
        if (r19 == null) goto L21;
        com.bytedance.android.livesdk.user.f r20 = r19.user();
        if (r20 == null) goto L21;
        String r21 = r20.n();
        if (r21 == null) goto L21;
        r0 = r21;
    L21:
        r18.put("anchor_id", r0);
        r18.put("set_result", "off");
        Unit r110 = Unit.INSTANCE;
        r17.sendLog("livesdk_chat_channel_anchor_set", r18, new Object[]{new am2.x(), Room.class});
    }
}
