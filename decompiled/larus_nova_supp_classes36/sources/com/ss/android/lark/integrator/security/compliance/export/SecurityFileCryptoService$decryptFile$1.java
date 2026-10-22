package com.ss.android.lark.integrator.security.compliance.export;

import android.util.Pair;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import java.io.File;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/ss/android/lark/integrator/security/compliance/export/SecurityFileCryptoService$OperationResult;", "", "invoke"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
final class SecurityFileCryptoService$decryptFile$1 extends Lambda implements Function0<SecurityFileCryptoService.c<String>> {
    final /* synthetic */ File $file;
    final /* synthetic */ SecurityFileCryptoService this$0;

    public SecurityFileCryptoService$decryptFile$1(SecurityFileCryptoService r1, File r2) {
        this.this$0 = r1;
        this.$file = r2;
        super(0);
    }

    public final SecurityFileCryptoService.c<String> invoke() {
        SecurityFileCryptoService r0 = this.this$0;
        File r1 = this.$file;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L5
        Object r3 = Result.constructor-impl(r0.b.m3(r1));     // Catch: Throwable -> L5
    L7:
        Throwable r4 = Result.exceptionOrNull-impl(r3);
        if (r4 == null) goto L11;
        Log.e("SecurityFileCryptoService", "[decryptFile] failed, error=".concat(r4.getClass().getSimpleName()));
    L11:
        if (Result.isFailure-impl(r3) == false) goto L13;
        r3 = null;
    L13:
        Pair r5 = (Pair) r3;
        boolean r6 = false;
        if (r5 == null) goto L16;
        SecurityFileCryptoService.b r7 = SecurityFileCryptoService.b(this.this$0, r5, "decryptFile");
        String r8 = r7.a;
        if (r8 == null) goto L21;
        r6 = true;
    L21:
        return new SecurityFileCryptoService.c(r8, r6, r7.b, r7.c);
    L16:
        return new SecurityFileCryptoService.c(null, false, null, null);
    L5:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m941invoke() {
        return invoke();
    }
}
