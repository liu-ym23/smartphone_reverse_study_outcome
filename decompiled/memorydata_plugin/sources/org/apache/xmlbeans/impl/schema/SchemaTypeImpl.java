package org.apache.xmlbeans.impl.schema;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Constructor;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.QNameSet;
import org.apache.xmlbeans.QNameSetBuilder;
import org.apache.xmlbeans.SchemaAnnotation;
import org.apache.xmlbeans.SchemaAttributeModel;
import org.apache.xmlbeans.SchemaComponent;
import org.apache.xmlbeans.SchemaField;
import org.apache.xmlbeans.SchemaGlobalAttribute;
import org.apache.xmlbeans.SchemaGlobalElement;
import org.apache.xmlbeans.SchemaLocalAttribute;
import org.apache.xmlbeans.SchemaLocalElement;
import org.apache.xmlbeans.SchemaParticle;
import org.apache.xmlbeans.SchemaProperty;
import org.apache.xmlbeans.SchemaStringEnumEntry;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SchemaTypeLoader;
import org.apache.xmlbeans.SchemaTypeSystem;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.common.XBeanDebug;
import org.apache.xmlbeans.impl.regex.RegularExpression;
import org.apache.xmlbeans.impl.values.StringEnumValue;
import org.apache.xmlbeans.impl.values.TypeStoreUser;
import org.apache.xmlbeans.impl.values.TypeStoreUserFactory;
import org.apache.xmlbeans.impl.values.XmlAnySimpleTypeImpl;
import org.apache.xmlbeans.impl.values.XmlAnySimpleTypeRestriction;
import org.apache.xmlbeans.impl.values.XmlAnyTypeImpl;
import org.apache.xmlbeans.impl.values.XmlAnyUriImpl;
import org.apache.xmlbeans.impl.values.XmlAnyUriRestriction;
import org.apache.xmlbeans.impl.values.XmlBase64BinaryImpl;
import org.apache.xmlbeans.impl.values.XmlBase64BinaryRestriction;
import org.apache.xmlbeans.impl.values.XmlBooleanImpl;
import org.apache.xmlbeans.impl.values.XmlBooleanRestriction;
import org.apache.xmlbeans.impl.values.XmlByteImpl;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.apache.xmlbeans.impl.values.XmlDateImpl;
import org.apache.xmlbeans.impl.values.XmlDateTimeImpl;
import org.apache.xmlbeans.impl.values.XmlDecimalImpl;
import org.apache.xmlbeans.impl.values.XmlDecimalRestriction;
import org.apache.xmlbeans.impl.values.XmlDoubleImpl;
import org.apache.xmlbeans.impl.values.XmlDoubleRestriction;
import org.apache.xmlbeans.impl.values.XmlDurationImpl;
import org.apache.xmlbeans.impl.values.XmlEntitiesImpl;
import org.apache.xmlbeans.impl.values.XmlEntityImpl;
import org.apache.xmlbeans.impl.values.XmlFloatImpl;
import org.apache.xmlbeans.impl.values.XmlFloatRestriction;
import org.apache.xmlbeans.impl.values.XmlGDayImpl;
import org.apache.xmlbeans.impl.values.XmlGMonthDayImpl;
import org.apache.xmlbeans.impl.values.XmlGMonthImpl;
import org.apache.xmlbeans.impl.values.XmlGYearImpl;
import org.apache.xmlbeans.impl.values.XmlGYearMonthImpl;
import org.apache.xmlbeans.impl.values.XmlHexBinaryImpl;
import org.apache.xmlbeans.impl.values.XmlHexBinaryRestriction;
import org.apache.xmlbeans.impl.values.XmlIdImpl;
import org.apache.xmlbeans.impl.values.XmlIdRefImpl;
import org.apache.xmlbeans.impl.values.XmlIdRefsImpl;
import org.apache.xmlbeans.impl.values.XmlIntImpl;
import org.apache.xmlbeans.impl.values.XmlIntRestriction;
import org.apache.xmlbeans.impl.values.XmlIntegerImpl;
import org.apache.xmlbeans.impl.values.XmlIntegerRestriction;
import org.apache.xmlbeans.impl.values.XmlLanguageImpl;
import org.apache.xmlbeans.impl.values.XmlListImpl;
import org.apache.xmlbeans.impl.values.XmlLongImpl;
import org.apache.xmlbeans.impl.values.XmlLongRestriction;
import org.apache.xmlbeans.impl.values.XmlNCNameImpl;
import org.apache.xmlbeans.impl.values.XmlNameImpl;
import org.apache.xmlbeans.impl.values.XmlNegativeIntegerImpl;
import org.apache.xmlbeans.impl.values.XmlNmTokenImpl;
import org.apache.xmlbeans.impl.values.XmlNmTokensImpl;
import org.apache.xmlbeans.impl.values.XmlNonNegativeIntegerImpl;
import org.apache.xmlbeans.impl.values.XmlNonPositiveIntegerImpl;
import org.apache.xmlbeans.impl.values.XmlNormalizedStringImpl;
import org.apache.xmlbeans.impl.values.XmlNotationImpl;
import org.apache.xmlbeans.impl.values.XmlNotationRestriction;
import org.apache.xmlbeans.impl.values.XmlObjectBase;
import org.apache.xmlbeans.impl.values.XmlPositiveIntegerImpl;
import org.apache.xmlbeans.impl.values.XmlQNameImpl;
import org.apache.xmlbeans.impl.values.XmlQNameRestriction;
import org.apache.xmlbeans.impl.values.XmlShortImpl;
import org.apache.xmlbeans.impl.values.XmlStringEnumeration;
import org.apache.xmlbeans.impl.values.XmlStringImpl;
import org.apache.xmlbeans.impl.values.XmlStringRestriction;
import org.apache.xmlbeans.impl.values.XmlTimeImpl;
import org.apache.xmlbeans.impl.values.XmlTokenImpl;
import org.apache.xmlbeans.impl.values.XmlUnionImpl;
import org.apache.xmlbeans.impl.values.XmlUnsignedByteImpl;
import org.apache.xmlbeans.impl.values.XmlUnsignedIntImpl;
import org.apache.xmlbeans.impl.values.XmlUnsignedLongImpl;
import org.apache.xmlbeans.impl.values.XmlUnsignedShortImpl;
import org.apache.xmlbeans.impl.values.XmlValueOutOfRangeException;

/* JADX INFO: loaded from: classes7.dex */
public final class SchemaTypeImpl implements SchemaType, TypeStoreUserFactory {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final SchemaProperty[] NO_PROPERTIES = null;
    private boolean _abs;
    private SchemaAnnotation _annotation;
    private SchemaType.Ref[] _anonymousTyperefs;
    private int _anonymousUnionMemberOrdinal;
    private SchemaAttributeModel _attributeModel;
    private int _baseDepth;
    private SchemaType.Ref _baseEnumTyperef;
    private SchemaType.Ref _baseTyperef;
    private boolean _blockExt;
    private boolean _blockRest;
    private int _builtinTypeCode;
    private int _complexTypeVariety;
    private SchemaContainer _container;
    private volatile SchemaField _containerField;
    private volatile int _containerFieldCode;
    private volatile int _containerFieldIndex;
    private volatile SchemaComponent.Ref _containerFieldRef;
    private SchemaType.Ref _contentBasedOnTyperef;
    private SchemaParticle _contentModel;
    private final Object[] _ctrArgs;
    private int _decimalSize;
    private int _derivationType;
    private XmlValueRef[] _enumerationValues;
    private XmlValueRef[] _facetArray;
    private String _filename;
    private boolean _finalExt;
    private boolean _finalList;
    private boolean _finalRest;
    private boolean _finalUnion;
    private boolean[] _fixedFacetArray;
    private String _fullJavaImplName;
    private String _fullJavaName;
    private boolean _hasAllContent;
    private boolean _hasPatterns;
    private boolean _hasWildcardAttributes;
    private boolean _hasWildcardElements;
    private volatile boolean _implNotAvailable;
    private boolean _isAttributeType;
    private boolean _isBounded;
    private boolean _isCompiled;
    private boolean _isDocumentType;
    private boolean _isFinite;
    private boolean _isNumeric;
    private boolean _isSimpleType;
    private boolean _isUnionOfLists;
    private volatile Class<? extends XmlObject> _javaClass;
    private volatile Class<? extends StringEnumAbstractBase> _javaEnumClass;
    private volatile Class<? extends XmlObjectBase> _javaImplClass;
    private volatile Constructor<? extends XmlObjectBase> _javaImplConstructor;
    private volatile Constructor<? extends XmlObjectBase> _javaImplConstructor2;
    private SchemaType.Ref _listItemTyperef;
    private volatile List<StringEnumAbstractBase> _listOfStringEnum;
    private volatile SchemaLocalElement[] _localElts;
    private volatile Map<String, StringEnumAbstractBase> _lookupStringEnum;
    private volatile Map<String, SchemaStringEnumEntry> _lookupStringEnumEntry;
    private QName _name;
    private boolean _orderSensitive;
    private int _ordered;
    private SchemaType.Ref _outerSchemaTypeRef;
    private RegularExpression[] _patterns;
    private SchemaType.Ref _primitiveTypeRef;
    private Map<QName, SchemaProperty> _propertyModelByAttributeName;
    private Map<QName, SchemaProperty> _propertyModelByElementName;
    private int _resolvePhase;
    private final SchemaType.Ref _selfref;
    private final List<QName> _sgMembers;
    private String _shortJavaImplName;
    private String _shortJavaName;
    private int _simpleTypeVariety;
    private boolean _stringEnumEnsured;
    private SchemaStringEnumEntry[] _stringEnumEntries;
    private QNameSet _typedWildcardAttributes;
    private QNameSet _typedWildcardElements;
    private volatile SchemaType _unionCommonBaseType;
    private volatile SchemaType[] _unionConstituentTypes;
    private SchemaType.Ref[] _unionMemberTyperefs;
    private volatile SchemaType[] _unionSubTypes;
    private volatile boolean _unloaded;
    private Set<QName> _validSubstitutions;
    private int _whiteSpaceRule;

    static {
        NO_PROPERTIES = new SchemaProperty[0];
    }

    SchemaTypeImpl(SchemaContainer r3, boolean r4) {
        this._ctrArgs = new Object[]{this};
        this._validSubstitutions = Collections.emptySet();
        this._sgMembers = new ArrayList();
        this._selfref = new SchemaType.Ref(this);
        this._container = r3;
        this._unloaded = r4;
        if (r4 == false) goto L6;
        finishQuick();
        return;
    }

    private void assertJavaizing() {
        if (this._resolvePhase != 5) goto L5;
        return;
    L5:
        if (this._unloaded == false) goto L8;
        return;
    L8:
        throw new IllegalStateException();
    }

    private void assertResolved() {
        if (this._resolvePhase != 4) goto L5;
        return;
    L5:
        if (this._unloaded == false) goto L8;
        return;
    L8:
        throw new IllegalStateException();
    }

    private void assertResolving() {
        if (this._resolvePhase != 3) goto L5;
        return;
    L5:
        if (this._unloaded == false) goto L8;
        return;
    L8:
        throw new IllegalStateException();
    }

    private void assertUnresolved() {
        if (this._resolvePhase != 0) goto L5;
        return;
    L5:
        if (this._unloaded == false) goto L8;
        return;
    L8:
        throw new IllegalStateException();
    }

    private static void buildEltList(List<SchemaLocalElement> r3, SchemaParticle r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        SchemaParticle r6 = (SchemaParticle) ZeusTransformUtils.wrapperContextForParams(r4, SchemaParticle.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L5;
        return;
    L5:
        int r0 = r6.getParticleType();
        if (r0 != 1) goto L8;
    L15:
        int r1 = 0;
    L17:
        if (r1 >= r6.countOfParticleChild()) goto L22;
        buildEltList(r5, r6.getParticleChild(r1));
        r1 = r1 + 1;
        goto L17
    L22:
        return;
    L8:
        if (r0 == 2) goto L15;
        if (r0 == 3) goto L15;
        if (r0 != 4) goto L21;
        r5.add((SchemaLocalElement) ZeusTransformUtils.preCheckCast(r6, SchemaLocalElement.class, "com.obric.memorydata.plugin"));
        return;
    }

    private void buildLocalElts() {
        ArrayList r0 = new ArrayList();
        buildEltList(r0, this._contentModel);
        this._localElts = (SchemaLocalElement[]) ZeusTransformUtils.preCheckCast(r0.toArray(new SchemaLocalElement[0]), SchemaLocalElement[].class, "com.obric.memorydata.plugin");
    }

    private static QNameSet computeAllContainedElements(SchemaParticle r3, Map<SchemaParticle, QNameSet> r4) {
        SchemaParticle r5 = (SchemaParticle) ZeusTransformUtils.wrapperContextForParams(r3, SchemaParticle.class, "com.obric.memorydata.plugin");
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        QNameSet r0 = (QNameSet) ZeusTransformUtils.preCheckCast(r6.get(r5), QNameSet.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L5;
        return r0;
    L5:
        int r1 = r5.getParticleType();
        if (r1 != 4) goto L8;
        QNameSet r2 = r5.acceptedStartNames();
    L16:
        r6.put(r5, r2);
        return r2;
    L8:
        if (r1 == 5) goto L14;
        QNameSetBuilder r7 = new QNameSetBuilder();
        int r8 = 0;
    L11:
        if (r8 >= r5.countOfParticleChild()) goto L13;
        r7.addAll(computeAllContainedElements(r5.getParticleChild(r8), r6));
        r8 = r8 + 1;
        goto L11
    L13:
        r2 = r7.toQNameSet();
        goto L16
    L14:
        r2 = r5.getWildcardSet();
        goto L16
    }

    private void computeFlatUnionModel() {
        if (getSimpleVariety() != 2) goto L21;
        LinkedHashSet r0 = new LinkedHashSet();
        LinkedHashSet r2 = new LinkedHashSet();
        SchemaType r3 = null;
        r2.add(this);
        SchemaType.Ref[] r4 = this._unionMemberTyperefs;
        int r5 = r4.length;
        int r6 = 0;
    L6:
        if (r6 >= r5) goto L18;
        SchemaTypeImpl r7 = (SchemaTypeImpl) ZeusTransformUtils.preCheckCast(r4[r6].get(), SchemaTypeImpl.class, "com.obric.memorydata.plugin");
        int r8 = r7.getSimpleVariety();
        if (r8 == 1) goto L16;
        if (r8 != 2) goto L11;
        r0.addAll(Arrays.asList(r7.getUnionConstituentTypes()));
        r2.addAll(Arrays.asList(r7.getUnionSubTypes()));
        SchemaType r9 = r7.getUnionCommonBaseType();
        if (r9 == null) goto L17;
        r3 = r9.getCommonBaseType(r3);
    L17:
        r6 = r6 + 1;
        goto L6
    L11:
        if (r8 != 3) goto L17;
    L16:
        r0.add(r7);
        r2.add(r7);
        r3 = r7.getCommonBaseType(r3);
        goto L17
    L18:
        setUnionConstituentTypes((SchemaType[]) ZeusTransformUtils.preCheckCast(r0.toArray(StscState.EMPTY_ST_ARRAY), SchemaType[].class, "com.obric.memorydata.plugin"));
        setUnionSubTypes((SchemaType[]) ZeusTransformUtils.preCheckCast(r2.toArray(StscState.EMPTY_ST_ARRAY), SchemaType[].class, "com.obric.memorydata.plugin"));
        setUnionCommonBaseType(r3);
        return;
    L21:
        throw new IllegalStateException("Operation is only supported on union types");
    }

    private static QNameSet computeNondelimitingElements(QName r4, SchemaParticle r5, Map<SchemaParticle, QNameSet> r6) {
        SchemaParticle r7 = (SchemaParticle) ZeusTransformUtils.wrapperContextForParams(r5, SchemaParticle.class, "com.obric.memorydata.plugin");
        Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin");
        QNameSet r0 = computeAllContainedElements(r7, r8);
        if (r0.contains(r4) == true) goto L7;
        return QNameSet.EMPTY;
    L7:
        if (r7.getMaxOccurs() != null) goto L9;
    L39:
        return r0;
    L9:
        if (r7.getMaxOccurs().compareTo(BigInteger.ONE) > 0) goto L39;
        int r1 = r7.getParticleType();
        int r3 = 0;
        if (r1 != 2) goto L14;
        QNameSetBuilder r2 = new QNameSetBuilder();
    L32:
        if (r3 >= r7.countOfParticleChild()) goto L38;
        if (computeAllContainedElements(r7.getParticleChild(r3), r8).contains(r4) == false) goto L36;
        r2.addAll(computeNondelimitingElements(r4, r7.getParticleChild(r3), r8));
    L36:
        r3 = r3 + 1;
        goto L32
    L38:
        return r2.toQNameSet();
    L14:
        if (r1 != 3) goto L16;
        QNameSetBuilder r9 = new QNameSetBuilder();
        int r10 = r7.countOfParticleChild();
    L21:
        if (r10 <= 0) goto L29;
        r10 = r10 - 1;
        QNameSet r11 = computeAllContainedElements(r7.getParticleChild(r10), r8);
        if (r3 != 0) goto L24;
        if (r11.contains(r4) == false) goto L21;
        r9.addAll(computeNondelimitingElements(r4, r7.getParticleChild(r10), r8));
        r3 = 1;
        goto L21
    L24:
        r9.addAll(r11);
        goto L21
    L29:
        return r9.toQNameSet();
    L16:
        if (r1 == 5) goto L19;
        return r0;
    L19:
        return QNameSet.singleton(r4);
    }

    private XmlObject createBuiltinInstance() {
        switch(getBuiltinTypeCode()) {
            case 0: goto L99;
            case 1: goto L97;
            case 2: goto L95;
            case 3: goto L93;
            case 4: goto L91;
            case 5: goto L89;
            case 6: goto L87;
            case 7: goto L85;
            case 8: goto L83;
            case 9: goto L81;
            case 10: goto L79;
            case 11: goto L77;
            case 12: goto L75;
            case 13: goto L73;
            case 14: goto L71;
            case 15: goto L69;
            case 16: goto L67;
            case 17: goto L65;
            case 18: goto L63;
            case 19: goto L61;
            case 20: goto L59;
            case 21: goto L57;
            case 22: goto L55;
            case 23: goto L53;
            case 24: goto L51;
            case 25: goto L49;
            case 26: goto L47;
            case 27: goto L45;
            case 28: goto L43;
            case 29: goto L41;
            case 30: goto L39;
            case 31: goto L37;
            case 32: goto L35;
            case 33: goto L33;
            case 34: goto L31;
            case 35: goto L29;
            case 36: goto L27;
            case 37: goto L25;
            case 38: goto L23;
            case 39: goto L21;
            case 40: goto L19;
            case 41: goto L17;
            case 42: goto L15;
            case 43: goto L13;
            case 44: goto L11;
            case 45: goto L9;
            case 46: goto L7;
            default: goto L5;
        };
    L5:
        throw new IllegalStateException("Unrecognized builtin type: " + getBuiltinTypeCode());
    L7:
        return new XmlNmTokensImpl();
    L9:
        return new XmlNmTokenImpl();
    L11:
        return new XmlEntitiesImpl();
    L13:
        return new XmlEntityImpl();
    L15:
        return new XmlIdRefsImpl();
    L17:
        return new XmlIdRefImpl();
    L19:
        return new XmlIdImpl();
    L21:
        return new XmlLanguageImpl();
    L23:
        return new XmlNCNameImpl();
    L25:
        return new XmlNameImpl();
    L27:
        return new XmlTokenImpl();
    L29:
        return new XmlNormalizedStringImpl();
    L31:
        return new XmlUnsignedByteImpl();
    L33:
        return new XmlUnsignedShortImpl();
    L35:
        return new XmlUnsignedIntImpl();
    L37:
        return new XmlUnsignedLongImpl();
    L39:
        return new XmlPositiveIntegerImpl();
    L41:
        return new XmlNonNegativeIntegerImpl();
    L43:
        return new XmlNegativeIntegerImpl();
    L45:
        return new XmlNonPositiveIntegerImpl();
    L47:
        return new XmlByteImpl();
    L49:
        return new XmlShortImpl();
    L51:
        return new XmlIntImpl();
    L53:
        return new XmlLongImpl();
    L55:
        return new XmlIntegerImpl();
    L57:
        return new XmlGMonthImpl();
    L59:
        return new XmlGDayImpl();
    L61:
        return new XmlGMonthDayImpl();
    L63:
        return new XmlGYearImpl();
    L65:
        return new XmlGYearMonthImpl();
    L67:
        return new XmlDateImpl();
    L69:
        return new XmlTimeImpl();
    L71:
        return new XmlDateTimeImpl();
    L73:
        return new XmlDurationImpl();
    L75:
        return new XmlStringImpl();
    L77:
        return new XmlDecimalImpl();
    L79:
        return new XmlDoubleImpl();
    L81:
        return new XmlFloatImpl();
    L83:
        return new XmlNotationImpl();
    L85:
        return new XmlQNameImpl();
    L87:
        return new XmlAnyUriImpl();
    L89:
        return new XmlHexBinaryImpl();
    L91:
        return new XmlBase64BinaryImpl();
    L93:
        return new XmlBooleanImpl();
    L95:
        return new XmlAnySimpleTypeImpl();
    L97:
        return new XmlAnyTypeImpl();
    L99:
        return new XmlAnyTypeImpl(BuiltinSchemaTypeSystem.ST_NO_TYPE);
    }

    private XmlObject createBuiltinSubclass(SchemaType r4) {
        SchemaType r5 = (SchemaType) ZeusTransformUtils.wrapperContextForParams(r4, SchemaType.class, "com.obric.memorydata.plugin");
        boolean r0 = !r5.isSimpleType();
        switch(getBuiltinTypeCode()) {
            case 0: goto L116;
            case 1: goto L98;
            case 2: goto L98;
            case 3: goto L97;
            case 4: goto L95;
            case 5: goto L93;
            case 6: goto L91;
            case 7: goto L89;
            case 8: goto L87;
            case 9: goto L85;
            case 10: goto L83;
            case 11: goto L81;
            case 12: goto L75;
            case 13: goto L73;
            case 14: goto L71;
            case 15: goto L69;
            case 16: goto L67;
            case 17: goto L65;
            case 18: goto L63;
            case 19: goto L61;
            case 20: goto L59;
            case 21: goto L57;
            case 22: goto L55;
            case 23: goto L53;
            case 24: goto L51;
            case 25: goto L49;
            case 26: goto L47;
            case 27: goto L45;
            case 28: goto L43;
            case 29: goto L41;
            case 30: goto L39;
            case 31: goto L37;
            case 32: goto L35;
            case 33: goto L33;
            case 34: goto L31;
            case 35: goto L29;
            case 36: goto L27;
            case 37: goto L25;
            case 38: goto L23;
            case 39: goto L21;
            case 40: goto L19;
            case 41: goto L17;
            case 42: goto L15;
            case 43: goto L13;
            case 44: goto L11;
            case 45: goto L9;
            case 46: goto L7;
            default: goto L5;
        };
    L98:
        int r3 = r5.getSimpleVariety();
        if (r3 == 0) goto L114;
        if (r3 == 1) goto L112;
        if (r3 == 2) goto L110;
        if (r3 != 3) goto L108;
        return new XmlListImpl(r5, r0);
    L108:
        throw new IllegalStateException();
    L110:
        return new XmlUnionImpl(r5, r0);
    L112:
        return new XmlAnySimpleTypeRestriction(r5, r0);
    L114:
        return new XmlComplexContentImpl(r5);
    L5:
        throw new IllegalStateException("Unrecognized builtin type: " + getBuiltinTypeCode());
    L7:
        return new XmlNmTokensImpl(r5, r0);
    L9:
        return new XmlNmTokenImpl(r5, r0);
    L11:
        return new XmlEntitiesImpl(r5, r0);
    L13:
        return new XmlEntityImpl(r5, r0);
    L15:
        return new XmlIdRefsImpl(r5, r0);
    L17:
        return new XmlIdRefImpl(r5, r0);
    L19:
        return new XmlIdImpl(r5, r0);
    L21:
        return new XmlLanguageImpl(r5, r0);
    L23:
        return new XmlNCNameImpl(r5, r0);
    L25:
        return new XmlNameImpl(r5, r0);
    L27:
        return new XmlTokenImpl(r5, r0);
    L29:
        return new XmlNormalizedStringImpl(r5, r0);
    L31:
        return new XmlUnsignedByteImpl(r5, r0);
    L33:
        return new XmlUnsignedShortImpl(r5, r0);
    L35:
        return new XmlUnsignedIntImpl(r5, r0);
    L37:
        return new XmlUnsignedLongImpl(r5, r0);
    L39:
        return new XmlPositiveIntegerImpl(r5, r0);
    L41:
        return new XmlNonNegativeIntegerImpl(r5, r0);
    L43:
        return new XmlNegativeIntegerImpl(r5, r0);
    L45:
        return new XmlNonPositiveIntegerImpl(r5, r0);
    L47:
        return new XmlByteImpl(r5, r0);
    L49:
        return new XmlShortImpl(r5, r0);
    L51:
        return new XmlIntRestriction(r5, r0);
    L53:
        return new XmlLongRestriction(r5, r0);
    L55:
        return new XmlIntegerRestriction(r5, r0);
    L57:
        return new XmlGMonthImpl(r5, r0);
    L59:
        return new XmlGDayImpl(r5, r0);
    L61:
        return new XmlGMonthDayImpl(r5, r0);
    L63:
        return new XmlGYearImpl(r5, r0);
    L65:
        return new XmlGYearMonthImpl(r5, r0);
    L67:
        return new XmlDateImpl(r5, r0);
    L69:
        return new XmlTimeImpl(r5, r0);
    L71:
        return new XmlDateTimeImpl(r5, r0);
    L73:
        return new XmlDurationImpl(r5, r0);
    L75:
        if (r5.hasStringEnumValues() == false) goto L79;
        return new XmlStringEnumeration(r5, r0);
    L79:
        return new XmlStringRestriction(r5, r0);
    L81:
        return new XmlDecimalRestriction(r5, r0);
    L83:
        return new XmlDoubleRestriction(r5, r0);
    L85:
        return new XmlFloatRestriction(r5, r0);
    L87:
        return new XmlNotationRestriction(r5, r0);
    L89:
        return new XmlQNameRestriction(r5, r0);
    L91:
        return new XmlAnyUriRestriction(r5, r0);
    L93:
        return new XmlHexBinaryRestriction(r5, r0);
    L95:
        return new XmlBase64BinaryRestriction(r5, r0);
    L97:
        return new XmlBooleanRestriction(r5, r0);
    L116:
        return new XmlAnyTypeImpl(BuiltinSchemaTypeSystem.ST_NO_TYPE);
    }

    private XmlObject createUnattachedNode(SchemaProperty r5) {
        SchemaProperty r6 = (SchemaProperty) ZeusTransformUtils.wrapperContextForParams(r5, SchemaProperty.class, "com.obric.memorydata.plugin");
        if (isBuiltinType() == false) goto L5;
    L13:
        XmlObject r0 = createBuiltinInstance();
    L14:
        SchemaType r2 = this;
    L15:
        if (r0 != null) goto L17;
        r0 = ((SchemaTypeImpl) ZeusTransformUtils.preCheckCast(r2, SchemaTypeImpl.class, "com.obric.memorydata.plugin")).createUnattachedSubclass(this);
        r2 = r2.getBaseType();
        goto L15
    L17:
        ((XmlObjectBase) ZeusTransformUtils.preCheckCast(r0, XmlObjectBase.class, "com.obric.memorydata.plugin")).init_flags(r6);
        return r0;
    L5:
        if (isNoType() == true) goto L13;
        Constructor<? extends XmlObjectBase> r1 = getJavaImplConstructor();
        if (r1 != null) goto L19;
    L12:
        r0 = null;
        goto L14
    L19:
        return (XmlObject) ZeusTransformUtils.preCheckCast(r1.newInstance(this._ctrArgs), XmlObject.class, "com.obric.memorydata.plugin");
    L10:
        e = move-exception;
        System.out.println("Exception trying to instantiate impl class.");
        e.printStackTrace();
        goto L12
    }

    private XmlObject createUnattachedSubclass(SchemaType r6) {
        SchemaType r7 = (SchemaType) ZeusTransformUtils.wrapperContextForParams(r6, SchemaType.class, "com.obric.memorydata.plugin");
        if (isBuiltinType() == true) goto L20;
        if (isNoType() == true) goto L20;
        Constructor<? extends XmlObjectBase> r5 = getJavaImplConstructor2();
        if (r5 != null) goto L21;
        return null;
    L21:
        Object[] r2 = new Object[2];     // Catch: Throwable -> L16
        boolean r3 = false;
        r2[0] = r7;     // Catch: Throwable -> L16
        if (r7.isSimpleType() == true) goto L13;
        r3 = true;
    L13:
        r2[1] = Boolean.valueOf(r3);     // Catch: Throwable -> L16
        return (XmlObject) ZeusTransformUtils.preCheckCast(r5.newInstance(r2), XmlObject.class, "com.obric.memorydata.plugin");
    L16:
        e = move-exception;
        XBeanDebug.LOG.atDebug().a(e).a(e.getMessage());
        return null;
    L20:
        return createBuiltinSubclass(r7);
    }

    private void ensureStringEnumInfo() {
        if (this._stringEnumEnsured == false) goto L5;
        return;
    L5:
        SchemaStringEnumEntry[] r0 = this._stringEnumEntries;
        if (r0 != null) goto L9;
        this._stringEnumEnsured = true;
        return;
    L9:
        HashMap r2 = new HashMap(r0.length);
        ArrayList r3 = new ArrayList(r0.length + 1);
        HashMap r4 = new HashMap(r0.length);
        int r5 = r0.length;
        int r6 = 0;
        int r7 = 0;
    L10:
        if (r7 >= r5) goto L12;
        SchemaStringEnumEntry r8 = r0[r7];
        r4.put(r8.getString(), r8);
        r7 = r7 + 1;
        goto L10
    L12:
        Class<? extends StringEnumAbstractBase> r9 = this._baseEnumTyperef.get().getEnumJavaClass();
        if (r9 != null) goto L48;
    L23:
        if (r9 != null) goto L31;
        int r10 = r0.length;
    L25:
        if (r6 >= r10) goto L31;
        SchemaStringEnumEntry r11 = r0[r6];
        int r12 = r11.getIntValue();
        String r13 = r11.getString();
        StringEnumValue r14 = new StringEnumValue(r13, r12);
        r2.put(r13, r14);
    L28:
        if (r3.size() > r12) goto L30;
        r3.add(null);
        goto L28
    L30:
        r3.set(r12, r14);
        r6 = r6 + 1;
    L31:
        monitor-enter(this);
    L43:
        th = move-exception;
        throw th;
    L33:
        if (this._stringEnumEnsured == true) goto L35;
        this._lookupStringEnum = r2;     // Catch: Throwable -> L43
        this._listOfStringEnum = r3;     // Catch: Throwable -> L43
        this._lookupStringEnumEntry = r4;     // Catch: Throwable -> L43
    L35:
        monitor-exit(this);     // Catch: Throwable -> L43
        monitor-enter(this);
        this._stringEnumEnsured = true;     // Catch: Throwable -> L40
        monitor-exit(this);     // Catch: Throwable -> L40
        return;
    L40:
        th = move-exception;
        throw th;
    L48:
        StringEnumAbstractBase.Table r15 = (StringEnumAbstractBase.Table) ZeusTransformUtils.preCheckCast(r9.getField("table").get(null), StringEnumAbstractBase.Table.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L22
        int r16 = r0.length;     // Catch: Exception -> L22
        int r17 = 0;
    L15:
        if (r17 >= r16) goto L23;
        SchemaStringEnumEntry r18 = r0[r17];     // Catch: Exception -> L22
        int r19 = r18.getIntValue();     // Catch: Exception -> L22
        StringEnumAbstractBase r110 = r15.forInt(r19);     // Catch: Exception -> L22
        r2.put(r18.getString(), r110);     // Catch: Exception -> L22
    L18:
        if (r3.size() > r19) goto L20;
        r3.add(null);     // Catch: Exception -> L22
        goto L18
    L20:
        r3.set(r19, r110);     // Catch: Exception -> L22
        r17 = r17 + 1;
    L22:
        System.err.println("Something wrong: could not locate enum table for " + r9);
        r2.clear();
        r3.clear();
        r9 = null;
        goto L23
    }

    private void finishQuick() {
        this._resolvePhase = 6;
    }

    private boolean noElements() {
        if (getContentType() != 3) goto L5;
    L7:
        return false;
    L5:
        if (getContentType() == 4) goto L7;
        return true;
    }

    private void setUnionCommonBaseType(SchemaType r3) {
        this._unionCommonBaseType = (SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin");
    }

    private void setUnionConstituentTypes(SchemaType[] r1) {
        this._unionConstituentTypes = r1;
    }

    private void setUnionSubTypes(SchemaType[] r1) {
        this._unionSubTypes = r1;
    }

    private static SchemaType[] staCopy(SchemaType[] r3) {
        if (r3 != null) goto L5;
        return null;
    L5:
        SchemaType[] r0 = new SchemaType[r3.length];
        System.arraycopy(r3, 0, r0, 0, r3.length);
        return r0;
    }

    synchronized void assignJavaElementSetterModel() {
        monitor-enter(this);
        SchemaProperty[] r0 = getElementProperties();     // Catch: Throwable -> L9
        SchemaParticle r1 = getContentModel();     // Catch: Throwable -> L9
        HashMap r2 = new HashMap();     // Catch: Throwable -> L9
        QNameSet r3 = computeAllContainedElements(r1, r2);     // Catch: Throwable -> L9
        int r4 = r0.length;     // Catch: Throwable -> L9
        int r5 = 0;
    L4:
        if (r5 >= r4) goto L7;
        SchemaPropertyImpl r6 = (SchemaPropertyImpl) ZeusTransformUtils.preCheckCast(r0[r5], SchemaPropertyImpl.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        QNameSet r7 = computeNondelimitingElements(r6.getName(), r1, r2);     // Catch: Throwable -> L9
        QNameSetBuilder r8 = new QNameSetBuilder(r3);     // Catch: Throwable -> L9
        r8.removeAll(r7);     // Catch: Throwable -> L9
        r6.setJavaSetterDelimiter(r8.toQNameSet());     // Catch: Throwable -> L9
        r5 = r5 + 1;
        goto L4
    L7:
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public boolean blockExtension() {
        return this._blockExt;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public boolean blockRestriction() {
        return this._blockRest;
    }

    public XmlObject createAttributeType(QName r6, SchemaTypeLoader r7) {
        SchemaTypeLoader r8 = (SchemaTypeLoader) ZeusTransformUtils.wrapperContextForParams(r7, SchemaTypeLoader.class, "com.obric.memorydata.plugin");
        if (isSimpleType() == false) goto L5;
    L20:
        SchemaTypeImpl r5 = BuiltinSchemaTypeSystem.ST_NO_TYPE;
    L21:
        SchemaProperty r1 = null;
    L22:
        if (r5 != null) goto L24;
        return null;
    L24:
        return r5.createUnattachedNode(r1);
    L5:
        if (isNoType() == true) goto L20;
        if (isURType() == false) goto L10;
        r5 = BuiltinSchemaTypeSystem.ST_ANY_SIMPLE;
        goto L21
    L10:
        r1 = (SchemaProperty) ZeusTransformUtils.preCheckCast(this._propertyModelByAttributeName.get(r6), SchemaProperty.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L15;
        SchemaType r9 = r1.getType();
    L13:
        r5 = (SchemaTypeImpl) ZeusTransformUtils.preCheckCast(r9, SchemaTypeImpl.class, "com.obric.memorydata.plugin");
        goto L22
    L15:
        if (this._typedWildcardAttributes.contains(r6) == true) goto L17;
    L16:
        r5 = BuiltinSchemaTypeSystem.ST_NO_TYPE;
        goto L22
    L17:
        SchemaGlobalAttribute r10 = r8.findAttribute(r6);
        if (r10 == null) goto L16;
        r9 = r10.getType();
        goto L13
    }

    public XmlObject createElementType(QName r5, QName r6, SchemaTypeLoader r7) {
        SchemaTypeLoader r8 = (SchemaTypeLoader) ZeusTransformUtils.wrapperContextForParams(r7, SchemaTypeLoader.class, "com.obric.memorydata.plugin");
        if (isSimpleType() == false) goto L5;
    L29:
        SchemaType r4 = BuiltinSchemaTypeSystem.ST_NO_TYPE;
        SchemaProperty r0 = null;
    L30:
        if (r4 != null) goto L32;
        return null;
    L32:
        return ((SchemaTypeImpl) ZeusTransformUtils.preCheckCast(r4, SchemaTypeImpl.class, "com.obric.memorydata.plugin")).createUnattachedNode(r0);
    L5:
        if (noElements() == true) goto L29;
        if (isNoType() == true) goto L29;
        r0 = (SchemaProperty) ZeusTransformUtils.preCheckCast(this._propertyModelByElementName.get(r5), SchemaProperty.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L13;
        r4 = r0.getType();
    L23:
        if (r6 == null) goto L30;
        SchemaType r9 = r8.findType(r6);
        if (r9 == null) goto L30;
        if (r4.isAssignableFrom(r9) == false) goto L30;
        r4 = r9;
        goto L30
    L13:
        if (this._typedWildcardElements.contains(r5) == false) goto L15;
    L18:
        SchemaGlobalElement r10 = r8.findElement(r5);
        if (r10 != null) goto L20;
    L17:
        r4 = BuiltinSchemaTypeSystem.ST_NO_TYPE;
        goto L23
    L20:
        r4 = r10.getType();
        SchemaType r3 = r8.findDocumentType(r5);
        if (r3 == null) goto L23;
        r0 = r3.getElementProperty(r5);
        goto L23
    L15:
        if (this._validSubstitutions.contains(r5) == false) goto L17;
        goto L17
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStoreUserFactory
    public TypeStoreUser createTypeStoreUser() {
        return (TypeStoreUser) ZeusTransformUtils.preCheckCast(createUnattachedNode(null), TypeStoreUser.class, "com.obric.memorydata.plugin");
    }

    @Override // org.apache.xmlbeans.SchemaType
    public StringEnumAbstractBase enumForString(String r2) {
        ensureStringEnumInfo();
        if (this._lookupStringEnum != null) goto L7;
        return null;
    L7:
        return (StringEnumAbstractBase) ZeusTransformUtils.preCheckCast(this._lookupStringEnum.get(r2), StringEnumAbstractBase.class, "com.obric.memorydata.plugin");
    }

    @Override // org.apache.xmlbeans.SchemaType
    public SchemaType[] getAnonymousTypes() {
        int r0 = this._anonymousTyperefs.length;
        SchemaType[] r1 = new SchemaType[r0];
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        r1[r2] = this._anonymousTyperefs[r2].get();
        r2 = r2 + 1;
        goto L3
    L5:
        return r1;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public int getAnonymousUnionMemberOrdinal() {
        return this._anonymousUnionMemberOrdinal;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public SchemaAttributeModel getAttributeModel() {
        return this._attributeModel;
    }

    public SchemaProperty[] getAttributeProperties() {
        Map<QName, SchemaProperty> r2 = this._propertyModelByAttributeName;
        if (r2 != null) goto L7;
        return NO_PROPERTIES;
    L7:
        return (SchemaProperty[]) ZeusTransformUtils.preCheckCast(r2.values().toArray(new SchemaProperty[0]), SchemaProperty[].class, "com.obric.memorydata.plugin");
    }

    @Override // org.apache.xmlbeans.SchemaType
    public SchemaProperty getAttributeProperty(QName r2) {
        Map<QName, SchemaProperty> r1 = this._propertyModelByAttributeName;
        if (r1 != null) goto L6;
        return null;
    L6:
        return (SchemaProperty) ZeusTransformUtils.preCheckCast(r1.get(r2), SchemaProperty.class, "com.obric.memorydata.plugin");
    }

    @Override // org.apache.xmlbeans.SchemaType
    public SchemaType getAttributeType(QName r4, SchemaTypeLoader r5) {
        SchemaTypeLoader r6 = (SchemaTypeLoader) ZeusTransformUtils.wrapperContextForParams(r5, SchemaTypeLoader.class, "com.obric.memorydata.plugin");
        if (isSimpleType() == true) goto L28;
        if (isNoType() == true) goto L28;
        if (isURType() == true) goto L10;
        SchemaProperty r0 = (SchemaProperty) ZeusTransformUtils.preCheckCast(this._propertyModelByAttributeName.get(r4), SchemaProperty.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L16;
        return r0.getType();
    L16:
        if (this._typedWildcardAttributes.contains(r4) == false) goto L26;
        if (r6 == null) goto L26;
        SchemaGlobalAttribute r3 = r6.findAttribute(r4);
        if (r3 != null) goto L24;
        return BuiltinSchemaTypeSystem.ST_NO_TYPE;
    L24:
        return r3.getType();
    L26:
        return BuiltinSchemaTypeSystem.ST_NO_TYPE;
    L10:
        return BuiltinSchemaTypeSystem.ST_ANY_SIMPLE;
    L28:
        return BuiltinSchemaTypeSystem.ST_NO_TYPE;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public QName getAttributeTypeAttributeName() {
        if (this._isAttributeType == false) goto L12;
        SchemaAttributeModel r1 = getAttributeModel();
        if (r1 == null) goto L14;
        SchemaLocalAttribute[] r2 = r1.getAttributes();
        if (r2 != null) goto L9;
        return null;
    L9:
        if (r2.length > 0) goto L11;
        return null;
    L11:
        return r2[0].getName();
    L14:
        return null;
    L12:
        return null;
    }

    public int getBaseDepth() {
        return this._baseDepth;
    }

    public SchemaType getBaseEnumType() {
        SchemaType.Ref r0 = this._baseEnumTyperef;
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.get();
    }

    @Override // org.apache.xmlbeans.SchemaType
    public SchemaType getBaseType() {
        SchemaType.Ref r0 = this._baseTyperef;
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.get();
    }

    @Override // org.apache.xmlbeans.SchemaType
    public int getBuiltinTypeCode() {
        return this._builtinTypeCode;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v10, types: [org.apache.xmlbeans.impl.schema.SchemaTypeImpl] */
    @Override // org.apache.xmlbeans.SchemaType
    public SchemaType getCommonBaseType(SchemaType r5) {
        SchemaType r6 = (SchemaType) ZeusTransformUtils.wrapperContextForParams(r5, SchemaType.class, "com.obric.memorydata.plugin");
        if (this == BuiltinSchemaTypeSystem.ST_ANY_TYPE) goto L23;
        if (r6 == 0) goto L23;
        if (r6.isNoType() == true) goto L23;
        if (r6 == BuiltinSchemaTypeSystem.ST_ANY_TYPE) goto L22;
        Object r7 = r6;
        if (isNoType() == true) goto L22;
    L13:
        r6 = (SchemaTypeImpl) ZeusTransformUtils.preCheckCast(r7, SchemaTypeImpl.class, "com.obric.memorydata.plugin");
        if (r6.getBaseDepth() <= getBaseDepth()) goto L17;
        r7 = r6.getBaseType();
    L17:
        if (this.getBaseDepth() <= r6.getBaseDepth()) goto L20;
        SchemaTypeImpl this = (SchemaTypeImpl) ZeusTransformUtils.preCheckCast(this.getBaseType(), SchemaTypeImpl.class, "com.obric.memorydata.plugin");
    L20:
        if (r6.equals(this) == true) goto L22;
        r6 = (SchemaTypeImpl) ZeusTransformUtils.preCheckCast(r6.getBaseType(), SchemaTypeImpl.class, "com.obric.memorydata.plugin");
        this = (SchemaTypeImpl) ZeusTransformUtils.preCheckCast(this.getBaseType(), SchemaTypeImpl.class, "com.obric.memorydata.plugin");
    L22:
        return r6;
    L23:
        return this;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public synchronized SchemaField getContainerField() {
        monitor-enter(this);
    L20:
        th = move-exception;
        throw th;
    L4:
        if (this._containerFieldCode == (-1)) goto L17;
        SchemaType r0 = getOuterType();     // Catch: Throwable -> L20
        if (this._containerFieldCode != 0) goto L13;
        if (this._containerFieldRef != null) goto L10;
        SchemaField r1 = null;
    L11:
        this._containerField = r1;     // Catch: Throwable -> L20
        this._containerFieldCode = -1;     // Catch: Throwable -> L20
        goto L17
    L10:
        r1 = (SchemaField) ZeusTransformUtils.preCheckCast(this._containerFieldRef.getComponent(), SchemaField.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L20
        goto L11
    L13:
        if (this._containerFieldCode != 1) goto L15;
        r1 = r0.getAttributeModel().getAttributes()[this._containerFieldIndex];     // Catch: Throwable -> L20
        goto L11
    L15:
        r1 = ((SchemaTypeImpl) ZeusTransformUtils.preCheckCast(r0, SchemaTypeImpl.class, "com.obric.memorydata.plugin")).getLocalElementByIndex(this._containerFieldIndex);     // Catch: Throwable -> L20
    L17:
        SchemaField r2 = this._containerField;     // Catch: Throwable -> L20
        monitor-exit(this);
        return r2;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public SchemaType getContentBasedOnType() {
        SchemaType.Ref r0 = this._contentBasedOnTyperef;
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.get();
    }

    @Override // org.apache.xmlbeans.SchemaType
    public SchemaParticle getContentModel() {
        return this._contentModel;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public int getContentType() {
        return this._complexTypeVariety;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public int getDecimalSize() {
        return this._decimalSize;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public int getDerivationType() {
        return this._derivationType;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public QName getDocumentElementName() {
        if (this._isDocumentType == false) goto L8;
        SchemaParticle r1 = getContentModel();
        if (r1 != null) goto L7;
        return null;
    L7:
        return r1.getName();
    L8:
        return null;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public SchemaProperty[] getElementProperties() {
        Map<QName, SchemaProperty> r2 = this._propertyModelByElementName;
        if (r2 != null) goto L7;
        return NO_PROPERTIES;
    L7:
        return (SchemaProperty[]) ZeusTransformUtils.preCheckCast(r2.values().toArray(new SchemaProperty[0]), SchemaProperty[].class, "com.obric.memorydata.plugin");
    }

    @Override // org.apache.xmlbeans.SchemaType
    public SchemaProperty getElementProperty(QName r2) {
        Map<QName, SchemaProperty> r1 = this._propertyModelByElementName;
        if (r1 != null) goto L6;
        return null;
    L6:
        return (SchemaProperty) ZeusTransformUtils.preCheckCast(r1.get(r2), SchemaProperty.class, "com.obric.memorydata.plugin");
    }

    @Override // org.apache.xmlbeans.SchemaType
    public SchemaType getElementType(QName r4, QName r5, SchemaTypeLoader r6) {
        SchemaTypeLoader r7 = (SchemaTypeLoader) ZeusTransformUtils.wrapperContextForParams(r6, SchemaTypeLoader.class, "com.obric.memorydata.plugin");
        if (isSimpleType() == true) goto L36;
        if (noElements() == true) goto L36;
        if (isNoType() == true) goto L36;
        SchemaProperty r0 = (SchemaProperty) ZeusTransformUtils.preCheckCast(this._propertyModelByElementName.get(r4), SchemaProperty.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L12;
        SchemaType r3 = r0.getType();
    L27:
        if (r5 == null) goto L34;
        if (r7 == null) goto L34;
        SchemaType r8 = r7.findType(r5);
        if (r8 == null) goto L34;
        if (r3.isAssignableFrom(r8) == false) goto L34;
        return r8;
    L34:
        return r3;
    L12:
        if (r7 != null) goto L16;
        return BuiltinSchemaTypeSystem.ST_NO_TYPE;
    L16:
        if (this._typedWildcardElements.contains(r4) == false) goto L18;
    L22:
        SchemaGlobalElement r9 = r7.findElement(r4);
        if (r9 == null) goto L25;
        r3 = r9.getType();
        goto L27
    L25:
        return BuiltinSchemaTypeSystem.ST_NO_TYPE;
    L18:
        if (this._validSubstitutions.contains(r4) == true) goto L22;
        return BuiltinSchemaTypeSystem.ST_NO_TYPE;
    L36:
        return BuiltinSchemaTypeSystem.ST_NO_TYPE;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public Class<? extends StringEnumAbstractBase> getEnumJavaClass() {
        if (this._javaEnumClass != null) goto L10;
        if (getBaseEnumType() == null) goto L10;
        this._javaEnumClass = Class.forName(getBaseEnumType().getFullJavaName() + "$Enum", false, getTypeSystem().getClassLoader());     // Catch: ClassNotFoundException -> L8
    L8:
        this._javaEnumClass = null;
    L10:
        return this._javaEnumClass;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public XmlAnySimpleType[] getEnumerationValues() {
        XmlValueRef[] r0 = this._enumerationValues;
        if (r0 != null) goto L5;
        return null;
    L5:
        int r1 = r0.length;
        XmlAnySimpleType[] r2 = new XmlAnySimpleType[r1];
        int r3 = 0;
    L6:
        if (r3 >= r1) goto L12;
        XmlValueRef r4 = this._enumerationValues[r3];
        if (r4 != null) goto L10;
        XmlAnySimpleType r5 = null;
    L11:
        r2[r3] = r5;
        r3 = r3 + 1;
        goto L6
    L10:
        r5 = r4.get();
        goto L11
    L12:
        return r2;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public XmlAnySimpleType getFacet(int r2) {
        XmlValueRef[] r1 = this._facetArray;
        if (r1 != null) goto L5;
        return null;
    L5:
        XmlValueRef r3 = r1[r2];
        if (r3 != null) goto L9;
        return null;
    L9:
        return r3.get();
    }

    public String getFullJavaImplName() {
        return this._fullJavaImplName;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public String getFullJavaName() {
        return this._fullJavaName;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public Class<? extends XmlObject> getJavaClass() {
        if (this._javaClass != null) goto L10;
        if (getFullJavaName() == null) goto L10;
        this._javaClass = Class.forName(getFullJavaName(), false, getTypeSystem().getClassLoader());     // Catch: ClassNotFoundException -> L8
    L8:
        this._javaClass = null;
    L10:
        return this._javaClass;
    }

    public Class<? extends XmlObjectBase> getJavaImplClass() {
        if (this._implNotAvailable == false) goto L7;
        return null;
    L7:
        if (this._javaImplClass != null) goto L16;
    L14:
        this._implNotAvailable = true;
        goto L16
    L10:
        if (getFullJavaImplName() == null) goto L12;
        this._javaImplClass = Class.forName(getFullJavaImplName(), false, getTypeSystem().getClassLoader());     // Catch: ClassNotFoundException -> L14
    L17:
        goto L16
    L12:
        this._implNotAvailable = true;     // Catch: ClassNotFoundException -> L14
    L16:
        return this._javaImplClass;
    }

    public Constructor<? extends XmlObjectBase> getJavaImplConstructor() {
        if (this._javaImplConstructor != null) goto L16;
        if (this._implNotAvailable == true) goto L16;
        Class<? extends XmlObjectBase> r0 = getJavaImplClass();
        if (r0 != null) goto L17;
        return null;
    L17:
        this._javaImplConstructor = r0.getConstructor(new Class[]{SchemaType.class});     // Catch: NoSuchMethodException -> L13
    L13:
        e = move-exception;
        e.printStackTrace();
    L16:
        return this._javaImplConstructor;
    }

    public Constructor<? extends XmlObjectBase> getJavaImplConstructor2() {
        if (this._javaImplConstructor2 != null) goto L16;
        if (this._implNotAvailable == true) goto L16;
        Class<? extends XmlObjectBase> r0 = getJavaImplClass();
        if (r0 != null) goto L17;
        return null;
    L17:
        this._javaImplConstructor2 = r0.getDeclaredConstructor(new Class[]{SchemaType.class, Boolean.TYPE});     // Catch: NoSuchMethodException -> L13
    L13:
        e = move-exception;
        e.printStackTrace();
    L16:
        return this._javaImplConstructor2;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public SchemaType getListItemType() {
        SchemaType.Ref r0 = this._listItemTyperef;
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.get();
    }

    public SchemaLocalElement getLocalElementByIndex(int r2) {
        SchemaLocalElement[] r0 = this._localElts;
        if (r0 != null) goto L6;
        buildLocalElts();
        r0 = this._localElts;
    L6:
        return r0[r2];
    }

    @Override // org.apache.xmlbeans.SchemaType, org.apache.xmlbeans.SchemaComponent
    public QName getName() {
        return this._name;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public SchemaType getOuterType() {
        SchemaType.Ref r0 = this._outerSchemaTypeRef;
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.get();
    }

    @Override // org.apache.xmlbeans.SchemaType
    public SchemaType getPrimitiveType() {
        SchemaType.Ref r0 = this._primitiveTypeRef;
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.get();
    }

    @Override // org.apache.xmlbeans.SchemaType
    public SchemaProperty[] getProperties() {
        if (this._propertyModelByElementName != null) goto L7;
        return getAttributeProperties();
    L7:
        if (this._propertyModelByAttributeName == null) goto L9;
        ArrayList r0 = new ArrayList();
        r0.addAll(this._propertyModelByElementName.values());
        r0.addAll(this._propertyModelByAttributeName.values());
        return (SchemaProperty[]) ZeusTransformUtils.preCheckCast(r0.toArray(new SchemaProperty[0]), SchemaProperty[].class, "com.obric.memorydata.plugin");
    L9:
        return getElementProperties();
    }

    @Override // org.apache.xmlbeans.SchemaType
    public SchemaType.Ref getRef() {
        return this._selfref;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public int getSimpleVariety() {
        return this._simpleTypeVariety;
    }

    public SchemaTypeSystem getTypeSystem() {
        return this._container.getTypeSystem();
    }

    public synchronized SchemaType getUnionCommonBaseType() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this._unionCommonBaseType != null) goto L6;
        computeFlatUnionModel();     // Catch: Throwable -> L9
    L6:
        SchemaType r0 = this._unionCommonBaseType;     // Catch: Throwable -> L9
        monitor-exit(this);
        return r0;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public synchronized SchemaType[] getUnionConstituentTypes() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this._unionCommonBaseType != null) goto L6;
        computeFlatUnionModel();     // Catch: Throwable -> L9
    L6:
        SchemaType[] r0 = staCopy(this._unionConstituentTypes);     // Catch: Throwable -> L9
        monitor-exit(this);
        return r0;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public SchemaType[] getUnionMemberTypes() {
        SchemaType.Ref[] r0 = this._unionMemberTyperefs;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        SchemaType[] r3 = new SchemaType[r2];
    L7:
        if (r1 >= r2) goto L9;
        r3[r1] = this._unionMemberTyperefs[r1].get();
        r1 = r1 + 1;
        goto L7
    L9:
        return r3;
    L5:
        r2 = r0.length;
        goto L6
    }

    public synchronized SchemaType[] getUnionSubTypes() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this._unionCommonBaseType != null) goto L6;
        computeFlatUnionModel();     // Catch: Throwable -> L9
    L6:
        SchemaType[] r0 = staCopy(this._unionSubTypes);     // Catch: Throwable -> L9
        monitor-exit(this);
        return r0;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public int getWhiteSpaceRule() {
        return this._whiteSpaceRule;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public boolean hasPatternFacet() {
        return this._hasPatterns;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public boolean hasStringEnumValues() {
        if (this._stringEnumEntries == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public boolean isAbstract() {
        return this._abs;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public boolean isAssignableFrom(SchemaType r8) {
        SchemaType r9 = (SchemaType) ZeusTransformUtils.wrapperContextForParams(r8, SchemaType.class, "com.obric.memorydata.plugin");
        if (r9 != null) goto L5;
        return true;
    L5:
        if (r9.isNoType() == false) goto L8;
        return true;
    L8:
        if (isNoType() == false) goto L11;
        return false;
    L11:
        if (getSimpleVariety() != 2) goto L18;
        SchemaType[] r2 = getUnionMemberTypes();
        int r4 = r2.length;
        int r5 = 0;
    L13:
        if (r5 >= r4) goto L18;
        if (r2[r5].isAssignableFrom(r9) == true) goto L16;
        r5 = r5 + 1;
        goto L13
    L16:
        return true;
    L18:
        int r1 = ((SchemaTypeImpl) ZeusTransformUtils.preCheckCast(r9, SchemaTypeImpl.class, "com.obric.memorydata.plugin")).getBaseDepth() - getBaseDepth();
        if (r1 >= 0) goto L21;
        return false;
    L21:
        if (r1 <= 0) goto L23;
        r9 = r9.getBaseType();
        r1 = r1 - 1;
        goto L21
    L23:
        if (r9 == null) goto L28;
        if (r9.equals(this) == false) goto L28;
        return true;
    L28:
        return false;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public boolean isAttributeType() {
        return this._isAttributeType;
    }

    public boolean isBuiltinType() {
        if (getBuiltinTypeCode() == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public boolean isDocumentType() {
        return this._isDocumentType;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public boolean isNoType() {
        if (this != BuiltinSchemaTypeSystem.ST_NO_TYPE) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public boolean isOrderSensitive() {
        return this._orderSensitive;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public boolean isSimpleType() {
        return this._isSimpleType;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public boolean isURType() {
        int r2 = this._builtinTypeCode;
        if (r2 != 1) goto L5;
        return true;
    L5:
        if (r2 == 2) goto L10;
        return false;
    L10:
        return true;
    }

    @Override // org.apache.xmlbeans.SchemaType
    public boolean isValidSubstitution(QName r1) {
        return this._validSubstitutions.contains(r1);
    }

    @Override // org.apache.xmlbeans.SchemaType
    public boolean matchPatternFacet(String r5) {
        if (this._hasPatterns == true) goto L6;
        return true;
    L6:
        RegularExpression[] r0 = this._patterns;
        if (r0 == null) goto L21;
        if (r0.length <= 0) goto L21;
        int r1 = 0;
    L11:
        RegularExpression[] r2 = this._patterns;
        if (r1 >= r2.length) goto L18;
        if (r2[r1].matches(r5) == true) goto L18;
        r1 = r1 + 1;
    L18:
        if (r1 < this._patterns.length) goto L21;
        return false;
    L21:
        return getBaseType().matchPatternFacet(r5);
    }

    public XmlAnySimpleType newValidatingValue(Object r2) {
        return newValue(r2, true);
    }

    @Override // org.apache.xmlbeans.SchemaType
    public XmlAnySimpleType newValue(Object r2) {
        return newValue(r2, false);
    }

    public XmlAnySimpleType newValue(Object r3, boolean r4) {
        if (isSimpleType() == false) goto L5;
    L9:
        XmlObjectBase r2 = (XmlObjectBase) ZeusTransformUtils.preCheckCast(createUnattachedNode(null), XmlObjectBase.class, "com.obric.memorydata.plugin");
        if (r4 == false) goto L13;
        r2.setValidateOnSet();
    L13:
        if (ZeusTransformUtils.instanceOf(r3, XmlObject.class) == false) goto L15;
        r2.set_newValue((XmlObject) ZeusTransformUtils.preCheckCast(r3, XmlObject.class, "com.obric.memorydata.plugin"));
    L16:
        r2.check_dated();
        r2.setImmutable();
        return (XmlAnySimpleType) ZeusTransformUtils.preCheckCast(r2, XmlAnySimpleType.class, "com.obric.memorydata.plugin");
    L15:
        r2.setObjectValue(r3);
        goto L16
    L5:
        if (getContentType() == 2) goto L9;
        throw new XmlValueOutOfRangeException();
    }

    void setAbstractFinal(boolean r1, boolean r2, boolean r3, boolean r4, boolean r5) {
        assertResolving();
        this._abs = r1;
        this._finalExt = r2;
        this._finalRest = r3;
        this._finalList = r4;
        this._finalUnion = r5;
    }

    public void setAnnotation(SchemaAnnotation r3) {
        SchemaAnnotation r4 = (SchemaAnnotation) ZeusTransformUtils.wrapperContextForParams(r3, SchemaAnnotation.class, "com.obric.memorydata.plugin");
        assertUnresolved();
        this._annotation = r4;
    }

    public void setAnonymousTypeRefs(SchemaType.Ref[] r3) {
        if (r3 != null) goto L4;
        SchemaType.Ref[] r4 = null;
    L5:
        this._anonymousTyperefs = r4;
        return;
    L4:
        r4 = (SchemaType.Ref[]) ZeusTransformUtils.preCheckCast(r3.clone(), SchemaType.Ref[].class, "com.obric.memorydata.plugin");
        goto L5
    }

    public void setAnonymousUnionMemberOrdinal(int r1) {
        assertUnresolved();
        this._anonymousUnionMemberOrdinal = r1;
    }

    public void setAttributeType(boolean r1) {
        assertUnresolved();
        this._isAttributeType = r1;
    }

    public void setBaseDepth(int r1) {
        assertResolving();
        this._baseDepth = r1;
    }

    public void setBaseEnumTypeRef(SchemaType.Ref r1) {
        this._baseEnumTyperef = r1;
    }

    public void setBaseTypeRef(SchemaType.Ref r1) {
        assertResolving();
        this._baseTyperef = r1;
    }

    public void setBasicFacets(XmlValueRef[] r4, boolean[] r5) {
        assertResolving();
        boolean[] r0 = null;
        if (r4 != null) goto L5;
        XmlValueRef[] r6 = null;
    L6:
        this._facetArray = r6;
        if (r5 == null) goto L10;
        r0 = (boolean[]) ZeusTransformUtils.preCheckCast(r5.clone(), boolean[].class, "com.obric.memorydata.plugin");
    L10:
        this._fixedFacetArray = r0;
        return;
    L5:
        r6 = (XmlValueRef[]) ZeusTransformUtils.preCheckCast(r4.clone(), XmlValueRef[].class, "com.obric.memorydata.plugin");
        goto L6
    }

    void setBlock(boolean r1, boolean r2) {
        assertResolving();
        this._blockExt = r1;
        this._blockRest = r2;
    }

    public void setBounded(boolean r1) {
        assertResolving();
        this._isBounded = r1;
    }

    public void setBuiltinTypeCode(int r1) {
        assertResolving();
        this._builtinTypeCode = r1;
    }

    public void setCompiled(boolean r1) {
        assertJavaizing();
        this._isCompiled = r1;
    }

    public void setComplexTypeVariety(int r1) {
        assertResolving();
        this._complexTypeVariety = r1;
    }

    void setContainer(SchemaContainer r1) {
        this._container = r1;
    }

    public void setContainerFieldIndex(short r1, int r2) {
        assertUnresolved();
        this._containerFieldCode = r1;
        this._containerFieldIndex = r2;
    }

    public void setContainerFieldRef(SchemaComponent.Ref r1) {
        assertUnresolved();
        this._containerFieldRef = r1;
        this._containerFieldCode = 0;
    }

    public void setContentBasedOnTypeRef(SchemaType.Ref r1) {
        assertResolving();
        this._contentBasedOnTyperef = r1;
    }

    public void setContentModel(SchemaParticle r3, SchemaAttributeModel r4, Map<QName, SchemaProperty> r5, Map<QName, SchemaProperty> r6, boolean r7) {
        SchemaParticle r8 = (SchemaParticle) ZeusTransformUtils.wrapperContextForParams(r3, SchemaParticle.class, "com.obric.memorydata.plugin");
        SchemaAttributeModel r9 = (SchemaAttributeModel) ZeusTransformUtils.wrapperContextForParams(r4, SchemaAttributeModel.class, "com.obric.memorydata.plugin");
        Map<QName, SchemaProperty> r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        Map<QName, SchemaProperty> r11 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin");
        assertResolving();
        this._contentModel = r8;
        this._attributeModel = r9;
        this._propertyModelByElementName = r10;
        this._propertyModelByAttributeName = r11;
        this._hasAllContent = r7;
        if (r10 == null) goto L13;
        this._validSubstitutions = new LinkedHashSet();
        Iterator<SchemaProperty> r12 = this._propertyModelByElementName.values().iterator();
    L6:
        if (r12.hasNext() == false) goto L18;
        QName[] r13 = ((SchemaProperty) ZeusTransformUtils.preCheckCast(r12.next(), SchemaProperty.class, "com.obric.memorydata.plugin")).acceptedNames();
        int r14 = r13.length;
        int r15 = 0;
    L8:
        if (r15 >= r14) goto L6;
        QName r16 = r13[r15];
        if (this._propertyModelByElementName.containsKey(r16) == true) goto L12;
        this._validSubstitutions.add(r16);
    L12:
        r15 = r15 + 1;
        goto L8
    L18:
        return;
    }

    public void setDecimalSize(int r1) {
        assertResolving();
        this._decimalSize = r1;
    }

    public void setDerivationType(int r1) {
        assertResolving();
        this._derivationType = r1;
    }

    public void setDocumentType(boolean r1) {
        assertUnresolved();
        this._isDocumentType = r1;
    }

    public void setEnumerationValues(XmlValueRef[] r3) {
        assertResolving();
        if (r3 != null) goto L5;
        XmlValueRef[] r4 = null;
    L6:
        this._enumerationValues = r4;
        return;
    L5:
        r4 = (XmlValueRef[]) ZeusTransformUtils.preCheckCast(r3.clone(), XmlValueRef[].class, "com.obric.memorydata.plugin");
        goto L6
    }

    public void setFilename(String r1) {
        assertUnresolved();
        this._filename = r1;
    }

    public void setFinite(boolean r1) {
        assertResolving();
        this._isFinite = r1;
    }

    public void setFullJavaImplName(String r3) {
        assertResolved();
        this._fullJavaImplName = r3;
        int r4 = Math.max(r3.lastIndexOf(36), this._fullJavaImplName.lastIndexOf(46)) + 1;
        this._shortJavaImplName = this._fullJavaImplName.substring(r4);
    }

    public void setFullJavaName(String r3) {
        assertResolved();
        this._fullJavaName = r3;
        int r4 = Math.max(r3.lastIndexOf(36), this._fullJavaName.lastIndexOf(46)) + 1;
        this._shortJavaName = this._fullJavaName.substring(r4);
    }

    public void setListItemTypeRef(SchemaType.Ref r1) {
        assertResolving();
        this._listItemTyperef = r1;
    }

    public void setName(QName r1) {
        assertUnresolved();
        this._name = r1;
    }

    public void setNumeric(boolean r1) {
        assertResolving();
        this._isNumeric = r1;
    }

    public void setOrderSensitive(boolean r1) {
        assertJavaizing();
        this._orderSensitive = r1;
    }

    public void setOrdered(int r1) {
        assertResolving();
        this._ordered = r1;
    }

    public void setOuterSchemaTypeRef(SchemaType.Ref r1) {
        assertUnresolved();
        this._outerSchemaTypeRef = r1;
    }

    public void setPatternFacet(boolean r1) {
        assertResolving();
        this._hasPatterns = r1;
    }

    public void setPatterns(RegularExpression[] r3) {
        assertResolving();
        if (r3 != null) goto L5;
        RegularExpression[] r4 = null;
    L6:
        this._patterns = r4;
        return;
    L5:
        r4 = (RegularExpression[]) ZeusTransformUtils.preCheckCast(r3.clone(), RegularExpression[].class, "com.obric.memorydata.plugin");
        goto L6
    }

    public void setPrimitiveTypeRef(SchemaType.Ref r1) {
        assertResolving();
        this._primitiveTypeRef = r1;
    }

    void setSimpleFinal(boolean r1, boolean r2, boolean r3) {
        assertResolving();
        this._finalRest = r1;
        this._finalList = r2;
        this._finalUnion = r3;
    }

    public void setSimpleType(boolean r1) {
        assertUnresolved();
        this._isSimpleType = r1;
    }

    public void setSimpleTypeVariety(int r1) {
        assertResolving();
        this._simpleTypeVariety = r1;
    }

    public void setStringEnumEntries(SchemaStringEnumEntry[] r3) {
        assertJavaizing();
        if (r3 != null) goto L5;
        SchemaStringEnumEntry[] r4 = null;
    L6:
        this._stringEnumEntries = r4;
        return;
    L5:
        r4 = (SchemaStringEnumEntry[]) ZeusTransformUtils.preCheckCast(r3.clone(), SchemaStringEnumEntry[].class, "com.obric.memorydata.plugin");
        goto L6
    }

    public void setUnionMemberTypeRefs(SchemaType.Ref[] r3) {
        assertResolving();
        if (r3 != null) goto L5;
        SchemaType.Ref[] r4 = null;
    L6:
        this._unionMemberTyperefs = r4;
        return;
    L5:
        r4 = (SchemaType.Ref[]) ZeusTransformUtils.preCheckCast(r3.clone(), SchemaType.Ref[].class, "com.obric.memorydata.plugin");
        goto L6
    }

    public void setUnionOfLists(boolean r1) {
        assertResolving();
        this._isUnionOfLists = r1;
    }

    public void setWhiteSpaceRule(int r1) {
        assertResolving();
        this._whiteSpaceRule = r1;
    }

    public void setWildcardSummary(QNameSet r1, boolean r2, QNameSet r3, boolean r4) {
        assertResolving();
        this._typedWildcardElements = r1;
        this._hasWildcardElements = r2;
        this._typedWildcardAttributes = r3;
        this._hasWildcardAttributes = r4;
    }

    public String toString() {
        if (getName() == null) goto L9;
        StringBuilder r0 = new StringBuilder().append("T=");
        QName r2 = getName();
    L5:
        String r3 = QNameHelper.pretty(r2);
    L7:
        return r0.append(r3).toString();
    L9:
        if (isDocumentType() == false) goto L12;
        r0 = new StringBuilder().append("D=");
        r2 = getDocumentElementName();
        goto L5
    L12:
        if (isAttributeType() == false) goto L15;
        r0 = new StringBuilder().append("R=");
        r2 = getAttributeTypeAttributeName();
        goto L5
    L15:
        if (getContainerField() == null) goto L30;
        StringBuilder r1 = new StringBuilder();
        if (getContainerField().getName().getNamespaceURI().length() <= 0) goto L23;
        if (getContainerField().isAttribute() == false) goto L21;
        String r4 = "Q=";
    L26:
        String r5 = r1.append(r4).append(getContainerField().getName().getLocalPart()).toString();
        if (getOuterType() != null) goto L50;
        r0 = new StringBuilder().append(r5).append("@");
        r3 = getContainerField().getName().getNamespaceURI();
    L50:
        r0 = new StringBuilder().append(r5).append("|");
        r3 = getOuterType().toString();
        goto L7
    L21:
        r4 = "E=";
        goto L26
    L23:
        if (getContainerField().isAttribute() == false) goto L25;
        r4 = "A=";
        goto L26
    L25:
        r4 = "U=";
        goto L26
    L30:
        if (isNoType() == false) goto L34;
        return "N=";
    L34:
        if (getOuterType() != null) goto L38;
        return "noouter";
    L38:
        if (getOuterType().getBaseType() != this) goto L41;
        r5 = "B=";
        goto L50
    L41:
        if (getOuterType().getContentBasedOnType() != this) goto L44;
        r5 = "S=";
        goto L50
    L44:
        if (getOuterType().getSimpleVariety() != 3) goto L47;
        r5 = "I=";
        goto L50
    L47:
        if (getOuterType().getSimpleVariety() != 2) goto L49;
        r5 = "M=" + getAnonymousUnionMemberOrdinal();
        goto L50
    L49:
        r5 = "strange=";
        goto L50
    }
}
