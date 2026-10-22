package com.lynx.animax.player;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final enum VideoPlayerType extends Enum<VideoPlayerType> {
    public static final VideoPlayerType CUSTOM = null;
    public static final VideoPlayerType DEFAULT = null;
    public static final /* synthetic */ VideoPlayerType[] a = null;

    static {
        VideoPlayerType r0 = new VideoPlayerType("DEFAULT", 0);
        DEFAULT = r0;
        VideoPlayerType r1 = new VideoPlayerType("CUSTOM", 1);
        CUSTOM = r1;
        a = new VideoPlayerType[]{r0, r1};
    }

    public static VideoPlayerType[] values() {
        return (VideoPlayerType[]) a.clone();
    }

    public static VideoPlayerType valueOf(String r1) {
        return (VideoPlayerType) r27.a.a(VideoPlayerType.class, r1);
    }

    public VideoPlayerType(String r1, int r2) {
        super(r1, r2);
    }
}
