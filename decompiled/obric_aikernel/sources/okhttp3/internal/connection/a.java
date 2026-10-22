package okhttp3.internal.connection;

import kotlin.jvm.internal.Intrinsics;
import okhttp3.t;
import okhttp3.z;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f11766a = null;

    static {
        f11766a = new a();
    }

    private a() {
    }

    @Override // okhttp3.t
    public z a(t.a r10) {
        Intrinsics.checkNotNullParameter(r10, "chain");
        kc.g r11 = (kc.g) r10;
        return kc.g.e(r11, 0, r11.f().q(r11), null, 0, 0, 0, 61, null).b(r11.j());
    }
}
