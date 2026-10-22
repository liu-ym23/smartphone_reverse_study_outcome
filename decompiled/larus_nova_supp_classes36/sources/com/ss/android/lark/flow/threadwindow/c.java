package com.ss.android.lark.flow.threadwindow;

import com.ss.android.lark.biz.im.api.a1;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c implements a1 {
    public c() {
    }

    public final int a(MessageInfo r2) {
        Intrinsics.checkNotNullParameter(r2, "info");
        return r2.getMessage().getThreadPosition();
    }

    public final int b(Message r2) {
        Intrinsics.checkNotNullParameter(r2, INotificationHitPoint.NoticeType.MESSAGE);
        return r2.getThreadPosition();
    }

    public final int c(y6b.c<?> r2) {
        Intrinsics.checkNotNullParameter(r2, "messageVO");
        return r2.W2;
    }
}
