package uk0;

import com.bytedance.android.live.pushstream.d;
import fr2.g0;
import fr2.k;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import uf2.d0;
import uf2.z;
import vh6.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a {
    public final d a;

    public final k b() {
        d0 r0 = this.a.getLiveCore();
        if (r0 == null) goto L12;
        z r1 = r0.C();
        if (r1 == null) goto L14;
        KClass r2 = Reflection.getOrCreateKotlinClass(k.class);
        k r3 = c.b(g0.class).o6().e(r2, r1);
        if (r3 == null) goto L11;
        return r3;
    L11:
        throw new NullPointerException("null cannot be cast to non-null type T");
    L14:
        return null;
    L12:
        return null;
    }

    public final boolean c() {
        return this.a.a();
    }

    public a(d r2) {
        Intrinsics.checkNotNullParameter(r2, "liveStream");
        this.a = r2;
    }

    public final void a(boolean r2) {
        this.a.t(r2);
    }
}
