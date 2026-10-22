package o48;

import com.larus.account.base.api.ILoginService;
import com.larus.account.base.model.GetOauthTokenTriggerScene;
import com.larus.account.base.model.LoginPlatform;
import com.larus.api.serviceimpl.auth.AoLoginBaseServiceImpl;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final /* synthetic */ class a implements Runnable {
    public final /* synthetic */ u64.a a;

    public /* synthetic */ a(com.bytedance.awemeopen.domain.user.login.b r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        u64.a r0 = this.a;
        int r1 = AoLoginBaseServiceImpl.a;
        ILoginService r2 = (ILoginService) ServiceManager.get().getService(ILoginService.class);
        if (r2 == null) goto L6;
        r2.w(LoginPlatform.DOUYIN, false, GetOauthTokenTriggerScene.Request, new b(r0));
        return;
    }
}
