package com.bytedance.bmmt.video;

import com.bytedance.android.livesdk.dsl.api.DSLType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
final enum BmmtVideoCodecStandard extends Enum<BmmtVideoCodecStandard> {
    private static final /* synthetic */ BmmtVideoCodecStandard[] $VALUES = null;
    public static final BmmtVideoCodecStandard AV1 = null;
    public static final BmmtVideoCodecStandard ByteVC1 = null;
    public static final BmmtVideoCodecStandard H264 = null;
    public static final BmmtVideoCodecStandard Unknown = null;
    public static final BmmtVideoCodecStandard VP8 = null;
    public static final BmmtVideoCodecStandard VP9 = null;
    private final int value;

    private static /* synthetic */ BmmtVideoCodecStandard[] $values() {
        return new BmmtVideoCodecStandard[]{H264, ByteVC1, Unknown, VP8, VP9, AV1};
    }

    static {
        H264 = new BmmtVideoCodecStandard("H264", 0, 0);
        ByteVC1 = new BmmtVideoCodecStandard("ByteVC1", 1, 1);
        Unknown = new BmmtVideoCodecStandard(DSLType.Unknown, 2, 2);
        VP8 = new BmmtVideoCodecStandard("VP8", 3, 8);
        VP9 = new BmmtVideoCodecStandard("VP9", 4, 9);
        AV1 = new BmmtVideoCodecStandard("AV1", 5, 10);
        $VALUES = $values();
    }

    public static BmmtVideoCodecStandard[] values() {
        return (BmmtVideoCodecStandard[]) $VALUES.clone();
    }

    public String mimeType() {
        int r0 = this.value;
        if (r0 != 1) goto L5;
        return "video/hevc";
    L5:
        if (r0 != 8) goto L7;
        return "video/x-vnd.on2.vp8";
    L7:
        if (r0 == 10) goto L10;
        return "video/avc";
    L10:
        return "video/av01";
    }

    public int toInt() {
        return this.value;
    }

    public static BmmtVideoCodecStandard fromValue(int r1) {
        if (r1 == 0) goto L18;
        if (r1 == 1) goto L16;
        if (r1 == 8) goto L14;
        if (r1 == 10) goto L12;
        return H264;
    L12:
        return AV1;
    L14:
        return VP8;
    L16:
        return ByteVC1;
    L18:
        return H264;
    }

    public static BmmtVideoCodecStandard valueOf(String r1) {
        return (BmmtVideoCodecStandard) r27.a.a(BmmtVideoCodecStandard.class, r1);
    }

    private BmmtVideoCodecStandard(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
