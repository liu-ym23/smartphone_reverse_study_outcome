package com.larus.account.saas.security.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0014"}, d2 = {"Lcom/larus/account/saas/security/model/AccountSecurityEventType;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "", "type", "I", "getType", "()I", "WAKE_UP_APP", "OPEN_CONVERSATION", "OPEN_DOCUMENT", "BROWSE_EXCESSIVE_CHAT_HISTORY", "VIEW_WALLET", "VIEW_ORDER", "VIEW_MEMORY", "LOGOUT_DEVICE_IN_DEVICE_MANAGEMENT", "account-saas-security-api_release"}, k = 1, mv = {1, 7, 1})
public final enum AccountSecurityEventType extends Enum<AccountSecurityEventType> {
    public static final AccountSecurityEventType BROWSE_EXCESSIVE_CHAT_HISTORY = null;
    public static final AccountSecurityEventType LOGOUT_DEVICE_IN_DEVICE_MANAGEMENT = null;
    public static final AccountSecurityEventType OPEN_CONVERSATION = null;
    public static final AccountSecurityEventType OPEN_DOCUMENT = null;
    public static final AccountSecurityEventType VIEW_MEMORY = null;
    public static final AccountSecurityEventType VIEW_ORDER = null;
    public static final AccountSecurityEventType VIEW_WALLET = null;
    public static final AccountSecurityEventType WAKE_UP_APP = null;
    public static final /* synthetic */ AccountSecurityEventType[] a = null;
    private final int type;
    private final String value;

    public static AccountSecurityEventType valueOf(String r1) {
        return (AccountSecurityEventType) a.a(AccountSecurityEventType.class, r1);
    }

    public static AccountSecurityEventType[] values() {
        return (AccountSecurityEventType[]) a.clone();
    }

    static {
        AccountSecurityEventType r0 = new AccountSecurityEventType("WAKE_UP_APP", 0, "wake_up_app", 1);
        WAKE_UP_APP = r0;
        AccountSecurityEventType r1 = new AccountSecurityEventType("OPEN_CONVERSATION", 1, "open_conversation", 2);
        OPEN_CONVERSATION = r1;
        AccountSecurityEventType r3 = new AccountSecurityEventType("OPEN_DOCUMENT", 2, "open_document", 3);
        OPEN_DOCUMENT = r3;
        AccountSecurityEventType r5 = new AccountSecurityEventType("BROWSE_EXCESSIVE_CHAT_HISTORY", 3, "browse_excessive_chat_history", 4);
        BROWSE_EXCESSIVE_CHAT_HISTORY = r5;
        AccountSecurityEventType r7 = new AccountSecurityEventType("VIEW_WALLET", 4, "view_wallet", 5);
        VIEW_WALLET = r7;
        AccountSecurityEventType r9 = new AccountSecurityEventType("VIEW_ORDER", 5, "view_order", 6);
        VIEW_ORDER = r9;
        AccountSecurityEventType r11 = new AccountSecurityEventType("VIEW_MEMORY", 6, "view_memory", 7);
        VIEW_MEMORY = r11;
        AccountSecurityEventType r13 = new AccountSecurityEventType("LOGOUT_DEVICE_IN_DEVICE_MANAGEMENT", 7, "logout_device_in_device_management", 8);
        LOGOUT_DEVICE_IN_DEVICE_MANAGEMENT = r13;
        a = new AccountSecurityEventType[]{r0, r1, r3, r5, r7, r9, r11, r13};
    }

    public final int getType() {
        return this.type;
    }

    public final String getValue() {
        return this.value;
    }

    public AccountSecurityEventType(String r1, int r2, String r3, int r4) {
        super(r1, r2);
        this.value = r3;
        this.type = r4;
    }
}
