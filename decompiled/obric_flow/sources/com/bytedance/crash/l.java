package com.bytedance.crash;

import android.content.Context;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class l implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f4056a;

    public l(Context r5) {
        this.f4056a = r5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Map r5 = n.d().u();
        Object r10 = r5.get("update_version_code");
        if (r10 != null) goto L6;
    L12:
        int r11 = 0;
    L13:
        Object r12 = r5.get(WsConstants.KEY_APP_ID);
        if (r12 != null) goto L17;
    L23:
        int r13 = 4444;
    L24:
        String r14 = String.valueOf(r5.get("app_version"));
        MonitorCrash r15 = MonitorCrash.init(this.f4056a, String.valueOf(r13), r11, r14);
        if (r15 == null) goto L40;
        MonitorCrash.Config r16 = r15.config();
        i4.a r17 = n.d();
        r17.getClass();
        String r18 = ((ICommonParams) r17.f17503c).getDeviceId();     // Catch: Throwable -> L29
    L30:
        r16.setDeviceId(r18).setChannel(String.valueOf(r5.get(LynxMonitorService.KEY_CHANNEL)));
        return;
    L29:
        r18 = "";
        goto L30
    L40:
        return;
    L17:
        if ((r12 instanceof Integer) == false) goto L20;
        r13 = ((Integer) r12).intValue();
        goto L24
    L20:
        if ((r12 instanceof String) == false) goto L23;
        r13 = Integer.parseInt(String.valueOf(r12));     // Catch: Throwable -> L32
    L6:
        if ((r10 instanceof Integer) == false) goto L9;
        r11 = ((Integer) r10).intValue();
        goto L13
    L9:
        if ((r10 instanceof String) == false) goto L12;
        r11 = Integer.parseInt(String.valueOf(r10));     // Catch: Throwable -> L33
        goto L13
    }
}
