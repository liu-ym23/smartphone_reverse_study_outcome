package com.bytedance.android.ec.base.api.ai;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/ec/base/api/ai/AIChatMessageStatusLocal;", "", "(Ljava/lang/String;I)V", "UNKNOWN", "SENDING", "SENT", "FAILED", "RECEIVING", "FINISHED", "ec-base-api_release"}, k = 1, mv = {1, 4, 3})
public final enum AIChatMessageStatusLocal extends Enum<AIChatMessageStatusLocal> {
    private static final /* synthetic */ AIChatMessageStatusLocal[] $VALUES = null;
    public static final AIChatMessageStatusLocal FAILED = null;
    public static final AIChatMessageStatusLocal FINISHED = null;
    public static final AIChatMessageStatusLocal RECEIVING = null;
    public static final AIChatMessageStatusLocal SENDING = null;
    public static final AIChatMessageStatusLocal SENT = null;
    public static final AIChatMessageStatusLocal UNKNOWN = null;

    static {
        AIChatMessageStatusLocal r1 = new AIChatMessageStatusLocal("UNKNOWN", 0);
        UNKNOWN = r1;
        AIChatMessageStatusLocal r10 = new AIChatMessageStatusLocal("SENDING", 1);
        SENDING = r10;
        AIChatMessageStatusLocal r11 = new AIChatMessageStatusLocal("SENT", 2);
        SENT = r11;
        AIChatMessageStatusLocal r12 = new AIChatMessageStatusLocal("FAILED", 3);
        FAILED = r12;
        AIChatMessageStatusLocal r13 = new AIChatMessageStatusLocal("RECEIVING", 4);
        RECEIVING = r13;
        AIChatMessageStatusLocal r14 = new AIChatMessageStatusLocal("FINISHED", 5);
        FINISHED = r14;
        $VALUES = new AIChatMessageStatusLocal[]{r1, r10, r11, r12, r13, r14};
    }

    public static AIChatMessageStatusLocal valueOf(String r1) {
        return (AIChatMessageStatusLocal) a.a(AIChatMessageStatusLocal.class, r1);
    }

    public static AIChatMessageStatusLocal[] values() {
        return (AIChatMessageStatusLocal[]) $VALUES.clone();
    }

    private AIChatMessageStatusLocal(String r1, int r10) {
        super(r1, r10);
    }
}
