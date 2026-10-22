package e88;

import com.larus.platform.api.o0;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import tx9.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class g implements o0 {
    public final /* synthetic */ com.larus.audioplayer.impl.music.a a;

    public g(com.larus.audioplayer.impl.music.a r1) {
        this.a = r1;
    }

    public final void a(yq9.e r9) {
        Intrinsics.checkNotNullParameter(r9, "info");
        if (Intrinsics.areEqual(r9.a, "mdlhitcachesize") == false) goto L10;
        FLogger.a.i("MusicPlayEngine", "music media hit cache info: " + r9);
        com.larus.audioplayer.impl.music.a r0 = this.a;
        long r4 = r9.d;
        if (r4 <= 0) goto L7;
        boolean r3 = true;
    L8:
        r0.t = r3;
        a88.e r10 = r0.a;
        i1.k(r10.m, r10.a, r3, r4, null, 48);
        return;
    L7:
        r3 = false;
        goto L8
    }
}
