package com.ss.android.lark.intent.export.entity.input;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0001(By\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u001a\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\n\u0012\u001a\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\n\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\u0006\u0010!\u001a\u00020\"J\u0006\u0010#\u001a\u00020\"J\b\u0010$\u001a\u00020\"H\u0002J\u0006\u0010%\u001a\u00020\"J\u0006\u0010&\u001a\u00020\"J\b\u0010'\u001a\u00020\u0007H\u0016R\u0015\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0016\u0010\u0014R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R%\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\n¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR%\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\n¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0013\u0010\f\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 ¨\u0006)"}, d2 = {"Lcom/ss/android/lark/intent/export/entity/input/SearchCalendarIntentInput;", "Lcom/ss/android/lark/intent/export/entity/input/IntentInput;", "Ljava/io/Serializable;", "startTime", "", "endTime", "roomDesc", "", "participants", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "participantIds", "agenda", "timeType", "Lcom/ss/android/lark/intent/export/entity/input/SearchCalendarIntentInput$TimeType;", "version", "Lcom/ss/android/lark/intent/export/entity/input/IntentInputVersion;", "<init>", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/lang/String;Lcom/ss/android/lark/intent/export/entity/input/SearchCalendarIntentInput$TimeType;Lcom/ss/android/lark/intent/export/entity/input/IntentInputVersion;)V", "getStartTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getEndTime", "getRoomDesc", "()Ljava/lang/String;", "getParticipants", "()Ljava/util/ArrayList;", "getParticipantIds", "getAgenda", "getTimeType", "()Lcom/ss/android/lark/intent/export/entity/input/SearchCalendarIntentInput$TimeType;", "getVersion", "()Lcom/ss/android/lark/intent/export/entity/input/IntentInputVersion;", "isAllDataInvalid", "", "onlyHaveTime", "isParticipantsValid", "isTimePoint", "isTimeRange", "toString", "TimeType", "intent-export_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class SearchCalendarIntentInput extends IntentInput implements Serializable {
    private final String agenda;
    private final Long endTime;
    private final ArrayList<String> participantIds;
    private final ArrayList<String> participants;
    private final String roomDesc;
    private final Long startTime;
    private final TimeType timeType;
    private final IntentInputVersion version;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\n\u001a\u00020\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/intent/export/entity/input/SearchCalendarIntentInput$TimeType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "SEARCH_TIME_START", "SEARCH_TIME_RANGE", "toDescString", "", "Companion", "intent-export_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final enum TimeType extends Enum<TimeType> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ TimeType[] $VALUES = null;
        public static final Companion Companion = null;
        public static final TimeType SEARCH_TIME_RANGE = null;
        public static final TimeType SEARCH_TIME_START = null;
        private final int value;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/intent/export/entity/input/SearchCalendarIntentInput$TimeType$Companion;", "", "<init>", "()V", "valueOf", "Lcom/ss/android/lark/intent/export/entity/input/SearchCalendarIntentInput$TimeType;", "value", "", "intent-export_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r1) {
                this();
            }

            @JvmStatic
            public final TimeType valueOf(int r4) {
                TimeType r0 = TimeType.SEARCH_TIME_START;
                if (r4 == r0.getValue()) goto L10;
                TimeType r1 = TimeType.SEARCH_TIME_RANGE;
                if (r4 == r1.getValue()) goto L8;
                return r0;
            L8:
                return r1;
            L10:
                return r0;
            }
        }

        @Metadata(k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

            static {
                int[] r0 = new int[TimeType.values().length];
                r0[TimeType.SEARCH_TIME_START.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
            L9:
                r0[TimeType.SEARCH_TIME_RANGE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
            L5:
                $EnumSwitchMapping$0 = r0;
            }
        }

        private static final /* synthetic */ TimeType[] $values() {
            return new TimeType[]{SEARCH_TIME_START, SEARCH_TIME_RANGE};
        }

        public static EnumEntries<TimeType> getEntries() {
            return $ENTRIES;
        }

        @JvmStatic
        public static final TimeType valueOf(int r1) {
            return Companion.valueOf(r1);
        }

        static {
            SEARCH_TIME_START = new TimeType("SEARCH_TIME_START", 0, 0);
            SEARCH_TIME_RANGE = new TimeType("SEARCH_TIME_RANGE", 1, 1);
            TimeType[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = EnumEntriesKt.enumEntries(r0);
            Companion = new Companion(null);
        }

        public static TimeType[] values() {
            return (TimeType[]) $VALUES.clone();
        }

        public final String toDescString() {
            int r0 = WhenMappings.$EnumSwitchMapping$0[ordinal()];
            if (r0 != 1) goto L5;
            return "time_start_point";
        L5:
            if (r0 != 2) goto L8;
            return "time_range";
        L8:
            throw new NoWhenBranchMatchedException();
        }

        public final int getValue() {
            return this.value;
        }

        public static TimeType valueOf(String r1) {
            return (TimeType) a.a(TimeType.class, r1);
        }

        private TimeType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    private final boolean isParticipantsValid() {
        ArrayList<String> r0 = this.participantIds;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L20;
        ArrayList<String> r2 = this.participants;
        if (r2 != null) goto L13;
    L16:
        boolean r3 = true;
    L17:
        if (r3 == false) goto L21;
        return true;
    L21:
        return false;
    L13:
        if (r2.isEmpty() == true) goto L16;
        r3 = false;
        goto L17
    L20:
        return false;
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }

    public final boolean isTimePoint() {
        if (this.startTime != null) goto L5;
    L7:
        return false;
    L5:
        if (this.endTime != null) goto L7;
        return true;
    }

    public final boolean isTimeRange() {
        if (this.startTime != null) goto L7;
        if (this.endTime != null) goto L7;
    L9:
        return false;
    L7:
        if (isTimePoint() == true) goto L9;
        return true;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("SearchCalendarIntentInput(startTime=");
        Object r1 = this.startTime;
        String r2 = "null";
        if (r1 != null) goto L5;
        r1 = "null";
    L5:
        r0.append(r1);
        r0.append(", endTime=");
        Object r3 = this.endTime;
        if (r3 != null) goto L8;
        r3 = "null";
    L8:
        r0.append(r3);
        r0.append(", roomDesc=");
        String r4 = this.roomDesc;
        if (r4 == null) goto L12;
        String r5 = knb.a.a(r4);
        if (r5 == null) goto L12;
    L13:
        r0.append(r5);
        r0.append(", participants=");
        Object r6 = this.participants;
        if (r6 != null) goto L17;
        r6 = "null";
    L17:
        r0.append(r6);
        r0.append(", participantIds = ");
        Object r7 = this.participantIds;
        if (r7 != null) goto L21;
        r7 = "null";
    L21:
        r0.append(r7);
        r0.append(", agenda=");
        String r8 = this.agenda;
        if (r8 == null) goto L25;
        String r9 = knb.a.a(r8);
        if (r9 == null) goto L25;
    L26:
        r0.append(r9);
        r0.append(", timeType=");
        TimeType r10 = this.timeType;
        if (r10 == null) goto L32;
        String r11 = r10.toDescString();
        if (r11 == null) goto L32;
        r2 = r11;
    L32:
        r0.append(r2);
        r0.append(", version=");
        r0.append(this.version);
        r0.append(')');
        return r0.toString();
    L25:
        r9 = "null";
    L12:
        r5 = "null";
        goto L13
    }

    public final boolean isAllDataInvalid() {
        if (isParticipantsValid() == true) goto L5;
    L13:
        return false;
    L5:
        if (this.roomDesc != null) goto L13;
        if (this.startTime != null) goto L13;
        if (this.endTime != null) goto L13;
        if (this.agenda != null) goto L13;
        return true;
    }

    public final boolean onlyHaveTime() {
        if (isParticipantsValid() == true) goto L5;
    L13:
        return false;
    L5:
        if (this.roomDesc != null) goto L13;
        if (this.agenda != null) goto L13;
        if (this.startTime == null) goto L11;
    L12:
        return true;
    L11:
        if (this.endTime == null) goto L13;
        goto L12
    }

    public final String getAgenda() {
        return this.agenda;
    }

    public final Long getEndTime() {
        return this.endTime;
    }

    public final ArrayList<String> getParticipantIds() {
        return this.participantIds;
    }

    public final ArrayList<String> getParticipants() {
        return this.participants;
    }

    public final String getRoomDesc() {
        return this.roomDesc;
    }

    public final Long getStartTime() {
        return this.startTime;
    }

    public final TimeType getTimeType() {
        return this.timeType;
    }

    public final IntentInputVersion getVersion() {
        return this.version;
    }

    public SearchCalendarIntentInput(Long r2, Long r3, String r4, ArrayList<String> r5, ArrayList<String> r6, String r7, TimeType r8, IntentInputVersion r9) {
        Intrinsics.checkNotNullParameter(r9, "version");
        super(IntentInput.IntentType.SEARCH_CALENDAR);
        this.startTime = r2;
        this.endTime = r3;
        this.roomDesc = r4;
        this.participants = r5;
        this.participantIds = r6;
        this.agenda = r7;
        this.timeType = r8;
        this.version = r9;
    }
}
