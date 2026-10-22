package com.larus.bmhome.upload.sdk.api.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/larus/bmhome/upload/sdk/api/model/CancelReason;", "", "reason", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getReason", "()Ljava/lang/String;", "User", "LeaveChat", "Replaced", "Shutdown", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CancelReason extends Enum<CancelReason> {
    public static final CancelReason LeaveChat = null;
    public static final CancelReason Replaced = null;
    public static final CancelReason Shutdown = null;
    public static final CancelReason User = null;
    public static final /* synthetic */ CancelReason[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String reason;

    public static EnumEntries<CancelReason> getEntries() {
        return b;
    }

    static {
        CancelReason r0 = new CancelReason("User", 0, "user_cancel");
        User = r0;
        CancelReason r1 = new CancelReason("LeaveChat", 1, "leave_chat");
        LeaveChat = r1;
        CancelReason r2 = new CancelReason("Replaced", 2, "replaced");
        Replaced = r2;
        CancelReason r4 = new CancelReason("Shutdown", 3, "shutdown");
        Shutdown = r4;
        CancelReason[] r6 = {r0, r1, r2, r4};
        a = r6;
        b = EnumEntriesKt.enumEntries(r6);
    }

    public static CancelReason[] values() {
        return (CancelReason[]) a.clone();
    }

    public final String getReason() {
        return this.reason;
    }

    public static CancelReason valueOf(String r1) {
        return (CancelReason) a.a(CancelReason.class, r1);
    }

    public CancelReason(String r1, int r2, String r3) {
        super(r1, r2);
        this.reason = r3;
    }
}
