package com.larus.bmhome.chat.mode;

import com.larus.bmhome.social.userchat.model.b0;
import com.larus.im.bean.message.Message;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class w implements Function1 {
    public final /* synthetic */ ModeSwitchComponent a;

    public /* synthetic */ w(ModeSwitchComponent r1) {
        this.a = r1;
    }

    public final Object invoke(Object r4) {
        ModeSwitchComponent r0 = this.a;
        Message r5 = (Message) r4;
        int r1 = ModeSwitchComponent.k0;
        Intrinsics.checkNotNullParameter(r5, "message");
        if (r5.getContentType() != 2) goto L5;
    L10:
        boolean r6 = true;
    L12:
        return Boolean.valueOf(r6);
    L5:
        if (r0.D == true) goto L7;
    L9:
        r6 = false;
        goto L12
    L7:
        if (b0.e(r5) == false) goto L9;
        goto L9
    }
}
