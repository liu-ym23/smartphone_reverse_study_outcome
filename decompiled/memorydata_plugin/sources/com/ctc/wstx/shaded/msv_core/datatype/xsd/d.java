package com.ctc.wstx.shaded.msv_core.datatype.xsd;

import com.ctc.wstx.shaded.msv.relaxng_datatype.DatatypeException;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

/* JADX INFO: loaded from: classes2.dex */
public class d {
    private static final String[][] c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map f3570a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final XSDatatypeImpl f3571b;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f3572a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f3573b;

        public a(Object r1, boolean r2) {
            this.f3572a = r1;
            this.f3573b = r2;
        }
    }

    static {
        c = new String[][]{new String[]{XSDatatype.FACET_LENGTH, XSDatatype.FACET_MINLENGTH}, new String[]{XSDatatype.FACET_LENGTH, XSDatatype.FACET_MAXLENGTH}, new String[]{XSDatatype.FACET_MAXINCLUSIVE, XSDatatype.FACET_MAXEXCLUSIVE}, new String[]{XSDatatype.FACET_MININCLUSIVE, XSDatatype.FACET_MINEXCLUSIVE}};
    }

    public d(XSDatatype r3) {
        XSDatatype r4 = (XSDatatype) ZeusTransformUtils.wrapperContextForParams(r3, XSDatatype.class, "com.obric.memorydata.plugin");
        this.f3570a = new HashMap();
        this.f3571b = (XSDatatypeImpl) ZeusTransformUtils.preCheckCast(r4, XSDatatypeImpl.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L6;
        return;
    L6:
        throw new IllegalArgumentException();
    }

    private static DatatypeException a(String r3, DataTypeWithFacet r4, String r5, DataTypeWithFacet r6, String r7) {
        String r0 = r4.getName();
        String r1 = r6.getName();
        if (r0.equals(r1) == false) goto L7;
        return new DatatypeException(XSDatatypeImpl.localize(XSDatatypeImpl.ERR_INCONSISTENT_FACETS_1, r5, r7));
    L7:
        if (r0.equals(r3) == false) goto L11;
        return new DatatypeException(XSDatatypeImpl.localize(XSDatatypeImpl.ERR_INCONSISTENT_FACETS_2, r5, r6.displayName(), r7));
    L11:
        if (r1.equals(r3) == false) goto L15;
        return new DatatypeException(XSDatatypeImpl.localize(XSDatatypeImpl.ERR_INCONSISTENT_FACETS_2, r7, r4.displayName(), r5));
    L15:
        throw new IllegalStateException();
    }

    private static void a(XSDatatypeImpl r6, String r7, String r8) {
        DataTypeWithFacet r0 = r6.getFacetObject(r7);
        DataTypeWithFacet r1 = r6.getFacetObject(r8);
        if (r0 == null) goto L10;
        if (r1 != null) goto L6;
        return;
    L6:
        if (((com.ctc.wstx.shaded.msv_core.datatype.xsd.a) ZeusTransformUtils.preCheckCast(r0.getConcreteType(), com.ctc.wstx.shaded.msv_core.datatype.xsd.a.class, "com.obric.memorydata.plugin")).compare(((RangeFacet) ZeusTransformUtils.preCheckCast(r0, RangeFacet.class, "com.obric.memorydata.plugin")).limitValue, ((RangeFacet) ZeusTransformUtils.preCheckCast(r1, RangeFacet.class, "com.obric.memorydata.plugin")).limitValue) == 1) goto L9;
        return;
    L9:
        throw a(r6.displayName(), r0, r7, r1, r8);
    }

    private static boolean f(String r1) {
        if (r1.equals(XSDatatype.FACET_ENUMERATION) == false) goto L5;
    L14:
        return true;
    L5:
        if (r1.equals(XSDatatype.FACET_MAXEXCLUSIVE) == true) goto L14;
        if (r1.equals(XSDatatype.FACET_MINEXCLUSIVE) == true) goto L14;
        if (r1.equals(XSDatatype.FACET_MAXINCLUSIVE) == true) goto L14;
        if (r1.equals(XSDatatype.FACET_MININCLUSIVE) == true) goto L14;
        return false;
    }

    private static boolean g(String r1) {
        if (r1.equals(XSDatatype.FACET_ENUMERATION) == false) goto L5;
    L8:
        return true;
    L5:
        if (r1.equals(XSDatatype.FACET_PATTERN) == true) goto L8;
        return false;
    }

    private boolean h(String r1) {
        return this.f3570a.containsKey(r1);
    }

    public XSDatatypeImpl a(String r18, String r19) {
        if (ZeusTransformUtils.instanceOf(this.f3571b, ErrorType.class) == false) goto L7;
        return this.f3571b;
    L7:
        if (this.f3571b.isFinal(1) == true) goto L83;
        if (a() == false) goto L16;
        if (r18 != null) goto L15;
        if (r19 != null) goto L15;
        return this.f3571b;
    L15:
        return new FinalComponent(r18, r19, this.f3571b, 0);
    L16:
        XSDatatypeImpl r4 = this.f3571b;
        int r1 = 0;
    L17:
        String[][] r5 = c;
        if (r1 >= r5.length) goto L28;
        if (h(r5[r1][0]) == false) goto L26;
        if (h(r5[r1][1]) == false) goto L26;
        throw new DatatypeException(XSDatatypeImpl.localize(XSDatatypeImpl.ERR_X_AND_Y_ARE_EXCLUSIVE, r5[r1][0], r5[r1][1]));
    L26:
        r1 = r1 + 1;
        goto L17
    L28:
        if (h(XSDatatype.FACET_TOTALDIGITS) == false) goto L31;
        r4 = new TotalDigitsFacet(r18, r19, r4, d(XSDatatype.FACET_TOTALDIGITS), a(XSDatatype.FACET_TOTALDIGITS));
    L31:
        if (h(XSDatatype.FACET_FRACTIONDIGITS) == false) goto L34;
        r4 = new FractionDigitsFacet(r18, r19, r4, e(XSDatatype.FACET_FRACTIONDIGITS), a(XSDatatype.FACET_FRACTIONDIGITS));
    L34:
        if (h(XSDatatype.FACET_MININCLUSIVE) == false) goto L37;
        r4 = new MinInclusiveFacet(r18, r19, r4, b(XSDatatype.FACET_MININCLUSIVE), a(XSDatatype.FACET_MININCLUSIVE));
    L37:
        if (h(XSDatatype.FACET_MAXINCLUSIVE) == false) goto L40;
        r4 = new MaxInclusiveFacet(r18, r19, r4, b(XSDatatype.FACET_MAXINCLUSIVE), a(XSDatatype.FACET_MAXINCLUSIVE));
    L40:
        if (h(XSDatatype.FACET_MINEXCLUSIVE) == false) goto L43;
        r4 = new MinExclusiveFacet(r18, r19, r4, b(XSDatatype.FACET_MINEXCLUSIVE), a(XSDatatype.FACET_MINEXCLUSIVE));
    L43:
        if (h(XSDatatype.FACET_MAXEXCLUSIVE) == false) goto L46;
        r4 = new MaxExclusiveFacet(r18, r19, r4, b(XSDatatype.FACET_MAXEXCLUSIVE), a(XSDatatype.FACET_MAXEXCLUSIVE));
    L46:
        if (h(XSDatatype.FACET_LENGTH) == false) goto L49;
        r4 = new LengthFacet(r18, r19, r4, this);
    L49:
        if (h(XSDatatype.FACET_MINLENGTH) == false) goto L52;
        r4 = new MinLengthFacet(r18, r19, r4, this);
    L52:
        if (h(XSDatatype.FACET_MAXLENGTH) == false) goto L55;
        r4 = new MaxLengthFacet(r18, r19, r4, this);
    L55:
        if (h(XSDatatype.FACET_WHITESPACE) == false) goto L58;
        r4 = new WhiteSpaceFacet(r18, r19, r4, this);
    L58:
        if (h(XSDatatype.FACET_PATTERN) == false) goto L60;
        XSDatatypeImpl r3 = new PatternFacet(r18, r19, r4, this);
    L62:
        if (h(XSDatatype.FACET_ENUMERATION) == false) goto L64;
        r3 = new EnumerationFacet(r18, r19, r3, c(XSDatatype.FACET_ENUMERATION), a(XSDatatype.FACET_ENUMERATION));
    L64:
        DataTypeWithFacet r0 = r3.getFacetObject(XSDatatype.FACET_MAXLENGTH);
        DataTypeWithFacet r2 = r3.getFacetObject(XSDatatype.FACET_MINLENGTH);
        if (r0 == null) goto L72;
        if (r2 == null) goto L72;
        if (((MaxLengthFacet) ZeusTransformUtils.preCheckCast(r0, MaxLengthFacet.class, "com.obric.memorydata.plugin")).maxLength >= ((MinLengthFacet) ZeusTransformUtils.preCheckCast(r2, MinLengthFacet.class, "com.obric.memorydata.plugin")).minLength) goto L72;
        throw a(r19, r0, XSDatatype.FACET_MAXLENGTH, r2, XSDatatype.FACET_MINLENGTH);
    L72:
        DataTypeWithFacet r6 = r3.getFacetObject(XSDatatype.FACET_FRACTIONDIGITS);
        DataTypeWithFacet r7 = r3.getFacetObject(XSDatatype.FACET_TOTALDIGITS);
        if (r6 == null) goto L80;
        if (r7 == null) goto L80;
        if (((FractionDigitsFacet) ZeusTransformUtils.preCheckCast(r6, FractionDigitsFacet.class, "com.obric.memorydata.plugin")).scale <= ((TotalDigitsFacet) ZeusTransformUtils.preCheckCast(r7, TotalDigitsFacet.class, "com.obric.memorydata.plugin")).precision) goto L80;
        throw a(r19, r6, XSDatatype.FACET_FRACTIONDIGITS, r7, XSDatatype.FACET_TOTALDIGITS);
    L80:
        a(r3, XSDatatype.FACET_MININCLUSIVE, XSDatatype.FACET_MAXINCLUSIVE);
        a(r3, XSDatatype.FACET_MINEXCLUSIVE, XSDatatype.FACET_MAXEXCLUSIVE);
        a(r3, XSDatatype.FACET_MININCLUSIVE, XSDatatype.FACET_MAXEXCLUSIVE);
        a(r3, XSDatatype.FACET_MINEXCLUSIVE, XSDatatype.FACET_MAXINCLUSIVE);
        return r3;
    L60:
        r3 = r4;
        goto L62
    L83:
        throw new DatatypeException(XSDatatypeImpl.localize(XSDatatypeImpl.ERR_INVALID_BASE_TYPE, this.f3571b.displayName()));
    }

    public void a(String r4, String r5, boolean r6, com.ctc.wstx.shaded.msv.relaxng_datatype.e r7) {
        com.ctc.wstx.shaded.msv.relaxng_datatype.e r8 = (com.ctc.wstx.shaded.msv.relaxng_datatype.e) ZeusTransformUtils.wrapperContextForParams(r7, com.ctc.wstx.shaded.msv.relaxng_datatype.e.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(this.f3571b, ErrorType.class) == false) goto L5;
        return;
    L5:
        int r0 = this.f3571b.isFacetApplicable(r4);
        if (r0 == (-2)) goto L34;
        if (r0 == (-1)) goto L32;
        if (r0 != 0) goto L31;
        Object r9 = r5;
        if (f(r4) == false) goto L18;
        Object r10 = this.f3571b.createValue(r5, r8);
        if (r10 == null) goto L16;
        r9 = r10;
        goto L18
    L16:
        throw new DatatypeException(XSDatatypeImpl.localize(XSDatatypeImpl.ERR_INVALID_VALUE_FOR_THIS_TYPE, r5, this.f3571b.displayName()));
    L18:
        if (g(r4) == false) goto L25;
        boolean r11 = this.f3570a.containsKey(r4);
        Map r3 = this.f3570a;
        if (r11 == false) goto L22;
        a r12 = (a) ZeusTransformUtils.preCheckCast(r3.get(r4), a.class, "com.obric.memorydata.plugin");
    L23:
        ((Vector) ZeusTransformUtils.preCheckCast(r12.f3572a, Vector.class, "com.obric.memorydata.plugin")).add(r9);
        r12.f3573b |= r6;
        return;
    L22:
        a r13 = new a(new Vector(), r6);
        r3.put(r4, r13);
        r12 = r13;
        goto L23
    L25:
        if (this.f3570a.containsKey(r4) == true) goto L29;
        this.f3570a.put(r4, new a(r9, r6));
        return;
    L29:
        throw new DatatypeException(XSDatatypeImpl.localize(XSDatatypeImpl.ERR_DUPLICATE_FACET, r4));
    L31:
        throw new Error();
    L32:
        return;
    L34:
        throw new DatatypeException(XSDatatypeImpl.localize(XSDatatypeImpl.ERR_NOT_APPLICABLE_FACET, r4));
    }

    public boolean a() {
        return this.f3570a.isEmpty();
    }

    public boolean a(String r2) {
        return ((a) ZeusTransformUtils.preCheckCast(this.f3570a.get(r2), a.class, "com.obric.memorydata.plugin")).f3573b;
    }

    public Object b(String r2) {
        return ((a) ZeusTransformUtils.preCheckCast(this.f3570a.get(r2), a.class, "com.obric.memorydata.plugin")).f3572a;
    }

    public Vector c(String r2) {
        return (Vector) ZeusTransformUtils.preCheckCast(((a) ZeusTransformUtils.preCheckCast(this.f3570a.get(r2), a.class, "com.obric.memorydata.plugin")).f3572a, Vector.class, "com.obric.memorydata.plugin");
    }

    public int d(String r4) {
        int r3 = Integer.parseInt((String) ZeusTransformUtils.preCheckCast(b(r4), String.class, "com.obric.memorydata.plugin"));     // Catch: NumberFormatException -> L6
        if (r3 <= 0) goto L11;
        return r3;
    L6:
        if (new BigInteger((String) ZeusTransformUtils.preCheckCast(b(r4), String.class, "com.obric.memorydata.plugin")).signum() <= 0) goto L11;
        return Integer.MAX_VALUE;
    L11:
        throw new DatatypeException(XSDatatypeImpl.localize(XSDatatypeImpl.ERR_FACET_MUST_BE_POSITIVE_INTEGER, r4));
    }

    public int e(String r3) {
        int r2 = Integer.parseInt((String) ZeusTransformUtils.preCheckCast(b(r3), String.class, "com.obric.memorydata.plugin"));     // Catch: NumberFormatException -> L7
        if (r2 < 0) goto L6;
        return r2;
    L6:
        throw new DatatypeException(XSDatatypeImpl.localize(XSDatatypeImpl.ERR_FACET_MUST_BE_NON_NEGATIVE_INTEGER, r3));
    }
}
