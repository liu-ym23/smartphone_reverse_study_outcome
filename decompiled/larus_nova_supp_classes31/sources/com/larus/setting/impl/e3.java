package com.larus.setting.impl;

import android.content.Context;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class e3 implements n38.m {
    public final /* synthetic */ SettingAccountInfoFragment a;

    public e3(SettingAccountInfoFragment r1) {
        this.a = r1;
    }

    public final void onSuccess(String r4) {
        this.a.aa0(true);
        this.a.Y90(true, "facebook", null);
    }

    public final void a(int r3, String r4, String r5, String r6) {
        if (SettingAccountInfoFragment.m.contains(String.valueOf(r3)) == false) goto L5;
        t19.s r7 = t19.s.a;
        Context r8 = this.a.getContext();
        String r0 = this.a.X90(2131905609);
        r7.getClass();
        t19.s.t(r8, r0);
    L15:
        this.a.Y90(false, "facebook", String.valueOf(r3));
        return;
    L5:
        t19.s r9 = t19.s.a;
        Context r1 = this.a.getContext();
        if (r4 != null) goto L8;
    L11:
        boolean r2 = true;
    L12:
        if (r2 == false) goto L14;
        r4 = this.a.X90(2131907052);
    L14:
        r9.getClass();
        t19.s.t(r1, r4);
        goto L15
    L8:
        if (r4.length() == 0) goto L11;
        r2 = false;
        goto L12
    }
}
