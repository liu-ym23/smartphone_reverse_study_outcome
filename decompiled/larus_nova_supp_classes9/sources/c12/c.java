package c12;

import com.bytedance.android.livesdk.gift.platform.core.a0;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.GiftResourceFileCacheService;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public abstract class c implements fd6.b<String> {
    public final boolean a;
    public final com.bytedance.kmp.livesdk.gift.platform.resourcemanager.cache.a b;

    public static final class a {
    }

    static {
    }

    public c(com.bytedance.kmp.livesdk.gift.platform.resourcemanager.cache.a r3) {
        Intrinsics.checkNotNullParameter(r3, "mFileCacheFactory");
        this.b = r3;
        this.a = ((Boolean) a0.e.getValue(null, a0.a[3])).booleanValue();
    }

    public final String b(com.bytedance.android.livesdk.gift.platform.business.effect.assets.e r4) {
        Intrinsics.checkNotNullParameter(r4, "request");
        GiftResourceFileCacheService r0 = (GiftResourceFileCacheService) com.bytedance.android.live.revenue.core.util.f.a(GiftResourceFileCacheService.class);
        if (r0.h().getEnable() == false) goto L6;
        String r1 = r0.a(r4);
        new PolarisFileWrapper(r1).mkdirs();
        return rlc.b.a(r1) + rlc.a.b(r4.k);
    L6:
        String r2 = rlc.b.a(this.b.b(r4));
        PolarisFileWrapper r3 = new PolarisFileWrapper(r2);
        if (r3.exists() == true) goto L13;
        if (r3.mkdirs() == true) goto L13;
        return null;
    L13:
        return r2 + rlc.a.b(r4.j[0]);
    }

    public static void c(com.bytedance.android.livesdk.gift.platform.business.effect.assets.e r16, long r17, long r19, long r21, String r23, double r24, int r26, String r27, int r28) {
        Intrinsics.checkNotNullParameter(r16, "request");
        Intrinsics.checkNotNullParameter(r23, "url");
        Intrinsics.checkNotNullParameter(r27, "strErrorMsg");
        Intrinsics.checkNotNullParameter("ttnet", "cdnType");
        if ((r16 instanceof e) == false) goto L9;
        long r5 = System.currentTimeMillis();
        long r7 = r16.e;
        long r9 = r19 - r7;
        long r11 = r5 - r19;
        long r6 = r5 - r7;
        LinkedHashMap r8 = new LinkedHashMap();
        r8.put("fileLength", String.valueOf(r17) + BuildConfig.FLAVOR);
        r8.put("downTime", String.valueOf(r11) + BuildConfig.FLAVOR);
        r8.put("realTime", String.valueOf(r21));
        r8.put("asset_id", String.valueOf(r16.i) + BuildConfig.FLAVOR);
        r8.put("speed", String.valueOf(r24) + BuildConfig.FLAVOR);
        r8.put("out_duration", String.valueOf(r9) + BuildConfig.FLAVOR);
        r8.put("in_duration", String.valueOf(r11) + BuildConfig.FLAVOR);
        r8.put("total_duration", String.valueOf(r6) + BuildConfig.FLAVOR);
        r8.put("download_url", r23);
        r8.put("errorCode", String.valueOf(r26) + BuildConfig.FLAVOR);
        r8.put("errorMsg", r27);
        r8.put("source", String.valueOf(r16.l) + BuildConfig.FLAVOR);
        String r2 = "0";
        r8.put("status", "0");
        r8.put("cdnType", "ttnet");
        r8.put("cdn_state", String.valueOf(r28));
        if (r16.h == false) goto L7;
        r2 = "1";
    L7:
        r8.put("isFastDownload", r2);
        ((e) r16).n = r8;
        return;
    }
}
