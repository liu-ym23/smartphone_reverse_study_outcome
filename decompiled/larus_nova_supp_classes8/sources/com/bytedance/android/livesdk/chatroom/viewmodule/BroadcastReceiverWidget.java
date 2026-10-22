package com.bytedance.android.livesdk.chatroom.viewmodule;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.livesdk.action.ActionManager;
import com.bytedance.crash.Npth;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/BroadcastReceiverWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "<init>", "()V", "ADBBroadcastReceiver", "a", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BroadcastReceiverWidget extends LiveRecyclableWidget {
    public static final /* synthetic */ int b = 0;
    public final ADBBroadcastReceiver a;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/BroadcastReceiverWidget$ADBBroadcastReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ADBBroadcastReceiver extends BroadcastReceiver {
        public ADBBroadcastReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context r2, Intent r3) {
            if (r3 == null) goto L4;
            String r4 = r3.getStringExtra("scheme");
        L5:
            ALogger.i("livesdk.adb.debug", "scheme: " + r4);
            if (TextUtils.isEmpty(r4) == true) goto L11;
            int r5 = BroadcastReceiverWidget.b;
            if (com.bytedance.android.live.core.utils.v.a() == false) goto L12;
            ActionManager.getInstance().action(r4);
            return;
        L12:
            return;
        L11:
            return;
        L4:
            r4 = null;
            goto L5
        }
    }

    public static final class a {
    }

    static {
    }

    public final void onInit(Object[] r1) {
    }

    public BroadcastReceiverWidget() {
        this.a = new ADBBroadcastReceiver();
    }

    public final void onUnload() {
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.d(this);
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L20;
        Context r0 = ((Widget) this).context;
        if (r0 == null) goto L21;
        ADBBroadcastReceiver r1 = this.a;
        ReceiverRegisterLancet.loge(r1, false);
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == true) goto L18;
        r0.unregisterReceiver(r1);
        return;
    L18:
    L12:
        e = move-exception;
        if (r1 == null) goto L15;
        Npth.addTag("unregisterReceiver", r1.toString());
    L15:
        e.printStackTrace();
        return;
    L9:
        if (ReceiverRegisterAnrOptimizer.unregisterReceiverHasNonScreenFilter(r1, r0) == false) goto L22;
        r0.unregisterReceiver(r1);     // Catch: Exception -> L12
        return;
    L22:
        return;
    L21:
        return;
    }

    public final void onLoad(Object[] r13) {
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.c(this);
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L76;
        IntentFilter r14 = new IntentFilter();
        r14.addAction("livesdk.adb.debug");
        if (Build.VERSION.SDK_INT < 34) goto L37;
        Context r10 = ((Widget) this).context;
        if (r10 == null) goto L77;
        ADBBroadcastReceiver r11 = this.a;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L70;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L70:
    L32:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L36;
        ReceiverRegisterCrashOptimizer.registerReceiver(r11, r14, 2);
        return;
    L36:
        throw e;
    L12:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L23;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r14) == false) goto L23;
        int r0 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r11, r14, 2, null, null, 3, r10).result;     // Catch: Exception -> L32
        if (r0 == 1) goto L21;
        if (r0 == 2) goto L20;
        if (r0 == 3) goto L69;
        r10.registerReceiver(r11, r14, 2);     // Catch: Exception -> L32
    L69:
        return;
    L20:
        new Intent();     // Catch: Exception -> L32
        goto L69
    L21:
        r10.registerReceiver(r11, r14, 2);     // Catch: Exception -> L32
    L23:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L26;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L32
        r10.registerReceiver(r11, r14, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L32
        goto L69
    L26:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L28;
    L30:
        r10.registerReceiver(r11, r14, 2);     // Catch: Exception -> L32
        goto L69
    L28:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r14) == false) goto L30;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L32
        ContextCompat.registerReceiver(r10, r11, r14, null, ReceiverRegisterLancet.sProxyHandler, 2);     // Catch: Exception -> L32
        goto L69
    L77:
        return;
    L37:
        Context r12 = ((Widget) this).context;
        if (r12 == null) goto L79;
        ADBBroadcastReceiver r15 = this.a;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L73;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L73:
    L63:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L67;
        ReceiverRegisterCrashOptimizer.registerReceiver(r15, r14);
        return;
    L67:
        throw e;
    L43:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L54;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r14) == false) goto L54;
        int r1 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r15, r14, 0, null, null, 2, r12).result;     // Catch: Exception -> L63
        if (r1 == 1) goto L52;
        if (r1 == 2) goto L51;
        if (r1 == 3) goto L72;
        r12.registerReceiver(r15, r14);     // Catch: Exception -> L63
    L72:
        return;
    L51:
        new Intent();     // Catch: Exception -> L63
        goto L72
    L52:
        r12.registerReceiver(r15, r14);     // Catch: Exception -> L63
    L54:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L57;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L63
        r12.registerReceiver(r15, r14, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L63
        goto L72
    L57:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L59;
    L61:
        r12.registerReceiver(r15, r14);     // Catch: Exception -> L63
        goto L72
    L59:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r14) == false) goto L61;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L63
        ContextCompat.registerReceiver(r12, r15, r14, null, ReceiverRegisterLancet.sProxyHandler, 2);     // Catch: Exception -> L63
        goto L72
    L79:
        return;
    }
}
