package com.ss.android.lark.feed.app.entity;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0015\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015¨\u0006\u0016"}, d2 = {"Lcom/ss/android/lark/feed/app/entity/MutexMarkType;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "UNKNOWN", "DRAFT", "SENDING", "FAILED", "VIDEO_MEETING", "UNREAD", "ENCRYPTED_CALL", "READ", "VOICE_CALL", "VC_MEETING_STARTED", "VC_MEETING_ENDED_OVER_ONE_HOUR", "VC_MEETING_ENDED_LESS_ONE_HOUR", "VC_MEETING_ENDED_LESS_ONE_MINUTE", "VC_DEFAULT_MEETING_ENDED_OVER_ONE_HOUR", "VC_DEFAULT_MEETING_ENDED_LESS_ONE_HOUR", "VC_DEFAULT_MEETING_ENDED_LESS_ONE_MIN", "CHAT_ROOM_CARD", "CHAT_ROOM_START_MESSAGE", "feed-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MutexMarkType extends Enum<MutexMarkType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ MutexMarkType[] $VALUES = null;
    public static final MutexMarkType CHAT_ROOM_CARD = null;
    public static final MutexMarkType CHAT_ROOM_START_MESSAGE = null;
    public static final MutexMarkType DRAFT = null;
    public static final MutexMarkType ENCRYPTED_CALL = null;
    public static final MutexMarkType FAILED = null;
    public static final MutexMarkType READ = null;
    public static final MutexMarkType SENDING = null;
    public static final MutexMarkType UNKNOWN = null;
    public static final MutexMarkType UNREAD = null;
    public static final MutexMarkType VC_DEFAULT_MEETING_ENDED_LESS_ONE_HOUR = null;
    public static final MutexMarkType VC_DEFAULT_MEETING_ENDED_LESS_ONE_MIN = null;
    public static final MutexMarkType VC_DEFAULT_MEETING_ENDED_OVER_ONE_HOUR = null;
    public static final MutexMarkType VC_MEETING_ENDED_LESS_ONE_HOUR = null;
    public static final MutexMarkType VC_MEETING_ENDED_LESS_ONE_MINUTE = null;
    public static final MutexMarkType VC_MEETING_ENDED_OVER_ONE_HOUR = null;
    public static final MutexMarkType VC_MEETING_STARTED = null;
    public static final MutexMarkType VIDEO_MEETING = null;
    public static final MutexMarkType VOICE_CALL = null;

    private static final /* synthetic */ MutexMarkType[] $values() {
        return new MutexMarkType[]{UNKNOWN, DRAFT, SENDING, FAILED, VIDEO_MEETING, UNREAD, ENCRYPTED_CALL, READ, VOICE_CALL, VC_MEETING_STARTED, VC_MEETING_ENDED_OVER_ONE_HOUR, VC_MEETING_ENDED_LESS_ONE_HOUR, VC_MEETING_ENDED_LESS_ONE_MINUTE, VC_DEFAULT_MEETING_ENDED_OVER_ONE_HOUR, VC_DEFAULT_MEETING_ENDED_LESS_ONE_HOUR, VC_DEFAULT_MEETING_ENDED_LESS_ONE_MIN, CHAT_ROOM_CARD, CHAT_ROOM_START_MESSAGE};
    }

    public static EnumEntries<MutexMarkType> getEntries() {
        return $ENTRIES;
    }

    static {
        UNKNOWN = new MutexMarkType("UNKNOWN", 0);
        DRAFT = new MutexMarkType("DRAFT", 1);
        SENDING = new MutexMarkType("SENDING", 2);
        FAILED = new MutexMarkType("FAILED", 3);
        VIDEO_MEETING = new MutexMarkType("VIDEO_MEETING", 4);
        UNREAD = new MutexMarkType("UNREAD", 5);
        ENCRYPTED_CALL = new MutexMarkType("ENCRYPTED_CALL", 6);
        READ = new MutexMarkType("READ", 7);
        VOICE_CALL = new MutexMarkType("VOICE_CALL", 8);
        VC_MEETING_STARTED = new MutexMarkType("VC_MEETING_STARTED", 9);
        VC_MEETING_ENDED_OVER_ONE_HOUR = new MutexMarkType("VC_MEETING_ENDED_OVER_ONE_HOUR", 10);
        VC_MEETING_ENDED_LESS_ONE_HOUR = new MutexMarkType("VC_MEETING_ENDED_LESS_ONE_HOUR", 11);
        VC_MEETING_ENDED_LESS_ONE_MINUTE = new MutexMarkType("VC_MEETING_ENDED_LESS_ONE_MINUTE", 12);
        VC_DEFAULT_MEETING_ENDED_OVER_ONE_HOUR = new MutexMarkType("VC_DEFAULT_MEETING_ENDED_OVER_ONE_HOUR", 13);
        VC_DEFAULT_MEETING_ENDED_LESS_ONE_HOUR = new MutexMarkType("VC_DEFAULT_MEETING_ENDED_LESS_ONE_HOUR", 14);
        VC_DEFAULT_MEETING_ENDED_LESS_ONE_MIN = new MutexMarkType("VC_DEFAULT_MEETING_ENDED_LESS_ONE_MIN", 15);
        CHAT_ROOM_CARD = new MutexMarkType("CHAT_ROOM_CARD", 16);
        CHAT_ROOM_START_MESSAGE = new MutexMarkType("CHAT_ROOM_START_MESSAGE", 17);
        MutexMarkType[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries(r0);
    }

    public static MutexMarkType[] values() {
        return (MutexMarkType[]) $VALUES.clone();
    }

    public static MutexMarkType valueOf(String r1) {
        return (MutexMarkType) a.a(MutexMarkType.class, r1);
    }

    private MutexMarkType(String r1, int r2) {
        super(r1, r2);
    }
}
