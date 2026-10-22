package com.bytedance.android.live.base.model.ad;

import am3.g;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@ProtoMessage("webcast.api.feed.AdExtra")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/base/model/ad/AdExtra;", "", "()V", "rawData", "", "getRawAdData", "Lcom/bytedance/android/live/base/model/ad/LiveAdRawData;", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AdExtra implements h {

    @SerializedName("raw_data")
    public String rawData;

    public AdExtra() {
    }

    public AdExtra(g r5) {
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L9;
        if (r2 != 1) goto L7;
        this.rawData = am3.h.c(r5);
        goto L3
    L7:
        am3.h.e(r5);
        goto L3
    L9:
        r5.d(r0);
    }

    public final LiveAdRawData getRawAdData() {
        if (this.rawData != null) goto L9;
        return null;
    L9:
        return (LiveAdRawData) GsonHelper.get().fromJson(this.rawData, LiveAdRawData.class);
    L11:
        return null;
    }
}
