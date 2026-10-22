package com.bytedance.android.live.revlink.impl.settings.dynamic;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import vh7.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@JsonAdapter(MultiDynamicConfigSerializableObjectImpl.Adapter.class)
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/settings/dynamic/c;", "Lvh7/j;", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface c extends j<c> {

    @JsonAdapter(MultiDynamicConfigSerializableObjectImpl.Adapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @FieldName(name = "live_multi_dynamic_hub_load_enable")
    boolean I6();

    @FieldName(name = "live_multi_lynx_control_native_view_enable")
    boolean N1();

    @FieldName(name = "live_multi_preview_stream_support_dynamic_enable")
    boolean R8();

    @FieldName(name = "live_multi_pk_lynx_control_debug_mode")
    boolean getDebugMode();

    @FieldName(name = "live_multi_preview_lynx_control_native_view_enable")
    boolean h7();

    @FieldName(name = "live_multi_dynamic_hub_lynx_params")
    String m8();

    @FieldName(name = "live_multi_pk_dynamic_offset")
    boolean s6();
}
