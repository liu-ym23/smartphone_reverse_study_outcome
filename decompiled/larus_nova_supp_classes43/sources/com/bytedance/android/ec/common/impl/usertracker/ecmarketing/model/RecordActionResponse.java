package com.bytedance.android.ec.common.impl.usertracker.ecmarketing.model;

import com.bytedance.android.ec.model.api.CommerceBaseResponse;
import com.google.gson.annotations.SerializedName;
import hg.b;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bR*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/bytedance/android/ec/common/impl/usertracker/ecmarketing/model/RecordActionResponse;", "Lcom/bytedance/android/ec/model/api/CommerceBaseResponse;", "", "Lhg/b;", "switchList", "Ljava/util/List;", "getSwitchList", "()Ljava/util/List;", "setSwitchList", "(Ljava/util/List;)V", "<init>", "()V", "ec-common-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RecordActionResponse extends CommerceBaseResponse {

    @SerializedName("data")
    private List<b> switchList;

    public RecordActionResponse() {
    }

    public final List<b> getSwitchList() {
        return this.switchList;
    }

    public final void setSwitchList(List<b> r1) {
        this.switchList = r1;
    }
}
