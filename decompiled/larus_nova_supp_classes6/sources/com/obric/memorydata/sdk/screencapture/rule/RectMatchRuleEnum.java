package com.obric.memorydata.sdk.screencapture.rule;

import com.obric.eventkit.eventstaskmanager.ITaskManager;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/sdk/screencapture/rule/RectMatchRuleEnum;", "", "<init>", "(Ljava/lang/String;I)V", "CONTAINS", "NOT_CONTAINS", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final enum RectMatchRuleEnum extends Enum<RectMatchRuleEnum> {
    public static final RectMatchRuleEnum CONTAINS = null;
    public static final RectMatchRuleEnum NOT_CONTAINS = null;
    public static final /* synthetic */ RectMatchRuleEnum[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<RectMatchRuleEnum> getEntries() {
        return b;
    }

    static {
        RectMatchRuleEnum r0 = new RectMatchRuleEnum("CONTAINS", 0);
        CONTAINS = r0;
        RectMatchRuleEnum r1 = new RectMatchRuleEnum("NOT_CONTAINS", 1);
        NOT_CONTAINS = r1;
        RectMatchRuleEnum[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static RectMatchRuleEnum[] values() {
        return (RectMatchRuleEnum[]) a.clone();
    }

    public static RectMatchRuleEnum valueOf(String r1) {
        return (RectMatchRuleEnum) a.a(RectMatchRuleEnum.class, r1);
    }

    public RectMatchRuleEnum(String r1, int r2) {
        super(r1, r2);
    }
}
