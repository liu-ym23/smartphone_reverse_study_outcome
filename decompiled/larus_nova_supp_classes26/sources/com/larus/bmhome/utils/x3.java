package com.larus.bmhome.utils;

import com.bytedance.keva.Keva;
import com.larus.bmhome.social.userchat.model.TriggerSendLoading;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class x3 {
    public static String a;
    public static final Lazy b = null;

    static {
        a = "";
        b = LazyKt.lazy(new w3());
    }

    public static String a(String r3, String r4) {
        if (r3 != null) goto L5;
        return TriggerSendLoading.NO_LOADING;
    L5:
        if (r4 != null) goto L7;
        return TriggerSendLoading.NO_LOADING;
    L7:
        String r5 = ((Keva) b.getValue()).getString(r3, "");
        if (com.larus.utils.o0.d(r5) == true) goto L10;
    L13:
        return TriggerSendLoading.NO_LOADING;
    L10:
        if (Intrinsics.areEqual(r5, r4) == false) goto L13;
        return "1";
    }
}
