package com.bytedance.android.ec.core.address;

import com.bytedance.ai.event.MessageIndication;
import com.bytedance.android.ec.core.utils.b2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class AddressSDKLog {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(final String r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, MessageIndication.MESSAGE_TYPE_MSG);
        if (r11 == true) goto L7;
        final long r0 = System.currentTimeMillis();
        b2.a(new AddressSDKLog$i$1(r10, r0));
        return;
    }
}
