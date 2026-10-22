package au8;

import com.larus.bootprotector.BootProtectorLauncher;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class c implements Thread.UncaughtExceptionHandler {
    public final /* synthetic */ BootProtectorLauncher a;

    public /* synthetic */ c(BootProtectorLauncher r1) {
        this.a = r1;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread r3, Throwable r4) {
        BootProtectorLauncher r5 = this.a;
        boolean r0 = BootProtectorLauncher.b;
        Intrinsics.checkNotNull(r4);
        nu8.a.f("BootProtectorLauncher", r4, "failed:");
        r5.getClass();
        BootProtectorLauncher.m();
    }
}
