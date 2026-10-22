package mo8;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public abstract class a {
    public final com.larus.trace.tracespan.span.b a;
    public com.larus.trace.tracespan.span.b b;

    /* JADX INFO: renamed from: mo8.a$a, reason: collision with other inner class name */
    public static final class C0119a {
    }

    static {
    }

    public abstract List<String> a();

    public abstract String b();

    public abstract String c();

    public abstract String d();

    public a(com.larus.trace.tracespan.span.b r2) {
        Intrinsics.checkNotNullParameter(r2, "parentSpan");
        this.a = r2;
    }
}
