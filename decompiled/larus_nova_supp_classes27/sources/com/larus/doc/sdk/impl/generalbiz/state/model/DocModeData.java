package com.larus.doc.sdk.impl.generalbiz.state.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/larus/doc/sdk/impl/generalbiz/state/model/DocModeData;", "", "<init>", "()V", "mode", "", "getMode", "()Ljava/lang/Integer;", "setMode", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocModeData {

    @SerializedName("mode")
    private Integer mode;

    public DocModeData() {
        this.mode = 0;
    }

    public final Integer getMode() {
        return this.mode;
    }

    public final void setMode(Integer r1) {
        this.mode = r1;
    }
}
