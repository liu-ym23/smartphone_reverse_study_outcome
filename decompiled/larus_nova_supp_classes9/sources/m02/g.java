package m02;

import com.bytedance.android.live.revenue.common.x0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(x0 r5) {
        Intrinsics.checkNotNullParameter(r5, "schemaUri");
        ReadOnlyProperty r1 = com.bytedance.android.livesdk.gift.platform.business.effect.a.j;
        KProperty[] r2 = com.bytedance.android.livesdk.gift.platform.business.effect.a.a;
        if (((Boolean) r1.getValue(null, r2[8])).booleanValue() == true) goto L5;
        Intrinsics.checkNotNullParameter("enable_dynamic_v8", "key");
        r5.a.remove("enable_dynamic_v8");
    L5:
        Intrinsics.checkNotNullParameter(r5, "schemaUri");
        if (((Boolean) com.bytedance.android.livesdk.gift.platform.business.effect.a.k.getValue(null, r2[9])).booleanValue() == false) goto L9;
        r5.b("enable_dynamic_v8", "1");
        return;
    }
}
