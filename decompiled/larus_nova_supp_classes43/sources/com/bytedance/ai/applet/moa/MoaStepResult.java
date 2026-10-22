package com.bytedance.ai.applet.moa;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/ai/applet/moa/MoaStepResult;", "", "<init>", "(Ljava/lang/String;I)V", "CONTINUE", "REFUSED", "FAILED", "REQUIRES_CONFIRMATION", "WAITING_ACTION", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MoaStepResult extends Enum<MoaStepResult> {
    public static final MoaStepResult CONTINUE = null;
    public static final MoaStepResult FAILED = null;
    public static final MoaStepResult REFUSED = null;
    public static final MoaStepResult REQUIRES_CONFIRMATION = null;
    public static final MoaStepResult WAITING_ACTION = null;
    public static final /* synthetic */ MoaStepResult[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<MoaStepResult> getEntries() {
        return b;
    }

    static {
        MoaStepResult r0 = new MoaStepResult("CONTINUE", 0);
        CONTINUE = r0;
        MoaStepResult r1 = new MoaStepResult("REFUSED", 1);
        REFUSED = r1;
        MoaStepResult r10 = new MoaStepResult("FAILED", 2);
        FAILED = r10;
        MoaStepResult r11 = new MoaStepResult("REQUIRES_CONFIRMATION", 3);
        REQUIRES_CONFIRMATION = r11;
        MoaStepResult r12 = new MoaStepResult("WAITING_ACTION", 4);
        WAITING_ACTION = r12;
        MoaStepResult[] r13 = {r0, r1, r10, r11, r12};
        a = r13;
        b = EnumEntriesKt.enumEntries(r13);
    }

    public static MoaStepResult[] values() {
        return (MoaStepResult[]) a.clone();
    }

    public static MoaStepResult valueOf(String r1) {
        return (MoaStepResult) r27.a.a(MoaStepResult.class, r1);
    }

    public MoaStepResult(String r1, int r10) {
        super(r1, r10);
    }
}
