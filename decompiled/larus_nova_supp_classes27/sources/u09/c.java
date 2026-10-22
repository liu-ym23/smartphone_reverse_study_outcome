package u09;

import com.larus.utils.t0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(final String r6, Integer r7, Function0 r8) {
        Intrinsics.checkNotNullParameter(r6, "eventName");
        Intrinsics.checkNotNullParameter(r8, "callback");
        if (r7 == null) goto L16;
        int r1 = a.a;
        int r9 = r7.intValue();
        if (r9 <= 0) goto L13;
        boolean r2 = true;
        if (r9 != 1) goto L11;
    L14:
        if (r2 == true) goto L16;
        return;
    L11:
        if ((System.currentTimeMillis() % ((long) r9)) == 0) goto L14;
    L13:
        r2 = false;
    L16:
        final JSONObject r10 = (JSONObject) r8.invoke();
        Intrinsics.checkNotNullParameter(r6, "eventName");
        Intrinsics.checkNotNullParameter(r10, "params");
        t0.a(new b(r6, r10));
    }
}
