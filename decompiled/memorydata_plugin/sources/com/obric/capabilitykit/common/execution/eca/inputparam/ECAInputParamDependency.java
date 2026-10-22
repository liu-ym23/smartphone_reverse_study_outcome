package com.obric.capabilitykit.common.execution.eca.inputparam;

import com.obric.capabilitykit.common.execution.eca.ECAInputParam;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/obric/capabilitykit/common/execution/eca/inputparam/ECAInputParamDependency;", "Lcom/obric/capabilitykit/common/execution/eca/ECAInputParam;", "targetEcaId", "", "targetActionName", "dependedParamName", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDependedParamName", "()Ljava/lang/String;", "getTargetActionName", "getTargetEcaId", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ECAInputParamDependency extends ECAInputParam {
    private final String dependedParamName;
    private final String targetActionName;
    private final String targetEcaId;

    public ECAInputParamDependency() {
        this(null, null, null, 7, null);
    }

    public ECAInputParamDependency(String r1, String r2, String r3) {
        this.targetEcaId = r1;
        this.targetActionName = r2;
        this.dependedParamName = r3;
    }

    public /* synthetic */ ECAInputParamDependency(String r2, String r3, String r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = null;
    L11:
        this(r2, r3, r4);
    }

    public final String getDependedParamName() {
        return this.dependedParamName;
    }

    public final String getTargetActionName() {
        return this.targetActionName;
    }

    public final String getTargetEcaId() {
        return this.targetEcaId;
    }
}
