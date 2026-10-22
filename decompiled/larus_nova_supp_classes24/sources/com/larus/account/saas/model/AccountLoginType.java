package com.larus.account.saas.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/account/saas/model/AccountLoginType;", "", "SMS", "SAFE_ONE_LOGIN", "GROUP_AUTH", "H5_JSB", "account-saas-api_release"}, k = 1, mv = {1, 7, 1})
public final enum AccountLoginType extends Enum<AccountLoginType> {
    public static final AccountLoginType GROUP_AUTH = null;
    public static final AccountLoginType H5_JSB = null;
    public static final AccountLoginType SAFE_ONE_LOGIN = null;
    public static final AccountLoginType SMS = null;
    public static final /* synthetic */ AccountLoginType[] a = null;

    public static AccountLoginType valueOf(String r1) {
        return (AccountLoginType) a.a(AccountLoginType.class, r1);
    }

    public static AccountLoginType[] values() {
        return (AccountLoginType[]) a.clone();
    }

    static {
        AccountLoginType r0 = new AccountLoginType("SMS", 0);
        SMS = r0;
        AccountLoginType r1 = new AccountLoginType("SAFE_ONE_LOGIN", 1);
        SAFE_ONE_LOGIN = r1;
        AccountLoginType r3 = new AccountLoginType("GROUP_AUTH", 2);
        GROUP_AUTH = r3;
        AccountLoginType r5 = new AccountLoginType("H5_JSB", 3);
        H5_JSB = r5;
        a = new AccountLoginType[]{r0, r1, r3, r5};
    }

    public AccountLoginType(String r1, int r2) {
        super(r1, r2);
    }
}
