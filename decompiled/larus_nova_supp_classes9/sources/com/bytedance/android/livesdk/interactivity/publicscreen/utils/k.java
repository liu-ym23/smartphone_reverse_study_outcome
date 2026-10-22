package com.bytedance.android.livesdk.interactivity.publicscreen.utils;

import com.bytedance.android.livesdkapi.message.IPublicAreaCommon;
import com.bytedance.android.livesdkapi.message.IPublicAreaCommonKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class k {
    public static final /* synthetic */ int a = 0;

    static {
    }

    @JvmStatic
    public static final boolean a(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r1) {
        Intrinsics.checkNotNullParameter(r1, "message");
        com.bytedance.android.livesdk.interactivity.api.publicscreen.i r2 = r1.s();
        if (r2 == null) goto L9;
        IPublicAreaCommon r3 = r2.c();
        if (r3 == null) goto L9;
        if (IPublicAreaCommonKt.isFloatMessage(r3) != true) goto L9;
        return true;
    L9:
        return false;
    }
}
