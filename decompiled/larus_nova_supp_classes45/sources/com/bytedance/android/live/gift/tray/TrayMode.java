package com.bytedance.android.live.gift.tray;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/live/gift/tray/TrayMode;", "", "IDLE", "AUDIO_GIFT", "MULTI_PK", "EQUAL_VIDEO_TALK", "PLATFORM", "GAME", "MEDIA", "PK", "HOT_COMMENT", "VS_BAR", "VIDEO_CHORUS", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum TrayMode extends Enum<TrayMode> {
    public static final TrayMode AUDIO_GIFT = null;
    public static final TrayMode EQUAL_VIDEO_TALK = null;
    public static final TrayMode GAME = null;
    public static final TrayMode HOT_COMMENT = null;
    public static final TrayMode IDLE = null;
    public static final TrayMode MEDIA = null;
    public static final TrayMode MULTI_PK = null;
    public static final TrayMode PK = null;
    public static final TrayMode PLATFORM = null;
    public static final TrayMode VIDEO_CHORUS = null;
    public static final TrayMode VS_BAR = null;
    public static final /* synthetic */ TrayMode[] a = null;

    static {
        TrayMode r1 = new TrayMode("IDLE", 0);
        IDLE = r1;
        TrayMode r2 = new TrayMode("AUDIO_GIFT", 1);
        AUDIO_GIFT = r2;
        TrayMode r3 = new TrayMode("MULTI_PK", 2);
        MULTI_PK = r3;
        TrayMode r4 = new TrayMode("EQUAL_VIDEO_TALK", 3);
        EQUAL_VIDEO_TALK = r4;
        TrayMode r5 = new TrayMode("PLATFORM", 4);
        PLATFORM = r5;
        TrayMode r6 = new TrayMode("GAME", 5);
        GAME = r6;
        TrayMode r7 = new TrayMode("MEDIA", 6);
        MEDIA = r7;
        TrayMode r8 = new TrayMode("PK", 7);
        PK = r8;
        TrayMode r9 = new TrayMode("HOT_COMMENT", 8);
        HOT_COMMENT = r9;
        TrayMode r11 = new TrayMode("VS_BAR", 9);
        VS_BAR = r11;
        TrayMode r12 = new TrayMode("VIDEO_CHORUS", 10);
        VIDEO_CHORUS = r12;
        a = new TrayMode[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r12};
    }

    public static TrayMode valueOf(String r1) {
        return (TrayMode) a.a(TrayMode.class, r1);
    }

    public static TrayMode[] values() {
        return (TrayMode[]) a.clone();
    }

    public TrayMode(String r1, int r2) {
        super(r1, r2);
    }
}
