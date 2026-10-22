package com.larus.common.account.bdauth.repository;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/common/account/bdauth/repository/BDAuthorizeAccountIssueType;", "", "<init>", "(Ljava/lang/String;I)V", "SessionExpired", "AccountDeactivated", "EnterpriseUnsupported", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum BDAuthorizeAccountIssueType extends Enum<BDAuthorizeAccountIssueType> {
    public static final BDAuthorizeAccountIssueType AccountDeactivated = null;
    public static final BDAuthorizeAccountIssueType EnterpriseUnsupported = null;
    public static final BDAuthorizeAccountIssueType SessionExpired = null;
    public static final /* synthetic */ BDAuthorizeAccountIssueType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<BDAuthorizeAccountIssueType> getEntries() {
        return b;
    }

    static {
        BDAuthorizeAccountIssueType r0 = new BDAuthorizeAccountIssueType("SessionExpired", 0);
        SessionExpired = r0;
        BDAuthorizeAccountIssueType r1 = new BDAuthorizeAccountIssueType("AccountDeactivated", 1);
        AccountDeactivated = r1;
        BDAuthorizeAccountIssueType r3 = new BDAuthorizeAccountIssueType("EnterpriseUnsupported", 2);
        EnterpriseUnsupported = r3;
        BDAuthorizeAccountIssueType[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static BDAuthorizeAccountIssueType[] values() {
        return (BDAuthorizeAccountIssueType[]) a.clone();
    }

    public static BDAuthorizeAccountIssueType valueOf(String r1) {
        return (BDAuthorizeAccountIssueType) r27.a.a(BDAuthorizeAccountIssueType.class, r1);
    }

    public BDAuthorizeAccountIssueType(String r1, int r2) {
        super(r1, r2);
    }
}
