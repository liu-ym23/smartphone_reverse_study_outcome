package com.larus.bootprotector.hotfix;

import android.app.Application;
import com.bytedance.reparo.g;
import com.larus.applog.api.IApplog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016¨\u0006\n"}, d2 = {"Lcom/larus/bootprotector/hotfix/BootProtectorHotPatchImpl;", "Lcom/larus/bootprotector/hotfix/IBootProtectorHotPatch;", "<init>", "()V", "initHotFix", "", "application", "Landroid/app/Application;", "requestHotPatch", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BootProtectorHotPatchImpl implements IBootProtectorHotPatch {

    public static final class a {
    }

    static {
    }

    public BootProtectorHotPatchImpl() {
    }

    @Override // com.larus.bootprotector.hotfix.IBootProtectorHotPatch
    public final void a() {
        nu8.a.e("BootProtectorHotPatch", "applyForPatch...");
        g.a().f();
    }

    @Override // com.larus.bootprotector.hotfix.IBootProtectorHotPatch
    public final void b(Application r5) {
        Intrinsics.checkNotNullParameter(r5, "application");
        nu8.a.e("BootProtectorHotPatch", "initHotFix");
        g.a().getClass();
        g.k = 0;
        g.a().b(new fu8.a(r5));
        nu8.a.e("BootProtectorHotPatch", "deviceId: ".concat(IApplog.a.getDeviceId()));
    }
}
