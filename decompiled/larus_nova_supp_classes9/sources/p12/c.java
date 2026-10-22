package p12;

import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.revenue.core.util.f;
import com.bytedance.android.live.revenue.platform.network.api.INetworkService;
import com.bytedance.android.livesdk.gift.model.x3;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.TypesJVMKt;
import uz0.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c {

    public static final class a<T, R> implements Function {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final Object apply(Object r2) {
            ExtraResponse r3 = (ExtraResponse) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            return (x3) r3.data;
        }
    }

    public c() {
    }

    public static Observable a(String r13, boolean r14) {
        Intrinsics.checkNotNullParameter(r13, "roomId");
        tz0.b r0 = tz0.b.a;
        e r1 = new e();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "$this$beforeConfigureRequest");
        Map r2 = r1.e;
        Intrinsics.checkNotNullParameter(r2, "fieldsMap");
        String r15 = String.valueOf(r14);
        Intrinsics.checkNotNullParameter("forbidden_switch", "$this$setTo");
        if (r15 == null) goto L5;
        r2.put("forbidden_switch", r15);
    L5:
        Intrinsics.checkNotNullParameter("room_id", "$this$setTo");
        if (r13 == null) goto L8;
        r2.put("room_id", r13);
    L8:
        Intrinsics.checkNotNullParameter(r1, "$this$afterConfigureRequest");
        return f.a(INetworkService.class).L4(INetworkService.Biz.Revenue, "/webcast/gift/effect_game/update_config/", TypesJVMKt.getJavaType(Reflection.typeOf(x3.class)), Extra.class, ((uz0.a) r1).d, ((uz0.a) r1).a, ((uz0.a) r1).b, ((uz0.a) r1).c, r1.e, r1.f, r1.g).map(a.a);
    }
}
