package com.bytedance.compression.zstd;

/* JADX INFO: loaded from: classes2.dex */
public final enum EndDirective extends Enum<EndDirective> {
    public static final EndDirective CONTINUE = null;
    public static final EndDirective END = null;
    public static final EndDirective FLUSH = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ EndDirective[] f4021a = null;
    private final int value;

    static {
        EndDirective r5 = new EndDirective("CONTINUE", 0, 0);
        CONTINUE = r5;
        EndDirective r10 = new EndDirective("FLUSH", 1, 1);
        FLUSH = r10;
        EndDirective r11 = new EndDirective("END", 2, 2);
        END = r11;
        f4021a = new EndDirective[]{r5, r10, r11};
    }

    public EndDirective(String r5, int r10, int r11) {
        super(r5, r10);
        this.value = r11;
    }

    public static EndDirective valueOf(String r5) {
        return (EndDirective) Enum.valueOf(EndDirective.class, r5);
    }

    public static EndDirective[] values() {
        return (EndDirective[]) f4021a.clone();
    }

    public int value() {
        return this.value;
    }
}
