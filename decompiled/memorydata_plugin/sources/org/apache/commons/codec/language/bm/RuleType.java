package org.apache.commons.codec.language.bm;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public final enum RuleType extends Enum<RuleType> {
    private static final /* synthetic */ RuleType[] $VALUES = null;
    public static final RuleType APPROX = null;
    public static final RuleType EXACT = null;
    public static final RuleType RULES = null;
    private final String name;

    static {
        RuleType r0 = new RuleType("APPROX", 0, "approx");
        APPROX = r0;
        RuleType r1 = new RuleType("EXACT", 1, "exact");
        EXACT = r1;
        RuleType r3 = new RuleType("RULES", 2, "rules");
        RULES = r3;
        $VALUES = new RuleType[]{r0, r1, r3};
    }

    private RuleType(String r1, int r2, String r3) {
        super(r1, r2);
        this.name = r3;
    }

    public static RuleType valueOf(String r2) {
        return (RuleType) ZeusTransformUtils.preCheckCast(Enum.valueOf(RuleType.class, r2), RuleType.class, "com.obric.memorydata.plugin");
    }

    public static RuleType[] values() {
        return (RuleType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), RuleType[].class, "com.obric.memorydata.plugin");
    }

    public String getName() {
        return this.name;
    }
}
