package o48;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.fragment.app.FragmentActivity;
import com.larus.account.base.api.IAccountService;
import com.larus.account.base.api.ILoginService;
import com.larus.account.base.model.SettingsAccountInfo;
import com.larus.account.base.model.SettingsConnectAccountInfo;
import com.larus.api.serviceimpl.auth.NormalLoginService;
import com.larus.applog.api.IApplog;
import com.larus.login.api.ILoginApi;
import com.larus.login.api.SwitchBindParam;
import com.larus.login.api.i0;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import tx9.w0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class k implements n38.l {
    public final /* synthetic */ u64.c a;
    public final /* synthetic */ NormalLoginService b;
    public final /* synthetic */ Activity c;

    public static final class a implements n38.m {
        public final /* synthetic */ u64.c a;
        public final /* synthetic */ NormalLoginService b;
        public final /* synthetic */ Activity c;

        @Override // n38.m
        public final void onSuccess(String r3) {
            FLogger r4 = FLogger.a;
            StringBuilder r0 = new StringBuilder("bindDouYinUseAndroidClientKey bindPlatform success:---");
            SettingsAccountInfo r1 = IAccountService.a.w();
            if (r1 == null) goto L7;
            List<SettingsConnectAccountInfo> r2 = r1.b();
            if (r2 == null) goto L7;
            Integer r5 = Integer.valueOf(r2.size());
        L8:
            r0.append(r5);
            r4.i("NormalLoginService", r0.toString());
            this.a.onSuccess(true);
            w0.e("success");
            return;
        L7:
            r5 = null;
            goto L8
        }

        public a(u64.c r1, NormalLoginService r2, Activity r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // n38.m
        public final void a(int r8, final String r9, String r10, String r11) {
            FLogger.a.e("NormalLoginService", "bindDouYinUseAndroidClientKey bindPlatform onFailed:---errorCode:" + r8 + "----errorMsg:" + r9);
            if (r8 != 1030) goto L5;
            NormalLoginService r12 = this.b;
            FragmentActivity r13 = this.c;
            if (r11 != null) goto L11;
            r11 = "";
        L11:
            String r1 = r11;
            final u64.c r14 = this.a;
            int r15 = NormalLoginService.a;
            r12.getClass();
            if ((r13 instanceof FragmentActivity) == false) goto L14;
            FragmentActivity r16 = r13;
        L15:
            if (r16 == null) goto L22;
            ILoginApi r17 = (ILoginApi) ServiceManager.get().getService(ILoginApi.class);
            if (r17 == null) goto L23;
            List r0 = i0.a;
            r17.F(r16, new SwitchBindParam(r1, "8943", "aweme_v2", "douyin_account_bind_popup_click", "chat", 96), new h(r14));
            return;
        L23:
            return;
        L22:
            return;
        L14:
            r16 = null;
            goto L15
        L5:
            if (r8 == 4048) goto L7;
            Handler r19 = new Handler(Looper.getMainLooper());
            final Activity r110 = this.c;
            r19.post(new j(r110, r9));
            this.a.onSuccess(false);
            w0.e("fail");
            return;
        L7:
            new Handler(Looper.getMainLooper()).post(new i());
            IApplog.a.reportEvent("account_risk_toast", new JSONObject());
        }
    }

    @Override // n38.l
    public final void a(String r6, Bundle r7) {
        Intrinsics.checkNotNullParameter(r6, "token");
        ILoginService.a.q(AccountService.a.J(), "aweme_v2", r6, new a(this.a, this.b, this.c));
    }

    @Override // n38.l
    public final void b(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "errorMsg");
        this.a.onSuccess(false);
        FLogger.a.d("NormalLoginService", "bindDouYinUseAndroidClientKey onTokenUpdateFailed:---errorMsg：".concat(r2));
    }

    public k(u64.c r1, NormalLoginService r2, Activity r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
