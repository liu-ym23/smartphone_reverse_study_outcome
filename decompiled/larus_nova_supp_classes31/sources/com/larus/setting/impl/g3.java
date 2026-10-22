package com.larus.setting.impl;

import android.content.Context;
import com.larus.login.api.LoginService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class g3 implements n38.m {
    public final /* synthetic */ SettingAccountInfoFragment a;

    public g3(SettingAccountInfoFragment r1) {
        this.a = r1;
    }

    public final void onSuccess(String r4) {
        this.a.aa0(true);
        this.a.Y90(true, "line", null);
    }

    public final void a(int r3, String r4, String r5, String r6) {
        if (LoginService.a.s(this.a) == true) goto L6;
        return;
    L6:
        if (SettingAccountInfoFragment.m.contains(String.valueOf(r3)) == false) goto L8;
        t19.s r7 = t19.s.a;
        Context r8 = this.a.getContext();
        String r0 = this.a.X90(2131906811);
        r7.getClass();
        t19.s.t(r8, r0);
    L18:
        this.a.Y90(false, "line", String.valueOf(r3));
        return;
    L8:
        t19.s r9 = t19.s.a;
        Context r1 = this.a.getContext();
        if (r4 != null) goto L11;
    L14:
        boolean r2 = true;
    L15:
        if (r2 == false) goto L17;
        r4 = this.a.X90(2131907052);
    L17:
        r9.getClass();
        t19.s.t(r1, r4);
        goto L18
    L11:
        if (r4.length() == 0) goto L14;
        r2 = false;
        goto L15
    }
}
