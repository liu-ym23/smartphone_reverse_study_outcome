package com.larus.bmhome.chat.setting.bean;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/bmhome/chat/setting/bean/UserConfigPullReason;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "STARTUP", "POLLING", "NOTIFIED", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final enum UserConfigPullReason extends Enum<UserConfigPullReason> {
    public static final UserConfigPullReason NOTIFIED = null;
    public static final UserConfigPullReason POLLING = null;
    public static final UserConfigPullReason STARTUP = null;
    public static final /* synthetic */ UserConfigPullReason[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static EnumEntries<UserConfigPullReason> getEntries() {
        return b;
    }

    static {
        UserConfigPullReason r0 = new UserConfigPullReason("STARTUP", 0, 1);
        STARTUP = r0;
        UserConfigPullReason r1 = new UserConfigPullReason("POLLING", 1, 2);
        POLLING = r1;
        UserConfigPullReason r4 = new UserConfigPullReason("NOTIFIED", 2, 3);
        NOTIFIED = r4;
        UserConfigPullReason[] r6 = {r0, r1, r4};
        a = r6;
        b = EnumEntriesKt.enumEntries(r6);
    }

    public static UserConfigPullReason[] values() {
        return (UserConfigPullReason[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static UserConfigPullReason valueOf(String r1) {
        return (UserConfigPullReason) a.a(UserConfigPullReason.class, r1);
    }

    public UserConfigPullReason(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
