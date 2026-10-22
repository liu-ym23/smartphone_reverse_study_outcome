package ms.bd.c;

import android.text.TextUtils;
import com.bytedance.mobsec.metasec.ml.MSConfig;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public abstract class a2 extends c2 implements b2 {
    public c2 build0() {
        if (this.mClientType == (-1)) goto L6;
        return this;
    L6:
        throw new IllegalArgumentException("MSConfig init error");
    }

    public b2 setBDDeviceID0(String r1) {
        this.mBDDeviceID = r1;
        return this;
    }

    public b2 setChannel0(String r1) {
        this.mChannel = r1;
        return this;
    }

    public b2 setClientType0(int r1) {
        this.mClientType = r1;
        return this;
    }

    public b2 setCustomInfo0(Map<String, String> r1) {
        if (r1 != null) goto L4;
        r1 = new HashMap();
    L4:
        this.mCustomInfo = r1;
        return this;
    }

    public b2 setDefaultReportHost0(String r1) {
        this.mDefaultReportHost = r1;
        return this;
    }

    public b2 setDeviceID0(String r1) {
        this.mDeviceID = r1;
        return this;
    }

    public b2 setFetchedDidInterface0(MSConfig.Builder.IFetchedDid r1) {
        this.mFetchedDidIntf = r1;
        return this;
    }

    public b2 setInstallID0(String r1) {
        this.mInstallID = r1;
        return this;
    }

    public b2 setMsComplianceScene0(MSConfig.Builder.IMsComplianceScene r2) {
        u2.b.a = r2;
        return this;
    }

    public b2 setMsSettingConfig0(MSConfig.Builder.IMsSettingConfig r2) {
        v2.b.a = r2;
        return this;
    }

    public b2 setOVRegionType0(int r1) {
        this.mOVRegionType = r1;
        return this;
    }

    public b2 setSecssionID0(String r1) {
        this.mSessionID = r1;
        return this;
    }

    public b2 addAdvanceInfo0(String r2, String r3) {
        this.mAdvanceInfo.put(r2, r3);
        return this;
    }

    public a2(String r1, String r2, int r3) {
        this.mAppID = r1;
        this.mLicensetStr = r2;
        this.mCollectMode = r3;
        if (TextUtils.isEmpty(r1) == true) goto L10;
        if ("0".equals(r1) == true) goto L10;
        if (TextUtils.isEmpty(r2) == true) goto L10;
        return;
    L10:
        throw new IllegalArgumentException("appID or license must be set.");
    }

    public a2(String r1, String r2, String r3, int r4) {
        this.mSDKID = r1;
        this.mSubAppID = r2;
        this.mLicensetStr = r3;
        this.mCollectMode = r4;
        if (TextUtils.isEmpty(r1) == true) goto L12;
        if ("0".equals(r1) == true) goto L12;
        if (TextUtils.isEmpty(r2) == true) goto L12;
        if (TextUtils.isEmpty(r3) == true) goto L12;
        return;
    L12:
        throw new IllegalArgumentException("sdkID or license must be set.");
    }
}
