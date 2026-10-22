package com.obric.memorydata.sdk.screencapture.rule;

import com.obric.eventkit.eventstaskmanager.ITaskManager;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/sdk/screencapture/rule/ConditionMatchRuleEnum;", "", "<init>", "(Ljava/lang/String;I)V", "OR", "SEQUENCE", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final enum ConditionMatchRuleEnum extends Enum<ConditionMatchRuleEnum> {
    public static final ConditionMatchRuleEnum OR = null;
    public static final ConditionMatchRuleEnum SEQUENCE = null;
    public static final /* synthetic */ ConditionMatchRuleEnum[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ConditionMatchRuleEnum> getEntries() {
        return b;
    }

    static {
        ConditionMatchRuleEnum r0 = new ConditionMatchRuleEnum("OR", 0);
        OR = r0;
        ConditionMatchRuleEnum r1 = new ConditionMatchRuleEnum("SEQUENCE", 1);
        SEQUENCE = r1;
        ConditionMatchRuleEnum[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static ConditionMatchRuleEnum[] values() {
        return (ConditionMatchRuleEnum[]) a.clone();
    }

    public static ConditionMatchRuleEnum valueOf(String r1) {
        return (ConditionMatchRuleEnum) a.a(ConditionMatchRuleEnum.class, r1);
    }

    public ConditionMatchRuleEnum(String r1, int r2) {
        super(r1, r2);
    }
}
