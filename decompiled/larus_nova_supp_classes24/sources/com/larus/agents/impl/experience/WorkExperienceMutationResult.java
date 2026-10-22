package com.larus.agents.impl.experience;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/agents/impl/experience/WorkExperienceMutationResult;", "", "<init>", "(Ljava/lang/String;I)V", "SUCCESS", "SECURITY_RISK", "DUPLICATE_NAME", "FAILURE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum WorkExperienceMutationResult extends Enum<WorkExperienceMutationResult> {
    public static final WorkExperienceMutationResult DUPLICATE_NAME = null;
    public static final WorkExperienceMutationResult FAILURE = null;
    public static final WorkExperienceMutationResult SECURITY_RISK = null;
    public static final WorkExperienceMutationResult SUCCESS = null;
    public static final /* synthetic */ WorkExperienceMutationResult[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<WorkExperienceMutationResult> getEntries() {
        return b;
    }

    static {
        WorkExperienceMutationResult r0 = new WorkExperienceMutationResult("SUCCESS", 0);
        SUCCESS = r0;
        WorkExperienceMutationResult r1 = new WorkExperienceMutationResult("SECURITY_RISK", 1);
        SECURITY_RISK = r1;
        WorkExperienceMutationResult r3 = new WorkExperienceMutationResult("DUPLICATE_NAME", 2);
        DUPLICATE_NAME = r3;
        WorkExperienceMutationResult r5 = new WorkExperienceMutationResult("FAILURE", 3);
        FAILURE = r5;
        WorkExperienceMutationResult[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
    }

    public static WorkExperienceMutationResult[] values() {
        return (WorkExperienceMutationResult[]) a.clone();
    }

    public static WorkExperienceMutationResult valueOf(String r1) {
        return (WorkExperienceMutationResult) r27.a.a(WorkExperienceMutationResult.class, r1);
    }

    public WorkExperienceMutationResult(String r1, int r2) {
        super(r1, r2);
    }
}
