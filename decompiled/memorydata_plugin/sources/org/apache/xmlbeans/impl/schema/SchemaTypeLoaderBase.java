package org.apache.xmlbeans.impl.schema;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.util.ArrayList;
import javax.xml.namespace.QName;
import javax.xml.stream.e;
import org.apache.xmlbeans.SchemaField;
import org.apache.xmlbeans.SchemaGlobalAttribute;
import org.apache.xmlbeans.SchemaGlobalElement;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SchemaTypeLoader;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlFactoryHook;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.store.Locale;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes7.dex */
public abstract class SchemaTypeLoaderBase implements SchemaTypeLoader {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String USER_AGENT = null;

    static {
        USER_AGENT = "XMLBeans/" + XmlBeans.getVersion() + " (" + XmlBeans.getTitle() + ")";
    }

    public SchemaTypeLoaderBase() {
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaGlobalAttribute findAttribute(QName r1) {
        SchemaGlobalAttribute.Ref r0 = findAttributeRef(r1);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.get();
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaType findAttributeType(QName r1) {
        SchemaType.Ref r0 = findAttributeTypeRef(r1);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.get();
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaType findDocumentType(QName r1) {
        SchemaType.Ref r0 = findDocumentTypeRef(r1);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.get();
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaGlobalElement findElement(QName r1) {
        SchemaGlobalElement.Ref r0 = findElementRef(r1);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.get();
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaType findType(QName r1) {
        SchemaType.Ref r0 = findTypeRef(r1);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.get();
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public XmlObject newInstance(SchemaType r3, XmlOptions r4) {
        SchemaType r5 = (SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin");
        XmlFactoryHook r0 = XmlFactoryHook.ThreadContext.getHook();
        if (r0 == null) goto L7;
        return r0.newInstance(this, r5, r4);
    L7:
        return Locale.newInstance(this, r5, r4);
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public XmlObject parse(InputStream r4, SchemaType r5, XmlOptions r6) {
        SchemaType r7 = (SchemaType) ZeusTransformUtils.wrapperContextForParams(r5, SchemaType.class, "com.obric.memorydata.plugin");
        XmlFactoryHook r0 = XmlFactoryHook.ThreadContext.getHook();
        if (r6 != null) goto L5;
    L8:
        DigestInputStream r2 = null;
    L9:
        if (r0 != null) goto L11;
        XmlObject r3 = Locale.parseToXmlObject(this, r4, r7, r6);
        if (r2 == null) goto L15;
        r3.documentProperties().setMessageDigest(r2.getMessageDigest().digest());
    L15:
        return r3;
    L11:
        return r0.parse(this, r4, r7, r6);
    L5:
        if (r6.isLoadMessageDigest() == false) goto L8;
        r2 = new DigestInputStream(r4, MessageDigest.getInstance("SHA"));
        r4 = r2;
        goto L9
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public XmlObject parse(String r3, SchemaType r4, XmlOptions r5) {
        SchemaType r6 = (SchemaType) ZeusTransformUtils.wrapperContextForParams(r4, SchemaType.class, "com.obric.memorydata.plugin");
        XmlFactoryHook r0 = XmlFactoryHook.ThreadContext.getHook();
        if (r0 == null) goto L7;
        return r0.parse(this, r3, r6, r5);
    L7:
        return Locale.parseToXmlObject(this, r3, r6, r5);
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public XmlObject parse(e r3, SchemaType r4, XmlOptions r5) {
        e r6 = (e) ZeusTransformUtils.wrapperContextForParams(r3, e.class, "com.obric.memorydata.plugin");
        SchemaType r7 = (SchemaType) ZeusTransformUtils.wrapperContextForParams(r4, SchemaType.class, "com.obric.memorydata.plugin");
        XmlFactoryHook r0 = XmlFactoryHook.ThreadContext.getHook();
        if (r0 == null) goto L7;
        return r0.parse(this, r6, r7, r5);
    L7:
        return Locale.parseToXmlObject(this, r6, r7, r5);
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public XmlObject parse(Node r3, SchemaType r4, XmlOptions r5) {
        Node r6 = (Node) ZeusTransformUtils.wrapperContextForParams(r3, Node.class, "com.obric.memorydata.plugin");
        SchemaType r7 = (SchemaType) ZeusTransformUtils.wrapperContextForParams(r4, SchemaType.class, "com.obric.memorydata.plugin");
        XmlFactoryHook r0 = XmlFactoryHook.ThreadContext.getHook();
        if (r0 == null) goto L7;
        return r0.parse(this, r6, r7, r5);
    L7:
        return Locale.parseToXmlObject(this, r6, r7, r5);
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaType typeForSignature(String r13) {
        int r0 = r13.indexOf(64);
        if (r0 >= 0) goto L5;
        r0 = r13.length();
        String r1 = "";
    L6:
        ArrayList r2 = new ArrayList();
        int r4 = 0;
    L8:
        if (r4 >= r0) goto L19;
        int r6 = r13.indexOf(58, r4);
        int r7 = r13.indexOf(124, r4);
        if (r6 >= 0) goto L12;
        r6 = r7;
    L15:
        if (r6 < 0) goto L17;
        if (r6 > r0) goto L17;
    L18:
        r2.add(r13.substring(r4, r6));
        r4 = r6 + 1;
    L17:
        r6 = r0;
        goto L18
    L12:
        if (r7 < 0) goto L15;
        r6 = Math.min(r6, r7);
        goto L15
    L19:
        int r14 = r2.size() - 1;
        SchemaType r5 = null;
    L20:
        if (r14 < 0) goto L136;
        String r8 = (String) ZeusTransformUtils.preCheckCast(r2.get(r14), String.class, "com.obric.memorydata.plugin");
        if (r8.length() < 1) goto L135;
        if (r8.length() >= 2) goto L26;
    L28:
        int r9 = 1;
    L29:
        char r10 = r8.charAt(0);
        if (r10 != 'I') goto L32;
        if (r5 == null) goto L133;
        if (r5.getSimpleVariety() != 3) goto L126;
        SchemaType[] r11 = r5.getAnonymousTypes();
        if (r11.length != 1) goto L129;
        r5 = r11[0];
    L131:
        r14 = r14 - 1;
        goto L20
    L129:
        return null;
    L126:
        return null;
    L133:
        throw new IllegalArgumentException();
    L32:
        if (r10 != 'M') goto L34;
        if (r5 == null) goto L122;
        int r12 = Integer.parseInt(r8.substring(r9));     // Catch: Exception -> L119
        if (r5.getSimpleVariety() != 2) goto L114;
        SchemaType[] r15 = r5.getAnonymousTypes();
        if (r15.length <= r12) goto L117;
        r5 = r15[r12];
        goto L131
    L117:
        return null;
    L114:
        return null;
    L120:
        throw new IllegalArgumentException();
    L122:
        throw new IllegalArgumentException();
    L34:
        if (r10 != 'Q') goto L36;
    L91:
        if (r5 != null) goto L93;
        SchemaGlobalAttribute r16 = findAttribute(QNameHelper.forLNS(r8.substring(r9), r1));
        if (r16 == null) goto L108;
        r5 = r16.getType();
        goto L131
    L108:
        return null;
    L93:
        if (r5.isSimpleType() == true) goto L94;
        SchemaType[] r17 = r5.getAnonymousTypes();
        String r18 = r8.substring(r9);
        int r19 = r17.length;
        int r20 = 0;
    L96:
        if (r20 >= r19) goto L105;
        SchemaType r21 = r17[r20];
        SchemaField r110 = r21.getContainerField();
        if (r110 == null) goto L104;
        if (r110.isAttribute() == false) goto L104;
        if (r110.getName().getLocalPart().equals(r18) == false) goto L104;
    L103:
        r5 = r21;
    L104:
        r20 = r20 + 1;
        goto L96
    L105:
        return null;
    L94:
        return null;
    L36:
        if (r10 != 'R') goto L38;
    L85:
        if (r5 != null) goto L90;
        r5 = findAttributeType(QNameHelper.forLNS(r8.substring(r9), r1));
        if (r5 != null) goto L131;
        return null;
    L90:
        throw new IllegalArgumentException();
    L38:
        if (r10 != 'T') goto L40;
        if (r5 != null) goto L84;
        r5 = findType(QNameHelper.forLNS(r8.substring(r9), r1));
        if (r5 != null) goto L131;
        return null;
    L84:
        throw new IllegalArgumentException();
    L40:
        if (r10 == 'U') goto L60;
        switch(r10) {
            case 65: goto L91;
            case 66: goto L50;
            case 67: goto L85;
            case 68: goto L44;
            case 69: goto L60;
            default: goto L43;
        };
    L44:
        if (r5 != null) goto L49;
        r5 = findDocumentType(QNameHelper.forLNS(r8.substring(r9), r1));
        if (r5 != null) goto L131;
        return null;
    L49:
        throw new IllegalArgumentException();
    L50:
        if (r5 == null) goto L59;
        if (r5.getSimpleVariety() != 1) goto L53;
        SchemaType[] r22 = r5.getAnonymousTypes();
        if (r22.length != 1) goto L56;
        r5 = r22[0];
        goto L131
    L56:
        return null;
    L53:
        return null;
    L59:
        throw new IllegalArgumentException();
    L43:
        throw new IllegalArgumentException();
    L60:
        if (r5 != null) goto L62;
        SchemaGlobalElement r23 = findElement(QNameHelper.forLNS(r8.substring(r9), r1));
        if (r23 == null) goto L77;
        r5 = r23.getType();
        goto L131
    L77:
        return null;
    L62:
        if (r5.getContentType() < 3) goto L63;
        SchemaType[] r24 = r5.getAnonymousTypes();
        String r25 = r8.substring(r9);
        int r26 = r24.length;
        int r27 = 0;
    L65:
        if (r27 >= r26) goto L74;
        r21 = r24[r27];
        SchemaField r111 = r21.getContainerField();
        if (r111 == null) goto L73;
        if (r111.isAttribute() == true) goto L73;
        if (r111.getName().getLocalPart().equals(r25) == true) goto L103;
    L73:
        r27 = r27 + 1;
        goto L65
    L74:
        return null;
    L63:
        return null;
    L26:
        if (r8.charAt(1) != '=') goto L28;
        r9 = 2;
        goto L29
    L135:
        throw new IllegalArgumentException();
    L136:
        return r5;
    L5:
        r1 = r13.substring(r0 + 1);
        goto L6
    }
}
