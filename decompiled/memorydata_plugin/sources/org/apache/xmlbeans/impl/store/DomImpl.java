package org.apache.xmlbeans.impl.store;

import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import javax.xml.namespace.QName;
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlRuntimeException;
import org.apache.xmlbeans.impl.common.XMLChar;
import org.w3c.dom.Attr;
import org.w3c.dom.CDATASection;
import org.w3c.dom.Comment;
import org.w3c.dom.DOMException;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentFragment;
import org.w3c.dom.DocumentType;
import org.w3c.dom.Element;
import org.w3c.dom.EntityReference;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.ProcessingInstruction;
import org.w3c.dom.Text;
import org.w3c.dom.UserDataHandler;

/* JADX INFO: loaded from: classes7.dex */
public final class DomImpl {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final NodeList _emptyNodeList = null;

    /* JADX INFO: renamed from: org.apache.xmlbeans.impl.store.DomImpl$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public interface Dom {
        QName getQName();

        Locale locale();

        boolean nodeCanHavePrefixUri();

        int nodeType();

        Cur tempCur();
    }

    public static class DomLevel3NotImplemented extends RuntimeException {
        DomLevel3NotImplemented() {
            super("DOM Level 3 Not implemented");
        }
    }

    private static class ElementsByTagNameNSNodeList extends ElementsNodeList {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final String _local;
        private final String _uri;

        static {
        }

        ElementsByTagNameNSNodeList(Dom r3, String r4, String r5) {
            super((Dom) ZeusTransformUtils.wrapperContextForParams(r3, Dom.class, "com.obric.memorydata.plugin"));
            if (r4 != null) goto L5;
            r4 = "";
        L5:
            this._uri = r4;
            this._local = r5;
        }

        @Override // org.apache.xmlbeans.impl.store.DomImpl.ElementsNodeList
        public boolean match(Dom r5) {
            Dom r6 = (Dom) ZeusTransformUtils.wrapperContextForParams(r5, Dom.class, "com.obric.memorydata.plugin");
            if (this._uri.equals("*") == true) goto L8;
            if (this._uri.equals(DomImpl._node_getNamespaceURI(r6)) == true) goto L8;
            return false;
        L8:
            if (this._local.equals("*") == false) goto L10;
        L11:
            return true;
        L10:
            if (this._local.equals(DomImpl._node_getLocalName(r6)) == true) goto L11;
            return false;
        }
    }

    private static class ElementsByTagNameNodeList extends ElementsNodeList {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final String _name;

        static {
        }

        ElementsByTagNameNodeList(Dom r3, String r4) {
            super((Dom) ZeusTransformUtils.wrapperContextForParams(r3, Dom.class, "com.obric.memorydata.plugin"));
            this._name = r4;
        }

        @Override // org.apache.xmlbeans.impl.store.DomImpl.ElementsNodeList
        public boolean match(Dom r3) {
            Dom r4 = (Dom) ZeusTransformUtils.wrapperContextForParams(r3, Dom.class, "com.obric.memorydata.plugin");
            if (this._name.equals("*") == false) goto L5;
        L8:
            return true;
        L5:
            if (this._name.equals(DomImpl._node_getNodeName(r4)) == true) goto L8;
            return false;
        }
    }

    private static abstract class ElementsNodeList implements NodeList {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private ArrayList<Dom> _elements;
        private final Locale _locale;
        private final Dom _root;
        private long _version;

        static {
        }

        ElementsNodeList(Dom r3) {
            Dom r4 = (Dom) ZeusTransformUtils.wrapperContextForParams(r3, Dom.class, "com.obric.memorydata.plugin");
            this._root = r4;
            this._locale = r4.locale();
            this._version = 0;
        }

        private void addElements(Dom r4) {
            Node r5 = DomImpl.firstChild((Dom) ZeusTransformUtils.wrapperContextForParams(r4, Dom.class, "com.obric.memorydata.plugin"));
        L3:
            if (r5 == null) goto L11;
            if (((Dom) ZeusTransformUtils.preCheckCast(r5, Dom.class, "com.obric.memorydata.plugin")).nodeType() != 1) goto L10;
            if (match((Dom) ZeusTransformUtils.preCheckCast(r5, Dom.class, "com.obric.memorydata.plugin")) == false) goto L9;
            this._elements.add((Dom) ZeusTransformUtils.preCheckCast(r5, Dom.class, "com.obric.memorydata.plugin"));
        L9:
            addElements((Dom) ZeusTransformUtils.preCheckCast(r5, Dom.class, "com.obric.memorydata.plugin"));
        L10:
            r5 = DomImpl.nextSibling((Dom) ZeusTransformUtils.preCheckCast(r5, Dom.class, "com.obric.memorydata.plugin"));
            goto L3
        }

        private void ensureElements() {
            if (this._version != this._locale.version()) goto L5;
            return;
        L5:
            this._version = this._locale.version();
            this._elements = new ArrayList();
            DomImpl.access$100(this._locale, true, new $$Lambda$DomImpl$ElementsNodeList$NHj55MSVF9vg4m_6fVmB5sqmSxQ(this));
        }

        @Override // org.w3c.dom.NodeList
        public int getLength() {
            ensureElements();
            return this._elements.size();
        }

        @Override // org.w3c.dom.NodeList
        public Node item(int r2) {
            ensureElements();
            if (r2 >= 0) goto L5;
        L8:
            return null;
        L5:
            if (r2 >= this._elements.size()) goto L8;
            return (Node) ZeusTransformUtils.preCheckCast(this._elements.get(r2), Node.class, "com.obric.memorydata.plugin");
        }

        public /* synthetic */ Object lambda$ensureElements$0$DomImpl$ElementsNodeList() {
            addElements(this._root);
            return null;
        }

        public abstract boolean match(Dom r1);
    }

    private static final class EmptyNodeList implements NodeList {
        private EmptyNodeList() {
        }

        /* synthetic */ EmptyNodeList(AnonymousClass1 r1) {
            this();
        }

        @Override // org.w3c.dom.NodeList
        public int getLength() {
            return 0;
        }

        @Override // org.w3c.dom.NodeList
        public Node item(int r1) {
            return null;
        }
    }

    static class HierarchyRequestErr extends DOMException {
        HierarchyRequestErr(String r2) {
            super(3, r2);
        }
    }

    static class IndexSizeError extends DOMException {
        IndexSizeError() {
            this("Index Size Error");
        }

        IndexSizeError(String r2) {
            super(1, r2);
        }
    }

    static class InuseAttributeError extends DOMException {
        InuseAttributeError() {
            this("Attribute currently in use error");
        }

        InuseAttributeError(String r2) {
            super(10, r2);
        }
    }

    static class InvalidCharacterError extends DOMException {
        InvalidCharacterError() {
            this("The name contains an invalid character");
        }

        InvalidCharacterError(String r2) {
            super(5, r2);
        }
    }

    static class NamespaceErr extends DOMException {
        NamespaceErr(String r2) {
            super(14, r2);
        }
    }

    static class NoModificationAllowedErr extends DOMException {
        NoModificationAllowedErr(String r2) {
            super(7, r2);
        }
    }

    static class NotFoundErr extends DOMException {
        NotFoundErr(String r2) {
            super(8, r2);
        }
    }

    static class NotSupportedError extends DOMException {
        NotSupportedError(String r2) {
            super(9, r2);
        }
    }

    static class WrongDocumentErr extends DOMException {
        WrongDocumentErr(String r2) {
            super(4, r2);
        }
    }

    static {
        _emptyNodeList = new EmptyNodeList(null);
    }

    public DomImpl() {
    }

    public static Element _attr_getOwnerElement(Dom r2) {
        return (Element) ZeusTransformUtils.preCheckCast(syncWrap((Dom) ZeusTransformUtils.wrapperContextForParams(r2, Dom.class, "com.obric.memorydata.plugin"), $$Lambda$jtt_wO7leGX5RA2Bdm2OdXYQZdg.INSTANCE), Element.class, "com.obric.memorydata.plugin");
    }

    public static boolean _attr_getSpecified(Dom r2) {
        Dom r3 = (Dom) ZeusTransformUtils.wrapperContextForParams(r2, Dom.class, "com.obric.memorydata.plugin");
        return true;
    }

    public static int _attributes_getLength(Dom r2) {
        return ((Integer) ZeusTransformUtils.preCheckCast(syncWrap((Dom) ZeusTransformUtils.wrapperContextForParams(r2, Dom.class, "com.obric.memorydata.plugin"), $$Lambda$49DgIe1YiyZQo6Lv1xw2B9xXk8.INSTANCE), Integer.class, "com.obric.memorydata.plugin")).intValue();
    }

    public static Node _attributes_getNamedItem(Dom r2, final String r3) {
        final Dom r4 = (Dom) ZeusTransformUtils.wrapperContextForParams(r2, Dom.class, "com.obric.memorydata.plugin");
        return (Node) ZeusTransformUtils.preCheckCast(syncWrap(r4, new $$Lambda$DomImpl$gVVLTtCAw_C4XtPI5J2KQHNamHk(r4, r3)), Node.class, "com.obric.memorydata.plugin");
    }

    public static Node _attributes_getNamedItemNS(Dom r2, final String r3, final String r4) {
        return (Node) ZeusTransformUtils.preCheckCast(syncWrap((Dom) ZeusTransformUtils.wrapperContextForParams(r2, Dom.class, "com.obric.memorydata.plugin"), new $$Lambda$DomImpl$hhW_VSN7ETmu6xtMNm5LUIZE0JY(r3, r4)), Node.class, "com.obric.memorydata.plugin");
    }

    public static Node _attributes_item(Dom r2, final int r3) {
        return (Node) ZeusTransformUtils.preCheckCast(syncWrap((Dom) ZeusTransformUtils.wrapperContextForParams(r2, Dom.class, "com.obric.memorydata.plugin"), new $$Lambda$DomImpl$GQtHLgHXl_1ERv7AxocDwndXsVs(r3)), Node.class, "com.obric.memorydata.plugin");
    }

    public static Node _attributes_removeNamedItem(Dom r2, final String r3) {
        return (Node) ZeusTransformUtils.preCheckCast(syncWrap((Dom) ZeusTransformUtils.wrapperContextForParams(r2, Dom.class, "com.obric.memorydata.plugin"), new $$Lambda$DomImpl$gjwLxaosBlEXa8HpyTlXbGNMmP8(r3)), Node.class, "com.obric.memorydata.plugin");
    }

    public static Node _attributes_removeNamedItemNS(Dom r2, final String r3, final String r4) {
        return (Node) ZeusTransformUtils.preCheckCast(syncWrap((Dom) ZeusTransformUtils.wrapperContextForParams(r2, Dom.class, "com.obric.memorydata.plugin"), new $$Lambda$DomImpl$X82D6YUHYKcCL5nyfxA4XffEwY(r3, r4)), Node.class, "com.obric.memorydata.plugin");
    }

    public static Node _attributes_setNamedItem(Dom r3, Node r4) {
        Dom r5 = (Dom) ZeusTransformUtils.wrapperContextForParams(r3, Dom.class, "com.obric.memorydata.plugin");
        Node r6 = (Node) ZeusTransformUtils.wrapperContextForParams(r4, Node.class, "com.obric.memorydata.plugin");
        Locale r0 = r5.locale();
        if (r6 == null) goto L13;
        if (ZeusTransformUtils.instanceOf(r6, Dom.class) == false) goto L11;
        final Dom r7 = (Dom) ZeusTransformUtils.preCheckCast(r6, Dom.class, "com.obric.memorydata.plugin");
        if (r7.locale() != r0) goto L11;
        return (Node) ZeusTransformUtils.preCheckCast(syncWrap(r5, new $$Lambda$DomImpl$mPxvVBvXYi7lJE9xCjloRu0qhMs(r7)), Node.class, "com.obric.memorydata.plugin");
    L11:
        throw new WrongDocumentErr("Attr to set is from another document");
    L13:
        throw new IllegalArgumentException("Attr to set is null");
    }

    public static Node _attributes_setNamedItemNS(Dom r3, Node r4) {
        Dom r5 = (Dom) ZeusTransformUtils.wrapperContextForParams(r3, Dom.class, "com.obric.memorydata.plugin");
        Node r6 = (Node) ZeusTransformUtils.wrapperContextForParams(r4, Node.class, "com.obric.memorydata.plugin");
        Locale r0 = r5.locale();
        if (r6 == null) goto L13;
        if (ZeusTransformUtils.instanceOf(r6, Dom.class) == false) goto L11;
        final Dom r7 = (Dom) ZeusTransformUtils.preCheckCast(r6, Dom.class, "com.obric.memorydata.plugin");
        if (r7.locale() != r0) goto L11;
        return (Node) ZeusTransformUtils.preCheckCast(syncWrap(r5, new $$Lambda$DomImpl$TfsRQqCE_b45aMxwnBeI1Y8nME(r7)), Node.class, "com.obric.memorydata.plugin");
    L11:
        throw new WrongDocumentErr("Attr to set is from another document");
    L13:
        throw new IllegalArgumentException("Attr to set is null");
    }

    public static void _characterData_appendData(Dom r2, String r3) {
        Dom r4 = (Dom) ZeusTransformUtils.wrapperContextForParams(r2, Dom.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L5;
        return;
    L5:
        if (r3.length() == 0) goto L9;
        _node_setNodeValue(r4, _node_getNodeValue(r4) + r3);
        return;
    }

    public static void _characterData_deleteData(Dom r3, int r4, int r5) {
        Dom r6 = (Dom) ZeusTransformUtils.wrapperContextForParams(r3, Dom.class, "com.obric.memorydata.plugin");
        String r0 = _characterData_getData(r6);
        if (r4 < 0) goto L14;
        if (r4 > r0.length()) goto L14;
        if (r5 < 0) goto L14;
        if ((r4 + r5) <= r0.length()) goto L10;
        r5 = r0.length() - r4;
    L10:
        if (r5 <= 0) goto L15;
        _characterData_setData(r6, r0.substring(0, r4) + r0.substring(r4 + r5));
        return;
    L15:
        return;
    L14:
        throw new IndexSizeError();
    }

    public static String _characterData_getData(Dom r2) {
        return _node_getNodeValue((Dom) ZeusTransformUtils.wrapperContextForParams(r2, Dom.class, "com.obric.memorydata.plugin"));
    }

    public static int _characterData_getLength(Dom r2) {
        return _characterData_getData((Dom) ZeusTransformUtils.wrapperContextForParams(r2, Dom.class, "com.obric.memorydata.plugin")).length();
    }

    public static void _characterData_insertData(Dom r3, int r4, String r5) {
        Dom r6 = (Dom) ZeusTransformUtils.wrapperContextForParams(r3, Dom.class, "com.obric.memorydata.plugin");
        String r0 = _characterData_getData(r6);
        if (r4 < 0) goto L12;
        if (r4 > r0.length()) goto L12;
        if (r5 != null) goto L8;
        return;
    L8:
        if (r5.length() <= 0) goto L14;
        _characterData_setData(r6, r0.substring(0, r4) + r5 + r0.substring(r4));
        return;
    L14:
        return;
    L12:
        throw new IndexSizeError();
    }

    public static void _characterData_replaceData(Dom r3, int r4, int r5, String r6) {
        Dom r7 = (Dom) ZeusTransformUtils.wrapperContextForParams(r3, Dom.class, "com.obric.memorydata.plugin");
        String r0 = _characterData_getData(r7);
        if (r4 < 0) goto L17;
        if (r4 > r0.length()) goto L17;
        if (r5 < 0) goto L17;
        if ((r4 + r5) <= r0.length()) goto L10;
        r5 = r0.length() - r4;
    L10:
        if (r5 <= 0) goto L18;
        StringBuilder r1 = new StringBuilder().append(r0.substring(0, r4));
        if (r6 != null) goto L14;
        r6 = "";
    L14:
        _characterData_setData(r7, r1.append(r6).append(r0.substring(r4 + r5)).toString());
        return;
    L18:
        return;
    L17:
        throw new IndexSizeError();
    }

    public static void _characterData_setData(Dom r2, String r3) {
        _node_setNodeValue((Dom) ZeusTransformUtils.wrapperContextForParams(r2, Dom.class, "com.obric.memorydata.plugin"), r3);
    }

    public static String _characterData_substringData(Dom r2, int r3, int r4) {
        String r5 = _characterData_getData((Dom) ZeusTransformUtils.wrapperContextForParams(r2, Dom.class, "com.obric.memorydata.plugin"));
        if (r3 < 0) goto L13;
        if (r3 > r5.length()) goto L13;
        if (r4 < 0) goto L13;
        if ((r3 + r4) <= r5.length()) goto L11;
        r4 = r5.length() - r3;
    L11:
        return r5.substring(r3, r4 + r3);
    L13:
        throw new IndexSizeError();
    }

    public static int _childNodes_getLength(Dom r3) {
        Dom r4 = (Dom) ZeusTransformUtils.wrapperContextForParams(r3, Dom.class, "com.obric.memorydata.plugin");
        Xobj r0 = (Xobj) ZeusTransformUtils.preCheckCast(r4, Xobj.class, "com.obric.memorydata.plugin");
        if (r0.isVacant() == true) goto L8;
        int r1 = r0.getDomZeroOneChildren();
        if (r1 >= 2) goto L8;
        return r1;
    L8:
        return ((Integer) ZeusTransformUtils.preCheckCast(syncWrapNoEnter(r4, $$Lambda$MtspagKDzqUjJcckI6t6_pSzW_g.INSTANCE), Integer.class, "com.obric.memorydata.plugin")).intValue();
    }

    public static Node _childNodes_item(Dom r2, final int r3) {
        Dom r4 = (Dom) ZeusTransformUtils.wrapperContextForParams(r2, Dom.class, "com.obric.memorydata.plugin");
        if (r3 != 0) goto L6;
        return _node_getFirstChild(r4);
    L6:
        return (Node) ZeusTransformUtils.preCheckCast(syncWrapNoEnter(r4, new $$Lambda$DomImpl$GnsxdOQmRjwAmNDMFwp4iu_1LlA(r3)), Node.class, "com.obric.memorydata.plugin");
    }

    public static Attr _document_createAttribute(Dom r2, final String r3) {
        return (Attr) ZeusTransformUtils.preCheckCast(syncWrap((Dom) ZeusTransformUtils.wrapperContextForParams(r2, Dom.class, "com.obric.memorydata.plugin"), new $$Lambda$DomImpl$6MfgjMdKmKdkPtFYvbE1L1_wt7Y(r3)), Attr.class, "com.obric.memorydata.plugin");
    }

    public static Attr _document_createAttributeNS(Dom r2, final String r3, final String r4) {
        return (Attr) ZeusTransformUtils.preCheckCast(syncWrap((Dom) ZeusTransformUtils.wrapperContextForParams(r2, Dom.class, "com.obric.memorydata.plugin"), new $$Lambda$DomImpl$ObdQ3xGYrhSQoxunzi8_YVeU_A(r3, r4)), Attr.class, "com.obric.memorydata.plugin");
    }

    public static CDATASection _document_createCDATASection(Dom r2, String r3) {
        return document_createCDATASection((Dom) ZeusTransformUtils.wrapperContextForParams(r2, Dom.class, "com.obric.memorydata.plugin"), r3);
    }

    public static Comment _document_createComment(Dom r2, final String r3) {
        return (Comment) ZeusTransformUtils.preCheckCast(syncWrap((Dom) ZeusTransformUtils.wrapperContextForParams(r2, Dom.class, "com.obric.memorydata.plugin"), new $$Lambda$DomImpl$omCgb3TE57c5fni2TrtmV_zI7U(r3)), Comment.class, "com.obric.memorydata.plugin");
    }

    public static DocumentFragment _document_createDocumentFragment(Dom r2) {
        return (DocumentFragment) ZeusTransformUtils.preCheckCast(syncWrap((Dom) ZeusTransformUtils.wrapperContextForParams(r2, Dom.class, "com.obric.memorydata.plugin"), $$Lambda$pa_iBiHPdD_rhqjVN_8W66jluis.INSTANCE), DocumentFragment.class, "com.obric.memorydata.plugin");
    }

    public static Element _document_createElement(Dom r2, final String r3) {
        return (Element) ZeusTransformUtils.preCheckCast(syncWrap((Dom) ZeusTransformUtils.wrapperContextForParams(r2, Dom.class, "com.obric.memorydata.plugin"), new $$Lambda$DomImpl$hOmF42AP6cZiPzH7NBqWWg3Db2Y(r3)), Element.class, "com.obric.memorydata.plugin");
    }

    public static Element _document_createElementNS(Dom r2, final String r3, final String r4) {
        return (Element) ZeusTransformUtils.preCheckCast(syncWrap((Dom) ZeusTransformUtils.wrapperContextForParams(r2, Dom.class, "com.obric.memorydata.plugin"), new $$Lambda$DomImpl$SVzrYjUHlYxzPdQfq1LYU5K0wHY(r3, r4)), Element.class, "com.obric.memorydata.plugin");
    }

    public static EntityReference _document_createEntityReference(Dom r1, String r2) {
        Dom r3 = (Dom) ZeusTransformUtils.wrapperContextForParams(r1, Dom.class, "com.obric.memorydata.plugin");
        throw new RuntimeException("Not implemented");
    }

    public static ProcessingInstruction _document_createProcessingInstruction(Dom r2, final String r3, final String r4) {
        return (ProcessingInstruction) ZeusTransformUtils.preCheckCast(syncWrap((Dom) ZeusTransformUtils.wrapperContextForParams(r2, Dom.class, "com.obric.memorydata.plugin"), new $$Lambda$DomImpl$cnBRAX6Xj2BNw2z5mKhcqUkYU7M(r3, r4)), ProcessingInstruction.class, "com.obric.memorydata.plugin");
    }

    public static Text _document_createTextNode(Dom r2, String r3) {
        return document_createTextNode((Dom) ZeusTransformUtils.wrapperContextForParams(r2, Dom.class, "com.obric.memorydata.plugin"), r3);
    }

    public static DocumentType _document_getDoctype(Dom r2) {
        return (DocumentType) ZeusTransformUtils.preCheckCast(syncWrap((Dom) ZeusTransformUtils.wrapperContextForParams(r2, Dom.class, "com.obric.memorydata.plugin"), $$Lambda$mitVy48k9IcgvnS85DnKyftMdM.INSTANCE), DocumentType.class, "com.obric.memorydata.plugin");
    }

    public static Element _document_getDocumentElement(Dom r2) {
        return (Element) ZeusTransformUtils.preCheckCast(syncWrap((Dom) ZeusTransformUtils.wrapperContextForParams(r2, Dom.class, "com.obric.memorydata.plugin"), $$Lambda$UUMllPEGaUM3prrn3YTHhsqll00.INSTANCE), Element.class, "com.obric.memorydata.plugin");
    }

    public static Element _document_getElementById(Dom r1, String r2) {
        Dom r3 = (Dom) ZeusTransformUtils.wrapperContextForParams(r1, Dom.class, "com.obric.memorydata.plugin");
        throw new RuntimeException("Not implemented");
    }

    public static NodeList _document_getElementsByTagName(Dom r2, final String r3) {
        return (NodeList) ZeusTransformUtils.preCheckCast(syncWrap((Dom) ZeusTransformUtils.wrapperContextForParams(r2, Dom.class, "com.obric.memorydata.plugin"), new $$Lambda$DomImpl$CEgWk8EVLkqeZY2NVy0tfVJ60(r3)), NodeList.class, "com.obric.memorydata.plugin");
    }

    public static NodeList _document_getElementsByTagNameNS(Dom r2, final String r3, final String r4) {
        return (NodeList) ZeusTransformUtils.preCheckCast(syncWrap((Dom) ZeusTransformUtils.wrapperContextForParams(r2, Dom.class, "com.obric.memorydata.plugin"), new $$Lambda$DomImpl$wjG31_5U461rRkukuTR7gtltcxM(r3, r4)), NodeList.class, "com.obric.memorydata.plugin");
    }

    public static DOMImplementation _document_getImplementation(Dom r2) {
        return ((Dom) ZeusTransformUtils.wrapperContextForParams(r2, Dom.class, "com.obric.memorydata.plugin")).locale();
    }

    public static Node _document_importNode(Dom r2, Node r3, final boolean r4) {
        Dom r5 = (Dom) ZeusTransformUtils.wrapperContextForParams(r2, Dom.class, "com.obric.memorydata.plugin");
        final Node r6 = (Node) ZeusTransformUtils.wrapperContextForParams(r3, Node.class, "com.obric.memorydata.plugin");
        return (Node) ZeusTransformUtils.preCheckCast(syncWrap(r5, new $$Lambda$DomImpl$biFz_22g4EkBKzTdAcLqKOMdgI(r6, r4)), Node.class, "com.obric.memorydata.plugin");
    }

    public static Document _domImplementation_createDocument(final Locale r2, final String r3, final String r4, DocumentType r5) {
        final DocumentType r6 = (DocumentType) ZeusTransformUtils.wrapperContextForParams(r5, DocumentType.class, "com.obric.memorydata.plugin");
        return (Document) ZeusTransformUtils.preCheckCast(syncWrapHelper(r2, true, new $$Lambda$DomImpl$8FonyFpb42E873I0_0DSNRfZS2I(r2, r3, r4, r6)), Document.class, "com.obric.memorydata.plugin");
    }

    public static boolean _domImplementation_hasFeature(Locale r1, String r2, String r3) {
        if (r2 != null) goto L5;
        return false;
    L5:
        if (r3 == null) goto L14;
        if (r3.length() <= 0) goto L14;
        if (r3.equals("1.0") == true) goto L14;
        if (r3.equals("2.0") == true) goto L14;
        return false;
    L14:
        if (r2.equalsIgnoreCase("core") == false) goto L18;
        return true;
    L18:
        return r2.equalsIgnoreCase("xml");
    }

    public static String _element_getAttribute(Dom r2, String r3) {
        Node r4 = _attributes_getNamedItem((Dom) ZeusTransformUtils.wrapperContextForParams(r2, Dom.class, "com.obric.memorydata.plugin"), r3);
        if (r4 != null) goto L6;
        return "";
    L6:
        return r4.getNodeValue();
    }

    public static String _element_getAttributeNS(Dom r2, String r3, String r4) {
        Node r5 = _attributes_getNamedItemNS((Dom) ZeusTransformUtils.wrapperContextForParams(r2, Dom.class, "com.obric.memorydata.plugin"), r3, r4);
        if (r5 != null) goto L6;
        return "";
    L6:
        return r5.getNodeValue();
    }

    public static Attr _element_getAttributeNode(Dom r2, String r3) {
        return (Attr) ZeusTransformUtils.preCheckCast(_attributes_getNamedItem((Dom) ZeusTransformUtils.wrapperContextForParams(r2, Dom.class, "com.obric.memorydata.plugin"), r3), Attr.class, "com.obric.memorydata.plugin");
    }

    public static Attr _element_getAttributeNodeNS(Dom r2, String r3, String r4) {
        return (Attr) ZeusTransformUtils.preCheckCast(_attributes_getNamedItemNS((Dom) ZeusTransformUtils.wrapperContextForParams(r2, Dom.class, "com.obric.memorydata.plugin"), r3, r4), Attr.class, "com.obric.memorydata.plugin");
    }

    public static NodeList _element_getElementsByTagName(Dom r2, final String r3) {
        return (NodeList) ZeusTransformUtils.preCheckCast(syncWrap((Dom) ZeusTransformUtils.wrapperContextForParams(r2, Dom.class, "com.obric.memorydata.plugin"), new $$Lambda$DomImpl$pNA9H_pB7U1RuZqZIzCH3eTN1I(r3)), NodeList.class, "com.obric.memorydata.plugin");
    }

    public static NodeList _element_getElementsByTagNameNS(Dom r2, final String r3, final String r4) {
        return (NodeList) ZeusTransformUtils.preCheckCast(syncWrap((Dom) ZeusTransformUtils.wrapperContextForParams(r2, Dom.class, "com.obric.memorydata.plugin"), new $$Lambda$DomImpl$92Q80Uv8PTzGYgzzlEId2_17oIo(r3, r4)), NodeList.class, "com.obric.memorydata.plugin");
    }

    public static String _element_getTagName(Dom r2) {
        return _node_getNodeName((Dom) ZeusTransformUtils.wrapperContextForParams(r2, Dom.class, "com.obric.memorydata.plugin"));
    }

    public static boolean _element_hasAttribute(Dom r2, String r3) {
        if (_attributes_getNamedItem((Dom) ZeusTransformUtils.wrapperContextForParams(r2, Dom.class, "com.obric.memorydata.plugin"), r3) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean _element_hasAttributeNS(Dom r2, String r3, String r4) {
        if (_attributes_getNamedItemNS((Dom) ZeusTransformUtils.wrapperContextForParams(r2, Dom.class, "com.obric.memorydata.plugin"), r3, r4) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public static void _element_removeAttribute(Dom r2, String r3) {
        _attributes_removeNamedItem((Dom) ZeusTransformUtils.wrapperContextForParams(r2, Dom.class, "com.obric.memorydata.plugin"), r3);     // Catch: NotFoundErr -> L5
        return;
    }

    public static void _element_removeAttributeNS(Dom r2, String r3, String r4) {
        _attributes_removeNamedItemNS((Dom) ZeusTransformUtils.wrapperContextForParams(r2, Dom.class, "com.obric.memorydata.plugin"), r3, r4);     // Catch: NotFoundErr -> L5
        return;
    }

    public static Attr _element_removeAttributeNode(Dom r2, Attr r3) {
        Dom r4 = (Dom) ZeusTransformUtils.wrapperContextForParams(r2, Dom.class, "com.obric.memorydata.plugin");
        Attr r5 = (Attr) ZeusTransformUtils.wrapperContextForParams(r3, Attr.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L11;
        if (r5.getOwnerElement() != r4) goto L9;
        return (Attr) ZeusTransformUtils.preCheckCast(_attributes_removeNamedItem(r4, r5.getNodeName()), Attr.class, "com.obric.memorydata.plugin");
    L9:
        throw new NotFoundErr("Attribute to remove does not belong to this element");
    L11:
        throw new NotFoundErr("Attribute to remove is null");
    }

    public static void _element_setAttribute(Dom r2, final String r3, final String r4) {
        syncWrapVoid((Dom) ZeusTransformUtils.wrapperContextForParams(r2, Dom.class, "com.obric.memorydata.plugin"), new $$Lambda$DomImpl$9Q0swTqcP3FL9SmL4_j4VSEtisw(r3, r4));
    }

    public static void _element_setAttributeNS(Dom r2, final String r3, final String r4, final String r5) {
        syncWrapVoid((Dom) ZeusTransformUtils.wrapperContextForParams(r2, Dom.class, "com.obric.memorydata.plugin"), new $$Lambda$DomImpl$W6l22RtRUYp3TL_ko__mzD1OPGs(r3, r4, r5));
    }

    public static Attr _element_setAttributeNode(Dom r2, Attr r3) {
        return (Attr) ZeusTransformUtils.preCheckCast(_attributes_setNamedItem((Dom) ZeusTransformUtils.wrapperContextForParams(r2, Dom.class, "com.obric.memorydata.plugin"), (Attr) ZeusTransformUtils.wrapperContextForParams(r3, Attr.class, "com.obric.memorydata.plugin")), Attr.class, "com.obric.memorydata.plugin");
    }

    public static Attr _element_setAttributeNodeNS(Dom r2, Attr r3) {
        return (Attr) ZeusTransformUtils.preCheckCast(_attributes_setNamedItemNS((Dom) ZeusTransformUtils.wrapperContextForParams(r2, Dom.class, "com.obric.memorydata.plugin"), (Attr) ZeusTransformUtils.wrapperContextForParams(r3, Attr.class, "com.obric.memorydata.plugin")), Attr.class, "com.obric.memorydata.plugin");
    }

    public static Node _node_appendChild(Dom r2, Node r3) {
        return _node_insertBefore((Dom) ZeusTransformUtils.wrapperContextForParams(r2, Dom.class, "com.obric.memorydata.plugin"), (Node) ZeusTransformUtils.wrapperContextForParams(r3, Node.class, "com.obric.memorydata.plugin"), null);
    }

    public static Node _node_cloneNode(Dom r2, final boolean r3) {
        return (Node) ZeusTransformUtils.preCheckCast(syncWrap((Dom) ZeusTransformUtils.wrapperContextForParams(r2, Dom.class, "com.obric.memorydata.plugin"), new $$Lambda$DomImpl$_lR8yp7MAb26aRjEktznEkGsGqE(r3)), Node.class, "com.obric.memorydata.plugin");
    }

    public static short _node_compareDocumentPosition(Dom r8, Node r9) {
        Dom r10 = (Dom) ZeusTransformUtils.wrapperContextForParams(r8, Dom.class, "com.obric.memorydata.plugin");
        Node r11 = (Node) ZeusTransformUtils.wrapperContextForParams(r9, Node.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r10, Node.class) == true) goto L5;
        return 32;
    L5:
        Iterator<Node> r12 = ancestorAndSelf((Node) ZeusTransformUtils.preCheckCast(r10, Node.class, "com.obric.memorydata.plugin")).iterator();
        Iterator<Node> r13 = ancestorAndSelf(r11).iterator();
        boolean r3 = true;
    L6:
        Node r4 = (Node) ZeusTransformUtils.preCheckCast(r12.next(), Node.class, "com.obric.memorydata.plugin");
        Node r5 = (Node) ZeusTransformUtils.preCheckCast(r13.next(), Node.class, "com.obric.memorydata.plugin");
        boolean r6 = Objects.equals(r4, r5);
        if (r3 == false) goto L10;
        if (r6 == true) goto L10;
        return 1;
    L10:
        r3 = false;
        if (r6 == false) goto L16;
        if (r12.hasNext() == false) goto L16;
        if (r13.hasNext() == true) goto L6;
    L16:
        if (r6 == true) goto L18;
    L24:
        r4 = r4.getPreviousSibling();
        if (r4 == null) goto L30;
        if (Objects.equals(r4, r5) == false) goto L24;
        return 2;
    L30:
        return 4;
    L18:
        if (r12.hasNext() == false) goto L21;
        return 10;
    L21:
        if (r13.hasNext() == false) goto L41;
        return 20;
    L41:
        return 32;
    }

    public static String _node_getBaseURI(Dom r2) {
        Dom r3 = (Dom) ZeusTransformUtils.wrapperContextForParams(r2, Dom.class, "com.obric.memorydata.plugin");
        throw new DomLevel3NotImplemented();
    }

    public static Object _node_getFeature(Dom r0, String r1, String r2) {
        Dom r3 = (Dom) ZeusTransformUtils.wrapperContextForParams(r0, Dom.class, "com.obric.memorydata.plugin");
        throw new DomLevel3NotImplemented();
    }

    public static Node _node_getFirstChild(Dom r4) {
        Dom r5 = (Dom) ZeusTransformUtils.wrapperContextForParams(r4, Dom.class, "com.obric.memorydata.plugin");
        Xobj r0 = (Xobj) ZeusTransformUtils.preCheckCast(r5, Xobj.class, "com.obric.memorydata.plugin");
        if (r0.isVacant() == true) goto L19;
        if (r0.isFirstChildPtrDomUsable() == true) goto L7;
        Xobj r2 = r0.lastAttr();
        if (r2 == null) goto L15;
        if (r2.isNextSiblingPtrDomUsable() == false) goto L15;
        return (NodeXobj) ZeusTransformUtils.preCheckCast(r2._nextSibling, NodeXobj.class, "com.obric.memorydata.plugin");
    L15:
        if (r0.isExistingCharNodesValueUsable() == false) goto L19;
        return r0._charNodesValue;
    L7:
        return (Node) ZeusTransformUtils.preCheckCast(r0._firstChild, Node.class, "com.obric.memorydata.plugin");
    L19:
        return (Node) ZeusTransformUtils.preCheckCast(syncWrapNoEnter(r5, $$Lambda$mvKLVh_B40BQwByOaI6rAUCct_g.INSTANCE), Node.class, "com.obric.memorydata.plugin");
    }

    public static Node _node_getLastChild(Dom r2) {
        return (Node) ZeusTransformUtils.preCheckCast(syncWrap((Dom) ZeusTransformUtils.wrapperContextForParams(r2, Dom.class, "com.obric.memorydata.plugin"), $$Lambda$woUnk9yHCEJAi2zmuXidNSU154Q.INSTANCE), Node.class, "com.obric.memorydata.plugin");
    }

    public static String _node_getLocalName(Dom r2) {
        Dom r3 = (Dom) ZeusTransformUtils.wrapperContextForParams(r2, Dom.class, "com.obric.memorydata.plugin");
        if (r3.nodeCanHavePrefixUri() == true) goto L6;
        return null;
    L6:
        QName r4 = r3.getQName();
        if (r4 != null) goto L10;
        return "";
    L10:
        return r4.getLocalPart();
    }

    public static String _node_getNamespaceURI(Dom r2) {
        Dom r3 = (Dom) ZeusTransformUtils.wrapperContextForParams(r2, Dom.class, "com.obric.memorydata.plugin");
        if (r3.nodeCanHavePrefixUri() == true) goto L6;
        return null;
    L6:
        QName r4 = r3.getQName();
        if (r4 != null) goto L10;
        return "";
    L10:
        return r4.getNamespaceURI();
    }

    public static Node _node_getNextSibling(Dom r2) {
        return (Node) ZeusTransformUtils.preCheckCast(syncWrapNoEnter((Dom) ZeusTransformUtils.wrapperContextForParams(r2, Dom.class, "com.obric.memorydata.plugin"), $$Lambda$_0Ldb99jTcJkZOvtpcUs7_xvPQE.INSTANCE), Node.class, "com.obric.memorydata.plugin");
    }

    public static String _node_getNodeName(Dom r2) {
        Dom r3 = (Dom) ZeusTransformUtils.wrapperContextForParams(r2, Dom.class, "com.obric.memorydata.plugin");
        switch(r3.nodeType()) {
            case 1: goto L20;
            case 2: goto L20;
            case 3: goto L18;
            case 4: goto L16;
            case 5: goto L15;
            case 6: goto L15;
            case 7: goto L13;
            case 8: goto L10;
            case 9: goto L8;
            case 10: goto L15;
            case 11: goto L6;
            case 12: goto L15;
            default: goto L5;
        };
    L6:
        return "#document-fragment";
    L8:
        return "#document";
    L10:
        return "#comment";
    L16:
        return "#cdata-section";
    L18:
        return "#text";
    L20:
        QName r4 = r3.getQName();
        String r0 = r4.getPrefix();
        if (r0.length() != 0) goto L24;
        return r4.getLocalPart();
    L24:
        return r0 + ParameterizedMessage.ERROR_MSG_SEPARATOR + r4.getLocalPart();
    L5:
        throw new RuntimeException("Unknown node type");
    L13:
        return r3.getQName().getLocalPart();
    L15:
        throw new RuntimeException("Not impl");
    }

    public static short _node_getNodeType(Dom r2) {
        return (short) ((Dom) ZeusTransformUtils.wrapperContextForParams(r2, Dom.class, "com.obric.memorydata.plugin")).nodeType();
    }

    public static String _node_getNodeValue(Dom r2) {
        return (String) ZeusTransformUtils.preCheckCast(syncWrapNoEnter((Dom) ZeusTransformUtils.wrapperContextForParams(r2, Dom.class, "com.obric.memorydata.plugin"), $$Lambda$Mzy3iKr_LZ_xibwLkOXzxhx82M.INSTANCE), String.class, "com.obric.memorydata.plugin");
    }

    public static Document _node_getOwnerDocument(Dom r2) {
        return (Document) ZeusTransformUtils.preCheckCast(syncWrap((Dom) ZeusTransformUtils.wrapperContextForParams(r2, Dom.class, "com.obric.memorydata.plugin"), $$Lambda$KHIPs8vju9aq2hliYOephoGYpY.INSTANCE), Document.class, "com.obric.memorydata.plugin");
    }

    public static Node _node_getParentNode(Dom r2) {
        return (Node) ZeusTransformUtils.preCheckCast(syncWrap((Dom) ZeusTransformUtils.wrapperContextForParams(r2, Dom.class, "com.obric.memorydata.plugin"), $$Lambda$BuMhD4qzj_RWZ39ZPUedg5v564.INSTANCE), Node.class, "com.obric.memorydata.plugin");
    }

    public static String _node_getPrefix(Dom r2) {
        Dom r3 = (Dom) ZeusTransformUtils.wrapperContextForParams(r2, Dom.class, "com.obric.memorydata.plugin");
        if (r3.nodeCanHavePrefixUri() == true) goto L6;
        return null;
    L6:
        QName r4 = r3.getQName();
        if (r4 != null) goto L10;
        return "";
    L10:
        return r4.getPrefix();
    }

    public static Node _node_getPreviousSibling(Dom r2) {
        return (Node) ZeusTransformUtils.preCheckCast(syncWrapNoEnter((Dom) ZeusTransformUtils.wrapperContextForParams(r2, Dom.class, "com.obric.memorydata.plugin"), $$Lambda$RF7K0ZkZr_Ac0L_ScSrat06aGQg.INSTANCE), Node.class, "com.obric.memorydata.plugin");
    }

    public static String _node_getTextContent(Dom r2) {
        Dom r3 = (Dom) ZeusTransformUtils.wrapperContextForParams(r2, Dom.class, "com.obric.memorydata.plugin");
        throw new DomLevel3NotImplemented();
    }

    public static Object _node_getUserData(Dom r1, String r2) {
        Dom r3 = (Dom) ZeusTransformUtils.wrapperContextForParams(r1, Dom.class, "com.obric.memorydata.plugin");
        throw new DomLevel3NotImplemented();
    }

    public static boolean _node_hasAttributes(Dom r2) {
        return ((Boolean) ZeusTransformUtils.preCheckCast(syncWrap((Dom) ZeusTransformUtils.wrapperContextForParams(r2, Dom.class, "com.obric.memorydata.plugin"), $$Lambda$YBfn3obk3K4zY090QaHvdNYwTUU.INSTANCE), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    }

    public static boolean _node_hasChildNodes(Dom r2) {
        Dom r3 = (Dom) ZeusTransformUtils.wrapperContextForParams(r2, Dom.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, Xobj.class) == true) goto L5;
    L7:
        return false;
    L5:
        if (_node_getFirstChild(r3) == null) goto L7;
        return true;
    }

    public static Node _node_insertBefore(Dom r3, Node r4, Node r5) {
        Dom r6 = (Dom) ZeusTransformUtils.wrapperContextForParams(r3, Dom.class, "com.obric.memorydata.plugin");
        Node r7 = (Node) ZeusTransformUtils.wrapperContextForParams(r4, Node.class, "com.obric.memorydata.plugin");
        Node r8 = (Node) ZeusTransformUtils.wrapperContextForParams(r5, Node.class, "com.obric.memorydata.plugin");
        Locale r0 = r6.locale();
        if (r7 == null) goto L22;
        if (ZeusTransformUtils.instanceOf(r7, Dom.class) == false) goto L20;
        final Dom r9 = (Dom) ZeusTransformUtils.preCheckCast(r7, Dom.class, "com.obric.memorydata.plugin");
        if (r9.locale() != r0) goto L20;
        final Dom r2 = null;
        if (r8 == null) goto L18;
        if (ZeusTransformUtils.instanceOf(r8, Dom.class) == false) goto L16;
        r2 = (Dom) ZeusTransformUtils.preCheckCast(r8, Dom.class, "com.obric.memorydata.plugin");
        if (r2.locale() == r0) goto L18;
    L16:
        throw new WrongDocumentErr("Reference child is from another document");
    L18:
        return (Node) ZeusTransformUtils.preCheckCast(syncWrap(r6, new $$Lambda$DomImpl$MpiKLTiIvOnF7wRacewxuNOkmOM(r9, r2)), Node.class, "com.obric.memorydata.plugin");
    L20:
        throw new WrongDocumentErr("Child to add is from another document");
    L22:
        throw new IllegalArgumentException("Child to add is null");
    }

    public static boolean _node_isDefaultNamespace(Dom r1, String r2) {
        Dom r3 = (Dom) ZeusTransformUtils.wrapperContextForParams(r1, Dom.class, "com.obric.memorydata.plugin");
        throw new DomLevel3NotImplemented();
    }

    public static boolean _node_isEqualNode(Dom r2, Node r3) {
        Dom r4 = (Dom) ZeusTransformUtils.wrapperContextForParams(r2, Dom.class, "com.obric.memorydata.plugin");
        Node r5 = (Node) ZeusTransformUtils.wrapperContextForParams(r3, Node.class, "com.obric.memorydata.plugin");
        throw new DomLevel3NotImplemented();
    }

    public static boolean _node_isSameNode(Dom r2, Node r3) {
        Dom r4 = (Dom) ZeusTransformUtils.wrapperContextForParams(r2, Dom.class, "com.obric.memorydata.plugin");
        Node r5 = (Node) ZeusTransformUtils.wrapperContextForParams(r3, Node.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, CharNode.class) == false) goto L6;
    L8:
        return r4.equals(r5);
    L6:
        if (ZeusTransformUtils.instanceOf(r4, NodeXobj.class) == false) goto L10;
        r4 = ((NodeXobj) ZeusTransformUtils.preCheckCast(r4, NodeXobj.class, "com.obric.memorydata.plugin")).getDom();
        goto L8
    L10:
        throw new DomLevel3NotImplemented();
    }

    public static boolean _node_isSupported(Dom r2, String r3, String r4) {
        return _domImplementation_hasFeature(((Dom) ZeusTransformUtils.wrapperContextForParams(r2, Dom.class, "com.obric.memorydata.plugin")).locale(), r3, r4);
    }

    public static String _node_lookupNamespaceURI(Dom r1, String r2) {
        Dom r3 = (Dom) ZeusTransformUtils.wrapperContextForParams(r1, Dom.class, "com.obric.memorydata.plugin");
        throw new DomLevel3NotImplemented();
    }

    public static String _node_lookupPrefix(Dom r1, String r2) {
        Dom r3 = (Dom) ZeusTransformUtils.wrapperContextForParams(r1, Dom.class, "com.obric.memorydata.plugin");
        throw new DomLevel3NotImplemented();
    }

    public static void _node_normalize(Dom r2) {
        syncWrapVoid((Dom) ZeusTransformUtils.wrapperContextForParams(r2, Dom.class, "com.obric.memorydata.plugin"), $$Lambda$mlDSON61VV5G0tsiNxumvh3mk.INSTANCE);
    }

    public static Node _node_removeChild(Dom r3, Node r4) {
        Dom r5 = (Dom) ZeusTransformUtils.wrapperContextForParams(r3, Dom.class, "com.obric.memorydata.plugin");
        Node r6 = (Node) ZeusTransformUtils.wrapperContextForParams(r4, Node.class, "com.obric.memorydata.plugin");
        Locale r0 = r5.locale();
        if (r6 == null) goto L13;
        if (ZeusTransformUtils.instanceOf(r6, Dom.class) == false) goto L11;
        final Dom r7 = (Dom) ZeusTransformUtils.preCheckCast(r6, Dom.class, "com.obric.memorydata.plugin");
        if (r7.locale() != r0) goto L11;
        return (Node) ZeusTransformUtils.preCheckCast(syncWrap(r5, new $$Lambda$DomImpl$SCNYPRObiAuo2AHoWASwD2JEY0(r7)), Node.class, "com.obric.memorydata.plugin");
    L11:
        throw new WrongDocumentErr("Child to remove is from another document");
    L13:
        throw new NotFoundErr("Child to remove is null");
    }

    public static Node _node_replaceChild(Dom r3, Node r4, Node r5) {
        Dom r6 = (Dom) ZeusTransformUtils.wrapperContextForParams(r3, Dom.class, "com.obric.memorydata.plugin");
        Node r7 = (Node) ZeusTransformUtils.wrapperContextForParams(r4, Node.class, "com.obric.memorydata.plugin");
        Node r8 = (Node) ZeusTransformUtils.wrapperContextForParams(r5, Node.class, "com.obric.memorydata.plugin");
        Locale r0 = r6.locale();
        if (r7 == null) goto L22;
        if (r8 == null) goto L20;
        if (ZeusTransformUtils.instanceOf(r7, Dom.class) == false) goto L18;
        final Dom r9 = (Dom) ZeusTransformUtils.preCheckCast(r7, Dom.class, "com.obric.memorydata.plugin");
        if (r9.locale() != r0) goto L18;
        if (ZeusTransformUtils.instanceOf(r8, Dom.class) == false) goto L16;
        final Dom r10 = (Dom) ZeusTransformUtils.preCheckCast(r8, Dom.class, "com.obric.memorydata.plugin");
        if (r10.locale() != r0) goto L16;
        return (Node) ZeusTransformUtils.preCheckCast(syncWrap(r6, new $$Lambda$DomImpl$HWBgwS6enJwkTh0ut7evadn0cRk(r9, r10)), Node.class, "com.obric.memorydata.plugin");
    L16:
        throw new WrongDocumentErr("Child to replace is from another document");
    L18:
        throw new WrongDocumentErr("Child to add is from another document");
    L20:
        throw new NotFoundErr("Child to replace is null");
    L22:
        throw new IllegalArgumentException("Child to add is null");
    }

    public static void _node_setNodeValue(Dom r2, final String r3) {
        syncWrapVoid((Dom) ZeusTransformUtils.wrapperContextForParams(r2, Dom.class, "com.obric.memorydata.plugin"), new $$Lambda$DomImpl$v4FFdzlEAU_nS_ZUKzRb76wI8U(r3));
    }

    public static void _node_setPrefix(Dom r2, final String r3) {
        syncWrapVoid((Dom) ZeusTransformUtils.wrapperContextForParams(r2, Dom.class, "com.obric.memorydata.plugin"), new $$Lambda$DomImpl$puREY7AdCMk8FGDAUFWVMVSIHw(r3));
    }

    public static void _node_setTextContent(Dom r1, String r2) {
        Dom r3 = (Dom) ZeusTransformUtils.wrapperContextForParams(r1, Dom.class, "com.obric.memorydata.plugin");
        throw new DomLevel3NotImplemented();
    }

    public static Object _node_setUserData(Dom r0, String r1, Object r2, UserDataHandler r3) {
        Dom r4 = (Dom) ZeusTransformUtils.wrapperContextForParams(r0, Dom.class, "com.obric.memorydata.plugin");
        UserDataHandler r5 = (UserDataHandler) ZeusTransformUtils.wrapperContextForParams(r3, UserDataHandler.class, "com.obric.memorydata.plugin");
        throw new DomLevel3NotImplemented();
    }

    public static String _processingInstruction_getData(Dom r2) {
        return _node_getNodeValue((Dom) ZeusTransformUtils.wrapperContextForParams(r2, Dom.class, "com.obric.memorydata.plugin"));
    }

    public static String _processingInstruction_getTarget(Dom r2) {
        return _node_getNodeName((Dom) ZeusTransformUtils.wrapperContextForParams(r2, Dom.class, "com.obric.memorydata.plugin"));
    }

    public static void _processingInstruction_setData(Dom r2, String r3) {
        _node_setNodeValue((Dom) ZeusTransformUtils.wrapperContextForParams(r2, Dom.class, "com.obric.memorydata.plugin"), r3);
    }

    public static String _text_getWholeText(Dom r2) {
        Dom r3 = (Dom) ZeusTransformUtils.wrapperContextForParams(r2, Dom.class, "com.obric.memorydata.plugin");
        throw new DomLevel3NotImplemented();
    }

    public static boolean _text_isElementContentWhitespace(Dom r2) {
        Dom r3 = (Dom) ZeusTransformUtils.wrapperContextForParams(r2, Dom.class, "com.obric.memorydata.plugin");
        throw new DomLevel3NotImplemented();
    }

    public static Text _text_replaceWholeText(Dom r1, String r2) {
        Dom r3 = (Dom) ZeusTransformUtils.wrapperContextForParams(r1, Dom.class, "com.obric.memorydata.plugin");
        throw new DomLevel3NotImplemented();
    }

    public static Text _text_splitText(Dom r4, int r5) {
        Dom r6 = (Dom) ZeusTransformUtils.wrapperContextForParams(r4, Dom.class, "com.obric.memorydata.plugin");
        String r0 = _characterData_getData(r6);
        if (r5 < 0) goto L12;
        if (r5 > r0.length()) goto L12;
        _characterData_deleteData(r6, r5, r0.length() - r5);
        Dom r7 = (Dom) ZeusTransformUtils.preCheckCast(_document_createTextNode(r6, r0.substring(r5)), Dom.class, "com.obric.memorydata.plugin");
        Dom r1 = (Dom) ZeusTransformUtils.preCheckCast(_node_getParentNode(r6), Dom.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L10;
        _node_insertBefore(r1, (Text) ZeusTransformUtils.preCheckCast(r7, Text.class, "com.obric.memorydata.plugin"), _node_getNextSibling(r6));
        r6.locale().invalidateDomCaches(r1);
    L10:
        return (Text) ZeusTransformUtils.preCheckCast(r7, Text.class, "com.obric.memorydata.plugin");
    L12:
        throw new IndexSizeError();
    }

    static /* synthetic */ Object access$100(Locale r2, boolean r3, Supplier r4) {
        return syncWrapHelper(r2, r3, (Supplier) ZeusTransformUtils.wrapperContextForParams(r4, Supplier.class, "com.obric.memorydata.plugin"));
    }

    private static List<Node> ancestorAndSelf(Node r2) {
        Node r3 = (Node) ZeusTransformUtils.wrapperContextForParams(r2, Node.class, "com.obric.memorydata.plugin");
        LinkedList r0 = new LinkedList();
    L3:
        r0.addFirst(r3);
        r3 = r3.getParentNode();
        if (r3 != null) goto L3;
        return r0;
    }

    public static Node append(Dom r2, Dom r3) {
        Dom r4 = (Dom) ZeusTransformUtils.wrapperContextForParams(r2, Dom.class, "com.obric.memorydata.plugin");
        return node_insertBefore((Dom) ZeusTransformUtils.wrapperContextForParams(r3, Dom.class, "com.obric.memorydata.plugin"), r4, null);
    }

    public static Element attr_getOwnerElement(Dom r2) {
        Cur r3 = ((Dom) ZeusTransformUtils.wrapperContextForParams(r2, Dom.class, "com.obric.memorydata.plugin")).tempCur();
        if (r3.toParentRaw() == true) goto L6;
        r3.release();
        return null;
    L6:
        Dom r0 = r3.getDom();
        r3.release();
        return (Element) ZeusTransformUtils.preCheckCast(r0, Element.class, "com.obric.memorydata.plugin");
    }

    public static int attributes_getLength(Dom r2) {
        Cur r3 = ((Dom) ZeusTransformUtils.wrapperContextForParams(r2, Dom.class, "com.obric.memorydata.plugin")).tempCur();
        int r0 = 0;
    L4:
        if (r3.toNextAttr() == false) goto L6;
        r0 = r0 + 1;
        goto L4
    L6:
        r3.release();
        return r0;
    }

    public static Node attributes_getNamedItem(Dom r3, String r4) {
        Cur r5 = ((Dom) ZeusTransformUtils.wrapperContextForParams(r3, Dom.class, "com.obric.memorydata.plugin")).tempCur();
    L4:
        if (r5.toNextAttr() == false) goto L8;
        Dom r0 = r5.getDom();
        if (_node_getNodeName(r0).equals(r4) == false) goto L4;
    L9:
        r5.release();
        return (Node) ZeusTransformUtils.preCheckCast(r0, Node.class, "com.obric.memorydata.plugin");
    L8:
        r0 = null;
        goto L9
    }

    public static Node attributes_getNamedItemNS(Dom r5, String r6, String r7) {
        Dom r8 = (Dom) ZeusTransformUtils.wrapperContextForParams(r5, Dom.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L5;
        r6 = "";
    L5:
        Dom r0 = null;
        Cur r9 = r8.tempCur();
    L7:
        if (r9.toNextAttr() == false) goto L13;
        Dom r2 = r9.getDom();
        QName r3 = r2.getQName();
        if (r3.getNamespaceURI().equals(r6) == false) goto L7;
        if (r3.getLocalPart().equals(r7) == false) goto L7;
        r0 = r2;
    L13:
        r9.release();
        return (Node) ZeusTransformUtils.preCheckCast(r0, Node.class, "com.obric.memorydata.plugin");
    }

    public static Node attributes_item(Dom r3, int r4) {
        Dom r5 = (Dom) ZeusTransformUtils.wrapperContextForParams(r3, Dom.class, "com.obric.memorydata.plugin");
        Dom r0 = null;
        if (r4 >= 0) goto L5;
        return null;
    L5:
        Cur r6 = r5.tempCur();
    L7:
        if (r6.toNextAttr() == false) goto L12;
        int r2 = r4 - 1;
        if (r4 == 0) goto L10;
        r4 = r2;
        goto L7
    L10:
        r0 = r6.getDom();
    L12:
        r6.release();
        return (Node) ZeusTransformUtils.preCheckCast(r0, Node.class, "com.obric.memorydata.plugin");
    }

    public static Node attributes_removeNamedItem(Dom r6, String r7) {
        Cur r8 = ((Dom) ZeusTransformUtils.wrapperContextForParams(r6, Dom.class, "com.obric.memorydata.plugin")).tempCur();
        Dom r0 = null;
    L4:
        if (r8.toNextAttr() == false) goto L15;
        Dom r2 = r8.getDom();
        if (_node_getNodeName(r2).equals(r7) == false) goto L4;
        if (r0 != null) goto L10;
        r0 = r2;
    L10:
        if (((AttrXobj) ZeusTransformUtils.preCheckCast(r2, AttrXobj.class, "com.obric.memorydata.plugin")).isId() == false) goto L14;
        Document r3 = node_getOwnerDocument(r2);
        String r4 = node_getNodeValue(r2);
        if (ZeusTransformUtils.instanceOf(r3, DocumentXobj.class) == false) goto L14;
        ((DocumentXobj) ZeusTransformUtils.preCheckCast(r3, DocumentXobj.class, "com.obric.memorydata.plugin")).removeIdElement(r4);
    L14:
        removeNode(r2);
        r8.toPrevAttr();
        goto L4
    L15:
        r8.release();
        if (r0 == null) goto L20;
        return (Node) ZeusTransformUtils.preCheckCast(r0, Node.class, "com.obric.memorydata.plugin");
    L20:
        throw new NotFoundErr("Named item not found: " + r7);
    }

    public static Node attributes_removeNamedItemNS(Dom r6, String r7, String r8) {
        Dom r9 = (Dom) ZeusTransformUtils.wrapperContextForParams(r6, Dom.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L5;
        r7 = "";
    L5:
        Dom r0 = null;
        Cur r10 = r9.tempCur();
    L7:
        if (r10.toNextAttr() == false) goto L20;
        Dom r2 = r10.getDom();
        QName r3 = r2.getQName();
        if (r3.getNamespaceURI().equals(r7) == false) goto L7;
        if (r3.getLocalPart().equals(r8) == false) goto L7;
        if (r0 != null) goto L15;
        r0 = r2;
    L15:
        if (((AttrXobj) ZeusTransformUtils.preCheckCast(r2, AttrXobj.class, "com.obric.memorydata.plugin")).isId() == false) goto L19;
        Document r4 = node_getOwnerDocument(r2);
        String r5 = node_getNodeValue(r2);
        if (ZeusTransformUtils.instanceOf(r4, DocumentXobj.class) == false) goto L19;
        ((DocumentXobj) ZeusTransformUtils.preCheckCast(r4, DocumentXobj.class, "com.obric.memorydata.plugin")).removeIdElement(r5);
    L19:
        removeNode(r2);
        r10.toPrevAttr();
        goto L7
    L20:
        r10.release();
        if (r0 == null) goto L25;
        return (Node) ZeusTransformUtils.preCheckCast(r0, Node.class, "com.obric.memorydata.plugin");
    L25:
        throw new NotFoundErr("Named item not found: uri=" + r7 + ", local=" + r8);
    }

    public static Node attributes_setNamedItem(Dom r6, Dom r7) {
        Dom r8 = (Dom) ZeusTransformUtils.wrapperContextForParams(r6, Dom.class, "com.obric.memorydata.plugin");
        Dom r9 = (Dom) ZeusTransformUtils.wrapperContextForParams(r7, Dom.class, "com.obric.memorydata.plugin");
        if (attr_getOwnerElement(r9) != null) goto L22;
        if (r9.nodeType() != 2) goto L20;
        String r0 = _node_getNodeName(r9);
        Dom r2 = null;
        Cur r3 = r8.tempCur();
    L8:
        if (r3.toNextAttr() == false) goto L14;
        Dom r4 = r3.getDom();
        if (_node_getNodeName(r4).equals(r0) == false) goto L8;
        if (r2 == null) goto L12;
        removeNode(r4);
        r3.toPrevAttr();
        goto L8
    L12:
        r2 = r4;
        goto L8
    L14:
        if (r2 != null) goto L16;
        r3.moveToDom(r8);
        r3.next();
        Cur.moveNode((Xobj) ZeusTransformUtils.preCheckCast(r9, Xobj.class, "com.obric.memorydata.plugin"), r3);
    L17:
        r3.release();
        return (Node) ZeusTransformUtils.preCheckCast(r2, Node.class, "com.obric.memorydata.plugin");
    L16:
        r3.moveToDom(r2);
        Cur.moveNode((Xobj) ZeusTransformUtils.preCheckCast(r9, Xobj.class, "com.obric.memorydata.plugin"), r3);
        removeNode(r2);
        goto L17
    L20:
        throw new HierarchyRequestErr("Node is not an attribute");
    L22:
        throw new InuseAttributeError();
    }

    public static Node attributes_setNamedItemNS(Dom r6, Dom r7) {
        Dom r8 = (Dom) ZeusTransformUtils.wrapperContextForParams(r6, Dom.class, "com.obric.memorydata.plugin");
        Dom r9 = (Dom) ZeusTransformUtils.wrapperContextForParams(r7, Dom.class, "com.obric.memorydata.plugin");
        Element r0 = attr_getOwnerElement(r9);
        if (r0 != r8) goto L7;
        Object r10 = ZeusTransformUtils.preCheckCast(r9, Node.class, "com.obric.memorydata.plugin");
    L6:
        return (Node) r10;
    L7:
        if (r0 != null) goto L25;
        if (r9.nodeType() != 2) goto L23;
        QName r1 = r9.getQName();
        Dom r2 = null;
        Cur r3 = r8.tempCur();
    L12:
        if (r3.toNextAttr() == false) goto L18;
        Dom r4 = r3.getDom();
        if (r4.getQName().equals(r1) == false) goto L12;
        if (r2 == null) goto L16;
        removeNode(r4);
        r3.toPrevAttr();
        goto L12
    L16:
        r2 = r4;
        goto L12
    L18:
        if (r2 != null) goto L20;
        r3.moveToDom(r8);
        r3.next();
        Cur.moveNode((Xobj) ZeusTransformUtils.preCheckCast(r9, Xobj.class, "com.obric.memorydata.plugin"), r3);
    L21:
        r3.release();
        r10 = ZeusTransformUtils.preCheckCast(r2, Node.class, "com.obric.memorydata.plugin");
        goto L6
    L20:
        r3.moveToDom(r2);
        Cur.moveNode((Xobj) ZeusTransformUtils.preCheckCast(r9, Xobj.class, "com.obric.memorydata.plugin"), r3);
        removeNode(r2);
        goto L21
    L23:
        throw new HierarchyRequestErr("Node is not an attribute");
    L25:
        throw new InuseAttributeError();
    }

    public static int childNodes_getLength(Dom r3) {
        Dom r4 = (Dom) ZeusTransformUtils.wrapperContextForParams(r3, Dom.class, "com.obric.memorydata.plugin");
        switch(r4.nodeType()) {
            case 3: goto L9;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L6;
            case 7: goto L9;
            case 8: goto L9;
            case 9: goto L11;
            case 10: goto L6;
            case 11: goto L11;
            case 12: goto L6;
            default: goto L11;
        };
    L9:
        return 0;
    L11:
        Xobj r0 = (Xobj) ZeusTransformUtils.preCheckCast(r4, Xobj.class, "com.obric.memorydata.plugin");
        r0.ensureOccupancy();
        int r1 = r0.getDomZeroOneChildren();
        if (r1 >= 2) goto L15;
        return r1;
    L15:
        return r4.locale().domLength(r4);
    L6:
        throw new RuntimeException("Not impl");
    L8:
        throw new RuntimeException("Not impl");
    }

    public static Node childNodes_item(Dom r4, int r5) {
        Dom r6 = (Dom) ZeusTransformUtils.wrapperContextForParams(r4, Dom.class, "com.obric.memorydata.plugin");
        if (r5 >= 0) goto L6;
        return null;
    L6:
        switch(r6.nodeType()) {
            case 3: goto L14;
            case 4: goto L14;
            case 5: goto L13;
            case 6: goto L11;
            case 7: goto L14;
            case 8: goto L14;
            case 9: goto L7;
            case 10: goto L11;
            case 11: goto L7;
            case 12: goto L11;
            default: goto L7;
        };
    L7:
        if (r5 != 0) goto L16;
        return node_getFirstChild(r6);
    L16:
        return (Node) ZeusTransformUtils.preCheckCast(r6.locale().findDomNthChild(r6, r5), Node.class, "com.obric.memorydata.plugin");
    L14:
        return null;
    L11:
        throw new RuntimeException("Not impl");
    L13:
        throw new RuntimeException("Not impl");
    }

    public static Attr document_createAttribute(Dom r3, String r4) {
        Dom r5 = (Dom) ZeusTransformUtils.wrapperContextForParams(r3, Dom.class, "com.obric.memorydata.plugin");
        validateName(r4);
        Locale r6 = r5.locale();
        Cur r0 = r6.tempCur();
        r0.createAttr(r6.makeQualifiedQName("", r4));
        AttrXobj r7 = (AttrXobj) ZeusTransformUtils.preCheckCast(r0.getDom(), AttrXobj.class, "com.obric.memorydata.plugin");
        r0.release();
        r7._canHavePrefixUri = false;
        return r7;
    }

    public static Attr document_createAttributeNS(Dom r2, String r3, String r4) {
        Dom r5 = (Dom) ZeusTransformUtils.wrapperContextForParams(r2, Dom.class, "com.obric.memorydata.plugin");
        validateQualifiedName(r4, r3, true);
        Locale r6 = r5.locale();
        Cur r0 = r6.tempCur();
        r0.createAttr(r6.makeQualifiedQName(r3, r4));
        Dom r7 = r0.getDom();
        r0.release();
        return (Attr) ZeusTransformUtils.preCheckCast(r7, Attr.class, "com.obric.memorydata.plugin");
    }

    public static CDATASection document_createCDATASection(Dom r3, String r4) {
        CdataNode r5 = ((Dom) ZeusTransformUtils.wrapperContextForParams(r3, Dom.class, "com.obric.memorydata.plugin")).locale().createCdataNode();
        if (r4 != null) goto L5;
        r4 = "";
    L5:
        r5.setChars(r4, 0, r4.length());
        return (CDATASection) ZeusTransformUtils.preCheckCast(r5, CDATASection.class, "com.obric.memorydata.plugin");
    }

    public static Comment document_createComment(Dom r2, String r3) {
        Cur r4 = ((Dom) ZeusTransformUtils.wrapperContextForParams(r2, Dom.class, "com.obric.memorydata.plugin")).locale().tempCur();
        r4.createComment();
        Dom r0 = r4.getDom();
        if (r3 == null) goto L5;
        r4.next();
        r4.insertString(r3);
    L5:
        r4.release();
        return (Comment) ZeusTransformUtils.preCheckCast(r0, Comment.class, "com.obric.memorydata.plugin");
    }

    public static DocumentFragment document_createDocumentFragment(Dom r2) {
        Cur r3 = ((Dom) ZeusTransformUtils.wrapperContextForParams(r2, Dom.class, "com.obric.memorydata.plugin")).locale().tempCur();
        r3.createDomDocFragRoot();
        Dom r0 = r3.getDom();
        r3.release();
        return (DocumentFragment) ZeusTransformUtils.preCheckCast(r0, DocumentFragment.class, "com.obric.memorydata.plugin");
    }

    public static Element document_createElement(Dom r3, String r4) {
        Dom r5 = (Dom) ZeusTransformUtils.wrapperContextForParams(r3, Dom.class, "com.obric.memorydata.plugin");
        validateName(r4);
        Locale r6 = r5.locale();
        Cur r0 = r6.tempCur();
        r0.createElement(r6.makeQualifiedQName("", r4));
        ElementXobj r7 = (ElementXobj) ZeusTransformUtils.preCheckCast(r0.getDom(), ElementXobj.class, "com.obric.memorydata.plugin");
        r0.release();
        r7._canHavePrefixUri = false;
        return r7;
    }

    public static Element document_createElementNS(Dom r2, String r3, String r4) {
        Dom r5 = (Dom) ZeusTransformUtils.wrapperContextForParams(r2, Dom.class, "com.obric.memorydata.plugin");
        validateQualifiedName(r4, r3, false);
        Locale r6 = r5.locale();
        Cur r0 = r6.tempCur();
        r0.createElement(r6.makeQualifiedQName(r3, r4));
        Dom r7 = r0.getDom();
        r0.release();
        return (Element) ZeusTransformUtils.preCheckCast(r7, Element.class, "com.obric.memorydata.plugin");
    }

    public static ProcessingInstruction document_createProcessingInstruction(Dom r3, String r4, String r5) {
        Dom r6 = (Dom) ZeusTransformUtils.wrapperContextForParams(r3, Dom.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L25;
        if (r4.length() == 0) goto L23;
        if (XMLChar.isValidName(r4) == false) goto L21;
        if (Locale.beginsWithXml(r4) == true) goto L11;
    L15:
        Cur r7 = r6.locale().tempCur();
        r7.createProcinst(r4);
        Dom r8 = r7.getDom();
        if (r5 == null) goto L18;
        r7.next();
        r7.insertString(r5);
    L18:
        r7.release();
        return (ProcessingInstruction) ZeusTransformUtils.preCheckCast(r8, ProcessingInstruction.class, "com.obric.memorydata.plugin");
    L11:
        if (r4.length() != 3) goto L15;
        throw new InvalidCharacterError("Invalid target - is 'xml'");
    L21:
        throw new InvalidCharacterError("Target has an invalid character");
    L23:
        throw new IllegalArgumentException("Target is empty");
    L25:
        throw new IllegalArgumentException("Target is null");
    }

    public static Text document_createTextNode(Dom r2, String r3) {
        TextNode r4 = ((Dom) ZeusTransformUtils.wrapperContextForParams(r2, Dom.class, "com.obric.memorydata.plugin")).locale().createTextNode();
        if (r3 != null) goto L5;
        r3 = "";
    L5:
        r4.setChars(r3, 0, r3.length());
        return r4;
    }

    public static DocumentType document_getDoctype(Dom r2) {
        Dom r3 = (Dom) ZeusTransformUtils.wrapperContextForParams(r2, Dom.class, "com.obric.memorydata.plugin");
        return null;
    }

    public static Element document_getDocumentElement(Dom r3) {
        Node r4 = firstChild((Dom) ZeusTransformUtils.wrapperContextForParams(r3, Dom.class, "com.obric.memorydata.plugin"));
    L3:
        if (r4 == null) goto L9;
        if (((Dom) ZeusTransformUtils.preCheckCast(r4, Dom.class, "com.obric.memorydata.plugin")).nodeType() == 1) goto L7;
        r4 = nextSibling((Dom) ZeusTransformUtils.preCheckCast(r4, Dom.class, "com.obric.memorydata.plugin"));
        goto L3
    L7:
        return (Element) ZeusTransformUtils.preCheckCast(r4, Element.class, "com.obric.memorydata.plugin");
    L9:
        return null;
    }

    public static NodeList document_getElementsByTagName(Dom r2, String r3) {
        return new ElementsByTagNameNodeList((Dom) ZeusTransformUtils.wrapperContextForParams(r2, Dom.class, "com.obric.memorydata.plugin"), r3);
    }

    public static NodeList document_getElementsByTagNameNS(Dom r2, String r3, String r4) {
        return new ElementsByTagNameNSNodeList((Dom) ZeusTransformUtils.wrapperContextForParams(r2, Dom.class, "com.obric.memorydata.plugin"), r3, r4);
    }

    public static Node document_importNode(Dom r10, Node r11, boolean r12) {
        Dom r13 = (Dom) ZeusTransformUtils.wrapperContextForParams(r10, Dom.class, "com.obric.memorydata.plugin");
        Node r14 = (Node) ZeusTransformUtils.wrapperContextForParams(r11, Node.class, "com.obric.memorydata.plugin");
        if (r14 != null) goto L5;
        return null;
    L5:
        int r4 = 0;
        switch(r14.getNodeType()) {
            case 1: goto L41;
            case 2: goto L21;
            case 3: goto L19;
            case 4: goto L18;
            case 5: goto L17;
            case 6: goto L17;
            case 7: goto L15;
            case 8: goto L14;
            case 9: goto L13;
            case 10: goto L11;
            case 11: goto L9;
            case 12: goto L17;
            default: goto L8;
        };
    L9:
        Node r2 = document_createDocumentFragment(r13);
    L64:
        if (r12 == false) goto L69;
        NodeList r15 = r14.getChildNodes();
    L67:
        if (r4 >= r15.getLength()) goto L69;
        node_insertBefore((Dom) ZeusTransformUtils.preCheckCast(r2, Dom.class, "com.obric.memorydata.plugin"), (Dom) ZeusTransformUtils.preCheckCast(document_importNode(r13, r15.item(r4), true), Dom.class, "com.obric.memorydata.plugin"), null);
        r4 = r4 + 1;
    L69:
        return r2;
    L14:
        r2 = document_createComment(r13, r14.getNodeValue());
    L20:
        r12 = false;
        goto L64
    L15:
        r2 = document_createProcessingInstruction(r13, r14.getNodeName(), r14.getNodeValue());
        goto L20
    L18:
        r2 = document_createCDATASection(r13, r14.getNodeValue());
        goto L20
    L19:
        r2 = document_createTextNode(r13, r14.getNodeValue());
        goto L20
    L21:
        String r16 = r14.getLocalName();
        if (r16 != null) goto L24;
    L38:
        r16 = r14.getNodeName();
    L39:
        Attr r17 = document_createAttribute(r13, r16);
    L40:
        r2 = r17;
        r12 = true;
        goto L64
    L24:
        if (r16.length() == 0) goto L38;
        String r3 = r14.getPrefix();
        if (r3 != null) goto L29;
    L32:
        String r5 = r14.getNamespaceURI();
        if (r5 == null) goto L39;
        if (r5.length() == 0) goto L39;
        r17 = document_createAttributeNS(r13, r5, r16);
        goto L40
    L29:
        if (r3.length() == 0) goto L32;
        r16 = r3 + ParameterizedMessage.ERROR_MSG_SEPARATOR + r16;
        goto L32
    L41:
        String r6 = r14.getLocalName();
        if (r6 != null) goto L44;
    L58:
        r6 = r14.getNodeName();
    L59:
        r2 = document_createElement(r13, r6);
    L60:
        NamedNodeMap r7 = r14.getAttributes();
        int r8 = 0;
    L62:
        if (r8 >= r7.getLength()) goto L64;
        attributes_setNamedItem((Dom) ZeusTransformUtils.preCheckCast(r2, Dom.class, "com.obric.memorydata.plugin"), (Dom) ZeusTransformUtils.preCheckCast(document_importNode(r13, r7.item(r8), true), Dom.class, "com.obric.memorydata.plugin"));
        r8 = r8 + 1;
        goto L62
    L44:
        if (r6.length() == 0) goto L58;
        String r9 = r14.getPrefix();
        if (r9 != null) goto L49;
    L52:
        String r18 = r14.getNamespaceURI();
        if (r18 == null) goto L59;
        if (r18.length() == 0) goto L59;
        r2 = document_createElementNS(r13, r18, r6);
        goto L60
    L49:
        if (r9.length() == 0) goto L52;
        r6 = r9 + ParameterizedMessage.ERROR_MSG_SEPARATOR + r6;
        goto L52
    L8:
        throw new RuntimeException("Unknown kind");
    L11:
        throw new NotSupportedError("Document type nodes may not be imported");
    L13:
        throw new NotSupportedError("Document nodes may not be imported");
    L17:
        throw new RuntimeException("Not impl");
    }

    public static Document domImplementation_createDocument(Locale r4, String r5, String r6, DocumentType r7) {
        DocumentType r8 = (DocumentType) ZeusTransformUtils.wrapperContextForParams(r7, DocumentType.class, "com.obric.memorydata.plugin");
        validateQualifiedName(r6, r5, false);
        Cur r0 = r4.tempCur();
        r0.createDomDocumentRoot();
        Document r1 = (Document) ZeusTransformUtils.preCheckCast(r0.getDom(), Document.class, "com.obric.memorydata.plugin");
        r0.next();
        r0.createElement(r4.makeQualifiedQName(r5, r6));
        if (r8 != null) goto L12;
        r0.toParent();
        Locale.autoTypeDocument(r0, null, null);     // Catch: XmlException -> L8
        r0.release();
        return r1;
    L8:
        e = move-exception;
        throw new XmlRuntimeException(e);
    L12:
        throw new RuntimeException("Not impl");
    }

    public static NodeList element_getElementsByTagName(Dom r2, String r3) {
        return new ElementsByTagNameNodeList((Dom) ZeusTransformUtils.wrapperContextForParams(r2, Dom.class, "com.obric.memorydata.plugin"), r3);
    }

    public static NodeList element_getElementsByTagNameNS(Dom r2, String r3, String r4) {
        return new ElementsByTagNameNSNodeList((Dom) ZeusTransformUtils.wrapperContextForParams(r2, Dom.class, "com.obric.memorydata.plugin"), r3, r4);
    }

    public static void element_setAttribute(Dom r3, String r4, String r5) {
        Dom r6 = (Dom) ZeusTransformUtils.wrapperContextForParams(r3, Dom.class, "com.obric.memorydata.plugin");
        Object r0 = attributes_getNamedItem(r6, r4);
        if (r0 != null) goto L9;
        Dom r1 = (Dom) ZeusTransformUtils.preCheckCast(node_getOwnerDocument(r6), Dom.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L8;
        r0 = document_createAttribute(r1, r4);
        attributes_setNamedItem(r6, (Dom) ZeusTransformUtils.preCheckCast(r0, Dom.class, "com.obric.memorydata.plugin"));
        goto L9
    L8:
        throw new NotFoundErr("Document element can't be determined.");
    L9:
        node_setNodeValue((Dom) ZeusTransformUtils.preCheckCast(r0, Dom.class, "com.obric.memorydata.plugin"), r5);
    }

    public static void element_setAttributeNS(Dom r4, String r5, String r6, String r7) {
        Dom r8 = (Dom) ZeusTransformUtils.wrapperContextForParams(r4, Dom.class, "com.obric.memorydata.plugin");
        validateQualifiedName(r6, r5, true);
        QName r9 = r8.locale().makeQualifiedQName(r5, r6);
        String r2 = r9.getLocalPart();
        String r10 = validatePrefix(r9.getPrefix(), r5, r2, true);
        Object r0 = attributes_getNamedItemNS(r8, r5, r2);
        if (r0 != null) goto L5;
        r0 = document_createAttributeNS((Dom) ZeusTransformUtils.preCheckCast(node_getOwnerDocument(r8), Dom.class, "com.obric.memorydata.plugin"), r5, r2);
        attributes_setNamedItemNS(r8, (Dom) ZeusTransformUtils.preCheckCast(r0, Dom.class, "com.obric.memorydata.plugin"));
    L5:
        node_setPrefix((Dom) ZeusTransformUtils.preCheckCast(r0, Dom.class, "com.obric.memorydata.plugin"), r10);
        node_setNodeValue((Dom) ZeusTransformUtils.preCheckCast(r0, Dom.class, "com.obric.memorydata.plugin"), r7);
    }

    static Node firstChild(Dom r2) {
        return node_getFirstChild((Dom) ZeusTransformUtils.wrapperContextForParams(r2, Dom.class, "com.obric.memorydata.plugin"));
    }

    public static Node insert(Dom r3, Dom r4) {
        Dom r5 = (Dom) ZeusTransformUtils.wrapperContextForParams(r3, Dom.class, "com.obric.memorydata.plugin");
        Dom r6 = (Dom) ZeusTransformUtils.wrapperContextForParams(r4, Dom.class, "com.obric.memorydata.plugin");
        return node_insertBefore((Dom) ZeusTransformUtils.preCheckCast(parent(r6), Dom.class, "com.obric.memorydata.plugin"), r5, r6);
    }

    private static String isValidChild(Dom r7, Dom r8) {
        Dom r9 = (Dom) ZeusTransformUtils.wrapperContextForParams(r7, Dom.class, "com.obric.memorydata.plugin");
        Dom r10 = (Dom) ZeusTransformUtils.wrapperContextForParams(r8, Dom.class, "com.obric.memorydata.plugin");
        int r0 = r9.nodeType();
        int r11 = r10.nodeType();
        switch(r0) {
            case 1: goto L28;
            case 2: goto L25;
            case 3: goto L22;
            case 4: goto L22;
            case 5: goto L28;
            case 6: goto L28;
            case 7: goto L22;
            case 8: goto L22;
            case 9: goto L5;
            case 10: goto L22;
            case 11: goto L28;
            case 12: goto L22;
            default: goto L37;
        };
    L5:
        if (r11 == 1) goto L18;
        if (r11 == 10) goto L13;
        if (r11 == 7) goto L11;
        if (r11 != 8) goto L37;
    L11:
        return null;
    L13:
        if (document_getDoctype(r9) == null) goto L16;
        return "Documents may only have a maximum of one document type node";
    L16:
        return null;
    L18:
        if (document_getDocumentElement(r9) == null) goto L21;
        return "Documents may only have a maximum of one document element";
    L21:
        return null;
    L22:
        StringBuilder r12 = new StringBuilder().append(nodeKindName(r0));
        String r13 = " nodes may not have any children";
    L24:
        return r12.append(r13).toString();
    L25:
        if (r11 == 3) goto L27;
        if (r11 != 5) goto L37;
    L27:
        return null;
    L28:
        if (r11 == 1) goto L36;
        if (r11 == 3) goto L36;
        if (r11 == 4) goto L36;
        if (r11 == 5) goto L36;
        if (r11 == 7) goto L36;
        if (r11 != 8) goto L37;
    L36:
        return null;
    L37:
        r12 = new StringBuilder().append(nodeKindName(r0)).append(" nodes may not have ").append(nodeKindName(r11));
        r13 = " nodes as children";
        goto L24
    }

    static /* synthetic */ Node lambda$_attributes_getNamedItem$22(Dom r2, String r3, Dom r4) {
        Dom r5 = (Dom) ZeusTransformUtils.wrapperContextForParams(r2, Dom.class, "com.obric.memorydata.plugin");
        Dom r6 = (Dom) ZeusTransformUtils.wrapperContextForParams(r4, Dom.class, "com.obric.memorydata.plugin");
        return attributes_getNamedItem(r5, r3);
    }

    static /* synthetic */ Node lambda$_attributes_getNamedItemNS$23(String r2, String r3, Dom r4) {
        return attributes_getNamedItemNS((Dom) ZeusTransformUtils.wrapperContextForParams(r4, Dom.class, "com.obric.memorydata.plugin"), r2, r3);
    }

    static /* synthetic */ Node lambda$_attributes_item$27(int r2, Dom r3) {
        return attributes_item((Dom) ZeusTransformUtils.wrapperContextForParams(r3, Dom.class, "com.obric.memorydata.plugin"), r2);
    }

    static /* synthetic */ Node lambda$_attributes_removeNamedItem$24(String r2, Dom r3) {
        return attributes_removeNamedItem((Dom) ZeusTransformUtils.wrapperContextForParams(r3, Dom.class, "com.obric.memorydata.plugin"), r2);
    }

    static /* synthetic */ Node lambda$_attributes_removeNamedItemNS$25(String r2, String r3, Dom r4) {
        return attributes_removeNamedItemNS((Dom) ZeusTransformUtils.wrapperContextForParams(r4, Dom.class, "com.obric.memorydata.plugin"), r2, r3);
    }

    static /* synthetic */ Node lambda$_attributes_setNamedItem$21(Dom r2, Dom r3) {
        Dom r4 = (Dom) ZeusTransformUtils.wrapperContextForParams(r2, Dom.class, "com.obric.memorydata.plugin");
        return attributes_setNamedItem((Dom) ZeusTransformUtils.wrapperContextForParams(r3, Dom.class, "com.obric.memorydata.plugin"), r4);
    }

    static /* synthetic */ Node lambda$_attributes_setNamedItemNS$26(Dom r2, Dom r3) {
        Dom r4 = (Dom) ZeusTransformUtils.wrapperContextForParams(r2, Dom.class, "com.obric.memorydata.plugin");
        return attributes_setNamedItemNS((Dom) ZeusTransformUtils.wrapperContextForParams(r3, Dom.class, "com.obric.memorydata.plugin"), r4);
    }

    static /* synthetic */ Node lambda$_childNodes_item$16(int r2, Dom r3) {
        return childNodes_item((Dom) ZeusTransformUtils.wrapperContextForParams(r3, Dom.class, "com.obric.memorydata.plugin"), r2);
    }

    static /* synthetic */ Attr lambda$_document_createAttribute$3(String r2, Dom r3) {
        return document_createAttribute((Dom) ZeusTransformUtils.wrapperContextForParams(r3, Dom.class, "com.obric.memorydata.plugin"), r2);
    }

    static /* synthetic */ Attr lambda$_document_createAttributeNS$4(String r2, String r3, Dom r4) {
        return document_createAttributeNS((Dom) ZeusTransformUtils.wrapperContextForParams(r4, Dom.class, "com.obric.memorydata.plugin"), r2, r3);
    }

    static /* synthetic */ Comment lambda$_document_createComment$5(String r2, Dom r3) {
        return document_createComment((Dom) ZeusTransformUtils.wrapperContextForParams(r3, Dom.class, "com.obric.memorydata.plugin"), r2);
    }

    static /* synthetic */ Element lambda$_document_createElement$1(String r2, Dom r3) {
        return document_createElement((Dom) ZeusTransformUtils.wrapperContextForParams(r3, Dom.class, "com.obric.memorydata.plugin"), r2);
    }

    static /* synthetic */ Element lambda$_document_createElementNS$2(String r2, String r3, Dom r4) {
        return document_createElementNS((Dom) ZeusTransformUtils.wrapperContextForParams(r4, Dom.class, "com.obric.memorydata.plugin"), r2, r3);
    }

    static /* synthetic */ ProcessingInstruction lambda$_document_createProcessingInstruction$6(String r2, String r3, Dom r4) {
        return document_createProcessingInstruction((Dom) ZeusTransformUtils.wrapperContextForParams(r4, Dom.class, "com.obric.memorydata.plugin"), r2, r3);
    }

    static /* synthetic */ NodeList lambda$_document_getElementsByTagName$7(String r2, Dom r3) {
        return document_getElementsByTagName((Dom) ZeusTransformUtils.wrapperContextForParams(r3, Dom.class, "com.obric.memorydata.plugin"), r2);
    }

    static /* synthetic */ NodeList lambda$_document_getElementsByTagNameNS$8(String r2, String r3, Dom r4) {
        return document_getElementsByTagNameNS((Dom) ZeusTransformUtils.wrapperContextForParams(r4, Dom.class, "com.obric.memorydata.plugin"), r2, r3);
    }

    static /* synthetic */ Node lambda$_document_importNode$9(Node r2, boolean r3, Dom r4) {
        Node r5 = (Node) ZeusTransformUtils.wrapperContextForParams(r2, Node.class, "com.obric.memorydata.plugin");
        return document_importNode((Dom) ZeusTransformUtils.wrapperContextForParams(r4, Dom.class, "com.obric.memorydata.plugin"), r5, r3);
    }

    static /* synthetic */ Document lambda$_domImplementation_createDocument$0(Locale r2, String r3, String r4, DocumentType r5) {
        return domImplementation_createDocument(r2, r3, r4, (DocumentType) ZeusTransformUtils.wrapperContextForParams(r5, DocumentType.class, "com.obric.memorydata.plugin"));
    }

    static /* synthetic */ NodeList lambda$_element_getElementsByTagName$19(String r2, Dom r3) {
        return element_getElementsByTagName((Dom) ZeusTransformUtils.wrapperContextForParams(r3, Dom.class, "com.obric.memorydata.plugin"), r2);
    }

    static /* synthetic */ NodeList lambda$_element_getElementsByTagNameNS$20(String r2, String r3, Dom r4) {
        return element_getElementsByTagNameNS((Dom) ZeusTransformUtils.wrapperContextForParams(r4, Dom.class, "com.obric.memorydata.plugin"), r2, r3);
    }

    static /* synthetic */ void lambda$_element_setAttribute$17(String r2, String r3, Dom r4) {
        element_setAttribute((Dom) ZeusTransformUtils.wrapperContextForParams(r4, Dom.class, "com.obric.memorydata.plugin"), r2, r3);
    }

    static /* synthetic */ void lambda$_element_setAttributeNS$18(String r2, String r3, String r4, Dom r5) {
        element_setAttributeNS((Dom) ZeusTransformUtils.wrapperContextForParams(r5, Dom.class, "com.obric.memorydata.plugin"), r2, r3, r4);
    }

    static /* synthetic */ Node lambda$_node_cloneNode$13(boolean r2, Dom r3) {
        return node_cloneNode((Dom) ZeusTransformUtils.wrapperContextForParams(r3, Dom.class, "com.obric.memorydata.plugin"), r2);
    }

    static /* synthetic */ Node lambda$_node_insertBefore$11(Dom r2, Dom r3, Dom r4) {
        Dom r5 = (Dom) ZeusTransformUtils.wrapperContextForParams(r2, Dom.class, "com.obric.memorydata.plugin");
        Dom r6 = (Dom) ZeusTransformUtils.wrapperContextForParams(r3, Dom.class, "com.obric.memorydata.plugin");
        return node_insertBefore((Dom) ZeusTransformUtils.wrapperContextForParams(r4, Dom.class, "com.obric.memorydata.plugin"), r5, r6);
    }

    static /* synthetic */ Node lambda$_node_removeChild$12(Dom r2, Dom r3) {
        Dom r4 = (Dom) ZeusTransformUtils.wrapperContextForParams(r2, Dom.class, "com.obric.memorydata.plugin");
        return node_removeChild((Dom) ZeusTransformUtils.wrapperContextForParams(r3, Dom.class, "com.obric.memorydata.plugin"), r4);
    }

    static /* synthetic */ Node lambda$_node_replaceChild$10(Dom r2, Dom r3, Dom r4) {
        Dom r5 = (Dom) ZeusTransformUtils.wrapperContextForParams(r2, Dom.class, "com.obric.memorydata.plugin");
        Dom r6 = (Dom) ZeusTransformUtils.wrapperContextForParams(r3, Dom.class, "com.obric.memorydata.plugin");
        return node_replaceChild((Dom) ZeusTransformUtils.wrapperContextForParams(r4, Dom.class, "com.obric.memorydata.plugin"), r5, r6);
    }

    static /* synthetic */ void lambda$_node_setNodeValue$15(String r2, Dom r3) {
        node_setNodeValue((Dom) ZeusTransformUtils.wrapperContextForParams(r3, Dom.class, "com.obric.memorydata.plugin"), r2);
    }

    static /* synthetic */ void lambda$_node_setPrefix$14(String r2, Dom r3) {
        node_setPrefix((Dom) ZeusTransformUtils.wrapperContextForParams(r3, Dom.class, "com.obric.memorydata.plugin"), r2);
    }

    static /* synthetic */ Object lambda$syncWrap$107(Function r2, Dom r3) {
        return ((Function) ZeusTransformUtils.wrapperContextForParams(r2, Function.class, "com.obric.memorydata.plugin")).apply((Dom) ZeusTransformUtils.wrapperContextForParams(r3, Dom.class, "com.obric.memorydata.plugin"));
    }

    static /* synthetic */ Object lambda$syncWrapNoEnter$108(Function r2, Dom r3) {
        return ((Function) ZeusTransformUtils.wrapperContextForParams(r2, Function.class, "com.obric.memorydata.plugin")).apply((Dom) ZeusTransformUtils.wrapperContextForParams(r3, Dom.class, "com.obric.memorydata.plugin"));
    }

    static /* synthetic */ Object lambda$syncWrapVoid$109(Consumer r2, Dom r3) {
        ((Consumer) ZeusTransformUtils.wrapperContextForParams(r2, Consumer.class, "com.obric.memorydata.plugin")).accept((Dom) ZeusTransformUtils.wrapperContextForParams(r3, Dom.class, "com.obric.memorydata.plugin"));
        return null;
    }

    static Node nextSibling(Dom r2) {
        return node_getNextSibling((Dom) ZeusTransformUtils.wrapperContextForParams(r2, Dom.class, "com.obric.memorydata.plugin"));
    }

    static String nodeKindName(int r1) {
        switch(r1) {
            case 1: goto L27;
            case 2: goto L25;
            case 3: goto L23;
            case 4: goto L21;
            case 5: goto L19;
            case 6: goto L17;
            case 7: goto L15;
            case 8: goto L13;
            case 9: goto L11;
            case 10: goto L9;
            case 11: goto L7;
            case 12: goto L5;
            default: goto L4;
        };
    L5:
        return "notation";
    L7:
        return "document fragment";
    L9:
        return "document type";
    L11:
        return "document";
    L13:
        return "comment";
    L15:
        return "processing instruction";
    L17:
        return "entity";
    L19:
        return "entity reference";
    L21:
        return "cdata section";
    L23:
        return IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT;
    L25:
        return "attribute";
    L27:
        return "element";
    L4:
        throw new RuntimeException("Unknown node type");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v3, types: [org.apache.xmlbeans.impl.store.DomImpl$Dom] */
    /* JADX WARN: Type inference failed for: r2v5, types: [org.apache.xmlbeans.impl.store.CharNode] */
    /* JADX WARN: Type inference failed for: r2v6, types: [org.apache.xmlbeans.impl.store.DomImpl$Dom] */
    /* JADX WARN: Type inference failed for: r2v7 */
    public static Node node_cloneNode(Dom r9, boolean r10) {
        Dom r11 = (Dom) ZeusTransformUtils.wrapperContextForParams(r9, Dom.class, "com.obric.memorydata.plugin");
        Locale r0 = r11.locale();
        ?? r2 = 0;
        r2 = 0;
        if (r10 == true) goto L22;
        int r12 = r11.nodeType();
        if (r12 != 1) goto L7;
        Cur r13 = r0.tempCur();
        r13.createElement(r11.getQName());
        Element r4 = (Element) ZeusTransformUtils.preCheckCast(r13.getDom(), Element.class, "com.obric.memorydata.plugin");
        NamedNodeMap r5 = ((Element) ZeusTransformUtils.preCheckCast(r11, Element.class, "com.obric.memorydata.plugin")).getAttributes();
        int r6 = 0;
    L18:
        if (r6 >= r5.getLength()) goto L20;
        r4.setAttributeNodeNS((Attr) ZeusTransformUtils.preCheckCast(r5.item(r6).cloneNode(true), Attr.class, "com.obric.memorydata.plugin"));
        r6 = r6 + 1;
    L20:
        if (r13 == null) goto L22;
        r2 = r13.getDom();
        r13.release();
        goto L22
    L7:
        if (r12 != 2) goto L9;
        r13 = r0.tempCur();
        r13.createAttr(r11.getQName());
        goto L20
    L9:
        if (r12 != 9) goto L11;
        r13 = r0.tempCur();
        r13.createDomDocumentRoot();
        goto L20
    L11:
        if (r12 == 11) goto L13;
        r13 = null;
        goto L20
    L13:
        r13 = r0.tempCur();
        r13.createDomDocFragRoot();
    L22:
        if (r2 != 0) goto L36;
        switch(r11.nodeType()) {
            case 1: goto L34;
            case 2: goto L34;
            case 3: goto L29;
            case 4: goto L29;
            case 5: goto L28;
            case 6: goto L28;
            case 7: goto L34;
            case 8: goto L34;
            case 9: goto L34;
            case 10: goto L28;
            case 11: goto L34;
            case 12: goto L28;
            default: goto L26;
        };
    L29:
        Cur r14 = r11.tempCur();
        if (r11.nodeType() != 3) goto L32;
        TextNode r1 = r0.createTextNode();
    L33:
        r2 = r1;
        r2.setChars(r14.getChars(((CharNode) ZeusTransformUtils.preCheckCast(r11, CharNode.class, "com.obric.memorydata.plugin"))._cch), r14._offSrc, r14._cchSrc);
        r14.release();
        goto L36
    L32:
        r1 = r0.createCdataNode();
        goto L33
    L34:
        Cur r15 = r0.tempCur();
        Cur r16 = r11.tempCur();
        r16.copyNode(r15);
        r2 = r15.getDom();
        r15.release();
        r16.release();
        goto L36
    L26:
        throw new RuntimeException("Unknown kind");
    L28:
        throw new RuntimeException("Not impl");
    L36:
        return (Node) ZeusTransformUtils.preCheckCast(r2, Node.class, "com.obric.memorydata.plugin");
    }

    public static Node node_getFirstChild(Dom r4) {
        Dom r5 = (Dom) ZeusTransformUtils.wrapperContextForParams(r4, Dom.class, "com.obric.memorydata.plugin");
        int r0 = r5.nodeType();
        if (r0 != 1) goto L5;
    L16:
        Xobj r6 = (Xobj) ZeusTransformUtils.preCheckCast(r5, Xobj.class, "com.obric.memorydata.plugin");
        r6.ensureOccupancy();
        if (r6.isFirstChildPtrDomUsable() == true) goto L19;
        Xobj r1 = r6.lastAttr();
        if (r1 == null) goto L31;
        if (r1.isNextSiblingPtrDomUsable() == false) goto L27;
        return (NodeXobj) ZeusTransformUtils.preCheckCast(r1._nextSibling, NodeXobj.class, "com.obric.memorydata.plugin");
    L27:
        if (r1.isCharNodesAfterUsable() == false) goto L31;
        return r1._charNodesAfter;
    L31:
        if (r6.isCharNodesValueUsable() == true) goto L33;
    L35:
        return (Node) ZeusTransformUtils.preCheckCast(null, Node.class, "com.obric.memorydata.plugin");
    L33:
        return r6._charNodesValue;
    L19:
        return (NodeXobj) ZeusTransformUtils.preCheckCast(r6._firstChild, NodeXobj.class, "com.obric.memorydata.plugin");
    L5:
        if (r0 == 2) goto L16;
        if (r0 == 5) goto L15;
        if (r0 == 6) goto L13;
        switch(r0) {
            case 9: goto L16;
            case 10: goto L13;
            case 11: goto L16;
            case 12: goto L13;
            default: goto L35;
        };
    L13:
        throw new RuntimeException("Not impl");
    L15:
        throw new RuntimeException("Not impl");
    }

    public static Node node_getLastChild(Dom r4) {
        Dom r5 = (Dom) ZeusTransformUtils.wrapperContextForParams(r4, Dom.class, "com.obric.memorydata.plugin");
        Dom r3 = null;
        switch(r5.nodeType()) {
            case 3: goto L13;
            case 4: goto L13;
            case 5: goto L12;
            case 6: goto L10;
            case 7: goto L13;
            case 8: goto L13;
            case 9: goto L4;
            case 10: goto L10;
            case 11: goto L4;
            case 12: goto L10;
            default: goto L4;
        };
    L4:
        Cur r6 = r5.tempCur();
        if (r6.toLastChild() == false) goto L15;
        Dom r0 = r6.getDom();
        r6.skip();
        CharNode r2 = r6.getCharNodes();
        if (r2 != null) goto L16;
        r3 = r0;
    L16:
        if (r3 != null) goto L22;
        if (r2 == null) goto L22;
    L19:
        if (r2._next == null) goto L21;
        r2 = r2._next;
        goto L19
    L21:
        r3 = r2;
    L22:
        r6.release();
        return (Node) ZeusTransformUtils.preCheckCast(r3, Node.class, "com.obric.memorydata.plugin");
    L15:
        r6.next();
        r2 = r6.getCharNodes();
        goto L16
    L13:
        return null;
    L10:
        throw new RuntimeException("Not impl");
    L12:
        throw new RuntimeException("Not impl");
    }

    public static Node node_getNextSibling(Dom r5) {
        Dom r6 = (Dom) ZeusTransformUtils.wrapperContextForParams(r5, Dom.class, "com.obric.memorydata.plugin");
        Object r2 = null;
        switch(r6.nodeType()) {
            case 1: goto L18;
            case 2: goto L27;
            case 3: goto L7;
            case 4: goto L7;
            case 5: goto L6;
            case 6: goto L6;
            case 7: goto L18;
            case 8: goto L18;
            case 9: goto L27;
            case 10: goto L6;
            case 11: goto L27;
            case 12: goto L6;
            default: goto L27;
        };
    L7:
        CharNode r7 = (CharNode) ZeusTransformUtils.preCheckCast(r6, CharNode.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r7.getObject(), Xobj.class) == true) goto L10;
        return null;
    L10:
        Xobj r0 = (Xobj) ZeusTransformUtils.preCheckCast(r7.getObject(), Xobj.class, "com.obric.memorydata.plugin");
        r0._charNodesAfter = Cur.updateCharNodes(r0._locale, r0, r0._charNodesAfter, r0._cchAfter);
        r0._charNodesValue = Cur.updateCharNodes(r0._locale, r0, r0._charNodesValue, r0._cchValue);
        if (r7._next == null) goto L14;
        r2 = r7._next;
        goto L27
    L14:
        if (r7.isNodeAftertext() == false) goto L16;
        Xobj r8 = r0._nextSibling;
    L17:
        r2 = (NodeXobj) ZeusTransformUtils.preCheckCast(r8, NodeXobj.class, "com.obric.memorydata.plugin");
        goto L27
    L16:
        r8 = r0._firstChild;
        goto L17
    L18:
        Xobj r9 = (Xobj) ZeusTransformUtils.preCheckCast(r6, Xobj.class, "com.obric.memorydata.plugin");
        r9.ensureOccupancy();
        if (r9.isNextSiblingPtrDomUsable() == false) goto L23;
        return (NodeXobj) ZeusTransformUtils.preCheckCast(r9._nextSibling, NodeXobj.class, "com.obric.memorydata.plugin");
    L23:
        if (r9.isCharNodesAfterUsable() == false) goto L27;
        return r9._charNodesAfter;
    L6:
        throw new RuntimeException("Not implemented");
    L27:
        return (Node) ZeusTransformUtils.preCheckCast(r2, Node.class, "com.obric.memorydata.plugin");
    }

    public static String node_getNodeValue(Dom r4) {
        Dom r5 = (Dom) ZeusTransformUtils.wrapperContextForParams(r4, Dom.class, "com.obric.memorydata.plugin");
        int r0 = r5.nodeType();
        if (r0 == 2) goto L21;
        if (r0 != 3) goto L7;
    L13:
        CharNode r6 = (CharNode) ZeusTransformUtils.preCheckCast(r5, CharNode.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r6.getObject(), Xobj.class) == false) goto L23;
        Xobj r1 = (Xobj) ZeusTransformUtils.preCheckCast(r6.getObject(), Xobj.class, "com.obric.memorydata.plugin");
        r1.ensureOccupancy();
        if (r6.isNodeAftertext() == false) goto L19;
        r1._charNodesAfter = Cur.updateCharNodes(r1._locale, r1, r1._charNodesAfter, r1._cchAfter);
        return r1.getCharsAfterAsString(r6._off, r6._cch);
    L19:
        r1._charNodesValue = Cur.updateCharNodes(r1._locale, r1, r1._charNodesValue, r1._cchValue);
        return r1.getCharsValueAsString(r6._off, r6._cch);
    L23:
        return CharUtil.getString(r6.getObject(), r6._off, r6._cch);
    L7:
        if (r0 == 4) goto L13;
        if (r0 == 7) goto L21;
        if (r0 == 8) goto L21;
        return null;
    L21:
        return ((Xobj) ZeusTransformUtils.preCheckCast(r5, Xobj.class, "com.obric.memorydata.plugin")).getValueAsString();
    }

    public static Document node_getOwnerDocument(Dom r3) {
        Dom r4 = (Dom) ZeusTransformUtils.wrapperContextForParams(r3, Dom.class, "com.obric.memorydata.plugin");
        if (r4.nodeType() != 9) goto L6;
        return null;
    L6:
        Locale r5 = r4.locale();
        if (r5._ownerDoc != null) goto L10;
        Cur r0 = r5.tempCur();
        r0.createDomDocumentRoot();
        r5._ownerDoc = r0.getDom();
        r0.release();
    L10:
        return (Document) ZeusTransformUtils.preCheckCast(r5._ownerDoc, Document.class, "com.obric.memorydata.plugin");
    }

    public static Node node_getParentNode(Dom r4) {
        Dom r5 = (Dom) ZeusTransformUtils.wrapperContextForParams(r4, Dom.class, "com.obric.memorydata.plugin");
        switch(r5.nodeType()) {
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L10;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L7;
            case 7: goto L14;
            case 8: goto L14;
            case 9: goto L13;
            case 10: goto L7;
            case 11: goto L13;
            case 12: goto L7;
            default: goto L5;
        };
    L10:
        Cur r6 = r5.tempCur();
        if (r6 == null) goto L17;
        r6.toParent();
    L17:
        if (r6 != null) goto L19;
        return null;
    L19:
        Dom r0 = r6.getDom();
        r6.release();
        return (Node) ZeusTransformUtils.preCheckCast(r0, Node.class, "com.obric.memorydata.plugin");
    L13:
        r6 = null;
        goto L17
    L14:
        r6 = r5.tempCur();
        if (r6.toParentRaw() == true) goto L17;
        r6.release();
        goto L13
    L5:
        throw new RuntimeException("Unknown kind");
    L7:
        throw new RuntimeException("Not impl");
    L9:
        throw new RuntimeException("Not impl");
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x008e -> B:24:0x007e). Please report as a decompilation issue!!! */
    public static Node node_getPreviousSibling(Dom r4) {
        Dom r5 = (Dom) ZeusTransformUtils.wrapperContextForParams(r4, Dom.class, "com.obric.memorydata.plugin");
        int r0 = r5.nodeType();
        if (r0 != 3) goto L5;
    L15:
        CharNode r1 = (CharNode) ZeusTransformUtils.preCheckCast(r5, CharNode.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r1.getObject(), Xobj.class) == true) goto L19;
        return null;
    L19:
        NodeXobj r2 = (NodeXobj) ZeusTransformUtils.preCheckCast(r1.getObject(), NodeXobj.class, "com.obric.memorydata.plugin");
        r2.ensureOccupancy();
        boolean r3 = r1.isNodeAftertext();
        Node r6 = r1._prev;
        Node r7 = r2;
        if (r6 != null) goto L27;
        if (r3 == true) goto L24;
        r6 = r2._charNodesValue;
    L24:
        if (r7 == null) goto L28;
        r6 = node_getNextSibling((Dom) ZeusTransformUtils.preCheckCast(r7, Dom.class, "com.obric.memorydata.plugin"));
        if (r6 != r5) goto L27;
    L28:
        return r7;
    L27:
        r7 = r6;
        goto L24
    L5:
        if (r0 == 4) goto L15;
        NodeXobj r8 = (NodeXobj) ZeusTransformUtils.preCheckCast(r5, NodeXobj.class, "com.obric.memorydata.plugin");
        NodeXobj r9 = (NodeXobj) ZeusTransformUtils.preCheckCast(r8._prevSibling, NodeXobj.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L12;
        r7 = r9;
        if (ZeusTransformUtils.instanceOf(r8, AttrXobj.class) == true) goto L24;
        boolean r10 = ZeusTransformUtils.instanceOf(r9, AttrXobj.class);
        r7 = r9;
        if (r10 == false) goto L24;
    L12:
        r7 = r9;
        if (r8._parent == null) goto L24;
        r7 = node_getFirstChild((Dom) ZeusTransformUtils.preCheckCast(r8._parent, Dom.class, "com.obric.memorydata.plugin"));
        goto L24
    }

    public static boolean node_hasAttributes(Dom r2) {
        Dom r3 = (Dom) ZeusTransformUtils.wrapperContextForParams(r2, Dom.class, "com.obric.memorydata.plugin");
        if (r3.nodeType() != 1) goto L5;
        Cur r4 = r3.tempCur();
        boolean r0 = r4.hasAttrs();
        r4.release();
        return r0;
    L5:
        return false;
    }

    public static Node node_insertBefore(Dom r8, Dom r9, Dom r10) {
        Dom r11 = (Dom) ZeusTransformUtils.wrapperContextForParams(r8, Dom.class, "com.obric.memorydata.plugin");
        Dom r12 = (Dom) ZeusTransformUtils.wrapperContextForParams(r9, Dom.class, "com.obric.memorydata.plugin");
        Dom r13 = (Dom) ZeusTransformUtils.wrapperContextForParams(r10, Dom.class, "com.obric.memorydata.plugin");
        if (r12 == r13) goto L5;
        if (r13 != null) goto L8;
    L12:
        int r0 = r12.nodeType();
        if (r0 != 11) goto L24;
        Node r1 = firstChild(r12);
    L15:
        if (r1 == null) goto L17;
        validateNewChild(r11, (Dom) ZeusTransformUtils.preCheckCast(r1, Dom.class, "com.obric.memorydata.plugin"));
        r1 = nextSibling((Dom) ZeusTransformUtils.preCheckCast(r1, Dom.class, "com.obric.memorydata.plugin"));
        goto L15
    L17:
        Node r2 = firstChild(r12);
    L18:
        if (r2 == null) goto L5;
        Node r3 = nextSibling((Dom) ZeusTransformUtils.preCheckCast(r2, Dom.class, "com.obric.memorydata.plugin"));
        Dom r4 = (Dom) ZeusTransformUtils.preCheckCast(r2, Dom.class, "com.obric.memorydata.plugin");
        if (r13 != null) goto L22;
        append(r4, r11);
    L23:
        r2 = r3;
        goto L18
    L22:
        insert(r4, r13);
        goto L23
    L24:
        validateNewChild(r11, r12);
        remove(r12);
        r11.nodeType();
        if (r0 != 1) goto L27;
    L55:
        if (r13 != null) goto L59;
        Cur r14 = r11.tempCur();
        r14.toEnd();
    L57:
        Cur.moveNode((Xobj) ZeusTransformUtils.preCheckCast(r12, Xobj.class, "com.obric.memorydata.plugin"), r14);
    L58:
        r14.release();
        goto L5
    L59:
        int r5 = r13.nodeType();
        if (r5 == 3) goto L67;
        if (r5 == 4) goto L67;
        if (r5 == 5) goto L66;
        r14 = r13.tempCur();
        goto L57
    L66:
        throw new RuntimeException("Not implemented");
    L67:
        ArrayList r6 = new ArrayList();
    L68:
        if (r13 == null) goto L74;
        if (r13.nodeType() == 3) goto L73;
        if (r13.nodeType() != 4) goto L74;
    L73:
        Node r7 = nextSibling(r13);
        r6.add((Dom) ZeusTransformUtils.preCheckCast(remove(r13), Dom.class, "com.obric.memorydata.plugin"));
        r13 = (Dom) ZeusTransformUtils.preCheckCast(r7, Dom.class, "com.obric.memorydata.plugin");
    L74:
        if (r13 != null) goto L76;
        append(r12, r11);
    L77:
        Dom r15 = (Dom) ZeusTransformUtils.preCheckCast(nextSibling(r12), Dom.class, "com.obric.memorydata.plugin");
        Iterator r16 = r6.iterator();
    L79:
        if (r16.hasNext() == false) goto L5;
        Dom r17 = (Dom) ZeusTransformUtils.preCheckCast(r16.next(), Dom.class, "com.obric.memorydata.plugin");
        if (r15 == null) goto L82;
        insert(r17, r15);
        goto L79
    L82:
        append(r17, r11);
        goto L79
    L76:
        insert(r12, r13);
        goto L77
    L27:
        if (r0 == 10) goto L54;
        if (r0 == 3) goto L40;
        if (r0 == 4) goto L40;
        if (r0 == 5) goto L39;
        if (r0 == 7) goto L55;
        if (r0 == 8) goto L55;
        throw new RuntimeException("Unexpected child node type");
    L39:
        throw new RuntimeException("Not implemented");
    L40:
        CharNode r18 = (CharNode) ZeusTransformUtils.preCheckCast(r12, CharNode.class, "com.obric.memorydata.plugin");
        CharNode r19 = null;
        r14 = r11.tempCur();
        if (r13 != null) goto L43;
        r14.toEnd();
    L52:
        CharNode r110 = CharNode.insertNode(r14.getCharNodes(), r18, r19);
        r14.insertChars(r18.getObject(), r18._off, r18._cch);
        r14.setCharNodes(r110);
        goto L58
    L43:
        int r20 = r13.nodeType();
        if (r20 == 3) goto L51;
        if (r20 == 4) goto L51;
        if (r20 == 5) goto L50;
        r14.moveToDom(r13);
        goto L52
    L50:
        throw new RuntimeException("Not implemented");
    L51:
        r19 = (CharNode) ZeusTransformUtils.preCheckCast(r13, CharNode.class, "com.obric.memorydata.plugin");
        r14.moveToCharNode(r19);
        goto L52
    L54:
        throw new RuntimeException("Not implemented");
    L8:
        if (parent(r13) == r11) goto L12;
        throw new NotFoundErr("RefChild is not a child of this node");
    L5:
        return (Node) ZeusTransformUtils.preCheckCast(r12, Node.class, "com.obric.memorydata.plugin");
    }

    public static void node_normalize(Dom r5) {
        Dom r6 = (Dom) ZeusTransformUtils.wrapperContextForParams(r5, Dom.class, "com.obric.memorydata.plugin");
        switch(r6.nodeType()) {
            case 3: goto L9;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L6;
            case 7: goto L9;
            case 8: goto L9;
            case 9: goto L4;
            case 10: goto L6;
            case 11: goto L4;
            case 12: goto L6;
            default: goto L4;
        };
    L4:
        Cur r0 = r6.tempCur();
        r0.push();
    L10:
        r0.nextWithAttrs();
        CharNode r1 = r0.getCharNodes();
        if (r1 == null) goto L24;
        if (r0.isText() == true) goto L17;
    L14:
        if (r1 == null) goto L22;
        r1.setChars(null, 0, 0);
        r1 = CharNode.remove(r1, r1);
    L22:
        r0.setCharNodes(r1);
        goto L24
    L17:
        if (r1._next == null) goto L22;
    L19:
        if (r1._next == null) goto L21;
        r1.setChars(null, 0, 0);
        r1 = CharNode.remove(r1, r1._next);
        goto L19
    L21:
        r1._cch = Integer.MAX_VALUE;
    L24:
        if (r0.isAtEndOfLastPush() == false) goto L10;
        r0.release();
        r6.locale().invalidateDomCaches(r6);
        return;
    L9:
        return;
    L6:
        throw new RuntimeException("Not impl");
    L8:
        throw new RuntimeException("Not impl");
    }

    public static Node node_removeChild(Dom r6, Dom r7) {
        Dom r8 = (Dom) ZeusTransformUtils.wrapperContextForParams(r6, Dom.class, "com.obric.memorydata.plugin");
        Dom r9 = (Dom) ZeusTransformUtils.wrapperContextForParams(r7, Dom.class, "com.obric.memorydata.plugin");
        if (parent(r9) != r8) goto L19;
        switch(r9.nodeType()) {
            case 1: goto L15;
            case 2: goto L14;
            case 3: goto L12;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L9;
            case 7: goto L15;
            case 8: goto L15;
            case 9: goto L14;
            case 10: goto L9;
            case 11: goto L14;
            case 12: goto L9;
            default: goto L7;
        };
    L12:
        Cur r10 = r9.tempCur();
        CharNode r0 = r10.getCharNodes();
        CharNode r2 = (CharNode) ZeusTransformUtils.preCheckCast(r9, CharNode.class, "com.obric.memorydata.plugin");
        r2.setChars(r10.moveChars(null, r2._cch), r10._offSrc, r10._cchSrc);
        r10.setCharNodes(CharNode.remove(r0, r2));
        r10.release();
    L17:
        return (Node) ZeusTransformUtils.preCheckCast(r9, Node.class, "com.obric.memorydata.plugin");
    L15:
        removeNode(r9);
        goto L17
    L7:
        throw new RuntimeException("Unknown kind");
    L9:
        throw new RuntimeException("Not impl");
    L11:
        throw new RuntimeException("Not impl");
    L14:
        throw new IllegalStateException();
    L19:
        throw new NotFoundErr("Child to remove is not a child of given parent");
    }

    public static Node node_replaceChild(Dom r3, Dom r4, Dom r5) {
        Dom r6 = (Dom) ZeusTransformUtils.wrapperContextForParams(r3, Dom.class, "com.obric.memorydata.plugin");
        Dom r7 = (Dom) ZeusTransformUtils.wrapperContextForParams(r4, Dom.class, "com.obric.memorydata.plugin");
        Dom r8 = (Dom) ZeusTransformUtils.wrapperContextForParams(r5, Dom.class, "com.obric.memorydata.plugin");
        Node r0 = node_getNextSibling(r8);
        node_removeChild(r6, r8);
        node_insertBefore(r6, r7, (Dom) ZeusTransformUtils.preCheckCast(r0, Dom.class, "com.obric.memorydata.plugin"));     // Catch: DOMException -> L6
        return (Node) ZeusTransformUtils.preCheckCast(r8, Node.class, "com.obric.memorydata.plugin");
    L6:
        e = move-exception;
        node_insertBefore(r6, r8, (Dom) ZeusTransformUtils.preCheckCast(r0, Dom.class, "com.obric.memorydata.plugin"));
        throw e;
    }

    public static void node_setNodeValue(Dom r6, String r7) {
        Dom r8 = (Dom) ZeusTransformUtils.wrapperContextForParams(r6, Dom.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L5;
        r7 = "";
    L5:
        int r0 = r8.nodeType();
        if (r0 != 2) goto L8;
        NodeList r1 = ((Node) ZeusTransformUtils.preCheckCast(r8, Node.class, "com.obric.memorydata.plugin")).getChildNodes();
    L23:
        if (r1.getLength() <= 1) goto L26;
        node_removeChild(r8, (Dom) ZeusTransformUtils.preCheckCast(r1.item(1), Dom.class, "com.obric.memorydata.plugin"));
        goto L23
    L26:
        if (r1.getLength() != 0) goto L28;
        TextNode r2 = r8.locale().createTextNode();
        r2.setChars(r7, 0, r7.length());
        node_insertBefore(r8, r2, null);
    L30:
        if (((AttrXobj) ZeusTransformUtils.preCheckCast(r8, AttrXobj.class, "com.obric.memorydata.plugin")).isId() == false) goto L39;
        Document r3 = node_getOwnerDocument(r8);
        String r4 = node_getNodeValue(r8);
        if (ZeusTransformUtils.instanceOf(r3, DocumentXobj.class) == false) goto L40;
        DocumentXobj r5 = (DocumentXobj) ZeusTransformUtils.preCheckCast(r3, DocumentXobj.class, "com.obric.memorydata.plugin");
        r5.removeIdElement(r4);
        r5.addIdElement(r7, (Dom) ZeusTransformUtils.preCheckCast(attr_getOwnerElement(r8), Dom.class, "com.obric.memorydata.plugin"));
        return;
    L40:
        return;
    L39:
        return;
    L28:
        r1.item(0).setNodeValue(r7);
        goto L30
    L8:
        if (r0 != 3) goto L10;
    L17:
        CharNode r9 = (CharNode) ZeusTransformUtils.preCheckCast(r8, CharNode.class, "com.obric.memorydata.plugin");
        Cur r10 = r9.tempCur();
        if (r10 == null) goto L20;
        r10.moveChars(null, r9._cch);
        r9._cch = r7.length();
        r10.insertString(r7);
        r10.release();
        return;
    L20:
        r9.setChars(r7, 0, r7.length());
        return;
    L10:
        if (r0 == 4) goto L17;
        if (r0 != 7) goto L14;
    L16:
        Cur r11 = r8.tempCur();
        r11.next();
        r11.getChars(-1);
        r11.moveChars(null, r11._cchSrc);
        r11.insertString(r7);
        r11.release();
        return;
    L14:
        if (r0 == 8) goto L16;
    }

    public static void node_setPrefix(Dom r7, String r8) {
        Dom r9 = (Dom) ZeusTransformUtils.wrapperContextForParams(r7, Dom.class, "com.obric.memorydata.plugin");
        boolean r1 = false;
        if (r9.nodeType() != 1) goto L5;
    L8:
        Cur r0 = r9.tempCur();
        QName r4 = r0.getName();
        String r5 = r4.getNamespaceURI();
        String r6 = r4.getLocalPart();
        if (r9.nodeType() != 2) goto L11;
        r1 = true;
    L11:
        r0.setName(r9.locale().makeQName(r5, r6, validatePrefix(r8, r5, r6, r1)));
        r0.release();
        return;
    L5:
        if (r9.nodeType() == 2) goto L8;
        validatePrefix(r8, "", "", false);
    }

    static Node parent(Dom r2) {
        return node_getParentNode((Dom) ZeusTransformUtils.wrapperContextForParams(r2, Dom.class, "com.obric.memorydata.plugin"));
    }

    static Node prevSibling(Dom r2) {
        return node_getPreviousSibling((Dom) ZeusTransformUtils.wrapperContextForParams(r2, Dom.class, "com.obric.memorydata.plugin"));
    }

    public static Node remove(Dom r3) {
        Dom r4 = (Dom) ZeusTransformUtils.wrapperContextForParams(r3, Dom.class, "com.obric.memorydata.plugin");
        Node r0 = parent(r4);
        if (r0 == null) goto L6;
        node_removeChild((Dom) ZeusTransformUtils.preCheckCast(r0, Dom.class, "com.obric.memorydata.plugin"), r4);
    L6:
        return (Node) ZeusTransformUtils.preCheckCast(r4, Node.class, "com.obric.memorydata.plugin");
    }

    private static void removeNode(Dom r6) {
        Dom r7 = (Dom) ZeusTransformUtils.wrapperContextForParams(r6, Dom.class, "com.obric.memorydata.plugin");
        Cur r0 = r7.tempCur();
        r0.toEnd();
        if (r0.next() == false) goto L7;
        CharNode r2 = r0.getCharNodes();
        if (r2 == null) goto L7;
        r0.setCharNodes(null);
        Cur r4 = r7.tempCur();
        r4.setCharNodes(CharNode.appendNodes(r4.getCharNodes(), r2));
        r4.release();
    L7:
        r0.release();
        Cur.moveNode((Xobj) ZeusTransformUtils.preCheckCast(r7, Xobj.class, "com.obric.memorydata.plugin"), null);
    }

    private static <T> T syncWrap(Dom r2, Function<Dom, T> r3) {
        final Dom r4 = (Dom) ZeusTransformUtils.wrapperContextForParams(r2, Dom.class, "com.obric.memorydata.plugin");
        final Function r5 = (Function) ZeusTransformUtils.wrapperContextForParams(r3, Function.class, "com.obric.memorydata.plugin");
        return (T) syncWrapHelper(r4.locale(), true, new $$Lambda$DomImpl$Wv39PVuNJaokGQAr_yIO8nj0VE(r5, r4));
    }

    private static <T> T syncWrapHelper(Locale r2, boolean r3, Supplier<T> r4) {
        Supplier r5 = (Supplier) ZeusTransformUtils.wrapperContextForParams(r4, Supplier.class, "com.obric.memorydata.plugin");
        if (r2.noSync() == true) goto L5;
        monitor-enter(r2);
        T r6 = (T) syncWrapHelper2(r2, r3, r5);
        monitor-exit(r2);     // Catch: Throwable -> L10
        return r6;
    L10:
        th = move-exception;
        throw th;
    L5:
        return (T) syncWrapHelper2(r2, r3, r5);
    }

    private static <T> T syncWrapHelper2(Locale r2, boolean r3, Supplier<T> r4) {
        Supplier r5 = (Supplier) ZeusTransformUtils.wrapperContextForParams(r4, Supplier.class, "com.obric.memorydata.plugin");
        if (r3 == false) goto L13;
        r2.enter();
    L13:
        T r6 = (T) r5.get();
        if (r3 == false) goto L8;
        r2.exit();
    L8:
        return r6;
    L9:
        th = move-exception;
        if (r3 == false) goto L12;
        r2.exit();
    L12:
        throw th;
    }

    private static <T> T syncWrapNoEnter(Dom r2, Function<Dom, T> r3) {
        final Dom r4 = (Dom) ZeusTransformUtils.wrapperContextForParams(r2, Dom.class, "com.obric.memorydata.plugin");
        final Function r5 = (Function) ZeusTransformUtils.wrapperContextForParams(r3, Function.class, "com.obric.memorydata.plugin");
        return (T) syncWrapHelper(r4.locale(), false, new $$Lambda$DomImpl$_rSzY1cBZnBj3R6iRnlE0Uj8Bk(r5, r4));
    }

    private static void syncWrapVoid(Dom r2, Consumer<Dom> r3) {
        final Dom r4 = (Dom) ZeusTransformUtils.wrapperContextForParams(r2, Dom.class, "com.obric.memorydata.plugin");
        final Consumer r5 = (Consumer) ZeusTransformUtils.wrapperContextForParams(r3, Consumer.class, "com.obric.memorydata.plugin");
        syncWrapHelper(r4.locale(), true, new $$Lambda$DomImpl$h_1Ln7W4cRiQRVENExQvUQq4U3E(r5, r4));
    }

    private static void validateName(String r1) {
        if (r1 == null) goto L13;
        if (r1.length() == 0) goto L11;
        if (XMLChar.isValidName(r1) == false) goto L9;
        return;
    L9:
        throw new InvalidCharacterError("Name has an invalid character");
    L11:
        throw new IllegalArgumentException("Name is empty");
    L13:
        throw new IllegalArgumentException("Name is null");
    }

    private static void validateNcName(String r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        if (r1.length() > 0) goto L6;
        return;
    L6:
        if (XMLChar.isValidNCName(r1) == false) goto L9;
        return;
    L9:
        throw new InvalidCharacterError();
    }

    private static void validateNewChild(Dom r3, Dom r4) {
        Dom r5 = (Dom) ZeusTransformUtils.wrapperContextForParams(r3, Dom.class, "com.obric.memorydata.plugin");
        Dom r6 = (Dom) ZeusTransformUtils.wrapperContextForParams(r4, Dom.class, "com.obric.memorydata.plugin");
        String r0 = isValidChild(r5, r6);
        if (r0 != null) goto L20;
        if (r5 == r6) goto L18;
        Node r7 = (Node) ZeusTransformUtils.preCheckCast(r5, Node.class, "com.obric.memorydata.plugin");
    L6:
        r7 = parent((Dom) ZeusTransformUtils.preCheckCast(r7, Dom.class, "com.obric.memorydata.plugin"));
        if (r7 == null) goto L16;
        if (r6.nodeType() == 5) goto L15;
        if (r6 != r7) goto L6;
        throw new HierarchyRequestErr("New child is an ancestor node of the parent node");
    L15:
        throw new NoModificationAllowedErr("Entity reference trees may not be modified");
    L16:
        return;
    L18:
        throw new HierarchyRequestErr("New child and parent are the same node");
    L20:
        throw new HierarchyRequestErr(r0);
    }

    private static String validatePrefix(String r3, String r4, String r5, boolean r6) {
        if (r3 != null) goto L4;
    L8:
        validateNcName(r3);
        if (r3 != null) goto L11;
        r3 = "";
    L11:
        if (r4 != null) goto L14;
        r4 = "";
    L14:
        if (r3.length() <= 0) goto L21;
        if (r4.length() != 0) goto L21;
        throw new NamespaceErr("Attempt to give a prefix for no namespace");
    L21:
        if (r3.equals("xml") == true) goto L23;
    L27:
        if (r6 == false) goto L53;
        if (r3.length() <= 0) goto L46;
        if (r5.equals("xmlns") == true) goto L44;
        if (Locale.beginsWithXml(r5) == true) goto L42;
        if (r3.equals("xmlns") == true) goto L37;
    L54:
        return r3;
    L37:
        if (r4.equals("http://www.w3.org/2000/xmlns/") == true) goto L54;
        throw new NamespaceErr("Invalid namespace - uri is not 'http://www.w3.org/2000/xmlns/;");
    L42:
        throw new NamespaceErr("Invalid namespace - attr prefix begins with 'xml'");
    L44:
        throw new NamespaceErr("Invalid namespace - attr is default namespace already");
    L46:
        if (r5.equals("xmlns") == false) goto L54;
        if (r4.equals("http://www.w3.org/2000/xmlns/") == true) goto L54;
        throw new NamespaceErr("Invalid namespace - uri is not 'http://www.w3.org/2000/xmlns/;");
    L53:
        if (Locale.beginsWithXml(r3) == false) goto L54;
        throw new NamespaceErr("Invalid prefix - begins with 'xml'");
    L23:
        if (r4.equals("http://www.w3.org/XML/1998/namespace") == true) goto L27;
        throw new NamespaceErr("Invalid prefix - begins with 'xml'");
    L4:
        if (r3.contains(ParameterizedMessage.ERROR_MSG_SEPARATOR) == false) goto L8;
        throw new NamespaceErr("Invalid prefix - contains ':' character");
    }

    private static void validateQualifiedName(String r3, String r4, boolean r5) {
        if (r4 != null) goto L4;
        r4 = "";
    L4:
        int r1 = r3.indexOf(58);
        if (r1 >= 0) goto L15;
        validateNcName(r3);
        if (r5 == false) goto L28;
        if (r3.equals("xmlns") == false) goto L28;
        if (r4.equals("http://www.w3.org/2000/xmlns/") == true) goto L28;
        throw new NamespaceErr("Default xmlns attribute does not have namespace: http://www.w3.org/2000/xmlns/");
    L28:
        if (r3.length() == 0) goto L31;
        return;
    L31:
        throw new NamespaceErr("Invalid qualified name, no local part specified");
    L15:
        if (r1 == 0) goto L37;
        String r6 = r3.substring(0, r1);
        validateNcName(r6);
        if (r4.length() == 0) goto L35;
        r3 = r3.substring(r1 + 1);
        if (r3.indexOf(58) >= 0) goto L33;
        validateNcName(r3);
        if (r6.equals("xml") == false) goto L28;
        if (r4.equals("http://www.w3.org/XML/1998/namespace") == true) goto L28;
        throw new NamespaceErr("Invalid prefix - begins with 'xml'");
    L33:
        throw new NamespaceErr("Invalid qualified name, more than one colon");
    L35:
        throw new NamespaceErr("Attempt to give a prefix for no namespace");
    L37:
        throw new NamespaceErr("Invalid qualified name, no prefix specified");
    }
}
