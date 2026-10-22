package com.larus.account.saas.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/larus/account/saas/model/AccountLoginEntryStyle;", "", "SETTINGS_ITEM", "FULL_SCREEN", "HALF_SCREEN", "account-saas-api_release"}, k = 1, mv = {1, 7, 1})
public final enum AccountLoginEntryStyle extends Enum<AccountLoginEntryStyle> {
    public static final AccountLoginEntryStyle FULL_SCREEN = null;
    public static final AccountLoginEntryStyle HALF_SCREEN = null;
    public static final AccountLoginEntryStyle SETTINGS_ITEM = null;
    public static final /* synthetic */ AccountLoginEntryStyle[] a = null;

    public static AccountLoginEntryStyle valueOf(String r1) {
        return (AccountLoginEntryStyle) a.a(AccountLoginEntryStyle.class, r1);
    }

    public static AccountLoginEntryStyle[] values() {
        return (AccountLoginEntryStyle[]) a.clone();
    }

    static {
        AccountLoginEntryStyle r0 = new AccountLoginEntryStyle("SETTINGS_ITEM", 0);
        SETTINGS_ITEM = r0;
        AccountLoginEntryStyle r1 = new AccountLoginEntryStyle("FULL_SCREEN", 1);
        FULL_SCREEN = r1;
        AccountLoginEntryStyle r3 = new AccountLoginEntryStyle("HALF_SCREEN", 2);
        HALF_SCREEN = r3;
        a = new AccountLoginEntryStyle[]{r0, r1, r3};
    }

    public AccountLoginEntryStyle(String r1, int r2) {
        super(r1, r2);
    }
}
