package com.larus.slides.sdk.impl.plugins.selection;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0004\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/larus/slides/sdk/impl/plugins/selection/RefSelectData;", "", "<init>", "()V", "isRef", "", "()Ljava/lang/Boolean;", "setRef", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class RefSelectData {

    @SerializedName("isRef")
    private Boolean isRef;

    public RefSelectData() {
        this.isRef = Boolean.FALSE;
    }

    public final Boolean isRef() {
        return this.isRef;
    }

    public final void setRef(Boolean r1) {
        this.isRef = r1;
    }
}
