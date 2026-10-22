package com.ss.android.lark.framework.assembly.logger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final enum ProcessEnum extends Enum<ProcessEnum> {
    private static final /* synthetic */ ProcessEnum[] $VALUES = null;
    public static final ProcessEnum Default = null;
    public static final ProcessEnum Mail = null;
    public static final ProcessEnum Main = null;
    public static final ProcessEnum Mini = null;
    public static final ProcessEnum P0 = null;
    public static final ProcessEnum Push = null;
    public static final ProcessEnum PushService = null;
    public static final ProcessEnum Sandbox = null;
    public static final ProcessEnum Wschannel = null;

    static {
        ProcessEnum r0 = new ProcessEnum("Main", 0);
        Main = r0;
        ProcessEnum r1 = new ProcessEnum("P0", 1);
        P0 = r1;
        ProcessEnum r3 = new ProcessEnum("Mini", 2);
        Mini = r3;
        ProcessEnum r5 = new ProcessEnum("Mail", 3);
        Mail = r5;
        ProcessEnum r7 = new ProcessEnum("Sandbox", 4);
        Sandbox = r7;
        ProcessEnum r9 = new ProcessEnum("Wschannel", 5);
        Wschannel = r9;
        ProcessEnum r11 = new ProcessEnum("Push", 6);
        Push = r11;
        ProcessEnum r13 = new ProcessEnum("PushService", 7);
        PushService = r13;
        ProcessEnum r15 = new ProcessEnum("Default", 8);
        Default = r15;
        $VALUES = new ProcessEnum[]{r0, r1, r3, r5, r7, r9, r11, r13, r15};
    }

    public static ProcessEnum[] values() {
        return (ProcessEnum[]) $VALUES.clone();
    }

    public static ProcessEnum valueOf(String r1) {
        return (ProcessEnum) r27.a.a(ProcessEnum.class, r1);
    }

    private ProcessEnum(String r1, int r2) {
        super(r1, r2);
    }
}
