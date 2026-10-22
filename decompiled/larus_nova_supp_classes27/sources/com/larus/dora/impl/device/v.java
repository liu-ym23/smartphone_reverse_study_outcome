package com.larus.dora.impl.device;

import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.avlink.api.DoraAVLinkDelegate;
import com.larus.dora.impl.nl.DoraUserSettingsManager;
import com.larus.dora.impl.nl.permission.CategoryWhenNotGranted;
import com.larus.dora.impl.nl.permission.ProactivePermission;
import com.larus.dora.impl.settings.DoraPushSummaryConfig;
import java.util.Date;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class v implements Runnable {
    public final /* synthetic */ DoraDeviceFragment a;
    public final /* synthetic */ DoraPushSummaryConfig b;

    public v(DoraDeviceFragment r1, DoraPushSummaryConfig r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        g49.d.d("DoraDeviceFragment", "checkProactivePermission: isResume=" + this.a.isResumed());
        if (this.a.isResumed() == false) goto L42;
        DoraDeviceFragment r0 = this.a;
        if (r0.v == true) goto L43;
        r0.v = true;
        DoraPushSummaryConfig r3 = this.b;
        if (r3.getNotificationSummary() == true) goto L9;
    L11:
        boolean r4 = false;
    L13:
        if (r3.getProactiveMessage() == true) goto L15;
    L17:
        boolean r5 = false;
    L18:
        if (r5 == true) goto L21;
        if (r4 == true) goto L21;
        g49.d.d("DoraDeviceFragment", "checkProactivePermission: notification and proactive chat are both disabled");
        return;
    L21:
        com.larus.dora.impl.util.b0.a.getClass();
        long r6 = com.larus.dora.impl.util.b0.j().getLong("dora_nl_confirm_timestamp", 0);
        if (r6 == 0) goto L31;
        Date r8 = new Date(r6);
        Date r7 = new Date();
        if (r8.getYear() != r7.getYear()) goto L31;
        if (r8.getMonth() != r7.getMonth()) goto L31;
        if (r8.getDate() != r7.getDate()) goto L31;
        boolean r9 = true;
    L32:
        if (r9 == false) goto L34;
        g49.d.d("DoraDeviceFragment", "checkProactivePermission: ConfirmOnSameDay");
        return;
    L34:
        g49.d.d("DoraDeviceFragment", "checkProactivePermission: isProactiveNotificationEnabled=" + r4 + ", isProactiveChatEnabled=" + r5);
        if (r5 == false) goto L37;
    L39:
        List r2 = CollectionsKt.listOf(new ProactivePermission[]{ProactivePermission.POST_NOTIFICATION, ProactivePermission.NOTIFICATION_LISTENER});
    L40:
        g49.d.d("DoraDeviceFragment", "checkProactivePermission: start " + r2);
        int r1 = p59.b.a;
        p59.b.c(r0, r2, CategoryWhenNotGranted.NEXT, new r());
        return;
    L37:
        if (DoraAVLinkDelegate.b.y() == true) goto L39;
        r2 = CollectionsKt.listOf(ProactivePermission.NOTIFICATION_LISTENER);
    L31:
        r9 = false;
        goto L32
    L15:
        if (((Boolean) DoraUserSettingsManager.o.getValue()).booleanValue() == false) goto L17;
        r5 = true;
        goto L18
    L9:
        if (((Boolean) DoraUserSettingsManager.g.getValue()).booleanValue() == false) goto L11;
        r4 = true;
        goto L13
    L43:
        return;
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
