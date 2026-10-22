package m5;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final /* synthetic */ class q0 implements Function0 {
    public final /* synthetic */ String a;
    public final /* synthetic */ long b;

    public /* synthetic */ q0(String r1, long r10) {
        this.a = r1;
        this.b = r10;
    }

    public final Object invoke() {
        String r0 = this.a;
        long r1 = this.b;
        com.bytedance.ai.utils.g r10 = com.bytedance.ai.utils.g.a;
        r10.d("AppletEventMonitorManager", "onUserInput: " + r0);
        i1 r11 = y0.a;
        r11.getClass();
        Intrinsics.checkNotNullParameter(r0, "traceId");
        r10.d(r11.h, "onUserInput: " + r0 + ", " + r1);
        d1.c(r11.g, r0).d("user_input", Long.valueOf(r1));
        return Unit.INSTANCE;
    }
}
