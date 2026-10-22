package org.apache.xmlbeans.impl.schema;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.ResourceLoader;
import org.apache.xmlbeans.SchemaAttributeGroup;
import org.apache.xmlbeans.SchemaGlobalAttribute;
import org.apache.xmlbeans.SchemaGlobalElement;
import org.apache.xmlbeans.SchemaIdentityConstraint;
import org.apache.xmlbeans.SchemaModelGroup;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SchemaTypeLoader;
import org.apache.xmlbeans.SchemaTypeSystem;
import org.apache.xmlbeans.XmlRuntimeException;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.common.SystemCache;
import org.apache.xmlbeans.impl.common.XBeanDebug;
import org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument;

/* JADX INFO: loaded from: classes7.dex */
public class SchemaTypeLoaderImpl extends SchemaTypeLoaderBase {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Object CACHED_NOT_FOUND = null;
    private static final SchemaTypeLoader[] EMPTY_SCHEMATYPELOADER_ARRAY = null;
    public static String METADATA_PACKAGE_LOAD;
    private static final String[] basePackage = null;
    private static final String[] baseSchemas = null;
    private Map<QName, Object> _attributeCache;
    private Map<QName, Object> _attributeGroupCache;
    private Map<QName, Object> _attributeTypeCache;
    private final ClassLoader _classLoader;
    private Map<String, SchemaTypeSystemImpl> _classLoaderTypeSystems;
    private Map<String, Object> _classnameCache;
    private Map<String, SchemaTypeSystemImpl> _classpathTypeSystems;
    private Map<QName, Object> _documentCache;
    private Map<QName, Object> _elementCache;
    private Map<QName, Object> _idConstraintCache;
    private final String _metadataPath;
    private Map<QName, Object> _modelGroupCache;
    private final ResourceLoader _resourceLoader;
    private final SchemaTypeLoader[] _searchPath;
    private Map<QName, Object> _typeCache;

    /* JADX INFO: renamed from: org.apache.xmlbeans.impl.schema.SchemaTypeLoaderImpl$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class SchemaTypeLoaderCache extends SystemCache {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final ThreadLocal<List<SoftReference<SchemaTypeLoaderImpl>>> _cachedTypeSystems;

        static {
        }

        private SchemaTypeLoaderCache() {
            this._cachedTypeSystems = ThreadLocal.withInitial($$Lambda$SchemaTypeLoaderImpl$SchemaTypeLoaderCache$gDKEcGxnaIgU7sqXbIS8kj9NQtE.INSTANCE);
        }

        /* synthetic */ SchemaTypeLoaderCache(AnonymousClass1 r1) {
            this();
        }

        public static /* synthetic */ ArrayList lambda$gDKEcGxnaIgU7sqXbIS8kj9NQtE() {
            return new ArrayList();
        }

        @Override // org.apache.xmlbeans.impl.common.SystemCache
        public void addToTypeLoaderCache(SchemaTypeLoader r5, ClassLoader r6) {
            SchemaTypeLoader r7 = (SchemaTypeLoader) ZeusTransformUtils.wrapperContextForParams(r5, SchemaTypeLoader.class, "com.obric.memorydata.plugin");
            List r4 = (List) ZeusTransformUtils.preCheckCast(this._cachedTypeSystems.get(), List.class, "com.obric.memorydata.plugin");
            if (r4.size() <= 0) goto L5;
            SoftReference r1 = (SoftReference) ZeusTransformUtils.preCheckCast(r4.get(0), SoftReference.class, "com.obric.memorydata.plugin");
            r4.set(0, new SoftReference((SchemaTypeLoaderImpl) ZeusTransformUtils.preCheckCast(r7, SchemaTypeLoaderImpl.class, "com.obric.memorydata.plugin")));
            r4.add(r1);
            return;
        L5:
            r4.add(new SoftReference((SchemaTypeLoaderImpl) ZeusTransformUtils.preCheckCast(r7, SchemaTypeLoaderImpl.class, "com.obric.memorydata.plugin")));
        }

        @Override // org.apache.xmlbeans.impl.common.SystemCache
        public SchemaTypeLoader getFromTypeLoaderCache(ClassLoader r6) {
            List r5 = (List) ZeusTransformUtils.preCheckCast(this._cachedTypeSystems.get(), List.class, "com.obric.memorydata.plugin");
            int r2 = 0;
        L4:
            if (r2 >= r5.size()) goto L12;
            SchemaTypeLoaderImpl r3 = (SchemaTypeLoaderImpl) ZeusTransformUtils.preCheckCast(((SoftReference) ZeusTransformUtils.preCheckCast(r5.get(r2), SoftReference.class, "com.obric.memorydata.plugin")).get(), SchemaTypeLoaderImpl.class, "com.obric.memorydata.plugin");
            if (r3 != null) goto L9;
            r5.remove(r2);
            r2 = r2 - 1;
        L11:
            r2 = r2 + 1;
            goto L4
        L9:
            if (SchemaTypeLoaderImpl.access$000(r3) != r6) goto L11;
        L13:
            if (r2 <= 0) goto L15;
            SoftReference r7 = (SoftReference) ZeusTransformUtils.preCheckCast(r5.get(0), SoftReference.class, "com.obric.memorydata.plugin");
            r5.set(0, r5.get(r2));
            r5.set(r2, r7);
        L15:
            return r3;
        L12:
            r2 = -1;
            r3 = null;
            goto L13
        }
    }

    private static class SubLoaderList {
        private final Map<SchemaTypeLoader, Object> seen;
        private final List<SchemaTypeLoader> theList;

        private SubLoaderList() {
            this.theList = new ArrayList();
            this.seen = new IdentityHashMap();
        }

        /* synthetic */ SubLoaderList(AnonymousClass1 r1) {
            this();
        }

        void add(SchemaTypeLoader r3) {
            SchemaTypeLoader r4 = (SchemaTypeLoader) ZeusTransformUtils.wrapperContextForParams(r3, SchemaTypeLoader.class, "com.obric.memorydata.plugin");
            if (r4 != null) goto L5;
            return;
        L5:
            if (this.seen.containsKey(r4) == true) goto L9;
            this.theList.add(r4);
            this.seen.put(r4, null);
            return;
        }

        void add(SchemaTypeLoader[] r6) {
            if (r6 != null) goto L4;
            return;
        L4:
            int r0 = r6.length;
            int r1 = 0;
        L5:
            if (r1 >= r0) goto L16;
            SchemaTypeLoader r2 = r6[r1];
            boolean r3 = ZeusTransformUtils.instanceOf(r2, SchemaTypeLoaderImpl.class);
            SchemaTypeLoader r4 = r2;
            if (r3 == false) goto L14;
            SchemaTypeLoaderImpl r5 = (SchemaTypeLoaderImpl) ZeusTransformUtils.preCheckCast(r2, SchemaTypeLoaderImpl.class, "com.obric.memorydata.plugin");
            ClassLoader r7 = SchemaTypeLoaderImpl.access$000(r5);
            r4 = r5;
            if (r7 != null) goto L14;
            ResourceLoader r8 = SchemaTypeLoaderImpl.access$200(r5);
            r4 = r5;
            if (r8 != null) goto L14;
            add(SchemaTypeLoaderImpl.access$300(r5));
        L15:
            r1 = r1 + 1;
        L14:
            add(r4);
            goto L15
        }

        SchemaTypeLoader[] toArray() {
            return (SchemaTypeLoader[]) ZeusTransformUtils.preCheckCast(this.theList.toArray(SchemaTypeLoaderImpl.access$400()), SchemaTypeLoader[].class, "com.obric.memorydata.plugin");
        }
    }

    static {
        METADATA_PACKAGE_LOAD = SchemaTypeSystemImpl.METADATA_PACKAGE_GEN;
        CACHED_NOT_FOUND = new Object();
        basePackage = new String[]{"org.apache.xmlbeans.metadata", "schemaorg_apache_xmlbeans"};
        baseSchemas = new String[]{"sXMLCONFIG", "sXMLLANG", "sXMLSCHEMA", "sXMLTOOLS"};
        EMPTY_SCHEMATYPELOADER_ARRAY = new SchemaTypeLoader[0];
        SystemCache.set(new SchemaTypeLoaderCache(null));
    }

    private SchemaTypeLoaderImpl(SchemaTypeLoader[] r3, ResourceLoader r4, ClassLoader r5, String r6) {
        ResourceLoader r7 = (ResourceLoader) ZeusTransformUtils.wrapperContextForParams(r4, ResourceLoader.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L5;
        r3 = EMPTY_SCHEMATYPELOADER_ARRAY;
    L5:
        this._searchPath = r3;
        this._resourceLoader = r7;
        this._classLoader = r5;
        if (r6 == null) goto L8;
        this._metadataPath = r6;
    L12:
        initCaches();
        return;
    L8:
        String r8 = "schema" + METADATA_PACKAGE_LOAD.replace("/", "_");
        if (isPath30(r5) == false) goto L11;
        r8 = METADATA_PACKAGE_LOAD;
    L11:
        this._metadataPath = r8;
        goto L12
    }

    static /* synthetic */ ClassLoader access$000(SchemaTypeLoaderImpl r0) {
        return r0._classLoader;
    }

    static /* synthetic */ ResourceLoader access$200(SchemaTypeLoaderImpl r0) {
        return r0._resourceLoader;
    }

    static /* synthetic */ SchemaTypeLoader[] access$300(SchemaTypeLoaderImpl r0) {
        return r0._searchPath;
    }

    static /* synthetic */ SchemaTypeLoader[] access$400() {
        return EMPTY_SCHEMATYPELOADER_ARRAY;
    }

    public static SchemaTypeLoader build(SchemaTypeLoader[] r2, ResourceLoader r3, ClassLoader r4) {
        return build(r2, (ResourceLoader) ZeusTransformUtils.wrapperContextForParams(r3, ResourceLoader.class, "com.obric.memorydata.plugin"), r4, null);
    }

    public static SchemaTypeLoader build(SchemaTypeLoader[] r16, ResourceLoader r17, ClassLoader r18, String r19) {
        ResourceLoader r1 = (ResourceLoader) ZeusTransformUtils.wrapperContextForParams(r17, ResourceLoader.class, "com.obric.memorydata.plugin");
        SubLoaderList r3 = new SubLoaderList(null);
        r3.add(r16);
        if (r18 != null) goto L5;
        ClassLoader r5 = SchemaDocument.class.getClassLoader();
    L6:
        String[] r6 = basePackage;
        int r7 = r6.length;
        int r9 = 0;
    L7:
        if (r9 >= r7) goto L19;
        String r10 = r6[r9];
        String[] r11 = baseSchemas;
        int r12 = r11.length;
        int r13 = 0;
    L9:
        if (r13 >= r12) goto L17;
        r3.add((SchemaTypeLoader) ZeusTransformUtils.preCheckCast(Class.forName(r10 + ".system." + r11[r13] + ".TypeSystemHolder", true, r5).getDeclaredField("typeSystem").get(null), SchemaTypeLoader.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L13 ClassNotFoundException -> L20
    L13:
        e = move-exception;
        throw new XmlRuntimeException(e);
    L16:
        r13 = r13 + 1;
        goto L9
    L17:
        r9 = r9 + 1;
        goto L7
    L19:
        return new SchemaTypeLoaderImpl(r3.toArray(), r1, r18, r19);
    L5:
        r5 = r18;
        goto L6
    }

    static String crackEntry(ClassLoader r0, String r1) {
        InputStream r2 = r0.getResourceAsStream(r1);
        if (r2 != null) goto L6;
        return null;
    L6:
        return crackPointer(r2);
    }

    static String crackEntry(ResourceLoader r2, String r3) {
        InputStream r4 = ((ResourceLoader) ZeusTransformUtils.wrapperContextForParams(r2, ResourceLoader.class, "com.obric.memorydata.plugin")).getResourceAsStream(r3);
        if (r4 != null) goto L6;
        return null;
    L6:
        return crackPointer(r4);
    }

    static String crackPointer(InputStream r0) {
        return SchemaTypeSystemImpl.crackPointer(r0);
    }

    public static SchemaTypeLoaderImpl getContextTypeLoader() {
        ClassLoader r0 = Thread.currentThread().getContextClassLoader();
        SchemaTypeLoaderImpl r1 = (SchemaTypeLoaderImpl) ZeusTransformUtils.preCheckCast(SystemCache.get().getFromTypeLoaderCache(r0), SchemaTypeLoaderImpl.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L6;
        SchemaTypeLoaderImpl r2 = new SchemaTypeLoaderImpl(new SchemaTypeLoader[]{BuiltinSchemaTypeSystem.get()}, null, r0, null);
        SystemCache.get().addToTypeLoaderCache(r2, r0);
        return r2;
    L6:
        return r1;
    }

    private void initCaches() {
        this._classpathTypeSystems = Collections.synchronizedMap(new HashMap());
        this._classLoaderTypeSystems = Collections.synchronizedMap(new HashMap());
        this._elementCache = Collections.synchronizedMap(new HashMap());
        this._attributeCache = Collections.synchronizedMap(new HashMap());
        this._modelGroupCache = Collections.synchronizedMap(new HashMap());
        this._attributeGroupCache = Collections.synchronizedMap(new HashMap());
        this._idConstraintCache = Collections.synchronizedMap(new HashMap());
        this._typeCache = Collections.synchronizedMap(new HashMap());
        this._documentCache = Collections.synchronizedMap(new HashMap());
        this._attributeTypeCache = Collections.synchronizedMap(new HashMap());
        this._classnameCache = Collections.synchronizedMap(new HashMap());
    }

    private static boolean isPath30(ClassLoader r2) {
        String r0 = METADATA_PACKAGE_LOAD + "/system";
        if (r2 != null) goto L7;
        r2 = SchemaDocument.class.getClassLoader();
    L7:
        if (r2.getResource(r0) == null) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaAttributeGroup.Ref findAttributeGroupRef(QName r5) {
        Object r0 = this._attributeGroupCache.get(r5);
        if (r0 != CACHED_NOT_FOUND) goto L6;
        return null;
    L6:
        SchemaAttributeGroup.Ref r1 = (SchemaAttributeGroup.Ref) ZeusTransformUtils.preCheckCast(r0, SchemaAttributeGroup.Ref.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L23;
        SchemaTypeLoader[] r2 = this._searchPath;
        int r3 = r2.length;
        int r4 = 0;
    L9:
        if (r4 >= r3) goto L14;
        r1 = r2[r4].findAttributeGroupRef(r5);
        if (r1 != null) goto L14;
        r4 = r4 + 1;
    L14:
        if (r1 != null) goto L18;
        SchemaTypeSystemImpl r6 = typeSystemForComponent(this._metadataPath + "/attributegroup/", r5);
        if (r6 == null) goto L18;
        r1 = r6.findAttributeGroupRef(r5);
    L18:
        Map<QName, Object> r7 = this._attributeGroupCache;
        if (r1 != null) goto L21;
        Object r8 = CACHED_NOT_FOUND;
    L22:
        r7.put(r5, r8);
        goto L23
    L21:
        r8 = r1;
    L23:
        return r1;
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaGlobalAttribute.Ref findAttributeRef(QName r5) {
        Object r0 = this._attributeCache.get(r5);
        if (r0 != CACHED_NOT_FOUND) goto L6;
        return null;
    L6:
        SchemaGlobalAttribute.Ref r1 = (SchemaGlobalAttribute.Ref) ZeusTransformUtils.preCheckCast(r0, SchemaGlobalAttribute.Ref.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L23;
        SchemaTypeLoader[] r2 = this._searchPath;
        int r3 = r2.length;
        int r4 = 0;
    L9:
        if (r4 >= r3) goto L14;
        r1 = r2[r4].findAttributeRef(r5);
        if (r1 != null) goto L14;
        r4 = r4 + 1;
    L14:
        if (r1 != null) goto L18;
        SchemaTypeSystemImpl r6 = typeSystemForComponent(this._metadataPath + "/attribute/", r5);
        if (r6 == null) goto L18;
        r1 = r6.findAttributeRef(r5);
    L18:
        Map<QName, Object> r7 = this._attributeCache;
        if (r1 != null) goto L21;
        Object r8 = CACHED_NOT_FOUND;
    L22:
        r7.put(r5, r8);
        goto L23
    L21:
        r8 = r1;
    L23:
        return r1;
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaType.Ref findAttributeTypeRef(QName r5) {
        Object r0 = this._attributeTypeCache.get(r5);
        if (r0 != CACHED_NOT_FOUND) goto L6;
        return null;
    L6:
        SchemaType.Ref r1 = (SchemaType.Ref) ZeusTransformUtils.preCheckCast(r0, SchemaType.Ref.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L23;
        SchemaTypeLoader[] r2 = this._searchPath;
        int r3 = r2.length;
        int r4 = 0;
    L9:
        if (r4 >= r3) goto L14;
        r1 = r2[r4].findAttributeTypeRef(r5);
        if (r1 != null) goto L14;
        r4 = r4 + 1;
    L14:
        if (r1 != null) goto L18;
        SchemaTypeSystemImpl r6 = typeSystemForComponent(this._metadataPath + "/attribute/", r5);
        if (r6 == null) goto L18;
        r1 = r6.findAttributeTypeRef(r5);
    L18:
        Map<QName, Object> r7 = this._attributeTypeCache;
        if (r1 != null) goto L21;
        Object r8 = CACHED_NOT_FOUND;
    L22:
        r7.put(r5, r8);
        goto L23
    L21:
        r8 = r1;
    L23:
        return r1;
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaType.Ref findDocumentTypeRef(QName r5) {
        Object r0 = this._documentCache.get(r5);
        if (r0 != CACHED_NOT_FOUND) goto L6;
        return null;
    L6:
        SchemaType.Ref r1 = (SchemaType.Ref) ZeusTransformUtils.preCheckCast(r0, SchemaType.Ref.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L23;
        SchemaTypeLoader[] r2 = this._searchPath;
        int r3 = r2.length;
        int r4 = 0;
    L9:
        if (r4 >= r3) goto L14;
        r1 = r2[r4].findDocumentTypeRef(r5);
        if (r1 != null) goto L14;
        r4 = r4 + 1;
    L14:
        if (r1 != null) goto L18;
        SchemaTypeSystemImpl r6 = typeSystemForComponent(this._metadataPath + "/element/", r5);
        if (r6 == null) goto L18;
        r1 = r6.findDocumentTypeRef(r5);
    L18:
        Map<QName, Object> r7 = this._documentCache;
        if (r1 != null) goto L21;
        Object r8 = CACHED_NOT_FOUND;
    L22:
        r7.put(r5, r8);
        goto L23
    L21:
        r8 = r1;
    L23:
        return r1;
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaGlobalElement.Ref findElementRef(QName r5) {
        Object r0 = this._elementCache.get(r5);
        if (r0 != CACHED_NOT_FOUND) goto L6;
        return null;
    L6:
        SchemaGlobalElement.Ref r1 = (SchemaGlobalElement.Ref) ZeusTransformUtils.preCheckCast(r0, SchemaGlobalElement.Ref.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L23;
        SchemaTypeLoader[] r2 = this._searchPath;
        int r3 = r2.length;
        int r4 = 0;
    L9:
        if (r4 >= r3) goto L14;
        r1 = r2[r4].findElementRef(r5);
        if (r1 != null) goto L14;
        r4 = r4 + 1;
    L14:
        if (r1 != null) goto L18;
        SchemaTypeSystemImpl r6 = typeSystemForComponent(this._metadataPath + "/element/", r5);
        if (r6 == null) goto L18;
        r1 = r6.findElementRef(r5);
    L18:
        Map<QName, Object> r7 = this._elementCache;
        if (r1 != null) goto L21;
        Object r8 = CACHED_NOT_FOUND;
    L22:
        r7.put(r5, r8);
        goto L23
    L21:
        r8 = r1;
    L23:
        return r1;
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaIdentityConstraint.Ref findIdentityConstraintRef(QName r5) {
        Object r0 = this._idConstraintCache.get(r5);
        if (r0 != CACHED_NOT_FOUND) goto L6;
        return null;
    L6:
        SchemaIdentityConstraint.Ref r1 = (SchemaIdentityConstraint.Ref) ZeusTransformUtils.preCheckCast(r0, SchemaIdentityConstraint.Ref.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L23;
        SchemaTypeLoader[] r2 = this._searchPath;
        int r3 = r2.length;
        int r4 = 0;
    L9:
        if (r4 >= r3) goto L14;
        r1 = r2[r4].findIdentityConstraintRef(r5);
        if (r1 != null) goto L14;
        r4 = r4 + 1;
    L14:
        if (r1 != null) goto L18;
        SchemaTypeSystemImpl r6 = typeSystemForComponent(this._metadataPath + "/identityconstraint/", r5);
        if (r6 == null) goto L18;
        r1 = r6.findIdentityConstraintRef(r5);
    L18:
        Map<QName, Object> r7 = this._idConstraintCache;
        if (r1 != null) goto L21;
        Object r8 = CACHED_NOT_FOUND;
    L22:
        r7.put(r5, r8);
        goto L23
    L21:
        r8 = r1;
    L23:
        return r1;
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaModelGroup.Ref findModelGroupRef(QName r5) {
        Object r0 = this._modelGroupCache.get(r5);
        if (r0 != CACHED_NOT_FOUND) goto L6;
        return null;
    L6:
        SchemaModelGroup.Ref r1 = (SchemaModelGroup.Ref) ZeusTransformUtils.preCheckCast(r0, SchemaModelGroup.Ref.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L23;
        SchemaTypeLoader[] r2 = this._searchPath;
        int r3 = r2.length;
        int r4 = 0;
    L9:
        if (r4 >= r3) goto L14;
        r1 = r2[r4].findModelGroupRef(r5);
        if (r1 != null) goto L14;
        r4 = r4 + 1;
    L14:
        if (r1 != null) goto L18;
        SchemaTypeSystemImpl r6 = typeSystemForComponent(this._metadataPath + "/modelgroup/", r5);
        if (r6 == null) goto L18;
        r1 = r6.findModelGroupRef(r5);
    L18:
        Map<QName, Object> r7 = this._modelGroupCache;
        if (r1 != null) goto L21;
        Object r8 = CACHED_NOT_FOUND;
    L22:
        r7.put(r5, r8);
        goto L23
    L21:
        r8 = r1;
    L23:
        return r1;
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaType.Ref findTypeRef(QName r5) {
        Object r0 = this._typeCache.get(r5);
        if (r0 != CACHED_NOT_FOUND) goto L6;
        return null;
    L6:
        SchemaType.Ref r1 = (SchemaType.Ref) ZeusTransformUtils.preCheckCast(r0, SchemaType.Ref.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L23;
        SchemaTypeLoader[] r2 = this._searchPath;
        int r3 = r2.length;
        int r4 = 0;
    L9:
        if (r4 >= r3) goto L14;
        r1 = r2[r4].findTypeRef(r5);
        if (r1 != null) goto L14;
        r4 = r4 + 1;
    L14:
        if (r1 != null) goto L18;
        SchemaTypeSystemImpl r6 = typeSystemForComponent(this._metadataPath + "/type/", r5);
        if (r6 == null) goto L18;
        r1 = r6.findTypeRef(r5);
    L18:
        Map<QName, Object> r7 = this._typeCache;
        if (r1 != null) goto L21;
        Object r8 = CACHED_NOT_FOUND;
    L22:
        r7.put(r5, r8);
        goto L23
    L21:
        r8 = r1;
    L23:
        return r1;
    }

    SchemaTypeSystemImpl getTypeSystemOnClassloader(String r4) {
        XBeanDebug.LOG.atTrace().a("Finding type system {} on classloader", r4);
        SchemaTypeSystemImpl r0 = (SchemaTypeSystemImpl) ZeusTransformUtils.preCheckCast(this._classLoaderTypeSystems.get(r4), SchemaTypeSystemImpl.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L6;
        XBeanDebug.LOG.atTrace().a("Type system {}} not cached - consulting field", r4);
        SchemaTypeSystemImpl r1 = SchemaTypeSystemImpl.forName(r4, this._classLoader);
        this._classLoaderTypeSystems.put(r4, r1);
        return r1;
    L6:
        return r0;
    }

    SchemaTypeSystemImpl getTypeSystemOnClasspath(String r3) {
        return (SchemaTypeSystemImpl) ZeusTransformUtils.preCheckCast(this._classpathTypeSystems.computeIfAbsent(r3, new $$Lambda$SchemaTypeLoaderImpl$uWpJQQwgG9HAMhgCucq70vROe8(this)), SchemaTypeSystemImpl.class, "com.obric.memorydata.plugin");
    }

    public /* synthetic */ SchemaTypeSystemImpl lambda$getTypeSystemOnClasspath$0$SchemaTypeLoaderImpl(String r3) {
        return new SchemaTypeSystemImpl(this._resourceLoader, r3, this);
    }

    SchemaTypeSystemImpl typeSystemForComponent(String r3, QName r4) {
        String r5 = r3 + QNameHelper.hexsafedir(r4) + ".xsb";
        ResourceLoader r6 = this._resourceLoader;
        if (r6 == null) goto L5;
        String r7 = crackEntry(r6, r5);
    L6:
        ClassLoader r1 = this._classLoader;
        if (r1 == null) goto L9;
        r7 = crackEntry(r1, r5);
    L9:
        if (r7 != null) goto L11;
        return null;
    L11:
        return (SchemaTypeSystemImpl) ZeusTransformUtils.preCheckCast(typeSystemForName(r7), SchemaTypeSystemImpl.class, "com.obric.memorydata.plugin");
    L5:
        r7 = null;
        goto L6
    }

    public SchemaTypeSystem typeSystemForName(String r2) {
        if (this._resourceLoader == null) goto L8;
        SchemaTypeSystemImpl r0 = getTypeSystemOnClasspath(r2);
        if (r0 == null) goto L8;
        return r0;
    L8:
        if (this._classLoader == null) goto L12;
        SchemaTypeSystemImpl r1 = getTypeSystemOnClassloader(r2);
        if (r1 == null) goto L14;
        return r1;
    L14:
        return null;
    L12:
        return null;
    }
}
