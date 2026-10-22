package com.larus.platform.api;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/platform/api/AccountState;", "", "<init>", "(Ljava/lang/String;I)V", "ONLINE", "OFFLINE", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final enum AccountState extends Enum<AccountState> {
    public static final AccountState OFFLINE = null;
    public static final AccountState ONLINE = null;
    public static final /* synthetic */ AccountState[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<AccountState> getEntries() {
        return b;
    }

    static {
        AccountState r0 = new AccountState("ONLINE", 0);
        ONLINE = r0;
        AccountState r1 = new AccountState("OFFLINE", 1);
        OFFLINE = r1;
        AccountState[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static AccountState[] values() {
        return (AccountState[]) a.clone();
    }

    public static AccountState valueOf(String r1) {
        return (AccountState) r27.a.a(AccountState.class, r1);
    }

    public AccountState(String r1, int r2) {
        super(r1, r2);
    }
}
