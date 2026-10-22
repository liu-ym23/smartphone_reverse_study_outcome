package com.ctc.wstx.shaded.msv_core.datatype.xsd;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.ctc.wstx.shaded.msv.relaxng_datatype.DatatypeException;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map f3569a = null;

    static {
        f3569a = a();
    }

    public static synchronized XSDatatype a(String r6) {
        monitor-enter(b.class);
        Map r1 = f3569a;     // Catch: Throwable -> L102
        XSDatatype r2 = (XSDatatype) ZeusTransformUtils.preCheckCast(r1.get(r6), XSDatatype.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L102
        if (r2 == null) goto L105;
        monitor-exit(b.class);
        return r2;
    L105:
        if (r6.equals(TypedValues.Custom.S_FLOAT) == false) goto L13;
        XSDatatypeImpl r3 = FloatType.theInstance;     // Catch: DatatypeException -> L100 Throwable -> L102
    L11:
        a(r1, r3);     // Catch: DatatypeException -> L100 Throwable -> L102
    L94:
        XSDatatype r4 = (XSDatatype) ZeusTransformUtils.preCheckCast(r1.get(r6), XSDatatype.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L102
        if (r4 == null) goto L99;
        monitor-exit(b.class);
        return r4;
    L99:
        throw new DatatypeException("undefined type name:" + r6);     // Catch: Throwable -> L102
        goto L101
    L13:
        if (r6.equals("double") == false) goto L16;
        r3 = DoubleType.theInstance;     // Catch: DatatypeException -> L100 Throwable -> L102
        goto L11
    L16:
        if (r6.equals("duration") == false) goto L19;
        r3 = DurationType.theInstance;     // Catch: DatatypeException -> L100 Throwable -> L102
        goto L11
    L19:
        if (r6.equals("dateTime") == false) goto L22;
        r3 = DateTimeType.theInstance;     // Catch: DatatypeException -> L100 Throwable -> L102
        goto L11
    L22:
        if (r6.equals(OaidModel.KEY_TIME) == false) goto L25;
        r3 = TimeType.theInstance;     // Catch: DatatypeException -> L100 Throwable -> L102
        goto L11
    L25:
        if (r6.equals("date") == false) goto L28;
        r3 = DateType.theInstance;     // Catch: DatatypeException -> L100 Throwable -> L102
        goto L11
    L28:
        if (r6.equals("gYearMonth") == false) goto L31;
        r3 = GYearMonthType.theInstance;     // Catch: DatatypeException -> L100 Throwable -> L102
        goto L11
    L31:
        if (r6.equals("gYear") == false) goto L34;
        r3 = GYearType.theInstance;     // Catch: DatatypeException -> L100 Throwable -> L102
        goto L11
    L34:
        if (r6.equals("gMonthDay") == false) goto L37;
        r3 = GMonthDayType.theInstance;     // Catch: DatatypeException -> L100 Throwable -> L102
        goto L11
    L37:
        if (r6.equals("gDay") == false) goto L40;
        r3 = GDayType.theInstance;     // Catch: DatatypeException -> L100 Throwable -> L102
        goto L11
    L40:
        if (r6.equals("gMonth") == false) goto L43;
        r3 = GMonthType.theInstance;     // Catch: DatatypeException -> L100 Throwable -> L102
        goto L11
    L43:
        if (r6.equals("hexBinary") == false) goto L46;
        r3 = HexBinaryType.theInstance;     // Catch: DatatypeException -> L100 Throwable -> L102
        goto L11
    L46:
        if (r6.equals("base64Binary") == false) goto L49;
        r3 = Base64BinaryType.theInstance;     // Catch: DatatypeException -> L100 Throwable -> L102
        goto L11
    L49:
        if (r6.equals("anyURI") == false) goto L52;
        r3 = AnyURIType.theInstance;     // Catch: DatatypeException -> L100 Throwable -> L102
        goto L11
    L52:
        if (r6.equals("ENTITY") == false) goto L55;
        r3 = EntityType.theInstance;     // Catch: DatatypeException -> L100 Throwable -> L102
        goto L11
    L55:
        if (r6.equals(Api.KEY_LANGUAGE) == false) goto L58;
        r3 = LanguageType.theInstance;     // Catch: DatatypeException -> L100 Throwable -> L102
        goto L11
    L58:
        if (r6.equals("ID") == false) goto L61;
        r3 = IDType.theInstance;     // Catch: DatatypeException -> L100 Throwable -> L102
        goto L11
    L61:
        if (r6.equals("IDREF") == false) goto L64;
        r3 = IDREFType.theInstance;     // Catch: DatatypeException -> L100 Throwable -> L102
        goto L11
    L64:
        if (r6.equals("IDREFS") == false) goto L67;
        r3 = a("IDREFS", IDREFType.theInstance);     // Catch: DatatypeException -> L100 Throwable -> L102
        goto L11
    L67:
        if (r6.equals("ENTITIES") == false) goto L70;
        r3 = a("ENTITIES", EntityType.theInstance);     // Catch: DatatypeException -> L100 Throwable -> L102
        goto L11
    L70:
        if (r6.equals("NMTOKENS") == false) goto L73;
        r3 = a("NMTOKENS", NmtokenType.theInstance);     // Catch: DatatypeException -> L100 Throwable -> L102
        goto L11
    L73:
        if (r6.equals("NOTATION") == false) goto L76;
        r3 = new StringType("NOTATION", WhiteSpaceProcessor.theCollapse, false);     // Catch: DatatypeException -> L100 Throwable -> L102
        goto L11
    L76:
        if (r6.equals("nonPositiveInteger") == false) goto L79;
        r3 = NonPositiveIntegerType.theInstance;     // Catch: DatatypeException -> L100 Throwable -> L102
        goto L11
    L79:
        if (r6.equals("unsignedLong") == false) goto L82;
        r3 = UnsignedLongType.theInstance;     // Catch: DatatypeException -> L100 Throwable -> L102
        goto L11
    L82:
        if (r6.equals("unsignedInt") == false) goto L85;
        r3 = UnsignedIntType.theInstance;     // Catch: DatatypeException -> L100 Throwable -> L102
        goto L11
    L85:
        if (r6.equals("unsignedShort") == false) goto L88;
        r3 = UnsignedShortType.theInstance;     // Catch: DatatypeException -> L100 Throwable -> L102
        goto L11
    L88:
        if (r6.equals("unsignedByte") == false) goto L91;
        r3 = UnsignedByteType.theInstance;     // Catch: DatatypeException -> L100 Throwable -> L102
        goto L11
    L91:
        if (r6.equals("anySimpleType") == false) goto L94;
        r3 = SimpleURType.theInstance;     // Catch: DatatypeException -> L100 Throwable -> L102
    L101:
        throw new Error();     // Catch: Throwable -> L102
    L102:
        th = move-exception;
        throw th;
    }

    public static XSDatatype a(String r3, String r4, XSDatatype r5) {
        XSDatatype r6 = (XSDatatype) ZeusTransformUtils.wrapperContextForParams(r5, XSDatatype.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r6, ErrorType.class) == false) goto L6;
        return r6;
    L6:
        return new ListType(r3, r4, (XSDatatypeImpl) ZeusTransformUtils.preCheckCast(r6, XSDatatypeImpl.class, "com.obric.memorydata.plugin"));
    }

    public static XSDatatype a(String r3, String r4, XSDatatype[] r5) {
        int r0 = 0;
    L4:
        if (r0 >= r5.length) goto L11;
        if (ZeusTransformUtils.instanceOf(r5[r0], ErrorType.class) == true) goto L8;
        r0 = r0 + 1;
        goto L4
    L8:
        return r5[r0];
    L11:
        return new UnionType(r3, r4, r5);
    }

    private static XSDatatypeImpl a(final String r4, XSDatatypeImpl r5) {
        d r0 = new d(new ListType(null, null, r5));
        r0.a(XSDatatype.FACET_MINLENGTH, "1", false, null);
        final XSDatatypeImpl r1 = r0.a(null, null);
        final String r2 = "http://www.w3.org/2001/XMLSchema";
        return new DatatypeFactory$1(r2, r4, r1);
    }

    private static Map a() {
        HashMap r0 = new HashMap();
        a(r0, StringType.theInstance);
        a(r0, BooleanType.theInstance);
        a(r0, NumberType.theInstance);
        a(r0, QnameType.theInstance);
        a(r0, NormalizedStringType.theInstance);
        a(r0, TokenType.theInstance);
        a(r0, NmtokenType.theInstance);
        a(r0, NameType.theInstance);
        a(r0, NcnameType.theInstance);
        a(r0, IntegerType.theInstance);
        a(r0, NegativeIntegerType.theInstance);
        a(r0, LongType.theInstance);
        a(r0, IntType.theInstance);
        a(r0, ShortType.theInstance);
        a(r0, ByteType.theInstance);
        a(r0, NonNegativeIntegerType.theInstance);
        a(r0, PositiveIntegerType.theInstance);
        return r0;
    }

    private static void a(Map r2, XSDatatypeImpl r3) {
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin");
        String r0 = r3.getName();
        if (r0 == null) goto L11;
        if (r4.containsKey(r0) == true) goto L9;
        r4.put(r0, r3);
        return;
    L9:
        throw new IllegalArgumentException("multiple definition");
    L11:
        throw new IllegalArgumentException("anonymous type");
    }
}
