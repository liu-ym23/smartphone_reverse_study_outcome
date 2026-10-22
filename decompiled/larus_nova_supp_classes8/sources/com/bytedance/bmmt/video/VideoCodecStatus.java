package com.bytedance.bmmt.video;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final enum VideoCodecStatus extends Enum<VideoCodecStatus> {
    private static final /* synthetic */ VideoCodecStatus[] $VALUES = null;
    public static final VideoCodecStatus DROP_DECODED_FRAME = null;
    public static final VideoCodecStatus ERROR = null;
    public static final VideoCodecStatus ERR_PARAMETER = null;
    public static final VideoCodecStatus ERR_SIZE = null;
    public static final VideoCodecStatus FALLBACK_SOFTWARE = null;
    public static final VideoCodecStatus LEVEL_EXCEEDED = null;
    public static final VideoCodecStatus MEDIACODEC_EXCEPTION = null;
    public static final VideoCodecStatus MEDIACODEC_OUT_OF_RESOLUTION = null;
    public static final VideoCodecStatus MEMORY = null;
    public static final VideoCodecStatus NO_OUTPUT = null;
    public static final VideoCodecStatus OK = null;
    public static final VideoCodecStatus OVERLOAD = null;
    public static final VideoCodecStatus TIMEOUT = null;
    public static final VideoCodecStatus UNINITIALIZED = null;
    public static final VideoCodecStatus USING_INTERNAL_SURFACE = null;
    private final int number;

    private static /* synthetic */ VideoCodecStatus[] $values() {
        return new VideoCodecStatus[]{OK, ERR_PARAMETER, ERR_SIZE, LEVEL_EXCEEDED, UNINITIALIZED, MEMORY, ERROR, TIMEOUT, NO_OUTPUT, FALLBACK_SOFTWARE, MEDIACODEC_EXCEPTION, USING_INTERNAL_SURFACE, OVERLOAD, MEDIACODEC_OUT_OF_RESOLUTION, DROP_DECODED_FRAME};
    }

    static {
        OK = new VideoCodecStatus("OK", 0, 0);
        ERR_PARAMETER = new VideoCodecStatus("ERR_PARAMETER", 1, 3001);
        ERR_SIZE = new VideoCodecStatus("ERR_SIZE", 2, 3001);
        LEVEL_EXCEEDED = new VideoCodecStatus("LEVEL_EXCEEDED", 3, 3001);
        UNINITIALIZED = new VideoCodecStatus("UNINITIALIZED", 4, 4002);
        MEMORY = new VideoCodecStatus("MEMORY", 5, 4003);
        ERROR = new VideoCodecStatus("ERROR", 6, 4003);
        TIMEOUT = new VideoCodecStatus("TIMEOUT", 7, 4007);
        NO_OUTPUT = new VideoCodecStatus("NO_OUTPUT", 8, 2002);
        FALLBACK_SOFTWARE = new VideoCodecStatus("FALLBACK_SOFTWARE", 9, 4009);
        MEDIACODEC_EXCEPTION = new VideoCodecStatus("MEDIACODEC_EXCEPTION", 10, 2006);
        USING_INTERNAL_SURFACE = new VideoCodecStatus("USING_INTERNAL_SURFACE", 11, 2007);
        OVERLOAD = new VideoCodecStatus("OVERLOAD", 12, 4005);
        MEDIACODEC_OUT_OF_RESOLUTION = new VideoCodecStatus("MEDIACODEC_OUT_OF_RESOLUTION", 13, 2008);
        DROP_DECODED_FRAME = new VideoCodecStatus("DROP_DECODED_FRAME", 14, 2002);
        $VALUES = $values();
    }

    public static VideoCodecStatus[] values() {
        return (VideoCodecStatus[]) $VALUES.clone();
    }

    public int getNumber() {
        return this.number;
    }

    public static VideoCodecStatus valueOf(String r1) {
        return (VideoCodecStatus) r27.a.a(VideoCodecStatus.class, r1);
    }

    private VideoCodecStatus(String r1, int r2, int r3) {
        super(r1, r2);
        this.number = r3;
    }
}
