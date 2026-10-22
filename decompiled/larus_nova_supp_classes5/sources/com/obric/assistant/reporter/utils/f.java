package com.obric.assistant.reporter.utils;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.api.IAssistantInteractionServiceKt;
import com.obric.assistant.interaction.base.interact.KeyguardLockedState;
import com.obric.assistant.reporter.IObricReporter;
import com.obric.assistant.trace.IObricTraceParam;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import ow3.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class f implements b {
    public f() {
    }

    public final void a(String r4, JSONObject r5) {
        Intrinsics.checkNotNullParameter(r5, "flatParams");
        FLogger.a.i("ObricLaunchReportManager", "onPause: called, report app terminate activityName = " + r4 + ", flatParams = " + r5);
    }

    public final void b(String r7, JSONObject r8) {
        Intrinsics.checkNotNullParameter(r8, "flatParams");
        KeyguardLockedState r0 = IAssistantInteractionServiceKt.getInteractionStateService().getInteractionKeyguardLockedState();
        Object r1 = IAssistantInteractionServiceKt.getInteractionStateService().getWakeUpAppPkg();
        IObricReporter.a.getClass();
        IObricReporter r2 = IObricReporter.a.a();
        String r3 = null;
        if (r2 == null) goto L5;
        String r4 = r2.a();
    L6:
        IObricReporter r5 = IObricReporter.a.a();
        if (r5 == null) goto L9;
        Object r6 = r5.getWakeupSource();
    L11:
        if (r0 != KeyguardLockedState.UNLOCKED) goto L13;
        Object r9 = "unlocked_screen";
    L14:
        IObricReporter r10 = IObricReporter.a.a();
        if (r10 == null) goto L17;
        r3 = r10.l();
    L17:
        r8.put("obric_launch_method", r4);
        r8.put("obric_launch_position_level1", r9);
        r8.put("obric_launch_position_level2", r1);
        r8.put("obric_launch_service", r3);
        r8.put("obric_launch_wakeup", r6);
        IObricTraceParam r11 = (IObricTraceParam) ServiceManager.get().getService(IObricTraceParam.class);
        if (r11 == null) goto L20;
        r11.n(r8);
    L20:
        if (r4 == null) goto L23;
        if (r3 == null) goto L23;
        Object r12 = ObricLaunchReportManager.a(ObricLaunchReportManager.a, r4, r3);
    L24:
        r8.put("obric_window_mode", r12);
        FLogger.a.i("ObricLaunchReportManager", "onResume: called, report app launch activityName = " + r7 + ", flatParams = " + r8);
        return;
    L23:
        r12 = "unknown";
        goto L24
    L13:
        r9 = "lock_screen";
        goto L14
    L9:
        r6 = null;
        goto L11
    L5:
        r4 = null;
        goto L6
    }
}
