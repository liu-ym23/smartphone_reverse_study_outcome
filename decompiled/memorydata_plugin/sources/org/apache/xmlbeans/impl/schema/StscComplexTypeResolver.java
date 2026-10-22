package org.apache.xmlbeans.impl.schema;

import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.QNameSet;
import org.apache.xmlbeans.QNameSetBuilder;
import org.apache.xmlbeans.SchemaAttributeModel;
import org.apache.xmlbeans.SchemaParticle;
import org.apache.xmlbeans.impl.common.QNameHelper;

/* JADX INFO: loaded from: classes7.dex */
public class StscComplexTypeResolver {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Map<QName, Integer> attributeCodeMap = null;
    private static final CodeForNameEntry[] attributeCodes = null;
    private static final Map<QName, Integer> particleCodeMap = null;
    private static final CodeForNameEntry[] particleCodes = null;

    private static class CodeForNameEntry {
        public int code;
        public QName name;

        CodeForNameEntry(QName r1, int r2) {
            this.name = r1;
            this.code = r2;
        }
    }

    static class WildcardResult {
        boolean hasWildcards;
        QNameSet typedWildcards;

        WildcardResult(QNameSet r1, boolean r2) {
            this.typedWildcards = r1;
            this.hasWildcards = r2;
        }
    }

    static {
        CodeForNameEntry[] r0 = {new CodeForNameEntry(QNameHelper.forLNS(LocationAnnotation.LightLocationType.LIGHT_LOCATION_ALL, "http://www.w3.org/2001/XMLSchema"), 1), new CodeForNameEntry(QNameHelper.forLNS("sequence", "http://www.w3.org/2001/XMLSchema"), 3), new CodeForNameEntry(QNameHelper.forLNS("choice", "http://www.w3.org/2001/XMLSchema"), 2), new CodeForNameEntry(QNameHelper.forLNS("element", "http://www.w3.org/2001/XMLSchema"), 4), new CodeForNameEntry(QNameHelper.forLNS("any", "http://www.w3.org/2001/XMLSchema"), 5), new CodeForNameEntry(QNameHelper.forLNS("group", "http://www.w3.org/2001/XMLSchema"), 100)};
        particleCodes = r0;
        particleCodeMap = (Map) ZeusTransformUtils.preCheckCast(Stream.of(r0).collect(Collectors.toMap($$Lambda$StscComplexTypeResolver$spjgqkGx3kq8B6cvLqOP8tNvcp8.INSTANCE, $$Lambda$StscComplexTypeResolver$iV8msqTSdBQOhsjVC3GPwL3nPsM.INSTANCE)), Map.class, "com.obric.memorydata.plugin");
        CodeForNameEntry[] r1 = {new CodeForNameEntry(QNameHelper.forLNS("attribute", "http://www.w3.org/2001/XMLSchema"), 100), new CodeForNameEntry(QNameHelper.forLNS("attributeGroup", "http://www.w3.org/2001/XMLSchema"), 101), new CodeForNameEntry(QNameHelper.forLNS("anyAttribute", "http://www.w3.org/2001/XMLSchema"), 102)};
        attributeCodes = r1;
        attributeCodeMap = (Map) ZeusTransformUtils.preCheckCast(Stream.of(r1).collect(Collectors.toMap($$Lambda$StscComplexTypeResolver$tuEmK7g8R8xCEq6Sl_87pv_DLAA.INSTANCE, $$Lambda$StscComplexTypeResolver$SvIIC8jRmxg2REzFC0eW3nzihqo.INSTANCE)), Map.class, "com.obric.memorydata.plugin");
    }

    public StscComplexTypeResolver() {
    }

    static /* synthetic */ QName lambda$static$4(CodeForNameEntry r0) {
        return r0.name;
    }

    static /* synthetic */ Integer lambda$static$5(CodeForNameEntry r0) {
        return Integer.valueOf(r0.code);
    }

    static /* synthetic */ QName lambda$static$6(CodeForNameEntry r0) {
        return r0.name;
    }

    static /* synthetic */ Integer lambda$static$7(CodeForNameEntry r0) {
        return Integer.valueOf(r0.code);
    }

    static WildcardResult summarizeAttrWildcards(SchemaAttributeModel r3) {
        SchemaAttributeModel r4 = (SchemaAttributeModel) ZeusTransformUtils.wrapperContextForParams(r3, SchemaAttributeModel.class, "com.obric.memorydata.plugin");
        if (r4.getWildcardProcess() != 0) goto L7;
        return new WildcardResult(QNameSet.EMPTY, false);
    L7:
        if (r4.getWildcardProcess() != 3) goto L11;
        return new WildcardResult(QNameSet.EMPTY, true);
    L11:
        return new WildcardResult(r4.getWildcardSet(), true);
    }

    static WildcardResult summarizeEltWildcards(SchemaParticle r5) {
        SchemaParticle r6 = (SchemaParticle) ZeusTransformUtils.wrapperContextForParams(r5, SchemaParticle.class, "com.obric.memorydata.plugin");
        int r0 = 0;
        if (r6 == null) goto L5;
        int r1 = r6.getParticleType();
        if (r1 != 1) goto L9;
    L22:
        QNameSetBuilder r2 = new QNameSetBuilder();
        boolean r3 = false;
    L24:
        if (r0 >= r6.countOfParticleChild()) goto L27;
        WildcardResult r4 = summarizeEltWildcards(r6.getParticleChild(r0));
        r2.addAll(r4.typedWildcards);
        r3 = r3 | r4.hasWildcards;
        r0 = r0 + 1;
        goto L24
    L27:
        return new WildcardResult(r2.toQNameSet(), r3);
    L9:
        if (r1 == 2) goto L22;
        if (r1 == 3) goto L22;
        if (r1 == 5) goto L17;
        return new WildcardResult(QNameSet.EMPTY, false);
    L17:
        if (r6.getWildcardProcess() != 3) goto L19;
        QNameSet r7 = QNameSet.EMPTY;
    L21:
        return new WildcardResult(r7, true);
    L19:
        r7 = r6.getWildcardSet();
        goto L21
    L5:
        return new WildcardResult(QNameSet.EMPTY, false);
    }
}
