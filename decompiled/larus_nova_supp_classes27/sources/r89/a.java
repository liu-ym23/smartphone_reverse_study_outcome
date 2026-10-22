package r89;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.common.apphost.AppHost;
import com.larus.e_commerce.impl.applet.PageState;
import com.larus.utils.y0;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import o89.q;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class a {
    public static final a a = null;

    static {
        a = new a();
    }

    public a() {
    }

    public static Map b() {
        Pair[] r0 = new Pair[3];
        AtomicBoolean r1 = q.a;
        String r2 = "1";
        if (q.d() == false) goto L5;
        Object r3 = "1";
    L6:
        boolean r4 = false;
        r0[0] = TuplesKt.to("ec_applet_flag", r3);
        if (q.g() == false) goto L9;
        Object r5 = "1";
    L10:
        r0[1] = TuplesKt.to("ec_applet_landing_page", r5);
        if (q.f(AppHost.a.a().getCurrentActivity()) == false) goto L14;
    L16:
        if (r4 == true) goto L19;
        r2 = "0";
    L19:
        r0[2] = TuplesKt.to("ec_applet_going_landing_page", r2);
        return MapsKt.mapOf(r0);
    L14:
        if (q.b != PageState.GOING) goto L16;
        r4 = true;
        goto L16
    L9:
        r5 = "0";
        goto L10
    L5:
        r3 = "0";
        goto L6
    }

    public static String a(String r8) {
        Map r0 = b();
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L19
        Uri r2 = y0.h(r8);     // Catch: Throwable -> L19
        Iterator r3 = CollectionsKt.listOf(new String[]{"url", "surl"}).iterator();     // Catch: Throwable -> L19
    L5:
        if (r3.hasNext() == false) goto L13;
        String r4 = (String) r3.next();     // Catch: Throwable -> L19
        String r5 = UriProtector.getQueryParameter(r2, r4);     // Catch: Throwable -> L19
        if (r5 == null) goto L5;
        Uri.Builder r6 = y0.h(r5).buildUpon();     // Catch: Throwable -> L19
        Iterator r7 = r0.entrySet().iterator();     // Catch: Throwable -> L19
    L10:
        if (r7.hasNext() == false) goto L12;
        Map.Entry r9 = (Map.Entry) r7.next();     // Catch: Throwable -> L19
        r6.appendQueryParameter((String) r9.getKey(), (String) r9.getValue());     // Catch: Throwable -> L19
        goto L10
    L12:
        r2 = y0.g(r2, r4, r6.build().toString());     // Catch: Throwable -> L19
        goto L5
    L13:
        Uri.Builder r10 = r2.buildUpon();     // Catch: Throwable -> L19
        Iterator r11 = r0.entrySet().iterator();     // Catch: Throwable -> L19
    L15:
        if (r11.hasNext() == false) goto L17;
        Map.Entry r12 = (Map.Entry) r11.next();     // Catch: Throwable -> L19
        r10.appendQueryParameter((String) r12.getKey(), (String) r12.getValue());     // Catch: Throwable -> L19
        goto L15
    L17:
        Object r13 = Result.constructor-impl(r10.build().toString());     // Catch: Throwable -> L19
    L21:
        Object r14 = r8;
        if (Result.isFailure-impl(r13) == true) goto L26;
        r14 = r13;
    L26:
        return (String) r14;
    L19:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L21
    }
}
