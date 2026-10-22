package com.bytedance.compression.zstd;

/* JADX INFO: loaded from: classes.dex */
public final enum EndDirective extends Enum<EndDirective> {
    private static final /* synthetic */ EndDirective[] $VALUES = null;
    public static final EndDirective CONTINUE = null;
    public static final EndDirective END = null;
    public static final EndDirective FLUSH = null;
    private final int value;

    static {
        EndDirective r10 = new EndDirective("CONTINUE", 0, 0);
        CONTINUE = r10;
        EndDirective r11 = new EndDirective("FLUSH", 1, 1);
        FLUSH = r11;
        EndDirective r12 = new EndDirective("END", 2, 2);
        END = r12;
        $VALUES = new EndDirective[]{r10, r11, r12};
    }

    private EndDirective(String r10, int r11, int r12) {
        super(r10, r11);
        this.value = r12;
    }

    public static EndDirective valueOf(String r10) {
        return (EndDirective) Enum.valueOf(EndDirective.class, r10);
    }

    public static EndDirective[] values() {
        return (EndDirective[]) $VALUES.clone();
    }

    int value() {
        return this.value;
    }
}
