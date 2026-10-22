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
public abstract class JavaIntHolder extends XmlObjectBase {
    static final BigInteger _max = null;
    static final BigInteger _min = null;
    private int _value;

    static {
        _max = BigInteger.valueOf(2147483647L);
        _min = BigInteger.valueOf(-2147483648L);
    }

    public JavaIntHolder() {
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public int compare_to(XmlObject r4) {
        XmlObject r5 = (XmlObject) ZeusTransformUtils.wrapperContextForParams(r4, XmlObject.class, "com.obric.memorydata.plugin");
        if (((SimpleValue) ZeusTransformUtils.preCheckCast(r5, SimpleValue.class, "com.obric.memorydata.plugin")).instanceType().getDecimalSize() <= 32) goto L7;
        return -r5.compareTo(this);
    L7:
        return Integer.compare(this._value, ((XmlObjectBase) ZeusTransformUtils.preCheckCast(r5, XmlObjectBase.class, "com.obric.memorydata.plugin")).getIntValue());
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public String compute_text(NamespaceManager r3) {
        NamespaceManager r4 = (NamespaceManager) ZeusTransformUtils.wrapperContextForParams(r3, NamespaceManager.class, "com.obric.memorydata.plugin");
        return Long.toString(this._value);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public boolean equal_to(XmlObject r4) {
        XmlObject r5 = (XmlObject) ZeusTransformUtils.wrapperContextForParams(r4, XmlObject.class, "com.obric.memorydata.plugin");
        if (((SimpleValue) ZeusTransformUtils.preCheckCast(r5, SimpleValue.class, "com.obric.memorydata.plugin")).instanceType().getDecimalSize() <= 32) goto L7;
        return r5.valueEquals(this);
    L7:
        if (this._value != ((XmlObjectBase) ZeusTransformUtils.preCheckCast(r5, XmlObjectBase.class, "com.obric.memorydata.plugin")).getIntValue()) goto L9;
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
    public int getIntValue() {
        check_dated();
        return this._value;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public long getLongValue() {
        check_dated();
        return this._value;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.XmlObject
    public SchemaType schemaType() {
        return BuiltinSchemaTypeSystem.ST_INT;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_BigDecimal(BigDecimal r1) {
        set_BigInteger(r1.toBigInteger());
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_BigInteger(BigInteger r2) {
        if (r2.compareTo(_max) > 0) goto L9;
        if (r2.compareTo(_min) < 0) goto L9;
        set_int(r2.intValue());
        return;
    L9:
        throw new XmlValueOutOfRangeException();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_int(int r1) {
        this._value = r1;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_long(long r3) {
        if (r3 > 2147483647L) goto L9;
        if (r3 < (-2147483648L)) goto L9;
        set_int((int) r3);
        return;
    L9:
        throw new XmlValueOutOfRangeException();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_nil() {
        this._value = 0;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_text(String r3) {
        set_int(XsTypeConverter.lexInt(r3));     // Catch: Exception -> L4
        return;
    L5:
        throw new XmlValueOutOfRangeException("int", new Object[]{r3});
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public int value_hash_code() {
        return this._value;
    }
}
