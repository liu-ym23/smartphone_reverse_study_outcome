package com.lynx.tasm.service;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public interface ILynxLogService extends IServiceProvider {

    /* JADX INFO: renamed from: com.lynx.tasm.service.ILynxLogService$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static Class $default$getServiceClass(ILynxLogService r0) {
            return ILynxLogService.class;
        }
    }

    public static final enum LogOutputChannelType extends Enum<LogOutputChannelType> {
        public static final LogOutputChannelType Native = null;
        public static final LogOutputChannelType Platform = null;
        public static final /* synthetic */ LogOutputChannelType[] a = null;

        static {
            LogOutputChannelType r0 = new LogOutputChannelType("Native", 0);
            Native = r0;
            LogOutputChannelType r1 = new LogOutputChannelType("Platform", 1);
            Platform = r1;
            a = new LogOutputChannelType[]{r0, r1};
        }

        public static LogOutputChannelType[] values() {
            return (LogOutputChannelType[]) a.clone();
        }

        public static LogOutputChannelType valueOf(String r1) {
            return (LogOutputChannelType) a.a(LogOutputChannelType.class, r1);
        }

        public LogOutputChannelType(String r1, int r2) {
            super(r1, r2);
        }
    }

    long getDefaultWriteFunction();

    boolean getLogToSystemStatus();

    @Override // com.lynx.tasm.service.IServiceProvider
    Class<? extends IServiceProvider> getServiceClass();

    boolean isLogOutputByPlatform();

    void logByPlatform(int r1, String r2, String r3);

    void switchLogToSystem(boolean r1);
}
