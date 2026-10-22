package com.bytedance.android.live.broadcast.api.model.component;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@ProtoMessage("webcast.api.room.TopAreaComponent")
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/model/component/TopAreaComponent;", "", "()V", "audienceLimitSubComponent", "Lcom/bytedance/android/live/broadcast/api/model/component/AudienceLimitSubComponent;", "base", "Lcom/bytedance/android/live/broadcast/api/model/component/BaseComponentModel;", "coverSubComponent", "Lcom/bytedance/android/live/broadcast/api/model/component/CoverSubComponent;", "locationSubComponent", "Lcom/bytedance/android/live/broadcast/api/model/component/LocationSubComponent;", "titleSubComponent", "Lcom/bytedance/android/live/broadcast/api/model/component/TitleSubComponent;", "visibilitySubComponent", "Lcom/bytedance/android/live/broadcast/api/model/component/VisibilitySubComponent;", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TopAreaComponent implements h {

    @SerializedName("audience_limit_sub_component")
    public AudienceLimitSubComponent audienceLimitSubComponent;

    @SerializedName("base")
    public BaseComponentModel base;

    @SerializedName("cover_sub_component")
    public CoverSubComponent coverSubComponent;

    @SerializedName("location_sub_component")
    public LocationSubComponent locationSubComponent;

    @SerializedName("title_sub_component")
    public TitleSubComponent titleSubComponent;

    @SerializedName("visibility_sub_component")
    public VisibilitySubComponent visibilitySubComponent;

    public TopAreaComponent() {
    }

    public TopAreaComponent(g r5) {
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L13;
        switch(r2) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            default: goto L6;
        };
    L7:
        this.audienceLimitSubComponent = new AudienceLimitSubComponent(r5);
        goto L3
    L8:
        this.visibilitySubComponent = new VisibilitySubComponent(r5);
        goto L3
    L9:
        this.locationSubComponent = new LocationSubComponent(r5);
        goto L3
    L10:
        this.coverSubComponent = new CoverSubComponent(r5);
        goto L3
    L11:
        this.titleSubComponent = new TitleSubComponent(r5);
        goto L3
    L12:
        this.base = new BaseComponentModel(r5);
        goto L3
    L6:
        am3.h.e(r5);
        goto L3
    L13:
        r5.d(r0);
    }
}
