package org.apache.xmlbeans.impl.values;

import com.bytedance.apm6.consumer.slardar.Constants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlSimpleList;
import org.apache.xmlbeans.impl.common.PrefixResolver;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.common.ValidationContext;
import org.apache.xmlbeans.impl.common.XMLChar;

/* JADX INFO: loaded from: classes7.dex */
public class XmlListImpl extends XmlObjectBase implements XmlAnySimpleType {
    private static final String[] EMPTY_STRINGARRAY = null;
    private XmlSimpleList<?> _jvalue;
    private final SchemaType _schemaType;
    private XmlSimpleList<? extends XmlAnySimpleType> _value;

    static {
        EMPTY_STRINGARRAY = new String[0];
    }

    public XmlListImpl(SchemaType r3, boolean r4) {
        this._schemaType = (SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin");
        initComplexType(r4, false);
    }

    private static String compute_list_text(List<? extends XmlAnySimpleType> r2) {
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        if (r3.isEmpty() == false) goto L6;
        return "";
    L6:
        return (String) ZeusTransformUtils.preCheckCast(r3.stream().map($$Lambda$XmlListImpl$bpqkj3tK_2Y2V4xdgJLLrKVCfsU.INSTANCE).collect(Collectors.joining(" ")), String.class, "com.obric.memorydata.plugin");
    }

    private static boolean contains_white_space(String r1) {
        if (r1.indexOf(32) < 0) goto L5;
    L12:
        return true;
    L5:
        if (r1.indexOf(9) >= 0) goto L12;
        if (r1.indexOf(10) >= 0) goto L12;
        if (r1.indexOf(13) >= 0) goto L12;
        return false;
    }

    private static boolean equal_xmlLists(List<?> r4, List<?> r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        if (r6.size() == r7.size()) goto L5;
        return false;
    L5:
        int r0 = 0;
    L7:
        if (r0 >= r6.size()) goto L12;
        if (r6.get(r0).equals(r7.get(r0)) == false) goto L10;
        r0 = r0 + 1;
        goto L7
    L10:
        return false;
    L12:
        return true;
    }

    public static /* synthetic */ String lambda$bpqkj3tK_2Y2V4xdgJLLrKVCfsU(Object r0) {
        return object2String(r0);
    }

    static /* synthetic */ XmlAnySimpleType lambda$lex$0(SchemaType r4, ValidationContext r5, String r6) {
        SchemaType r7 = (SchemaType) ZeusTransformUtils.wrapperContextForParams(r4, SchemaType.class, "com.obric.memorydata.plugin");
        return r7.newValue(r6);
    L5:
        ((ValidationContext) ZeusTransformUtils.wrapperContextForParams(r5, ValidationContext.class, "com.obric.memorydata.plugin")).invalid(Constants.KEY_LIST, new Object[]{"item '" + r6 + "' is not a valid value of " + QNameHelper.readable(r7)});
        return null;
    }

    static /* synthetic */ XmlAnySimpleType lambda$set_list$1(SchemaType r2, Object r3) {
        SchemaType r4 = (SchemaType) ZeusTransformUtils.wrapperContextForParams(r2, SchemaType.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, XmlObject.class) == false) goto L12;
        if (permits_inner_space((XmlObject) ZeusTransformUtils.preCheckCast(r3, XmlObject.class, "com.obric.memorydata.plugin")) == false) goto L12;
        if (contains_white_space(r3.toString()) == false) goto L12;
        throw new XmlValueOutOfRangeException();
    L12:
        return r4.newValue(r3);
    }

    public static XmlSimpleList<? extends XmlAnySimpleType> lex(String r2, SchemaType r3, ValidationContext r4, PrefixResolver r5) {
        final SchemaType r6 = (SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin");
        final ValidationContext r7 = (ValidationContext) ZeusTransformUtils.wrapperContextForParams(r4, ValidationContext.class, "com.obric.memorydata.plugin");
        PrefixResolver r8 = (PrefixResolver) ZeusTransformUtils.wrapperContextForParams(r5, PrefixResolver.class, "com.obric.memorydata.plugin");
        String[] r9 = split_list(r2);
        Function r0 = new $$Lambda$XmlListImpl$tMzRYokjBtWle9FZLA_WI8wqw0(r6, r7);
        if (r8 == null) goto L5;
        NamespaceContext.push(new NamespaceContext(r8));
        boolean r10 = true;
    L14:
        XmlSimpleList<? extends XmlAnySimpleType> r11 = new XmlSimpleList((List) ZeusTransformUtils.preCheckCast(Stream.of(r9).map(r0).collect(Collectors.toList()), List.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L10
        if (r10 == false) goto L9;
        NamespaceContext.pop();
    L9:
        return r11;
    L10:
        th = move-exception;
        if (r10 == false) goto L13;
        NamespaceContext.pop();
    L13:
        throw th;
    L5:
        r10 = false;
        goto L14
    }

    private static String object2String(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, SimpleValue.class) == false) goto L5;
        String r3 = ((SimpleValue) ZeusTransformUtils.preCheckCast(r2, SimpleValue.class, "com.obric.memorydata.plugin")).getStringValue();
    L6:
        if (r3 != null) goto L9;
        return "";
    L9:
        return r3;
    L5:
        r3 = r2.toString();
        goto L6
    }

    private static boolean permits_inner_space(XmlObject r2) {
        int r3 = ((SimpleValue) ZeusTransformUtils.preCheckCast((XmlObject) ZeusTransformUtils.wrapperContextForParams(r2, XmlObject.class, "com.obric.memorydata.plugin"), SimpleValue.class, "com.obric.memorydata.plugin")).instanceType().getPrimitiveType().getBuiltinTypeCode();
        if (r3 != 1) goto L5;
    L12:
        return true;
    L5:
        if (r3 == 2) goto L12;
        if (r3 == 6) goto L12;
        if (r3 == 12) goto L12;
        return false;
    }

    public static String[] split_list(String r4) {
        if (r4.length() == 0) goto L5;
        ArrayList r0 = new ArrayList();
        int r1 = 0;
    L8:
        if (r1 >= r4.length()) goto L13;
        if (XMLChar.isSpace(r4.charAt(r1)) == false) goto L13;
        r1 = r1 + 1;
    L13:
        if (r1 >= r4.length()) goto L15;
        int r2 = r1;
    L18:
        if (r2 >= r4.length()) goto L22;
        if (XMLChar.isSpace(r4.charAt(r2)) == true) goto L22;
        r2 = r2 + 1;
    L22:
        r0.add(r4.substring(r1, r2));
        r1 = r2;
        goto L8
    L15:
        return (String[]) ZeusTransformUtils.preCheckCast(r0.toArray(EMPTY_STRINGARRAY), String[].class, "com.obric.memorydata.plugin");
    L5:
        return EMPTY_STRINGARRAY;
    }

    public static void validateValue(XmlSimpleList<? extends XmlAnySimpleType> r10, SchemaType r11, ValidationContext r12) {
        SchemaType r13 = (SchemaType) ZeusTransformUtils.wrapperContextForParams(r11, SchemaType.class, "com.obric.memorydata.plugin");
        ValidationContext r14 = (ValidationContext) ZeusTransformUtils.wrapperContextForParams(r12, ValidationContext.class, "com.obric.memorydata.plugin");
        XmlAnySimpleType[] r0 = r13.getEnumerationValues();
        if (r0 == null) goto L11;
        int r6 = r0.length;
        int r7 = 0;
    L5:
        if (r7 >= r6) goto L10;
        if (equal_xmlLists(r10, ((XmlObjectBase) ZeusTransformUtils.preCheckCast(r0[r7], XmlObjectBase.class, "com.obric.memorydata.plugin")).xgetListValue()) == true) goto L11;
        r7 = r7 + 1;
        goto L5
    L10:
        r14.invalid("cvc-enumeration-valid", new Object[]{Constants.KEY_LIST, r10, QNameHelper.readable(r13)});
    L11:
        XmlAnySimpleType r1 = r13.getFacet(0);
        if (r1 == null) goto L16;
        int r2 = ((SimpleValue) ZeusTransformUtils.preCheckCast(r1, SimpleValue.class, "com.obric.memorydata.plugin")).getIntValue();
        if (r2 == r10.size()) goto L16;
        r14.invalid("cvc-length-valid.2", new Object[]{r10, Integer.valueOf(r10.size()), Integer.valueOf(r2), QNameHelper.readable(r13)});
    L16:
        XmlAnySimpleType r3 = r13.getFacet(1);
        if (r3 == null) goto L21;
        int r4 = ((SimpleValue) ZeusTransformUtils.preCheckCast(r3, SimpleValue.class, "com.obric.memorydata.plugin")).getIntValue();
        if (r4 <= r10.size()) goto L21;
        r14.invalid("cvc-minLength-valid.2", new Object[]{r10, Integer.valueOf(r10.size()), Integer.valueOf(r4), QNameHelper.readable(r13)});
    L21:
        XmlAnySimpleType r5 = r13.getFacet(2);
        if (r5 == null) goto L29;
        int r8 = ((SimpleValue) ZeusTransformUtils.preCheckCast(r5, SimpleValue.class, "com.obric.memorydata.plugin")).getIntValue();
        if (r8 >= r10.size()) goto L30;
        r14.invalid("cvc-maxLength-valid.2", new Object[]{r10, Integer.valueOf(r10.size()), Integer.valueOf(r8), QNameHelper.readable(r13)});
        return;
    L30:
        return;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public String compute_text(NamespaceManager r3) {
        NamespaceManager r4 = (NamespaceManager) ZeusTransformUtils.wrapperContextForParams(r3, NamespaceManager.class, "com.obric.memorydata.plugin");
        return compute_list_text(this._value);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public boolean equal_to(XmlObject r3) {
        XmlObject r4 = (XmlObject) ZeusTransformUtils.wrapperContextForParams(r3, XmlObject.class, "com.obric.memorydata.plugin");
        return equal_xmlLists(this._value, ((XmlObjectBase) ZeusTransformUtils.preCheckCast(r4, XmlObjectBase.class, "com.obric.memorydata.plugin")).xgetListValue());
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public List<?> getListValue() {
        check_dated();
        if (this._value != null) goto L6;
        return null;
    L6:
        XmlSimpleList<?> r0 = this._jvalue;
        if (r0 == null) goto L9;
        return r0;
    L9:
        ArrayList r1 = new ArrayList();
        Iterator<? extends XmlAnySimpleType> r2 = this._value.iterator();
    L11:
        if (r2.hasNext() == false) goto L13;
        r1.add(java_value((XmlObject) ZeusTransformUtils.preCheckCast(r2.next(), XmlObject.class, "com.obric.memorydata.plugin")));
        goto L11
    L13:
        XmlSimpleList<?> r3 = new XmlSimpleList(r1);
        this._jvalue = r3;
        return r3;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public boolean is_defaultable_ws(String r2) {
        XmlSimpleList<? extends XmlAnySimpleType> r0 = this._value;     // Catch: XmlValueOutOfRangeException -> L5
        set_text(r2);     // Catch: XmlValueOutOfRangeException -> L5
        this._value = r0;     // Catch: XmlValueOutOfRangeException -> L5
        return false;
    L5:
        return true;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.XmlObject
    public SchemaType schemaType() {
        return this._schemaType;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_list(List<?> r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        final SchemaType r0 = this._schemaType.getListItemType();
        if (has_store() == false) goto L5;
        NamespaceContext.push(new NamespaceContext(get_store()));
        boolean r2 = true;
    L6:
        Function r3 = new $$Lambda$XmlListImpl$AF_0qyy2FZp446FVLOmpHUFaqVk(r0);
        XmlSimpleList<? extends XmlAnySimpleType> r1 = new XmlSimpleList((List) ZeusTransformUtils.preCheckCast(r6.stream().map(r3).collect(Collectors.toList()), List.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L15
        if (r2 == false) goto L11;
        NamespaceContext.pop();
    L11:
        if (_validateOnSet() == false) goto L13;
        validateValue(r1, this._schemaType, _voorVc);
    L13:
        this._value = r1;
        this._jvalue = null;
        return;
    L15:
        th = move-exception;
        if (r2 == false) goto L18;
        NamespaceContext.pop();
    L18:
        throw th;
    L5:
        r2 = false;
        goto L6
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_nil() {
        this._value = null;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_text(String r5) {
        if (_validateOnSet() == true) goto L5;
    L9:
        SchemaType r0 = this._schemaType.getListItemType();
        ValidationContext r1 = _voorVc;
        if (has_store() == false) goto L12;
        TypeStore r2 = get_store();
    L13:
        XmlSimpleList<? extends XmlAnySimpleType> r6 = lex(r5, r0, r1, r2);
        if (_validateOnSet() == false) goto L16;
        validateValue(r6, this._schemaType, _voorVc);
    L16:
        this._value = r6;
        this._jvalue = null;
        return;
    L12:
        r2 = null;
        goto L13
    L5:
        if (this._schemaType.matchPatternFacet(r5) == true) goto L9;
        throw new XmlValueOutOfRangeException("cvc-datatype-valid.1.1", new Object[]{Constants.KEY_LIST, r5, QNameHelper.readable(this._schemaType)});
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void validate_simpleval(String r2, ValidationContext r3) {
        ValidationContext r4 = (ValidationContext) ZeusTransformUtils.wrapperContextForParams(r3, ValidationContext.class, "com.obric.memorydata.plugin");
        validateValue(xgetListValue(), schemaType(), r4);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public int value_hash_code() {
        XmlSimpleList<? extends XmlAnySimpleType> r0 = this._value;
        int r1 = 0;
        if (r0 != null) goto L5;
        return 0;
    L5:
        int r2 = r0.size();
        int r3 = this._value.size() / 9;
        if (r3 >= 1) goto L9;
        r3 = 1;
    L9:
        if (r1 >= this._value.size()) goto L11;
        r2 = (r2 * 19) + ((XmlAnySimpleType) ZeusTransformUtils.preCheckCast(this._value.get(r1), XmlAnySimpleType.class, "com.obric.memorydata.plugin")).hashCode();
        r1 = r1 + r3;
        goto L9
    L11:
        return r2;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public /* bridge */ /* synthetic */ List xgetListValue() {
        return xgetListValue();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public XmlSimpleList<? extends XmlAnySimpleType> xgetListValue() {
        check_dated();
        return this._value;
    }
}
