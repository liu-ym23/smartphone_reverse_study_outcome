package com.bytedance.bdlocation.log;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class LogPrinter implements Printer {
    private volatile boolean mEnable;

    public LogPrinter() {
    }

    @Override // com.bytedance.bdlocation.log.Printer
    public void d(String r1, String r2, Throwable r3) {
        if (this.mEnable == false) goto L6;
        Log.d(r1, r2, r3);
        return;
    }

    @Override // com.bytedance.bdlocation.log.Printer
    public void e(String r1, String r2, Throwable r3) {
        Log.e(r1, r2, r3);
    }

    @Override // com.bytedance.bdlocation.log.Printer
    public void i(String r1, String r2, Throwable r3) {
        if (this.mEnable == false) goto L6;
        Log.i(r1, r2, r3);
        return;
    }

    public void setEnable(boolean r1) {
        this.mEnable = r1;
    }

    @Override // com.bytedance.bdlocation.log.Printer
    public void v(String r1, String r2, Throwable r3) {
        if (this.mEnable == false) goto L6;
        Log.v(r1, r2, r3);
        return;
    }

    @Override // com.bytedance.bdlocation.log.Printer
    public void w(String r1, String r2, Throwable r3) {
        if (this.mEnable == false) goto L6;
        Log.w(r1, r2, r3);
        return;
    }
}
