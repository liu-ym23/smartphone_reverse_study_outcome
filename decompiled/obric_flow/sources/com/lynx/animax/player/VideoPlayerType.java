package com.lynx.animax.player;

/* JADX INFO: loaded from: classes2.dex */
public final enum VideoPlayerType extends Enum<VideoPlayerType> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VideoPlayerType[] f9644a = null;

    static {
        f9644a = new VideoPlayerType[]{new VideoPlayerType("DEFAULT", 0), new VideoPlayerType("CUSTOM", 1)};
    }

    public VideoPlayerType(String r5, int r10) {
        super(r5, r10);
    }

    public static VideoPlayerType valueOf(String r5) {
        return (VideoPlayerType) Enum.valueOf(VideoPlayerType.class, r5);
    }

    public static VideoPlayerType[] values() {
        return (VideoPlayerType[]) f9644a.clone();
    }
}
