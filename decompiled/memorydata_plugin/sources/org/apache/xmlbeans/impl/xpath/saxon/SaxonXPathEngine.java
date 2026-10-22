package org.apache.xmlbeans.impl.xpath.saxon;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ConcurrentModificationException;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import net.sf.saxon.value.DateTimeValue;
import net.sf.saxon.value.GDateValue;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlDate;
import org.apache.xmlbeans.XmlDateTime;
import org.apache.xmlbeans.XmlDecimal;
import org.apache.xmlbeans.XmlDouble;
import org.apache.xmlbeans.XmlFloat;
import org.apache.xmlbeans.XmlInteger;
import org.apache.xmlbeans.XmlLong;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.store.Cur;
import org.apache.xmlbeans.impl.store.DomImpl;
import org.apache.xmlbeans.impl.xpath.XPathEngine;
import org.apache.xmlbeans.impl.xpath.XPathExecutionContext;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes7.dex */
public class SaxonXPathEngine extends XPathExecutionContext implements XPathEngine {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private Cur _cur;
    private SaxonXPath _engine;
    private boolean _firstCall;
    private final long _version;
    private final DateFormat xmlDateFormat;

    static {
    }

    SaxonXPathEngine(SaxonXPath r4, Cur r5) {
        this.xmlDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ROOT);
        this._firstCall = true;
        this._engine = r4;
        this._version = r5.getLocale().version();
        this._cur = r5.weakCur(this);
    }

    private SchemaType getType(Object r1) {
        if (ZeusTransformUtils.instanceOf(r1, Integer.class) == false) goto L6;
        return XmlInteger.type;
    L6:
        if (ZeusTransformUtils.instanceOf(r1, Double.class) == false) goto L9;
        return XmlDouble.type;
    L9:
        if (ZeusTransformUtils.instanceOf(r1, Long.class) == false) goto L12;
        return XmlLong.type;
    L12:
        if (ZeusTransformUtils.instanceOf(r1, Float.class) == false) goto L15;
        return XmlFloat.type;
    L15:
        if (ZeusTransformUtils.instanceOf(r1, BigDecimal.class) == false) goto L18;
        return XmlDecimal.type;
    L18:
        if (ZeusTransformUtils.instanceOf(r1, Boolean.class) == false) goto L21;
        return XmlBoolean.type;
    L21:
        if (ZeusTransformUtils.instanceOf(r1, String.class) == false) goto L24;
        return XmlString.type;
    L24:
        if (ZeusTransformUtils.instanceOf(r1, GDateValue.class) == false) goto L27;
        return XmlDate.type;
    L27:
        if (ZeusTransformUtils.instanceOf(r1, DateTimeValue.class) == false) goto L30;
        return XmlDateTime.type;
    L30:
        return XmlAnySimpleType.type;
    }

    @Override // org.apache.xmlbeans.impl.xpath.XPathEngine
    public boolean next(Cur r9) {
        int r1 = 0;
        if (this._firstCall == true) goto L5;
        return false;
    L5:
        this._firstCall = false;
        Cur r0 = this._cur;
        if (r0 != null) goto L8;
    L12:
        List r2 = this._engine.selectPath(this._cur.getDom());
    L14:
        if (r1 >= r2.size()) goto L38;
        Object r3 = r2.get(r1);
        if (ZeusTransformUtils.instanceOf(r3, Node.class) == true) goto L36;
        Object r4 = r2.get(r1);
        if (ZeusTransformUtils.instanceOf(r4, Date.class) == false) goto L21;
        String r5 = this.xmlDateFormat.format((Date) ZeusTransformUtils.preCheckCast(r4, Date.class, "com.obric.memorydata.plugin"));
    L40:
        Cur r6 = r9.getLocale().load("<xml-fragment/>").tempCur();     // Catch: Exception -> L33
        r6.setValue(r5);     // Catch: Exception -> L33
        org.apache.xmlbeans.impl.store.Locale.autoTypeDocument(r6, getType(r3), null);     // Catch: Exception -> L33
        r6.next();     // Catch: Exception -> L33
    L37:
        r9.addToSelection(r6);
        r6.release();
        r1 = r1 + 1;
    L33:
        e = move-exception;
        throw new RuntimeException(e);
    L21:
        if (ZeusTransformUtils.instanceOf(r4, GDateValue.class) == false) goto L24;
        r5 = ((GDateValue) ZeusTransformUtils.preCheckCast(r4, GDateValue.class, "com.obric.memorydata.plugin")).getStringValue();
        goto L40
    L24:
        if (ZeusTransformUtils.instanceOf(r4, DateTimeValue.class) == false) goto L27;
        r5 = ((DateTimeValue) ZeusTransformUtils.preCheckCast(r4, DateTimeValue.class, "com.obric.memorydata.plugin")).getStringValue();
        goto L40
    L27:
        if (ZeusTransformUtils.instanceOf(r4, BigDecimal.class) == false) goto L29;
        r5 = ((BigDecimal) ZeusTransformUtils.preCheckCast(r4, BigDecimal.class, "com.obric.memorydata.plugin")).toPlainString();
        goto L40
    L29:
        r5 = r4.toString();
        goto L40
    L36:
        r6 = ((DomImpl.Dom) ZeusTransformUtils.preCheckCast(r3, DomImpl.Dom.class, "com.obric.memorydata.plugin")).tempCur();
        goto L37
    L38:
        release();
        this._engine = null;
        return true;
    L8:
        if (this._version == r0.getLocale().version()) goto L12;
        throw new ConcurrentModificationException("Document changed during select");
    }

    @Override // org.apache.xmlbeans.impl.xpath.XPathEngine
    public void release() {
        Cur r0 = this._cur;
        if (r0 == null) goto L6;
        r0.release();
        this._cur = null;
        return;
    }
}
