package org.apache.xmlbeans;

import com.bytedance.retrofit2.HttpMethodContrants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.net.URI;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.impl.store.Saaj;
import org.xml.sax.EntityResolver;
import org.xml.sax.XMLReader;

/* JADX INFO: loaded from: classes7.dex */
public class XmlOptions implements Serializable {
    public static final int DEFAULT_ENTITY_EXPANSION_LIMIT = 2048;
    private static final XmlOptions EMPTY_OPTIONS = null;
    private static final long serialVersionUID = 1;
    private Map<XmlOptionsKeys, Object> _map;

    public static final enum BeanMethod extends Enum<BeanMethod> {
        private static final /* synthetic */ BeanMethod[] $VALUES = null;
        public static final BeanMethod ADD = null;
        public static final BeanMethod ADD_NEW = null;
        public static final BeanMethod GET = null;
        public static final BeanMethod GET_ARRAY = null;
        public static final BeanMethod GET_IDX = null;
        public static final BeanMethod GET_LIST = null;
        public static final BeanMethod INSERT_IDX = null;
        public static final BeanMethod INSERT_NEW_IDX = null;
        public static final BeanMethod INSTANCE_TYPE = null;
        public static final BeanMethod IS_NIL = null;
        public static final BeanMethod IS_NIL_IDX = null;
        public static final BeanMethod IS_SET = null;
        public static final BeanMethod REMOVE_IDX = null;
        public static final BeanMethod SET = null;
        public static final BeanMethod SET_ARRAY = null;
        public static final BeanMethod SET_IDX = null;
        public static final BeanMethod SET_LIST = null;
        public static final BeanMethod SET_NIL = null;
        public static final BeanMethod SET_NIL_IDX = null;
        public static final BeanMethod SIZE_OF_ARRAY = null;
        public static final BeanMethod UNSET = null;
        public static final BeanMethod XGET = null;
        public static final BeanMethod XGET_ARRAY = null;
        public static final BeanMethod XGET_IDX = null;
        public static final BeanMethod XGET_LIST = null;
        public static final BeanMethod XSET = null;
        public static final BeanMethod XSET_ARRAY = null;
        public static final BeanMethod XSET_IDX = null;

        static {
            BeanMethod r0 = new BeanMethod(HttpMethodContrants.GET, 0);
            GET = r0;
            BeanMethod r1 = new BeanMethod("XGET", 1);
            XGET = r1;
            BeanMethod r3 = new BeanMethod("IS_SET", 2);
            IS_SET = r3;
            BeanMethod r5 = new BeanMethod("IS_NIL", 3);
            IS_NIL = r5;
            BeanMethod r7 = new BeanMethod("IS_NIL_IDX", 4);
            IS_NIL_IDX = r7;
            BeanMethod r9 = new BeanMethod("SET", 5);
            SET = r9;
            BeanMethod r11 = new BeanMethod("SET_NIL", 6);
            SET_NIL = r11;
            BeanMethod r13 = new BeanMethod("SET_NIL_IDX", 7);
            SET_NIL_IDX = r13;
            BeanMethod r15 = new BeanMethod("XSET", 8);
            XSET = r15;
            BeanMethod r14 = new BeanMethod("UNSET", 9);
            UNSET = r14;
            BeanMethod r12 = new BeanMethod("GET_ARRAY", 10);
            GET_ARRAY = r12;
            BeanMethod r10 = new BeanMethod("XGET_ARRAY", 11);
            XGET_ARRAY = r10;
            BeanMethod r8 = new BeanMethod("GET_IDX", 12);
            GET_IDX = r8;
            BeanMethod r6 = new BeanMethod("XGET_IDX", 13);
            XGET_IDX = r6;
            BeanMethod r4 = new BeanMethod("XSET_ARRAY", 14);
            XSET_ARRAY = r4;
            BeanMethod r2 = new BeanMethod("XSET_IDX", 15);
            XSET_IDX = r2;
            BeanMethod r16 = new BeanMethod("SIZE_OF_ARRAY", 16);
            SIZE_OF_ARRAY = r16;
            BeanMethod r17 = new BeanMethod("SET_ARRAY", 17);
            SET_ARRAY = r17;
            BeanMethod r18 = new BeanMethod("SET_IDX", 18);
            SET_IDX = r18;
            BeanMethod r19 = new BeanMethod("INSERT_IDX", 19);
            INSERT_IDX = r19;
            BeanMethod r20 = new BeanMethod("INSERT_NEW_IDX", 20);
            INSERT_NEW_IDX = r20;
            BeanMethod r21 = new BeanMethod("ADD", 21);
            ADD = r21;
            BeanMethod r22 = new BeanMethod("ADD_NEW", 22);
            ADD_NEW = r22;
            BeanMethod r23 = new BeanMethod("REMOVE_IDX", 23);
            REMOVE_IDX = r23;
            BeanMethod r24 = new BeanMethod("GET_LIST", 24);
            GET_LIST = r24;
            BeanMethod r25 = new BeanMethod("XGET_LIST", 25);
            XGET_LIST = r25;
            BeanMethod r26 = new BeanMethod("SET_LIST", 26);
            SET_LIST = r26;
            BeanMethod r27 = new BeanMethod("INSTANCE_TYPE", 27);
            INSTANCE_TYPE = r27;
            $VALUES = new BeanMethod[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6, r4, r2, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27};
        }

        private BeanMethod(String r1, int r2) {
            super(r1, r2);
        }

        public static BeanMethod valueOf(String r2) {
            return (BeanMethod) ZeusTransformUtils.preCheckCast(Enum.valueOf(BeanMethod.class, r2), BeanMethod.class, "com.obric.memorydata.plugin");
        }

        public static BeanMethod[] values() {
            return (BeanMethod[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), BeanMethod[].class, "com.obric.memorydata.plugin");
        }
    }

    public static final enum XmlOptionsKeys extends Enum<XmlOptionsKeys> {
        private static final /* synthetic */ XmlOptionsKeys[] $VALUES = null;
        public static final XmlOptionsKeys ATTRIBUTE_VALIDATION_COMPAT_MODE = null;
        public static final XmlOptionsKeys BASE_URI = null;
        public static final XmlOptionsKeys CHARACTER_ENCODING = null;
        public static final XmlOptionsKeys COMPILE_ANNOTATION_JAVADOC = null;
        public static final XmlOptionsKeys COMPILE_DOWNLOAD_URLS = null;
        public static final XmlOptionsKeys COMPILE_MDEF_NAMESPACES = null;
        public static final XmlOptionsKeys COMPILE_NO_ANNOTATIONS = null;
        public static final XmlOptionsKeys COMPILE_NO_PVR_RULE = null;
        public static final XmlOptionsKeys COMPILE_NO_UPA_RULE = null;
        public static final XmlOptionsKeys COMPILE_NO_VALIDATION = null;
        public static final XmlOptionsKeys COMPILE_PARTIAL_METHODS = null;
        public static final XmlOptionsKeys COMPILE_PARTIAL_TYPESYSTEM = null;
        public static final XmlOptionsKeys COMPILE_SUBSTITUTE_NAMES = null;
        public static final XmlOptionsKeys COPY_USE_NEW_SYNC_DOMAIN = null;
        public static final XmlOptionsKeys DISALLOW_DOCTYPE_DECLARATION = null;
        public static final XmlOptionsKeys DOCUMENT_SOURCE_NAME = null;
        public static final XmlOptionsKeys DOCUMENT_TYPE = null;
        public static final XmlOptionsKeys ENTITY_EXPANSION_LIMIT = null;
        public static final XmlOptionsKeys ENTITY_RESOLVER = null;
        public static final XmlOptionsKeys ERROR_LISTENER = null;
        public static final XmlOptionsKeys GENERATE_JAVA_VERSION = null;
        public static final XmlOptionsKeys LOAD_ADDITIONAL_NAMESPACES = null;
        public static final XmlOptionsKeys LOAD_DTD_GRAMMAR = null;
        public static final XmlOptionsKeys LOAD_ENTITY_BYTES_LIMIT = null;
        public static final XmlOptionsKeys LOAD_EXTERNAL_DTD = null;
        public static final XmlOptionsKeys LOAD_LINE_NUMBERS = null;
        public static final XmlOptionsKeys LOAD_LINE_NUMBERS_END_ELEMENT = null;
        public static final XmlOptionsKeys LOAD_MESSAGE_DIGEST = null;
        public static final XmlOptionsKeys LOAD_REPLACE_DOCUMENT_ELEMENT = null;
        public static final XmlOptionsKeys LOAD_SAVE_CDATA_BOOKMARKS = null;
        public static final XmlOptionsKeys LOAD_STRIP_COMMENTS = null;
        public static final XmlOptionsKeys LOAD_STRIP_PROCINSTS = null;
        public static final XmlOptionsKeys LOAD_STRIP_WHITESPACE = null;
        public static final XmlOptionsKeys LOAD_SUBSTITUTE_NAMESPACES = null;
        public static final XmlOptionsKeys LOAD_TRIM_TEXT_BUFFER = null;
        public static final XmlOptionsKeys LOAD_USE_DEFAULT_RESOLVER = null;
        public static final XmlOptionsKeys LOAD_USE_LOCALE_CHAR_UTIL = null;
        public static final XmlOptionsKeys LOAD_USE_XMLREADER = null;
        public static final XmlOptionsKeys SAAJ_IMPL = null;
        public static final XmlOptionsKeys SAVE_AGGRESSIVE_NAMESPACES = null;
        public static final XmlOptionsKeys SAVE_CDATA_ENTITY_COUNT_THRESHOLD = null;
        public static final XmlOptionsKeys SAVE_CDATA_LENGTH_THRESHOLD = null;
        public static final XmlOptionsKeys SAVE_FILTER_PROCINST = null;
        public static final XmlOptionsKeys SAVE_IMPLICIT_NAMESPACES = null;
        public static final XmlOptionsKeys SAVE_INNER = null;
        public static final XmlOptionsKeys SAVE_NAMESPACES_FIRST = null;
        public static final XmlOptionsKeys SAVE_NO_XML_DECL = null;
        public static final XmlOptionsKeys SAVE_OPTIMIZE_FOR_SPEED = null;
        public static final XmlOptionsKeys SAVE_OUTER = null;
        public static final XmlOptionsKeys SAVE_PRETTY_PRINT = null;
        public static final XmlOptionsKeys SAVE_PRETTY_PRINT_INDENT = null;
        public static final XmlOptionsKeys SAVE_PRETTY_PRINT_OFFSET = null;
        public static final XmlOptionsKeys SAVE_SAX_NO_NSDECLS_IN_ATTRIBUTES = null;
        public static final XmlOptionsKeys SAVE_SUBSTITUTE_CHARACTERS = null;
        public static final XmlOptionsKeys SAVE_SUGGESTED_PREFIXES = null;
        public static final XmlOptionsKeys SAVE_SYNTHETIC_DOCUMENT_ELEMENT = null;
        public static final XmlOptionsKeys SAVE_USE_DEFAULT_NAMESPACE = null;
        public static final XmlOptionsKeys SAVE_USE_OPEN_FRAGMENT = null;
        public static final XmlOptionsKeys SCHEMA_CODE_PRINTER = null;
        public static final XmlOptionsKeys UNSYNCHRONIZED = null;
        public static final XmlOptionsKeys USE_SAME_LOCALE = null;
        public static final XmlOptionsKeys VALIDATE_ON_SET = null;
        public static final XmlOptionsKeys VALIDATE_STRICT = null;
        public static final XmlOptionsKeys VALIDATE_TEXT_ONLY = null;
        public static final XmlOptionsKeys VALIDATE_TREAT_LAX_AS_SKIP = null;
        public static final XmlOptionsKeys XPATH_USE_SAXON = null;
        public static final XmlOptionsKeys XPATH_USE_XMLBEANS = null;
        public static final XmlOptionsKeys XQUERY_CURRENT_NODE_VAR = null;
        public static final XmlOptionsKeys XQUERY_VARIABLE_MAP = null;

        static {
            SAVE_NAMESPACES_FIRST = new XmlOptionsKeys("SAVE_NAMESPACES_FIRST", 0);
            SAVE_SYNTHETIC_DOCUMENT_ELEMENT = new XmlOptionsKeys("SAVE_SYNTHETIC_DOCUMENT_ELEMENT", 1);
            SAVE_PRETTY_PRINT = new XmlOptionsKeys("SAVE_PRETTY_PRINT", 2);
            SAVE_PRETTY_PRINT_INDENT = new XmlOptionsKeys("SAVE_PRETTY_PRINT_INDENT", 3);
            SAVE_PRETTY_PRINT_OFFSET = new XmlOptionsKeys("SAVE_PRETTY_PRINT_OFFSET", 4);
            SAVE_AGGRESSIVE_NAMESPACES = new XmlOptionsKeys("SAVE_AGGRESSIVE_NAMESPACES", 5);
            SAVE_USE_DEFAULT_NAMESPACE = new XmlOptionsKeys("SAVE_USE_DEFAULT_NAMESPACE", 6);
            SAVE_IMPLICIT_NAMESPACES = new XmlOptionsKeys("SAVE_IMPLICIT_NAMESPACES", 7);
            SAVE_SUGGESTED_PREFIXES = new XmlOptionsKeys("SAVE_SUGGESTED_PREFIXES", 8);
            SAVE_FILTER_PROCINST = new XmlOptionsKeys("SAVE_FILTER_PROCINST", 9);
            SAVE_USE_OPEN_FRAGMENT = new XmlOptionsKeys("SAVE_USE_OPEN_FRAGMENT", 10);
            SAVE_OUTER = new XmlOptionsKeys("SAVE_OUTER", 11);
            SAVE_INNER = new XmlOptionsKeys("SAVE_INNER", 12);
            SAVE_NO_XML_DECL = new XmlOptionsKeys("SAVE_NO_XML_DECL", 13);
            SAVE_SUBSTITUTE_CHARACTERS = new XmlOptionsKeys("SAVE_SUBSTITUTE_CHARACTERS", 14);
            SAVE_OPTIMIZE_FOR_SPEED = new XmlOptionsKeys("SAVE_OPTIMIZE_FOR_SPEED", 15);
            SAVE_CDATA_LENGTH_THRESHOLD = new XmlOptionsKeys("SAVE_CDATA_LENGTH_THRESHOLD", 16);
            SAVE_CDATA_ENTITY_COUNT_THRESHOLD = new XmlOptionsKeys("SAVE_CDATA_ENTITY_COUNT_THRESHOLD", 17);
            SAVE_SAX_NO_NSDECLS_IN_ATTRIBUTES = new XmlOptionsKeys("SAVE_SAX_NO_NSDECLS_IN_ATTRIBUTES", 18);
            LOAD_REPLACE_DOCUMENT_ELEMENT = new XmlOptionsKeys("LOAD_REPLACE_DOCUMENT_ELEMENT", 19);
            LOAD_STRIP_WHITESPACE = new XmlOptionsKeys("LOAD_STRIP_WHITESPACE", 20);
            LOAD_STRIP_COMMENTS = new XmlOptionsKeys("LOAD_STRIP_COMMENTS", 21);
            LOAD_STRIP_PROCINSTS = new XmlOptionsKeys("LOAD_STRIP_PROCINSTS", 22);
            LOAD_LINE_NUMBERS = new XmlOptionsKeys("LOAD_LINE_NUMBERS", 23);
            LOAD_LINE_NUMBERS_END_ELEMENT = new XmlOptionsKeys("LOAD_LINE_NUMBERS_END_ELEMENT", 24);
            LOAD_SAVE_CDATA_BOOKMARKS = new XmlOptionsKeys("LOAD_SAVE_CDATA_BOOKMARKS", 25);
            LOAD_SUBSTITUTE_NAMESPACES = new XmlOptionsKeys("LOAD_SUBSTITUTE_NAMESPACES", 26);
            LOAD_TRIM_TEXT_BUFFER = new XmlOptionsKeys("LOAD_TRIM_TEXT_BUFFER", 27);
            LOAD_ADDITIONAL_NAMESPACES = new XmlOptionsKeys("LOAD_ADDITIONAL_NAMESPACES", 28);
            LOAD_MESSAGE_DIGEST = new XmlOptionsKeys("LOAD_MESSAGE_DIGEST", 29);
            LOAD_USE_DEFAULT_RESOLVER = new XmlOptionsKeys("LOAD_USE_DEFAULT_RESOLVER", 30);
            LOAD_USE_XMLREADER = new XmlOptionsKeys("LOAD_USE_XMLREADER", 31);
            XQUERY_CURRENT_NODE_VAR = new XmlOptionsKeys("XQUERY_CURRENT_NODE_VAR", 32);
            XQUERY_VARIABLE_MAP = new XmlOptionsKeys("XQUERY_VARIABLE_MAP", 33);
            CHARACTER_ENCODING = new XmlOptionsKeys("CHARACTER_ENCODING", 34);
            ERROR_LISTENER = new XmlOptionsKeys("ERROR_LISTENER", 35);
            DOCUMENT_TYPE = new XmlOptionsKeys("DOCUMENT_TYPE", 36);
            DOCUMENT_SOURCE_NAME = new XmlOptionsKeys("DOCUMENT_SOURCE_NAME", 37);
            COMPILE_SUBSTITUTE_NAMES = new XmlOptionsKeys("COMPILE_SUBSTITUTE_NAMES", 38);
            COMPILE_NO_VALIDATION = new XmlOptionsKeys("COMPILE_NO_VALIDATION", 39);
            COMPILE_NO_UPA_RULE = new XmlOptionsKeys("COMPILE_NO_UPA_RULE", 40);
            COMPILE_NO_PVR_RULE = new XmlOptionsKeys("COMPILE_NO_PVR_RULE", 41);
            COMPILE_NO_ANNOTATIONS = new XmlOptionsKeys("COMPILE_NO_ANNOTATIONS", 42);
            COMPILE_DOWNLOAD_URLS = new XmlOptionsKeys("COMPILE_DOWNLOAD_URLS", 43);
            COMPILE_MDEF_NAMESPACES = new XmlOptionsKeys("COMPILE_MDEF_NAMESPACES", 44);
            COMPILE_PARTIAL_TYPESYSTEM = new XmlOptionsKeys("COMPILE_PARTIAL_TYPESYSTEM", 45);
            COMPILE_PARTIAL_METHODS = new XmlOptionsKeys("COMPILE_PARTIAL_METHODS", 46);
            COMPILE_ANNOTATION_JAVADOC = new XmlOptionsKeys("COMPILE_ANNOTATION_JAVADOC", 47);
            VALIDATE_ON_SET = new XmlOptionsKeys("VALIDATE_ON_SET", 48);
            VALIDATE_TREAT_LAX_AS_SKIP = new XmlOptionsKeys("VALIDATE_TREAT_LAX_AS_SKIP", 49);
            VALIDATE_STRICT = new XmlOptionsKeys("VALIDATE_STRICT", 50);
            VALIDATE_TEXT_ONLY = new XmlOptionsKeys("VALIDATE_TEXT_ONLY", 51);
            UNSYNCHRONIZED = new XmlOptionsKeys("UNSYNCHRONIZED", 52);
            ENTITY_RESOLVER = new XmlOptionsKeys("ENTITY_RESOLVER", 53);
            BASE_URI = new XmlOptionsKeys("BASE_URI", 54);
            SCHEMA_CODE_PRINTER = new XmlOptionsKeys("SCHEMA_CODE_PRINTER", 55);
            GENERATE_JAVA_VERSION = new XmlOptionsKeys("GENERATE_JAVA_VERSION", 56);
            USE_SAME_LOCALE = new XmlOptionsKeys("USE_SAME_LOCALE", 57);
            COPY_USE_NEW_SYNC_DOMAIN = new XmlOptionsKeys("COPY_USE_NEW_SYNC_DOMAIN", 58);
            LOAD_ENTITY_BYTES_LIMIT = new XmlOptionsKeys("LOAD_ENTITY_BYTES_LIMIT", 59);
            ENTITY_EXPANSION_LIMIT = new XmlOptionsKeys("ENTITY_EXPANSION_LIMIT", 60);
            LOAD_DTD_GRAMMAR = new XmlOptionsKeys("LOAD_DTD_GRAMMAR", 61);
            LOAD_EXTERNAL_DTD = new XmlOptionsKeys("LOAD_EXTERNAL_DTD", 62);
            DISALLOW_DOCTYPE_DECLARATION = new XmlOptionsKeys("DISALLOW_DOCTYPE_DECLARATION", 63);
            SAAJ_IMPL = new XmlOptionsKeys("SAAJ_IMPL", 64);
            LOAD_USE_LOCALE_CHAR_UTIL = new XmlOptionsKeys("LOAD_USE_LOCALE_CHAR_UTIL", 65);
            XPATH_USE_SAXON = new XmlOptionsKeys("XPATH_USE_SAXON", 66);
            XPATH_USE_XMLBEANS = new XmlOptionsKeys("XPATH_USE_XMLBEANS", 67);
            ATTRIBUTE_VALIDATION_COMPAT_MODE = new XmlOptionsKeys("ATTRIBUTE_VALIDATION_COMPAT_MODE", 68);
            $VALUES = new XmlOptionsKeys[]{SAVE_NAMESPACES_FIRST, SAVE_SYNTHETIC_DOCUMENT_ELEMENT, SAVE_PRETTY_PRINT, SAVE_PRETTY_PRINT_INDENT, SAVE_PRETTY_PRINT_OFFSET, SAVE_AGGRESSIVE_NAMESPACES, SAVE_USE_DEFAULT_NAMESPACE, SAVE_IMPLICIT_NAMESPACES, SAVE_SUGGESTED_PREFIXES, SAVE_FILTER_PROCINST, SAVE_USE_OPEN_FRAGMENT, SAVE_OUTER, SAVE_INNER, SAVE_NO_XML_DECL, SAVE_SUBSTITUTE_CHARACTERS, SAVE_OPTIMIZE_FOR_SPEED, SAVE_CDATA_LENGTH_THRESHOLD, SAVE_CDATA_ENTITY_COUNT_THRESHOLD, SAVE_SAX_NO_NSDECLS_IN_ATTRIBUTES, LOAD_REPLACE_DOCUMENT_ELEMENT, LOAD_STRIP_WHITESPACE, LOAD_STRIP_COMMENTS, LOAD_STRIP_PROCINSTS, LOAD_LINE_NUMBERS, LOAD_LINE_NUMBERS_END_ELEMENT, LOAD_SAVE_CDATA_BOOKMARKS, LOAD_SUBSTITUTE_NAMESPACES, LOAD_TRIM_TEXT_BUFFER, LOAD_ADDITIONAL_NAMESPACES, LOAD_MESSAGE_DIGEST, LOAD_USE_DEFAULT_RESOLVER, LOAD_USE_XMLREADER, XQUERY_CURRENT_NODE_VAR, XQUERY_VARIABLE_MAP, CHARACTER_ENCODING, ERROR_LISTENER, DOCUMENT_TYPE, DOCUMENT_SOURCE_NAME, COMPILE_SUBSTITUTE_NAMES, COMPILE_NO_VALIDATION, COMPILE_NO_UPA_RULE, COMPILE_NO_PVR_RULE, COMPILE_NO_ANNOTATIONS, COMPILE_DOWNLOAD_URLS, COMPILE_MDEF_NAMESPACES, COMPILE_PARTIAL_TYPESYSTEM, COMPILE_PARTIAL_METHODS, COMPILE_ANNOTATION_JAVADOC, VALIDATE_ON_SET, VALIDATE_TREAT_LAX_AS_SKIP, VALIDATE_STRICT, VALIDATE_TEXT_ONLY, UNSYNCHRONIZED, ENTITY_RESOLVER, BASE_URI, SCHEMA_CODE_PRINTER, GENERATE_JAVA_VERSION, USE_SAME_LOCALE, COPY_USE_NEW_SYNC_DOMAIN, LOAD_ENTITY_BYTES_LIMIT, ENTITY_EXPANSION_LIMIT, LOAD_DTD_GRAMMAR, LOAD_EXTERNAL_DTD, DISALLOW_DOCTYPE_DECLARATION, SAAJ_IMPL, LOAD_USE_LOCALE_CHAR_UTIL, XPATH_USE_SAXON, XPATH_USE_XMLBEANS, ATTRIBUTE_VALIDATION_COMPAT_MODE};
        }

        private XmlOptionsKeys(String r1, int r2) {
            super(r1, r2);
        }

        public static XmlOptionsKeys valueOf(String r2) {
            return (XmlOptionsKeys) ZeusTransformUtils.preCheckCast(Enum.valueOf(XmlOptionsKeys.class, r2), XmlOptionsKeys.class, "com.obric.memorydata.plugin");
        }

        public static XmlOptionsKeys[] values() {
            return (XmlOptionsKeys[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), XmlOptionsKeys[].class, "com.obric.memorydata.plugin");
        }
    }

    static {
        XmlOptions r0 = new XmlOptions();
        EMPTY_OPTIONS = r0;
        r0._map = Collections.unmodifiableMap(r0._map);
    }

    public XmlOptions() {
        this._map = new HashMap();
    }

    public XmlOptions(XmlOptions r2) {
        HashMap r0 = new HashMap();
        this._map = r0;
        if (r2 == null) goto L6;
        r0.putAll(r2._map);
        return;
    }

    public static XmlOptions maskNull(XmlOptions r0) {
        if (r0 == null) goto L4;
        return r0;
    L4:
        return EMPTY_OPTIONS;
    }

    private XmlOptions set(XmlOptionsKeys r2) {
        return set(r2, true);
    }

    private XmlOptions set(XmlOptionsKeys r1, int r2) {
        return set(r1, Integer.valueOf(r2));
    }

    private XmlOptions set(XmlOptionsKeys r2, Object r3) {
        this._map.put(r2, r3);
        return this;
    }

    private XmlOptions set(XmlOptionsKeys r1, boolean r2) {
        if (r2 == false) goto L4;
        set(r1, Boolean.TRUE);
    L5:
        return this;
    L4:
        remove(r1);
        goto L5
    }

    public boolean disallowDocTypeDeclaration() {
        Boolean r2 = (Boolean) ZeusTransformUtils.preCheckCast(get(XmlOptionsKeys.DISALLOW_DOCTYPE_DECLARATION), Boolean.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L5;
    L7:
        return false;
    L5:
        if (r2.booleanValue() == false) goto L7;
        return true;
    }

    public Object get(XmlOptionsKeys r1) {
        return this._map.get(r1);
    }

    public URI getBaseURI() {
        return (URI) ZeusTransformUtils.preCheckCast(get(XmlOptionsKeys.BASE_URI), URI.class, "com.obric.memorydata.plugin");
    }

    public String getCharacterEncoding() {
        return (String) ZeusTransformUtils.preCheckCast(get(XmlOptionsKeys.CHARACTER_ENCODING), String.class, "com.obric.memorydata.plugin");
    }

    public Set<String> getCompileMdefNamespaces() {
        return (Set) ZeusTransformUtils.preCheckCast(get(XmlOptionsKeys.COMPILE_MDEF_NAMESPACES), Set.class, "com.obric.memorydata.plugin");
    }

    public Set<BeanMethod> getCompilePartialMethod() {
        return (Set) ZeusTransformUtils.preCheckCast(get(XmlOptionsKeys.COMPILE_PARTIAL_METHODS), Set.class, "com.obric.memorydata.plugin");
    }

    public Map<QName, QName> getCompileSubstituteNames() {
        return (Map) ZeusTransformUtils.preCheckCast(get(XmlOptionsKeys.COMPILE_SUBSTITUTE_NAMES), Map.class, "com.obric.memorydata.plugin");
    }

    public String getDocumentSourceName() {
        return (String) ZeusTransformUtils.preCheckCast(get(XmlOptionsKeys.DOCUMENT_SOURCE_NAME), String.class, "com.obric.memorydata.plugin");
    }

    public SchemaType getDocumentType() {
        return (SchemaType) ZeusTransformUtils.preCheckCast(get(XmlOptionsKeys.DOCUMENT_TYPE), SchemaType.class, "com.obric.memorydata.plugin");
    }

    public int getEntityExpansionLimit() {
        Integer r2 = (Integer) ZeusTransformUtils.preCheckCast(get(XmlOptionsKeys.ENTITY_EXPANSION_LIMIT), Integer.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L6;
        return 2048;
    L6:
        return r2.intValue();
    }

    public EntityResolver getEntityResolver() {
        return (EntityResolver) ZeusTransformUtils.preCheckCast(get(XmlOptionsKeys.ENTITY_RESOLVER), EntityResolver.class, "com.obric.memorydata.plugin");
    }

    public Collection<XmlError> getErrorListener() {
        return (Collection) ZeusTransformUtils.preCheckCast(get(XmlOptionsKeys.ERROR_LISTENER), Collection.class, "com.obric.memorydata.plugin");
    }

    public Map<String, String> getLoadAdditionalNamespaces() {
        return (Map) ZeusTransformUtils.preCheckCast(get(XmlOptionsKeys.LOAD_ADDITIONAL_NAMESPACES), Map.class, "com.obric.memorydata.plugin");
    }

    public Integer getLoadEntityBytesLimit() {
        return (Integer) ZeusTransformUtils.preCheckCast(get(XmlOptionsKeys.LOAD_ENTITY_BYTES_LIMIT), Integer.class, "com.obric.memorydata.plugin");
    }

    public QName getLoadReplaceDocumentElement() {
        return (QName) ZeusTransformUtils.preCheckCast(get(XmlOptionsKeys.LOAD_REPLACE_DOCUMENT_ELEMENT), QName.class, "com.obric.memorydata.plugin");
    }

    public Map<String, String> getLoadSubstituteNamespaces() {
        return (Map) ZeusTransformUtils.preCheckCast(get(XmlOptionsKeys.LOAD_SUBSTITUTE_NAMESPACES), Map.class, "com.obric.memorydata.plugin");
    }

    public XMLReader getLoadUseXMLReader() {
        return (XMLReader) ZeusTransformUtils.preCheckCast(get(XmlOptionsKeys.LOAD_USE_XMLREADER), XMLReader.class, "com.obric.memorydata.plugin");
    }

    public Saaj getSaaj() {
        return (Saaj) ZeusTransformUtils.preCheckCast(get(XmlOptionsKeys.SAAJ_IMPL), Saaj.class, "com.obric.memorydata.plugin");
    }

    public Integer getSaveCDataEntityCountThreshold() {
        return (Integer) ZeusTransformUtils.preCheckCast(get(XmlOptionsKeys.SAVE_CDATA_ENTITY_COUNT_THRESHOLD), Integer.class, "com.obric.memorydata.plugin");
    }

    public Integer getSaveCDataLengthThreshold() {
        return (Integer) ZeusTransformUtils.preCheckCast(get(XmlOptionsKeys.SAVE_CDATA_LENGTH_THRESHOLD), Integer.class, "com.obric.memorydata.plugin");
    }

    public String getSaveFilterProcinst() {
        return (String) ZeusTransformUtils.preCheckCast(get(XmlOptionsKeys.SAVE_FILTER_PROCINST), String.class, "com.obric.memorydata.plugin");
    }

    public Map<String, String> getSaveImplicitNamespaces() {
        return (Map) ZeusTransformUtils.preCheckCast(get(XmlOptionsKeys.SAVE_IMPLICIT_NAMESPACES), Map.class, "com.obric.memorydata.plugin");
    }

    public Integer getSavePrettyPrintIndent() {
        return (Integer) ZeusTransformUtils.preCheckCast(get(XmlOptionsKeys.SAVE_PRETTY_PRINT_INDENT), Integer.class, "com.obric.memorydata.plugin");
    }

    public Integer getSavePrettyPrintOffset() {
        return (Integer) ZeusTransformUtils.preCheckCast(get(XmlOptionsKeys.SAVE_PRETTY_PRINT_OFFSET), Integer.class, "com.obric.memorydata.plugin");
    }

    public XmlOptionCharEscapeMap getSaveSubstituteCharacters() {
        return (XmlOptionCharEscapeMap) ZeusTransformUtils.preCheckCast(get(XmlOptionsKeys.SAVE_SUBSTITUTE_CHARACTERS), XmlOptionCharEscapeMap.class, "com.obric.memorydata.plugin");
    }

    public Map<String, String> getSaveSuggestedPrefixes() {
        return (Map) ZeusTransformUtils.preCheckCast(get(XmlOptionsKeys.SAVE_SUGGESTED_PREFIXES), Map.class, "com.obric.memorydata.plugin");
    }

    public QName getSaveSyntheticDocumentElement() {
        return (QName) ZeusTransformUtils.preCheckCast(get(XmlOptionsKeys.SAVE_SYNTHETIC_DOCUMENT_ELEMENT), QName.class, "com.obric.memorydata.plugin");
    }

    public SchemaCodePrinter getSchemaCodePrinter() {
        return (SchemaCodePrinter) ZeusTransformUtils.preCheckCast(get(XmlOptionsKeys.SCHEMA_CODE_PRINTER), SchemaCodePrinter.class, "com.obric.memorydata.plugin");
    }

    public Object getUseSameLocale() {
        return get(XmlOptionsKeys.USE_SAME_LOCALE);
    }

    public String getXqueryCurrentNodeVar() {
        return (String) ZeusTransformUtils.preCheckCast(get(XmlOptionsKeys.XQUERY_CURRENT_NODE_VAR), String.class, "com.obric.memorydata.plugin");
    }

    public Map<String, Object> getXqueryVariables() {
        return (Map) ZeusTransformUtils.preCheckCast(get(XmlOptionsKeys.XQUERY_VARIABLE_MAP), Map.class, "com.obric.memorydata.plugin");
    }

    public boolean hasOption(XmlOptionsKeys r1) {
        return this._map.containsKey(r1);
    }

    public boolean isAttributeValidationCompatMode() {
        Boolean r2 = (Boolean) ZeusTransformUtils.preCheckCast(get(XmlOptionsKeys.ATTRIBUTE_VALIDATION_COMPAT_MODE), Boolean.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L5;
    L7:
        return false;
    L5:
        if (r2.booleanValue() == false) goto L7;
        return true;
    }

    public boolean isCompileAnnotationAsJavadoc() {
        Boolean r2 = (Boolean) ZeusTransformUtils.preCheckCast(get(XmlOptionsKeys.COMPILE_ANNOTATION_JAVADOC), Boolean.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L5;
    L7:
        return false;
    L5:
        if (r2.booleanValue() == false) goto L7;
        return true;
    }

    public boolean isCompileDownloadUrls() {
        return hasOption(XmlOptionsKeys.COMPILE_DOWNLOAD_URLS);
    }

    public boolean isCompileNoAnnotations() {
        return hasOption(XmlOptionsKeys.COMPILE_NO_ANNOTATIONS);
    }

    public boolean isCompileNoPvrRule() {
        return hasOption(XmlOptionsKeys.COMPILE_NO_PVR_RULE);
    }

    public boolean isCompileNoUpaRule() {
        return hasOption(XmlOptionsKeys.COMPILE_NO_UPA_RULE);
    }

    public boolean isCompileNoValidation() {
        return hasOption(XmlOptionsKeys.COMPILE_NO_VALIDATION);
    }

    public boolean isCompilePartialTypesystem() {
        Boolean r2 = (Boolean) ZeusTransformUtils.preCheckCast(get(XmlOptionsKeys.COMPILE_PARTIAL_TYPESYSTEM), Boolean.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L5;
    L7:
        return false;
    L5:
        if (r2.booleanValue() == false) goto L7;
        return true;
    }

    public boolean isCopyUseNewSynchronizationDomain() {
        Boolean r2 = (Boolean) ZeusTransformUtils.preCheckCast(get(XmlOptionsKeys.COPY_USE_NEW_SYNC_DOMAIN), Boolean.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L5;
    L7:
        return false;
    L5:
        if (r2.booleanValue() == false) goto L7;
        return true;
    }

    public boolean isLoadDTDGrammar() {
        Boolean r2 = (Boolean) ZeusTransformUtils.preCheckCast(get(XmlOptionsKeys.LOAD_DTD_GRAMMAR), Boolean.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L5;
    L7:
        return false;
    L5:
        if (r2.booleanValue() == false) goto L7;
        return true;
    }

    public boolean isLoadExternalDTD() {
        Boolean r2 = (Boolean) ZeusTransformUtils.preCheckCast(get(XmlOptionsKeys.LOAD_EXTERNAL_DTD), Boolean.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L5;
    L7:
        return false;
    L5:
        if (r2.booleanValue() == false) goto L7;
        return true;
    }

    public boolean isLoadLineNumbers() {
        return hasOption(XmlOptionsKeys.LOAD_LINE_NUMBERS);
    }

    public boolean isLoadLineNumbersEndElement() {
        return hasOption(XmlOptionsKeys.LOAD_LINE_NUMBERS_END_ELEMENT);
    }

    public boolean isLoadMessageDigest() {
        return hasOption(XmlOptionsKeys.LOAD_MESSAGE_DIGEST);
    }

    public boolean isLoadStripComments() {
        return hasOption(XmlOptionsKeys.LOAD_STRIP_COMMENTS);
    }

    public boolean isLoadStripProcinsts() {
        return hasOption(XmlOptionsKeys.LOAD_STRIP_PROCINSTS);
    }

    public boolean isLoadTrimTextBuffer() {
        return hasOption(XmlOptionsKeys.LOAD_TRIM_TEXT_BUFFER);
    }

    public boolean isLoadUseDefaultResolver() {
        return hasOption(XmlOptionsKeys.LOAD_USE_DEFAULT_RESOLVER);
    }

    public boolean isLoadUseLocaleCharUtil() {
        Boolean r2 = (Boolean) ZeusTransformUtils.preCheckCast(get(XmlOptionsKeys.LOAD_USE_LOCALE_CHAR_UTIL), Boolean.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L5;
    L7:
        return false;
    L5:
        if (r2.booleanValue() == false) goto L7;
        return true;
    }

    public boolean isSaveAggressiveNamespaces() {
        return hasOption(XmlOptionsKeys.SAVE_AGGRESSIVE_NAMESPACES);
    }

    public boolean isSaveInner() {
        return hasOption(XmlOptionsKeys.SAVE_INNER);
    }

    public boolean isSaveNamespacesFirst() {
        return hasOption(XmlOptionsKeys.SAVE_NAMESPACES_FIRST);
    }

    public boolean isSaveNoXmlDecl() {
        return hasOption(XmlOptionsKeys.SAVE_NO_XML_DECL);
    }

    public boolean isSaveOptimizeForSpeed() {
        Boolean r2 = (Boolean) ZeusTransformUtils.preCheckCast(get(XmlOptionsKeys.SAVE_OPTIMIZE_FOR_SPEED), Boolean.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L5;
    L7:
        return false;
    L5:
        if (r2.booleanValue() == false) goto L7;
        return true;
    }

    public boolean isSaveOuter() {
        return hasOption(XmlOptionsKeys.SAVE_OUTER);
    }

    public boolean isSavePrettyPrint() {
        return hasOption(XmlOptionsKeys.SAVE_PRETTY_PRINT);
    }

    public boolean isSaveSaxNoNSDeclsInAttributes() {
        return hasOption(XmlOptionsKeys.SAVE_SAX_NO_NSDECLS_IN_ATTRIBUTES);
    }

    public boolean isSaveUseOpenFrag() {
        return hasOption(XmlOptionsKeys.SAVE_USE_OPEN_FRAGMENT);
    }

    public boolean isSetLoadStripWhitespace() {
        return hasOption(XmlOptionsKeys.LOAD_STRIP_WHITESPACE);
    }

    public boolean isUnsynchronized() {
        return hasOption(XmlOptionsKeys.UNSYNCHRONIZED);
    }

    public boolean isUseCDataBookmarks() {
        return hasOption(XmlOptionsKeys.LOAD_SAVE_CDATA_BOOKMARKS);
    }

    public boolean isUseDefaultNamespace() {
        return hasOption(XmlOptionsKeys.SAVE_USE_DEFAULT_NAMESPACE);
    }

    public boolean isValidateOnSet() {
        return hasOption(XmlOptionsKeys.VALIDATE_ON_SET);
    }

    public boolean isValidateStrict() {
        return hasOption(XmlOptionsKeys.VALIDATE_STRICT);
    }

    public boolean isValidateTextOnly() {
        return hasOption(XmlOptionsKeys.VALIDATE_TEXT_ONLY);
    }

    public boolean isValidateTreatLaxAsSkip() {
        return hasOption(XmlOptionsKeys.VALIDATE_TREAT_LAX_AS_SKIP);
    }

    public boolean isXPathUseSaxon() {
        Boolean r2 = (Boolean) ZeusTransformUtils.preCheckCast(get(XmlOptionsKeys.XPATH_USE_SAXON), Boolean.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L5;
    L7:
        return false;
    L5:
        if (r2.booleanValue() == false) goto L7;
        return true;
    }

    public boolean isXPathUseXmlBeans() {
        Boolean r2 = (Boolean) ZeusTransformUtils.preCheckCast(get(XmlOptionsKeys.XPATH_USE_XMLBEANS), Boolean.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L5;
    L7:
        return false;
    L5:
        if (r2.booleanValue() == false) goto L7;
        return true;
    }

    public void remove(XmlOptionsKeys r1) {
        this._map.remove(r1);
    }

    public XmlOptions setAttributeValidationCompatMode(boolean r2) {
        return set(XmlOptionsKeys.ATTRIBUTE_VALIDATION_COMPAT_MODE, r2);
    }

    public XmlOptions setBaseURI(URI r2) {
        return set(XmlOptionsKeys.BASE_URI, r2);
    }

    public XmlOptions setCharacterEncoding(String r2) {
        return set(XmlOptionsKeys.CHARACTER_ENCODING, r2);
    }

    public XmlOptions setCompileAnnotationAsJavadoc() {
        return setCompileAnnotationAsJavadoc(true);
    }

    public XmlOptions setCompileAnnotationAsJavadoc(boolean r2) {
        return set(XmlOptionsKeys.COMPILE_ANNOTATION_JAVADOC, r2);
    }

    public XmlOptions setCompileDownloadUrls() {
        return setCompileDownloadUrls(true);
    }

    public XmlOptions setCompileDownloadUrls(boolean r2) {
        return set(XmlOptionsKeys.COMPILE_DOWNLOAD_URLS, r2);
    }

    public XmlOptions setCompileMdefNamespaces(Set<String> r3) {
        Set r4 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.memorydata.plugin");
        return set(XmlOptionsKeys.COMPILE_MDEF_NAMESPACES, r4);
    }

    public XmlOptions setCompileNoAnnotations() {
        return setCompileNoAnnotations(true);
    }

    public XmlOptions setCompileNoAnnotations(boolean r2) {
        return set(XmlOptionsKeys.COMPILE_NO_ANNOTATIONS, r2);
    }

    public XmlOptions setCompileNoPvrRule() {
        return setCompileNoPvrRule(true);
    }

    public XmlOptions setCompileNoPvrRule(boolean r2) {
        return set(XmlOptionsKeys.COMPILE_NO_PVR_RULE, r2);
    }

    public XmlOptions setCompileNoUpaRule() {
        return setCompileNoUpaRule(true);
    }

    public XmlOptions setCompileNoUpaRule(boolean r2) {
        return set(XmlOptionsKeys.COMPILE_NO_UPA_RULE, r2);
    }

    public XmlOptions setCompileNoValidation() {
        return set(XmlOptionsKeys.COMPILE_NO_VALIDATION);
    }

    public void setCompilePartialMethod(Set<BeanMethod> r3) {
        Set r4 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L5;
    L8:
        remove(XmlOptionsKeys.COMPILE_PARTIAL_METHODS);
        return;
    L5:
        if (r4.isEmpty() == true) goto L8;
        set(XmlOptionsKeys.COMPILE_PARTIAL_METHODS, r4);
    }

    public XmlOptions setCompilePartialTypesystem() {
        return setCompilePartialTypesystem(true);
    }

    public XmlOptions setCompilePartialTypesystem(boolean r2) {
        return set(XmlOptionsKeys.COMPILE_PARTIAL_TYPESYSTEM, r2);
    }

    public XmlOptions setCompileSubstituteNames(Map<QName, QName> r3) {
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        return set(XmlOptionsKeys.COMPILE_SUBSTITUTE_NAMES, r4);
    }

    public XmlOptions setCopyUseNewSynchronizationDomain(boolean r2) {
        return set(XmlOptionsKeys.COPY_USE_NEW_SYNC_DOMAIN, r2);
    }

    public XmlOptions setDisallowDocTypeDeclaration(boolean r2) {
        return set(XmlOptionsKeys.DISALLOW_DOCTYPE_DECLARATION, r2);
    }

    public XmlOptions setDocumentSourceName(String r2) {
        return set(XmlOptionsKeys.DOCUMENT_SOURCE_NAME, r2);
    }

    public XmlOptions setDocumentType(SchemaType r3) {
        SchemaType r4 = (SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin");
        return set(XmlOptionsKeys.DOCUMENT_TYPE, r4);
    }

    public XmlOptions setEntityExpansionLimit(int r2) {
        return set(XmlOptionsKeys.ENTITY_EXPANSION_LIMIT, r2);
    }

    public XmlOptions setEntityResolver(EntityResolver r3) {
        EntityResolver r4 = (EntityResolver) ZeusTransformUtils.wrapperContextForParams(r3, EntityResolver.class, "com.obric.memorydata.plugin");
        return set(XmlOptionsKeys.ENTITY_RESOLVER, r4);
    }

    public XmlOptions setErrorListener(Collection<XmlError> r3) {
        Collection r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
        return set(XmlOptionsKeys.ERROR_LISTENER, r4);
    }

    public XmlOptions setLoadAdditionalNamespaces(Map<String, String> r3) {
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        return set(XmlOptionsKeys.LOAD_ADDITIONAL_NAMESPACES, r4);
    }

    public XmlOptions setLoadDTDGrammar(boolean r2) {
        return set(XmlOptionsKeys.LOAD_DTD_GRAMMAR, r2);
    }

    public XmlOptions setLoadEntityBytesLimit(int r2) {
        return set(XmlOptionsKeys.LOAD_ENTITY_BYTES_LIMIT, r2);
    }

    public XmlOptions setLoadExternalDTD(boolean r2) {
        return set(XmlOptionsKeys.LOAD_EXTERNAL_DTD, r2);
    }

    public XmlOptions setLoadLineNumbers() {
        return setLoadLineNumbers(true);
    }

    public XmlOptions setLoadLineNumbers(boolean r2) {
        return set(XmlOptionsKeys.LOAD_LINE_NUMBERS, r2);
    }

    public XmlOptions setLoadLineNumbersEndElement() {
        return setLoadLineNumbersEndElement(true);
    }

    public XmlOptions setLoadLineNumbersEndElement(boolean r2) {
        setLoadLineNumbers(true);
        return set(XmlOptionsKeys.LOAD_LINE_NUMBERS_END_ELEMENT, r2);
    }

    public XmlOptions setLoadMessageDigest() {
        return setLoadMessageDigest(true);
    }

    public XmlOptions setLoadMessageDigest(boolean r2) {
        return set(XmlOptionsKeys.LOAD_MESSAGE_DIGEST, r2);
    }

    public XmlOptions setLoadReplaceDocumentElement(QName r2) {
        return set(XmlOptionsKeys.LOAD_REPLACE_DOCUMENT_ELEMENT, r2);
    }

    public XmlOptions setLoadStripComments() {
        return setLoadStripComments(true);
    }

    public XmlOptions setLoadStripComments(boolean r2) {
        return set(XmlOptionsKeys.LOAD_STRIP_COMMENTS, r2);
    }

    public XmlOptions setLoadStripProcinsts() {
        return setLoadStripProcinsts(true);
    }

    public XmlOptions setLoadStripProcinsts(boolean r2) {
        return set(XmlOptionsKeys.LOAD_STRIP_PROCINSTS, r2);
    }

    public XmlOptions setLoadStripWhitespace() {
        return setLoadStripWhitespace(true);
    }

    public XmlOptions setLoadStripWhitespace(boolean r2) {
        return set(XmlOptionsKeys.LOAD_STRIP_WHITESPACE, r2);
    }

    public XmlOptions setLoadSubstituteNamespaces(Map<String, String> r3) {
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        return set(XmlOptionsKeys.LOAD_SUBSTITUTE_NAMESPACES, r4);
    }

    public XmlOptions setLoadTrimTextBuffer() {
        return setLoadTrimTextBuffer(true);
    }

    public XmlOptions setLoadTrimTextBuffer(boolean r2) {
        return set(XmlOptionsKeys.LOAD_TRIM_TEXT_BUFFER, r2);
    }

    public XmlOptions setLoadUseDefaultResolver() {
        return setLoadUseDefaultResolver(true);
    }

    public XmlOptions setLoadUseDefaultResolver(boolean r2) {
        return set(XmlOptionsKeys.LOAD_USE_DEFAULT_RESOLVER, r2);
    }

    public XmlOptions setLoadUseLocaleCharUtil(boolean r2) {
        return set(XmlOptionsKeys.LOAD_USE_LOCALE_CHAR_UTIL, r2);
    }

    public XmlOptions setLoadUseXMLReader(XMLReader r3) {
        XMLReader r4 = (XMLReader) ZeusTransformUtils.wrapperContextForParams(r3, XMLReader.class, "com.obric.memorydata.plugin");
        return set(XmlOptionsKeys.LOAD_USE_XMLREADER, r4);
    }

    public XmlOptions setSaaj(Saaj r3) {
        Saaj r4 = (Saaj) ZeusTransformUtils.wrapperContextForParams(r3, Saaj.class, "com.obric.memorydata.plugin");
        return set(XmlOptionsKeys.SAAJ_IMPL, r4);
    }

    public XmlOptions setSaveAggressiveNamespaces() {
        return setSaveAggressiveNamespaces(true);
    }

    public XmlOptions setSaveAggressiveNamespaces(boolean r2) {
        return set(XmlOptionsKeys.SAVE_AGGRESSIVE_NAMESPACES, r2);
    }

    public XmlOptions setSaveCDataEntityCountThreshold(int r2) {
        return set(XmlOptionsKeys.SAVE_CDATA_ENTITY_COUNT_THRESHOLD, r2);
    }

    public XmlOptions setSaveCDataLengthThreshold(int r2) {
        return set(XmlOptionsKeys.SAVE_CDATA_LENGTH_THRESHOLD, r2);
    }

    public XmlOptions setSaveFilterProcinst(String r2) {
        return set(XmlOptionsKeys.SAVE_FILTER_PROCINST, r2);
    }

    public XmlOptions setSaveImplicitNamespaces(Map<String, String> r3) {
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        return set(XmlOptionsKeys.SAVE_IMPLICIT_NAMESPACES, r4);
    }

    public XmlOptions setSaveInner() {
        return setSaveInner(true);
    }

    public XmlOptions setSaveInner(boolean r2) {
        return set(XmlOptionsKeys.SAVE_INNER, r2);
    }

    public XmlOptions setSaveNamespacesFirst() {
        return setSaveNamespacesFirst(true);
    }

    public XmlOptions setSaveNamespacesFirst(boolean r2) {
        return set(XmlOptionsKeys.SAVE_NAMESPACES_FIRST, r2);
    }

    public XmlOptions setSaveNoXmlDecl() {
        return setSaveNoXmlDecl(true);
    }

    public XmlOptions setSaveNoXmlDecl(boolean r2) {
        return set(XmlOptionsKeys.SAVE_NO_XML_DECL, r2);
    }

    public XmlOptions setSaveOptimizeForSpeed(boolean r2) {
        return set(XmlOptionsKeys.SAVE_OPTIMIZE_FOR_SPEED, r2);
    }

    public XmlOptions setSaveOuter() {
        return setSaveOuter(true);
    }

    public XmlOptions setSaveOuter(boolean r2) {
        return set(XmlOptionsKeys.SAVE_OUTER, r2);
    }

    public XmlOptions setSavePrettyPrint() {
        return setSavePrettyPrint(true);
    }

    public XmlOptions setSavePrettyPrint(boolean r2) {
        return set(XmlOptionsKeys.SAVE_PRETTY_PRINT, r2);
    }

    public XmlOptions setSavePrettyPrintIndent(int r2) {
        return set(XmlOptionsKeys.SAVE_PRETTY_PRINT_INDENT, r2);
    }

    public XmlOptions setSavePrettyPrintOffset(int r2) {
        return set(XmlOptionsKeys.SAVE_PRETTY_PRINT_OFFSET, r2);
    }

    public XmlOptions setSaveSaxNoNSDeclsInAttributes() {
        return setSaveSaxNoNSDeclsInAttributes(true);
    }

    public XmlOptions setSaveSaxNoNSDeclsInAttributes(boolean r2) {
        return set(XmlOptionsKeys.SAVE_SAX_NO_NSDECLS_IN_ATTRIBUTES, r2);
    }

    public XmlOptions setSaveSubstituteCharacters(XmlOptionCharEscapeMap r2) {
        return set(XmlOptionsKeys.SAVE_SUBSTITUTE_CHARACTERS, r2);
    }

    public XmlOptions setSaveSuggestedPrefixes(Map<String, String> r3) {
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        return set(XmlOptionsKeys.SAVE_SUGGESTED_PREFIXES, r4);
    }

    public XmlOptions setSaveSyntheticDocumentElement(QName r2) {
        return set(XmlOptionsKeys.SAVE_SYNTHETIC_DOCUMENT_ELEMENT, r2);
    }

    public XmlOptions setSaveUseOpenFrag() {
        return setSaveUseOpenFrag(true);
    }

    public XmlOptions setSaveUseOpenFrag(boolean r2) {
        return set(XmlOptionsKeys.SAVE_USE_OPEN_FRAGMENT, r2);
    }

    public XmlOptions setSchemaCodePrinter(SchemaCodePrinter r3) {
        SchemaCodePrinter r4 = (SchemaCodePrinter) ZeusTransformUtils.wrapperContextForParams(r3, SchemaCodePrinter.class, "com.obric.memorydata.plugin");
        return set(XmlOptionsKeys.SCHEMA_CODE_PRINTER, r4);
    }

    public XmlOptions setUnsynchronized() {
        return setUnsynchronized(true);
    }

    public XmlOptions setUnsynchronized(boolean r2) {
        return set(XmlOptionsKeys.UNSYNCHRONIZED, r2);
    }

    public XmlOptions setUseCDataBookmarks() {
        return set(XmlOptionsKeys.LOAD_SAVE_CDATA_BOOKMARKS);
    }

    public XmlOptions setUseDefaultNamespace() {
        return setUseDefaultNamespace(true);
    }

    public XmlOptions setUseDefaultNamespace(boolean r2) {
        return set(XmlOptionsKeys.SAVE_USE_DEFAULT_NAMESPACE, r2);
    }

    public XmlOptions setUseSameLocale(Object r2) {
        return set(XmlOptionsKeys.USE_SAME_LOCALE, r2);
    }

    public XmlOptions setValidateOnSet() {
        return setValidateOnSet(true);
    }

    public XmlOptions setValidateOnSet(boolean r2) {
        return set(XmlOptionsKeys.VALIDATE_ON_SET, r2);
    }

    public XmlOptions setValidateStrict() {
        return setValidateStrict(true);
    }

    public XmlOptions setValidateStrict(boolean r2) {
        return set(XmlOptionsKeys.VALIDATE_STRICT, r2);
    }

    public XmlOptions setValidateTextOnly() {
        return setValidateTextOnly(true);
    }

    public XmlOptions setValidateTextOnly(boolean r2) {
        return set(XmlOptionsKeys.VALIDATE_TEXT_ONLY, r2);
    }

    public XmlOptions setValidateTreatLaxAsSkip() {
        return setValidateTreatLaxAsSkip(true);
    }

    public XmlOptions setValidateTreatLaxAsSkip(boolean r2) {
        return set(XmlOptionsKeys.VALIDATE_TREAT_LAX_AS_SKIP, r2);
    }

    public XmlOptions setXPathUseSaxon() {
        return setXPathUseSaxon(true);
    }

    public XmlOptions setXPathUseSaxon(boolean r2) {
        return set(XmlOptionsKeys.XPATH_USE_SAXON, r2);
    }

    public XmlOptions setXPathUseXmlBeans() {
        return setXPathUseSaxon(true);
    }

    public XmlOptions setXPathUseXmlBeans(boolean r2) {
        return set(XmlOptionsKeys.XPATH_USE_XMLBEANS, r2);
    }

    public XmlOptions setXqueryCurrentNodeVar(String r2) {
        return set(XmlOptionsKeys.XQUERY_CURRENT_NODE_VAR, r2);
    }

    public XmlOptions setXqueryVariables(Map<String, Object> r3) {
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        return set(XmlOptionsKeys.XQUERY_VARIABLE_MAP, r4);
    }
}
