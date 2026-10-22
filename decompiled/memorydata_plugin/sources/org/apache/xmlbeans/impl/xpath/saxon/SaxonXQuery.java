package org.apache.xmlbeans.impl.xpath.saxon;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URI;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.Duration;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;
import javax.xml.transform.TransformerException;
import javax.xml.xpath.XPathException;
import net.sf.saxon.Configuration;
import net.sf.saxon.dom.DOMNodeWrapper;
import net.sf.saxon.dom.DocumentWrapper;
import net.sf.saxon.dom.NodeOverNodeInfo;
import net.sf.saxon.ma.map.HashTrieMap;
import net.sf.saxon.om.Item;
import net.sf.saxon.om.NodeInfo;
import net.sf.saxon.om.StructuredQName;
import net.sf.saxon.query.DynamicQueryContext;
import net.sf.saxon.query.StaticQueryContext;
import net.sf.saxon.query.XQueryExpression;
import net.sf.saxon.str.StringView;
import net.sf.saxon.type.BuiltInAtomicType;
import net.sf.saxon.value.AnyURIValue;
import net.sf.saxon.value.AtomicValue;
import net.sf.saxon.value.BigDecimalValue;
import net.sf.saxon.value.BigIntegerValue;
import net.sf.saxon.value.BooleanValue;
import net.sf.saxon.value.DateTimeValue;
import net.sf.saxon.value.DateValue;
import net.sf.saxon.value.DoubleValue;
import net.sf.saxon.value.DurationValue;
import net.sf.saxon.value.FloatValue;
import net.sf.saxon.value.GDayValue;
import net.sf.saxon.value.GMonthDayValue;
import net.sf.saxon.value.GMonthValue;
import net.sf.saxon.value.GYearMonthValue;
import net.sf.saxon.value.GYearValue;
import net.sf.saxon.value.HexBinaryValue;
import net.sf.saxon.value.Int64Value;
import net.sf.saxon.value.ObjectValue;
import net.sf.saxon.value.QNameValue;
import net.sf.saxon.value.SaxonDuration;
import net.sf.saxon.value.SaxonXMLGregorianCalendar;
import net.sf.saxon.value.StringValue;
import net.sf.saxon.value.TimeValue;
import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlDate;
import org.apache.xmlbeans.XmlDecimal;
import org.apache.xmlbeans.XmlDouble;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlFloat;
import org.apache.xmlbeans.XmlInteger;
import org.apache.xmlbeans.XmlLong;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlRuntimeException;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.XmlTokenSource;
import org.apache.xmlbeans.impl.store.Cur;
import org.apache.xmlbeans.impl.store.Locale;
import org.apache.xmlbeans.impl.xpath.XQuery;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes7.dex */
public class SaxonXQuery implements XQuery {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final c LOG = null;
    private Cur _cur;
    private XmlOptions _options;
    private long _version;
    private final Configuration config;
    private final String contextVar;
    private final XQueryExpression xquery;

    static {
        LOG = b.a(SaxonXQuery.class);
    }

    public SaxonXQuery(String r4, String r5, Integer r6, XmlOptions r7) {
        this._options = r7;
        Configuration r0 = new Configuration();
        this.config = r0;
        final StaticQueryContext r1 = r0.newStaticQueryContext();
        Map<String, String> r8 = r7.getLoadAdditionalNamespaces();
        if (r8 == null) goto L5;
        r1.getClass();
        r8.forEach(new $$Lambda$SaxonXQuery$_Tz2k8_vwYuEYdigSe8HRbiobkg(r1));
    L5:
        this.contextVar = r5;
        this.xquery = r1.compileQuery(r4.substring(0, r6.intValue()) + " declare variable $" + r5 + " external;" + r4.substring(r6.intValue()));     // Catch: TransformerException -> L8
        return;
    L8:
        e = move-exception;
        throw new XmlRuntimeException(e);
    }

    private SchemaType getType(Object r1) {
        if (ZeusTransformUtils.instanceOf(r1, Integer.class) == false) goto L6;
        return XmlInteger.type;
    L6:
        if (ZeusTransformUtils.instanceOf(r1, Double.class) == false) goto L9;
        return XmlDouble.type;
    L9:
        if (ZeusTransformUtils.instanceOf(r1, Long.class) == false) goto L12;
        return XmlLong.type;
    L12:
        if (ZeusTransformUtils.instanceOf(r1, Float.class) == false) goto L15;
        return XmlFloat.type;
    L15:
        if (ZeusTransformUtils.instanceOf(r1, BigDecimal.class) == false) goto L18;
        return XmlDecimal.type;
    L18:
        if (ZeusTransformUtils.instanceOf(r1, Boolean.class) == false) goto L21;
        return XmlBoolean.type;
    L21:
        if (ZeusTransformUtils.instanceOf(r1, String.class) == false) goto L24;
        return XmlString.type;
    L24:
        if (ZeusTransformUtils.instanceOf(r1, Date.class) == false) goto L27;
        return XmlDate.type;
    L27:
        return XmlAnySimpleType.type;
    }

    public static /* synthetic */ void lambda$_Tz2k8_vwYuEYdigSe8HRbiobkg(StaticQueryContext r0, String r1, String r2) {
        r0.declareNamespace(r1, r2);
    }

    private Cur loadNode(Locale r3, Node r4) {
        Node r5 = (Node) ZeusTransformUtils.wrapperContextForParams(r4, Node.class, "com.obric.memorydata.plugin");
        Cur.CurLoadContext r0 = new Cur.CurLoadContext(r3, this._options);
        loadNodeHelper(r3, r5, r0);     // Catch: Exception -> L5
        Cur r6 = r0.finish();     // Catch: Exception -> L5
        Locale.associateSourceName(r6, this._options);     // Catch: Exception -> L5
        Locale.autoTypeDocument(r6, null, this._options);     // Catch: Exception -> L5
        return r6;
    L5:
        e = move-exception;
        throw new XmlRuntimeException(e.getMessage(), e);
    }

    private void loadNodeHelper(Locale r3, Node r4, Locale.LoadContext r5) {
        Node r2 = (Node) ZeusTransformUtils.wrapperContextForParams(r4, Node.class, "com.obric.memorydata.plugin");
        if (r2.getNodeType() != 2) goto L5;
        r5.attr(new QName(r2.getNamespaceURI(), r2.getLocalName(), r2.getPrefix()), r2.getNodeValue());
        return;
    L5:
        r3.loadNode(r2, r5);
    }

    private static Item objectToItem(Object r12, Configuration r13) {
        Configuration r14 = (Configuration) ZeusTransformUtils.wrapperContextForParams(r13, Configuration.class, "com.obric.memorydata.plugin");
        if (r12 != null) goto L7;
        return null;
    L7:
        if (ZeusTransformUtils.instanceOf(r12, Boolean.class) == false) goto L11;
        return BooleanValue.get(((Boolean) ZeusTransformUtils.preCheckCast(r12, Boolean.class, "com.obric.memorydata.plugin")).booleanValue());
    L11:
        if ((r12 instanceof byte[]) == true) goto L13;
        boolean r1 = false;
        if (ZeusTransformUtils.instanceOf(r12, Byte.class) == false) goto L19;
        return new Int64Value(((Byte) ZeusTransformUtils.preCheckCast(r12, Byte.class, "com.obric.memorydata.plugin")).byteValue(), BuiltInAtomicType.BYTE, false);
    L19:
        if (ZeusTransformUtils.instanceOf(r12, Float.class) == false) goto L23;
        return new FloatValue(((Float) ZeusTransformUtils.preCheckCast(r12, Float.class, "com.obric.memorydata.plugin")).floatValue());
    L23:
        if (ZeusTransformUtils.instanceOf(r12, Double.class) == false) goto L27;
        return new DoubleValue(((Double) ZeusTransformUtils.preCheckCast(r12, Double.class, "com.obric.memorydata.plugin")).doubleValue());
    L27:
        if (ZeusTransformUtils.instanceOf(r12, Integer.class) == false) goto L31;
        return new Int64Value(((Integer) ZeusTransformUtils.preCheckCast(r12, Integer.class, "com.obric.memorydata.plugin")).intValue(), BuiltInAtomicType.INT, false);
    L31:
        if (ZeusTransformUtils.instanceOf(r12, Long.class) == false) goto L35;
        return new Int64Value(((Long) ZeusTransformUtils.preCheckCast(r12, Long.class, "com.obric.memorydata.plugin")).longValue(), BuiltInAtomicType.LONG, false);
    L35:
        if (ZeusTransformUtils.instanceOf(r12, Short.class) == false) goto L39;
        return new Int64Value(((Short) ZeusTransformUtils.preCheckCast(r12, Short.class, "com.obric.memorydata.plugin")).shortValue(), BuiltInAtomicType.SHORT, false);
    L39:
        if (ZeusTransformUtils.instanceOf(r12, String.class) == false) goto L43;
        return new StringValue((String) ZeusTransformUtils.preCheckCast(r12, String.class, "com.obric.memorydata.plugin"));
    L43:
        if (ZeusTransformUtils.instanceOf(r12, BigDecimal.class) == false) goto L47;
        return new BigDecimalValue((BigDecimal) ZeusTransformUtils.preCheckCast(r12, BigDecimal.class, "com.obric.memorydata.plugin"));
    L47:
        if (ZeusTransformUtils.instanceOf(r12, BigInteger.class) == false) goto L51;
        return new BigIntegerValue((BigInteger) ZeusTransformUtils.preCheckCast(r12, BigInteger.class, "com.obric.memorydata.plugin"));
    L51:
        if (ZeusTransformUtils.instanceOf(r12, SaxonDuration.class) == false) goto L55;
        return ((SaxonDuration) ZeusTransformUtils.preCheckCast(r12, SaxonDuration.class, "com.obric.memorydata.plugin")).getDurationValue();
    L55:
        if (ZeusTransformUtils.instanceOf(r12, Duration.class) == false) goto L62;
        Duration r15 = (Duration) ZeusTransformUtils.preCheckCast(r12, Duration.class, "com.obric.memorydata.plugin");
        if (r15.getSign() < 0) goto L60;
        r1 = true;
    L60:
        return new DurationValue(r1, r15.getYears(), r15.getMonths(), r15.getDays(), r15.getHours(), r15.getMinutes(), r15.getSeconds(), 0);
    L62:
        if (ZeusTransformUtils.instanceOf(r12, SaxonXMLGregorianCalendar.class) == false) goto L66;
        return ((SaxonXMLGregorianCalendar) ZeusTransformUtils.preCheckCast(r12, SaxonXMLGregorianCalendar.class, "com.obric.memorydata.plugin")).toCalendarValue();
    L66:
        if (ZeusTransformUtils.instanceOf(r12, XMLGregorianCalendar.class) == false) goto L105;
        QName r0 = ((XMLGregorianCalendar) ZeusTransformUtils.preCheckCast(r12, XMLGregorianCalendar.class, "com.obric.memorydata.plugin")).getXMLSchemaType();
        if (r0.equals(DatatypeConstants.DATETIME) == false) goto L72;
        return DateTimeValue.makeDateTimeValue(StringView.tidy(r12.toString()), r14.getConversionRules()).asAtomic();
    L72:
        if (r0.equals(DatatypeConstants.DATE) == false) goto L76;
        return DateValue.makeDateValue(StringView.tidy(r12.toString()), r14.getConversionRules()).asAtomic();
    L76:
        if (r0.equals(DatatypeConstants.TIME) == false) goto L80;
        return TimeValue.makeTimeValue(StringView.tidy(r12.toString())).asAtomic();
    L80:
        if (r0.equals(DatatypeConstants.GYEAR) == false) goto L84;
        return GYearValue.makeGYearValue(StringView.tidy(r12.toString()), r14.getConversionRules()).asAtomic();
    L84:
        if (r0.equals(DatatypeConstants.GYEARMONTH) == false) goto L88;
        return GYearMonthValue.makeGYearMonthValue(StringView.tidy(r12.toString()), r14.getConversionRules()).asAtomic();
    L88:
        if (r0.equals(DatatypeConstants.GMONTH) == false) goto L95;
        String r16 = r12.toString();
        if (r16.endsWith("--") == false) goto L93;
        r16 = r16.substring(0, r16.length() - 2);
    L93:
        return GMonthValue.makeGMonthValue(StringView.tidy(r16)).asAtomic();
    L95:
        if (r0.equals(DatatypeConstants.GMONTHDAY) == false) goto L99;
        return GMonthDayValue.makeGMonthDayValue(StringView.tidy(r12.toString())).asAtomic();
    L99:
        if (r0.equals(DatatypeConstants.GDAY) == false) goto L103;
        return GDayValue.makeGDayValue(StringView.tidy(r12.toString())).asAtomic();
    L103:
        throw new AssertionError("Unknown Gregorian date type");
    L105:
        if (ZeusTransformUtils.instanceOf(r12, QName.class) == false) goto L109;
        QName r17 = (QName) ZeusTransformUtils.preCheckCast(r12, QName.class, "com.obric.memorydata.plugin");
        return new QNameValue(r17.getPrefix(), r17.getNamespaceURI(), r17.getLocalPart());
    L109:
        if (ZeusTransformUtils.instanceOf(r12, URI.class) == false) goto L113;
        return new AnyURIValue(r12.toString());
    L113:
        if (ZeusTransformUtils.instanceOf(r12, Map.class) == false) goto L120;
        HashTrieMap r2 = new HashTrieMap();
        Iterator r18 = ((Map) ZeusTransformUtils.preCheckCast(r12, Map.class, "com.obric.memorydata.plugin")).entrySet().iterator();
    L116:
        if (r18.hasNext() == false) goto L118;
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r18.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        r2.initialPut((AtomicValue) ZeusTransformUtils.preCheckCast(objectToItem(r3.getKey(), r14), AtomicValue.class, "com.obric.memorydata.plugin"), objectToItem(r3.getValue(), r14));
        goto L116
    L118:
        return r2;
    L120:
        return new ObjectValue(r12);
    L13:
        return new HexBinaryValue((byte[]) ZeusTransformUtils.preCheckCast((byte[]) ZeusTransformUtils.preCheckCast(r12, byte[].class, "com.obric.memorydata.plugin"), byte[].class, "com.obric.memorydata.plugin"));
    }

    public List<Object> execQuery(Object r9, Map<String, Object> r10) {
        Map r11 = (Map) ZeusTransformUtils.wrapperContextForParams(r10, Map.class, "com.obric.memorydata.plugin");
        Node r12 = (Node) ZeusTransformUtils.preCheckCast(r9, Node.class, "com.obric.memorydata.plugin");     // Catch: TransformerException -> L29
        if (r12.getNodeType() != 9) goto L6;
        Document r1 = (Document) ZeusTransformUtils.preCheckCast(r12, Document.class, "com.obric.memorydata.plugin");     // Catch: TransformerException -> L29
    L7:
        DocumentWrapper r3 = new DocumentWrapper(r1, null, this.config);     // Catch: TransformerException -> L29
        DOMNodeWrapper r13 = r3.wrap(r12);     // Catch: TransformerException -> L29
        DynamicQueryContext r2 = new DynamicQueryContext(this.config);     // Catch: TransformerException -> L29
        r2.setContextItem(r13);     // Catch: TransformerException -> L29
        r2.setParameter(new StructuredQName("", null, this.contextVar), r13);     // Catch: TransformerException -> L29
        if (r11 == null) goto L21;
        Iterator r14 = r11.entrySet().iterator();     // Catch: TransformerException -> L29
    L11:
        if (r14.hasNext() == false) goto L21;
        Map.Entry r15 = (Map.Entry) ZeusTransformUtils.preCheckCast(r14.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: TransformerException -> L29
        StructuredQName r4 = new StructuredQName("", null, (String) ZeusTransformUtils.preCheckCast(r15.getKey(), String.class, "com.obric.memorydata.plugin"));     // Catch: TransformerException -> L29
        Object r16 = r15.getValue();     // Catch: TransformerException -> L29
        if (ZeusTransformUtils.instanceOf(r16, XmlTokenSource.class) == true) goto L14;
        r2.setParameter(r4, objectToItem(r16, this.config));     // Catch: XPathException -> L18 TransformerException -> L29
    L18:
        e = move-exception;
        throw new RuntimeException(e);     // Catch: TransformerException -> L29
    L14:
        r2.setParameter(r4, r3.wrap(((XmlTokenSource) ZeusTransformUtils.preCheckCast(r16, XmlTokenSource.class, "com.obric.memorydata.plugin")).getDomNode()));     // Catch: TransformerException -> L29
    L21:
        List<Object> r17 = this.xquery.evaluate(r2);     // Catch: TransformerException -> L29
        ListIterator<Object> r18 = r17.listIterator();     // Catch: TransformerException -> L29
    L23:
        if (r18.hasNext() == false) goto L28;
        Object r0 = r18.next();     // Catch: TransformerException -> L29
        if (ZeusTransformUtils.instanceOf(r0, NodeInfo.class) == false) goto L23;
        r18.set(NodeOverNodeInfo.wrap((NodeInfo) ZeusTransformUtils.preCheckCast(r0, NodeInfo.class, "com.obric.memorydata.plugin")));     // Catch: TransformerException -> L29
        goto L23
    L28:
        return r17;
    L6:
        r1 = r12.getOwnerDocument();     // Catch: TransformerException -> L29
    L29:
        e = move-exception;
        throw new RuntimeException("Error binding " + this.contextVar, e);
    }

    @Override // org.apache.xmlbeans.impl.xpath.XQuery
    public XmlObject[] objectExecute(Cur r6, XmlOptions r7) {
        this._version = r6.getLocale().version();
        this._cur = r6.weakCur(this);
        this._options = r7;
        Map<String, Object> r8 = XmlOptions.maskNull(r7).getXqueryVariables();
        List<Object> r9 = execQuery(this._cur.getDom(), r8);
        XmlObject[] r10 = new XmlObject[r9.size()];
        int r0 = 0;
    L4:
        if (r0 >= r9.size()) goto L19;
        Locale r1 = Locale.getLocale(this._cur.getLocale().getSchemaTypeLoader(), this._options);
        r1.enter();
        Object r2 = r9.get(r0);
        if (ZeusTransformUtils.instanceOf(r2, Node.class) == true) goto L9;
        Cur r3 = r1.load("<xml-fragment/>").tempCur();     // Catch: Throwable -> L12 XmlException -> L14
        r3.setValue(r2.toString());     // Catch: Throwable -> L12 XmlException -> L14
        Locale.autoTypeDocument(r3, getType(r2), null);     // Catch: Throwable -> L12 XmlException -> L14
        r10[r0] = r3.getObject();     // Catch: Throwable -> L12 XmlException -> L14
    L10:
        r10[r0] = r3.getObject();     // Catch: Throwable -> L12 XmlException -> L14
        r1.exit();
        r3.release();
        r0 = r0 + 1;
        goto L4
    L9:
        r3 = loadNode(r1, (Node) ZeusTransformUtils.preCheckCast(r2, Node.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L12 XmlException -> L14
        goto L10
    L14:
        e = move-exception;
        throw new RuntimeException(e);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        r1.exit();
        throw th;
    L19:
        release();
        return r10;
    }

    public void release() {
        Cur r0 = this._cur;
        if (r0 == null) goto L6;
        r0.release();
        this._cur = null;
        return;
    }
}
