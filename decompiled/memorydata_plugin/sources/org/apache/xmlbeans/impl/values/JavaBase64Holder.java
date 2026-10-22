package org.apache.xmlbeans.impl.values;

import com.bytedance.crypto.utils.CryptoConst;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBase64Binary;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.common.ValidationContext;
import org.apache.xmlbeans.impl.schema.BuiltinSchemaTypeSystem;

/* JADX INFO: loaded from: classes7.dex */
public abstract class JavaBase64Holder extends XmlObjectBase {
    protected static final MessageDigest md5 = null;
    protected boolean _hashcached;
    protected byte[] _value;
    protected int hashcode;

    static {
        md5 = MessageDigest.getInstance(CryptoConst.ALGORITHM_MD5);     // Catch: NoSuchAlgorithmException -> L4
        return;
    L5:
        throw new IllegalStateException("Cannot find MD5 hash Algorithm");
    }

    public JavaBase64Holder() {
        this._hashcached = false;
        this.hashcode = 0;
    }

    public static byte[] lex(String r2, ValidationContext r3) {
        return Base64.getMimeDecoder().decode(r2);
    L5:
        ((ValidationContext) ZeusTransformUtils.wrapperContextForParams(r3, ValidationContext.class, "com.obric.memorydata.plugin")).invalid("base64Binary", new Object[]{"not encoded properly"});
        return null;
    }

    public static byte[] validateLexical(String r3, SchemaType r4, ValidationContext r5) {
        SchemaType r6 = (SchemaType) ZeusTransformUtils.wrapperContextForParams(r4, SchemaType.class, "com.obric.memorydata.plugin");
        ValidationContext r7 = (ValidationContext) ZeusTransformUtils.wrapperContextForParams(r5, ValidationContext.class, "com.obric.memorydata.plugin");
        byte[] r0 = lex(r3, r7);
        if (r0 != null) goto L6;
        return null;
    L6:
        if (r6.matchPatternFacet(r3) == true) goto L9;
        r7.invalid("cvc-datatype-valid.1.1b", new Object[]{"base 64", QNameHelper.readable(r6)});
        return null;
    L9:
        return r0;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public String compute_text(NamespaceManager r3) {
        NamespaceManager r4 = (NamespaceManager) ZeusTransformUtils.wrapperContextForParams(r3, NamespaceManager.class, "com.obric.memorydata.plugin");
        return Base64.getEncoder().encodeToString(this._value);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public boolean equal_to(XmlObject r3) {
        byte[] r4 = ((XmlBase64Binary) ZeusTransformUtils.preCheckCast((XmlObject) ZeusTransformUtils.wrapperContextForParams(r3, XmlObject.class, "com.obric.memorydata.plugin"), XmlBase64Binary.class, "com.obric.memorydata.plugin")).getByteArrayValue();
        return Arrays.equals(this._value, r4);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public byte[] getByteArrayValue() {
        check_dated();
        byte[] r3 = this._value;
        if (r3 != null) goto L6;
        return null;
    L6:
        byte[] r0 = new byte[r3.length];
        System.arraycopy(r3, 0, r0, 0, r3.length);
        return r0;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.XmlObject
    public SchemaType schemaType() {
        return BuiltinSchemaTypeSystem.ST_BASE_64_BINARY;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_ByteArray(byte[] r3) {
        this._hashcached = false;
        byte[] r1 = new byte[r3.length];
        this._value = r1;
        System.arraycopy(r3, 0, r1, 0, r3.length);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_nil() {
        this._hashcached = false;
        this._value = null;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_text(String r3) {
        this._hashcached = false;
        if (_validateOnSet() == false) goto L5;
        this._value = validateLexical(r3, schemaType(), _voorVc);
        return;
    L5:
        this._value = lex(r3, _voorVc);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public int value_hash_code() {
        if (this._hashcached == true) goto L5;
        this._hashcached = true;
        byte[] r1 = this._value;
        if (r1 != null) goto L10;
        this.hashcode = 0;
        return 0;
    L10:
        byte[] r2 = md5.digest(r1);
        int r3 = r2[0] << 24;
        int r0 = (((r2[1] << 16) | r3) | (r2[2] << 8)) | r2[3];
        this.hashcode = r0;
        return r0;
    L5:
        return this.hashcode;
    }
}
