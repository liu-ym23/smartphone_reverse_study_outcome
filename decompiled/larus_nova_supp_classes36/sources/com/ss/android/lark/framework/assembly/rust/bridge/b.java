package com.ss.android.lark.framework.assembly.rust.bridge;

import android.app.Application;
import com.bytedance.lark.office_sdk_im_android.OfficeSdkHostSetting;
import com.ss.android.lark.log.Log;
import e0c.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b implements OfficeSdkHostSetting {
    public final Application a;

    public static final class a {
    }

    static {
    }

    public final boolean getIsLegacyPcSidePanelImFeatureOpened() {
        return false;
    }

    public final boolean getIsImFeatureOpenedByHostManual() {
        Boolean r1 = null;
        qtb.b r2 = (qtb.b) k.a(this.a, qtb.b.class);     // Catch: Throwable -> L5
    L7:
        if (r2 == null) goto L9;
        r1 = Boolean.valueOf(r2.getIsImFeatureOpenedByHostManual());
    L9:
        Log.i("OfficeSdkHostSettingProviderImpl", "getIsImFeatureOpenedByHostManual result: " + r1);
        if (r1 != null) goto L16;
        return false;
    L16:
        return r1.booleanValue();
    L5:
        th = move-exception;
        Log.e("OfficeSdkHostSettingProviderImpl", "spiByDwarf(IOfficeSDKFeedApi) failed", th);
        r2 = null;
        goto L7
    }

    public b(Application r2) {
        Intrinsics.checkNotNullParameter(r2, "application");
        this.a = r2;
    }
}
