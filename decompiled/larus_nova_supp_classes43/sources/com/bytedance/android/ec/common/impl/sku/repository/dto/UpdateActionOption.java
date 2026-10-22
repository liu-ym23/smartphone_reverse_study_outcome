package com.bytedance.android.ec.common.impl.sku.repository.dto;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005R\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/ec/common/impl/sku/repository/dto/UpdateActionOption;", "Ljava/io/Serializable;", "actions", "", "Lcom/bytedance/android/ec/common/impl/sku/repository/dto/APIAction;", "(Ljava/util/List;)V", "getActions", "()Ljava/util/List;", "ec-common-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class UpdateActionOption implements Serializable {

    @SerializedName("actions")
    private final List<APIAction> actions;

    public UpdateActionOption() {
        List r0 = null;
        this(r0, 1, r0);
    }

    public final List<APIAction> getActions() {
        return this.actions;
    }

    public UpdateActionOption(List<APIAction> r1) {
        this.actions = r1;
    }

    public /* synthetic */ UpdateActionOption(List r1, int r10, DefaultConstructorMarker r11) {
        if ((r10 & 1) == 0) goto L5;
        r1 = null;
    L5:
        this(r1);
    }
}
