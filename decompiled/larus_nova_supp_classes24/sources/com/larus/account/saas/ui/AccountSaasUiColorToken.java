package com.larus.account.saas.ui;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002¨\u0006\u0003"}, d2 = {"Lcom/larus/account/saas/ui/AccountSaasUiColorToken;", "", "STATUS_BAR_BACKGROUND", "account-saas-api_release"}, k = 1, mv = {1, 7, 1})
public final enum AccountSaasUiColorToken extends Enum<AccountSaasUiColorToken> {
    public static final AccountSaasUiColorToken STATUS_BAR_BACKGROUND = null;
    public static final /* synthetic */ AccountSaasUiColorToken[] a = null;

    public static AccountSaasUiColorToken valueOf(String r1) {
        return (AccountSaasUiColorToken) a.a(AccountSaasUiColorToken.class, r1);
    }

    public static AccountSaasUiColorToken[] values() {
        return (AccountSaasUiColorToken[]) a.clone();
    }

    static {
        AccountSaasUiColorToken r0 = new AccountSaasUiColorToken();
        STATUS_BAR_BACKGROUND = r0;
        a = new AccountSaasUiColorToken[]{r0};
    }

    public AccountSaasUiColorToken() {
        super("STATUS_BAR_BACKGROUND", 0);
    }
}
