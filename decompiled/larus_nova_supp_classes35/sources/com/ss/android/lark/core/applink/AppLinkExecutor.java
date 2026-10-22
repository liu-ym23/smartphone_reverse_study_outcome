package com.ss.android.lark.core.applink;

import android.content.Context;
import com.ss.android.lark.alchemy.applink.IAppLinkApi;
import ova.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class AppLinkExecutor implements IAppLinkApi {
    public AppLinkExecutor() {
    }

    public boolean openAppLink(Context r7, String r8) {
        return f.m().C(r7, r8, 13, null, null);
    }
}
