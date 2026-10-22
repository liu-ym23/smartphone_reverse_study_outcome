package com.obric.memorydata.sdk.screencapture.rule;

import com.obric.eventkit.eventstaskmanager.ITaskManager;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/sdk/screencapture/rule/TextMatchRuleEnum;", "", "<init>", "(Ljava/lang/String;I)V", "EQUALS", "CONTAINS", "REGEX", "WILDCARD", "NOT_CONTAINS", "CHANGED", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final enum TextMatchRuleEnum extends Enum<TextMatchRuleEnum> {
    public static final TextMatchRuleEnum CHANGED = null;
    public static final TextMatchRuleEnum CONTAINS = null;
    public static final TextMatchRuleEnum EQUALS = null;
    public static final TextMatchRuleEnum NOT_CONTAINS = null;
    public static final TextMatchRuleEnum REGEX = null;
    public static final TextMatchRuleEnum WILDCARD = null;
    public static final /* synthetic */ TextMatchRuleEnum[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<TextMatchRuleEnum> getEntries() {
        return b;
    }

    static {
        TextMatchRuleEnum r0 = new TextMatchRuleEnum("EQUALS", 0);
        EQUALS = r0;
        TextMatchRuleEnum r1 = new TextMatchRuleEnum("CONTAINS", 1);
        CONTAINS = r1;
        TextMatchRuleEnum r3 = new TextMatchRuleEnum("REGEX", 2);
        REGEX = r3;
        TextMatchRuleEnum r5 = new TextMatchRuleEnum("WILDCARD", 3);
        WILDCARD = r5;
        TextMatchRuleEnum r7 = new TextMatchRuleEnum("NOT_CONTAINS", 4);
        NOT_CONTAINS = r7;
        TextMatchRuleEnum r9 = new TextMatchRuleEnum("CHANGED", 5);
        CHANGED = r9;
        TextMatchRuleEnum[] r11 = {r0, r1, r3, r5, r7, r9};
        a = r11;
        b = EnumEntriesKt.enumEntries(r11);
    }

    public static TextMatchRuleEnum[] values() {
        return (TextMatchRuleEnum[]) a.clone();
    }

    public static TextMatchRuleEnum valueOf(String r1) {
        return (TextMatchRuleEnum) a.a(TextMatchRuleEnum.class, r1);
    }

    public TextMatchRuleEnum(String r1, int r2) {
        super(r1, r2);
    }
}
