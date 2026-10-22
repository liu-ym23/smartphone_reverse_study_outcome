package org.apache.poi.xslf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import javax.xml.namespace.QName;
import javax.xml.stream.e;
import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;
import org.apache.poi.ooxml.util.XPathHelper;
import org.apache.poi.sl.usermodel.PictureShape;
import org.openxmlformats.schemas.drawingml.x2006.main.f;
import org.openxmlformats.schemas.drawingml.x2006.main.g;
import org.openxmlformats.schemas.presentationml.x2006.main.ac;

/* JADX INFO: loaded from: classes7.dex */
public class XSLFPictureShape extends XSLFSimpleShape implements PictureShape<XSLFShape, XSLFTextParagraph> {
    private static final QName[] BLIP_FILL = null;
    private static final QName EMBED_TAG = null;
    private static final c LOG = null;
    private XSLFPictureData _data;

    static {
        LOG = b.a(XSLFPictureShape.class);
        EMBED_TAG = new QName("http://schemas.openxmlformats.org/officeDocument/2006/relationships", "embed", "rel");
        BLIP_FILL = new QName[]{new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "blipFill")};
    }

    XSLFPictureShape(ac r3, XSLFSheet r4) {
        super((ac) ZeusTransformUtils.wrapperContextForParams(r3, ac.class, "com.obric.memorydata.plugin"), r4);
    }

    /* JADX INFO: renamed from: lambda$K0P-2yFFEgclQ6HvYPlY-YDjEm8, reason: not valid java name */
    public static /* synthetic */ g m3190lambda$K0P2yFFEgclQ6HvYPlYYDjEm8(e r0) {
        return parse(r0);
    }

    private static g parse(e r2) {
        e r3 = (e) ZeusTransformUtils.wrapperContextForParams(r2, e.class, "com.obric.memorydata.plugin");
        ac r4 = (ac) ZeusTransformUtils.preCheckCast(ac.f19203a.parse(r3), ac.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L7;
        return null;
    L7:
        return r4.getBlipFill();
    }

    public f getBlip() {
        return getBlipFill().getBlip();
    }

    public g getBlipFill() {
        g r0 = ((ac) ZeusTransformUtils.preCheckCast(getXmlObject(), ac.class, "com.obric.memorydata.plugin")).getBlipFill();
        if (r0 == null) goto L9;
        return r0;
    L9:
        return (g) ZeusTransformUtils.preCheckCast(XPathHelper.selectProperty(getXmlObject(), g.class, $$Lambda$XSLFPictureShape$K0P2yFFEgclQ6HvYPlYYDjEm8.INSTANCE, new QName[][]{BLIP_FILL}), g.class, "com.obric.memorydata.plugin");
    L7:
        return null;
    }

    public String getBlipId() {
        f r2 = getBlip();
        if (r2 == null) goto L9;
        String r3 = r2.getEmbed();
        if (r3.isEmpty() == false) goto L8;
        return null;
    L8:
        return r3;
    L9:
        return null;
    }

    public XSLFPictureData getPictureData() {
        if (this._data != null) goto L10;
        String r0 = getBlipId();
        if (r0 != null) goto L8;
        return null;
    L8:
        this._data = (XSLFPictureData) ZeusTransformUtils.preCheckCast(getSheet().getRelationById(r0), XSLFPictureData.class, "com.obric.memorydata.plugin");
    L10:
        return this._data;
    }
}
