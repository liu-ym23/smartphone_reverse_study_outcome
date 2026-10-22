package com.bytedance.android.live.recharge.config;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import vh7.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@JsonAdapter(CustomRechargeOneStepConfigSerializableObjectImpl.Adapter.class)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/recharge/config/CustomRechargeOneStepConfig;", "Lvh7/j;", "Companion", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface CustomRechargeOneStepConfig extends j<CustomRechargeOneStepConfig> {
    public static final Companion b = null;

    public static final class Companion {
        public static final Lazy a = null;
        public static final /* synthetic */ Companion b = null;

        public Companion() {
        }

        static {
            b = new Companion();
            a = LazyKt.lazy(CustomRechargeOneStepConfig$Companion$DEFAULT$2.INSTANCE);
        }
    }

    @JsonAdapter(CustomRechargeOneStepConfigSerializableObjectImpl.Adapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    static {
        b = Companion.b;
    }

    @FieldName(name = "is_limit_min_price")
    boolean I2();

    @FieldName(name = "enable_input_mode")
    boolean M5();

    @FieldName(name = "is_limit_min_price#setter")
    void X4();

    @FieldName(name = "enable_rec_last_use#setter")
    void Z5();

    @FieldName(name = "enable_rec_last_use")
    boolean m6();

    @FieldName(name = "last_recharge_price_limit#setter")
    void n1();

    @FieldName(name = "last_recharge_price_limit")
    long v7();

    @FieldName(name = "enable_input_mode#setter")
    void w8();
}
