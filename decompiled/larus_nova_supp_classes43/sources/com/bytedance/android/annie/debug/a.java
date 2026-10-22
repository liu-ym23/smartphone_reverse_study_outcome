package com.bytedance.android.annie.debug;

import com.bytedance.android.annie.service.setting.AnnieConfigSettingKeys;
import com.bytedance.forest.model.Request;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a implements com.bytedance.forest.interceptor.a {
    public a() {
    }

    public final void a(Request r10) {
        Intrinsics.checkNotNullParameter(r10, "request");
        if (AnnieConfigSettingKeys.OFFLINE_SWITCH.a().booleanValue() == true) goto L6;
        r10.setOnlyOnline(true);
        r10.setEnableCDNCache(false);
        return;
    }
}
