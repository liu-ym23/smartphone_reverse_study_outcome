package com.obric.assistant.state.api.multitask.state;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/obric/assistant/state/api/multitask/state/ModeRefreshSource;", "", "<init>", "(Ljava/lang/String;I)V", "BUSINESS", "MESSAGE", "STREAM", "DEEP_THINK", "COMPLEX_TASK", "TTS", "CLICK_TALK", "REALTIME_CALL", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ModeRefreshSource extends Enum<ModeRefreshSource> {
    public static final ModeRefreshSource BUSINESS = null;
    public static final ModeRefreshSource CLICK_TALK = null;
    public static final ModeRefreshSource COMPLEX_TASK = null;
    public static final ModeRefreshSource DEEP_THINK = null;
    public static final ModeRefreshSource MESSAGE = null;
    public static final ModeRefreshSource REALTIME_CALL = null;
    public static final ModeRefreshSource STREAM = null;
    public static final ModeRefreshSource TTS = null;
    public static final /* synthetic */ ModeRefreshSource[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ModeRefreshSource> getEntries() {
        return b;
    }

    static {
        ModeRefreshSource r0 = new ModeRefreshSource("BUSINESS", 0);
        BUSINESS = r0;
        ModeRefreshSource r1 = new ModeRefreshSource("MESSAGE", 1);
        MESSAGE = r1;
        ModeRefreshSource r3 = new ModeRefreshSource("STREAM", 2);
        STREAM = r3;
        ModeRefreshSource r5 = new ModeRefreshSource("DEEP_THINK", 3);
        DEEP_THINK = r5;
        ModeRefreshSource r7 = new ModeRefreshSource("COMPLEX_TASK", 4);
        COMPLEX_TASK = r7;
        ModeRefreshSource r9 = new ModeRefreshSource("TTS", 5);
        TTS = r9;
        ModeRefreshSource r11 = new ModeRefreshSource("CLICK_TALK", 6);
        CLICK_TALK = r11;
        ModeRefreshSource r13 = new ModeRefreshSource("REALTIME_CALL", 7);
        REALTIME_CALL = r13;
        ModeRefreshSource[] r15 = {r0, r1, r3, r5, r7, r9, r11, r13};
        a = r15;
        b = EnumEntriesKt.enumEntries(r15);
    }

    public static ModeRefreshSource[] values() {
        return (ModeRefreshSource[]) a.clone();
    }

    public static ModeRefreshSource valueOf(String r1) {
        return (ModeRefreshSource) a.a(ModeRefreshSource.class, r1);
    }

    public ModeRefreshSource(String r1, int r2) {
        super(r1, r2);
    }
}
