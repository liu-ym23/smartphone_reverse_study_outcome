package com.bytedance.android.livesdk.init;

import com.bytedance.android.live.core.launch.AbsTask;
import com.bytedance.android.live.core.launch.Task;
import com.bytedance.android.live.core.launch.WorkThreadTask;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.uikit.dialog.AlertDialog;
import com.bytedance.android.livesdk.config.q30;
import com.bytedance.android.livesdkapi.init.LiveInitAssistant;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@WorkThreadTask
@Task(businessInfo = "WTO_InternalServiceInitTask", value = 2)
public class InternalServiceInitTask extends AbsTask {
    public static /* synthetic */ boolean a() {
        return lambda$run$0();
    }

    private static /* synthetic */ boolean lambda$run$0() {
        return false;
    }

    public List<Integer> preTasks() {
        return Arrays.asList(new Integer[]{1});
    }

    public void run() {
        ALogger.i("ttlive_init", "InternalServiceInitTask run");
        AlertDialog.setNightMode(new b());
        com.bytedance.android.livesdk.service.l.d().getClass();
        ((com.bytedance.android.livesdk.service.i) com.bytedance.android.livesdk.service.k.b(com.bytedance.android.livesdk.service.i.class)).a().init();
        if (((Boolean) q30.a.getValue()).booleanValue() == false) goto L5;
        return;
    L5:
        if (LiveInitAssistant.INSTANCE.getInitConfigInner().isLiveInitArcOpt() == true) goto L9;
        initLiveIO();
        return;
    }

    private void initLiveIO() {
        com.bytedance.android.live.room.e r0 = is0.c.c().dnsOptimizer();
        if (r0 == null) goto L6;
        r0.sync();
        r0.b();
        return;
    }

    public InternalServiceInitTask() {
    }
}
