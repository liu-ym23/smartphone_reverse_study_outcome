package e8;

import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.annie.lynx.e;
import com.bytedance.android.annie.ng.g;
import com.bytedance.android.annie.ng.j;
import com.bytedance.android.annie.service.latch.ILatchService;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.Npth;
import com.bytedance.services.apm.api.EnsureManager;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b implements j {
    public final /* synthetic */ Function1<d8.b, Unit> a;

    @Override // com.bytedance.android.annie.ng.j
    public final void onCallback() {
        Function1<d8.b, Unit> r0 = this.a;
        d8.b r1 = c.a;
        r0.invoke(r1);
        d.a.put("host", r1);
        d8.b r10 = e.a;
        Intrinsics.checkNotNullParameter(r1, "lynxConfig");
        if (e.b == true) goto L17;
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        e.a = r1;
        com.bytedance.android.annie.card.e r11 = g.e;
        IHybridComponent.HybridType r12 = IHybridComponent.HybridType.LYNX;
        com.bytedance.android.annie.lynx.b r13 = com.bytedance.android.annie.lynx.b.a;
        if (((HashMap) r11.a).containsKey(r12) == true) goto L9;
        ((HashMap) r11.a).put(r12, r13);
    L9:
        com.bytedance.android.annie.lynx.service.latch.g r14 = new com.bytedance.android.annie.lynx.service.latch.g(0);
        Annie.registerService$default(ILatchService.class, r14, null, 4, null);
        Annie.registerService$default(com.bytedance.android.annie.lynx.service.latch.a.class, r14, null, 4, null);
        Annie.registerService$default(r9.c.class, new com.bytedance.android.annie.lynx.c(), null, 4, null);
        Npth.addAttachUserData(com.bytedance.android.annie.lynx.d.a, CrashType.ALL);     // Catch: Throwable -> L12
    L13:
        e.b = true;
        return;
    L12:
        EnsureManager.ensureNotReachHere("Npth addAttachUserData exception");
        goto L13
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(Function1<? super d8.b, Unit> r1) {
        this.a = r1;
    }
}
