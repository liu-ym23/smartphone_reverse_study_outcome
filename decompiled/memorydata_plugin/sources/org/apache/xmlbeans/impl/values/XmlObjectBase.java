package org.apache.xmlbeans.impl.values;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.tom_roush.pdfbox.pdmodel.a.d.e;
import com.ttnet.org.chromium.net.NetError;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Serializable;
import java.io.Writer;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.function.Function;
import java.util.function.IntFunction;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.DelegateXmlObject;
import org.apache.xmlbeans.GDate;
import org.apache.xmlbeans.GDateSpecification;
import org.apache.xmlbeans.GDuration;
import org.apache.xmlbeans.GDurationSpecification;
import org.apache.xmlbeans.QNameSet;
import org.apache.xmlbeans.SchemaAttributeModel;
import org.apache.xmlbeans.SchemaField;
import org.apache.xmlbeans.SchemaLocalAttribute;
import org.apache.xmlbeans.SchemaProperty;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SchemaTypeLoader;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlDocumentProperties;
import org.apache.xmlbeans.XmlError;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlRuntimeException;
import org.apache.xmlbeans.impl.common.GlobalLock;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.common.ValidationContext;
import org.apache.xmlbeans.impl.common.XmlErrorWatcher;
import org.apache.xmlbeans.impl.common.XmlLocale;
import org.apache.xmlbeans.impl.common.XmlWhitespace;
import org.apache.xmlbeans.impl.schema.SchemaTypeImpl;
import org.apache.xmlbeans.impl.schema.SchemaTypeVisitorImpl;
import org.apache.xmlbeans.impl.util.LongUTFDataInputStream;
import org.apache.xmlbeans.impl.validator.Validator;
import org.w3c.dom.Node;
import org.xml.sax.ContentHandler;
import org.xml.sax.ext.LexicalHandler;

/* JADX INFO: loaded from: classes7.dex */
public abstract class XmlObjectBase implements Serializable, SimpleValue, XmlObject, TypeStoreUser {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final XmlObject[] EMPTY_RESULT = null;
    private static final int FLAGS_DATED = 672;
    private static final int FLAGS_ELEMENT = 7;
    private static final int FLAG_ATTRIBUTE = 8;
    private static final int FLAG_COMPLEXCONTENT = 16384;
    private static final int FLAG_COMPLEXTYPE = 8192;
    private static final int FLAG_ELEMENT_DATED = 512;
    private static final int FLAG_FIXED = 4;
    private static final int FLAG_HASDEFAULT = 2;
    private static final int FLAG_IMMUTABLE = 4096;
    private static final int FLAG_ISDEFAULT = 256;
    private static final int FLAG_NIL = 64;
    private static final int FLAG_NILLABLE = 1;
    private static final int FLAG_NIL_DATED = 128;
    private static final int FLAG_NOT_VARIABLE = 32768;
    private static final int FLAG_ORPHANED = 2048;
    private static final int FLAG_SETTINGDEFAULT = 1024;
    private static final int FLAG_STORE = 16;
    private static final int FLAG_VALIDATE_ON_SET = 65536;
    private static final int FLAG_VALUE_DATED = 32;
    public static final short KIND_SETTERHELPER_ARRAYITEM = 2;
    public static final short KIND_SETTERHELPER_SINGLETON = 1;
    public static final short MAJOR_VERSION_NUMBER = 1;
    public static final short MINOR_VERSION_NUMBER = 1;
    private static final BigInteger _max = null;
    private static final BigInteger _min = null;
    private static final XmlOptions _toStringOptions = null;
    public static final ValidationContext _voorVc = null;
    private int _flags;
    private Object _textsource;

    /* JADX INFO: renamed from: org.apache.xmlbeans.impl.values.XmlObjectBase$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static final class ImmutableValueValidationContext implements ValidationContext {
        private final Collection<XmlError> _coll;
        private final XmlObject _loc;

        ImmutableValueValidationContext(Collection<XmlError> r3, XmlObject r4) {
            Collection<XmlError> r5 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
            XmlObject r6 = (XmlObject) ZeusTransformUtils.wrapperContextForParams(r4, XmlObject.class, "com.obric.memorydata.plugin");
            this._coll = r5;
            this._loc = r6;
        }

        @Override // org.apache.xmlbeans.impl.common.ValidationContext
        public void invalid(String r2) {
            this._coll.add(XmlError.forObject(r2, this._loc));
        }

        @Override // org.apache.xmlbeans.impl.common.ValidationContext
        public void invalid(String r2, Object[] r3) {
            this._coll.add(XmlError.forObject(r2, r3, this._loc));
        }
    }

    private static class SerializedInteriorObject implements Serializable {
        private static final long serialVersionUID = 1;
        transient XmlObject _impl;
        transient XmlObject _root;

        private SerializedInteriorObject(XmlObject r3, XmlObject r4) {
            XmlObject r5 = (XmlObject) ZeusTransformUtils.wrapperContextForParams(r3, XmlObject.class, "com.obric.memorydata.plugin");
            XmlObject r6 = (XmlObject) ZeusTransformUtils.wrapperContextForParams(r4, XmlObject.class, "com.obric.memorydata.plugin");
            this._impl = r5;
            this._root = r6;
        }

        /* synthetic */ SerializedInteriorObject(XmlObject r2, XmlObject r3, AnonymousClass1 r4) {
            this((XmlObject) ZeusTransformUtils.wrapperContextForParams(r2, XmlObject.class, "com.obric.memorydata.plugin"), (XmlObject) ZeusTransformUtils.wrapperContextForParams(r3, XmlObject.class, "com.obric.memorydata.plugin"));
        }

        private int distanceToRoot() {
            XmlCursor r2 = this._impl.newCursor();
            int r0 = 0;
        L20:
        L11:
            th = move-exception;
            throw th;     // Catch: Throwable -> L13
        L13:
            th = move-exception;
            if (r2 != null) goto L24;
        L19:
            throw th;
        L24:
            r2.close();     // Catch: Throwable -> L17
        L17:
            th = move-exception;
            th.addSuppressed(th);
            goto L19
        L4:
            if (r2.toPrevToken().isNone() == true) goto L8;
            if (r2.currentTokenType().isNamespace() == true) goto L20;
            r0 = r0 + 1;
            goto L20
        L8:
            if (r2 == null) goto L10;
            r2.close();
        L10:
            return r0;
        }

        private XmlObject objectAtDistance(int r2) {
            XmlCursor r1 = this._root.newCursor();
        L3:
            if (r2 <= 0) goto L7;
            r1.toNextToken();     // Catch: Throwable -> L11
            if (r1.currentTokenType().isNamespace() == true) goto L3;
            r2 = r2 - 1;     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            throw th;     // Catch: Throwable -> L13
        L13:
            th = move-exception;
            if (r1 != null) goto L24;
        L19:
            throw th;
        L24:
            r1.close();     // Catch: Throwable -> L17
        L17:
            th = move-exception;
            th.addSuppressed(th);
            goto L19
        L7:
            XmlObject r3 = r1.getObject();     // Catch: Throwable -> L11
            if (r1 == null) goto L10;
            r1.close();
        L10:
            return r3;
        }

        private void readObject(ObjectInputStream r4) {
            this._root = (XmlObject) ZeusTransformUtils.preCheckCast(r4.readObject(), XmlObject.class, "com.obric.memorydata.plugin");
            r4.readBoolean();
            this._impl = objectAtDistance(r4.readInt());
        }

        private Object readResolve() {
            return this._impl;
        }

        private void writeObject(ObjectOutputStream r2) {
            r2.writeObject(this._root);
            r2.writeBoolean(false);
            r2.writeInt(distanceToRoot());
        }
    }

    private static class SerializedRootObject implements Serializable {
        private static final long serialVersionUID = 1;
        transient XmlObject _impl;
        transient Class<? extends XmlObject> _xbeanClass;

        private SerializedRootObject(XmlObject r3) {
            XmlObject r4 = (XmlObject) ZeusTransformUtils.wrapperContextForParams(r3, XmlObject.class, "com.obric.memorydata.plugin");
            this._xbeanClass = r4.schemaType().getJavaClass();
            this._impl = r4;
        }

        /* synthetic */ SerializedRootObject(XmlObject r2, AnonymousClass1 r3) {
            this((XmlObject) ZeusTransformUtils.wrapperContextForParams(r2, XmlObject.class, "com.obric.memorydata.plugin"));
        }

        private void readObject(ObjectInputStream r8) {
            this._xbeanClass = (Class) ZeusTransformUtils.preCheckCast(r8.readObject(), Class.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L21
            int r1 = r8.readUnsignedShort();     // Catch: Exception -> L21
            int r2 = 0;
            if (r1 != 0) goto L7;
            r2 = r8.readUnsignedShort();     // Catch: Exception -> L21
            int r3 = r8.readUnsignedShort();     // Catch: Exception -> L21
        L8:
            if (r2 != 0) goto L10;
            String r0 = readObjectV0(r8, r1);     // Catch: Exception -> L21
        L13:
            r8.readBoolean();     // Catch: Exception -> L21
            this._impl = XmlBeans.getContextTypeLoader().parse(r0, null, new XmlOptions().setDocumentType(XmlBeans.typeForClass(this._xbeanClass)));     // Catch: Exception -> L21
            return;
        L10:
            if (r2 != 1) goto L17;
            if (r3 != 1) goto L15;
            r0 = (String) ZeusTransformUtils.preCheckCast(r8.readObject(), String.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L21
            goto L13
        L15:
            throw new IOException("Deserialization error: version number " + r2 + "." + r3 + " not supported.");     // Catch: Exception -> L21
        L17:
            throw new IOException("Deserialization error: version number " + r2 + "." + r3 + " not supported.");     // Catch: Exception -> L21
        L7:
            r3 = 0;
        L21:
            e = move-exception;
            throw new IOException(e.getMessage(), e);
        }

        private String readObjectV0(ObjectInputStream r4, int r5) {
            byte[] r3 = new byte[r5 + 2];
            int r1 = 0;
            r3[0] = (byte) ((r5 >> 8) & 255);
            r3[1] = (byte) (r5 & 255);
        L3:
            if (r1 >= r5) goto L8;
            int r0 = r4.read(r3, r1 + 2, r5 - r1);
            if (r0 == (-1)) goto L8;
            r1 = r1 + r0;
        L8:
            if (r1 != r5) goto L21;
            LongUTFDataInputStream r6 = null;
            LongUTFDataInputStream r7 = new LongUTFDataInputStream(new ByteArrayInputStream(r3));     // Catch: Throwable -> L16
            String r8 = r7.readLongUTF();     // Catch: Throwable -> L14
            r7.close();
            return r8;
        L14:
            th = th;
            r6 = r7;
        L17:
            if (r6 == null) goto L19;
            r6.close();
        L19:
            throw th;
        L16:
            th = th;
            goto L17
        L21:
            throw new IOException("Error reading backwards compatible XmlObject: number of bytes read (" + r1 + ") != number expected (" + r5 + ")");
        }

        private Object readResolve() {
            return this._impl;
        }

        private void writeObject(ObjectOutputStream r3) {
            r3.writeObject(this._xbeanClass);
            r3.writeShort(0);
            r3.writeShort(1);
            r3.writeShort(1);
            r3.writeObject(this._impl.xmlText());
            r3.writeBoolean(false);
        }
    }

    private static final class ValueOutOfRangeValidationContext implements ValidationContext {
        private ValueOutOfRangeValidationContext() {
        }

        /* synthetic */ ValueOutOfRangeValidationContext(AnonymousClass1 r1) {
            this();
        }

        @Override // org.apache.xmlbeans.impl.common.ValidationContext
        public void invalid(String r1) {
            throw new XmlValueOutOfRangeException(r1);
        }

        @Override // org.apache.xmlbeans.impl.common.ValidationContext
        public void invalid(String r1, Object[] r2) {
            throw new XmlValueOutOfRangeException(r1, r2);
        }
    }

    static {
        _voorVc = new ValueOutOfRangeValidationContext(null);
        _max = BigInteger.valueOf(Long.MAX_VALUE);
        _min = BigInteger.valueOf(Long.MIN_VALUE);
        _toStringOptions = buildInnerPrettyOptions();
        EMPTY_RESULT = new XmlObject[0];
    }

    public XmlObjectBase() {
        this._flags = 65;
    }

    private static XmlObject[] _typedArray(XmlObject[] r4) {
        if (r4.length != 0) goto L5;
        return r4;
    L5:
        SchemaType r1 = r4[0].schemaType();
        if (r1.equals(XmlObject.type) == false) goto L8;
    L27:
        return r4;
    L8:
        if (r1.isNoType() == true) goto L27;
        int r2 = 1;
    L12:
        if (r2 >= r4.length) goto L20;
        if (r4[r2].schemaType().isNoType() == true) goto L15;
        r1 = r1.getCommonBaseType(r4[r2].schemaType());
        if (r1.equals(XmlObject.type) == true) goto L18;
        r2 = r2 + 1;
        goto L12
    L18:
        return r4;
    L15:
        return r4;
    L20:
        Class<? extends XmlObject> r3 = r1.getJavaClass();
        if (r3 != null) goto L25;
        r1 = r1.getBaseType();
        if (XmlObject.type.equals(r1) == false) goto L20;
        return r4;
    L25:
        XmlObject[] r5 = (XmlObject[]) ZeusTransformUtils.preCheckCast((XmlObject[]) ZeusTransformUtils.preCheckCast(Array.newInstance(r3, r4.length), XmlObject[].class, "com.obric.memorydata.plugin"), XmlObject[].class, "com.obric.memorydata.plugin");
        System.arraycopy(r4, 0, r5, 0, r4.length);
        return r5;
    }

    private String apply_wscanon(String r1) {
        return XmlWhitespace.collapse(r1, get_wscanon_rule());
    }

    static XmlOptions buildInnerPrettyOptions() {
        XmlOptions r0 = new XmlOptions();
        r0.setSaveInner();
        r0.setSavePrettyPrint();
        r0.setSaveAggressiveNamespaces();
        r0.setUseDefaultNamespace();
        return r0;
    }

    private void check_element_dated() {
        int r0 = this._flags;
        if ((r0 & 512) != 0) goto L5;
    L11:
        int r1 = this._flags;
        if ((r1 & 32768) == 0) goto L15;
        this._flags = r1 & NetError.ERR_TTNET_FT_INVALID_STREAM;
        return;
    L15:
        return;
    L5:
        if ((r0 & 32768) != 0) goto L11;
        if ((r0 & 2048) != 0) goto L10;
        int r2 = get_store().compute_flags();
        int r3 = this._flags & NetError.ERR_TTNET_FT_INVALID_STREAM_ID;
        this._flags = r3;
        this._flags = r2 | r3;
        goto L11
    L10:
        throw new XmlValueDisconnectedException();
    }

    private boolean comparable_value_spaces(SchemaType r4, SchemaType r5) {
        SchemaType r3 = (SchemaType) ZeusTransformUtils.wrapperContextForParams(r4, SchemaType.class, "com.obric.memorydata.plugin");
        SchemaType r6 = (SchemaType) ZeusTransformUtils.wrapperContextForParams(r5, SchemaType.class, "com.obric.memorydata.plugin");
        if (r3.isSimpleType() == true) goto L12;
        if (r6.isSimpleType() == true) goto L12;
        if (r3.getContentType() != r6.getContentType()) goto L10;
        return true;
    L10:
        return false;
    L12:
        if (r3.isSimpleType() == true) goto L14;
    L28:
        return false;
    L14:
        if (r6.isSimpleType() == false) goto L28;
        if (r3.getSimpleVariety() != 3) goto L22;
        if (r6.getSimpleVariety() != 3) goto L22;
        return true;
    L22:
        if (r3.getSimpleVariety() == 3) goto L28;
        if (r6.getSimpleVariety() == 3) goto L28;
        return r3.getPrimitiveType().equals(r6.getPrimitiveType());
    }

    private int compareValueImpl(XmlObject r5) {
        XmlObject r6 = (XmlObject) ZeusTransformUtils.wrapperContextForParams(r5, XmlObject.class, "com.obric.memorydata.plugin");
        SchemaType r2 = instanceType();     // Catch: XmlValueOutOfRangeException -> L27
        SchemaType r1 = ((SimpleValue) ZeusTransformUtils.preCheckCast(r6, SimpleValue.class, "com.obric.memorydata.plugin")).instanceType();     // Catch: XmlValueOutOfRangeException -> L27
        if (r2 != null) goto L8;
        if (r1 != null) goto L8;
        return 0;
    L8:
        if (r2 == null) goto L26;
        if (r1 == null) goto L26;
        if (r2.isSimpleType() == false) goto L26;
        if (r2.isURType() == true) goto L26;
        if (r1.isSimpleType() == false) goto L26;
        if (r1.isURType() == true) goto L26;
        SchemaType r3 = r2.getPrimitiveType();
        SchemaType r4 = r1.getPrimitiveType();
        if (r3.getBuiltinTypeCode() == r4.getBuiltinTypeCode()) goto L25;
        return 2;
    L25:
        return compare_to(r6);
    L26:
        return 2;
    }

    private XmlObject ensureStore() {
        if ((this._flags & 16) == 0) goto L5;
        return this;
    L5:
        check_dated();
        if ((this._flags & 64) == 0) goto L9;
        String r0 = "";
    L13:
        XmlOptions r3 = new XmlOptions().setDocumentType(schemaType());
        XmlObject r4 = (XmlObject) ZeusTransformUtils.preCheckCast(XmlObject.Factory.newInstance(r3), XmlObject.class, "com.obric.memorydata.plugin");
        XmlCursor r1 = r4.newCursor();
        r1.toNextToken();     // Catch: Throwable -> L18
        r1.insertChars(r0);     // Catch: Throwable -> L18
        if (r1 == null) goto L17;
        r1.close();
    L17:
        return r4;
    L18:
        th = move-exception;
        throw th;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        if (r1 != null) goto L31;
    L26:
        throw th;
    L31:
        r1.close();     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        th.addSuppressed(th);
        goto L26
    L9:
        if (has_store() == false) goto L11;
        TypeStore r2 = get_store();
    L12:
        r0 = compute_text(r2);
        goto L13
    L11:
        r2 = null;
        goto L12
    }

    private List<XmlObjectBase> getBaseArray(QName r2) {
        check_orphaned();
        ArrayList r0 = new ArrayList();
        get_store().find_all_element_users(r2, r0);
        return r0;
    }

    private List<XmlObjectBase> getBaseArray(QNameSet r2) {
        check_orphaned();
        ArrayList r0 = new ArrayList();
        get_store().find_all_element_users(r2, r0);
        return r0;
    }

    private String getPrimitiveTypeName() {
        SchemaType r1 = schemaType();
        if (r1.isNoType() == false) goto L6;
        return "unknown";
    L6:
        SchemaType r2 = r1.getPrimitiveType();
        if (r2 != null) goto L11;
        return "complex";
    L11:
        return r2.getName().getLocalPart();
    }

    private XmlObject getRootXmlObject() {
        XmlCursor r0 = newCursor();
        if (r0 != null) goto L22;
        if (r0 == null) goto L6;
        r0.close();
    L6:
        return this;
    L22:
        r0.toStartDoc();     // Catch: Throwable -> L11
        XmlObject r2 = r0.getObject();     // Catch: Throwable -> L11
        if (r0 == null) goto L10;
        r0.close();
    L10:
        return r2;
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        if (r0 != null) goto L20;
    L19:
        throw th;
    L20:
        r0.close();     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        th.addSuppressed(th);
        goto L19
    }

    private XmlObjectBase getTargetForSetter(QName r5, int r6, short r7) {
        if (r7 != 1) goto L5;
        check_orphaned();
        XmlObjectBase r8 = (XmlObjectBase) ZeusTransformUtils.preCheckCast(get_store().find_element_user(r5, r6), XmlObjectBase.class, "com.obric.memorydata.plugin");
        if (r8 != null) goto L21;
        r8 = (XmlObjectBase) ZeusTransformUtils.preCheckCast(get_store().add_element_user(r5), XmlObjectBase.class, "com.obric.memorydata.plugin");
    L21:
        if (r8.isImmutable() == true) goto L24;
        return r8;
    L24:
        throw new IllegalStateException("Cannot set the value of an immutable XmlObject");
    L5:
        if (r7 != 2) goto L16;
        check_orphaned();
        XmlObjectBase r4 = (XmlObjectBase) ZeusTransformUtils.preCheckCast(get_store().find_element_user(r5, r6), XmlObjectBase.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L14;
        if (r4.isImmutable() == true) goto L12;
        return r4;
    L12:
        throw new IllegalStateException("Cannot set the value of an immutable XmlObject");
    L14:
        throw new IndexOutOfBoundsException();
    L16:
        throw new IllegalArgumentException("Unknown kindSetterHelper: " + r7);
    }

    private boolean isRootXmlObject() {
        XmlCursor r2 = newCursor();
        if (r2 == null) goto L5;
        boolean r0 = !r2.toParent();
        if (r2 == null) goto L12;
        r2.close();
    L12:
        return r0;
    L13:
        th = move-exception;
        throw th;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        if (r2 != null) goto L22;
    L21:
        throw th;
    L22:
        r2.close();     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        th.addSuppressed(th);
        goto L21
    L5:
        if (r2 == null) goto L7;
        r2.close();
    L7:
        return false;
    }

    public static Object java_value(XmlObject r4) {
        XmlObject r5 = (XmlObject) ZeusTransformUtils.wrapperContextForParams(r4, XmlObject.class, "com.obric.memorydata.plugin");
        if (r5.isNil() == false) goto L7;
        return null;
    L7:
        if (ZeusTransformUtils.instanceOf(r5, XmlAnySimpleType.class) == true) goto L9;
        return r5;
    L9:
        SchemaType r0 = ((SimpleValue) ZeusTransformUtils.preCheckCast(r5, SimpleValue.class, "com.obric.memorydata.plugin")).instanceType();
        if (r0.getSimpleVariety() == 3) goto L12;
        SimpleValue r6 = (SimpleValue) ZeusTransformUtils.preCheckCast(r5, SimpleValue.class, "com.obric.memorydata.plugin");
        switch(r0.getPrimitiveType().getBuiltinTypeCode()) {
            case 2: goto L57;
            case 3: goto L52;
            case 4: goto L50;
            case 5: goto L50;
            case 6: goto L48;
            case 7: goto L46;
            case 8: goto L57;
            case 9: goto L44;
            case 10: goto L42;
            case 11: goto L20;
            case 12: goto L57;
            case 13: goto L19;
            case 14: goto L17;
            case 15: goto L17;
            case 16: goto L17;
            case 17: goto L17;
            case 18: goto L17;
            case 19: goto L17;
            case 20: goto L17;
            case 21: goto L17;
            default: goto L57;
        };
    L20:
        int r1 = r0.getDecimalSize();
        if (r1 == 8) goto L40;
        if (r1 == 16) goto L38;
        if (r1 == 32) goto L36;
        if (r1 == 64) goto L34;
        switch(r1) {
            case 1000000: goto L32;
            case 1000001: goto L30;
            default: goto L30;
        };
    L30:
        return r6.getBigDecimalValue();
    L32:
        return r6.getBigIntegerValue();
    L34:
        return Long.valueOf(r6.getLongValue());
    L36:
        return Integer.valueOf(r6.getIntValue());
    L38:
        return Short.valueOf(r6.getShortValue());
    L40:
        return Byte.valueOf(r6.getByteValue());
    L17:
        return r6.getCalendarValue();
    L19:
        return r6.getGDurationValue();
    L42:
        return Double.valueOf(r6.getDoubleValue());
    L44:
        return Float.valueOf(r6.getFloatValue());
    L46:
        return r6.getQNameValue();
    L48:
        return r6.getStringValue();
    L50:
        return r6.getByteArrayValue();
    L52:
        if (r6.getBooleanValue() == false) goto L55;
        return Boolean.TRUE;
    L55:
        return Boolean.FALSE;
    L57:
        return r6.getStringValue();
    L12:
        return ((SimpleValue) ZeusTransformUtils.preCheckCast(r5, SimpleValue.class, "com.obric.memorydata.plugin")).getListValue();
    }

    public static /* synthetic */ Object lambda$sZT5efFyTAcMUGcVBAkDU0ttgn0(Class r0, Object r1) {
        return r0.cast(r1);
    }

    private static XmlOptions makeInnerOptions(XmlOptions r1) {
        XmlOptions r0 = new XmlOptions(r1);
        r0.setSaveInner();
        return r0;
    }

    private TypeStoreUser objSetterHelper(XmlObjectBase r1, QName r2, int r3, short r4) {
        XmlObjectBase r0 = getTargetForSetter(r2, r3, r4);
        r0.check_orphaned();
        r1.check_orphaned();
        return r0.get_store().copy_contents_from(r1.get_store()).get_store().change_type(r1.schemaType());
    }

    private boolean preCheck() {
        if (has_store() == true) goto L5;
        return false;
    L5:
        return get_store().get_locale().noSync();
    }

    private SchemaField schemaField() {
        SchemaField r0 = schemaType().getContainerField();
        if (r0 == null) goto L5;
        return r0;
    L5:
        return get_store().get_schema_field();
    }

    private void set_commit() {
        int r0 = this._flags;
        if ((r0 & 64) == 0) goto L5;
        boolean r1 = true;
    L6:
        int r2 = r0 & NetError.ERR_INVALID_CHUNKED_ENCODING;
        this._flags = r2;
        if ((r2 & 16) == 0) goto L12;
        this._flags = r2 & (-673);
        get_store().invalidate_text();
        if (r1 == false) goto L11;
        get_store().invalidate_nil();
    L11:
        this._flags &= -673;
        return;
    L12:
        this._textsource = null;
        return;
    L5:
        r1 = false;
        goto L6
    }

    private void set_prepare() {
        check_element_dated();
        if ((this._flags & 4096) != 0) goto L6;
        return;
    L6:
        throw new IllegalStateException();
    }

    private TypeStoreUser setterHelper(XmlObjectBase r2) {
        check_orphaned();
        r2.check_orphaned();
        return get_store().copy_contents_from(r2.get_store()).get_store().change_type(r2.schemaType());
    }

    private static XmlObjectBase underlying(XmlObject r3) {
        XmlObject r4 = (XmlObject) ZeusTransformUtils.wrapperContextForParams(r3, XmlObject.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L7;
        return null;
    L7:
        if (ZeusTransformUtils.instanceOf(r4, XmlObjectBase.class) == false) goto L11;
    L9:
        return (XmlObjectBase) ZeusTransformUtils.preCheckCast(r4, XmlObjectBase.class, "com.obric.memorydata.plugin");
    L11:
        if (ZeusTransformUtils.instanceOf(r4, DelegateXmlObject.class) == false) goto L14;
        r4 = ((DelegateXmlObject) ZeusTransformUtils.preCheckCast(r4, DelegateXmlObject.class, "com.obric.memorydata.plugin")).underlyingXmlObject();
        goto L11
    L14:
        if (ZeusTransformUtils.instanceOf(r4, XmlObjectBase.class) == true) goto L9;
        throw new IllegalStateException("Non-native implementations of XmlObject should extend FilterXmlObject or implement DelegateXmlObject");
    }

    private void update_from_wscanon_text(String r3) {
        int r0 = this._flags;
        if ((r0 & 2) != 0) goto L5;
    L22:
        set_text(r3);
        int r4 = this._flags & NetError.ERR_INVALID_CHUNKED_ENCODING;
    L15:
        this._flags = r4;
        return;
    L5:
        if ((r0 & 1024) != 0) goto L22;
        if ((r0 & 8) != 0) goto L22;
        if (r3.equals("") == false) goto L22;
        String r5 = get_store().compute_default_text();
        if (r5 == null) goto L21;
        this._flags |= 1024;
        setStringValue(r5);     // Catch: Throwable -> L17
        int r6 = this._flags & (-1025);
        this._flags = r6;
        int r7 = r6 & (-65);
        this._flags = r7;
        r4 = r7 | 256;
    L17:
        th = move-exception;
        this._flags &= -1025;
        throw th;
    L21:
        throw new XmlValueOutOfRangeException();
    }

    private boolean validate_immutable(XmlOptions r9) {
        if (r9 != null) goto L4;
        Collection<XmlError> r0 = null;
    L5:
        XmlErrorWatcher r1 = new XmlErrorWatcher(r0);
        if (schemaType().isSimpleType() == true) goto L25;
        if (r9 != null) goto L9;
    L10:
        SchemaProperty[] r10 = schemaType().getProperties();
        int r2 = r10.length;
        int r4 = 0;
    L12:
        if (r4 >= r2) goto L22;
        SchemaProperty r6 = r10[r4];
        if (r6.getMinOccurs().signum() <= 0) goto L20;
        if (r6.isAttribute() == false) goto L18;
        XmlError r5 = XmlError.forObject("cvc-complex-type.4", new Object[]{QNameHelper.pretty(r6.getName())}, this);
    L19:
        r1.add(r5);
        goto L20
    L18:
        r5 = XmlError.forObject("cvc-complex-type.2.4c", new Object[]{r6.getMinOccurs(), QNameHelper.pretty(r6.getName())}, this);
    L20:
        r4 = r4 + 1;
        goto L12
    L22:
        if (schemaType().getContentType() == 2) goto L25;
        return !r1.hasError();
    L9:
        if (r9.isValidateTextOnly() == false) goto L10;
    L25:
        String r11 = (String) ZeusTransformUtils.preCheckCast(this._textsource, String.class, "com.obric.memorydata.plugin");
        if (r11 != null) goto L28;
        r11 = "";
    L28:
        validate_simpleval(r11, new ImmutableValueValidationContext(r1, this));
        return !r1.hasError();
    L4:
        r0 = r9.getErrorListener();
        goto L5
    }

    private boolean valueEqualsImpl(XmlObject r4) {
        XmlObject r5 = (XmlObject) ZeusTransformUtils.wrapperContextForParams(r4, XmlObject.class, "com.obric.memorydata.plugin");
        check_dated();
        SchemaType r0 = instanceType();
        SchemaType r1 = ((SimpleValue) ZeusTransformUtils.preCheckCast(r5, SimpleValue.class, "com.obric.memorydata.plugin")).instanceType();
        if (r0 != null) goto L8;
        if (r1 != null) goto L8;
        return true;
    L8:
        if (r0 == null) goto L20;
        if (r1 == null) goto L20;
        if (comparable_value_spaces(r0, r1) == true) goto L15;
        return false;
    L15:
        if (r5.schemaType().getSimpleVariety() != 2) goto L19;
        return underlying(r5).equal_to(this);
    L19:
        return equal_to(r5);
    L20:
        return false;
    }

    public final XmlObject _copy() {
        return _copy(null);
    }

    public final XmlObject _copy(XmlOptions r3) {
        if (isImmutable() == false) goto L5;
        return this;
    L5:
        check_orphaned();
        SchemaTypeLoader r0 = get_store().get_schematypeloader();
        return (XmlObject) ZeusTransformUtils.preCheckCast(get_store().copy(r0, schemaType(), r3), XmlObject.class, "com.obric.memorydata.plugin");
    }

    public boolean _isComplexContent() {
        if ((this._flags & 16384) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean _isComplexType() {
        if ((this._flags & 8192) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v10 */
    public final XmlObject _set(XmlObject r3) {
        XmlObject r4 = (XmlObject) ZeusTransformUtils.wrapperContextForParams(r3, XmlObject.class, "com.obric.memorydata.plugin");
        if (isImmutable() == true) goto L15;
        XmlObjectBase r5 = underlying(r4);
        if (r5 != null) goto L9;
        setNil();
        return this;
    L9:
        if (r5.isImmutable() == false) goto L11;
        setStringValue(r5.getStringValue());
        Object r2 = this;
    L13:
        return (XmlObject) ZeusTransformUtils.preCheckCast(r2, XmlObject.class, "com.obric.memorydata.plugin");
    L11:
        check_orphaned();
        r5.check_orphaned();
        r2 = get_store().copy_contents_from(r5.get_store()).get_store().change_type(r5.schemaType());
        goto L13
    L15:
        throw new IllegalStateException("Cannot set the value of an immutable XmlObject");
    }

    public boolean _validateOnSet() {
        if ((this._flags & 65536) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
    public final void attach_store(TypeStore r3) {
        TypeStore r4 = (TypeStore) ZeusTransformUtils.wrapperContextForParams(r3, TypeStore.class, "com.obric.memorydata.plugin");
        this._textsource = r4;
        int r0 = this._flags;
        if ((r0 & 4096) != 0) goto L12;
        this._flags = r0 | 688;
        if (r4.is_attribute() == false) goto L8;
        this._flags |= 8;
    L8:
        if (r4.validate_on_set() == false) goto L13;
        this._flags |= 65536;
        return;
    L13:
        return;
    L12:
        throw new IllegalStateException();
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
    public boolean build_nil() {
        if ((this._flags & 64) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
    public final String build_text(NamespaceManager r3) {
        NamespaceManager r4 = (NamespaceManager) ZeusTransformUtils.wrapperContextForParams(r3, NamespaceManager.class, "com.obric.memorydata.plugin");
        if ((this._flags & 320) == 0) goto L6;
        return "";
    L6:
        if (r4 != null) goto L12;
        if (has_store() == false) goto L10;
        r4 = get_store();
        goto L12
    L10:
        r4 = null;
    L12:
        return compute_text(r4);
    }

    public XmlObject changeType(SchemaType r3) {
        SchemaType r4 = (SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L17;
        if ((this._flags & 16) == 0) goto L15;
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L11
        XmlObject r2 = (XmlObject) ZeusTransformUtils.preCheckCast(get_store().change_type(r4), XmlObject.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r2;
    L11:
        th = move-exception;
        throw th;
    L15:
        throw new IllegalStateException("XML Value Objects cannot have thier type changed");
    L17:
        throw new IllegalArgumentException("Invalid type (null)");
    }

    public final void check_dated() {
        int r0 = this._flags;
        if ((r0 & FLAGS_DATED) != 0) goto L5;
        return;
    L5:
        if ((r0 & 2048) != 0) goto L38;
        check_element_dated();
        if ((this._flags & 512) == 0) goto L9;
        int r1 = get_store().compute_flags();
        int r2 = this._flags & NetError.ERR_TTNET_FT_INVALID_STREAM_ID;
        this._flags = r2;
        this._flags = r1 | r2;
    L9:
        boolean r3 = false;
        if ((this._flags & 128) != 0) goto L12;
    L23:
        if (r3 == false) goto L25;
    L36:
        this._flags &= -33;
        return;
    L25:
        if ((this._flags & 16384) != 0) goto L35;
        String r4 = get_wscanon_text();
        if (r4 == null) goto L35;
        NamespaceContext.push(new NamespaceContext(get_store()));
        update_from_wscanon_text(r4);     // Catch: Throwable -> L32
        NamespaceContext.pop();
    L32:
        th = move-exception;
        NamespaceContext.pop();
        throw th;
    L35:
        update_from_complex_content();
        goto L36
    L12:
        if (get_store().find_nil() == false) goto L21;
        int r5 = this._flags;
        if ((r5 & 1) == 0) goto L16;
    L20:
        set_nil();
        this._flags |= 64;
        r3 = true;
    L22:
        this._flags &= -129;
        goto L23
    L16:
        if ((r5 & 65536) == 0) goto L20;
        throw new XmlValueOutOfRangeException();
    L21:
        this._flags &= -65;
        goto L22
    L38:
        throw new XmlValueDisconnectedException();
    }

    public final void check_orphaned() {
        if (is_orphaned() == true) goto L6;
        return;
    L6:
        throw new XmlValueDisconnectedException();
    }

    @Override // org.apache.xmlbeans.XmlObject
    public final int compareTo(Object r3) {
        int r2 = compareValue((XmlObject) ZeusTransformUtils.preCheckCast(r3, XmlObject.class, "com.obric.memorydata.plugin"));
        if (r2 == 2) goto L6;
        return r2;
    L6:
        throw new ClassCastException();
    }

    public final int compareValue(XmlObject r5) {
        XmlObject r6 = (XmlObject) ZeusTransformUtils.wrapperContextForParams(r5, XmlObject.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L6;
        return 2;
    L6:
        boolean r0 = false;
    L61:
        th = th;
    L66:
        if (r0 == false) goto L68;
        GlobalLock.release();
    L68:
        throw th;
    L63:
        e = e;
    L65:
        throw new XmlRuntimeException(e);     // Catch: Throwable -> L61
    L8:
        if (isImmutable() == false) goto L22;
        if (r6.isImmutable() == true) goto L12;
        Object r1 = r6.monitor();     // Catch: Throwable -> L61 InterruptedException -> L63
        monitor-enter(r1);     // Catch: Throwable -> L61 InterruptedException -> L63
        int r4 = compareValueImpl(r6);     // Catch: Throwable -> L18
        monitor-exit(r1);     // Catch: Throwable -> L18
        return r4;
    L18:
        th = move-exception;
        throw th;     // Catch: Throwable -> L61 InterruptedException -> L63
    L12:
        return compareValueImpl(r6);
    L22:
        if (r6.isImmutable() == false) goto L24;
    L53:
        Object r2 = monitor();     // Catch: Throwable -> L61 InterruptedException -> L63
        monitor-enter(r2);     // Catch: Throwable -> L61 InterruptedException -> L63
        int r7 = compareValueImpl(r6);     // Catch: Throwable -> L58
        monitor-exit(r2);     // Catch: Throwable -> L58
        return r7;
    L58:
        th = move-exception;
        throw th;     // Catch: Throwable -> L61 InterruptedException -> L63
    L24:
        if (monitor() == r6.monitor()) goto L53;
        GlobalLock.acquire();     // Catch: Throwable -> L61 InterruptedException -> L63
        Object r3 = monitor();     // Catch: Throwable -> L49 InterruptedException -> L51
        monitor-enter(r3);     // Catch: Throwable -> L49 InterruptedException -> L51
        Object r8 = r6.monitor();     // Catch: Throwable -> L43
        monitor-enter(r8);     // Catch: Throwable -> L43
        GlobalLock.release();     // Catch: Throwable -> L39
        int r9 = compareValueImpl(r6);     // Catch: Throwable -> L37
        monitor-exit(r8);     // Catch: Throwable -> L37
        monitor-exit(r3);     // Catch: Throwable -> L47
        return r9;
    L39:
        th = th;
    L41:
        monitor-exit(r8);     // Catch: Throwable -> L37
        throw th;     // Catch: Throwable -> L47
    L37:
        th = th;
    L43:
        th = th;
    L45:
        monitor-exit(r3);     // Catch: Throwable -> L47
        throw th;     // Catch: Throwable -> L61 InterruptedException -> L63
    L47:
        th = th;
    L51:
        e = e;
    L49:
        th = th;
        r0 = true;
        goto L66
    }

    public int compare_to(XmlObject r3) {
        if (equal_to((XmlObject) ZeusTransformUtils.wrapperContextForParams(r3, XmlObject.class, "com.obric.memorydata.plugin")) == false) goto L6;
        return 0;
    L6:
        return 2;
    }

    public abstract String compute_text(NamespaceManager r1);

    @Override // org.apache.xmlbeans.XmlObject
    public final XmlObject copy() {
        if (preCheck() == true) goto L5;
        Object r0 = monitor();
        monitor-enter(r0);
        XmlObject r1 = _copy();     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r1;
    L11:
        th = move-exception;
        throw th;
    L5:
        return _copy();
    }

    public final XmlObject copy(XmlOptions r2) {
        if (preCheck() == true) goto L5;
        Object r0 = monitor();
        monitor-enter(r0);
        XmlObject r1 = _copy(r2);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r1;
    L11:
        th = move-exception;
        throw th;
    L5:
        return _copy(r2);
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
    public TypeStoreUser create_attribute_user(QName r4) {
        return (TypeStoreUser) ZeusTransformUtils.preCheckCast(((SchemaTypeImpl) ZeusTransformUtils.preCheckCast(schemaType(), SchemaTypeImpl.class, "com.obric.memorydata.plugin")).createAttributeType(r4, get_store().get_schematypeloader()), TypeStoreUser.class, "com.obric.memorydata.plugin");
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
    public TypeStoreUser create_element_user(QName r4, QName r5) {
        return (TypeStoreUser) ZeusTransformUtils.preCheckCast(((SchemaTypeImpl) ZeusTransformUtils.preCheckCast(schemaType(), SchemaTypeImpl.class, "com.obric.memorydata.plugin")).createElementType(r4, r5, get_store().get_schematypeloader()), TypeStoreUser.class, "com.obric.memorydata.plugin");
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
    public void disconnect_store() {
        this._flags |= 2720;
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public XmlDocumentProperties documentProperties() {
        XmlCursor r2 = newCursorForce();
        XmlDocumentProperties r0 = r2.documentProperties();     // Catch: Throwable -> L7
        if (r2 == null) goto L6;
        r2.close();
    L6:
        return r0;
    L7:
        th = move-exception;
        throw th;     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        if (r2 != null) goto L18;
    L15:
        throw th;
    L18:
        r2.close();     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        th.addSuppressed(th);
        goto L15
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public void dump() {
        XmlCursor r2 = newCursorForce();
        r2.dump();     // Catch: Throwable -> L7
        if (r2 == null) goto L22;
        r2.close();
        return;
    L22:
        return;
    L7:
        th = move-exception;
        throw th;     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        if (r2 != null) goto L16;
    L15:
        throw th;
    L16:
        r2.close();     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        th.addSuppressed(th);
        goto L15
    }

    public int elementFlags() {
        check_element_dated();
        return this._flags & 7;
    }

    public abstract boolean equal_to(XmlObject r1);

    public final boolean equals(Object r4) {
        if (isImmutable() == true) goto L7;
        return super.equals(r4);
    L7:
        if (ZeusTransformUtils.instanceOf(r4, XmlObject.class) == true) goto L9;
        return false;
    L9:
        XmlObject r5 = (XmlObject) ZeusTransformUtils.preCheckCast(r4, XmlObject.class, "com.obric.memorydata.plugin");
        if (r5.isImmutable() == true) goto L13;
        return false;
    L13:
        return valueEquals(r5);
    }

    public XmlObject[] execQuery(String r2) {
        return execQuery(r2, null);
    }

    public XmlObject[] execQuery(String r2, XmlOptions r3) {
        Object r0 = monitor();
        monitor-enter(r0);
        TypeStore r1 = get_store();     // Catch: Throwable -> L11
        if (r1 == null) goto L10;
        XmlObject[] r4 = _typedArray(r1.exec_query(r2, r3));     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r4;
    L10:
        throw new XmlRuntimeException("Cannot do XQuery on XML Value Objects");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public final XmlObject generatedSetterHelperImpl(XmlObject r5, QName r6, int r7, short r8) {
        XmlObjectBase r9 = underlying((XmlObject) ZeusTransformUtils.wrapperContextForParams(r5, XmlObject.class, "com.obric.memorydata.plugin"));
        if (r9 != null) goto L13;
        Object r0 = monitor();
        monitor-enter(r0);
        XmlObjectBase r4 = getTargetForSetter(r6, r7, r8);     // Catch: Throwable -> L9
        r4.setNil();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r4;
    L9:
        th = move-exception;
        throw th;
    L13:
        if (r9.isImmutable() == false) goto L22;
        Object r1 = monitor();
        monitor-enter(r1);
        XmlObjectBase r10 = getTargetForSetter(r6, r7, r8);     // Catch: Throwable -> L19
        r10.setStringValue(r9.getStringValue());     // Catch: Throwable -> L19
        monitor-exit(r1);     // Catch: Throwable -> L19
        return r10;
    L19:
        th = move-exception;
        throw th;
    L22:
        boolean r2 = preCheck();
        boolean r3 = r9.preCheck();
        if (monitor() != r9.monitor()) goto L35;
        if (r2 == true) goto L26;
        Object r11 = monitor();
        monitor-enter(r11);
        XmlObject r12 = (XmlObject) ZeusTransformUtils.preCheckCast(objSetterHelper(r9, r6, r7, r8), XmlObject.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L32
        monitor-exit(r11);     // Catch: Throwable -> L32
        return r12;
    L32:
        th = move-exception;
        throw th;
    L26:
        return (XmlObject) ZeusTransformUtils.preCheckCast(objSetterHelper(r9, r6, r7, r8), XmlObject.class, "com.obric.memorydata.plugin");
    L35:
        if (r2 == false) goto L46;
        if (r3 == true) goto L26;
        Object r13 = r9.monitor();
        monitor-enter(r13);
        XmlObject r14 = (XmlObject) ZeusTransformUtils.preCheckCast(objSetterHelper(r9, r6, r7, r8), XmlObject.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L43
        monitor-exit(r13);     // Catch: Throwable -> L43
        return r14;
    L43:
        th = move-exception;
        throw th;
    L46:
        if (r3 == false) goto L55;
        Object r15 = monitor();
        monitor-enter(r15);
        XmlObject r16 = (XmlObject) ZeusTransformUtils.preCheckCast(objSetterHelper(r9, r6, r7, r8), XmlObject.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L52
        monitor-exit(r15);     // Catch: Throwable -> L52
        return r16;
    L52:
        th = move-exception;
        throw th;
    L55:
        boolean r17 = false;
        GlobalLock.acquire();     // Catch: Throwable -> L83 InterruptedException -> L85
        Object r18 = monitor();     // Catch: Throwable -> L79 InterruptedException -> L81
        monitor-enter(r18);     // Catch: Throwable -> L79 InterruptedException -> L81
        Object r19 = r9.monitor();     // Catch: Throwable -> L73
        monitor-enter(r19);     // Catch: Throwable -> L73
        GlobalLock.release();     // Catch: Throwable -> L69
        XmlObject r20 = (XmlObject) ZeusTransformUtils.preCheckCast(objSetterHelper(r9, r6, r7, r8), XmlObject.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L67
        monitor-exit(r19);     // Catch: Throwable -> L67
        monitor-exit(r18);     // Catch: Throwable -> L77
        return r20;
    L69:
        th = th;
    L71:
        monitor-exit(r19);     // Catch: Throwable -> L67
        throw th;     // Catch: Throwable -> L77
    L67:
        th = th;
    L73:
        th = th;
    L75:
        monitor-exit(r18);     // Catch: Throwable -> L77
        throw th;     // Catch: Throwable -> L83 InterruptedException -> L85
    L77:
        th = th;
    L81:
        e = e;
    L87:
        throw new XmlRuntimeException(e);     // Catch: Throwable -> L83
    L79:
        th = th;
        r17 = true;
    L88:
        if (r17 == false) goto L90;
        GlobalLock.release();
    L90:
        throw th;
    L85:
        e = e;
    L83:
        th = th;
        goto L88
    }

    public BigDecimal getBigDecimalValue() {
        throw new XmlValueNotSupportedException("exception.value.not.supported.s2j", new Object[]{getPrimitiveTypeName(), "numeric"});
    }

    public BigInteger getBigIntegerValue() {
        BigDecimal r0 = getBigDecimalValue();
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.toBigInteger();
    }

    public boolean[] getBooleanArray(QName r7) {
        Object r0 = monitor();
        monitor-enter(r0);
        List<XmlObjectBase> r6 = getBaseArray(r7);     // Catch: Throwable -> L9
        int r8 = r6.size();     // Catch: Throwable -> L9
        boolean[] r1 = new boolean[r8];     // Catch: Throwable -> L9
        int r2 = 0;
    L5:
        if (r2 >= r8) goto L7;
        r1[r2] = ((SimpleValue) ZeusTransformUtils.preCheckCast(r6.get(r2), SimpleValue.class, "com.obric.memorydata.plugin")).getBooleanValue();     // Catch: Throwable -> L9
        r2 = r2 + 1;     // Catch: Throwable -> L9
        goto L5
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r1;
    L9:
        th = move-exception;
        throw th;
    }

    public boolean[] getBooleanArray(QNameSet r7) {
        Object r0 = monitor();
        monitor-enter(r0);
        List<XmlObjectBase> r6 = getBaseArray(r7);     // Catch: Throwable -> L9
        int r8 = r6.size();     // Catch: Throwable -> L9
        boolean[] r1 = new boolean[r8];     // Catch: Throwable -> L9
        int r2 = 0;
    L5:
        if (r2 >= r8) goto L7;
        r1[r2] = ((SimpleValue) ZeusTransformUtils.preCheckCast(r6.get(r2), SimpleValue.class, "com.obric.memorydata.plugin")).getBooleanValue();     // Catch: Throwable -> L9
        r2 = r2 + 1;     // Catch: Throwable -> L9
        goto L5
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r1;
    L9:
        th = move-exception;
        throw th;
    }

    public boolean getBooleanValue() {
        throw new XmlValueNotSupportedException("exception.value.not.supported.s2j", new Object[]{getPrimitiveTypeName(), TypedValues.Custom.S_BOOLEAN});
    }

    public byte[] getByteArray(QName r7) {
        Object r0 = monitor();
        monitor-enter(r0);
        List<XmlObjectBase> r6 = getBaseArray(r7);     // Catch: Throwable -> L9
        int r8 = r6.size();     // Catch: Throwable -> L9
        byte[] r1 = new byte[r8];     // Catch: Throwable -> L9
        int r2 = 0;
    L5:
        if (r2 >= r8) goto L7;
        r1[r2] = ((SimpleValue) ZeusTransformUtils.preCheckCast(r6.get(r2), SimpleValue.class, "com.obric.memorydata.plugin")).getByteValue();     // Catch: Throwable -> L9
        r2 = r2 + 1;     // Catch: Throwable -> L9
        goto L5
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r1;
    L9:
        th = move-exception;
        throw th;
    }

    public byte[] getByteArray(QNameSet r7) {
        Object r0 = monitor();
        monitor-enter(r0);
        List<XmlObjectBase> r6 = getBaseArray(r7);     // Catch: Throwable -> L9
        int r8 = r6.size();     // Catch: Throwable -> L9
        byte[] r1 = new byte[r8];     // Catch: Throwable -> L9
        int r2 = 0;
    L5:
        if (r2 >= r8) goto L7;
        r1[r2] = ((SimpleValue) ZeusTransformUtils.preCheckCast(r6.get(r2), SimpleValue.class, "com.obric.memorydata.plugin")).getByteValue();     // Catch: Throwable -> L9
        r2 = r2 + 1;     // Catch: Throwable -> L9
        goto L5
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r1;
    L9:
        th = move-exception;
        throw th;
    }

    public byte[] getByteArrayValue() {
        throw new XmlValueNotSupportedException("exception.value.not.supported.s2j", new Object[]{getPrimitiveTypeName(), "byte[]"});
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public byte getByteValue() {
        long r0 = getIntValue();
        if (r0 > 127) goto L11;
        if (r0 < (-128)) goto L9;
        return (byte) r0;
    L9:
        throw new XmlValueOutOfRangeException();
    L11:
        throw new XmlValueOutOfRangeException();
    }

    public Calendar getCalendarValue() {
        throw new XmlValueNotSupportedException("exception.value.not.supported.s2j", new Object[]{getPrimitiveTypeName(), "Calendar"});
    }

    public Date getDateValue() {
        throw new XmlValueNotSupportedException("exception.value.not.supported.s2j", new Object[]{getPrimitiveTypeName(), "Date"});
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public Node getDomNode() {
        XmlCursor r2 = newCursorForce();
        Node r0 = r2.getDomNode();     // Catch: Throwable -> L7
        if (r2 == null) goto L6;
        r2.close();
    L6:
        return r0;
    L7:
        th = move-exception;
        throw th;     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        if (r2 != null) goto L18;
    L15:
        throw th;
    L18:
        r2.close();     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        th.addSuppressed(th);
        goto L15
    }

    public double[] getDoubleArray(QName r3) {
        Object r0 = monitor();
        monitor-enter(r0);
        double[] r2 = getBaseArray(r3).stream().map(new $$Lambda$XmlObjectBase$sZT5efFyTAcMUGcVBAkDU0ttgn0(SimpleValue.class)).mapToDouble($$Lambda$bHXxkBhplptAM71rhkCVNLbHUHc.INSTANCE).toArray();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r2;
    L7:
        th = move-exception;
        throw th;
    }

    public double[] getDoubleArray(QNameSet r3) {
        Object r0 = monitor();
        monitor-enter(r0);
        double[] r2 = getBaseArray(r3).stream().map(new $$Lambda$XmlObjectBase$sZT5efFyTAcMUGcVBAkDU0ttgn0(SimpleValue.class)).mapToDouble($$Lambda$bHXxkBhplptAM71rhkCVNLbHUHc.INSTANCE).toArray();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r2;
    L7:
        th = move-exception;
        throw th;
    }

    public double getDoubleValue() {
        BigDecimal r2 = getBigDecimalValue();
        if (r2 != null) goto L6;
        return 0.0d;
    L6:
        return r2.doubleValue();
    }

    public <T> T[] getEnumArray(QName r3, IntFunction<T[]> r4) {
        IntFunction r5 = (IntFunction) ZeusTransformUtils.wrapperContextForParams(r4, IntFunction.class, "com.obric.memorydata.plugin");
        Object r0 = monitor();
        monitor-enter(r0);
        T[] r2 = (T[]) getBaseArray(r3).stream().map($$Lambda$CzVcobku7lnlM3vSu3ZR1C8POGc.INSTANCE).toArray(r5);
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r2;
    L7:
        th = move-exception;
        throw th;
    }

    public <T> T[] getEnumArray(QNameSet r3, IntFunction<T[]> r4) {
        IntFunction r5 = (IntFunction) ZeusTransformUtils.wrapperContextForParams(r4, IntFunction.class, "com.obric.memorydata.plugin");
        Object r0 = monitor();
        monitor-enter(r0);
        T[] r2 = (T[]) getBaseArray(r3).stream().map($$Lambda$CzVcobku7lnlM3vSu3ZR1C8POGc.INSTANCE).toArray(r5);
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r2;
    L7:
        th = move-exception;
        throw th;
    }

    public StringEnumAbstractBase getEnumValue() {
        throw new XmlValueNotSupportedException("exception.value.not.supported.s2j", new Object[]{getPrimitiveTypeName(), "enum"});
    }

    public float[] getFloatArray(QName r7) {
        Object r0 = monitor();
        monitor-enter(r0);
        List<XmlObjectBase> r6 = getBaseArray(r7);     // Catch: Throwable -> L9
        int r8 = r6.size();     // Catch: Throwable -> L9
        float[] r1 = new float[r8];     // Catch: Throwable -> L9
        int r2 = 0;
    L5:
        if (r2 >= r8) goto L7;
        r1[r2] = ((SimpleValue) ZeusTransformUtils.preCheckCast(r6.get(r2), SimpleValue.class, "com.obric.memorydata.plugin")).getFloatValue();     // Catch: Throwable -> L9
        r2 = r2 + 1;     // Catch: Throwable -> L9
        goto L5
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r1;
    L9:
        th = move-exception;
        throw th;
    }

    public float[] getFloatArray(QNameSet r7) {
        Object r0 = monitor();
        monitor-enter(r0);
        List<XmlObjectBase> r6 = getBaseArray(r7);     // Catch: Throwable -> L9
        int r8 = r6.size();     // Catch: Throwable -> L9
        float[] r1 = new float[r8];     // Catch: Throwable -> L9
        int r2 = 0;
    L5:
        if (r2 >= r8) goto L7;
        r1[r2] = ((SimpleValue) ZeusTransformUtils.preCheckCast(r6.get(r2), SimpleValue.class, "com.obric.memorydata.plugin")).getFloatValue();     // Catch: Throwable -> L9
        r2 = r2 + 1;     // Catch: Throwable -> L9
        goto L5
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r1;
    L9:
        th = move-exception;
        throw th;
    }

    public float getFloatValue() {
        BigDecimal r0 = getBigDecimalValue();
        if (r0 != null) goto L6;
        return 0.0f;
    L6:
        return r0.floatValue();
    }

    public GDate getGDateValue() {
        throw new XmlValueNotSupportedException("exception.value.not.supported.s2j", new Object[]{getPrimitiveTypeName(), "Date"});
    }

    public GDuration getGDurationValue() {
        throw new XmlValueNotSupportedException("exception.value.not.supported.s2j", new Object[]{getPrimitiveTypeName(), "Duration"});
    }

    public int[] getIntArray(QName r3) {
        Object r0 = monitor();
        monitor-enter(r0);
        int[] r2 = getBaseArray(r3).stream().map(new $$Lambda$XmlObjectBase$sZT5efFyTAcMUGcVBAkDU0ttgn0(SimpleValue.class)).mapToInt($$Lambda$h8stMdw2fDKsVkCYKzrouvz2Qg0.INSTANCE).toArray();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r2;
    L7:
        th = move-exception;
        throw th;
    }

    public int[] getIntArray(QNameSet r3) {
        Object r0 = monitor();
        monitor-enter(r0);
        int[] r2 = getBaseArray(r3).stream().map(new $$Lambda$XmlObjectBase$sZT5efFyTAcMUGcVBAkDU0ttgn0(SimpleValue.class)).mapToInt($$Lambda$h8stMdw2fDKsVkCYKzrouvz2Qg0.INSTANCE).toArray();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r2;
    L7:
        th = move-exception;
        throw th;
    }

    public int getIntValue() {
        long r0 = getLongValue();
        if (r0 > 2147483647L) goto L11;
        if (r0 < (-2147483648L)) goto L9;
        return (int) r0;
    L9:
        throw new XmlValueOutOfRangeException();
    L11:
        throw new XmlValueOutOfRangeException();
    }

    public List<?> getListValue() {
        throw new XmlValueNotSupportedException("exception.value.not.supported.s2j", new Object[]{getPrimitiveTypeName(), e.f16168a});
    }

    public long[] getLongArray(QName r3) {
        Object r0 = monitor();
        monitor-enter(r0);
        long[] r2 = getBaseArray(r3).stream().map(new $$Lambda$XmlObjectBase$sZT5efFyTAcMUGcVBAkDU0ttgn0(SimpleValue.class)).mapToLong($$Lambda$cmpFUbNG6rH2jqiJjOpigGnEac.INSTANCE).toArray();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r2;
    L7:
        th = move-exception;
        throw th;
    }

    public long[] getLongArray(QNameSet r3) {
        Object r0 = monitor();
        monitor-enter(r0);
        long[] r2 = getBaseArray(r3).stream().map(new $$Lambda$XmlObjectBase$sZT5efFyTAcMUGcVBAkDU0ttgn0(SimpleValue.class)).mapToLong($$Lambda$cmpFUbNG6rH2jqiJjOpigGnEac.INSTANCE).toArray();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r2;
    L7:
        th = move-exception;
        throw th;
    }

    public long getLongValue() {
        BigInteger r2 = getBigIntegerValue();
        if (r2 != null) goto L7;
        return 0;
    L7:
        if (r2.compareTo(_max) >= 0) goto L15;
        if (r2.compareTo(_min) <= 0) goto L13;
        return r2.longValue();
    L13:
        throw new XmlValueOutOfRangeException();
    L15:
        throw new XmlValueOutOfRangeException();
    }

    public <T> T[] getObjectArray(QName r3, Function<SimpleValue, T> r4, IntFunction<T[]> r5) {
        Function<? super XmlObjectBase, ? extends R> r6 = (Function) ZeusTransformUtils.wrapperContextForParams(r4, Function.class, "com.obric.memorydata.plugin");
        IntFunction r7 = (IntFunction) ZeusTransformUtils.wrapperContextForParams(r5, IntFunction.class, "com.obric.memorydata.plugin");
        Object r0 = monitor();
        monitor-enter(r0);
        T[] r2 = (T[]) getBaseArray(r3).stream().map(r6).toArray(r7);
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r2;
    L7:
        th = move-exception;
        throw th;
    }

    public <T> T[] getObjectArray(QNameSet r3, Function<SimpleValue, T> r4, IntFunction<T[]> r5) {
        Function<? super XmlObjectBase, ? extends R> r6 = (Function) ZeusTransformUtils.wrapperContextForParams(r4, Function.class, "com.obric.memorydata.plugin");
        IntFunction r7 = (IntFunction) ZeusTransformUtils.wrapperContextForParams(r5, IntFunction.class, "com.obric.memorydata.plugin");
        Object r0 = monitor();
        monitor-enter(r0);
        T[] r2 = (T[]) getBaseArray(r3).stream().map(r6).toArray(r7);
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r2;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public Object getObjectValue() {
        return java_value(this);
    }

    public QName getQNameValue() {
        throw new XmlValueNotSupportedException("exception.value.not.supported.s2j", new Object[]{getPrimitiveTypeName(), "QName"});
    }

    public short[] getShortArray(QName r7) {
        Object r0 = monitor();
        monitor-enter(r0);
        List<XmlObjectBase> r6 = getBaseArray(r7);     // Catch: Throwable -> L9
        int r8 = r6.size();     // Catch: Throwable -> L9
        short[] r1 = new short[r8];     // Catch: Throwable -> L9
        int r2 = 0;
    L5:
        if (r2 >= r8) goto L7;
        r1[r2] = ((SimpleValue) ZeusTransformUtils.preCheckCast(r6.get(r2), SimpleValue.class, "com.obric.memorydata.plugin")).getShortValue();     // Catch: Throwable -> L9
        r2 = r2 + 1;     // Catch: Throwable -> L9
        goto L5
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r1;
    L9:
        th = move-exception;
        throw th;
    }

    public short[] getShortArray(QNameSet r7) {
        Object r0 = monitor();
        monitor-enter(r0);
        List<XmlObjectBase> r6 = getBaseArray(r7);     // Catch: Throwable -> L9
        int r8 = r6.size();     // Catch: Throwable -> L9
        short[] r1 = new short[r8];     // Catch: Throwable -> L9
        int r2 = 0;
    L5:
        if (r2 >= r8) goto L7;
        r1[r2] = ((SimpleValue) ZeusTransformUtils.preCheckCast(r6.get(r2), SimpleValue.class, "com.obric.memorydata.plugin")).getShortValue();     // Catch: Throwable -> L9
        r2 = r2 + 1;     // Catch: Throwable -> L9
        goto L5
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r1;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public short getShortValue() {
        long r0 = getIntValue();
        if (r0 > 32767) goto L11;
        if (r0 < (-32768)) goto L9;
        return (short) r0;
    L9:
        throw new XmlValueOutOfRangeException();
    L11:
        throw new XmlValueOutOfRangeException();
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public String getStringValue() {
        TypeStore r1 = null;
        if (isImmutable() == true) goto L5;
        Object r0 = monitor();
        monitor-enter(r0);
    L26:
        th = move-exception;
        throw th;
    L12:
        if (_isComplexContent() == false) goto L16;
        String r3 = get_store().fetch_text(1);     // Catch: Throwable -> L26
        monitor-exit(r0);     // Catch: Throwable -> L26
        return r3;
    L16:
        check_dated();     // Catch: Throwable -> L26
        if ((this._flags & 64) == 0) goto L21;
        monitor-exit(r0);     // Catch: Throwable -> L26
        return null;
    L21:
        if (has_store() == false) goto L23;
        r1 = get_store();     // Catch: Throwable -> L26
    L23:
        String r4 = compute_text(r1);     // Catch: Throwable -> L26
        monitor-exit(r0);     // Catch: Throwable -> L26
        return r4;
    L5:
        if ((this._flags & 64) == 0) goto L8;
        return null;
    L8:
        return compute_text(null);
    }

    public final XmlLocale getXmlLocale() {
        return get_store().get_locale();
    }

    public <T extends XmlObject> T[] getXmlObjectArray(QName r2, T[] r3) {
        Object r0 = monitor();
        monitor-enter(r0);
        T[] r1 = (T[]) ((XmlObject[]) ZeusTransformUtils.preCheckCast(getBaseArray(r2).toArray(r3), XmlObject[].class, "com.obric.memorydata.plugin"));
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public <T extends XmlObject> T[] getXmlObjectArray(QNameSet r2, T[] r3) {
        Object r0 = monitor();
        monitor-enter(r0);
        T[] r1 = (T[]) ((XmlObject[]) ZeusTransformUtils.preCheckCast(getBaseArray(r2).toArray(r3), XmlObject[].class, "com.obric.memorydata.plugin"));
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
    public SchemaField get_attribute_field(QName r1) {
        SchemaAttributeModel r0 = schemaType().getAttributeModel();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getAttribute(r1);
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
    public SchemaType get_attribute_type(QName r2) {
        return schemaType().getAttributeType(r2, get_store().get_schematypeloader());
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
    public int get_attributeflags(QName r3) {
        int r1 = 0;
        if (_isComplexType() == true) goto L5;
        return 0;
    L5:
        SchemaProperty r2 = schemaType().getAttributeProperty(r3);
        if (r2 != null) goto L9;
        return 0;
    L9:
        if (r2.hasDefault() != 0) goto L11;
        int r4 = 0;
    L13:
        if (r2.hasFixed() == 0) goto L17;
        r1 = 4;
    L17:
        return r4 | r1;
    L11:
        r4 = 2;
        goto L13
    }

    public String get_default_attribute_text(QName r2) {
        if (_isComplexType() == false) goto L11;
        SchemaProperty r1 = schemaType().getAttributeProperty(r2);
        if (r1 != null) goto L9;
        return "";
    L9:
        return r1.getDefaultText();
    L11:
        throw new IllegalStateException();
    }

    public XmlAnySimpleType get_default_attribute_value(QName r2) {
        SchemaAttributeModel r1 = schemaType().getAttributeModel();
        if (r1 != null) goto L5;
        return null;
    L5:
        SchemaLocalAttribute r3 = r1.getAttribute(r2);
        if (r3 != null) goto L9;
        return null;
    L9:
        return r3.getDefaultValue();
    }

    public String get_default_element_text(QName r2) {
        if (_isComplexContent() == false) goto L11;
        SchemaProperty r1 = schemaType().getElementProperty(r2);
        if (r1 != null) goto L9;
        return "";
    L9:
        return r1.getDefaultText();
    L11:
        throw new IllegalStateException();
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
    public final QNameSet get_element_ending_delimiters(QName r1) {
        SchemaProperty r0 = schemaType().getElementProperty(r1);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getJavaSetterDelimiter();
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
    public SchemaType get_element_type(QName r2, QName r3) {
        return schemaType().getElementType(r2, r3, get_store().get_schematypeloader());
    }

    public int get_elementflags(QName r4) {
        int r1 = 0;
        if (_isComplexContent() == true) goto L5;
        return 0;
    L5:
        SchemaProperty r3 = schemaType().getElementProperty(r4);
        if (r3 != null) goto L9;
        return 0;
    L9:
        if (r3.hasDefault() != 1) goto L11;
        return -1;
    L11:
        if (r3.hasFixed() != 1) goto L13;
        return -1;
    L13:
        if (r3.hasNillable() != 1) goto L16;
        return -1;
    L16:
        if (r3.hasDefault() != 0) goto L18;
        int r5 = 0;
    L20:
        if (r3.hasFixed() != 0) goto L22;
        int r2 = 0;
    L23:
        int r6 = r5 | r2;
        if (r3.hasNillable() == 0) goto L28;
        r1 = 1;
    L28:
        return r6 | r1;
    L22:
        r2 = 4;
        goto L23
    L18:
        r5 = 2;
        goto L20
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
    public SchemaType get_schema_type() {
        return schemaType();
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
    public final TypeStore get_store() {
        return (TypeStore) ZeusTransformUtils.preCheckCast(this._textsource, TypeStore.class, "com.obric.memorydata.plugin");
    }

    public int get_wscanon_rule() {
        return 3;
    }

    public final String get_wscanon_text() {
        if ((this._flags & 16) != 0) goto L7;
        return apply_wscanon((String) ZeusTransformUtils.preCheckCast(this._textsource, String.class, "com.obric.memorydata.plugin"));
    L7:
        return get_store().fetch_text(get_wscanon_rule());
    }

    public final boolean has_store() {
        if ((this._flags & 16) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final int hashCode() {
        if (isImmutable() == false) goto L5;
        Object r0 = monitor();
        monitor-enter(r0);
    L16:
        th = move-exception;
        throw th;
    L9:
        if (isNil() == true) goto L11;
        int r2 = value_hash_code();     // Catch: Throwable -> L16
        monitor-exit(r0);     // Catch: Throwable -> L16
        return r2;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L16
        return 0;
    L5:
        return super.hashCode();
    }

    public void initComplexType(boolean r3, boolean r4) {
        int r0 = this._flags;
        int r1 = 0;
        if (r3 == false) goto L5;
        int r5 = 8192;
    L6:
        if (r4 == false) goto L8;
        r1 = 16384;
    L8:
        this._flags = (r5 | r1) | r0;
        return;
    L5:
        r5 = 0;
        goto L6
    }

    public void init_flags(SchemaProperty r6) {
        SchemaProperty r7 = (SchemaProperty) ZeusTransformUtils.wrapperContextForParams(r6, SchemaProperty.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L5;
        return;
    L5:
        int r1 = 1;
        if (r7.hasDefault() != 1) goto L8;
        return;
    L8:
        if (r7.hasFixed() != 1) goto L10;
        return;
    L10:
        if (r7.hasNillable() == 1) goto L27;
        int r0 = this._flags & (-8);
        this._flags = r0;
        if (r7.hasDefault() != 0) goto L15;
        int r2 = 0;
    L17:
        if (r7.hasFixed() != 0) goto L19;
        int r4 = 0;
    L20:
        int r3 = r2 | r4;
        if (r7.hasNillable() != 0) goto L23;
        r1 = 0;
    L23:
        this._flags = ((r3 | r1) | 32768) | r0;
        return;
    L19:
        r4 = 4;
        goto L20
    L15:
        r2 = 2;
        goto L17
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public SchemaType instanceType() {
        Object r0 = monitor();
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (isNil() == false) goto L7;
        SchemaType r2 = null;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r2;
    L7:
        r2 = schemaType();     // Catch: Throwable -> L10
        goto L8
    }

    public final void invalidate_element_order() {
        this._flags |= FLAGS_DATED;
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
    public final void invalidate_nilvalue() {
        this._flags |= 160;
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStoreUser
    public final void invalidate_value() {
        this._flags |= 32;
    }

    public final boolean isDefault() {
        check_dated();
        if ((this._flags & 256) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isDefaultable() {
        check_element_dated();
        if ((this._flags & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isFixed() {
        check_element_dated();
        if ((this._flags & 4) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // org.apache.xmlbeans.XmlObject
    public boolean isImmutable() {
        if ((this._flags & 4096) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isInstanceOf(SchemaType r4) {
        SchemaType r5 = (SchemaType) ZeusTransformUtils.wrapperContextForParams(r4, SchemaType.class, "com.obric.memorydata.plugin");
        if (r5.getSimpleVariety() == 2) goto L9;
        SchemaType r3 = instanceType();
    L5:
        if (r3 == null) goto L15;
        if (r5 == r3) goto L7;
        r3 = r3.getBaseType();
        goto L5
    L7:
        return true;
    L15:
        return false;
    L9:
        HashSet r0 = new HashSet(Arrays.asList(r5.getUnionConstituentTypes()));
        SchemaType r6 = instanceType();
    L10:
        if (r6 == null) goto L21;
        if (r0.contains(r6) == true) goto L13;
        r6 = r6.getBaseType();
        goto L10
    L13:
        return true;
    L21:
        return false;
    }

    @Override // org.apache.xmlbeans.XmlObject
    public final boolean isNil() {
        Object r0 = monitor();
        monitor-enter(r0);
        check_dated();     // Catch: Throwable -> L10
        if ((this._flags & 64) == 0) goto L7;
        boolean r1 = true;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r1;
    L7:
        r1 = false;
    L10:
        th = move-exception;
        throw th;
    }

    public final boolean isNillable() {
        check_element_dated();
        if ((this._flags & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean is_child_element_order_sensitive() {
        if (_isComplexType() == true) goto L7;
        return false;
    L7:
        return schemaType().isOrderSensitive();
    }

    public boolean is_defaultable_ws(String r1) {
        return true;
    }

    public final boolean is_orphaned() {
        if ((this._flags & 2048) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public final Object monitor() {
        if (has_store() == true) goto L5;
        return this;
    L5:
        return get_store().get_locale();
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public XmlCursor newCursor() {
        if ((this._flags & 16) == 0) goto L26;
        check_orphaned();
        XmlLocale r0 = getXmlLocale();
        if (r0.noSync() == false) goto L13;
        r0.enter();
        XmlCursor r2 = get_store().new_cursor();     // Catch: Throwable -> L10
        r0.exit();
        return r2;
    L10:
        th = move-exception;
        r0.exit();
        throw th;
    L13:
        monitor-enter(r0);
        r0.enter();     // Catch: Throwable -> L22
        XmlCursor r3 = get_store().new_cursor();     // Catch: Throwable -> L19
        r0.exit();     // Catch: Throwable -> L22
        monitor-exit(r0);     // Catch: Throwable -> L22
        return r3;
    L19:
        th = move-exception;
        r0.exit();     // Catch: Throwable -> L22
        throw th;     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        throw th;
    L26:
        throw new IllegalStateException("XML Value Objects cannot create cursors");
    }

    public XmlCursor newCursorForce() {
        Object r0 = monitor();
        monitor-enter(r0);
        XmlCursor r1 = ensureStore().newCursor();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public Node newDomNode() {
        return newDomNode(null);
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public Node newDomNode(XmlOptions r2) {
        XmlCursor r1 = newCursorForce();
        Node r3 = r1.newDomNode(makeInnerOptions(r2));     // Catch: Throwable -> L7
        if (r1 == null) goto L6;
        r1.close();
    L6:
        return r3;
    L7:
        th = move-exception;
        throw th;     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        if (r1 != null) goto L20;
    L15:
        throw th;
    L20:
        r1.close();     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        th.addSuppressed(th);
        goto L15
    }

    public InputStream newInputStream() {
        return newInputStream(null);
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public InputStream newInputStream(XmlOptions r2) {
        XmlCursor r1 = newCursorForce();
        InputStream r3 = r1.newInputStream(makeInnerOptions(r2));     // Catch: Throwable -> L7
        if (r1 == null) goto L6;
        r1.close();
    L6:
        return r3;
    L7:
        th = move-exception;
        throw th;     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        if (r1 != null) goto L20;
    L15:
        throw th;
    L20:
        r1.close();     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        th.addSuppressed(th);
        goto L15
    }

    public Reader newReader() {
        return newReader(null);
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public Reader newReader(XmlOptions r2) {
        XmlCursor r1 = newCursorForce();
        Reader r3 = r1.newReader(makeInnerOptions(r2));     // Catch: Throwable -> L7
        if (r1 == null) goto L6;
        r1.close();
    L6:
        return r3;
    L7:
        th = move-exception;
        throw th;     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        if (r1 != null) goto L20;
    L15:
        throw th;
    L20:
        r1.close();     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        th.addSuppressed(th);
        goto L15
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public javax.xml.stream.e newXMLStreamReader() {
        return newXMLStreamReader(null);
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public javax.xml.stream.e newXMLStreamReader(XmlOptions r2) {
        XmlCursor r1 = newCursorForce();
        javax.xml.stream.e r3 = r1.newXMLStreamReader(makeInnerOptions(r2));     // Catch: Throwable -> L7
        if (r1 == null) goto L6;
        r1.close();
    L6:
        return r3;
    L7:
        th = move-exception;
        throw th;     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        if (r1 != null) goto L20;
    L15:
        throw th;
    L20:
        r1.close();     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        th.addSuppressed(th);
        goto L15
    }

    public TypeStoreVisitor new_visitor() {
        if (_isComplexContent() == true) goto L7;
        return null;
    L7:
        return new SchemaTypeVisitorImpl(schemaType().getContentModel());
    }

    public void save(File r2) {
        save(r2, null);
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public void save(File r1, XmlOptions r2) {
        XmlCursor r0 = newCursorForce();
        r0.save(r1, makeInnerOptions(r2));     // Catch: Throwable -> L7
        if (r0 == null) goto L22;
        r0.close();
        return;
    L22:
        return;
    L7:
        th = move-exception;
        throw th;     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        if (r0 != null) goto L20;
    L15:
        throw th;
    L20:
        r0.close();     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        th.addSuppressed(th);
        goto L15
    }

    public void save(OutputStream r2) {
        save(r2, null);
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public void save(OutputStream r1, XmlOptions r2) {
        XmlCursor r0 = newCursorForce();
        r0.save(r1, makeInnerOptions(r2));     // Catch: Throwable -> L7
        if (r0 == null) goto L22;
        r0.close();
        return;
    L22:
        return;
    L7:
        th = move-exception;
        throw th;     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        if (r0 != null) goto L20;
    L15:
        throw th;
    L20:
        r0.close();     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        th.addSuppressed(th);
        goto L15
    }

    public void save(Writer r2) {
        save(r2, null);
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public void save(Writer r1, XmlOptions r2) {
        XmlCursor r0 = newCursorForce();
        r0.save(r1, makeInnerOptions(r2));     // Catch: Throwable -> L7
        if (r0 == null) goto L22;
        r0.close();
        return;
    L22:
        return;
    L7:
        th = move-exception;
        throw th;     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        if (r0 != null) goto L20;
    L15:
        throw th;
    L20:
        r0.close();     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        th.addSuppressed(th);
        goto L15
    }

    public void save(ContentHandler r3, LexicalHandler r4) {
        save((ContentHandler) ZeusTransformUtils.wrapperContextForParams(r3, ContentHandler.class, "com.obric.memorydata.plugin"), (LexicalHandler) ZeusTransformUtils.wrapperContextForParams(r4, LexicalHandler.class, "com.obric.memorydata.plugin"), null);
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public void save(ContentHandler r3, LexicalHandler r4, XmlOptions r5) {
        ContentHandler r6 = (ContentHandler) ZeusTransformUtils.wrapperContextForParams(r3, ContentHandler.class, "com.obric.memorydata.plugin");
        LexicalHandler r7 = (LexicalHandler) ZeusTransformUtils.wrapperContextForParams(r4, LexicalHandler.class, "com.obric.memorydata.plugin");
        XmlCursor r2 = newCursorForce();
        r2.save(r6, r7, makeInnerOptions(r5));     // Catch: Throwable -> L7
        if (r2 == null) goto L22;
        r2.close();
        return;
    L22:
        return;
    L7:
        th = move-exception;
        throw th;     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        if (r2 != null) goto L20;
    L15:
        throw th;
    L20:
        r2.close();     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        th.addSuppressed(th);
        goto L15
    }

    public abstract SchemaType schemaType();

    public XmlObject selectAttribute(String r2, String r3) {
        return selectAttribute(new QName(r2, r3));
    }

    public XmlObject selectAttribute(QName r3) {
        XmlCursor r2 = newCursor();
    L22:
        th = move-exception;
        throw th;     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        if (r2 != null) goto L31;
    L30:
        throw th;
    L31:
        r2.close();     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        th.addSuppressed(th);
        goto L30
    L5:
        if (r2.isContainer() == true) goto L10;
        if (r2 == null) goto L8;
        r2.close();
    L8:
        return null;
    L10:
        if (r2.toFirstAttribute() == true) goto L12;
    L19:
        if (r2 == null) goto L21;
        r2.close();
    L21:
        return null;
    L12:
        if (r2.getName().equals(r3) == true) goto L13;
        if (r2.toNextAttribute() == true) goto L12;
    L13:
        XmlObject r4 = r2.getObject();     // Catch: Throwable -> L22
        if (r2 == null) goto L16;
        r2.close();
    L16:
        return r4;
    }

    public XmlObject[] selectAttributes(QNameSet r3) {
        if (r3 == null) goto L37;
        XmlCursor r2 = newCursor();
    L27:
        th = move-exception;
        throw th;     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        if (r2 != null) goto L38;
    L35:
        throw th;
    L38:
        r2.close();     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        th.addSuppressed(th);
        goto L35
    L5:
        if (r2.isContainer() == true) goto L10;
        XmlObject[] r4 = EMPTY_RESULT;     // Catch: Throwable -> L27
        if (r2 == null) goto L9;
        r2.close();
    L9:
        return r4;
    L10:
        ArrayList r0 = new ArrayList();     // Catch: Throwable -> L27
        if (r2.toFirstAttribute() == false) goto L18;
    L13:
        if (r3.contains(r2.getName()) == false) goto L16;
        r0.add(r2.getObject());     // Catch: Throwable -> L27
    L16:
        if (r2.toNextAttribute() == true) goto L13;
    L18:
        if (r0.size() != 0) goto L23;
        XmlObject[] r5 = EMPTY_RESULT;     // Catch: Throwable -> L27
        if (r2 == null) goto L22;
        r2.close();
    L22:
        return r5;
    L23:
        XmlObject[] r6 = (XmlObject[]) ZeusTransformUtils.preCheckCast(r0.toArray(EMPTY_RESULT), XmlObject[].class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L27
        if (r2 == null) goto L26;
        r2.close();
    L26:
        return r6;
    L37:
        throw new IllegalArgumentException();
    }

    public XmlObject[] selectChildren(String r2, String r3) {
        return selectChildren(new QName(r2, r3));
    }

    @Override // org.apache.xmlbeans.XmlObject
    public XmlObject[] selectChildren(QName r3) {
        XmlCursor r2 = newCursor();
    L23:
        th = move-exception;
        throw th;     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        if (r2 != null) goto L34;
    L31:
        throw th;
    L34:
        r2.close();     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        th.addSuppressed(th);
        goto L31
    L4:
        if (r2.isContainer() == true) goto L9;
        XmlObject[] r4 = EMPTY_RESULT;     // Catch: Throwable -> L23
        if (r2 == null) goto L8;
        r2.close();
    L8:
        return r4;
    L9:
        ArrayList r0 = new ArrayList();     // Catch: Throwable -> L23
        if (r2.toChild(r3) == false) goto L14;
    L11:
        r0.add(r2.getObject());     // Catch: Throwable -> L23
        if (r2.toNextSibling(r3) == true) goto L11;
    L14:
        if (r0.size() != 0) goto L19;
        XmlObject[] r5 = EMPTY_RESULT;     // Catch: Throwable -> L23
        if (r2 == null) goto L18;
        r2.close();
    L18:
        return r5;
    L19:
        XmlObject[] r6 = (XmlObject[]) ZeusTransformUtils.preCheckCast(r0.toArray(EMPTY_RESULT), XmlObject[].class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L23
        if (r2 == null) goto L22;
        r2.close();
    L22:
        return r6;
    }

    public XmlObject[] selectChildren(QNameSet r3) {
        if (r3 == null) goto L37;
        XmlCursor r2 = newCursor();
    L27:
        th = move-exception;
        throw th;     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        if (r2 != null) goto L38;
    L35:
        throw th;
    L38:
        r2.close();     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        th.addSuppressed(th);
        goto L35
    L5:
        if (r2.isContainer() == true) goto L10;
        XmlObject[] r4 = EMPTY_RESULT;     // Catch: Throwable -> L27
        if (r2 == null) goto L9;
        r2.close();
    L9:
        return r4;
    L10:
        ArrayList r0 = new ArrayList();     // Catch: Throwable -> L27
        if (r2.toFirstChild() == false) goto L18;
    L13:
        if (r3.contains(r2.getName()) == false) goto L16;
        r0.add(r2.getObject());     // Catch: Throwable -> L27
    L16:
        if (r2.toNextSibling() == true) goto L13;
    L18:
        if (r0.size() != 0) goto L23;
        XmlObject[] r5 = EMPTY_RESULT;     // Catch: Throwable -> L27
        if (r2 == null) goto L22;
        r2.close();
    L22:
        return r5;
    L23:
        XmlObject[] r6 = (XmlObject[]) ZeusTransformUtils.preCheckCast(r0.toArray(EMPTY_RESULT), XmlObject[].class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L27
        if (r2 == null) goto L26;
        r2.close();
    L26:
        return r6;
    L37:
        throw new IllegalArgumentException();
    }

    @Override // org.apache.xmlbeans.XmlObject
    public XmlObject[] selectPath(String r2) {
        return selectPath(r2, null);
    }

    public XmlObject[] selectPath(String r2, XmlOptions r3) {
        XmlCursor r1 = newCursor();
        if (r1 == null) goto L27;
        r1.selectPath(r2, r3);     // Catch: Throwable -> L24
        if (r1.hasNextSelection() == true) goto L7;
        XmlObject[] r4 = EMPTY_RESULT;     // Catch: Throwable -> L24
    L20:
        if (r1 == null) goto L23;
        r1.close();
    L23:
        return _typedArray(r4);
    L7:
        r4 = new XmlObject[r1.getSelectionCount()];     // Catch: Throwable -> L24
        int r5 = 0;
    L9:
        if (r1.toNextSelection() == false) goto L20;
        XmlObject r0 = r1.getObject();     // Catch: Throwable -> L24
        r4[r5] = r0;     // Catch: Throwable -> L24
        if (r0 != null) goto L19;
        if (r1.toParent() == false) goto L18;
        XmlObject r6 = r1.getObject();     // Catch: Throwable -> L24
        r4[r5] = r6;     // Catch: Throwable -> L24
        if (r6 != null) goto L19;
    L18:
        throw new XmlRuntimeException("Path must select only elements and attributes");     // Catch: Throwable -> L24
    L19:
        r5 = r5 + 1;
        goto L9
    L27:
        throw new XmlValueDisconnectedException();     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        throw th;     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        if (r1 != null) goto L38;
    L35:
        throw th;
    L38:
        r1.close();     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        th.addSuppressed(th);
        goto L35
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v30 */
    @Override // org.apache.xmlbeans.XmlObject
    public final XmlObject set(XmlObject r5) {
        XmlObject r6 = (XmlObject) ZeusTransformUtils.wrapperContextForParams(r5, XmlObject.class, "com.obric.memorydata.plugin");
        if (isImmutable() == true) goto L81;
        XmlObjectBase r7 = underlying(r6);
        if (r7 != null) goto L9;
        setNil();
        return this;
    L9:
        if (r7.isImmutable() == false) goto L11;
        setStringValue(r7.getStringValue());
        Object r4 = this;
    L55:
        return (XmlObject) ZeusTransformUtils.preCheckCast(r4, XmlObject.class, "com.obric.memorydata.plugin");
    L11:
        boolean r0 = preCheck();
        boolean r1 = r7.preCheck();
        if (monitor() != r7.monitor()) goto L23;
        if (r0 == false) goto L15;
    L14:
        r4 = setterHelper(r7);
        goto L55
    L15:
        Object r2 = monitor();
        monitor-enter(r2);
        TypeStoreUser r8 = setterHelper(r7);     // Catch: Throwable -> L20
        monitor-exit(r2);     // Catch: Throwable -> L20
        r4 = r8;
    L20:
        th = move-exception;
        throw th;
    L23:
        if (r0 == false) goto L34;
        if (r1 == true) goto L14;
        Object r3 = r7.monitor();
        monitor-enter(r3);
        TypeStoreUser r9 = setterHelper(r7);     // Catch: Throwable -> L31
        monitor-exit(r3);     // Catch: Throwable -> L31
        r4 = r9;
    L31:
        th = move-exception;
        throw th;
    L34:
        if (r1 == false) goto L43;
        Object r10 = monitor();
        monitor-enter(r10);
        TypeStoreUser r11 = setterHelper(r7);     // Catch: Throwable -> L40
        monitor-exit(r10);     // Catch: Throwable -> L40
        r4 = r11;
    L40:
        th = move-exception;
        throw th;
    L43:
        boolean r12 = false;
        GlobalLock.acquire();     // Catch: Throwable -> L72 InterruptedException -> L74
        Object r13 = monitor();     // Catch: Throwable -> L68 InterruptedException -> L70
        monitor-enter(r13);     // Catch: Throwable -> L68 InterruptedException -> L70
        Object r14 = r7.monitor();     // Catch: Throwable -> L62
        monitor-enter(r14);     // Catch: Throwable -> L62
        GlobalLock.release();     // Catch: Throwable -> L58
        r4 = setterHelper(r7);     // Catch: Throwable -> L56
        monitor-exit(r14);     // Catch: Throwable -> L56
        monitor-exit(r13);     // Catch: Throwable -> L66
    L58:
        th = th;
    L60:
        monitor-exit(r14);     // Catch: Throwable -> L56
        throw th;     // Catch: Throwable -> L66
    L56:
        th = th;
    L62:
        th = th;
    L64:
        monitor-exit(r13);     // Catch: Throwable -> L66
        throw th;     // Catch: Throwable -> L72 InterruptedException -> L74
    L66:
        th = th;
    L70:
        e = e;
    L76:
        throw new XmlRuntimeException(e);     // Catch: Throwable -> L72
    L68:
        th = th;
        r12 = true;
    L77:
        if (r12 == false) goto L79;
        GlobalLock.release();
    L79:
        throw th;
    L72:
        th = th;
    L74:
        e = e;
        goto L76
    L81:
        throw new IllegalStateException("Cannot set the value of an immutable XmlObject");
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public final void setBigDecimalValue(BigDecimal r2) {
        if (r2 != null) goto L4;
        setNil();
        return;
    L4:
        Object r0 = monitor();
        monitor-enter(r0);
        set_prepare();     // Catch: Throwable -> L9
        set_BigDecimal(r2);     // Catch: Throwable -> L9
        set_commit();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public final void setBigIntegerValue(BigInteger r2) {
        if (r2 != null) goto L4;
        setNil();
        return;
    L4:
        Object r0 = monitor();
        monitor-enter(r0);
        set_prepare();     // Catch: Throwable -> L9
        set_BigInteger(r2);     // Catch: Throwable -> L9
        set_commit();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public final void setBooleanValue(boolean r2) {
        Object r0 = monitor();
        monitor-enter(r0);
        set_prepare();     // Catch: Throwable -> L7
        set_boolean(r2);     // Catch: Throwable -> L7
        set_commit();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public final void setByteArrayValue(byte[] r2) {
        if (r2 != null) goto L4;
        setNil();
        return;
    L4:
        Object r0 = monitor();
        monitor-enter(r0);
        set_prepare();     // Catch: Throwable -> L9
        set_ByteArray(r2);     // Catch: Throwable -> L9
        set_commit();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public final void setByteValue(byte r2) {
        Object r0 = monitor();
        monitor-enter(r0);
        set_prepare();     // Catch: Throwable -> L7
        set_byte(r2);     // Catch: Throwable -> L7
        set_commit();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public final void setCalendarValue(Calendar r2) {
        if (r2 != null) goto L4;
        setNil();
        return;
    L4:
        Object r0 = monitor();
        monitor-enter(r0);
        set_prepare();     // Catch: Throwable -> L9
        set_Calendar(r2);     // Catch: Throwable -> L9
        set_commit();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public final void setDateValue(Date r2) {
        if (r2 != null) goto L4;
        setNil();
        return;
    L4:
        Object r0 = monitor();
        monitor-enter(r0);
        set_prepare();     // Catch: Throwable -> L9
        set_Date(r2);     // Catch: Throwable -> L9
        set_commit();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public final void setDoubleValue(double r2) {
        Object r0 = monitor();
        monitor-enter(r0);
        set_prepare();     // Catch: Throwable -> L7
        set_double(r2);     // Catch: Throwable -> L7
        set_commit();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public final void setEnumValue(StringEnumAbstractBase r2) {
        if (r2 != null) goto L4;
        setNil();
        return;
    L4:
        Object r0 = monitor();
        monitor-enter(r0);
        set_prepare();     // Catch: Throwable -> L9
        set_enum(r2);     // Catch: Throwable -> L9
        set_commit();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public final void setFloatValue(float r2) {
        Object r0 = monitor();
        monitor-enter(r0);
        set_prepare();     // Catch: Throwable -> L7
        set_float(r2);     // Catch: Throwable -> L7
        set_commit();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final void setGDateValue(GDate r2) {
        if (r2 != null) goto L4;
        setNil();
        return;
    L4:
        Object r0 = monitor();
        monitor-enter(r0);
        set_prepare();     // Catch: Throwable -> L9
        set_GDate(r2);     // Catch: Throwable -> L9
        set_commit();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public final void setGDateValue(GDateSpecification r3) {
        GDateSpecification r4 = (GDateSpecification) ZeusTransformUtils.wrapperContextForParams(r3, GDateSpecification.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L5;
        setNil();
        return;
    L5:
        Object r0 = monitor();
        monitor-enter(r0);
        set_prepare();     // Catch: Throwable -> L10
        set_GDate(r4);     // Catch: Throwable -> L10
        set_commit();     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public final void setGDurationValue(GDuration r2) {
        if (r2 != null) goto L4;
        setNil();
        return;
    L4:
        Object r0 = monitor();
        monitor-enter(r0);
        set_prepare();     // Catch: Throwable -> L9
        set_GDuration(r2);     // Catch: Throwable -> L9
        set_commit();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public final void setGDurationValue(GDurationSpecification r3) {
        GDurationSpecification r4 = (GDurationSpecification) ZeusTransformUtils.wrapperContextForParams(r3, GDurationSpecification.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L5;
        setNil();
        return;
    L5:
        Object r0 = monitor();
        monitor-enter(r0);
        set_prepare();     // Catch: Throwable -> L10
        set_GDuration(r4);     // Catch: Throwable -> L10
        set_commit();     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public void setImmutable() {
        int r0 = this._flags;
        if ((r0 & 4112) != 0) goto L7;
        this._flags = r0 | 4096;
        return;
    L7:
        throw new IllegalStateException();
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public final void setIntValue(int r2) {
        Object r0 = monitor();
        monitor-enter(r0);
        set_prepare();     // Catch: Throwable -> L7
        set_int(r2);     // Catch: Throwable -> L7
        set_commit();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public final void setListValue(List<?> r3) {
        List<?> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L5;
        setNil();
        return;
    L5:
        Object r0 = monitor();
        monitor-enter(r0);
        set_prepare();     // Catch: Throwable -> L10
        set_list(r4);     // Catch: Throwable -> L10
        set_commit();     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public final void setLongValue(long r2) {
        Object r0 = monitor();
        monitor-enter(r0);
        set_prepare();     // Catch: Throwable -> L7
        set_long(r2);     // Catch: Throwable -> L7
        set_commit();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final void setNil() {
        Object r0 = monitor();
        monitor-enter(r0);
        set_prepare();     // Catch: Throwable -> L17
        int r1 = this._flags;     // Catch: Throwable -> L17
        if ((r1 & 1) == 0) goto L7;
    L11:
        set_nil();     // Catch: Throwable -> L17
        int r2 = this._flags | 64;     // Catch: Throwable -> L17
        this._flags = r2;     // Catch: Throwable -> L17
        if ((r2 & 16) == 0) goto L14;
        get_store().invalidate_text();     // Catch: Throwable -> L17
        this._flags &= -673;     // Catch: Throwable -> L17
        get_store().invalidate_nil();     // Catch: Throwable -> L17
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L17
        return;
    L14:
        this._textsource = null;     // Catch: Throwable -> L17
        goto L15
    L7:
        if ((r1 & 65536) == 0) goto L11;
        throw new XmlValueNotNillableException();     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public void setObjectValue(Object r4) {
        if (r4 != null) goto L7;
        setNil();
        return;
    L7:
        if (ZeusTransformUtils.instanceOf(r4, XmlObject.class) == false) goto L10;
        set((XmlObject) ZeusTransformUtils.preCheckCast(r4, XmlObject.class, "com.obric.memorydata.plugin"));
        return;
    L10:
        if (ZeusTransformUtils.instanceOf(r4, String.class) == false) goto L13;
        setStringValue((String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.memorydata.plugin"));
        return;
    L13:
        if (ZeusTransformUtils.instanceOf(r4, StringEnumAbstractBase.class) == false) goto L16;
        setEnumValue((StringEnumAbstractBase) ZeusTransformUtils.preCheckCast(r4, StringEnumAbstractBase.class, "com.obric.memorydata.plugin"));
        return;
    L16:
        if (ZeusTransformUtils.instanceOf(r4, BigInteger.class) == false) goto L19;
        setBigIntegerValue((BigInteger) ZeusTransformUtils.preCheckCast(r4, BigInteger.class, "com.obric.memorydata.plugin"));
        return;
    L19:
        if (ZeusTransformUtils.instanceOf(r4, BigDecimal.class) == false) goto L22;
        setBigDecimalValue((BigDecimal) ZeusTransformUtils.preCheckCast(r4, BigDecimal.class, "com.obric.memorydata.plugin"));
        return;
    L22:
        if (ZeusTransformUtils.instanceOf(r4, Byte.class) == false) goto L25;
        setByteValue(((Byte) ZeusTransformUtils.preCheckCast(r4, Byte.class, "com.obric.memorydata.plugin")).byteValue());
        return;
    L25:
        if (ZeusTransformUtils.instanceOf(r4, Short.class) == false) goto L28;
        setShortValue(((Short) ZeusTransformUtils.preCheckCast(r4, Short.class, "com.obric.memorydata.plugin")).shortValue());
        return;
    L28:
        if (ZeusTransformUtils.instanceOf(r4, Integer.class) == false) goto L31;
        setIntValue(((Integer) ZeusTransformUtils.preCheckCast(r4, Integer.class, "com.obric.memorydata.plugin")).intValue());
        return;
    L31:
        if (ZeusTransformUtils.instanceOf(r4, Long.class) == false) goto L34;
        setLongValue(((Long) ZeusTransformUtils.preCheckCast(r4, Long.class, "com.obric.memorydata.plugin")).longValue());
        return;
    L34:
        if (ZeusTransformUtils.instanceOf(r4, Boolean.class) == false) goto L37;
        setBooleanValue(((Boolean) ZeusTransformUtils.preCheckCast(r4, Boolean.class, "com.obric.memorydata.plugin")).booleanValue());
        return;
    L37:
        if (ZeusTransformUtils.instanceOf(r4, Float.class) == false) goto L40;
        setFloatValue(((Float) ZeusTransformUtils.preCheckCast(r4, Float.class, "com.obric.memorydata.plugin")).floatValue());
        return;
    L40:
        if (ZeusTransformUtils.instanceOf(r4, Double.class) == false) goto L43;
        setDoubleValue(((Double) ZeusTransformUtils.preCheckCast(r4, Double.class, "com.obric.memorydata.plugin")).doubleValue());
        return;
    L43:
        if (ZeusTransformUtils.instanceOf(r4, Calendar.class) == false) goto L46;
        setCalendarValue((Calendar) ZeusTransformUtils.preCheckCast(r4, Calendar.class, "com.obric.memorydata.plugin"));
        return;
    L46:
        if (ZeusTransformUtils.instanceOf(r4, Date.class) == false) goto L49;
        setDateValue((Date) ZeusTransformUtils.preCheckCast(r4, Date.class, "com.obric.memorydata.plugin"));
        return;
    L49:
        if (ZeusTransformUtils.instanceOf(r4, GDateSpecification.class) == false) goto L52;
        setGDateValue((GDateSpecification) ZeusTransformUtils.preCheckCast(r4, GDateSpecification.class, "com.obric.memorydata.plugin"));
        return;
    L52:
        if (ZeusTransformUtils.instanceOf(r4, GDurationSpecification.class) == false) goto L55;
        setGDurationValue((GDurationSpecification) ZeusTransformUtils.preCheckCast(r4, GDurationSpecification.class, "com.obric.memorydata.plugin"));
        return;
    L55:
        if (ZeusTransformUtils.instanceOf(r4, QName.class) == false) goto L58;
        setQNameValue((QName) ZeusTransformUtils.preCheckCast(r4, QName.class, "com.obric.memorydata.plugin"));
        return;
    L58:
        if (ZeusTransformUtils.instanceOf(r4, List.class) == false) goto L61;
        setListValue((List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.memorydata.plugin"));
        return;
    L61:
        if ((r4 instanceof byte[]) == false) goto L65;
        setByteArrayValue((byte[]) ZeusTransformUtils.preCheckCast((byte[]) ZeusTransformUtils.preCheckCast(r4, byte[].class, "com.obric.memorydata.plugin"), byte[].class, "com.obric.memorydata.plugin"));
        return;
    L65:
        throw new XmlValueNotSupportedException("Can't set union object of class : " + r4.getClass().getName());
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public final void setQNameValue(QName r2) {
        if (r2 != null) goto L4;
        setNil();
        return;
    L4:
        Object r0 = monitor();
        monitor-enter(r0);
        set_prepare();     // Catch: Throwable -> L9
        set_QName(r2);     // Catch: Throwable -> L9
        set_commit();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public final void setShortValue(short r2) {
        Object r0 = monitor();
        monitor-enter(r0);
        set_prepare();     // Catch: Throwable -> L7
        set_short(r2);     // Catch: Throwable -> L7
        set_commit();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public final void setStringValue(String r2) {
        if (r2 != null) goto L4;
        setNil();
        return;
    L4:
        Object r0 = monitor();
        monitor-enter(r0);
        set_prepare();     // Catch: Throwable -> L9
        set_String(r2);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public void setValidateOnSet() {
        this._flags |= 65536;
    }

    public void set_BigDecimal(BigDecimal r4) {
        throw new XmlValueNotSupportedException("exception.value.not.supported.j2s", new Object[]{"numeric", getPrimitiveTypeName()});
    }

    public void set_BigInteger(BigInteger r2) {
        set_BigDecimal(new BigDecimal(r2));
    }

    public void set_ByteArray(byte[] r4) {
        throw new XmlValueNotSupportedException("exception.value.not.supported.j2s", new Object[]{"byte[]", getPrimitiveTypeName()});
    }

    public void set_Calendar(Calendar r4) {
        throw new XmlValueNotSupportedException("exception.value.not.supported.j2s", new Object[]{"Calendar", getPrimitiveTypeName()});
    }

    public void set_ComplexXml(XmlObject r4) {
        XmlObject r5 = (XmlObject) ZeusTransformUtils.wrapperContextForParams(r4, XmlObject.class, "com.obric.memorydata.plugin");
        throw new XmlValueNotSupportedException("exception.value.not.supported.j2s", new Object[]{"complex content", getPrimitiveTypeName()});
    }

    public void set_Date(Date r4) {
        throw new XmlValueNotSupportedException("exception.value.not.supported.j2s", new Object[]{"Date", getPrimitiveTypeName()});
    }

    public void set_GDate(GDateSpecification r4) {
        GDateSpecification r5 = (GDateSpecification) ZeusTransformUtils.wrapperContextForParams(r4, GDateSpecification.class, "com.obric.memorydata.plugin");
        throw new XmlValueNotSupportedException("exception.value.not.supported.j2s", new Object[]{"Date", getPrimitiveTypeName()});
    }

    public void set_GDuration(GDurationSpecification r4) {
        GDurationSpecification r5 = (GDurationSpecification) ZeusTransformUtils.wrapperContextForParams(r4, GDurationSpecification.class, "com.obric.memorydata.plugin");
        throw new XmlValueNotSupportedException("exception.value.not.supported.j2s", new Object[]{"Duration", getPrimitiveTypeName()});
    }

    public void set_QName(QName r4) {
        throw new XmlValueNotSupportedException("exception.value.not.supported.j2s", new Object[]{"QName", getPrimitiveTypeName()});
    }

    public void set_String(String r4) {
        int r0 = this._flags;
        if ((r0 & 4096) != 0) goto L18;
        if ((r0 & 64) == 0) goto L7;
        boolean r1 = true;
    L8:
        update_from_wscanon_text(apply_wscanon(r4));
        int r2 = this._flags;
        if ((r2 & 16) == 0) goto L15;
        int r3 = r2 & (-33);
        this._flags = r3;
        if ((r3 & 1024) != 0) goto L13;
        get_store().store_text(r4);
    L13:
        if (r1 == false) goto L19;
        get_store().invalidate_nil();
        return;
    L19:
        return;
    L15:
        this._textsource = r4;
        return;
    L7:
        r1 = false;
        goto L8
    L18:
        throw new IllegalStateException();
    }

    public void set_b64(byte[] r1) {
        set_ByteArray(r1);
    }

    public void set_boolean(boolean r4) {
        throw new XmlValueNotSupportedException("exception.value.not.supported.j2s", new Object[]{TypedValues.Custom.S_BOOLEAN, getPrimitiveTypeName()});
    }

    public void set_byte(byte r1) {
        set_int(r1);
    }

    public void set_char(char r1) {
        set_String(Character.toString(r1));
    }

    public void set_double(double r2) {
        set_BigDecimal(new BigDecimal(r2));
    }

    public void set_enum(StringEnumAbstractBase r4) {
        throw new XmlValueNotSupportedException("exception.value.not.supported.j2s", new Object[]{"enum", getPrimitiveTypeName()});
    }

    public void set_float(float r4) {
        set_BigDecimal(new BigDecimal(r4));
    }

    public void set_hex(byte[] r1) {
        set_ByteArray(r1);
    }

    public void set_int(int r3) {
        set_long(r3);
    }

    public void set_list(List<?> r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        throw new XmlValueNotSupportedException("exception.value.not.supported.j2s", new Object[]{e.f16168a, getPrimitiveTypeName()});
    }

    public void set_long(long r1) {
        set_BigInteger(BigInteger.valueOf(r1));
    }

    public final void set_newValue(XmlObject r5) {
        XmlObject r6 = (XmlObject) ZeusTransformUtils.wrapperContextForParams(r5, XmlObject.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L5;
    L71:
        setNil();
        return;
    L5:
        if (r6.isNil() == true) goto L71;
        if (ZeusTransformUtils.instanceOf(r6, XmlAnySimpleType.class) == false) goto L70;
        XmlAnySimpleType r7 = (XmlAnySimpleType) ZeusTransformUtils.preCheckCast(r6, XmlAnySimpleType.class, "com.obric.memorydata.plugin");
        SchemaType r0 = ((SimpleValue) ZeusTransformUtils.preCheckCast(r7, SimpleValue.class, "com.obric.memorydata.plugin")).instanceType();
        if (r0.getSimpleVariety() != 3) goto L19;
        Object r1 = monitor();
        monitor-enter(r1);
        set_prepare();     // Catch: Throwable -> L16
        set_list(((SimpleValue) ZeusTransformUtils.preCheckCast(r7, SimpleValue.class, "com.obric.memorydata.plugin")).xgetListValue());     // Catch: Throwable -> L16
        set_commit();     // Catch: Throwable -> L16
        monitor-exit(r1);     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        throw th;
    L19:
        Object r2 = monitor();
        monitor-enter(r2);
    L67:
        th = move-exception;
        throw th;
    L22:
        switch(r0.getPrimitiveType().getBuiltinTypeCode()) {
            case 2: goto L50;
            case 3: goto L49;
            case 4: goto L48;
            case 5: goto L47;
            case 6: goto L46;
            case 7: goto L45;
            case 8: goto L44;
            case 9: goto L43;
            case 10: goto L42;
            case 11: goto L27;
            case 12: goto L26;
            case 13: goto L25;
            case 14: goto L24;
            case 15: goto L24;
            case 16: goto L24;
            case 17: goto L24;
            case 18: goto L24;
            case 19: goto L24;
            case 20: goto L24;
            case 21: goto L24;
            default: goto L63;
        };     // Catch: Throwable -> L67
    L24:
        GDate r8 = ((SimpleValue) ZeusTransformUtils.preCheckCast(r7, SimpleValue.class, "com.obric.memorydata.plugin")).getGDateValue();     // Catch: Throwable -> L67
        set_prepare();     // Catch: Throwable -> L67
        set_GDate(r8);     // Catch: Throwable -> L67
    L56:
        set_commit();     // Catch: Throwable -> L67
        monitor-exit(r2);     // Catch: Throwable -> L67
        return;
    L25:
        GDuration r9 = ((SimpleValue) ZeusTransformUtils.preCheckCast(r7, SimpleValue.class, "com.obric.memorydata.plugin")).getGDurationValue();     // Catch: Throwable -> L67
        set_prepare();     // Catch: Throwable -> L67
        set_GDuration(r9);     // Catch: Throwable -> L67
        goto L56
    L26:
        String r10 = r7.getStringValue();     // Catch: Throwable -> L67
        set_prepare();     // Catch: Throwable -> L67
        set_String(r10);     // Catch: Throwable -> L67
        goto L56
    L27:
        int r3 = r0.getDecimalSize();     // Catch: Throwable -> L67
        if (r3 != 8) goto L30;
        byte r11 = ((SimpleValue) ZeusTransformUtils.preCheckCast(r7, SimpleValue.class, "com.obric.memorydata.plugin")).getByteValue();     // Catch: Throwable -> L67
        set_prepare();     // Catch: Throwable -> L67
        set_byte(r11);     // Catch: Throwable -> L67
        goto L56
    L30:
        if (r3 != 16) goto L32;
        short r12 = ((SimpleValue) ZeusTransformUtils.preCheckCast(r7, SimpleValue.class, "com.obric.memorydata.plugin")).getShortValue();     // Catch: Throwable -> L67
        set_prepare();     // Catch: Throwable -> L67
        set_short(r12);     // Catch: Throwable -> L67
        goto L56
    L32:
        if (r3 != 32) goto L34;
        int r13 = ((SimpleValue) ZeusTransformUtils.preCheckCast(r7, SimpleValue.class, "com.obric.memorydata.plugin")).getIntValue();     // Catch: Throwable -> L67
        set_prepare();     // Catch: Throwable -> L67
        set_int(r13);     // Catch: Throwable -> L67
        goto L56
    L34:
        if (r3 == 64) goto L38;
        switch(r3) {
            case 1000000: goto L37;
            case 1000001: goto L36;
            default: goto L36;
        };     // Catch: Throwable -> L67
    L36:
        BigDecimal r14 = ((SimpleValue) ZeusTransformUtils.preCheckCast(r7, SimpleValue.class, "com.obric.memorydata.plugin")).getBigDecimalValue();     // Catch: Throwable -> L67
        set_prepare();     // Catch: Throwable -> L67
        set_BigDecimal(r14);     // Catch: Throwable -> L67
        goto L56
    L37:
        BigInteger r15 = ((SimpleValue) ZeusTransformUtils.preCheckCast(r7, SimpleValue.class, "com.obric.memorydata.plugin")).getBigIntegerValue();     // Catch: Throwable -> L67
        set_prepare();     // Catch: Throwable -> L67
        set_BigInteger(r15);     // Catch: Throwable -> L67
        goto L56
    L38:
        long r4 = ((SimpleValue) ZeusTransformUtils.preCheckCast(r7, SimpleValue.class, "com.obric.memorydata.plugin")).getLongValue();     // Catch: Throwable -> L67
        set_prepare();     // Catch: Throwable -> L67
        set_long(r4);     // Catch: Throwable -> L67
        goto L56
    L42:
        double r16 = ((SimpleValue) ZeusTransformUtils.preCheckCast(r7, SimpleValue.class, "com.obric.memorydata.plugin")).getDoubleValue();     // Catch: Throwable -> L67
        set_prepare();     // Catch: Throwable -> L67
        set_double(r16);     // Catch: Throwable -> L67
        goto L56
    L43:
        float r17 = ((SimpleValue) ZeusTransformUtils.preCheckCast(r7, SimpleValue.class, "com.obric.memorydata.plugin")).getFloatValue();     // Catch: Throwable -> L67
        set_prepare();     // Catch: Throwable -> L67
        set_float(r17);     // Catch: Throwable -> L67
        goto L56
    L44:
        String r18 = r7.getStringValue();     // Catch: Throwable -> L67
        set_prepare();     // Catch: Throwable -> L67
        set_notation(r18);     // Catch: Throwable -> L67
        goto L56
    L45:
        QName r19 = ((SimpleValue) ZeusTransformUtils.preCheckCast(r7, SimpleValue.class, "com.obric.memorydata.plugin")).getQNameValue();     // Catch: Throwable -> L67
        set_prepare();     // Catch: Throwable -> L67
        set_QName(r19);     // Catch: Throwable -> L67
        goto L56
    L46:
        String r20 = r7.getStringValue();     // Catch: Throwable -> L67
        set_prepare();     // Catch: Throwable -> L67
        set_text(r20);     // Catch: Throwable -> L67
        goto L56
    L47:
        byte[] r21 = ((SimpleValue) ZeusTransformUtils.preCheckCast(r7, SimpleValue.class, "com.obric.memorydata.plugin")).getByteArrayValue();     // Catch: Throwable -> L67
        set_prepare();     // Catch: Throwable -> L67
        set_hex(r21);     // Catch: Throwable -> L67
        goto L56
    L48:
        byte[] r22 = ((SimpleValue) ZeusTransformUtils.preCheckCast(r7, SimpleValue.class, "com.obric.memorydata.plugin")).getByteArrayValue();     // Catch: Throwable -> L67
        set_prepare();     // Catch: Throwable -> L67
        set_b64(r22);     // Catch: Throwable -> L67
        goto L56
    L49:
        boolean r23 = ((SimpleValue) ZeusTransformUtils.preCheckCast(r7, SimpleValue.class, "com.obric.memorydata.plugin")).getBooleanValue();     // Catch: Throwable -> L67
        set_prepare();     // Catch: Throwable -> L67
        set_boolean(r23);     // Catch: Throwable -> L67
        goto L56
    L50:
        boolean r24 = false;
        if (r7.isImmutable() == true) goto L74;
        r24 = true;
        NamespaceContext.push(new NamespaceContext(r7));     // Catch: Throwable -> L67
    L74:
        set_prepare();     // Catch: Throwable -> L59
        set_xmlanysimple(r7);     // Catch: Throwable -> L59
        if (r24 == false) goto L56;
        NamespaceContext.pop();     // Catch: Throwable -> L67
        goto L56
    L59:
        th = move-exception;
        if (r24 == false) goto L62;
        NamespaceContext.pop();     // Catch: Throwable -> L67
    L62:
        throw th;     // Catch: Throwable -> L67
    L63:
        monitor-exit(r2);     // Catch: Throwable -> L67
    L70:
        throw new IllegalStateException("Complex type unexpected");
    }

    public abstract void set_nil();

    public void set_notation(String r1) {
        throw new XmlValueNotSupportedException();
    }

    public void set_short(short r1) {
        set_int(r1);
    }

    public abstract void set_text(String r1);

    public void set_xmlanysimple(XmlAnySimpleType r3) {
        set_String(((XmlAnySimpleType) ZeusTransformUtils.wrapperContextForParams(r3, XmlAnySimpleType.class, "com.obric.memorydata.plugin")).getStringValue());
    }

    public XmlObject substitute(QName r3, SchemaType r4) {
        SchemaType r5 = (SchemaType) ZeusTransformUtils.wrapperContextForParams(r4, SchemaType.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L20;
        if (r5 == null) goto L18;
        if ((this._flags & 16) == 0) goto L16;
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L12
        XmlObject r2 = (XmlObject) ZeusTransformUtils.preCheckCast(get_store().substitute(r3, r5), XmlObject.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r2;
    L12:
        th = move-exception;
        throw th;
    L16:
        throw new IllegalStateException("XML Value Objects cannot be used with substitution");
    L18:
        throw new IllegalArgumentException("Invalid type (null)");
    L20:
        throw new IllegalArgumentException("Invalid name (null)");
    }

    @Override // org.apache.xmlbeans.XmlObject
    public final String toString() {
        Object r0 = monitor();
        monitor-enter(r0);
        String r2 = ensureStore().xmlText(_toStringOptions);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r2;
    L7:
        th = move-exception;
        throw th;
    }

    public void update_from_complex_content() {
        throw new XmlValueNotSupportedException("Complex content");
    }

    public final boolean uses_invalidate_value() {
        SchemaType r1 = schemaType();
        if (r1.isSimpleType() == false) goto L5;
    L8:
        return true;
    L5:
        if (r1.getContentType() == 2) goto L8;
        return false;
    }

    public boolean validate() {
        return validate(null);
    }

    public boolean validate(XmlOptions r9) {
        int r0 = this._flags;
        if ((r0 & 16) == 0) goto L5;
        Object r1 = monitor();
        monitor-enter(r1);
    L19:
        th = move-exception;
        throw th;
    L13:
        if ((this._flags & 2048) != 0) goto L18;
        SchemaField r4 = schemaField();     // Catch: Throwable -> L19
        SchemaType r3 = schemaType();     // Catch: Throwable -> L19
        TypeStore r8 = get_store();     // Catch: Throwable -> L19
        Validator r2 = new Validator(r3, r4, r8.get_schematypeloader(), r9, null);     // Catch: Throwable -> L19
        r8.validate(r2);     // Catch: Throwable -> L19
        boolean r10 = r2.isValid();     // Catch: Throwable -> L19
        monitor-exit(r1);     // Catch: Throwable -> L19
        return r10;
    L18:
        throw new XmlValueDisconnectedException();     // Catch: Throwable -> L19
    L5:
        if ((r0 & 4096) == 0) goto L9;
        return validate_immutable(r9);
    L9:
        throw new IllegalStateException("XML objects with no underlying store cannot be validated");
    }

    public void validate_now() {
        check_dated();
    }

    public void validate_simpleval(String r1, ValidationContext r2) {
        ValidationContext r0 = (ValidationContext) ZeusTransformUtils.wrapperContextForParams(r2, ValidationContext.class, "com.obric.memorydata.plugin");
    }

    @Override // org.apache.xmlbeans.XmlObject
    public final boolean valueEquals(XmlObject r5) {
        XmlObject r6 = (XmlObject) ZeusTransformUtils.wrapperContextForParams(r5, XmlObject.class, "com.obric.memorydata.plugin");
        boolean r0 = false;
    L59:
        e = e;
    L61:
        throw new XmlRuntimeException(e);     // Catch: Throwable -> L57
    L4:
        if (isImmutable() == false) goto L18;
        if (r6.isImmutable() == true) goto L8;
        Object r1 = r6.monitor();     // Catch: Throwable -> L57 InterruptedException -> L59
        monitor-enter(r1);     // Catch: Throwable -> L57 InterruptedException -> L59
        boolean r4 = valueEqualsImpl(r6);     // Catch: Throwable -> L14
        monitor-exit(r1);     // Catch: Throwable -> L14
        return r4;
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L57 InterruptedException -> L59
    L8:
        return valueEqualsImpl(r6);
    L18:
        if (r6.isImmutable() == false) goto L20;
    L49:
        Object r2 = monitor();     // Catch: Throwable -> L57 InterruptedException -> L59
        monitor-enter(r2);     // Catch: Throwable -> L57 InterruptedException -> L59
        boolean r7 = valueEqualsImpl(r6);     // Catch: Throwable -> L54
        monitor-exit(r2);     // Catch: Throwable -> L54
        return r7;
    L54:
        th = move-exception;
        throw th;     // Catch: Throwable -> L57 InterruptedException -> L59
    L20:
        if (monitor() == r6.monitor()) goto L49;
        GlobalLock.acquire();     // Catch: Throwable -> L57 InterruptedException -> L59
        Object r3 = monitor();     // Catch: Throwable -> L45 InterruptedException -> L47
        monitor-enter(r3);     // Catch: Throwable -> L45 InterruptedException -> L47
        Object r8 = r6.monitor();     // Catch: Throwable -> L39
        monitor-enter(r8);     // Catch: Throwable -> L39
        GlobalLock.release();     // Catch: Throwable -> L35
        boolean r9 = valueEqualsImpl(r6);     // Catch: Throwable -> L33
        monitor-exit(r8);     // Catch: Throwable -> L33
        monitor-exit(r3);     // Catch: Throwable -> L43
        return r9;
    L35:
        th = th;
    L37:
        monitor-exit(r8);     // Catch: Throwable -> L33
        throw th;     // Catch: Throwable -> L43
    L33:
        th = th;
    L39:
        th = th;
    L41:
        monitor-exit(r3);     // Catch: Throwable -> L43
        throw th;     // Catch: Throwable -> L57 InterruptedException -> L59
    L43:
        th = th;
    L47:
        e = e;
    L45:
        th = th;
        r0 = true;
    L62:
        if (r0 == false) goto L64;
        GlobalLock.release();
    L64:
        throw th;
    L57:
        th = th;
        goto L62
    }

    @Override // org.apache.xmlbeans.XmlObject
    public int valueHashCode() {
        Object r0 = monitor();
        monitor-enter(r0);
        int r1 = value_hash_code();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public abstract int value_hash_code();

    public Object writeReplace() {
        Object r0 = monitor();
        monitor-enter(r0);
        AnonymousClass1 r2 = null;
        if (isRootXmlObject() == false) goto L9;
        SerializedRootObject r1 = new SerializedRootObject(this, r2);     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r1;
    L9:
        SerializedInteriorObject r3 = new SerializedInteriorObject(this, getRootXmlObject(), r2);     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r3;
    L12:
        th = move-exception;
        throw th;
    }

    public <T extends XmlObject> T[] xgetArray(QName r3, IntFunction<T[]> r4) {
        IntFunction<A[]> r5 = (IntFunction) ZeusTransformUtils.wrapperContextForParams(r4, IntFunction.class, "com.obric.memorydata.plugin");
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ArrayList r1 = new ArrayList();     // Catch: Throwable -> L7
        get_store().find_all_element_users(r3, r1);     // Catch: Throwable -> L7
        T[] r2 = (T[]) ((XmlObject[]) ZeusTransformUtils.preCheckCast(r1.stream().toArray(r5), XmlObject[].class, "com.obric.memorydata.plugin"));
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r2;
    L7:
        th = move-exception;
        throw th;
    }

    public <T extends XmlObject> T[] xgetArray(QNameSet r3, IntFunction<T[]> r4) {
        IntFunction<A[]> r5 = (IntFunction) ZeusTransformUtils.wrapperContextForParams(r4, IntFunction.class, "com.obric.memorydata.plugin");
        Object r0 = monitor();
        monitor-enter(r0);
        check_orphaned();     // Catch: Throwable -> L7
        ArrayList r1 = new ArrayList();     // Catch: Throwable -> L7
        get_store().find_all_element_users(r3, r1);     // Catch: Throwable -> L7
        T[] r2 = (T[]) ((XmlObject[]) ZeusTransformUtils.preCheckCast(r1.stream().toArray(r5), XmlObject[].class, "com.obric.memorydata.plugin"));
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r2;
    L7:
        th = move-exception;
        throw th;
    }

    public List<? extends XmlAnySimpleType> xgetListValue() {
        throw new XmlValueNotSupportedException("exception.value.not.supported.s2j", new Object[]{getPrimitiveTypeName(), e.f16168a});
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public String xmlText() {
        return xmlText(null);
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public String xmlText(XmlOptions r2) {
        XmlCursor r1 = newCursorForce();
        String r3 = r1.xmlText(makeInnerOptions(r2));     // Catch: Throwable -> L7
        if (r1 == null) goto L6;
        r1.close();
    L6:
        return r3;
    L7:
        th = move-exception;
        throw th;     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        if (r1 != null) goto L20;
    L15:
        throw th;
    L20:
        r1.close();     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        th.addSuppressed(th);
        goto L15
    }
}
