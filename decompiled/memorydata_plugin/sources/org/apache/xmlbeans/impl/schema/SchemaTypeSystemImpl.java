package org.apache.xmlbeans.impl.schema;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.ResourceLoader;
import org.apache.xmlbeans.SchemaAnnotation;
import org.apache.xmlbeans.SchemaAttributeGroup;
import org.apache.xmlbeans.SchemaComponent;
import org.apache.xmlbeans.SchemaGlobalAttribute;
import org.apache.xmlbeans.SchemaGlobalElement;
import org.apache.xmlbeans.SchemaIdentityConstraint;
import org.apache.xmlbeans.SchemaModelGroup;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SchemaTypeLoader;
import org.apache.xmlbeans.SchemaTypeLoaderException;
import org.apache.xmlbeans.SchemaTypeSystem;
import org.apache.xmlbeans.impl.common.XBeanDebug;
import org.apache.xmlbeans.impl.util.LongUTFDataInputStream;

/* JADX INFO: loaded from: classes7.dex */
public class SchemaTypeSystemImpl extends SchemaTypeLoaderBase implements SchemaTypeSystem {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final SchemaAttributeGroup[] EMPTY_AG_ARRAY = null;
    private static final SchemaAnnotation[] EMPTY_ANN_ARRAY = null;
    private static final SchemaGlobalAttribute[] EMPTY_GA_ARRAY = null;
    private static final SchemaGlobalElement[] EMPTY_GE_ARRAY = null;
    private static final SchemaIdentityConstraint[] EMPTY_IC_ARRAY = null;
    private static final SchemaModelGroup[] EMPTY_MG_ARRAY = null;
    private static final SchemaType[] EMPTY_ST_ARRAY = null;
    public static String METADATA_PACKAGE_GEN;
    static final byte[] SINGLE_ZERO_BYTE = null;
    private static final byte[] _mask = null;
    private static final Pattern packPat = null;
    private boolean _allNonGroupHandlesResolved;
    private List<SchemaAnnotation> _annotations;
    private Map<QName, SchemaComponent.Ref> _attributeGroups;
    private Map<QName, SchemaComponent.Ref> _attributeTypes;
    private ClassLoader _classloader;
    private Map<String, SchemaContainer> _containers;
    private Map<QName, SchemaComponent.Ref> _documentTypes;
    private Map<QName, SchemaComponent.Ref> _globalAttributes;
    private Map<QName, SchemaComponent.Ref> _globalElements;
    private Map<QName, SchemaComponent.Ref> _globalTypes;
    private Map<QName, SchemaComponent.Ref> _identityConstraints;
    private boolean _incomplete;
    SchemaTypeLoader _linker;
    private SchemaTypePool _localHandles;
    private Map<QName, SchemaComponent.Ref> _modelGroups;
    private final String _name;
    private Set<String> _namespaces;
    private List<SchemaComponent.Ref> _redefinedAttributeGroups;
    private List<SchemaComponent.Ref> _redefinedGlobalTypes;
    private List<SchemaComponent.Ref> _redefinedModelGroups;
    private final Map<String, SchemaComponent> _resolvedHandles;
    private ResourceLoader _resourceLoader;
    private Map<String, SchemaComponent.Ref> _typeRefsByClassname;

    static class StringPool {
        private final String _handle;
        private final String _name;
        private final List<String> intsToStrings;
        private final Map<String, Integer> stringsToInts;

        StringPool(String r3, String r4) {
            ArrayList r0 = new ArrayList();
            this.intsToStrings = r0;
            this.stringsToInts = new HashMap();
            this._handle = r3;
            this._name = r4;
            r0.add(null);
        }

        int codeForString(String r4) {
            if (r4 != null) goto L5;
            return 0;
        L5:
            Integer r0 = (Integer) ZeusTransformUtils.preCheckCast(this.stringsToInts.get(r4), Integer.class, "com.obric.memorydata.plugin");
            if (r0 != null) goto L9;
            r0 = Integer.valueOf(this.intsToStrings.size());
            this.intsToStrings.add(r4);
            this.stringsToInts.put(r4, r0);
        L9:
            return r0.intValue();
        }

        void readFrom(LongUTFDataInputStream r7) {
            int r1 = 1;
            if (this.intsToStrings.size() != 1) goto L22;
            if (this.stringsToInts.size() != 0) goto L22;
            int r0 = r7.readUnsignedShortOrInt();     // Catch: IOException -> L14
        L7:
            if (r1 >= r0) goto L13;
            if (codeForString(r7.readLongUTF().intern()) != r1) goto L12;
            r1 = r1 + 1;     // Catch: IOException -> L14
            goto L7
        L12:
            throw new IllegalStateException();     // Catch: IOException -> L14
        L13:
            return;
        L14:
            e = move-exception;
            if (e.getMessage() != null) goto L18;
            String r2 = e.getMessage();
        L20:
            throw new SchemaTypeLoaderException(r2, this._name, this._handle, 9, e);
        L18:
            r2 = "IO Exception";
        L22:
            throw new IllegalStateException();
        }

        String stringForCode(int r2) {
            if (r2 != 0) goto L5;
            return null;
        L5:
            return (String) ZeusTransformUtils.preCheckCast(this.intsToStrings.get(r2), String.class, "com.obric.memorydata.plugin");
        }
    }

    static {
        packPat = Pattern.compile("^(.+)(\\.[^.]+){2}$");
        METADATA_PACKAGE_GEN = "org/apache/xmlbeans/metadata";
        EMPTY_ST_ARRAY = new SchemaType[0];
        EMPTY_GE_ARRAY = new SchemaGlobalElement[0];
        EMPTY_GA_ARRAY = new SchemaGlobalAttribute[0];
        EMPTY_MG_ARRAY = new SchemaModelGroup[0];
        EMPTY_AG_ARRAY = new SchemaAttributeGroup[0];
        EMPTY_IC_ARRAY = new SchemaIdentityConstraint[0];
        EMPTY_ANN_ARRAY = new SchemaAnnotation[0];
        _mask = new byte[16];
        SINGLE_ZERO_BYTE = new byte[]{0};
    }

    public SchemaTypeSystemImpl() {
        this._incomplete = false;
        this._containers = new HashMap();
        this._identityConstraints = Collections.emptyMap();
        this._typeRefsByClassname = new HashMap();
        this._resolvedHandles = new HashMap();
        this._allNonGroupHandlesResolved = false;
        String r1 = getClass().getName();
        String r0 = r1.substring(0, r1.lastIndexOf(46));
        this._name = r0;
        XBeanDebug.LOG.atTrace().a("Loading type system {}", r0);
        this._classloader = getClass().getClassLoader();
        this._linker = this;
        this._resourceLoader = new ClassLoaderResourceLoader(this._classloader);
        initFromHeader();     // Catch: Throwable -> L6
        XBeanDebug.LOG.atTrace().a("Finished loading type system {}", r0);
        return;
    L6:
        e = move-exception;
        XBeanDebug.LOG.atDebug().a(e).a(e.getMessage());
        throw e;
    }

    public SchemaTypeSystemImpl(Class<?> r4) {
        this._incomplete = false;
        this._containers = new HashMap();
        this._identityConstraints = Collections.emptyMap();
        this._typeRefsByClassname = new HashMap();
        this._resolvedHandles = new HashMap();
        this._allNonGroupHandlesResolved = false;
        String r1 = r4.getName();
        String r0 = r1.substring(0, r1.lastIndexOf(46));
        this._name = r0;
        XBeanDebug.LOG.atTrace().a("Loading type system {}", r0);
        ClassLoader r5 = r4.getClassLoader();
        this._classloader = r5;
        this._linker = SchemaTypeLoaderImpl.build(null, null, r5, getMetadataPath());
        this._resourceLoader = new ClassLoaderResourceLoader(this._classloader);
        initFromHeader();     // Catch: Throwable -> L6
        XBeanDebug.LOG.atTrace().a("Finished loading type system {}", r0);
        return;
    L6:
        e = move-exception;
        XBeanDebug.LOG.atDebug().a(e).a(e.getMessage());
        throw e;
    }

    public SchemaTypeSystemImpl(ResourceLoader r3, String r4, SchemaTypeLoader r5) {
        ResourceLoader r6 = (ResourceLoader) ZeusTransformUtils.wrapperContextForParams(r3, ResourceLoader.class, "com.obric.memorydata.plugin");
        SchemaTypeLoader r7 = (SchemaTypeLoader) ZeusTransformUtils.wrapperContextForParams(r5, SchemaTypeLoader.class, "com.obric.memorydata.plugin");
        this._incomplete = false;
        this._containers = new HashMap();
        this._identityConstraints = Collections.emptyMap();
        this._typeRefsByClassname = new HashMap();
        this._resolvedHandles = new HashMap();
        this._allNonGroupHandlesResolved = false;
        this._name = r4;
        this._linker = r7;
        this._resourceLoader = r6;
        initFromHeader();     // Catch: Throwable -> L5
        return;
    L5:
        e = move-exception;
        XBeanDebug.LOG.atDebug().a(e).a(e.getMessage());
        throw e;
    }

    private void addContainer(String r2) {
        SchemaContainer r0 = new SchemaContainer(r2);
        r0.setTypeSystem(this);
        this._containers.put(r2, r0);
    }

    private void buildContainers(List<QName> r3, List<QName> r4, List<QName> r5) {
        List<QName> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        List<QName> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        List<QName> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        buildContainersHelper(this._globalElements, $$Lambda$QoDcJ9RvsJXQYXOuybBTygZHWY.INSTANCE);
        buildContainersHelper(this._globalAttributes, $$Lambda$1dKbQkYZkutxezKH6j1T2cwR2Xw.INSTANCE);
        buildContainersHelper(this._modelGroups, $$Lambda$xvS7Jgo3Wo8uK6uOm5DFdVh8fKs.INSTANCE);
        buildContainersHelper(this._attributeGroups, $$Lambda$od1m73dItUp_x5UyVl3I4AA_D9Y.INSTANCE);
        buildContainersHelper(this._identityConstraints, $$Lambda$NPO4Ida6RcSB1OOvbUU2ALRD7nA.INSTANCE);
        buildContainersHelper(this._globalTypes, $$Lambda$MsSezIvOAbqP0yjraxmrEq4PNLo.INSTANCE);
        buildContainersHelper(this._attributeTypes, $$Lambda$lG_LcOoSEOEeA19JoCglwImrR8g.INSTANCE);
        List<SchemaComponent.Ref> r0 = this._redefinedGlobalTypes;
        if (r0 != null) goto L5;
    L9:
        List<SchemaAnnotation> r9 = this._annotations;
        if (r9 != null) goto L12;
    L14:
        this._containers.values().forEach($$Lambda$g1DDLKFSEp69fkXHW7cemSmBH4.INSTANCE);
        return;
    L12:
        if (r9.isEmpty() == true) goto L14;
        List<SchemaAnnotation> r10 = this._annotations;
        final SchemaContainer r11 = getContainerNonNull("");
        r11.getClass();
        r10.forEach(new $$Lambda$4AdgmFiU2z29PeEEsP3Urr0HNSY(r11));
        goto L14
    L5:
        if (this._redefinedModelGroups == null) goto L9;
        if (this._redefinedAttributeGroups == null) goto L9;
        buildContainersHelper(r0, r6, $$Lambda$FaRze4pDvsTVONA4UpyrIVISZk.INSTANCE);
        buildContainersHelper(this._redefinedModelGroups, r7, $$Lambda$BLEw7fctBNc_7BsCpvfBl9DvTAU.INSTANCE);
        buildContainersHelper(this._redefinedAttributeGroups, r8, $$Lambda$h92FuXP9IJSrQ9EbOkIW5t3ixBg.INSTANCE);
        goto L9
    }

    private <T extends SchemaComponent.Ref> void buildContainersHelper(List<SchemaComponent.Ref> r5, List<QName> r6, BiConsumer<SchemaContainer, T> r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        BiConsumer r10 = (BiConsumer) ZeusTransformUtils.wrapperContextForParams(r7, BiConsumer.class, "com.obric.memorydata.plugin");
        Iterator r11 = r8.iterator();
        Iterator r12 = r9.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r10.accept(getContainerNonNull(((QName) ZeusTransformUtils.preCheckCast(r12.next(), QName.class, "com.obric.memorydata.plugin")).getNamespaceURI()), (SchemaComponent.Ref) ZeusTransformUtils.preCheckCast(r11.next(), SchemaComponent.Ref.class, "com.obric.memorydata.plugin"));
        goto L4
    }

    private <T extends SchemaComponent.Ref> void buildContainersHelper(Map<QName, SchemaComponent.Ref> r3, BiConsumer<SchemaContainer, T> r4) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        final BiConsumer r6 = (BiConsumer) ZeusTransformUtils.wrapperContextForParams(r4, BiConsumer.class, "com.obric.memorydata.plugin");
        r5.forEach(new $$Lambda$SchemaTypeSystemImpl$Y0QqOeuAz6Z8FdKp2F8GRnsLZvg(this, r6));
    }

    public static String crackPointer(InputStream r4) {
        LongUTFDataInputStream r1 = new LongUTFDataInputStream(r4);     // Catch: IOException -> L37
    L29:
        th = move-exception;
        throw th;     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        r1.close();     // Catch: Throwable -> L34
    L36:
        throw th;     // Catch: IOException -> L37
    L34:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L37
        goto L36
    L6:
        if (r1.readInt() == (-629491010)) goto L9;
        r1.close();     // Catch: IOException -> L37
        return null;
    L9:
        short r5 = r1.readShort();     // Catch: Throwable -> L29
        short r2 = r1.readShort();     // Catch: Throwable -> L29
        if (r5 == 2) goto L15;
        r1.close();     // Catch: IOException -> L37
        return null;
    L15:
        if (r2 <= 24) goto L19;
        r1.close();     // Catch: IOException -> L37
        return null;
    L19:
        if (r2 < 18) goto L23;
        r1.readShort();     // Catch: Throwable -> L29
    L23:
        if (r1.readShort() == 5) goto L26;
        r1.close();     // Catch: IOException -> L37
        return null;
    L26:
        StringPool r6 = new StringPool("pointer", "unk");     // Catch: Throwable -> L29
        r6.readFrom(r1);     // Catch: Throwable -> L29
        String r7 = r6.stringForCode(r1.readShort());     // Catch: Throwable -> L29
        r1.close();     // Catch: IOException -> L37
        return r7;
    L37:
        return null;
    }

    public static SchemaTypeSystemImpl forName(String r2, ClassLoader r3) {
        return (SchemaTypeSystemImpl) ZeusTransformUtils.preCheckCast(Class.forName(r2 + ".TypeSystemHolder", true, r3).getField("typeSystem").get(null), SchemaTypeSystemImpl.class, "com.obric.memorydata.plugin");
    L5:
        return null;
    }

    private void initFromHeader() {
        XBeanDebug.LOG.atTrace().a("Reading unresolved handles for type system {}", this._name);
        XsbReader r0 = null;
        XsbReader r1 = new XsbReader(getTypeSystem(), "index", 1);     // Catch: Throwable -> L15
        SchemaTypePool r2 = new SchemaTypePool(getTypeSystem());     // Catch: Throwable -> L13
        this._localHandles = r2;     // Catch: Throwable -> L13
        r2.readHandlePool(r1);     // Catch: Throwable -> L13
        this._globalElements = r1.readQNameRefMap();     // Catch: Throwable -> L13
        this._globalAttributes = r1.readQNameRefMap();     // Catch: Throwable -> L13
        this._modelGroups = r1.readQNameRefMap();     // Catch: Throwable -> L13
        this._attributeGroups = r1.readQNameRefMap();     // Catch: Throwable -> L13
        this._identityConstraints = r1.readQNameRefMap();     // Catch: Throwable -> L13
        this._globalTypes = r1.readQNameRefMap();     // Catch: Throwable -> L13
        this._documentTypes = r1.readQNameRefMap();     // Catch: Throwable -> L13
        this._attributeTypes = r1.readQNameRefMap();     // Catch: Throwable -> L13
        this._typeRefsByClassname = r1.readClassnameRefMap();     // Catch: Throwable -> L13
        this._namespaces = r1.readNamespaces();     // Catch: Throwable -> L13
        ArrayList r3 = new ArrayList();     // Catch: Throwable -> L13
        ArrayList r4 = new ArrayList();     // Catch: Throwable -> L13
        ArrayList r5 = new ArrayList();     // Catch: Throwable -> L13
        if (r1.atLeast(2, 15, 0) == false) goto L8;
        this._redefinedGlobalTypes = r1.readQNameRefMapAsList(r3);     // Catch: Throwable -> L13
        this._redefinedModelGroups = r1.readQNameRefMapAsList(r4);     // Catch: Throwable -> L13
        this._redefinedAttributeGroups = r1.readQNameRefMapAsList(r5);     // Catch: Throwable -> L13
    L8:
        if (r1.atLeast(2, 19, 0) == false) goto L10;
        this._annotations = r1.readAnnotations();     // Catch: Throwable -> L13
    L10:
        buildContainers(r3, r4, r5);     // Catch: Throwable -> L13
        r1.readEnd();
        return;
    L13:
        th = th;
        r0 = r1;
    L16:
        if (r0 == null) goto L18;
        r0.readEnd();
    L18:
        throw th;
    L15:
        th = th;
        goto L16
    }

    static String nameToPathString(String r2) {
        String r3 = r2.replace('.', '/');
        if (r3.endsWith("/") == false) goto L5;
        return r3;
    L5:
        if (r3.length() > 0) goto L7;
        return r3;
    L7:
        return r3 + "/";
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaAttributeGroup.Ref findAttributeGroupRef(QName r2) {
        return (SchemaAttributeGroup.Ref) ZeusTransformUtils.preCheckCast(this._attributeGroups.get(r2), SchemaAttributeGroup.Ref.class, "com.obric.memorydata.plugin");
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaGlobalAttribute.Ref findAttributeRef(QName r2) {
        return (SchemaGlobalAttribute.Ref) ZeusTransformUtils.preCheckCast(this._globalAttributes.get(r2), SchemaGlobalAttribute.Ref.class, "com.obric.memorydata.plugin");
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaType.Ref findAttributeTypeRef(QName r2) {
        return (SchemaType.Ref) ZeusTransformUtils.preCheckCast(this._attributeTypes.get(r2), SchemaType.Ref.class, "com.obric.memorydata.plugin");
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaType.Ref findDocumentTypeRef(QName r2) {
        return (SchemaType.Ref) ZeusTransformUtils.preCheckCast(this._documentTypes.get(r2), SchemaType.Ref.class, "com.obric.memorydata.plugin");
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaGlobalElement.Ref findElementRef(QName r2) {
        return (SchemaGlobalElement.Ref) ZeusTransformUtils.preCheckCast(this._globalElements.get(r2), SchemaGlobalElement.Ref.class, "com.obric.memorydata.plugin");
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaIdentityConstraint.Ref findIdentityConstraintRef(QName r2) {
        return (SchemaIdentityConstraint.Ref) ZeusTransformUtils.preCheckCast(this._identityConstraints.get(r2), SchemaIdentityConstraint.Ref.class, "com.obric.memorydata.plugin");
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaModelGroup.Ref findModelGroupRef(QName r2) {
        return (SchemaModelGroup.Ref) ZeusTransformUtils.preCheckCast(this._modelGroups.get(r2), SchemaModelGroup.Ref.class, "com.obric.memorydata.plugin");
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaType.Ref findTypeRef(QName r2) {
        return (SchemaType.Ref) ZeusTransformUtils.preCheckCast(this._globalTypes.get(r2), SchemaType.Ref.class, "com.obric.memorydata.plugin");
    }

    String getBasePackage() {
        return nameToPathString(this._name);
    }

    @Override // org.apache.xmlbeans.SchemaTypeSystem
    public ClassLoader getClassLoader() {
        return this._classloader;
    }

    SchemaContainer getContainer(String r2) {
        return (SchemaContainer) ZeusTransformUtils.preCheckCast(this._containers.get(r2), SchemaContainer.class, "com.obric.memorydata.plugin");
    }

    SchemaContainer getContainerNonNull(String r2) {
        SchemaContainer r0 = getContainer(r2);
        if (r0 != null) goto L6;
        addContainer(r2);
        return getContainer(r2);
    L6:
        return r0;
    }

    SchemaTypeLoader getLinker() {
        return this._linker;
    }

    InputStream getLoaderStream(String r1) {
        return this._resourceLoader.getResourceAsStream(r1);
    }

    public String getMetadataPath() {
        Matcher r0 = packPat.matcher(this._name);
        if (r0.find() == false) goto L5;
        String r2 = r0.group(1);
    L7:
        return r2.replace('.', '/');
    L5:
        r2 = this._name;
        goto L7
    }

    public String getName() {
        return this._name;
    }

    SchemaTypePool getTypePool() {
        return this._localHandles;
    }

    final SchemaTypeSystemImpl getTypeSystem() {
        return this;
    }

    public /* synthetic */ void lambda$buildContainersHelper$1$SchemaTypeSystemImpl(BiConsumer r3, QName r4, SchemaComponent.Ref r5) {
        ((BiConsumer) ZeusTransformUtils.wrapperContextForParams(r3, BiConsumer.class, "com.obric.memorydata.plugin")).accept(getContainerNonNull(r4.getNamespaceURI()), r5);
    }

    @Override // org.apache.xmlbeans.SchemaTypeSystem
    public SchemaComponent resolveHandle(String r5) {
        Map<String, SchemaComponent> r0 = this._resolvedHandles;
        monitor-enter(r0);
        SchemaComponent r1 = (SchemaComponent) ZeusTransformUtils.preCheckCast(this._resolvedHandles.get(r5), SchemaComponent.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L39
        monitor-exit(r0);     // Catch: Throwable -> L39
        if (r1 != null) goto L38;
        XsbReader r2 = new XsbReader(getTypeSystem(), r5, 65535);
        int r3 = r2.getActualFiletype();
        if (r3 != 2) goto L10;
        XBeanDebug.LOG.atTrace().a("Resolving type for handle {}", r5);
        SchemaComponent r4 = r2.finishLoadingType();
    L27:
        Map<String, SchemaComponent> r6 = this._resolvedHandles;
        monitor-enter(r6);
    L35:
        th = move-exception;
        throw th;
    L30:
        if (this._resolvedHandles.containsKey(r5) == true) goto L32;
        this._resolvedHandles.put(r5, r4);     // Catch: Throwable -> L35
        r1 = r4;
    L33:
        monitor-exit(r6);     // Catch: Throwable -> L35
        goto L38
    L32:
        r1 = (SchemaComponent) ZeusTransformUtils.preCheckCast(this._resolvedHandles.get(r5), SchemaComponent.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L35
        goto L33
    L10:
        if (r3 != 3) goto L12;
        XBeanDebug.LOG.atTrace().a("Resolving element for handle {}", r5);
        r4 = r2.finishLoadingElement();
        goto L27
    L12:
        if (r3 != 4) goto L14;
        XBeanDebug.LOG.atTrace().a("Resolving attribute for handle {}", r5);
        r4 = r2.finishLoadingAttribute();
        goto L27
    L14:
        if (r3 != 6) goto L16;
        XBeanDebug.LOG.atTrace().a("Resolving model group for handle {}", r5);
        r4 = r2.finishLoadingModelGroup();
        goto L27
    L16:
        if (r3 != 7) goto L18;
        XBeanDebug.LOG.atTrace().a("Resolving attribute group for handle {}", r5);
        r4 = r2.finishLoadingAttributeGroup();
        goto L27
    L18:
        if (r3 != 8) goto L21;
        XBeanDebug.LOG.atTrace().a("Resolving id constraint for handle {}", r5);
        r4 = r2.finishLoadingIdentityConstraint();
        goto L27
    L21:
        throw new IllegalStateException("Illegal handle type");
    L38:
        return r1;
    L39:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.xmlbeans.SchemaTypeSystem
    public SchemaType typeForHandle(String r3) {
        Map<String, SchemaComponent> r0 = this._resolvedHandles;
        monitor-enter(r0);
        SchemaType r2 = (SchemaType) ZeusTransformUtils.preCheckCast(this._resolvedHandles.get(r3), SchemaType.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r2;
    L7:
        th = move-exception;
        throw th;
    }
}
