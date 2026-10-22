package com.ctc.wstx.shaded.msv_core.datatype.xsd;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public interface XSDatatype extends com.ctc.wstx.shaded.msv_core.datatype.a, Serializable {
    public static final int APPLICABLE = 0;
    public static final int DERIVATION_BY_LIST = 2;
    public static final int DERIVATION_BY_RESTRICTION = 1;
    public static final int DERIVATION_BY_UNION = 4;
    public static final String FACET_ENUMERATION = "enumeration";
    public static final String FACET_FRACTIONDIGITS = "fractionDigits";
    public static final String FACET_LENGTH = "length";
    public static final String FACET_MAXEXCLUSIVE = "maxExclusive";
    public static final String FACET_MAXINCLUSIVE = "maxInclusive";
    public static final String FACET_MAXLENGTH = "maxLength";
    public static final String FACET_MINEXCLUSIVE = "minExclusive";
    public static final String FACET_MININCLUSIVE = "minInclusive";
    public static final String FACET_MINLENGTH = "minLength";
    public static final String FACET_PATTERN = "pattern";
    public static final String FACET_TOTALDIGITS = "totalDigits";
    public static final String FACET_WHITESPACE = "whiteSpace";
    public static final int FIXED = -1;
    public static final int NOT_ALLOWED = -2;
    public static final int VARIETY_ATOMIC = 1;
    public static final int VARIETY_LIST = 2;
    public static final int VARIETY_UNION = 3;
    public static final String XMLSCHEMA_NSURI = "http://www.w3.org/2001/XMLSchema";

    String convertToLexicalValue(Object r1, com.ctc.wstx.shaded.msv_core.datatype.c r2);

    String displayName();

    XSDatatype getAncestorBuiltinType();

    String[] getApplicableFacetNames();

    XSDatatype getBaseType();

    DataTypeWithFacet getFacetObject(String r1);

    String getName();

    String getNamespaceUri();

    int getVariety();

    boolean isAlwaysValid();

    boolean isDerivedTypeOf(XSDatatype r1, boolean r2);

    int isFacetApplicable(String r1);

    boolean isFinal(int r1);
}
