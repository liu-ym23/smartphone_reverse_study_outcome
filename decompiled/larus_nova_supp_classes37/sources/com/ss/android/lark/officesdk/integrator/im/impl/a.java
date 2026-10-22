package com.ss.android.lark.officesdk.integrator.im.impl;

import android.content.Context;
import com.ss.android.lark.log.Log;
import com.suite.lark.platform.component.widget_biz_billingtips.IBillingTipsDependency;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Singleton
public final class a implements IBillingTipsDependency {
    @Inject
    public a() {
    }

    public final String adaptHelpCenterUrl(String r2) {
        Intrinsics.checkNotNullParameter(r2, "url");
        return r2;
    }

    public final void openUrl(Context r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "url");
        Log.i("OfficeSdkBillingTipsDependency", "openUrl ignored, url=" + r4);
        com.ss.android.lark.router.c.b(r3, r4);
    }
}
