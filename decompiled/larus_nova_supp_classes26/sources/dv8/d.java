package dv8;

import com.larus.platform.service.o;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class d {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public d() {
    }

    public static void a(boolean r3, String r4) {
        Intrinsics.checkNotNullParameter(r4, "failReason");
        o r0 = o.a;
        JSONObject r1 = new JSONObject();
        r1.put("success", r3 ? 1 : 0);
        if (r3 == true) goto L5;
        r1.put("fail_reason", r4);
    L5:
        Unit r5 = Unit.INSTANCE;
        r0.reportEvent("create_new_bot_result", r1);
    }
}
