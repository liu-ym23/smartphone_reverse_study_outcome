package org.apache.xmlbeans.impl.values;

import com.bytedance.crypto.utils.CryptoConst;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlHexBinary;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.common.ValidationContext;
import org.apache.xmlbeans.impl.schema.BuiltinSchemaTypeSystem;
import org.apache.xmlbeans.impl.util.HexBin;

/* JADX INFO: loaded from: classes7.dex */
public abstract class JavaHexBinaryHolder extends XmlObjectBase {
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

    public JavaHexBinaryHolder() {
        this._hashcached = false;
        this.hashcode = 0;
    }

    public static byte[] lex(String r3, ValidationContext r4) {
        ValidationContext r5 = (ValidationContext) ZeusTransformUtils.wrapperContextForParams(r4, ValidationContext.class, "com.obric.memorydata.plugin");
        byte[] r6 = HexBin.decode(r3.getBytes(StandardCharsets.ISO_8859_1));
        if (r6 != null) goto L5;
        r5.invalid("hexBinary", new Object[]{"not encoded properly"});
    L5:
        return r6;
    }

    public static byte[] validateLexical(String r2, SchemaType r3, ValidationContext r4) {
        SchemaType r5 = (SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin");
        ValidationContext r6 = (ValidationContext) ZeusTransformUtils.wrapperContextForParams(r4, ValidationContext.class, "com.obric.memorydata.plugin");
        byte[] r0 = lex(r2, r6);
        if (r0 != null) goto L6;
        return null;
    L6:
        if (r5.matchPatternFacet(r2) == true) goto L9;
        r6.invalid("Hex encoded data does not match pattern for " + QNameHelper.readable(r5));
        return null;
    L9:
        return r0;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public String compute_text(NamespaceManager r3) {
        NamespaceManager r4 = (NamespaceManager) ZeusTransformUtils.wrapperContextForParams(r3, NamespaceManager.class, "com.obric.memorydata.plugin");
        return new String(HexBin.encode(this._value), StandardCharsets.ISO_8859_1);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public boolean equal_to(XmlObject r3) {
        byte[] r4 = ((XmlHexBinary) ZeusTransformUtils.preCheckCast((XmlObject) ZeusTransformUtils.wrapperContextForParams(r3, XmlObject.class, "com.obric.memorydata.plugin"), XmlHexBinary.class, "com.obric.memorydata.plugin")).getByteArrayValue();
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
        return BuiltinSchemaTypeSystem.ST_HEX_BINARY;
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
