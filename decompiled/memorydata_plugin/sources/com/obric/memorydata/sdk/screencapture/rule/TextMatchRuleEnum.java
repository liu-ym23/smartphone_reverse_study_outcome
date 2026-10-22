package com.obric.memorydata.sdk.screencapture.rule;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/sdk/screencapture/rule/TextMatchRuleEnum;", "", "<init>", "(Ljava/lang/String;I)V", "EQUALS", "CONTAINS", "REGEX", "WILDCARD", "NOT_CONTAINS", "CHANGED", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum TextMatchRuleEnum extends Enum<TextMatchRuleEnum> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ TextMatchRuleEnum[] $VALUES = null;
    public static final TextMatchRuleEnum CHANGED = null;
    public static final TextMatchRuleEnum CONTAINS = null;
    public static final TextMatchRuleEnum EQUALS = null;
    public static final TextMatchRuleEnum NOT_CONTAINS = null;
    public static final TextMatchRuleEnum REGEX = null;
    public static final TextMatchRuleEnum WILDCARD = null;

    private static final /* synthetic */ TextMatchRuleEnum[] $values() {
        return new TextMatchRuleEnum[]{EQUALS, CONTAINS, REGEX, WILDCARD, NOT_CONTAINS, CHANGED};
    }

    static {
        EQUALS = new TextMatchRuleEnum("EQUALS", 0);
        CONTAINS = new TextMatchRuleEnum("CONTAINS", 1);
        REGEX = new TextMatchRuleEnum("REGEX", 2);
        WILDCARD = new TextMatchRuleEnum("WILDCARD", 3);
        NOT_CONTAINS = new TextMatchRuleEnum("NOT_CONTAINS", 4);
        CHANGED = new TextMatchRuleEnum("CHANGED", 5);
        TextMatchRuleEnum[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private TextMatchRuleEnum(String r1, int r2) {
        super(r1, r2);
    }

    public static EnumEntries<TextMatchRuleEnum> getEntries() {
        return $ENTRIES;
    }

    public static TextMatchRuleEnum valueOf(String r2) {
        return (TextMatchRuleEnum) ZeusTransformUtils.preCheckCast(Enum.valueOf(TextMatchRuleEnum.class, r2), TextMatchRuleEnum.class, "com.obric.memorydata.plugin");
    }

    public static TextMatchRuleEnum[] values() {
        return (TextMatchRuleEnum[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), TextMatchRuleEnum[].class, "com.obric.memorydata.plugin");
    }
}
