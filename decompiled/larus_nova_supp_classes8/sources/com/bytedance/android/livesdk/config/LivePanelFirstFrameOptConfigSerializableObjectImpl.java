package com.bytedance.android.livesdk.config;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000e\u0018\u00002\u00020\u0001:\u0001!B\u0007¢\u0006\u0004\b\u001f\u0010 R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001a\u0010\u000e\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011R\u001a\u0010\u0015\u001a\u00020\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u0016\u001a\u0004\b\u001a\u0010\u0018R\u001a\u0010\u001b\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u000f\u001a\u0004\b\u001c\u0010\u0011R\u001a\u0010\u001d\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u000f\u001a\u0004\b\u001e\u0010\u0011¨\u0006\""}, d2 = {"Lcom/bytedance/android/livesdk/config/LivePanelFirstFrameOptConfigSerializableObjectImpl;", "Lcom/bytedance/android/livesdk/config/t61;", "", "totalSwitch", "Z", "getTotalSwitch", "()Z", "enableLinkedPanelOptValue", "m5", "enableOrderSongPanelOptValue", "z6", "linkedPanelMemoryLeakFixValue", "O3", "", "linkedApplyPanelCountPerPage", "J", "f7", "()J", "linkedInvitePanelCountPerPage", "d1", "", "orderSongPanelDefaultCountPerPage", "I", "L6", "()I", "orderSongPanelFirstLoadCountPerPage", "R6", "linkedPanelDelayLoadTime", "f3", "bannerWidgetDelayLoadTime", "a3", "<init>", "()V", "Adapter", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LivePanelFirstFrameOptConfigSerializableObjectImpl implements t61 {

    @SerializedName("banner_widget_delay_load_time")
    private final long bannerWidgetDelayLoadTime;

    @SerializedName("enable_linked_panel_opt")
    private final boolean enableLinkedPanelOptValue;

    @SerializedName("enable_order_song_panel_opt")
    private final boolean enableOrderSongPanelOptValue;

    @SerializedName("linked_apply_panel_count_per_page")
    private final long linkedApplyPanelCountPerPage;

    @SerializedName("linked_invite_panel_count_per_page")
    private final long linkedInvitePanelCountPerPage;

    @SerializedName("linked_panel_delay_load_time")
    private final long linkedPanelDelayLoadTime;

    @SerializedName("linked_panel_memory_leak_fix")
    private final boolean linkedPanelMemoryLeakFixValue;

    @SerializedName("order_song_panel_default_count_per_page")
    private final int orderSongPanelDefaultCountPerPage;

    @SerializedName("order_song_panel_first_load_count_per_page")
    private final int orderSongPanelFirstLoadCountPerPage;

    @SerializedName("total_switch")
    private final boolean totalSwitch;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/config/LivePanelFirstFrameOptConfigSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(LivePanelFirstFrameOptConfigSerializableObjectImpl.class);
        }
    }

    public LivePanelFirstFrameOptConfigSerializableObjectImpl() {
        this.totalSwitch = false;
        this.enableLinkedPanelOptValue = true;
        this.enableOrderSongPanelOptValue = true;
        this.linkedPanelMemoryLeakFixValue = true;
        this.linkedApplyPanelCountPerPage = 10;
        this.linkedInvitePanelCountPerPage = 15;
        this.orderSongPanelDefaultCountPerPage = 20;
        this.orderSongPanelFirstLoadCountPerPage = 8;
        this.linkedPanelDelayLoadTime = 3000;
        this.bannerWidgetDelayLoadTime = 1000;
    }

    @Override // com.bytedance.android.livesdk.config.t61
    public final int L6() {
        return this.orderSongPanelDefaultCountPerPage;
    }

    @Override // com.bytedance.android.livesdk.config.t61
    public final boolean O3() {
        return this.linkedPanelMemoryLeakFixValue;
    }

    @Override // com.bytedance.android.livesdk.config.t61
    public final int R6() {
        return this.orderSongPanelFirstLoadCountPerPage;
    }

    @Override // com.bytedance.android.livesdk.config.t61
    public final long a3() {
        return this.bannerWidgetDelayLoadTime;
    }

    @Override // com.bytedance.android.livesdk.config.t61
    public final long d1() {
        return this.linkedInvitePanelCountPerPage;
    }

    @Override // com.bytedance.android.livesdk.config.t61
    public final long f3() {
        return this.linkedPanelDelayLoadTime;
    }

    @Override // com.bytedance.android.livesdk.config.t61
    public final long f7() {
        return this.linkedApplyPanelCountPerPage;
    }

    @Override // com.bytedance.android.livesdk.config.t61
    public final boolean getTotalSwitch() {
        return this.totalSwitch;
    }

    @Override // com.bytedance.android.livesdk.config.t61
    public final boolean m5() {
        return this.enableLinkedPanelOptValue;
    }

    @Override // com.bytedance.android.livesdk.config.t61
    public final boolean z6() {
        return this.enableOrderSongPanelOptValue;
    }
}
