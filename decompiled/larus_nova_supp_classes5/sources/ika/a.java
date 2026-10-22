package ika;

import android.content.Context;
import com.obric.matrix.push.common.cross_process.CrossProcessService;
import jka.c;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class a {
    public static final a a = null;
    public static CrossProcessService b;

    static {
        a = new a();
    }

    public a() {
    }

    public final c a(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        if (b != null) goto L14;
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L6:
        if (b != null) goto L8;
        b = new CrossProcessService(r2);     // Catch: Throwable -> L11
    L8:
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(this);
    L14:
        CrossProcessService r4 = b;
        Intrinsics.checkNotNull(r4);
        return r4;
    }
}
