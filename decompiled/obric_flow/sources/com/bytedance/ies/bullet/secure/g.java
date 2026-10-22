package com.bytedance.ies.bullet.secure;

import android.net.Uri;
import com.bytedance.ies.bullet.base.settings.n;
import com.lynx.jsbridge.LynxResourceModule;
import com.ss.android.common.applog.AppLog;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
public abstract class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f5907a = 0;

    static {
        LazyKt.lazy(HybridSecureUtil$innerSafeHostMap$2.f5890a);
    }

    public static void a(Uri r5, StringBuilder r10) {
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.URI_KEY);
        Intrinsics.checkNotNullParameter(r10, "sb");
        if (b(r5) == true) goto L5;
        return;
    L5:
        AppLog.appendCommonParams(r10, false);
    }

    public static boolean b(Uri r12) {
        Intrinsics.checkNotNullParameter(r12, "originUrl");
        ConcurrentHashMap r5 = yc.a.f23246a;
        Intrinsics.checkNotNullParameter(xc.e.class, "cls");
        xc.e r10 = (xc.e) yc.a.a(xc.e.class, "default_bid");
        if (r10 == null) goto L76;
        n r11 = (n) r10.a(n.class);
        if (r11 == null) goto L76;
        if (r11.a() == true) goto L9;
        return true;
    L9:
        List r13 = r11.b();
        if (r13 == null) goto L76;
        if (r13.isEmpty() == true) goto L76;
        String r14 = io.reactivex.exceptions.a.b(r12, "default_bid");
        if (r14 != null) goto L17;
        return true;
    L17:
        Uri r15 = Uri.parse(r14);
        Intrinsics.checkNotNullParameter(r15, LynxResourceModule.URI_KEY);
        if (r15.isHierarchical() == false) goto L20;
        Uri r16 = Uri.parse(r15.toString());
    L21:
        String r17 = r16.getHost();
        if (r17 == null) goto L55;
        String r18 = r16.getEncodedAuthority();
        if (r18 == null) goto L55;
        int r19 = 0;
        int r20 = 0;
    L29:
        if (r19 >= r18.length()) goto L34;
        if (r18.charAt(r19) != '@') goto L33;
        r20 = r20 + 1;
    L33:
        r19 = r19 + 1;
        goto L29
    L34:
        if (r20 <= 1) goto L57;
        String r21 = r15.getEncodedAuthority();
        if (r21 != null) goto L38;
        r17 = null;
    L54:
        if (r17 != null) goto L57;
    L38:
        int r22 = StringsKt.t(r21, '@', 0, 6);
        int r23 = r21.length() - 1;
    L39:
        if ((-1) >= r23) goto L49;
        char r24 = r21.charAt(r23);
        if (':' == r24) goto L50;
        if (r24 < '0') goto L49;
        if (r24 > '9') goto L49;
        r23 = r23 - 1;
    L50:
        if (r23 != (-1)) goto L52;
        String r25 = r21.substring(r22 + 1);
    L53:
        r17 = Uri.decode(r25);
        goto L54
    L52:
        r25 = r21.substring(r22 + 1, r23);
    L49:
        r23 = -1;
    L57:
        if (StringsKt.f(r17, '\\') == false) goto L59;
        r17 = StringsKt.W(r17, '\\');
    L59:
        if (r17 != null) goto L61;
        return false;
    L61:
        Iterator r26 = r13.iterator();
    L63:
        if (r26.hasNext() == false) goto L74;
        String r27 = (String) r26.next();
        if (StringsKt.P(r27, ".") == true) goto L67;
        if (Intrinsics.areEqual(r17, r27) == true) goto L73;
        if (StringsKt.k(r17, td.d.b(".", r27)) == false) goto L63;
    L73:
        return true;
    L67:
        if (StringsKt.k(r17, r27) == false) goto L63;
        return true;
    L74:
        int r28 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        com.bytedance.ies.bullet.base.utils.logger.a.d("HybridSecureUtil", "host " + r17 + " not in append common params allow list, origin url is " + r12, null, 12);
        return false;
    L55:
        r17 = null;
        goto L59
    L20:
        r16 = r15;
    L76:
        return true;
    }
}
