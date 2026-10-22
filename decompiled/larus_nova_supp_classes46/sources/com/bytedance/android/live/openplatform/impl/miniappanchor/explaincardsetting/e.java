package com.bytedance.android.live.openplatform.impl.miniappanchor.explaincardsetting;

import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.base.perf.OpenPlatformPerformanceReportService;
import com.bytedance.android.live.openplatform.impl.base.perf.PerformanceScene;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e implements Runnable {
    public final /* synthetic */ ExplainCardSettingDialog a;

    public e(ExplainCardSettingDialog r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        so0.a r0 = this.a.h;     // Catch: Throwable -> L11
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("miniAppAnchorService");     // Catch: Throwable -> L11
    L5:
        OpenPlatformContext r1 = r0.a();     // Catch: Throwable -> L11
        if (r1 == null) goto L14;
        OpenPlatformPerformanceReportService r2 = (OpenPlatformPerformanceReportService) r1.getService(OpenPlatformPerformanceReportService.class);     // Catch: Throwable -> L11
        if (r2 == null) goto L18;
        HashMap<String, zo0.f> r3 = zo0.g.a;     // Catch: Throwable -> L11
        zo0.f r4 = zo0.h.b(PerformanceScene.EXPLAIN_CARD_SETTING_DIALOG);     // Catch: Throwable -> L11
        r4.b();     // Catch: Throwable -> L11
        zo0.f.a(r4, new zo0.c(r2));     // Catch: Throwable -> L11
        return;
    L18:
        return;
    L14:
        return;
    L11:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L19;
        throw th;
    }
}
