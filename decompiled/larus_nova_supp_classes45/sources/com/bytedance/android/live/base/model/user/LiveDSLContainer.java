package com.bytedance.android.live.base.model.user;

import com.bytedance.android.livesdkapi.depend.model.live.LiveDSLModel;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/base/model/user/LiveDSLContainer;", "", "()V", "dslModel", "Lcom/bytedance/android/livesdkapi/depend/model/live/LiveDSLModel;", "getDslModel", "()Lcom/bytedance/android/livesdkapi/depend/model/live/LiveDSLModel;", "setDslModel", "(Lcom/bytedance/android/livesdkapi/depend/model/live/LiveDSLModel;)V", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveDSLContainer implements vh7.h {

    @SerializedName("dsl_detail")
    protected LiveDSLModel dslModel;

    public LiveDSLContainer() {
    }

    public LiveDSLContainer(am3.g r5) {
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L9;
        if (r2 != 1) goto L7;
        this.dslModel = new LiveDSLModel(r5);
        goto L3
    L7:
        am3.h.e(r5);
        goto L3
    L9:
        r5.d(r0);
    }

    public final LiveDSLModel getDslModel() {
        return this.dslModel;
    }

    public final void setDslModel(LiveDSLModel r1) {
        this.dslModel = r1;
    }
}
