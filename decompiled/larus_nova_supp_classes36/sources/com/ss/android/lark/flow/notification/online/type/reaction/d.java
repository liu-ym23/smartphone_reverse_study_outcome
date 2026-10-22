package com.ss.android.lark.flow.notification.online.type.reaction;

import com.ss.android.lark.flow.notification.online.type.reaction.entity.FlowReactionNotice;
import com.ss.android.lark.notification.export.AbstractNotification;
import com.ss.android.lark.notification.export.entity.Notice;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d implements AbstractNotification.b<FlowReactionNotice> {
    public d() {
    }

    @Override // com.ss.android.lark.notification.export.AbstractNotification.b
    public final Notice a(Notice r2) {
        if (r2 != null) goto L4;
    L7:
        return null;
    L4:
        if (r2.extra == null) goto L7;
        return new FlowReactionNotice(r2);
    }

    @Override // com.ss.android.lark.notification.export.AbstractNotification.b
    public final int b(Notice r4) {
        if (r4.shouldNotify == true) goto L13;
        int r5 = r4.state;
        if (r5 != 2) goto L7;
    L10:
        boolean r6 = true;
    L11:
        if (r6 == false) goto L13;
        return 1;
    L7:
        if (r5 == 3) goto L10;
        r6 = false;
    L13:
        return 0;
    }
}
