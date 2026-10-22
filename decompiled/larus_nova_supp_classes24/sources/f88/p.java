package f88;

import com.larus.platform.api.o0;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import tx9.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class p implements o0 {
    public final /* synthetic */ com.larus.audioplayer.impl.news.b a;

    public p(com.larus.audioplayer.impl.news.b r1) {
        this.a = r1;
    }

    public final void a(yq9.e r10) {
        Intrinsics.checkNotNullParameter(r10, "info");
        if (Intrinsics.areEqual(r10.a, "mdlhitcachesize") == false) goto L10;
        FLogger.a.i("UrlAudioPlayer", "url media hit cache info: " + r10);
        com.larus.audioplayer.impl.news.b r0 = this.a;
        if (r10.d <= 0) goto L7;
        boolean r1 = true;
    L8:
        r0.u = r1;
        String r2 = r0.a();
        com.larus.audioplayer.impl.news.b r3 = this.a;
        i1.k(r2, r3.a, r3.u, r10.d, r3.e, 32);
        return;
    L7:
        r1 = false;
        goto L8
    }
}
