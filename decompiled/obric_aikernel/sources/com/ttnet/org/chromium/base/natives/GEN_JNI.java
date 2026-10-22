package com.ttnet.org.chromium.base.natives;

import J.N;

/* JADX INFO: loaded from: classes2.dex */
public class GEN_JNI {
    public static final boolean REQUIRE_MOCK = false;
    public static final boolean TESTING_ENABLED = false;

    public GEN_JNI() {
    }

    public static void com_ttnet_org_chromium_base_ApplicationStatus_onApplicationStateChange(int r10) {
        N.M$lotPPc(r10);
    }

    public static boolean com_ttnet_org_chromium_base_BaseFeatureList_isEnabled(String r10) {
        return N.Mtllg_IO(r10);
    }

    public static void com_ttnet_org_chromium_base_CommandLine_appendSwitch(String r10) {
        N.MawtMrJF(r10);
    }

    public static void com_ttnet_org_chromium_base_CommandLine_appendSwitchWithValue(String r10, String r11) {
        N.MIZelAXD(r10, r11);
    }

    public static void com_ttnet_org_chromium_base_CommandLine_appendSwitchesAndArguments(String[] r10) {
        N.MjOVh1Zv(r10);
    }

    public static String com_ttnet_org_chromium_base_CommandLine_getSwitchValue(String r10) {
        return N.MaCXZYAa(r10);
    }

    public static String[] com_ttnet_org_chromium_base_CommandLine_getSwitchesFlattened() {
        return N.MahsXrQs();
    }

    public static boolean com_ttnet_org_chromium_base_CommandLine_hasSwitch(String r10) {
        return N.MhlgTxh2(r10);
    }

    public static void com_ttnet_org_chromium_base_CommandLine_init(String[] r10) {
        N.MZSU27YP(r10);
    }

    public static void com_ttnet_org_chromium_base_CommandLine_removeSwitch(String r10) {
        N.MP5WQt3J(r10);
    }

    public static int com_ttnet_org_chromium_base_CpuFeatures_getCoreCount() {
        return N.Mcaj_8qf();
    }

    public static long com_ttnet_org_chromium_base_CpuFeatures_getCpuFeatures() {
        return N.M1UV95tj();
    }

    public static void com_ttnet_org_chromium_base_EarlyTraceEvent_recordEarlyAsyncBeginEvent(String r10, long r11, long r12) {
        N.M88o6Bs3(r10, r11, r12);
    }

    public static void com_ttnet_org_chromium_base_EarlyTraceEvent_recordEarlyAsyncEndEvent(String r10, long r11, long r12) {
        N.MohIB14s(r10, r11, r12);
    }

    public static void com_ttnet_org_chromium_base_EarlyTraceEvent_recordEarlyBeginEvent(String r10, long r11, int r12, long r13) {
        N.MCawLSFP(r10, r11, r12, r13);
    }

    public static void com_ttnet_org_chromium_base_EarlyTraceEvent_recordEarlyEndEvent(String r10, long r11, int r12, long r13) {
        N.MvvW3g4w(r10, r11, r12, r13);
    }

    public static void com_ttnet_org_chromium_base_EarlyTraceEvent_recordEarlyToplevelBeginEvent(String r10, long r11, int r12, long r13) {
        N.MjWH5Jmd(r10, r11, r12, r13);
    }

    public static void com_ttnet_org_chromium_base_EarlyTraceEvent_recordEarlyToplevelEndEvent(String r10, long r11, int r12, long r13) {
        N.MoB6dYvZ(r10, r11, r12, r13);
    }

    public static boolean com_ttnet_org_chromium_base_FeatureList_isInitialized() {
        return N.Md1lGM43();
    }

    public static boolean com_ttnet_org_chromium_base_Features_getFieldTrialParamByFeatureAsBoolean(long r10, String r11, boolean r12) {
        return N.MiTw3O_J(r10, r11, r12);
    }

    public static boolean com_ttnet_org_chromium_base_Features_isEnabled(long r10) {
        return N.MoITUwC2(r10);
    }

    public static boolean com_ttnet_org_chromium_base_FieldTrialList_createFieldTrial(String r10, String r11) {
        return N.MzhBrODy(r10, r11);
    }

    public static String com_ttnet_org_chromium_base_FieldTrialList_findFullName(String r10) {
        return N.MfcktC_e(r10);
    }

    public static String com_ttnet_org_chromium_base_FieldTrialList_getVariationParameter(String r10, String r11) {
        return N.Msd5Ns7Y(r10, r11);
    }

    public static void com_ttnet_org_chromium_base_FieldTrialList_logActiveTrials() {
        N.M2n_z3BB();
    }

    public static boolean com_ttnet_org_chromium_base_FieldTrialList_trialExists(String r10) {
        return N.MBEGQVWX(r10);
    }

    public static String com_ttnet_org_chromium_base_FileUtils_getAbsoluteFilePath(String r10) {
        return N.MKMoqNq6(r10);
    }

    public static boolean com_ttnet_org_chromium_base_ImportantFileWriterAndroid_writeFileAtomically(String r10, byte[] r11) {
        return N.M1jycjxU(r10, r11);
    }

    public static void com_ttnet_org_chromium_base_JavaExceptionReporter_reportJavaException(boolean r10, Throwable r11) {
        N.M9gfm$zh(r10, r11);
    }

    public static void com_ttnet_org_chromium_base_JavaExceptionReporter_reportJavaStackTrace(String r10) {
        N.MuvJZ5jK(r10);
    }

    public static void com_ttnet_org_chromium_base_JavaHandlerThread_initializeThread(long r10, long r11) {
        N.M3RaWo13(r10, r11);
    }

    public static void com_ttnet_org_chromium_base_JavaHandlerThread_onLooperStopped(long r10) {
        N.MSKUcgE4(r10);
    }

    public static void com_ttnet_org_chromium_base_PathService_override(int r10, String r11) {
        N.MvMFfChw(r10, r11);
    }

    public static void com_ttnet_org_chromium_base_PowerMonitor_onBatteryChargingChanged() {
        N.MxETr4iO();
    }

    public static void com_ttnet_org_chromium_base_PowerMonitor_onInstantResume() {
        N.MELAwTDU();
    }

    public static void com_ttnet_org_chromium_base_PowerMonitor_onInstantSuspend() {
        N.MolcG1Wq();
    }

    public static void com_ttnet_org_chromium_base_PowerMonitor_onResume() {
        N.MyS7kauI();
    }

    public static void com_ttnet_org_chromium_base_PowerMonitor_onSuspend() {
        N.MBffe1lF();
    }

    public static void com_ttnet_org_chromium_base_PowerMonitor_onThermalStatusChanged(int r10) {
        N.MuSEGQ9M(r10);
    }

    public static void com_ttnet_org_chromium_base_SysUtils_logPageFaultCountToTracing() {
        N.Mm3sCch3();
    }

    public static void com_ttnet_org_chromium_base_TraceEvent_addViewDump(int r10, int r11, boolean r12, boolean r13, String r14, String r15, long r16) {
        N.MxGy3cn_(r10, r11, r12, r13, r14, r15, r16);
    }

    public static void com_ttnet_org_chromium_base_TraceEvent_begin(String r10, String r11) {
        N.MajVTFsV(r10, r11);
    }

    public static void com_ttnet_org_chromium_base_TraceEvent_beginToplevel(String r10) {
        N.MljCyOuh(r10);
    }

    public static void com_ttnet_org_chromium_base_TraceEvent_end(String r10, String r11) {
        N.M5yUVmrW(r10, r11);
    }

    public static void com_ttnet_org_chromium_base_TraceEvent_endToplevel(String r10) {
        N.M6R6NWXS(r10);
    }

    public static void com_ttnet_org_chromium_base_TraceEvent_finishAsync(String r10, long r11) {
        N.MjXrJVoa(r10, r11);
    }

    public static void com_ttnet_org_chromium_base_TraceEvent_initViewHierarchyDump() {
        N.MgOuiubc();
    }

    public static void com_ttnet_org_chromium_base_TraceEvent_instant(String r10, String r11) {
        N.Mz5qii_R(r10, r11);
    }

    public static void com_ttnet_org_chromium_base_TraceEvent_instantAndroidIPC(String r10, long r11) {
        N.MMXoiNW_(r10, r11);
    }

    public static void com_ttnet_org_chromium_base_TraceEvent_registerEnabledObserver() {
        N.M8F7L$JR();
    }

    public static void com_ttnet_org_chromium_base_TraceEvent_setupATraceStartupTrace(String r10) {
        N.M8MvK2gp(r10);
    }

    public static void com_ttnet_org_chromium_base_TraceEvent_startATrace(String r10) {
        N.MiUfkLIq(r10);
    }

    public static long com_ttnet_org_chromium_base_TraceEvent_startActivityDump(String r10, long r11) {
        return N.MgxFMA1H(r10, r11);
    }

    public static void com_ttnet_org_chromium_base_TraceEvent_startAsync(String r10, long r11) {
        N.MKlPFTpb(r10, r11);
    }

    public static void com_ttnet_org_chromium_base_TraceEvent_stopATrace() {
        N.MTnadCLu();
    }

    public static boolean com_ttnet_org_chromium_base_TraceEvent_viewHierarchyDumpEnabled() {
        return N.MpI7Xy5x();
    }

    public static void com_ttnet_org_chromium_base_jank_1tracker_JankMetricUMARecorder_recordJankMetrics(String r10, long[] r11, long[] r12, long[] r13, int r14) {
        N.Mw$h3q2i(r10, r11, r12, r13, r14);
    }

    public static boolean com_ttnet_org_chromium_base_library_1loader_LibraryLoader_libraryLoaded(int r10) {
        return N.MnwWsRxg(r10);
    }

    public static void com_ttnet_org_chromium_base_library_1loader_LibraryLoader_registerNonMainDexJni() {
        N.MU8nwPRG();
    }

    public static void com_ttnet_org_chromium_base_library_1loader_LibraryPrefetcher_forkAndPrefetchNativeLibrary() {
        N.MVIMN27T();
    }

    public static int com_ttnet_org_chromium_base_library_1loader_LibraryPrefetcher_percentageOfResidentNativeLibraryCode() {
        return N.MA6QAXj_();
    }

    public static void com_ttnet_org_chromium_base_library_1loader_LibraryPrefetcher_periodicallyCollectResidency() {
        N.MtuV2SWL();
    }

    public static long com_ttnet_org_chromium_base_metrics_NativeUmaRecorder_addActionCallbackForTesting(Object r10) {
        return N.MDoBOCZO_ForTesting(r10);
    }

    public static long com_ttnet_org_chromium_base_metrics_NativeUmaRecorder_createHistogramSnapshotForTesting() {
        return N.M_034fMZ_ForTesting();
    }

    public static void com_ttnet_org_chromium_base_metrics_NativeUmaRecorder_destroyHistogramSnapshotForTesting(long r10) {
        N.Me95ZC6G_ForTesting(r10);
    }

    public static int com_ttnet_org_chromium_base_metrics_NativeUmaRecorder_getHistogramTotalCountForTesting(String r10, long r11) {
        return N.M7NlTYxi_ForTesting(r10, r11);
    }

    public static int com_ttnet_org_chromium_base_metrics_NativeUmaRecorder_getHistogramValueCountForTesting(String r10, int r11, long r12) {
        return N.MkFXHbyW_ForTesting(r10, r11, r12);
    }

    public static long com_ttnet_org_chromium_base_metrics_NativeUmaRecorder_recordBooleanHistogram(String r10, long r11, boolean r12) {
        return N.MYPj82kt(r10, r11, r12);
    }

    public static long com_ttnet_org_chromium_base_metrics_NativeUmaRecorder_recordExponentialHistogram(String r10, long r11, int r12, int r13, int r14, int r15) {
        return N.M45N7QIN(r10, r11, r12, r13, r14, r15);
    }

    public static long com_ttnet_org_chromium_base_metrics_NativeUmaRecorder_recordLinearHistogram(String r10, long r11, int r12, int r13, int r14, int r15) {
        return N.Mx1k0LvC(r10, r11, r12, r13, r14, r15);
    }

    public static long com_ttnet_org_chromium_base_metrics_NativeUmaRecorder_recordSparseHistogram(String r10, long r11, int r12) {
        return N.MV$7$UuP(r10, r11, r12);
    }

    public static void com_ttnet_org_chromium_base_metrics_NativeUmaRecorder_recordUserAction(String r10, long r11) {
        N.MxViw_go(r10, r11);
    }

    public static void com_ttnet_org_chromium_base_metrics_NativeUmaRecorder_removeActionCallbackForTesting(long r10) {
        N.MYkUp9vo_ForTesting(r10);
    }

    public static String com_ttnet_org_chromium_base_metrics_StatisticsRecorderAndroid_toJson(int r10) {
        return N.M5gAmtvn(r10);
    }

    public static void com_ttnet_org_chromium_base_task_PostTask_postDelayedTask(int r10, boolean r11, boolean r12, byte r13, byte[] r14, Object r15, long r16, String r17) {
        N.Mwr17eXX(r10, r11, r12, r13, r14, r15, r16, r17);
    }

    public static boolean com_ttnet_org_chromium_base_task_TaskRunnerImpl_belongsToCurrentThread(long r10) {
        return N.Mz$BG_4y(r10);
    }

    public static void com_ttnet_org_chromium_base_task_TaskRunnerImpl_destroy(long r10) {
        N.Mvd960xb(r10);
    }

    public static long com_ttnet_org_chromium_base_task_TaskRunnerImpl_init(int r10, int r11, boolean r12, boolean r13, byte r14, byte[] r15) {
        return N.MLtH82Um(r10, r11, r12, r13, r14, r15);
    }

    public static void com_ttnet_org_chromium_base_task_TaskRunnerImpl_postDelayedTask(long r10, Object r11, long r12, String r13) {
        N.MJ_h_2p2(r10, r11, r12, r13);
    }

    public static void com_ttnet_org_chromium_net_AndroidNetworkLibrary_onCellularAlwaysUp(boolean r10, int r11) {
        N.MeYG7FqD(r10, r11);
    }

    public static String com_ttnet_org_chromium_net_GURLUtils_getOrigin(String r10) {
        return N.McGsvqvj(r10);
    }

    public static void com_ttnet_org_chromium_net_HttpNegotiateAuthenticator_setResult(long r10, Object r11, int r12, String r13) {
        N.MsAf1sYp(r10, r11, r12, r13);
    }

    public static boolean com_ttnet_org_chromium_net_HttpUtil_isAllowedHeader(String r10, String r11) {
        return N.MsTaj7yX(r10, r11);
    }

    public static void com_ttnet_org_chromium_net_NetworkActiveNotifier_notifyOfDefaultNetworkActive(long r10) {
        N.M5aI8A5Z(r10);
    }

    public static void com_ttnet_org_chromium_net_NetworkChangeNotifier_notifyConnectionCostChanged(long r10, Object r11, int r12) {
        N.MZnuk2LK(r10, r11, r12);
    }

    public static void com_ttnet_org_chromium_net_NetworkChangeNotifier_notifyConnectionTypeChanged(long r10, Object r11, int r12, long r13) {
        N.MjJzrRFH(r10, r11, r12, r13);
    }

    public static void com_ttnet_org_chromium_net_NetworkChangeNotifier_notifyMaxBandwidthChanged(long r10, Object r11, int r12) {
        N.MqNJnYjG(r10, r11, r12);
    }

    public static void com_ttnet_org_chromium_net_NetworkChangeNotifier_notifyOfNetworkConnect(long r10, Object r11, long r12, boolean r13, int r14) {
        N.MZ5e75rQ(r10, r11, r12, r13, r14);
    }

    public static void com_ttnet_org_chromium_net_NetworkChangeNotifier_notifyOfNetworkDisconnect(long r10, Object r11, boolean r12, long r13) {
        N.Ms7JLaGI(r10, r11, r12, r13);
    }

    public static void com_ttnet_org_chromium_net_NetworkChangeNotifier_notifyOfNetworkSoonToDisconnect(long r10, Object r11, long r12) {
        N.MssT8yD3(r10, r11, r12);
    }

    public static void com_ttnet_org_chromium_net_NetworkChangeNotifier_notifyPurgeActiveNetworkList(long r10, Object r11, long[] r12) {
        N.Mvng38R0(r10, r11, r12);
    }

    public static void com_ttnet_org_chromium_net_ProxyChangeListener_proxySettingsChanged(long r10, Object r11) {
        N.MKwsFZ4t(r10, r11);
    }

    public static void com_ttnet_org_chromium_net_ProxyChangeListener_proxySettingsChangedTo(long r10, Object r11, String r12, int r13, String r14, String[] r15) {
        N.MtXZ30qk(r10, r11, r12, r13, r14, r15);
    }

    public static boolean com_ttnet_org_chromium_net_TTAppSecurityManager_isTTPRestrictionEnabled() {
        return N.Mhd7DRFo();
    }

    public static boolean com_ttnet_org_chromium_net_TTAppSecurityManager_isUserPrivacyRestrictionEnabled() {
        return N.MaSRwBiO();
    }

    public static void com_ttnet_org_chromium_net_TTSocketAccelerate_OnCheckSystemAvailableResult(long r10, Object r11, int r12) {
        N.MXvQH$ie(r10, r11, r12);
    }

    public static void com_ttnet_org_chromium_net_TTSocketAccelerate_OnNotifyAccelerateResult(long r10, Object r11, int r12, int r13) {
        N.MOfWrYJI(r10, r11, r12, r13);
    }

    public static void com_ttnet_org_chromium_net_X509Util_notifyKeyChainChanged() {
        N.MzV1TXLS();
    }

    public static long com_ttnet_org_chromium_net_impl_CronetBidirectionalStream_createBidirectionalStream(Object r10, long r11, boolean r12, boolean r13, int r14, boolean r15, int r16, long r17) {
        return N.MSnVviPU(r10, r11, r12, r13, r14, r15, r16, r17);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetBidirectionalStream_destroy(long r10, Object r11, boolean r12) {
        N.My0p82p4(r10, r11, r12);
    }

    public static boolean com_ttnet_org_chromium_net_impl_CronetBidirectionalStream_readData(long r10, Object r11, Object r12, int r13, int r14) {
        return N.M21CWxxV(r10, r11, r12, r13, r14);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetBidirectionalStream_sendRequestHeaders(long r10, Object r11) {
        N.MhETl_ev(r10, r11);
    }

    public static int com_ttnet_org_chromium_net_impl_CronetBidirectionalStream_start(long r10, Object r11, String r12, int r13, String r14, String[] r15, boolean r16) {
        return N.MycrIbGr(r10, r11, r12, r13, r14, r15, r16);
    }

    public static boolean com_ttnet_org_chromium_net_impl_CronetBidirectionalStream_writevData(long r10, Object r11, Object[] r12, int[] r13, int[] r14, boolean r15) {
        return N.MYRRygif(r10, r11, r12, r13, r14, r15);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetFrontierClient_addHeader(long r10, Object r11, String r12, String r13) {
        N.MwZrRAIG(r10, r11, r12, r13);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetFrontierClient_addServiceId(long r10, Object r11, int r12) {
        N.Msf3H5kQ(r10, r11, r12);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetFrontierClient_configParams(long r10, Object r11, int r12, int r13, String r14, int r15, String r16, String r17, String r18, String r19, int r110, int r111, int r112, boolean r113, String r114, String r115) {
        N.Mhk1t9AY(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r112, r113, r114, r115);
    }

    public static long com_ttnet_org_chromium_net_impl_CronetFrontierClient_createFrontierClientAdapter(Object r10) {
        return N.MagNlhNv(r10);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetFrontierClient_destroy(long r10, Object r11) {
        N.MKRYs$fc(r10, r11);
    }

    public static boolean com_ttnet_org_chromium_net_impl_CronetFrontierClient_isServiceReady(long r10, Object r11, int r12) {
        return N.My_P9YPg(r10, r11, r12);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetFrontierClient_registerService(long r10, Object r11, String[] r12, Object r13, int r14, int r15, boolean r16) {
        N.MKu8Zh_d(r10, r11, r12, r13, r14, r15, r16);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetFrontierClient_reportAppStateChange(long r10, Object r11, boolean r12) {
        N.MlH8$Rpg(r10, r11, r12);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetFrontierClient_sendMessage(long r10, Object r11, int r12, String[] r13, Object r14) {
        N.MKYiSehZ(r10, r11, r12, r13, r14);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetFrontierClient_unregisterService(long r10, Object r11, int r12) {
        N.M4rPfgYd(r10, r11, r12);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetLibraryLoader_cronetInitOnInitThread() {
        N.MyweRqSS();
    }

    public static String com_ttnet_org_chromium_net_impl_CronetLibraryLoader_getCronetVersion() {
        return N.MVlvYo_c();
    }

    public static long com_ttnet_org_chromium_net_impl_CronetUploadDataStream_attachUploadDataToRequest(Object r10, long r11, long r12) {
        return N.M89UGLMC(r10, r11, r12);
    }

    public static long com_ttnet_org_chromium_net_impl_CronetUploadDataStream_createAdapterForTesting(Object r10) {
        return N.M3b_yKC0_ForTesting(r10);
    }

    public static long com_ttnet_org_chromium_net_impl_CronetUploadDataStream_createUploadDataStreamForTesting(Object r10, long r11, long r12) {
        return N.MKATyFlf_ForTesting(r10, r11, r12);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUploadDataStream_destroy(long r10) {
        N.Mx3T_YwB(r10);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUploadDataStream_onReadSucceeded(long r10, Object r11, int r12, boolean r13) {
        N.MYsxiVBk(r10, r11, r12, r13);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUploadDataStream_onRewindSucceeded(long r10, Object r11) {
        N.M3Tck9nA(r10, r11);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_addClientOpaqueData(long r10, Object r11, String[] r12, byte[] r13, byte[] r14, long r15, long r16) {
        N.MWb1lJ5e(r10, r11, r12, r13, r14, r15, r16);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_addPkp(long r10, String r11, byte[][] r12, boolean r13, long r14) {
        N.Mkx3KULb(r10, r11, r12, r13, r14);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_addQuicHint(long r10, String r11, int r12, int r13) {
        N.M6WZ7Wt0(r10, r11, r12, r13);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_addSamplingSetting(long r10, Object r11, Object r12) {
        N.MKYzOUkj(r10, r11, r12);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_clearClientOpaqueData(long r10, Object r11) {
        N.MK0SE_Ub(r10, r11);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_configureNetworkQualityEstimatorForTesting(long r10, Object r11, boolean r12, boolean r13, boolean r14) {
        N.MNAF9eXw_ForTesting(r10, r11, r12, r13, r14);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_controlHttpDNSConfig(long r10, Object r11, boolean r12, boolean r13, boolean r14) {
        N.MHps7uOC(r10, r11, r12, r13, r14);
    }

    public static long com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_createRequestContextAdapter(long r10) {
        return N.MuixiOYs(r10);
    }

    public static long com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_createRequestContextConfig(String r10, String r11, boolean r12, String r13, boolean r14, boolean r15, boolean r16, int r17, long r18, String r19, long r110, boolean r111, boolean r112, int r113) {
        return N.Mmo_MQVE(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r112, r113);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_destroy(long r10, Object r11) {
        N.MG$DT18r(r10, r11);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_enableTTBizHttpDns(long r10, Object r11, boolean r12, String r13, String r14, String r15, boolean r16, String r17) {
        N.M2ni33Tk(r10, r11, r12, r13, r14, r15, r16, r17);
    }

    public static byte[] com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_getHistogramDeltas() {
        return N.MdOiNSC0();
    }

    public static long[] com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_getOpaqueFuncAddress() {
        return N.MlOQJZ8w();
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_initALogFuncAddr(long r10) {
        N.MjS9m1YQ(r10);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_initRequestContextOnInitThread(long r10, Object r11) {
        N.Mdu$OLLN(r10, r11);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_notifySwitchToMultiNetwork(long r10, Object r11, boolean r12) {
        N.Mbnl3sIw(r10, r11, r12);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_parseTNCConfigFromSystemHTTPRequest(long r10, Object r11, String r12, String r13, String r14, String r15, String r16, String r17) {
        N.MU6k4d25(r10, r11, r12, r13, r14, r15, r16, r17);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_preconnectUrl(long r10, Object r11, String r12, int r13, String r14) {
        N.MBtj30QU(r10, r11, r12, r13, r14);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_provideRTTObservations(long r10, Object r11, boolean r12) {
        N.Mk1UqBGq(r10, r11, r12);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_provideThroughputObservations(long r10, Object r11, boolean r12) {
        N.MHUcn7PP(r10, r11, r12);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_removeClientOpaqueData(long r10, Object r11, String r12) {
        N.Mcfn2q8$(r10, r11, r12);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_reportNetDiagnosisUserLog(long r10, Object r11, String r12) {
        N.MPONMQm_(r10, r11, r12);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_runInBackGround(long r10, Object r11, boolean r12) {
        N.MWOUQ7KG(r10, r11, r12);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_setAlogFuncAddr(long r10, Object r11, long r12) {
        N.Me3xdZoU(r10, r11, r12);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_setAppStartUpState(long r10, Object r11, int r12) {
        N.MksRT8QX(r10, r11, r12);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_setClientOpaqueData(long r10, String[] r11, byte[] r12, byte[] r13) {
        N.MTZ7mkhc(r10, r11, r12, r13);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_setCookieInitCompleted(long r10, Object r11) {
        N.MaSOyuXL(r10, r11);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_setHostResolverRules(long r10, Object r11, String r12) {
        N.MlH1XMiR(r10, r11, r12);
    }

    public static int com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_setMinLogLevel(int r10) {
        return N.MyyJ5zsH(r10);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_setProxy(long r10, Object r11, String r12) {
        N.Mj4Pi_Pa(r10, r11, r12);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_setRouteSelectionBestHost(long r10, Object r11, String r12, String r13) {
        N.MhbNiNFL(r10, r11, r12, r13);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_setTTNetInitConfig(long r10, int r11, boolean r12, boolean r13, String r14, String r15, String r16, boolean r17, String r18, String r19, byte[][] r110, Object[] r111, boolean r112, boolean r113, boolean r114, String r115, Object r116, long r117, boolean r20, boolean r21, boolean r22, Object r23) {
        N.MawZO189(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r112, r113, r114, r115, r116, r117, r20, r21, r22, r23);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_setZstdFuncAddr(long r10, Object r11, long r12, long r13, long r14, long r15, long r16, long r17, long r18, long r19) {
        N.MIs1FVFz(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19);
    }

    public static boolean com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_skipLogging(long r10, Object r11) {
        return N.MLLAskZ0(r10, r11);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_startNetLogToDisk(long r10, Object r11, String r12, boolean r13, int r14) {
        N.MuR7zLrb(r10, r11, r12, r13, r14);
    }

    public static boolean com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_startNetLogToFile(long r10, Object r11, String r12, boolean r13) {
        return N.Mt89JXhb(r10, r11, r12, r13);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_startThrottle(long r10, Object r11, String[] r12, int r13, long r14) {
        N.MiGn0DCY(r10, r11, r12, r13, r14);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_stopNetLog(long r10, Object r11) {
        N.ML5dVOOG(r10, r11);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_stopThrottle(long r10, Object r11, String[] r12, int r13) {
        N.MohL$06P(r10, r11, r12, r13);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_triggerTNCRequestByUser(long r10, Object r11, boolean r12) {
        N.MN8yyQkr(r10, r11, r12);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_triggerWiFiToCellularByThirdParty(long r10, Object r11) {
        N.M221PN7l(r10, r11);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_tryStartNetDetect(long r10, Object r11, String[] r12, int r13, int r14) {
        N.MA5SsGAv(r10, r11, r12, r13, r14);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_ttDnsResolve(long r10, Object r11, String r12, int r13, String r14, String r15) {
        N.MH0muaR3(r10, r11, r12, r13, r14, r15);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_ttUrlDispatch(long r10, Object r11, Object r12, String r13, boolean r14) {
        N.MRTGlzo1(r10, r11, r12, r13, r14);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_updateStoreRegionFromServer(long r10, Object r11, String r12, String r13, String r14, String r15, String r16, String r17, String r18, String r19, String r110, String r111, String r112) {
        N.MqjX8qD1(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r112);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequest_abortWhenUploadException(long r10, Object r11) {
        N.MzKjGz9N(r10, r11);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequest_addRequestCookieHeader(long r10, Object r11, String r12, String r13) {
        N.M2jrbUOP(r10, r11, r12, r13);
    }

    public static boolean com_ttnet_org_chromium_net_impl_CronetUrlRequest_addRequestHeader(long r10, Object r11, String r12, String r13) {
        return N.MtJFji5x(r10, r11, r12, r13);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequest_appTimeout(long r10, Object r11) {
        N.M3xsE8SK(r10, r11);
    }

    public static long com_ttnet_org_chromium_net_impl_CronetUrlRequest_createRequestAdapter(Object r10, long r11, String r12, int r13, int r14, boolean r15, boolean r16, boolean r17, int r18, boolean r19, int r110, int r111, long r112) {
        return N.MnXVOzVo(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r112);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequest_destroy(long r10, Object r11, boolean r12) {
        N.MIb9tt7_(r10, r11, r12);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequest_followDeferredRedirect(long r10, Object r11) {
        N.MhCyx70S(r10, r11);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequest_getStatus(long r10, Object r11, Object r12) {
        N.MmSvKAJE(r10, r11, r12);
    }

    public static boolean com_ttnet_org_chromium_net_impl_CronetUrlRequest_readData(long r10, Object r11, Object r12, int r13, int r14) {
        return N.MJbYA4in(r10, r11, r12, r13, r14);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequest_removeRequestCookieHeader(long r10, Object r11) {
        N.MjbEhTZs(r10, r11);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequest_setAuthCredentials(long r10, Object r11, String r12, String r13) {
        N.Mor7A21H(r10, r11, r12, r13);
    }

    public static boolean com_ttnet_org_chromium_net_impl_CronetUrlRequest_setHttpMethod(long r10, Object r11, String r12) {
        return N.MfdvbiJC(r10, r11, r12);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequest_setRequestTimeout(long r10, Object r11, int r12) {
        N.MaFGwSbC(r10, r11, r12);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequest_setRequestTypeFlags(long r10, Object r11, int r12) {
        N.MC7pScOk(r10, r11, r12);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequest_setSocketTimeout(long r10, Object r11, int r12, int r13, int r14) {
        N.M4C6WZaz(r10, r11, r12, r13, r14);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequest_setThrottleNetSpeed(long r10, Object r11, long r12) {
        N.ML2WrLQ6(r10, r11, r12);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequest_start(long r10, Object r11) {
        N.Mv2a151P(r10, r11);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetUrlRequest_stopRedirect(long r10, Object r11) {
        N.MFMoBdtW(r10, r11);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetWebsocketConnection_addGetParam(long r10, Object r11, String r12, String r13) {
        N.Mzisx1kZ(r10, r11, r12, r13);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetWebsocketConnection_addHeader(long r10, Object r11, String r12, String r13) {
        N.MKmGe$35(r10, r11, r12, r13);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetWebsocketConnection_addUrl(long r10, Object r11, String r12) {
        N.MgN9hn8A(r10, r11, r12);
    }

    public static long com_ttnet_org_chromium_net_impl_CronetWebsocketConnection_createWebsocketConnectionAdapter(Object r10, long r11) {
        return N.MRAGjNeT(r10, r11);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetWebsocketConnection_destroy(long r10, Object r11) {
        N.MCzpxGQD(r10, r11);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetWebsocketConnection_sendBinary(long r10, Object r11, Object r12) {
        N.MRfZ_7V_(r10, r11, r12);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetWebsocketConnection_sendText(long r10, Object r11, String r12) {
        N.MRnDfpSi(r10, r11, r12);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetWebsocketConnection_startWithFrontier(long r10, Object r11, int r12, String r13, long r14, int r15, long r16, String r17, int r18, String r19, boolean r110) {
        N.MWq0tMul(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetWebsocketConnection_startWithWSChannel(long r10, Object r11, boolean r12) {
        N.MVrBbeuj(r10, r11, r12);
    }

    public static void com_ttnet_org_chromium_net_impl_CronetWebsocketConnection_stop(long r10, Object r11) {
        N.M14GZgiH(r10, r11);
    }

    public static long com_ttnet_org_chromium_net_impl_TTCronetNetExpRequest_createRequestAdapter(Object r10, long r11, int r12, String[] r13, int r14, int r15, int r16) {
        return N.MPJAsrFC(r10, r11, r12, r13, r14, r15, r16);
    }

    public static void com_ttnet_org_chromium_net_impl_TTCronetNetExpRequest_destroy(long r10, Object r11) {
        N.M6$xRvea(r10, r11);
    }

    public static void com_ttnet_org_chromium_net_impl_TTCronetNetExpRequest_doExtraCommand(long r10, Object r11, String r12, String r13) {
        N.MDZjmtTn(r10, r11, r12, r13);
    }

    public static void com_ttnet_org_chromium_net_impl_TTCronetNetExpRequest_start(long r10, Object r11) {
        N.MLiR9ZbW(r10, r11);
    }
}
