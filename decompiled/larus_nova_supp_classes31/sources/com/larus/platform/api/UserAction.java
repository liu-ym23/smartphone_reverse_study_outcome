package com.larus.platform.api;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/platform/api/UserAction;", "", "<init>", "(Ljava/lang/String;I)V", "USER_LOGIN", "USER_LOGOUT", "ACCOUNT_SWITCH", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final enum UserAction extends Enum<UserAction> {
    public static final UserAction ACCOUNT_SWITCH = null;
    public static final UserAction USER_LOGIN = null;
    public static final UserAction USER_LOGOUT = null;
    public static final /* synthetic */ UserAction[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<UserAction> getEntries() {
        return b;
    }

    static {
        UserAction r0 = new UserAction("USER_LOGIN", 0);
        USER_LOGIN = r0;
        UserAction r1 = new UserAction("USER_LOGOUT", 1);
        USER_LOGOUT = r1;
        UserAction r3 = new UserAction("ACCOUNT_SWITCH", 2);
        ACCOUNT_SWITCH = r3;
        UserAction[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static UserAction[] values() {
        return (UserAction[]) a.clone();
    }

    public static UserAction valueOf(String r1) {
        return (UserAction) r27.a.a(UserAction.class, r1);
    }

    public UserAction(String r1, int r2) {
        super(r1, r2);
    }
}
