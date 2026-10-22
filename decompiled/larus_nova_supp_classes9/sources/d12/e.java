package d12;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.livesdk.gift.configmodel.w1;
import com.bytedance.android.livesdk.gift.platform.core.h;
import com.bytedance.live.kmp.core.KmpEnv;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import java.io.File;
import jta.g;
import kotlin.TypeCastException;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e {
    public static final String a = null;
    public static final String b = null;
    public static final String c = null;

    static {
        StringBuilder r0 = new StringBuilder();
        r0.append(jc1.a.b().getCacheDir().getAbsolutePath());
        String r1 = File.separator;
        r0.append(r1);
        r0.append("pcdn_basepath");
        a = r0.toString();
        b = jc1.a.b().getCacheDir().getAbsolutePath() + r1 + "pcdn_cachepath";
        c = jc1.a.b().getDir("assets", 0).getAbsolutePath();
    }

    public static boolean a() {
        ReadOnlyProperty r0 = h.j;
        KProperty[] r1 = h.a;
        w1 r3 = (w1) r0.getValue(null, r1[8]);
        KmpEnv r5 = KmpEnv.a;
        if (KmpEnv.a() == false) goto L6;
        int r2 = 10001;
    L9:
        r3.pcdnBusinessId = r2;
        r3.pcdnBasePath = a;
        r3.pcdnCachePath = b;
        r3.odlCachePath = c;
        r3.deviceId = g.d();
        r3.pcdnCacheSize = 104857600;
        r3.pcdnMemorySize = 104857600;
        rr0.b r4 = b();
        GsonProtectorUtils.toJson(GsonHelper.getDefault(), r3);
        r4.init();
        b().destroy();
        jy0.b.a("PcdnDownloader", "init fail, result code = -1");
        return false;
    L6:
        if (KmpEnv.b() == false) goto L8;
        r2 = 10002;
        goto L9
    L8:
        r2 = ((w1) r0.getValue(null, r1[8])).pcdnBusinessId;
        goto L9
    }

    public static rr0.b b() {
        rr0.e r0 = rr0.e.b;
        rr0.e.a = new f();
        rr0.b r1 = rr0.f.a;
        if (r1 != null) goto L25;
        Object r2 = rr0.f.a().getConstructor(new Class[0]).newInstance(new Object[0]);     // Catch: Throwable -> L11
        if ((r2 instanceof rr0.b) == false) goto L8;
        r0.i("initDownloader: obj is PCDNDownloader ");     // Catch: Throwable -> L11
        rr0.b r3 = (rr0.b) r2;     // Catch: Throwable -> L11
    L9:
        rr0.f.a = r3;     // Catch: Throwable -> L11
    L14:
        if (rr0.f.a == null) goto L20;
        rr0.e.b.w("getDownloader: defaultDownloader !=null");
        rr0.b r4 = rr0.f.a;
        if (r4 != null) goto L22;
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.android.live.pcdn.api.IPCDNDownloader");
    L22:
        return r4;
    L20:
        rr0.e.b.w("getDownloader: defaultDownloader == null, use emptyDownloader");
        r4 = rr0.f.b;
        goto L22
    L8:
        r0.w("initDownloader: obj not is PCDNDownloader");     // Catch: Throwable -> L11
        r3 = null;
    L11:
        th = move-exception;
        rr0.e.b.e(th);
        goto L14
    L25:
        return r1;
    }
}
