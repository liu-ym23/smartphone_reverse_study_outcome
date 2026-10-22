package com.bytedance.bdlocation.scan.wifi;

import android.net.wifi.ScanResult;
import com.obric.cae.smartNetwork.networkHandoverRL.NetworkSwitchDatabase;
import com.obric.cae.smartNetwork.networkHandoverRL.NetworkSwitchPolicyML;
import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class f implements Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3844a;

    public /* synthetic */ f(int r8) {
        this.f3844a = r8;
    }

    @Override // java.util.Comparator
    public final int compare(Object r8, Object r10) {
        switch(this.f3844a) {
            case 0: goto L6;
            default: goto L8;
        };
    L6:
        return WifiUtil.c((ScanResult) r8, (ScanResult) r10);
    L8:
        return NetworkSwitchDatabase.b((NetworkSwitchPolicyML.FeatureParams) r8, (NetworkSwitchPolicyML.FeatureParams) r10);
    }
}
