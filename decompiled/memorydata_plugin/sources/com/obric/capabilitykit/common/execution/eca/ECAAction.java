package com.obric.capabilitykit.common.execution.eca;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0000H\u0016R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\t\u0010\u0005\"\u0004\b\n\u0010\u0007R\u001e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\fX¦\u000e¢\u0006\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00130\u0012X¦\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/obric/capabilitykit/common/execution/eca/ECAAction;", "Lcom/obric/capabilitykit/common/execution/eca/ECAModifiable;", "actionName", "", "getActionName", "()Ljava/lang/String;", "setActionName", "(Ljava/lang/String;)V", "ecaId", "getEcaId", "setEcaId", "impls", "", "getImpls", "()Ljava/util/List;", "setImpls", "(Ljava/util/List;)V", "inputParams", "", "Lcom/obric/capabilitykit/common/execution/eca/ECAInputParam;", "getInputParams", "()Ljava/util/Map;", "setInputParams", "(Ljava/util/Map;)V", "mergeWith", "", "withAnother", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface ECAAction extends ECAModifiable {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class DefaultImpls {
        public static boolean isDirty(ECAAction r2) {
            return ECAModifiable.DefaultImpls.isDirty((ECAAction) ZeusTransformUtils.wrapperContextForParams(r2, ECAAction.class, "com.obric.memorydata.plugin"));
        }

        public static void mergeWith(ECAAction r2, ECAAction r3) {
            ECAAction r4 = (ECAAction) ZeusTransformUtils.wrapperContextForParams(r2, ECAAction.class, "com.obric.memorydata.plugin");
            ECAAction r5 = (ECAAction) ZeusTransformUtils.wrapperContextForParams(r3, ECAAction.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "withAnother");
            if (Intrinsics.areEqual(r4.getActionName(), r5.getActionName()) == true) goto L5;
            return;
        L5:
            r4.getInputParams().putAll(r5.getInputParams());
        }
    }

    String getActionName();

    String getEcaId();

    List<String> getImpls();

    Map<String, ECAInputParam> getInputParams();

    void mergeWith(ECAAction r1);

    void setActionName(String r1);

    void setEcaId(String r1);

    void setImpls(List<String> r1);

    void setInputParams(Map<String, ECAInputParam> r1);
}
