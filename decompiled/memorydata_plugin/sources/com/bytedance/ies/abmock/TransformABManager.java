package com.bytedance.ies.abmock;

/* JADX INFO: loaded from: classes2.dex */
public class TransformABManager {
    private static final TransformABManager instance = null;

    static {
        instance = new TransformABManager();
    }

    private TransformABManager() {
    }

    private int abmock_download_monitor_sample_2() {
        SettingsManager.a();
        return com.bytedance.ies.abmock.fetch.d.class.a("abmock_download_monitor_sample_2", 50);
    }

    static TransformABManager getInstance() {
        return instance;
    }

    private boolean ttk_abmock_fetch_data_optimized_experiment_3() {
        ABManager.getInstance();
        return com.bytedance.ies.experiment.a.class.getBooleanValue(true, "ttk_abmock_fetch_data_optimized_experiment_3", 31744, false);
    }

    boolean getBooleanValue(String r2) {
        if (r2.equals("ttk_abmock_fetch_data_optimized_experiment_3") == true) goto L5;
        return false;
    L5:
        return ttk_abmock_fetch_data_optimized_experiment_3();
    }

    double getDoubleValue(String r1) {
        return 0.0d;
    }

    float getFloatValue(String r1) {
        return 0.0f;
    }

    int getIntValue(String r2) {
        if (r2.equals("abmock_download_monitor_sample_2") == true) goto L5;
        return 0;
    L5:
        return abmock_download_monitor_sample_2();
    }

    long getLongValue(String r1) {
        return 0;
    }

    String getStringValue(String r1) {
        return null;
    }

    <T> T getValue(String r1) {
        return null;
    }
}
