package com.bytedance.android.live.base.model.message;

import com.bytedance.android.livesdk.chatroom.model.interact.EnlargeGuestInfo;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001a\u0010\u0007\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R$\u0010\u000e\u001a\u0004\u0018\u00010\b8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\r\u0010\u0006\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0013\u001a\u00020\u000f8&X§\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u0006\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0018\u001a\u00020\u00148&X§\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\u0006\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u00148&X§\u0004¢\u0006\f\u0012\u0004\b\u001a\u0010\u0006\u001a\u0004\b\u0019\u0010\u0016¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/live/base/model/message/f6;", "Lvh7/c;", "", "getSource", "()I", "getSource$annotations", "()V", "source", "Lcom/bytedance/android/livesdk/chatroom/model/interact/EnlargeGuestInfo;", "getEnlargeGuestInfo", "()Lcom/bytedance/android/livesdk/chatroom/model/interact/EnlargeGuestInfo;", "setEnlargeGuestInfo", "(Lcom/bytedance/android/livesdk/chatroom/model/interact/EnlargeGuestInfo;)V", "getEnlargeGuestInfo$annotations", "enlargeGuestInfo", "", "get_enlargedUserId", "()J", "get_enlargedUserId$annotations", "_enlargedUserId", "", "get_enlargedOpenId", "()Ljava/lang/String;", "get_enlargedOpenId$annotations", "_enlargedOpenId", "getTrackingData", "getTrackingData$annotations", "trackingData", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface f6 extends vh7.c<f6> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "info")
    EnlargeGuestInfo getEnlargeGuestInfo();

    @FieldName(name = "source")
    int getSource();

    @FieldName(name = "tracking_data")
    String getTrackingData();

    @FieldName(name = "enlarged_openid")
    String get_enlargedOpenId();

    @FieldName(name = "enlarged_user_id")
    long get_enlargedUserId();

    @FieldName(name = "info#setter")
    void setEnlargeGuestInfo(EnlargeGuestInfo r1);
}
