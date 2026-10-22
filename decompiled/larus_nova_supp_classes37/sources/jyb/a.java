package jyb;

import com.ss.android.lark.optrace.core.b;
import com.ss.android.lark.optrace.impl.TracingSpanImpl;
import kotlin.Deprecated;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Deprecated(message = "this is deprecated,use OPTraceService")
public final class a {
    public static a a;
    public static b b;
    public static TracingSpanImpl c;

    public a() {
        c = new TracingSpanImpl(null);
        b = new b();
    }
}
