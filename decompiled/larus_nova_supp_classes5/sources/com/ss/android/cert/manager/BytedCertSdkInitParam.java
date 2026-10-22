package com.ss.android.cert.manager;

import android.text.TextUtils;
import com.ss.android.cert.manager.ablity.ICertDialogDepend;
import com.ss.android.cert.manager.ablity.SettingsDelegate;
import com.ss.android.cert.manager.ablity.service.ICertRouterService;
import com.ss.android.cert.manager.ablity.service.animation.ICertAnimationService;
import com.ss.android.cert.manager.ablity.service.asr.IASRService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class BytedCertSdkInitParam {
    private ICertAnimationService animationService;
    private IAnnieXDepend annieXDepend;
    private IASRService asrService;
    private ICertDialogDepend certDialogDepend;
    private CnNetAuthParams cnNetAuthParams;
    private boolean enableReportQualityInfo;
    private List<FaceDetectCycleConfig> faceDetectCycleConfigs;
    private int infoDetectFrameBuff;
    private boolean isLocalTest;
    private boolean isScreenRecordDetect;
    private NfcParams nfcParams;
    private boolean optPermissionRequest;
    private PermissionParam permissionParam;
    private PluginParams pluginParams;
    private List<String> recordUploadFailVideoScenes;
    private boolean reportBadgerEnable;
    private long reportBadgerInterval;
    private boolean reportDepthCameraInfo;
    private int reportTimeout;
    private ICertRouterService routerService;
    private SettingsDelegate settingsDelegate;
    private boolean upgradeV3;
    private String webContainerType;
    private boolean withoutFaceDetect;

    public static class PermissionParam {
        private final Map<String, String> defaultUsageMap;
        private final Map<String, Map<String, String>> localizationUsageMap;
        private final boolean showMask;

        public Map<String, String> getDefaultUsageMap() {
            return this.defaultUsageMap;
        }

        public Map<String, Map<String, String>> getLocalizationUsageMap() {
            return this.localizationUsageMap;
        }

        public boolean isShowMask() {
            return this.showMask;
        }

        public boolean canShowMask(String r4) {
            if (this.showMask == true) goto L5;
            return false;
        L5:
            if (TextUtils.isEmpty(r4) == true) goto L11;
            Map<String, Map<String, String>> r0 = this.localizationUsageMap;
            if (r0 == null) goto L11;
            if (r0.containsKey(r4) == false) goto L11;
            return true;
        L11:
            Map<String, String> r5 = this.defaultUsageMap;
            if (r5 != null) goto L14;
            return false;
        L14:
            if (r5.isEmpty() == true) goto L19;
            return true;
        L19:
            return false;
        }

        public PermissionParam(boolean r1, Map<String, String> r2) {
            this.showMask = r1;
            this.defaultUsageMap = r2;
            this.localizationUsageMap = null;
        }

        public PermissionParam(boolean r1, Map<String, String> r2, Map<String, Map<String, String>> r3) {
            this.showMask = r1;
            this.defaultUsageMap = r2;
            this.localizationUsageMap = r3;
        }
    }

    public BytedCertSdkInitParam() {
        this.enableReportQualityInfo = true;
    }

    public ICertAnimationService getAnimationService() {
        return this.animationService;
    }

    public IAnnieXDepend getAnnieXDepend() {
        return this.annieXDepend;
    }

    public IASRService getAsrService() {
        return this.asrService;
    }

    public ICertDialogDepend getCertDialogDepend() {
        return this.certDialogDepend;
    }

    public CnNetAuthParams getCnNetAuthParams() {
        return this.cnNetAuthParams;
    }

    public List<FaceDetectCycleConfig> getFaceDetectCycleConfig() {
        return this.faceDetectCycleConfigs;
    }

    public int getInfoDetectFrameBuff() {
        return this.infoDetectFrameBuff;
    }

    public NfcParams getNfcParams() {
        return this.nfcParams;
    }

    public PermissionParam getPermissionParam() {
        return this.permissionParam;
    }

    public PluginParams getPluginParams() {
        return this.pluginParams;
    }

    public long getReportBadgerInterval() {
        return this.reportBadgerInterval;
    }

    public int getReportTimeout() {
        return this.reportTimeout;
    }

    public ICertRouterService getRouterService() {
        return this.routerService;
    }

    public SettingsDelegate getSettingsDelegate() {
        return this.settingsDelegate;
    }

    public String getWebContainerType() {
        return this.webContainerType;
    }

    public boolean isLocalTest() {
        return this.isLocalTest;
    }

    public boolean isOptPermissionRequest() {
        return this.optPermissionRequest;
    }

    public boolean isReportBadgerEnable() {
        return this.reportBadgerEnable;
    }

    public boolean isReportDepthCameraInfo() {
        return this.reportDepthCameraInfo;
    }

    public boolean isReportQualityInfo() {
        return this.enableReportQualityInfo;
    }

    public boolean isScreenRecordDetect() {
        return this.isScreenRecordDetect;
    }

    public boolean isUpgradeV3() {
        return this.upgradeV3;
    }

    public boolean isWithoutFaceDetect() {
        return this.withoutFaceDetect;
    }

    public boolean isRecordUploadFailVideo(String r2) {
        List<String> r0 = this.recordUploadFailVideoScenes;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.isEmpty() == false) goto L8;
        return false;
    L8:
        return this.recordUploadFailVideoScenes.contains(r2);
    }

    public BytedCertSdkInitParam setAnimationService(ICertAnimationService r1) {
        this.animationService = r1;
        return this;
    }

    public BytedCertSdkInitParam setAnnieXDepend(IAnnieXDepend r1) {
        this.annieXDepend = r1;
        return this;
    }

    public BytedCertSdkInitParam setAsrService(IASRService r1) {
        this.asrService = r1;
        return this;
    }

    public BytedCertSdkInitParam setCertDialogDepend(ICertDialogDepend r1) {
        this.certDialogDepend = r1;
        return this;
    }

    public BytedCertSdkInitParam setCnNetAuthParams(CnNetAuthParams r1) {
        this.cnNetAuthParams = r1;
        return this;
    }

    public BytedCertSdkInitParam setEnableReportQualityInfo(boolean r1) {
        this.enableReportQualityInfo = r1;
        return this;
    }

    public BytedCertSdkInitParam setFaceDetectCycleConfig(FaceDetectCycleConfig... r5) {
        if (this.faceDetectCycleConfigs != null) goto L5;
        this.faceDetectCycleConfigs = new ArrayList();
    L5:
        if (r5 == null) goto L12;
        int r0 = r5.length;
        int r1 = 0;
    L7:
        if (r1 >= r0) goto L12;
        FaceDetectCycleConfig r2 = r5[r1];
        if (r2 == null) goto L11;
        this.faceDetectCycleConfigs.add(r2);
    L11:
        r1 = r1 + 1;
    L12:
        return this;
    }

    public BytedCertSdkInitParam setInfoDetectFrameBuff(int r1) {
        this.infoDetectFrameBuff = r1;
        return this;
    }

    public BytedCertSdkInitParam setLocalTest(boolean r1) {
        this.isLocalTest = r1;
        return this;
    }

    public BytedCertSdkInitParam setNfcParams(NfcParams r1) {
        this.nfcParams = r1;
        return this;
    }

    public BytedCertSdkInitParam setOptPermissionRequest(boolean r1) {
        this.optPermissionRequest = r1;
        return this;
    }

    public BytedCertSdkInitParam setPermissionParam(PermissionParam r1) {
        this.permissionParam = r1;
        return this;
    }

    public BytedCertSdkInitParam setPluginParams(PluginParams r1) {
        this.pluginParams = r1;
        return this;
    }

    public BytedCertSdkInitParam setRecordUploadFailVideo(List<String> r1) {
        this.recordUploadFailVideoScenes = r1;
        return this;
    }

    public BytedCertSdkInitParam setReportBadgerEnable(boolean r1) {
        this.reportBadgerEnable = r1;
        return this;
    }

    public BytedCertSdkInitParam setReportBadgerInterval(long r1) {
        this.reportBadgerInterval = r1;
        return this;
    }

    public BytedCertSdkInitParam setReportDepthCameraInfo(boolean r1) {
        this.reportDepthCameraInfo = r1;
        return this;
    }

    public BytedCertSdkInitParam setReportTimeout(int r1) {
        this.reportTimeout = r1;
        return this;
    }

    public BytedCertSdkInitParam setRouterService(ICertRouterService r1) {
        this.routerService = r1;
        return this;
    }

    public BytedCertSdkInitParam setScreenRecordDetect(boolean r1) {
        this.isScreenRecordDetect = r1;
        return this;
    }

    public BytedCertSdkInitParam setSettingsDelegate(SettingsDelegate r1) {
        this.settingsDelegate = r1;
        return this;
    }

    public BytedCertSdkInitParam setUpgradeV3(boolean r1) {
        this.upgradeV3 = r1;
        return this;
    }

    public BytedCertSdkInitParam setWebContainerType(String r1) {
        this.webContainerType = r1;
        return this;
    }

    public BytedCertSdkInitParam setWithoutFaceDetect(boolean r1) {
        this.withoutFaceDetect = r1;
        return this;
    }

    public BytedCertSdkInitParam setFaceDetectCycleConfig(List<FaceDetectCycleConfig> r1) {
        this.faceDetectCycleConfigs = r1;
        return this;
    }
}
