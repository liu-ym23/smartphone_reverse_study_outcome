package com.obric.assistant;

import android.app.Activity;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.common.spi.ObricFeatureServiceDelegate;
import com.obric.assistant.common.utils.m;
import com.obric.assistant.guide.ui.UserGuideActivity;
import com.obric.assistant.permission.IObricPermissionService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class p1 {
    public static final b a = null;
    public static final a b = null;

    public static final class a implements f09.a.a {
        public a() {
        }

        public final void onPaused(Activity r2) {
            Intrinsics.checkNotNullParameter(r2, "activity");
        }

        public final void onPreDestroyed(Activity r2) {
            Intrinsics.checkNotNullParameter(r2, "activity");
        }

        public final void onResumed(Activity r4) {
            Intrinsics.checkNotNullParameter(r4, "activity");
            b r0 = p1.a;
            FLogger.a.i("ObricPermissionManager", "onResumed activity: " + r4);
        }

        public final void onStart(Activity r2) {
            Intrinsics.checkNotNullParameter(r2, "activity");
        }

        public final void onStopped(Activity r2) {
            Intrinsics.checkNotNullParameter(r2, "activity");
            if (ObricFeatureServiceDelegate.b.c() == false) goto L6;
            boolean r3 = r2 instanceof UserGuideActivity;
            return;
        }

        public final void onCreate(Activity r1, Bundle r2) {
            Intrinsics.checkNotNullParameter(r1, "activity");
        }
    }

    public static final class b implements f09.a.b {
        public b() {
        }

        public final void onAllActivityDestroyed() {
        }

        public final void onAppBackground() {
            FLogger.a.i("ObricPermissionManager", "onAppBackground");
            b r0 = p1.a;
        }

        public final void onAppForeground() {
            FLogger.a.i("ObricPermissionManager", "onAppForeground");
            b r0 = p1.a;
        }
    }

    public static final class c implements IObricPermissionService.a {
        public final /* synthetic */ Function0<Unit> a;

        public c(Function0<Unit> r1) {
            this.a = r1;
        }

        public final void a(boolean r4, boolean r5, List<String> r6, List<String> r7) {
            Intrinsics.checkNotNullParameter(r6, "grantedList");
            Intrinsics.checkNotNullParameter(r7, "deniedList");
            FLogger.a.i("ObricPermissionManager", "tryBatchRequestInitPermissions, isCanceledOrFailed: " + r4 + ", allGranted: " + r5 + ", grantedList.size: " + r6.size() + ", deniedList: " + r7.size());
            this.a.invoke();
        }
    }

    static {
        a = new b();
        b = new a();
    }

    public static void a(Function0 r9) {
        Intrinsics.checkNotNullParameter(r9, "requestCompleted");
        FragmentActivity r0 = AppHost.a.a().getCurrentActivity();
        if ((r0 instanceof FragmentActivity) == false) goto L5;
        FragmentActivity r1 = r0;
    L6:
        FragmentActivity r2 = r1;
        t1 r3 = t1.a;
        boolean r4 = r3.W1();
        boolean r5 = t9a.b.a().b();
        FLogger r6 = FLogger.a;
        r6.i("ObricPermissionManager", "tryBatchRequestInitPermissions, permissionTips: " + r4 + ", isObricOS: " + r5);
        if (r4 == false) goto L10;
        r6.i("ObricPermissionManager", "tryBatchRequestInitPermissions, return by permissionTips");
        r9.invoke();
        return;
    L10:
        if (r5 == false) goto L14;
        m.a.getClass();
        if (m.a() == false) goto L14;
        boolean r7 = true;
    L15:
        IObricPermissionService r8 = (IObricPermissionService) ServiceManager.get().getService(IObricPermissionService.class);
        if (r8 == null) goto L21;
        if (r5 == false) goto L19;
        IObricPermissionService.a.getClass();
        List r10 = IObricPermissionService.Companion.b;
    L20:
        r8.n(r2, r10, true, true, true, r7, new c(r9));
        goto L21
    L19:
        IObricPermissionService.a.getClass();
        r10 = IObricPermissionService.Companion.c;
    L21:
        r3.W0();
        return;
    L14:
        r7 = false;
        goto L15
    L5:
        r1 = null;
        goto L6
    }
}
