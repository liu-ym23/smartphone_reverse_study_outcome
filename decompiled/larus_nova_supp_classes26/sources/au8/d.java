package au8;

import android.content.Context;
import com.larus.bootprotector.BootProtectorLauncher;
import com.larus.bootprotector.entity.BaseExceptionInfo;
import com.larus.bootprotector.entity.LastException;
import com.larus.utils.f;
import hu8.e;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class d implements Runnable {
    public final /* synthetic */ BootProtectorLauncher a;
    public final /* synthetic */ Context b;

    public /* synthetic */ d(BootProtectorLauncher r1, Context r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        BootProtectorLauncher r0 = this.a;
        Context r1 = this.b;
        boolean r2 = BootProtectorLauncher.b;
    L40:
        th = move-exception;
        nu8.a.c("BootProtectorLauncher", "checkBootProtectorEffect dispatchBootProtectorEffectCheck error", th);
        return;
    L4:
        Object r10 = "";
        if (hu8.a.a("enter_bootprotector_page", 0) != 1) goto L24;
        int r3 = hu8.a.a("bootprotector_click_opt", 0);     // Catch: Throwable -> L40
        int r12 = hu8.a.a("bootprotector_click_download", 0);     // Catch: Throwable -> L40
        if (r3 != 1) goto L9;
        String r4 = "opt";
    L12:
        LastException r13 = e.h();     // Catch: Throwable -> L40
        if (r13 == null) goto L16;
        String r14 = r13.getExceptionStackTrace();     // Catch: Throwable -> L40
        if (r14 == null) goto L16;
    L17:
        LastException r15 = e.h();     // Catch: Throwable -> L40
        if (r15 == null) goto L23;
        BaseExceptionInfo.Type r16 = r15.getCrashType();     // Catch: Throwable -> L40
        if (r16 == null) goto L23;
        r10 = r16;
    L23:
        int r17 = b.a;     // Catch: Throwable -> L40
        b.a("bootprotector_fix_success", f.c(new Pair[]{TuplesKt.to("click", r4), TuplesKt.to("crash_type", r10), TuplesKt.to("crash_stack", StringsKt.take(r14, 4000))}));     // Catch: Throwable -> L40
        nu8.a.h("BootProtectorLauncher", "checkBootProtectorEffect， boot protector FIX SUCCESS LAST TIME ！！！！");     // Catch: Throwable -> L40
    L38:
        nu8.a.e("BootProtectorLauncher", "checkBootProtectorEffect， app launch success");     // Catch: Throwable -> L40
        r0.getClass();     // Catch: Throwable -> L40
        nu8.a.h("BootProtectorRepo", "bootProtectorKV clear!");     // Catch: Throwable -> L40
        hu8.a.a.clear();     // Catch: Throwable -> L40
        e.j(r1);     // Catch: Throwable -> L40
        gu8.b.a.getClass();     // Catch: Throwable -> L40
        gu8.b.d();     // Catch: Throwable -> L40
        return;
    L16:
        r14 = "";
        goto L17
    L9:
        if (r12 != 1) goto L11;
        r4 = "download";
        goto L12
    L11:
        r4 = "unknown";
        goto L12
    L24:
        int r5 = e.g();     // Catch: Throwable -> L40
        if (r5 <= 0) goto L38;
        LastException r18 = e.h();     // Catch: Throwable -> L40
        if (r18 == null) goto L30;
        String r19 = r18.getExceptionStackTrace();     // Catch: Throwable -> L40
        if (r19 == null) goto L30;
    L31:
        LastException r110 = e.h();     // Catch: Throwable -> L40
        if (r110 == null) goto L37;
        BaseExceptionInfo.Type r111 = r110.getCrashType();     // Catch: Throwable -> L40
        if (r111 == null) goto L37;
        r10 = r111;
    L37:
        int r112 = b.a;     // Catch: Throwable -> L40
        b.a("bootprotector_launch_success_without_fix", f.c(new Pair[]{TuplesKt.to("crash_type", r10), TuplesKt.to("crash_count", Integer.valueOf(r5)), TuplesKt.to("crash_stack", StringsKt.take(r19, 4000))}));     // Catch: Throwable -> L40
        nu8.a.h("BootProtectorLauncher", "checkBootProtectorEffect， boot protector LAUNCH SUCCESS without FIX ！！！！");     // Catch: Throwable -> L40
    L30:
        r19 = "";
        goto L31
    }
}
