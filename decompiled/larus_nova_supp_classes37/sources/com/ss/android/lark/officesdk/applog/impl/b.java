package com.ss.android.lark.officesdk.applog.impl;

import android.os.Bundle;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class b implements gtb.a {
    public b() {
    }

    @Override // gtb.a
    public final void flush() {
        gtb.a r0 = (gtb.a) OfficeSDKManager.getHostGlobalService(gtb.a.class);
        if (r0 == null) goto L6;
        r0.flush();
        return;
    }

    @Override // gtb.a
    public final void onEventV3(String r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "event");
        gtb.a r0 = (gtb.a) OfficeSDKManager.getHostGlobalService(gtb.a.class);
        if (r0 == null) goto L6;
        r0.onEventV3(r2, r3);
        return;
    }

    @Override // gtb.a
    public final void onMiscEvent(String r2, JSONObject r3) {
        Intrinsics.checkNotNullParameter(r2, "logType");
        Intrinsics.checkNotNullParameter(r3, "obj");
        gtb.a r0 = (gtb.a) OfficeSDKManager.getHostGlobalService(gtb.a.class);
        if (r0 == null) goto L6;
        r0.onMiscEvent(r2, r3);
        return;
    }

    @Override // gtb.a
    public final void onEventV3(String r2, JSONObject r3) {
        Intrinsics.checkNotNullParameter(r2, "event");
        gtb.a r0 = (gtb.a) OfficeSDKManager.getHostGlobalService(gtb.a.class);
        if (r0 == null) goto L6;
        r0.onEventV3(r2, r3);
        return;
    }
}
