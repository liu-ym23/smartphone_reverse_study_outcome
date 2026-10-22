package org.apache.poi.xslf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import javax.xml.namespace.QName;
import org.apache.poi.ooxml.util.XPathHelper;
import org.apache.poi.sl.usermodel.Placeholder;
import org.apache.poi.sl.usermodel.PlaceholderDetails;
import org.openxmlformats.schemas.presentationml.x2006.main.a;
import org.openxmlformats.schemas.presentationml.x2006.main.ae;

/* JADX INFO: loaded from: classes7.dex */
public class XSLFPlaceholderDetails implements PlaceholderDetails {
    private static final QName[] NV_CONTAINER = null;
    private static final QName[] NV_PROPS = null;
    private ae _ph;
    private final XSLFShape shape;

    static {
        NV_CONTAINER = new QName[]{new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "nvSpPr"), new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "nvCxnSpPr"), new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "nvGrpSpPr"), new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "nvPicPr"), new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "nvGraphicFramePr")};
        NV_PROPS = new QName[]{new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "nvPr")};
    }

    XSLFPlaceholderDetails(XSLFShape r1) {
        this.shape = r1;
    }

    private a getNvProps() {
        return (a) ZeusTransformUtils.preCheckCast(XPathHelper.selectProperty(this.shape.getXmlObject(), a.class, null, new QName[][]{NV_CONTAINER, NV_PROPS}), a.class, "com.obric.memorydata.plugin");
    L5:
        return null;
    }

    ae getCTPlaceholder(boolean r3) {
        ae r0 = this._ph;
        if (r0 == null) goto L5;
        return r0;
    L5:
        a r1 = getNvProps();
        if (r1 != null) goto L10;
        return null;
    L10:
        if (r1.isSetPh() == true) goto L14;
        if (r3 == false) goto L14;
        ae r4 = r1.addNewPh();
    L15:
        this._ph = r4;
        return r4;
    L14:
        r4 = r1.getPh();
        goto L15
    }

    public Placeholder getPlaceholder() {
        ae r1 = getCTPlaceholder(false);
        if (r1 != null) goto L5;
        return null;
    L5:
        if (r1.isSetType() == true) goto L10;
        if (r1.isSetIdx() == true) goto L10;
        return null;
    L10:
        return Placeholder.lookupOoxml(r1.getType().intValue());
    }
}
