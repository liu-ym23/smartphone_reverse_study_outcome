package g0;

import android.net.wifi.ScanResult;
import com.bytedance.bdlocation.scan.wifi.LBSLightWifiUtils;
import com.obric.cae.libs.useraware.WifiStandardData;
import com.obric.cae.smartNetwork.SmartNetworkService;
import com.obric.cae.userAware.report.CaeUserAwareReportBase;
import java.util.Comparator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class d implements Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7503a;

    public /* synthetic */ d(int r8) {
        this.f7503a = r8;
    }

    @Override // java.util.Comparator
    public final int compare(Object r8, Object r10) {
        switch(this.f7503a) {
            case 0: goto L9;
            case 1: goto L8;
            case 2: goto L6;
            default: goto L21;
        };
    L9:
        byte[] r11 = (byte[]) r8;
        byte[] r12 = (byte[]) r10;
        if (r11.length != r12.length) goto L19;
        int r13 = 0;
    L14:
        if (r13 >= r11.length) goto L25;
        byte r14 = r11[r13];
        byte r15 = r12[r13];
        if (r14 != r15) goto L24;
        r13 = r13 + 1;
        goto L14
    L24:
        return r14 - r15;
    L25:
        return 0;
    L19:
        return r11.length - r12.length;
    L6:
        return SmartNetworkService.a((Map.Entry) r8, (Map.Entry) r10);
    L8:
        return LBSLightWifiUtils.a((ScanResult) r8, (ScanResult) r10);
    L21:
        return CaeUserAwareReportBase.a((WifiStandardData) r8, (WifiStandardData) r10);
    }
}
