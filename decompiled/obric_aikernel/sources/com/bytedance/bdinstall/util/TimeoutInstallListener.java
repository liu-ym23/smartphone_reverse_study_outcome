package com.bytedance.bdinstall.util;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.bytedance.bdinstall.BDInstall;
import com.bytedance.bdinstall.IInstallListener;
import com.bytedance.bdinstall.InstallInfo;
import com.bytedance.bdinstall.InstallOptions;
import com.bytedance.bdinstall.OnResetListener;

/* JADX INFO: loaded from: classes.dex */
public class TimeoutInstallListener implements IInstallListener {
    private final Handler mHandler;
    private OnResetListener mListener;
    private final long mTimeout;
    private InstallOptions sOptions;

    public TimeoutInstallListener(long r10, OnResetListener r11, InstallOptions r12) {
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mTimeout = r10;
        this.mListener = r11;
        this.sOptions = r12;
    }

    static /* synthetic */ OnResetListener access$000(TimeoutInstallListener r10) {
        return r10.mListener;
    }

    static /* synthetic */ OnResetListener access$002(TimeoutInstallListener r10, OnResetListener r11) {
        r10.mListener = r11;
        return r11;
    }

    static /* synthetic */ void access$100(TimeoutInstallListener r10) {
        r10.removeInstallListener();
    }

    private void removeInstallListener() {
        InstallOptions r10 = this.sOptions;
        if (r10 != null) goto L5;
    L8:
        BDInstall.removeInstallListener(this);
        return;
    L5:
        if (r10.isMainInstance() == true) goto L8;
        BDInstall.getInstance(String.valueOf(this.sOptions.getAid())).removeInstallListener(this);
    }

    @Override // com.bytedance.bdinstall.IInstallListener
    public void installFinished(@NonNull final InstallInfo r10) {
        this.mHandler.post(new AnonymousClass1(this, r10));
    }

    public void startTiming() {
        this.mHandler.postDelayed(new AnonymousClass2(this), this.mTimeout);
    }
}
