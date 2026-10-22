package com.larus.bmhome.chat.layout.item;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\b\u0086\u0081\u0002\u0018\u0000 \u00162\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0016B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015¨\u0006\u0017"}, d2 = {"Lcom/larus/bmhome/chat/layout/item/RecordStatus;", "", "type", "", "<init>", "(Ljava/lang/String;II)V", "getType", "()I", "AVAILABLE", "RECORDING", "RECORD_FINISHED", "RecordInterruptedFinish", "OFFLINE_ASR_ING", "SUMMARY_READY", "RECORD_ERROR", "SUMMARY_GENERATE_ERROR", "UNAUTHORIZED_ERROR", "SecurityRiskControlError", "EarlyEndError", "OfflineASRError", "Connecting", "SUMMARY_GENERATING", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final enum RecordStatus extends Enum<RecordStatus> {

    @Deprecated(message = "available 已废弃，默认的初始状态为 connecting")
    public static final RecordStatus AVAILABLE = null;
    public static final a Companion = null;
    public static final RecordStatus Connecting = null;
    public static final RecordStatus EarlyEndError = null;
    public static final RecordStatus OFFLINE_ASR_ING = null;
    public static final RecordStatus OfflineASRError = null;
    public static final RecordStatus RECORDING = null;
    public static final RecordStatus RECORD_ERROR = null;
    public static final RecordStatus RECORD_FINISHED = null;
    public static final RecordStatus RecordInterruptedFinish = null;
    public static final RecordStatus SUMMARY_GENERATE_ERROR = null;
    public static final RecordStatus SUMMARY_GENERATING = null;
    public static final RecordStatus SUMMARY_READY = null;
    public static final RecordStatus SecurityRiskControlError = null;
    public static final RecordStatus UNAUTHORIZED_ERROR = null;
    public static final /* synthetic */ RecordStatus[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int type;

    public static final class a {
        public a() {
        }

        public static RecordStatus a(Integer r7) {
            RecordStatus[] r0 = RecordStatus.values();
            int r1 = r0.length;
            int r3 = 0;
        L3:
            if (r3 >= r1) goto L14;
            RecordStatus r4 = r0[r3];
            int r5 = r4.getType();
            if (r7 != null) goto L8;
        L10:
            boolean r6 = false;
        L11:
            if (r6 == true) goto L18;
            r3 = r3 + 1;
            goto L3
        L18:
            return r4;
        L8:
            if (r5 != r7.intValue()) goto L10;
            r6 = true;
            goto L11
        L14:
            return null;
        }
    }

    public static EnumEntries<RecordStatus> getEntries() {
        return b;
    }

    static {
        RecordStatus r0 = new RecordStatus("AVAILABLE", 0, 1);
        AVAILABLE = r0;
        RecordStatus r1 = new RecordStatus("RECORDING", 1, 2);
        RECORDING = r1;
        RecordStatus r4 = new RecordStatus("RECORD_FINISHED", 2, 3);
        RECORD_FINISHED = r4;
        RecordStatus r6 = new RecordStatus("RecordInterruptedFinish", 3, 31);
        RecordInterruptedFinish = r6;
        RecordStatus r8 = new RecordStatus("OFFLINE_ASR_ING", 4, 4);
        OFFLINE_ASR_ING = r8;
        RecordStatus r9 = new RecordStatus("SUMMARY_READY", 5, 5);
        SUMMARY_READY = r9;
        RecordStatus r11 = new RecordStatus("RECORD_ERROR", 6, 100);
        RECORD_ERROR = r11;
        RecordStatus r13 = new RecordStatus("SUMMARY_GENERATE_ERROR", 7, 101);
        SUMMARY_GENERATE_ERROR = r13;
        RecordStatus r12 = new RecordStatus("UNAUTHORIZED_ERROR", 8, 102);
        UNAUTHORIZED_ERROR = r12;
        RecordStatus r10 = new RecordStatus("SecurityRiskControlError", 9, 103);
        SecurityRiskControlError = r10;
        RecordStatus r7 = new RecordStatus("EarlyEndError", 10, MessageCellStateTransformerType.DOWNLOAD_APP_ENTITY);
        EarlyEndError = r7;
        RecordStatus r5 = new RecordStatus("OfflineASRError", 11, MessageCellStateTransformerType.MSG_SEND_ENTITY);
        OfflineASRError = r5;
        RecordStatus r3 = new RecordStatus("Connecting", 12, 11);
        Connecting = r3;
        RecordStatus r15 = new RecordStatus("SUMMARY_GENERATING", 13, 41);
        SUMMARY_GENERATING = r15;
        RecordStatus[] r2 = {r0, r1, r4, r6, r8, r9, r11, r13, r12, r10, r7, r5, r3, r15};
        a = r2;
        b = EnumEntriesKt.enumEntries(r2);
        Companion = new a();
    }

    public static RecordStatus[] values() {
        return (RecordStatus[]) a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public static RecordStatus valueOf(String r1) {
        return (RecordStatus) r27.a.a(RecordStatus.class, r1);
    }

    public RecordStatus(String r1, int r2, int r3) {
        super(r1, r2);
        this.type = r3;
    }
}
