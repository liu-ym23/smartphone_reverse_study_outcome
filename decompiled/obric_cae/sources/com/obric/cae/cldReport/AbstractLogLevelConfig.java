package com.obric.cae.cldReport;

import android.content.Context;
import com.obric.cae.cldReport.logLevelDataBase.LogLevDAO;
import com.obric.cae.cldReport.logLevelDataBase.LogLevEntry;

/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractLogLevelConfig {
    private final Context mContext;
    private final LogLevDAO mDb;

    public static class ErrorCodeAndLogConfMap {
        private int duration;
        private int errorCode;
        private String errorName;
        ModuleAndLogMasks[] moduleAndLogMasks;

        public ErrorCodeAndLogConfMap(int r8, String r10, int r11, ModuleAndLogMasks[] r12) {
            this.errorCode = r8;
            this.duration = r11;
            this.errorName = r10;
            this.moduleAndLogMasks = r12;
        }

        public int getDuration() {
            return this.duration;
        }

        public int getErrorCode() {
            return this.errorCode;
        }

        public String getErrorName() {
            return this.errorName;
        }

        public ModuleAndLogMasks[] getLogLevelMasks() {
            return this.moduleAndLogMasks;
        }
    }

    public static class ModuleAndLogMasks {
        public int logMasks;
        public int modType;

        public ModuleAndLogMasks(int r8, int r10) {
            this.modType = r8;
            this.logMasks = r10;
        }
    }

    public AbstractLogLevelConfig(Context r8) {
        this.mContext = r8;
        this.mDb = LogLevDAO.getInstance(r8);
    }

    public void deleteLogLevDb(String r8, int r10) {
        this.mDb.deleteLogEntry(r8, r10);
    }

    public void insertLogLevDb(String r8, int r10, int r11) {
        if (r11 > 0) goto L5;
        return;
    L5:
        if (this.mDb.getLogEntry(r8, r10) == null) goto L7;
        this.mDb.deleteLogEntry(r8, r10);
    L7:
        StringBuilder r12 = new StringBuilder("insertLogLevDb: moduleStr=");
        r12.append(r8);
        r12.append(", levelMask=");
        r12.append(r10);
        r12.append(", duration=");
        defpackage.b.p(r12, r11, "CldCommon");
        long r13 = CldUtil.getCurrentTimeMillis();
        String r14 = CldUtil.timeMillisToDateString(r13 + (((long) r11) * 1000));
        LogLevEntry r15 = new LogLevEntry(r8, r10, CldUtil.getCurrentTimeFormatted(), r14);
        this.mDb.addLogEntry(r15);
    }

    public abstract void logLevelDecrement(int r8, boolean r10);

    public abstract void logLevelIncrement(int r8, int r10, boolean r11);

    public void updateLogLevDb(String r8, int r10, int r11) {
        if (r11 > 0) goto L4;
        return;
    L4:
        LogLevEntry r12 = this.mDb.getLogEntry(r8, r10);
        if (r12 != null) goto L7;
        return;
    L7:
        String r13 = r12.getInvalidDate();
        if (r13 != null) goto L10;
        return;
    L10:
        long r14 = CldUtil.stringToTimeMillis(r13);
        long r15 = ((long) r11) * 1000;
        if (r14 >= (CldUtil.getCurrentTimeMillis() + r15)) goto L14;
        r12.setInvalidDate(CldUtil.timeMillisToDateString(CldUtil.getCurrentTimeMillis() + r15));
        this.mDb.updateLogEntry(r12);
        return;
    }
}
