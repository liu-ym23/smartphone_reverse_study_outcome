package com.ss.android.lark.integrator.security.compliance.export;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import java.io.File;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/ss/android/lark/integrator/security/compliance/export/SecurityFileCryptoService$OperationResult;", "Ljava/io/OutputStream;", "invoke"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
final class SecurityFileCryptoService$openEncryptOutputStream$1 extends Lambda implements Function0<SecurityFileCryptoService.c<OutputStream>> {
    final /* synthetic */ File $file;
    final /* synthetic */ boolean $truncate;
    final /* synthetic */ SecurityFileCryptoService this$0;

    public SecurityFileCryptoService$openEncryptOutputStream$1(SecurityFileCryptoService r1, File r2, boolean r3) {
        this.this$0 = r1;
        this.$file = r2;
        this.$truncate = r3;
        super(0);
    }

    public final SecurityFileCryptoService.c<OutputStream> invoke() {
        return new SecurityFileCryptoService.c(this.this$0.b.p3(this.$file, this.$truncate), true, null, null);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m945invoke() {
        return invoke();
    }
}
