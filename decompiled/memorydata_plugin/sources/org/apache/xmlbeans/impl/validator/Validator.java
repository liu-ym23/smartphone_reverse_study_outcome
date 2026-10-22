package org.apache.xmlbeans.impl.validator;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm6.consumer.slardar.Constants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.GDate;
import org.apache.xmlbeans.GDuration;
import org.apache.xmlbeans.SchemaAttributeModel;
import org.apache.xmlbeans.SchemaField;
import org.apache.xmlbeans.SchemaGlobalAttribute;
import org.apache.xmlbeans.SchemaLocalAttribute;
import org.apache.xmlbeans.SchemaLocalElement;
import org.apache.xmlbeans.SchemaParticle;
import org.apache.xmlbeans.SchemaProperty;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SchemaTypeLoader;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlError;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlQName;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.XmlValidationError;
import org.apache.xmlbeans.impl.common.IdentityConstraint;
import org.apache.xmlbeans.impl.common.InvalidLexicalValueException;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.common.ValidationContext;
import org.apache.xmlbeans.impl.common.ValidatorListener;
import org.apache.xmlbeans.impl.common.XmlWhitespace;
import org.apache.xmlbeans.impl.schema.SchemaTypeImpl;
import org.apache.xmlbeans.impl.schema.SchemaTypeVisitorImpl;
import org.apache.xmlbeans.impl.util.XsTypeConverter;
import org.apache.xmlbeans.impl.values.JavaBase64HolderEx;
import org.apache.xmlbeans.impl.values.JavaBooleanHolderEx;
import org.apache.xmlbeans.impl.values.JavaDecimalHolderEx;
import org.apache.xmlbeans.impl.values.JavaDoubleHolderEx;
import org.apache.xmlbeans.impl.values.JavaFloatHolderEx;
import org.apache.xmlbeans.impl.values.JavaHexBinaryHolderEx;
import org.apache.xmlbeans.impl.values.JavaNotationHolderEx;
import org.apache.xmlbeans.impl.values.JavaQNameHolderEx;
import org.apache.xmlbeans.impl.values.JavaStringEnumerationHolderEx;
import org.apache.xmlbeans.impl.values.JavaUriHolderEx;
import org.apache.xmlbeans.impl.values.NamespaceContext;
import org.apache.xmlbeans.impl.values.TypeStoreVisitor;
import org.apache.xmlbeans.impl.values.XmlDateImpl;
import org.apache.xmlbeans.impl.values.XmlDurationImpl;
import org.apache.xmlbeans.impl.values.XmlListImpl;
import org.apache.xmlbeans.impl.values.XmlValueOutOfRangeException;

/* JADX INFO: loaded from: classes7.dex */
public final class Validator implements ValidatorListener {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private boolean _booleanValue;
    private byte[] _byteArrayValue;
    private final IdentityConstraint _constraintEngine;
    private BigDecimal _decimalValue;
    private double _doubleValue;
    private int _eatContent;
    private Collection<XmlError> _errorListener;
    private int _errorState;
    private float _floatValue;
    private GDate _gdateValue;
    private GDuration _gdurationValue;
    private final SchemaTypeLoader _globalTypes;
    private boolean _invalid;
    private List<SchemaType> _listTypes;
    private List<Object> _listValue;
    private SchemaLocalAttribute _localAttribute;
    private SchemaLocalElement _localElement;
    private QName _qnameValue;
    private final SchemaField _rootField;
    private final SchemaType _rootType;
    private State _stateStack;
    private final boolean _strict;
    private String _stringValue;
    private int _suspendErrors;
    private final boolean _treatLaxAsSkip;
    private SchemaType _unionType;
    private final ValidatorVC _vc;
    private final LinkedList<TypeStoreVisitor> _visitorPool;
    private SchemaAttributeModel _wildcardAttribute;
    private SchemaParticle _wildcardElement;

    /* JADX INFO: renamed from: org.apache.xmlbeans.impl.validator.Validator$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static final class State {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        SchemaAttributeModel _attrModel;
        HashSet<QName> _attrs;
        boolean _canHaveAttrs;
        boolean _canHaveElements;
        boolean _canHaveMixedContent;
        SchemaField _field;
        boolean _hasSimpleContent;
        boolean _isEmpty;
        boolean _isNil;
        State _next;
        boolean _sawText;
        SchemaType _type;
        SchemaTypeVisitorImpl _visitor;

        static {
        }

        private State() {
        }

        /* synthetic */ State(AnonymousClass1 r1) {
            this();
        }

        SchemaParticle currentParticle() {
            return this._visitor.currentParticle();
        }

        boolean end() {
            if (this._canHaveElements == true) goto L5;
        L8:
            return true;
        L5:
            if (this._visitor.visit(null) == true) goto L8;
            return false;
        }

        boolean test(QName r2) {
            if (this._canHaveElements == true) goto L5;
        L7:
            return false;
        L5:
            if (this._visitor.testValid(r2) == false) goto L7;
            return true;
        }

        boolean visit(QName r2) {
            if (this._canHaveElements == true) goto L5;
        L7:
            return false;
        L5:
            if (this._visitor.visit(r2) == false) goto L7;
            return true;
        }
    }

    private class ValidatorVC implements ValidationContext {
        ValidatorListener.Event _event;
        final /* synthetic */ Validator this$0;

        private ValidatorVC(Validator r1) {
            this.this$0 = r1;
        }

        /* synthetic */ ValidatorVC(Validator r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // org.apache.xmlbeans.impl.common.ValidationContext
        public void invalid(String r7) {
            Validator.access$100(this.this$0, this._event, r7, null, null, 1001);
        }

        @Override // org.apache.xmlbeans.impl.common.ValidationContext
        public void invalid(String r9, Object[] r10) {
            Validator.access$200(this.this$0, this._event, r9, r10, null, null, 1001, null);
        }
    }

    static {
    }

    public Validator(SchemaType r3, SchemaField r4, SchemaTypeLoader r5, XmlOptions r6, Collection<XmlError> r7) {
        SchemaType r8 = (SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin");
        SchemaField r9 = (SchemaField) ZeusTransformUtils.wrapperContextForParams(r4, SchemaField.class, "com.obric.memorydata.plugin");
        SchemaTypeLoader r10 = (SchemaTypeLoader) ZeusTransformUtils.wrapperContextForParams(r5, SchemaTypeLoader.class, "com.obric.memorydata.plugin");
        Collection<XmlError> r11 = (Collection) ZeusTransformUtils.wrapperContextForParams(r7, Collection.class, "com.obric.memorydata.plugin");
        this._visitorPool = new LinkedList();
        XmlOptions r12 = XmlOptions.maskNull(r6);
        this._errorListener = r12.getErrorListener();
        this._treatLaxAsSkip = r12.isValidateTreatLaxAsSkip();
        this._strict = r12.isValidateStrict();
        if (this._errorListener != null) goto L5;
        this._errorListener = r11;
    L5:
        this._constraintEngine = new IdentityConstraint(this._errorListener, r8.isDocumentType());
        this._globalTypes = r10;
        this._rootType = r8;
        this._rootField = r9;
        this._vc = new ValidatorVC(this, null);
    }

    static /* synthetic */ void access$100(Validator r8, ValidatorListener.Event r9, String r10, QName r11, SchemaType r12, int r13) {
        r8.emitError((ValidatorListener.Event) ZeusTransformUtils.wrapperContextForParams(r9, ValidatorListener.Event.class, "com.obric.memorydata.plugin"), r10, r11, (SchemaType) ZeusTransformUtils.wrapperContextForParams(r12, SchemaType.class, "com.obric.memorydata.plugin"), r13);
    }

    static /* synthetic */ void access$200(Validator r10, ValidatorListener.Event r11, String r12, Object[] r13, QName r14, SchemaType r15, int r16, SchemaType r17) {
        r10.emitError((ValidatorListener.Event) ZeusTransformUtils.wrapperContextForParams(r11, ValidatorListener.Event.class, "com.obric.memorydata.plugin"), r12, r13, r14, (SchemaType) ZeusTransformUtils.wrapperContextForParams(r15, SchemaType.class, "com.obric.memorydata.plugin"), r16, (SchemaType) ZeusTransformUtils.wrapperContextForParams(r17, SchemaType.class, "com.obric.memorydata.plugin"));
    }

    private void addToList(SchemaType r3) {
        SchemaType r4 = (SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin");
        if (r4.getSimpleVariety() == 1) goto L8;
        if (r4.getSimpleVariety() == 2) goto L8;
        return;
    L8:
        if (r4.getUnionMemberTypes().length > 0) goto L10;
    L12:
        this._listTypes.add(r4);
        if (r4.getPrimitiveType() != null) goto L17;
        this._listValue.add(null);
        return;
    L17:
        switch(r4.getPrimitiveType().getBuiltinTypeCode()) {
            case 2: goto L33;
            case 3: goto L28;
            case 4: goto L27;
            case 5: goto L27;
            case 6: goto L33;
            case 7: goto L26;
            case 8: goto L26;
            case 9: goto L25;
            case 10: goto L24;
            case 11: goto L23;
            case 12: goto L22;
            case 13: goto L21;
            case 14: goto L20;
            case 15: goto L20;
            case 16: goto L20;
            case 17: goto L20;
            case 18: goto L20;
            case 19: goto L20;
            case 20: goto L20;
            case 21: goto L20;
            default: goto L19;
        };
    L20:
        this._listValue.add(this._gdateValue);
        this._gdateValue = null;
        return;
    L21:
        this._listValue.add(this._gdurationValue);
        this._gdurationValue = null;
        return;
    L22:
        this._listValue.add(this._stringValue);
        this._stringValue = null;
        return;
    L23:
        this._listValue.add(this._decimalValue);
        this._decimalValue = null;
        return;
    L24:
        this._listValue.add(Double.valueOf(this._doubleValue));
        this._doubleValue = 0.0d;
        return;
    L25:
        this._listValue.add(Float.valueOf(this._floatValue));
        this._floatValue = 0.0f;
        return;
    L26:
        this._listValue.add(this._qnameValue);
        this._qnameValue = null;
        return;
    L27:
        this._listValue.add(this._byteArrayValue);
        this._byteArrayValue = null;
        return;
    L28:
        List<Object> r5 = this._listValue;
        if (this._booleanValue == false) goto L31;
        Boolean r0 = Boolean.TRUE;
    L32:
        r5.add(r0);
        this._booleanValue = false;
        return;
    L31:
        r0 = Boolean.FALSE;
        goto L32
    L33:
        this._listValue.add(this._stringValue);
        return;
    L19:
        throw new RuntimeException("Unexpected primitive type code");
    L10:
        if (getUnionType() == null) goto L12;
        r4 = getUnionType();
        this._unionType = null;
        goto L12
    }

    private void attrEvent(ValidatorListener.Event r11) {
        ValidatorListener.Event r12 = (ValidatorListener.Event) ZeusTransformUtils.wrapperContextForParams(r11, ValidatorListener.Event.class, "com.obric.memorydata.plugin");
        QName r6 = r12.getName();
        State r0 = topState();
        if (r0._attrs != null) goto L6;
        r0._attrs = new HashSet();
    L6:
        if (r0._attrs.contains(r6) == false) goto L9;
        emitFieldError(r12, "uniqattspec", new Object[]{QNameHelper.pretty(r6)}, r6, null, null, 1000, r0._type);
        return;
    L9:
        r0._attrs.add(r6);
        if (r0._canHaveAttrs == true) goto L14;
        emitFieldError(r12, "cvc-complex-type.3.2.1", new Object[]{QNameHelper.pretty(r6)}, r6, null, null, 1000, r0._type);
        return;
    L14:
        if (r0._attrModel != null) goto L16;
        SchemaLocalAttribute r1 = null;
    L17:
        SchemaLocalAttribute r7 = r1;
        if (r7 == null) goto L25;
        this._localAttribute = r7;
        if (r7.getUse() != 1) goto L23;
        emitFieldError(r12, "cvc-complex-type.prohibited-attribute", new Object[]{QNameHelper.pretty(r6)}, r6, null, null, 1000, r0._type);
        return;
    L23:
        this._constraintEngine.attr(r12, r6, r7.getType(), validateSimpleType(r7.getType(), r7, r12, false, false));
        return;
    L25:
        int r2 = r0._attrModel.getWildcardProcess();
        this._wildcardAttribute = r0._attrModel;
        if (r2 != 0) goto L30;
        emitFieldError(r12, "cvc-complex-type.3.2.1", new Object[]{QNameHelper.pretty(r6)}, r6, null, null, 1000, r0._type);
        return;
    L30:
        if (r0._attrModel.getWildcardSet().contains(r6) == true) goto L34;
        emitFieldError(r12, "cvc-complex-type.3.2.2", new Object[]{QNameHelper.pretty(r6)}, r6, null, null, 1000, r0._type);
        return;
    L34:
        if (r2 != 3) goto L36;
        return;
    L36:
        if (r2 == 2) goto L38;
    L40:
        SchemaGlobalAttribute r8 = this._globalTypes.findAttribute(r6);
        this._localAttribute = r8;
        if (r8 != null) goto L46;
        if (r2 != 2) goto L44;
        return;
    L44:
        emitFieldError(r12, "cvc-assess-attr.1.2", new Object[]{QNameHelper.pretty(r6)}, r6, null, null, 1000, r0._type);
        return;
    L46:
        this._constraintEngine.attr(r12, r6, r8.getType(), validateSimpleType(r8.getType(), r8, r12, false, false));
        return;
    L38:
        if (this._treatLaxAsSkip == false) goto L40;
        return;
    L16:
        r1 = r0._attrModel.getAttribute(r6);
        goto L17
    }

    /* JADX WARN: Failed to calculate best type for var: r13v0 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r13v0 ??, new type: org.apache.xmlbeans.impl.validator.Validator$State
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r13v0 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r13v0 ??, new type: org.apache.xmlbeans.impl.validator.Validator$State
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r14v3 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r14v3 ??, new type: int
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r14v8 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r14v8 ??, new type: int
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r1v16 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r1v16 ??, new type: int
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r1v4 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r1v4 ??, new type: org.apache.xmlbeans.SchemaParticle
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r1v63 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r1v63 ??, new type: org.apache.xmlbeans.SchemaType
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r1v64 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r1v64 ??, new type: org.apache.xmlbeans.SchemaType
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r1v67 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r1v67 ??, new type: org.apache.xmlbeans.SchemaType
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r1v76 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r1v76 ??, new type: int
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r1v77 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r1v77 ??, new type: int
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r21v0 'this'  ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r21v0 'this'  ??, new type: org.apache.xmlbeans.impl.validator.Validator
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r2v34 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r2v34 ??, new type: org.apache.xmlbeans.SchemaType
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r2v35 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r2v35 ??, new type: org.apache.xmlbeans.SchemaType
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r2v36 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r2v36 ??, new type: org.apache.xmlbeans.SchemaType
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r2v42 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r2v42 ??, new type: int
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r3v12 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r3v12 ??, new type: int
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r3v21 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r3v21 ??, new type: int
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r3v22 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r3v22 ??, new type: int
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r3v23 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r3v23 ??, new type: int
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r3v24 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r3v24 ??, new type: int
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r3v25 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r3v25 ??, new type: int
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r3v26 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r3v26 ??, new type: int
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r4v20 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r4v20 ??, new type: int
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r4v21 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r4v21 ??, new type: int
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to set immutable type for var: r14v3 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r14v3 ??, new type: int
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.applyWithWiderIgnSame(TypeUpdate.java:73)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setImmutableType(TypeInferenceVisitor.java:111)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$0(TypeInferenceVisitor.java:102)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:102)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to set immutable type for var: r21v0 'this'  ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r21v0 'this'  ??, new type: org.apache.xmlbeans.impl.validator.Validator
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.applyWithWiderIgnSame(TypeUpdate.java:73)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setImmutableType(TypeInferenceVisitor.java:111)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$0(TypeInferenceVisitor.java:102)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:102)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /*  JADX ERROR: Types fix failed
        jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r15v0 ??, new type: int
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryPossibleTypes(FixTypesVisitor.java:186)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:245)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
        Caused by: java.lang.NullPointerException
        */
    private void beginEvent(org.apache.xmlbeans.impl.common.ValidatorListener.Event r22) {
        /*  JADX ERROR: Simple mode code generation failed
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0013: INVOKE (r13v0 ?? I:org.apache.xmlbeans.impl.validator.Validator$State) = (r21v0 'this' ?? I:org.apache.xmlbeans.impl.validator.Validator A[IMMUTABLE_TYPE, THIS]) DIRECT call: org.apache.xmlbeans.impl.validator.Validator.topState():org.apache.xmlbeans.impl.validator.Validator$State A[DECLARE_VAR, MD:():org.apache.xmlbeans.impl.validator.Validator$State (m)] in method: org.apache.xmlbeans.impl.validator.Validator.beginEvent(org.apache.xmlbeans.impl.common.ValidatorListener$Event):void, file: classes7.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:348)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.ArgType.getPrimitiveType()" because "type" is null
            	at jadx.core.codegen.ClassGen.useType(ClassGen.java:564)
            	at jadx.core.codegen.InsnGen.useType(InsnGen.java:269)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:166)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:159)
            	at jadx.core.codegen.InsnGen.assignVar(InsnGen.java:152)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:299)
            	... 31 more
            */
        /*
            Method dump skipped, instruction units count: 964
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.xmlbeans.impl.validator.Validator.beginEvent(org.apache.xmlbeans.impl.common.ValidatorListener$Event):void");
    }

    private boolean derivedFromInteger(SchemaType r2) {
        SchemaType r1 = (SchemaType) ZeusTransformUtils.wrapperContextForParams(r2, SchemaType.class, "com.obric.memorydata.plugin");
    L3:
        int r3 = r1.getBuiltinTypeCode();
        if (r3 != 0) goto L7;
        r1 = r1.getBaseType();
        goto L3
    L7:
        if (r3 >= 22) goto L9;
    L11:
        return false;
    L9:
        if (r3 > 34) goto L11;
        return true;
    }

    private void emitError(ValidatorListener.Event r16, String r17, String r18, Object[] r19, int r20, QName r21, QName r22, SchemaType r23, List<QName> r24, int r25, SchemaType r26) {
        ValidatorListener.Event r1 = (ValidatorListener.Event) ZeusTransformUtils.wrapperContextForParams(r16, ValidatorListener.Event.class, "com.obric.memorydata.plugin");
        SchemaType r11 = (SchemaType) ZeusTransformUtils.wrapperContextForParams(r23, SchemaType.class, "com.obric.memorydata.plugin");
        List r12 = (List) ZeusTransformUtils.wrapperContextForParams(r24, List.class, "com.obric.memorydata.plugin");
        SchemaType r14 = (SchemaType) ZeusTransformUtils.wrapperContextForParams(r26, SchemaType.class, "com.obric.memorydata.plugin");
        this._errorState++;
        if (this._suspendErrors != 0) goto L14;
        if (r20 != 0) goto L7;
        this._invalid = true;
    L7:
        if (this._errorListener == null) goto L15;
        XmlCursor r8 = r1.getLocationAsCursor();
        if (r8 == null) goto L11;
        XmlValidationError r2 = XmlValidationError.forCursorWithDetails(r17, r18, r19, r20, r8, r21, r22, r11, r12, r25, r14);
    L12:
        this._errorListener.add(r2);
        return;
    L11:
        r2 = XmlValidationError.forLocationWithDetails(r17, r18, r19, r20, r1.getLocation(), r21, r22, r11, r12, r25, r14);
        goto L12
    L15:
        return;
    }

    private void emitError(ValidatorListener.Event r15, String r16, QName r17, SchemaType r18, int r19) {
        emitError((ValidatorListener.Event) ZeusTransformUtils.wrapperContextForParams(r15, ValidatorListener.Event.class, "com.obric.memorydata.plugin"), r16, null, null, 0, null, r17, (SchemaType) ZeusTransformUtils.wrapperContextForParams(r18, SchemaType.class, "com.obric.memorydata.plugin"), null, r19, null);
    }

    private void emitError(ValidatorListener.Event r15, String r16, Object[] r17, QName r18, SchemaType r19, int r20, SchemaType r21) {
        emitError((ValidatorListener.Event) ZeusTransformUtils.wrapperContextForParams(r15, ValidatorListener.Event.class, "com.obric.memorydata.plugin"), null, r16, r17, 0, null, r18, (SchemaType) ZeusTransformUtils.wrapperContextForParams(r19, SchemaType.class, "com.obric.memorydata.plugin"), null, r20, (SchemaType) ZeusTransformUtils.wrapperContextForParams(r21, SchemaType.class, "com.obric.memorydata.plugin"));
    }

    private void emitFieldError(ValidatorListener.Event r13, String r14, Object[] r15, QName r16, SchemaType r17, List<QName> r18, int r19, SchemaType r20) {
        ValidatorListener.Event r1 = (ValidatorListener.Event) ZeusTransformUtils.wrapperContextForParams(r13, ValidatorListener.Event.class, "com.obric.memorydata.plugin");
        SchemaType r8 = (SchemaType) ZeusTransformUtils.wrapperContextForParams(r17, SchemaType.class, "com.obric.memorydata.plugin");
        List<QName> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r18, List.class, "com.obric.memorydata.plugin");
        SchemaType r11 = (SchemaType) ZeusTransformUtils.wrapperContextForParams(r20, SchemaType.class, "com.obric.memorydata.plugin");
        State r2 = this._stateStack;
        if (r2 != null) goto L5;
    L7:
        QName r3 = null;
    L8:
        emitError(r1, null, r14, r15, 0, r3, r16, r8, r9, r19, r11);
        return;
    L5:
        if (r2._field == null) goto L7;
        r3 = this._stateStack._field.getName();
        goto L8
    }

    private void endAttrsEvent(ValidatorListener.Event r15) {
        ValidatorListener.Event r16 = (ValidatorListener.Event) ZeusTransformUtils.wrapperContextForParams(r15, ValidatorListener.Event.class, "com.obric.memorydata.plugin");
        State r9 = topState();
        if (r9._attrModel == null) goto L19;
        SchemaLocalAttribute[] r10 = r9._attrModel.getAttributes();
        int r11 = r10.length;
        int r13 = 0;
    L5:
        if (r13 >= r11) goto L25;
        SchemaLocalAttribute r0 = r10[r13];
        if (r9._attrs == null) goto L11;
        if (r9._attrs.contains(r0.getName()) == false) goto L11;
    L18:
        r13 = r13 + 1;
    L11:
        if (r0.getUse() != 3) goto L14;
        emitFieldError(r16, "cvc-complex-type.4", new Object[]{QNameHelper.pretty(r0.getName())}, r0.getName(), null, null, 1000, r9._type);
        goto L18
    L14:
        if (r0.isDefault() == false) goto L16;
    L17:
        this._constraintEngine.attr(r16, r0.getName(), r0.getType(), r0.getDefaultText());
        goto L18
    L16:
        if (r0.isFixed() == false) goto L18;
    L25:
        return;
    }

    private void endEvent(ValidatorListener.Event r3) {
        ValidatorListener.Event r4 = (ValidatorListener.Event) ZeusTransformUtils.wrapperContextForParams(r3, ValidatorListener.Event.class, "com.obric.memorydata.plugin");
        this._localElement = null;
        this._wildcardElement = null;
        State r0 = topState();
        if (r0._isNil == false) goto L5;
    L10:
        popState(r4);
        this._constraintEngine.endElement(r4);
        return;
    L5:
        if (r0.end() == true) goto L8;
        findDetailedErrorEnd(r4, r0);
    L8:
        if (r0._isEmpty == false) goto L10;
        handleText(r4, true, r0._field);
        goto L10
    }

    private void findDetailedErrorBegin(ValidatorListener.Event r12, State r13, QName r14) {
        ValidatorListener.Event r3 = (ValidatorListener.Event) ZeusTransformUtils.wrapperContextForParams(r12, ValidatorListener.Event.class, "com.obric.memorydata.plugin");
        ArrayList r15 = new ArrayList();
        ArrayList r0 = new ArrayList();
        SchemaProperty[] r2 = r13._type.getElementProperties();
        int r4 = r2.length;
        int r6 = 0;
    L3:
        if (r6 >= r4) goto L12;
        SchemaProperty r7 = r2[r6];
        if (r13.test(r7.getName()) == false) goto L10;
        int r8 = BigInteger.ZERO.compareTo(r7.getMinOccurs());
        QName r9 = r7.getName();
        if (r8 != 0) goto L9;
        r0.add(r9);
        goto L10
    L9:
        r15.add(r9);
    L10:
        r6 = r6 + 1;
        goto L3
    L12:
        if (r15.size() <= 0) goto L14;
        List<QName> r10 = r15;
    L16:
        if (r10.size() <= 0) goto L18;
        emitFieldError(r3, "cvc-complex-type.2.4a", new Object[]{Integer.valueOf(r10.size()), (String) ZeusTransformUtils.preCheckCast(r10.stream().map($$Lambda$uilw6QxOwK1lqcYbCnKyCzxcX_Q.INSTANCE).collect(Collectors.joining(" ")), String.class, "com.obric.memorydata.plugin"), QNameHelper.pretty(r14)}, r14, null, r10, 1, r13._type);
        return;
    L18:
        emitFieldError(r3, "cvc-complex-type.2.4b", new Object[]{QNameHelper.pretty(r14)}, r14, null, null, 1, r13._type);
        return;
    L14:
        r10 = r0;
        goto L16
    }

    private void findDetailedErrorEnd(ValidatorListener.Event r12, State r13) {
        ValidatorListener.Event r3 = (ValidatorListener.Event) ZeusTransformUtils.wrapperContextForParams(r12, ValidatorListener.Event.class, "com.obric.memorydata.plugin");
        SchemaProperty[] r14 = r13._type.getElementProperties();
        ArrayList r0 = new ArrayList();
        ArrayList r2 = new ArrayList();
        int r4 = r14.length;
        int r6 = 0;
    L3:
        if (r6 >= r4) goto L12;
        SchemaProperty r7 = r14[r6];
        if (r13.test(r7.getName()) == false) goto L10;
        int r8 = BigInteger.ZERO.compareTo(r7.getMinOccurs());
        QName r9 = r7.getName();
        if (r8 != 0) goto L9;
        r2.add(r9);
        goto L10
    L9:
        r0.add(r9);
    L10:
        r6 = r6 + 1;
        goto L3
    L12:
        if (r0.size() <= 0) goto L14;
        List<QName> r10 = r0;
    L16:
        if (r10.size() <= 0) goto L18;
        emitFieldError(r3, "cvc-complex-type.2.4c", new Object[]{Integer.valueOf(r10.size()), (String) ZeusTransformUtils.preCheckCast(r10.stream().map($$Lambda$uilw6QxOwK1lqcYbCnKyCzxcX_Q.INSTANCE).collect(Collectors.joining(" ")), String.class, "com.obric.memorydata.plugin")}, null, null, r10, 1, r13._type);
        return;
    L18:
        emitFieldError(r3, "cvc-complex-type.2.4d", null, null, null, null, 2, r13._type);
        return;
    L14:
        r10 = r2;
        goto L16
    }

    private void handleText(ValidatorListener.Event r12, boolean r13, SchemaField r14) {
        ValidatorListener.Event r15 = (ValidatorListener.Event) ZeusTransformUtils.wrapperContextForParams(r12, ValidatorListener.Event.class, "com.obric.memorydata.plugin");
        SchemaField r16 = (SchemaField) ZeusTransformUtils.wrapperContextForParams(r14, SchemaField.class, "com.obric.memorydata.plugin");
        State r0 = topState();
        if (r0._sawText == false) goto L5;
    L15:
        if (r13 == false) goto L17;
    L30:
        if (r13 == true) goto L33;
        r0._sawText = true;
        return;
    L33:
        return;
    L17:
        if (r0._canHaveMixedContent == true) goto L30;
        if (r15.textIsWhitespace() == true) goto L30;
        if (r0._hasSimpleContent == true) goto L30;
        if (ZeusTransformUtils.instanceOf(r16, SchemaLocalElement.class) == false) goto L29;
        SchemaLocalElement r1 = (SchemaLocalElement) ZeusTransformUtils.preCheckCast(r16, SchemaLocalElement.class, "com.obric.memorydata.plugin");
        if (r0._type.getContentType() != 1) goto L27;
        String r2 = "cvc-complex-type.2.1";
    L28:
        emitError(r15, r2, new Object[]{QNameHelper.pretty(r1.getName())}, r1.getName(), r16.getType(), 3, null);
        goto L30
    L27:
        r2 = "cvc-complex-type.2.3";
        goto L28
    L29:
        emitError(r15, "Can't have mixed content", r15.getName(), r0._type, 3);
        goto L30
    L5:
        if (r0._hasSimpleContent == false) goto L9;
        String r3 = validateSimpleType(r0._type, r16, r15, r13, true);
        IdentityConstraint r4 = this._constraintEngine;
        SchemaType r5 = r0._type;
    L7:
        r4.text(r15, r5, r3, false);
        goto L15
    L9:
        if (r0._canHaveMixedContent == false) goto L11;
        r3 = validateSimpleType(XmlString.type, r16, r15, r13, true);
        r4 = this._constraintEngine;
        r5 = XmlString.type;
        goto L7
    L11:
        IdentityConstraint r6 = this._constraintEngine;
        SchemaType r7 = r0._type;
        if (r13 == false) goto L14;
        r6.text(r15, r7, null, true);
        goto L15
    L14:
        r6.text(r15, r7, "", false);
        goto L15
    }

    private SchemaTypeVisitorImpl initVisitor(SchemaParticle r3) {
        SchemaParticle r4 = (SchemaParticle) ZeusTransformUtils.wrapperContextForParams(r3, SchemaParticle.class, "com.obric.memorydata.plugin");
        if (this._visitorPool.isEmpty() == true) goto L5;
        SchemaTypeVisitorImpl r2 = (SchemaTypeVisitorImpl) ZeusTransformUtils.preCheckCast(this._visitorPool.removeLast(), SchemaTypeVisitorImpl.class, "com.obric.memorydata.plugin");
        r2.init(r4);
        return r2;
    L5:
        return new SchemaTypeVisitorImpl(r4);
    }

    private void newState(SchemaType r3, SchemaField r4, boolean r5) {
        SchemaType r6 = (SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin");
        SchemaField r7 = (SchemaField) ZeusTransformUtils.wrapperContextForParams(r4, SchemaField.class, "com.obric.memorydata.plugin");
        State r0 = new State(null);
        r0._type = r6;
        r0._field = r7;
        boolean r8 = true;
        r0._isEmpty = true;
        r0._isNil = r5;
        if (r6.isSimpleType() == false) goto L5;
    L4:
        r0._hasSimpleContent = true;
    L23:
        pushState(r0);
        return;
    L5:
        r0._canHaveAttrs = true;
        r0._attrModel = r6.getAttributeModel();
        int r9 = r6.getContentType();
        if (r9 == 1) goto L23;
        if (r9 == 2) goto L4;
        if (r9 != 3) goto L12;
    L16:
        SchemaParticle r10 = r6.getContentModel();
        if (r10 != null) goto L20;
        r8 = false;
    L20:
        r0._canHaveElements = r8;
        if (r0._canHaveElements == false) goto L23;
        r0._visitor = initVisitor(r10);
        goto L23
    L12:
        if (r9 != 4) goto L15;
        r0._canHaveMixedContent = true;
        goto L16
    L15:
        throw new RuntimeException("Unexpected content type");
    }

    private void poolVisitor(SchemaTypeVisitorImpl r1) {
        this._visitorPool.add(r1);
    }

    private void popState(ValidatorListener.Event r3) {
        ValidatorListener.Event r4 = (ValidatorListener.Event) ZeusTransformUtils.wrapperContextForParams(r3, ValidatorListener.Event.class, "com.obric.memorydata.plugin");
        if (this._stateStack._visitor == null) goto L5;
        poolVisitor(this._stateStack._visitor);
        this._stateStack._visitor = null;
    L5:
        this._stateStack = this._stateStack._next;
    }

    private void pushState(State r2) {
        r2._next = this._stateStack;
        this._stateStack = r2;
    }

    private void resetValues() {
        this._localAttribute = null;
        this._wildcardAttribute = null;
        this._stringValue = null;
        this._decimalValue = null;
        this._booleanValue = false;
        this._floatValue = 0.0f;
        this._doubleValue = 0.0d;
        this._qnameValue = null;
        this._gdateValue = null;
        this._gdurationValue = null;
        this._byteArrayValue = null;
        this._listValue = null;
        this._listTypes = null;
        this._unionType = null;
    }

    private void textEvent(ValidatorListener.Event r11) {
        ValidatorListener.Event r1 = (ValidatorListener.Event) ZeusTransformUtils.wrapperContextForParams(r11, ValidatorListener.Event.class, "com.obric.memorydata.plugin");
        State r12 = topState();
        if (r12._isNil == false) goto L5;
        emitFieldError(r1, "cvc-elt.3.2.1", null, r12._field.getName(), r12._type, null, 4, r12._type);
    L6:
        r12._isEmpty = false;
        return;
    L5:
        handleText(r1, false, r12._field);
        goto L6
    }

    private State topState() {
        return this._stateStack;
    }

    private void validateAtomicType(SchemaType r5, String r6, ValidatorListener.Event r7) {
        SchemaType r8 = (SchemaType) ZeusTransformUtils.wrapperContextForParams(r5, SchemaType.class, "com.obric.memorydata.plugin");
        ValidatorListener.Event r9 = (ValidatorListener.Event) ZeusTransformUtils.wrapperContextForParams(r7, ValidatorListener.Event.class, "com.obric.memorydata.plugin");
        int r0 = this._errorState;
        this._vc._event = r9;
        switch(r8.getPrimitiveType().getBuiltinTypeCode()) {
            case 2: goto L61;
            case 3: goto L60;
            case 4: goto L56;
            case 5: goto L52;
            case 6: goto L47;
            case 7: goto L43;
            case 8: goto L40;
            case 9: goto L36;
            case 10: goto L32;
            case 11: goto L24;
            case 12: goto L23;
            case 13: goto L19;
            case 14: goto L15;
            case 15: goto L15;
            case 16: goto L15;
            case 17: goto L15;
            case 18: goto L15;
            case 19: goto L15;
            case 20: goto L15;
            case 21: goto L7;
            default: goto L5;
        };
    L15:
        GDate r10 = XmlDateImpl.validateLexical(r6, r8, this._vc);
        if (r10 == null) goto L18;
        XmlDateImpl.validateValue(r10, r8, this._vc);
    L18:
        this._gdateValue = r10;
        return;
    L19:
        GDuration r11 = XmlDurationImpl.validateLexical(r6, r8, this._vc);
        if (r11 == null) goto L22;
        XmlDurationImpl.validateValue(r11, r8, this._vc);
    L22:
        this._gdurationValue = r11;
        return;
    L23:
        JavaStringEnumerationHolderEx.validateLexical(r6, r8, this._vc);
        goto L61
    L24:
        JavaDecimalHolderEx.validateLexical(r6, r8, this._vc);
        if (derivedFromInteger(r8) == false) goto L30;
        if (r6.lastIndexOf(46) < 0) goto L30;
        this._vc.invalid(TypedValues.Custom.S_INT, new Object[]{r6});
    L30:
        if (r0 != this._errorState) goto L67;
        BigDecimal r12 = new BigDecimal(r6);
        this._decimalValue = r12;
        JavaDecimalHolderEx.validateValue(r12, r8, this._vc);
        return;
    L67:
        return;
    L32:
        double r13 = JavaDoubleHolderEx.validateLexical(r6, r8, this._vc);
        if (r0 != this._errorState) goto L35;
        JavaDoubleHolderEx.validateValue(r13, r8, this._vc);
    L35:
        this._doubleValue = r13;
        return;
    L36:
        float r14 = JavaFloatHolderEx.validateLexical(r6, r8, this._vc);
        if (r0 != this._errorState) goto L39;
        JavaFloatHolderEx.validateValue(r14, r8, this._vc);
    L39:
        this._floatValue = r14;
        return;
    L40:
        QName r15 = JavaNotationHolderEx.validateLexical(r6, r8, this._vc, r9);
        if (r0 != this._errorState) goto L46;
        JavaNotationHolderEx.validateValue(r15, r8, this._vc);
    L46:
        this._qnameValue = r15;
        return;
    L43:
        r15 = JavaQNameHolderEx.validateLexical(r6, r8, this._vc, r9);
        if (r0 != this._errorState) goto L46;
        JavaQNameHolderEx.validateValue(r15, r8, this._vc);
        goto L46
    L47:
        JavaUriHolderEx.validateLexical(r6, r8, this._vc);
        if (this._strict == false) goto L61;
        XsTypeConverter.lexAnyURI(r6);     // Catch: InvalidLexicalValueException -> L51
    L51:
        this._vc.invalid("anyURI", new Object[]{r6});
        goto L61
    L52:
        byte[] r16 = JavaHexBinaryHolderEx.validateLexical(r6, r8, this._vc);
        if (r16 == null) goto L55;
        JavaHexBinaryHolderEx.validateValue(r16, r8, this._vc);
    L55:
        this._byteArrayValue = r16;
        return;
    L56:
        byte[] r17 = JavaBase64HolderEx.validateLexical(r6, r8, this._vc);
        if (r17 == null) goto L59;
        JavaBase64HolderEx.validateValue(r17, r8, this._vc);
    L59:
        this._byteArrayValue = r17;
        return;
    L60:
        this._booleanValue = JavaBooleanHolderEx.validateLexical(r6, r8, this._vc);
        return;
    L61:
        this._stringValue = r6;
        return;
    L5:
        throw new RuntimeException("Unexpected primitive type code");
    L7:
        if (this._strict == false) goto L15;
        if (r6.length() != 6) goto L15;
        if (r6.charAt(4) != '-') goto L15;
        if (r6.charAt(5) != '-') goto L15;
        this._vc.invalid("date", new Object[]{r6});
        goto L15
    }

    /* JADX WARN: Failed to calculate best type for var: r11v1 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r11v1 ??, new type: org.apache.xmlbeans.SchemaType
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r11v1 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r11v1 ??, new type: org.apache.xmlbeans.SchemaType
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r21v0 'this'  ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r21v0 'this'  ??, new type: org.apache.xmlbeans.impl.validator.Validator
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r21v0 'this'  org.apache.xmlbeans.impl.validator.Validator, new type: org.apache.xmlbeans.impl.validator.Validator
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.applyWithWiderIgnSame(TypeUpdate.java:73)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.applyResolvedVars(TypeSearch.java:100)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:76)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.runMultiVariableSearch(FixTypesVisitor.java:119)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException
     */
    private void validateListType(SchemaType r22, String r23, ValidatorListener.Event r24) {
        SchemaType r11 = (SchemaType) ZeusTransformUtils.wrapperContextForParams(r22, SchemaType.class, "com.obric.memorydata.plugin");
        ValidatorListener.Event r12 = (ValidatorListener.Event) ZeusTransformUtils.wrapperContextForParams(r24, ValidatorListener.Event.class, "com.obric.memorydata.plugin");
        int r13 = this._errorState;
        if (r11.matchPatternFacet(r23) == true) goto L6;
        emitError(r12, "cvc-datatype-valid.1.1", new Object[]{Constants.KEY_LIST, r23, QNameHelper.readable(r11)}, null, r11, 2000, null);
    L6:
        String[] r8 = XmlListImpl.split_list(r23);
        XmlAnySimpleType r1 = r11.getFacet(r6);
        if (r1 == null) goto L11;
        int r2 = ((SimpleValue) ZeusTransformUtils.preCheckCast(r1, SimpleValue.class, "com.obric.memorydata.plugin")).getIntValue();
        if (r2 == r8.length) goto L11;
        int r15 = 1;
        emitError(r12, "cvc-length-valid.2", new Object[]{r23, Integer.valueOf(r8.length), Integer.valueOf(r2), QNameHelper.readable(r11)}, null, r11, 2000, null);
    L12:
        XmlAnySimpleType r3 = r11.getFacet(r15);
        if (r3 == null) goto L18;
        int r4 = ((SimpleValue) ZeusTransformUtils.preCheckCast(r3, SimpleValue.class, "com.obric.memorydata.plugin")).getIntValue();
        if (r4 <= r8.length) goto L17;
        Object[] r5 = new Object[4];
        r5[0] = r23;
        r5[r15] = Integer.valueOf(r8.length);
        r5[2] = Integer.valueOf(r4);
        r5[3] = QNameHelper.readable(r11);
        int r16 = 2;
        String[] r20 = r8;
        emitError(r12, "cvc-length-valid.2", r5, null, r11, 2000, null);
    L20:
        XmlAnySimpleType r6 = r11.getFacet(r16);
        if (r6 == null) goto L26;
        int r7 = ((SimpleValue) ZeusTransformUtils.preCheckCast(r6, SimpleValue.class, "com.obric.memorydata.plugin")).getIntValue();
        String[] r9 = r20;
        if (r7 >= r9.length) goto L25;
        Object[] r10 = new Object[4];
        r10[0] = r23;
        r10[1] = Integer.valueOf(r9.length);
        r10[r16] = Integer.valueOf(r7);
        r10[3] = QNameHelper.readable(r11);
        String[] r17 = r9;
        emitError(r12, "cvc-length-valid.2", r10, null, r11, 2000, null);
    L27:
        SchemaType r14 = r11.getListItemType();
        this._listValue = new ArrayList();
        this._listTypes = new ArrayList();
        int r18 = 0;
    L29:
        if (r18 >= r17.length) goto L32;
        validateSimpleType(r14, r17[r18], r12);
        addToList(r14);
        r18 = r18 + 1;
        goto L29
    L32:
        if (r13 == this._errorState) goto L34;
        return;
    L34:
        if (r11.getEnumerationValues() == null) goto L49;
        NamespaceContext.push(new NamespaceContext(r12));
        ((SchemaTypeImpl) ZeusTransformUtils.preCheckCast(r11, SchemaTypeImpl.class, "com.obric.memorydata.plugin")).newValidatingValue(r23);     // Catch: Throwable -> L38 XmlValueOutOfRangeException -> L40
    L37:
        NamespaceContext.pop();
        return;
    L40:
        emitError(r12, "cvc-enumeration-valid", new Object[]{Constants.KEY_LIST, r23, QNameHelper.readable(r11)}, null, r11, 2000, null);     // Catch: Throwable -> L38
    L38:
        th = move-exception;
        NamespaceContext.pop();
        throw th;
    L49:
        return;
    L25:
        r17 = r9;
        goto L27
    L26:
        r17 = r20;
        goto L27
    L17:
        r20 = r8;
    L19:
        r16 = 2;
        goto L20
    L18:
        r20 = r8;
    L11:
        r15 = 1;
        goto L12
    }

    private String validateSimpleType(SchemaType r15, SchemaField r16, ValidatorListener.Event r17, boolean r18, boolean r19) {
        SchemaType r8 = (SchemaType) ZeusTransformUtils.wrapperContextForParams(r15, SchemaType.class, "com.obric.memorydata.plugin");
        SchemaField r1 = (SchemaField) ZeusTransformUtils.wrapperContextForParams(r16, SchemaField.class, "com.obric.memorydata.plugin");
        ValidatorListener.Event r2 = (ValidatorListener.Event) ZeusTransformUtils.wrapperContextForParams(r17, ValidatorListener.Event.class, "com.obric.memorydata.plugin");
        if (r8.isSimpleType() == true) goto L8;
        if (r8.getContentType() == 2) goto L8;
        return null;
    L8:
        if (r8.isNoType() == false) goto L16;
        if (r1.isAttribute() == false) goto L12;
        String r3 = "cvc-attribute.1";
    L13:
        emitError(r2, r3, null, r1.getName(), r8, 3, null);
        return null;
    L12:
        r3 = "cvc-elt.1";
        goto L13
    L16:
        if (r18 == true) goto L21;
        int r5 = r8.getWhiteSpaceRule();
        if (r5 != 1) goto L20;
        String r6 = r2.getText();
    L23:
        if (r6.length() != 0) goto L39;
        if (r19 == false) goto L39;
        if (r1 == null) goto L39;
        if (r1.isDefault() == true) goto L31;
        if (r1.isFixed() == false) goto L39;
    L31:
        if (XmlQName.type.isAssignableFrom(r8) == false) goto L34;
        emitError(r2, "Default QName values are unsupported for " + QNameHelper.readable(r8) + " - ignoring.", null, null, 2, r1.getName(), null, r8, null, 3, null);
        return null;
    L34:
        String r4 = XmlWhitespace.collapse(r1.getDefaultText(), r8.getWhiteSpaceRule());
        if (validateSimpleType(r8, r4, r2) == true) goto L37;
        return null;
    L37:
        return r4;
    L39:
        if (validateSimpleType(r8, r6, r2) == true) goto L41;
        return null;
    L41:
        if (r1 != null) goto L43;
    L61:
        return r6;
    L43:
        if (r1.isFixed() == false) goto L61;
        String r7 = XmlWhitespace.collapse(r1.getDefaultText(), r8.getWhiteSpaceRule());
        if (validateSimpleType(r8, r7, r2) == true) goto L48;
        return null;
    L48:
        if (r8.newValue(r6).valueEquals(r8.newValue(r7)) == true) goto L61;
        if (r1.isAttribute() == false) goto L53;
        emitError(r2, "cvc-attribute.4", new Object[]{r6, r7, QNameHelper.pretty(r2.getName())}, null, r1.getType(), 3, null);
    L60:
        return null;
    L53:
        if (r1.getType().getContentType() != 4) goto L56;
        String r9 = "cvc-elt.5.2.2.2.1";
    L59:
        emitError(r2, r9, new Object[]{r6, r7}, r1.getName(), r1.getType(), 3, null);
        goto L60
    L56:
        if (r8.isSimpleType() == false) goto L58;
        r9 = "cvc-elt.5.2.2.2.2";
        goto L59
    L58:
        r9 = null;
        goto L59
    L20:
        r6 = r2.getText(r5);
        goto L23
    L21:
        r6 = "";
        goto L23
    }

    private boolean validateSimpleType(SchemaType r5, String r6, ValidatorListener.Event r7) {
        SchemaType r8 = (SchemaType) ZeusTransformUtils.wrapperContextForParams(r5, SchemaType.class, "com.obric.memorydata.plugin");
        ValidatorListener.Event r9 = (ValidatorListener.Event) ZeusTransformUtils.wrapperContextForParams(r7, ValidatorListener.Event.class, "com.obric.memorydata.plugin");
        if (r8.isSimpleType() == false) goto L5;
    L9:
        int r0 = this._errorState;
        int r2 = r8.getSimpleVariety();
        if (r2 == 1) goto L18;
        if (r2 != 2) goto L13;
        validateUnionType(r8, r6, r9);
    L20:
        if (r0 == this._errorState) goto L24;
        return false;
    L24:
        return true;
    L13:
        if (r2 != 3) goto L16;
        validateListType(r8, r6, r9);
        goto L20
    L16:
        throw new RuntimeException("Unexpected simple variety");
    L18:
        validateAtomicType(r8, r6, r9);
        goto L20
    L5:
        if (r8.getContentType() == 2) goto L9;
        throw new RuntimeException("Not a simple type");
    }

    private void validateUnionType(SchemaType r18, String r19, ValidatorListener.Event r20) {
        SchemaType r10 = (SchemaType) ZeusTransformUtils.wrapperContextForParams(r18, SchemaType.class, "com.obric.memorydata.plugin");
        ValidatorListener.Event r11 = (ValidatorListener.Event) ZeusTransformUtils.wrapperContextForParams(r20, ValidatorListener.Event.class, "com.obric.memorydata.plugin");
        if (r10.matchPatternFacet(r19) == true) goto L5;
        emitError(r11, "cvc-datatype-valid.1.1", new Object[]{"union", r19, QNameHelper.readable(r10)}, null, r10, 3000, null);
    L5:
        SchemaType[] r1 = r10.getUnionMemberTypes();
        int r2 = this._errorState;
        String r5 = r19;
        int r3 = 0;
        int r4 = 1;
    L7:
        if (r3 >= r1.length) goto L22;
        int r6 = r1[r3].getWhiteSpaceRule();
        if (r6 != 0) goto L11;
        r6 = 1;
    L11:
        if (r6 == r4) goto L13;
        r5 = XmlWhitespace.collapse(r19, r6);
        r4 = r6;
    L13:
        int r7 = this._errorState;
        this._suspendErrors++;
        validateSimpleType(r1[r3], r5, r11);     // Catch: Throwable -> L19
        this._suspendErrors--;
        if (r7 == this._errorState) goto L17;
        r3 = r3 + 1;
        goto L7
    L17:
        this._unionType = r1[r3];
    L19:
        th = move-exception;
        this._suspendErrors--;
        throw th;
    L22:
        this._errorState = r2;
        if (r3 < r1.length) goto L25;
        emitError(r11, "cvc-datatype-valid.1.2.3", new Object[]{r19, QNameHelper.readable(r10)}, null, r10, 3000, null);
        return;
    L25:
        XmlAnySimpleType[] r8 = r10.getEnumerationValues();
        if (r8 == null) goto L54;
        NamespaceContext.push(new NamespaceContext(r11));
        XmlAnySimpleType r9 = r10.newValue(r19);     // Catch: Throwable -> L39 XmlValueOutOfRangeException -> L41
        int r12 = 0;
    L30:
        if (r12 >= r8.length) goto L36;
        if (r9.valueEquals(r8[r12]) == true) goto L36;
        r12 = r12 + 1;     // Catch: Throwable -> L39 XmlValueOutOfRangeException -> L41
    L36:
        if (r12 < r8.length) goto L38;
        emitError(r11, "cvc-enumeration-valid", new Object[]{"union", r19, QNameHelper.readable(r10)}, null, r10, 3000, null);     // Catch: Throwable -> L39 XmlValueOutOfRangeException -> L41
    L38:
        NamespaceContext.pop();
        return;
    L39:
        th = move-exception;
        NamespaceContext.pop();
        throw th;
    L41:
        emitError(r11, "cvc-enumeration-valid", new Object[]{"union", r19, QNameHelper.readable(r10)}, null, r10, 3000, null);     // Catch: Throwable -> L39
        goto L38
    }

    public SchemaType getUnionType() {
        return this._unionType;
    }

    public boolean isValid() {
        if (this._invalid == false) goto L5;
    L7:
        return false;
    L5:
        if (this._constraintEngine.isValid() == false) goto L7;
        return true;
    }

    @Override // org.apache.xmlbeans.impl.common.ValidatorListener
    public void nextEvent(int r4, ValidatorListener.Event r5) {
        ValidatorListener.Event r6 = (ValidatorListener.Event) ZeusTransformUtils.wrapperContextForParams(r5, ValidatorListener.Event.class, "com.obric.memorydata.plugin");
        resetValues();
        int r0 = this._eatContent;
        if (r0 <= 0) goto L10;
        if (r4 == 1) goto L8;
        if (r4 != 2) goto L30;
        int r1 = r0 - 1;
    L9:
        this._eatContent = r1;
        return;
    L30:
        return;
    L8:
        r1 = r0 + 1;
        goto L9
    L10:
        if (r4 == 1) goto L23;
        if (r4 != 2) goto L13;
        endEvent(r6);
        return;
    L13:
        if (r4 != 3) goto L15;
        textEvent(r6);
        return;
    L15:
        if (r4 != 4) goto L17;
        attrEvent(r6);
        return;
    L17:
        if (r4 != 5) goto L31;
        endAttrsEvent(r6);
        return;
    L31:
        return;
    L23:
        beginEvent(r6);
    }
}
