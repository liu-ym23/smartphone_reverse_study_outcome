package com.larus.setting.impl;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.activity.result.ActivityResultLauncher;
import androidx.fragment.app.FragmentActivity;
import com.larus.account.base.api.ILoginService;
import com.larus.applog.api.IApplog;
import com.larus.login.api.DouyinConversationAuthService;
import com.larus.login.api.DouyinConversationAuthTriggerScene;
import com.larus.login.api.ILoginApi;
import com.larus.login.api.SwitchBindParam;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class d3 implements n38.l {
    public final /* synthetic */ SettingAccountInfoFragment a;

    public static final class a implements n38.m {
        public final /* synthetic */ Bundle a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ SettingAccountInfoFragment d;

        public final void onSuccess(String r13) {
            Bundle r14 = this.a;
            if (r14 == null) goto L6;
            String r15 = r14.getString("granted_permission");
            if (r15 == null) goto L6;
        L7:
            String r0 = this.b;
            String r2 = this.c;
            tx9.w0.d(r0, "host", r2, 1, r15, null, null, null, null, null, null, 4064);
            t19.s r16 = t19.s.a;
            Context r1 = this.d.getContext();
            SettingAccountInfoFragment r3 = this.d;
            Set<String> r4 = SettingAccountInfoFragment.m;
            String r5 = r3.X90(2131899066);
            r16.getClass();
            t19.s.p(r1, r5);
            this.d.aa0(true);
            this.d.Y90(true, "douyin", null);
            DouyinConversationAuthService r17 = DouyinConversationAuthService.a;
            r17.b(DouyinConversationAuthTriggerScene.ACCOUNT_BIND);
            FragmentActivity r6 = this.d.getActivity();
            if (r6 == null) goto L11;
            this.d.getClass();
            r17.a(r6, "setting");
            return;
        L11:
            return;
        L6:
            r15 = "";
            goto L7
        }

        public a(Bundle r1, String r2, String r3, SettingAccountInfoFragment r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void a(int r26, String r27, String r28, String r29) {
            String r2 = r27;
            FLogger.a.i(this.d.e, "[bindPlatform] PLATFORM_DOUYIN, errorCode:" + r26 + ", errorMsg:" + r2);
            if (r26 != 1030) goto L5;
            SettingAccountInfoFragment r3 = this.d;
            if (r29 != null) goto L26;
            String r6 = "";
        L27:
            ActivityResultLauncher<Intent> r4 = r3.j;
            if (r4 == null) goto L32;
            ILoginApi r5 = (ILoginApi) ServiceManager.get().getService(ILoginApi.class);
            if (r5 == null) goto L32;
            List r7 = com.larus.login.api.i0.a;
            r5.G(r4, new SwitchBindParam(r6, "8943", SettingAccountInfoFragment.n, "douyin_account_bind_click", "setting", 96));
        L32:
            tx9.w0.d(this.b, "host", this.c, 0, null, null, null, null, null, null, null, 4064);
            this.d.Y90(false, "douyin", String.valueOf(r26));
            return;
        L26:
            r6 = r29;
            goto L27
        L5:
            if (r26 != 1041) goto L7;
            t19.s r8 = t19.s.a;
            Context r9 = this.d.getContext();
            if (r2 != null) goto L22;
            r2 = this.d.X90(2131908252);
        L22:
            r8.getClass();
            t19.s.t(r9, r2);
            goto L32
        L7:
            if (r26 == 4048) goto L18;
            t19.s r10 = t19.s.a;
            Context r11 = this.d.getContext();
            if (r2 != null) goto L11;
        L14:
            boolean r12 = true;
        L15:
            if (r12 == false) goto L17;
            r2 = this.d.X90(2131900167);
        L17:
            r10.getClass();
            t19.s.t(r11, r2);
            goto L32
        L11:
            if (r27.length() == 0) goto L14;
            r12 = false;
            goto L15
        L18:
            t19.s r13 = t19.s.a;
            Context r14 = this.d.getContext();
            String r15 = this.d.X90(2131899061);
            r13.getClass();
            t19.s.t(r14, r15);
            IApplog.Companion r16 = IApplog.a;
            JSONObject r17 = new JSONObject();
            this.d.getClass();
            r17.put("current_page", "setting");
            Unit r18 = Unit.INSTANCE;
            r16.reportEvent("account_risk_toast", r17);
            goto L32
        }
    }

    public d3(SettingAccountInfoFragment r1) {
        this.a = r1;
    }

    public final void a(String r7, Bundle r8) {
        Intrinsics.checkNotNullParameter(r7, "token");
        ILoginService.Companion r0 = ILoginService.a;
        List r1 = com.larus.login.api.i0.a;
        r0.q("8943", SettingAccountInfoFragment.n, r7, new a(r8, "normal", "setting_page", this.a));
    }

    public final void b(String r19, String r20) {
        Intrinsics.checkNotNullParameter(r19, "errorMsg");
        if (Intrinsics.areEqual(r20, "-2") == true) goto L10;
    L8:
        tx9.w0.d("normal", "host", "setting_page", 0, null, null, null, null, null, null, null, 4064);
        SettingAccountInfoFragment r0 = this.a;
        Set<String> r3 = SettingAccountInfoFragment.m;
        r0.Y90(false, "douyin", r20);
        return;
    L10:
        t19.s r4 = t19.s.a;     // Catch: Exception -> L6
        Context r5 = this.a.getContext();     // Catch: Exception -> L6
        SettingAccountInfoFragment r1 = this.a;     // Catch: Exception -> L6
        Set<String> r6 = SettingAccountInfoFragment.m;     // Catch: Exception -> L6
        t19.s.j(r4, r5, r1.X90(2131905280), null, false, 28);     // Catch: Exception -> L6
    L6:
        e = move-exception;
        FLogger.a.e(this.a.e, "toast fails", e);
        goto L8
    }
}
