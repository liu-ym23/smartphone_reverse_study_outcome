package org.apache.xmlbeans.impl.values;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigDecimal;
import java.math.BigInteger;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.common.ValidationContext;
import org.apache.xmlbeans.impl.schema.BuiltinSchemaTypeSystem;
import org.apache.xmlbeans.impl.util.XsTypeConverter;

/* JADX INFO: loaded from: classes7.dex */
public abstract class JavaFloatHolder extends XmlObjectBase {
    private float _value;

    public JavaFloatHolder() {
    }

    static int compare(float r1, float r2) {
        if (r1 >= r2) goto L7;
        return -1;
    L7:
        if (r1 <= r2) goto L11;
        return 1;
    L11:
        return Integer.compare(Float.floatToIntBits(r1), Float.floatToIntBits(r2));
    }

    public static String serialize(float r1) {
        if (r1 != Float.POSITIVE_INFINITY) goto L7;
        return "INF";
    L7:
        if (r1 != Float.NEGATIVE_INFINITY) goto L11;
        return "-INF";
    L11:
        if (Float.isNaN(r1) == false) goto L15;
        return "NaN";
    L15:
        return Float.toString(r1);
    }

    public static float validateLexical(String r2, ValidationContext r3) {
        return XsTypeConverter.lexFloat(r2);
    L5:
        ((ValidationContext) ZeusTransformUtils.wrapperContextForParams(r3, ValidationContext.class, "com.obric.memorydata.plugin")).invalid(TypedValues.Custom.S_FLOAT, new Object[]{r2});
        return Float.NaN;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public int compare_to(XmlObject r3) {
        XmlObject r4 = (XmlObject) ZeusTransformUtils.wrapperContextForParams(r3, XmlObject.class, "com.obric.memorydata.plugin");
        return compare(this._value, ((XmlObjectBase) ZeusTransformUtils.preCheckCast(r4, XmlObjectBase.class, "com.obric.memorydata.plugin")).getFloatValue());
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public String compute_text(NamespaceManager r3) {
        NamespaceManager r4 = (NamespaceManager) ZeusTransformUtils.wrapperContextForParams(r3, NamespaceManager.class, "com.obric.memorydata.plugin");
        return serialize(this._value);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public boolean equal_to(XmlObject r3) {
        XmlObject r4 = (XmlObject) ZeusTransformUtils.wrapperContextForParams(r3, XmlObject.class, "com.obric.memorydata.plugin");
        if (compare(this._value, ((XmlObjectBase) ZeusTransformUtils.preCheckCast(r4, XmlObjectBase.class, "com.obric.memorydata.plugin")).getFloatValue()) != 0) goto L5;
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
        return this._value;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.XmlObject
    public SchemaType schemaType() {
        return BuiltinSchemaTypeSystem.ST_FLOAT;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_BigDecimal(BigDecimal r1) {
        set_float(r1.floatValue());
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_BigInteger(BigInteger r1) {
        set_float(r1.floatValue());
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_double(double r1) {
        set_float((float) r1);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_float(float r1) {
        this._value = r1;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_long(long r1) {
        set_float(r1);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_nil() {
        this._value = 0.0f;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_text(String r2) {
        set_float(validateLexical(r2, _voorVc));
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public int value_hash_code() {
        return Float.floatToIntBits(this._value);
    }
}
