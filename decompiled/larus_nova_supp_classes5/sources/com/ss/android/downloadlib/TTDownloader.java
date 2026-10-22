package com.ss.android.downloadlib;

import android.content.Context;
import android.text.TextUtils;
import com.ss.android.download.api.ActionDecisionApi;
import com.ss.android.download.api.DownloadConfigure;
import com.ss.android.download.api.DownloadReverseExperimentInterface;
import com.ss.android.download.api.ITTDownloader;
import com.ss.android.download.api.PreDownloadManager;
import com.ss.android.download.api.config.DownloadConfigureInterceptor;
import com.ss.android.download.api.config.IDownloadButtonClickListener;
import com.ss.android.download.api.config.OnItemClickListener;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.download.DownloadStatusChangeListener;
import com.ss.android.download.api.download.DownloadStatusChangeListenerForInstall;
import com.ss.android.download.api.download.extend.DownloadCompletedListener;
import com.ss.android.download.api.settings.TTDownloadSettingsAdapter;
import com.ss.android.download.api.settings.TTDownloadSettingsModel;
import com.ss.android.downloadad.api.AdDownloadCompletedEventHandler;
import com.ss.android.downloadad.api.AdWebViewDownloadManager;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.downloadad.api.model.NativeDownloadModel;
import com.ss.android.downloadlib.addownload.ActionDecisionImpl;
import com.ss.android.downloadlib.addownload.AdQuickAppManager;
import com.ss.android.downloadlib.addownload.CommonDownloadHandler;
import com.ss.android.downloadlib.addownload.DownloadInstallCorrectHelper;
import com.ss.android.downloadlib.addownload.DownloadRetainHelper;
import com.ss.android.downloadlib.addownload.DownloadTaskKeyManager;
import com.ss.android.downloadlib.addownload.DownloadTaskQueueManagementManager;
import com.ss.android.downloadlib.addownload.GlobalInfo;
import com.ss.android.downloadlib.addownload.MarketDownloadRetainHelper;
import com.ss.android.downloadlib.addownload.MockNotificationProgressHandlerManager;
import com.ss.android.downloadlib.addownload.OrderDownloaderRetainHelper;
import com.ss.android.downloadlib.addownload.ReserveWifiStatusImpl;
import com.ss.android.downloadlib.addownload.config.TTDownloaderConfigure;
import com.ss.android.downloadlib.addownload.dialog.AdDownloadDialogManager;
import com.ss.android.downloadlib.addownload.manager.DownloadInstallHelper;
import com.ss.android.downloadlib.addownload.model.DownloadInstallInfo;
import com.ss.android.downloadlib.addownload.model.ModelManager;
import com.ss.android.downloadlib.addownload.upload.DeviceInfoReporter;
import com.ss.android.downloadlib.downloader.AppDownloadLaunchResumeListener;
import com.ss.android.downloadlib.downloader.InnerEventListenerImpl;
import com.ss.android.downloadlib.downloader.NewDownloadCompletedEventDispatcher;
import com.ss.android.downloadlib.downloader.NewDownloadDepend;
import com.ss.android.downloadlib.exception.Safe;
import com.ss.android.downloadlib.install.BeforeAppInstallInterceptorManager;
import com.ss.android.downloadlib.scheme.SchemeListHelper;
import com.ss.android.downloadlib.utils.AsyncTaskUtils;
import com.ss.android.downloadlib.utils.DownloadManagementManager;
import com.ss.android.downloadlib.utils.InitCompatibilityUtils;
import com.ss.android.downloadlib.utils.ToolUtils;
import com.ss.android.socialbase.appdownloader.AppDownloader;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.constants.DownloadStatus;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class TTDownloader implements ITTDownloader {
    private static volatile TTDownloader sInstance;
    private final AdDownloadCompletedEventHandler mAdDownloadCompletedEventHandler;
    private AdWebViewDownloadManager mAdWebViewDownloadManager;
    private final DownloadConfigure mDownloadConfigure;
    private final DownloadDispatcher mDownloadDispatcher;
    private final DownloadReverseExperimentInterface mDownloadReverseExperimentInterface;
    private long mLastActiveTimpstamp;
    private PreDownloadManager mPreDownloadManager;

    public static /* synthetic */ void a(TTDownloader r0, String r1, boolean r2) {
        r0.lambda$cancelAndDeleteModel$0(r1, r2);
    }

    @Override // com.ss.android.download.api.ITTDownloader
    public AdWebViewDownloadManager getAdWebViewDownloadManager() {
        if (this.mAdWebViewDownloadManager != null) goto L6;
        this.mAdWebViewDownloadManager = AdWebViewDownloadManagerImpl.inst();
    L6:
        return this.mAdWebViewDownloadManager;
    }

    public List<DownloadModel> getDownloadPauseTask() {
        ArrayList r0 = new ArrayList();
        if (GlobalInfo.getContext() != null) goto L5;
        return r0;
    L5:
        List r1 = Downloader.getInstance(GlobalInfo.getContext()).getUnCompletedDownloadInfosWithMimeType(DownloadConstants.MIME_APK);
        if (r1 != null) goto L8;
    L18:
        return r0;
    L8:
        if (r1.size() == 0) goto L18;
        Iterator r2 = r1.iterator();
    L12:
        if (r2.hasNext() == false) goto L18;
        DownloadInfo r3 = (DownloadInfo) r2.next();
        if ((-2) != r3.getStatus()) goto L12;
        NativeDownloadModel r4 = ModelManager.getInstance().getNativeModelByInfo(r3);
        if (r4 == null) goto L12;
        r0.add(r4.getModel());
        goto L12
    }

    public List<DownloadModel> getDownloadingTask() {
        ArrayList r0 = new ArrayList();
        Context r1 = GlobalInfo.getContext();
        if (r1 != null) goto L5;
        return r0;
    L5:
        List r2 = AppDownloader.getInstance().getDownloadingDownloadInfosWithMimeType(r1);
        if (r2 != null) goto L8;
    L18:
        return r0;
    L8:
        if (r2.size() == 0) goto L18;
        Iterator r3 = r2.iterator();
    L12:
        if (r3.hasNext() == false) goto L18;
        DownloadInfo r4 = (DownloadInfo) r3.next();
        if (DownloadStatus.isDownloading(r4.getStatus()) == false) goto L12;
        NativeDownloadModel r5 = ModelManager.getInstance().getNativeModelByInfo(r4);
        if (r5 == null) goto L12;
        r0.add(r5.getModel());
        goto L12
    }

    public PreDownloadManager getPreDownloadManager() {
        if (this.mPreDownloadManager != null) goto L6;
        this.mPreDownloadManager = PreDownloadMangerImpl.getInstance();
    L6:
        return this.mPreDownloadManager;
    }

    public void clearAllData() {
        DownloadComponentManager.getInstance().clearAllData();
    }

    public void clearApkAndData() {
        DownloadComponentManager.getInstance().clearApkAndData();
    }

    public void destroy() {
        DownloadComponentManager.getInstance().destroyComponents();
    }

    public DataProvider getDataProvider() {
        return DataProvider.getInstance();
    }

    public AdDownloadDialogManager getDialogManager() {
        return AdDownloadDialogManager.Instance();
    }

    public DownloadManagementManager getDownloadManagementManager() {
        return DownloadManagementManager.getInstance();
    }

    public JSONObject getDownloadModelInfo() {
        return DeviceInfoReporter.report();
    }

    public JSONObject getDownloadModelInfoWithoutSettings() {
        return DeviceInfoReporter.reportWithoutSettings();
    }

    public OrderDownloader getOrderDownloader() {
        return OrderDownloader.getInstance();
    }

    public String getSDKVersion() {
        return GlobalInfo.getSdkVersion();
    }

    public SchemeListHelper getSchemeListHelper() {
        return SchemeListHelper.inst();
    }

    public void updateLastActiveTimpstamp() {
        this.mLastActiveTimpstamp = System.currentTimeMillis();
    }

    private DownloadDispatcher getDownloadDispatcher() {
        return this.mDownloadDispatcher;
    }

    @Override // com.ss.android.download.api.ITTDownloader
    public AdDownloadCompletedEventHandler getAdDownloadCompletedEventHandler() {
        return this.mAdDownloadCompletedEventHandler;
    }

    @Override // com.ss.android.download.api.ITTDownloader
    public DownloadConfigure getDownloadConfigure() {
        return this.mDownloadConfigure;
    }

    public DownloadReverseExperimentInterface getDownloadReverseExperimentInterface() {
        return this.mDownloadReverseExperimentInterface;
    }

    public long getLastActiveTimpstamp() {
        return this.mLastActiveTimpstamp;
    }

    private TTDownloader(Context r3) {
        this.mDownloadDispatcher = DownloadDispatcher.getInstance();
        this.mDownloadConfigure = new DownloadConfigureImpl();
        this.mDownloadReverseExperimentInterface = new DownloadReverseExperimentInterfaceImpl();
        this.mLastActiveTimpstamp = System.currentTimeMillis();
        init(r3);
        DownloadInstallCorrectHelper.getInstance().recoverInstallCorrectTimeStamp();
        DownloadRetainHelper.getInstance().recoverUnInstalledPushRetainTimeStamp();
        DownloadRetainHelper.getInstance().recoverUnFinishedPushRetainTimeStamp();
        MarketDownloadRetainHelper.INSTANCE.recoverMarketDownloadRecordForReboot();
        OrderDownloaderRetainHelper.getInstance().recoverUnInstalledOrderDownloadPushTimeStamp();
        OrderDownloaderRetainHelper.getInstance().recoverUnInstalledOrderDownloadMessageTimeStamp();
        DownloadTaskQueueManagementManager.getInstance().tryRecoverDownloadTaskQueue();
        this.mAdDownloadCompletedEventHandler = AdDownloadCompletedEventHandlerImpl.getInstance();
    }

    public static /* synthetic */ TTDownloader access$002(TTDownloader r0) {
        sInstance = r0;
        return r0;
    }

    public static /* synthetic */ DownloadDispatcher access$200(TTDownloader r0) {
        return r0.getDownloadDispatcher();
    }

    private void init(Context r8) {
        GlobalInfo.setContext(r8);
        Downloader.getInstance(GlobalInfo.getContext());
        ModelManager.getInstance().init();
        AppDownloader.getInstance().init(GlobalInfo.getContext(), "misc_config", new NewDownloadDepend(), new NewDownloadCompletedEventDispatcher(r8), new BaseDownloadMonitorListener());
        AppDownloadLaunchResumeListener r0 = new AppDownloadLaunchResumeListener();
        AppDownloader.getInstance().setAppDownloadLaunchResumeListener(r0);
        Downloader.getInstance(r8).registerDownloadCacheSyncListener(r0);
        AppDownloader.getInstance().setReserveWifiStatusListener(new ReserveWifiStatusImpl());
        com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.setDownloadEventListener(new InnerEventListenerImpl());
        AppDownloader.getInstance().setBeforeAppInstallInterceptor(BeforeAppInstallInterceptorManager.getInstance());
        AppDownloader.getInstance().setMockNotificationProgressHandler(MockNotificationProgressHandlerManager.getInstance());
    }

    public static TTDownloader inst(Context r2) {
        if (sInstance != null) goto L15;
        monitor-enter(TTDownloader.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        Safe.noCatch(new 1(r2));     // Catch: Throwable -> L11
    L9:
        monitor-exit(TTDownloader.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    @Override // com.ss.android.download.api.ITTDownloader
    public void addDownloadCompletedListener(DownloadCompletedListener r2) {
        getDownloadDispatcher().addDownloadCompletedListener(r2);
    }

    @Override // com.ss.android.download.api.ITTDownloader
    public void cancel(String r2) {
        Safe.noCatch(new 18(this, r2));
    }

    public DownloadConfigure getDownloadConfigure(String r3) {
        DownloadConfigureInterceptor r0 = DownloadConfigureInterceptorHolder.getInstance().getDownloadConfigureInterceptor();
        if (r0 == null) goto L9;
        if (r0.shouldIntercept(r3) == false) goto L9;
        return r0.getDownloadConfigure(r3);
    L9:
        return this.mDownloadConfigure;
    }

    @Override // com.ss.android.download.api.ITTDownloader
    public DownloadInfo getDownloadInfo(String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L7;
        return null;
    L7:
        return AppDownloader.getInstance().getAppDownloadInfo(GlobalInfo.getContext(), r3);
    }

    public String getDownloadTaskKey(DownloadModel r2) {
        if ((r2 instanceof AdDownloadModel) == true) goto L5;
        return null;
    L5:
        return DownloadTaskKeyManager.getInstance().getDownloadTaskKey((AdDownloadModel) r2);
    }

    public boolean isInstalledAppByAdId(long r2) {
        return ToolUtils.isInstalledApp(ModelManager.getInstance().getDownloadModel(r2));
    }

    @Override // com.ss.android.download.api.ITTDownloader
    public boolean isStarted(String r2) {
        return getDownloadDispatcher().isStarted(r2);
    }

    @Override // com.ss.android.download.api.ITTDownloader
    public void removeDownloadCompletedListener(DownloadCompletedListener r2) {
        getDownloadDispatcher().removeDownloadCompletedListener(r2);
    }

    public void setDownloadConfig(TTDownloaderConfigure r2) {
        if (r2 != null) goto L4;
        r2 = TTDownloaderConfigure.build(new 2(this));
    L4:
        InitCompatibilityUtils.combine(r2, this.mDownloadConfigure);
    }

    public void unBindQuickApp(long r2) {
        AdQuickAppManager.getsInstance().unBindQuickApp(r2);
    }

    public /* synthetic */ TTDownloader(Context r1, 1 r2) {
        this(r1);
    }

    private /* synthetic */ void lambda$cancelAndDeleteModel$0(String r4, boolean r5) {
        TTDownloadSettingsModel r0 = (TTDownloadSettingsModel) TTDownloadSettingsAdapter.INSTANCE.get();
        if (r0 != null) goto L5;
    L7:
        getDownloadDispatcher().cancel(r4, r5, null);
        return;
    L5:
        if (r0.getEnableDeleteDownloadAndModel() != 1) goto L7;
        getDownloadDispatcher().cancel(r4, r5, null, true);
    }

    @Override // com.ss.android.download.api.ITTDownloader
    public void cancel(String r2, boolean r3) {
        Safe.noCatch(new 17(this, r2, r3));
    }

    public void cancelAndDeleteModel(String r2, boolean r3) {
        Safe.noCatch(new b(this, r2, r3));
    }

    @Override // com.ss.android.download.api.ITTDownloader
    public DownloadInfo getDownloadInfo(String r2, String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L7;
        return getDownloadInfo(r2);
    L7:
        return Downloader.getInstance(GlobalInfo.getContext()).getDownloadInfo(r2, r3);
    }

    public void getDownloadInstallStatus(List<DownloadInstallInfo> r2, DownloadInstallHelper.DownloadInstallCallback r3) {
        AsyncTaskUtils.executeAsyncTask(new DownloadInstallHelper(r2, r3), new Void[0]);
    }

    public String getDownloadTaskKey(int r2, JSONObject r3) {
        return DownloadTaskKeyManager.getInstance().getDownloadTaskKey(r2, r3);
    }

    @Override // com.ss.android.download.api.ITTDownloader
    public void unbind(String r2, int r3) {
        Safe.noCatch(new 14(this, r2, r3));
    }

    @Override // com.ss.android.download.api.ITTDownloader
    public void action(String r8, long r9, int r11) {
        Safe.noCatch(new 11(this, r8, r9, r11));
    }

    @Override // com.ss.android.download.api.ITTDownloader
    public void bind(int r2, DownloadStatusChangeListener r3, DownloadModel r4) {
        Safe.noCatch(new 4(this, r2, r3, r4));
    }

    public void bindQuickApp(DownloadModel r2, DownloadEventConfig r3, Runnable r4) {
        AdQuickAppManager.getsInstance().bindQuickApp(r2, r3, r4);
    }

    public void cancel(String r2, boolean r3, JSONObject r4) {
        Safe.noCatch(new 16(this, r2, r3, r4));
    }

    public DownloadInfo getDownloadInfo(String r2, String r3, boolean r4) {
        if (TextUtils.isEmpty(r3) == false) goto L8;
        if (r4 == false) goto L8;
        return getDownloadInfo(r2);
    L8:
        return Downloader.getInstance(GlobalInfo.getContext()).getDownloadInfo(r2, r3);
    }

    public void unbind(String r2, int r3, boolean r4) {
        Safe.noCatch(new 15(this, r2, r3, r4));
    }

    @Override // com.ss.android.download.api.ITTDownloader
    public void action(String r2, int r3, DownloadEventConfig r4) {
        Safe.noCatch(new 12(this, r2, r3, r4));
    }

    public void bind(int r2, DownloadStatusChangeListenerForInstall r3, DownloadModel r4) {
        Safe.noCatch(new 6(this, r2, r3, r4));
    }

    @Override // com.ss.android.download.api.ITTDownloader
    public void bind(Context r8, int r9, DownloadStatusChangeListener r10, DownloadModel r11) {
        Safe.noCatch(new 3(this, r8, r9, r10, r11));
    }

    public void bind(Context r8, int r9, DownloadStatusChangeListenerForInstall r10, DownloadModel r11) {
        Safe.noCatch(new 5(this, r8, r9, r10, r11));
    }

    @Override // com.ss.android.download.api.ITTDownloader
    public void action(String r10, long r11, int r13, DownloadEventConfig r14, DownloadController r15) {
        Safe.noCatch(new 9(this, r10, r11, r13, r14, r15));
    }

    @Override // com.ss.android.download.api.ITTDownloader
    public ActionDecisionApi getActionDecision(String r8, long r9, int r11, DownloadEventConfig r12, DownloadController r13) {
        CommonDownloadHandler r10 = getDownloadDispatcher().trickAction(r8, r9, r11, r12, r13);
        if (r10 != null) goto L5;
        return null;
    L5:
        return new ActionDecisionImpl(r10, r11);
    }

    @Override // com.ss.android.download.api.ITTDownloader
    public void action(String r11, long r12, int r14, DownloadEventConfig r15, DownloadController r16, IDownloadButtonClickListener r17) {
        Safe.noCatch(new 10(this, r11, r12, r14, r15, r16, r17));
    }

    @Override // com.ss.android.download.api.ITTDownloader
    public void action(String r11, long r12, int r14, DownloadEventConfig r15, DownloadController r16, DownloadModel r17) {
        Safe.noCatch(new 13(this, r11, r12, r14, r15, r16, r17));
    }

    @Override // com.ss.android.download.api.ITTDownloader
    public void action(String r11, long r12, int r14, DownloadEventConfig r15, DownloadController r16, JSONObject r17) {
        Safe.noCatch(new 8(this, r11, r12, r14, r15, r16, r17));
    }

    @Override // com.ss.android.download.api.ITTDownloader
    public void action(String r12, long r13, int r15, DownloadEventConfig r16, DownloadController r17, OnItemClickListener r18, IDownloadButtonClickListener r19) {
        Safe.noCatch(new 7(this, r12, r13, r15, r16, r17, r18, r19));
    }
}
