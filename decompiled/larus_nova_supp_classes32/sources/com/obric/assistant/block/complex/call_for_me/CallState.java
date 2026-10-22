package com.obric.assistant.block.complex.call_for_me;

import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\b\u0086\u0081\u0002\u0018\u0000 \u001a2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u001aB)\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019¨\u0006\u001b"}, d2 = {"Lcom/obric/assistant/block/complex/call_for_me/CallState;", NameKeys.UnloadStrategy_No_Strategy, "stateStr", NameKeys.UnloadStrategy_No_Strategy, "btnTextResId", NameKeys.UnloadStrategy_No_Strategy, "btnEnabled", NameKeys.UnloadStrategy_No_Strategy, "btnActivated", "<init>", "(Ljava/lang/String;ILjava/lang/String;IZZ)V", "getStateStr", "()Ljava/lang/String;", "getBtnTextResId", "()I", "getBtnEnabled", "()Z", "getBtnActivated", "UNKNOWN", "CALL_FOR_ME", "CALL_DIALING", "CALL_ONGOING", "CALL_ENDED", "CALL_SUMMARIZING", "CALL_CANCELLED", "CALL_EXPIRED", "Companion", "card_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CallState extends Enum<CallState> {
    public static final CallState CALL_CANCELLED = null;
    public static final CallState CALL_DIALING = null;
    public static final CallState CALL_ENDED = null;
    public static final CallState CALL_EXPIRED = null;
    public static final CallState CALL_FOR_ME = null;
    public static final CallState CALL_ONGOING = null;
    public static final CallState CALL_SUMMARIZING = null;
    public static final a Companion = null;
    public static final CallState UNKNOWN = null;
    public static final /* synthetic */ CallState[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final boolean btnActivated;
    private final boolean btnEnabled;
    private final int btnTextResId;
    private final String stateStr;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<CallState> getEntries() {
        return b;
    }

    static {
        CallState r7 = new CallState("UNKNOWN", 0, "unknown", 2131911982, false, false);
        UNKNOWN = r7;
        CallState r0 = new CallState("CALL_FOR_ME", 1, "call_for_me", 2131911982, true, false);
        CALL_FOR_ME = r0;
        CallState r1 = new CallState("CALL_DIALING", 2, "call_dialing", 2131911984, false, false);
        CALL_DIALING = r1;
        CallState r4 = new CallState("CALL_ONGOING", 3, "call_ongoing", 2131911987, true, true);
        CALL_ONGOING = r4;
        CallState r5 = new CallState("CALL_ENDED", 4, "call_ended", 2131911985, false, false);
        CALL_ENDED = r5;
        CallState r6 = new CallState("CALL_SUMMARIZING", 5, "call_summarizing", 2131911988, false, false);
        CALL_SUMMARIZING = r6;
        CallState r20 = new CallState("CALL_CANCELLED", 6, "call_cancelled", 2131911983, false, false);
        CALL_CANCELLED = r20;
        CallState r2 = new CallState("CALL_EXPIRED", 7, "call_expired", 2131911986, false, false);
        CALL_EXPIRED = r2;
        CallState[] r3 = {r7, r0, r1, r4, r5, r6, r20, r2};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
        Companion = new a();
    }

    public static CallState[] values() {
        return (CallState[]) a.clone();
    }

    public final boolean getBtnActivated() {
        return this.btnActivated;
    }

    public final boolean getBtnEnabled() {
        return this.btnEnabled;
    }

    public final int getBtnTextResId() {
        return this.btnTextResId;
    }

    public final String getStateStr() {
        return this.stateStr;
    }

    public static CallState valueOf(String r1) {
        return (CallState) r27.a.a(CallState.class, r1);
    }

    public CallState(String r1, int r2, String r3, int r4, boolean r5, boolean r6) {
        super(r1, r2);
        this.stateStr = r3;
        this.btnTextResId = r4;
        this.btnEnabled = r5;
        this.btnActivated = r6;
    }
}
