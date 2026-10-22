package com.larus.dora.impl.noti_v3.overview.ui;

import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.dora.impl.nl.permission.CategoryWhenNotGranted;
import com.larus.dora.impl.nl.permission.ProactivePermission;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class u implements Runnable {
    public final /* synthetic */ NotificationBroadcastV3Fragment a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ boolean c;

    public u(NotificationBroadcastV3Fragment r1, boolean r2, boolean r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void a() {
        NotificationBroadcastV3Fragment r0 = this.a;
        final boolean r1 = this.b;
        final boolean r2 = this.c;
        int r3 = NotificationBroadcastV3Fragment.l;
        r0.getClass();
        g49.d.d("NotificationBroadcastV3Fragment", "checkPermissionOnHonor: isProactiveNotificationEnabled=" + r1 + ", isProactiveChatEnabled=" + r2);
        int r4 = p59.b.a;
        p59.b.c(r0, CollectionsKt.listOf(new ProactivePermission[]{ProactivePermission.POST_NOTIFICATION, ProactivePermission.NOTIFICATION_LISTENER}), CategoryWhenNotGranted.INTERRUPT, new l(r2, r1));
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
}
