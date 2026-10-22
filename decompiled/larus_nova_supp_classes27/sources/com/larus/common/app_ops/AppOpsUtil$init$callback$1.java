package com.larus.common.app_ops;

import android.app.AppOpsManager;
import android.app.AsyncNotedAppOp;
import android.app.SyncNotedAppOp;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class AppOpsUtil$init$callback$1 extends AppOpsManager.OnOpNotedCallback {
    public final /* synthetic */ boolean a;

    public AppOpsUtil$init$callback$1(boolean r1) {
        this.a = r1;
    }

    @Override // android.app.AppOpsManager.OnOpNotedCallback
    public final void onAsyncNoted(AsyncNotedAppOp r8) {
        Intrinsics.checkNotNullParameter(r8, "asyncOp");
        FLogger.a.i("AppOpsUtil", "onAsyncNoted:" + r8.getOp() + ",attributionTag:" + r8.getAttributionTag() + ",message:" + r8.getMessage());
        a r0 = a.a;
        if (AppHost.a.isTestChannel() == false) goto L6;
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AppOpsUtil$init$callback$1$onAsyncNoted$1(r8, null), 3, null);
        return;
    }

    @Override // android.app.AppOpsManager.OnOpNotedCallback
    public final void onNoted(SyncNotedAppOp r11) {
        Intrinsics.checkNotNullParameter(r11, "op");
        FLogger.a.i("AppOpsUtil", "onNoted:" + r11.getOp() + ',' + r11.getAttributionTag());
        a r0 = a.a;
        if (AppHost.a.isTestChannel() == true) goto L5;
        return;
    L5:
        if (this.a == false) goto L7;
        List r1 = e.a();
    L8:
        Ref.ObjectRef r2 = new Ref.ObjectRef();
        r2.element = "";
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AppOpsUtil$init$callback$1$onNoted$1(r1, r11, r2, null), 3, null);
        return;
    L7:
        r1 = null;
        goto L8
    }

    @Override // android.app.AppOpsManager.OnOpNotedCallback
    public final void onSelfNoted(SyncNotedAppOp r11) {
        Intrinsics.checkNotNullParameter(r11, "op");
        FLogger.a.i("AppOpsUtil", "onSelfNoted:,attributionTag:" + r11.getAttributionTag());
        a r0 = a.a;
        if (AppHost.a.isTestChannel() == true) goto L5;
        return;
    L5:
        if (this.a == false) goto L7;
        List r1 = e.a();
    L8:
        Ref.ObjectRef r2 = new Ref.ObjectRef();
        r2.element = "";
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AppOpsUtil$init$callback$1$onSelfNoted$1(r1, r11, r2, null), 3, null);
        return;
    L7:
        r1 = null;
        goto L8
    }
}
