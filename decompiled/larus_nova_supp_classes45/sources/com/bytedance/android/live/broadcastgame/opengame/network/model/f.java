package com.bytedance.android.live.broadcastgame.opengame.network.model;

import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.x;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@ProtoMessage("webcast.data.CardImage")
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/network/model/f;", "", "<init>", "()V", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class f implements vh7.h {

    @SerializedName("customer_image")
    protected ImageModel _$$customImage;

    @SerializedName("default_image")
    protected ImageModel _$$defaultImage;

    public f() {
        this._$$customImage = null;
        this._$$defaultImage = null;
    }

    public f(am3.g r5) {
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L12;
        if (r2 != 1) goto L8;
        this._$$customImage = x.a(r5);
        goto L3
    L8:
        if (r2 != 2) goto L9;
        this._$$defaultImage = x.a(r5);
        goto L3
    L9:
        am3.h.e(r5);
        goto L3
    L12:
        r5.d(r0);
        if (this._$$customImage != null) goto L16;
        this._$$customImage = null;
    L16:
        if (this._$$defaultImage != null) goto L28;
        this._$$defaultImage = null;
        return;
    }

    public final ImageModel a() {
        return this._$$customImage;
    }

    public final ImageModel b() {
        return this._$$defaultImage;
    }
}
