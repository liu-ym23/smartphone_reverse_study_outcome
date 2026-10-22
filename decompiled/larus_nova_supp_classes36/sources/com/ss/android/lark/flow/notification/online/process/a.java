package com.ss.android.lark.flow.notification.online.process;

import android.app.Application;
import androidx.core.app.NotificationManagerCompat;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.notification.export.entity.Notice;
import com.ss.android.lark.utils.LarkContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements Runnable {
    public final /* synthetic */ Notice a;
    public final /* synthetic */ b b;

    public final void a() {
        Notice r2 = this.a;     // Catch: Throwable -> L16
        if (r2 != null) goto L6;
    L8:
        boolean r3 = false;
    L9:
        if (r3 == true) goto L14;
        iac.a r4 = iac.a.b(LarkContext.getApplication());     // Catch: Throwable -> L16
        Application r5 = LarkContext.getApplication();     // Catch: Throwable -> L16
        r4.getClass();     // Catch: Throwable -> L16
        if (NotificationManagerCompat.from(r5).areNotificationsEnabled() == true) goto L14;
        thb.a.b("FlowNotificationDispatcher", "Notification is disabled");     // Catch: Throwable -> L16
        return;
    L14:
        b.a(this.b, this.a);     // Catch: Throwable -> L16
        return;
    L6:
        if (r2.type != 20002) goto L8;
        r3 = true;
    L16:
        th = move-exception;
        int r6 = thb.a.a;
        Intrinsics.checkNotNullParameter("FlowNotificationDispatcher", "tag");
        Log.e("FlowNotificationDispatcher", "[FlowNotificationLog] pushNotice", th, true);
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public a(b r1, Notice r2) {
        this.b = r1;
        this.a = r2;
    }
}
