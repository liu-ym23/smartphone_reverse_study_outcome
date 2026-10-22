package org.apache.xmlbeans;

/* JADX INFO: loaded from: classes7.dex */
public interface XmlBase64Binary extends XmlAnySimpleType {
    public static final SchemaType type = null;

    static {
        type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_base64Binary");
    }

    byte[] getByteArrayValue();
}
