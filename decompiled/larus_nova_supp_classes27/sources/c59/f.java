package c59;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class f implements d {
    public final /* synthetic */ b a;

    public f(b r1) {
        this.a = r1;
    }

    @Override // c59.d
    public final boolean a(Context r2, CoroutineScope r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "lifecycleScope");
        int r4 = com.larus.dora.impl.util.h0.a;
        return com.larus.dora.impl.util.h0.b(this.a.e());
    }
}
