package com.larus.drive.sdk.impl.view.chat;

import com.larus.utils.logger.FLogger;
import va8.g0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class n implements va8.d {
    public final /* synthetic */ DriveFloatChatContainer a;

    public final void foldStatusChanged() {
        DriveFloatChatContainer.c r0 = this.a.g;
        if (r0 == null) goto L5;
        g0 r1 = r0.b();
    L6:
        FLogger r2 = FLogger.a;
        StringBuilder r3 = new StringBuilder("[foldStatusChanged] isExpanded=");
        boolean r4 = true;
        if (r1 != null) goto L9;
    L11:
        boolean r5 = false;
    L12:
        r3.append(r5);
        r3.append(", containerId=");
        r3.append(this.a.c);
        r2.i("DriveFloatChatContainer", r3.toString());
        DriveFloatChatContainer.a r6 = this.a.e;
        if (r1 != null) goto L15;
    L17:
        r4 = false;
    L18:
        r6.a(r4, r1);
        return;
    L15:
        if (r1.YC() != true) goto L17;
    L9:
        if (r1.YC() != true) goto L11;
        r5 = true;
        goto L12
    L5:
        r1 = null;
        goto L6
    }

    public n(DriveFloatChatContainer r1) {
        this.a = r1;
    }
}
