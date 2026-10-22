package com.larus.commercecredit.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/larus/commercecredit/api/CreditInfoScene;", "", "scene", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getScene", "()Ljava/lang/String;", "COMMERCE_CREDIT_INFO_PANEL", "COMMERCE_CREDIT_INFO_PANEL_RETRY", "COMMERCE_CREDIT_INFO_PANEL_CLICK_MOBILE_ACTIVITY", "COMMERCE_CREDIT_SIDEBAR_PROFILE", "COMMERCE_CREDIT_DEFAULT_PROFILE", "COMMERCE_CREDIT_SETTING", "COMMERCE_CREDIT_MESSAGE_RECEIVED", "COMMERCE_CREDIT_MESSAGE_STREAM_END", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CreditInfoScene extends Enum<CreditInfoScene> {
    public static final CreditInfoScene COMMERCE_CREDIT_DEFAULT_PROFILE = null;
    public static final CreditInfoScene COMMERCE_CREDIT_INFO_PANEL = null;
    public static final CreditInfoScene COMMERCE_CREDIT_INFO_PANEL_CLICK_MOBILE_ACTIVITY = null;
    public static final CreditInfoScene COMMERCE_CREDIT_INFO_PANEL_RETRY = null;
    public static final CreditInfoScene COMMERCE_CREDIT_MESSAGE_RECEIVED = null;
    public static final CreditInfoScene COMMERCE_CREDIT_MESSAGE_STREAM_END = null;
    public static final CreditInfoScene COMMERCE_CREDIT_SETTING = null;
    public static final CreditInfoScene COMMERCE_CREDIT_SIDEBAR_PROFILE = null;
    public static final /* synthetic */ CreditInfoScene[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String scene;

    public static EnumEntries<CreditInfoScene> getEntries() {
        return b;
    }

    static {
        CreditInfoScene r0 = new CreditInfoScene("COMMERCE_CREDIT_INFO_PANEL", 0, "commerce_credit_info_panel");
        COMMERCE_CREDIT_INFO_PANEL = r0;
        CreditInfoScene r1 = new CreditInfoScene("COMMERCE_CREDIT_INFO_PANEL_RETRY", 1, "commerce_credit_info_panel_retry");
        COMMERCE_CREDIT_INFO_PANEL_RETRY = r1;
        CreditInfoScene r2 = new CreditInfoScene("COMMERCE_CREDIT_INFO_PANEL_CLICK_MOBILE_ACTIVITY", 2, "commerce_credit_info_panel_click_mobile_activity");
        COMMERCE_CREDIT_INFO_PANEL_CLICK_MOBILE_ACTIVITY = r2;
        CreditInfoScene r4 = new CreditInfoScene("COMMERCE_CREDIT_SIDEBAR_PROFILE", 3, "commerce_credit_sidebar_profile");
        COMMERCE_CREDIT_SIDEBAR_PROFILE = r4;
        CreditInfoScene r6 = new CreditInfoScene("COMMERCE_CREDIT_DEFAULT_PROFILE", 4, "commerce_credit_default_profile");
        COMMERCE_CREDIT_DEFAULT_PROFILE = r6;
        CreditInfoScene r8 = new CreditInfoScene("COMMERCE_CREDIT_SETTING", 5, "commerce_credit_setting");
        COMMERCE_CREDIT_SETTING = r8;
        CreditInfoScene r10 = new CreditInfoScene("COMMERCE_CREDIT_MESSAGE_RECEIVED", 6, "commerce_credit_message_received");
        COMMERCE_CREDIT_MESSAGE_RECEIVED = r10;
        CreditInfoScene r12 = new CreditInfoScene("COMMERCE_CREDIT_MESSAGE_STREAM_END", 7, "commerce_credit_message_stream_end");
        COMMERCE_CREDIT_MESSAGE_STREAM_END = r12;
        CreditInfoScene[] r14 = {r0, r1, r2, r4, r6, r8, r10, r12};
        a = r14;
        b = EnumEntriesKt.enumEntries(r14);
    }

    public static CreditInfoScene[] values() {
        return (CreditInfoScene[]) a.clone();
    }

    public final String getScene() {
        return this.scene;
    }

    public static CreditInfoScene valueOf(String r1) {
        return (CreditInfoScene) a.a(CreditInfoScene.class, r1);
    }

    public CreditInfoScene(String r1, int r2, String r3) {
        super(r1, r2);
        this.scene = r3;
    }
}
