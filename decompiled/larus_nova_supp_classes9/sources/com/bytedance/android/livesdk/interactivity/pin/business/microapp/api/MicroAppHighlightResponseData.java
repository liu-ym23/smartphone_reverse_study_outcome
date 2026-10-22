package com.bytedance.android.livesdk.interactivity.pin.business.microapp.api;

import am3.g;
import com.bytedance.android.livesdk.wrds.syncdata.highlight.HighlightItem;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@ProtoMessage("webcast.api.room.MicroAppHighlightResponse.Response")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/pin/business/microapp/api/MicroAppHighlightResponseData;", BuildConfig.FLAVOR, "()V", "eventTime", BuildConfig.FLAVOR, "item", "Lcom/bytedance/android/livesdk/wrds/syncdata/highlight/HighlightItem;", "skipReview", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MicroAppHighlightResponseData implements h {

    @SerializedName("event_time")
    public long eventTime;

    @SerializedName("item")
    public HighlightItem item;

    @SerializedName("skip_review")
    public long skipReview;

    public MicroAppHighlightResponseData() {
    }

    public MicroAppHighlightResponseData(g r5) {
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L15;
        if (r2 != 1) goto L8;
        this.eventTime = r5.j();
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this.item = new HighlightItem(r5);
        goto L3
    L10:
        if (r2 != 3) goto L11;
        this.skipReview = r5.j();
        goto L3
    L11:
        am3.h.e(r5);
        goto L3
    L15:
        r5.d(r0);
    }
}
