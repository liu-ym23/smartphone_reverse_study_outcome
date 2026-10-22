package com.obric.cae.BWDL.BwdlDrop;

import com.obric.cae.cldReport.network.NetworkLogLevelConfig;
import com.obric.cae.location.geosdk.poi.StarAoiBoardManager;
import com.obric.cae.log.CaeLog;
import com.obric.cae.log.CommSenseLog;
import com.obric.cae.smartNetwork.throughtput.ApDataRecords;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5364a;

    public /* synthetic */ a(int r8) {
        this.f5364a = r8;
    }

    @Override // java.util.function.Function
    public final Object apply(Object r8) {
        switch(this.f5364a) {
            case 0: goto L20;
            case 1: goto L18;
            case 2: goto L16;
            case 3: goto L14;
            case 4: goto L12;
            case 5: goto L10;
            case 6: goto L8;
            case 7: goto L6;
            default: goto L22;
        };
    L6:
        return CommSenseLog.b((String) r8);
    L8:
        return CaeLog.a((String) r8);
    L10:
        return StarAoiBoardManager.f((String) r8);
    L12:
        return StarAoiBoardManager.j((String) r8);
    L14:
        return StarAoiBoardManager.k((String) r8);
    L16:
        return StarAoiBoardManager.a((String) r8);
    L18:
        return NetworkLogLevelConfig.a((Integer) r8);
    L20:
        return ((BwdlDropDeviceManager) r8).getBwdlDropSession();
    L22:
        return ApDataRecords.a((Integer) r8);
    }
}
