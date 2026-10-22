package com.obric.assistant.omnidetailpage.util;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import androidx.core.content.ContextCompat;
import com.larus.utils.j0;
import com.obric.assistant.obric_action.IObricActionService;
import com.obric.assistant.obric_action.c;
import ifa.f;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class OmniPageUtil {
    public static final ConcurrentHashMap<String, Pair<Drawable, String>> a = null;
    public static final Map<String, List<f>> b = null;

    static {
        a = new ConcurrentHashMap();
        b = Collections.synchronizedMap(new OmniPageUtil$detailContentCache$1());
    }

    public static void a(Context r2, String r3, String r4, Map r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "fullUrl");
        Intrinsics.checkNotNullParameter(r5, "params");
        IObricActionService r0 = c.a();
        com.obric.assistant.card.utils.f.a.getClass();
        r0.d(r2, com.obric.assistant.card.utils.f.b(r3, r5), c.a().c("omni_detail", r4));
    }

    public static Pair b(String r3, PackageManager r4, Context r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r3, "packageName");
        Intrinsics.checkNotNullParameter(r4, "pm");
        Intrinsics.checkNotNullParameter(r5, "context");
        if (r6 == false) goto L5;
        String r0 = r3.concat("_blue");
    L6:
        Pair<Drawable, String> r1 = a.get(r0);
        if (r1 == null) goto L10;
        return r1;
    L10:
        switch(r3.hashCode()) {
            case -599445191: goto L37;
            case -266166185: goto L29;
            case -172590263: goto L21;
            case 1909301541: goto L13;
            default: goto L41;
        };
    L13:
        if (r3.equals("askUserBegin") == false) goto L41;
        if (r6 == false) goto L18;
        int r7 = 2131244553;
    L19:
        Drawable r8 = ContextCompat.getDrawable(r5, r7);
        int r9 = j0.a;
        Pair<Drawable, String> r10 = new Pair(r8, j0.d(2131912285));
    L51:
        if (r10.getFirst() == null) goto L53;
        a.put(r0, r10);
    L53:
        return r10;
    L18:
        r7 = 2131244552;
        goto L19
    L21:
        if (r3.equals("callUser") == false) goto L41;
        if (r6 == false) goto L26;
        int r11 = 2131244557;
    L27:
        Drawable r12 = ContextCompat.getDrawable(r5, r11);
        int r13 = j0.a;
        r10 = new Pair(r12, j0.d(2131912286));
        goto L51
    L26:
        r11 = 2131244556;
        goto L27
    L29:
        if (r3.equals("askUserEnd") == false) goto L41;
        if (r6 == false) goto L34;
        int r14 = 2131244555;
    L35:
        Drawable r15 = ContextCompat.getDrawable(r5, r14);
        int r16 = j0.a;
        r10 = new Pair(r15, j0.d(2131912285));
        goto L51
    L34:
        r14 = 2131244554;
        goto L35
    L37:
        if (r3.equals("complete") == false) goto L41;
        Drawable r17 = ContextCompat.getDrawable(r5, 2131244559);
        int r18 = j0.a;
        r10 = new Pair(r17, j0.d(2131912287));
    L41:
        if (r3.length() != 0) goto L43;
        boolean r19 = true;
    L44:
        if (r19 == false) goto L54;
        Pair<Drawable, String> r20 = new Pair(null, r3);
    L46:
        r10 = r20;
        goto L51
    L54:
        String r21 = r4.getApplicationLabel(r4.getApplicationInfo(r3, 0)).toString();     // Catch: Exception -> L49
        r20 = new Pair(r4.getApplicationIcon(r3), r21);     // Catch: Exception -> L49
    L49:
        Drawable r22 = ContextCompat.getDrawable(r5, 2131244560);
        int r23 = j0.a;
        r10 = new Pair(r22, j0.d(2131912281));
        goto L51
    L43:
        r19 = false;
        goto L44
    L5:
        r0 = r3;
        goto L6
    }
}
