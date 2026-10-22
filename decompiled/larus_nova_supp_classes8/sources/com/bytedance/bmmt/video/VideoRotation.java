package com.bytedance.bmmt.video;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final enum VideoRotation extends Enum<VideoRotation> {
    private static final /* synthetic */ VideoRotation[] $VALUES = null;
    public static final VideoRotation VIDEO_ROTATION_0 = null;
    public static final VideoRotation VIDEO_ROTATION_180 = null;
    public static final VideoRotation VIDEO_ROTATION_270 = null;
    public static final VideoRotation VIDEO_ROTATION_90 = null;
    private int value;

    private static /* synthetic */ VideoRotation[] $values() {
        return new VideoRotation[]{VIDEO_ROTATION_0, VIDEO_ROTATION_90, VIDEO_ROTATION_180, VIDEO_ROTATION_270};
    }

    static {
        VIDEO_ROTATION_0 = new VideoRotation("VIDEO_ROTATION_0", 0, 0);
        VIDEO_ROTATION_90 = new VideoRotation("VIDEO_ROTATION_90", 1, 90);
        VIDEO_ROTATION_180 = new VideoRotation("VIDEO_ROTATION_180", 2, 180);
        VIDEO_ROTATION_270 = new VideoRotation("VIDEO_ROTATION_270", 3, 270);
        $VALUES = $values();
    }

    public static VideoRotation[] values() {
        return (VideoRotation[]) $VALUES.clone();
    }

    public int value() {
        return this.value;
    }

    public static VideoRotation fromId(int r5) {
        VideoRotation[] r0 = values();
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L8;
        VideoRotation r3 = r0[r2];
        if (r3.value() == r5) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return r3;
    L8:
        return null;
    }

    public static VideoRotation valueOf(String r1) {
        return (VideoRotation) r27.a.a(VideoRotation.class, r1);
    }

    private VideoRotation(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
