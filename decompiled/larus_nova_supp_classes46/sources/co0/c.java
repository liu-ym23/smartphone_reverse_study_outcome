package co0;

import android.net.Uri;
import com.bytedance.android.live.core.cache.LruCache;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.config.cp0;
import com.bytedance.android.livesdk.config.hg1;
import com.bytedance.android.livesdk.user.e;
import com.bytedance.mt.protector.impl.UriProtector;
import io.reactivex.Flowable;
import jc1.k;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c {
    public static final LruCache a = null;
    public static boolean b;

    static {
        a = new LruCache(5);
    }

    @JvmStatic
    public static final String a(String r2, String r3) {
        if (r2 != null) goto L4;
        return r2;
    L4:
        Uri r0 = UriProtector.parse(r2);
        if (r0 == null) goto L15;
        Uri.Builder r1 = r0.buildUpon();
        if (r1 == null) goto L16;
        Uri.Builder r4 = r1.appendQueryParameter("r_signature", r3);
        if (r4 == null) goto L17;
        String r5 = r4.toString();
        if (r5 != null) goto L14;
        return r2;
    L14:
        return r5;
    L17:
        return r2;
    L16:
        return r2;
    L15:
        return r2;
    }

    @JvmStatic
    public static final String b(String r3, String r4) {
        if (r3 == null) goto L34;
        hg1 r0 = (hg1) cp0.a.getValue();
        if (r0 != null) goto L6;
        return r3;
    L6:
        if (r0.b(r4) != true) goto L37;
        Uri r5 = UriProtector.parse(r3);
        if (r5 != null) goto L12;
    L15:
        String r6 = "";
    L16:
        boolean r2 = false;
        if (r6.length() != 0) goto L19;
        boolean r1 = true;
    L20:
        if (r1 == false) goto L22;
        return r3;
    L22:
        LruCache r7 = a;
        if (r7 == null) goto L25;
        String r8 = (String) r7.get(r6);
    L26:
        if (r8 != null) goto L28;
        return r3;
    L28:
        if (r8.length() <= 0) goto L30;
        r2 = true;
    L30:
        if (r2 == true) goto L33;
        return r3;
    L33:
        return a(r3, r8);
    L25:
        r8 = null;
        goto L26
    L19:
        r1 = false;
        goto L20
    L12:
        if (r5.isOpaque() == true) goto L15;
        r6 = UriProtector.getQueryParameter(r5, "room_id");
        if (r6 != null) goto L16;
    L37:
        return r3;
    L34:
        return r3;
    }

    @JvmStatic
    public static final void c(long r1, String r3) {
        Intrinsics.checkNotNullParameter(r3, "signature");
        LruCache r0 = a;
        if (r0 == null) goto L6;
        r0.put(String.valueOf(r1), r3);
    L6:
        if (b == true) goto L22;
        b = true;
        IMiddlewareUserService r2 = k.f(IMiddlewareUserService.class);
        if (r2 == null) goto L18;
        e r4 = r2.user();
        if (r4 == null) goto L19;
        Flowable r5 = r4.m();
        if (r5 == null) goto L20;
        Flowable r6 = r5.onBackpressureLatest();
        if (r6 == null) goto L21;
        r6.subscribe(a.a, b.a);
        return;
    L21:
        return;
    L20:
        return;
    L19:
        return;
    L18:
        return;
    }
}
