package com.obric.miniapp.intent;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u001c\b\u0086\u0081\u0002\u0018\u0000 \u001c2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u001cB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001b¨\u0006\u001d"}, d2 = {"Lcom/obric/miniapp/intent/IntentCardOpType;", "", "<init>", "(Ljava/lang/String;I)V", "QUERY_APP_ICON", "QUERY_PRIVILEGED_IMAGE", "OPEN_APP", "OPEN_APP_DETAIL", "SET_ALARM", "TURN_ON_OFF_ALARM", "DELETE_ALARM", "DELETE_CONTACTS", "DELETE_CALL_HISTORY", "DELETE_MESSAGES", "DELETE_MEMORIES", "OPEN_VIEW_ALL_SHEET", "SHOW_ENTITY", "CALL_PHONE", "SEND_SMS", "OPEN_SMS_COMPOSER", "CONFIRM_MESSAGE_SEND", "PLAY_MUSIC", "PAUSE_MUSIC", "QUERY_MUSIC_STATE", "OPEN_MUSIC_PAGE", "SHOW_PHOTO_GROUP", "DELETE_RECORDINGS", "SHOW_WEATHER", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum IntentCardOpType extends Enum<IntentCardOpType> {
    public static final IntentCardOpType CALL_PHONE = null;
    public static final IntentCardOpType CONFIRM_MESSAGE_SEND = null;
    public static final a Companion = null;
    public static final IntentCardOpType DELETE_ALARM = null;
    public static final IntentCardOpType DELETE_CALL_HISTORY = null;
    public static final IntentCardOpType DELETE_CONTACTS = null;
    public static final IntentCardOpType DELETE_MEMORIES = null;
    public static final IntentCardOpType DELETE_MESSAGES = null;
    public static final IntentCardOpType DELETE_RECORDINGS = null;
    public static final IntentCardOpType OPEN_APP = null;
    public static final IntentCardOpType OPEN_APP_DETAIL = null;
    public static final IntentCardOpType OPEN_MUSIC_PAGE = null;
    public static final IntentCardOpType OPEN_SMS_COMPOSER = null;
    public static final IntentCardOpType OPEN_VIEW_ALL_SHEET = null;
    public static final IntentCardOpType PAUSE_MUSIC = null;
    public static final IntentCardOpType PLAY_MUSIC = null;
    public static final IntentCardOpType QUERY_APP_ICON = null;
    public static final IntentCardOpType QUERY_MUSIC_STATE = null;
    public static final IntentCardOpType QUERY_PRIVILEGED_IMAGE = null;
    public static final IntentCardOpType SEND_SMS = null;
    public static final IntentCardOpType SET_ALARM = null;
    public static final IntentCardOpType SHOW_ENTITY = null;
    public static final IntentCardOpType SHOW_PHOTO_GROUP = null;
    public static final IntentCardOpType SHOW_WEATHER = null;
    public static final IntentCardOpType TURN_ON_OFF_ALARM = null;
    public static final /* synthetic */ IntentCardOpType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<IntentCardOpType> getEntries() {
        return b;
    }

    static {
        IntentCardOpType r0 = new IntentCardOpType("QUERY_APP_ICON", 0);
        QUERY_APP_ICON = r0;
        IntentCardOpType r1 = new IntentCardOpType("QUERY_PRIVILEGED_IMAGE", 1);
        QUERY_PRIVILEGED_IMAGE = r1;
        IntentCardOpType r3 = new IntentCardOpType("OPEN_APP", 2);
        OPEN_APP = r3;
        IntentCardOpType r5 = new IntentCardOpType("OPEN_APP_DETAIL", 3);
        OPEN_APP_DETAIL = r5;
        IntentCardOpType r7 = new IntentCardOpType("SET_ALARM", 4);
        SET_ALARM = r7;
        IntentCardOpType r9 = new IntentCardOpType("TURN_ON_OFF_ALARM", 5);
        TURN_ON_OFF_ALARM = r9;
        IntentCardOpType r11 = new IntentCardOpType("DELETE_ALARM", 6);
        DELETE_ALARM = r11;
        IntentCardOpType r13 = new IntentCardOpType("DELETE_CONTACTS", 7);
        DELETE_CONTACTS = r13;
        IntentCardOpType r15 = new IntentCardOpType("DELETE_CALL_HISTORY", 8);
        DELETE_CALL_HISTORY = r15;
        IntentCardOpType r14 = new IntentCardOpType("DELETE_MESSAGES", 9);
        DELETE_MESSAGES = r14;
        IntentCardOpType r12 = new IntentCardOpType("DELETE_MEMORIES", 10);
        DELETE_MEMORIES = r12;
        IntentCardOpType r10 = new IntentCardOpType("OPEN_VIEW_ALL_SHEET", 11);
        OPEN_VIEW_ALL_SHEET = r10;
        IntentCardOpType r8 = new IntentCardOpType("SHOW_ENTITY", 12);
        SHOW_ENTITY = r8;
        IntentCardOpType r6 = new IntentCardOpType("CALL_PHONE", 13);
        CALL_PHONE = r6;
        IntentCardOpType r4 = new IntentCardOpType("SEND_SMS", 14);
        SEND_SMS = r4;
        IntentCardOpType r2 = new IntentCardOpType("OPEN_SMS_COMPOSER", 15);
        OPEN_SMS_COMPOSER = r2;
        IntentCardOpType r16 = new IntentCardOpType("CONFIRM_MESSAGE_SEND", 16);
        CONFIRM_MESSAGE_SEND = r16;
        IntentCardOpType r17 = new IntentCardOpType("PLAY_MUSIC", 17);
        PLAY_MUSIC = r17;
        IntentCardOpType r18 = new IntentCardOpType("PAUSE_MUSIC", 18);
        PAUSE_MUSIC = r18;
        IntentCardOpType r19 = new IntentCardOpType("QUERY_MUSIC_STATE", 19);
        QUERY_MUSIC_STATE = r19;
        IntentCardOpType r20 = new IntentCardOpType("OPEN_MUSIC_PAGE", 20);
        OPEN_MUSIC_PAGE = r20;
        IntentCardOpType r21 = new IntentCardOpType("SHOW_PHOTO_GROUP", 21);
        SHOW_PHOTO_GROUP = r21;
        IntentCardOpType r22 = new IntentCardOpType("DELETE_RECORDINGS", 22);
        DELETE_RECORDINGS = r22;
        IntentCardOpType r23 = new IntentCardOpType("SHOW_WEATHER", 23);
        SHOW_WEATHER = r23;
        IntentCardOpType[] r24 = {r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6, r4, r2, r16, r17, r18, r19, r20, r21, r22, r23};
        a = r24;
        b = EnumEntriesKt.enumEntries(r24);
        Companion = new a();
    }

    public static IntentCardOpType[] values() {
        return (IntentCardOpType[]) a.clone();
    }

    public static IntentCardOpType valueOf(String r1) {
        return (IntentCardOpType) r27.a.a(IntentCardOpType.class, r1);
    }

    public IntentCardOpType(String r1, int r2) {
        super(r1, r2);
    }
}
