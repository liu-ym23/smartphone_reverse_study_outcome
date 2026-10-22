package dvb;

import kotlin.Result;
import kotlin.ResultKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class b implements a {
    public static final b a = null;

    static {
        a = new b();
    }

    public b() {
    }

    @Override // dvb.a
    public final void a() {
    }

    @Override // dvb.a
    public final void b() {
    }

    @Override // dvb.a
    public final Object c() {
        Result.Companion r0 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(new UnsupportedOperationException("hardware file sync is unsupported")));
    }
}
