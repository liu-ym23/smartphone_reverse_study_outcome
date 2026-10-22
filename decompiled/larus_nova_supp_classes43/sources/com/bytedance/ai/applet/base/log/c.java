package com.bytedance.ai.applet.base.log;

import com.bytedance.ai.event.MessageIndication;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c implements b {
    public c() {
    }

    @Override // com.bytedance.ai.applet.base.log.b
    public final void d(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_LUBAN_TAG);
        Intrinsics.checkNotNullParameter(r11, MessageIndication.MESSAGE_TYPE_MSG);
        h.a(r11);
    }

    @Override // com.bytedance.ai.applet.base.log.b
    public final void i(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_LUBAN_TAG);
        Intrinsics.checkNotNullParameter(r11, MessageIndication.MESSAGE_TYPE_MSG);
        h.a(r11);
    }

    @Override // com.bytedance.ai.applet.base.log.b
    public final void e(String r10, String r11, Throwable r12) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_LUBAN_TAG);
        Intrinsics.checkNotNullParameter(r11, MessageIndication.MESSAGE_TYPE_MSG);
        if (r12 == null) goto L5;
        h.a(r11);
        return;
    L5:
        h.a(r11);
    }

    @Override // com.bytedance.ai.applet.base.log.b
    public final void w(String r10, String r11, Throwable r12) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_LUBAN_TAG);
        Intrinsics.checkNotNullParameter(r11, MessageIndication.MESSAGE_TYPE_MSG);
        if (r12 == null) goto L5;
        h.a(r11);
        return;
    L5:
        h.a(r11);
    }
}
