package com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.base;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/live/liveinteract/chatroom/chatroom/seat/layer/base/MicSeatScene;", "", "AUDIO_LINK", "AUDIO_LINK_ANCHOR", "AUDIO_LINK_LARGE", "AUDIO_LINK_C_POSITION", "AUDIO_LINK_C_POSITION_V2", "AUDIO_LINK_HEAD_RADIO", "AUDIO_LINK_DYNAMIC_ISLAND", "AUDIO_LINK_HAMLET_AVATAR", "AUDIO_LINK_HAMLET_AVATAR_C_POSITION", "AUDIO_LINK_STAGE_ENLARGE", "AUDIO_LINK_STAGE_ENLARGE_MAIN", "VIDEO_LINK", "VIDEO_LINK_EQUAL", "KTV", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum MicSeatScene extends Enum<MicSeatScene> {
    public static final MicSeatScene AUDIO_LINK = null;
    public static final MicSeatScene AUDIO_LINK_ANCHOR = null;
    public static final MicSeatScene AUDIO_LINK_C_POSITION = null;
    public static final MicSeatScene AUDIO_LINK_C_POSITION_V2 = null;
    public static final MicSeatScene AUDIO_LINK_DYNAMIC_ISLAND = null;
    public static final MicSeatScene AUDIO_LINK_HAMLET_AVATAR = null;
    public static final MicSeatScene AUDIO_LINK_HAMLET_AVATAR_C_POSITION = null;
    public static final MicSeatScene AUDIO_LINK_HEAD_RADIO = null;
    public static final MicSeatScene AUDIO_LINK_LARGE = null;
    public static final MicSeatScene AUDIO_LINK_STAGE_ENLARGE = null;
    public static final MicSeatScene AUDIO_LINK_STAGE_ENLARGE_MAIN = null;
    public static final MicSeatScene KTV = null;
    public static final MicSeatScene VIDEO_LINK = null;
    public static final MicSeatScene VIDEO_LINK_EQUAL = null;
    public static final /* synthetic */ MicSeatScene[] a = null;

    static {
        MicSeatScene r1 = new MicSeatScene("AUDIO_LINK", 0);
        AUDIO_LINK = r1;
        MicSeatScene r2 = new MicSeatScene("AUDIO_LINK_ANCHOR", 1);
        AUDIO_LINK_ANCHOR = r2;
        MicSeatScene r3 = new MicSeatScene("AUDIO_LINK_LARGE", 2);
        AUDIO_LINK_LARGE = r3;
        MicSeatScene r4 = new MicSeatScene("AUDIO_LINK_C_POSITION", 3);
        AUDIO_LINK_C_POSITION = r4;
        MicSeatScene r5 = new MicSeatScene("AUDIO_LINK_C_POSITION_V2", 4);
        AUDIO_LINK_C_POSITION_V2 = r5;
        MicSeatScene r6 = new MicSeatScene("AUDIO_LINK_HEAD_RADIO", 5);
        AUDIO_LINK_HEAD_RADIO = r6;
        MicSeatScene r7 = new MicSeatScene("AUDIO_LINK_DYNAMIC_ISLAND", 6);
        AUDIO_LINK_DYNAMIC_ISLAND = r7;
        MicSeatScene r8 = new MicSeatScene("AUDIO_LINK_HAMLET_AVATAR", 7);
        AUDIO_LINK_HAMLET_AVATAR = r8;
        MicSeatScene r9 = new MicSeatScene("AUDIO_LINK_HAMLET_AVATAR_C_POSITION", 8);
        AUDIO_LINK_HAMLET_AVATAR_C_POSITION = r9;
        MicSeatScene r10 = new MicSeatScene("AUDIO_LINK_STAGE_ENLARGE", 9);
        AUDIO_LINK_STAGE_ENLARGE = r10;
        MicSeatScene r11 = new MicSeatScene("AUDIO_LINK_STAGE_ENLARGE_MAIN", 10);
        AUDIO_LINK_STAGE_ENLARGE_MAIN = r11;
        MicSeatScene r12 = new MicSeatScene("VIDEO_LINK", 11);
        VIDEO_LINK = r12;
        MicSeatScene r13 = new MicSeatScene("VIDEO_LINK_EQUAL", 12);
        VIDEO_LINK_EQUAL = r13;
        MicSeatScene r14 = new MicSeatScene("KTV", 13);
        KTV = r14;
        a = new MicSeatScene[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14};
    }

    public static MicSeatScene valueOf(String r1) {
        return (MicSeatScene) a.a(MicSeatScene.class, r1);
    }

    public static MicSeatScene[] values() {
        return (MicSeatScene[]) a.clone();
    }

    public MicSeatScene(String r1, int r2) {
        super(r1, r2);
    }
}
