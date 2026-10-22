package com.larus.avlink.plugins;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/larus/avlink/plugins/NotUploadReason;", "", "reason", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getReason", "()Ljava/lang/String;", "UNKNOWN", "NO_CALL_INSTANCE", "SESSION_NOT_STARTED", "SESSION_TYPE_NOT_SUPPORT", "BEFORE_ASR", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final enum NotUploadReason extends Enum<NotUploadReason> {
    public static final NotUploadReason BEFORE_ASR = null;
    public static final NotUploadReason NO_CALL_INSTANCE = null;
    public static final NotUploadReason SESSION_NOT_STARTED = null;
    public static final NotUploadReason SESSION_TYPE_NOT_SUPPORT = null;
    public static final NotUploadReason UNKNOWN = null;
    public static final /* synthetic */ NotUploadReason[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String reason;

    public static EnumEntries<NotUploadReason> getEntries() {
        return b;
    }

    static {
        NotUploadReason r0 = new NotUploadReason("UNKNOWN", 0, "unknown");
        UNKNOWN = r0;
        NotUploadReason r1 = new NotUploadReason("NO_CALL_INSTANCE", 1, "no call instance");
        NO_CALL_INSTANCE = r1;
        NotUploadReason r2 = new NotUploadReason("SESSION_NOT_STARTED", 2, " session not started");
        SESSION_NOT_STARTED = r2;
        NotUploadReason r4 = new NotUploadReason("SESSION_TYPE_NOT_SUPPORT", 3, "session type not support");
        SESSION_TYPE_NOT_SUPPORT = r4;
        NotUploadReason r6 = new NotUploadReason("BEFORE_ASR", 4, "before asr");
        BEFORE_ASR = r6;
        NotUploadReason[] r8 = {r0, r1, r2, r4, r6};
        a = r8;
        b = EnumEntriesKt.enumEntries(r8);
    }

    public static NotUploadReason[] values() {
        return (NotUploadReason[]) a.clone();
    }

    public final String getReason() {
        return this.reason;
    }

    public static NotUploadReason valueOf(String r1) {
        return (NotUploadReason) r27.a.a(NotUploadReason.class, r1);
    }

    public NotUploadReason(String r1, int r2, String r3) {
        super(r1, r2);
        this.reason = r3;
    }
}
