package com.bytedance.android.livesdk.chatroom.ui;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class SandwichLayoutHelper {
    public static final Lazy b = null;
    public f9 a;

    public static final class a {
    }

    public SandwichLayoutHelper() {
    }

    public static String a(int r1) {
        if (r1 != 1) goto L5;
        return "enter_room";
    L5:
        if (r1 != 2) goto L7;
        return "on_configuration_changed";
    L7:
        if (r1 == 3) goto L9;
        return "unknown";
    L9:
        return "im_message";
    }

    static {
        b = LazyKt.lazy(SandwichLayoutHelper$Companion$enable$2.INSTANCE);
    }
}
