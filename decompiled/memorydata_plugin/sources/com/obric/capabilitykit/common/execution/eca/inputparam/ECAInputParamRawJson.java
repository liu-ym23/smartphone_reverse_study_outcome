package com.obric.capabilitykit.common.execution.eca.inputparam;

import com.google.gson.JsonElement;
import com.obric.capabilitykit.common.execution.eca.ECAInputParam;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/obric/capabilitykit/common/execution/eca/inputparam/ECAInputParamRawJson;", "Lcom/obric/capabilitykit/common/execution/eca/ECAInputParam;", "rawJson", "Lcom/google/gson/JsonElement;", "(Lcom/google/gson/JsonElement;)V", "getRawJson", "()Lcom/google/gson/JsonElement;", "setRawJson", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public class ECAInputParamRawJson extends ECAInputParam {
    private JsonElement rawJson;

    /* JADX WARN: Multi-variable type inference failed */
    public ECAInputParamRawJson() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public ECAInputParamRawJson(JsonElement r1) {
        this.rawJson = r1;
    }

    public /* synthetic */ ECAInputParamRawJson(JsonElement r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        this(r1);
    }

    public final JsonElement getRawJson() {
        return this.rawJson;
    }

    public final void setRawJson(JsonElement r1) {
        this.rawJson = r1;
    }
}
