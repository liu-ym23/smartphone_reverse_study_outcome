package lf6;

import com.bytedance.live.artist.render.RenderRequest;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b extends c {
    public b() {
    }

    @Override // lf6.c
    public final void b(RenderRequest r1, float r2) {
        com.bytedance.live.artist.core.b r3 = this.a;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("_engineContext");
    L5:
        r3.a.b();
    }
}
