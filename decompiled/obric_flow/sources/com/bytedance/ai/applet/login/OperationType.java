package com.bytedance.ai.applet.login;

import kotlin.Metadata;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/ai/applet/login/OperationType;", "", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum OperationType extends Enum<OperationType> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final OperationType f1730a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final OperationType f1731b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final OperationType f1732c = null;
    public static final /* synthetic */ OperationType[] d = null;

    static {
        OperationType r5 = new OperationType("PRIVACY", 0);
        f1730a = r5;
        OperationType r10 = new OperationType("LOGIN", 1);
        f1731b = r10;
        OperationType r11 = new OperationType("PHONE_NUM", 2);
        f1732c = r11;
        OperationType[] r12 = {r5, r10, r11};
        d = r12;
        EnumEntriesKt.enumEntries(r12);
    }

    public OperationType(String r5, int r10) {
        super(r5, r10);
    }

    public static OperationType valueOf(String r5) {
        return (OperationType) Enum.valueOf(OperationType.class, r5);
    }

    public static OperationType[] values() {
        return (OperationType[]) d.clone();
    }
}
