package com.ss.android.ugc.effectmanager.knadapt;

import bytekn.foundation.logger.ILogger;
import com.ss.android.ugc.effectmanager.common.logger.EPLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0018\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0016J \u0010\u000f\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0018\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0016R$\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/ss/android/ugc/effectmanager/knadapt/KNLogger;", "Lbytekn/foundation/logger/ILogger;", "()V", "value", "", "enabled", "getEnabled", "()Z", "setEnabled", "(Z)V", "logDebug", "", "tag", "", "message", "logError", "exception", "", "logWarn", "effectmanager_release"}, k = 1, mv = {1, 1, 16})
public final class KNLogger implements ILogger {
    public static final KNLogger INSTANCE = null;

    private KNLogger() {
    }

    public void setEnabled(boolean r1) {
    }

    static {
        INSTANCE = new KNLogger();
    }

    public boolean getEnabled() {
        return EPLog.INSTANCE.getSEnableLog();
    }

    public void logDebug(String r1, String r2) {
        EPLog.d(r1, r2);
    }

    public void logError(String r1, String r2) {
        EPLog.e(r1, r2);
    }

    public void logWarn(String r1, String r2) {
        EPLog.w(r1, r2);
    }

    public void logError(String r1, String r2, Throwable r3) {
        EPLog.e(r1, r2, r3);
    }
}
