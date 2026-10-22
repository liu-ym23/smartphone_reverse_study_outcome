package org.apache.xmlbeans.impl.store;

import com.ctc.wstx.shaded.msv_core.grammar.xmlschema.XMLSchemaSchema;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import javax.xml.namespace.QName;
import javax.xml.stream.a;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.impl.common.ValidatorListener;

/* JADX INFO: loaded from: classes7.dex */
final class Validate implements ValidatorListener.Event {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private Cur _cur;
    private boolean _hasText;
    private boolean _oneChunk;
    private ValidatorListener _sink;
    private Cur _textCur;
    private StringBuffer _textSb;

    static {
    }

    Validate(Cur r3, ValidatorListener r4) {
        ValidatorListener r5 = (ValidatorListener) ZeusTransformUtils.wrapperContextForParams(r4, ValidatorListener.class, "com.obric.memorydata.plugin");
        if (r3.isUserNode() == false) goto L12;
        this._sink = r5;
        this._cur = r3;
        this._textCur = r3.tempCur();
        this._hasText = false;
        this._cur.push();
        process();     // Catch: Throwable -> L8
        this._cur.pop();
        this._cur = null;
        this._sink = null;
        this._textCur.release();
        return;
    L8:
        th = move-exception;
        this._cur.pop();
        this._cur = null;
        this._sink = null;
        this._textCur.release();
        throw th;
    L12:
        throw new IllegalStateException("Inappropriate location to validate");
    }

    private void doAttrs() {
        if (this._cur.toFirstAttr() == true) goto L5;
    L12:
        this._sink.nextEvent(5, this);
        return;
    L5:
        if (this._cur.isNormalAttr() == false) goto L10;
        if (this._cur.getUri().equals(XMLSchemaSchema.XMLSchemaInstanceNamespace) == true) goto L10;
        this._sink.nextEvent(4, this);
    L10:
        if (this._cur.toNextAttr() == true) goto L5;
        this._cur.toParent();
        goto L12
    }

    private void emitEvent(int r3) {
        if (this._hasText == false) goto L5;
        this._sink.nextEvent(3, this);
        this._hasText = false;
    L5:
        this._sink.nextEvent(r3, this);
    }

    private void emitText() {
        if (this._hasText == true) goto L5;
        this._hasText = true;
        this._oneChunk = true;
        this._textCur.moveToCur(this._cur);
        return;
    L5:
        if (this._oneChunk == false) goto L11;
        StringBuffer r0 = this._textSb;
        if (r0 != null) goto L9;
        this._textSb = new StringBuffer();
    L10:
        CharUtil.getString(this._textSb, this._textCur.getChars(-1), this._textCur._offSrc, this._textCur._cchSrc);
        this._oneChunk = false;
        goto L11
    L9:
        r0.delete(0, r0.length());
    L11:
        CharUtil.getString(this._textSb, this._cur.getChars(-1), this._cur._offSrc, this._cur._cchSrc);
    }

    private void process() {
        emitEvent(1);
        if (this._cur.isAttr() == false) goto L7;
        this._cur.next();
        if (this._cur.isText() == false) goto L25;
        emitText();
    L25:
        emitEvent(2);
        return;
    L7:
        doAttrs();
    L8:
        this._cur.next();
        if (this._cur.isAtEndOfLastPush() == true) goto L25;
        int r1 = this._cur.kind();
        if (r1 != (-2)) goto L12;
        emitEvent(2);
        goto L8
    L12:
        if (r1 != 0) goto L13;
        emitText();
        goto L8
    L13:
        if (r1 == 2) goto L22;
        if (r1 != 4) goto L17;
    L21:
        this._cur.toEnd();
        goto L8
    L17:
        if (r1 == 5) goto L21;
        throw new RuntimeException("Unexpected kind: " + this._cur.kind());
    L22:
        emitEvent(1);
        goto L7
    }

    @Override // org.apache.xmlbeans.impl.common.ValidatorListener.Event
    public a getLocation() {
        return null;
    }

    @Override // org.apache.xmlbeans.impl.common.ValidatorListener.Event
    public XmlCursor getLocationAsCursor() {
        return new Cursor(this._cur);
    }

    @Override // org.apache.xmlbeans.impl.common.ValidatorListener.Event
    public QName getName() {
        if (this._cur.isAtLastPush() == false) goto L6;
        return null;
    L6:
        return this._cur.getName();
    }

    @Override // org.apache.xmlbeans.impl.common.PrefixResolver
    public String getNamespaceForPrefix(String r2) {
        return this._cur.namespaceForPrefix(r2, true);
    }

    @Override // org.apache.xmlbeans.impl.common.ValidatorListener.Event
    public String getText() {
        if (this._cur.isAttr() == false) goto L7;
        return this._cur.getValueAsString();
    L7:
        if (this._oneChunk == false) goto L10;
        return this._textCur.getCharsAsString();
    L10:
        return this._textSb.toString();
    }

    @Override // org.apache.xmlbeans.impl.common.ValidatorListener.Event
    public String getText(int r2) {
        if (this._cur.isAttr() == false) goto L7;
        return this._cur.getValueAsString(r2);
    L7:
        if (this._oneChunk == false) goto L11;
        return this._textCur.getCharsAsString(r2);
    L11:
        return Locale.applyWhiteSpaceRule(this._textSb.toString(), r2);
    }

    @Override // org.apache.xmlbeans.impl.common.ValidatorListener.Event
    public String getXsiNil() {
        return this._cur.getAttrValue(Locale._xsiNil);
    }

    @Override // org.apache.xmlbeans.impl.common.ValidatorListener.Event
    public String getXsiType() {
        return this._cur.getAttrValue(Locale._xsiType);
    }

    @Override // org.apache.xmlbeans.impl.common.ValidatorListener.Event
    public boolean textIsWhitespace() {
        if (this._cur.isAttr() == false) goto L7;
        return this._cur._locale.getCharUtil().isWhiteSpace(this._cur.getFirstChars(), this._cur._offSrc, this._cur._cchSrc);
    L7:
        if (this._oneChunk == true) goto L9;
        String r0 = this._textSb.toString();
        return this._cur._locale.getCharUtil().isWhiteSpace(r0, 0, r0.length());
    L9:
        return this._cur._locale.getCharUtil().isWhiteSpace(this._textCur.getChars(-1), this._textCur._offSrc, this._textCur._cchSrc);
    }
}
