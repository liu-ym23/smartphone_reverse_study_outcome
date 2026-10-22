package org.apache.xmlbeans.impl.values;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigDecimal;
import java.math.BigInteger;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.common.ValidationContext;
import org.apache.xmlbeans.impl.schema.BuiltinSchemaTypeSystem;

/* JADX INFO: loaded from: classes7.dex */
public abstract class JavaIntegerHolder extends XmlObjectBase {
    private static final BigInteger _maxlong = null;
    private static final BigInteger _minlong = null;
    private BigInteger _value;

    static {
        _maxlong = BigInteger.valueOf(Long.MAX_VALUE);
        _minlong = BigInteger.valueOf(Long.MIN_VALUE);
    }

    public JavaIntegerHolder() {
    }

    public static BigInteger lex(String r4, ValidationContext r5) {
        ValidationContext r6 = (ValidationContext) ZeusTransformUtils.wrapperContextForParams(r5, ValidationContext.class, "com.obric.memorydata.plugin");
        if (r4.length() > 0) goto L5;
    L11:
        return new BigInteger(r4);
    L9:
        r6.invalid(TypedValues.Custom.S_INT, new Object[]{r4});
        return null;
    L5:
        if (r4.charAt(0) != '+') goto L11;
        r4 = r4.substring(1);
        goto L11
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public int compare_to(XmlObject r4) {
        XmlObject r5 = (XmlObject) ZeusTransformUtils.wrapperContextForParams(r4, XmlObject.class, "com.obric.memorydata.plugin");
        if (((SimpleValue) ZeusTransformUtils.preCheckCast(r5, SimpleValue.class, "com.obric.memorydata.plugin")).instanceType().getDecimalSize() <= 1000000) goto L7;
        return -r5.compareTo(this);
    L7:
        return this._value.compareTo(((XmlObjectBase) ZeusTransformUtils.preCheckCast(r5, XmlObjectBase.class, "com.obric.memorydata.plugin")).getBigIntegerValue());
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public String compute_text(NamespaceManager r3) {
        NamespaceManager r4 = (NamespaceManager) ZeusTransformUtils.wrapperContextForParams(r3, NamespaceManager.class, "com.obric.memorydata.plugin");
        return this._value.toString();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public boolean equal_to(XmlObject r4) {
        XmlObject r5 = (XmlObject) ZeusTransformUtils.wrapperContextForParams(r4, XmlObject.class, "com.obric.memorydata.plugin");
        if (((SimpleValue) ZeusTransformUtils.preCheckCast(r5, SimpleValue.class, "com.obric.memorydata.plugin")).instanceType().getDecimalSize() <= 1000000) goto L7;
        return r5.valueEquals(this);
    L7:
        return this._value.equals(((XmlObjectBase) ZeusTransformUtils.preCheckCast(r5, XmlObjectBase.class, "com.obric.memorydata.plugin")).getBigIntegerValue());
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public BigDecimal getBigDecimalValue() {
        check_dated();
        if (this._value != null) goto L6;
        return null;
    L6:
        return new BigDecimal(this._value);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public BigInteger getBigIntegerValue() {
        check_dated();
        return this._value;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.XmlObject
    public SchemaType schemaType() {
        return BuiltinSchemaTypeSystem.ST_INTEGER;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_BigDecimal(BigDecimal r1) {
        this._value = r1.toBigInteger();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_BigInteger(BigInteger r1) {
        this._value = r1;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_nil() {
        this._value = null;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_text(String r2) {
        set_BigInteger(lex(r2, _voorVc));
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public int value_hash_code() {
        if (this._value.compareTo(_maxlong) > 0) goto L10;
        if (this._value.compareTo(_minlong) < 0) goto L10;
        long r0 = this._value.longValue();
        return (int) (((r0 >> 32) * 19) + r0);
    L10:
        return this._value.hashCode();
    }
}
