package org.apache.xmlbeans.impl.schema;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.QNameSet;
import org.apache.xmlbeans.SchemaAttributeModel;
import org.apache.xmlbeans.SchemaLocalAttribute;

/* JADX INFO: loaded from: classes7.dex */
public class SchemaAttributeModelImpl implements SchemaAttributeModel {
    private static final SchemaLocalAttribute[] EMPTY_SLA_ARRAY = null;
    private Map<QName, SchemaLocalAttribute> attrMap;
    private int wcProcess;
    private QNameSet wcSet;

    static {
        EMPTY_SLA_ARRAY = new SchemaLocalAttribute[0];
    }

    public SchemaAttributeModelImpl() {
        this.attrMap = new LinkedHashMap();
        this.wcSet = null;
        this.wcProcess = 0;
    }

    public void addAttribute(SchemaLocalAttribute r3) {
        SchemaLocalAttribute r4 = (SchemaLocalAttribute) ZeusTransformUtils.wrapperContextForParams(r3, SchemaLocalAttribute.class, "com.obric.memorydata.plugin");
        this.attrMap.put(r4.getName(), r4);
    }

    @Override // org.apache.xmlbeans.SchemaAttributeModel
    public SchemaLocalAttribute getAttribute(QName r2) {
        return (SchemaLocalAttribute) ZeusTransformUtils.preCheckCast(this.attrMap.get(r2), SchemaLocalAttribute.class, "com.obric.memorydata.plugin");
    }

    @Override // org.apache.xmlbeans.SchemaAttributeModel
    public SchemaLocalAttribute[] getAttributes() {
        return (SchemaLocalAttribute[]) ZeusTransformUtils.preCheckCast((SchemaLocalAttribute[]) ZeusTransformUtils.preCheckCast(this.attrMap.values().toArray(EMPTY_SLA_ARRAY), SchemaLocalAttribute[].class, "com.obric.memorydata.plugin"), SchemaLocalAttribute[].class, "com.obric.memorydata.plugin");
    }

    @Override // org.apache.xmlbeans.SchemaAttributeModel
    public int getWildcardProcess() {
        return this.wcProcess;
    }

    @Override // org.apache.xmlbeans.SchemaAttributeModel
    public QNameSet getWildcardSet() {
        QNameSet r0 = this.wcSet;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return QNameSet.EMPTY;
    }

    public void setWildcardProcess(int r1) {
        this.wcProcess = r1;
    }

    public void setWildcardSet(QNameSet r1) {
        this.wcSet = r1;
    }
}
