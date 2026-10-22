package org.apache.xmlbeans.impl.values;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.common.ValidationContext;
import org.apache.xmlbeans.impl.schema.BuiltinSchemaTypeSystem;
import org.apache.xmlbeans.impl.util.XsTypeConverter;

/* JADX INFO: loaded from: classes7.dex */
public class JavaDecimalHolder extends XmlObjectBase {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final BigInteger _maxlong = null;
    private static final BigInteger _minlong = null;
    private BigDecimal _value;

    static {
        _maxlong = BigInteger.valueOf(Long.MAX_VALUE);
        _minlong = BigInteger.valueOf(Long.MIN_VALUE);
    }

    public JavaDecimalHolder() {
    }

    public static void validateLexical(String r9, ValidationContext r10) {
        ValidationContext r11 = (ValidationContext) ZeusTransformUtils.wrapperContextForParams(r10, ValidationContext.class, "com.obric.memorydata.plugin");
        int r0 = r9.length();
        if (r0 <= 0) goto L9;
        char r3 = r9.charAt(0);
        if (r3 != '+') goto L7;
    L8:
        int r4 = 1;
    L10:
        boolean r5 = false;
        boolean r6 = false;
    L12:
        if (r4 >= r0) goto L27;
        char r7 = r9.charAt(r4);
        if (r7 != '.') goto L20;
        if (r6 == true) goto L16;
        r6 = true;
    L24:
        r4 = r4 + 1;
        goto L12
    L16:
        r11.invalid("decimal", new Object[]{"saw '.' more than once: " + r9});
        return;
    L20:
        if (r7 < '0') goto L25;
        if (r7 > '9') goto L25;
        r5 = true;
    L25:
        r11.invalid("decimal", new Object[]{"unexpected char '" + r7 + "'"});
        return;
    L27:
        if (r5 == true) goto L36;
        r11.invalid("decimal", new Object[]{"expected at least one digit"});
        return;
    L36:
        return;
    L7:
        if (r3 == '-') goto L8;
    L9:
        r4 = 0;
        goto L10
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public int compare_to(XmlObject r3) {
        XmlObject r4 = (XmlObject) ZeusTransformUtils.wrapperContextForParams(r3, XmlObject.class, "com.obric.memorydata.plugin");
        return this._value.compareTo(((XmlObjectBase) ZeusTransformUtils.preCheckCast(r4, XmlObjectBase.class, "com.obric.memorydata.plugin")).getBigDecimalValue());
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public String compute_text(NamespaceManager r3) {
        NamespaceManager r4 = (NamespaceManager) ZeusTransformUtils.wrapperContextForParams(r3, NamespaceManager.class, "com.obric.memorydata.plugin");
        return XsTypeConverter.printDecimal(this._value);
    }

    public int decimalHashCode() {
        String r3 = this._value.toString();
        int r0 = r3.length() - 1;
    L3:
        if (r0 < 0) goto L9;
        if (r3.charAt(r0) != '0') goto L9;
        r0 = r0 - 1;
    L9:
        return r3.substring(0, r0 + 1).hashCode();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public boolean equal_to(XmlObject r3) {
        XmlObject r4 = (XmlObject) ZeusTransformUtils.wrapperContextForParams(r3, XmlObject.class, "com.obric.memorydata.plugin");
        if (this._value.compareTo(((XmlObjectBase) ZeusTransformUtils.preCheckCast(r4, XmlObjectBase.class, "com.obric.memorydata.plugin")).getBigDecimalValue()) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public BigDecimal getBigDecimalValue() {
        check_dated();
        return this._value;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.XmlObject
    public SchemaType schemaType() {
        return BuiltinSchemaTypeSystem.ST_DECIMAL;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_BigDecimal(BigDecimal r1) {
        this._value = r1;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_nil() {
        this._value = null;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_text(String r3) {
        if (_validateOnSet() == false) goto L9;
        validateLexical(r3, _voorVc);
    L9:
        set_BigDecimal(new BigDecimal(r3));     // Catch: NumberFormatException -> L7
        return;
    L7:
        _voorVc.invalid("decimal", new Object[]{r3});
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public int value_hash_code() {
        if (this._value.scale() > 0) goto L5;
    L8:
        BigInteger r6 = this._value.toBigInteger();
        if (r6.compareTo(_maxlong) > 0) goto L16;
        if (r6.compareTo(_minlong) < 0) goto L16;
        long r0 = r6.longValue();
        return (int) (((r0 >> 32) * 19) + r0);
    L16:
        return r6.hashCode();
    L5:
        if (this._value.setScale(0, RoundingMode.DOWN).compareTo(this._value) == 0) goto L8;
        return decimalHashCode();
    }
}
