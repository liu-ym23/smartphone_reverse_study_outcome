package com.bytedance.android.live.liveinteract.videotalk.avatarmix;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/liveinteract/videotalk/avatarmix/MicseatType;", "", "Empty", "VideoVoice", "Video", "Voice", "liveinteract-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum MicseatType extends Enum<MicseatType> {
    public static final MicseatType Empty = null;
    public static final MicseatType Video = null;
    public static final MicseatType VideoVoice = null;
    public static final MicseatType Voice = null;
    public static final /* synthetic */ MicseatType[] a = null;

    static {
        MicseatType r1 = new MicseatType("Empty", 0);
        Empty = r1;
        MicseatType r2 = new MicseatType("VideoVoice", 1);
        VideoVoice = r2;
        MicseatType r3 = new MicseatType("Video", 2);
        Video = r3;
        MicseatType r4 = new MicseatType("Voice", 3);
        Voice = r4;
        a = new MicseatType[]{r1, r2, r3, r4};
    }

    public static MicseatType valueOf(String r1) {
        return (MicseatType) r27.a.a(MicseatType.class, r1);
    }

    public static MicseatType[] values() {
        return (MicseatType[]) a.clone();
    }

    public MicseatType(String r1, int r2) {
        super(r1, r2);
    }
}
