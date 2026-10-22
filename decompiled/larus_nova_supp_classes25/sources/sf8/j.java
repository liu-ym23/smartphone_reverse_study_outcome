package sf8;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class j implements Function1 {
    public final /* synthetic */ String a;

    public /* synthetic */ j(String r1) {
        this.a = r1;
    }

    public final Object invoke(Object r3) {
        String r0 = this.a;
        JSONObject r4 = (JSONObject) r3;
        Intrinsics.checkNotNullParameter(r4, "$this$mobDeepSearchEvent");
        r4.put("enter_method", r0);
        return Unit.INSTANCE;
    }
}
