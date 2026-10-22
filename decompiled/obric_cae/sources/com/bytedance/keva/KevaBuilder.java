package com.bytedance.keva;

import android.content.Context;
import android.util.Log;
import java.io.File;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class KevaBuilder {
    private static KevaBuilder mInstance;
    Context mContext;
    Executor mExecutor;
    KevaMonitor mMonitor;
    String mPortedRepoName;
    File mWorkDir;

    static {
        mInstance = new KevaBuilder();
    }

    public KevaBuilder() {
    }

    public static void clearInstance() {
        mInstance = null;
    }

    public static KevaBuilder getInstance() {
        KevaBuilder r8 = mInstance;
        if (r8 == null) goto L5;
        return r8;
    L5:
        Log.w(KevaConstants.TAG, "have already did init, builder is invalid now!");
        return new KevaBuilder();
    }

    public KevaBuilder setContext(Context r8) {
        this.mContext = r8;
        return this;
    }

    public KevaBuilder setExecutor(Executor r8) {
        this.mExecutor = r8;
        return this;
    }

    public KevaBuilder setMonitor(KevaMonitor r8) {
        this.mMonitor = r8;
        return this;
    }

    public KevaBuilder setPortedRepoName(String r8) {
        this.mPortedRepoName = r8;
        return this;
    }

    public KevaBuilder setWorkDir(File r8) {
        if (r8.exists() == true) goto L8;
        Log.i(KevaConstants.TAG, "work dir does not exist! try to create " + r8.getPath());
        if (r8.mkdirs() == true) goto L8;
        Log.w(KevaConstants.TAG, "work dir fail to create!");
        return this;
    L8:
        this.mWorkDir = r8;
        return this;
    }
}
