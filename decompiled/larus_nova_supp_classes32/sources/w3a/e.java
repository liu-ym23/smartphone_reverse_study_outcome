package w3a;

import com.larus.av_call.databinding.LarusFragmentInstantCallBaseBinding;
import com.larus.utils.t0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class e implements g {
    public static final e a = null;

    static {
        a = new e();
    }

    public e() {
    }

    @Override // w3a.g
    public final void b(final LarusFragmentInstantCallBaseBinding r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        t0.e(new d(r2));
    }

    @Override // w3a.g
    public final void a(final LarusFragmentInstantCallBaseBinding r2, final e3a.a r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "runtimeData");
        t0.e(new c(r3, r2));
    }
}
