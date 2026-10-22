package com.lynx.debugrouter.log;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public abstract class AbsLogDelegate implements ILogDelegate {
    public static final int TYPE_INC = 2;
    public static final int TYPE_OVERRIDE = 1;
    public int mMinimumLoggingLevel;

    private void println(int r1, String r2, String r3) {
    }

    @Override // com.lynx.debugrouter.log.ILogDelegate
    public int type() {
        return 2;
    }

    public AbsLogDelegate() {
        this.mMinimumLoggingLevel = 2;
    }

    @Override // com.lynx.debugrouter.log.ILogDelegate
    public int getMinimumLoggingLevel() {
        return this.mMinimumLoggingLevel;
    }

    @Override // com.lynx.debugrouter.log.ILogDelegate
    public boolean isLoggable(int r2) {
        if (this.mMinimumLoggingLevel > r2) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.lynx.debugrouter.log.ILogDelegate
    public void setMinimumLoggingLevel(int r1) {
        this.mMinimumLoggingLevel = r1;
    }

    @Override // com.lynx.debugrouter.log.ILogDelegate
    public void d(String r2, String r3) {
        println(3, r2, r3);
    }

    @Override // com.lynx.debugrouter.log.ILogDelegate
    public void e(String r2, String r3) {
        println(6, r2, r3);
    }

    @Override // com.lynx.debugrouter.log.ILogDelegate
    public void i(String r2, String r3) {
        println(4, r2, r3);
    }

    @Override // com.lynx.debugrouter.log.ILogDelegate
    public void k(String r2, String r3) {
        println(6, r2, r3);
    }

    @Override // com.lynx.debugrouter.log.ILogDelegate
    public void v(String r2, String r3) {
        println(2, r2, r3);
    }

    @Override // com.lynx.debugrouter.log.ILogDelegate
    public void w(String r2, String r3) {
        println(5, r2, r3);
    }

    @Override // com.lynx.debugrouter.log.ILogDelegate
    public void log(int r1, String r2, String r3) {
        println(r1, r2, r3);
    }
}
