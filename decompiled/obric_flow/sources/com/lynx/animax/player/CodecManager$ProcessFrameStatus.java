package com.lynx.animax.player;

/* JADX INFO: loaded from: classes2.dex */
final enum CodecManager$ProcessFrameStatus extends Enum<CodecManager$ProcessFrameStatus> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CodecManager$ProcessFrameStatus f9638a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final CodecManager$ProcessFrameStatus f9639b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final CodecManager$ProcessFrameStatus f9640c = null;
    public static final CodecManager$ProcessFrameStatus d = null;
    public static final /* synthetic */ CodecManager$ProcessFrameStatus[] e = null;

    static {
        CodecManager$ProcessFrameStatus r5 = new CodecManager$ProcessFrameStatus("SUCCESS", 0);
        f9638a = r5;
        CodecManager$ProcessFrameStatus r10 = new CodecManager$ProcessFrameStatus("TRY_AGAIN_IF_NECESSARY", 1);
        f9639b = r10;
        CodecManager$ProcessFrameStatus r11 = new CodecManager$ProcessFrameStatus("TRY_AGAIN", 2);
        f9640c = r11;
        CodecManager$ProcessFrameStatus r12 = new CodecManager$ProcessFrameStatus("FATAL", 3);
        d = r12;
        e = new CodecManager$ProcessFrameStatus[]{r5, r10, r11, r12};
    }

    public CodecManager$ProcessFrameStatus(String r5, int r10) {
        super(r5, r10);
    }

    public static CodecManager$ProcessFrameStatus valueOf(String r5) {
        return (CodecManager$ProcessFrameStatus) Enum.valueOf(CodecManager$ProcessFrameStatus.class, r5);
    }

    public static CodecManager$ProcessFrameStatus[] values() {
        return (CodecManager$ProcessFrameStatus[]) e.clone();
    }
}
