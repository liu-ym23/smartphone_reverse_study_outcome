package rd;

import com.bytedance.ies.bullet.forest.n;
import kotlin.jvm.internal.Intrinsics;
import ym.j;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends com.bytedance.ies.bullet.service.sdk.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j f21722b;

    public a(String r5) {
        Intrinsics.checkNotNullParameter(r5, "bid");
        Intrinsics.checkNotNullParameter(r5, "bid");
        j r10 = new j();
        r10.f23302a = r5;
        Intrinsics.checkNotNullParameter(r10, "monitor");
        this.f21722b = r10;
        n r11 = new n(2);
        Intrinsics.checkNotNullParameter(r11, "interceptor");
        this.f6132a.add(r11);
        sd.a r12 = new sd.a(r5);
        Intrinsics.checkNotNullParameter(r12, "interceptor");
        this.f6132a.add(r12);
        n r13 = new n(5);
        Intrinsics.checkNotNullParameter(r13, "interceptor");
        this.f6132a.add(r13);
    }
}
