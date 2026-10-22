package com.obric.memorydata.sdk.screencapture.rule;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/sdk/screencapture/rule/RectMatchRuleEnum;", "", "<init>", "(Ljava/lang/String;I)V", "CONTAINS", "NOT_CONTAINS", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum RectMatchRuleEnum extends Enum<RectMatchRuleEnum> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ RectMatchRuleEnum[] $VALUES = null;
    public static final RectMatchRuleEnum CONTAINS = null;
    public static final RectMatchRuleEnum NOT_CONTAINS = null;

    private static final /* synthetic */ RectMatchRuleEnum[] $values() {
        return new RectMatchRuleEnum[]{CONTAINS, NOT_CONTAINS};
    }

    static {
        CONTAINS = new RectMatchRuleEnum("CONTAINS", 0);
        NOT_CONTAINS = new RectMatchRuleEnum("NOT_CONTAINS", 1);
        RectMatchRuleEnum[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private RectMatchRuleEnum(String r1, int r2) {
        super(r1, r2);
    }

    public static EnumEntries<RectMatchRuleEnum> getEntries() {
        return $ENTRIES;
    }

    public static RectMatchRuleEnum valueOf(String r2) {
        return (RectMatchRuleEnum) ZeusTransformUtils.preCheckCast(Enum.valueOf(RectMatchRuleEnum.class, r2), RectMatchRuleEnum.class, "com.obric.memorydata.plugin");
    }

    public static RectMatchRuleEnum[] values() {
        return (RectMatchRuleEnum[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), RectMatchRuleEnum[].class, "com.obric.memorydata.plugin");
    }
}
