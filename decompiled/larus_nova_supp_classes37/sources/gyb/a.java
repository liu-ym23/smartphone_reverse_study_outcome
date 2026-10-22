package gyb;

import com.ss.android.lark.log.Log;
import com.ss.android.lark.opmonitor.trace.OPTrace;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a {
    public static final OPTrace a = null;

    static {
        a = new OPTrace();
    }

    @JvmStatic
    public static final OPTrace a() {
        return a.subTrace();
    L4:
        e = move-exception;
        Log.e("OPTraceService", "generateTrace " + e.getMessage());
        return new OPTrace().subTrace();
    }
}
