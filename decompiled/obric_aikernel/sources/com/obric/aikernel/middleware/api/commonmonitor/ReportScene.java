package com.obric.aikernel.middleware.api.commonmonitor;

/* JADX INFO: loaded from: classes2.dex */
public final enum ReportScene extends Enum<ReportScene> {
    private static final /* synthetic */ ReportScene[] $VALUES = null;
    public static final ReportScene app_start = null;
    public static final ReportScene exe = null;
    public static final ReportScene load = null;
    public static final ReportScene unload = null;
    private final String prefix;

    private static final /* synthetic */ ReportScene[] $values() {
        return new ReportScene[]{app_start, load, unload, exe};
    }

    static {
        app_start = new ReportScene("app_start", 0, "app_start");
        load = new ReportScene("load", 1, "load_");
        unload = new ReportScene("unload", 2, "unload_");
        exe = new ReportScene("exe", 3, "exe_");
        $VALUES = $values();
    }

    private ReportScene(String r10, int r11, String r12) {
        super(r10, r11);
        this.prefix = r12;
    }

    public static ReportScene valueOf(String r10) {
        return (ReportScene) Enum.valueOf(ReportScene.class, r10);
    }

    public static ReportScene[] values() {
        return (ReportScene[]) $VALUES.clone();
    }

    public final String getPrefix() {
        return this.prefix;
    }
}
