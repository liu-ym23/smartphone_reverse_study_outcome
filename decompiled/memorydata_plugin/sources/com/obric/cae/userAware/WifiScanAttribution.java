package com.obric.cae.userAware;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class WifiScanAttribution {
    static final WifiScanAttribution INVALID = null;
    private final int sceneId;
    private final int sourceId;

    static {
        INVALID = new WifiScanAttribution(-1, -1);
    }

    public WifiScanAttribution(int r1, int r2) {
        this.sourceId = r1;
        this.sceneId = r2;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, WifiScanAttribution.class) == true) goto L8;
        return false;
    L8:
        WifiScanAttribution r6 = (WifiScanAttribution) ZeusTransformUtils.preCheckCast(r5, WifiScanAttribution.class, "com.obric.memorydata.plugin");
        if (this.sourceId != r6.sourceId) goto L14;
        if (this.sceneId != r6.sceneId) goto L14;
        return true;
    L14:
        return false;
    }

    public int getSceneId() {
        return this.sceneId;
    }

    public int getSourceId() {
        return this.sourceId;
    }

    public int getWifiScanCountSceneType() {
        if (shouldReportToWifiScanCount() == true) goto L7;
        return -1;
    L7:
        return this.sceneId;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(this.sourceId), Integer.valueOf(this.sceneId)});
    }

    public boolean isHomeCompanyAware() {
        if (this.sourceId == 1) goto L5;
    L7:
        return false;
    L5:
        if (WifiScanSceneType.isHomeCompanyAwareScene(this.sceneId) == false) goto L7;
        return true;
    }

    public boolean shouldReportToWifiScanCount() {
        if (this.sourceId == 1) goto L5;
    L7:
        return false;
    L5:
        if (WifiScanSceneType.isWifiScanCountScene(this.sceneId) == false) goto L7;
        return true;
    }

    public String toString() {
        return "WifiScanAttribution{sourceId=" + this.sourceId + ", sceneId=" + this.sceneId + '}';
    }
}
