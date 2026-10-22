package ll0;

import com.bytedance.android.livesdkapi.hybridapi.IJsBridgeManager;
import com.bytedance.ies.web.jsbridge2.g;
import com.google.gson.JsonObject;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b implements Function2<String, g<JsonObject, JsonObject>, Unit> {
    public final /* synthetic */ IJsBridgeManager a;

    public b(IJsBridgeManager r1) {
        this.a = r1;
    }

    public final Object invoke(Object r2, Object r3) {
        String r4 = (String) r2;
        g r5 = (g) r3;
        Intrinsics.checkNotNullParameter(r4, "p1");
        Intrinsics.checkNotNullParameter(r5, "p2");
        this.a.registerMethod(r4, r5);
        return Unit.INSTANCE;
    }
}
