package com.ss.android.lark.integrator.security.compliance.export;

import android.util.Pair;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/ss/android/lark/integrator/security/compliance/export/SecurityFileCryptoService$OperationResult;", "", "invoke"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
final class SecurityFileCryptoService$writeBackEncrypted$1 extends Lambda implements Function0<SecurityFileCryptoService.c<String>> {
    final /* synthetic */ String $decryptedPath;
    final /* synthetic */ SecurityFileCryptoService this$0;

    public SecurityFileCryptoService$writeBackEncrypted$1(SecurityFileCryptoService r1, String r2) {
        this.this$0 = r1;
        this.$decryptedPath = r2;
        super(0);
    }

    public final SecurityFileCryptoService.c<String> invoke() {
        SecurityFileCryptoService r0 = this.this$0;
        String r1 = this.$decryptedPath;
        int r2 = SecurityFileCryptoService.e;
        r0.getClass();
        boolean r3 = SecurityFileCryptoService.c(r1);
        boolean r4 = false;
        String r5 = null;
        if (r3 == true) goto L7;
        Log.e("SecurityFileCryptoService", "[writeBackEncrypted] invalid input path");
        return new SecurityFileCryptoService.c(null, false, null, null);
    L7:
        if (new PolarisFileWrapper(this.$decryptedPath).isFile() == true) goto L10;
        Log.e("SecurityFileCryptoService", "[writeBackEncrypted] input is not a regular file");
        return new SecurityFileCryptoService.c(null, false, null, null);
    L10:
        SecurityFileCryptoService r6 = this.this$0;
        String r7 = this.$decryptedPath;
        Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L13
        Object r9 = Result.constructor-impl(r6.b.Ec(r7));     // Catch: Throwable -> L13
    L15:
        Throwable r10 = Result.exceptionOrNull-impl(r9);
        if (r10 == null) goto L19;
        Log.e("SecurityFileCryptoService", "[writeBackEncrypted] failed, error=".concat(r10.getClass().getSimpleName()));
    L19:
        if (Result.isFailure-impl(r9) == false) goto L21;
        r9 = null;
    L21:
        Pair r11 = (Pair) r9;
        if (r11 == null) goto L24;
        SecurityFileCryptoService.b r12 = SecurityFileCryptoService.b(this.this$0, r11, "writeBackEncrypted");
        String r13 = r12.a;
        if (r13 == null) goto L31;
        if (SecurityFileCryptoService.a(this.this$0, r13, "writeBackEncrypted") == false) goto L31;
        r5 = r13;
    L31:
        if (r5 == null) goto L34;
        r4 = true;
    L34:
        return new SecurityFileCryptoService.c(r5, r4, r12.b, r12.c);
    L24:
        return new SecurityFileCryptoService.c(null, false, null, null);
    L13:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L15
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m946invoke() {
        return invoke();
    }
}
