package com.lark.kmp.basic;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/lark/kmp/basic/UserState;", "", "<init>", "(Ljava/lang/String;I)V", "OFFLINE", "ONLINE", "ABSENT", "PRE_ONLINE", "user-state-manager_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum UserState extends Enum<UserState> {
    public static final UserState ABSENT = null;
    public static final UserState OFFLINE = null;
    public static final UserState ONLINE = null;
    public static final UserState PRE_ONLINE = null;
    public static final /* synthetic */ UserState[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<UserState> getEntries() {
        return b;
    }

    static {
        UserState r0 = new UserState("OFFLINE", 0);
        OFFLINE = r0;
        UserState r1 = new UserState("ONLINE", 1);
        ONLINE = r1;
        UserState r10 = new UserState("ABSENT", 2);
        ABSENT = r10;
        UserState r11 = new UserState("PRE_ONLINE", 3);
        PRE_ONLINE = r11;
        UserState[] r12 = {r0, r1, r10, r11};
        a = r12;
        b = EnumEntriesKt.enumEntries(r12);
    }

    public static UserState[] values() {
        return (UserState[]) a.clone();
    }

    public static UserState valueOf(String r1) {
        return (UserState) a.a(UserState.class, r1);
    }

    public UserState(String r1, int r10) {
        super(r1, r10);
    }
}
