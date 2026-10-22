package c12;

import android.util.Log;
import com.bytedance.android.live.core.utils.i0;
import com.bytedance.android.livesdk.downloader.GiftResourceManagerFactory;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.kmp.livesdk.gift.platform.resourcemanager.exception.BaseGetResourceException;
import com.bytedance.kmp.livesdk.gift.platform.resourcemanager.exception.Md5InvalidException;
import com.bytedance.live.kmp.core.KmpEnv;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.ttmd5.TTMd5;
import java.io.File;
import java.util.HashMap;
import kotlin.Lazy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class h implements fd6.b<String>, com.bytedance.kmp.livesdk.gift.platform.resourcemanager.a<String> {
    public final fd6.b<String> a;
    public com.bytedance.kmp.livesdk.gift.platform.resourcemanager.a<String> b;

    public h(fd6.b r1) {
        this.a = r1;
    }

    public final void a(com.bytedance.android.livesdk.gift.platform.business.effect.assets.e r1, com.bytedance.kmp.livesdk.gift.platform.resourcemanager.a<String> r2) {
        this.b = r2;
        this.a.a(r1, this);
    }

    public final void b(com.bytedance.android.livesdk.gift.platform.business.effect.assets.e r20, Object r21) {
        String r3 = (String) r21;
        PolarisFileWrapper r9 = new PolarisFileWrapper(r3);     // Catch: Exception -> L36
        HashMap r10 = new HashMap();     // Catch: Exception -> L36
        r10.put("assets", String.valueOf(r20.i));     // Catch: Exception -> L36
        long r11 = System.currentTimeMillis();     // Catch: Exception -> L36
        KmpEnv r13 = KmpEnv.a;     // Catch: Exception -> L36
        if (KmpEnv.a() == true) goto L7;
    L24:
        String r14 = rlc.a.a(r9);     // Catch: Exception -> L36
        boolean r15 = r20.k.equals(r14);     // Catch: Exception -> L36
        jy0.b.b("OptMD5Producer", "MD5 isOK:" + r15 + " file:" + r3, null);     // Catch: Exception -> L36
        if (r15 == false) goto L27;
        Object r0 = "md5";
    L28:
        r10.put("type", r0);     // Catch: Exception -> L36
    L29:
        r10.put("time", String.valueOf((int) (System.currentTimeMillis() - r11)));     // Catch: Exception -> L36
        i0.c().post(new g(r10));     // Catch: Exception -> L36
        if (r15 == true) goto L32;
        l(r20, new Md5InvalidException(String.format("File %1$s md5 is not equals", new Object[]{r3}), r20, r14));     // Catch: Exception -> L36
        r9.delete();     // Catch: Exception -> L36
        StringBuilder r7 = new StringBuilder();     // Catch: Exception -> L36
        r7.append(r3.substring(0, r3.lastIndexOf(File.separator) + 1));     // Catch: Exception -> L36
        Lazy r8 = GiftResourceManagerFactory.a;     // Catch: Exception -> L36
        r7.append(".fetched");     // Catch: Exception -> L36
        new PolarisFileWrapper(r7.toString()).delete();     // Catch: Exception -> L36
        return;
    L32:
        com.bytedance.kmp.livesdk.gift.platform.resourcemanager.a<String> r1 = this.b;     // Catch: Exception -> L36
        if (r1 == null) goto L41;
        r1.b(r20, r3);     // Catch: Exception -> L36
        return;
    L41:
        return;
    L27:
        r0 = "md5E";
        goto L28
    L7:
        if ((r20 instanceof n) == false) goto L24;
        if (((n) r20).q == null) goto L24;
        if (((n) r20).q.isEmpty() == true) goto L24;
        String r16 = TTMd5.ttmd5(r9);     // Catch: Exception -> L36
        r15 = ((n) r20).q.equals(r16);     // Catch: Exception -> L36
        jy0.b.b("OptMD5Producer", "TTMD5 isOK:" + r15 + " file:" + r3, null);     // Catch: Exception -> L36
        if (r15 == false) goto L15;
        String r2 = "ttmd5";
    L16:
        r10.put("type", r2);     // Catch: Exception -> L36
        if (r15 == true) goto L23;
        r14 = rlc.a.a(r9);     // Catch: Exception -> L36
        r15 = r20.k.equals(r14);     // Catch: Exception -> L36
        jy0.b.b("OptMD5Producer", "MD5 isOK:" + r15 + " file:" + r3, null);     // Catch: Exception -> L36
        if (r15 == false) goto L21;
        Object r4 = "md5";
    L22:
        r10.put("type", r4);     // Catch: Exception -> L36
        goto L29
    L21:
        r4 = "md5E";
        goto L22
    L23:
        r14 = r16;
        goto L29
    L15:
        r2 = "ttmd5E";
    L36:
        e = move-exception;
        HashMap r17 = new HashMap();
        r17.put("assets", String.valueOf(r20.i));
        r17.put("type", "error");
        r17.put("time", "0");
        r17.put("error_trace", Log.getStackTraceString(e));
        i0.c().post(new g(r17));
        l(r20, new Md5InvalidException(String.format("File %1$s md5 error", new Object[]{r3}), e, r20, BuildConfig.FLAVOR));
    }

    public final void l(com.bytedance.android.livesdk.gift.platform.business.effect.assets.e r2, BaseGetResourceException r3) {
        com.bytedance.kmp.livesdk.gift.platform.resourcemanager.a<String> r0 = this.b;
        if (r0 == null) goto L6;
        r0.l(r2, r3);
        return;
    }
}
