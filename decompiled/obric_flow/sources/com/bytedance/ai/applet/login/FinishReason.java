package com.bytedance.ai.applet.login;

import kotlin.Metadata;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/ai/applet/login/FinishReason;", "", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum FinishReason extends Enum<FinishReason> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final FinishReason f1724b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final FinishReason f1725c = null;
    public static final FinishReason d = null;
    public static final FinishReason e = null;
    public static final FinishReason f = null;
    public static final /* synthetic */ FinishReason[] g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1726a;

    static {
        FinishReason r5 = new FinishReason("USER_REJECTED_ON_CARD", 0, "User rejected on native card");
        FinishReason r10 = new FinishReason("USER_REJECTED_PRIVACY", 1, "User rejected in privacy dialog");
        f1724b = r10;
        FinishReason r11 = new FinishReason("USER_REJECTED_LOGIN", 2, "User rejected in login dialog");
        f1725c = r11;
        FinishReason r12 = new FinishReason("USER_REJECTED_COMBINED", 3, "User rejected in combined dialog");
        d = r12;
        FinishReason r13 = new FinishReason("SUCCESS", 4, "Login success");
        e = r13;
        FinishReason r14 = new FinishReason("BIZ_FAILED", 5, "Business login failed");
        f = r14;
        FinishReason[] r15 = {r5, r10, r11, r12, r13, r14, new FinishReason("TIMEOUT", 6, "Process timeout")};
        g = r15;
        EnumEntriesKt.enumEntries(r15);
    }

    public FinishReason(String r5, int r10, String r11) {
        super(r5, r10);
        this.f1726a = r11;
    }

    public static FinishReason valueOf(String r5) {
        return (FinishReason) Enum.valueOf(FinishReason.class, r5);
    }

    public static FinishReason[] values() {
        return (FinishReason[]) g.clone();
    }
}
