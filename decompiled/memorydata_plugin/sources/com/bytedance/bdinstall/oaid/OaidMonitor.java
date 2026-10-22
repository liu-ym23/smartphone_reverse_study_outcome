package com.bytedance.bdinstall.oaid;

/* JADX INFO: loaded from: classes.dex */
public class OaidMonitor {
    private static long mInitTs;
    private static long mOnFinishFetchOaid;
    private static long mReadStartInitTs;
    private static long mRegisterWaitFinish;
    private static long mRegisterWaitOaid;
    private static long mStartSystemCall;
    private static long mSystemCallFinished;

    public OaidMonitor() {
    }

    public static long getInitTs() {
        return mInitTs;
    }

    public static long getOnFinishFetchOaid() {
        return mOnFinishFetchOaid;
    }

    public static long getReadStartInitTs() {
        return mReadStartInitTs;
    }

    public static long getRegisterWaitFinish() {
        return mRegisterWaitFinish;
    }

    public static long getRegisterWaitOaid() {
        return mRegisterWaitOaid;
    }

    public static long getStartSystemCall() {
        return mStartSystemCall;
    }

    public static long getSystemCallFinished() {
        return mSystemCallFinished;
    }

    public static void onInit() {
        if (mInitTs <= 0) goto L5;
        return;
    L5:
        mInitTs = System.currentTimeMillis();
    }

    public static void onOaidFinished() {
        if (mOnFinishFetchOaid <= 0) goto L5;
        return;
    L5:
        mOnFinishFetchOaid = System.currentTimeMillis();
    }

    public static void onRealStartInit() {
        if (mReadStartInitTs <= 0) goto L5;
        return;
    L5:
        mReadStartInitTs = System.currentTimeMillis();
    }

    public static void onStartSystemCall() {
        if (mStartSystemCall <= 0) goto L5;
        return;
    L5:
        mStartSystemCall = System.currentTimeMillis();
    }

    public static void onSystemCallFinished() {
        if (mSystemCallFinished <= 0) goto L5;
        return;
    L5:
        mSystemCallFinished = System.currentTimeMillis();
    }

    public static void registerWaitFinish() {
        if (mRegisterWaitFinish <= 0) goto L5;
        return;
    L5:
        mRegisterWaitFinish = System.currentTimeMillis();
    }

    public static void registerWaitOaid() {
        if (mRegisterWaitOaid <= 0) goto L5;
        return;
    L5:
        mRegisterWaitOaid = System.currentTimeMillis();
    }
}
