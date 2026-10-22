package com.bytedance.ai.applet.login;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ai/applet/login/OperationType;", "", "<init>", "(Ljava/lang/String;I)V", "PRIVACY", "LOGIN", "PHONE_NUM", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OperationType extends Enum<OperationType> {
    public static final OperationType LOGIN = null;
    public static final OperationType PHONE_NUM = null;
    public static final OperationType PRIVACY = null;
    public static final /* synthetic */ OperationType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<OperationType> getEntries() {
        return b;
    }

    static {
        OperationType r0 = new OperationType("PRIVACY", 0);
        PRIVACY = r0;
        OperationType r1 = new OperationType("LOGIN", 1);
        LOGIN = r1;
        OperationType r10 = new OperationType("PHONE_NUM", 2);
        PHONE_NUM = r10;
        OperationType[] r11 = {r0, r1, r10};
        a = r11;
        b = EnumEntriesKt.enumEntries(r11);
    }

    public static OperationType[] values() {
        return (OperationType[]) a.clone();
    }

    public static OperationType valueOf(String r1) {
        return (OperationType) r27.a.a(OperationType.class, r1);
    }

    public OperationType(String r1, int r10) {
        super(r1, r10);
    }
}
