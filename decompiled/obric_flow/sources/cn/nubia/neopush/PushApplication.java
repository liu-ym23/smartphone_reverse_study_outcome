package cn.nubia.neopush;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Process;
import cn.nubia.neopush.commons.BuildConfig;
import cn.nubia.neopush.commons.Constant;
import cn.nubia.neopush.commons.NeoLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

/* JADX INFO: loaded from: classes.dex */
public class PushApplication extends Application {
    private static boolean isCanUpload = false;
    private static Context mContext;
    static Handler mHandler;
    private static Resources mRes;
    static ArrayList<String> unrealpackage;
    Properties mCrashInfo;

    static {
        unrealpackage = new ArrayList();
        mHandler = new Handler();
    }

    public PushApplication() {
        this.mCrashInfo = new Properties();
    }

    public static Context getContext() {
        return mContext;
    }

    public static void getNewConfiguration() {
    }

    public static Resources getResource() {
        return mRes;
    }

    public static ArrayList<String> getUnrealpackageRegester() {
        ArrayList<String> r5 = new ArrayList();
        int r10 = 0;
        SharedPreferences r11 = getContext().getSharedPreferences(Constant.SaveReg, 0);
        if (unrealpackage.size() > 0) goto L5;
    L13:
        return r5;
    L5:
        if (r10 >= unrealpackage.size()) goto L13;
        String r12 = r11.getString("RegID_" + unrealpackage.get(r10), null);
        if (r12 != null) goto L10;
    L11:
        r5.add(unrealpackage.get(r10));
    L12:
        r10 = r10 + 1;
        goto L5
    L10:
        if (r12.equals("") == false) goto L12;
        goto L11
    }

    public static boolean isCanUploadError() {
        return isCanUpload;
    }

    public static boolean isUnrealpackage(String r5) {
        if (r5 != null) goto L6;
        return false;
    L6:
        return unrealpackage.contains(r5);
    }

    public static void registeUnrealpackage(String r5, boolean r10) {
        NeoLog.i("luzhi", "regester unrealpackage 1 " + r5);
    }

    public static void setCanUploadError(boolean r5) {
        isCanUpload = r5;
    }

    private void setUncaughtExceptionHandler() {
    }

    private void trackAppStart(Context r5) {
    }

    private void trackDeviceChange(Context r5) {
    }

    public boolean isMainProcess() {
        List<ActivityManager.RunningAppProcessInfo> r5 = ((ActivityManager) getSystemService("activity")).getRunningAppProcesses();     // Catch: Exception -> L18
        String r10 = getPackageName();     // Catch: Exception -> L18
        int r11 = Process.myPid();     // Catch: Exception -> L18
        if (r5 == null) goto L17;
        if (r5.size() <= 0) goto L17;
        Iterator<ActivityManager.RunningAppProcessInfo> r12 = r5.iterator();     // Catch: Exception -> L18
    L9:
        if (r12.hasNext() == false) goto L17;
        ActivityManager.RunningAppProcessInfo r13 = r12.next();     // Catch: Exception -> L18
        if (r13.pid != r11) goto L9;
        if (r10.equals(r13.processName) == false) goto L9;
        return true;
    L17:
        return false;
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        NeoLog.i("PushApplication", "android.os.Process.myPid():" + Process.myPid());
        if (isMainProcess() == false) goto L11;
        mContext = this;
        NeoLog.i("PushApplication", "onCreate start");
        getSharedPreferences(Constant.SaveCrashLog, 0);     // Catch: Exception -> L7
        NeoLog.i("PushApplication", "onCreate end");
        mRes = getResources();
        setUncaughtExceptionHandler();
        BuildConfig.isDebug();
        unrealpackage.add("cn.nubia.neopush.ad");
        registeUnrealpackage("cn.nubia.neopush.ad", BuildConfig.isDebug());
        return;
    L7:
        Process.killProcess(Process.myPid());
        System.exit(10);
        return;
    }
}
