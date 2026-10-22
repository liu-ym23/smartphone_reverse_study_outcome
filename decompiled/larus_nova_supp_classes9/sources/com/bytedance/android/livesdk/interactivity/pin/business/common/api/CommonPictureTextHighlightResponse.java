package com.bytedance.android.livesdk.interactivity.pin.business.common.api;

import am3.g;
import com.bytedance.android.livesdk.wrds.syncdata.highlight.HighlightItem;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@ProtoMessage("webcast.api.room.CommonPictureTextHighlightResponse.Response")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/pin/business/common/api/CommonPictureTextHighlightResponse;", BuildConfig.FLAVOR, "()V", "eventTime", BuildConfig.FLAVOR, "getEventTime", "()J", "setEventTime", "(J)V", "item", "Lcom/bytedance/android/livesdk/wrds/syncdata/highlight/HighlightItem;", "getItem", "()Lcom/bytedance/android/livesdk/wrds/syncdata/highlight/HighlightItem;", "setItem", "(Lcom/bytedance/android/livesdk/wrds/syncdata/highlight/HighlightItem;)V", "skipReview", BuildConfig.FLAVOR, "getSkipReview", "()I", "setSkipReview", "(I)V", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommonPictureTextHighlightResponse implements h {

    @SerializedName("event_time")
    protected long eventTime;

    @SerializedName("item")
    protected HighlightItem item;

    @SerializedName("skip_review")
    protected int skipReview;

    public CommonPictureTextHighlightResponse() {
    }

    public final long getEventTime() {
        return this.eventTime;
    }

    public final HighlightItem getItem() {
        return this.item;
    }

    public final int getSkipReview() {
        return this.skipReview;
    }

    public CommonPictureTextHighlightResponse(g r5) {
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
        this.skipReview = (int) r5.j();
        goto L3
    L11:
        am3.h.e(r5);
        goto L3
    L15:
        r5.d(r0);
    }

    public final void setEventTime(long r1) {
        this.eventTime = r1;
    }

    public final void setItem(HighlightItem r1) {
        this.item = r1;
    }

    public final void setSkipReview(int r1) {
        this.skipReview = r1;
    }
}
