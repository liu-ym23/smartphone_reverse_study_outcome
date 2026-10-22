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
public class BuiltinSchemaTypeSystem extends SchemaTypeLoaderBase implements SchemaTypeSystem {
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
    public static final SchemaTypeImpl ST_ANY_SIMPLE = null;
    public static final SchemaTypeImpl ST_ANY_TYPE = null;
    public static final SchemaTypeImpl ST_ANY_URI = null;
    public static final SchemaTypeImpl ST_BASE_64_BINARY = null;
    public static final SchemaTypeImpl ST_BOOLEAN = null;
    public static final SchemaTypeImpl ST_BYTE = null;
    public static final SchemaTypeImpl ST_DATE = null;
    public static final SchemaTypeImpl ST_DATE_TIME = null;
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
    private static final XmlValueRef XMLSTR_COLLAPSE = null;
    private static final XmlValueRef XMLSTR_PRESERVE = null;
    private static final XmlValueRef XMLSTR_REPLACE = null;
    private static BuiltinSchemaTypeSystem _global;
    private SchemaContainer _container;
    private Map<String, SchemaType> _handlesToObjects;
    private Map<SchemaType, String> _objectsToHandles;
    private SchemaTypeImpl[] _typeArray;
    private Map<QName, SchemaType> _typeMap;
    private Map<String, SchemaType> _typesByClassname;

    static {
        int r0 = 0;
        EMPTY_SCHEMATYPE_ARRAY = new SchemaType[0];
        EMPTY_SCHEMATYPEREF_ARRAY = new SchemaType.Ref[0];
        EMPTY_SCHEMAELEMENT_ARRAY = new SchemaGlobalElement[0];
        EMPTY_SCHEMAATTRIBUTE_ARRAY = new SchemaGlobalAttribute[0];
        EMPTY_SCHEMAMODELGROUP_ARRAY = new SchemaModelGroup[0];
        EMPTY_SCHEMAATTRIBUTEGROUP_ARRAY = new SchemaAttributeGroup[0];
        EMPTY_SCHEMAANNOTATION_ARRAY = new SchemaAnnotation[0];
        BuiltinSchemaTypeSystem r1 = new BuiltinSchemaTypeSystem();
        _global = r1;
        ST_ANY_TYPE = r1.getBuiltinType(1);
        ST_ANY_SIMPLE = _global.getBuiltinType(2);
        ST_BOOLEAN = _global.getBuiltinType(3);
        ST_BASE_64_BINARY = _global.getBuiltinType(4);
        ST_HEX_BINARY = _global.getBuiltinType(5);
        ST_ANY_URI = _global.getBuiltinType(6);
        ST_QNAME = _global.getBuiltinType(7);
        ST_NOTATION = _global.getBuiltinType(8);
        ST_FLOAT = _global.getBuiltinType(9);
        ST_DOUBLE = _global.getBuiltinType(10);
        ST_DECIMAL = _global.getBuiltinType(11);
        ST_STRING = _global.getBuiltinType(12);
        ST_DURATION = _global.getBuiltinType(13);
        ST_DATE_TIME = _global.getBuiltinType(14);
        ST_TIME = _global.getBuiltinType(15);
        ST_DATE = _global.getBuiltinType(16);
        ST_G_YEAR_MONTH = _global.getBuiltinType(17);
        ST_G_YEAR = _global.getBuiltinType(18);
        ST_G_MONTH_DAY = _global.getBuiltinType(19);
        ST_G_DAY = _global.getBuiltinType(20);
        ST_G_MONTH = _global.getBuiltinType(21);
        ST_INTEGER = _global.getBuiltinType(22);
        ST_LONG = _global.getBuiltinType(23);
        ST_INT = _global.getBuiltinType(24);
        ST_SHORT = _global.getBuiltinType(25);
        ST_BYTE = _global.getBuiltinType(26);
        ST_NON_POSITIVE_INTEGER = _global.getBuiltinType(27);
        ST_NEGATIVE_INTEGER = _global.getBuiltinType(28);
        ST_NON_NEGATIVE_INTEGER = _global.getBuiltinType(29);
        ST_POSITIVE_INTEGER = _global.getBuiltinType(30);
        ST_UNSIGNED_LONG = _global.getBuiltinType(31);
        ST_UNSIGNED_INT = _global.getBuiltinType(32);
        ST_UNSIGNED_SHORT = _global.getBuiltinType(33);
        ST_UNSIGNED_BYTE = _global.getBuiltinType(34);
        ST_NORMALIZED_STRING = _global.getBuiltinType(35);
        ST_TOKEN = _global.getBuiltinType(36);
        ST_NAME = _global.getBuiltinType(37);
        ST_NCNAME = _global.getBuiltinType(38);
        ST_LANGUAGE = _global.getBuiltinType(39);
        ST_ID = _global.getBuiltinType(40);
        ST_IDREF = _global.getBuiltinType(41);
        ST_IDREFS = _global.getBuiltinType(42);
        ST_ENTITY = _global.getBuiltinType(43);
        ST_ENTITIES = _global.getBuiltinType(44);
        ST_NMTOKEN = _global.getBuiltinType(45);
        ST_NMTOKENS = _global.getBuiltinType(46);
        ST_NO_TYPE = _global.getBuiltinType(0);
        XMLSTR_PRESERVE = buildString("preserve");
        XMLSTR_REPLACE = buildString("preserve");
        XMLSTR_COLLAPSE = buildString("preserve");
        XmlValueRef[] r2 = {null, null, null, null, null, null, null, null, null, null, null, null};
        FACETS_NONE = r2;
        boolean[] r14 = {false, false, false, false, false, false, false, false, false, false, false, false};
        FIXED_FACETS_NONE = r14;
        XmlValueRef[] r12 = {null, null, null, null, null, null, null, null, null, build_wsstring(3), null, null};
        FACETS_WS_COLLAPSE = r12;
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
        FIXED_FACETS_UNION = r14;
        FACETS_LIST = r12;
        FIXED_FACETS_LIST = r3;
    L3:
        if (r0 > 46) goto L5;
        _global.fillInType(r0);
        r0 = r0 + 1;
        goto L3
    }

    private BuiltinSchemaTypeSystem() {
        this._typeMap = new HashMap();
        this._typeArray = new SchemaTypeImpl[47];
        this._handlesToObjects = new HashMap();
        this._objectsToHandles = new HashMap();
        this._typesByClassname = new HashMap();
        SchemaContainer r0 = new SchemaContainer("http://www.w3.org/2001/XMLSchema");
        this._container = r0;
        r0.setTypeSystem(this);
        setupBuiltin(1, "anyType", "org.apache.xmlbeans.XmlObject");
        setupBuiltin(2, "anySimpleType", "org.apache.xmlbeans.XmlAnySimpleType");
        setupBuiltin(3, TypedValues.Custom.S_BOOLEAN, "org.apache.xmlbeans.XmlBoolean");
        setupBuiltin(4, "base64Binary", "org.apache.xmlbeans.XmlBase64Binary");
        setupBuiltin(5, "hexBinary", "org.apache.xmlbeans.XmlHexBinary");
        setupBuiltin(6, "anyURI", "org.apache.xmlbeans.XmlAnyURI");
        setupBuiltin(7, "QName", "org.apache.xmlbeans.XmlQName");
        setupBuiltin(8, "NOTATION", "org.apache.xmlbeans.XmlNOTATION");
        setupBuiltin(9, TypedValues.Custom.S_FLOAT, "org.apache.xmlbeans.XmlFloat");
        setupBuiltin(10, "double", "org.apache.xmlbeans.XmlDouble");
        setupBuiltin(11, "decimal", "org.apache.xmlbeans.XmlDecimal");
        setupBuiltin(12, TypedValues.Custom.S_STRING, "org.apache.xmlbeans.XmlString");
        setupBuiltin(13, "duration", "org.apache.xmlbeans.XmlDuration");
        setupBuiltin(14, "dateTime", "org.apache.xmlbeans.XmlDateTime");
        setupBuiltin(15, OaidModel.KEY_TIME, "org.apache.xmlbeans.XmlTime");
        setupBuiltin(16, "date", "org.apache.xmlbeans.XmlDate");
        setupBuiltin(17, "gYearMonth", "org.apache.xmlbeans.XmlGYearMonth");
        setupBuiltin(18, "gYear", "org.apache.xmlbeans.XmlGYear");
        setupBuiltin(19, "gMonthDay", "org.apache.xmlbeans.XmlGMonthDay");
        setupBuiltin(20, "gDay", "org.apache.xmlbeans.XmlGDay");
        setupBuiltin(21, "gMonth", "org.apache.xmlbeans.XmlGMonth");
        setupBuiltin(22, TypedValues.Custom.S_INT, "org.apache.xmlbeans.XmlInteger");
        setupBuiltin(23, "long", "org.apache.xmlbeans.XmlLong");
        setupBuiltin(24, "int", "org.apache.xmlbeans.XmlInt");
        setupBuiltin(25, "short", "org.apache.xmlbeans.XmlShort");
        setupBuiltin(26, "byte", "org.apache.xmlbeans.XmlByte");
        setupBuiltin(27, "nonPositiveInteger", "org.apache.xmlbeans.XmlNonPositiveInteger");
        setupBuiltin(28, "negativeInteger", "org.apache.xmlbeans.XmlNegativeInteger");
        setupBuiltin(29, "nonNegativeInteger", "org.apache.xmlbeans.XmlNonNegativeInteger");
        setupBuiltin(30, "positiveInteger", "org.apache.xmlbeans.XmlPositiveInteger");
        setupBuiltin(31, "unsignedLong", "org.apache.xmlbeans.XmlUnsignedLong");
        setupBuiltin(32, "unsignedInt", "org.apache.xmlbeans.XmlUnsignedInt");
        setupBuiltin(33, "unsignedShort", "org.apache.xmlbeans.XmlUnsignedShort");
        setupBuiltin(34, "unsignedByte", "org.apache.xmlbeans.XmlUnsignedByte");
        setupBuiltin(35, "normalizedString", "org.apache.xmlbeans.XmlNormalizedString");
        setupBuiltin(36, "token", "org.apache.xmlbeans.XmlToken");
        setupBuiltin(37, "Name", "org.apache.xmlbeans.XmlName");
        setupBuiltin(38, "NCName", "org.apache.xmlbeans.XmlNCName");
        setupBuiltin(39, Api.KEY_LANGUAGE, "org.apache.xmlbeans.XmlLanguage");
        setupBuiltin(40, "ID", "org.apache.xmlbeans.XmlID");
        setupBuiltin(41, "IDREF", "org.apache.xmlbeans.XmlIDREF");
        setupBuiltin(42, "IDREFS", "org.apache.xmlbeans.XmlIDREFS");
        setupBuiltin(43, "ENTITY", "org.apache.xmlbeans.XmlENTITY");
        setupBuiltin(44, "ENTITIES", "org.apache.xmlbeans.XmlENTITIES");
        setupBuiltin(45, "NMTOKEN", "org.apache.xmlbeans.XmlNMTOKEN");
        setupBuiltin(46, "NMTOKENS", "org.apache.xmlbeans.XmlNMTOKENS");
        setupBuiltin(0, null, null);
        this._container.setImmutable();
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

    private SchemaTypeImpl getBuiltinType(int r1) {
        return this._typeArray[r1];
    }

    public static SchemaType getNoType() {
        return ST_NO_TYPE;
    }

    private void setupBuiltin(int r5, String r6, String r7) {
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
        this._typeArray[r5] = r0;
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

    public void fillInType(int r14) {
        SchemaTypeImpl r13 = getBuiltinType(r14);
        switch(r14) {
            case 0: goto L30;
            case 1: goto L29;
            case 2: goto L32;
            case 3: goto L28;
            case 4: goto L28;
            case 5: goto L28;
            case 6: goto L28;
            case 7: goto L28;
            case 8: goto L28;
            case 9: goto L28;
            case 10: goto L28;
            case 11: goto L28;
            case 12: goto L28;
            case 13: goto L28;
            case 14: goto L28;
            case 15: goto L28;
            case 16: goto L28;
            case 17: goto L28;
            case 18: goto L28;
            case 19: goto L28;
            case 20: goto L28;
            case 21: goto L28;
            case 22: goto L27;
            case 23: goto L26;
            case 24: goto L25;
            case 25: goto L24;
            case 26: goto L23;
            case 27: goto L26;
            case 28: goto L22;
            case 29: goto L26;
            case 30: goto L21;
            case 31: goto L21;
            case 32: goto L20;
            case 33: goto L19;
            case 34: goto L18;
            case 35: goto L17;
            case 36: goto L16;
            case 37: goto L15;
            case 38: goto L14;
            case 39: goto L15;
            case 40: goto L13;
            case 41: goto L13;
            case 42: goto L5;
            case 43: goto L13;
            case 44: goto L5;
            case 45: goto L15;
            case 46: goto L5;
            default: goto L32;
        };
    L5:
        SchemaTypeImpl r2 = ST_ANY_SIMPLE;
        if (r14 != 42) goto L10;
        SchemaTypeImpl r3 = ST_IDREF;
    L8:
        int r4 = 3;
    L34:
        r13.setDerivationType(1);
        r13.setSimpleTypeVariety(r4);
        if (r4 == 0) goto L37;
        r13.setSimpleType(true);
    L37:
        if (r2 != null) goto L39;
        SchemaType.Ref r5 = null;
    L40:
        r13.setBaseTypeRef(r5);
        if (r2 != null) goto L43;
        int r6 = 0;
    L44:
        r13.setBaseDepth(r6);
        if (r3 != null) goto L47;
        SchemaType.Ref r7 = null;
    L48:
        r13.setListItemTypeRef(r7);
        if (r14 >= 2) goto L51;
    L54:
        if (r4 != 1) goto L63;
        if (r2 == null) goto L62;
        if (r2.getPrimitiveType() == null) goto L60;
        SchemaType.Ref r8 = r2.getPrimitiveType().getRef();
    L53:
        r13.setPrimitiveTypeRef(r8);
        goto L63
    L60:
        throw new IllegalStateException("Base.gpt was null for " + r14);
    L62:
        throw new IllegalStateException("Base was null for " + r14);
    L63:
        int r9 = 64;
        int r10 = 1000000;
        switch(r14) {
            case 0: goto L92;
            case 1: goto L92;
            case 2: goto L92;
            case 3: goto L89;
            case 4: goto L89;
            case 5: goto L89;
            case 6: goto L89;
            case 7: goto L89;
            case 8: goto L89;
            case 9: goto L89;
            case 10: goto L89;
            case 11: goto L87;
            case 12: goto L86;
            case 13: goto L89;
            case 14: goto L89;
            case 15: goto L89;
            case 16: goto L89;
            case 17: goto L89;
            case 18: goto L89;
            case 19: goto L89;
            case 20: goto L89;
            case 21: goto L89;
            case 22: goto L84;
            case 23: goto L82;
            case 24: goto L80;
            case 25: goto L78;
            case 26: goto L77;
            case 27: goto L76;
            case 28: goto L75;
            case 29: goto L74;
            case 30: goto L73;
            case 31: goto L72;
            case 32: goto L71;
            case 33: goto L70;
            case 34: goto L69;
            case 35: goto L68;
            case 36: goto L67;
            case 37: goto L67;
            case 38: goto L67;
            case 39: goto L67;
            case 40: goto L67;
            case 41: goto L67;
            case 42: goto L67;
            case 43: goto L67;
            case 44: goto L66;
            case 45: goto L67;
            case 46: goto L66;
            default: goto L92;
        };
    L66:
        XmlValueRef[] r0 = FACETS_BUILTIN_LIST;
    L93:
        boolean[] r11 = FIXED_FACETS_NONE;
        int r12 = 0;
        r10 = 0;
    L94:
        switch(r14) {
            case 0: goto L100;
            case 1: goto L100;
            case 2: goto L100;
            case 3: goto L99;
            case 4: goto L100;
            case 5: goto L100;
            case 6: goto L100;
            case 7: goto L100;
            case 8: goto L100;
            case 9: goto L98;
            case 10: goto L98;
            case 11: goto L98;
            case 12: goto L100;
            case 13: goto L97;
            case 14: goto L97;
            case 15: goto L97;
            case 16: goto L97;
            case 17: goto L97;
            case 18: goto L97;
            case 19: goto L97;
            case 20: goto L97;
            case 21: goto L97;
            case 22: goto L98;
            case 23: goto L96;
            case 24: goto L96;
            case 25: goto L96;
            case 26: goto L96;
            case 27: goto L96;
            case 28: goto L96;
            case 29: goto L96;
            case 30: goto L96;
            case 31: goto L96;
            case 32: goto L96;
            case 33: goto L96;
            case 34: goto L96;
            case 35: goto L100;
            case 36: goto L100;
            case 37: goto L100;
            case 38: goto L100;
            case 39: goto L100;
            case 40: goto L100;
            case 41: goto L100;
            case 42: goto L100;
            case 43: goto L100;
            case 44: goto L100;
            case 45: goto L100;
            case 46: goto L100;
            default: goto L100;
        };
    L96:
        int r15 = 2;
        boolean r16 = true;
    L101:
        boolean r17 = r16;
        boolean r18 = r17;
    L102:
        r13.setBasicFacets(r0, r11);
        r13.setWhiteSpaceRule(r12);
        r13.setOrdered(r15);
        r13.setBounded(r16);
        r13.setNumeric(r17);
        r13.setFinite(r18);
        r13.setDecimalSize(r10);
        r13.setAnonymousTypeRefs(EMPTY_SCHEMATYPEREF_ARRAY);
        switch(r14) {
            case 37: goto L109;
            case 38: goto L108;
            case 39: goto L107;
            case 40: goto L106;
            case 41: goto L106;
            case 42: goto L104;
            case 43: goto L106;
            case 44: goto L104;
            case 45: goto L105;
            default: goto L104;
        };
    L104:
        String r1 = null;
        boolean r19 = false;
    L111:
        if (r1 != null) goto L123;
    L116:
        r13.setPatternFacet(r19);
        if (r14 != 1) goto L119;
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
        r13.setComplexTypeVariety(4);
        r13.setContentModel(r110, r20, Collections.EMPTY_MAP, Collections.EMPTY_MAP, false);
        r13.setAnonymousTypeRefs(EMPTY_SCHEMATYPEREF_ARRAY);
        r13.setWildcardSummary(QNameSet.ALL, true, QNameSet.ALL, true);
    L121:
        r13.setOrderSensitive(false);
        return;
    L119:
        if (r14 != 0) goto L121;
        SchemaAttributeModelImpl r21 = new SchemaAttributeModelImpl();
        r13.setComplexTypeVariety(1);
        r13.setContentModel(null, r21, Collections.EMPTY_MAP, Collections.EMPTY_MAP, false);
        r13.setAnonymousTypeRefs(EMPTY_SCHEMATYPEREF_ARRAY);
        r13.setWildcardSummary(QNameSet.EMPTY, false, QNameSet.EMPTY, false);
        goto L121
    L123:
        RegularExpression r22 = SchemaRegularExpression.forPattern(r1);     // Catch: ParseException -> L114
    L115:
        r13.setPatterns(new RegularExpression[]{r22});
    L114:
        r22 = null;
        goto L115
    L105:
        r1 = "\\c+";
    L110:
        r19 = true;
        goto L111
    L106:
        r1 = null;
        goto L110
    L107:
        r1 = "[a-zA-Z]{1,8}(-[a-zA-Z0-9]{1,8})*";
        goto L110
    L108:
        r1 = "[\\i-[:]][\\c-[:]]*";
        goto L110
    L109:
        r1 = "\\i\\c*";
        goto L110
    L97:
        r16 = false;
        r17 = false;
        r18 = false;
        r15 = 1;
        goto L102
    L98:
        r15 = 2;
        r16 = false;
        r18 = false;
        r17 = true;
        goto L102
    L99:
        r15 = 0;
        r16 = false;
        r17 = false;
        r18 = true;
        goto L102
    L100:
        r15 = 0;
        r16 = false;
        goto L101
    L67:
        XmlValueRef[] r23 = FACETS_WS_COLLAPSE;
        r11 = FIXED_FACETS_NONE;
    L90:
        r10 = 0;
    L91:
        XmlValueRef[] r111 = r23;
        r12 = 3;
        r0 = r111;
        goto L94
    L68:
        r0 = FACETS_WS_REPLACE;
        r11 = FIXED_FACETS_NONE;
        r12 = 2;
        r10 = 0;
        goto L94
    L69:
        XmlValueRef[] r24 = FACETS_UNSIGNED_BYTE;
    L79:
        r10 = 16;
        r12 = 3;
        r0 = r24;
        r11 = FIXED_FACETS_INTEGER;
        goto L94
    L70:
        r23 = FACETS_UNSIGNED_SHORT;
    L81:
        r10 = 32;
        r11 = FIXED_FACETS_INTEGER;
        goto L91
    L71:
        r23 = FACETS_UNSIGNED_INT;
    L83:
        r11 = FIXED_FACETS_INTEGER;
    L88:
        r10 = r9;
        goto L91
    L72:
        r23 = FACETS_UNSIGNED_LONG;
    L85:
        r11 = FIXED_FACETS_INTEGER;
        goto L91
    L73:
        r23 = FACETS_POSITIVE;
        goto L85
    L74:
        r23 = FACETS_NONNEGATIVE;
        goto L85
    L75:
        r23 = FACETS_NEGATIVE;
        goto L85
    L76:
        r23 = FACETS_NONPOSITIVE;
        goto L85
    L77:
        r23 = FACETS_BYTE;
        r11 = FIXED_FACETS_INTEGER;
        r9 = 8;
        goto L88
    L78:
        r24 = FACETS_SHORT;
        goto L79
    L80:
        r23 = FACETS_INT;
        goto L81
    L82:
        r23 = FACETS_LONG;
        goto L83
    L84:
        r23 = FACETS_INTEGER;
        goto L85
    L86:
        r0 = FACETS_WS_PRESERVE;
        r11 = FIXED_FACETS_NONE;
        r10 = 0;
        r12 = 1;
        goto L94
    L87:
        r23 = FACETS_WS_COLLAPSE;
        r11 = FIXED_FACETS_WS;
        r9 = 1000001;
        goto L88
    L89:
        r23 = FACETS_WS_COLLAPSE;
        r11 = FIXED_FACETS_WS;
        goto L90
    L92:
        r0 = FACETS_NONE;
        goto L93
    L51:
        if (r14 > 21) goto L54;
        r8 = r13.getRef();
        goto L53
    L47:
        r7 = r3.getRef();
        goto L48
    L43:
        r6 = ((SchemaTypeImpl) ZeusTransformUtils.preCheckCast(r2, SchemaTypeImpl.class, "com.obric.memorydata.plugin")).getBaseDepth() + 1;
        goto L44
    L39:
        r5 = r2.getRef();
        goto L40
    L10:
        if (r14 != 44) goto L12;
        r3 = ST_ENTITY;
        goto L8
    L12:
        r3 = ST_NMTOKEN;
        goto L8
    L13:
        r2 = ST_NCNAME;
    L33:
        r3 = null;
        r4 = 1;
        goto L34
    L14:
        r2 = ST_NAME;
        goto L33
    L15:
        r2 = ST_TOKEN;
        goto L33
    L16:
        r2 = ST_NORMALIZED_STRING;
        goto L33
    L17:
        r2 = ST_STRING;
        goto L33
    L18:
        r2 = ST_UNSIGNED_SHORT;
        goto L33
    L19:
        r2 = ST_UNSIGNED_INT;
        goto L33
    L20:
        r2 = ST_UNSIGNED_LONG;
        goto L33
    L21:
        r2 = ST_NON_NEGATIVE_INTEGER;
        goto L33
    L22:
        r2 = ST_NON_POSITIVE_INTEGER;
        goto L33
    L23:
        r2 = ST_SHORT;
        goto L33
    L24:
        r2 = ST_INT;
        goto L33
    L25:
        r2 = ST_LONG;
        goto L33
    L26:
        r2 = ST_INTEGER;
        goto L33
    L27:
        r2 = ST_DECIMAL;
        goto L33
    L28:
        r2 = ST_ANY_SIMPLE;
        goto L33
    L29:
        r2 = null;
        r3 = null;
    L31:
        r4 = 0;
        goto L34
    L30:
        r2 = ST_ANY_TYPE;
        r3 = null;
        goto L31
    L32:
        r2 = ST_ANY_TYPE;
        goto L33
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
