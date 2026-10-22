package com.lynx.tasm.service;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public interface ILynxLogService extends IServiceProvider {

    public static final enum LogOutputChannelType extends Enum<LogOutputChannelType> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final LogOutputChannelType f10955a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final LogOutputChannelType f10956b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ LogOutputChannelType[] f10957c = null;

        static {
            LogOutputChannelType r5 = new LogOutputChannelType("Native", 0);
            f10955a = r5;
            LogOutputChannelType r10 = new LogOutputChannelType("Platform", 1);
            f10956b = r10;
            f10957c = new LogOutputChannelType[]{r5, r10};
        }

        public LogOutputChannelType(String r5, int r10) {
            super(r5, r10);
        }

        public static LogOutputChannelType valueOf(String r5) {
            return (LogOutputChannelType) Enum.valueOf(LogOutputChannelType.class, r5);
        }

        public static LogOutputChannelType[] values() {
            return (LogOutputChannelType[]) f10957c.clone();
        }
    }

    long getDefaultWriteFunction();

    boolean getLogToSystemStatus();

    @Override // com.lynx.tasm.service.IServiceProvider
    @NonNull
    default Class<? extends IServiceProvider> getServiceClass() {
        return ILynxLogService.class;
    }

    boolean isLogOutputByPlatform();

    void logByPlatform(int r5, String r10, String r11);

    void switchLogToSystem(boolean r5);
}
