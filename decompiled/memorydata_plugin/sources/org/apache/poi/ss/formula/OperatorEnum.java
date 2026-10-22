package org.apache.poi.ss.formula;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
final enum OperatorEnum extends Enum<OperatorEnum> {
    private static final /* synthetic */ OperatorEnum[] $VALUES = null;
    public static final OperatorEnum BETWEEN = null;
    public static final OperatorEnum EQUAL = null;
    public static final OperatorEnum GREATER_OR_EQUAL = null;
    public static final OperatorEnum GREATER_THAN = null;
    public static final OperatorEnum LESS_OR_EQUAL = null;
    public static final OperatorEnum LESS_THAN = null;
    public static final OperatorEnum NOT_BETWEEN = null;
    public static final OperatorEnum NOT_EQUAL = null;
    public static final OperatorEnum NO_COMPARISON = null;
    private final CompareOp compareOp;
    private final boolean validForIncompatibleTypes;

    private interface CompareOp {
        <C extends Comparable<C>> boolean isValid(C r1, C r2, C r3);
    }

    static {
        OperatorEnum r0 = new OperatorEnum("NO_COMPARISON", 0, $$Lambda$OperatorEnum$GeQz0mAk6FWLHvWoT1PkVGJbyFQ.INSTANCE, false);
        NO_COMPARISON = r0;
        OperatorEnum r1 = new OperatorEnum("BETWEEN", 1, $$Lambda$OperatorEnum$zlsP8tXOLyz0akViUJJiDOg5I.INSTANCE, false);
        BETWEEN = r1;
        OperatorEnum r2 = new OperatorEnum("NOT_BETWEEN", 2, $$Lambda$OperatorEnum$Mrs4laDP0usFBJ9c9XlDnvijul8.INSTANCE, true);
        NOT_BETWEEN = r2;
        OperatorEnum r4 = new OperatorEnum("EQUAL", 3, $$Lambda$OperatorEnum$G7pUxss2Vv6ZWemkgo2uKvxd7Fc.INSTANCE, false);
        EQUAL = r4;
        OperatorEnum r6 = new OperatorEnum("NOT_EQUAL", 4, $$Lambda$OperatorEnum$ZegmaD05E6fwDesUe2eG78o0bA.INSTANCE, true);
        NOT_EQUAL = r6;
        OperatorEnum r8 = new OperatorEnum("GREATER_THAN", 5, $$Lambda$OperatorEnum$t39HkhcI79Ok9rXztQC_5lOgEI.INSTANCE, false);
        GREATER_THAN = r8;
        OperatorEnum r10 = new OperatorEnum("LESS_THAN", 6, $$Lambda$OperatorEnum$UOD4cIk4NmW3Nfj2gCdIM33d04.INSTANCE, false);
        LESS_THAN = r10;
        OperatorEnum r12 = new OperatorEnum("GREATER_OR_EQUAL", 7, $$Lambda$OperatorEnum$iV1kfdtPbDJXRzVBx7ZaAFspXY.INSTANCE, false);
        GREATER_OR_EQUAL = r12;
        OperatorEnum r14 = new OperatorEnum("LESS_OR_EQUAL", 8, $$Lambda$OperatorEnum$gPQgp5zAwpyw0uDb8SCRzDPpOM.INSTANCE, false);
        LESS_OR_EQUAL = r14;
        $VALUES = new OperatorEnum[]{r0, r1, r2, r4, r6, r8, r10, r12, r14};
    }

    private OperatorEnum(String r3, int r4, CompareOp r5, boolean r6) {
        CompareOp r7 = (CompareOp) ZeusTransformUtils.wrapperContextForParams(r5, CompareOp.class, "com.obric.memorydata.plugin");
        super(r3, r4);
        this.compareOp = r7;
        this.validForIncompatibleTypes = r6;
    }

    private static <C extends Comparable<C>> boolean between(C r7, C r8, C r9) {
        Comparable r10 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r7, Comparable.class, "com.obric.memorydata.plugin");
        Comparable r11 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r8, Comparable.class, "com.obric.memorydata.plugin");
        Comparable r12 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r9, Comparable.class, "com.obric.memorydata.plugin");
        if (r11 != null) goto L33;
        if (ZeusTransformUtils.instanceOf(r10, Number.class) == false) goto L18;
        if (r12 != null) goto L9;
        double r13 = 0.0d;
    L11:
        if (Double.compare(((Number) ZeusTransformUtils.preCheckCast(r10, Number.class, "com.obric.memorydata.plugin")).doubleValue(), 0.0d) < 0) goto L16;
        if (Double.compare(((Number) ZeusTransformUtils.preCheckCast(r10, Number.class, "com.obric.memorydata.plugin")).doubleValue(), r13) > 0) goto L16;
        return true;
    L16:
        return false;
    L9:
        r13 = ((Number) ZeusTransformUtils.preCheckCast(r12, Number.class, "com.obric.memorydata.plugin")).doubleValue();
        goto L11
    L18:
        if (ZeusTransformUtils.instanceOf(r10, String.class) == true) goto L20;
        ZeusTransformUtils.instanceOf(r10, Boolean.class);
        return false;
    L20:
        if (r12 != null) goto L22;
        String r14 = "";
    L24:
        if (((String) ZeusTransformUtils.preCheckCast(r10, String.class, "com.obric.memorydata.plugin")).compareToIgnoreCase("") < 0) goto L29;
        if (((String) ZeusTransformUtils.preCheckCast(r10, String.class, "com.obric.memorydata.plugin")).compareToIgnoreCase(r14) > 0) goto L29;
        return true;
    L29:
        return false;
    L22:
        r14 = (String) ZeusTransformUtils.preCheckCast(r12, String.class, "com.obric.memorydata.plugin");
        goto L24
    L33:
        if (r10.compareTo(r11) < 0) goto L38;
        if (r10.compareTo(r12) > 0) goto L38;
        return true;
    L38:
        return false;
    }

    private static <C extends Comparable<C>> boolean equalCheck(C r3, C r4, C r5) {
        Comparable r6 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r3, Comparable.class, "com.obric.memorydata.plugin");
        Comparable r7 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r4, Comparable.class, "com.obric.memorydata.plugin");
        Comparable r8 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r5, Comparable.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L17;
        if (ZeusTransformUtils.instanceOf(r6, Number.class) == false) goto L12;
        if (Double.compare(((Number) ZeusTransformUtils.preCheckCast(r6, Number.class, "com.obric.memorydata.plugin")).doubleValue(), 0.0d) != 0) goto L10;
        return true;
    L10:
        return false;
    L12:
        if (ZeusTransformUtils.instanceOf(r6, String.class) == false) goto L14;
        return false;
    L14:
        ZeusTransformUtils.instanceOf(r6, Boolean.class);
        return false;
    L17:
        if (ZeusTransformUtils.instanceOf(r6, String.class) == false) goto L24;
        if (r6.toString().compareToIgnoreCase(r7.toString()) != 0) goto L22;
        return true;
    L22:
        return false;
    L24:
        if (r6.compareTo(r7) != 0) goto L27;
        return true;
    L27:
        return false;
    }

    private static <C extends Comparable<C>> boolean greaterOrEqual(C r3, C r4, C r5) {
        Comparable r6 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r3, Comparable.class, "com.obric.memorydata.plugin");
        Comparable r7 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r4, Comparable.class, "com.obric.memorydata.plugin");
        Comparable r8 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r5, Comparable.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L16;
        if (ZeusTransformUtils.instanceOf(r6, Number.class) == false) goto L11;
        if (Double.compare(((Number) ZeusTransformUtils.preCheckCast(r6, Number.class, "com.obric.memorydata.plugin")).doubleValue(), 0.0d) >= 0) goto L9;
        return false;
    L9:
        return true;
    L11:
        if (ZeusTransformUtils.instanceOf(r6, String.class) == false) goto L14;
        return true;
    L14:
        return ZeusTransformUtils.instanceOf(r6, Boolean.class);
    L16:
        if (r6.compareTo(r7) >= 0) goto L18;
        return false;
    L18:
        return true;
    }

    private static <C extends Comparable<C>> boolean greaterThan(C r3, C r4, C r5) {
        Comparable r6 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r3, Comparable.class, "com.obric.memorydata.plugin");
        Comparable r7 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r4, Comparable.class, "com.obric.memorydata.plugin");
        Comparable r8 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r5, Comparable.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L16;
        if (ZeusTransformUtils.instanceOf(r6, Number.class) == false) goto L11;
        if (Double.compare(((Number) ZeusTransformUtils.preCheckCast(r6, Number.class, "com.obric.memorydata.plugin")).doubleValue(), 0.0d) > 0) goto L9;
        return false;
    L9:
        return true;
    L11:
        if (ZeusTransformUtils.instanceOf(r6, String.class) == false) goto L14;
        return true;
    L14:
        return ZeusTransformUtils.instanceOf(r6, Boolean.class);
    L16:
        if (r6.compareTo(r7) > 0) goto L18;
        return false;
    L18:
        return true;
    }

    public static /* synthetic */ boolean lambda$G7pUxss2Vv6ZWemkgo2uKvxd7Fc(Comparable r0, Comparable r1, Comparable r2) {
        return equalCheck(r0, r1, r2);
    }

    public static /* synthetic */ boolean lambda$GeQz0mAk6FWLHvWoT1PkVGJbyFQ(Comparable r0, Comparable r1, Comparable r2) {
        return noComp(r0, r1, r2);
    }

    public static /* synthetic */ boolean lambda$Mrs4laDP0usFBJ9c9XlDnvijul8(Comparable r0, Comparable r1, Comparable r2) {
        return notBetween(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$UOD4-cIk4NmW3Nfj2gCdIM33d04, reason: not valid java name */
    public static /* synthetic */ boolean m3174lambda$UOD4cIk4NmW3Nfj2gCdIM33d04(Comparable r0, Comparable r1, Comparable r2) {
        return lessThan(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$ZegmaD05E6fwD-esUe2eG78o0bA, reason: not valid java name */
    public static /* synthetic */ boolean m3175lambda$ZegmaD05E6fwDesUe2eG78o0bA(Comparable r0, Comparable r1, Comparable r2) {
        return notEqual(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$gPQgp5zAwpyw0uDb8SC-RzDPpOM, reason: not valid java name */
    public static /* synthetic */ boolean m3176lambda$gPQgp5zAwpyw0uDb8SCRzDPpOM(Comparable r0, Comparable r1, Comparable r2) {
        return lessOrEqual(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$iV1kfdtPbDJX-RzVBx7ZaAFspXY, reason: not valid java name */
    public static /* synthetic */ boolean m3177lambda$iV1kfdtPbDJXRzVBx7ZaAFspXY(Comparable r0, Comparable r1, Comparable r2) {
        return greaterOrEqual(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$t39HkhcI79Ok-9rXztQC_5lOgEI, reason: not valid java name */
    public static /* synthetic */ boolean m3178lambda$t39HkhcI79Ok9rXztQC_5lOgEI(Comparable r0, Comparable r1, Comparable r2) {
        return greaterThan(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$zlsP8tXOLyz0akViUJJ-iDOg-5I, reason: not valid java name */
    public static /* synthetic */ boolean m3179lambda$zlsP8tXOLyz0akViUJJiDOg5I(Comparable r0, Comparable r1, Comparable r2) {
        return between(r0, r1, r2);
    }

    private static <C extends Comparable<C>> boolean lessOrEqual(C r3, C r4, C r5) {
        Comparable r6 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r3, Comparable.class, "com.obric.memorydata.plugin");
        Comparable r7 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r4, Comparable.class, "com.obric.memorydata.plugin");
        Comparable r8 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r5, Comparable.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L17;
        if (ZeusTransformUtils.instanceOf(r6, Number.class) == false) goto L12;
        if (Double.compare(((Number) ZeusTransformUtils.preCheckCast(r6, Number.class, "com.obric.memorydata.plugin")).doubleValue(), 0.0d) > 0) goto L10;
        return true;
    L10:
        return false;
    L12:
        if (ZeusTransformUtils.instanceOf(r6, String.class) == false) goto L14;
        return false;
    L14:
        ZeusTransformUtils.instanceOf(r6, Boolean.class);
        return false;
    L17:
        if (r6.compareTo(r7) > 0) goto L20;
        return true;
    L20:
        return false;
    }

    private static <C extends Comparable<C>> boolean lessThan(C r3, C r4, C r5) {
        Comparable r6 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r3, Comparable.class, "com.obric.memorydata.plugin");
        Comparable r7 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r4, Comparable.class, "com.obric.memorydata.plugin");
        Comparable r8 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r5, Comparable.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L17;
        if (ZeusTransformUtils.instanceOf(r6, Number.class) == false) goto L12;
        if (Double.compare(((Number) ZeusTransformUtils.preCheckCast(r6, Number.class, "com.obric.memorydata.plugin")).doubleValue(), 0.0d) >= 0) goto L10;
        return true;
    L10:
        return false;
    L12:
        if (ZeusTransformUtils.instanceOf(r6, String.class) == false) goto L14;
        return false;
    L14:
        ZeusTransformUtils.instanceOf(r6, Boolean.class);
        return false;
    L17:
        if (r6.compareTo(r7) >= 0) goto L20;
        return true;
    L20:
        return false;
    }

    private static <C extends Comparable<C>> boolean noComp(C r2, C r3, C r4) {
        Comparable r5 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r2, Comparable.class, "com.obric.memorydata.plugin");
        Comparable r6 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r3, Comparable.class, "com.obric.memorydata.plugin");
        Comparable r7 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r4, Comparable.class, "com.obric.memorydata.plugin");
        return false;
    }

    private static <C extends Comparable<C>> boolean notBetween(C r7, C r8, C r9) {
        Comparable r10 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r7, Comparable.class, "com.obric.memorydata.plugin");
        Comparable r11 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r8, Comparable.class, "com.obric.memorydata.plugin");
        Comparable r12 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r9, Comparable.class, "com.obric.memorydata.plugin");
        if (r11 != null) goto L31;
        if (ZeusTransformUtils.instanceOf(r10, Number.class) == false) goto L17;
        if (r12 != null) goto L9;
        double r13 = 0.0d;
    L11:
        if (Double.compare(((Number) ZeusTransformUtils.preCheckCast(r10, Number.class, "com.obric.memorydata.plugin")).doubleValue(), 0.0d) < 0) goto L15;
        if (Double.compare(((Number) ZeusTransformUtils.preCheckCast(r10, Number.class, "com.obric.memorydata.plugin")).doubleValue(), r13) > 0) goto L15;
        return false;
    L15:
        return true;
    L9:
        r13 = ((Number) ZeusTransformUtils.preCheckCast(r12, Number.class, "com.obric.memorydata.plugin")).doubleValue();
        goto L11
    L17:
        if (ZeusTransformUtils.instanceOf(r10, String.class) == false) goto L29;
        if (r12 != null) goto L21;
        String r14 = "";
    L23:
        if (((String) ZeusTransformUtils.preCheckCast(r10, String.class, "com.obric.memorydata.plugin")).compareToIgnoreCase("") < 0) goto L27;
        if (((String) ZeusTransformUtils.preCheckCast(r10, String.class, "com.obric.memorydata.plugin")).compareToIgnoreCase(r14) > 0) goto L27;
        return false;
    L27:
        return true;
    L21:
        r14 = (String) ZeusTransformUtils.preCheckCast(r12, String.class, "com.obric.memorydata.plugin");
        goto L23
    L29:
        return ZeusTransformUtils.instanceOf(r10, Boolean.class);
    L31:
        if (r10.compareTo(r11) < 0) goto L35;
        if (r10.compareTo(r12) > 0) goto L35;
        return false;
    L35:
        return true;
    }

    private static <C extends Comparable<C>> boolean notEqual(C r2, C r3, C r4) {
        Comparable r5 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r2, Comparable.class, "com.obric.memorydata.plugin");
        Comparable r6 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r3, Comparable.class, "com.obric.memorydata.plugin");
        Comparable r7 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r4, Comparable.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, String.class) == false) goto L13;
        if (r5.toString().compareToIgnoreCase(r6.toString()) != 0) goto L11;
        return true;
    L11:
        return false;
    L13:
        if (r5.compareTo(r6) == 0) goto L16;
        return true;
    L16:
        return false;
    }

    public static OperatorEnum valueOf(String r2) {
        return (OperatorEnum) ZeusTransformUtils.preCheckCast(Enum.valueOf(OperatorEnum.class, r2), OperatorEnum.class, "com.obric.memorydata.plugin");
    }

    public static OperatorEnum[] values() {
        return (OperatorEnum[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), OperatorEnum[].class, "com.obric.memorydata.plugin");
    }

    /* JADX WARN: Multi-variable type inference failed */
    <C extends Comparable<C>> boolean isValid(C r3, C r4, C r5) {
        Comparable r6 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r3, Comparable.class, "com.obric.memorydata.plugin");
        Comparable r7 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r4, Comparable.class, "com.obric.memorydata.plugin");
        Comparable r8 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r5, Comparable.class, "com.obric.memorydata.plugin");
        return this.compareOp.isValid(r6, r7, r8);
    }

    boolean isValidForIncompatibleTypes() {
        return this.validForIncompatibleTypes;
    }
}
