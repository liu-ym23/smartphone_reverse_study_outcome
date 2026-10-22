package com.ss.android.lark.flow.notification.online.type.appfeed;

import com.ss.android.lark.notification.export.AbstractNotification;
import com.ss.android.lark.notification.export.entity.Notice;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a extends AbstractNotification<Notice, phb.a> {

    /* JADX INFO: renamed from: com.ss.android.lark.flow.notification.online.type.appfeed.a$a, reason: collision with other inner class name */
    public static final class C0055a {
    }

    static {
    }

    @Override // com.ss.android.lark.notification.export.AbstractNotification
    public int getType() {
        return 14;
    }

    @Override // com.ss.android.lark.notification.export.AbstractNotification
    public final AbstractNotification.AbstractNotificationDisplayer<phb.a> c() {
        return new FlowOpenAppFeedNotificationDisplayer();
    }

    public a() {
    }
}
