package za;

import android.net.Uri;
import com.bytedance.android.anniex.scene.core.UrlUsageTracker;
import com.bytedance.android.anniex.utils.k;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.mt.protector.impl.UriProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c {
    public static final String a(String r14) {
        Intrinsics.checkNotNullParameter(r14, com.bytedance.android.ec.core.event.a.KEY_URL);
        long r10 = System.currentTimeMillis();     // Catch: Exception -> L43
        Uri r11 = UriProtector.parse(r14);     // Catch: Exception -> L43
        if (Intrinsics.areEqual(r11.getScheme(), "http") == false) goto L6;
    L40:
        r14 = r11.buildUpon().clearQuery().toString();     // Catch: Exception -> L43
    L41:
        HybridLogger r1 = HybridLogger.a;     // Catch: Exception -> L43
        UrlUsageTracker r12 = UrlUsageTracker.n;     // Catch: Exception -> L43
        HybridLogger.f("UrlUsageTracker", "getIdentifyUrl result:" + r14 + ", cost: " + (System.currentTimeMillis() - r10), null, 12);     // Catch: Exception -> L43
        return r14;
    L6:
        if (Intrinsics.areEqual(r11.getScheme(), "https") == true) goto L40;
        if (Intrinsics.areEqual(r11.getScheme(), "sslocal") == false) goto L11;
    L19:
        String r15 = UriProtector.getQueryParameter(r11, "channel");     // Catch: Exception -> L43
        String r13 = UriProtector.getQueryParameter(r11, "bundle");     // Catch: Exception -> L43
        String r16 = k.c(r11);     // Catch: Exception -> L43
        if (r16 == null) goto L28;
        Uri r17 = UriProtector.parse(r16);     // Catch: Exception -> L43
        if (r17 == null) goto L28;
        Uri.Builder r18 = r17.buildUpon();     // Catch: Exception -> L43
        if (r18 == null) goto L28;
        Uri.Builder r19 = r18.clearQuery();     // Catch: Exception -> L43
        if (r19 == null) goto L28;
        String r110 = r19.toString();     // Catch: Exception -> L43
    L29:
        if (r15 == null) goto L39;
        if (r13 == null) goto L39;
        Uri.Builder r111 = new Uri.Builder().scheme(r11.getScheme());     // Catch: Exception -> L43
        if (r11.getAuthority() == null) goto L35;
        r111.authority(r11.getAuthority());     // Catch: Exception -> L43
    L35:
        Uri.Builder r112 = r111.appendQueryParameter("channel", r15).appendQueryParameter("bundle", r13);     // Catch: Exception -> L43
        if (r110 == null) goto L38;
        r112.appendQueryParameter(com.bytedance.android.ec.core.event.a.KEY_URL, r110);     // Catch: Exception -> L43
    L38:
        r14 = r112.build().toString();     // Catch: Exception -> L43
    L39:
        r14 = r110;
    L28:
        r110 = null;
        goto L29
    L11:
        if (Intrinsics.areEqual(r11.getScheme(), "aweme") == true) goto L19;
        if (Intrinsics.areEqual(r11.getScheme(), "hybrid") == true) goto L19;
        if (Intrinsics.areEqual(r11.getScheme(), "lynxview") == true) goto L41;
        r14 = r11.buildUpon().clearQuery().toString();     // Catch: Exception -> L43
    L43:
        e = move-exception;
        HybridLogger r20 = HybridLogger.a;
        UrlUsageTracker r21 = UrlUsageTracker.n;
        HybridLogger.i("UrlUsageTracker", "getIdentifyUrl error: " + e.getMessage(), null, 12);
        return null;
    }
}
