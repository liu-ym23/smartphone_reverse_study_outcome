package org.apache.xmlbeans.impl.store;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SchemaTypeLoader;
import org.apache.xmlbeans.XmlDocumentProperties;
import org.apache.xmlbeans.XmlOptions;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes7.dex */
final class DomSaver extends Saver {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final boolean _isFrag;
    private Cur _nodeCur;
    private final XmlOptions _options;
    private final SchemaTypeLoader _stl;
    private SchemaType _type;

    static {
    }

    DomSaver(Cur r2, boolean r3, XmlOptions r4) {
        super(r2, r4);
        if (r2.isUserNode() == false) goto L5;
        this._type = r2.getUser().get_schema_type();
    L5:
        this._stl = r2._locale._schemaTypeLoader;
        this._options = r4;
        this._isFrag = r3;
    }

    private void emitTextValue(Saver.SaveCur r5) {
        r5.push();
        r5.next();
        if (r5.isText() == false) goto L5;
        this._nodeCur.next();
        this._nodeCur.insertChars(r5.getChars(), r5._offSrc, r5._cchSrc);
        this._nodeCur.toParent();
    L5:
        r5.pop();
    }

    private void ensureDoc() {
        if (this._nodeCur.isPositioned() == false) goto L5;
        return;
    L5:
        if (this._isFrag == false) goto L7;
        this._nodeCur.createDomDocFragRoot();
    L8:
        this._nodeCur.next();
        return;
    L7:
        this._nodeCur.createDomDocumentRoot();
        goto L8
    }

    private QName getQualifiedName(Saver.SaveCur r3, QName r4) {
        String r5 = r4.getNamespaceURI();
        if (r5.length() <= 0) goto L5;
        String r0 = getUriMapping(r5);
    L7:
        if (r0.equals(r4.getPrefix()) == false) goto L10;
        return r4;
    L10:
        return this._nodeCur._locale.makeQName(r5, r4.getLocalPart(), r0);
    L5:
        r0 = "";
        goto L7
    }

    @Override // org.apache.xmlbeans.impl.store.Saver
    public void emitComment(Saver.SaveCur r2) {
        ensureDoc();
        this._nodeCur.createComment();
        emitTextValue(r2);
        this._nodeCur.skip();
    }

    @Override // org.apache.xmlbeans.impl.store.Saver
    public void emitDocType(String r2, String r3, String r4) {
        ensureDoc();
        XmlDocumentProperties r1 = Locale.getDocProps(this._nodeCur, true);
        r1.setDoctypeName(r2);
        r1.setDoctypePublicId(r3);
        r1.setDoctypeSystemId(r4);
    }

    @Override // org.apache.xmlbeans.impl.store.Saver
    public boolean emitElement(Saver.SaveCur r7, List<QName> r8, List<String> r9) {
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        if (Locale.isFragmentQName(r7.getName()) == false) goto L5;
        this._nodeCur.moveTo(null, -2);
    L5:
        ensureDoc();
        this._nodeCur.createElement(getQualifiedName(r7, r7.getName()));
        this._nodeCur.next();
        iterateMappings();
    L7:
        if (hasMapping() == false) goto L9;
        Cur r0 = this._nodeCur;
        r0.createAttr(r0._locale.createXmlns(mappingPrefix()));
        this._nodeCur.next();
        this._nodeCur.insertString(mappingUri());
        this._nodeCur.toParent();
        this._nodeCur.skipWithAttrs();
        nextMapping();
        goto L7
    L9:
        int r2 = 0;
    L11:
        if (r2 >= r10.size()) goto L13;
        this._nodeCur.createAttr(getQualifiedName(r7, (QName) ZeusTransformUtils.preCheckCast(r10.get(r2), QName.class, "com.obric.memorydata.plugin")));
        this._nodeCur.next();
        this._nodeCur.insertString((String) ZeusTransformUtils.preCheckCast(r11.get(r2), String.class, "com.obric.memorydata.plugin"));
        this._nodeCur.toParent();
        this._nodeCur.skipWithAttrs();
        r2 = r2 + 1;
        goto L11
    L13:
        return false;
    }

    @Override // org.apache.xmlbeans.impl.store.Saver
    public void emitEndDoc(Saver.SaveCur r1) {
    }

    @Override // org.apache.xmlbeans.impl.store.Saver
    public void emitFinish(Saver.SaveCur r1) {
        if (Locale.isFragmentQName(r1.getName()) == true) goto L6;
        this._nodeCur.next();
        return;
    }

    @Override // org.apache.xmlbeans.impl.store.Saver
    public void emitProcinst(Saver.SaveCur r3) {
        ensureDoc();
        this._nodeCur.createProcinst(r3.getName().getLocalPart());
        emitTextValue(r3);
        this._nodeCur.skip();
    }

    @Override // org.apache.xmlbeans.impl.store.Saver
    public void emitStartDoc(Saver.SaveCur r1) {
        ensureDoc();
    }

    @Override // org.apache.xmlbeans.impl.store.Saver
    public void emitText(Saver.SaveCur r4) {
        ensureDoc();
        Object r0 = r4.getChars();
        if (r4._cchSrc <= 0) goto L6;
        this._nodeCur.insertChars(r0, r4._offSrc, r4._cchSrc);
        this._nodeCur.next();
        return;
    }

    Node saveDom() {
        Locale r0 = Locale.getLocale(this._stl, this._options);
        r0.enter();
        this._nodeCur = r0.getCur();     // Catch: Throwable -> L16
    L5:
        if (process() == true) goto L5;
    L8:
        if (this._nodeCur.isRoot() == true) goto L10;
        this._nodeCur.toParent();     // Catch: Throwable -> L16
        goto L8
    L10:
        SchemaType r1 = this._type;     // Catch: Throwable -> L16
        if (r1 == null) goto L13;
        this._nodeCur.setType(r1);     // Catch: Throwable -> L16
    L13:
        Node r2 = (Node) ZeusTransformUtils.preCheckCast(this._nodeCur.getDom(), Node.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
        this._nodeCur.release();     // Catch: Throwable -> L16
        this._nodeCur = null;     // Catch: Throwable -> L16
        r0.exit();
        return r2;
    L16:
        th = move-exception;
        r0.exit();
        throw th;
    }
}
