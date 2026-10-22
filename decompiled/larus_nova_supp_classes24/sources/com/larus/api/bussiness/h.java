package com.larus.api.bussiness;

import com.bytedance.keva.Keva;
import com.larus.account.base.api.ILoginService;
import com.larus.account.base.model.LoginPlatform;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.dialog.p0;
import com.larus.platform.model.TriggerLoginScene;
import com.larus.platform.service.i3;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class h implements p0 {
    public final /* synthetic */ VideoChatFragment a;

    public final void confirm() {
        Keva r0 = a.a;
        a.a(AppHost.a.getAppClock().currentTimeMillis());
        i3 r1 = i3.a;
        if (r1.f() == false) goto L5;
        VideoChatFragment r2 = this.a;
        int r3 = VideoChatFragment.q;
        r2.getClass();
        r1.g(TriggerLoginScene.TRIGGER_LOGIN_TOURIST_AUTH);
        return;
    L5:
        VideoChatFragment r4 = this.a;
        int r5 = VideoChatFragment.q;
        r4.getClass();
        ILoginService r6 = (ILoginService) ServiceManager.get().getService(ILoginService.class);
        if (r6 == null) goto L10;
        ILoginService.a.d(r6, LoginPlatform.DOUYIN, new f(r4), null, false, null, 28);
        return;
    }

    public h(VideoChatFragment r1) {
        this.a = r1;
    }
}
