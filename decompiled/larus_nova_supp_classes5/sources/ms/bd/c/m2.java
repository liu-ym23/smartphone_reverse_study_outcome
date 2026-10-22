package ms.bd.c;

import com.bytedance.mobsec.metasec.ml.MSManagerUtils;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public interface m2 {
    Map frameSign(String r1, int r2);

    Map getFeatureHash(String r1, byte[] r2);

    Map getReportRaw(String r1, int r2, Map r3);

    String getToken();

    void postEventMessage(MSManagerUtils.MSBusinessHelper r1);

    void qurryMsRiskInfo(String r1, MSManagerUtils.IMsBundleCallback r2);

    void report(String r1, String r2);

    void setBDDeviceID(String r1);

    void setCollectMode(int r1);

    void setCustomInfo(Map r1, boolean r2);

    void setDeviceID(String r1);

    void setInstallID(String r1);

    void setMsSettingConfig(String r1);

    void setSessionID(String r1);
}
