package m5;

import java.util.Iterator;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class f1 {
    public final JSONObject a;

    public static final class a {
    }

    static {
    }

    public f1() {
        this.a = new JSONObject();
    }

    public final void a(JSONObject r10) {
        Intrinsics.checkNotNullParameter(r10, "jsonObject");
        JSONObject r0 = this.a;
        Intrinsics.checkNotNullParameter(r0, "<this>");
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L12
        Iterator<String> r11 = r10.keys();     // Catch: Throwable -> L12
        if (r11 != null) goto L6;
        Unit r12 = null;
    L10:
        Object r13 = Result.constructor-impl(r12);     // Catch: Throwable -> L12
    L14:
        Throwable r14 = Result.exceptionOrNull-impl(r13);
        if (r14 == null) goto L21;
        com.bytedance.ai.utils.g.a.e("Monitor-Timeline", "JsonUtils.wrap " + r14.getMessage());
        return;
    L21:
        return;
    L6:
        if (r11.hasNext() == false) goto L8;
        String r15 = r11.next();     // Catch: Throwable -> L12
        r0.put(r15, r10.opt(r15));     // Catch: Throwable -> L12
        goto L6
    L8:
        r12 = Unit.INSTANCE;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    }

    public final boolean b(String r10) {
        Intrinsics.checkNotNullParameter(r10, "key");
        if (this.a.optLong(r10) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final long c(String r10) {
        Intrinsics.checkNotNullParameter(r10, "key");
        long r0 = this.a.optLong(r10);
        if (r0 != 0) goto L6;
        com.bytedance.ai.utils.g.a.w("Monitor-Timeline", "get null metric: ".concat(r10));
        return -1;
    L6:
        return r0;
    }

    public final void d(String r10, Long r11) {
        Intrinsics.checkNotNullParameter(r10, "key");
        if (this.a.optLong(r10) == 0) goto L6;
        com.bytedance.ai.utils.g.a.w("Monitor-Timeline", "redundancy record: " + r10 + ", " + r11);
        return;
    L6:
        Intrinsics.checkNotNullParameter(r10, "key");
        if (r11 != null) goto L9;
        com.bytedance.ai.utils.g.a.w("Monitor-Timeline", "record with null metric: " + r10 + ", " + r11);
        return;
    L9:
        this.a.put(r10, r11.longValue());
    }
}
