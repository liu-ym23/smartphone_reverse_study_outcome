package com.bytedance.android.livesdk.chatroom.widget.landscape;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.crash.Npth;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/widget/landscape/LandscapeBatteryInfoWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LandscapeBatteryInfoWidget extends LiveRecyclableWidget {
    public TextView a;
    public LandscapeBatteryView b;
    public int c;
    public int d;
    public int e;
    public final LandscapeBatteryInfoWidget$batteryReceiver$1 f;

    public final int getLayoutId() {
        return 2131568016;
    }

    public final void onUnload() {
        ALogger.i("LandscapeBattery", "onUnload");
        Context r0 = ((Widget) this).context;     // Catch: Exception -> L15
        LandscapeBatteryInfoWidget$batteryReceiver$1 r2 = this.f;     // Catch: Exception -> L15
        ReceiverRegisterLancet.loge(r2, false);     // Catch: Exception -> L15
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == true) goto L18;
        r0.unregisterReceiver(r2);     // Catch: Exception -> L15
        return;
    L18:
    L9:
        e = move-exception;
        if (r2 == null) goto L12;
        Npth.addTag("unregisterReceiver", r2.toString());     // Catch: Exception -> L15
    L12:
        e.printStackTrace();     // Catch: Exception -> L15
        return;
    L6:
        if (ReceiverRegisterAnrOptimizer.unregisterReceiverHasNonScreenFilter(r2, r0) == false) goto L21;
        r0.unregisterReceiver(r2);     // Catch: Exception -> L9
    L23:
        return;
    L21:
        return;
    L15:
        e = move-exception;
        ALogger.e("LandscapeBattery", e.toString());
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.bytedance.android.livesdk.chatroom.widget.landscape.LandscapeBatteryInfoWidget$batteryReceiver$1] */
    public LandscapeBatteryInfoWidget() {
        this.c = -1;
        this.d = -1;
        this.e = -1;
        this.f = new LandscapeBatteryInfoWidget$batteryReceiver$1(this);
    }

    public final void onInit(Object[] r2) {
        ALogger.i("LandscapeBattery", "onInit");
        this.a = (TextView) ((Widget) this).contentView.findViewById(2131390216);
        this.b = (LandscapeBatteryView) ((Widget) this).contentView.findViewById(2131364012);
    }

    public final void onLoad(Object[] r10) {
        ALogger.i("LandscapeBattery", "onLoad");
        IntentFilter r11 = new IntentFilter("android.intent.action.BATTERY_CHANGED");
        Context r0 = ((Widget) this).context;
        LandscapeBatteryInfoWidget$batteryReceiver$1 r8 = this.f;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L36;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L36:
    L29:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L35;
        Intent r12 = ReceiverRegisterCrashOptimizer.registerReceiver(r8, r11);
    L33:
        wq(r12);
        UtilityKotlinExtentionsKt.s(0, false, false, new LandscapeBatteryInfoWidget$refreshUI$1(this), 7);
        return;
    L35:
        throw e;
    L6:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L20;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r11) == false) goto L20;
        ReceiverRegisterAnrOptimizer.ResultWrapper r1 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r8, r11, 0, null, null, 2, r0);     // Catch: Exception -> L29
        int r2 = r1.result;     // Catch: Exception -> L29
        if (r2 != 1) goto L12;
        r12 = r0.registerReceiver(r8, r11);     // Catch: Exception -> L29
        goto L33
    L12:
        if (r2 != 2) goto L14;
        r12 = new Intent();     // Catch: Exception -> L29
        goto L33
    L14:
        if (r2 == 3) goto L16;
        r12 = r0.registerReceiver(r8, r11);     // Catch: Exception -> L29
        goto L33
    L16:
        r12 = r1.intent;     // Catch: Exception -> L29
    L20:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L23;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L29
        r12 = r0.registerReceiver(r8, r11, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L29
        goto L33
    L23:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L25;
    L27:
        r12 = r0.registerReceiver(r8, r11);     // Catch: Exception -> L29
        goto L33
    L25:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r11) == false) goto L27;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L29
        r12 = ContextCompat.registerReceiver(r0, r8, r11, null, ReceiverRegisterLancet.sProxyHandler, 2);     // Catch: Exception -> L29
        goto L33
    }

    public final void wq(Intent r3) {
        if (r3 == null) goto L6;
        Bundle r0 = r3.getExtras();
        if (r0 == null) goto L6;
        int r1 = r0.getInt("scale");
    L7:
        this.c = r1;
        if (r3 == null) goto L12;
        Bundle r2 = r3.getExtras();
        if (r2 == null) goto L12;
        int r4 = r2.getInt("level");
    L13:
        this.d = r4;
        if (r3 == null) goto L18;
        Bundle r5 = r3.getExtras();
        if (r5 == null) goto L18;
        int r6 = r5.getInt("status");
    L19:
        this.e = r6;
        ALogger.i("LandscapeBattery", "receive data = " + this.c + "  current = " + this.d + "   status = " + this.e);
        return;
    L18:
        r6 = 1;
    L12:
        r4 = this.c;
    L6:
        r1 = 100;
        goto L7
    }
}
