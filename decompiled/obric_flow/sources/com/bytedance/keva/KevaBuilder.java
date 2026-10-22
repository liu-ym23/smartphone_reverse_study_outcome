package com.bytedance.keva;

import android.content.Context;
import android.util.Log;
import java.io.File;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public class KevaBuilder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f6713a = 0;
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
        KevaBuilder r5 = mInstance;
        if (r5 == null) goto L5;
        return r5;
    L5:
        Log.w(KevaConstants.TAG, "have already did init, builder is invalid now!");
        return new KevaBuilder();
    }

    public KevaBuilder setContext(Context r5) {
        this.mContext = r5;
        return this;
    }

    public KevaBuilder setExecutor(Executor r5) {
        this.mExecutor = r5;
        return this;
    }

    public KevaBuilder setMonitor(KevaMonitor r5) {
        this.mMonitor = r5;
        return this;
    }

    public KevaBuilder setPortedRepoName(String r5) {
        this.mPortedRepoName = r5;
        return this;
    }

    public KevaBuilder setWorkDir(File r5) {
        if (r5.exists() == true) goto L8;
        Log.i(KevaConstants.TAG, "work dir does not exist! try to create " + r5.getPath());
        if (r5.mkdirs() == true) goto L8;
        Log.w(KevaConstants.TAG, "work dir fail to create!");
        return this;
    L8:
        this.mWorkDir = r5;
        return this;
    }
}
