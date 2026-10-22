package com.bytedance.ai.applet.login;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ai/applet/login/FinishReason;", "", "description", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getDescription", "()Ljava/lang/String;", "USER_REJECTED_ON_CARD", "USER_REJECTED_PRIVACY", "USER_REJECTED_LOGIN", "USER_REJECTED_COMBINED", "SUCCESS", "BIZ_FAILED", "TIMEOUT", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum FinishReason extends Enum<FinishReason> {
    public static final FinishReason BIZ_FAILED = null;
    public static final FinishReason SUCCESS = null;
    public static final FinishReason TIMEOUT = null;
    public static final FinishReason USER_REJECTED_COMBINED = null;
    public static final FinishReason USER_REJECTED_LOGIN = null;
    public static final FinishReason USER_REJECTED_ON_CARD = null;
    public static final FinishReason USER_REJECTED_PRIVACY = null;
    public static final /* synthetic */ FinishReason[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String description;

    public static EnumEntries<FinishReason> getEntries() {
        return b;
    }

    static {
        FinishReason r0 = new FinishReason("USER_REJECTED_ON_CARD", 0, "User rejected on native card");
        USER_REJECTED_ON_CARD = r0;
        FinishReason r1 = new FinishReason("USER_REJECTED_PRIVACY", 1, "User rejected in privacy dialog");
        USER_REJECTED_PRIVACY = r1;
        FinishReason r10 = new FinishReason("USER_REJECTED_LOGIN", 2, "User rejected in login dialog");
        USER_REJECTED_LOGIN = r10;
        FinishReason r11 = new FinishReason("USER_REJECTED_COMBINED", 3, "User rejected in combined dialog");
        USER_REJECTED_COMBINED = r11;
        FinishReason r12 = new FinishReason("SUCCESS", 4, "Login success");
        SUCCESS = r12;
        FinishReason r13 = new FinishReason("BIZ_FAILED", 5, "Business login failed");
        BIZ_FAILED = r13;
        FinishReason r14 = new FinishReason("TIMEOUT", 6, "Process timeout");
        TIMEOUT = r14;
        FinishReason[] r15 = {r0, r1, r10, r11, r12, r13, r14};
        a = r15;
        b = EnumEntriesKt.enumEntries(r15);
    }

    public static FinishReason[] values() {
        return (FinishReason[]) a.clone();
    }

    public final String getDescription() {
        return this.description;
    }

    public static FinishReason valueOf(String r1) {
        return (FinishReason) r27.a.a(FinishReason.class, r1);
    }

    public FinishReason(String r1, int r10, String r11) {
        super(r1, r10);
        this.description = r11;
    }
}
