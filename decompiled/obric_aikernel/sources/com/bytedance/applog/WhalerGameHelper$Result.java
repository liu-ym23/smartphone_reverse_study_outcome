package com.bytedance.applog;

/* JADX INFO: loaded from: classes.dex */
public final enum WhalerGameHelper$Result extends Enum<WhalerGameHelper$Result> {
    private static final /* synthetic */ WhalerGameHelper$Result[] $VALUES = null;
    public static final WhalerGameHelper$Result FAIL = null;
    public static final WhalerGameHelper$Result SUCCESS = null;
    public static final WhalerGameHelper$Result UNCOMPLETED = null;
    final String gameResult;

    static {
        WhalerGameHelper$Result r10 = new WhalerGameHelper$Result("UNCOMPLETED", 0, "uncompleted");
        UNCOMPLETED = r10;
        WhalerGameHelper$Result r11 = new WhalerGameHelper$Result("SUCCESS", 1, "success");
        SUCCESS = r11;
        WhalerGameHelper$Result r12 = new WhalerGameHelper$Result("FAIL", 2, "fail");
        FAIL = r12;
        $VALUES = new WhalerGameHelper$Result[]{r10, r11, r12};
    }

    private WhalerGameHelper$Result(String r10, int r11, String r12) {
        super(r10, r11);
        this.gameResult = r12;
    }

    public static WhalerGameHelper$Result valueOf(String r10) {
        return (WhalerGameHelper$Result) Enum.valueOf(WhalerGameHelper$Result.class, r10);
    }

    public static WhalerGameHelper$Result[] values() {
        return (WhalerGameHelper$Result[]) $VALUES.clone();
    }
}
