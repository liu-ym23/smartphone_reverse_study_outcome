package com.larus.api.bussiness;

import android.app.Application;
import android.os.Bundle;
import com.larus.account.base.api.ILoginService;
import com.larus.applog.api.IApplog;
import com.larus.common.apphost.AppHost;
import com.larus.platform.model.video.business.VideoFeedProviderDelegate;
import com.larus.platform.service.AccountService;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import n38.l;
import n38.m;
import org.json.JSONObject;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class f implements l {
    public final /* synthetic */ VideoChatFragment a;

    public static final class a implements m {
        public final /* synthetic */ VideoChatFragment a;

        public a(VideoChatFragment r1) {
            this.a = r1;
        }

        @Override // n38.m
        public final void onSuccess(String r1) {
            qr9.b r2 = VideoFeedProviderDelegate.b.getTopPlayerController();
            if (r2 == null) goto L6;
            r2.playPlayer();
            return;
        }

        @Override // n38.m
        public final void a(int r1, String r2, String r3, String r4) {
            if (r1 != 4048) goto L5;
            s r5 = s.a;
            AppHost.Companion r6 = AppHost.a;
            Application r7 = r6.getApplication();
            String r8 = r6.getApplication().getString(2131899061);
            r5.getClass();
            s.t(r7, r8);
            IApplog.Companion r9 = IApplog.a;
            JSONObject r10 = new JSONObject();
            this.a.getClass();
            r10.put("current_page", "");
            Unit r11 = Unit.INSTANCE;
            r9.reportEvent("account_risk_toast", r10);
        L5:
            qr9.b r12 = VideoFeedProviderDelegate.b.getTopPlayerController();
            if (r12 == null) goto L9;
            r12.playPlayer();
            return;
        }
    }

    public f(VideoChatFragment r1) {
        this.a = r1;
    }

    @Override // n38.l
    public final void a(String r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r4, "token");
        ILoginService.a.q(AccountService.a.J(), "aweme_v2", r4, new a(this.a));
    }

    @Override // n38.l
    public final void b(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "errorMsg");
        qr9.b r3 = VideoFeedProviderDelegate.b.getTopPlayerController();
        if (r3 == null) goto L6;
        r3.playPlayer();
        return;
    }
}
