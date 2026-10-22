package com.larus.drive.sdk.impl.view.chat;

import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class o implements com.larus.bmhome.chat.component.bottom.core.speaker.h {
    public final /* synthetic */ DriveFloatChatContainer a;

    public o(DriveFloatChatContainer r1) {
        this.a = r1;
    }

    public final void a(com.larus.bmhome.chat.component.bottom.core.speaker.g r4) {
        Intrinsics.checkNotNullParameter(r4, "state");
        FLogger.a.i("DriveFloatChatContainer", "[onStateChanged] state=" + r4);
        if ((r4 instanceof com.larus.bmhome.chat.component.bottom.core.speaker.g.e) == false) goto L6;
        this.a.e.b(((com.larus.bmhome.chat.component.bottom.core.speaker.g.e) r4).a, true);
        return;
    }
}
