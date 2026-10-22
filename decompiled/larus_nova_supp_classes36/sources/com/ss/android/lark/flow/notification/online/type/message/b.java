package com.ss.android.lark.flow.notification.online.type.message;

import android.text.TextUtils;
import com.ss.android.lark.notification.export.AbstractNotification;
import com.ss.android.lark.notification.export.entity.Notice;
import com.ss.android.lark.utils.LarkContext;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b implements AbstractNotification.a {
    public b() {
    }

    @Override // com.ss.android.lark.notification.export.AbstractNotification.a
    public final void a(Notice r5) {
        String r0 = r5.messageId;
        if (TextUtils.isEmpty(r0) == true) goto L13;
        Notice.Extra r1 = r5.extra;
        if (r1 == null) goto L13;
        String r2 = r1.a;
        if (TextUtils.isEmpty(r2) == false) goto L11;
        thb.a.a("FlowMessageNotificationCanceler", "getChatId extra is null");
        return;
    L11:
        int r3 = dtb.c.b(r5, r0);
        iac.a.b(LarkContext.getApplication()).a(r3);
        int r4 = dtb.c.b(r5, r2);
        iac.a.b(LarkContext.getApplication()).a(r4);
        iac.a.b(LarkContext.getApplication()).a(dtb.c.b(r5, r5.key));
        return;
    L13:
        thb.a.a("FlowMessageNotificationCanceler", "messageId or notice extra is null");
    }
}
