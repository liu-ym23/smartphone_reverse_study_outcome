package com.bytedance.pia.core.bridge.methods;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.pia.core.api.bridge.PiaMethod$Scope;
import com.lynx.jsbridge.LynxResourceModule;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class l implements ah.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ah.b f6998a = null;

    static {
        f6998a = new ah.b("pia.internal.cache.getHeaders", PiaMethod$Scope.f6954c, e.f6974c);
    }

    @Override // ah.a
    public final void a(gh.c r5, Object r10, gh.b r11, n0 r12) {
        j r13 = (j) r10;
        Intrinsics.checkNotNullParameter(r5, "bridge");
        Intrinsics.checkNotNullParameter(r13, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r11, "resolve");
        Intrinsics.checkNotNullParameter(r12, "reject");
        if (TextUtils.isEmpty(r13.b()) == false) goto L27;
        td.b.c("Parameter 'url' required!", r12);
        return;
    L27:
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L8
        Object r15 = Result.m124constructorimpl(com.bytedance.pia.core.utils.j.b(Uri.parse(r13.b())));     // Catch: Throwable -> L8
    L11:
        if (Result.m127exceptionOrNullimpl(r15) != null) goto L25;
        Uri r16 = (Uri) r15;
        String r17 = com.bytedance.pia.core.utils.j.k(r16, null);
        if (r17 != null) goto L15;
    L24:
        td.b.c("Parameter 'url' invalid!", r12);
        return;
    L15:
        if (r17.length() == 0) goto L24;
        String r18 = com.bytedance.pia.core.utils.j.k(r16, r13.a());
        if (r18 != null) goto L20;
    L23:
        td.b.c("Parameter 'url' & 'extraVary' invalid!", r12);
        return;
    L20:
        if (r18.length() == 0) goto L23;
        com.bytedance.pia.core.utils.m.b(new h(r11, r18, r12, 1));
        return;
    L25:
        td.b.c("Parameter 'url' invalid!", r12);
        return;
    L8:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r15 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L11
    }
}
