package org.apache.xmlbeans.impl.schema;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaAnnotation;
import org.apache.xmlbeans.SchemaAttributeGroup;
import org.apache.xmlbeans.SchemaComponent;
import org.apache.xmlbeans.SchemaGlobalAttribute;
import org.apache.xmlbeans.SchemaGlobalElement;
import org.apache.xmlbeans.SchemaIdentityConstraint;
import org.apache.xmlbeans.SchemaModelGroup;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SchemaTypeLoader;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.impl.values.XmlStringImpl;
import org.apache.xmlbeans.impl.values.XmlValueOutOfRangeException;
import org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument;

/* JADX INFO: loaded from: classes7.dex */
public class StscState {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final SchemaType[] EMPTY_ST_ARRAY = null;
    static final XmlValueRef[] FACETS_LIST = null;
    private static final XmlValueRef[] FACETS_NONE = null;
    static final XmlValueRef[] FACETS_UNION = null;
    private static final XmlValueRef[] FACETS_WS_COLLAPSE = null;
    static final boolean[] FIXED_FACETS_LIST = null;
    private static final boolean[] FIXED_FACETS_NONE = null;
    static final boolean[] FIXED_FACETS_UNION = null;
    private static final boolean[] FIXED_FACETS_WS = null;
    private static final XmlValueRef XMLSTR_COLLAPSE = null;
    private static final XmlValueRef XMLSTR_PRESERVE = null;
    private static final XmlValueRef XMLSTR_REPLACE = null;
    private static final ThreadLocal<Object> tl_stscStack = null;
    private boolean _allowPartial;
    private final List<SchemaAnnotation> _annotations;
    private final Map<QName, SchemaAttributeGroup> _attributeGroups;
    private final Map<QName, SchemaType> _attributeTypes;
    private URI _baseURI;
    private final Map<String, SchemaContainer> _containers;
    private byte[] _digest;
    private final Map<QName, SchemaType> _documentTypes;
    private final Map<QName, SchemaGlobalAttribute> _globalAttributes;
    private final Map<QName, SchemaGlobalElement> _globalElements;
    private final Map<QName, SchemaType> _globalTypes;
    private final Map<QName, SchemaIdentityConstraint> _idConstraints;
    private final Set<String> _mdefNamespaces;
    private final Map<String, SchemaComponent> _misspelledNames;
    private final Map<QName, SchemaModelGroup> _modelGroups;
    private final Set<String> _namespaces;
    private boolean _noDigest;
    private final Set<SchemaComponent> _processingGroups;
    private int _recoveredErrors;
    private final Map<SchemaAttributeGroupImpl, SchemaAttributeGroupImpl> _redefinedAttributeGroups;
    private final Map<SchemaTypeImpl, SchemaTypeImpl> _redefinedGlobalTypes;
    private final Map<SchemaModelGroupImpl, SchemaModelGroupImpl> _redefinedModelGroups;
    private final SchemaTypeLoader _s4sloader;
    private final Map<String, String> _sourceForUri;
    private final Map<String, SchemaType> _typesByClassname;

    static {
        XMLSTR_PRESERVE = buildString("preserve");
        XMLSTR_REPLACE = buildString("preserve");
        XMLSTR_COLLAPSE = buildString("preserve");
        EMPTY_ST_ARRAY = new SchemaType[0];
        XmlValueRef[] r2 = new XmlValueRef[12];
        FACETS_NONE = r2;
        boolean[] r3 = new boolean[12];
        FIXED_FACETS_NONE = r3;
        boolean[] r4 = new boolean[12];
        FIXED_FACETS_WS = r4;
        XmlValueRef[] r1 = {null, null, null, null, null, null, null, null, null, build_wsstring(3), null, null};
        FACETS_WS_COLLAPSE = r1;
        FACETS_UNION = r2;
        FIXED_FACETS_UNION = r3;
        FACETS_LIST = r1;
        FIXED_FACETS_LIST = r4;
        tl_stscStack = new ThreadLocal();
    }

    private StscState() {
        this._digest = null;
        this._noDigest = false;
        this._allowPartial = false;
        this._recoveredErrors = 0;
        this._containers = new LinkedHashMap();
        this._redefinedGlobalTypes = new LinkedHashMap();
        this._redefinedModelGroups = new LinkedHashMap();
        this._redefinedAttributeGroups = new LinkedHashMap();
        this._globalTypes = new LinkedHashMap();
        this._globalElements = new LinkedHashMap();
        this._globalAttributes = new LinkedHashMap();
        this._modelGroups = new LinkedHashMap();
        this._attributeGroups = new LinkedHashMap();
        this._documentTypes = new LinkedHashMap();
        this._attributeTypes = new LinkedHashMap();
        this._typesByClassname = new LinkedHashMap();
        this._misspelledNames = new HashMap();
        this._processingGroups = new LinkedHashSet();
        this._idConstraints = new LinkedHashMap();
        this._namespaces = new HashSet();
        this._annotations = new ArrayList();
        this._mdefNamespaces = buildDefaultMdefNamespaces();
        this._sourceForUri = new HashMap();
        this._baseURI = URI.create("project://local/");
        this._s4sloader = XmlBeans.typeLoaderForClassLoader(SchemaDocument.class.getClassLoader());
    }

    private static Set<String> buildDefaultMdefNamespaces() {
        return new HashSet(Collections.singletonList("http://www.openuri.org/2002/04/soap/conversation/"));
    }

    static XmlValueRef buildString(String r2) {
        if (r2 != null) goto L8;
        return null;
    L8:
        XmlStringImpl r1 = new XmlStringImpl();     // Catch: XmlValueOutOfRangeException -> L7
        r1.setStringValue(r2);     // Catch: XmlValueOutOfRangeException -> L7
        r1.setImmutable();     // Catch: XmlValueOutOfRangeException -> L7
        return new XmlValueRef(r1);
    L7:
        return null;
    }

    static XmlValueRef build_wsstring(int r1) {
        if (r1 == 1) goto L15;
        if (r1 == 2) goto L13;
        if (r1 == 3) goto L11;
        return null;
    L11:
        return XMLSTR_COLLAPSE;
    L13:
        return XMLSTR_REPLACE;
    L15:
        return XMLSTR_PRESERVE;
    }
}
