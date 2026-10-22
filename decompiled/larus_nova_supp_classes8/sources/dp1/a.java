package dp1;

import android.net.Uri;
import android.view.View;
import com.bytedance.android.anniex.utils.k;
import com.bytedance.android.livesdk.config.bc;
import com.bytedance.android.livesdk.schema.interfaces.ILiveActionHandler;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String b(String r7, String r8, boolean r9) {
        Uri r10 = UriProtector.parse(r7);
        Uri.Builder r0 = r10.buildUpon().clearQuery();
        Iterator r1 = UriProtector.getQueryParameterNames(r10).iterator();
    L4:
        if (r1.hasNext() == false) goto L20;
        String r2 = (String) r1.next();
        boolean r4 = true;
        if ((!Intrinsics.areEqual(r2, "url")) == false) goto L4;
        String r3 = UriProtector.getQueryParameter(r10, r2);
        if (Intrinsics.areEqual(r2, "height") == false) goto L19;
        if (r9 == true) goto L19;
        Integer r5 = bc.a.getValue();
        if (r5 != null) goto L14;
    L16:
        r4 = false;
    L17:
        if (r4 == false) goto L19;
        r0.appendQueryParameter("height_percent", "70");
        goto L4
    L14:
        if (r5.intValue() != 2) goto L16;
    L19:
        r0.appendQueryParameter(r2, r3);
        goto L4
    L20:
        r0.appendQueryParameter("url", r8);
        return r0.build().toString();
    }

    public static void a(View r4, String r5, Map r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r4, "v");
        Intrinsics.checkNotNullParameter(r6, "params");
        boolean r0 = true;
        if (r5 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L11;
        return;
    L11:
        if (r5 != null) goto L13;
    L16:
        String r1 = "";
        if (r0 == true) goto L27;
        if (r5 == null) goto L30;
        r1 = r5;
    L30:
        Uri.Builder r3 = UriProtector.parse(k.c(UriProtector.parse(r5))).buildUpon();     // Catch: Exception -> L29
        Iterator r8 = r6.entrySet().iterator();     // Catch: Exception -> L29
    L24:
        if (r8.hasNext() == false) goto L26;
        Map.Entry r9 = (Map.Entry) r8.next();     // Catch: Exception -> L29
        String r10 = (String) r9.getKey();     // Catch: Exception -> L29
        String r11 = (String) r9.getValue();     // Catch: Exception -> L29
        r3.appendQueryParameter(Uri.encode(r10), Uri.encode(r11));     // Catch: Exception -> L29
        goto L24
    L26:
        r1 = b(r5, r3.build().toString(), r7);     // Catch: Exception -> L29
    L27:
        jc1.k.n(ILiveActionHandler.class).handle(r4.getContext(), r1);
        return;
    L13:
        if (r5.length() == 0) goto L16;
        r0 = false;
        goto L16
    L5:
        if (r5.length() == 0) goto L8;
        r2 = false;
        goto L9
    }
}
