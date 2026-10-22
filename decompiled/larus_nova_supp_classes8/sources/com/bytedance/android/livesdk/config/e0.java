package com.bytedance.android.livesdk.config;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@JsonAdapter(AssetManualCleanCacheConfigSerializableObjectImpl.Adapter.class)
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/config/e0;", "Lvh7/j;", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface e0 extends vh7.j<e0> {

    @JsonAdapter(AssetManualCleanCacheConfigSerializableObjectImpl.Adapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @FieldName(name = "expire_duration")
    long C0();

    @FieldName(name = "app_on_device_percentage")
    int F1();

    @FieldName(name = "hint_count")
    int H5();

    @FieldName(name = "max_room_member_count")
    int Q4();

    @FieldName(name = "enter_room_wait_hint_duration")
    int Q8();

    @FieldName(name = "max_loading_duration")
    int T7();

    @FieldName(name = "clean_gap")
    long T8();

    @FieldName(name = "min_asset_size")
    int d4();

    @FieldName(name = "enable")
    boolean getEnable();
}
