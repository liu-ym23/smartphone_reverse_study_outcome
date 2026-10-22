package com.bytedance.android.live.room.api.messagewindow.trigger;

import com.bytedance.android.live.schema.api.WebcastRedirectException;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/live/room/api/messagewindow/trigger/TriggerId;", "", "", "value", "I", "getValue", "()I", "", "desc", "Ljava/lang/String;", "getDesc", "()Ljava/lang/String;", "NO_LIMIT_TRIGGER", "ENTER_ROOM_TIME_LIMIT", "CYCLE_DISPLAY_WITH_LIMITED_TIMES_TRIGGER", "EXIT_MIC_TIME_LIMIT", "experience-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum TriggerId extends Enum<TriggerId> {
    public static final TriggerId CYCLE_DISPLAY_WITH_LIMITED_TIMES_TRIGGER = null;
    public static final TriggerId ENTER_ROOM_TIME_LIMIT = null;
    public static final TriggerId EXIT_MIC_TIME_LIMIT = null;
    public static final TriggerId NO_LIMIT_TRIGGER = null;
    public static final /* synthetic */ TriggerId[] a = null;
    private final String desc;
    private final int value;

    static {
        TriggerId r1 = new TriggerId("NO_LIMIT_TRIGGER", 0, -1, "无需被动触发");
        NO_LIMIT_TRIGGER = r1;
        TriggerId r2 = new TriggerId("ENTER_ROOM_TIME_LIMIT", 1, 1, "进房Ns后触发");
        ENTER_ROOM_TIME_LIMIT = r2;
        TriggerId r3 = new TriggerId("CYCLE_DISPLAY_WITH_LIMITED_TIMES_TRIGGER", 2, 2, "循环展示");
        CYCLE_DISPLAY_WITH_LIMITED_TIMES_TRIGGER = r3;
        TriggerId r4 = new TriggerId("EXIT_MIC_TIME_LIMIT", 3, WebcastRedirectException.MISS_REDIRECT_RULE, "上麦主播下麦前Ns");
        EXIT_MIC_TIME_LIMIT = r4;
        a = new TriggerId[]{r1, r2, r3, r4};
    }

    public static TriggerId valueOf(String r1) {
        return (TriggerId) a.a(TriggerId.class, r1);
    }

    public static TriggerId[] values() {
        return (TriggerId[]) a.clone();
    }

    public final String getDesc() {
        return this.desc;
    }

    public final int getValue() {
        return this.value;
    }

    public TriggerId(String r1, int r2, int r3, String r4) {
        super(r1, r2);
        this.value = r3;
        this.desc = r4;
    }
}
