package au8;

import android.os.Bundle;
import com.larus.apm.api.IApmTrace;
import com.larus.applog.api.IApplog;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(String r7, Bundle r8) {
        Intrinsics.checkNotNullParameter(r7, "event");
        nu8.a.e("BootProtectorReporter", "reportEvent key:" + r7 + " params:" + r8);
        IApplog.a.b(r7, r8);
        IApmTrace.Companion r0 = IApmTrace.a;
    L14:
        th = th;
        JSONObject r3 = null;
    L16:
        FLogger.a.e("BootProtectorReporter", "parse bundle params failed, " + th);
    L17:
        if (r3 != null) goto L19;
        r3 = new JSONObject();
    L19:
        r0.f(r7, r3, null, null);
        return;
    L4:
        if (r8.isEmpty() == true) goto L13;
        r3 = new JSONObject();     // Catch: Throwable -> L14
        Iterator<String> r4 = r8.keySet().iterator();     // Catch: Throwable -> L11
    L8:
        if (r4.hasNext() == false) goto L17;
        String r5 = r4.next();     // Catch: Throwable -> L11
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type kotlin.String");     // Catch: Throwable -> L11
        String r6 = r5;     // Catch: Throwable -> L11
        r3.put(r6, r8.get(r6));     // Catch: Throwable -> L11
    L11:
        th = th;
        goto L16
    L13:
        r3 = null;
        goto L17
    }
}
