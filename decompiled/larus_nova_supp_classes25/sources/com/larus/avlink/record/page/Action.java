package com.larus.avlink.record.page;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/larus/avlink/record/page/Action;", "", "<init>", "(Ljava/lang/String;I)V", "INITIAL_PULL", "RETRY_PULL", "REFRESH_PULL", "START_PULL", "END_PULL", "DELETE", "UPLOAD_PROGRESS", "SYNC_COMPLETED", "ERROR", "UNKNOWN", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final enum Action extends Enum<Action> {
    public static final Action DELETE = null;
    public static final Action END_PULL = null;
    public static final Action ERROR = null;
    public static final Action INITIAL_PULL = null;
    public static final Action REFRESH_PULL = null;
    public static final Action RETRY_PULL = null;
    public static final Action START_PULL = null;
    public static final Action SYNC_COMPLETED = null;
    public static final Action UNKNOWN = null;
    public static final Action UPLOAD_PROGRESS = null;
    public static final /* synthetic */ Action[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<Action> getEntries() {
        return b;
    }

    static {
        Action r0 = new Action("INITIAL_PULL", 0);
        INITIAL_PULL = r0;
        Action r1 = new Action("RETRY_PULL", 1);
        RETRY_PULL = r1;
        Action r3 = new Action("REFRESH_PULL", 2);
        REFRESH_PULL = r3;
        Action r5 = new Action("START_PULL", 3);
        START_PULL = r5;
        Action r7 = new Action("END_PULL", 4);
        END_PULL = r7;
        Action r9 = new Action("DELETE", 5);
        DELETE = r9;
        Action r11 = new Action("UPLOAD_PROGRESS", 6);
        UPLOAD_PROGRESS = r11;
        Action r13 = new Action("SYNC_COMPLETED", 7);
        SYNC_COMPLETED = r13;
        Action r15 = new Action("ERROR", 8);
        ERROR = r15;
        Action r14 = new Action("UNKNOWN", 9);
        UNKNOWN = r14;
        Action[] r12 = {r0, r1, r3, r5, r7, r9, r11, r13, r15, r14};
        a = r12;
        b = EnumEntriesKt.enumEntries(r12);
    }

    public static Action[] values() {
        return (Action[]) a.clone();
    }

    public static Action valueOf(String r1) {
        return (Action) r27.a.a(Action.class, r1);
    }

    public Action(String r1, int r2) {
        super(r1, r2);
    }
}
