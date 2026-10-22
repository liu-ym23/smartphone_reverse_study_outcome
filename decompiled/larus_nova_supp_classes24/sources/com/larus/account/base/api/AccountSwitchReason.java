package com.larus.account.base.api;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u0000 \u00142\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0014B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0012\u001a\u00020\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0015"}, d2 = {"Lcom/larus/account/base/api/AccountSwitchReason;", "", "enterMethod", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getEnterMethod", "()Ljava/lang/String;", "SETTING", "SETTING_ACCOUNT_NAME", "SETTING_TOP", "DOUBAO_ACCOUNT_SETTING_PAGE", "ACCOUNT_NAME", "PROFILE_ACCOUNT_NAME", "LOGOUT", "AUTO_LOGOUT", "OS_CLOUD_ALIGN_POPUP", "UNKNOWN", "isLogout", "", "Companion", "api_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum AccountSwitchReason extends Enum<AccountSwitchReason> {
    public static final AccountSwitchReason ACCOUNT_NAME = null;
    public static final AccountSwitchReason AUTO_LOGOUT = null;
    public static final a Companion = null;
    public static final AccountSwitchReason DOUBAO_ACCOUNT_SETTING_PAGE = null;
    public static final AccountSwitchReason LOGOUT = null;
    public static final AccountSwitchReason OS_CLOUD_ALIGN_POPUP = null;
    public static final AccountSwitchReason PROFILE_ACCOUNT_NAME = null;
    public static final AccountSwitchReason SETTING = null;
    public static final AccountSwitchReason SETTING_ACCOUNT_NAME = null;
    public static final AccountSwitchReason SETTING_TOP = null;
    public static final AccountSwitchReason UNKNOWN = null;
    public static final /* synthetic */ AccountSwitchReason[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String enterMethod;

    public static EnumEntries<AccountSwitchReason> getEntries() {
        return b;
    }

    /* JADX WARN: Type inference failed for: r0v8, types: [com.larus.account.base.api.AccountSwitchReason$a] */
    static {
        AccountSwitchReason r0 = new AccountSwitchReason("SETTING", 0, "setting");
        SETTING = r0;
        AccountSwitchReason r1 = new AccountSwitchReason("SETTING_ACCOUNT_NAME", 1, "setting_account_name");
        SETTING_ACCOUNT_NAME = r1;
        AccountSwitchReason r3 = new AccountSwitchReason("SETTING_TOP", 2, "setting_top");
        SETTING_TOP = r3;
        AccountSwitchReason r5 = new AccountSwitchReason("DOUBAO_ACCOUNT_SETTING_PAGE", 3, "doubao_account_setting_page");
        DOUBAO_ACCOUNT_SETTING_PAGE = r5;
        AccountSwitchReason r7 = new AccountSwitchReason("ACCOUNT_NAME", 4, "account_name");
        ACCOUNT_NAME = r7;
        AccountSwitchReason r9 = new AccountSwitchReason("PROFILE_ACCOUNT_NAME", 5, "profile_account_name");
        PROFILE_ACCOUNT_NAME = r9;
        AccountSwitchReason r11 = new AccountSwitchReason("LOGOUT", 6, "logout");
        LOGOUT = r11;
        AccountSwitchReason r13 = new AccountSwitchReason("AUTO_LOGOUT", 7, "auto_logout");
        AUTO_LOGOUT = r13;
        AccountSwitchReason r12 = new AccountSwitchReason("OS_CLOUD_ALIGN_POPUP", 8, "os_cloud_align_popup");
        OS_CLOUD_ALIGN_POPUP = r12;
        AccountSwitchReason r10 = new AccountSwitchReason("UNKNOWN", 9, "unknown");
        UNKNOWN = r10;
        AccountSwitchReason[] r8 = {r0, r1, r3, r5, r7, r9, r11, r13, r12, r10};
        a = r8;
        b = EnumEntriesKt.enumEntries(r8);
        Companion = new a();
    }

    public static AccountSwitchReason[] values() {
        return (AccountSwitchReason[]) a.clone();
    }

    public final boolean isLogout() {
        if (this != LOGOUT) goto L5;
    L8:
        return true;
    L5:
        if (this == AUTO_LOGOUT) goto L8;
        return false;
    }

    public final String getEnterMethod() {
        return this.enterMethod;
    }

    public static AccountSwitchReason valueOf(String r1) {
        return (AccountSwitchReason) r27.a.a(AccountSwitchReason.class, r1);
    }

    public AccountSwitchReason(String r1, int r2, String r3) {
        super(r1, r2);
        this.enterMethod = r3;
    }
}
