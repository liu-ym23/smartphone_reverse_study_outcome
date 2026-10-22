package com.obric.assistant.state.impl.v2.power;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.core.content.ContextCompat;
import com.bytedance.crash.Npth;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.larus.common.apphost.AppHost;
import com.obric.assistant.interaction.impl.window.helpers.OverlayPermissionGuideActivity;
import com.obric.assistant.state.api.v2.core.IObricDeviceStateService;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0006H\u0016J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0006H\u0016J\b\u0010\r\u001a\u00020\nH\u0002J\b\u0010\u000e\u001a\u00020\nH\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0018\u00010\bR\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/obric/assistant/state/impl/v2/power/ObricDeviceStateServiceImpl;", "Lcom/obric/assistant/state/api/v2/core/IObricDeviceStateService;", "<init>", "()V", "listeners", "Ljava/util/concurrent/CopyOnWriteArraySet;", "Lcom/obric/assistant/state/api/v2/core/IObricDeviceStateService$ScreenStateListener;", "receiver", "Lcom/obric/assistant/state/impl/v2/power/ObricDeviceStateServiceImpl$ScreenBroadcastReceiver;", "register", "", "listener", "unregister", "ensureReceiverRegistered", "unregisterReceiver", "ScreenBroadcastReceiver", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricDeviceStateServiceImpl implements IObricDeviceStateService {
    public final CopyOnWriteArraySet<IObricDeviceStateService.a> a;
    public a b;

    private final void unregisterReceiver() {
        BroadcastReceiver r0 = this.b;
        if (r0 == null) goto L17;
        Application r1 = AppHost.a.getApplication();
        ReceiverRegisterLancet.loge(r0, false);
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == true) goto L15;
        r1.unregisterReceiver(r0);
    L13:
        this.b = null;
        return;
    L15:
    L10:
        e = move-exception;
        Npth.addTag("unregisterReceiver", r0.toString());
        e.printStackTrace();
        goto L13
    L7:
        if (ReceiverRegisterAnrOptimizer.unregisterReceiverHasNonScreenFilter(r0, r1) == false) goto L13;
        r1.unregisterReceiver(r0);     // Catch: Exception -> L10
        goto L13
    }

    public ObricDeviceStateServiceImpl() {
        this.a = new CopyOnWriteArraySet();
    }

    public final void a(OverlayPermissionGuideActivity.screenStateListener.1 r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.a.remove(r2);
        if (this.a.isEmpty() == false) goto L6;
        unregisterReceiver();
        return;
    }

    public final void b(IObricDeviceStateService.a r11) {
        Intrinsics.checkNotNullParameter(r11, "listener");
        if (this.a.isEmpty() == true) goto L5;
    L37:
        this.a.add(r11);
        return;
    L5:
        if (this.b != null) goto L37;
        this.b = new a(this);
        IntentFilter r0 = new IntentFilter();
        r0.addAction("android.intent.action.SCREEN_OFF");
        r0.addAction("android.intent.action.SCREEN_ON");
        r0.addAction("android.intent.action.USER_PRESENT");
        Application r8 = AppHost.a.getApplication();
        a r9 = this.b;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L40;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L40:
    L32:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L36;
        ReceiverRegisterCrashOptimizer.registerReceiver(r9, r0);
        goto L37
    L36:
        throw e;
    L10:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L23;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r0) == false) goto L23;
        int r1 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r9, r0, 0, null, null, 2, r8).result;     // Catch: Exception -> L32
        if (r1 != 1) goto L16;
        r8.registerReceiver(r9, r0);     // Catch: Exception -> L32
    L39:
        goto L37
    L16:
        if (r1 != 2) goto L18;
        new Intent();     // Catch: Exception -> L32
        goto L39
    L18:
        if (r1 == 3) goto L39;
        r8.registerReceiver(r9, r0);     // Catch: Exception -> L32
    L23:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L26;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L32
        r8.registerReceiver(r9, r0, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L32
        goto L39
    L26:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L28;
    L30:
        r8.registerReceiver(r9, r0);     // Catch: Exception -> L32
        goto L39
    L28:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r0) == false) goto L30;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L32
        ContextCompat.registerReceiver(r8, r9, r0, null, ReceiverRegisterLancet.sProxyHandler, 2);     // Catch: Exception -> L32
        goto L39
    }
}
