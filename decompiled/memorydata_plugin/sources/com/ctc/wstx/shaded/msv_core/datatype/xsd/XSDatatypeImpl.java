package com.ctc.wstx.shaded.msv_core.datatype.xsd;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.text.MessageFormat;
import java.util.ResourceBundle;
import java.util.Vector;

/* JADX INFO: loaded from: classes2.dex */
public abstract class XSDatatypeImpl implements XSDatatype {
    public static final String ERR_DUPLICATE_FACET = "BadTypeException.DuplicateFacet";
    public static final String ERR_EMPTY_UNION = "BadTypeException.EmptyUnion";
    public static final String ERR_ENUMERATION = "DataTypeErrorDiagnosis.Enumeration";
    public static final String ERR_ENUMERATION_WITH_ARG = "DataTypeErrorDiagnosis.Enumeration.Arg";
    public static final String ERR_FACET_MUST_BE_NON_NEGATIVE_INTEGER = "BadTypeException.FacetMustBeNonNegativeInteger";
    public static final String ERR_FACET_MUST_BE_POSITIVE_INTEGER = "BadTypeException.FacetMustBePositiveInteger";
    public static final String ERR_INAPPROPRIATE_FOR_TYPE = "DataTypeErrorDiagnosis.InappropriateForType";
    public static final String ERR_INCONSISTENT_FACETS_1 = "InconsistentFacets.1";
    public static final String ERR_INCONSISTENT_FACETS_2 = "InconsistentFacets.2";
    public static final String ERR_INVALID_BASE_TYPE = "BadTypeException.InvalidBaseType";
    public static final String ERR_INVALID_ITEMTYPE = "BadTypeException.InvalidItemType";
    public static final String ERR_INVALID_MEMBER_TYPE = "BadTypeException.InvalidMemberType";
    public static final String ERR_INVALID_VALUE_FOR_THIS_TYPE = "EnumerationFacet.InvalidValueForThisType";
    public static final String ERR_INVALID_WHITESPACE_VALUE = "WhiteSpaceProcessor.InvalidWhiteSpaceValue";
    public static final String ERR_LENGTH = "DataTypeErrorDiagnosis.Length";
    public static final String ERR_LOOSENED_FACET = "LoosenedFacet";
    public static final String ERR_MAXLENGTH = "DataTypeErrorDiagnosis.MaxLength";
    public static final String ERR_MINLENGTH = "DataTypeErrorDiagnosis.MinLength";
    public static final String ERR_NOT_APPLICABLE_FACET = "BadTypeException.NotApplicableFacet";
    public static final String ERR_OUT_OF_RANGE = "DataTypeErrorDiagnosis.OutOfRange";
    public static final String ERR_OVERRIDING_FIXED_FACET = "BadTypeException.OverridingFixedFacet";
    public static final String ERR_PARSE_ERROR = "PatternFacet.ParseError";
    public static final String ERR_PATTERN_1 = "DataTypeErrorDiagnosis.Pattern.1";
    public static final String ERR_PATTERN_MANY = "DataTypeErrorDiagnosis.Pattern.Many";
    public static final String ERR_SCALE_IS_GREATER_THAN_PRECISION = "PrecisionScaleFacet.ScaleIsGraterThanPrecision";
    public static final String ERR_TOO_MUCH_PRECISION = "DataTypeErrorDiagnosis.TooMuchPrecision";
    public static final String ERR_TOO_MUCH_SCALE = "DataTypeErrorDiagnosis.TooMuchScale";
    public static final String ERR_X_AND_Y_ARE_EXCLUSIVE = "XAndYAreExclusive";
    private static final long serialVersionUID = 1;
    protected static final com.ctc.wstx.shaded.msv.relaxng_datatype.e serializedValueChecker = null;
    private final String namespaceUri;
    private final String typeName;
    public final WhiteSpaceProcessor whiteSpace;

    static {
        serializedValueChecker = new AnonymousClass1();
    }

    public XSDatatypeImpl(String r1, String r2, WhiteSpaceProcessor r3) {
        this.namespaceUri = r1;
        this.typeName = r2;
        this.whiteSpace = r3;
    }

    public static boolean isDerivedTypeOf(XSDatatype r5, XSDatatype r6, boolean r7) {
        XSDatatype r8 = (XSDatatype) ZeusTransformUtils.wrapperContextForParams(r5, XSDatatype.class, "com.obric.memorydata.plugin");
        XSDatatype r9 = (XSDatatype) ZeusTransformUtils.wrapperContextForParams(r6, XSDatatype.class, "com.obric.memorydata.plugin");
        if (r8 != r9) goto L6;
        return true;
    L6:
        if (r7 == true) goto L9;
        return false;
    L9:
        if (r8 != SimpleURType.theInstance) goto L12;
        return true;
    L12:
        if (r8.getVariety() != 3) goto L25;
        XSDatatype r3 = r8;
    L15:
        if (ZeusTransformUtils.instanceOf(r3, UnionType.class) == true) goto L17;
        r3 = r3.getBaseType();
        goto L15
    L17:
        XSDatatypeImpl[] r1 = ((UnionType) ZeusTransformUtils.preCheckCast(r3, UnionType.class, "com.obric.memorydata.plugin")).memberTypes;
        int r4 = 0;
    L19:
        if (r4 >= r1.length) goto L25;
        if (isDerivedTypeOf(r1[r4], r9, r7) == true) goto L22;
        r4 = r4 + 1;
        goto L19
    L22:
        return true;
    L25:
        if (r9 == SimpleURType.theInstance) goto L29;
        if (r8 == r9) goto L27;
        r9 = r9.getBaseType();
        goto L25
    L27:
        return true;
    L29:
        return false;
    }

    public static String localize(String r1) {
        return localize(r1, null);
    }

    public static String localize(String r2, Object r3) {
        return localize(r2, new Object[]{r3});
    }

    public static String localize(String r2, Object r3, Object r4) {
        return localize(r2, new Object[]{r3, r4});
    }

    public static String localize(String r2, Object r3, Object r4, Object r5) {
        return localize(r2, new Object[]{r3, r4, r5});
    }

    public static String localize(String r1, Object[] r2) {
        return MessageFormat.format(ResourceBundle.getBundle("com.ctc.wstx.shaded.msv_core.datatype.xsd.Messages").getString(r1), r2);
    }

    public abstract void _checkValid(String r1, com.ctc.wstx.shaded.msv.relaxng_datatype.e r2);

    public abstract Object _createJavaObject(String r1, com.ctc.wstx.shaded.msv.relaxng_datatype.e r2);

    public abstract Object _createValue(String r1, com.ctc.wstx.shaded.msv.relaxng_datatype.e r2);

    public abstract boolean checkFormat(String r1, com.ctc.wstx.shaded.msv.relaxng_datatype.e r2);

    @Override // com.ctc.wstx.shaded.msv.relaxng_datatype.a
    public final void checkValid(String r3, com.ctc.wstx.shaded.msv.relaxng_datatype.e r4) {
        com.ctc.wstx.shaded.msv.relaxng_datatype.e r5 = (com.ctc.wstx.shaded.msv.relaxng_datatype.e) ZeusTransformUtils.wrapperContextForParams(r4, com.ctc.wstx.shaded.msv.relaxng_datatype.e.class, "com.obric.memorydata.plugin");
        _checkValid(this.whiteSpace.process(r3), r5);
    }

    public final Object createJavaObject(String r3, com.ctc.wstx.shaded.msv.relaxng_datatype.e r4) {
        com.ctc.wstx.shaded.msv.relaxng_datatype.e r5 = (com.ctc.wstx.shaded.msv.relaxng_datatype.e) ZeusTransformUtils.wrapperContextForParams(r4, com.ctc.wstx.shaded.msv.relaxng_datatype.e.class, "com.obric.memorydata.plugin");
        return _createJavaObject(this.whiteSpace.process(r3), r5);
    }

    public com.ctc.wstx.shaded.msv.relaxng_datatype.d createStreamingValidator(com.ctc.wstx.shaded.msv.relaxng_datatype.e r3) {
        return new com.ctc.wstx.shaded.msv.relaxng_datatype.a.a(this, (com.ctc.wstx.shaded.msv.relaxng_datatype.e) ZeusTransformUtils.wrapperContextForParams(r3, com.ctc.wstx.shaded.msv.relaxng_datatype.e.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.ctc.wstx.shaded.msv.relaxng_datatype.a
    public final Object createValue(String r3, com.ctc.wstx.shaded.msv.relaxng_datatype.e r4) {
        com.ctc.wstx.shaded.msv.relaxng_datatype.e r5 = (com.ctc.wstx.shaded.msv.relaxng_datatype.e) ZeusTransformUtils.wrapperContextForParams(r4, com.ctc.wstx.shaded.msv.relaxng_datatype.e.class, "com.obric.memorydata.plugin");
        return _createValue(this.whiteSpace.process(r3), r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype
    public XSDatatype getAncestorBuiltinType() {
    L3:
        if ("http://www.w3.org/2001/XMLSchema".equals(r2.getNamespaceUri()) == true) goto L5;
        ?? r2 = r2.getBaseType();
        goto L3
    L5:
        return r2;
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype
    public String[] getApplicableFacetNames() {
        Vector r0 = new Vector();
        String[] r1 = {XSDatatype.FACET_ENUMERATION, XSDatatype.FACET_FRACTIONDIGITS, XSDatatype.FACET_TOTALDIGITS, XSDatatype.FACET_LENGTH, XSDatatype.FACET_MINLENGTH, XSDatatype.FACET_MAXLENGTH, XSDatatype.FACET_MAXEXCLUSIVE, XSDatatype.FACET_MINEXCLUSIVE, XSDatatype.FACET_MAXINCLUSIVE, XSDatatype.FACET_MININCLUSIVE, XSDatatype.FACET_PATTERN, XSDatatype.FACET_WHITESPACE};
        int r2 = 0;
    L4:
        if (r2 >= 12) goto L10;
        if (isFacetApplicable(r1[r2]) != 0) goto L8;
        r0.add(r1[r2]);
    L8:
        r2 = r2 + 1;
        goto L4
    L10:
        return (String[]) ZeusTransformUtils.preCheckCast((String[]) ZeusTransformUtils.preCheckCast(r0.toArray(new String[r0.size()]), String[].class, "com.obric.memorydata.plugin"), String[].class, "com.obric.memorydata.plugin");
    }

    public abstract ConcreteType getConcreteType();

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype
    public DataTypeWithFacet getFacetObject(String r1) {
        XSDatatype r0 = getBaseType();
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.getFacetObject(r1);
    }

    @Override // com.ctc.wstx.shaded.msv.relaxng_datatype.a
    public int getIdType() {
        return 0;
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype
    public String getName() {
        return this.typeName;
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype
    public String getNamespaceUri() {
        return this.namespaceUri;
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype
    public boolean isAlwaysValid() {
        return false;
    }

    public boolean isContextDependent() {
        return false;
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype
    public final boolean isDerivedTypeOf(XSDatatype r3, boolean r4) {
        return isDerivedTypeOf((XSDatatype) ZeusTransformUtils.wrapperContextForParams(r3, XSDatatype.class, "com.obric.memorydata.plugin"), this, r4);
    }

    @Override // com.ctc.wstx.shaded.msv.relaxng_datatype.a
    public final boolean isValid(String r3, com.ctc.wstx.shaded.msv.relaxng_datatype.e r4) {
        com.ctc.wstx.shaded.msv.relaxng_datatype.e r5 = (com.ctc.wstx.shaded.msv.relaxng_datatype.e) ZeusTransformUtils.wrapperContextForParams(r4, com.ctc.wstx.shaded.msv.relaxng_datatype.e.class, "com.obric.memorydata.plugin");
        String r6 = this.whiteSpace.process(r3);
        if (needValueCheck() == false) goto L10;
        if (_createValue(r6, r5) == null) goto L7;
        return true;
    L7:
        return false;
    L10:
        return checkFormat(r6, r5);
    }

    public boolean needValueCheck() {
        return false;
    }

    @Override // com.ctc.wstx.shaded.msv.relaxng_datatype.a
    public final boolean sameValue(Object r1, Object r2) {
        if (r1 == null) goto L7;
        if (r2 != null) goto L6;
        return false;
    L6:
        return r1.equals(r2);
    L7:
        return false;
    }

    @Override // com.ctc.wstx.shaded.msv.relaxng_datatype.a
    public final int valueHashCode(Object r1) {
        return r1.hashCode();
    }
}
