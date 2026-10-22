package com.larus.common.account.bdauth.repository;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/common/account/bdauth/repository/BDAuthorizeBlockingErrorType;", "", "<init>", "(Ljava/lang/String;I)V", "MinorMode", "EnterpriseAccount", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum BDAuthorizeBlockingErrorType extends Enum<BDAuthorizeBlockingErrorType> {
    public static final BDAuthorizeBlockingErrorType EnterpriseAccount = null;
    public static final BDAuthorizeBlockingErrorType MinorMode = null;
    public static final /* synthetic */ BDAuthorizeBlockingErrorType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<BDAuthorizeBlockingErrorType> getEntries() {
        return b;
    }

    static {
        BDAuthorizeBlockingErrorType r0 = new BDAuthorizeBlockingErrorType("MinorMode", 0);
        MinorMode = r0;
        BDAuthorizeBlockingErrorType r1 = new BDAuthorizeBlockingErrorType("EnterpriseAccount", 1);
        EnterpriseAccount = r1;
        BDAuthorizeBlockingErrorType[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static BDAuthorizeBlockingErrorType[] values() {
        return (BDAuthorizeBlockingErrorType[]) a.clone();
    }

    public static BDAuthorizeBlockingErrorType valueOf(String r1) {
        return (BDAuthorizeBlockingErrorType) r27.a.a(BDAuthorizeBlockingErrorType.class, r1);
    }

    public BDAuthorizeBlockingErrorType(String r1, int r2) {
        super(r1, r2);
    }
}
