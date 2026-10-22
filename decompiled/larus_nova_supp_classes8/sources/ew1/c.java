package ew1;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c {
    public static final String a(String r5, List<String> r6) {
        Intrinsics.checkNotNullParameter(r5, "url");
        Intrinsics.checkNotNullParameter(r6, "cleanArgs");
        Uri r0 = UriProtector.parse(r5);     // Catch: Throwable -> L11
        Uri.Builder r1 = r0.buildUpon();     // Catch: Throwable -> L11
        r1.clearQuery();     // Catch: Throwable -> L11
        Iterator r2 = UriProtector.getQueryParameterNames(r0).iterator();     // Catch: Throwable -> L11
    L5:
        if (r2.hasNext() == false) goto L9;
        String r3 = (String) r2.next();     // Catch: Throwable -> L11
        if (r6.contains(r3) == true) goto L5;
        r1.appendQueryParameter(r3, UriProtector.getQueryParameter(r0, r3));     // Catch: Throwable -> L11
        goto L5
    L9:
        return r1.build().toString();
    L19:
        return r5;
    }
}
