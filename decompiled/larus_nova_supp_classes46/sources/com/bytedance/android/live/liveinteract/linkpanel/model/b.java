package com.bytedance.android.live.liveinteract.linkpanel.model;

import com.bytedance.android.livesdk.chatroom.model.interact.s0;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R$\u0010\t\u001a\u0004\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R$\u0010\r\u001a\u0004\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\f\u0010\b\u001a\u0004\b\n\u0010\u0004\"\u0004\b\u000b\u0010\u0006R\"\u0010\u0014\u001a\u00020\u000e8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0013\u0010\b\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u001b\u001a\u0004\u0018\u00010\u00158&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001a\u0010\b\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/live/liveinteract/linkpanel/model/b;", "Lvh7/c;", "", "getRtcExtInfo", "()Ljava/lang/String;", "setRtcExtInfo", "(Ljava/lang/String;)V", "getRtcExtInfo$annotations", "()V", "rtcExtInfo", "getLiveCoreExtInfo", "setLiveCoreExtInfo", "getLiveCoreExtInfo$annotations", "liveCoreExtInfo", "", "getTargetUiLayout", "()J", "setTargetUiLayout", "(J)V", "getTargetUiLayout$annotations", "targetUiLayout", "Lcom/bytedance/android/livesdk/chatroom/model/interact/s0;", "getCastInfo", "()Lcom/bytedance/android/livesdk/chatroom/model/interact/s0;", "setCastInfo", "(Lcom/bytedance/android/livesdk/chatroom/model/interact/s0;)V", "getCastInfo$annotations", "castInfo", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface b extends c<b> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    /* synthetic */ e castTo(Class r1);

    /* synthetic */ e castToOrNull(Class r1);

    @FieldName(name = "screen_cast_info")
    s0 getCastInfo();

    @FieldName(name = "live_core_ext_info")
    String getLiveCoreExtInfo();

    @FieldName(name = "rtc_ext_info")
    String getRtcExtInfo();

    @FieldName(name = "target_ui_layout")
    long getTargetUiLayout();

    @FieldName(name = "screen_cast_info#setter")
    void setCastInfo(s0 r1);

    @FieldName(name = "live_core_ext_info#setter")
    void setLiveCoreExtInfo(String r1);

    @FieldName(name = "rtc_ext_info#setter")
    void setRtcExtInfo(String r1);

    @FieldName(name = "target_ui_layout#setter")
    void setTargetUiLayout(long r1);
}
