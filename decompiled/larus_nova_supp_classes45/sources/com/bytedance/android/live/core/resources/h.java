package com.bytedance.android.live.core.resources;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@JsonAdapter(LokiExtraKtSerializableObjectImpl.Adapter.class)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/core/resources/h;", "Lvh7/j;", "a", "b", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface h extends vh7.j<h> {

    @JsonAdapter(LokiExtraKt_AudioGraphSerializableObjectImpl.Adapter.class)
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/core/resources/h$a;", "Lvh7/j;", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public interface a extends vh7.j<a> {

        /* JADX INFO: renamed from: com.bytedance.android.live.core.resources.h$a$a, reason: collision with other inner class name */
        @JsonAdapter(LokiExtraKt_AudioGraphSerializableObjectImpl.Adapter.class)
        @Metadata(k = 3, mv = {1, 5, 1})
        public static final class C0150a {
        }
    }

    @JsonAdapter(LokiExtraKt_BefViewRenderSizeSerializableObjectImpl.Adapter.class)
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/core/resources/h$b;", "Lvh7/j;", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public interface b extends vh7.j<b> {

        @JsonAdapter(LokiExtraKt_BefViewRenderSizeSerializableObjectImpl.Adapter.class)
        @Metadata(k = 3, mv = {1, 5, 1})
        public static final class a {
        }
    }

    @JsonAdapter(LokiExtraKtSerializableObjectImpl.Adapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class c {
    }

    @FieldName(name = "should_multi_frame")
    boolean Y7();

    @FieldName(name = "gift_duration")
    long getDuration();

    @FieldName(name = "gift_type")
    String getGiftType();

    @FieldName(name = "model_names#setter")
    void h4(String r1);

    @FieldName(name = "model_names")
    String l3();

    @FieldName(name = "requirements#setter")
    void n2(List<String> r1);

    @FieldName(name = "requirements")
    List<String> o8();
}
