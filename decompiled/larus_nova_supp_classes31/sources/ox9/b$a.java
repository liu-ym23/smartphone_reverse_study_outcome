package ox9;

import com.ss.android.ugc.bytex.pthread.base.convergence.executor.IThreadNameTransformer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class b$a implements IThreadNameTransformer {
    public b$a() {
    }

    public final String transform(String r3) {
        Intrinsics.checkNotNullParameter(r3, "threadName");
        return "S#" + r3;
    }
}
