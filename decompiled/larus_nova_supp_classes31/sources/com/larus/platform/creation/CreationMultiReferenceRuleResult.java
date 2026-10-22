package com.larus.platform.creation;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/platform/creation/CreationMultiReferenceRuleResult;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "PASS", "REJECT", "UNAVAILABLE", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final enum CreationMultiReferenceRuleResult extends Enum<CreationMultiReferenceRuleResult> {
    public static final CreationMultiReferenceRuleResult PASS = null;
    public static final CreationMultiReferenceRuleResult REJECT = null;
    public static final CreationMultiReferenceRuleResult UNAVAILABLE = null;
    public static final /* synthetic */ CreationMultiReferenceRuleResult[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String value;

    public static EnumEntries<CreationMultiReferenceRuleResult> getEntries() {
        return b;
    }

    static {
        CreationMultiReferenceRuleResult r0 = new CreationMultiReferenceRuleResult("PASS", 0, "pass");
        PASS = r0;
        CreationMultiReferenceRuleResult r1 = new CreationMultiReferenceRuleResult("REJECT", 1, "reject");
        REJECT = r1;
        CreationMultiReferenceRuleResult r2 = new CreationMultiReferenceRuleResult("UNAVAILABLE", 2, "unavailable");
        UNAVAILABLE = r2;
        CreationMultiReferenceRuleResult[] r4 = {r0, r1, r2};
        a = r4;
        b = EnumEntriesKt.enumEntries(r4);
    }

    public static CreationMultiReferenceRuleResult[] values() {
        return (CreationMultiReferenceRuleResult[]) a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static CreationMultiReferenceRuleResult valueOf(String r1) {
        return (CreationMultiReferenceRuleResult) a.a(CreationMultiReferenceRuleResult.class, r1);
    }

    public CreationMultiReferenceRuleResult(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
