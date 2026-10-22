package org.apache.xmlbeans.impl.schema;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigInteger;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.xml.namespace.QName;
import okhttp3.internal.ws.WebSocketProtocol;
import org.apache.xmlbeans.QNameSet;
import org.apache.xmlbeans.SchemaAnnotation;
import org.apache.xmlbeans.SchemaAttributeGroup;
import org.apache.xmlbeans.SchemaComponent;
import org.apache.xmlbeans.SchemaGlobalAttribute;
import org.apache.xmlbeans.SchemaGlobalElement;
import org.apache.xmlbeans.SchemaIdentityConstraint;
import org.apache.xmlbeans.SchemaModelGroup;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SchemaTypeSystem;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.regex.ParseException;
import org.apache.xmlbeans.impl.regex.RegularExpression;
import org.apache.xmlbeans.impl.regex.SchemaRegularExpression;
import org.apache.xmlbeans.impl.values.XmlIntegerImpl;
import org.apache.xmlbeans.impl.values.XmlStringImpl;
import org.apache.xmlbeans.impl.values.XmlValueOutOfRangeException;

/* JADX INFO: loaded from: classes7.dex */
public class XQuerySchemaTypeSystem extends SchemaTypeLoaderBase implements SchemaTypeSystem {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final SchemaAnnotation[] EMPTY_SCHEMAANNOTATION_ARRAY = null;
    private static final SchemaAttributeGroup[] EMPTY_SCHEMAATTRIBUTEGROUP_ARRAY = null;
    private static final SchemaGlobalAttribute[] EMPTY_SCHEMAATTRIBUTE_ARRAY = null;
    private static final SchemaGlobalElement[] EMPTY_SCHEMAELEMENT_ARRAY = null;
    private static final SchemaModelGroup[] EMPTY_SCHEMAMODELGROUP_ARRAY = null;
    private static final SchemaType.Ref[] EMPTY_SCHEMATYPEREF_ARRAY = null;
    private static final SchemaType[] EMPTY_SCHEMATYPE_ARRAY = null;
    private static final XmlValueRef[] FACETS_BUILTIN_LIST = null;
    private static final XmlValueRef[] FACETS_BYTE = null;
    private static final XmlValueRef[] FACETS_INT = null;
    private static final XmlValueRef[] FACETS_INTEGER = null;
    static final XmlValueRef[] FACETS_LIST = null;
    private static final XmlValueRef[] FACETS_LONG = null;
    private static final XmlValueRef[] FACETS_NEGATIVE = null;
    private static final XmlValueRef[] FACETS_NONE = null;
    private static final XmlValueRef[] FACETS_NONNEGATIVE = null;
    private static final XmlValueRef[] FACETS_NONPOSITIVE = null;
    private static final XmlValueRef[] FACETS_POSITIVE = null;
    private static final XmlValueRef[] FACETS_SHORT = null;
    static final XmlValueRef[] FACETS_UNION = null;
    private static final XmlValueRef[] FACETS_UNSIGNED_BYTE = null;
    private static final XmlValueRef[] FACETS_UNSIGNED_INT = null;
    private static final XmlValueRef[] FACETS_UNSIGNED_LONG = null;
    private static final XmlValueRef[] FACETS_UNSIGNED_SHORT = null;
    private static final XmlValueRef[] FACETS_WS_COLLAPSE = null;
    private static final XmlValueRef[] FACETS_WS_PRESERVE = null;
    private static final XmlValueRef[] FACETS_WS_REPLACE = null;
    private static final boolean[] FIXED_FACETS_INTEGER = null;
    static final boolean[] FIXED_FACETS_LIST = null;
    private static final boolean[] FIXED_FACETS_NONE = null;
    static final boolean[] FIXED_FACETS_UNION = null;
    private static final boolean[] FIXED_FACETS_WS = null;
    public static final SchemaTypeImpl ST_ANY_ATOMIC = null;
    public static final SchemaTypeImpl ST_ANY_SIMPLE = null;
    public static final SchemaTypeImpl ST_ANY_TYPE = null;
    public static final SchemaTypeImpl ST_ANY_URI = null;
    public static final SchemaTypeImpl ST_BASE_64_BINARY = null;
    public static final SchemaTypeImpl ST_BOOLEAN = null;
    public static final SchemaTypeImpl ST_BYTE = null;
    public static final SchemaTypeImpl ST_DATE = null;
    public static final SchemaTypeImpl ST_DATE_TIME = null;
    public static final SchemaTypeImpl ST_DAY_TIME_DURATION = null;
    public static final SchemaTypeImpl ST_DECIMAL = null;
    public static final SchemaTypeImpl ST_DOUBLE = null;
    public static final SchemaTypeImpl ST_DURATION = null;
    public static final SchemaTypeImpl ST_ENTITIES = null;
    public static final SchemaTypeImpl ST_ENTITY = null;
    public static final SchemaTypeImpl ST_FLOAT = null;
    public static final SchemaTypeImpl ST_G_DAY = null;
    public static final SchemaTypeImpl ST_G_MONTH = null;
    public static final SchemaTypeImpl ST_G_MONTH_DAY = null;
    public static final SchemaTypeImpl ST_G_YEAR = null;
    public static final SchemaTypeImpl ST_G_YEAR_MONTH = null;
    public static final SchemaTypeImpl ST_HEX_BINARY = null;
    public static final SchemaTypeImpl ST_ID = null;
    public static final SchemaTypeImpl ST_IDREF = null;
    public static final SchemaTypeImpl ST_IDREFS = null;
    public static final SchemaTypeImpl ST_INT = null;
    public static final SchemaTypeImpl ST_INTEGER = null;
    public static final SchemaTypeImpl ST_LANGUAGE = null;
    public static final SchemaTypeImpl ST_LONG = null;
    public static final SchemaTypeImpl ST_NAME = null;
    public static final SchemaTypeImpl ST_NCNAME = null;
    public static final SchemaTypeImpl ST_NEGATIVE_INTEGER = null;
    public static final SchemaTypeImpl ST_NMTOKEN = null;
    public static final SchemaTypeImpl ST_NMTOKENS = null;
    public static final SchemaTypeImpl ST_NON_NEGATIVE_INTEGER = null;
    public static final SchemaTypeImpl ST_NON_POSITIVE_INTEGER = null;
    public static final SchemaTypeImpl ST_NORMALIZED_STRING = null;
    public static final SchemaTypeImpl ST_NOTATION = null;
    public static final SchemaTypeImpl ST_NO_TYPE = null;
    public static final SchemaTypeImpl ST_POSITIVE_INTEGER = null;
    public static final SchemaTypeImpl ST_QNAME = null;
    public static final SchemaTypeImpl ST_SHORT = null;
    public static final SchemaTypeImpl ST_STRING = null;
    public static final SchemaTypeImpl ST_TIME = null;
    public static final SchemaTypeImpl ST_TOKEN = null;
    public static final SchemaTypeImpl ST_UNSIGNED_BYTE = null;
    public static final SchemaTypeImpl ST_UNSIGNED_INT = null;
    public static final SchemaTypeImpl ST_UNSIGNED_LONG = null;
    public static final SchemaTypeImpl ST_UNSIGNED_SHORT = null;
    public static final SchemaTypeImpl ST_YEAR_MONTH_DURATION = null;
    private static final XmlValueRef XMLSTR_COLLAPSE = null;
    private static final XmlValueRef XMLSTR_PRESERVE = null;
    private static final XmlValueRef XMLSTR_REPLACE = null;
    private static final XQuerySchemaTypeSystem _global = null;
    private final SchemaContainer _container;
    private final Map<String, SchemaType> _handlesToObjects;
    private final Map<SchemaType, String> _objectsToHandles;
    private final SchemaTypeImpl[] _typeArray;
    private final Map<QName, SchemaType> _typeMap;
    private final Map<String, SchemaType> _typesByClassname;

    static {
        int r0 = 0;
        EMPTY_SCHEMATYPE_ARRAY = new SchemaType[0];
        EMPTY_SCHEMATYPEREF_ARRAY = new SchemaType.Ref[0];
        EMPTY_SCHEMAELEMENT_ARRAY = new SchemaGlobalElement[0];
        EMPTY_SCHEMAATTRIBUTE_ARRAY = new SchemaGlobalAttribute[0];
        EMPTY_SCHEMAMODELGROUP_ARRAY = new SchemaModelGroup[0];
        EMPTY_SCHEMAATTRIBUTEGROUP_ARRAY = new SchemaAttributeGroup[0];
        EMPTY_SCHEMAANNOTATION_ARRAY = new SchemaAnnotation[0];
        XQuerySchemaTypeSystem r1 = new XQuerySchemaTypeSystem();
        _global = r1;
        ST_ANY_TYPE = r1.getBuiltinType(1);
        ST_ANY_SIMPLE = r1.getBuiltinType(2);
        ST_ANY_ATOMIC = r1.getBuiltinType(52);
        ST_BOOLEAN = r1.getBuiltinType(3);
        ST_BASE_64_BINARY = r1.getBuiltinType(4);
        ST_HEX_BINARY = r1.getBuiltinType(5);
        ST_ANY_URI = r1.getBuiltinType(6);
        ST_QNAME = r1.getBuiltinType(7);
        ST_NOTATION = r1.getBuiltinType(8);
        ST_FLOAT = r1.getBuiltinType(9);
        ST_DOUBLE = r1.getBuiltinType(10);
        ST_DECIMAL = r1.getBuiltinType(11);
        ST_STRING = r1.getBuiltinType(12);
        ST_DURATION = r1.getBuiltinType(13);
        ST_DATE_TIME = r1.getBuiltinType(14);
        ST_TIME = r1.getBuiltinType(15);
        ST_DATE = r1.getBuiltinType(16);
        ST_G_YEAR_MONTH = r1.getBuiltinType(17);
        ST_G_YEAR = r1.getBuiltinType(18);
        ST_G_MONTH_DAY = r1.getBuiltinType(19);
        ST_G_DAY = r1.getBuiltinType(20);
        ST_G_MONTH = r1.getBuiltinType(21);
        ST_INTEGER = r1.getBuiltinType(22);
        ST_LONG = r1.getBuiltinType(23);
        ST_INT = r1.getBuiltinType(24);
        ST_SHORT = r1.getBuiltinType(25);
        ST_BYTE = r1.getBuiltinType(26);
        ST_NON_POSITIVE_INTEGER = r1.getBuiltinType(27);
        ST_NEGATIVE_INTEGER = r1.getBuiltinType(28);
        ST_NON_NEGATIVE_INTEGER = r1.getBuiltinType(29);
        ST_POSITIVE_INTEGER = r1.getBuiltinType(30);
        ST_UNSIGNED_LONG = r1.getBuiltinType(31);
        ST_UNSIGNED_INT = r1.getBuiltinType(32);
        ST_UNSIGNED_SHORT = r1.getBuiltinType(33);
        ST_UNSIGNED_BYTE = r1.getBuiltinType(34);
        ST_NORMALIZED_STRING = r1.getBuiltinType(35);
        ST_TOKEN = r1.getBuiltinType(36);
        ST_NAME = r1.getBuiltinType(37);
        ST_NCNAME = r1.getBuiltinType(38);
        ST_LANGUAGE = r1.getBuiltinType(39);
        ST_ID = r1.getBuiltinType(40);
        ST_IDREF = r1.getBuiltinType(41);
        ST_IDREFS = r1.getBuiltinType(42);
        ST_ENTITY = r1.getBuiltinType(43);
        ST_ENTITIES = r1.getBuiltinType(44);
        ST_NMTOKEN = r1.getBuiltinType(45);
        ST_NMTOKENS = r1.getBuiltinType(46);
        ST_DAY_TIME_DURATION = r1.getBuiltinType(53);
        ST_YEAR_MONTH_DURATION = r1.getBuiltinType(54);
        ST_NO_TYPE = r1.getBuiltinType(0);
        XMLSTR_PRESERVE = buildString("preserve");
        XMLSTR_REPLACE = buildString("preserve");
        XMLSTR_COLLAPSE = buildString("preserve");
        XmlValueRef[] r2 = {null, null, null, null, null, null, null, null, null, null, null, null};
        FACETS_NONE = r2;
        boolean[] r4 = {false, false, false, false, false, false, false, false, false, false, false, false};
        FIXED_FACETS_NONE = r4;
        XmlValueRef[] r15 = {null, null, null, null, null, null, null, null, null, build_wsstring(3), null, null};
        FACETS_WS_COLLAPSE = r15;
        FACETS_WS_REPLACE = new XmlValueRef[]{null, null, null, null, null, null, null, null, null, build_wsstring(2), null, null};
        FACETS_WS_PRESERVE = new XmlValueRef[]{null, null, null, null, null, null, null, null, null, build_wsstring(1), null, null};
        FACETS_INTEGER = new XmlValueRef[]{null, null, null, null, null, null, null, null, buildNnInteger(BigInteger.ZERO), build_wsstring(3), null, null};
        FACETS_LONG = new XmlValueRef[]{null, null, null, null, buildInteger(BigInteger.valueOf(Long.MIN_VALUE)), buildInteger(BigInteger.valueOf(Long.MAX_VALUE)), null, null, buildNnInteger(BigInteger.ZERO), build_wsstring(3), null, null};
        FACETS_INT = new XmlValueRef[]{null, null, null, null, buildInteger(BigInteger.valueOf(-2147483648L)), buildInteger(BigInteger.valueOf(2147483647L)), null, null, buildNnInteger(BigInteger.ZERO), build_wsstring(3), null, null};
        FACETS_SHORT = new XmlValueRef[]{null, null, null, null, buildInteger(BigInteger.valueOf(-32768)), buildInteger(BigInteger.valueOf(32767)), null, null, buildNnInteger(BigInteger.ZERO), build_wsstring(3), null, null};
        FACETS_BYTE = new XmlValueRef[]{null, null, null, null, buildInteger(BigInteger.valueOf(-128)), buildInteger(BigInteger.valueOf(127)), null, null, buildNnInteger(BigInteger.ZERO), build_wsstring(3), null, null};
        FACETS_NONNEGATIVE = new XmlValueRef[]{null, null, null, null, buildInteger(BigInteger.ZERO), null, null, null, buildNnInteger(BigInteger.ZERO), build_wsstring(3), null, null};
        FACETS_POSITIVE = new XmlValueRef[]{null, null, null, null, buildInteger(BigInteger.ONE), null, null, null, buildNnInteger(BigInteger.ZERO), build_wsstring(3), null, null};
        FACETS_NONPOSITIVE = new XmlValueRef[]{null, null, null, null, null, buildInteger(BigInteger.ZERO), null, null, buildNnInteger(BigInteger.ZERO), build_wsstring(3), null, null};
        FACETS_NEGATIVE = new XmlValueRef[]{null, null, null, null, null, buildInteger(BigInteger.ONE.negate()), null, null, buildNnInteger(BigInteger.ZERO), build_wsstring(3), null, null};
        FACETS_UNSIGNED_LONG = new XmlValueRef[]{null, null, null, null, buildInteger(BigInteger.ZERO), buildInteger(new BigInteger("18446744073709551615")), null, null, buildNnInteger(BigInteger.ZERO), build_wsstring(3), null, null};
        FACETS_UNSIGNED_INT = new XmlValueRef[]{null, null, null, null, buildInteger(BigInteger.ZERO), buildInteger(BigInteger.valueOf(4294967295L)), null, null, buildNnInteger(BigInteger.ZERO), build_wsstring(3), null, null};
        FACETS_UNSIGNED_SHORT = new XmlValueRef[]{null, null, null, null, buildInteger(BigInteger.ZERO), buildInteger(BigInteger.valueOf(WebSocketProtocol.PAYLOAD_SHORT_MAX)), null, null, buildNnInteger(BigInteger.ZERO), build_wsstring(3), null, null};
        FACETS_UNSIGNED_BYTE = new XmlValueRef[]{null, null, null, null, buildInteger(BigInteger.ZERO), buildInteger(BigInteger.valueOf(255)), null, null, buildNnInteger(BigInteger.ZERO), build_wsstring(3), null, null};
        FACETS_BUILTIN_LIST = new XmlValueRef[]{null, buildNnInteger(BigInteger.ONE), null, null, null, null, null, null, null, build_wsstring(3), null, null};
        boolean[] r3 = {false, false, false, false, false, false, false, false, false, true, false, false};
        FIXED_FACETS_WS = r3;
        FIXED_FACETS_INTEGER = new boolean[]{false, false, false, false, false, false, false, false, true, true, false, false};
        FACETS_UNION = r2;
        FIXED_FACETS_UNION = r4;
        FACETS_LIST = r15;
        FIXED_FACETS_LIST = r3;
    L3:
        if (r0 > 46) goto L5;
        _global.fillInType(r0);
        r0 = r0 + 1;
        goto L3
    L5:
        int r5 = 52;
    L6:
        if (r5 > 54) goto L8;
        _global.fillInType(r5);
        r5 = r5 + 1;
        goto L6
    }

    private XQuerySchemaTypeSystem() {
        this._typeMap = new HashMap();
        this._typeArray = new SchemaTypeImpl[50];
        this._handlesToObjects = new HashMap();
        this._objectsToHandles = new HashMap();
        this._typesByClassname = new HashMap();
        SchemaContainer r0 = new SchemaContainer("http://www.w3.org/2001/XMLSchema");
        this._container = r0;
        r0.setTypeSystem(this);
        setupType(1, "anyType", "org.apache.xmlbeans.XmlObject");
        setupType(2, "anySimpleType", "org.apache.xmlbeans.XmlAnySimpleType");
        setupType(52, "anyAtomicType", null);
        setupType(3, TypedValues.Custom.S_BOOLEAN, "org.apache.xmlbeans.XmlBoolean");
        setupType(4, "base64Binary", "org.apache.xmlbeans.XmlBase64Binary");
        setupType(5, "hexBinary", "org.apache.xmlbeans.XmlHexBinary");
        setupType(6, "anyURI", "org.apache.xmlbeans.XmlAnyURI");
        setupType(7, "QName", "org.apache.xmlbeans.XmlQName");
        setupType(8, "NOTATION", "org.apache.xmlbeans.XmlNOTATION");
        setupType(9, TypedValues.Custom.S_FLOAT, "org.apache.xmlbeans.XmlFloat");
        setupType(10, "double", "org.apache.xmlbeans.XmlDouble");
        setupType(11, "decimal", "org.apache.xmlbeans.XmlDecimal");
        setupType(12, TypedValues.Custom.S_STRING, "org.apache.xmlbeans.XmlString");
        setupType(13, "duration", "org.apache.xmlbeans.XmlDuration");
        setupType(14, "dateTime", "org.apache.xmlbeans.XmlDateTime");
        setupType(15, OaidModel.KEY_TIME, "org.apache.xmlbeans.XmlTime");
        setupType(16, "date", "org.apache.xmlbeans.XmlDate");
        setupType(17, "gYearMonth", "org.apache.xmlbeans.XmlGYearMonth");
        setupType(18, "gYear", "org.apache.xmlbeans.XmlGYear");
        setupType(19, "gMonthDay", "org.apache.xmlbeans.XmlGMonthDay");
        setupType(20, "gDay", "org.apache.xmlbeans.XmlGDay");
        setupType(21, "gMonth", "org.apache.xmlbeans.XmlGMonth");
        setupType(22, TypedValues.Custom.S_INT, "org.apache.xmlbeans.XmlInteger");
        setupType(23, "long", "org.apache.xmlbeans.XmlLong");
        setupType(24, "int", "org.apache.xmlbeans.XmlInt");
        setupType(25, "short", "org.apache.xmlbeans.XmlShort");
        setupType(26, "byte", "org.apache.xmlbeans.XmlByte");
        setupType(27, "nonPositiveInteger", "org.apache.xmlbeans.XmlNonPositiveInteger");
        setupType(28, "negativeInteger", "org.apache.xmlbeans.XmlNegativeInteger");
        setupType(29, "nonNegativeInteger", "org.apache.xmlbeans.XmlNonNegativeInteger");
        setupType(30, "positiveInteger", "org.apache.xmlbeans.XmlPositiveInteger");
        setupType(31, "unsignedLong", "org.apache.xmlbeans.XmlUnsignedLong");
        setupType(32, "unsignedInt", "org.apache.xmlbeans.XmlUnsignedInt");
        setupType(33, "unsignedShort", "org.apache.xmlbeans.XmlUnsignedShort");
        setupType(34, "unsignedByte", "org.apache.xmlbeans.XmlUnsignedByte");
        setupType(35, "normalizedString", "org.apache.xmlbeans.XmlNormalizedString");
        setupType(36, "token", "org.apache.xmlbeans.XmlToken");
        setupType(37, "Name", "org.apache.xmlbeans.XmlName");
        setupType(38, "NCName", "org.apache.xmlbeans.XmlNCName");
        setupType(39, Api.KEY_LANGUAGE, "org.apache.xmlbeans.XmlLanguage");
        setupType(40, "ID", "org.apache.xmlbeans.XmlID");
        setupType(41, "IDREF", "org.apache.xmlbeans.XmlIDREF");
        setupType(42, "IDREFS", "org.apache.xmlbeans.XmlIDREFS");
        setupType(43, "ENTITY", "org.apache.xmlbeans.XmlENTITY");
        setupType(44, "ENTITIES", "org.apache.xmlbeans.XmlENTITIES");
        setupType(45, "NMTOKEN", "org.apache.xmlbeans.XmlNMTOKEN");
        setupType(46, "NMTOKENS", "org.apache.xmlbeans.XmlNMTOKENS");
        setupType(53, "dayTimeDuration", null);
        setupType(54, "yearMonthDuration", null);
        setupType(0, null, null);
        r0.setImmutable();
    }

    private int arrayIndexForBtc(int r1) {
        if (r1 > 46) goto L5;
        return r1;
    L5:
        return ((r1 - 52) + 46) + 1;
    }

    private static XmlValueRef buildInteger(BigInteger r2) {
        if (r2 != null) goto L8;
        return null;
    L8:
        XmlIntegerImpl r1 = new XmlIntegerImpl();     // Catch: XmlValueOutOfRangeException -> L7
        r1.setBigIntegerValue(r2);     // Catch: XmlValueOutOfRangeException -> L7
        r1.setImmutable();     // Catch: XmlValueOutOfRangeException -> L7
        return new XmlValueRef(r1);
    L7:
        return null;
    }

    private static XmlValueRef buildNnInteger(BigInteger r2) {
        if (r2 != null) goto L6;
        return null;
    L6:
        if (r2.signum() >= 0) goto L11;
        return null;
    L11:
        XmlIntegerImpl r1 = new XmlIntegerImpl();     // Catch: XmlValueOutOfRangeException -> L10
        r1.setBigIntegerValue(r2);     // Catch: XmlValueOutOfRangeException -> L10
        r1.setImmutable();     // Catch: XmlValueOutOfRangeException -> L10
        return new XmlValueRef(r1);
    L10:
        return null;
    }

    private static XmlValueRef buildString(String r2) {
        if (r2 != null) goto L8;
        return null;
    L8:
        XmlStringImpl r1 = new XmlStringImpl();     // Catch: XmlValueOutOfRangeException -> L7
        r1.setStringValue(r2);     // Catch: XmlValueOutOfRangeException -> L7
        r1.setImmutable();     // Catch: XmlValueOutOfRangeException -> L7
        return new XmlValueRef(r1);
    L7:
        return null;
    }

    private static XmlValueRef build_wsstring(int r1) {
        if (r1 == 1) goto L15;
        if (r1 == 2) goto L13;
        if (r1 == 3) goto L11;
        return null;
    L11:
        return XMLSTR_COLLAPSE;
    L13:
        return XMLSTR_REPLACE;
    L15:
        return XMLSTR_PRESERVE;
    }

    public static SchemaTypeSystem get() {
        return _global;
    }

    private SchemaTypeImpl getBuiltinType(int r2) {
        return this._typeArray[arrayIndexForBtc(r2)];
    }

    private void setupType(int r5, String r6, String r7) {
        SchemaTypeImpl r0 = new SchemaTypeImpl(this._container, true);
        this._container.addGlobalType(r0.getRef());
        if (r6 != null) goto L5;
        QName r1 = null;
    L6:
        StringBuilder r2 = new StringBuilder().append("_BI_");
        if (r6 != null) goto L9;
        r6 = "NO_TYPE";
    L9:
        String r8 = r2.append(r6).toString();
        r0.setName(r1);
        r0.setBuiltinTypeCode(r5);
        if (r7 == null) goto L12;
        r0.setFullJavaName(r7);
    L12:
        this._typeArray[arrayIndexForBtc(r5)] = r0;
        this._typeMap.put(r1, r0);
        this._handlesToObjects.put(r8, r0);
        this._objectsToHandles.put(r0, r8);
        if (r7 == null) goto L16;
        this._typesByClassname.put(r7, r0);
        return;
    L16:
        return;
    L5:
        r1 = QNameHelper.forLNS(r6, "http://www.w3.org/2001/XMLSchema");
        goto L6
    }

    public void fillInType(int r13) {
        SchemaTypeImpl r12 = getBuiltinType(r13);
        int r0 = 3;
        switch(r13) {
            case 0: goto L35;
            case 1: goto L34;
            case 2: goto L32;
            case 3: goto L31;
            case 4: goto L31;
            case 5: goto L31;
            case 6: goto L31;
            case 7: goto L31;
            case 8: goto L31;
            case 9: goto L31;
            case 10: goto L31;
            case 11: goto L31;
            case 12: goto L31;
            case 13: goto L31;
            case 14: goto L31;
            case 15: goto L31;
            case 16: goto L31;
            case 17: goto L31;
            case 18: goto L31;
            case 19: goto L31;
            case 20: goto L31;
            case 21: goto L31;
            case 22: goto L30;
            case 23: goto L29;
            case 24: goto L28;
            case 25: goto L27;
            case 26: goto L26;
            case 27: goto L29;
            case 28: goto L25;
            case 29: goto L29;
            case 30: goto L24;
            case 31: goto L24;
            case 32: goto L23;
            case 33: goto L22;
            case 34: goto L21;
            case 35: goto L20;
            case 36: goto L19;
            case 37: goto L18;
            case 38: goto L17;
            case 39: goto L18;
            case 40: goto L16;
            case 41: goto L16;
            case 42: goto L8;
            case 43: goto L16;
            case 44: goto L8;
            case 45: goto L18;
            case 46: goto L8;
            default: goto L4;
        };
    L4:
        switch(r13) {
            case 52: goto L7;
            case 53: goto L6;
            case 54: goto L6;
            default: goto L32;
        };
    L6:
        SchemaTypeImpl r2 = ST_DURATION;
    L33:
        SchemaTypeImpl r3 = null;
        int r4 = 1;
    L37:
        r12.setDerivationType(1);
        r12.setSimpleTypeVariety(r4);
        if (r4 == 0) goto L40;
        r12.setSimpleType(true);
    L40:
        if (r2 != null) goto L42;
        SchemaType.Ref r5 = null;
    L43:
        r12.setBaseTypeRef(r5);
        if (r2 != null) goto L46;
        int r6 = 0;
    L47:
        r12.setBaseDepth(r6);
        if (r3 != null) goto L50;
        SchemaType.Ref r7 = null;
    L51:
        r12.setListItemTypeRef(r7);
        if (r13 < 2) goto L56;
        if (r13 > 21) goto L56;
    L57:
        SchemaType.Ref r8 = r12.getRef();
    L58:
        r12.setPrimitiveTypeRef(r8);
    L68:
        int r9 = 64;
        int r10 = 1000000;
        switch(r13) {
            case 0: goto L98;
            case 1: goto L98;
            case 2: goto L98;
            case 3: goto L96;
            case 4: goto L96;
            case 5: goto L96;
            case 6: goto L96;
            case 7: goto L96;
            case 8: goto L96;
            case 9: goto L96;
            case 10: goto L96;
            case 11: goto L94;
            case 12: goto L93;
            case 13: goto L96;
            case 14: goto L96;
            case 15: goto L96;
            case 16: goto L96;
            case 17: goto L96;
            case 18: goto L96;
            case 19: goto L96;
            case 20: goto L96;
            case 21: goto L96;
            case 22: goto L91;
            case 23: goto L89;
            case 24: goto L86;
            case 25: goto L84;
            case 26: goto L83;
            case 27: goto L82;
            case 28: goto L81;
            case 29: goto L80;
            case 30: goto L79;
            case 31: goto L78;
            case 32: goto L77;
            case 33: goto L76;
            case 34: goto L75;
            case 35: goto L74;
            case 36: goto L73;
            case 37: goto L73;
            case 38: goto L73;
            case 39: goto L73;
            case 40: goto L73;
            case 41: goto L73;
            case 42: goto L73;
            case 43: goto L73;
            case 44: goto L72;
            case 45: goto L73;
            case 46: goto L72;
            default: goto L70;
        };
    L70:
        switch(r13) {
            case 52: goto L98;
            case 53: goto L96;
            case 54: goto L96;
            default: goto L98;
        };
    L72:
        XmlValueRef[] r11 = FACETS_BUILTIN_LIST;
    L99:
        boolean[] r14 = FIXED_FACETS_NONE;
        r0 = 0;
        r10 = 0;
    L100:
        switch(r13) {
            case 0: goto L107;
            case 1: goto L107;
            case 2: goto L107;
            case 3: goto L106;
            case 4: goto L107;
            case 5: goto L107;
            case 6: goto L107;
            case 7: goto L107;
            case 8: goto L107;
            case 9: goto L105;
            case 10: goto L105;
            case 11: goto L105;
            case 12: goto L107;
            case 13: goto L104;
            case 14: goto L104;
            case 15: goto L104;
            case 16: goto L104;
            case 17: goto L104;
            case 18: goto L104;
            case 19: goto L104;
            case 20: goto L104;
            case 21: goto L104;
            case 22: goto L105;
            case 23: goto L103;
            case 24: goto L103;
            case 25: goto L103;
            case 26: goto L103;
            case 27: goto L103;
            case 28: goto L103;
            case 29: goto L103;
            case 30: goto L103;
            case 31: goto L103;
            case 32: goto L103;
            case 33: goto L103;
            case 34: goto L103;
            case 35: goto L107;
            case 36: goto L107;
            case 37: goto L107;
            case 38: goto L107;
            case 39: goto L107;
            case 40: goto L107;
            case 41: goto L107;
            case 42: goto L107;
            case 43: goto L107;
            case 44: goto L107;
            case 45: goto L107;
            case 46: goto L107;
            default: goto L101;
        };
    L101:
        switch(r13) {
            case 52: goto L107;
            case 53: goto L104;
            case 54: goto L104;
            default: goto L107;
        };
    L103:
        int r15 = 2;
        boolean r16 = true;
    L108:
        boolean r17 = r16;
        boolean r18 = r17;
    L109:
        r12.setBasicFacets(r11, r14);
        r12.setWhiteSpaceRule(r0);
        r12.setOrdered(r15);
        r12.setBounded(r16);
        r12.setNumeric(r17);
        r12.setFinite(r18);
        r12.setDecimalSize(r10);
        r12.setAnonymousTypeRefs(EMPTY_SCHEMATYPEREF_ARRAY);
        if (r13 != 43) goto L112;
    L126:
        String r1 = null;
    L122:
        boolean r19 = true;
    L127:
        if (r1 != null) goto L139;
    L132:
        r12.setPatternFacet(r19);
        if (r13 != 1) goto L135;
        SchemaParticleImpl r110 = new SchemaParticleImpl();
        r110.setParticleType(5);
        r110.setWildcardSet(QNameSet.ALL);
        r110.setWildcardProcess(2);
        r110.setMinOccurs(BigInteger.ZERO);
        r110.setMaxOccurs(null);
        r110.setTransitionRules(QNameSet.ALL, true);
        r110.setTransitionNotes(QNameSet.ALL, true);
        SchemaAttributeModelImpl r20 = new SchemaAttributeModelImpl();
        r20.setWildcardProcess(2);
        r20.setWildcardSet(QNameSet.ALL);
        r12.setComplexTypeVariety(4);
        r12.setContentModel(r110, r20, Collections.EMPTY_MAP, Collections.EMPTY_MAP, false);
        r12.setAnonymousTypeRefs(EMPTY_SCHEMATYPEREF_ARRAY);
        r12.setWildcardSummary(QNameSet.ALL, true, QNameSet.ALL, true);
    L137:
        r12.setOrderSensitive(false);
        return;
    L135:
        if (r13 != 0) goto L137;
        SchemaAttributeModelImpl r21 = new SchemaAttributeModelImpl();
        r12.setComplexTypeVariety(1);
        r12.setContentModel(null, r21, Collections.EMPTY_MAP, Collections.EMPTY_MAP, false);
        r12.setAnonymousTypeRefs(EMPTY_SCHEMATYPEREF_ARRAY);
        r12.setWildcardSummary(QNameSet.EMPTY, false, QNameSet.EMPTY, false);
        goto L137
    L139:
        RegularExpression r22 = SchemaRegularExpression.forPattern(r1);     // Catch: ParseException -> L130
    L131:
        r12.setPatterns(new RegularExpression[]{r22});
    L130:
        r22 = null;
        goto L131
    L112:
        if (r13 != 45) goto L114;
        r1 = "\\c+";
        goto L122
    L114:
        if (r13 != 53) goto L116;
        r1 = "[^YM]*[DT].*";
        goto L122
    L116:
        if (r13 == 54) goto L123;
        switch(r13) {
            case 37: goto L121;
            case 38: goto L120;
            case 39: goto L119;
            case 40: goto L126;
            case 41: goto L126;
            default: goto L118;
        };
    L118:
        r1 = null;
        r19 = false;
        goto L127
    L119:
        r1 = "[a-zA-Z]{1,8}(-[a-zA-Z0-9]{1,8})*";
        goto L122
    L120:
        r1 = "[\\i-[:]][\\c-[:]]*";
        goto L122
    L121:
        r1 = "\\i\\c*";
        goto L122
    L123:
        r1 = "[^DT]*";
    L104:
        r16 = false;
        r17 = false;
        r18 = false;
        r15 = 1;
        goto L109
    L105:
        r15 = 2;
        r16 = false;
        r18 = false;
        r17 = true;
        goto L109
    L106:
        r15 = 0;
        r16 = false;
        r17 = false;
        r18 = true;
    L107:
        r15 = 0;
        r16 = false;
        goto L108
    L73:
        r11 = FACETS_WS_COLLAPSE;
        r14 = FIXED_FACETS_NONE;
    L97:
        r10 = 0;
        goto L100
    L74:
        r11 = FACETS_WS_REPLACE;
        r14 = FIXED_FACETS_NONE;
        r0 = 2;
        goto L97
    L75:
        XmlValueRef[] r23 = FACETS_UNSIGNED_BYTE;
    L85:
        boolean[] r24 = FIXED_FACETS_INTEGER;
        r10 = 16;
        r11 = r23;
    L88:
        r14 = r24;
        goto L100
    L76:
        r11 = FACETS_UNSIGNED_SHORT;
    L87:
        r24 = FIXED_FACETS_INTEGER;
        r10 = 32;
        goto L88
    L77:
        r11 = FACETS_UNSIGNED_INT;
    L90:
        r14 = FIXED_FACETS_INTEGER;
    L95:
        r10 = r9;
        goto L100
    L78:
        r11 = FACETS_UNSIGNED_LONG;
    L92:
        r14 = FIXED_FACETS_INTEGER;
        goto L100
    L79:
        r11 = FACETS_POSITIVE;
        goto L92
    L80:
        r11 = FACETS_NONNEGATIVE;
        goto L92
    L81:
        r11 = FACETS_NEGATIVE;
        goto L92
    L82:
        r11 = FACETS_NONPOSITIVE;
        goto L92
    L83:
        r11 = FACETS_BYTE;
        r14 = FIXED_FACETS_INTEGER;
        r9 = 8;
        goto L95
    L84:
        r23 = FACETS_SHORT;
        goto L85
    L86:
        r11 = FACETS_INT;
        goto L87
    L89:
        r11 = FACETS_LONG;
        goto L90
    L91:
        r11 = FACETS_INTEGER;
        goto L92
    L93:
        r11 = FACETS_WS_PRESERVE;
        r14 = FIXED_FACETS_NONE;
        r10 = 0;
        r0 = 1;
        goto L100
    L94:
        r11 = FACETS_WS_COLLAPSE;
        r14 = FIXED_FACETS_WS;
        r9 = 1000001;
    L96:
        r11 = FACETS_WS_COLLAPSE;
        r14 = FIXED_FACETS_WS;
    L98:
        r11 = FACETS_NONE;
    L56:
        if (r13 == 52) goto L57;
        if (r4 != 1) goto L68;
        if (r2 == null) goto L67;
        if (r2.getPrimitiveType() == null) goto L65;
        r8 = r2.getPrimitiveType().getRef();
        goto L58
    L65:
        throw new IllegalStateException("Base.gpt was null for " + r13);
    L67:
        throw new IllegalStateException("Base was null for " + r13);
    L50:
        r7 = r3.getRef();
        goto L51
    L46:
        r6 = ((SchemaTypeImpl) ZeusTransformUtils.preCheckCast(r2, SchemaTypeImpl.class, "com.obric.memorydata.plugin")).getBaseDepth() + 1;
        goto L47
    L42:
        r5 = r2.getRef();
        goto L43
    L7:
        r2 = ST_ANY_SIMPLE;
        goto L33
    L8:
        r2 = ST_ANY_SIMPLE;
        if (r13 != 42) goto L13;
        r3 = ST_IDREF;
    L11:
        r4 = 3;
        goto L37
    L13:
        if (r13 != 44) goto L15;
        r3 = ST_ENTITY;
        goto L11
    L15:
        r3 = ST_NMTOKEN;
        goto L11
    L16:
        r2 = ST_NCNAME;
        goto L33
    L17:
        r2 = ST_NAME;
        goto L33
    L18:
        r2 = ST_TOKEN;
        goto L33
    L19:
        r2 = ST_NORMALIZED_STRING;
        goto L33
    L20:
        r2 = ST_STRING;
        goto L33
    L21:
        r2 = ST_UNSIGNED_SHORT;
        goto L33
    L22:
        r2 = ST_UNSIGNED_INT;
        goto L33
    L23:
        r2 = ST_UNSIGNED_LONG;
        goto L33
    L24:
        r2 = ST_NON_NEGATIVE_INTEGER;
        goto L33
    L25:
        r2 = ST_NON_POSITIVE_INTEGER;
        goto L33
    L26:
        r2 = ST_SHORT;
        goto L33
    L27:
        r2 = ST_INT;
        goto L33
    L28:
        r2 = ST_LONG;
        goto L33
    L29:
        r2 = ST_INTEGER;
        goto L33
    L30:
        r2 = ST_DECIMAL;
        goto L33
    L31:
        r2 = ST_ANY_ATOMIC;
    L32:
        r2 = ST_ANY_TYPE;
        goto L33
    L34:
        r2 = null;
        r3 = null;
    L36:
        r4 = 0;
        goto L37
    L35:
        r2 = ST_ANY_TYPE;
        r3 = null;
        goto L36
    }

    @Override // org.apache.xmlbeans.impl.schema.SchemaTypeLoaderBase, org.apache.xmlbeans.SchemaTypeLoader
    public SchemaGlobalAttribute findAttribute(QName r1) {
        return null;
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaAttributeGroup.Ref findAttributeGroupRef(QName r1) {
        return null;
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaGlobalAttribute.Ref findAttributeRef(QName r1) {
        return null;
    }

    @Override // org.apache.xmlbeans.impl.schema.SchemaTypeLoaderBase, org.apache.xmlbeans.SchemaTypeLoader
    public SchemaType findAttributeType(QName r1) {
        return null;
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaType.Ref findAttributeTypeRef(QName r1) {
        return null;
    }

    @Override // org.apache.xmlbeans.impl.schema.SchemaTypeLoaderBase, org.apache.xmlbeans.SchemaTypeLoader
    public SchemaType findDocumentType(QName r1) {
        return null;
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaType.Ref findDocumentTypeRef(QName r1) {
        return null;
    }

    @Override // org.apache.xmlbeans.impl.schema.SchemaTypeLoaderBase, org.apache.xmlbeans.SchemaTypeLoader
    public SchemaGlobalElement findElement(QName r1) {
        return null;
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaGlobalElement.Ref findElementRef(QName r1) {
        return null;
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaIdentityConstraint.Ref findIdentityConstraintRef(QName r1) {
        return null;
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaModelGroup.Ref findModelGroupRef(QName r1) {
        return null;
    }

    @Override // org.apache.xmlbeans.impl.schema.SchemaTypeLoaderBase, org.apache.xmlbeans.SchemaTypeLoader
    public SchemaType findType(QName r2) {
        return (SchemaType) ZeusTransformUtils.preCheckCast(this._typeMap.get(r2), SchemaType.class, "com.obric.memorydata.plugin");
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaType.Ref findTypeRef(QName r1) {
        SchemaType r0 = findType(r1);
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.getRef();
    }

    @Override // org.apache.xmlbeans.SchemaTypeSystem
    public ClassLoader getClassLoader() {
        return BuiltinSchemaTypeSystem.class.getClassLoader();
    }

    @Override // org.apache.xmlbeans.SchemaTypeSystem
    public SchemaComponent resolveHandle(String r2) {
        return (SchemaComponent) ZeusTransformUtils.preCheckCast(this._handlesToObjects.get(r2), SchemaComponent.class, "com.obric.memorydata.plugin");
    }

    @Override // org.apache.xmlbeans.SchemaTypeSystem
    public SchemaType typeForHandle(String r2) {
        return (SchemaType) ZeusTransformUtils.preCheckCast(this._handlesToObjects.get(r2), SchemaType.class, "com.obric.memorydata.plugin");
    }
}
