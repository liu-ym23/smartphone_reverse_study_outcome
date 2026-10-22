package com.bytedance.ai.applet.base.log;

import com.bytedance.ai.event.MessageIndication;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d {
    public static final AtomicInteger d = null;
    public final String a;
    public final String b;
    public final int c;

    public static final class a {
    }

    static {
        d = new AtomicInteger(0);
    }

    public final String b(String r10) {
        if (this.b == null) goto L6;
        return "[" + this.b + "][" + this.c + "] " + r10;
    L6:
        return "[" + this.c + "] " + r10;
    }

    public final void c(String r10) {
        Intrinsics.checkNotNullParameter(r10, MessageIndication.MESSAGE_TYPE_MSG);
        b r0 = com.bytedance.ai.applet.base.log.a.a;
        com.bytedance.ai.applet.base.log.a.c(this.a, b(r10));
    }

    public d(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_LUBAN_TAG);
        this.a = r10;
        this.b = r11;
        this.c = d.incrementAndGet();
    }

    public static void d(d r1, String r10) {
        r1.getClass();
        Intrinsics.checkNotNullParameter(r10, MessageIndication.MESSAGE_TYPE_MSG);
        b r0 = com.bytedance.ai.applet.base.log.a.a;
        com.bytedance.ai.applet.base.log.a.d(r1.a, r1.b(r10), null);
    }

    public final void a(String r10, Throwable r11) {
        Intrinsics.checkNotNullParameter(r10, MessageIndication.MESSAGE_TYPE_MSG);
        b r0 = com.bytedance.ai.applet.base.log.a.a;
        com.bytedance.ai.applet.base.log.a.b(this.a, b(r10), r11);
    }
}
