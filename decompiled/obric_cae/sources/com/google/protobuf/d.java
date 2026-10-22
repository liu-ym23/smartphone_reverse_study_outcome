package com.google.protobuf;

import com.obric.cae.BWDL.BwdlDrop.BwdlDropDeviceManager;
import com.obric.cae.cldReport.CldReportService;
import com.obric.cae.cldReport.logcat.LogcatLogLevelConfig;
import com.obric.cae.cldReport.wifi.WifiLogLevelConfig;
import com.obric.cae.location.geosdk.poi.StarAoiBoardManager;
import com.obric.cae.location.util.AoiBoardUtil;
import com.obric.cae.location.zpp.StarZppManager;
import com.obric.cae.log.CaeLog;
import com.obric.cae.log.CommSenseLog;
import com.obric.cae.runtime.CaeRuntime;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class d implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5193a;

    public /* synthetic */ d(int r8) {
        this.f5193a = r8;
    }

    @Override // java.util.function.Function
    public final Object apply(Object r8) {
        switch(this.f5193a) {
            case 0: goto L24;
            case 1: goto L22;
            case 2: goto L20;
            case 3: goto L18;
            case 4: goto L16;
            case 5: goto L14;
            case 6: goto L12;
            case 7: goto L10;
            case 8: goto L8;
            case 9: goto L6;
            default: goto L26;
        };
    L6:
        return CommSenseLog.c((String) r8);
    L8:
        return CaeLog.b((String) r8);
    L10:
        return StarZppManager.c((String) r8);
    L12:
        return AoiBoardUtil.a((String) r8);
    L14:
        return StarAoiBoardManager.l((Integer) r8);
    L16:
        return WifiLogLevelConfig.a((Integer) r8);
    L18:
        return LogcatLogLevelConfig.a((Integer) r8);
    L20:
        return CldReportService.a((String) r8);
    L22:
        return ((BwdlDropDeviceManager) r8).getBwdlDropSession();
    L24:
        return LegacyUnredactedTextFormat.legacyUnredactedStringValueOf(r8);
    L26:
        return CaeRuntime.a((Class) r8);
    }
}
