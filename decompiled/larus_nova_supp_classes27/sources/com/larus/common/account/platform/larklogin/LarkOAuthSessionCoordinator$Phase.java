package com.larus.common.account.platform.larklogin;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/common/account/platform/larklogin/LarkOAuthSessionCoordinator$Phase;", "", "<init>", "(Ljava/lang/String;I)V", "AUTHORIZING", "WAITING", "EXCHANGING", "larkauth_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum LarkOAuthSessionCoordinator$Phase extends Enum<LarkOAuthSessionCoordinator$Phase> {
    public static final LarkOAuthSessionCoordinator$Phase AUTHORIZING = null;
    public static final LarkOAuthSessionCoordinator$Phase EXCHANGING = null;
    public static final LarkOAuthSessionCoordinator$Phase WAITING = null;
    public static final /* synthetic */ LarkOAuthSessionCoordinator$Phase[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<LarkOAuthSessionCoordinator$Phase> getEntries() {
        return b;
    }

    static {
        LarkOAuthSessionCoordinator$Phase r0 = new LarkOAuthSessionCoordinator$Phase("AUTHORIZING", 0);
        AUTHORIZING = r0;
        LarkOAuthSessionCoordinator$Phase r1 = new LarkOAuthSessionCoordinator$Phase("WAITING", 1);
        WAITING = r1;
        LarkOAuthSessionCoordinator$Phase r3 = new LarkOAuthSessionCoordinator$Phase("EXCHANGING", 2);
        EXCHANGING = r3;
        LarkOAuthSessionCoordinator$Phase[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static LarkOAuthSessionCoordinator$Phase[] values() {
        return (LarkOAuthSessionCoordinator$Phase[]) a.clone();
    }

    public static LarkOAuthSessionCoordinator$Phase valueOf(String r1) {
        return (LarkOAuthSessionCoordinator$Phase) a.a(LarkOAuthSessionCoordinator$Phase.class, r1);
    }

    public LarkOAuthSessionCoordinator$Phase(String r1, int r2) {
        super(r1, r2);
    }
}
