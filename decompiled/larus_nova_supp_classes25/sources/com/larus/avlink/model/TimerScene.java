package com.larus.avlink.model;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/larus/avlink/model/TimerScene;", "", "<init>", "(Ljava/lang/String;I)V", "OnStart", "QueryEnd", "OnTtsPlayFinished", "OnReplyNoContent", "AuthDialog", "LocationAuthDialog", "StartConversationInEnvObserve", "NaturalWakeupConfirmed", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final enum TimerScene extends Enum<TimerScene> {
    public static final TimerScene AuthDialog = null;
    public static final TimerScene LocationAuthDialog = null;
    public static final TimerScene NaturalWakeupConfirmed = null;
    public static final TimerScene OnReplyNoContent = null;
    public static final TimerScene OnStart = null;
    public static final TimerScene OnTtsPlayFinished = null;
    public static final TimerScene QueryEnd = null;
    public static final TimerScene StartConversationInEnvObserve = null;
    public static final /* synthetic */ TimerScene[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<TimerScene> getEntries() {
        return b;
    }

    static {
        TimerScene r0 = new TimerScene("OnStart", 0);
        OnStart = r0;
        TimerScene r1 = new TimerScene("QueryEnd", 1);
        QueryEnd = r1;
        TimerScene r3 = new TimerScene("OnTtsPlayFinished", 2);
        OnTtsPlayFinished = r3;
        TimerScene r5 = new TimerScene("OnReplyNoContent", 3);
        OnReplyNoContent = r5;
        TimerScene r7 = new TimerScene("AuthDialog", 4);
        AuthDialog = r7;
        TimerScene r9 = new TimerScene("LocationAuthDialog", 5);
        LocationAuthDialog = r9;
        TimerScene r11 = new TimerScene("StartConversationInEnvObserve", 6);
        StartConversationInEnvObserve = r11;
        TimerScene r13 = new TimerScene("NaturalWakeupConfirmed", 7);
        NaturalWakeupConfirmed = r13;
        TimerScene[] r15 = {r0, r1, r3, r5, r7, r9, r11, r13};
        a = r15;
        b = EnumEntriesKt.enumEntries(r15);
    }

    public static TimerScene[] values() {
        return (TimerScene[]) a.clone();
    }

    public static TimerScene valueOf(String r1) {
        return (TimerScene) r27.a.a(TimerScene.class, r1);
    }

    public TimerScene(String r1, int r2) {
        super(r1, r2);
    }
}
