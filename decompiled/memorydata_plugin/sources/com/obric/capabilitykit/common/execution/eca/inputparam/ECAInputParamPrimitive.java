package com.obric.capabilitykit.common.execution.eca.inputparam;

import com.bytedance.crash.entity.EventBody;
import com.obric.capabilitykit.common.execution.eca.ECAInputParam;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/obric/capabilitykit/common/execution/eca/inputparam/ECAInputParamPrimitive;", "Lcom/obric/capabilitykit/common/execution/eca/ECAInputParam;", EventBody.KEY_VALUE, "", "(Ljava/lang/Object;)V", "getValue", "()Ljava/lang/Object;", "setValue", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ECAInputParamPrimitive extends ECAInputParam {
    private Object value;

    public ECAInputParamPrimitive() {
        DefaultConstructorMarker r0 = null;
        this(r0, 1, r0);
    }

    public ECAInputParamPrimitive(Object r1) {
        this.value = r1;
    }

    public /* synthetic */ ECAInputParamPrimitive(Object r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        this(r1);
    }

    public final Object getValue() {
        return this.value;
    }

    public final void setValue(Object r1) {
        this.value = r1;
    }
}
