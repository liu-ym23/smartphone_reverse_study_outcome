package com.bytedance.android.livesdk.config;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@JsonAdapter(LivePanelFirstFrameOptConfigSerializableObjectImpl.Adapter.class)
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/config/t61;", "Lvh7/j;", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface t61 extends vh7.j<t61> {

    @JsonAdapter(LivePanelFirstFrameOptConfigSerializableObjectImpl.Adapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @FieldName(name = "order_song_panel_default_count_per_page")
    int L6();

    @FieldName(name = "linked_panel_memory_leak_fix")
    boolean O3();

    @FieldName(name = "order_song_panel_first_load_count_per_page")
    int R6();

    @FieldName(name = "banner_widget_delay_load_time")
    long a3();

    @FieldName(name = "linked_invite_panel_count_per_page")
    long d1();

    @FieldName(name = "linked_panel_delay_load_time")
    long f3();

    @FieldName(name = "linked_apply_panel_count_per_page")
    long f7();

    @FieldName(name = "total_switch")
    boolean getTotalSwitch();

    @FieldName(name = "enable_linked_panel_opt")
    boolean m5();

    @FieldName(name = "enable_order_song_panel_opt")
    boolean z6();
}
