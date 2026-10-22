package org.apache.xmlbeans.impl.values;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigDecimal;
import java.math.BigInteger;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.BuiltinSchemaTypeSystem;
import org.apache.xmlbeans.impl.util.XsTypeConverter;

/* JADX INFO: loaded from: classes7.dex */
public abstract class JavaLongHolder extends XmlObjectBase {
    private static final BigInteger _max = null;
    private static final BigInteger _min = null;
    private long _value;

    static {
        _max = BigInteger.valueOf(Long.MAX_VALUE);
        _min = BigInteger.valueOf(Long.MIN_VALUE);
    }

    public JavaLongHolder() {
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public int compare_to(XmlObject r5) {
        XmlObject r6 = (XmlObject) ZeusTransformUtils.wrapperContextForParams(r5, XmlObject.class, "com.obric.memorydata.plugin");
        if (((SimpleValue) ZeusTransformUtils.preCheckCast(r6, SimpleValue.class, "com.obric.memorydata.plugin")).instanceType().getDecimalSize() <= 64) goto L7;
        return -r6.compareTo(this);
    L7:
        return Long.compare(this._value, ((XmlObjectBase) ZeusTransformUtils.preCheckCast(r6, XmlObjectBase.class, "com.obric.memorydata.plugin")).getLongValue());
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public String compute_text(NamespaceManager r3) {
        NamespaceManager r4 = (NamespaceManager) ZeusTransformUtils.wrapperContextForParams(r3, NamespaceManager.class, "com.obric.memorydata.plugin");
        return Long.toString(this._value);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public boolean equal_to(XmlObject r5) {
        XmlObject r6 = (XmlObject) ZeusTransformUtils.wrapperContextForParams(r5, XmlObject.class, "com.obric.memorydata.plugin");
        if (((SimpleValue) ZeusTransformUtils.preCheckCast(r6, SimpleValue.class, "com.obric.memorydata.plugin")).instanceType().getDecimalSize() <= 64) goto L7;
        return r6.valueEquals(this);
    L7:
        if (this._value != ((XmlObjectBase) ZeusTransformUtils.preCheckCast(r6, XmlObjectBase.class, "com.obric.memorydata.plugin")).getLongValue()) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public BigDecimal getBigDecimalValue() {
        check_dated();
        return BigDecimal.valueOf(this._value);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public BigInteger getBigIntegerValue() {
        check_dated();
        return BigInteger.valueOf(this._value);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public long getLongValue() {
        check_dated();
        return this._value;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.XmlObject
    public SchemaType schemaType() {
        return BuiltinSchemaTypeSystem.ST_LONG;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_BigDecimal(BigDecimal r1) {
        set_BigInteger(r1.toBigInteger());
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_BigInteger(BigInteger r3) {
        if (r3.compareTo(_max) > 0) goto L9;
        if (r3.compareTo(_min) < 0) goto L9;
        this._value = r3.longValue();
        return;
    L9:
        throw new XmlValueOutOfRangeException();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_long(long r1) {
        this._value = r1;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_nil() {
        this._value = 0;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_text(String r3) {
        set_long(XsTypeConverter.lexLong(r3));     // Catch: Exception -> L4
        return;
    L5:
        throw new XmlValueOutOfRangeException("long", new Object[]{r3});
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public int value_hash_code() {
        long r0 = this._value;
        return (int) (((r0 >> 32) * 19) + r0);
    }
}
