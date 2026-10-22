package qu0;

import com.bytedance.android.live.profit.livepet.config.LivePetConfigSerializableObjectImpl;
import com.bytedance.android.live.revenue.common.p;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.google.gson.JsonObject;
import com.google.gson.annotations.JsonAdapter;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import vh7.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@JsonAdapter(LivePetConfigSerializableObjectImpl.Adapter.class)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, d2 = {"Lqu0/a;", "Lvh7/j;", "b", "c", "live-privilege-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface a extends j<a> {

    /* JADX INFO: renamed from: qu0.a$a, reason: collision with other inner class name */
    @JsonAdapter(LivePetConfigSerializableObjectImpl.Adapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class C0302a {
    }

    public static final class b extends p {
        public static final /* synthetic */ KProperty[] d = null;
        public final p.a b;
        public final p.a c;

        static {
            d = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(b.class, "sendGiftScheme", "getSendGiftScheme()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(b.class, "disableBalanceCheck", "getDisableBalanceCheck()Ljava/lang/Boolean;", 0))};
        }

        public b(JsonObject r3) {
            Intrinsics.checkNotNullParameter(r3, "src");
            super(r3);
            this.b = new p.a("send_gift_scheme", Reflection.getOrCreateKotlinClass(String.class));
            this.c = new p.a("disable_balance_check", Reflection.getOrCreateKotlinClass(Boolean.class));
        }
    }

    public static final class c extends p {
        public static final /* synthetic */ KProperty[] c = null;
        public final p.a b;

        static {
            c = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(c.class, "scheme", "getScheme()Ljava/lang/String;", 0))};
        }

        public c(JsonObject r3) {
            Intrinsics.checkNotNullParameter(r3, "src");
            super(r3);
            this.b = new p.a("scheme", Reflection.getOrCreateKotlinClass(String.class));
        }
    }

    @FieldName(name = "pet_config")
    Map<String, JsonObject> D5();

    @FieldName(name = "gift_config")
    Map<String, JsonObject> V();

    @FieldName(name = "debug_mode")
    int getDebugMode();

    @FieldName(name = "enabled")
    boolean getEnabled();
}
