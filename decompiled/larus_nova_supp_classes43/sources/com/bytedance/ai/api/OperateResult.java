package com.bytedance.ai.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ai/api/OperateResult;", "", "<init>", "(Ljava/lang/String;I)V", "SUCCESS", "REJECT", "CANCEL", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OperateResult extends Enum<OperateResult> {
    public static final OperateResult CANCEL = null;
    public static final OperateResult REJECT = null;
    public static final OperateResult SUCCESS = null;
    public static final /* synthetic */ OperateResult[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<OperateResult> getEntries() {
        return b;
    }

    static {
        OperateResult r0 = new OperateResult("SUCCESS", 0);
        SUCCESS = r0;
        OperateResult r1 = new OperateResult("REJECT", 1);
        REJECT = r1;
        OperateResult r10 = new OperateResult("CANCEL", 2);
        CANCEL = r10;
        OperateResult[] r11 = {r0, r1, r10};
        a = r11;
        b = EnumEntriesKt.enumEntries(r11);
    }

    public static OperateResult[] values() {
        return (OperateResult[]) a.clone();
    }

    public static OperateResult valueOf(String r1) {
        return (OperateResult) r27.a.a(OperateResult.class, r1);
    }

    public OperateResult(String r1, int r10) {
        super(r1, r10);
    }
}
