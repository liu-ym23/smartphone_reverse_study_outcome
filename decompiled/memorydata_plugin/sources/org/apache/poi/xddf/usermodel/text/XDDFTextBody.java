package org.apache.poi.xddf.usermodel.text;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.openxmlformats.schemas.drawingml.x2006.main.df;

/* JADX INFO: loaded from: classes7.dex */
public class XDDFTextBody {
    private df _body;
    private TextContainer _parent;

    public XDDFTextBody(TextContainer r4) {
        this((TextContainer) ZeusTransformUtils.wrapperContextForParams(r4, TextContainer.class, "com.obric.memorydata.plugin"), (df) ZeusTransformUtils.preCheckCast(df.f18850a.newInstance(), df.class, "com.obric.memorydata.plugin"));
    }

    public XDDFTextBody(TextContainer r3, df r4) {
        TextContainer r5 = (TextContainer) ZeusTransformUtils.wrapperContextForParams(r3, TextContainer.class, "com.obric.memorydata.plugin");
        df r6 = (df) ZeusTransformUtils.wrapperContextForParams(r4, df.class, "com.obric.memorydata.plugin");
        this._parent = r5;
        this._body = r6;
    }

    public df getXmlObject() {
        return this._body;
    }
}
