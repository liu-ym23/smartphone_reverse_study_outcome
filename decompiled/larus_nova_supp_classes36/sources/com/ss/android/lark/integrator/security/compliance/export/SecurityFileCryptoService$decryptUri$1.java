package com.ss.android.lark.integrator.security.compliance.export;

import android.content.Context;
import android.net.Uri;
import android.util.Pair;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/ss/android/lark/integrator/security/compliance/export/SecurityFileCryptoService$OperationResult;", "", "invoke"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
final class SecurityFileCryptoService$decryptUri$1 extends Lambda implements Function0<SecurityFileCryptoService.c<String>> {
    final /* synthetic */ Context $context;
    final /* synthetic */ Uri $uri;
    final /* synthetic */ SecurityFileCryptoService this$0;

    public SecurityFileCryptoService$decryptUri$1(SecurityFileCryptoService r1, Context r2, Uri r3) {
        this.this$0 = r1;
        this.$context = r2;
        this.$uri = r3;
        super(0);
    }

    public final SecurityFileCryptoService.c<String> invoke() {
        SecurityFileCryptoService r0 = this.this$0;
        Context r1 = this.$context;
        Uri r2 = this.$uri;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L5
        Object r4 = Result.constructor-impl(r0.b.Gd(r1, r2));     // Catch: Throwable -> L5
    L7:
        Throwable r5 = Result.exceptionOrNull-impl(r4);
        if (r5 == null) goto L11;
        Log.e("SecurityFileCryptoService", "[decryptUri] failed, error=".concat(r5.getClass().getSimpleName()));
    L11:
        if (Result.isFailure-impl(r4) == false) goto L13;
        r4 = null;
    L13:
        Pair r6 = (Pair) r4;
        boolean r7 = false;
        if (r6 == null) goto L16;
        SecurityFileCryptoService.b r8 = SecurityFileCryptoService.b(this.this$0, r6, "decryptUri");
        String r9 = r8.a;
        if (r9 == null) goto L21;
        r7 = true;
    L21:
        return new SecurityFileCryptoService.c(r9, r7, r8.b, r8.c);
    L16:
        return new SecurityFileCryptoService.c(null, false, null, null);
    L5:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m942invoke() {
        return invoke();
    }
}
