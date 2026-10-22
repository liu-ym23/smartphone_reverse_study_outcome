package com.ss.ugc.effectplatform.model.algorithm;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0011"}, d2 = {"Lcom/ss/ugc/effectplatform/model/algorithm/SingleAlgorithmModelResponse;", "", "data", "Lcom/ss/ugc/effectplatform/model/algorithm/ModelInfo;", "(Lcom/ss/ugc/effectplatform/model/algorithm/ModelInfo;)V", "getData", "()Lcom/ss/ugc/effectplatform/model/algorithm/ModelInfo;", "setData", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "effect_model_release"}, k = 1, mv = {1, 1, 16})
public final class SingleAlgorithmModelResponse {
    private ModelInfo data;

    public static /* synthetic */ SingleAlgorithmModelResponse copy$default(SingleAlgorithmModelResponse r0, ModelInfo r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.data;
    L6:
        return r0.copy(r1);
    }

    public final ModelInfo component1() {
        return this.data;
    }

    public final SingleAlgorithmModelResponse copy(ModelInfo r2) {
        return new SingleAlgorithmModelResponse(r2);
    }

    public boolean equals(Object r2) {
        if (this != r2) goto L4;
        return true;
    L4:
        if ((r2 instanceof SingleAlgorithmModelResponse) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.data, ((SingleAlgorithmModelResponse) r2).data) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public int hashCode() {
        ModelInfo r0 = this.data;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.hashCode();
    }

    public String toString() {
        return "SingleAlgorithmModelResponse(data=" + this.data + ")";
    }

    public final ModelInfo getData() {
        return this.data;
    }

    public SingleAlgorithmModelResponse(ModelInfo r1) {
        this.data = r1;
    }

    public final void setData(ModelInfo r1) {
        this.data = r1;
    }
}
