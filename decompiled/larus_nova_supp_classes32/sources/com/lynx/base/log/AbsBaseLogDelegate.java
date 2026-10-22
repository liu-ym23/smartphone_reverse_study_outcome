package com.lynx.base.log;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public abstract class AbsBaseLogDelegate {
    public int mMinimumLoggingLevel;

    private void println(int r1, String r2, String r3) {
    }

    public AbsBaseLogDelegate() {
        this.mMinimumLoggingLevel = 4;
    }

    public int getMinimumLoggingLevel() {
        return this.mMinimumLoggingLevel;
    }

    public boolean isLoggable(int r2) {
        if (this.mMinimumLoggingLevel > r2) goto L5;
        return true;
    L5:
        return false;
    }

    public void setMinimumLoggingLevel(int r1) {
        this.mMinimumLoggingLevel = r1;
    }

    public void d(String r2, String r3) {
        println(3, r2, r3);
    }

    public void e(String r2, String r3) {
        println(6, r2, r3);
    }

    public void i(String r2, String r3) {
        println(4, r2, r3);
    }

    public void v(String r2, String r3) {
        println(2, r2, r3);
    }

    public void w(String r2, String r3) {
        println(5, r2, r3);
    }

    public void log(int r1, String r2, String r3) {
        println(r1, r2, r3);
    }
}
