package sk0;

import com.bytedance.android.live.pushstream.d;
import hh1.v0;
import kotlin.jvm.internal.Intrinsics;
import uf2.d0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b implements ec6.a {
    public final c a;
    public final ji6.a b;
    public final v0 c;
    public final d0 d;

    public /* synthetic */ b() {
        throw null;
    }

    public final void release() {
        this.c.release();
    }

    public final ji6.a o() {
        return this.b;
    }

    public final v0 p() {
        return this.c;
    }

    public final c r() {
        return this.a;
    }

    public final ei6.a q(fi6.a r2) {
        Intrinsics.checkNotNullParameter(r2, "config");
        return this.c.create();
    }

    public b(v0 r2, d0 r3) {
        Intrinsics.checkNotNullParameter(r2, "liveVideoClientFactory");
        this.c = r2;
        this.d = r3;
        d r0 = r2.getLiveStream();
        if (r3 != null) goto L5;
        r3 = r2.getLiveCore();
    L5:
        if (r0 == null) goto L9;
        if (r3 == null) goto L10;
        this.a = new c(r0);
        this.b = new ji6.a(r3);
        return;
    L10:
        return;
    }
}
