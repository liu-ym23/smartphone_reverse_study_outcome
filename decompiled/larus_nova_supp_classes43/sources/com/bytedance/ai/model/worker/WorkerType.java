package com.bytedance.ai.model.worker;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ai/model/worker/WorkerType;", "", "<init>", "(Ljava/lang/String;I)V", "JAVASCRIPT", "LYNX", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum WorkerType extends Enum<WorkerType> {
    public static final WorkerType JAVASCRIPT = null;
    public static final WorkerType LYNX = null;
    public static final /* synthetic */ WorkerType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<WorkerType> getEntries() {
        return b;
    }

    static {
        WorkerType r0 = new WorkerType("JAVASCRIPT", 0);
        JAVASCRIPT = r0;
        WorkerType r1 = new WorkerType("LYNX", 1);
        LYNX = r1;
        WorkerType[] r10 = {r0, r1};
        a = r10;
        b = EnumEntriesKt.enumEntries(r10);
    }

    public static WorkerType[] values() {
        return (WorkerType[]) a.clone();
    }

    public static WorkerType valueOf(String r1) {
        return (WorkerType) a.a(WorkerType.class, r1);
    }

    public WorkerType(String r1, int r10) {
        super(r1, r10);
    }
}
