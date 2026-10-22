package c12;

import com.bytedance.android.livesdk.gift.platform.core.scope.service.GiftResourceFileCacheService;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public class e extends com.bytedance.android.livesdk.gift.platform.business.effect.assets.e {
    public Map<String, String> n;
    public int o;
    public GiftResourceFileCacheService p;

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.e
    public final int a() {
        if (this.p != null) goto L5;
        this.p = (GiftResourceFileCacheService) com.bytedance.android.live.revenue.core.util.f.a(GiftResourceFileCacheService.class);
    L5:
        GiftResourceFileCacheService r0 = this.p;
        if (r0 == null) goto L39;
        com.bytedance.android.livesdk.gift.configmodel.f r1 = r0.h();
        if (r1 != null) goto L10;
        return 0;
    L10:
        if (r1.getEnable() != true) goto L41;
        GiftResourceFileCacheService r2 = this.p;
        if (r2 == null) goto L42;
        String r3 = this.k;
        ConcurrentHashMap<String, String> r4 = r2.c;
        if (r4 != null) goto L16;
        return 0;
    L16:
        if (r4.isEmpty() == true) goto L48;
        String r5 = r2.c.get(r3);
        if (r5 != null) goto L21;
    L24:
        boolean r6 = true;
    L25:
        if (r6 == true) goto L28;
        return 1;
    L28:
        if (r2.h().n7() == true) goto L34;
        if (r2.f == false) goto L34;
        return 2;
    L34:
        if (r2.f == true) goto L46;
        long r7 = r2.l;
        if (r7 >= 100000) goto L47;
        r2.l = r7 + 1;
        return 0;
    L47:
        return 0;
    L46:
        return 0;
    L21:
        if (r5.length() == 0) goto L24;
        r6 = false;
        goto L25
    L48:
        return 0;
    L42:
        return 0;
    L41:
        return 0;
    L39:
        return 0;
    }

    public e(long r2, String[] r4, String r5, long r6, GiftResourceFileCacheService r8) {
        Intrinsics.checkNotNullParameter(r4, "urls");
        Intrinsics.checkNotNullParameter(r5, "md5");
        super(r2, r4, r5, r6);
        this.p = r8;
    }
}
