package org.apache.xmlbeans.impl.values;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import javax.xml.namespace.QName;
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.common.PrefixResolver;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.common.ValidationContext;
import org.apache.xmlbeans.impl.common.XMLChar;
import org.apache.xmlbeans.impl.schema.BuiltinSchemaTypeSystem;

/* JADX INFO: loaded from: classes7.dex */
public class JavaQNameHolder extends XmlObjectBase {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final NamespaceManager PRETTY_PREFIXER = null;
    private QName _value;

    /* JADX INFO: renamed from: org.apache.xmlbeans.impl.values.JavaQNameHolder$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class PrettyNamespaceManager implements NamespaceManager {
        private PrettyNamespaceManager() {
        }

        /* synthetic */ PrettyNamespaceManager(AnonymousClass1 r1) {
            this();
        }

        @Override // org.apache.xmlbeans.impl.values.NamespaceManager
        public String find_prefix_for_nsuri(String r1, String r2) {
            return QNameHelper.suggestPrefix(r1);
        }

        @Override // org.apache.xmlbeans.impl.common.PrefixResolver
        public String getNamespaceForPrefix(String r1) {
            throw new RuntimeException("Should not be called");
        }
    }

    static {
        PRETTY_PREFIXER = new PrettyNamespaceManager(null);
    }

    public JavaQNameHolder() {
    }

    private static QName parse(String r8, PrefixResolver r9) {
        PrefixResolver r10 = (PrefixResolver) ZeusTransformUtils.wrapperContextForParams(r9, PrefixResolver.class, "com.obric.memorydata.plugin");
        int r0 = r8.length();
    L3:
        if (r0 <= 0) goto L8;
        if (XMLChar.isSpace(r8.charAt(r0 - 1)) == false) goto L8;
        r0 = r0 - 1;
    L8:
        int r2 = 0;
    L9:
        if (r2 >= r0) goto L14;
        if (XMLChar.isSpace(r8.charAt(r2)) == false) goto L14;
        r2 = r2 + 1;
    L14:
        int r3 = r8.indexOf(58, r2);
        String r4 = "";
        if (r3 < 0) goto L17;
        String r5 = r8.substring(r2, r3);
        String r1 = r8.substring(r3 + 1, r0);
    L19:
        if (r5.length() <= 0) goto L26;
        if (XMLChar.isValidNCName(r5) == true) goto L26;
        throw new XmlValueOutOfRangeException("QName", new Object[]{"Prefix not a valid NCName in '" + r8 + "'"});
    L26:
        if (XMLChar.isValidNCName(r1) == false) goto L45;
        if (r10 != null) goto L29;
        String r11 = null;
    L30:
        if (r11 == null) goto L32;
        r4 = r11;
    L37:
        if (r5 == null) goto L43;
        if (r5.length() <= 0) goto L43;
        return new QName(r4, r1, r5);
    L43:
        return new QName(r4, r1);
    L32:
        if (r5.length() <= 0) goto L37;
        throw new XmlValueOutOfRangeException("QName", new Object[]{"Can't resolve prefix '" + r5 + "'"});
    L29:
        r11 = r10.getNamespaceForPrefix(r5);
        goto L30
    L45:
        throw new XmlValueOutOfRangeException("QName", new Object[]{"Localname not a valid NCName in '" + r8 + "'"});
    L17:
        r1 = r8.substring(r2, r0);
        r5 = "";
        goto L19
    }

    public static QName validateLexical(String r2, ValidationContext r3, PrefixResolver r4) {
        ValidationContext r5 = (ValidationContext) ZeusTransformUtils.wrapperContextForParams(r3, ValidationContext.class, "com.obric.memorydata.plugin");
        return parse(r2, (PrefixResolver) ZeusTransformUtils.wrapperContextForParams(r4, PrefixResolver.class, "com.obric.memorydata.plugin"));
    L5:
        e = move-exception;
        r5.invalid(e.getMessage());
        return null;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public String compute_text(NamespaceManager r3) {
        NamespaceManager r4 = (NamespaceManager) ZeusTransformUtils.wrapperContextForParams(r3, NamespaceManager.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L5;
        r4 = PRETTY_PREFIXER;
    L5:
        String r0 = this._value.getNamespaceURI();
        String r2 = this._value.getLocalPart();
        if (r0 != null) goto L8;
        return r2;
    L8:
        if (r0.length() == 0) goto L16;
        String r5 = r4.find_prefix_for_nsuri(r0, null);
        if ("".equals(r5) == false) goto L14;
        return r2;
    L14:
        return r5 + ParameterizedMessage.ERROR_MSG_SEPARATOR + r2;
    L16:
        return r2;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public boolean equal_to(XmlObject r3) {
        XmlObject r4 = (XmlObject) ZeusTransformUtils.wrapperContextForParams(r3, XmlObject.class, "com.obric.memorydata.plugin");
        return this._value.equals(((XmlObjectBase) ZeusTransformUtils.preCheckCast(r4, XmlObjectBase.class, "com.obric.memorydata.plugin")).getQNameValue());
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public QName getQNameValue() {
        check_dated();
        return this._value;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public int get_wscanon_rule() {
        return 1;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.XmlObject
    public SchemaType schemaType() {
        return BuiltinSchemaTypeSystem.ST_QNAME;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_QName(QName r4) {
        if (has_store() == false) goto L5;
        get_store().find_prefix_for_nsuri(r4.getNamespaceURI(), null);
    L5:
        this._value = r4;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_nil() {
        this._value = null;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_text(String r3) {
        PrefixResolver r0 = NamespaceContext.getCurrent();
        if (r0 == null) goto L5;
    L7:
        this._value = parse(r3, r0);
        return;
    L5:
        if (has_store() == false) goto L7;
        r0 = get_store();
        goto L7
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_xmlanysimple(XmlAnySimpleType r3) {
        this._value = parse(((XmlAnySimpleType) ZeusTransformUtils.wrapperContextForParams(r3, XmlAnySimpleType.class, "com.obric.memorydata.plugin")).getStringValue(), NamespaceContext.getCurrent());
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public int value_hash_code() {
        return this._value.hashCode();
    }
}
