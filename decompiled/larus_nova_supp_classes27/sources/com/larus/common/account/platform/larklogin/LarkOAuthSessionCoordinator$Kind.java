package com.larus.common.account.platform.larklogin;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/common/account/platform/larklogin/LarkOAuthSessionCoordinator$Kind;", "", "<init>", "(Ljava/lang/String;I)V", "LOGIN", "REFRESH", "SUPPLEMENT", "larkauth_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum LarkOAuthSessionCoordinator$Kind extends Enum<LarkOAuthSessionCoordinator$Kind> {
    public static final LarkOAuthSessionCoordinator$Kind LOGIN = null;
    public static final LarkOAuthSessionCoordinator$Kind REFRESH = null;
    public static final LarkOAuthSessionCoordinator$Kind SUPPLEMENT = null;
    public static final /* synthetic */ LarkOAuthSessionCoordinator$Kind[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<LarkOAuthSessionCoordinator$Kind> getEntries() {
        return b;
    }

    static {
        LarkOAuthSessionCoordinator$Kind r0 = new LarkOAuthSessionCoordinator$Kind("LOGIN", 0);
        LOGIN = r0;
        LarkOAuthSessionCoordinator$Kind r1 = new LarkOAuthSessionCoordinator$Kind("REFRESH", 1);
        REFRESH = r1;
        LarkOAuthSessionCoordinator$Kind r3 = new LarkOAuthSessionCoordinator$Kind("SUPPLEMENT", 2);
        SUPPLEMENT = r3;
        LarkOAuthSessionCoordinator$Kind[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static LarkOAuthSessionCoordinator$Kind[] values() {
        return (LarkOAuthSessionCoordinator$Kind[]) a.clone();
    }

    public static LarkOAuthSessionCoordinator$Kind valueOf(String r1) {
        return (LarkOAuthSessionCoordinator$Kind) a.a(LarkOAuthSessionCoordinator$Kind.class, r1);
    }

    public LarkOAuthSessionCoordinator$Kind(String r1, int r2) {
        super(r1, r2);
    }
}
