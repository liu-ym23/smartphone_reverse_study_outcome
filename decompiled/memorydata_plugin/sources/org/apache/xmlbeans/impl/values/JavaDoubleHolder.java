package org.apache.xmlbeans.impl.values;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigDecimal;
import java.math.BigInteger;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.common.ValidationContext;
import org.apache.xmlbeans.impl.schema.BuiltinSchemaTypeSystem;
import org.apache.xmlbeans.impl.util.XsTypeConverter;

/* JADX INFO: loaded from: classes7.dex */
public abstract class JavaDoubleHolder extends XmlObjectBase {
    double _value;

    public JavaDoubleHolder() {
    }

    static int compare(double r1, double r3) {
        if (r1 >= r3) goto L7;
        return -1;
    L7:
        if (r1 <= r3) goto L11;
        return 1;
    L11:
        return Long.compare(Double.doubleToLongBits(r1), Double.doubleToLongBits(r3));
    }

    public static String serialize(double r2) {
        if (r2 != Double.POSITIVE_INFINITY) goto L7;
        return "INF";
    L7:
        if (r2 != Double.NEGATIVE_INFINITY) goto L11;
        return "-INF";
    L11:
        if (Double.isNaN(r2) == false) goto L15;
        return "NaN";
    L15:
        return Double.toString(r2);
    }

    public static double validateLexical(String r2, ValidationContext r3) {
        return XsTypeConverter.lexDouble(r2);
    L5:
        ((ValidationContext) ZeusTransformUtils.wrapperContextForParams(r3, ValidationContext.class, "com.obric.memorydata.plugin")).invalid("double", new Object[]{r2});
        return Double.NaN;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public int compare_to(XmlObject r5) {
        XmlObject r6 = (XmlObject) ZeusTransformUtils.wrapperContextForParams(r5, XmlObject.class, "com.obric.memorydata.plugin");
        return compare(this._value, ((XmlObjectBase) ZeusTransformUtils.preCheckCast(r6, XmlObjectBase.class, "com.obric.memorydata.plugin")).getDoubleValue());
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public String compute_text(NamespaceManager r3) {
        NamespaceManager r4 = (NamespaceManager) ZeusTransformUtils.wrapperContextForParams(r3, NamespaceManager.class, "com.obric.memorydata.plugin");
        return serialize(this._value);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public boolean equal_to(XmlObject r5) {
        XmlObject r6 = (XmlObject) ZeusTransformUtils.wrapperContextForParams(r5, XmlObject.class, "com.obric.memorydata.plugin");
        if (compare(this._value, ((XmlObjectBase) ZeusTransformUtils.preCheckCast(r6, XmlObjectBase.class, "com.obric.memorydata.plugin")).getDoubleValue()) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public BigDecimal getBigDecimalValue() {
        check_dated();
        return new BigDecimal(this._value);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public double getDoubleValue() {
        check_dated();
        return this._value;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public float getFloatValue() {
        check_dated();
        return (float) this._value;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.XmlObject
    public SchemaType schemaType() {
        return BuiltinSchemaTypeSystem.ST_DOUBLE;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_BigDecimal(BigDecimal r3) {
        set_double(r3.doubleValue());
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_BigInteger(BigInteger r3) {
        set_double(r3.doubleValue());
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_double(double r1) {
        this._value = r1;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_float(float r3) {
        set_double(r3);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_long(long r1) {
        set_double(r1);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_nil() {
        this._value = 0.0d;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_text(String r3) {
        set_double(validateLexical(r3, _voorVc));
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public int value_hash_code() {
        long r0 = Double.doubleToLongBits(this._value);
        return (int) (((r0 >> 32) * 19) + r0);
    }
}
