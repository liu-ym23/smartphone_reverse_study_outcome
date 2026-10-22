package com.obric.memorydata.sdk.screencapture.rule;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/memorydata/sdk/screencapture/rule/KeywordsMatchRuleEnum;", "", "<init>", "(Ljava/lang/String;I)V", "OR", "AND", "EXPRESSION", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum KeywordsMatchRuleEnum extends Enum<KeywordsMatchRuleEnum> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ KeywordsMatchRuleEnum[] $VALUES = null;
    public static final KeywordsMatchRuleEnum AND = null;
    public static final KeywordsMatchRuleEnum EXPRESSION = null;
    public static final KeywordsMatchRuleEnum OR = null;

    private static final /* synthetic */ KeywordsMatchRuleEnum[] $values() {
        return new KeywordsMatchRuleEnum[]{OR, AND, EXPRESSION};
    }

    static {
        OR = new KeywordsMatchRuleEnum("OR", 0);
        AND = new KeywordsMatchRuleEnum("AND", 1);
        EXPRESSION = new KeywordsMatchRuleEnum("EXPRESSION", 2);
        KeywordsMatchRuleEnum[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private KeywordsMatchRuleEnum(String r1, int r2) {
        super(r1, r2);
    }

    public static EnumEntries<KeywordsMatchRuleEnum> getEntries() {
        return $ENTRIES;
    }

    public static KeywordsMatchRuleEnum valueOf(String r2) {
        return (KeywordsMatchRuleEnum) ZeusTransformUtils.preCheckCast(Enum.valueOf(KeywordsMatchRuleEnum.class, r2), KeywordsMatchRuleEnum.class, "com.obric.memorydata.plugin");
    }

    public static KeywordsMatchRuleEnum[] values() {
        return (KeywordsMatchRuleEnum[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), KeywordsMatchRuleEnum[].class, "com.obric.memorydata.plugin");
    }
}
