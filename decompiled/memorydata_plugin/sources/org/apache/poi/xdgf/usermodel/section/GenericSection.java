package org.apache.poi.xdgf.usermodel.section;

import com.microsoft.schemas.office.visio.x2012.main.q;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.xdgf.usermodel.XDGFSheet;

/* JADX INFO: loaded from: classes7.dex */
public class GenericSection extends XDGFSection {
    public GenericSection(q r3, XDGFSheet r4) {
        super((q) ZeusTransformUtils.wrapperContextForParams(r3, q.class, "com.obric.memorydata.plugin"), r4);
    }
}
