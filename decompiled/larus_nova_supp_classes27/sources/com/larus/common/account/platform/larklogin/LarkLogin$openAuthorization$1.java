package com.larus.common.account.platform.larklogin;

import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/larus/common/account/platform/larklogin/LarkLogin$openAuthorization$1", "Landroidx/lifecycle/DefaultLifecycleObserver;", "onDestroy", "", "owner", "Landroidx/lifecycle/LifecycleOwner;", "larkauth_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LarkLogin$openAuthorization$1 implements DefaultLifecycleObserver {
    public final /* synthetic */ LarkOAuthSessionCoordinator$e a;

    public final /* synthetic */ void onCreate(LifecycleOwner r1) {
        DefaultLifecycleObserver.-CC.$default$onCreate(this, r1);
    }

    public final /* synthetic */ void onPause(LifecycleOwner r1) {
        DefaultLifecycleObserver.-CC.$default$onPause(this, r1);
    }

    public final /* synthetic */ void onResume(LifecycleOwner r1) {
        DefaultLifecycleObserver.-CC.$default$onResume(this, r1);
    }

    public final /* synthetic */ void onStart(LifecycleOwner r1) {
        DefaultLifecycleObserver.-CC.$default$onStart(this, r1);
    }

    public final /* synthetic */ void onStop(LifecycleOwner r1) {
        DefaultLifecycleObserver.-CC.$default$onStop(this, r1);
    }

    public LarkLogin$openAuthorization$1(LarkOAuthSessionCoordinator$e r1) {
        this.a = r1;
    }

    public final void onDestroy(LifecycleOwner r5) {
        Intrinsics.checkNotNullParameter(r5, "owner");
        LarkOAuthSessionCoordinator r6 = LarkLogin.h;
        String r0 = this.a.a;
        r6.getClass();
        Intrinsics.checkNotNullParameter(r0, "sessionId");
        Object r1 = r6.e;
        monitor-enter(r1);
        LarkOAuthSessionCoordinator$a r2 = r6.f;     // Catch: Throwable -> L12
        if (r2 != null) goto L7;
    L14:
        r2 = (LarkOAuthSessionCoordinator$a) r6.g.get(r0);     // Catch: Throwable -> L12
    L15:
        if (r2 == null) goto L17;
        boolean r3 = true;
    L18:
        monitor-exit(r1);
        if (r3 == false) goto L26;
        FLogger.a.w("LarkLogin", "cancel authorize by activity destroy");
        String r4 = this.a.a;
        Intrinsics.checkNotNullParameter(r4, "sessionId");
        r6.d(r4, LarkOAuthSessionCoordinator$c.b.a, LarkOAuthSessionCoordinator$Phase.AUTHORIZING);
        return;
    L26:
        return;
    L17:
        r3 = false;
        goto L18
    L7:
        if (Intrinsics.areEqual(r2.a.a, r0) == true) goto L10;
        r2 = null;
    L10:
        if (r2 != null) goto L15;
    L12:
        th = move-exception;
        throw th;
    }
}
