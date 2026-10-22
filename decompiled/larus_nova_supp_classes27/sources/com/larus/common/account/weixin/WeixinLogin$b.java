package com.larus.common.account.weixin;

import android.app.Application;
import com.bytedance.sdk.account.platform.IPlatformBindAdapter;
import com.bytedance.sdk.account.platform.PlatformBindAdapter;
import n38.m;
import ua7.b;
import ua7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class WeixinLogin$b extends PlatformBindAdapter {
    public final /* synthetic */ m a;

    public final void onBindError(h r5) {
        m r0 = this.a;
        if (r5 == null) goto L5;
        int r1 = ((b) r5).g;
    L7:
        if (r5 == null) goto L10;
        String r3 = r5.q;
        if (r3 == null) goto L10;
    L16:
        r0.a(r1, r3, null, null);
        return;
    L10:
        if (r5 == null) goto L12;
        String r6 = ((b) r5).i;
    L13:
        if (r6 != null) goto L15;
        r6 = "";
    L15:
        r3 = r6;
        goto L16
    L12:
        r6 = null;
        goto L13
    L5:
        r1 = -1;
        goto L7
    }

    public final void onBindSuccess(h r2) {
        this.a.onSuccess(null);
    }

    public WeixinLogin$b(m r2, Application r3) {
        this.a = r2;
        super(r3, "15210", "weixin");
    }

    public final void onBindExist(h r1, String r2, String r3, String r4, IPlatformBindAdapter.BindController r5) {
        m r6 = this.a;
        if (r1 == null) goto L5;
        int r7 = ((b) r1).g;
    L6:
        if (r2 != null) goto L8;
        r2 = "";
    L8:
        r6.a(r7, r2, null, null);
        return;
    L5:
        r7 = -1;
        goto L6
    }
}
