package org.apache.xmlbeans.impl.values;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlLanguage;

/* JADX INFO: loaded from: classes7.dex */
public class XmlLanguageImpl extends JavaStringHolderEx implements XmlLanguage {
    public XmlLanguageImpl() {
        super(XmlLanguage.type, false);
    }

    public XmlLanguageImpl(SchemaType r3, boolean r4) {
        super((SchemaType) ZeusTransformUtils.wrapperContextForParams(r3, SchemaType.class, "com.obric.memorydata.plugin"), r4);
    }
}
