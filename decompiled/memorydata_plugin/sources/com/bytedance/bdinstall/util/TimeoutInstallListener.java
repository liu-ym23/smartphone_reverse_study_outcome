package com.bytedance.bdinstall.util;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.bdinstall.BDInstall;
import com.bytedance.bdinstall.IInstallListener;
import com.bytedance.bdinstall.InstallInfo;
import com.bytedance.bdinstall.InstallOptions;
import com.bytedance.bdinstall.OnResetListener;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class TimeoutInstallListener implements IInstallListener {
    private final Handler mHandler;
    private OnResetListener mListener;
    private final long mTimeout;
    private InstallOptions sOptions;

    public TimeoutInstallListener(long r3, OnResetListener r5, InstallOptions r6) {
        OnResetListener r7 = (OnResetListener) ZeusTransformUtils.wrapperContextForParams(r5, OnResetListener.class, "com.obric.memorydata.plugin");
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mTimeout = r3;
        this.mListener = r7;
        this.sOptions = r6;
    }

    static /* synthetic */ OnResetListener access$000(TimeoutInstallListener r0) {
        return r0.mListener;
    }

    static /* synthetic */ OnResetListener access$002(TimeoutInstallListener r2, OnResetListener r3) {
        OnResetListener r4 = (OnResetListener) ZeusTransformUtils.wrapperContextForParams(r3, OnResetListener.class, "com.obric.memorydata.plugin");
        r2.mListener = r4;
        return r4;
    }

    static /* synthetic */ void access$100(TimeoutInstallListener r0) {
        r0.removeInstallListener();
    }

    private void removeInstallListener() {
        InstallOptions r0 = this.sOptions;
        if (r0 != null) goto L5;
    L8:
        BDInstall.removeInstallListener(this);
        return;
    L5:
        if (r0.isMainInstance() == true) goto L8;
        BDInstall.getInstance(String.valueOf(this.sOptions.getAid())).removeInstallListener(this);
    }

    @Override // com.bytedance.bdinstall.IInstallListener
    public void installFinished(final InstallInfo r3) {
        this.mHandler.post(new AnonymousClass1(this, r3));
    }

    public void startTiming() {
        this.mHandler.postDelayed(new AnonymousClass2(this), this.mTimeout);
    }
}
