package com.bytedance.android.livesdk.config;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@JsonAdapter(LinkMockConfigSerializableObjectImpl.Adapter.class)
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/config/t01;", "Lvh7/j;", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface t01 extends vh7.j<t01> {

    @JsonAdapter(LinkMockConfigSerializableObjectImpl.Adapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @FieldName(name = "enable_mock_permission_check_failed")
    boolean L5();

    @FieldName(name = "enable_mock_rtc_client_init_failed")
    boolean U();

    @FieldName(name = "enable_mock_rtc_client_start_failed")
    boolean c4();

    @FieldName(name = "enable_mock_live_client_init_failed")
    boolean e4();
}
