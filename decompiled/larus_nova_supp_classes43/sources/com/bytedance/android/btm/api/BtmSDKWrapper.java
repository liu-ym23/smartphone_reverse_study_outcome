package com.bytedance.android.btm.api;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class BtmSDKWrapper {
    public static final Lazy a = null;

    public BtmSDKWrapper() {
    }

    static {
        a = LazyKt.lazy(BtmSDKWrapper$enableV2Api$2.INSTANCE);
    }

    public static void c(Class r10, String r11) {
        if (((Boolean) a.getValue()).booleanValue() == true) goto L7;
        BtmSDK.INSTANCE.registerPageClass(r10, r11, true);
        return;
    }

    public static void a(Activity r1, String r10, String r11) {
        if (((Boolean) a.getValue()).booleanValue() == true) goto L5;
        return;
    L5:
        BtmSDK.INSTANCE.registerBtmPageOnCreate(r1, r10, r11);
    }

    public static void b(Fragment r10, String r11, String r12) {
        if (((Boolean) a.getValue()).booleanValue() == true) goto L5;
        return;
    L5:
        BtmSDK.INSTANCE.registerBtmPageOnCreate(new h(r10, r11, r12, 28));
    }
}
