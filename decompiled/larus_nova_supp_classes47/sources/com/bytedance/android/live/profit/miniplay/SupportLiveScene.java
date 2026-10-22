package com.bytedance.android.live.profit.miniplay;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\"\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#¨\u0006$"}, d2 = {"Lcom/bytedance/android/live/profit/miniplay/SupportLiveScene;", "", "", "value", "I", "getValue", "()I", "ALL_SCENE", "UNKNOWN_SCENE", "VIDEO_SINGLE_BROADCAST", "VIDEO_DOUBLE_PLAYERS_PK", "VIDEO_MULTI_ANCHOR_LINK", "VIDEO_AUDIENCE_LINK", "VIDEO_CHAT_ROOM", "VIDEO_EQUAL_CHAT_ROOM", "VIDEO_MEDIA_MULTI_ANCHOR", "VIDEO_LINK_ROOM", "AUDIO_SINGLE_BROADCAST", "AUDIO_CHAT_ROOM", "AUDIO_KTV_ROOM", "AUDIO_LINK_ROOM", "AUDIO_DOUBLE_PLAYERS_PK", "SCREEN_RECORD", "SCREEN_RECORD_LINK", "OBS_BROADCAST", "OBS_DOUBLE_PLAYERS_PK", "OBS_MULTI_ANCHOR_LINK", "OBS_AUDIENCE_LINK", "OBS_VIDEO_CHAT_ROOM", "OBS_AUDIO_CHAT_ROOM", "OBS_EQUAL_CHAT_ROOM", "OBS_KTV_ROOM", "OBS_LINK_ROOM", "OBS_MEDIA_MULTI_ANCHOR", "MEDIA_BROADCAST", "MEDIA_MULTI_ANCHOR", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum SupportLiveScene extends Enum<SupportLiveScene> {
    public static final SupportLiveScene ALL_SCENE = null;
    public static final SupportLiveScene AUDIO_CHAT_ROOM = null;
    public static final SupportLiveScene AUDIO_DOUBLE_PLAYERS_PK = null;
    public static final SupportLiveScene AUDIO_KTV_ROOM = null;
    public static final SupportLiveScene AUDIO_LINK_ROOM = null;
    public static final SupportLiveScene AUDIO_SINGLE_BROADCAST = null;
    public static final SupportLiveScene MEDIA_BROADCAST = null;
    public static final SupportLiveScene MEDIA_MULTI_ANCHOR = null;
    public static final SupportLiveScene OBS_AUDIENCE_LINK = null;
    public static final SupportLiveScene OBS_AUDIO_CHAT_ROOM = null;
    public static final SupportLiveScene OBS_BROADCAST = null;
    public static final SupportLiveScene OBS_DOUBLE_PLAYERS_PK = null;
    public static final SupportLiveScene OBS_EQUAL_CHAT_ROOM = null;
    public static final SupportLiveScene OBS_KTV_ROOM = null;
    public static final SupportLiveScene OBS_LINK_ROOM = null;
    public static final SupportLiveScene OBS_MEDIA_MULTI_ANCHOR = null;
    public static final SupportLiveScene OBS_MULTI_ANCHOR_LINK = null;
    public static final SupportLiveScene OBS_VIDEO_CHAT_ROOM = null;
    public static final SupportLiveScene SCREEN_RECORD = null;
    public static final SupportLiveScene SCREEN_RECORD_LINK = null;
    public static final SupportLiveScene UNKNOWN_SCENE = null;
    public static final SupportLiveScene VIDEO_AUDIENCE_LINK = null;
    public static final SupportLiveScene VIDEO_CHAT_ROOM = null;
    public static final SupportLiveScene VIDEO_DOUBLE_PLAYERS_PK = null;
    public static final SupportLiveScene VIDEO_EQUAL_CHAT_ROOM = null;
    public static final SupportLiveScene VIDEO_LINK_ROOM = null;
    public static final SupportLiveScene VIDEO_MEDIA_MULTI_ANCHOR = null;
    public static final SupportLiveScene VIDEO_MULTI_ANCHOR_LINK = null;
    public static final SupportLiveScene VIDEO_SINGLE_BROADCAST = null;
    public static final /* synthetic */ SupportLiveScene[] a = null;
    private final int value;

    public static SupportLiveScene valueOf(String r1) {
        return (SupportLiveScene) a.a(SupportLiveScene.class, r1);
    }

    public static SupportLiveScene[] values() {
        return (SupportLiveScene[]) a.clone();
    }

    static {
        SupportLiveScene r1 = new SupportLiveScene("ALL_SCENE", 0, -1);
        ALL_SCENE = r1;
        SupportLiveScene r2 = new SupportLiveScene("UNKNOWN_SCENE", 1, 0);
        UNKNOWN_SCENE = r2;
        SupportLiveScene r3 = new SupportLiveScene("VIDEO_SINGLE_BROADCAST", 2, 1);
        VIDEO_SINGLE_BROADCAST = r3;
        SupportLiveScene r4 = new SupportLiveScene("VIDEO_DOUBLE_PLAYERS_PK", 3, 2);
        VIDEO_DOUBLE_PLAYERS_PK = r4;
        SupportLiveScene r5 = new SupportLiveScene("VIDEO_MULTI_ANCHOR_LINK", 4, 4);
        VIDEO_MULTI_ANCHOR_LINK = r5;
        SupportLiveScene r6 = new SupportLiveScene("VIDEO_AUDIENCE_LINK", 5, 5);
        VIDEO_AUDIENCE_LINK = r6;
        SupportLiveScene r7 = new SupportLiveScene("VIDEO_CHAT_ROOM", 6, 6);
        VIDEO_CHAT_ROOM = r7;
        SupportLiveScene r8 = new SupportLiveScene("VIDEO_EQUAL_CHAT_ROOM", 7, 7);
        VIDEO_EQUAL_CHAT_ROOM = r8;
        SupportLiveScene r9 = new SupportLiveScene("VIDEO_MEDIA_MULTI_ANCHOR", 8, 8);
        VIDEO_MEDIA_MULTI_ANCHOR = r9;
        SupportLiveScene r10 = new SupportLiveScene("VIDEO_LINK_ROOM", 9, 9);
        VIDEO_LINK_ROOM = r10;
        SupportLiveScene r12 = new SupportLiveScene("AUDIO_SINGLE_BROADCAST", 10, 100);
        AUDIO_SINGLE_BROADCAST = r12;
        SupportLiveScene r13 = new SupportLiveScene("AUDIO_CHAT_ROOM", 11, 101);
        AUDIO_CHAT_ROOM = r13;
        SupportLiveScene r14 = new SupportLiveScene("AUDIO_KTV_ROOM", 12, 102);
        AUDIO_KTV_ROOM = r14;
        SupportLiveScene r15 = new SupportLiveScene("AUDIO_LINK_ROOM", 13, 103);
        AUDIO_LINK_ROOM = r15;
        SupportLiveScene r16 = new SupportLiveScene("AUDIO_DOUBLE_PLAYERS_PK", 14, 104);
        AUDIO_DOUBLE_PLAYERS_PK = r16;
        SupportLiveScene r17 = new SupportLiveScene("SCREEN_RECORD", 15, 200);
        SCREEN_RECORD = r17;
        SupportLiveScene r18 = new SupportLiveScene("SCREEN_RECORD_LINK", 16, 201);
        SCREEN_RECORD_LINK = r18;
        SupportLiveScene r19 = new SupportLiveScene("OBS_BROADCAST", 17, 300);
        OBS_BROADCAST = r19;
        SupportLiveScene r20 = new SupportLiveScene("OBS_DOUBLE_PLAYERS_PK", 18, 301);
        OBS_DOUBLE_PLAYERS_PK = r20;
        SupportLiveScene r22 = new SupportLiveScene("OBS_MULTI_ANCHOR_LINK", 19, 302);
        OBS_MULTI_ANCHOR_LINK = r22;
        SupportLiveScene r23 = new SupportLiveScene("OBS_AUDIENCE_LINK", 20, 303);
        OBS_AUDIENCE_LINK = r23;
        SupportLiveScene r24 = new SupportLiveScene("OBS_VIDEO_CHAT_ROOM", 21, 304);
        OBS_VIDEO_CHAT_ROOM = r24;
        SupportLiveScene r25 = new SupportLiveScene("OBS_AUDIO_CHAT_ROOM", 22, 305);
        OBS_AUDIO_CHAT_ROOM = r25;
        SupportLiveScene r26 = new SupportLiveScene("OBS_EQUAL_CHAT_ROOM", 23, 306);
        OBS_EQUAL_CHAT_ROOM = r26;
        SupportLiveScene r27 = new SupportLiveScene("OBS_KTV_ROOM", 24, 307);
        OBS_KTV_ROOM = r27;
        SupportLiveScene r28 = new SupportLiveScene("OBS_LINK_ROOM", 25, 308);
        OBS_LINK_ROOM = r28;
        SupportLiveScene r29 = new SupportLiveScene("OBS_MEDIA_MULTI_ANCHOR", 26, 309);
        OBS_MEDIA_MULTI_ANCHOR = r29;
        SupportLiveScene r30 = new SupportLiveScene("MEDIA_BROADCAST", 27, 400);
        MEDIA_BROADCAST = r30;
        SupportLiveScene r32 = new SupportLiveScene("MEDIA_MULTI_ANCHOR", 28, 401);
        MEDIA_MULTI_ANCHOR = r32;
        a = new SupportLiveScene[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r13, r14, r15, r16, r17, r18, r19, r20, r22, r23, r24, r25, r26, r27, r28, r29, r30, r32};
    }

    public final int getValue() {
        return this.value;
    }

    public SupportLiveScene(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public /* synthetic */ SupportLiveScene(String r1, int r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L5;
        r3 = 0;
    L5:
        this(r1, r2, r3);
    }
}
