package com.ss.android.lark.conditional.access.nopermission.manager;

import android.app.Activity;
import android.os.Bundle;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d extends com.ss.android.lark.appcontext.applifecycle.a {
    public final /* synthetic */ NoPermissionModuleManager a;

    public d(NoPermissionModuleManager r1) {
        this.a = r1;
    }

    public final void onActivityDestroyed(Activity r4) {
        Intrinsics.checkNotNullParameter(r4, "activity");
        this.a.c.getPassportDependency().getClass();
        if (this.a.h(r4) == true) goto L5;
        return;
    L5:
        if (r4.isChangingConfigurations() == false) goto L8;
        ScsLogger.d("SecurityPolicy_NoPermissionModuleManager", "protected oauth web container destroyed for configuration change");
        return;
    L8:
        WeakReference<Activity> r0 = this.a.i;
        if (r0 == null) goto L11;
        Activity r1 = r0.get();
    L12:
        if (r1 != r4) goto L14;
        this.a.i = null;
    L14:
        ScsLogger.d("SecurityPolicy_NoPermissionModuleManager", "protected oauth web container destroyed, try resume deferred no permission");
        this.a.l("protected_oauth_destroyed", r4);
        return;
    L11:
        r1 = null;
        goto L12
    }

    public final void onActivityResumed(Activity r3) {
        Intrinsics.checkNotNullParameter(r3, "activity");
        if (NoPermissionModuleManager.a(this.a, r3, "resumed") == false) goto L5;
        return;
    L5:
        this.a.l("activity_resumed", null);
    }

    public final void onActivityCreated(Activity r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        this.a.c.getPassportDependency().getClass();
        NoPermissionModuleManager.a(this.a, r2, "created");
    }
}
