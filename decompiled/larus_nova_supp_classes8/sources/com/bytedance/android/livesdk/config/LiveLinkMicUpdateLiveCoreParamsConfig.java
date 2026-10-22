package com.bytedance.android.livesdk.config;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@JsonAdapter(LiveLinkMicUpdateLiveCoreParamsConfigSerializableObjectImpl.Adapter.class)
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001a\u0010\u0007\u001a\u00020\u00028VX\u0097\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001a\u0010\n\u001a\u00020\u00028VX\u0097\u0004¢\u0006\f\u0012\u0004\b\t\u0010\u0006\u001a\u0004\b\b\u0010\u0004¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/config/LiveLinkMicUpdateLiveCoreParamsConfig;", "Lvh7/j;", "", "getAnchorEnable", "()Z", "getAnchorEnable$annotations", "()V", "anchorEnable", "getGuestEnable", "getGuestEnable$annotations", "guestEnable", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface LiveLinkMicUpdateLiveCoreParamsConfig extends vh7.j<LiveLinkMicUpdateLiveCoreParamsConfig> {

    @JsonAdapter(LiveLinkMicUpdateLiveCoreParamsConfigSerializableObjectImpl.Adapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @FieldName(name = "anchor_enable")
    boolean getAnchorEnable();

    @FieldName(name = "guest_enable")
    boolean getGuestEnable();
}
