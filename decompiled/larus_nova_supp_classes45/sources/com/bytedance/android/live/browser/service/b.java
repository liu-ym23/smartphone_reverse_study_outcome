package com.bytedance.android.live.browser.service;

import com.bytedance.android.live.base.model.user.IBaseUser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final /* synthetic */ class b {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[IBaseUser.Status.values().length];
        a = r0;
        r0[IBaseUser.Status.Login.ordinal()] = 1;
        r0[IBaseUser.Status.Logout.ordinal()] = 2;
    }
}
