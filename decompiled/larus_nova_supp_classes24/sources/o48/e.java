package o48;

import com.larus.account.base.api.ILoginService;
import com.larus.account.base.model.GetOauthTokenTriggerScene;
import com.larus.account.base.model.LoginPlatform;
import com.larus.api.serviceimpl.auth.NormalLoginService;
import com.larus.api.serviceimpl.auth.NormalLoginService$c;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final /* synthetic */ class e implements Runnable {
    public final /* synthetic */ u64.a a;

    public /* synthetic */ e(u64.a r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        final u64.a r0 = this.a;
        int r1 = NormalLoginService.a;
        ILoginService r2 = (ILoginService) ServiceManager.get().getService(ILoginService.class);
        if (r2 == null) goto L6;
        r2.w(LoginPlatform.DOUYIN, false, GetOauthTokenTriggerScene.Request, new NormalLoginService$c(r0));
        return;
    }
}
