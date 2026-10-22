package com.obric.assistant.live.gr.island.island;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0015\b\u0086\u0081\u0002\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0015B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0016"}, d2 = {"Lcom/obric/assistant/live/gr/island/island/GRLiveCardType;", "", "<init>", "(Ljava/lang/String;I)V", "CALL", "ASSISTANT", "OAUTO", "MEMORY_DATA", "SCREEN_CAP", "BATTERY", "VIBRATE", "RING_DOWN", "MUTE", "AUTO_DISMISS", "SOUND_RECORD", "TRANSFER_DATA", "ALARM", "COUNT_DOWN", "STOP_WATCH", "MUSIC", "LOCK", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum GRLiveCardType extends Enum<GRLiveCardType> {
    public static final GRLiveCardType ALARM = null;
    public static final GRLiveCardType ASSISTANT = null;
    public static final GRLiveCardType AUTO_DISMISS = null;
    public static final GRLiveCardType BATTERY = null;
    public static final GRLiveCardType CALL = null;
    public static final GRLiveCardType COUNT_DOWN = null;
    public static final a Companion = null;
    public static final GRLiveCardType LOCK = null;
    public static final GRLiveCardType MEMORY_DATA = null;
    public static final GRLiveCardType MUSIC = null;
    public static final GRLiveCardType MUTE = null;
    public static final GRLiveCardType OAUTO = null;
    public static final GRLiveCardType RING_DOWN = null;
    public static final GRLiveCardType SCREEN_CAP = null;
    public static final GRLiveCardType SOUND_RECORD = null;
    public static final GRLiveCardType STOP_WATCH = null;
    public static final GRLiveCardType TRANSFER_DATA = null;
    public static final GRLiveCardType VIBRATE = null;
    public static final /* synthetic */ GRLiveCardType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<GRLiveCardType> getEntries() {
        return b;
    }

    /* JADX WARN: Type inference failed for: r0v17, types: [com.obric.assistant.live.gr.island.island.GRLiveCardType$a] */
    static {
        GRLiveCardType r0 = new GRLiveCardType("CALL", 0);
        CALL = r0;
        GRLiveCardType r1 = new GRLiveCardType("ASSISTANT", 1);
        ASSISTANT = r1;
        GRLiveCardType r3 = new GRLiveCardType("OAUTO", 2);
        OAUTO = r3;
        GRLiveCardType r5 = new GRLiveCardType("MEMORY_DATA", 3);
        MEMORY_DATA = r5;
        GRLiveCardType r7 = new GRLiveCardType("SCREEN_CAP", 4);
        SCREEN_CAP = r7;
        GRLiveCardType r9 = new GRLiveCardType("BATTERY", 5);
        BATTERY = r9;
        GRLiveCardType r11 = new GRLiveCardType("VIBRATE", 6);
        VIBRATE = r11;
        GRLiveCardType r13 = new GRLiveCardType("RING_DOWN", 7);
        RING_DOWN = r13;
        GRLiveCardType r15 = new GRLiveCardType("MUTE", 8);
        MUTE = r15;
        GRLiveCardType r14 = new GRLiveCardType("AUTO_DISMISS", 9);
        AUTO_DISMISS = r14;
        GRLiveCardType r12 = new GRLiveCardType("SOUND_RECORD", 10);
        SOUND_RECORD = r12;
        GRLiveCardType r10 = new GRLiveCardType("TRANSFER_DATA", 11);
        TRANSFER_DATA = r10;
        GRLiveCardType r8 = new GRLiveCardType("ALARM", 12);
        ALARM = r8;
        GRLiveCardType r6 = new GRLiveCardType("COUNT_DOWN", 13);
        COUNT_DOWN = r6;
        GRLiveCardType r4 = new GRLiveCardType("STOP_WATCH", 14);
        STOP_WATCH = r4;
        GRLiveCardType r2 = new GRLiveCardType("MUSIC", 15);
        MUSIC = r2;
        GRLiveCardType r16 = new GRLiveCardType("LOCK", 16);
        LOCK = r16;
        GRLiveCardType[] r17 = {r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6, r4, r2, r16};
        a = r17;
        b = EnumEntriesKt.enumEntries(r17);
        Companion = new a();
    }

    public static GRLiveCardType[] values() {
        return (GRLiveCardType[]) a.clone();
    }

    public static GRLiveCardType valueOf(String r1) {
        return (GRLiveCardType) r27.a.a(GRLiveCardType.class, r1);
    }

    public GRLiveCardType(String r1, int r2) {
        super(r1, r2);
    }
}
