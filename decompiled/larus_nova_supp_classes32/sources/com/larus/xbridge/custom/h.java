package com.larus.xbridge.custom;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import com.ivy.ivykit.api.bridge.core.IvyBridgeMethod;
import com.larus.account.base.api.ILoginService;
import com.larus.applog.api.IApplog;
import com.larus.common.apphost.AppHost;
import com.larus.login.api.DouyinConversationAuthService;
import com.larus.login.api.DouyinConversationAuthTriggerScene;
import com.larus.login.api.ILoginApi;
import com.larus.login.api.SwitchBindParam;
import com.larus.utils.logger.FLogger;
import com.lynx.jsbridge.LynxResourceModule;
import com.obric.aivoice.core.data.NameKeys;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class h implements n38.l {
    public final /* synthetic */ IvyBridgeMethod.a a;
    public final /* synthetic */ f b;

    public static final class a implements n38.m {
        public final /* synthetic */ IvyBridgeMethod.a a;
        public final /* synthetic */ f b;

        public final void onSuccess(String r6) {
            FragmentActivity r7 = AppHost.a.a().getCurrentActivity();
            if ((r7 instanceof FragmentActivity) == false) goto L5;
            final FragmentActivity r8 = r7;
        L6:
            DouyinConversationAuthService.a.b(DouyinConversationAuthTriggerScene.ACCOUNT_BIND);
            IvyBridgeMethod.a r0 = this.a;
            LinkedHashMap r1 = new LinkedHashMap();
            r1.put(LynxResourceModule.CODE_KEY, 1);
            LinkedHashMap r2 = new LinkedHashMap();
            r2.put("success", 1);
            Unit r3 = Unit.INSTANCE;
            r1.put(LynxResourceModule.DATA_KEY, r2);
            r0.invoke(r1);
            if (r8 == null) goto L18;
            Window r4 = r8.getWindow();
            if (r4 == null) goto L19;
            View r5 = r4.getDecorView();
            if (com.larus.home.impl.utils.c.e == false) goto L15;
            FLogger.a.i("DecorViewLancet", "getDecorView");
            Thread r9 = ThreadMethodProxy.currentThread();
            if (r9 == com.larus.home.impl.utils.c.a) goto L15;
            com.larus.home.impl.utils.c.a(r9, "getDecorView");
        L15:
            if (r5 == null) goto L20;
            r5.post(new g(r8));
            return;
        L20:
            return;
        L19:
            return;
        L18:
            return;
        L5:
            r8 = null;
            goto L6
        }

        public a(IvyBridgeMethod.a r1, f r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a(final int r23, String r24, String r25, String r26) {
            final String r2 = r24;
            FLogger r3 = FLogger.a;
            r3.i("AppBindPlatformMethod", "bindPlatform onFailed, errorCode = " + r23 + ", errorMsg = " + r2);
            if (r23 != 1030) goto L18;
            f r7 = this.b;
            final IvyBridgeMethod.a r13 = this.a;
            if (r26 != null) goto L7;
            String r16 = NameKeys.UnloadStrategy_No_Strategy;
        L8:
            int r14 = f.b;
            r7.getClass();
            FragmentActivity r8 = AppHost.a.a().getCurrentActivity();
            if ((r8 instanceof FragmentActivity) == true) goto L14;
            r3.e("AppBindPlatformMethod", "current activity " + r8 + " is not FragmentActivity");
            LinkedHashMap r4 = new LinkedHashMap();
            r4.put(LynxResourceModule.CODE_KEY, 1);
            LinkedHashMap r5 = new LinkedHashMap();
            r5.put("success", 0);
            r5.put("errorCode", Integer.valueOf(r23));
            if (r2 == null) goto L13;
            r5.put("errorMsg", r2);
        L13:
            Unit r1 = Unit.INSTANCE;
            r4.put(LynxResourceModule.DATA_KEY, r5);
            r13.invoke(r4);
            return;
        L14:
            ILoginApi r6 = (ILoginApi) ServiceManager.get().getService(ILoginApi.class);
            if (r6 == null) goto L26;
            List r9 = com.larus.login.api.i0.a;
            r6.F(r8, new SwitchBindParam(r16, "8943", "douyin", "douyin_account_bind_popup_click", "chat", 96), new e(r13, r23, r2));
            return;
        L26:
            return;
        L7:
            r16 = r26;
            goto L8
        L18:
            if (r23 != 4048) goto L20;
            IApplog.Companion r10 = IApplog.a;
            JSONObject r11 = new JSONObject();
            r11.put("current_page", "setting");
            Unit r12 = Unit.INSTANCE;
            r10.reportEvent("account_risk_toast", r11);
            r2 = AppHost.a.getApplication().getString(2131899061);
        L20:
            IvyBridgeMethod.a r15 = this.a;
            LinkedHashMap r17 = new LinkedHashMap();
            r17.put(LynxResourceModule.CODE_KEY, 1);
            LinkedHashMap r18 = new LinkedHashMap();
            r18.put("success", 0);
            r18.put("errorCode", Integer.valueOf(r23));
            if (r2 == null) goto L23;
            r18.put("errorMsg", r2);
        L23:
            Unit r19 = Unit.INSTANCE;
            r17.put(LynxResourceModule.DATA_KEY, r18);
            r15.invoke(r17);
        }
    }

    public h(ux7.d.d r1, f r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a(String r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r4, "token");
        ILoginService.Companion r6 = ILoginService.a;
        List r0 = com.larus.login.api.i0.a;
        r6.q("8943", "aweme_v2", r4, new a(this.a, this.b));
    }

    public final void b(String r7, String r8) {
        Intrinsics.checkNotNullParameter(r7, "errorMsg");
        FLogger.a.i("AppBindPlatformMethod", "updateAccountToken onFailed, errorCode = " + r8 + ", errorMsg = " + r7);
        IvyBridgeMethod.a r1 = this.a;
        LinkedHashMap r2 = new LinkedHashMap();
        r2.put(LynxResourceModule.CODE_KEY, 1);
        LinkedHashMap r3 = new LinkedHashMap();
        r3.put("success", 0);
        if (r8 == null) goto L5;
        r3.put("errorCode", r8);
    L5:
        r3.put("errorMsg", r7);
        Unit r9 = Unit.INSTANCE;
        r2.put(LynxResourceModule.DATA_KEY, r3);
        r1.invoke(r2);
    }
}
