package com.ss.android.lark.im.sdk.service;

import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a0 {
    public final List<MessageInfo> a;
    public final int b;
    public final String c;
    public final boolean d;
    public final boolean e;
    public final Message f;

    public static final class a {
        public List<? extends MessageInfo> a;
        public int b;
        public String c;
        public boolean d;
        public boolean e;
        public Message f;

        public a() {
        }
    }

    public a0(a r2) {
        List<MessageInfo> r0 = r2.a;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("messages");
        r0 = null;
    L6:
        this.a = r0;
        this.b = r2.b;
        this.c = r2.c;
        this.d = r2.d;
        this.e = r2.e;
        this.f = r2.f;
    }

    public final int a(Message r2) {
        Intrinsics.checkNotNullParameter(r2, INotificationHitPoint.NoticeType.MESSAGE);
        String r0 = this.c;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        return r2.getBadgeCount();
    L12:
        return r2.getThreadBadgeCount();
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    public final int b(Message r2) {
        Intrinsics.checkNotNullParameter(r2, INotificationHitPoint.NoticeType.MESSAGE);
        String r0 = this.c;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        return r2.getPosition();
    L12:
        return r2.getThreadPosition();
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }
}
