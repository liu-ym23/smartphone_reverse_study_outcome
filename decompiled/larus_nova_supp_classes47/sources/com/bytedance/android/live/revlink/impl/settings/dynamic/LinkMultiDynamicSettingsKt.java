package com.bytedance.android.live.revlink.impl.settings.dynamic;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class LinkMultiDynamicSettingsKt {
    public static final Lazy a = null;
    public static final String b = null;
    public static final String c = null;

    public static final int a() {
        return ((Number) a.getValue()).intValue();
    }

    static {
        a = LazyKt.lazy(LinkMultiDynamicSettingsKt$timeEventCnt$2.INSTANCE);
        b = "{\n\t\"lynx_url\": \"sslocal://webcast_lynxview?bdhm_pid=multi_dynamic_central&url=https%3A%2F%2Flf-webcast-gr-sourcecdn.bytegecko.com%2Fobj%2Fbyte-gurd-source-gr%2Fwebcast%2Fmono%2Flynx%2Frevenue_pk_hybrid_douyin%2Fpages%2Fmulti_dynamic_central%2Ftemplate.js%3Flive_pk_enable_lynx_title%3D1\",\n\t\"tag\": \"dynamic_central\",\n\t\"height_radio\": 1.6,\n\t\"width_radio\": 1.0,\n\t\"horizontal_align\": 2,\n\t\"vertical_align\": 2,\n\t\"observer\": [\"pk_status\", \"remain_time\", \"change_screen\", \"link_anchor_info\", \"sei_data\", \"survival_remain_time\", \"survival_stage_index\", \"interact_start_time\"],\n\t\"init_data\": [\"pk_status\", \"remain_time\", \"link_anchor_info\", \"sei_data\", \"interact_start_time\"],\n\t\"to_front\": 1,\n\t\"super_view\": 1\n}";
        c = "{\n\t\"lynx_url\": \"sslocal://webcast_lynxview?bdhm_pid=rev_link&business_type=rev_link&group=rev_link&url=https%3A%2F%2Flf-webcast-gr-sourcecdn.bytegecko.com%2Fobj%2Fbyte-gurd-source-gr%2Fwebcast%2Fmono%2Flynx%2Frevenue_pk_hybrid_harmony%2Fpages%2Fdynamic_central_opt%2Ftemplate.js%3Flive_pk_enable_lynx_title%3D1%26live_pk_enable_team_pk_bar%3D1%26live_pk_enable_lynx_mic%3D1%26load_scene%3D7\",\n\t\"tag\": \"dynamic_central\",\n\t\"height_radio\": 1.6,\n\t\"width_radio\": 1.0,\n\t\"horizontal_align\": 2,\n\t\"vertical_align\": 2,\n\t\"observer\": [\"pk_status\", \"pk_result\", \"team_task\", \"remain_time\", \"clean_screen\", \"change_screen\", \"link_anchor_info\", \"sei_data\", \"survival_remain_time\", \"survival_stage_index\", \"interact_start_time\"],\n\t\"init_data\": [],\n\t\"to_front\": 1,\n\t\"super_view\": 1\n}";
    }
}
