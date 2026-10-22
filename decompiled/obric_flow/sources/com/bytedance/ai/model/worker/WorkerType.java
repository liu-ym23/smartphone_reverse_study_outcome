package com.bytedance.ai.model.worker;

import kotlin.Metadata;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/ai/model/worker/WorkerType;", "", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum WorkerType extends Enum<WorkerType> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final WorkerType f2373a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final WorkerType f2374b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final WorkerType f2375c = null;
    public static final /* synthetic */ WorkerType[] d = null;

    static {
        WorkerType r5 = new WorkerType("RELAX", 0);
        f2373a = r5;
        WorkerType r10 = new WorkerType("JAVASCRIPT", 1);
        f2374b = r10;
        WorkerType r11 = new WorkerType("LYNX", 2);
        f2375c = r11;
        WorkerType[] r12 = {r5, r10, r11};
        d = r12;
        EnumEntriesKt.enumEntries(r12);
    }

    public WorkerType(String r5, int r10) {
        super(r5, r10);
    }

    public static WorkerType valueOf(String r5) {
        return (WorkerType) Enum.valueOf(WorkerType.class, r5);
    }

    public static WorkerType[] values() {
        return (WorkerType[]) d.clone();
    }
}
