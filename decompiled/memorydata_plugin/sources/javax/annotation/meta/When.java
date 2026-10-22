package javax.annotation.meta;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public final enum When extends Enum<When> {
    private static final /* synthetic */ When[] $VALUES = null;
    public static final When ALWAYS = null;
    public static final When MAYBE = null;
    public static final When NEVER = null;
    public static final When UNKNOWN = null;

    static {
        When r0 = new When("ALWAYS", 0);
        ALWAYS = r0;
        When r1 = new When("UNKNOWN", 1);
        UNKNOWN = r1;
        When r3 = new When("MAYBE", 2);
        MAYBE = r3;
        When r5 = new When("NEVER", 3);
        NEVER = r5;
        $VALUES = new When[]{r0, r1, r3, r5};
    }

    private When(String r1, int r2) {
        super(r1, r2);
    }

    public static When valueOf(String r2) {
        return (When) ZeusTransformUtils.preCheckCast(Enum.valueOf(When.class, r2), When.class, "com.obric.memorydata.plugin");
    }

    public static When[] values() {
        return (When[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), When[].class, "com.obric.memorydata.plugin");
    }
}
