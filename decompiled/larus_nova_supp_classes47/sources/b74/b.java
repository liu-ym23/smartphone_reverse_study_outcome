package b74;

import com.bytedance.badger.C.a;
import com.bytedance.badger.e;
import com.bytedance.badger.network.a0;
import com.bytedance.badger.network.b0;
import com.bytedance.badger.network.l0;
import kotlin.Unit;
import kotlin.jvm.functions.Function6;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b implements Function6 {
    public final /* synthetic */ c a;

    public b(c r1) {
        this.a = r1;
    }

    public final Object invoke(Object r3, Object r4, Object r5, Object r6, Object r7, Object r8) {
        ((Boolean) r3).booleanValue();
        String r9 = (String) r4;
        a0 r10 = (a0) r5;
        b0 r12 = (b0) r6;
        l0 r13 = (l0) r7;
        a r14 = (a) r8;
        Object r15 = e.d;
        monitor-enter(r15);
        this.a.a.b = false;     // Catch: Throwable -> L15
        if (e.a(r12) != 0) goto L11;
        this.a.a.a = true;     // Catch: Throwable -> L15
        e.f("CompensationManager", "onCompensate# success!, cause=" + this.a.a.f);     // Catch: Throwable -> L15
    L12:
        monitor-exit(r15);
        return Unit.INSTANCE;
    L11:
        e.g("CompensationManager", "onCompensate# failed, will retry on next eligible event: cause=" + this.a.a.f);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }
}
