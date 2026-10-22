package com.bytedance.android.live.multilink.external.api.core.type;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000e\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/live/multilink/external/api/core/type/AckFromSource;", "", "PK_WITH_AUDIENCE_SILENCE_API", "PK_WITH_AUDIENCE_SILENCE_MESSAGE", "PK_WITH_AUDIENCE_CAMERA_API", "PK_WITH_AUDIENCE_CAMERA_MESSAGE", "TALK_ROOM_SILENCE_API", "TALK_ROOM_SILENCE_MESSAGE", "TALK_ROOM_CAMERA_API", "TALK_ROOM_CAMERA_MESSAGE", "VOICE_CHAT_SILENCE_API", "VOICE_CHAT_SILENCE_MESSAGE", "KTV_CAMERA_API", "KTV_CAMERA_MESSAGE", "LINK_MULTI_RTS", "multilink-external-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum AckFromSource extends Enum<AckFromSource> {
    public static final AckFromSource KTV_CAMERA_API = null;
    public static final AckFromSource KTV_CAMERA_MESSAGE = null;
    public static final AckFromSource LINK_MULTI_RTS = null;
    public static final AckFromSource PK_WITH_AUDIENCE_CAMERA_API = null;
    public static final AckFromSource PK_WITH_AUDIENCE_CAMERA_MESSAGE = null;
    public static final AckFromSource PK_WITH_AUDIENCE_SILENCE_API = null;
    public static final AckFromSource PK_WITH_AUDIENCE_SILENCE_MESSAGE = null;
    public static final AckFromSource TALK_ROOM_CAMERA_API = null;
    public static final AckFromSource TALK_ROOM_CAMERA_MESSAGE = null;
    public static final AckFromSource TALK_ROOM_SILENCE_API = null;
    public static final AckFromSource TALK_ROOM_SILENCE_MESSAGE = null;
    public static final AckFromSource VOICE_CHAT_SILENCE_API = null;
    public static final AckFromSource VOICE_CHAT_SILENCE_MESSAGE = null;
    public static final /* synthetic */ AckFromSource[] a = null;

    static {
        AckFromSource r1 = new AckFromSource("PK_WITH_AUDIENCE_SILENCE_API", 0);
        PK_WITH_AUDIENCE_SILENCE_API = r1;
        AckFromSource r2 = new AckFromSource("PK_WITH_AUDIENCE_SILENCE_MESSAGE", 1);
        PK_WITH_AUDIENCE_SILENCE_MESSAGE = r2;
        AckFromSource r3 = new AckFromSource("PK_WITH_AUDIENCE_CAMERA_API", 2);
        PK_WITH_AUDIENCE_CAMERA_API = r3;
        AckFromSource r4 = new AckFromSource("PK_WITH_AUDIENCE_CAMERA_MESSAGE", 3);
        PK_WITH_AUDIENCE_CAMERA_MESSAGE = r4;
        AckFromSource r5 = new AckFromSource("TALK_ROOM_SILENCE_API", 4);
        TALK_ROOM_SILENCE_API = r5;
        AckFromSource r6 = new AckFromSource("TALK_ROOM_SILENCE_MESSAGE", 5);
        TALK_ROOM_SILENCE_MESSAGE = r6;
        AckFromSource r7 = new AckFromSource("TALK_ROOM_CAMERA_API", 6);
        TALK_ROOM_CAMERA_API = r7;
        AckFromSource r8 = new AckFromSource("TALK_ROOM_CAMERA_MESSAGE", 7);
        TALK_ROOM_CAMERA_MESSAGE = r8;
        AckFromSource r9 = new AckFromSource("VOICE_CHAT_SILENCE_API", 8);
        VOICE_CHAT_SILENCE_API = r9;
        AckFromSource r10 = new AckFromSource("VOICE_CHAT_SILENCE_MESSAGE", 9);
        VOICE_CHAT_SILENCE_MESSAGE = r10;
        AckFromSource r11 = new AckFromSource("KTV_CAMERA_API", 10);
        KTV_CAMERA_API = r11;
        AckFromSource r12 = new AckFromSource("KTV_CAMERA_MESSAGE", 11);
        KTV_CAMERA_MESSAGE = r12;
        AckFromSource r13 = new AckFromSource("LINK_MULTI_RTS", 12);
        LINK_MULTI_RTS = r13;
        a = new AckFromSource[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13};
    }

    public static AckFromSource valueOf(String r1) {
        return (AckFromSource) a.a(AckFromSource.class, r1);
    }

    public static AckFromSource[] values() {
        return (AckFromSource[]) a.clone();
    }

    public AckFromSource(String r1, int r2) {
        super(r1, r2);
    }
}
