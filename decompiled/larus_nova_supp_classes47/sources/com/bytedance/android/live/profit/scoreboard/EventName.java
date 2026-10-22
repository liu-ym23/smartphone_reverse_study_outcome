package com.bytedance.android.live.profit.scoreboard;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/profit/scoreboard/EventName;", "", "ON_ROUND_MESSAGE_START", "ON_ROUND_MESSAGE_FINISH", "ON_ROUND_MESSAGE_SCORE_CHANGE", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum EventName extends Enum<EventName> {
    public static final EventName ON_ROUND_MESSAGE_FINISH = null;
    public static final EventName ON_ROUND_MESSAGE_SCORE_CHANGE = null;
    public static final EventName ON_ROUND_MESSAGE_START = null;
    public static final /* synthetic */ EventName[] a = null;

    static {
        EventName r1 = new EventName("ON_ROUND_MESSAGE_START", 0);
        ON_ROUND_MESSAGE_START = r1;
        EventName r2 = new EventName("ON_ROUND_MESSAGE_FINISH", 1);
        ON_ROUND_MESSAGE_FINISH = r2;
        EventName r3 = new EventName("ON_ROUND_MESSAGE_SCORE_CHANGE", 2);
        ON_ROUND_MESSAGE_SCORE_CHANGE = r3;
        a = new EventName[]{r1, r2, r3};
    }

    public static EventName valueOf(String r1) {
        return (EventName) r27.a.a(EventName.class, r1);
    }

    public static EventName[] values() {
        return (EventName[]) a.clone();
    }

    public EventName(String r1, int r2) {
        super(r1, r2);
    }
}
