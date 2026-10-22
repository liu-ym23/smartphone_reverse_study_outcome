package org.apache.poi.xslf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import org.apache.poi.sl.usermodel.Placeholder;
import org.apache.poi.sl.usermodel.TextShape;
import org.apache.poi.xddf.usermodel.text.TextContainer;
import org.apache.xmlbeans.XmlObject;
import org.openxmlformats.schemas.drawingml.x2006.main.df;
import org.openxmlformats.schemas.drawingml.x2006.main.dv;

/* JADX INFO: loaded from: classes7.dex */
public abstract class XSLFTextShape extends XSLFSimpleShape implements TextShape<XSLFShape, XSLFTextParagraph>, TextContainer {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final List<XSLFTextParagraph> _paragraphs;

    static {
    }

    XSLFTextShape(XmlObject r4, XSLFSheet r5) {
        super((XmlObject) ZeusTransformUtils.wrapperContextForParams(r4, XmlObject.class, "com.obric.memorydata.plugin"), r5);
        this._paragraphs = new ArrayList();
        int r6 = 0;
        df r7 = getTextBody(false);
        if (r7 == null) goto L7;
        dv[] r8 = r7.getPArray();
        int r0 = r8.length;
    L5:
        if (r6 >= r0) goto L9;
        dv r1 = r8[r6];
        this._paragraphs.add(newTextParagraph(r1));
        r6 = r6 + 1;
        goto L5
    L9:
        return;
    }

    @Override // org.apache.poi.sl.usermodel.TextShape
    public String getText() {
        StringBuilder r0 = new StringBuilder();
        Iterator<XSLFTextParagraph> r4 = this._paragraphs.iterator();
    L4:
        if (r4.hasNext() == false) goto L10;
        XSLFTextParagraph r1 = (XSLFTextParagraph) ZeusTransformUtils.preCheckCast(r4.next(), XSLFTextParagraph.class, "com.obric.memorydata.plugin");
        if (r0.length() <= 0) goto L8;
        r0.append('\n');
    L8:
        r0.append(r1.getText());
        goto L4
    L10:
        return r0.toString();
    }

    public abstract df getTextBody(boolean r1);

    @Override // org.apache.poi.sl.usermodel.TextShape
    public List<XSLFTextParagraph> getTextParagraphs() {
        return Collections.unmodifiableList(this._paragraphs);
    }

    public Placeholder getTextType() {
        return getPlaceholder();
    }

    @Override // java.lang.Iterable
    public Iterator<XSLFTextParagraph> iterator() {
        return getTextParagraphs().iterator();
    }

    public XSLFTextParagraph newTextParagraph(dv r3) {
        return new XSLFTextParagraph((dv) ZeusTransformUtils.wrapperContextForParams(r3, dv.class, "com.obric.memorydata.plugin"), this);
    }

    @Override // java.lang.Iterable
    public Spliterator<XSLFTextParagraph> spliterator() {
        return getTextParagraphs().spliterator();
    }
}
