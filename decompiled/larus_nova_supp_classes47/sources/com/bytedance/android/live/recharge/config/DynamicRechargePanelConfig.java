package com.bytedance.android.live.recharge.config;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import vh7.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@JsonAdapter(DynamicRechargePanelConfigSerializableObjectImpl.Adapter.class)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/recharge/config/DynamicRechargePanelConfig;", "Lvh7/j;", "Companion", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface DynamicRechargePanelConfig extends j<DynamicRechargePanelConfig> {
    public static final Companion c = null;

    public static final class Companion {
        public static final Lazy a = null;
        public static final /* synthetic */ Companion b = null;

        public Companion() {
        }

        static {
            b = new Companion();
            a = LazyKt.lazy(DynamicRechargePanelConfig$Companion$DEFAULT$2.INSTANCE);
        }
    }

    @JsonAdapter(DynamicRechargePanelConfigSerializableObjectImpl.Adapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    static {
        c = Companion.b;
    }

    @FieldName(name = "one_step_data_split#setter")
    void P1();

    @FieldName(name = "one_step_data_split")
    boolean w4();
}
