package com.bytedance.ai.applet.base.log;

import com.bytedance.ai.event.MessageIndication;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public static b a;

    static {
        a = new c();
    }

    public static void a(String r1, String r10) {
        Intrinsics.checkNotNullParameter(r1, com.bytedance.android.ec.core.event.a.KEY_LUBAN_TAG);
        Intrinsics.checkNotNullParameter(r10, MessageIndication.MESSAGE_TYPE_MSG);
        a.d(r1, r10);
    }

    public static void c(String r1, String r10) {
        Intrinsics.checkNotNullParameter(r1, com.bytedance.android.ec.core.event.a.KEY_LUBAN_TAG);
        Intrinsics.checkNotNullParameter(r10, MessageIndication.MESSAGE_TYPE_MSG);
        a.i(r1, r10);
    }

    public static void b(String r1, String r10, Throwable r11) {
        Intrinsics.checkNotNullParameter(r1, com.bytedance.android.ec.core.event.a.KEY_LUBAN_TAG);
        Intrinsics.checkNotNullParameter(r10, MessageIndication.MESSAGE_TYPE_MSG);
        a.e(r1, r10, r11);
    }

    public static void d(String r1, String r10, Throwable r11) {
        Intrinsics.checkNotNullParameter(r1, com.bytedance.android.ec.core.event.a.KEY_LUBAN_TAG);
        Intrinsics.checkNotNullParameter(r10, MessageIndication.MESSAGE_TYPE_MSG);
        a.w(r1, r10, r11);
    }
}
