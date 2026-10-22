package b2a;

import com.larus.platform.api.b4;
import com.larus.platform.api.u3;
import com.larus.uploader.api.IUploaderService;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import mr9.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class b implements u3 {
    public static final b a = null;
    public static final Lazy b = null;

    public b() {
    }

    static {
        a = new b();
        b = LazyKt.lazy(new a());
    }

    @Override // com.larus.platform.api.u3
    public final b4 a(j r2) {
        Intrinsics.checkNotNullParameter(r2, "param");
        IUploaderService r0 = (IUploaderService) b.getValue();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.a(r2);
    }

    @Override // com.larus.platform.api.u3
    public final b4 b(j r2) {
        Intrinsics.checkNotNullParameter(r2, "param");
        IUploaderService r0 = (IUploaderService) b.getValue();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.b(r2);
    }
}
