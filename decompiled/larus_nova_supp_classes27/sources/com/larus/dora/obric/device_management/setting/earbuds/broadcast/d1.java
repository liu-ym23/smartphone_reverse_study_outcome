package com.larus.dora.obric.device_management.setting.earbuds.broadcast;

import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.dora.impl.nl.permission.CategoryWhenNotGranted;
import com.larus.dora.impl.nl.permission.ProactivePermission;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class d1 implements Runnable {
    public final /* synthetic */ DoraObricEarbudsBroadcastSettingFragment a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ boolean c;

    public d1(DoraObricEarbudsBroadcastSettingFragment r1, boolean r2, boolean r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        final DoraObricEarbudsBroadcastSettingFragment r0 = this.a;     // Catch: Throwable -> L4
        final boolean r1 = this.b;     // Catch: Throwable -> L4
        final boolean r2 = this.c;     // Catch: Throwable -> L4
        int r3 = DoraObricEarbudsBroadcastSettingFragment.F;     // Catch: Throwable -> L4
        r0.getClass();     // Catch: Throwable -> L4
        int r4 = p59.b.a;     // Catch: Throwable -> L4
        p59.b.c(r0, CollectionsKt.listOf(ProactivePermission.POST_NOTIFICATION), CategoryWhenNotGranted.INTERRUPT, new f0(r0, r1, r2));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
