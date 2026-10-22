package q20;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.Iterator;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class j {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String a(Uri r3) {
        Intrinsics.checkNotNullParameter(r3, "uri");
        int r0 = com.bytedance.ies.bullet.kit.resourceloader.loader.b.a;     // Catch: Exception -> L5
        return com.bytedance.ies.bullet.kit.resourceloader.loader.b.c(r3) + '_' + com.bytedance.ies.bullet.kit.resourceloader.loader.b.c(UriProtector.parse(UriProtector.getQueryParameter(r3, LiveSlardarConstants.EXTRA_KEY_URL))) + ')';
    L6:
        return com.bytedance.ies.bullet.kit.resourceloader.loader.b.c(r3);
    }

    public static Uri b(Uri r5, String r6) {
        Intrinsics.checkNotNullParameter(r5, "uri");
        Intrinsics.checkNotNullParameter(LiveSlardarConstants.EXTRA_KEY_URL, "key");
        Intrinsics.checkNotNullParameter(r6, "newValue");
        Set r0 = UriProtector.getQueryParameterNames(r5);
        Uri.Builder r2 = r5.buildUpon();
        if (r0.contains(LiveSlardarConstants.EXTRA_KEY_URL) == false) goto L14;
        r2.clearQuery();
        Iterator r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L16;
        String r3 = (String) r1.next();
        if (TextUtils.isEmpty(r3) == true) goto L6;
        if (Intrinsics.areEqual(r3, LiveSlardarConstants.EXTRA_KEY_URL) == false) goto L12;
        String r4 = r6;
    L13:
        r2.appendQueryParameter(r3, r4);
        goto L6
    L12:
        r4 = UriProtector.getQueryParameter(r5, r3);
    L16:
        return r2.build();
    L14:
        r2.appendQueryParameter(LiveSlardarConstants.EXTRA_KEY_URL, r6);
        goto L16
    }
}
