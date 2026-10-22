package com.ss.ttvideoengine.utils;

import com.bytedance.vcloud.abrmodule.ABRConfig;
import com.ss.ttvideoengine.DataLoaderHelper;
import com.ss.ttvideoengine.selector.strategy.GearStrategy;
import com.ss.ttvideoengine.selector.strategy.GearStrategyConfig;
import com.ss.ttvideoengine.setting.SettingsHelper;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class TTVideoEngineLog {
    public static final int LOG_DEBUG = 1;
    public static final int LOG_ERROR = 6;
    public static final int LOG_INFO = 2;
    public static final int LOG_KILL = 4;
    public static final int LOG_TRACK = 3;
    public static final int LOG_VERBOSE = 0;
    public static final int LOG_WARN = 5;
    private static final String TAG = "TTVideoEngineLog";

    public TTVideoEngineLog() {
    }

    public static boolean d() {
        return TTVideoEngineInternalLog.d();
    }

    public static boolean e() {
        return TTVideoEngineInternalLog.e();
    }

    public static boolean i() {
        return TTVideoEngineInternalLog.i();
    }

    public static boolean k() {
        return TTVideoEngineInternalLog.k();
    }

    public static boolean t() {
        return TTVideoEngineInternalLog.t();
    }

    public static boolean w() {
        return TTVideoEngineInternalLog.w();
    }

    public static int getLogNotifyLevel() {
        return TTVideoEngineInternalLog.LogNotifyLevel;
    }

    public static int getLogTurnOn() {
        return TTVideoEngineInternalLog.LogTurnOn;
    }

    public static void d(Throwable r0) {
        TTVideoEngineInternalLog.d(r0);
    }

    public static void enablePredicateLoglevelTurn(boolean r0) {
        TTVideoEngineInternalLog.enablePredicateLoglevelTurn(r0);
    }

    public static boolean isPredicateLoglevelTurnOn(int r0) {
        return TTVideoEngineInternalLog.isPredicateLoglevelTurnOn(r0);
    }

    public static void setListener(TTVideoEngineLogListener r0) {
        TTVideoEngineInternalLog.setListener(r0);
    }

    private static void _notifyListener(String r0, String r1) {
        TTVideoEngineInternalLog._notifyListener(r0, r1);
    }

    public static void d(String r0, String r1) {
        TTVideoEngineInternalLog.d(r0, r1);
    }

    public static void e(String r0, String r1) {
        TTVideoEngineInternalLog.e(r0, r1);
    }

    public static void i(String r0, String r1) {
        TTVideoEngineInternalLog.i(r0, r1);
    }

    public static void k(String r0, String r1) {
        TTVideoEngineInternalLog.k(r0, r1);
    }

    public static void setLogNotifyLevel(int r0, int r1) {
        TTVideoEngineInternalLog.setLogNotifyLevel(r0, r1);
    }

    public static void t(String r0, String r1) {
        TTVideoEngineInternalLog.t(r0, r1);
    }

    public static void turnOn(int r3, int r4) {
        TTVideoEngineInternalLog.turnOn(r3, r4);
        if (r3 != 1) goto L6;
        if (r4 != 1) goto L6;
        ABRConfig.setLoglevel(1);
        GearStrategyConfig r1 = GearStrategy.getGlobalConfig();
        r1.setIntValue(33, 1);
        GearStrategy.setGlobalConfig(r1);
        SettingsHelper.helper().setDebug(true);
    L7:
        if (r4 <= 0) goto L9;
        DataLoaderHelper.getDataLoader().setPreloadLogLevel(r3);
        return;
    L9:
        DataLoaderHelper.getDataLoader().setPreloadLogLevel(6);
        return;
    L6:
        SettingsHelper.helper().setDebug(false);
        goto L7
    }

    public static void w(String r0, String r1) {
        TTVideoEngineInternalLog.w(r0, r1);
    }
}
