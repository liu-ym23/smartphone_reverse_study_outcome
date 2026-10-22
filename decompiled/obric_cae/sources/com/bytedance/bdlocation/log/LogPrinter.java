package com.bytedance.bdlocation.log;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class LogPrinter implements Printer {
    private volatile boolean mEnable;

    public LogPrinter() {
    }

    @Override // com.bytedance.bdlocation.log.Printer
    public void d(String r8, String r10, Throwable r11) {
        if (this.mEnable == false) goto L6;
        Log.d(r8, r10, r11);
        return;
    }

    @Override // com.bytedance.bdlocation.log.Printer
    public void e(String r8, String r10, Throwable r11) {
        Log.e(r8, r10, r11);
    }

    @Override // com.bytedance.bdlocation.log.Printer
    public void i(String r8, String r10, Throwable r11) {
        if (this.mEnable == false) goto L6;
        Log.i(r8, r10, r11);
        return;
    }

    public void setEnable(boolean r8) {
        this.mEnable = r8;
    }

    @Override // com.bytedance.bdlocation.log.Printer
    public void v(String r8, String r10, Throwable r11) {
        if (this.mEnable == false) goto L6;
        Log.v(r8, r10, r11);
        return;
    }

    @Override // com.bytedance.bdlocation.log.Printer
    public void w(String r8, String r10, Throwable r11) {
        if (this.mEnable == false) goto L6;
        Log.w(r8, r10, r11);
        return;
    }
}
