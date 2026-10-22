package com.obric.memorydata.sdk.screencapture.rule;

import com.obric.eventkit.eventstaskmanager.ITaskManager;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/memorydata/sdk/screencapture/rule/KeywordsMatchRuleEnum;", "", "<init>", "(Ljava/lang/String;I)V", "OR", "AND", "EXPRESSION", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final enum KeywordsMatchRuleEnum extends Enum<KeywordsMatchRuleEnum> {
    public static final KeywordsMatchRuleEnum AND = null;
    public static final KeywordsMatchRuleEnum EXPRESSION = null;
    public static final KeywordsMatchRuleEnum OR = null;
    public static final /* synthetic */ KeywordsMatchRuleEnum[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<KeywordsMatchRuleEnum> getEntries() {
        return b;
    }

    static {
        KeywordsMatchRuleEnum r0 = new KeywordsMatchRuleEnum("OR", 0);
        OR = r0;
        KeywordsMatchRuleEnum r1 = new KeywordsMatchRuleEnum("AND", 1);
        AND = r1;
        KeywordsMatchRuleEnum r3 = new KeywordsMatchRuleEnum("EXPRESSION", 2);
        EXPRESSION = r3;
        KeywordsMatchRuleEnum[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static KeywordsMatchRuleEnum[] values() {
        return (KeywordsMatchRuleEnum[]) a.clone();
    }

    public static KeywordsMatchRuleEnum valueOf(String r1) {
        return (KeywordsMatchRuleEnum) a.a(KeywordsMatchRuleEnum.class, r1);
    }

    public KeywordsMatchRuleEnum(String r1, int r2) {
        super(r1, r2);
    }
}
