package com.larus.common.account.platform.larklogin;

import android.net.Uri;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class LarkEntryActivityKt$handleLarkEntry$2 extends FunctionReferenceImpl implements Function1<Uri, Boolean> {
    public LarkEntryActivityKt$handleLarkEntry$2(Object r8) {
        super(1, r8, LarkLogin.a.class, "handleAuthorizationRedirect", "handleAuthorizationRedirect(Landroid/net/Uri;)Z", 0);
    }

    public final Boolean invoke(Uri r11) {
        ((LarkLogin.a) ((CallableReference) this).receiver).getClass();
        LarkOAuthSessionCoordinator r0 = LarkLogin.h;
        boolean r2 = false;
        if (r0.f(r11) == false) goto L79;
        if (r11 == null) goto L79;
        Object r1 = r0.e;
        monitor-enter(r1);
        String r3 = r11.getQueryParameter("state");     // Catch: Throwable -> L80
        if (r3 != null) goto L13;
        monitor-exit(r1);
        goto L79
    L13:
        LarkOAuthSessionCoordinator$a r4 = r0.b(r3);     // Catch: Throwable -> L80
        if (r4 != null) goto L18;
        monitor-exit(r1);
        goto L79
    L18:
        if (r4.f == LarkOAuthSessionCoordinator$Phase.AUTHORIZING) goto L21;
        monitor-exit(r1);
        goto L79
    L21:
        String r5 = r11.getQueryParameter("error");     // Catch: Throwable -> L80
        Pair r6 = null;
        if (Intrinsics.areEqual(r5, "access_denied") == false) goto L24;
    L69:
        Pair r12 = TuplesKt.to(r4.a.a, LarkOAuthSessionCoordinator$c.b.a);     // Catch: Throwable -> L80
    L70:
        r4 = null;
        r6 = r12;
    L71:
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L80
        monitor-exit(r1);
        if (r6 == null) goto L75;
        r0.c((String) r6.component1(), (LarkOAuthSessionCoordinator$c) r6.component2());
    L75:
        if (r4 == null) goto L77;
        r0.e(r4);
    L77:
        r2 = true;
        goto L79
    L24:
        if (Intrinsics.areEqual(r5, "invalid_grant") == true) goto L69;
        if (r5 != null) goto L28;
    L31:
        boolean r7 = true;
    L32:
        if (r7 == true) goto L34;
        r12 = TuplesKt.to(r4.a.a, new LarkOAuthSessionCoordinator$c.c("enterprise_oauth_failed", null, null, null));     // Catch: Throwable -> L80
        goto L70
    L34:
        String r14 = r11.getQueryParameter("code");     // Catch: Throwable -> L80
        if (r14 != null) goto L37;
    L40:
        boolean r8 = true;
    L41:
        if (r8 == false) goto L43;
        r12 = TuplesKt.to(r4.a.a, new LarkOAuthSessionCoordinator$c.c("enterprise_oauth_failed", null, null, null));     // Catch: Throwable -> L80
        goto L70
    L43:
        r4.g = r14;     // Catch: Throwable -> L80
        long r9 = r0.h + 1;     // Catch: Throwable -> L80
        r0.h = r9;     // Catch: Throwable -> L80
        r4.h = Long.valueOf(r9);     // Catch: Throwable -> L80
        if (r4.b != LarkOAuthSessionCoordinator$Kind.SUPPLEMENT) goto L66;
        Collection r15 = r0.g.values();     // Catch: Throwable -> L80
        if ((r15 instanceof Collection) == true) goto L48;
    L50:
        Iterator r16 = r15.iterator();     // Catch: Throwable -> L80
    L52:
        if (r16.hasNext() == false) goto L63;
        LarkOAuthSessionCoordinator$a r10 = (LarkOAuthSessionCoordinator$a) r16.next();     // Catch: Throwable -> L80
        if (r10 != r4) goto L56;
    L60:
        boolean r17 = false;
    L61:
        if (r17 == false) goto L52;
        boolean r18 = true;
    L64:
        if (r18 == false) goto L66;
        r2 = true;
        goto L66
    L56:
        if (Intrinsics.areEqual(r10.c, r4.c) == false) goto L60;
        if (r10.f != LarkOAuthSessionCoordinator$Phase.EXCHANGING) goto L60;
        r17 = true;
    L63:
        r18 = false;
        goto L64
    L48:
        if (r15.isEmpty() == false) goto L50;
    L66:
        if (r2 == false) goto L68;
        LarkOAuthSessionCoordinator$Phase r110 = LarkOAuthSessionCoordinator$Phase.WAITING;     // Catch: Throwable -> L80
        Intrinsics.checkNotNullParameter(r110, "<set-?>");     // Catch: Throwable -> L80
        r4.f = r110;     // Catch: Throwable -> L80
        r4 = null;
        goto L71
    L68:
        LarkOAuthSessionCoordinator$Phase r111 = LarkOAuthSessionCoordinator$Phase.EXCHANGING;     // Catch: Throwable -> L80
        Intrinsics.checkNotNullParameter(r111, "<set-?>");     // Catch: Throwable -> L80
        r4.f = r111;     // Catch: Throwable -> L80
        goto L71
    L37:
        if (r14.length() == 0) goto L40;
        r8 = false;
        goto L41
    L28:
        if (r5.length() == 0) goto L31;
        r7 = false;
    L80:
        th = move-exception;
        throw th;
    L79:
        return Boolean.valueOf(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Uri) r1);
    }
}
