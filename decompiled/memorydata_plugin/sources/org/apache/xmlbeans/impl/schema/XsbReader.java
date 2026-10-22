package org.apache.xmlbeans.impl.schema;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.QNameSet;
import org.apache.xmlbeans.SchemaAnnotation;
import org.apache.xmlbeans.SchemaAttributeGroup;
import org.apache.xmlbeans.SchemaComponent;
import org.apache.xmlbeans.SchemaGlobalAttribute;
import org.apache.xmlbeans.SchemaGlobalElement;
import org.apache.xmlbeans.SchemaIdentityConstraint;
import org.apache.xmlbeans.SchemaLocalAttribute;
import org.apache.xmlbeans.SchemaModelGroup;
import org.apache.xmlbeans.SchemaParticle;
import org.apache.xmlbeans.SchemaProperty;
import org.apache.xmlbeans.SchemaStringEnumEntry;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SchemaTypeLoaderException;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.regex.RegularExpression;
import org.apache.xmlbeans.impl.util.LongUTFDataInputStream;
import org.apache.xmlbeans.impl.util.LongUTFDataOutputStream;
import org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroupDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.GroupDocument;
import org.apache.xmlbeans.soap.SOAPArrayType;

/* JADX INFO: loaded from: classes7.dex */
class XsbReader {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    int _actualfiletype;
    private String _handle;
    private LongUTFDataInputStream _input;
    private int _majorver;
    private int _minorver;
    private LongUTFDataOutputStream _output;
    private int _releaseno;
    private SchemaTypeSystemImpl.StringPool _stringPool;
    private final SchemaTypeSystemImpl typeSystem;

    static {
    }

    public XsbReader(SchemaTypeSystemImpl r6, String r7, int r8) {
        this.typeSystem = r6;
        String r0 = r6.getBasePackage() + r7 + ".xsb";
        InputStream r1 = r6.getLoaderStream(r0);
        if (r1 == null) goto L33;
        this._input = new LongUTFDataInputStream(r1);
        this._handle = r7;
        if (readInt() != (-629491010)) goto L31;
        this._majorver = readShort();
        int r2 = readShort();
        this._minorver = r2;
        if (this._majorver != 2) goto L29;
        if (r2 > 24) goto L27;
        if (r2 < 14) goto L25;
        if (atLeast(2, 18, 0) == false) goto L15;
        this._releaseno = readShort();
    L15:
        int r3 = readShort();
        if (r3 != r8) goto L18;
    L22:
        SchemaTypeSystemImpl.StringPool r9 = new SchemaTypeSystemImpl.StringPool(this._handle, r6.getName());
        this._stringPool = r9;
        r9.readFrom(this._input);
        this._actualfiletype = r3;
        return;
    L18:
        if (r8 == 65535) goto L22;
        throw new SchemaTypeLoaderException("XML-BEANS compiled schema: File has the wrong type - expecting type " + r8 + ", got type " + r3, r6.getName(), r7, 4);
    L25:
        throw new SchemaTypeLoaderException("XML-BEANS compiled schema: Incompatible minor version - expecting at least 14, got " + this._minorver, r6.getName(), r7, 3);
    L27:
        throw new SchemaTypeLoaderException("XML-BEANS compiled schema: Incompatible minor version - expecting up to 24, got " + this._minorver, r6.getName(), r7, 3);
    L29:
        throw new SchemaTypeLoaderException("XML-BEANS compiled schema: Wrong major version - expecting 2, got " + this._majorver, r6.getName(), r7, 2);
    L31:
        throw new SchemaTypeLoaderException("XML-BEANS compiled schema: Wrong magic cookie", r6.getName(), r7, 1);
    L33:
        throw new SchemaTypeLoaderException("XML-BEANS compiled schema: Could not locate compiled schema resource " + r0, r6.getName(), r7, 0);
    }

    public boolean atLeast(int r4, int r5, int r6) {
        int r0 = this._majorver;
        if (r0 <= r4) goto L6;
        return true;
    L6:
        if (r0 >= r4) goto L8;
        return false;
    L8:
        int r7 = this._minorver;
        if (r7 <= r5) goto L11;
        return true;
    L11:
        if (r7 >= r5) goto L14;
        return false;
    L14:
        if (this._releaseno < r6) goto L17;
        return true;
    L17:
        return false;
    }

    public boolean atMost(int r4, int r5, int r6) {
        int r0 = this._majorver;
        if (r0 <= r4) goto L6;
        return false;
    L6:
        if (r0 >= r4) goto L8;
        return true;
    L8:
        int r7 = this._minorver;
        if (r7 <= r5) goto L11;
        return false;
    L11:
        if (r7 >= r5) goto L14;
        return true;
    L14:
        if (this._releaseno <= r6) goto L16;
        return false;
    L16:
        return true;
    }

    void checkContainerNotNull(SchemaContainer r3, QName r4) {
        if (r3 == null) goto L5;
        return;
    L5:
        throw new LinkageError("Loading of resource " + r4 + '.' + this._handle + "failed, information from " + r4 + ".index.xsb is  out of sync (or conflicting index files found)");
    }

    public SchemaGlobalAttribute finishLoadingAttribute() {
        QName r0 = readQName();     // Catch: Throwable -> L5 Exception -> L7 SchemaTypeLoaderException -> L11
        SchemaContainer r1 = this.typeSystem.getContainer(r0.getNamespaceURI());     // Catch: Throwable -> L5 Exception -> L7 SchemaTypeLoaderException -> L11
        checkContainerNotNull(r1, r0);     // Catch: Throwable -> L5 Exception -> L7 SchemaTypeLoaderException -> L11
        SchemaGlobalAttributeImpl r2 = new SchemaGlobalAttributeImpl(r1);     // Catch: Throwable -> L5 Exception -> L7 SchemaTypeLoaderException -> L11
        loadAttribute(r2, r0, r1);     // Catch: Throwable -> L5 Exception -> L7 SchemaTypeLoaderException -> L11
        r2.setFilename(readString());     // Catch: Throwable -> L5 Exception -> L7 SchemaTypeLoaderException -> L11
        readEnd();
        return r2;
    L5:
        th = move-exception;
        readEnd();
        throw th;
    L11:
        e = move-exception;
        throw e;     // Catch: Throwable -> L5
    L7:
        e = move-exception;
        throw new SchemaTypeLoaderException("Cannot load type from typesystem", this.typeSystem.getName(), this._handle, 14, e);     // Catch: Throwable -> L5
    }

    SchemaAttributeGroup finishLoadingAttributeGroup() {
        QName r1 = readQName();
        SchemaContainer r0 = this.typeSystem.getContainer(r1.getNamespaceURI());
        checkContainerNotNull(r0, r1);
        SchemaAttributeGroupImpl r9 = new SchemaAttributeGroupImpl(r0);
        String r2 = readString();     // Catch: Throwable -> L22 Exception -> L24 SchemaTypeLoaderException -> L28
        if (readShort() != 1) goto L6;
        boolean r3 = true;
    L8:
        if (atLeast(2, 22, 0) == false) goto L10;
        String r5 = readString();     // Catch: Throwable -> L22 Exception -> L24 SchemaTypeLoaderException -> L28
    L12:
        if (atLeast(2, 15, 0) == true) goto L14;
    L16:
        boolean r6 = false;
    L17:
        r9.init(r1, r2, r3, r5, r6, ((AttributeGroupDocument) ZeusTransformUtils.preCheckCast(AttributeGroupDocument.Factory.parse(readString()), AttributeGroupDocument.class, "com.obric.memorydata.plugin")).getAttributeGroup(), readAnnotation(r0), null);     // Catch: Throwable -> L22 Exception -> L24 SchemaTypeLoaderException -> L28
        if (atLeast(2, 21, 0) == false) goto L20;
        r9.setFilename(readString());     // Catch: Throwable -> L22 Exception -> L24 SchemaTypeLoaderException -> L28
    L20:
        readEnd();
        return r9;
    L14:
        if (readShort() != 1) goto L16;
        r6 = true;
        goto L17
    L10:
        r5 = null;
        goto L12
    L6:
        r3 = false;
    L22:
        th = move-exception;
        readEnd();
        throw th;
    L28:
        e = move-exception;
        throw e;     // Catch: Throwable -> L22
    L24:
        e = move-exception;
        throw new SchemaTypeLoaderException("Cannot load type from typesystem", this.typeSystem.getName(), this._handle, 14, e);     // Catch: Throwable -> L22
    }

    public SchemaGlobalElement finishLoadingElement() {
        int r0 = readShort();     // Catch: Throwable -> L58 Exception -> L60 SchemaTypeLoaderException -> L64
        if (r0 != 4) goto L57;
        int r1 = readShort();     // Catch: Throwable -> L58 Exception -> L60 SchemaTypeLoaderException -> L64
        BigInteger r2 = readBigInteger();     // Catch: Throwable -> L58 Exception -> L60 SchemaTypeLoaderException -> L64
        BigInteger r3 = readBigInteger();     // Catch: Throwable -> L58 Exception -> L60 SchemaTypeLoaderException -> L64
        QNameSet r4 = readQNameSet();     // Catch: Throwable -> L58 Exception -> L60 SchemaTypeLoaderException -> L64
        QName r5 = readQName();     // Catch: Throwable -> L58 Exception -> L60 SchemaTypeLoaderException -> L64
        SchemaContainer r6 = this.typeSystem.getContainer(r5.getNamespaceURI());     // Catch: Throwable -> L58 Exception -> L60 SchemaTypeLoaderException -> L64
        checkContainerNotNull(r6, r5);     // Catch: Throwable -> L58 Exception -> L60 SchemaTypeLoaderException -> L64
        SchemaGlobalElementImpl r7 = new SchemaGlobalElementImpl(r6);     // Catch: Throwable -> L58 Exception -> L60 SchemaTypeLoaderException -> L64
        r7.setParticleType(r0);     // Catch: Throwable -> L58 Exception -> L60 SchemaTypeLoaderException -> L64
        r7.setMinOccurs(r2);     // Catch: Throwable -> L58 Exception -> L60 SchemaTypeLoaderException -> L64
        r7.setMaxOccurs(r3);     // Catch: Throwable -> L58 Exception -> L60 SchemaTypeLoaderException -> L64
        boolean r8 = true;
        int r9 = 0;
        if ((r1 & 1) == 0) goto L7;
        boolean r10 = true;
    L8:
        r7.setTransitionRules(r4, r10);     // Catch: Throwable -> L58 Exception -> L60 SchemaTypeLoaderException -> L64
        r7.setNameAndTypeRef(r5, readTypeRef());     // Catch: Throwable -> L58 Exception -> L60 SchemaTypeLoaderException -> L64
        String r11 = readString();     // Catch: Throwable -> L58 Exception -> L60 SchemaTypeLoaderException -> L64
        if ((r1 & 4) == 0) goto L11;
        boolean r12 = true;
    L12:
        r7.setDefault(r11, r12, null);     // Catch: Throwable -> L58 Exception -> L60 SchemaTypeLoaderException -> L64
        if (atLeast(2, 16, 0) == false) goto L16;
        r7.setDefaultValue(readXmlValueObject());     // Catch: Throwable -> L58 Exception -> L60 SchemaTypeLoaderException -> L64
    L16:
        if ((r1 & 8) == 0) goto L18;
        boolean r13 = true;
    L19:
        r7.setNillable(r13);     // Catch: Throwable -> L58 Exception -> L60 SchemaTypeLoaderException -> L64
        if ((r1 & 16) == 0) goto L22;
        boolean r14 = true;
    L24:
        if ((r1 & 32) == 0) goto L26;
        boolean r15 = true;
    L28:
        if ((r1 & 64) == 0) goto L30;
        boolean r16 = true;
    L31:
        r7.setBlock(r14, r15, r16);     // Catch: Throwable -> L58 Exception -> L60 SchemaTypeLoaderException -> L64
        r7.setWsdlArrayType(readSOAPArrayType());     // Catch: Throwable -> L58 Exception -> L60 SchemaTypeLoaderException -> L64
        if ((r1 & 128) == 0) goto L34;
        boolean r17 = true;
    L35:
        r7.setAbstract(r17);     // Catch: Throwable -> L58 Exception -> L60 SchemaTypeLoaderException -> L64
        r7.setAnnotation(readAnnotation(r6));     // Catch: Throwable -> L58 Exception -> L60 SchemaTypeLoaderException -> L64
        if ((r1 & 256) == 0) goto L38;
        boolean r18 = true;
    L40:
        if ((r1 & 512) != 0) goto L43;
        r8 = false;
    L43:
        r7.setFinal(r18, r8);     // Catch: Throwable -> L58 Exception -> L60 SchemaTypeLoaderException -> L64
        if (atLeast(2, 17, 0) == false) goto L47;
        r7.setSubstitutionGroup((SchemaGlobalElement.Ref) ZeusTransformUtils.preCheckCast(readHandle(), SchemaGlobalElement.Ref.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L58 Exception -> L60 SchemaTypeLoaderException -> L64
    L47:
        int r19 = readShort();     // Catch: Throwable -> L58 Exception -> L60 SchemaTypeLoaderException -> L64
        int r20 = 0;
    L48:
        if (r20 >= r19) goto L50;
        r7.addSubstitutionGroupMember(readQName());     // Catch: Throwable -> L58 Exception -> L60 SchemaTypeLoaderException -> L64
        r20 = r20 + 1;     // Catch: Throwable -> L58 Exception -> L60 SchemaTypeLoaderException -> L64
        goto L48
    L50:
        int r21 = readShort();     // Catch: Throwable -> L58 Exception -> L60 SchemaTypeLoaderException -> L64
        SchemaIdentityConstraint.Ref[] r22 = new SchemaIdentityConstraint.Ref[r21];     // Catch: Throwable -> L58 Exception -> L60 SchemaTypeLoaderException -> L64
    L51:
        if (r9 >= r21) goto L53;
        r22[r9] = (SchemaIdentityConstraint.Ref) ZeusTransformUtils.preCheckCast(readHandle(), SchemaIdentityConstraint.Ref.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L58 Exception -> L60 SchemaTypeLoaderException -> L64
        r9 = r9 + 1;     // Catch: Throwable -> L58 Exception -> L60 SchemaTypeLoaderException -> L64
        goto L51
    L53:
        r7.setIdentityConstraints(r22);     // Catch: Throwable -> L58 Exception -> L60 SchemaTypeLoaderException -> L64
        r7.setFilename(readString());     // Catch: Throwable -> L58 Exception -> L60 SchemaTypeLoaderException -> L64
        readEnd();
        return r7;
    L38:
        r18 = false;
        goto L40
    L34:
        r17 = false;
        goto L35
    L30:
        r16 = false;
        goto L31
    L26:
        r15 = false;
        goto L28
    L22:
        r14 = false;
        goto L24
    L18:
        r13 = false;
        goto L19
    L11:
        r12 = false;
        goto L12
    L7:
        r10 = false;
        goto L8
    L57:
        throw new SchemaTypeLoaderException("Wrong particle type ", this.typeSystem.getName(), this._handle, 11);     // Catch: Throwable -> L58 Exception -> L60 SchemaTypeLoaderException -> L64
    L58:
        th = move-exception;
        readEnd();
        throw th;
    L64:
        e = move-exception;
        throw e;     // Catch: Throwable -> L58
    L60:
        e = move-exception;
        throw new SchemaTypeLoaderException("Cannot load type from typesystem", this.typeSystem.getName(), null, 14, e);     // Catch: Throwable -> L58
    }

    SchemaIdentityConstraint finishLoadingIdentityConstraint() {
        QName r0 = readQName();     // Catch: Throwable -> L16 Exception -> L18 SchemaTypeLoaderException -> L22
        SchemaContainer r1 = this.typeSystem.getContainer(r0.getNamespaceURI());     // Catch: Throwable -> L16 Exception -> L18 SchemaTypeLoaderException -> L22
        checkContainerNotNull(r1, r0);     // Catch: Throwable -> L16 Exception -> L18 SchemaTypeLoaderException -> L22
        SchemaIdentityConstraintImpl r2 = new SchemaIdentityConstraintImpl(r1);     // Catch: Throwable -> L16 Exception -> L18 SchemaTypeLoaderException -> L22
        r2.setName(r0);     // Catch: Throwable -> L16 Exception -> L18 SchemaTypeLoaderException -> L22
        r2.setConstraintCategory(readShort());     // Catch: Throwable -> L16 Exception -> L18 SchemaTypeLoaderException -> L22
        r2.setSelector(readString());     // Catch: Throwable -> L16 Exception -> L18 SchemaTypeLoaderException -> L22
        r2.setAnnotation(readAnnotation(r1));     // Catch: Throwable -> L16 Exception -> L18 SchemaTypeLoaderException -> L22
        int r3 = readShort();     // Catch: Throwable -> L16 Exception -> L18 SchemaTypeLoaderException -> L22
        String[] r4 = new String[r3];     // Catch: Throwable -> L16 Exception -> L18 SchemaTypeLoaderException -> L22
        int r5 = 0;
    L3:
        if (r5 >= r3) goto L5;
        r4[r5] = readString();     // Catch: Throwable -> L16 Exception -> L18 SchemaTypeLoaderException -> L22
        r5 = r5 + 1;     // Catch: Throwable -> L16 Exception -> L18 SchemaTypeLoaderException -> L22
        goto L3
    L5:
        r2.setFields(r4);     // Catch: Throwable -> L16 Exception -> L18 SchemaTypeLoaderException -> L22
        if (r2.getConstraintCategory() != 2) goto L8;
        r2.setReferencedKey((SchemaIdentityConstraint.Ref) ZeusTransformUtils.preCheckCast(readHandle(), SchemaIdentityConstraint.Ref.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L16 Exception -> L18 SchemaTypeLoaderException -> L22
    L8:
        int r6 = readShort();     // Catch: Throwable -> L16 Exception -> L18 SchemaTypeLoaderException -> L22
        HashMap r7 = new HashMap();     // Catch: Throwable -> L16 Exception -> L18 SchemaTypeLoaderException -> L22
        int r8 = 0;
    L9:
        if (r8 >= r6) goto L11;
        r7.put(readString(), readString());     // Catch: Throwable -> L16 Exception -> L18 SchemaTypeLoaderException -> L22
        r8 = r8 + 1;     // Catch: Throwable -> L16 Exception -> L18 SchemaTypeLoaderException -> L22
        goto L9
    L11:
        r2.setNSMap(r7);     // Catch: Throwable -> L16 Exception -> L18 SchemaTypeLoaderException -> L22
        if (atLeast(2, 21, 0) == false) goto L14;
        r2.setFilename(readString());     // Catch: Throwable -> L16 Exception -> L18 SchemaTypeLoaderException -> L22
    L14:
        readEnd();
        return r2;
    L16:
        th = move-exception;
        readEnd();
        throw th;
    L22:
        e = move-exception;
        throw e;     // Catch: Throwable -> L16
    L18:
        e = move-exception;
        throw new SchemaTypeLoaderException("Cannot load type from typesystem", this.typeSystem.getName(), this._handle, 14, e);     // Catch: Throwable -> L16
    }

    SchemaModelGroup finishLoadingModelGroup() {
        QName r1 = readQName();
        SchemaContainer r0 = this.typeSystem.getContainer(r1.getNamespaceURI());
        checkContainerNotNull(r0, r1);
        SchemaModelGroupImpl r10 = new SchemaModelGroupImpl(r0);
        String r2 = readString();     // Catch: Throwable -> L26 Exception -> L28 SchemaTypeLoaderException -> L32
        if (readShort() != 1) goto L6;
        boolean r3 = true;
    L8:
        if (atLeast(2, 22, 0) == false) goto L10;
        String r6 = readString();     // Catch: Throwable -> L26 Exception -> L28 SchemaTypeLoaderException -> L32
    L12:
        if (atLeast(2, 22, 0) == false) goto L14;
        String r5 = readString();     // Catch: Throwable -> L26 Exception -> L28 SchemaTypeLoaderException -> L32
    L16:
        if (atLeast(2, 15, 0) == true) goto L18;
    L20:
        boolean r7 = false;
    L21:
        r10.init(r1, r2, r3, r6, r5, r7, ((GroupDocument) ZeusTransformUtils.preCheckCast(GroupDocument.Factory.parse(readString()), GroupDocument.class, "com.obric.memorydata.plugin")).getGroup(), readAnnotation(r0), null);     // Catch: Throwable -> L26 Exception -> L28 SchemaTypeLoaderException -> L32
        if (atLeast(2, 21, 0) == false) goto L24;
        r10.setFilename(readString());     // Catch: Throwable -> L26 Exception -> L28 SchemaTypeLoaderException -> L32
    L24:
        readEnd();
        return r10;
    L18:
        if (readShort() != 1) goto L20;
        r7 = true;
        goto L21
    L14:
        r5 = null;
        goto L16
    L10:
        r6 = null;
        goto L12
    L6:
        r3 = false;
    L26:
        th = move-exception;
        readEnd();
        throw th;
    L32:
        e = move-exception;
        throw e;     // Catch: Throwable -> L26
    L28:
        e = move-exception;
        throw new SchemaTypeLoaderException("Cannot load type from typesystem", this.typeSystem.getName(), this._handle, 14, e);     // Catch: Throwable -> L26
    }

    public SchemaType finishLoadingType() {
        String r2 = "";
        int r11 = 1;
        SchemaTypeImpl r10 = new SchemaTypeImpl(this.typeSystem.getContainerNonNull(""), true);     // Catch: Throwable -> L207 Exception -> L209 SchemaTypeLoaderException -> L213
        r10.setName(readQName());     // Catch: Throwable -> L207 Exception -> L209 SchemaTypeLoaderException -> L213
        r10.setOuterSchemaTypeRef(readTypeRef());     // Catch: Throwable -> L207 Exception -> L209 SchemaTypeLoaderException -> L213
        r10.setBaseDepth(readShort());     // Catch: Throwable -> L207 Exception -> L209 SchemaTypeLoaderException -> L213
        r10.setBaseTypeRef(readTypeRef());     // Catch: Throwable -> L207 Exception -> L209 SchemaTypeLoaderException -> L213
        r10.setDerivationType(readShort());     // Catch: Throwable -> L207 Exception -> L209 SchemaTypeLoaderException -> L213
        r10.setAnnotation(readAnnotation(null));     // Catch: Throwable -> L207 Exception -> L209 SchemaTypeLoaderException -> L213
        int r4 = readShort();     // Catch: Throwable -> L207 Exception -> L209 SchemaTypeLoaderException -> L213
        if (r4 == 1) goto L10;
        if (r4 == 2) goto L9;
        if (r4 != 3) goto L11;
        r10.setContainerFieldIndex(2, readShort());     // Catch: Throwable -> L207 Exception -> L209 SchemaTypeLoaderException -> L213
    L11:
        String r5 = readString();     // Catch: Throwable -> L207 Exception -> L209 SchemaTypeLoaderException -> L213
        if (r5 != null) goto L14;
        r5 = "";
    L14:
        r10.setFullJavaName(r5);     // Catch: Throwable -> L207 Exception -> L209 SchemaTypeLoaderException -> L213
        String r6 = readString();     // Catch: Throwable -> L207 Exception -> L209 SchemaTypeLoaderException -> L213
        if (r6 == null) goto L18;
        r2 = r6;
    L18:
        r10.setFullJavaImplName(r2);     // Catch: Throwable -> L207 Exception -> L209 SchemaTypeLoaderException -> L213
        r10.setAnonymousTypeRefs(readTypeRefArray());     // Catch: Throwable -> L207 Exception -> L209 SchemaTypeLoaderException -> L213
        r10.setAnonymousUnionMemberOrdinal(readShort());     // Catch: Throwable -> L207 Exception -> L209 SchemaTypeLoaderException -> L213
        int r3 = readInt();     // Catch: Throwable -> L207 Exception -> L209 SchemaTypeLoaderException -> L213
        if ((r3 & 1) != 0) goto L21;
        boolean r15 = true;
    L23:
        if ((r3 & 2048) == 0) goto L25;
        boolean r7 = true;
    L26:
        r10.setCompiled(r7);     // Catch: Throwable -> L207 Exception -> L209 SchemaTypeLoaderException -> L213
        if ((r3 & 2) == 0) goto L29;
        boolean r8 = true;
    L30:
        r10.setDocumentType(r8);     // Catch: Throwable -> L207 Exception -> L209 SchemaTypeLoaderException -> L213
        if ((524288 & r3) == 0) goto L33;
        boolean r9 = true;
    L34:
        r10.setAttributeType(r9);     // Catch: Throwable -> L207 Exception -> L209 SchemaTypeLoaderException -> L213
        if (r15 == true) goto L37;
        boolean r12 = true;
    L38:
        r10.setSimpleType(r12);     // Catch: Throwable -> L207 Exception -> L209 SchemaTypeLoaderException -> L213
        if (r15 == true) goto L41;
        int r13 = 0;
    L112:
        if (r15 == true) goto L114;
    L115:
        int r14 = readShort();     // Catch: Throwable -> L207 Exception -> L209 SchemaTypeLoaderException -> L213
        r10.setSimpleTypeVariety(r14);     // Catch: Throwable -> L207 Exception -> L209 SchemaTypeLoaderException -> L213
        if ((r3 & 64) == 0) goto L118;
        boolean r16 = true;
    L120:
        if ((r3 & 4) == 0) goto L123;
        int r17 = 0;
    L126:
        r10.setOrdered(r17);     // Catch: Throwable -> L207 Exception -> L209 SchemaTypeLoaderException -> L213
        if ((r3 & 8) == 0) goto L129;
        boolean r18 = true;
    L130:
        r10.setBounded(r18);     // Catch: Throwable -> L207 Exception -> L209 SchemaTypeLoaderException -> L213
        if ((r3 & 16) == 0) goto L133;
        boolean r19 = true;
    L134:
        r10.setFinite(r19);     // Catch: Throwable -> L207 Exception -> L209 SchemaTypeLoaderException -> L213
        if ((r3 & 32) == 0) goto L137;
        boolean r20 = true;
    L138:
        r10.setNumeric(r20);     // Catch: Throwable -> L207 Exception -> L209 SchemaTypeLoaderException -> L213
        if ((r3 & 128) == 0) goto L141;
        boolean r21 = true;
    L142:
        r10.setUnionOfLists(r21);     // Catch: Throwable -> L207 Exception -> L209 SchemaTypeLoaderException -> L213
        if ((r3 & 32768) == 0) goto L145;
        boolean r22 = true;
    L147:
        if ((r3 & 131072) == 0) goto L149;
        boolean r23 = true;
    L151:
        if ((r3 & 65536) == 0) goto L153;
        boolean r24 = true;
    L154:
        r10.setSimpleFinal(r22, r23, r24);     // Catch: Throwable -> L207 Exception -> L209 SchemaTypeLoaderException -> L213
        XmlValueRef[] r25 = new XmlValueRef[12];     // Catch: Throwable -> L207 Exception -> L209 SchemaTypeLoaderException -> L213
        boolean[] r26 = new boolean[12];     // Catch: Throwable -> L207 Exception -> L209 SchemaTypeLoaderException -> L213
        int r27 = readShort();     // Catch: Throwable -> L207 Exception -> L209 SchemaTypeLoaderException -> L213
        int r28 = 0;
    L155:
        if (r28 >= r27) goto L161;
        int r29 = readShort();     // Catch: Throwable -> L207 Exception -> L209 SchemaTypeLoaderException -> L213
        r25[r29] = readXmlValueObject();     // Catch: Throwable -> L207 Exception -> L209 SchemaTypeLoaderException -> L213
        if (readShort() != 1) goto L159;
        boolean r110 = true;
    L160:
        r26[r29] = r110;     // Catch: Throwable -> L207 Exception -> L209 SchemaTypeLoaderException -> L213
        r28 = r28 + 1;     // Catch: Throwable -> L207 Exception -> L209 SchemaTypeLoaderException -> L213
        goto L155
    L159:
        r110 = false;
        goto L160
    L161:
        r10.setBasicFacets(r25, r26);     // Catch: Throwable -> L207 Exception -> L209 SchemaTypeLoaderException -> L213
        r10.setWhiteSpaceRule(readShort());     // Catch: Throwable -> L207 Exception -> L209 SchemaTypeLoaderException -> L213
        if ((r3 & 256) == 0) goto L164;
        boolean r30 = true;
    L165:
        r10.setPatternFacet(r30);     // Catch: Throwable -> L207 Exception -> L209 SchemaTypeLoaderException -> L213
        int r31 = readShort();     // Catch: Throwable -> L207 Exception -> L209 SchemaTypeLoaderException -> L213
        RegularExpression[] r32 = new RegularExpression[r31];     // Catch: Throwable -> L207 Exception -> L209 SchemaTypeLoaderException -> L213
        int r33 = 0;
    L166:
        if (r33 >= r31) goto L168;
        r32[r33] = new RegularExpression(readString(), "X");     // Catch: Throwable -> L207 Exception -> L209 SchemaTypeLoaderException -> L213
        r33 = r33 + 1;     // Catch: Throwable -> L207 Exception -> L209 SchemaTypeLoaderException -> L213
        goto L166
    L168:
        r10.setPatterns(r32);     // Catch: Throwable -> L207 Exception -> L209 SchemaTypeLoaderException -> L213
        int r34 = readShort();     // Catch: Throwable -> L207 Exception -> L209 SchemaTypeLoaderException -> L213
        XmlValueRef[] r35 = new XmlValueRef[r34];     // Catch: Throwable -> L207 Exception -> L209 SchemaTypeLoaderException -> L213
        int r36 = 0;
    L169:
        if (r36 >= r34) goto L171;
        r35[r36] = readXmlValueObject();     // Catch: Throwable -> L207 Exception -> L209 SchemaTypeLoaderException -> L213
        r36 = r36 + 1;     // Catch: Throwable -> L207 Exception -> L209 SchemaTypeLoaderException -> L213
        goto L169
    L171:
        if (r34 != 0) goto L173;
        r35 = null;
    L173:
        r10.setEnumerationValues(r35);     // Catch: Throwable -> L207 Exception -> L209 SchemaTypeLoaderException -> L213
        r10.setBaseEnumTypeRef(readTypeRef());     // Catch: Throwable -> L207 Exception -> L209 SchemaTypeLoaderException -> L213
        if (r16 == false) goto L180;
        int r37 = readUnsignedShortOrInt();     // Catch: Throwable -> L207 Exception -> L209 SchemaTypeLoaderException -> L213
        SchemaStringEnumEntry[] r38 = new SchemaStringEnumEntry[r37];     // Catch: Throwable -> L207 Exception -> L209 SchemaTypeLoaderException -> L213
        int r111 = 0;
    L176:
        if (r111 >= r37) goto L178;
        r38[r111] = new SchemaStringEnumEntryImpl(readString(), readShort(), readString());     // Catch: Throwable -> L207 Exception -> L209 SchemaTypeLoaderException -> L213
        r111 = r111 + 1;     // Catch: Throwable -> L207 Exception -> L209 SchemaTypeLoaderException -> L213
        goto L176
    L178:
        r10.setStringEnumEntries(r38);     // Catch: Throwable -> L207 Exception -> L209 SchemaTypeLoaderException -> L213
    L180:
        if (r14 != 1) goto L182;
        r10.setPrimitiveTypeRef(readTypeRef());     // Catch: Throwable -> L207 Exception -> L209 SchemaTypeLoaderException -> L213
        r10.setDecimalSize(readInt());     // Catch: Throwable -> L207 Exception -> L209 SchemaTypeLoaderException -> L213
    L190:
        r10.setFilename(readString());     // Catch: Throwable -> L207 Exception -> L209 SchemaTypeLoaderException -> L213
        if (r10.getName() == null) goto L194;
        SchemaContainer r39 = this.typeSystem.getContainer(r10.getName().getNamespaceURI());     // Catch: Throwable -> L207 Exception -> L209 SchemaTypeLoaderException -> L213
        checkContainerNotNull(r39, r10.getName());     // Catch: Throwable -> L207 Exception -> L209 SchemaTypeLoaderException -> L213
        r10.setContainer(r39);     // Catch: Throwable -> L207 Exception -> L209 SchemaTypeLoaderException -> L213
    L205:
        readEnd();
        return r10;
    L194:
        if (r10.isDocumentType() == false) goto L200;
        QName r40 = r10.getDocumentElementName();     // Catch: Throwable -> L207 Exception -> L209 SchemaTypeLoaderException -> L213
        if (r40 == null) goto L205;
        SchemaContainer r41 = this.typeSystem.getContainer(r40.getNamespaceURI());     // Catch: Throwable -> L207 Exception -> L209 SchemaTypeLoaderException -> L213
        checkContainerNotNull(r41, r40);     // Catch: Throwable -> L207 Exception -> L209 SchemaTypeLoaderException -> L213
    L198:
        r10.setContainer(r41);     // Catch: Throwable -> L207 Exception -> L209 SchemaTypeLoaderException -> L213
        goto L205
    L200:
        if (r10.isAttributeType() == false) goto L205;
        QName r42 = r10.getAttributeTypeAttributeName();     // Catch: Throwable -> L207 Exception -> L209 SchemaTypeLoaderException -> L213
        if (r42 == null) goto L205;
        r41 = this.typeSystem.getContainer(r42.getNamespaceURI());     // Catch: Throwable -> L207 Exception -> L209 SchemaTypeLoaderException -> L213
        checkContainerNotNull(r41, r42);     // Catch: Throwable -> L207 Exception -> L209 SchemaTypeLoaderException -> L213
        goto L198
    L182:
        if (r14 != 2) goto L184;
        r10.setPrimitiveTypeRef(BuiltinSchemaTypeSystem.ST_ANY_SIMPLE.getRef());     // Catch: Throwable -> L207 Exception -> L209 SchemaTypeLoaderException -> L213
        r10.setUnionMemberTypeRefs(readTypeRefArray());     // Catch: Throwable -> L207 Exception -> L209 SchemaTypeLoaderException -> L213
        goto L190
    L184:
        if (r14 != 3) goto L187;
        r10.setPrimitiveTypeRef(BuiltinSchemaTypeSystem.ST_ANY_SIMPLE.getRef());     // Catch: Throwable -> L207 Exception -> L209 SchemaTypeLoaderException -> L213
        r10.setListItemTypeRef(readTypeRef());     // Catch: Throwable -> L207 Exception -> L209 SchemaTypeLoaderException -> L213
        goto L190
    L187:
        throw new SchemaTypeLoaderException("Simple type does not have a recognized variety", this.typeSystem.getName(), this._handle, 8);     // Catch: Throwable -> L207 Exception -> L209 SchemaTypeLoaderException -> L213
    L164:
        r30 = false;
        goto L165
    L153:
        r24 = false;
        goto L154
    L149:
        r23 = false;
        goto L151
    L145:
        r22 = false;
        goto L147
    L141:
        r21 = false;
        goto L142
    L137:
        r20 = false;
        goto L138
    L133:
        r19 = false;
        goto L134
    L129:
        r18 = false;
        goto L130
    L123:
        if ((r3 & 1024) == 0) goto L125;
        r17 = 2;
        goto L126
    L125:
        r17 = 1;
        goto L126
    L118:
        r16 = false;
        goto L120
    L114:
        if (r13 != 2) goto L190;
    L41:
        if ((262144 & r3) == 0) goto L43;
        boolean r43 = true;
    L45:
        if ((r3 & 16384) == 0) goto L47;
        boolean r44 = true;
    L49:
        if ((r3 & 32768) == 0) goto L51;
        boolean r45 = true;
    L53:
        if ((r3 & 131072) == 0) goto L55;
        boolean r46 = true;
    L57:
        if ((r3 & 65536) == 0) goto L59;
        boolean r47 = true;
    L60:
        r10.setAbstractFinal(r43, r44, r45, r46, r47);     // Catch: Throwable -> L207 Exception -> L209 SchemaTypeLoaderException -> L213
        if ((r3 & 4096) == 0) goto L63;
        boolean r48 = true;
    L65:
        if ((r3 & 8192) == 0) goto L67;
        boolean r49 = true;
    L68:
        r10.setBlock(r48, r49);     // Catch: Throwable -> L207 Exception -> L209 SchemaTypeLoaderException -> L213
        if ((r3 & 512) == 0) goto L71;
        boolean r50 = true;
    L72:
        r10.setOrderSensitive(r50);     // Catch: Throwable -> L207 Exception -> L209 SchemaTypeLoaderException -> L213
        int r51 = readShort();     // Catch: Throwable -> L207 Exception -> L209 SchemaTypeLoaderException -> L213
        r10.setComplexTypeVariety(r51);     // Catch: Throwable -> L207 Exception -> L209 SchemaTypeLoaderException -> L213
        if (atLeast(2, 23, 0) == false) goto L75;
        r10.setContentBasedOnTypeRef(readTypeRef());     // Catch: Throwable -> L207 Exception -> L209 SchemaTypeLoaderException -> L213
    L75:
        SchemaAttributeModelImpl r52 = new SchemaAttributeModelImpl();     // Catch: Throwable -> L207 Exception -> L209 SchemaTypeLoaderException -> L213
        int r53 = readShort();     // Catch: Throwable -> L207 Exception -> L209 SchemaTypeLoaderException -> L213
        int r54 = 0;
    L76:
        if (r54 >= r53) goto L78;
        r52.addAttribute(readAttributeData());     // Catch: Throwable -> L207 Exception -> L209 SchemaTypeLoaderException -> L213
        r54 = r54 + 1;     // Catch: Throwable -> L207 Exception -> L209 SchemaTypeLoaderException -> L213
        goto L76
    L78:
        r52.setWildcardSet(readQNameSet());     // Catch: Throwable -> L207 Exception -> L209 SchemaTypeLoaderException -> L213
        r52.setWildcardProcess(readShort());     // Catch: Throwable -> L207 Exception -> L209 SchemaTypeLoaderException -> L213
        LinkedHashMap r55 = new LinkedHashMap();     // Catch: Throwable -> L207 Exception -> L209 SchemaTypeLoaderException -> L213
        int r56 = readShort();     // Catch: Throwable -> L207 Exception -> L209 SchemaTypeLoaderException -> L213
        int r57 = 0;
    L80:
        if (r57 >= r56) goto L86;
        SchemaProperty r58 = readPropertyData();     // Catch: Throwable -> L207 Exception -> L209 SchemaTypeLoaderException -> L213
        if (r58.isAttribute() == false) goto L85;
        r55.put(r58.getName(), r58);     // Catch: Throwable -> L207 Exception -> L209 SchemaTypeLoaderException -> L213
        r57 = r57 + 1;     // Catch: Throwable -> L207 Exception -> L209 SchemaTypeLoaderException -> L213
        goto L80
    L85:
        throw new SchemaTypeLoaderException("Attribute property " + r57 + " is not an attribute", this.typeSystem.getName(), this._handle, 6);     // Catch: Throwable -> L207 Exception -> L209 SchemaTypeLoaderException -> L213
    L86:
        if (r51 != 3) goto L88;
    L91:
        int r59 = readShort();     // Catch: Throwable -> L207 Exception -> L209 SchemaTypeLoaderException -> L213
        SchemaParticle[] r60 = readParticleArray();     // Catch: Throwable -> L207 Exception -> L209 SchemaTypeLoaderException -> L213
        if (r60.length != 1) goto L95;
        SchemaParticle r61 = r60[0];     // Catch: Throwable -> L207 Exception -> L209 SchemaTypeLoaderException -> L213
    L97:
        LinkedHashMap r62 = new LinkedHashMap();     // Catch: Throwable -> L207 Exception -> L209 SchemaTypeLoaderException -> L213
        int r112 = readShort();     // Catch: Throwable -> L207 Exception -> L209 SchemaTypeLoaderException -> L213
        int r113 = 0;
    L98:
        if (r113 >= r112) goto L104;
        SchemaProperty r114 = readPropertyData();     // Catch: Throwable -> L207 Exception -> L209 SchemaTypeLoaderException -> L213
        if (r114.isAttribute() == true) goto L103;
        r62.put(r114.getName(), r114);     // Catch: Throwable -> L207 Exception -> L209 SchemaTypeLoaderException -> L213
        r113 = r113 + 1;     // Catch: Throwable -> L207 Exception -> L209 SchemaTypeLoaderException -> L213
        r11 = 1;
        goto L98
    L103:
        throw new SchemaTypeLoaderException("Element property " + r113 + " is not an element", this.typeSystem.getName(), this._handle, 6);     // Catch: Throwable -> L207 Exception -> L209 SchemaTypeLoaderException -> L213
    L104:
        LinkedHashMap r115 = r62;
        int r210 = r11;
        SchemaParticle r116 = r61;
        int r63 = r210;
    L105:
        if (r59 != r63) goto L107;
        boolean r64 = true;
    L108:
        r10.setContentModel(r116, r52, r115, r55, r64);     // Catch: Throwable -> L207 Exception -> L209 SchemaTypeLoaderException -> L213
        StscComplexTypeResolver.WildcardResult r65 = StscComplexTypeResolver.summarizeEltWildcards(r116);     // Catch: Throwable -> L207 Exception -> L209 SchemaTypeLoaderException -> L213
        StscComplexTypeResolver.WildcardResult r66 = StscComplexTypeResolver.summarizeAttrWildcards(r52);     // Catch: Throwable -> L207 Exception -> L209 SchemaTypeLoaderException -> L213
        r10.setWildcardSummary(r65.typedWildcards, r65.hasWildcards, r66.typedWildcards, r66.hasWildcards);     // Catch: Throwable -> L207 Exception -> L209 SchemaTypeLoaderException -> L213
        r13 = r51;
        goto L112
    L107:
        r64 = false;
        goto L108
    L95:
        if (r60.length != 0) goto L110;
        r61 = null;
        goto L97
    L110:
        throw new SchemaTypeLoaderException("Content model not well-formed", this.typeSystem.getName(), this._handle, 7);     // Catch: Throwable -> L207 Exception -> L209 SchemaTypeLoaderException -> L213
    L88:
        if (r51 == 4) goto L91;
        r63 = 1;
        r59 = 0;
        r116 = null;
        r115 = null;
        goto L105
    L71:
        r50 = false;
        goto L72
    L67:
        r49 = false;
        goto L68
    L63:
        r48 = false;
        goto L65
    L59:
        r47 = false;
        goto L60
    L55:
        r46 = false;
        goto L57
    L51:
        r45 = false;
        goto L53
    L47:
        r44 = false;
        goto L49
    L43:
        r43 = false;
        goto L45
    L37:
        r12 = false;
        goto L38
    L33:
        r9 = false;
        goto L34
    L29:
        r8 = false;
        goto L30
    L25:
        r7 = false;
        goto L26
    L21:
        r15 = false;
        goto L23
    L9:
        r10.setContainerFieldIndex(1, readShort());     // Catch: Throwable -> L207 Exception -> L209 SchemaTypeLoaderException -> L213
        goto L11
    L10:
        r10.setContainerFieldRef(readHandle());     // Catch: Throwable -> L207 Exception -> L209 SchemaTypeLoaderException -> L213
    L207:
        th = move-exception;
        readEnd();
        throw th;
    L213:
        e = move-exception;
        throw e;     // Catch: Throwable -> L207
    L209:
        e = move-exception;
        throw new SchemaTypeLoaderException("Cannot load type from typesystem", this.typeSystem.getName(), this._handle, 14, e);     // Catch: Throwable -> L207
    }

    int getActualFiletype() {
        return this._actualfiletype;
    }

    void loadAttribute(SchemaLocalAttributeImpl r12, QName r13, SchemaContainer r14) {
        SchemaType.Ref r2 = readTypeRef();
        int r3 = readShort();
        String r4 = readString();
        if (atLeast(2, 16, 0) == false) goto L5;
        XmlValueRef r0 = readXmlValueObject();
    L6:
        XmlValueRef r6 = r0;
        if (readShort() != 1) goto L9;
        boolean r7 = true;
    L10:
        r12.init(r13, r2, r3, r4, null, r6, r7, readSOAPArrayType(), readAnnotation(r14), null);
        return;
    L9:
        r7 = false;
        goto L10
    L5:
        r0 = null;
        goto L6
    }

    void loadParticle(SchemaParticleImpl r8, int r9) {
        int r0 = readShort();
        r8.setParticleType(r9);
        r8.setMinOccurs(readBigInteger());
        r8.setMaxOccurs(readBigInteger());
        QNameSet r1 = readQNameSet();
        int r3 = 0;
        boolean r4 = true;
        if ((r0 & 1) == 0) goto L5;
        boolean r2 = true;
    L6:
        r8.setTransitionRules(r1, r2);
        if (r9 != 1) goto L9;
    L50:
        r8.setParticleChildren(readParticleArray());
        return;
    L9:
        if (r9 == 2) goto L50;
        if (r9 == 3) goto L50;
        if (r9 != 4) goto L15;
        SchemaLocalElementImpl r10 = (SchemaLocalElementImpl) ZeusTransformUtils.preCheckCast(r8, SchemaLocalElementImpl.class, "com.obric.memorydata.plugin");
        r10.setNameAndTypeRef(readQName(), readTypeRef());
        String r11 = readString();
        if ((r0 & 4) == 0) goto L22;
        boolean r5 = true;
    L23:
        r10.setDefault(r11, r5, null);
        if (atLeast(2, 16, 0) == false) goto L27;
        r10.setDefaultValue(readXmlValueObject());
    L27:
        if ((r0 & 8) == 0) goto L29;
        boolean r12 = true;
    L30:
        r10.setNillable(r12);
        if ((r0 & 16) == 0) goto L33;
        boolean r13 = true;
    L35:
        if ((r0 & 32) == 0) goto L37;
        boolean r6 = true;
    L39:
        if ((r0 & 64) == 0) goto L41;
        boolean r7 = true;
    L42:
        r10.setBlock(r13, r6, r7);
        r10.setWsdlArrayType(readSOAPArrayType());
        if ((r0 & 128) != 0) goto L46;
        r4 = false;
    L46:
        r10.setAbstract(r4);
        r10.setAnnotation(readAnnotation(null));
        int r14 = readShort();
        SchemaIdentityConstraint.Ref[] r15 = new SchemaIdentityConstraint.Ref[r14];
    L47:
        if (r3 >= r14) goto L49;
        r15[r3] = (SchemaIdentityConstraint.Ref) ZeusTransformUtils.preCheckCast(readHandle(), SchemaIdentityConstraint.Ref.class, "com.obric.memorydata.plugin");
        r3 = r3 + 1;
        goto L47
    L49:
        r10.setIdentityConstraints(r15);
        return;
    L41:
        r7 = false;
        goto L42
    L37:
        r6 = false;
        goto L39
    L33:
        r13 = false;
        goto L35
    L29:
        r12 = false;
        goto L30
    L22:
        r5 = false;
        goto L23
    L15:
        if (r9 != 5) goto L18;
        r8.setWildcardSet(readQNameSet());
        r8.setWildcardProcess(readShort());
        return;
    L18:
        throw new SchemaTypeLoaderException("Unrecognized particle type ", this.typeSystem.getName(), this._handle, 11);
    L5:
        r2 = false;
        goto L6
    }

    SchemaAnnotation readAnnotation(SchemaContainer r11) {
        int r2 = 0;
        if (atLeast(2, 19, 0) == true) goto L5;
        return null;
    L5:
        int r1 = readInt();
        if (r1 != (-1)) goto L8;
        return null;
    L8:
        SchemaAnnotation.Attribute[] r4 = new SchemaAnnotation.Attribute[r1];
        int r5 = 0;
    L9:
        if (r5 >= r1) goto L15;
        QName r6 = readQName();
        String r7 = readString();
        if (atLeast(2, 24, 0) == false) goto L13;
        String r8 = readString();
    L14:
        r4[r5] = new SchemaAnnotationImpl.AttributeImpl(r6, r7, r8);
        r5 = r5 + 1;
        goto L9
    L13:
        r8 = null;
        goto L14
    L15:
        int r0 = readInt();
        String[] r3 = new String[r0];
        int r9 = 0;
    L16:
        if (r9 >= r0) goto L18;
        r3[r9] = readString();
        r9 = r9 + 1;
        goto L16
    L18:
        int r10 = readInt();
        String[] r12 = new String[r10];
    L19:
        if (r2 >= r10) goto L22;
        r12[r2] = readString();
        r2 = r2 + 1;
        goto L19
    L22:
        return new SchemaAnnotationImpl(r11, r12, r3, r4);
    }

    List<SchemaAnnotation> readAnnotations() {
        int r0 = readInt();
        ArrayList r1 = new ArrayList(r0);
        SchemaContainer r2 = this.typeSystem.getContainerNonNull("");
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L5;
        r1.add(readAnnotation(r2));
        r3 = r3 + 1;
        goto L3
    L5:
        return r1;
    }

    SchemaLocalAttribute readAttributeData() {
        SchemaLocalAttributeImpl r0 = new SchemaLocalAttributeImpl();
        loadAttribute(r0, readQName(), null);
        return r0;
    }

    BigInteger readBigInteger() {
        byte[] r3 = readByteArray();
        if (r3.length != 0) goto L7;
        return null;
    L7:
        if (r3.length != 1) goto L13;
        if (r3[0] != 0) goto L13;
        return BigInteger.ZERO;
    L13:
        if (r3.length != 1) goto L19;
        if (r3[0] != 1) goto L19;
        return BigInteger.ONE;
    L19:
        return new BigInteger(r3);
    }

    byte[] readByteArray() {
        byte[] r0 = new byte[this._input.readShort()];     // Catch: IOException -> L4
        this._input.readFully(r0);     // Catch: IOException -> L4
        return r0;
    L4:
        e = move-exception;
        throw new SchemaTypeLoaderException(e.getMessage(), this.typeSystem.getName(), this._handle, 9, e);
    }

    Map<String, SchemaComponent.Ref> readClassnameRefMap() {
        HashMap r0 = new HashMap();
        int r1 = readShort();
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        r0.put(readString(), readHandle());
        r2 = r2 + 1;
        goto L3
    L5:
        return r0;
    }

    double readDouble() {
        return this._input.readDouble();
    L4:
        e = move-exception;
        throw new SchemaTypeLoaderException(e.getMessage(), this.typeSystem.getName(), this._handle, 9, e);
    }

    void readEnd() {
        LongUTFDataInputStream r0 = this._input;     // Catch: IOException -> L7
        if (r0 == null) goto L5;
        r0.close();     // Catch: IOException -> L7
    L5:
        this._input = null;
        this._stringPool = null;
        this._handle = null;
    }

    SchemaComponent.Ref readHandle() {
        String r0 = readString();
        if (r0 != null) goto L7;
        return null;
    L7:
        if (r0.charAt(0) != '_') goto L9;
        char r1 = r0.charAt(2);
        if (r1 == 'A') goto L61;
        if (r1 != 'I') goto L15;
        SchemaType r5 = (SchemaType) ZeusTransformUtils.preCheckCast(BuiltinSchemaTypeSystem.get().resolveHandle(r0), SchemaType.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L59;
        return r5.getRef();
    L59:
        return ((SchemaType) ZeusTransformUtils.preCheckCast(XQuerySchemaTypeSystem.get().resolveHandle(r0), SchemaType.class, "com.obric.memorydata.plugin")).getRef();
    L15:
        if (r1 != 'Y') goto L17;
        SchemaType r2 = this.typeSystem.getLinker().typeForSignature(r0.substring(4));
        if (r2 == null) goto L53;
        return r2.getRef();
    L53:
        throw new SchemaTypeLoaderException("Cannot resolve type for handle " + r0, this.typeSystem.getName(), this._handle, 13);
    L17:
        if (r1 == 'D') goto L47;
        if (r1 == 'E') goto L45;
        switch(r1) {
            case 77: goto L43;
            case 78: goto L41;
            case 79: goto L39;
            default: goto L21;
        };
    L21:
        switch(r1) {
            case 82: goto L32;
            case 83: goto L26;
            case 84: goto L25;
            default: goto L23;
        };
    L26:
        SchemaGlobalElement r3 = this.typeSystem.getLinker().findElement(QNameHelper.forPretty(r0, 4));
        if (r3 == null) goto L31;
        return r3.getType().getRef();
    L31:
        throw new SchemaTypeLoaderException("Cannot resolve element for handle " + r0, this.typeSystem.getName(), this._handle, 13);
    L32:
        SchemaGlobalAttribute r4 = this.typeSystem.getLinker().findAttribute(QNameHelper.forPretty(r0, 4));
        if (r4 == null) goto L37;
        return r4.getType().getRef();
    L37:
        throw new SchemaTypeLoaderException("Cannot resolve attribute for handle " + r0, this.typeSystem.getName(), this._handle, 13);
    L23:
        throw new SchemaTypeLoaderException("Cannot resolve handle " + r0, this.typeSystem.getName(), this._handle, 13);
    L25:
        return this.typeSystem.getLinker().findTypeRef(QNameHelper.forPretty(r0, 4));
    L39:
        return this.typeSystem.getLinker().findDocumentTypeRef(QNameHelper.forPretty(r0, 4));
    L41:
        return this.typeSystem.getLinker().findAttributeGroupRef(QNameHelper.forPretty(r0, 4));
    L43:
        return this.typeSystem.getLinker().findModelGroupRef(QNameHelper.forPretty(r0, 4));
    L45:
        return this.typeSystem.getLinker().findElementRef(QNameHelper.forPretty(r0, 4));
    L47:
        return this.typeSystem.getLinker().findIdentityConstraintRef(QNameHelper.forPretty(r0, 4));
    L61:
        return this.typeSystem.getLinker().findAttributeRef(QNameHelper.forPretty(r0, 4));
    L9:
        return this.typeSystem.getTypePool().refForHandle(r0);
    }

    int readInt() {
        return this._input.readInt();
    L4:
        e = move-exception;
        throw new SchemaTypeLoaderException(e.getMessage(), this.typeSystem.getName(), this._handle, 9, e);
    }

    Set<String> readNamespaces() {
        HashSet r0 = new HashSet();
        int r1 = readShort();
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        r0.add(readString());
        r2 = r2 + 1;
        goto L3
    L5:
        return r0;
    }

    SchemaParticle[] readParticleArray() {
        int r0 = readShort();
        SchemaParticle[] r1 = new SchemaParticle[r0];
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        r1[r2] = readParticleData();
        r2 = r2 + 1;
        goto L3
    L5:
        return r1;
    }

    SchemaParticle readParticleData() {
        int r0 = readShort();
        if (r0 == 4) goto L5;
        SchemaParticleImpl r1 = new SchemaParticleImpl();
    L6:
        loadParticle(r1, r0);
        return r1;
    L5:
        r1 = new SchemaLocalElementImpl();
        goto L6
    }

    SchemaProperty readPropertyData() {
        SchemaPropertyImpl r0 = new SchemaPropertyImpl();
        r0.setName(readQName());
        r0.setTypeRef(readTypeRef());
        int r1 = readShort();
        boolean r3 = true;
        int r4 = 0;
        if ((r1 & 1) == 0) goto L5;
        boolean r2 = true;
    L6:
        r0.setAttribute(r2);
        r0.setContainerTypeRef(readTypeRef());
        r0.setMinOccurs(readBigInteger());
        r0.setMaxOccurs(readBigInteger());
        r0.setNillable(readShort());
        r0.setDefault(readShort());
        r0.setFixed(readShort());
        r0.setDefaultText(readString());
        r0.setJavaPropertyName(readString());
        r0.setJavaTypeCode(readShort());
        SchemaType.Ref r5 = readTypeRef();
        if ((r1 & 2) == 0) goto L9;
        boolean r6 = true;
    L11:
        if ((r1 & 4) == 0) goto L13;
        boolean r7 = true;
    L15:
        if ((r1 & 8) != 0) goto L18;
        r3 = false;
    L18:
        r0.setExtendsJava(r5, r6, r7, r3);
        if (atMost(2, 19, 0) == false) goto L22;
        r0.setJavaSetterDelimiter(readQNameSet());
    L22:
        if (atLeast(2, 16, 0) == false) goto L25;
        r0.setDefaultValue(readXmlValueObject());
    L25:
        if (r0.isAttribute() == false) goto L27;
    L32:
        r0.setImmutable();
        return r0;
    L27:
        if (atLeast(2, 17, 0) == false) goto L32;
        int r8 = readShort();
        LinkedHashSet r9 = new LinkedHashSet(r8);
    L29:
        if (r4 >= r8) goto L31;
        r9.add(readQName());
        r4 = r4 + 1;
        goto L29
    L31:
        r0.setAcceptedNames(r9);
        goto L32
    L13:
        r7 = false;
        goto L15
    L9:
        r6 = false;
        goto L11
    L5:
        r2 = false;
        goto L6
    }

    QName readQName() {
        String r0 = readString();
        String r2 = readString();
        if (r2 != null) goto L7;
        return null;
    L7:
        return new QName(r0, r2);
    }

    Map<QName, SchemaComponent.Ref> readQNameRefMap() {
        HashMap r0 = new HashMap();
        int r1 = readShort();
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        r0.put(readQName(), readHandle());
        r2 = r2 + 1;
        goto L3
    L5:
        return r0;
    }

    List<SchemaComponent.Ref> readQNameRefMapAsList(List<QName> r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        int r0 = readShort();
        ArrayList r1 = new ArrayList(r0);
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        QName r3 = readQName();
        r1.add(readHandle());
        r7.add(r3);
        r2 = r2 + 1;
        goto L3
    L5:
        return r1;
    }

    QNameSet readQNameSet() {
        int r0 = readShort();
        HashSet r1 = new HashSet();
        int r2 = readShort();
        int r3 = 0;
        int r4 = 0;
    L3:
        if (r4 >= r2) goto L5;
        r1.add(readString());
        r4 = r4 + 1;
        goto L3
    L5:
        HashSet r5 = new HashSet();
        int r6 = readShort();
        int r7 = 0;
    L6:
        if (r7 >= r6) goto L8;
        r5.add(readQName());
        r7 = r7 + 1;
        goto L6
    L8:
        HashSet r8 = new HashSet();
        int r9 = readShort();
    L9:
        if (r3 >= r9) goto L12;
        r8.add(readQName());
        r3 = r3 + 1;
        goto L9
    L12:
        if (r0 != 1) goto L16;
        return QNameSet.forSets(r1, null, r5, r8);
    L16:
        return QNameSet.forSets(null, r1, r8, r5);
    }

    SOAPArrayType readSOAPArrayType() {
        QName r0 = readQName();
        String r2 = readString();
        if (r0 != null) goto L7;
        return null;
    L7:
        return new SOAPArrayType(r0, r2);
    }

    int readShort() {
        return this._input.readUnsignedShort();
    L4:
        e = move-exception;
        throw new SchemaTypeLoaderException(e.getMessage(), this.typeSystem.getName(), this._handle, 9, e);
    }

    String readString() {
        int r0 = readUnsignedShortOrInt();
        return this._stringPool.stringForCode(r0);
    }

    SchemaType.Ref readTypeRef() {
        return (SchemaType.Ref) ZeusTransformUtils.preCheckCast(readHandle(), SchemaType.Ref.class, "com.obric.memorydata.plugin");
    }

    SchemaType.Ref[] readTypeRefArray() {
        int r0 = readShort();
        SchemaType.Ref[] r1 = new SchemaType.Ref[r0];
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        r1[r2] = readTypeRef();
        r2 = r2 + 1;
        goto L3
    L5:
        return r1;
    }

    int readUnsignedShortOrInt() {
        return this._input.readUnsignedShortOrInt();
    L4:
        e = move-exception;
        throw new SchemaTypeLoaderException(e.getMessage(), this.typeSystem.getName(), this._handle, 9, e);
    }

    XmlValueRef readXmlValueObject() {
        SchemaType.Ref r0 = readTypeRef();
        if (r0 != null) goto L5;
        return null;
    L5:
        int r2 = readShort();
        if (r2 == 0) goto L25;
        if (r2 == 65535) goto L19;
        switch(r2) {
            case 2: goto L18;
            case 3: goto L18;
            case 4: goto L16;
            case 5: goto L16;
            case 6: goto L18;
            case 7: goto L14;
            case 8: goto L14;
            case 9: goto L12;
            case 10: goto L12;
            case 11: goto L18;
            case 12: goto L18;
            case 13: goto L18;
            case 14: goto L18;
            case 15: goto L18;
            case 16: goto L18;
            case 17: goto L18;
            case 18: goto L18;
            case 19: goto L18;
            case 20: goto L18;
            case 21: goto L18;
            default: goto L25;
        };
    L12:
        return new XmlValueRef(r0, Double.valueOf(readDouble()));
    L14:
        return new XmlValueRef(r0, readQName());
    L16:
        return new XmlValueRef(r0, readByteArray());
    L18:
        return new XmlValueRef(r0, readString());
    L19:
        int r1 = readShort();
        ArrayList r3 = new ArrayList();
        writeShort(r1);
        int r4 = 0;
    L20:
        if (r4 >= r1) goto L23;
        r3.add(readXmlValueObject());
        r4 = r4 + 1;
        goto L20
    L23:
        return new XmlValueRef(r0, r3);
    L25:
        return new XmlValueRef(r0, null);
    }

    void writeShort(int r8) {
        if (r8 >= 65535) goto L15;
        if (r8 < (-1)) goto L15;
        LongUTFDataOutputStream r0 = this._output;
        if (r0 != null) goto L16;
        return;
    L16:
        r0.writeShort(r8);     // Catch: IOException -> L10
        return;
    L10:
        e = move-exception;
        throw new SchemaTypeLoaderException(e.getMessage(), this.typeSystem.getName(), this._handle, 9, e);
    L15:
        throw new SchemaTypeLoaderException("Value " + r8 + " out of range: must fit in a 16-bit unsigned short.", this.typeSystem.getName(), this._handle, 10);
    }
}
