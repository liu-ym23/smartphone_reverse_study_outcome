package com.bytedance.android.live.liveinteract.plantform.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0007\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\"\u0010\u0003\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R$\u0010\u000f\u001a\u0004\u0018\u00010\t8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u000e\u0010\b\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR$\u0010\u0016\u001a\u0004\u0018\u00010\u00108&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0015\u0010\b\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/model/g;", "Lvh7/c;", "", "isInWaiting", "()Z", "setInWaiting", "(Z)V", "isInWaiting$annotations", "()V", "Lcom/bytedance/android/livesdk/link/model/bridge/j1;", "getMediaInfo", "()Lcom/bytedance/android/livesdk/link/model/bridge/j1;", "setMediaInfo", "(Lcom/bytedance/android/livesdk/link/model/bridge/j1;)V", "getMediaInfo$annotations", "mediaInfo", "", "getRtcAppId", "()Ljava/lang/String;", "setRtcAppId", "(Ljava/lang/String;)V", "getRtcAppId$annotations", "rtcAppId", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface g extends vh7.c<g> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "media_info")
    com.bytedance.android.livesdk.link.model.bridge.j1 getMediaInfo();

    @FieldName(name = "oner_appid")
    String getRtcAppId();

    @FieldName(name = "is_in_waiting")
    boolean isInWaiting();

    @FieldName(name = "is_in_waiting#setter")
    void setInWaiting(boolean r1);

    @FieldName(name = "media_info#setter")
    void setMediaInfo(com.bytedance.android.livesdk.link.model.bridge.j1 r1);

    @FieldName(name = "oner_appid#setter")
    void setRtcAppId(String r1);
}
