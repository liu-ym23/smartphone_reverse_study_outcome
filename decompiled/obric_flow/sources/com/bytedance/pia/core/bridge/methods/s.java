package com.bytedance.pia.core.bridge.methods;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.pia.core.api.bridge.PiaMethod$Error;
import com.bytedance.pia.core.api.bridge.PiaMethod$Scope;
import com.google.gson.JsonObject;
import com.lynx.jsbridge.LynxResourceModule;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class s implements ah.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ah.b f7021a = null;

    static {
        f7021a = new ah.b("pia.internal.cache.save", PiaMethod$Scope.f6954c, e.e);
    }

    @Override // ah.a
    public final void a(gh.c r10, Object r11, gh.b r12, n0 r13) {
        p r14 = (p) r11;
        Intrinsics.checkNotNullParameter(r10, "bridge");
        Intrinsics.checkNotNullParameter(r14, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r12, "resolve");
        Intrinsics.checkNotNullParameter(r13, "reject");
        if (TextUtils.isEmpty(r14.c()) == false) goto L47;
        td.b.c("Parameter 'url' invalid!", r13);
        return;
    L47:
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L8
        Object r16 = Result.m124constructorimpl(com.bytedance.pia.core.utils.j.b(Uri.parse(r14.c())));     // Catch: Throwable -> L8
    L11:
        if (Result.m127exceptionOrNullimpl(r16) != null) goto L45;
        Uri r5 = (Uri) r16;
        String r17 = com.bytedance.pia.core.utils.j.k(r5, null);
        if (r17 != null) goto L15;
    L44:
        td.b.c("Parameter 'url' invalid!", r13);
        return;
    L15:
        if (r17.length() == 0) goto L44;
        List r18 = r14.b();
        String r19 = com.bytedance.pia.core.utils.j.k(r5, r18);
        if (r19 != null) goto L20;
    L43:
        td.b.c("Parameter 'url' & 'extraVary' invalid!", r13);
        return;
    L20:
        if (r19.length() == 0) goto L43;
        if (Intrinsics.areEqual(r17, r19) == false) goto L25;
        r13.accept(new PiaMethod$Error(-10001, "Can't modify the original html."));
        return;
    L25:
        String r20 = r14.a();
        if (r20 != null) goto L28;
    L42:
        td.b.c("Parameter 'content' invalid!", r13);
        return;
    L28:
        if (r20.length() == 0) goto L42;
        String r21 = r14.a();
        JsonObject r22 = com.bytedance.pia.core.utils.j.t(r21);
        if (r22 != null) goto L33;
        r13.accept(new PiaMethod$Error(-10002, "Invalid manifest in content."));
        return;
    L33:
        jh.a r23 = jh.c.c(r22);
        if (r23 != null) goto L36;
    L41:
        r13.accept(new PiaMethod$Error(-10003, "Invalid cache in manifest."));
        return;
    L36:
        if (r23.e() != null) goto L38;
    L40:
        com.bytedance.pia.core.utils.m.b(new r(r5, r21, r22, r18, r12, r13));
        return;
    L38:
        if (r23.e().longValue() > 0) goto L40;
    L45:
        td.b.c("Parameter 'url' invalid!", r13);
        return;
    L8:
        th = move-exception;
        Result.Companion r24 = Result.Companion;
        r16 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L11
    }
}
