package org.apache.poi.xssf.usermodel;

import androidx.core.net.MailTo;
import com.bytedance.apm6.util.constant.ReportConsts;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.common.usermodel.HyperlinkType;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.cg;

/* JADX INFO: loaded from: classes7.dex */
public class XSSFHyperlink {
    private final cg _ctHyperlink;
    private final PackageRelationship _externalRel;
    private String _location;
    private final HyperlinkType _type;

    public XSSFHyperlink(cg r3, PackageRelationship r4) {
        cg r5 = (cg) ZeusTransformUtils.wrapperContextForParams(r3, cg.class, "com.obric.memorydata.plugin");
        this._ctHyperlink = r5;
        this._externalRel = r4;
        if (r4 == null) goto L5;
        this._location = r4.getTargetURI().toString();
        if (r5.getLocation() == null) goto L16;
        this._location += "#" + r5.getLocation();
    L16:
        if (this._location.startsWith("http://") == false) goto L18;
    L26:
        HyperlinkType r6 = HyperlinkType.URL;
    L27:
        this._type = r6;
        return;
    L18:
        if (this._location.startsWith(ReportConsts.HTTPS) == true) goto L26;
        if (this._location.startsWith("ftp://") == true) goto L26;
        if (this._location.startsWith(MailTo.MAILTO_SCHEME) == false) goto L25;
        r6 = HyperlinkType.EMAIL;
        goto L27
    L25:
        r6 = HyperlinkType.FILE;
        goto L27
    L5:
        if (r5.getLocation() == null) goto L8;
        this._type = HyperlinkType.DOCUMENT;
        this._location = r5.getLocation();
        return;
    L8:
        if (r5.getId() != null) goto L11;
        r6 = HyperlinkType.DOCUMENT;
        goto L27
    L11:
        throw new IllegalStateException("The hyperlink for cell " + r5.getRef() + " references relation " + r5.getId() + ", but that didn't exist!");
    }

    public void generateRelationIfNeeded(PackagePart r3) {
        if (this._externalRel == null) goto L5;
        return;
    L5:
        if (needsRelationToo() == false) goto L9;
        PackageRelationship r4 = r3.addExternalRelationship(this._location, XSSFRelation.SHEET_HYPERLINKS.getRelation());
        this._ctHyperlink.setId(r4.getId());
        return;
    }

    public cg getCTHyperlink() {
        return this._ctHyperlink;
    }

    public HyperlinkType getType() {
        return this._type;
    }

    public boolean needsRelationToo() {
        if (this._type == HyperlinkType.DOCUMENT) goto L5;
        return true;
    L5:
        return false;
    }
}
