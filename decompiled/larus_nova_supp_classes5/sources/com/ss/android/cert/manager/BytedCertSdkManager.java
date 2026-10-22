package com.ss.android.cert.manager;

import com.ss.android.cert.manager.ablity.ICertDialogDepend;
import com.ss.android.cert.manager.ablity.SettingsDelegate;
import com.ss.android.cert.manager.ablity.service.CertServiceManager;
import com.ss.android.cert.manager.ablity.service.ICertRouterService;
import com.ss.android.cert.manager.ablity.service.animation.ICertAnimationService;
import com.ss.android.cert.manager.ablity.service.asr.IASRService;
import dta.b;
import dta.c;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class BytedCertSdkManager {
    private static BytedCertSdkManager instance;
    private BytedCertSdkInitParam initParam;

    public BytedCertSdkManager() {
    }

    public static /* synthetic */ Object a(String r0) {
        return lambda$getSettingsDelegate$0(r0);
    }

    public static /* synthetic */ Object b(String r0) {
        return lambda$getSettingsDelegate$1(r0);
    }

    private static /* synthetic */ Object lambda$getSettingsDelegate$0(String r0) {
        return null;
    }

    private static /* synthetic */ Object lambda$getSettingsDelegate$1(String r0) {
        return null;
    }

    public static BytedCertSdkManager getInstance() {
        if (instance != null) goto L15;
        monitor-enter(BytedCertSdkManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (instance != null) goto L9;
        instance = new BytedCertSdkManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(BytedCertSdkManager.class);     // Catch: Throwable -> L11
    L15:
        return instance;
    }

    public BytedCertSdkInitParam.IAnnieXDepend getAnnieXDepend() {
        BytedCertSdkInitParam r0 = this.initParam;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getAnnieXDepend();
    }

    public ICertDialogDepend getCertDialogDepend() {
        BytedCertSdkInitParam r0 = this.initParam;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getCertDialogDepend();
    }

    public BytedCertSdkInitParam.CnNetAuthParams getCnNetAuthParams() {
        BytedCertSdkInitParam r0 = this.initParam;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getCnNetAuthParams();
    }

    public List<BytedCertSdkInitParam.FaceDetectCycleConfig> getFaceDetectCycleConfig() {
        BytedCertSdkInitParam r0 = this.initParam;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getFaceDetectCycleConfig();
    }

    public int getInfoDetectFrameBuff() {
        BytedCertSdkInitParam r0 = this.initParam;
        if (r0 != null) goto L7;
        return 10;
    L7:
        return r0.getInfoDetectFrameBuff();
    }

    public BytedCertSdkInitParam.NfcParams getNfcParams() {
        BytedCertSdkInitParam r0 = this.initParam;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getNfcParams();
    }

    public BytedCertSdkInitParam.PermissionParam getPermissionParam() {
        BytedCertSdkInitParam r0 = this.initParam;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getPermissionParam();
    }

    public BytedCertSdkInitParam.PluginParams getPluginParams() {
        BytedCertSdkInitParam r0 = this.initParam;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getPluginParams();
    }

    public long getReportBadgerInterval() {
        BytedCertSdkInitParam r0 = this.initParam;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getReportBadgerInterval();
    }

    public int getReportTimeout() {
        BytedCertSdkInitParam r0 = this.initParam;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getReportTimeout();
    }

    public SettingsDelegate getSettingsDelegate() {
        BytedCertSdkInitParam r0 = this.initParam;
        if (r0 == null) goto L5;
        SettingsDelegate r1 = r0.getSettingsDelegate();
        if (r1 == null) goto L9;
        return r1;
    L9:
        return new c();
    L5:
        return new b();
    }

    public String getWebContainerType() {
        BytedCertSdkInitParam r0 = this.initParam;
        if (r0 != null) goto L7;
        return "";
    L7:
        return r0.getWebContainerType();
    }

    public boolean isLocalTest() {
        BytedCertSdkInitParam r0 = this.initParam;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isLocalTest();
    }

    public boolean isOptPermissionRequest() {
        BytedCertSdkInitParam r0 = this.initParam;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isOptPermissionRequest();
    }

    public boolean isReportBadgerEnable() {
        BytedCertSdkInitParam r0 = this.initParam;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isReportBadgerEnable();
    }

    public boolean isReportDepthCameraInfo() {
        BytedCertSdkInitParam r0 = this.initParam;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isReportDepthCameraInfo();
    }

    public boolean isReportQualityInfo() {
        BytedCertSdkInitParam r0 = this.initParam;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isReportQualityInfo();
    }

    public boolean isScreenRecordDetect() {
        BytedCertSdkInitParam r0 = this.initParam;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isScreenRecordDetect();
    }

    public boolean isUpgradeV3() {
        BytedCertSdkInitParam r0 = this.initParam;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isUpgradeV3();
    }

    public boolean withFaceDetect() {
        BytedCertSdkInitParam r0 = this.initParam;
        if (r0 != null) goto L6;
        return true;
    L6:
        return !r0.isWithoutFaceDetect();
    }

    public void init(BytedCertSdkInitParam r4) {
        this.initParam = r4;
        if (r4 == null) goto L14;
        IASRService r0 = r4.getAsrService();
        if (r0 == null) goto L7;
        CertServiceManager.getInst().registerService(IASRService.class, r0);
    L7:
        ICertRouterService r1 = r4.getRouterService();
        if (r1 == null) goto L10;
        CertServiceManager.getInst().registerService(ICertRouterService.class, r1);
    L10:
        ICertAnimationService r5 = r4.getAnimationService();
        if (r5 == null) goto L15;
        CertServiceManager.getInst().registerService(ICertAnimationService.class, r5);
        return;
    L15:
        return;
    }

    public boolean isRecordUploadFailVideo(String r2) {
        BytedCertSdkInitParam r0 = this.initParam;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isRecordUploadFailVideo(r2);
    }
}
