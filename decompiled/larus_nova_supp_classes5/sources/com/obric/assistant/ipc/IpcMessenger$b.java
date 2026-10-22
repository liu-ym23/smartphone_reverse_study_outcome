package com.obric.assistant.ipc;

import com.larus.account.base.api.ILoginService;
import com.larus.account.base.api.UserAction;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.device.obricDeviceManagerDelegate;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import n38.a;
import n38.j;
import q38.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class IpcMessenger$b implements j {
    public IpcMessenger$b() {
    }

    public final void a(a r13) {
        Intrinsics.checkNotNullParameter(r13, "event");
        String r0 = r13.b.a;
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        FLogger r1 = FLogger.a;
        r1.i("SvaSdkIPCService", "onUserDidOffline uid=" + com.obric.assistant.utils.j.d(r0) + " action=" + r13.c);
        k r2 = k.a;
        String r4 = "account_offline:" + r13.c + ':' + r13.d;
        r2.getClass();
        k.a(r4);
        HostStateSyncManager r3 = HostStateSyncManager.a;
        String r5 = "account_offline:" + r13.c + ':' + r13.d;
        r3.getClass();
        HostStateSyncManager.f(r5);
        int r6 = a.a[r13.c.ordinal()];
        if (r6 != 1) goto L8;
        IpcMessenger.a.getClass();
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new IpcMessenger.handleAccountSwitchAway.1(r0, null), 3, null);
        return;
    L8:
        if (r6 == 2) goto L10;
        r1.i("SvaSdkIPCService", "onUserDidOffline unexpected action=" + r13.c + ", skip");
        return;
    L10:
        IpcMessenger.a.getClass();
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new IpcMessenger.handleAccountLogout.1(r0, null), 3, null);
    }

    public final void b(a r10) {
        Intrinsics.checkNotNullParameter(r10, "event");
        String r0 = r10.b.a;
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        FLogger.a.i("SvaSdkIPCService", "onUserDidOnline uid=" + com.obric.assistant.utils.j.d(r0) + " action=" + r10.c);
        k r1 = k.a;
        String r2 = "account_online:" + r10.c + ':' + r10.d;
        r1.getClass();
        k.b(r2);
        HostStateSyncManager r3 = HostStateSyncManager.a;
        String r4 = "account_online:" + r10.c + ':' + r10.d;
        r3.getClass();
        HostStateSyncManager.f(r4);
        IpcMessenger.a.getClass();
        if (StringsKt.isBlank(r0) == false) goto L35;
    L33:
        IpcMessenger r5 = IpcMessenger.a;
        UserAction r11 = r10.c;
        r5.getClass();
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new IpcMessenger.handleAccountBecomeActive.1(r0, r11, null), 3, null);
        obricDeviceManagerDelegate.b.a();
        return;
    L35:
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L10
        Object r7 = Result.constructor-impl(ILoginService.a.getAccountInfo());     // Catch: Throwable -> L10
    L12:
        Throwable r8 = Result.exceptionOrNull-impl(r7);
        if (r8 == null) goto L16;
        FLogger.a.e("SvaSdkIPCService", "cacheAccountType getAccountInfo failed: " + r8.getMessage());
    L16:
        if (Result.isFailure-impl(r7) == false) goto L18;
        r7 = null;
    L18:
        q38.a r9 = (q38.a) r7;
        if (r9 == null) goto L21;
        String r12 = r9.c;
    L23:
        if (Intrinsics.areEqual(r12, r0) == false) goto L25;
        IpcMessenger.c.put(r0, Boolean.valueOf(r9.g));
        goto L33
    L25:
        b r13 = IpcMessenger.a();
        if (r13 == null) goto L33;
        if (Intrinsics.areEqual(r13.j(), r0) == true) goto L31;
        r13 = null;
    L31:
        if (r13 == null) goto L33;
        IpcMessenger.c.put(r0, Boolean.valueOf(r13.l()));
        goto L33
    L21:
        r12 = null;
    L10:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    }
}
